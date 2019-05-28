package com.tencent.p177mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FilterInputStream;

/* renamed from: com.tencent.mm.modelsfs.b */
public final class C32820b extends FilterInputStream {
    private boolean fNO = false;
    private C32819a fNS;

    public C32820b(String str, long j) {
        super(C5730e.openRead(str));
        AppMethodBeat.m2504i(93154);
        this.fNS = new C32819a(j);
        AppMethodBeat.m2505o(93154);
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(93155);
        if (this.fNO) {
            C4990ab.m7416i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + C5046bo.dpG().toString());
        }
        int read = super.read(bArr, i, i2);
        if (read < 0) {
            AppMethodBeat.m2505o(93155);
        } else {
            this.fNS.mo53392z(bArr, i2);
            AppMethodBeat.m2505o(93155);
        }
        return read;
    }

    public final long skip(long j) {
        AppMethodBeat.m2504i(93156);
        long skip = super.skip(j);
        this.fNS.seek(j);
        AppMethodBeat.m2505o(93156);
        return skip;
    }

    public final void close() {
        AppMethodBeat.m2504i(93157);
        super.close();
        if (this.fNS != null) {
            this.fNS.free();
        }
        C4990ab.m7416i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
        AppMethodBeat.m2505o(93157);
    }

    public final void mark(int i) {
        AppMethodBeat.m2504i(93158);
        super.mark(i);
        this.fNS.aiO();
        AppMethodBeat.m2505o(93158);
    }

    public final void reset() {
        AppMethodBeat.m2504i(93159);
        super.reset();
        this.fNS.reset();
        AppMethodBeat.m2505o(93159);
    }
}
