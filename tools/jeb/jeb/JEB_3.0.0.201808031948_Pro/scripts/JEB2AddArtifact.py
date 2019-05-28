"""
Sample UI client script for JEB2.

This script demonstrates how to add and process additional artifacts into a JEB2 project.

Refer to SCRIPTS.TXT for more information.
More online www.pnfsoftware.com
"""

import time

from java.lang import Runnable, Thread
from java.io import File

from com.pnfsoftware.jeb.client.api import IScript, IGraphicalClientContext
from com.pnfsoftware.jeb.core import Artifact
from com.pnfsoftware.jeb.core.input import FileInput


class JEB2AddArtifact(IScript):

  path = 'PATH_TO_FILE'

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

    artifactFile = File(self.path)
    a = Artifact(artifactFile.getName(), FileInput(artifactFile))
    print(a)

    la = prj.processArtifact(a)
    print(la)

