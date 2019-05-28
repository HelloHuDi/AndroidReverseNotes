package com.tencent.wcdb.database;

public class SQLiteReadOnlyDatabaseException extends SQLiteException {
    public SQLiteReadOnlyDatabaseException(String str) {
        super(str);
    }
}
