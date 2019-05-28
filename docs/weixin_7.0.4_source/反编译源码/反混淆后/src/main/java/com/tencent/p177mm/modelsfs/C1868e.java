package com.tencent.p177mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.modelsfs.e */
public final class C1868e extends SFSOutputStream {
    private C32819a fNS;

    public C1868e(long j, String str) {
        super(j);
        AppMethodBeat.m2504i(93171);
        this.fNS = new C32819a(str);
        AppMethodBeat.m2505o(93171);
    }

    public final void write(int i) {
        AppMethodBeat.m2504i(93172);
        super.write(i);
        AppMethodBeat.m2505o(93172);
    }

    public final void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(93173);
        this.fNS.mo53392z(bArr, i2);
        super.write(bArr, i, i2);
        AppMethodBeat.m2505o(93173);
    }

    public final void close() {
        AppMethodBeat.m2504i(93174);
        super.close();
        if (this.fNS != null) {
            this.fNS.free();
        }
        AppMethodBeat.m2505o(93174);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(93175);
        super.finalize();
        AppMethodBeat.m2505o(93175);
    }
}
