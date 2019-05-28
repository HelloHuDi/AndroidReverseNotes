package com.tencent.tmassistantsdk.storage.table;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class UpdateInfoLogTable extends BaseLogTable {
    private static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists SelfUpdateInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    private static final String INSERT_SQL = "INSERT INTO SelfUpdateInfoLogData logData = ?";
    private static final String TABLE_NAME = "SelfUpdateInfoLogData";
    private static UpdateInfoLogTable mInstance = null;

    public static synchronized UpdateInfoLogTable getInstance() {
        UpdateInfoLogTable updateInfoLogTable;
        synchronized (UpdateInfoLogTable.class) {
            AppMethodBeat.i(76211);
            if (mInstance == null) {
                mInstance = new UpdateInfoLogTable();
            }
            updateInfoLogTable = mInstance;
            AppMethodBeat.o(76211);
        }
        return updateInfoLogTable;
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
        return INSERT_SQL;
    }

    /* Access modifiers changed, original: protected */
    public String[] getAlterSQL(int i) {
        AppMethodBeat.i(76212);
        if (i > 1) {
            String[] strArr = new String[]{getCreateTableSQL()};
            AppMethodBeat.o(76212);
            return strArr;
        }
        AppMethodBeat.o(76212);
        return null;
    }
}
