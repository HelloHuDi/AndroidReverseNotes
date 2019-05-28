package com.tencent.wcdb.database;

public class SQLiteDatabaseCorruptException extends SQLiteException {
    public SQLiteDatabaseCorruptException(String str) {
        super(str);
    }
}
