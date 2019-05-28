package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends SFSOutputStream {
    private a fNS;

    public e(long j, String str) {
        super(j);
        AppMethodBeat.i(93171);
        this.fNS = new a(str);
        AppMethodBeat.o(93171);
    }

    public final void write(int i) {
        AppMethodBeat.i(93172);
        super.write(i);
        AppMethodBeat.o(93172);
    }

    public final void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(93173);
        this.fNS.z(bArr, i2);
        super.write(bArr, i, i2);
        AppMethodBeat.o(93173);
    }

    public final void close() {
        AppMethodBeat.i(93174);
        super.close();
        if (this.fNS != null) {
            this.fNS.free();
        }
        AppMethodBeat.o(93174);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(93175);
        super.finalize();
        AppMethodBeat.o(93175);
    }
}
