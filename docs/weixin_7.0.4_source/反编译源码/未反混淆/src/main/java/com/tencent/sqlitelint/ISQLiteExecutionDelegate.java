package com.tencent.sqlitelint;

import android.database.Cursor;

public interface ISQLiteExecutionDelegate {
    void execSQL(String str);

    Cursor rawQuery(String str, String... strArr);
}
