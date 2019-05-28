"""
JEB script to reload previously saved breakpoints onto the current debugging session. (The session must be started first.)
- Breakpoints file: [JEB]/bin/breakpoints.txt
- See converse script to save breakpoints ot a file: JEB2BreakpointsSave.py

Refer to SCRIPTS.TXT for more information.
"""

import json
import os
import time

from com.pnfsoftware.jeb.client.api import IScript
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units.code.debug import IDebuggerUnit


class JEB2BreakpointsLoad(IScript):
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
    prjname = prj.getName()

    prgdir = ctx.getProgramDirectory()
    bpfile = os.path.join(prgdir, 'breakpoints.txt')
    with open(bpfile, 'r+') as f:
      try:
        bpdict = json.load(f)
      except:
        bpdict = {}
    #print('Current breakpoints file:', bpdict)

    d = bpdict.get(prjname, None)
    if not d:
      print('Nothing to reload')
      return

    # get the first code unit available (code units re interactive units)
    units = RuntimeProjectUtil.findUnitsByType(prj, IDebuggerUnit, False)
    if not units:
      print('No unit available')
      return

    cnt = 0
    for dbg in units:
      a = d.get(dbg.getName(), None)
      if a:
        print(a)
        for entry in a:
          address = entry['address']
          enabled = entry['enabled']
          #print('- Debugger: %s (for %s): %s (%s)' % (dbg.getName(), dbg.getPotentialDebuggees(), address, 'enabled' if enabled else 'disabled'))
          bp = dbg.getBreakpoint(address, None)
          if not bp:  # do not overwrite an already-set breakpoint
            bp = dbg.setBreakpoint(address, None)
            if bp:
              if not enabled:
                bp.setEnabled(False)
              cnt += 1
            else:
              print('Cannot restore breakpoint at address: %s' % address)

    print('Breakpoints reloaded: %d.' % cnt)