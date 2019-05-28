package com.tencent.wcdb;

import com.tencent.wcdb.database.SQLiteDatabase;

public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase sQLiteDatabase);
}
