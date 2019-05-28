package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        AppMethodBeat.m2504i(11986);
        if (this.mCursor instanceof CrossProcessCursor) {
            ((CrossProcessCursor) this.mCursor).fillWindow(i, cursorWindow);
            AppMethodBeat.m2505o(11986);
            return;
        }
        DatabaseUtils.cursorFillWindow(this.mCursor, i, cursorWindow);
        AppMethodBeat.m2505o(11986);
    }

    public CursorWindow getWindow() {
        AppMethodBeat.m2504i(11987);
        if (this.mCursor instanceof CrossProcessCursor) {
            CursorWindow window = ((CrossProcessCursor) this.mCursor).getWindow();
            AppMethodBeat.m2505o(11987);
            return window;
        }
        AppMethodBeat.m2505o(11987);
        return null;
    }

    public boolean onMove(int i, int i2) {
        AppMethodBeat.m2504i(11988);
        if (this.mCursor instanceof CrossProcessCursor) {
            boolean onMove = ((CrossProcessCursor) this.mCursor).onMove(i, i2);
            AppMethodBeat.m2505o(11988);
            return onMove;
        }
        AppMethodBeat.m2505o(11988);
        return true;
    }
}
