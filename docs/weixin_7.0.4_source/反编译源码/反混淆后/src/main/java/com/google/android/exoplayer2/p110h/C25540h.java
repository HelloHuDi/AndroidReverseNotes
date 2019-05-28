package com.google.android.exoplayer2.p110h;

import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.google.android.exoplayer2.h.h */
public final class C25540h extends InputStream {
    private final C0867f aSF;
    private final C17665i bib;
    private final byte[] bpN;
    long bpO;
    private boolean closed = false;
    private boolean opened = false;

    public C25540h(C0867f c0867f, C17665i c17665i) {
        AppMethodBeat.m2504i(95795);
        this.aSF = c0867f;
        this.bib = c17665i;
        this.bpN = new byte[1];
        AppMethodBeat.m2505o(95795);
    }

    public final int read() {
        AppMethodBeat.m2504i(95796);
        if (read(this.bpN) == -1) {
            AppMethodBeat.m2505o(95796);
            return -1;
        }
        int i = this.bpN[0] & 255;
        AppMethodBeat.m2505o(95796);
        return i;
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.m2504i(95797);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(95797);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95798);
        C45039a.checkState(!this.closed);
        mo42798tn();
        int read = this.aSF.read(bArr, i, i2);
        if (read == -1) {
            AppMethodBeat.m2505o(95798);
            return -1;
        }
        this.bpO += (long) read;
        AppMethodBeat.m2505o(95798);
        return read;
    }

    public final void close() {
        AppMethodBeat.m2504i(95799);
        if (!this.closed) {
            this.aSF.close();
            this.closed = true;
        }
        AppMethodBeat.m2505o(95799);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: tn */
    public final void mo42798tn() {
        AppMethodBeat.m2504i(95800);
        if (!this.opened) {
            this.aSF.mo2583a(this.bib);
            this.opened = true;
        }
        AppMethodBeat.m2505o(95800);
    }
}
