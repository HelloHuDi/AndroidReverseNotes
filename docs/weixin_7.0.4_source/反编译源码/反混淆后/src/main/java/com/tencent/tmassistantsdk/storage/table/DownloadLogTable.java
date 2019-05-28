package com.tencent.tmassistantsdk.storage.table;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadLogTable extends BaseLogTable {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists downloadLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    protected static final String SQL_INSERT = "INSERT INTO downloadLogData logData = ?";
    public static final String TABLE_NAME = "downloadLogData";
    protected static DownloadLogTable mInstance = null;

    public static synchronized DownloadLogTable getInstance() {
        DownloadLogTable downloadLogTable;
        synchronized (DownloadLogTable.class) {
            AppMethodBeat.m2504i(76203);
            if (mInstance == null) {
                mInstance = new DownloadLogTable();
            }
            downloadLogTable = mInstance;
            AppMethodBeat.m2505o(76203);
        }
        return downloadLogTable;
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
        AppMethodBeat.m2504i(76204);
        String[] strArr = new String[]{getCreateTableSQL()};
        AppMethodBeat.m2505o(76204);
        return strArr;
    }
}
