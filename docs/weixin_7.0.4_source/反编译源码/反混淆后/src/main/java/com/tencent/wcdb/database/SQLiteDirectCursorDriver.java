package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private static CursorFactory DEFAULT_FACTORY = SQLiteCursor.FACTORY;
    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteProgram mQuery;
    private final String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
        this.mCancellationSignal = cancellationSignal;
    }

    public final Cursor query(CursorFactory cursorFactory, Object[] objArr) {
        AppMethodBeat.m2504i(12570);
        if (cursorFactory == null) {
            cursorFactory = DEFAULT_FACTORY;
        }
        SQLiteProgram sQLiteProgram = null;
        try {
            sQLiteProgram = cursorFactory.newQuery(this.mDatabase, this.mSql, objArr, this.mCancellationSignal);
            Cursor newCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteProgram);
            this.mQuery = sQLiteProgram;
            AppMethodBeat.m2505o(12570);
            return newCursor;
        } catch (RuntimeException e) {
            if (sQLiteProgram != null) {
                sQLiteProgram.close();
            }
            AppMethodBeat.m2505o(12570);
            throw e;
        }
    }

    public final void cursorClosed() {
    }

    public final void setBindArguments(String[] strArr) {
        AppMethodBeat.m2504i(12571);
        this.mQuery.bindAllArgsAsStrings(strArr);
        AppMethodBeat.m2505o(12571);
    }

    public final void cursorDeactivated() {
    }

    public final void cursorRequeried(Cursor cursor) {
    }

    public final String toString() {
        AppMethodBeat.m2504i(12572);
        String str = "SQLiteDirectCursorDriver: " + this.mSql;
        AppMethodBeat.m2505o(12572);
        return str;
    }
}
