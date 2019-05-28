package com.tencent.wcdb.repair;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import java.util.Arrays;

public class BackupKit implements OnCancelListener {
    public static final int FLAG_FIX_CORRUPTION = 4;
    public static final int FLAG_INCREMENTAL = 16;
    public static final int FLAG_NO_CIPHER = 1;
    public static final int FLAG_NO_COMPRESS = 2;
    public static final int FLAG_NO_CREATE_TABLE = 8;
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "WCDB.DBBackup";
    private SQLiteDatabase mDB;
    private String mLastError = null;
    private long mNativePtr;
    private int mStatementCount;
    private String[] mTableDesc;

    private static native void nativeCancel(long j);

    private static native void nativeFinish(long j);

    private static native long nativeInit(String str, byte[] bArr, int i);

    private static native String nativeLastError(long j);

    private static native int nativeRun(long j, long j2, String[] strArr);

    private static native int nativeStatementCount(long j);

    public BackupKit(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, int i, String[] strArr) {
        String[] strArr2 = null;
        AppMethodBeat.m2504i(12642);
        this.mDB = sQLiteDatabase;
        if (strArr != null) {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.mTableDesc = strArr2;
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(12642);
            throw illegalArgumentException;
        }
        this.mNativePtr = nativeInit(str, bArr, i);
        if (this.mNativePtr == 0) {
            SQLiteException sQLiteException = new SQLiteException("Failed initialize backup context.");
            AppMethodBeat.m2505o(12642);
            throw sQLiteException;
        }
        AppMethodBeat.m2505o(12642);
    }

    public int run() {
        AppMethodBeat.m2504i(12643);
        if (this.mNativePtr == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("BackupKit not initialized.");
            AppMethodBeat.m2505o(12643);
            throw illegalStateException;
        }
        long acquireNativeConnectionHandle = this.mDB.acquireNativeConnectionHandle("backup", false, false);
        int nativeRun = nativeRun(this.mNativePtr, acquireNativeConnectionHandle, this.mTableDesc);
        this.mDB.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mStatementCount = nativeStatementCount(this.mNativePtr);
        this.mLastError = nativeLastError(this.mNativePtr);
        nativeFinish(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.m2505o(12643);
        return nativeRun;
    }

    public int run(CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12644);
        if (cancellationSignal.isCanceled()) {
            AppMethodBeat.m2505o(12644);
            return 1;
        }
        cancellationSignal.setOnCancelListener(this);
        int run = run();
        cancellationSignal.setOnCancelListener(null);
        AppMethodBeat.m2505o(12644);
        return run;
    }

    public int statementCount() {
        return this.mStatementCount;
    }

    public void onCancel() {
        AppMethodBeat.m2504i(12645);
        if (this.mNativePtr != 0) {
            nativeCancel(this.mNativePtr);
        }
        AppMethodBeat.m2505o(12645);
    }

    public String lastError() {
        return this.mLastError;
    }

    public void release() {
        AppMethodBeat.m2504i(12646);
        if (this.mNativePtr != 0) {
            nativeFinish(this.mNativePtr);
            this.mNativePtr = 0;
        }
        AppMethodBeat.m2505o(12646);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(12647);
        release();
        super.finalize();
        AppMethodBeat.m2505o(12647);
    }
}
