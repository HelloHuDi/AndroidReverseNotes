package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        AppMethodBeat.i(11986);
        if (this.mCursor instanceof CrossProcessCursor) {
            ((CrossProcessCursor) this.mCursor).fillWindow(i, cursorWindow);
            AppMethodBeat.o(11986);
            return;
        }
        DatabaseUtils.cursorFillWindow(this.mCursor, i, cursorWindow);
        AppMethodBeat.o(11986);
    }

    public CursorWindow getWindow() {
        AppMethodBeat.i(11987);
        if (this.mCursor instanceof CrossProcessCursor) {
            CursorWindow window = ((CrossProcessCursor) this.mCursor).getWindow();
            AppMethodBeat.o(11987);
            return window;
        }
        AppMethodBeat.o(11987);
        return null;
    }

    public boolean onMove(int i, int i2) {
        AppMethodBeat.i(11988);
        if (this.mCursor instanceof CrossProcessCursor) {
            boolean onMove = ((CrossProcessCursor) this.mCursor).onMove(i, i2);
            AppMethodBeat.o(11988);
            return onMove;
        }
        AppMethodBeat.o(11988);
        return true;
    }
}
