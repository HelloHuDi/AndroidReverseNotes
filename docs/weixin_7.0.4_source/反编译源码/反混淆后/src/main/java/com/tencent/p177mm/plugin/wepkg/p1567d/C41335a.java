package com.tencent.p177mm.plugin.wepkg.p1567d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.wepkg.d.a */
public final class C41335a extends C40394c {
    int count;

    public C41335a(InputStream inputStream) {
        super(inputStream);
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.m2504i(63610);
        int read = super.read(bArr);
        this.count = (read >= 0 ? read : 0) + this.count;
        AppMethodBeat.m2505o(63610);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(63611);
        int read = super.read(bArr, i, i2);
        this.count = (read >= 0 ? read : 0) + this.count;
        AppMethodBeat.m2505o(63611);
        return read;
    }

    public final int read() {
        AppMethodBeat.m2504i(63612);
        int read = super.read();
        this.count = (read >= 0 ? 1 : 0) + this.count;
        AppMethodBeat.m2505o(63612);
        return read;
    }

    public final long skip(long j) {
        AppMethodBeat.m2504i(63613);
        long skip = super.skip(j);
        this.count = (int) (((long) this.count) + skip);
        AppMethodBeat.m2505o(63613);
        return skip;
    }

    public final synchronized int dgF() {
        int i;
        i = this.count;
        this.count = 0;
        return i;
    }
}
