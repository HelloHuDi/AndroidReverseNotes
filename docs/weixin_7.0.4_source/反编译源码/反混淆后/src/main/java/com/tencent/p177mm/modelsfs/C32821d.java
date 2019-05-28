package com.tencent.p177mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.modelsfs.d */
public final class C32821d extends SFSInputStream {
    private C32819a fNS;

    public C32821d(long j, long j2) {
        super(j);
        AppMethodBeat.m2504i(93164);
        this.fNS = new C32819a(j2);
        AppMethodBeat.m2505o(93164);
    }

    public final void mark(int i) {
        AppMethodBeat.m2504i(93165);
        super.mark(i);
        this.fNS.aiO();
        AppMethodBeat.m2505o(93165);
    }

    public final void reset() {
        AppMethodBeat.m2504i(93166);
        super.reset();
        this.fNS.reset();
        AppMethodBeat.m2505o(93166);
    }

    public final int read() {
        AppMethodBeat.m2504i(93167);
        int read = super.read();
        AppMethodBeat.m2505o(93167);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(93168);
        int read = super.read(bArr, i, i2);
        if (read < 0) {
            AppMethodBeat.m2505o(93168);
        } else {
            this.fNS.mo53392z(bArr, i2);
            AppMethodBeat.m2505o(93168);
        }
        return read;
    }

    public final long skip(long j) {
        AppMethodBeat.m2504i(93169);
        long skip = super.skip(j);
        this.fNS.seek(j);
        AppMethodBeat.m2505o(93169);
        return skip;
    }

    public final void close() {
        AppMethodBeat.m2504i(93170);
        super.close();
        if (this.fNS != null) {
            this.fNS.free();
        }
        AppMethodBeat.m2505o(93170);
    }
}
