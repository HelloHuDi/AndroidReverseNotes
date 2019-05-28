"""
Sample client script for PNF Software' JEB2.

Find code units in a project and attempt to decompile all classes of such units.

Refer to SCRIPTS.TXT for more information.
"""

import os

from com.pnfsoftware.jeb.core.util import DecompilerHelper
from com.pnfsoftware.jeb.client.api import IScript, IconType, ButtonGroupType
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units.code import ICodeUnit, ICodeItem
from com.pnfsoftware.jeb.core.output.text import ITextDocument


class JEB2DecompileAll(IScript):

  def run(self, ctx):
    self.ctx = ctx

    # customize this
    self.outputDir = ctx.getBaseDirectory()

    engctx = ctx.getEnginesContext()
    if not engctx:
      print('Back-end engines not initialized')
      return

    projects = engctx.getProjects()
    if not projects:
      print('There is no opened project')
      return

    prj = projects[0]
    print('Decompiling code units of %s...' % prj)

    codeUnits = RuntimeProjectUtil.findUnitsByType(prj, ICodeUnit, False)
    for codeUnit in codeUnits:
      self.decompileForCodeUnit(codeUnit)

    print('Done.')


  def decompileForCodeUnit(self, codeUnit):
    decomp = DecompilerHelper.getDecompiler(codeUnit)
    if not decomp:
      print('There is no decompiler available for code unit %s' % codeUnit)
      return

    outdir = os.path.join(self.outputDir, codeUnit.getName() + '_decompiled')
    print('Output folder: %s' % os.getcwd())

    allClasses = codeUnit.getClasses()
    for c in allClasses:
      # do not decompile inner classes
      if (c.getGenericFlags() & ICodeItem.FLAG_INNER) == 0:
        a = c.getAddress()
        srcUnit = decomp.decompile(a)
        if srcUnit:
          self.exportSourceUnit(srcUnit, outdir)


  def exportSourceUnit(self, srcUnit, outdir):
    ext = srcUnit.getFileExtension()

    if ext == 'java':
      csig = srcUnit.getFullyQualifiedName()
      subpath = csig[1:len(csig)-1] + '.java'
      dirname = subpath[:subpath.rfind('/') + 1]

      dirpath = os.path.join(outdir, dirname)
      if not os.path.exists(dirpath):
        os.makedirs(dirpath)

      doc = self.getTextDocument(srcUnit)
      if not doc:
        print('The source text document was not found')
        return False

      text = self.formatTextDocument(doc)

      filepath = os.path.join(outdir, subpath)
      f = open(filepath, 'w')
      f.write('// Decompiled by JEB v%s\n\n' % self.ctx.getSoftwareVersion())
      f.write(text.encode('utf-8'))
      f.close()

    else:
      print('Does not know how to export source types: %s' % ext)
      return False

    
  def getTextDocument(self, srcUnit):
    formatter = srcUnit.getFormatter()
    if formatter and formatter.getDocumentPresentations():
      doc = formatter.getDocumentPresentations()[0].getDocument()
      if isinstance(doc, ITextDocument):
        return doc
    return None
  

  def formatTextDocument(self, doc):
    s = ''
    # retrieve the entire document -it's a source file,
    # no need to buffer individual parts. 10 MLoC is enough 
    alldoc = doc.getDocumentPart(0, 10000000)
    for line in alldoc.getLines():
      s += line.getText().toString() + '\n'
    return s
