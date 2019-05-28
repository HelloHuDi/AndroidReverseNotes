package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor zzxu;

    public CursorWrapper(Cursor cursor) {
        super(cursor);
        AppMethodBeat.m2504i(89935);
        Object obj = cursor;
        for (int i = 0; i < 10 && (obj instanceof android.database.CursorWrapper); i++) {
            obj = ((android.database.CursorWrapper) obj).getWrappedCursor();
        }
        if (obj instanceof AbstractWindowedCursor) {
            this.zzxu = (AbstractWindowedCursor) obj;
            AppMethodBeat.m2505o(89935);
            return;
        }
        String str = "Unknown type: ";
        String valueOf = String.valueOf(obj.getClass().getName());
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        AppMethodBeat.m2505o(89935);
        throw illegalArgumentException;
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        AppMethodBeat.m2504i(89938);
        this.zzxu.fillWindow(i, cursorWindow);
        AppMethodBeat.m2505o(89938);
    }

    public CursorWindow getWindow() {
        AppMethodBeat.m2504i(89936);
        CursorWindow window = this.zzxu.getWindow();
        AppMethodBeat.m2505o(89936);
        return window;
    }

    public AbstractWindowedCursor getWrappedCursor() {
        return this.zzxu;
    }

    public boolean onMove(int i, int i2) {
        AppMethodBeat.m2504i(89939);
        boolean onMove = this.zzxu.onMove(i, i2);
        AppMethodBeat.m2505o(89939);
        return onMove;
    }

    public void setWindow(CursorWindow cursorWindow) {
        AppMethodBeat.m2504i(89937);
        this.zzxu.setWindow(cursorWindow);
        AppMethodBeat.m2505o(89937);
    }
}
