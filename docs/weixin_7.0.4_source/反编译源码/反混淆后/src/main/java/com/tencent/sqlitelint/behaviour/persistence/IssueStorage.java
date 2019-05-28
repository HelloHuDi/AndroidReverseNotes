package com.tencent.sqlitelint.behaviour.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.ArrayList;
import java.util.List;

public class IssueStorage {
    public static final String COLUMN_ADVICE = "advice";
    public static final String COLUMN_CREATE_TIME = "createTime";
    public static final String COLUMN_DB_PATH = "dbPath";
    public static final String COLUMN_DESC = "desc";
    public static final String COLUMN_DETAIL = "detail";
    public static final String COLUMN_EXT_INFO = "extInfo";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_SQL_TIME_COST = "sqlTimeCost";
    public static final String[] DB_VERSION_1_CREATE_INDEX;
    public static final String DB_VERSION_1_CREATE_SQL = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT PRIMARY KEY NOT NULL, %s TEXT NOT NULL, %s INTEGER, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s TEXT, %s INTEGER)", new Object[]{TABLE_NAME, "id", "dbPath", "level", "desc", "detail", "advice", "createTime", COLUMN_EXT_INFO, "sqlTimeCost"});
    public static final String TABLE_NAME = "Issue";
    private static final String TAG = "SQLiteLint.IssueStorage";
    private static SQLiteStatement sInsertAllSqlStatement;

    static {
        AppMethodBeat.m2504i(94077);
        r0 = new String[2];
        r0[0] = String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s)", new Object[]{"DbLabel_Index", TABLE_NAME, "dbPath"});
        r0[1] = String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s,%s)", new Object[]{"DbLabel_CreateTime_Index", TABLE_NAME, "dbPath", "createTime"});
        DB_VERSION_1_CREATE_INDEX = r0;
        AppMethodBeat.m2505o(94077);
    }

    public static boolean saveIssue(SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.m2504i(94067);
        if (hasIssue(sQLiteLintIssue.f1435id)) {
            SLog.m8893i(TAG, "saveIssue already recorded id=%s", sQLiteLintIssue.f1435id);
            AppMethodBeat.m2505o(94067);
            return false;
        }
        boolean doInsertIssue = doInsertIssue(sQLiteLintIssue);
        AppMethodBeat.m2505o(94067);
        return doInsertIssue;
    }

    public static void saveIssues(List<SQLiteLintIssue> list) {
        AppMethodBeat.m2504i(94068);
        SQLiteLintDbHelper.INSTANCE.getDatabase().beginTransaction();
        int i = 0;
        while (i < list.size()) {
            try {
                saveIssue((SQLiteLintIssue) list.get(i));
                i++;
            } finally {
                SQLiteLintDbHelper.INSTANCE.getDatabase().endTransaction();
                AppMethodBeat.m2505o(94068);
            }
        }
        SQLiteLintDbHelper.INSTANCE.getDatabase().setTransactionSuccessful();
    }

    public static boolean hasIssue(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(94069);
        Cursor rawQuery = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(String.format("SELECT %s FROM %s WHERE %s='%s' limit 1", new Object[]{"id", TABLE_NAME, "id", str}), null);
        try {
            if (rawQuery.getCount() <= 0) {
                z = false;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(94069);
            return z;
        } catch (Throwable th) {
            rawQuery.close();
            AppMethodBeat.m2505o(94069);
        }
    }

    private static boolean doInsertIssue(SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.m2504i(94070);
        SQLiteStatement insertAllSqlStatement = getInsertAllSqlStatement();
        insertAllSqlStatement.bindString(1, sQLiteLintIssue.f1435id);
        insertAllSqlStatement.bindString(2, sQLiteLintIssue.dbPath);
        insertAllSqlStatement.bindLong(3, (long) sQLiteLintIssue.level);
        insertAllSqlStatement.bindString(4, SQLiteLintUtil.nullAsNil(sQLiteLintIssue.desc));
        insertAllSqlStatement.bindString(5, SQLiteLintUtil.nullAsNil(sQLiteLintIssue.detail));
        insertAllSqlStatement.bindString(6, SQLiteLintUtil.nullAsNil(sQLiteLintIssue.advice));
        insertAllSqlStatement.bindLong(7, sQLiteLintIssue.createTime);
        insertAllSqlStatement.bindString(8, sQLiteLintIssue.extInfo);
        insertAllSqlStatement.bindLong(9, sQLiteLintIssue.sqlTimeCost);
        SLog.m8891d(TAG, "saveIssue insert ret=%s, id=%s", Long.valueOf(insertAllSqlStatement.executeInsert()), sQLiteLintIssue.f1435id);
        if (insertAllSqlStatement.executeInsert() == -1) {
            SLog.m8892e(TAG, "addIssue failed", new Object[0]);
            AppMethodBeat.m2505o(94070);
            return false;
        }
        AppMethodBeat.m2505o(94070);
        return true;
    }

    public static List<SQLiteLintIssue> getIssueListByDb(String str) {
        AppMethodBeat.m2504i(94071);
        List<SQLiteLintIssue> arrayList = new ArrayList();
        if (SQLiteLintUtil.isNullOrNil(str)) {
            AppMethodBeat.m2505o(94071);
        } else {
            Cursor rawQuery = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(String.format("SELECT * FROM %s where %s='%s' ORDER BY %s DESC", new Object[]{TABLE_NAME, "dbPath", str, "createTime"}), null);
            while (rawQuery.moveToNext()) {
                try {
                    arrayList.add(issueConvertFromCursor(rawQuery));
                } finally {
                    rawQuery.close();
                    AppMethodBeat.m2505o(94071);
                }
            }
        }
        return arrayList;
    }

    public static List<String> getDbPathList() {
        AppMethodBeat.m2504i(94072);
        List<String> arrayList = new ArrayList();
        Cursor rawQuery = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(String.format("SELECT DISTINCT(%s) FROM %s", new Object[]{"dbPath", TABLE_NAME}), null);
        while (rawQuery.moveToNext()) {
            try {
                arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("dbPath")));
            } finally {
                rawQuery.close();
                AppMethodBeat.m2505o(94072);
            }
        }
        return arrayList;
    }

    public static long getLastRowId() {
        AppMethodBeat.m2504i(94073);
        Cursor rawQuery = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(String.format("SELECT rowid FROM %s order by rowid desc limit 1", new Object[]{TABLE_NAME}), null);
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToFirst();
                    long j = rawQuery.getLong(0);
                    return j;
                }
            } finally {
                rawQuery.close();
                AppMethodBeat.m2505o(94073);
            }
        }
        rawQuery.close();
        AppMethodBeat.m2505o(94073);
        return -1;
    }

    public static void clearData() {
        AppMethodBeat.m2504i(94074);
        SQLiteLintDbHelper.INSTANCE.getDatabase().execSQL(String.format("delete from %s", new Object[]{TABLE_NAME}));
        AppMethodBeat.m2505o(94074);
    }

    private static SQLiteStatement getInsertAllSqlStatement() {
        AppMethodBeat.m2504i(94075);
        if (sInsertAllSqlStatement == null) {
            sInsertAllSqlStatement = SQLiteLintDbHelper.INSTANCE.getDatabase().compileStatement(String.format("INSERT INTO %s VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{TABLE_NAME}));
        }
        SQLiteStatement sQLiteStatement = sInsertAllSqlStatement;
        AppMethodBeat.m2505o(94075);
        return sQLiteStatement;
    }

    private static SQLiteLintIssue issueConvertFromCursor(Cursor cursor) {
        AppMethodBeat.m2504i(94076);
        SQLiteLintIssue sQLiteLintIssue = new SQLiteLintIssue();
        sQLiteLintIssue.f1435id = cursor.getString(cursor.getColumnIndex("id"));
        sQLiteLintIssue.dbPath = cursor.getString(cursor.getColumnIndex("dbPath"));
        sQLiteLintIssue.level = cursor.getInt(cursor.getColumnIndex("level"));
        sQLiteLintIssue.desc = cursor.getString(cursor.getColumnIndex("desc"));
        sQLiteLintIssue.detail = cursor.getString(cursor.getColumnIndex("detail"));
        sQLiteLintIssue.advice = cursor.getString(cursor.getColumnIndex("advice"));
        sQLiteLintIssue.createTime = cursor.getLong(cursor.getColumnIndex("createTime"));
        sQLiteLintIssue.extInfo = cursor.getString(cursor.getColumnIndex(COLUMN_EXT_INFO));
        sQLiteLintIssue.sqlTimeCost = cursor.getLong(cursor.getColumnIndex("sqlTimeCost"));
        AppMethodBeat.m2505o(94076);
        return sQLiteLintIssue;
    }
}
