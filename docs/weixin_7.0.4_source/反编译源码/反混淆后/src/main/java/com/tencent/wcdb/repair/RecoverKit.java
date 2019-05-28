package com.tencent.wcdb.repair;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;

public class RecoverKit implements OnCancelListener {
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "WCDB.DBBackup";
    private SQLiteDatabase mDB;
    private int mFailedCount;
    private String mLastError = null;
    private long mNativePtr;
    private int mSuccessCount;

    private static native void nativeCancel(long j);

    private static native int nativeFailureCount(long j);

    private static native void nativeFinish(long j);

    private static native long nativeInit(String str, byte[] bArr);

    private static native String nativeLastError(long j);

    private static native int nativeRun(long j, long j2, boolean z);

    private static native int nativeSuccessCount(long j);

    public RecoverKit(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
        AppMethodBeat.m2504i(12654);
        this.mDB = sQLiteDatabase;
        this.mNativePtr = nativeInit(str, bArr);
        if (this.mNativePtr == 0) {
            SQLiteException sQLiteException = new SQLiteException("Failed initialize recover context.");
            AppMethodBeat.m2505o(12654);
            throw sQLiteException;
        }
        AppMethodBeat.m2505o(12654);
    }

    public int run(boolean z) {
        AppMethodBeat.m2504i(12655);
        if (this.mNativePtr == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("RecoverKit not initialized.");
            AppMethodBeat.m2505o(12655);
            throw illegalStateException;
        }
        long acquireNativeConnectionHandle = this.mDB.acquireNativeConnectionHandle("recover", false, false);
        int nativeRun = nativeRun(this.mNativePtr, acquireNativeConnectionHandle, z);
        this.mDB.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mSuccessCount = nativeSuccessCount(this.mNativePtr);
        this.mFailedCount = nativeFailureCount(this.mNativePtr);
        this.mLastError = nativeLastError(this.mNativePtr);
        nativeFinish(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.m2505o(12655);
        return nativeRun;
    }

    public int run(boolean z, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12656);
        if (cancellationSignal.isCanceled()) {
            AppMethodBeat.m2505o(12656);
            return 1;
        }
        cancellationSignal.setOnCancelListener(this);
        int run = run(z);
        cancellationSignal.setOnCancelListener(null);
        AppMethodBeat.m2505o(12656);
        return run;
    }

    public int successCount() {
        return this.mSuccessCount;
    }

    public int failureCount() {
        return this.mFailedCount;
    }

    public void onCancel() {
        AppMethodBeat.m2504i(12657);
        if (this.mNativePtr != 0) {
            nativeCancel(this.mNativePtr);
        }
        AppMethodBeat.m2505o(12657);
    }

    public String lastError() {
        return this.mLastError;
    }

    public void release() {
        AppMethodBeat.m2504i(12658);
        if (this.mNativePtr != 0) {
            nativeFinish(this.mNativePtr);
            this.mNativePtr = 0;
        }
        AppMethodBeat.m2505o(12658);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(12659);
        release();
        super.finalize();
        AppMethodBeat.m2505o(12659);
    }
}
