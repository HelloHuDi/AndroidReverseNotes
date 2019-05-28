package com.tencent.p177mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.modelsfs.SFSInputStream */
public class SFSInputStream extends InputStream {
    private long aMp = 0;
    private long mNativePtr;

    private static native int nativeClose(long j);

    private static native int nativeRead(long j, byte[] bArr, int i, int i2);

    private static native long nativeSeek(long j, long j2, int i);

    private static native long nativeSize(long j);

    public SFSInputStream(long j) {
        this.mNativePtr = j;
    }

    public int available() {
        AppMethodBeat.m2504i(93255);
        IOException iOException;
        if (this.mNativePtr == 0) {
            iOException = new IOException("Stream already closed.");
            AppMethodBeat.m2505o(93255);
            throw iOException;
        }
        long nativeSize = SFSInputStream.nativeSize(this.mNativePtr);
        if (nativeSize < 0) {
            iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.m2505o(93255);
            throw iOException;
        }
        long nativeSeek = SFSInputStream.nativeSeek(this.mNativePtr, 0, 1);
        if (nativeSeek < 0) {
            iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.m2505o(93255);
            throw iOException;
        }
        int i = (int) (nativeSize - nativeSeek);
        AppMethodBeat.m2505o(93255);
        return i;
    }

    public void close() {
        AppMethodBeat.m2504i(93256);
        if (this.mNativePtr == 0) {
            AppMethodBeat.m2505o(93256);
        } else if (SFSInputStream.nativeClose(this.mNativePtr) == -1) {
            IOException iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.m2505o(93256);
            throw iOException;
        } else {
            this.mNativePtr = 0;
            AppMethodBeat.m2505o(93256);
        }
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int i) {
        AppMethodBeat.m2504i(93257);
        if (this.mNativePtr == 0) {
            AppMethodBeat.m2505o(93257);
            return;
        }
        this.aMp = SFSInputStream.nativeSeek(this.mNativePtr, 0, 1);
        AppMethodBeat.m2505o(93257);
    }

    public void reset() {
        AppMethodBeat.m2504i(93258);
        IOException iOException;
        if (this.mNativePtr == 0) {
            iOException = new IOException("Stream already closed.");
            AppMethodBeat.m2505o(93258);
            throw iOException;
        } else if (this.aMp < 0) {
            iOException = new IOException("Previous call to mark() failed.");
            AppMethodBeat.m2505o(93258);
            throw iOException;
        } else if (SFSInputStream.nativeSeek(this.mNativePtr, this.aMp, 0) != this.aMp) {
            iOException = new IOException("Seeking to previous position failed.");
            AppMethodBeat.m2505o(93258);
            throw iOException;
        } else {
            AppMethodBeat.m2505o(93258);
        }
    }

    public int read() {
        AppMethodBeat.m2504i(93259);
        if (this.mNativePtr == 0) {
            IOException iOException = new IOException("Stream already closed.");
            AppMethodBeat.m2505o(93259);
            throw iOException;
        }
        int nativeRead;
        byte[] bArr = new byte[1];
        do {
            nativeRead = SFSInputStream.nativeRead(this.mNativePtr, bArr, 0, 1);
        } while (nativeRead == 0);
        if (nativeRead == -1) {
            AppMethodBeat.m2505o(93259);
            return -1;
        }
        int i = bArr[0];
        AppMethodBeat.m2505o(93259);
        return i;
    }

    public int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(93260);
        IOException iOException;
        if (this.mNativePtr == 0) {
            iOException = new IOException("Stream already closed.");
            AppMethodBeat.m2505o(93260);
            throw iOException;
        } else if ((i | i2) < 0 || i > bArr.length || bArr.length - i < i2) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("length = " + bArr.length + ", offset = " + i + ", count = " + i2);
            AppMethodBeat.m2505o(93260);
            throw arrayIndexOutOfBoundsException;
        } else {
            int nativeRead = SFSInputStream.nativeRead(this.mNativePtr, bArr, i, i2);
            if (nativeRead == 0) {
                AppMethodBeat.m2505o(93260);
                return -1;
            } else if (nativeRead == -1) {
                iOException = new IOException(SFSContext.nativeErrorMessage());
                AppMethodBeat.m2505o(93260);
                throw iOException;
            } else {
                AppMethodBeat.m2505o(93260);
                return nativeRead;
            }
        }
    }

    public long skip(long j) {
        AppMethodBeat.m2504i(93261);
        IOException iOException;
        if (this.mNativePtr == 0) {
            iOException = new IOException("Stream already closed.");
            AppMethodBeat.m2505o(93261);
            throw iOException;
        } else if (j < 0) {
            iOException = new IOException("byteCount < 0: ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(93261);
            throw iOException;
        } else {
            long nativeSeek = SFSInputStream.nativeSeek(this.mNativePtr, 0, 1);
            long nativeSeek2 = SFSInputStream.nativeSeek(this.mNativePtr, j, 1);
            if (nativeSeek == -1 || nativeSeek2 == -1) {
                iOException = new IOException(SFSContext.nativeErrorMessage());
                AppMethodBeat.m2505o(93261);
                throw iOException;
            }
            nativeSeek = nativeSeek2 - nativeSeek;
            AppMethodBeat.m2505o(93261);
            return nativeSeek;
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(93262);
        if (this.mNativePtr != 0) {
            close();
        }
        super.finalize();
        AppMethodBeat.m2505o(93262);
    }
}
