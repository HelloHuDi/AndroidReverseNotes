package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteAsyncQuery extends SQLiteProgram {
    private static final String TAG = "WCDB.SQLiteAsyncQuery";
    private final int mResultColumns = getColumnNames().length;

    private static native int nativeCount(long j);

    private static native int nativeFillRows(long j, long j2, int i, int i2);

    public SQLiteAsyncQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, objArr, cancellationSignal);
        AppMethodBeat.i(12264);
        AppMethodBeat.o(12264);
    }

    /* Access modifiers changed, original: 0000 */
    public void acquire() {
        AppMethodBeat.i(12265);
        if (this.mPreparedStatement == null) {
            acquirePreparedStatement();
            this.mPreparedStatement.bindArguments(getBindArgs());
        }
        AppMethodBeat.o(12265);
    }

    /* Access modifiers changed, original: 0000 */
    public void release() {
        AppMethodBeat.i(12266);
        releasePreparedStatement();
        AppMethodBeat.o(12266);
    }

    /* Access modifiers changed, original: 0000 */
    public int fillRows(ChunkedCursorWindow chunkedCursorWindow, int i, int i2) {
        AppMethodBeat.i(12267);
        acquire();
        if (chunkedCursorWindow.getNumColumns() != this.mResultColumns) {
            chunkedCursorWindow.setNumColumns(this.mResultColumns);
        }
        try {
            int nativeFillRows = nativeFillRows(this.mPreparedStatement.getPtr(), chunkedCursorWindow.mWindowPtr, i, i2);
            AppMethodBeat.o(12267);
            return nativeFillRows;
        } catch (SQLiteException e) {
            Log.e(TAG, "Got exception on fillRows: " + e.getMessage() + ", SQL: " + getSql());
            checkCorruption(e);
            AppMethodBeat.o(12267);
            throw e;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public int getCount() {
        AppMethodBeat.i(12268);
        acquire();
        try {
            int nativeCount = nativeCount(this.mPreparedStatement.getPtr());
            AppMethodBeat.o(12268);
            return nativeCount;
        } catch (SQLiteException e) {
            Log.e(TAG, "Got exception on getCount: " + e.getMessage() + ", SQL: " + getSql());
            checkCorruption(e);
            AppMethodBeat.o(12268);
            throw e;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reset() {
        AppMethodBeat.i(12269);
        if (this.mPreparedStatement != null) {
            this.mPreparedStatement.reset(false);
        }
        AppMethodBeat.o(12269);
    }
}
