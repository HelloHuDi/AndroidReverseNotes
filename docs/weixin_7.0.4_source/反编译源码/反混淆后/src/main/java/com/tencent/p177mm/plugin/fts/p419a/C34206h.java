package com.tencent.p177mm.plugin.fts.p419a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;

/* renamed from: com.tencent.mm.plugin.fts.a.h */
public interface C34206h {
    /* renamed from: J */
    long mo54777J(long j, long j2);

    /* renamed from: K */
    void mo54778K(long j, long j2);

    /* renamed from: MS */
    Cursor mo54779MS(String str);

    /* renamed from: MT */
    boolean mo54780MT(String str);

    void beginTransaction();

    void commit();

    SQLiteStatement compileStatement(String str);

    /* renamed from: ei */
    boolean mo54784ei(int i, int i2);

    void execSQL(String str);

    void execSQL(String str, Object[] objArr);

    boolean inTransaction();

    Cursor rawQuery(String str, String[] strArr);
}
