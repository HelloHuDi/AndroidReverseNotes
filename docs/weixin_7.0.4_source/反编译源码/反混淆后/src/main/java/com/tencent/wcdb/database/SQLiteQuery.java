package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "WCDB.SQLiteQuery";
    private final CancellationSignal mCancellationSignal;

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, objArr, cancellationSignal);
        this.mCancellationSignal = cancellationSignal;
    }

    /* Access modifiers changed, original: final */
    public final int fillWindow(CursorWindow cursorWindow, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(12583);
        acquireReference();
        try {
            cursorWindow.acquireReference();
            try {
                int executeForCursorWindow = getSession().executeForCursorWindow(getSql(), getBindArgs(), cursorWindow, i, i2, z, getConnectionFlags(), this.mCancellationSignal);
                cursorWindow.releaseReference();
                return executeForCursorWindow;
            } catch (SQLiteException e) {
                Log.m9444e(TAG, "exception: " + e.getMessage() + "; query: " + getSql());
                checkCorruption(e);
                AppMethodBeat.m2505o(12583);
                throw e;
            } catch (Throwable th) {
                cursorWindow.releaseReference();
                AppMethodBeat.m2505o(12583);
            }
        } finally {
            releaseReference();
            AppMethodBeat.m2505o(12583);
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(12584);
        String str = "SQLiteQuery: " + getSql();
        AppMethodBeat.m2505o(12584);
        return str;
    }
}
