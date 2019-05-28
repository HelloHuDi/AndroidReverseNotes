"""
Sample script that lists all units (as well as their byte sizes) present in the currently opened JEB project .

Refer to SCRIPTS.TXT for more information.
"""

from com.pnfsoftware.jeb.client.api import IScript
from com.pnfsoftware.jeb.core.units import IBinaryUnit

class JEB2ListUnits(IScript):

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
    print('=> Listing units int project "%s":' % prj.getName())
    for art in prj.getLiveArtifacts():
      for unit in art.getUnits():
        self.checkUnit(unit)

  def checkUnit(self, unit, level=0):
    unitsize = -1
    if isinstance(unit, IBinaryUnit):
      unitinput = unit.getInput()
      # use the input
      # ...
      unitsize = unitinput.getCurrentSize()
    s = '  ' * level + unit.getName()
    if unitsize >= 0:
      s += ' (%d bytes)' % unitsize
    print(s)

    # recurse over children units
    for c in unit.getChildren():
      self.checkUnit(c, level + 1)
