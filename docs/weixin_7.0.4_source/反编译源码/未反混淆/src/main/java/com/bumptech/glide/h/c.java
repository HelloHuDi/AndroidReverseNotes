package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c extends FilterInputStream {
    private final long aHW;
    private int aHX;

    public static InputStream b(InputStream inputStream, long j) {
        AppMethodBeat.i(92559);
        c cVar = new c(inputStream, j);
        AppMethodBeat.o(92559);
        return cVar;
    }

    private c(InputStream inputStream, long j) {
        super(inputStream);
        this.aHW = j;
    }

    public final synchronized int available() {
        int max;
        AppMethodBeat.i(92560);
        max = (int) Math.max(this.aHW - ((long) this.aHX), (long) this.in.available());
        AppMethodBeat.o(92560);
        return max;
    }

    public final synchronized int read() {
        int read;
        AppMethodBeat.i(92561);
        read = super.read();
        dl(read >= 0 ? 1 : -1);
        AppMethodBeat.o(92561);
        return read;
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.i(92562);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.o(92562);
        return read;
    }

    public final synchronized int read(byte[] bArr, int i, int i2) {
        int dl;
        AppMethodBeat.i(92563);
        dl = dl(super.read(bArr, i, i2));
        AppMethodBeat.o(92563);
        return dl;
    }

    private int dl(int i) {
        AppMethodBeat.i(92564);
        if (i >= 0) {
            this.aHX += i;
        } else if (this.aHW - ((long) this.aHX) > 0) {
            IOException iOException = new IOException("Failed to read all expected data, expected: " + this.aHW + ", but read: " + this.aHX);
            AppMethodBeat.o(92564);
            throw iOException;
        }
        AppMethodBeat.o(92564);
        return i;
    }
}
