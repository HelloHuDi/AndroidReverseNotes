"""
Sample UI client script for PNF Software' JEB2.

This script is a JEB2 API port of the original JEB1 script 'ASTDecryptStrings.py'
Its purpose is to decrypt the strings protected by (older versions of) DexGuard-protected
More details can be found here:
https://www.pnfsoftware.com/blog/decompiled-java-code-manipulation-using-jeb-api-part-2-decrypting-strings/

Refer to SCRIPTS.TXT for more information.
"""

from com.pnfsoftware.jeb.client.api import IScript, IGraphicalClientContext
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.actions import Actions, ActionContext, ActionXrefsData
from com.pnfsoftware.jeb.core.events import JebEvent, J
from com.pnfsoftware.jeb.core.output import AbstractUnitRepresentation, UnitRepresentationAdapter
from com.pnfsoftware.jeb.core.units.code import ICodeUnit, ICodeItem
from com.pnfsoftware.jeb.core.units.code.java import IJavaSourceUnit, IJavaStaticField, IJavaNewArray, IJavaConstant, IJavaCall, IJavaField, IJavaMethod, IJavaClass


class JEB2JavaASTDecryptStrings(IScript):

  def run(self, ctx):
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

    self.codeUnit = RuntimeProjectUtil.findUnitsByType(prj, ICodeUnit, False)[0]
    print(self.codeUnit)

    # the encryption keys could be determined by analyzing the decryption method
    self.targetClass = 'MainActivity'
    self.keys = [409, 62, -8]

    # enumerate the decompiled classes, find and process the target class
    units = RuntimeProjectUtil.findUnitsByType(prj, IJavaSourceUnit, False)
    for unit in units:
      javaClass = unit.getClassElement()
      if javaClass.getName().find(self.targetClass) >= 0:
        self.cstbuilder = unit.getFactories().getConstantFactory()
        if self.processClass(javaClass):
          # let client code know about those changes
          unit.notifyListeners(JebEvent(J.UnitChange))
        break


  def processClass(self, javaClass):
    self.mname_decrypt = None    
    self.encbytes = []

    wanted_flags = ICodeItem.FLAG_PRIVATE|ICodeItem.FLAG_STATIC|ICodeItem.FLAG_FINAL
    for javaField in javaClass.getFields():
      fsig = javaField.getSignature()
      if fsig.endswith(':[B'):
        # retrieve the DEX unit field
        f = self.codeUnit.getField(fsig)
        if f and f.getGenericFlags() & wanted_flags == wanted_flags:
          print('Found field: %s' % fsig)
          for address in self.getMethodRefs(self.codeUnit, f.getItemId()):
            if address.find('<clinit>') < 0:
              self.mname_decrypt = address
              break
          # resume processing the AST class item
          for m2 in javaClass.getMethods():
            if m2.getName() == '<clinit>':
              s0 = m2.getBody().get(0)
              if isinstance(s0.getLeft(), IJavaStaticField) and s0.getLeft().getField().getSignature() == f.getSignature(True):
                array = s0.getRight()
                if isinstance(array, IJavaNewArray):
                  for v in array .getInitialValues():
                    self.encbytes.append(v.getByte())
              break
          break

    if len(self.encbytes) == 0:
      print('Encrypted strings byte array not found')
      return False

    print('%d bytes of encrypted data' % len(self.encbytes))

    if not self.mname_decrypt:
      print('Decryption method not found')
      return False

    print('Decryption routine: %s' % self.mname_decrypt)
    
    for javaMethod in javaClass.getMethods():
      print('Decrypting strings in method: %s' % javaMethod.getName())
      self.decryptMethodStrings(javaMethod)

    return True


  def getMethodRefs(self, unit, itemId):
    r = []
    data = ActionXrefsData()
    # careful, with query-type actions, the data is returned after the action prep'
    if unit.prepareExecution(ActionContext(unit, Actions.QUERY_XREFS, itemId, None), data):
      # clean up the DEX address, extrac the method name
      for a in data.getAddresses():
        i = a.find('->') + 2
        j = a.find('(', i)
        r.append(a[i:j])
    return r


  def decryptMethodStrings(self, javaMethod):
    block = javaMethod.getBody()
    i = 0
    while i < block.size():
      stm = block.get(i)
      self.checkElement(block, stm)
      i += 1


  def checkElement(self, parent, e):
    if isinstance(e, IJavaCall):
      mname = e.getMethod().getName()
      if mname == self.mname_decrypt:
        v = []
        for arg in e.getArguments():
          if isinstance(arg, IJavaConstant):
            v.append(arg.getInt())
        if len(v) == 3:
          decrypted_string = self.decrypt(v[0], v[1], v[2])
          parent.replaceSubElement(e, self.cstbuilder.createString(decrypted_string))
          print '  Decrypted string: %s' % repr(decrypted_string)

    for subelt in e.getSubElements():
      if isinstance(subelt, IJavaClass) or isinstance(subelt, IJavaField) or isinstance(subelt, IJavaMethod):
        continue
      self.checkElement(e, subelt)


  def decrypt(self, length, curChar, pos):
    length += self.keys[0]
    curChar += self.keys[1]
    r = ''
    for i in range(length):
      r += chr(curChar & 0xFF)
      if pos >= len(self.encbytes):
        break
      curEncodedChar = self.encbytes[pos]
      pos += 1
      curChar = curChar + curEncodedChar + self.keys[2]
    return r
