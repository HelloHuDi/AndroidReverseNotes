"""
Sample client script for PNF Software' JEB2.

Demo of the DEX manipulation methods exposed in the specialized IDexUnit interface.

Refer to SCRIPTS.TXT for more information.
"""

import os

from com.pnfsoftware.jeb.client.api import IScript, IconType, ButtonGroupType
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.events import JebEvent, J
from com.pnfsoftware.jeb.core.units.code import ICodeUnit, ICodeItem
from com.pnfsoftware.jeb.core.units.code.android import IDexUnit
from com.pnfsoftware.jeb.core.units.code.android.dex import IDexString


class JEB2DexManipulation(IScript):

  def run(self, ctx):
    self.ctx = ctx

    # customize this
    self.outputDir = ctx.getBaseDirectory()

    engctx = ctx.getEnginesContext()
    if not engctx:
      print('Back-end engines not initialized')
      return

    prj = engctx.getProject(0)
    if not prj:
      print('There is no opened project')
      return

    codeUnits = RuntimeProjectUtil.findUnitsByType(prj, IDexUnit, False)
    for codeUnit in codeUnits:
      self.processDex(codeUnit)


  def processDex(self, dex):
    print(dex)

    # replace DEX strings
    cnt = 0
    for s in dex.getStrings():
      if s.getValue().startswith('text/html'):
        s.setValue('foobar')
        cnt += 1
        print('String replaced')
    if cnt > 0:
      dex.notifyListeners(JebEvent(J.UnitChange))
