package com.tencent.wcdb.database;

public class SQLiteDoneException extends SQLiteException {
    public SQLiteDoneException(String str) {
        super(str);
    }
}
