package com.tencent.sqlitelint;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;

public final class SimpleSQLiteExecutionDelegate implements ISQLiteExecutionDelegate {
    static final /* synthetic */ boolean $assertionsDisabled = (!SimpleSQLiteExecutionDelegate.class.desiredAssertionStatus());
    private static final String TAG = "SQLiteLint.SimpleSQLiteExecutionDelegate";
    private final SQLiteDatabase mDb;

    static {
        AppMethodBeat.i(94035);
        AppMethodBeat.o(94035);
    }

    public SimpleSQLiteExecutionDelegate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(94032);
        if ($assertionsDisabled || sQLiteDatabase != null) {
            this.mDb = sQLiteDatabase;
            AppMethodBeat.o(94032);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(94032);
        throw assertionError;
    }

    public final Cursor rawQuery(String str, String... strArr) {
        AppMethodBeat.i(94033);
        if (this.mDb.isOpen()) {
            Cursor rawQuery = this.mDb.rawQuery(str, strArr);
            AppMethodBeat.o(94033);
            return rawQuery;
        }
        SLog.w(TAG, "rawQuery db close", new Object[0]);
        AppMethodBeat.o(94033);
        return null;
    }

    public final void execSQL(String str) {
        AppMethodBeat.i(94034);
        if (this.mDb.isOpen()) {
            this.mDb.execSQL(str);
            AppMethodBeat.o(94034);
            return;
        }
        SLog.w(TAG, "rawQuery db close", new Object[0]);
        AppMethodBeat.o(94034);
    }
}
