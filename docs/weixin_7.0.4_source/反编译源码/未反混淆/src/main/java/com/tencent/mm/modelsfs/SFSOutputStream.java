package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.io.OutputStream;

public class SFSOutputStream extends OutputStream {
    private StackTraceElement[] fOm = Thread.currentThread().getStackTrace();
    private long mNativePtr;

    private static native int nativeClose(long j);

    private static native int nativeWrite(long j, byte[] bArr, int i, int i2);

    public SFSOutputStream(long j) {
        AppMethodBeat.i(93263);
        this.mNativePtr = j;
        AppMethodBeat.o(93263);
    }

    public void close() {
        AppMethodBeat.i(93264);
        if (this.mNativePtr == 0) {
            AppMethodBeat.o(93264);
        } else if (nativeClose(this.mNativePtr) == -1) {
            IOException iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(93264);
            throw iOException;
        } else {
            this.mNativePtr = 0;
            AppMethodBeat.o(93264);
        }
    }

    public void write(int i) {
        AppMethodBeat.i(93265);
        IOException iOException;
        if (this.mNativePtr == 0) {
            iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(93265);
            throw iOException;
        }
        if (nativeWrite(this.mNativePtr, new byte[]{(byte) i}, 0, 1) != 1) {
            iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(93265);
            throw iOException;
        }
        AppMethodBeat.o(93265);
    }

    public void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(93266);
        IOException iOException;
        if (this.mNativePtr == 0) {
            iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(93266);
            throw iOException;
        } else if ((i | i2) < 0 || i > bArr.length || bArr.length - i < i2) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("length = " + bArr.length + "offset = " + i + "count = " + i2);
            AppMethodBeat.o(93266);
            throw arrayIndexOutOfBoundsException;
        } else if (nativeWrite(this.mNativePtr, bArr, i, i2) != i2) {
            iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(93266);
            throw iOException;
        } else {
            AppMethodBeat.o(93266);
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(93267);
        if (this.mNativePtr != 0) {
            StringBuilder stringBuilder = new StringBuilder("SFSOutputStream leaked:\n");
            for (StackTraceElement stackTraceElement : this.fOm) {
                stringBuilder.append(stackTraceElement.toString()).append(10);
            }
            ab.e("MicroMsg.SFSOutputStream", stringBuilder.toString());
            close();
        }
        super.finalize();
        AppMethodBeat.o(93267);
    }
}
