package com.tencent.tmassistantsdk.storage.table;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TipsInfoLogTable extends BaseLogTable {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists TipsInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    protected static final String SQL_INSERT = "INSERT INTO TipsInfoLogData logData = ?";
    public static final String TABLE_NAME = "TipsInfoLogData";
    protected static TipsInfoLogTable mInstance = null;

    public static synchronized TipsInfoLogTable getInstance() {
        TipsInfoLogTable tipsInfoLogTable;
        synchronized (TipsInfoLogTable.class) {
            AppMethodBeat.m2504i(76209);
            if (mInstance == null) {
                mInstance = new TipsInfoLogTable();
            }
            tipsInfoLogTable = mInstance;
            AppMethodBeat.m2505o(76209);
        }
        return tipsInfoLogTable;
    }

    /* Access modifiers changed, original: protected */
    public String getTableName() {
        return TABLE_NAME;
    }

    /* Access modifiers changed, original: protected */
    public String getCreateTableSQL() {
        return CREATE_TABLE_SQL;
    }

    /* Access modifiers changed, original: protected */
    public String getInsertSQL() {
        return SQL_INSERT;
    }

    /* Access modifiers changed, original: protected */
    public String[] getAlterSQL(int i) {
        AppMethodBeat.m2504i(76210);
        if (i > 1) {
            String[] strArr = new String[]{getCreateTableSQL()};
            AppMethodBeat.m2505o(76210);
            return strArr;
        }
        AppMethodBeat.m2505o(76210);
        return null;
    }
}
