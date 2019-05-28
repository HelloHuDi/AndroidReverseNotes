package com.tencent.wcdb.database;

public class SQLiteTableLockedException extends SQLiteException {
    public SQLiteTableLockedException(String str) {
        super(str);
    }
}
