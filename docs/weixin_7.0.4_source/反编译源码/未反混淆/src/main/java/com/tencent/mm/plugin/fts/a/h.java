package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;

public interface h {
    long J(long j, long j2);

    void K(long j, long j2);

    Cursor MS(String str);

    boolean MT(String str);

    void beginTransaction();

    void commit();

    SQLiteStatement compileStatement(String str);

    boolean ei(int i, int i2);

    void execSQL(String str);

    void execSQL(String str, Object[] objArr);

    boolean inTransaction();

    Cursor rawQuery(String str, String[] strArr);
}
