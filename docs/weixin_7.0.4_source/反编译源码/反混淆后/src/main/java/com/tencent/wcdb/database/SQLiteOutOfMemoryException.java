package com.tencent.wcdb.database;

public class SQLiteOutOfMemoryException extends SQLiteException {
    public SQLiteOutOfMemoryException(String str) {
        super(str);
    }
}
