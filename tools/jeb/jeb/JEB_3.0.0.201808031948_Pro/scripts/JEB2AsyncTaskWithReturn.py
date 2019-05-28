"""
Sample UI client script for PNF Software' JEB2.

This script demonstrates how to run an asynchronous interruptible task that returns a value.

Refer to SCRIPTS.TXT for more information.
"""

import time

from java.lang import Thread
from java.util.concurrent import Callable

from com.pnfsoftware.jeb.client.api import IScript, IGraphicalClientContext


class JEB2AsyncTaskWithReturn(IScript):
  def run(self, ctx):
    if not isinstance(ctx, IGraphicalClientContext):
      print('This script must be run within a graphical client')
      return
    r = ctx.executeAsyncWithReturn('Counting... and returning a value', SimpleTask())
    print r


# note the use of Callable here
class SimpleTask(Callable):
  def call(self):
    for i in range(5):
      # react to user pressing Cancel
      if Thread.interrupted():
        print('The task was interrupted')
        break
      print('Counter: %d' % i)
      time.sleep(1)
    return 123