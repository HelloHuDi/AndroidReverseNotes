package com.tencent.wcdb.database;

public class SQLiteCantOpenDatabaseException extends SQLiteException {
    public SQLiteCantOpenDatabaseException(String str) {
        super(str);
    }
}
