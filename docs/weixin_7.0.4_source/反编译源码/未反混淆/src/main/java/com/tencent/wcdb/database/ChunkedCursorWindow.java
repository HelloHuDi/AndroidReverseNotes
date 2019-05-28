package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindowAllocationException;

public class ChunkedCursorWindow extends SQLiteClosable {
    public static final long CHUNK_NOT_FOUND = -1;
    private int mNumColumns = 0;
    long mWindowPtr;

    private static native void nativeClear(long j);

    private static native long nativeCreate(int i);

    private static native void nativeDispose(long j);

    private static native void nativeEndRow(long j, long j2);

    private static native byte[] nativeGetBlob(long j, int i);

    private static native double nativeGetDouble(long j, int i);

    private static native long nativeGetLong(long j, int i);

    private static native int nativeGetNumChunks(long j);

    private static native long nativeGetRow(long j, int i);

    private static native String nativeGetString(long j, int i);

    private static native int nativeGetType(long j, int i);

    private static native long nativeRemoveChunk(long j, int i);

    private static native boolean nativeSetNumColumns(long j, int i);

    public ChunkedCursorWindow(int i) {
        AppMethodBeat.i(12211);
        this.mWindowPtr = nativeCreate(i);
        if (this.mWindowPtr == 0) {
            CursorWindowAllocationException cursorWindowAllocationException = new CursorWindowAllocationException("Cursor window allocation failed.");
            AppMethodBeat.o(12211);
            throw cursorWindowAllocationException;
        }
        AppMethodBeat.o(12211);
    }

    private void dispose() {
        AppMethodBeat.i(12212);
        if (this.mWindowPtr != 0) {
            nativeDispose(this.mWindowPtr);
            this.mWindowPtr = 0;
        }
        AppMethodBeat.o(12212);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(12213);
        try {
            dispose();
        } finally {
            super.finalize();
            AppMethodBeat.o(12213);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAllReferencesReleased() {
        AppMethodBeat.i(12214);
        dispose();
        AppMethodBeat.o(12214);
    }

    public void clear() {
        AppMethodBeat.i(12215);
        acquireReference();
        try {
            nativeClear(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(12215);
        }
    }

    public long removeChunk(int i) {
        AppMethodBeat.i(12216);
        acquireReference();
        try {
            long nativeRemoveChunk = nativeRemoveChunk(this.mWindowPtr, i);
            return nativeRemoveChunk;
        } finally {
            releaseReference();
            AppMethodBeat.o(12216);
        }
    }

    public int getNumChunks() {
        AppMethodBeat.i(12217);
        acquireReference();
        try {
            int nativeGetNumChunks = nativeGetNumChunks(this.mWindowPtr);
            return nativeGetNumChunks;
        } finally {
            releaseReference();
            AppMethodBeat.o(12217);
        }
    }

    public int getNumColumns() {
        return this.mNumColumns;
    }

    public boolean setNumColumns(int i) {
        AppMethodBeat.i(12218);
        acquireReference();
        try {
            boolean nativeSetNumColumns = nativeSetNumColumns(this.mWindowPtr, i);
            if (nativeSetNumColumns) {
                this.mNumColumns = i;
            }
            releaseReference();
            AppMethodBeat.o(12218);
            return nativeSetNumColumns;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(12218);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public long getRowUnsafe(int i) {
        AppMethodBeat.i(12219);
        acquireReference();
        long nativeGetRow = nativeGetRow(this.mWindowPtr, i);
        if (nativeGetRow == 0) {
            releaseReference();
        }
        AppMethodBeat.o(12219);
        return nativeGetRow;
    }

    /* Access modifiers changed, original: 0000 */
    public void endRowUnsafe(long j) {
        AppMethodBeat.i(12220);
        if (j == 0) {
            AppMethodBeat.o(12220);
            return;
        }
        nativeEndRow(this.mWindowPtr, j);
        releaseReference();
        AppMethodBeat.o(12220);
    }

    /* Access modifiers changed, original: 0000 */
    public int getTypeUnsafe(long j, int i) {
        AppMethodBeat.i(12221);
        int nativeGetType = nativeGetType(j, i);
        AppMethodBeat.o(12221);
        return nativeGetType;
    }

    /* Access modifiers changed, original: 0000 */
    public byte[] getBlobUnsafe(long j, int i) {
        AppMethodBeat.i(12222);
        byte[] nativeGetBlob = nativeGetBlob(j, i);
        AppMethodBeat.o(12222);
        return nativeGetBlob;
    }

    /* Access modifiers changed, original: 0000 */
    public String getStringUnsafe(long j, int i) {
        AppMethodBeat.i(12223);
        String nativeGetString = nativeGetString(j, i);
        AppMethodBeat.o(12223);
        return nativeGetString;
    }

    /* Access modifiers changed, original: 0000 */
    public long getLongUnsafe(long j, int i) {
        AppMethodBeat.i(12224);
        long nativeGetLong = nativeGetLong(j, i);
        AppMethodBeat.o(12224);
        return nativeGetLong;
    }

    /* Access modifiers changed, original: 0000 */
    public double getDoubleUnsafe(long j, int i) {
        AppMethodBeat.i(12225);
        double nativeGetDouble = nativeGetDouble(j, i);
        AppMethodBeat.o(12225);
        return nativeGetDouble;
    }

    public int getType(int i, int i2) {
        AppMethodBeat.i(12226);
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(12226);
            throw illegalStateException;
        }
        try {
            int nativeGetType = nativeGetType(rowUnsafe, i2);
            return nativeGetType;
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(12226);
        }
    }

    public byte[] getBlob(int i, int i2) {
        AppMethodBeat.i(12227);
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(12227);
            throw illegalStateException;
        }
        try {
            byte[] nativeGetBlob = nativeGetBlob(rowUnsafe, i2);
            return nativeGetBlob;
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(12227);
        }
    }

    public String getString(int i, int i2) {
        AppMethodBeat.i(12228);
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(12228);
            throw illegalStateException;
        }
        try {
            String nativeGetString = nativeGetString(rowUnsafe, i2);
            return nativeGetString;
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(12228);
        }
    }

    public long getLong(int i, int i2) {
        AppMethodBeat.i(12229);
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(12229);
            throw illegalStateException;
        }
        try {
            long nativeGetLong = nativeGetLong(rowUnsafe, i2);
            return nativeGetLong;
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(12229);
        }
    }

    public double getDouble(int i, int i2) {
        AppMethodBeat.i(12230);
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(12230);
            throw illegalStateException;
        }
        try {
            double nativeGetDouble = nativeGetDouble(rowUnsafe, i2);
            return nativeGetDouble;
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(12230);
        }
    }
}
