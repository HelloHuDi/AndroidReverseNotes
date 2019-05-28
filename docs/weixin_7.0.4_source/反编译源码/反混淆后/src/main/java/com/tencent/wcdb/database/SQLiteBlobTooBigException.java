package com.tencent.wcdb.database;

public class SQLiteBlobTooBigException extends SQLiteException {
    public SQLiteBlobTooBigException(String str) {
        super(str);
    }
}
