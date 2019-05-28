"""
JEB script to save (persist) the breakpoints (location and state) of the current debugging session to a file.
- Breakpoints file: [JEB]/bin/breakpoints.txt
- See converse script to reload breakpoints onto a debugging session: JEB2BreakpointsLoad.py

The breakpoints file is JSON formatted and can be edited manually as well. Structure

ProjectName:
  DebuggerName:
    BreakpointsList: (= dictionary with "address" and "enabled" keys)

Example:

{
 "/analysis/appcheck-debug.apk.jdb2": {
  "VM": [
   {
    "address": "Lcom/xyz/appcheck/AppCheck$1;-><init>(Lcom/xyz/appcheck/AppCheck;)V+4h", 
    "enabled": true
   }, 
   {
    "address": "Lcom/xyz/appcheck/AppCheck$1;->run()V+2h", 
    "enabled": true
   }
  ]
 }
 "/analysis/malware_yil1.apk.jdb2": {
  "VM": [
   {
    "address": "Lcom/malyy/a/b/c;->f()V+0h", 
    "enabled": false
   }
  ]
 }
}

Refer to SCRIPTS.TXT for more information.
"""

import json
import os
import time

from com.pnfsoftware.jeb.client.api import IScript
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units.code.debug import IDebuggerUnit


class JEB2BreakpointsSave(IScript):
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

    units = RuntimeProjectUtil.findUnitsByType(prj, IDebuggerUnit, False)
    if not units:
      print('No unit available')
      return

    d = {}
    cnt = 0
    for dbg in units:
      # may be null for a detached debugger
      bplist = dbg.getBreakpoints()
      if bplist:
        a = []
        for bp in bplist:
          address = bp.getAddress()
          enabled = bp.isEnabled()
          #print('- Debugger: %s (for %s): %s (%s)' % (dbg.getName(), dbg.getPotentialDebuggees(), address, 'enabled' if enabled else 'disabled'))
          a.append({'address': address, 'enabled': enabled})
          cnt += 1
        d[dbg.getName()] = a      
    bpdict[prjname] = d

    with open(bpfile, 'w') as f:
      try:
        json.dump(bpdict, f, indent=True)
      except Exception as e:
        print('ERROR: Cannot save to breakpoints file: %s' % e)

    print('Breakpoints saved: %d.' % cnt)