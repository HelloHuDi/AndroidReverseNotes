package com.bumptech.glide.p095h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: com.bumptech.glide.h.d */
public final class C37196d extends InputStream {
    private static final Queue<C37196d> aHY = C45002j.m82420dn(0);
    private InputStream aHZ;
    public IOException aIa;

    static {
        AppMethodBeat.m2504i(92576);
        AppMethodBeat.m2505o(92576);
    }

    /* renamed from: e */
    public static C37196d m62347e(InputStream inputStream) {
        C37196d c37196d;
        AppMethodBeat.m2504i(92565);
        synchronized (aHY) {
            try {
                c37196d = (C37196d) aHY.poll();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(92565);
                }
            }
        }
        if (c37196d == null) {
            c37196d = new C37196d();
        }
        c37196d.aHZ = inputStream;
        AppMethodBeat.m2505o(92565);
        return c37196d;
    }

    C37196d() {
    }

    public final int available() {
        AppMethodBeat.m2504i(92566);
        int available = this.aHZ.available();
        AppMethodBeat.m2505o(92566);
        return available;
    }

    public final void close() {
        AppMethodBeat.m2504i(92567);
        this.aHZ.close();
        AppMethodBeat.m2505o(92567);
    }

    public final void mark(int i) {
        AppMethodBeat.m2504i(92568);
        this.aHZ.mark(i);
        AppMethodBeat.m2505o(92568);
    }

    public final boolean markSupported() {
        AppMethodBeat.m2504i(92569);
        boolean markSupported = this.aHZ.markSupported();
        AppMethodBeat.m2505o(92569);
        return markSupported;
    }

    public final int read(byte[] bArr) {
        int read;
        AppMethodBeat.m2504i(92570);
        try {
            read = this.aHZ.read(bArr);
        } catch (IOException e) {
            this.aIa = e;
            read = -1;
        }
        AppMethodBeat.m2505o(92570);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read;
        AppMethodBeat.m2504i(92571);
        try {
            read = this.aHZ.read(bArr, i, i2);
        } catch (IOException e) {
            this.aIa = e;
            read = -1;
        }
        AppMethodBeat.m2505o(92571);
        return read;
    }

    public final synchronized void reset() {
        AppMethodBeat.m2504i(92572);
        this.aHZ.reset();
        AppMethodBeat.m2505o(92572);
    }

    public final long skip(long j) {
        long skip;
        AppMethodBeat.m2504i(92573);
        try {
            skip = this.aHZ.skip(j);
        } catch (IOException e) {
            this.aIa = e;
            skip = 0;
        }
        AppMethodBeat.m2505o(92573);
        return skip;
    }

    public final int read() {
        int read;
        AppMethodBeat.m2504i(92574);
        try {
            read = this.aHZ.read();
        } catch (IOException e) {
            this.aIa = e;
            read = -1;
        }
        AppMethodBeat.m2505o(92574);
        return read;
    }

    public final void release() {
        AppMethodBeat.m2504i(92575);
        this.aIa = null;
        this.aHZ = null;
        synchronized (aHY) {
            try {
                aHY.offer(this);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(92575);
            }
        }
    }
}
