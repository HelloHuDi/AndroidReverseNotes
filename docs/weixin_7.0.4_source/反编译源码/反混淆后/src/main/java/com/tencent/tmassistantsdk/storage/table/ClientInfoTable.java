package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import com.tencent.tmassistantsdk.storage.model.ClientInfo;
import java.util.ArrayList;

public class ClientInfoTable implements ITableBase {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
    public static final String QUERY_CLIENTINFO = "select * from clientinfo where clientId = ?";
    public static final String QUERY_CLIENTINFO_ALL = "select * from clientinfo";
    public static final String TABLE_NAME = "clientinfo";
    private static final String TAG = "ClientInfoTable";

    public class Columns {
        public static final String CLIENTID = "clientId";
        public static final String TASKID = "taskId";
        public static final String TASKURL = "taskUrl";
    }

    private static void fillValues(ContentValues contentValues, ClientInfo clientInfo) {
        AppMethodBeat.m2504i(76184);
        if (clientInfo != null) {
            contentValues.put(Columns.CLIENTID, clientInfo.clientId);
            contentValues.put("taskId", Integer.valueOf(clientInfo.taskId));
            contentValues.put("taskUrl", clientInfo.taskUrl);
        }
        AppMethodBeat.m2505o(76184);
    }

    private static ClientInfo cursor2object(Cursor cursor) {
        AppMethodBeat.m2504i(76185);
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.clientId = cursor.getString(cursor.getColumnIndex(Columns.CLIENTID));
        clientInfo.taskId = cursor.getInt(cursor.getColumnIndex("taskId"));
        clientInfo.taskUrl = cursor.getString(cursor.getColumnIndex("taskUrl"));
        AppMethodBeat.m2505o(76185);
        return clientInfo;
    }

    public static void save(ClientInfo clientInfo) {
        AppMethodBeat.m2504i(76186);
        if (clientInfo != null) {
            try {
                SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
                if (update(clientInfo, writableDatabase) <= 0) {
                    ContentValues contentValues = new ContentValues();
                    fillValues(contentValues, clientInfo);
                    writableDatabase.insert(TABLE_NAME, null, contentValues);
                }
                AppMethodBeat.m2505o(76186);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(76186);
    }

    public static void save(String str, String str2) {
        AppMethodBeat.m2504i(76187);
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.clientId = str;
        clientInfo.taskUrl = str2;
        save(clientInfo);
        AppMethodBeat.m2505o(76187);
    }

    private static int update(ClientInfo clientInfo, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(76188);
        if (clientInfo == null) {
            AppMethodBeat.m2505o(76188);
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            fillValues(contentValues, clientInfo);
            int update = sQLiteDatabase.update(TABLE_NAME, contentValues, "clientId = ? and taskUrl = ?", new String[]{clientInfo.clientId, clientInfo.taskUrl});
            if (update > 0) {
                AppMethodBeat.m2505o(76188);
                return update;
            }
            AppMethodBeat.m2505o(76188);
            return 0;
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(76188);
            return -2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ArrayList<ClientInfo> query(String str) {
        Throwable e;
        AppMethodBeat.m2504i(76189);
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase readableDatabase = AstSDKDBHelper_V2.getInstance().getReadableDatabase();
            Cursor rawQuery;
            try {
                rawQuery = readableDatabase.rawQuery(QUERY_CLIENTINFO, new String[]{str});
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToFirst()) {
                            do {
                                arrayList.add(cursor2object(rawQuery));
                            } while (rawQuery.moveToNext());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.m2505o(76189);
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.m2505o(76189);
                            throw e;
                        }
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(76189);
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                rawQuery = null;
            } catch (Throwable th2) {
                e = th2;
                rawQuery = null;
                if (rawQuery != null) {
                }
                AppMethodBeat.m2505o(76189);
                throw e;
            }
        }
        AppMethodBeat.m2505o(76189);
        return null;
    }

    public static void delete(String str, String str2) {
        AppMethodBeat.m2504i(76190);
        if (!(str == null || str2 == null)) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "clientId = ? and taskUrl = ?", new String[]{str, str2});
                AppMethodBeat.m2505o(76190);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(76190);
    }

    public static void deleteItemsByURL(String str) {
        AppMethodBeat.m2504i(76191);
        if (!TextUtils.isEmpty(str)) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "taskUrl = ?", new String[]{str});
                AppMethodBeat.m2505o(76191);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(76191);
    }

    public String tableName() {
        return TABLE_NAME;
    }

    public String createTableSQL() {
        return CREATE_TABLE_SQL;
    }

    public String[] getAlterSQL(int i, int i2) {
        return null;
    }

    public SqliteHelper getHelper() {
        AppMethodBeat.m2504i(76192);
        SqliteHelper instance = AstSDKDBHelper_V2.getInstance();
        AppMethodBeat.m2505o(76192);
        return instance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(76193);
        if (!(sQLiteDatabase2 == null || sQLiteDatabase == null)) {
            sQLiteDatabase2.beginTransaction();
            try {
                cursor = sQLiteDatabase.rawQuery(QUERY_CLIENTINFO_ALL, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                } else {
                    do {
                        ContentValues contentValues = new ContentValues();
                        fillValues(contentValues, cursor2object(cursor));
                        sQLiteDatabase2.insert(TABLE_NAME, null, contentValues);
                    } while (cursor.moveToNext());
                    if (cursor != null) {
                    }
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(76193);
            }
        }
        AppMethodBeat.m2505o(76193);
    }
}
