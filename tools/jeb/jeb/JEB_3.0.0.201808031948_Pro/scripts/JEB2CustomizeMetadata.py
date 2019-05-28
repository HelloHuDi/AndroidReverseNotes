"""
Sample UI client script for PNF Software' JEB2.

This script demonstrates how to manipulate the metadata of an interactive unit.

Refer to SCRIPTS.TXT for more information.
"""

import time

from java.util import ArrayList

from com.pnfsoftware.jeb.client.api import IScript, IGraphicalClientContext
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.units import IInteractiveUnit, MetadataGroup, MetadataGroupType
from com.pnfsoftware.jeb.core.units.code import ICodeUnit


class JEB2CustomizeMetadata(IScript):
  def run(self, ctx):
    engctx = ctx.getEnginesContext()
    if not engctx:
      print('Back-end engines not initialized')
      return

    projects = engctx.getProjects()
    if not projects:
      print('There is no opened project')
      return

    # get the first code unit available (code units re interactive units)
    units = RuntimeProjectUtil.findUnitsByType(projects[0], ICodeUnit, False)
    if not units:
      print('No unit available')
      return

    unit = units[0]
    print('Unit: %s' % unit)

    # the metadata manager is optional (a unit may choose to not provide one)
    mm = unit.getMetadataManager()
    if not mm:
      print('The unit does not have a metadata manager')
      return

    # assume the code unit has classes (pick the second one)
    c = unit.getClasses()[1]
    targetAddress = c.getAddress()
    
    g = mm.getGroupByName('custom')
    if not g:
      print('Creating new metadata group (type: RGB) ...')
      g = MetadataGroup('custom', MetadataGroupType.RGB)
      mm.addGroup(g)
      print('Done')

    print('Adding a piece of metadata at address "%s" ...' % targetAddress)
    g.setData(targetAddress, 0x00FF30)
    print('Done')

    print('If the unit has a text document representation with a an Overview bar, do a Refresh to visualize the metadata')

    print('Listing all metadata for this unit (if possible) ...')
    for g1 in mm.getGroups():
      print('- Group %s (type: %s)' % (g1.getName(), g1.getType()))
      alldata = g1.getAllData()
      if alldata == None:
        print('(This group manager does not allow metadata enumeration)')
      else:
        for k in alldata:
          print('  - at "%s" -> %s' % (k, alldata[k]))
