package com.tencent.wcdb.database;

public interface SQLiteChangeListener {
    void onChange(SQLiteDatabase sQLiteDatabase, String str, String str2, long[] jArr, long[] jArr2, long[] jArr3);
}
