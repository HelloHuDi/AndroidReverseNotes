package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class d extends InputStream {
    private static final Queue<d> aHY = j.dn(0);
    private InputStream aHZ;
    public IOException aIa;

    static {
        AppMethodBeat.i(92576);
        AppMethodBeat.o(92576);
    }

    public static d e(InputStream inputStream) {
        d dVar;
        AppMethodBeat.i(92565);
        synchronized (aHY) {
            try {
                dVar = (d) aHY.poll();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(92565);
                }
            }
        }
        if (dVar == null) {
            dVar = new d();
        }
        dVar.aHZ = inputStream;
        AppMethodBeat.o(92565);
        return dVar;
    }

    d() {
    }

    public final int available() {
        AppMethodBeat.i(92566);
        int available = this.aHZ.available();
        AppMethodBeat.o(92566);
        return available;
    }

    public final void close() {
        AppMethodBeat.i(92567);
        this.aHZ.close();
        AppMethodBeat.o(92567);
    }

    public final void mark(int i) {
        AppMethodBeat.i(92568);
        this.aHZ.mark(i);
        AppMethodBeat.o(92568);
    }

    public final boolean markSupported() {
        AppMethodBeat.i(92569);
        boolean markSupported = this.aHZ.markSupported();
        AppMethodBeat.o(92569);
        return markSupported;
    }

    public final int read(byte[] bArr) {
        int read;
        AppMethodBeat.i(92570);
        try {
            read = this.aHZ.read(bArr);
        } catch (IOException e) {
            this.aIa = e;
            read = -1;
        }
        AppMethodBeat.o(92570);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read;
        AppMethodBeat.i(92571);
        try {
            read = this.aHZ.read(bArr, i, i2);
        } catch (IOException e) {
            this.aIa = e;
            read = -1;
        }
        AppMethodBeat.o(92571);
        return read;
    }

    public final synchronized void reset() {
        AppMethodBeat.i(92572);
        this.aHZ.reset();
        AppMethodBeat.o(92572);
    }

    public final long skip(long j) {
        long skip;
        AppMethodBeat.i(92573);
        try {
            skip = this.aHZ.skip(j);
        } catch (IOException e) {
            this.aIa = e;
            skip = 0;
        }
        AppMethodBeat.o(92573);
        return skip;
    }

    public final int read() {
        int read;
        AppMethodBeat.i(92574);
        try {
            read = this.aHZ.read();
        } catch (IOException e) {
            this.aIa = e;
            read = -1;
        }
        AppMethodBeat.o(92574);
        return read;
    }

    public final void release() {
        AppMethodBeat.i(92575);
        this.aIa = null;
        this.aHZ = null;
        synchronized (aHY) {
            try {
                aHY.offer(this);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(92575);
            }
        }
    }
}
