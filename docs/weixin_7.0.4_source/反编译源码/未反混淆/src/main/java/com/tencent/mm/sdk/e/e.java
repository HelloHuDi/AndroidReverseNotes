package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;

public interface e {
    Cursor a(String str, String[] strArr, int i);

    Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i);

    int delete(String str, String str2, String[] strArr);

    boolean dpU();

    boolean hY(String str, String str2);

    long insert(String str, String str2, ContentValues contentValues);

    Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5);

    Cursor rawQuery(String str, String[] strArr);

    long replace(String str, String str2, ContentValues contentValues);

    int update(String str, ContentValues contentValues, String str2, String[] strArr);
}
