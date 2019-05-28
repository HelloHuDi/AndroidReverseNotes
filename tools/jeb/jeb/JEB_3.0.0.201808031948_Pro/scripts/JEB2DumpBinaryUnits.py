"""
Dump all binary units of a JEB opened project to files on disk.
Output folder= [HOME]/JEB_PROJECT_BINARY_EXTRACTED

Refer to SCRIPTS.TXT for more information.
"""

import os

from java.io import File

from com.pnfsoftware.jeb.client.api import IScript
from com.pnfsoftware.jeb.core.units import IBinaryUnit
from com.pnfsoftware.jeb.util.io import IO

class JEB2DumpBinaryUnits(IScript):

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

    OUTDIR = IO.expandPath('~/JEB_PROJECT_BINARY_EXTRACTED')
    prj = projects[0]
    print('=> Dumping binary units of project to directory: %s' % OUTDIR)

    for art in prj.getLiveArtifacts():
      for unit in art.getUnits():
        self.checkUnit(unit, OUTDIR+'/'+art.getArtifact().getName())

  def checkUnit(self, unit, basename, level=0):    
    basename2 = basename+'/'+unit.getName()

    unitsize = -1
    if isinstance(unit, IBinaryUnit):
      unitinput = unit.getInput()
      print('Creating dir: %s' % basename)
      if not os.path.exists(basename):
        os.makedirs(basename)
      try:
        print('Writing file: %s (%db)' % (basename2, unitinput.getCurrentSize()))
        f = File(basename2)
        data = IO.readInputStream(unitinput.getStream())
        IO.writeFile(f, data, 0, len(data))
      except Exception as e:
        print('An error occurred: %s' % e)
      basename2 = basename2 + '_sub'

    # recurse over children units
    for c in unit.getChildren():
      self.checkUnit(c, basename2, level + 1)
