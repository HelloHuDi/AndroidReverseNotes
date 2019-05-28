package com.tencent.tmassistantsdk.channel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;

public class DBOption {
    protected static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);";
    protected static final int DATEBASE_VERSION = 1;
    protected static final String DB_NAME = ".SystemConfig.db";
    protected static final String QUERY_ALL_SQL = "select * from channeldata";
    protected static final String TABLE_NAME = "channeldata";
    protected String DB_PATH = "";

    public DBOption() {
        AppMethodBeat.m2504i(75607);
        Object obj = ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory().canWrite()) ? 1 : null;
        if (obj != null) {
            this.DB_PATH = Environment.getExternalStorageDirectory().getPath() + "/tencent/assistant/";
            File file = new File(this.DB_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.DB_PATH += DB_NAME;
        }
        AppMethodBeat.m2505o(75607);
    }

    public long insert(TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem) {
        AppMethodBeat.m2504i(75608);
        if (tMAssistantSDKChannelDataItem == null) {
            AppMethodBeat.m2505o(75608);
            return -1;
        }
        byte[] buffer = tMAssistantSDKChannelDataItem.getBuffer();
        if (buffer != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("itemData", buffer);
                long insert = writableDatabase.insert(TABLE_NAME, "", contentValues);
                closeDB(writableDatabase);
                AppMethodBeat.m2505o(75608);
                return insert;
            }
        }
        AppMethodBeat.m2505o(75608);
        return -1;
    }

    public boolean delete(long j) {
        AppMethodBeat.m2504i(75609);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete(TABLE_NAME, "itemId=?", new String[]{String.valueOf(j)});
            closeDB(writableDatabase);
            AppMethodBeat.m2505o(75609);
            return true;
        }
        AppMethodBeat.m2505o(75609);
        return false;
    }

    public ArrayList<TMAssistantSDKChannelDataItem> queryAll() {
        ArrayList<TMAssistantSDKChannelDataItem> arrayList = null;
        AppMethodBeat.m2504i(75610);
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase != null) {
            Cursor rawQuery = readableDatabase.rawQuery(QUERY_ALL_SQL, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                int columnIndex = rawQuery.getColumnIndex("itemId");
                int columnIndex2 = rawQuery.getColumnIndex("itemData");
                arrayList = new ArrayList();
                do {
                    int i = rawQuery.getInt(columnIndex);
                    TMAssistantSDKChannelDataItem dataItemFromByte = TMAssistantSDKChannelDataItem.getDataItemFromByte(rawQuery.getBlob(columnIndex2));
                    if (dataItemFromByte != null) {
                        dataItemFromByte.mDBIdentity = i;
                        arrayList.add(dataItemFromByte);
                    }
                } while (rawQuery.moveToNext());
                closeDB(readableDatabase);
            }
            rawQuery.close();
            closeDB(readableDatabase);
            AppMethodBeat.m2505o(75610);
        } else {
            AppMethodBeat.m2505o(75610);
        }
        return arrayList;
    }

    private SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase = null;
        AppMethodBeat.m2504i(75611);
        for (int i = 0; i < 20; i++) {
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.DB_PATH, null);
            } catch (SQLiteException e) {
            }
            if (sQLiteDatabase != null) {
                checkAndCreateTable(sQLiteDatabase);
                break;
            }
            SystemClock.sleep(50);
        }
        AppMethodBeat.m2505o(75611);
        return sQLiteDatabase;
    }

    private synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (this) {
            AppMethodBeat.m2504i(75612);
            if (new File(this.DB_PATH).exists()) {
                for (int i = 0; i < 20; i++) {
                    try {
                        sQLiteDatabase = SQLiteDatabase.openDatabase(this.DB_PATH, null, 1);
                    } catch (SQLiteException e) {
                    }
                    if (sQLiteDatabase != null) {
                        break;
                    }
                    SystemClock.sleep(50);
                }
                AppMethodBeat.m2505o(75612);
            } else {
                AppMethodBeat.m2505o(75612);
            }
        }
        return sQLiteDatabase;
    }

    private void closeDB(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(75613);
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.close();
                AppMethodBeat.m2505o(75613);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(75613);
    }

    private void checkAndCreateTable(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(75614);
        int version = sQLiteDatabase.getVersion();
        if (version != 1) {
            sQLiteDatabase.beginTransaction();
            if (version == 0) {
                try {
                    sQLiteDatabase.execSQL(CREATE_TABLE_SQL);
                } catch (Throwable th) {
                    sQLiteDatabase.endTransaction();
                    AppMethodBeat.m2505o(75614);
                }
            }
            sQLiteDatabase.setVersion(1);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            AppMethodBeat.m2505o(75614);
            return;
        }
        AppMethodBeat.m2505o(75614);
    }
}
