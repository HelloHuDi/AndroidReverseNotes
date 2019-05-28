package com.tencent.p177mm.sdk.p603e;

import android.content.ContentValues;
import android.database.Cursor;

/* renamed from: com.tencent.mm.sdk.e.e */
public interface C4927e {
    /* renamed from: a */
    Cursor mo10104a(String str, String[] strArr, int i);

    /* renamed from: a */
    Cursor mo10105a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i);

    int delete(String str, String str2, String[] strArr);

    boolean dpU();

    /* renamed from: hY */
    boolean mo10108hY(String str, String str2);

    long insert(String str, String str2, ContentValues contentValues);

    Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5);

    Cursor rawQuery(String str, String[] strArr);

    long replace(String str, String str2, ContentValues contentValues);

    int update(String str, ContentValues contentValues, String str2, String[] strArr);
}
