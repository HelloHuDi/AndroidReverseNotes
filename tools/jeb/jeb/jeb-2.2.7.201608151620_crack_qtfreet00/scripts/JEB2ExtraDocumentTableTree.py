"""
Sample UI client script for PNF Software' JEB2.

This script demonstrates how to generate extra table and tree documents for a unit.

Refer to SCRIPTS.TXT for more information.
"""

import time

from java.util import ArrayList, Arrays

from com.pnfsoftware.jeb.client.api import IScript, IGraphicalClientContext
from com.pnfsoftware.jeb.core import RuntimeProjectUtil
from com.pnfsoftware.jeb.core.output import AbstractUnitRepresentation, UnitRepresentationAdapter, ItemClassIdentifiers
from com.pnfsoftware.jeb.core.output.table.impl import StaticTableDocument, TableRow, Cell
from com.pnfsoftware.jeb.core.output.tree.impl import StaticTreeDocument, Node, KVNode
from com.pnfsoftware.jeb.core.events import JebEvent, J


class JEB2ExtraDocumentTableTree(IScript):
  def run(self, ctx):
    engctx = ctx.getEnginesContext()
    if not engctx:
      print('Back-end engines not initialized')
      return

    projects = engctx.getProjects()
    if not projects:
      print('There is no opened project')
      return

    # get the first unit available
    units = RuntimeProjectUtil.findUnitsByType(projects[0], None, False)
    if not units:
      print('No unit available')
      return

    unit = units[0]
    print('Unit: %s' % unit)

    # retrieve the formatter, which is a producer of unit representations
    formatter = unit.getFormatter()

    # create a table document
    columnLabels = Arrays.asList('Key', 'Value', 'Comment')
    rows = ArrayList()
    rows.add(TableRow(Arrays.asList(Cell('foo'), Cell('bar'), Cell('none'))))
    rows.add(TableRow(Arrays.asList(Cell('type'), Cell('integer'), Cell('unset'))))
    extraDoc = StaticTableDocument(columnLabels, rows)
    extraPres0 = UnitRepresentationAdapter(101, 'Demo Table', False, extraDoc)

    # create a tree document
    columnLabels = Arrays.asList('Key', 'Value')
    root = KVNode('foo', 'bar')
    roots = Arrays.asList(root)
    root.addChild(KVNode('quantified', 'self'))
    root.addChild(KVNode('galaxy', 'milky way'))
    node = KVNode('black hole', '42')
    node.setClassId(ItemClassIdentifiers.INFO_DANGEROUS)
    root.addChild(node)
    extraDoc = StaticTreeDocument(roots, columnLabels, -1)
    extraPres1 = UnitRepresentationAdapter(102, 'Demo Tree', False, extraDoc)

    # add the newly created presentations to our unit, and notify clients
    # the second argument indicates that the presentation should be persisted when saving the project
    formatter.addPresentation(extraPres0, True)
    formatter.addPresentation(extraPres1, True)
    unit.notifyListeners(JebEvent(J.UnitChange));

    # done - if you are running a UI client, the additional document should be displayed
    # in a fragment view (eg, sub-tab in the case of the official RCP client)
