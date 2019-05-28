"""
Sample client script for PNF Software' JEB2.
Requires: JEB 2.1

This script demos how to use the Java AST API.

Refer to SCRIPTS.TXT for more information.
"""

import os

from com.pnfsoftware.jeb.client.api import IScript, IconType, ButtonGroupType
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units.code.java import IJavaSourceUnit
from com.pnfsoftware.jeb.core.units.code import ICodeUnit, ICodeItem
from com.pnfsoftware.jeb.core.output.text import ITextDocument


class JEB2JavaASTDemo(IScript):

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
      #self.decompileForCodeUnit(codeUnit)
      #print(unit.getJavaClass())
      self.displayTree(unit.getClassElement())

    print('Done.')


  def displayTree(self, e, level=0):
    print('%s%s' % (level*'  ', e))
    if e:
      elts = e.getSubElements()
      for e in elts:
        self.displayTree(e, level+1)
