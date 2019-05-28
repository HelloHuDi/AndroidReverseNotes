package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class h extends InputStream {
    private final f aSF;
    private final i bib;
    private final byte[] bpN;
    long bpO;
    private boolean closed = false;
    private boolean opened = false;

    public h(f fVar, i iVar) {
        AppMethodBeat.i(95795);
        this.aSF = fVar;
        this.bib = iVar;
        this.bpN = new byte[1];
        AppMethodBeat.o(95795);
    }

    public final int read() {
        AppMethodBeat.i(95796);
        if (read(this.bpN) == -1) {
            AppMethodBeat.o(95796);
            return -1;
        }
        int i = this.bpN[0] & 255;
        AppMethodBeat.o(95796);
        return i;
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.i(95797);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.o(95797);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95798);
        a.checkState(!this.closed);
        tn();
        int read = this.aSF.read(bArr, i, i2);
        if (read == -1) {
            AppMethodBeat.o(95798);
            return -1;
        }
        this.bpO += (long) read;
        AppMethodBeat.o(95798);
        return read;
    }

    public final void close() {
        AppMethodBeat.i(95799);
        if (!this.closed) {
            this.aSF.close();
            this.closed = true;
        }
        AppMethodBeat.o(95799);
    }

    /* Access modifiers changed, original: final */
    public final void tn() {
        AppMethodBeat.i(95800);
        if (!this.opened) {
            this.aSF.a(this.bib);
            this.opened = true;
        }
        AppMethodBeat.o(95800);
    }
}
