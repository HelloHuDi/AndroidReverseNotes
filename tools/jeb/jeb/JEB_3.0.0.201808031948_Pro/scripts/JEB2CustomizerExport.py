"""
Sample export script  for PNF Software' JEB2.

This script exports all the function names, comments and signatures in JSON
or MAP so the user can reimport them later on or use them with another tool.

Refer to SCRIPTS.TXT for more information.
"""

import json
import os

from com.pnfsoftware.jeb.client.api import IScript
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units import INativeCodeUnit
from com.pnfsoftware.jeb.core.units.codeobject import ICodeObjectUnit
from com.pnfsoftware.jeb.core.units.codeobject import CodeObjectUnitUtil

SECTIONS_HEADER = " Start         Length     Name                   Class"
SYMBOLS_HEADER = "Address         Publics by Value"

# Functions to help format addr, lengths for the MAP format.

def pad_addr(addr):
    """
    Pads the address on 16 chars
    """

    addr = hex(addr)[2:].upper()

    return "0"*(16-len(addr)) + addr


def pad_length(length):
    """
    Pads the length on 18 chars ending with an 'H'
    """

    length = hex(length)[2:].upper()

    return "0"*(17-len(length)) + length +"H"


def pad_section_number(section_number):
    """
    Pads the section number on 4 chars
    """

    section_number = hex(section_number)[2:].upper()

    return "0"* (4 - len(section_number)) + section_number


# Util to get the first unit of any type
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


class JEB2CustomizerExport(IScript):
    """
    Script class.
    """

    def export_json(self, ctx):
        """
        Exports the symbols as json with comments and prototypes.
        """

        code_unit = get_unit(ctx, INativeCodeUnit)

        print "Code unit type: {}".format(type(code_unit))

        # Getting all the comments
        analyzer = code_unit.getCodeAnalyzer()

        model = analyzer.getModel()

        comment_manager = model.getCommentManager()

        comments = comment_manager.getComments()
        # Needed for Java -> pythonic types
        comments = dict(comments)

        # Getting all the functions
        methods = code_unit.getMethods()

        function_names = {}
        function_prototypes = {}

        for method in methods:
            addr = method.getAddress()
            if addr:
                addr = addr[:-1]
            function_names[addr] = method.getName(1)
            prototype = method.getPrototype()
            if prototype is not None:
                function_prototypes[addr] = prototype.getSignature(1)


        export = {
            "comments": comments,
            "function_names": function_names,
            "function_prototypes": function_prototypes
            }

        return json.dumps(export)


    def export_map(self, ctx, code_obj_unit, file_format):
        """
        Exports in the MAP file format produced by linkers.
        """

        sections = code_obj_unit.getSections()

        sections_dict = {}

        export = "\n{}\n".format(SECTIONS_HEADER)

        if file_format == "PE":
            start = 2
        elif file_format == "ELF":
            start = 1
        else:
            print "Unknown file format."
            return

        for i in range(start, len(sections)):
            section_name = sections[i].getName()
            sections_dict[section_name] = i
            export += " {}:{} {} {} {}\n".format(
                pad_section_number(i),
                pad_addr(0),
                pad_length(int(sections[i].getSizeInMemory())),
                section_name,
                "CODE"
                )

        code_unit = get_unit(ctx, INativeCodeUnit)

        # Getting all the functions
        methods = code_unit.getMethods()

        function_names = {}

        export += "\n\n  {}\n\n".format(SYMBOLS_HEADER)

        for method in methods:
            addr = method.getAddress()
            if addr:
                addr = addr[:-1]

                # PE MAP exports are offsets
                if file_format == "PE":
                    addr -= (code_unit.getVirtualImageBase() + 0x1000)

                function_names[addr] = method.getName(1)

        i = 1
        util = CodeObjectUnitUtil()
        for addr in function_names.keys():
            name = function_names[addr]
            section = util.findSectionByAddress(code_obj_unit, int(addr, 16))
            section_name = section.getName()
            export += " 0000{}:{}       {}\n".format(
                pad_section_number(sections_dict[section_name]),
                pad_addr(int(addr, 16)),
                name
                )
            i += 1
        return export


    def run(self, ctx):
        """
        Main script function.
        """

        code_obj_unit = get_unit(ctx, ICodeObjectUnit)

        # Determines if we are analyzing a PE or an ELF
        if isinstance(code_obj_unit, IPECOFFUnit):
            file_format = "PE"
        elif isinstance(code_obj_unit, IELFUnit):
            file_format = "ELF"
        else:
            print "Unknown file format."
            return

        export_filename = ctx.displayQuestionBox(
            "Export user customizations",
            "Export file name",
            ""
            )

        export_format = ctx.displayQuestionBox(
            "Export user customizations",
            "Export format (JSON or MAP)",
            "")

        if export_format.upper() == "JSON":
            if export_filename.split(".")[-1] != "json":
                export_filename = export_filename + ".json"
            export = self.export_json(ctx)

        elif export_format.upper() == "MAP":
            if export_filename.split(".")[-1] != "map":
                export_filename = export_filename + ".map"
            export = self.export_map(ctx, code_obj_unit, file_format)

        else:
            print "Invalid export format"
            return

        export_file = open(export_filename, "w")
        export_file.write(export)
        export_file.close()

        print "Export finished."
        print "Exported file at {}".format(os.path.join(os.getcwd(), export_filename))
