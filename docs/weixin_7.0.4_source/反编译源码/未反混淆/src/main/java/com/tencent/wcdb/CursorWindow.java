package com.tencent.wcdb;

import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.database.SQLiteClosable;

public class CursorWindow extends SQLiteClosable implements Parcelable {
    public static final Creator<CursorWindow> CREATOR = new Creator<CursorWindow>() {
        public final CursorWindow createFromParcel(Parcel parcel) {
            AppMethodBeat.i(12021);
            CursorWindow cursorWindow = new CursorWindow(parcel, null);
            AppMethodBeat.o(12021);
            return cursorWindow;
        }

        public final CursorWindow[] newArray(int i) {
            return new CursorWindow[i];
        }
    };
    private static final String STATS_TAG = "WCDB.CursorWindowStats";
    private static int sCursorWindowSize;
    private final String mName;
    private int mStartPos;
    public long mWindowPtr;

    private static native boolean nativeAllocRow(long j);

    private static native void nativeClear(long j);

    private static native void nativeCopyStringToBuffer(long j, int i, int i2, CharArrayBuffer charArrayBuffer);

    private static native long nativeCreate(String str, int i);

    private static native void nativeDispose(long j);

    private static native void nativeFreeLastRow(long j);

    private static native byte[] nativeGetBlob(long j, int i, int i2);

    private static native double nativeGetDouble(long j, int i, int i2);

    private static native long nativeGetLong(long j, int i, int i2);

    private static native int nativeGetNumRows(long j);

    private static native String nativeGetString(long j, int i, int i2);

    private static native int nativeGetType(long j, int i, int i2);

    private static native boolean nativePutBlob(long j, byte[] bArr, int i, int i2);

    private static native boolean nativePutDouble(long j, double d, int i, int i2);

    private static native boolean nativePutLong(long j, long j2, int i, int i2);

    private static native boolean nativePutNull(long j, int i, int i2);

    private static native boolean nativePutString(long j, String str, int i, int i2);

    private static native boolean nativeSetNumColumns(long j, int i);

    /* synthetic */ CursorWindow(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(12056);
        int identifier = Resources.getSystem().getIdentifier("config_cursorWindowSize", "integer", "android");
        if (identifier != 0) {
            sCursorWindowSize = Resources.getSystem().getInteger(identifier) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        } else {
            sCursorWindowSize = 2097152;
        }
        AppMethodBeat.o(12056);
    }

    public static int windowSize(int i) {
        int i2 = sCursorWindowSize;
        if (i > 0) {
            sCursorWindowSize = i;
        }
        return i2;
    }

    public CursorWindow(String str) {
        AppMethodBeat.i(12024);
        this.mStartPos = 0;
        if (str == null || str.length() == 0) {
            str = "<unnamed>";
        }
        this.mName = str;
        this.mWindowPtr = nativeCreate(this.mName, sCursorWindowSize);
        if (this.mWindowPtr == 0) {
            CursorWindowAllocationException cursorWindowAllocationException = new CursorWindowAllocationException("Cursor window allocation of " + (sCursorWindowSize / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) + " kb failed. ");
            AppMethodBeat.o(12024);
            throw cursorWindowAllocationException;
        }
        AppMethodBeat.o(12024);
    }

    @Deprecated
    public CursorWindow(boolean z) {
        this(null);
    }

    private CursorWindow(Parcel parcel) {
        AppMethodBeat.i(12025);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(12025);
        throw unsupportedOperationException;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(12026);
        try {
            dispose();
        } finally {
            super.finalize();
            AppMethodBeat.o(12026);
        }
    }

    private void dispose() {
        AppMethodBeat.i(12027);
        if (this.mWindowPtr != 0) {
            nativeDispose(this.mWindowPtr);
            this.mWindowPtr = 0;
        }
        AppMethodBeat.o(12027);
    }

    public String getName() {
        return this.mName;
    }

    public void clear() {
        AppMethodBeat.i(12028);
        acquireReference();
        try {
            this.mStartPos = 0;
            nativeClear(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(12028);
        }
    }

    public int getStartPosition() {
        return this.mStartPos;
    }

    public void setStartPosition(int i) {
        this.mStartPos = i;
    }

    public int getNumRows() {
        AppMethodBeat.i(12029);
        acquireReference();
        try {
            int nativeGetNumRows = nativeGetNumRows(this.mWindowPtr);
            return nativeGetNumRows;
        } finally {
            releaseReference();
            AppMethodBeat.o(12029);
        }
    }

    public boolean setNumColumns(int i) {
        AppMethodBeat.i(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL);
        acquireReference();
        try {
            boolean nativeSetNumColumns = nativeSetNumColumns(this.mWindowPtr, i);
            return nativeSetNumColumns;
        } finally {
            releaseReference();
            AppMethodBeat.o(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL);
        }
    }

    public boolean allocRow() {
        AppMethodBeat.i(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_ALLADDRESS_FAILED);
        acquireReference();
        try {
            boolean nativeAllocRow = nativeAllocRow(this.mWindowPtr);
            return nativeAllocRow;
        } finally {
            releaseReference();
            AppMethodBeat.o(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_ALLADDRESS_FAILED);
        }
    }

    public void freeLastRow() {
        AppMethodBeat.i(12032);
        acquireReference();
        try {
            nativeFreeLastRow(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(12032);
        }
    }

    @Deprecated
    public boolean isNull(int i, int i2) {
        AppMethodBeat.i(12033);
        if (getType(i, i2) == 0) {
            AppMethodBeat.o(12033);
            return true;
        }
        AppMethodBeat.o(12033);
        return false;
    }

    @Deprecated
    public boolean isBlob(int i, int i2) {
        AppMethodBeat.i(12034);
        int type = getType(i, i2);
        if (type == 4 || type == 0) {
            AppMethodBeat.o(12034);
            return true;
        }
        AppMethodBeat.o(12034);
        return false;
    }

    @Deprecated
    public boolean isLong(int i, int i2) {
        AppMethodBeat.i(12035);
        if (getType(i, i2) == 1) {
            AppMethodBeat.o(12035);
            return true;
        }
        AppMethodBeat.o(12035);
        return false;
    }

    @Deprecated
    public boolean isFloat(int i, int i2) {
        AppMethodBeat.i(12036);
        if (getType(i, i2) == 2) {
            AppMethodBeat.o(12036);
            return true;
        }
        AppMethodBeat.o(12036);
        return false;
    }

    @Deprecated
    public boolean isString(int i, int i2) {
        AppMethodBeat.i(12037);
        int type = getType(i, i2);
        if (type == 3 || type == 0) {
            AppMethodBeat.o(12037);
            return true;
        }
        AppMethodBeat.o(12037);
        return false;
    }

    public int getType(int i, int i2) {
        AppMethodBeat.i(12038);
        acquireReference();
        try {
            int nativeGetType = nativeGetType(this.mWindowPtr, i - this.mStartPos, i2);
            return nativeGetType;
        } finally {
            releaseReference();
            AppMethodBeat.o(12038);
        }
    }

    public byte[] getBlob(int i, int i2) {
        AppMethodBeat.i(12039);
        acquireReference();
        try {
            byte[] nativeGetBlob = nativeGetBlob(this.mWindowPtr, i - this.mStartPos, i2);
            return nativeGetBlob;
        } finally {
            releaseReference();
            AppMethodBeat.o(12039);
        }
    }

    public String getString(int i, int i2) {
        AppMethodBeat.i(12040);
        acquireReference();
        try {
            String nativeGetString = nativeGetString(this.mWindowPtr, i - this.mStartPos, i2);
            return nativeGetString;
        } finally {
            releaseReference();
            AppMethodBeat.o(12040);
        }
    }

    public void copyStringToBuffer(int i, int i2, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(12041);
        if (charArrayBuffer == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("CharArrayBuffer should not be null");
            AppMethodBeat.o(12041);
            throw illegalArgumentException;
        }
        acquireReference();
        try {
            nativeCopyStringToBuffer(this.mWindowPtr, i - this.mStartPos, i2, charArrayBuffer);
        } finally {
            releaseReference();
            AppMethodBeat.o(12041);
        }
    }

    public long getLong(int i, int i2) {
        AppMethodBeat.i(12042);
        acquireReference();
        try {
            long nativeGetLong = nativeGetLong(this.mWindowPtr, i - this.mStartPos, i2);
            return nativeGetLong;
        } finally {
            releaseReference();
            AppMethodBeat.o(12042);
        }
    }

    public double getDouble(int i, int i2) {
        AppMethodBeat.i(12043);
        acquireReference();
        try {
            double nativeGetDouble = nativeGetDouble(this.mWindowPtr, i - this.mStartPos, i2);
            return nativeGetDouble;
        } finally {
            releaseReference();
            AppMethodBeat.o(12043);
        }
    }

    public short getShort(int i, int i2) {
        AppMethodBeat.i(12044);
        short s = (short) ((int) getLong(i, i2));
        AppMethodBeat.o(12044);
        return s;
    }

    public int getInt(int i, int i2) {
        AppMethodBeat.i(12045);
        int i3 = (int) getLong(i, i2);
        AppMethodBeat.o(12045);
        return i3;
    }

    public float getFloat(int i, int i2) {
        AppMethodBeat.i(12046);
        float f = (float) getDouble(i, i2);
        AppMethodBeat.o(12046);
        return f;
    }

    public boolean putBlob(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(12047);
        acquireReference();
        try {
            boolean nativePutBlob = nativePutBlob(this.mWindowPtr, bArr, i - this.mStartPos, i2);
            return nativePutBlob;
        } finally {
            releaseReference();
            AppMethodBeat.o(12047);
        }
    }

    public boolean putString(String str, int i, int i2) {
        AppMethodBeat.i(12048);
        acquireReference();
        try {
            boolean nativePutString = nativePutString(this.mWindowPtr, str, i - this.mStartPos, i2);
            return nativePutString;
        } finally {
            releaseReference();
            AppMethodBeat.o(12048);
        }
    }

    public boolean putLong(long j, int i, int i2) {
        AppMethodBeat.i(12049);
        acquireReference();
        try {
            boolean nativePutLong = nativePutLong(this.mWindowPtr, j, i - this.mStartPos, i2);
            return nativePutLong;
        } finally {
            releaseReference();
            AppMethodBeat.o(12049);
        }
    }

    public boolean putDouble(double d, int i, int i2) {
        AppMethodBeat.i(12050);
        acquireReference();
        try {
            boolean nativePutDouble = nativePutDouble(this.mWindowPtr, d, i - this.mStartPos, i2);
            return nativePutDouble;
        } finally {
            releaseReference();
            AppMethodBeat.o(12050);
        }
    }

    public boolean putNull(int i, int i2) {
        AppMethodBeat.i(12051);
        acquireReference();
        try {
            boolean nativePutNull = nativePutNull(this.mWindowPtr, i - this.mStartPos, i2);
            return nativePutNull;
        } finally {
            releaseReference();
            AppMethodBeat.o(12051);
        }
    }

    public static CursorWindow newFromParcel(Parcel parcel) {
        AppMethodBeat.i(12052);
        CursorWindow cursorWindow = (CursorWindow) CREATOR.createFromParcel(parcel);
        AppMethodBeat.o(12052);
        return cursorWindow;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(12053);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(12053);
        throw unsupportedOperationException;
    }

    public void onAllReferencesReleased() {
        AppMethodBeat.i(12054);
        dispose();
        AppMethodBeat.o(12054);
    }

    public String toString() {
        AppMethodBeat.i(12055);
        String str = getName() + " {" + Long.toHexString(this.mWindowPtr) + "}";
        AppMethodBeat.o(12055);
        return str;
    }
}
