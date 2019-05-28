package com.tencent.wcdb.repair;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;

public class RepairKit implements OnCancelListener {
    public static final int FLAG_ALL_TABLES = 2;
    public static final int FLAG_NO_CREATE_TABLES = 1;
    private static final int INTEGRITY_DATA = 2;
    private static final int INTEGRITY_HEADER = 1;
    private static final int INTEGRITY_KDF_SALT = 4;
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_IGNORE = 2;
    public static final int RESULT_OK = 0;
    private Callback mCallback;
    private RepairCursor mCurrentCursor;
    private int mIntegrityFlags;
    private MasterInfo mMasterInfo;
    private long mNativePtr;

    public interface Callback {
        int onProgress(String str, int i, Cursor cursor);
    }

    public static class MasterInfo {
        private byte[] mKDFSalt;
        private long mMasterPtr;

        private MasterInfo(long j, byte[] bArr) {
            this.mMasterPtr = j;
            this.mKDFSalt = bArr;
        }

        public static MasterInfo make(String[] strArr) {
            AppMethodBeat.m2504i(12660);
            long access$300 = RepairKit.access$300(strArr);
            if (access$300 == 0) {
                SQLiteException sQLiteException = new SQLiteException("Cannot create MasterInfo.");
                AppMethodBeat.m2505o(12660);
                throw sQLiteException;
            }
            MasterInfo masterInfo = new MasterInfo(access$300, null);
            AppMethodBeat.m2505o(12660);
            return masterInfo;
        }

        public static MasterInfo load(String str, byte[] bArr, String[] strArr) {
            AppMethodBeat.m2504i(12661);
            MasterInfo make;
            if (str == null) {
                make = make(strArr);
                AppMethodBeat.m2505o(12661);
                return make;
            }
            byte[] bArr2 = new byte[16];
            long access$400 = RepairKit.access$400(str, bArr, strArr, bArr2);
            if (access$400 == 0) {
                SQLiteException sQLiteException = new SQLiteException("Cannot create MasterInfo.");
                AppMethodBeat.m2505o(12661);
                throw sQLiteException;
            }
            make = new MasterInfo(access$400, bArr2);
            AppMethodBeat.m2505o(12661);
            return make;
        }

        public static boolean save(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
            AppMethodBeat.m2504i(12662);
            long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("backupMaster", true, false);
            boolean access$500 = RepairKit.access$500(acquireNativeConnectionHandle, str, bArr);
            sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
            AppMethodBeat.m2505o(12662);
            return access$500;
        }

        public void release() {
            AppMethodBeat.m2504i(12663);
            if (this.mMasterPtr == 0) {
                AppMethodBeat.m2505o(12663);
                return;
            }
            RepairKit.access$600(this.mMasterPtr);
            this.mMasterPtr = 0;
            AppMethodBeat.m2505o(12663);
        }

        /* Access modifiers changed, original: protected */
        public void finalize() {
            AppMethodBeat.m2504i(12664);
            release();
            super.finalize();
            AppMethodBeat.m2505o(12664);
        }
    }

    static class RepairCursor extends AbstractCursor {
        long mPtr;

        private static native byte[] nativeGetBlob(long j, int i);

        private static native int nativeGetColumnCount(long j);

        private static native double nativeGetDouble(long j, int i);

        private static native long nativeGetLong(long j, int i);

        private static native String nativeGetString(long j, int i);

        private static native int nativeGetType(long j, int i);

        private RepairCursor() {
        }

        public int getCount() {
            AppMethodBeat.m2504i(12665);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(12665);
            throw unsupportedOperationException;
        }

        public String[] getColumnNames() {
            AppMethodBeat.m2504i(12666);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(12666);
            throw unsupportedOperationException;
        }

        public int getColumnCount() {
            AppMethodBeat.m2504i(12667);
            int nativeGetColumnCount = nativeGetColumnCount(this.mPtr);
            AppMethodBeat.m2505o(12667);
            return nativeGetColumnCount;
        }

        public int getType(int i) {
            AppMethodBeat.m2504i(12668);
            int nativeGetType = nativeGetType(this.mPtr, i);
            AppMethodBeat.m2505o(12668);
            return nativeGetType;
        }

        public String getString(int i) {
            AppMethodBeat.m2504i(12669);
            String nativeGetString = nativeGetString(this.mPtr, i);
            AppMethodBeat.m2505o(12669);
            return nativeGetString;
        }

        public short getShort(int i) {
            AppMethodBeat.m2504i(12670);
            short s = (short) ((int) getLong(i));
            AppMethodBeat.m2505o(12670);
            return s;
        }

        public int getInt(int i) {
            AppMethodBeat.m2504i(12671);
            int i2 = (int) getLong(i);
            AppMethodBeat.m2505o(12671);
            return i2;
        }

        public long getLong(int i) {
            AppMethodBeat.m2504i(12672);
            long nativeGetLong = nativeGetLong(this.mPtr, i);
            AppMethodBeat.m2505o(12672);
            return nativeGetLong;
        }

        public float getFloat(int i) {
            AppMethodBeat.m2504i(12673);
            float f = (float) getDouble(i);
            AppMethodBeat.m2505o(12673);
            return f;
        }

        public double getDouble(int i) {
            AppMethodBeat.m2504i(12674);
            double nativeGetDouble = nativeGetDouble(this.mPtr, i);
            AppMethodBeat.m2505o(12674);
            return nativeGetDouble;
        }

        public byte[] getBlob(int i) {
            AppMethodBeat.m2504i(12675);
            byte[] nativeGetBlob = nativeGetBlob(this.mPtr, i);
            AppMethodBeat.m2505o(12675);
            return nativeGetBlob;
        }

        public boolean isNull(int i) {
            AppMethodBeat.m2504i(12676);
            if (getType(i) == 0) {
                AppMethodBeat.m2505o(12676);
                return true;
            }
            AppMethodBeat.m2505o(12676);
            return false;
        }
    }

    private static native void nativeCancel(long j);

    private static native void nativeFini(long j);

    private static native void nativeFreeMaster(long j);

    private static native long nativeInit(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, byte[] bArr2);

    private static native int nativeIntegrityFlags(long j);

    private static native String nativeLastError();

    private static native long nativeLoadMaster(String str, byte[] bArr, String[] strArr, byte[] bArr2);

    private static native long nativeMakeMaster(String[] strArr);

    private native int nativeOutput(long j, long j2, long j3, int i);

    private static native boolean nativeSaveMaster(long j, String str, byte[] bArr);

    static /* synthetic */ long access$300(String[] strArr) {
        AppMethodBeat.m2504i(12685);
        long nativeMakeMaster = nativeMakeMaster(strArr);
        AppMethodBeat.m2505o(12685);
        return nativeMakeMaster;
    }

    static /* synthetic */ long access$400(String str, byte[] bArr, String[] strArr, byte[] bArr2) {
        AppMethodBeat.m2504i(12686);
        long nativeLoadMaster = nativeLoadMaster(str, bArr, strArr, bArr2);
        AppMethodBeat.m2505o(12686);
        return nativeLoadMaster;
    }

    static /* synthetic */ boolean access$500(long j, String str, byte[] bArr) {
        AppMethodBeat.m2504i(12687);
        boolean nativeSaveMaster = nativeSaveMaster(j, str, bArr);
        AppMethodBeat.m2505o(12687);
        return nativeSaveMaster;
    }

    static /* synthetic */ void access$600(long j) {
        AppMethodBeat.m2504i(12688);
        nativeFreeMaster(j);
        AppMethodBeat.m2505o(12688);
    }

    public RepairKit(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, MasterInfo masterInfo) {
        AppMethodBeat.m2504i(12677);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(12677);
            throw illegalArgumentException;
        }
        this.mNativePtr = nativeInit(str, bArr, sQLiteCipherSpec, masterInfo == null ? null : masterInfo.mKDFSalt);
        if (this.mNativePtr == 0) {
            SQLiteException sQLiteException = new SQLiteException("Failed initialize RepairKit.");
            AppMethodBeat.m2505o(12677);
            throw sQLiteException;
        }
        this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        this.mMasterInfo = masterInfo;
        AppMethodBeat.m2505o(12677);
    }

    public Callback getCallback() {
        return this.mCallback;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void release() {
        AppMethodBeat.m2504i(12678);
        if (this.mMasterInfo != null) {
            this.mMasterInfo.release();
            this.mMasterInfo = null;
        }
        if (this.mNativePtr != 0) {
            nativeFini(this.mNativePtr);
            this.mNativePtr = 0;
        }
        AppMethodBeat.m2505o(12678);
    }

    public int output(SQLiteDatabase sQLiteDatabase, int i) {
        long j = 0;
        AppMethodBeat.m2504i(12679);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(12679);
            throw illegalArgumentException;
        }
        if (this.mMasterInfo != null) {
            j = this.mMasterInfo.mMasterPtr;
        }
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("repair", false, false);
        int nativeOutput = nativeOutput(this.mNativePtr, acquireNativeConnectionHandle, j, i);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mCurrentCursor = null;
        this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        AppMethodBeat.m2505o(12679);
        return nativeOutput;
    }

    public int output(SQLiteDatabase sQLiteDatabase, int i, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12680);
        if (cancellationSignal.isCanceled()) {
            AppMethodBeat.m2505o(12680);
            return 1;
        }
        cancellationSignal.setOnCancelListener(this);
        int output = output(sQLiteDatabase, i);
        cancellationSignal.setOnCancelListener(null);
        AppMethodBeat.m2505o(12680);
        return output;
    }

    public void onCancel() {
        AppMethodBeat.m2504i(12681);
        if (this.mNativePtr == 0) {
            AppMethodBeat.m2505o(12681);
            return;
        }
        nativeCancel(this.mNativePtr);
        AppMethodBeat.m2505o(12681);
    }

    private int onProgress(String str, int i, long j) {
        AppMethodBeat.m2504i(12682);
        if (this.mCallback == null) {
            AppMethodBeat.m2505o(12682);
            return 0;
        }
        if (this.mCurrentCursor == null) {
            this.mCurrentCursor = new RepairCursor();
        }
        this.mCurrentCursor.mPtr = j;
        int onProgress = this.mCallback.onProgress(str, i, this.mCurrentCursor);
        AppMethodBeat.m2505o(12682);
        return onProgress;
    }

    public boolean isSaltCorrupted() {
        return (this.mIntegrityFlags & 4) == 0;
    }

    public boolean isHeaderCorrupted() {
        return (this.mIntegrityFlags & 1) == 0;
    }

    public boolean isDataCorrupted() {
        return (this.mIntegrityFlags & 2) == 0;
    }

    public static String lastError() {
        AppMethodBeat.m2504i(12683);
        String nativeLastError = nativeLastError();
        AppMethodBeat.m2505o(12683);
        return nativeLastError;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(12684);
        release();
        super.finalize();
        AppMethodBeat.m2505o(12684);
    }
}
