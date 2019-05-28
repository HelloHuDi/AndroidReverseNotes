package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLogTable implements ITableBase {
    private static final String TAG = "BaseLogTable";

    public static class DataWrapper {
        public List<byte[]> dataList;
        public List<Long> idList;
    }

    public abstract String[] getAlterSQL(int i);

    public abstract String getCreateTableSQL();

    public abstract String getInsertSQL();

    public abstract String getTableName();

    public boolean save(byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("logData", bArr);
        return getHelper().getWritableDatabase().insert(getTableName(), null, contentValues) > 0;
    }

    public boolean save(List<byte[]> list) {
        String str = true;
        SQLiteDatabase writableDatabase = getHelper().getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            SQLiteStatement compileStatement = writableDatabase.compileStatement(getInsertSQL());
            for (byte[] bindBlob : list) {
                compileStatement.bindBlob(1, bindBlob);
                compileStatement.executeInsert();
            }
            writableDatabase.setTransactionSuccessful();
            return str;
        } catch (Exception e) {
            str = TAG;
            C4990ab.printErrStackTrace(str, e, "", new Object[0]);
            return false;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public boolean delete(List<Long> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer("(");
        for (Long append : list) {
            stringBuffer.append(append);
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append(")");
        getHelper().getWritableDatabase().delete(getTableName(), "_id in ".concat(String.valueOf(stringBuffer)), null);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DataWrapper getDatas(int i) {
        String concat;
        Throwable e;
        DataWrapper dataWrapper = new DataWrapper();
        dataWrapper.idList = new ArrayList();
        dataWrapper.dataList = new ArrayList();
        if (i > 0) {
            concat = "0,".concat(String.valueOf(i));
        } else {
            concat = null;
        }
        Cursor query;
        try {
            query = getHelper().getReadableDatabase().query(getTableName(), null, null, null, null, null, "_id asc", concat);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        do {
                            dataWrapper.idList.add(Long.valueOf(query.getLong(query.getColumnIndex("_id"))));
                            dataWrapper.dataList.add(query.getBlob(query.getColumnIndex("logData")));
                        } while (query.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                        if (query == null) {
                            return null;
                        }
                        query.close();
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            return dataWrapper;
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public String tableName() {
        return getTableName();
    }

    public String createTableSQL() {
        return getCreateTableSQL();
    }

    public String[] getAlterSQL(int i, int i2) {
        return getAlterSQL(i2);
    }

    public SqliteHelper getHelper() {
        return AstSDKDBHelper_V2.getInstance();
    }

    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
    }
}
