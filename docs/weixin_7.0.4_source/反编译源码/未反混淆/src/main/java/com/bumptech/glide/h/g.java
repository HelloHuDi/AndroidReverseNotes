package com.bumptech.glide.h;

import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class g extends FilterInputStream {
    private int aIc = j.INVALID_ID;

    public g(InputStream inputStream) {
        super(inputStream);
    }

    public final synchronized void mark(int i) {
        AppMethodBeat.i(92586);
        super.mark(i);
        this.aIc = i;
        AppMethodBeat.o(92586);
    }

    public final int read() {
        AppMethodBeat.i(92587);
        if (r(1) == -1) {
            AppMethodBeat.o(92587);
            return -1;
        }
        int read = super.read();
        s(1);
        AppMethodBeat.o(92587);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(92588);
        int r = (int) r((long) i2);
        if (r == -1) {
            AppMethodBeat.o(92588);
            return -1;
        }
        int read = super.read(bArr, i, r);
        s((long) read);
        AppMethodBeat.o(92588);
        return read;
    }

    public final synchronized void reset() {
        AppMethodBeat.i(92589);
        super.reset();
        this.aIc = j.INVALID_ID;
        AppMethodBeat.o(92589);
    }

    public final long skip(long j) {
        AppMethodBeat.i(92590);
        long r = r(j);
        if (r == -1) {
            AppMethodBeat.o(92590);
            return 0;
        }
        r = super.skip(r);
        s(r);
        AppMethodBeat.o(92590);
        return r;
    }

    public final int available() {
        AppMethodBeat.i(92591);
        int available;
        if (this.aIc == j.INVALID_ID) {
            available = super.available();
            AppMethodBeat.o(92591);
            return available;
        }
        available = Math.min(this.aIc, super.available());
        AppMethodBeat.o(92591);
        return available;
    }

    private long r(long j) {
        if (this.aIc == 0) {
            return -1;
        }
        if (this.aIc == j.INVALID_ID || j <= ((long) this.aIc)) {
            return j;
        }
        return (long) this.aIc;
    }

    private void s(long j) {
        if (this.aIc != j.INVALID_ID && j != -1) {
            this.aIc = (int) (((long) this.aIc) - j);
        }
    }
}
