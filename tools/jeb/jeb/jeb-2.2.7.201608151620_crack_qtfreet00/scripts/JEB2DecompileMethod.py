"""
Sample client script for PNF Software' JEB2.

This code shows how to decompile the class containing a target Dalvik method,
and retrieve the associated decompiled Java AST method element.

Requires JEB 2.2.2.

Refer to SCRIPTS.TXT for more information.
"""

import os

from com.pnfsoftware.jeb.core.util import DecompilerHelper
from com.pnfsoftware.jeb.client.api import IScript, IconType, ButtonGroupType
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units.code import ICodeUnit, ICodeItem
from com.pnfsoftware.jeb.core.output.text import ITextDocument


class JEB2DecompileOne(IScript):

  def run(self, ctx):
    self.ctx = ctx

    engctx = ctx.getEnginesContext()
    if not engctx:
      print('Back-end engines not initialized')
      return

    prj = engctx.getProject(0)
    if not prj:
      print('There is no opened project')
      return

    codeUnits = RuntimeProjectUtil.findUnitsByType(prj, ICodeUnit, False)
    if not codeUnits:
      return

    dex = codeUnits[0]
    # ---- SAMPLE --- Replace this by your own method name
    targetMethod = 'Lcom/pnfsoftware/raasta/AppHelp;->onCreate(Landroid/os/Bundle;)V'

    javaMethod = self.getDecompiledMethod(dex, targetMethod)
    if not javaMethod:
      print('The method was not found or was not decompiled')
      return

    print('Java Method: %s (%s)' % (javaMethod, javaMethod.getName()))


  def getDecompiledMethod(self, dex, msig):
    m = dex.getMethod(msig)
    if not m:
      return None

    c = m.getClassType()
    if not c:
      return None

    decomp = DecompilerHelper.getDecompiler(dex)
    if not decomp:
      return None

    csig = c.getSignature(False)
    javaUnit = decomp.decompile(csig)
    if not javaUnit:
      return None

    msig0 = m.getSignature(False)
    for m in javaUnit.getClassElement().getMethods():
      if m.getSignature() == msig0:
        return m
    return None
