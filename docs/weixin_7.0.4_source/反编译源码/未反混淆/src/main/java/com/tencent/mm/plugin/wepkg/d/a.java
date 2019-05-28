package com.tencent.mm.plugin.wepkg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a extends c {
    int count;

    public a(InputStream inputStream) {
        super(inputStream);
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.i(63610);
        int read = super.read(bArr);
        this.count = (read >= 0 ? read : 0) + this.count;
        AppMethodBeat.o(63610);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(63611);
        int read = super.read(bArr, i, i2);
        this.count = (read >= 0 ? read : 0) + this.count;
        AppMethodBeat.o(63611);
        return read;
    }

    public final int read() {
        AppMethodBeat.i(63612);
        int read = super.read();
        this.count = (read >= 0 ? 1 : 0) + this.count;
        AppMethodBeat.o(63612);
        return read;
    }

    public final long skip(long j) {
        AppMethodBeat.i(63613);
        long skip = super.skip(j);
        this.count = (int) (((long) this.count) + skip);
        AppMethodBeat.o(63613);
        return skip;
    }

    public final synchronized int dgF() {
        int i;
        i = this.count;
        this.count = 0;
        return i;
    }
}
