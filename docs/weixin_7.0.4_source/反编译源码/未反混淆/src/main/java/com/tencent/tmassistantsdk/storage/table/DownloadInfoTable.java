package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTask;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadInfoTable implements ITableBase {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, secondaryUrl TEXT, finalUrl TEXT, requestFileSize INTEGER, fileName TEXT, contentType TEXT, redirectCnt INTEGER, retryCnt INTEGER, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER,netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT);";
    public static final String QUERY_ALL = "select * from downloadInfo";
    public static final String QUERY_DOWNLOADINFO_URL = "select * from downloadInfo where taskUrl = ?";
    public static final String QUERY_UNFINISHED_TASK = "select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)";
    public static final String TABLE_NAME = "downloadInfo";
    private static final String TAG = "DownloadInfoTable";

    public String tableName() {
        return TABLE_NAME;
    }

    public String createTableSQL() {
        return CREATE_TABLE_SQL;
    }

    public String[] getAlterSQL(int i, int i2) {
        if (i == 1 && i2 == 2) {
            return new String[]{"alter table downloadInfo add column headerParams TEXT;"};
        }
        return new String[]{"alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;"};
    }

    public SqliteHelper getHelper() {
        AppMethodBeat.i(76194);
        SqliteHelper instance = AstSDKDBHelper_V2.getInstance();
        AppMethodBeat.o(76194);
        return instance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ArrayList<DownloadInfo> load() {
        Cursor cursor = null;
        AppMethodBeat.i(76195);
        ArrayList arrayList = new ArrayList();
        try {
            cursor = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery(QUERY_ALL, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(76195);
                return arrayList;
            }
            do {
                arrayList.add(DownloadInfo.readFromCursor(cursor));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(76195);
            return arrayList;
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(76195);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(76195);
            throw th;
        }
    }

    public static void save(ArrayList<DownloadInfo> arrayList) {
        AppMethodBeat.i(76196);
        if (arrayList != null) {
            SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DownloadInfo downloadInfo = (DownloadInfo) it.next();
                    if (update(downloadInfo, writableDatabase) <= 0) {
                        ContentValues contentValues = new ContentValues();
                        DownloadInfo.writeToContentValues(contentValues, downloadInfo);
                        writableDatabase.insert(TABLE_NAME, null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            } finally {
                writableDatabase.endTransaction();
                AppMethodBeat.o(76196);
            }
            return;
        }
        AppMethodBeat.o(76196);
    }

    public static void add(DownloadInfo downloadInfo) {
        AppMethodBeat.i(76197);
        if (downloadInfo != null) {
            try {
                SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
                if (update(downloadInfo, writableDatabase) <= 0) {
                    ContentValues contentValues = new ContentValues();
                    DownloadInfo.writeToContentValues(contentValues, downloadInfo);
                    writableDatabase.insert(TABLE_NAME, null, contentValues);
                }
                AppMethodBeat.o(76197);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(76197);
    }

    public static void del(String str) {
        AppMethodBeat.i(76198);
        if (str != null && str.length() > 0) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "taskUrl = ?", new String[]{str});
                AppMethodBeat.o(76198);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(76198);
    }

    private static int update(DownloadInfo downloadInfo, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(76199);
        if (downloadInfo == null) {
            AppMethodBeat.o(76199);
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            DownloadInfo.writeToContentValues(contentValues, downloadInfo);
            int update = sQLiteDatabase.update(TABLE_NAME, contentValues, "taskUrl = ?", new String[]{downloadInfo.mURL});
            if (update > 0) {
                AppMethodBeat.o(76199);
                return update;
            }
            AppMethodBeat.o(76199);
            return 0;
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(76199);
            return -2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static DownloadInfo query(String str) {
        Throwable e;
        DownloadInfo downloadInfo = null;
        AppMethodBeat.i(76200);
        if (str != null && str.length() > 0) {
            Cursor rawQuery;
            try {
                rawQuery = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery(QUERY_DOWNLOADINFO_URL, new String[]{str});
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToFirst()) {
                            downloadInfo = DownloadInfo.readFromCursor(rawQuery);
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.o(76200);
                            return downloadInfo;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace(TAG, e, "", new Object[0]);
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.o(76200);
                            return downloadInfo;
                        } catch (Throwable th) {
                            e = th;
                            if (rawQuery != null) {
                            }
                            AppMethodBeat.o(76200);
                            throw e;
                        }
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e3) {
                e = e3;
                rawQuery = null;
            } catch (Throwable th2) {
                e = th2;
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(76200);
                throw e;
            }
        }
        AppMethodBeat.o(76200);
        return downloadInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ArrayList<ServiceDownloadTask> query() {
        Cursor cursor = null;
        AppMethodBeat.i(76201);
        ArrayList arrayList = new ArrayList();
        try {
            cursor = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery(QUERY_UNFINISHED_TASK, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(76201);
                return arrayList;
            }
            do {
                String string = cursor.getString(cursor.getColumnIndex(Columns.CLIENTID));
                String string2 = cursor.getString(cursor.getColumnIndex("taskUrl"));
                int i = cursor.getInt(cursor.getColumnIndex("status"));
                ServiceDownloadTask serviceDownloadTask = new ServiceDownloadTask(string, string2);
                serviceDownloadTask.mState = i;
                arrayList.add(serviceDownloadTask);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(76201);
            return arrayList;
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(76201);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(76201);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Cursor cursor = null;
        AppMethodBeat.i(76202);
        if (!(sQLiteDatabase2 == null || sQLiteDatabase == null)) {
            sQLiteDatabase2.beginTransaction();
            try {
                cursor = sQLiteDatabase.rawQuery(QUERY_ALL, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                } else {
                    TMLog.i(TABLE_NAME, "start move data!");
                    do {
                        ContentValues contentValues = new ContentValues();
                        DownloadInfo.writeToContentValues(contentValues, DownloadInfo.readFromSimpleCursor(cursor));
                        sQLiteDatabase2.insert(TABLE_NAME, null, contentValues);
                    } while (cursor.moveToNext());
                    if (cursor != null) {
                    }
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                }
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
                TMLog.i(TABLE_NAME, "move data exception!");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(76202);
            }
        }
        AppMethodBeat.o(76202);
    }
}
