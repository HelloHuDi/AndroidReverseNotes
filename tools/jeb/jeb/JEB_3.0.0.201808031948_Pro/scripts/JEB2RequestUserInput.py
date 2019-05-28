"""
Sample UI client script for PNF Software' JEB2.

Shows how to use message and dialog boxes.

Refer to SCRIPTS.TXT for more information.
"""

from com.pnfsoftware.jeb.client.api import IScript, IGraphicalClientContext
from com.pnfsoftware.jeb.client.api import IconType, ButtonGroupType


class JEB2RequestUserInput(IScript):

  def run(self, ctx):
    if not isinstance(ctx, IGraphicalClientContext):
      print('This script must be run within a graphical client')
      return

    value = ctx.displayQuestionBox('Input', 'Enter a random string', '3')
    if value != None:
      ctx.displayMessageBox('Information', 'The value was %s' % value,
              IconType.INFORMATION, ButtonGroupType.OK)
