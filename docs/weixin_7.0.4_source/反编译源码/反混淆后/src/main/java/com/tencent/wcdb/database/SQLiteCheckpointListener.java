package com.tencent.wcdb.database;

public interface SQLiteCheckpointListener {
    void onAttach(SQLiteDatabase sQLiteDatabase);

    void onDetach(SQLiteDatabase sQLiteDatabase);

    void onWALCommit(SQLiteDatabase sQLiteDatabase, String str, int i);
}
