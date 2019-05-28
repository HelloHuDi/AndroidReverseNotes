package com.tencent.wcdb.database;

import java.util.List;

public interface SQLiteTrace {

    public static class TraceInfo<T> {
        public final T info;
        public final int tid;
        public final long time;

        TraceInfo(T t, long j, int i) {
            this.info = t;
            this.time = j;
            this.tid = i;
        }
    }

    void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z);

    void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z, List<TraceInfo<String>> list, List<TraceInfo<StackTraceElement[]>> list2);

    void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase);

    void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j);
}
