package com.tencent.sqlitelint;

import android.database.Cursor;
import android.database.SQLException;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;
import java.util.ArrayList;

public class SQLiteLintNativeBridge {
    private static final String TAG = "SQLiteLint.SQLiteLintNativeBridge";

    private native void execSqlCallback(long j, long j2, String str, int i, String[] strArr, String[] strArr2);

    public static native void nativeAddToWhiteList(String str, String[] strArr, String[][] strArr2);

    public static native void nativeEnableCheckers(String str, String[] strArr);

    static native void nativeInstall(String str);

    static native void nativeNotifySqlExecute(String str, String str2, long j, String str3);

    static native void nativeUninstall(String str);

    public static void loadLibrary() {
        AppMethodBeat.i(94019);
        System.loadLibrary("SqliteLint-lib");
        SLog.nativeSetLogger(2);
        AppMethodBeat.o(94019);
    }

    SQLiteLintNativeBridge() {
    }

    private static void onPublishIssue(String str, ArrayList<SQLiteLintIssue> arrayList) {
        AppMethodBeat.i(94020);
        try {
            SQLiteLintAndroidCoreManager.INSTANCE.get(str).onPublish(arrayList);
            AppMethodBeat.o(94020);
        } catch (Throwable th) {
            SLog.e(TAG, "onPublishIssue ex ", th.getMessage());
            AppMethodBeat.o(94020);
        }
    }

    private String[] sqliteLintExecSql(String str, String str2, boolean z, long j, long j2) {
        AppMethodBeat.i(94021);
        String[] strArr = new String[2];
        try {
            SLog.i(TAG, "dbPath %s, sql is %s ,needCallBack: %b", str, str2, Boolean.valueOf(z));
            strArr[0] = "";
            strArr[1] = "-1";
            ISQLiteExecutionDelegate iSQLiteExecutionDelegate = null;
            SQLiteLintAndroidCore sQLiteLintAndroidCore = SQLiteLintAndroidCoreManager.INSTANCE.get(str);
            if (sQLiteLintAndroidCore != null) {
                iSQLiteExecutionDelegate = sQLiteLintAndroidCore.getSQLiteExecutionDelegate();
            }
            if (iSQLiteExecutionDelegate == null) {
                SLog.w(TAG, "sqliteLintExecSql mExecSqlImp is null", new Object[0]);
                AppMethodBeat.o(94021);
                return strArr;
            } else if (z) {
                Cursor rawQuery = iSQLiteExecutionDelegate.rawQuery(str2, new String[0]);
                if (rawQuery == null || rawQuery.getCount() < 0) {
                    SLog.w(TAG, "sqliteLintExecSql cu is null", new Object[0]);
                    strArr[0] = "Cursor is null";
                } else {
                    doExecSqlCallback(j, j2, str, rawQuery);
                    strArr[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(94021);
                return strArr;
            } else {
                try {
                    iSQLiteExecutionDelegate.execSQL(str2);
                    strArr[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } catch (SQLException e) {
                    SLog.w(TAG, "sqliteLintExecSql execSQL exp: %s", e.getMessage());
                    strArr[0] = e.getMessage();
                }
                AppMethodBeat.o(94021);
                return strArr;
            }
        } catch (Exception e2) {
            SLog.w(TAG, "sqliteLintExecSql rawQuery exp: %s", e2.getMessage());
            strArr[0] = e2.getMessage();
        } catch (Throwable th) {
            SLog.e(TAG, "sqliteLintExecSql ex ", th.getMessage());
        }
    }

    private void doExecSqlCallback(long j, long j2, String str, Cursor cursor) {
        AppMethodBeat.i(94022);
        if (cursor == null) {
            SLog.w(TAG, "doExecSqlCallback cu is null", new Object[0]);
            AppMethodBeat.o(94022);
            return;
        }
        while (cursor.moveToNext()) {
            int columnCount = cursor.getColumnCount();
            String[] strArr = new String[columnCount];
            String[] strArr2 = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                strArr[i] = cursor.getColumnName(i);
                switch (cursor.getType(i)) {
                    case 1:
                        strArr2[i] = String.valueOf(cursor.getLong(i));
                        break;
                    case 2:
                        strArr2[i] = String.valueOf(cursor.getFloat(i));
                        break;
                    case 3:
                        strArr2[i] = String.valueOf(cursor.getString(i));
                        break;
                    case 4:
                        strArr2[i] = String.valueOf(cursor.getBlob(i));
                        break;
                    default:
                        strArr2[i] = "";
                        break;
                }
            }
            execSqlCallback(j, j2, str, columnCount, strArr2, strArr);
        }
        AppMethodBeat.o(94022);
    }
}
