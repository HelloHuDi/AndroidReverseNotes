package com.bumptech.glide.p095h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.h.c */
public final class C45001c extends FilterInputStream {
    private final long aHW;
    private int aHX;

    /* renamed from: b */
    public static InputStream m82413b(InputStream inputStream, long j) {
        AppMethodBeat.m2504i(92559);
        C45001c c45001c = new C45001c(inputStream, j);
        AppMethodBeat.m2505o(92559);
        return c45001c;
    }

    private C45001c(InputStream inputStream, long j) {
        super(inputStream);
        this.aHW = j;
    }

    public final synchronized int available() {
        int max;
        AppMethodBeat.m2504i(92560);
        max = (int) Math.max(this.aHW - ((long) this.aHX), (long) this.in.available());
        AppMethodBeat.m2505o(92560);
        return max;
    }

    public final synchronized int read() {
        int read;
        AppMethodBeat.m2504i(92561);
        read = super.read();
        m82414dl(read >= 0 ? 1 : -1);
        AppMethodBeat.m2505o(92561);
        return read;
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.m2504i(92562);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(92562);
        return read;
    }

    public final synchronized int read(byte[] bArr, int i, int i2) {
        int dl;
        AppMethodBeat.m2504i(92563);
        dl = m82414dl(super.read(bArr, i, i2));
        AppMethodBeat.m2505o(92563);
        return dl;
    }

    /* renamed from: dl */
    private int m82414dl(int i) {
        AppMethodBeat.m2504i(92564);
        if (i >= 0) {
            this.aHX += i;
        } else if (this.aHW - ((long) this.aHX) > 0) {
            IOException iOException = new IOException("Failed to read all expected data, expected: " + this.aHW + ", but read: " + this.aHX);
            AppMethodBeat.m2505o(92564);
            throw iOException;
        }
        AppMethodBeat.m2505o(92564);
        return i;
    }
}
