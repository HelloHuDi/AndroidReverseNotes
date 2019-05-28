package com.tencent.wcdb.database;

import com.tencent.wcdb.SQLException;

public class SQLiteException extends SQLException {
    public SQLiteException(String str) {
        super(str);
    }

    public SQLiteException(String str, Throwable th) {
        super(str, th);
    }
}
