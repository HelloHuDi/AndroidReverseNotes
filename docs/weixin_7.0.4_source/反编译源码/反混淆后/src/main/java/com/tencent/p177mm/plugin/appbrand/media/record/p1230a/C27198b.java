package com.tencent.p177mm.plugin.appbrand.media.record.p1230a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.media.record.p1230a.C19603c.C19604a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.a.b */
public class C27198b implements C19603c {
    String ilX = "audio/mp4a-latm";
    String ilY = "audio/mpeg";
    C19604a ilZ = null;
    int ima = 0;
    int imb = 0;
    byte[] imc;
    int imd = 0;

    /* renamed from: pl */
    public final void mo34815pl(int i) {
        AppMethodBeat.m2504i(105649);
        C4990ab.m7417i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", Integer.valueOf(this.ima));
        this.ima = i;
        AppMethodBeat.m2505o(105649);
    }

    /* renamed from: a */
    public final void mo34810a(C19604a c19604a) {
        this.ilZ = c19604a;
    }

    /* renamed from: t */
    public final void mo34816t(double d) {
        AppMethodBeat.m2504i(105650);
        this.imb = (int) (1024.0d * d);
        C4990ab.m7417i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", Double.valueOf(d), Integer.valueOf(this.imb));
        this.imc = new byte[this.imb];
        AppMethodBeat.m2505o(105650);
    }

    /* renamed from: h */
    public boolean mo34814h(String str, int i, int i2, int i3) {
        return false;
    }

    /* renamed from: a */
    public boolean mo34811a(boolean z, byte[] bArr, int i) {
        return false;
    }

    public void flush() {
    }

    public void close() {
    }

    /* renamed from: e */
    public final void mo44864e(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(105651);
        if (this.ilZ == null) {
            C4990ab.m7412e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
            AppMethodBeat.m2505o(105651);
        } else if (((double) this.imb) == 0.0d) {
            C4990ab.m7412e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
            AppMethodBeat.m2505o(105651);
        } else {
            if (i > this.imb) {
                C4990ab.m7421w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", Integer.valueOf(i), Integer.valueOf(this.imb));
            }
            C4990ab.m7411d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", Integer.valueOf(this.imd), Integer.valueOf(i));
            int i2 = this.imd + i;
            if (i2 >= this.imb && bArr != null) {
                C4990ab.m7411d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", Integer.valueOf(i2));
                if (i2 > this.imc.length) {
                    C4990ab.m7417i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", Integer.valueOf(i2));
                    byte[] bArr2 = this.imc;
                    this.imc = new byte[i2];
                    System.arraycopy(bArr2, 0, this.imc, 0, this.imd);
                }
                System.arraycopy(bArr, 0, this.imc, this.imd, i);
                this.ilZ.mo22161d(this.imc, i2, false);
                this.imd = 0;
            } else if (bArr != null) {
                System.arraycopy(bArr, 0, this.imc, this.imd, i);
                this.imd = i2;
                C4990ab.m7411d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", Integer.valueOf(this.imd));
            }
            if (z) {
                C4990ab.m7417i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", Integer.valueOf(this.imd));
                this.ilZ.mo22161d(this.imc, this.imd, z);
                this.imd = 0;
            }
            AppMethodBeat.m2505o(105651);
        }
    }
}
