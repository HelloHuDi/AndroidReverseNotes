package com.tencent.sqlitelint.behaviour.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;

public enum SQLiteLintDbHelper {
    INSTANCE;
    
    private static final String DB_NAME = "SQLiteLintInternal.db";
    private static final String TAG = "SQLiteLint.SQLiteLintOwnDatabase";
    private static final int VERSION_1 = 1;
    private volatile InternalDbHelper mHelper;

    static final class InternalDbHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "SQLiteLintInternal.db";
        private static final int VERSION_1 = 1;

        InternalDbHelper(Context context) {
            super(context, DB_NAME, null, 1);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            int i = 0;
            AppMethodBeat.m2504i(94079);
            SLog.m8893i(SQLiteLintDbHelper.TAG, "onCreate", new Object[0]);
            sQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_SQL);
            while (i < IssueStorage.DB_VERSION_1_CREATE_INDEX.length) {
                sQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_INDEX[i]);
                i++;
            }
            AppMethodBeat.m2505o(94079);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        AppMethodBeat.m2505o(94084);
    }

    public final SQLiteDatabase getDatabase() {
        AppMethodBeat.m2504i(94082);
        if (this.mHelper == null) {
            IllegalStateException illegalStateException = new IllegalStateException("getIssueStorage db not ready");
            AppMethodBeat.m2505o(94082);
            throw illegalStateException;
        }
        SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
        AppMethodBeat.m2505o(94082);
        return writableDatabase;
    }

    public final void initialize(Context context) {
        AppMethodBeat.m2504i(94083);
        if (this.mHelper == null) {
            synchronized (this) {
                try {
                    if (this.mHelper == null) {
                        this.mHelper = new InternalDbHelper(context);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(94083);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(94083);
    }
}
