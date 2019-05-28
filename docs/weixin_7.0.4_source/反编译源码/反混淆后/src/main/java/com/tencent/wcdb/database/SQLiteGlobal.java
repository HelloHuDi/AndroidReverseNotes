package com.tencent.wcdb.database;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SQLiteGlobal {
    private static final String TAG = "WCDB.SQLiteGlobal";
    public static final String defaultJournalMode = "PERSIST";
    public static final int defaultPageSize;
    public static final String defaultSyncMode = "FULL";
    public static final int journalSizeLimit = 524288;
    public static final int walAutoCheckpoint = 100;
    public static final int walConnectionPoolSize = 4;
    public static final String walSyncMode = "FULL";

    private static native int nativeReleaseMemory();

    private static native void nativeSetDefaultCipherSettings(int i);

    static {
        int blockSize;
        AppMethodBeat.m2504i(12582);
        if (!WCDBInitializationProbe.libLoaded) {
            System.loadLibrary("wcdb");
        }
        try {
            blockSize = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();
        } catch (RuntimeException e) {
            blockSize = 4096;
        }
        defaultPageSize = blockSize;
        nativeSetDefaultCipherSettings(blockSize);
        AppMethodBeat.m2505o(12582);
    }

    public static void loadLib() {
    }

    private SQLiteGlobal() {
    }

    public static int releaseMemory() {
        AppMethodBeat.m2504i(12581);
        int nativeReleaseMemory = nativeReleaseMemory();
        AppMethodBeat.m2505o(12581);
        return nativeReleaseMemory;
    }
}
