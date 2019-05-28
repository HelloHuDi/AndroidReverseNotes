package com.tencent.wcdb.database;

public class SQLiteDatabaseLockedException extends SQLiteException {
    public SQLiteDatabaseLockedException(String str) {
        super(str);
    }
}
