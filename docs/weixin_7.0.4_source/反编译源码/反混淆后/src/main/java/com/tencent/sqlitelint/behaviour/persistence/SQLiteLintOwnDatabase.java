package com.tencent.sqlitelint.behaviour.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public enum SQLiteLintOwnDatabase {
    INSTANCE;
    
    private static final String DATABASE_DIRECTORY = "database";
    private static final String DATABASE_NAME = "own.db";
    private static final int NEW_VERSION = 1;
    private static final String ROOT_PATH = null;
    private static final String TAG = "SQLiteLint.SQLiteLintOwnDatabase";
    private static final int VERSION_1 = 1;
    private static String sOwnDbDirectory;
    private volatile SQLiteDatabase mDatabase;
    private boolean mIsInitializing;

    static {
        ROOT_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        sOwnDbDirectory = "";
        AppMethodBeat.m2505o(94093);
    }

    public final SQLiteDatabase getDatabase() {
        AppMethodBeat.m2504i(94087);
        if (this.mDatabase == null || !this.mDatabase.isOpen()) {
            synchronized (this) {
                try {
                    if (this.mDatabase == null || !this.mDatabase.isOpen()) {
                        this.mDatabase = openOrCreateDatabase();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(94087);
                    }
                }
            }
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        AppMethodBeat.m2505o(94087);
        return sQLiteDatabase;
    }

    public final synchronized void closeDatabase() {
        AppMethodBeat.m2504i(94088);
        if (this.mIsInitializing) {
            IllegalStateException illegalStateException = new IllegalStateException("Closed during initialization");
            AppMethodBeat.m2505o(94088);
            throw illegalStateException;
        }
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
        AppMethodBeat.m2505o(94088);
    }

    private void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        AppMethodBeat.m2504i(94089);
        SLog.m8893i(TAG, "onCreate", new Object[0]);
        sQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_SQL);
        while (i < IssueStorage.DB_VERSION_1_CREATE_INDEX.length) {
            sQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_INDEX[i]);
            i++;
        }
        AppMethodBeat.m2505o(94089);
    }

    private void onUpgrade(SQLiteDatabase sQLiteDatabase, int i) {
        AppMethodBeat.m2504i(94090);
        SLog.m8893i(TAG, "onUpgrade oldVersion=%d, newVersion=%d", Integer.valueOf(i), Integer.valueOf(1));
        AppMethodBeat.m2505o(94090);
    }

    private SQLiteDatabase openOrCreateDatabase() {
        AppMethodBeat.m2504i(94091);
        IllegalStateException illegalStateException;
        if (this.mIsInitializing) {
            illegalStateException = new IllegalStateException("getDatabase called recursively");
            AppMethodBeat.m2505o(94091);
            throw illegalStateException;
        } else if (SQLiteLintUtil.isNullOrNil(sOwnDbDirectory)) {
            illegalStateException = new IllegalStateException("OwnDbDirectory not init");
            AppMethodBeat.m2505o(94091);
            throw illegalStateException;
        } else {
            SQLiteDatabase openDatabase;
            try {
                this.mIsInitializing = true;
                String format = String.format("%s/%s", new Object[]{sOwnDbDirectory, DATABASE_NAME});
                SLog.m8893i(TAG, "openOrCreateDatabase path=%s", format);
                SQLiteLintUtil.mkdirs(format);
                openDatabase = SQLiteDatabase.openDatabase(format, null, 268435456, null);
                int version = openDatabase.getVersion();
                if (version != 1) {
                    openDatabase.beginTransaction();
                    if (version == 0) {
                        onCreate(openDatabase);
                    } else if (version != 1) {
                        onUpgrade(openDatabase, version);
                    }
                    openDatabase.setVersion(1);
                    openDatabase.setTransactionSuccessful();
                    openDatabase.endTransaction();
                }
                this.mIsInitializing = false;
                AppMethodBeat.m2505o(94091);
                return openDatabase;
            } catch (Throwable th) {
                this.mIsInitializing = false;
                AppMethodBeat.m2505o(94091);
            }
        }
    }

    public static void setOwnDbDirectory(Context context) {
        AppMethodBeat.m2504i(94092);
        if (SQLiteLintUtil.isNullOrNil(sOwnDbDirectory)) {
            sOwnDbDirectory = String.format("%s/SQLiteLint-%s/%s/", new Object[]{ROOT_PATH, context.getPackageManager(), DATABASE_DIRECTORY});
            AppMethodBeat.m2505o(94092);
            return;
        }
        AppMethodBeat.m2505o(94092);
    }
}
