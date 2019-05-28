"""
Sample client script for PNF Software' JEB2.
Requires: JEB 2.1.3

This script shows how to "tag" elements of an AST tree, and later on retrieve
those tags from the Java text document output (referred to as "marks").

This code looks for Java units, and tags String contants containing the word
'html'. Output example:

  ...
  <Java code >
  ...
  => Marks:
  17:59 - htmlTag (Potential HTML code found)

Tags are persisted in JDB2 database files.

Note: tags are specific to Java units. However, marks are not (they are
specific to text documents). The Java plugin simply renders tags as text
marks. This example demonstrates usage of tags in that context.

As of JEB 2.1.3, marks are not displayed by the official desktop RCP client.
It is up to third-party code (clients, plugins, or scripts) to display them.

Refer to SCRIPTS.TXT for more information.
"""

from com.pnfsoftware.jeb.client.api import IScript, IconType, ButtonGroupType
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units.code.java import IJavaSourceUnit
from com.pnfsoftware.jeb.core.units.code import ICodeUnit, ICodeItem
from com.pnfsoftware.jeb.core.output.text import ITextDocument
from com.pnfsoftware.jeb.core.units.code.java import IJavaConstant


class JEB2JavaASTTags(IScript):

  def run(self, ctx):
    self.ctx = ctx

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

    units = RuntimeProjectUtil.findUnitsByType(prj, IJavaSourceUnit, False)
    for unit in units:
      self.processSourceTree(unit.getClassElement())

      doc = self.getTextDocument(unit)
      javaCode, formattedMarks = self.formatTextDocument(doc)
      print(javaCode)

      if(formattedMarks):
        print('=> Marks:')
        print(formattedMarks)

    print('Done.')


  def processSourceTree(self, e):
    if e:
      self.analyzeNode(e)
      elts = e.getSubElements()
      for e in elts:
        self.processSourceTree(e)

  # demo
  def analyzeNode(self, e):
    if isinstance(e, IJavaConstant):
      if e.isString():
        if e.getString().find('html') >= 0:
          e.getTagMap().put('htmlTag', 'Potential HTML code found')

  def getTextDocument(self, srcUnit):
    formatter = srcUnit.getFormatter()
    if formatter and formatter.getDocumentPresentations():
      doc = formatter.getDocumentPresentations()[0].getDocument()
      if isinstance(doc, ITextDocument):
        return doc
    return None

  def formatTextDocument(self, doc):
    javaCode, formattedMarks = '', ''
    # retrieve the entire document -it's a source file,
    # no need to buffer individual parts. 10 MLoC is enough 
    alldoc = doc.getDocumentPart(0, 10000000)
    for lineIndex, line in enumerate(alldoc.getLines()):
      javaCode += line.getText().toString() + '\n'
      for mark in line.getMarks():
        # 0-based line and column indexes
        formattedMarks += '%d:%d - %s (%s)\n' % (lineIndex, mark.getOffset(), mark.getName(), mark.getObject())
    return javaCode, formattedMarks
