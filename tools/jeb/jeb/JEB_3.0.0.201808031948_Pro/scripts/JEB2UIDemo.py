"""
Sample UI client script for PNF Software' JEB2.
Requires: JEB 2.1.4

This script demonstrates how to use the JEB2 UI API to query and augment the views offered by JEB2 UI clients.

Refer to SCRIPTS.TXT for more information.
"""

import time

from java.lang import Runnable, Thread

from com.pnfsoftware.jeb.client.api import IScript, IGraphicalClientContext
from com.pnfsoftware.jeb.core import RuntimeProjectUtil, IUnitFilter
from com.pnfsoftware.jeb.core.units import IUnit


class JEB2UIDemo(IScript):
  def run(self, ctx):
    if not isinstance(ctx, IGraphicalClientContext):
      print('This script must be run within a graphical client')
      return

    # show which unit view is currently focused
    v = ctx.getFocusedView()  # needs 2.1.4
    print('Focused view: %s' % v)

    # enumerate all unit views (views representing units) and fragments within those views
    print('Views and fragments:')
    views = ctx.getViews()
    for view in views:
      print('- %s' % view.getLabel())
      fragments = view.getFragments()
      for fragment in fragments:
        print('  - %s' % view.getFragmentLabel(fragment))

    # focus test
    if len(views) >= 2:
      print('Focusing the second Unit view (if any)')
      views[1].setFocus()

    # opening the first certificate unit we find (in an APK, there should be one)
    engctx = ctx.getEnginesContext()
    projects = engctx.getProjects()
    unitFilter = UnitFilter('cert')
    units = RuntimeProjectUtil.filterUnits(projects[0], unitFilter)
    if units:
      ctx.openView(units.get(0))

    # done


class UnitFilter(IUnitFilter):
  def __init__(self, formatType):
    self.formatType = formatType
  def check(self, unit):
    return unit.getFormatType() == self.formatType
