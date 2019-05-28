package com.tencent.tmassistantsdk.storage.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.storage.table.ITableBase;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public abstract class SqliteHelper extends SQLiteOpenHelper {
    private static final String TAG = "MicroMsg.SqliteHelper";

    public abstract int getDBVersion();

    public abstract Class<?>[] getTables();

    public SqliteHelper(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        try {
            sQLiteDatabase = super.getWritableDatabase();
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
        }
        while (true) {
            if (sQLiteDatabase.isDbLockedByCurrentThread() || sQLiteDatabase.isDbLockedByOtherThreads()) {
                SystemClock.sleep(10);
            }
        }
        return sQLiteDatabase;
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        try {
            sQLiteDatabase = super.getReadableDatabase();
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
        }
        while (true) {
            if (sQLiteDatabase.isDbLockedByCurrentThread() || sQLiteDatabase.isDbLockedByOtherThreads()) {
                SystemClock.sleep(10);
            }
        }
        return sQLiteDatabase;
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        int version = sQLiteDatabase.getVersion();
        TMLog.i("sqliteHelper", " dbversion:" + version + " newVersion:" + getDBVersion());
        if (version == 0) {
            return;
        }
        if (version < getDBVersion()) {
            onUpgrade(sQLiteDatabase, version, getDBVersion());
        } else if (version > getDBVersion()) {
            onDowngrade(sQLiteDatabase, version, getDBVersion());
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createTable(sQLiteDatabase);
    }

    private void createTable(SQLiteDatabase sQLiteDatabase) {
        TMLog.i("sqliteHelper", "tables count:" + getTables().length);
        for (Class newInstance : getTables()) {
            try {
                ITableBase iTableBase = (ITableBase) newInstance.newInstance();
                String createTableSQL = iTableBase.createTableSQL();
                if (createTableSQL != null && createTableSQL.length() > 0) {
                    sQLiteDatabase.execSQL(createTableSQL);
                }
                TMLog.i("sqliteHelper", "sql=".concat(String.valueOf(createTableSQL)));
                if (GlobalUtil.isDBExist(AstSDKDBHelper.DB_NAME)) {
                    TMLog.i("sqliteHelper", "dataMovement");
                    iTableBase.dataMovement(AstSDKDBHelper.getInstance().getReadableDatabase(), sQLiteDatabase);
                }
            } catch (InstantiationException e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            } catch (IllegalAccessException e2) {
                ab.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        GlobalUtil.deleteOldDB(AstSDKDBHelper.DB_NAME);
    }

    private void deleteTable(SQLiteDatabase sQLiteDatabase) {
        for (Class newInstance : getTables()) {
            try {
                sQLiteDatabase.delete(((ITableBase) newInstance.newInstance()).tableName(), null, null);
            } catch (InstantiationException e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            } catch (IllegalAccessException e2) {
                ab.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        deleteTable(sQLiteDatabase);
        createTable(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            for (Class newInstance : getTables()) {
                try {
                    String[] alterSQL = ((ITableBase) newInstance.newInstance()).getAlterSQL(i, i + 1);
                    TMLog.i("sqliteHelper", " upgrade:".concat(String.valueOf(alterSQL)));
                    if (alterSQL != null) {
                        for (String execSQL : alterSQL) {
                            sQLiteDatabase.execSQL(execSQL);
                        }
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace(TAG, e, "", new Object[0]);
                }
            }
            i++;
        }
    }
}
