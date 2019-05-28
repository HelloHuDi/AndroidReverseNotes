"""
Sample import script  for PNF Software' JEB2.

This script exports all the function names and comments
so the user can reimport them later on or use them with
another tool.

Takes only the filename as input.
The result will be stored in JEB's root folder.

Refer to SCRIPTS.TXT for more information.
"""

import json

from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units import INativeCodeUnit
from com.pnfsoftware.jeb.client.api import IconType, ButtonGroupType, IScript
from com.pnfsoftware.jeb.core.units.codeobject import ICodeObjectUnit, IPECOFFUnit, IELFUnit
from com.pnfsoftware.jeb.core.units.code.asm.decompiler.exceptions import DecompilerException

from java.lang import Runnable


# MAP headers
SECTIONS_HEADER = " Start         Length     Name                   Class"
SYMBOLS_HEADER = "Address         Publics by Value"


def get_unit(ctx, unit_type):
    """
    Retrieves a specific unit
    """
    engctx = ctx.getEnginesContext()
    if not engctx:
        print "Back-end engines not initialized"
        return

    projects = engctx.getProjects()
    if not projects:
        print "There is no opened project"
        return

    # get the first code unit available (code units re interactive units)
    units = RuntimeProjectUtil.findUnitsByType(projects[0], unit_type, False)
    if not units:
        print "No unit available"
        return

    unit = units[0]

    return unit


def skip_header(lines, header, i):
    """
    Iterates through the lines until it finds a specific header
    """

    while True:

        if lines[i].find(header) != -1:
            # header found
            break

        # next line
        i += 1

    # Skip the section header line
    i += 1

    return i

class ImportMap(Runnable):

    def __init__(self, ctx, filename):
        self.ctx = ctx
        self.filename = filename

    def run(self):
        """
        Imports fct names from MAP file
        """

        code_obj_unit = get_unit(ctx, ICodeObjectUnit)
        if isinstance(code_obj_unit, IPECOFFUnit):
            file_format = "PE"
        elif isinstance(code_obj_unit, IELFUnit):
            file_format = "ELF"
        else:
            print "Unknown file format."
            return

        code_unit = get_unit(self.ctx, INativeCodeUnit)

        # Read the MAP file
        import_file = open(self.filename, "r")
        lines = import_file.readlines()

        # Find the sections information
        i = 0
        i = skip_header(lines, SECTIONS_HEADER, i)

        sections_dict = {}

        while True:

            line = lines[i]

            if line == "\r\n" or line == "\n" or line == "":
                break

            # SECTION_NUMBER:START LENGTH NAME CLASS
            line = line.split(" ")
            section_and_start = line[1]
            section_and_start = section_and_start.split(":")
            section_number = int(section_and_start[0], 16)

            # IDA seems to mismatch section numbers with PEs
            if file_format == "PE":
                section_number -= 1

            section_name = line[3]

            sections_dict[0] = ""
            sections_dict[section_number] = section_name

            # next line
            i += 1

        # Go to the symbols section
        i = skip_header(lines, SYMBOLS_HEADER, i)

        # Symbols section has two other empty lines after the section header
        i += 2

        # Function names by adress
        function_names = {}

        # Parse the function names and addresses until an empty line or EOF
        for j in range(i, len(lines)):

            line = lines[j].strip("\r\n")

            if line == "\n" or line == "\r\n" or line == "":
                break

            # SECTION_NUMBER:ADDR FUNCTION_NAME
            line = line.split(" ")
            section_and_addr = line[1]
            section_and_addr = section_and_addr.split(":")
            section_number = int(section_and_addr[0], 16)
            addr = int(section_and_addr[1], 16)

            #if the address is invalid, we skip
            if addr == "null":
                continue

            # IDA's MAP addr are offsets in PEs
            if file_format == "PE":
                # offset + base addr + header size
                addr += code_unit.getVirtualImageBase() + 0x1000

            # Importing only function names in the .text section
            if sections_dict[section_number] == ".text":
                name = line[8].strip(" \n\r")
                function_names[addr] = name

            # next line
            i += 1

        # Import all functions
        for fct_addr in function_names.keys():

            print "Importing " + function_names[fct_addr]

            fct_addr_int = int(fct_addr)
            fct = code_unit.getInternalMethod(fct_addr_int, 1)

            # If the functions doesn't exist in JEB, we skip
            if not fct:
                continue

            new_name = function_names[fct_addr]

            if new_name != fct.getName(1):
                fct.setName(function_names[fct_addr])


class ImportJson(Runnable):

    def __init__(self, ctx, filename):
        self.ctx = ctx
        self.filename = filename

    def run(self):
        """
        Imports from a json file with comments, fct names
        """

        code_unit = get_unit(self.ctx, INativeCodeUnit)

        # Getting all the comments
        analyzer = code_unit.getCodeAnalyzer()

        model = analyzer.getModel()

        comment_manager = model.getCommentManager()

        import_file = open(self.filename, "r")
        import_content = json.loads(import_file.read())

        function_names = import_content["function_names"]

        # Renaming all functions
        for fct_addr in function_names.keys():

            if fct_addr != "null":

                fct_addr_int = int(fct_addr, 16)
                fct = code_unit.getInternalMethod(fct_addr_int, 1)
                new_name = function_names[fct_addr]

                if new_name != fct.getName(1):
                    fct.setName(function_names[fct_addr])

        comments = import_content["comments"]

        # Adding all comments
        for comment_addr in comments.keys():

            if comment_addr != "null":

                comment_addr_int = int(comment_addr)
                comment_manager.setComment(comment_addr_int,
                                           comments[comment_addr])

        # Adding all prototypes
        prototypes = import_content["function_prototypes"]

        for prototype_addr in prototypes.keys():

            if prototype_addr != "null":
                method = code_unit.getInternalMethod(int(prototype_addr, 16), 1)
                prototype = prototypes[prototype_addr]
                print "Prototype : {}, method: {}".format(prototype, method.getName(1))
                try:
                    code_unit.setRoutinePrototype(method, prototype)
                except DecompilerException:
                    print "Couldn't set the prototype {} for {}.".format(prototype, method.getName(1))
                    continue




class JEB2CustomizerImport(IScript):
    """
    Script class.
    """

    def run(self, ctx):
        """
        Method automatically ran when the script is loaded.
        """

        import_filename = ctx.displayQuestionBox(
            "Import user customizations",
            "Import file name",
            "")

        if import_filename.split(".")[-1] == "json":
            r = ctx.executeAsync("Importing...", ImportJson(ctx, import_filename))

        elif import_filename.split(".")[-1] == "map":
            r = ctx.executeAsync("Importing...", ImportMap(ctx, import_filename))

        else:
            print "Unknown file format."
            return

        print "Import finished."
