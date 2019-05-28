package com.tencent.tmassistantsdk.storage.table;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;

public interface ITableBase {
    String createTableSQL();

    void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2);

    String[] getAlterSQL(int i, int i2);

    SqliteHelper getHelper();

    String tableName();
}
