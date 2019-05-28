package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends SFSInputStream {
    private a fNS;

    public d(long j, long j2) {
        super(j);
        AppMethodBeat.i(93164);
        this.fNS = new a(j2);
        AppMethodBeat.o(93164);
    }

    public final void mark(int i) {
        AppMethodBeat.i(93165);
        super.mark(i);
        this.fNS.aiO();
        AppMethodBeat.o(93165);
    }

    public final void reset() {
        AppMethodBeat.i(93166);
        super.reset();
        this.fNS.reset();
        AppMethodBeat.o(93166);
    }

    public final int read() {
        AppMethodBeat.i(93167);
        int read = super.read();
        AppMethodBeat.o(93167);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(93168);
        int read = super.read(bArr, i, i2);
        if (read < 0) {
            AppMethodBeat.o(93168);
        } else {
            this.fNS.z(bArr, i2);
            AppMethodBeat.o(93168);
        }
        return read;
    }

    public final long skip(long j) {
        AppMethodBeat.i(93169);
        long skip = super.skip(j);
        this.fNS.seek(j);
        AppMethodBeat.o(93169);
        return skip;
    }

    public final void close() {
        AppMethodBeat.i(93170);
        super.close();
        if (this.fNS != null) {
            this.fNS.free();
        }
        AppMethodBeat.o(93170);
    }
}
