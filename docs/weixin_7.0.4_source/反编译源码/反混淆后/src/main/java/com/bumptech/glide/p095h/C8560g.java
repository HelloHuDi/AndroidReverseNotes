package com.bumptech.glide.p095h;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.h.g */
public final class C8560g extends FilterInputStream {
    private int aIc = C8415j.INVALID_ID;

    public C8560g(InputStream inputStream) {
        super(inputStream);
    }

    public final synchronized void mark(int i) {
        AppMethodBeat.m2504i(92586);
        super.mark(i);
        this.aIc = i;
        AppMethodBeat.m2505o(92586);
    }

    public final int read() {
        AppMethodBeat.m2504i(92587);
        if (m15213r(1) == -1) {
            AppMethodBeat.m2505o(92587);
            return -1;
        }
        int read = super.read();
        m15214s(1);
        AppMethodBeat.m2505o(92587);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(92588);
        int r = (int) m15213r((long) i2);
        if (r == -1) {
            AppMethodBeat.m2505o(92588);
            return -1;
        }
        int read = super.read(bArr, i, r);
        m15214s((long) read);
        AppMethodBeat.m2505o(92588);
        return read;
    }

    public final synchronized void reset() {
        AppMethodBeat.m2504i(92589);
        super.reset();
        this.aIc = C8415j.INVALID_ID;
        AppMethodBeat.m2505o(92589);
    }

    public final long skip(long j) {
        AppMethodBeat.m2504i(92590);
        long r = m15213r(j);
        if (r == -1) {
            AppMethodBeat.m2505o(92590);
            return 0;
        }
        r = super.skip(r);
        m15214s(r);
        AppMethodBeat.m2505o(92590);
        return r;
    }

    public final int available() {
        AppMethodBeat.m2504i(92591);
        int available;
        if (this.aIc == C8415j.INVALID_ID) {
            available = super.available();
            AppMethodBeat.m2505o(92591);
            return available;
        }
        available = Math.min(this.aIc, super.available());
        AppMethodBeat.m2505o(92591);
        return available;
    }

    /* renamed from: r */
    private long m15213r(long j) {
        if (this.aIc == 0) {
            return -1;
        }
        if (this.aIc == C8415j.INVALID_ID || j <= ((long) this.aIc)) {
            return j;
        }
        return (long) this.aIc;
    }

    /* renamed from: s */
    private void m15214s(long j) {
        if (this.aIc != C8415j.INVALID_ID && j != -1) {
            this.aIc = (int) (((long) this.aIc) - j);
        }
    }
}
