package com.google.android.exoplayer2.p101c.p795a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.p795a.C41592d.C8644a;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45041j;
import com.google.android.exoplayer2.video.C37284a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.a.e */
final class C44647e extends C41592d {
    private boolean aTf;
    private final C32065l aTx = new C32065l(C45041j.bqY);
    private final C32065l aTy = new C32065l(4);
    private int aTz;
    private int frameType;

    public C44647e(C32041m c32041m) {
        super(c32041m);
        AppMethodBeat.m2504i(94878);
        AppMethodBeat.m2505o(94878);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo32314a(C32065l c32065l) {
        AppMethodBeat.m2504i(94879);
        int readUnsignedByte = c32065l.readUnsignedByte();
        int i = (readUnsignedByte >> 4) & 15;
        readUnsignedByte &= 15;
        if (readUnsignedByte != 7) {
            C8644a c8644a = new C8644a("Video format not supported: ".concat(String.valueOf(readUnsignedByte)));
            AppMethodBeat.m2505o(94879);
            throw c8644a;
        }
        this.frameType = i;
        if (i != 5) {
            AppMethodBeat.m2505o(94879);
            return true;
        }
        AppMethodBeat.m2505o(94879);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo32313a(C32065l c32065l, long j) {
        AppMethodBeat.m2504i(94880);
        int readUnsignedByte = c32065l.readUnsignedByte();
        long tD = (((long) c32065l.mo52384tD()) * 1000) + j;
        if (readUnsignedByte != 0 || this.aTf) {
            if (readUnsignedByte == 1 && this.aTf) {
                int tI;
                byte[] bArr = this.aTy.data;
                bArr[0] = (byte) 0;
                bArr[1] = (byte) 0;
                bArr[2] = (byte) 0;
                readUnsignedByte = 4 - this.aTz;
                int i = 0;
                while (c32065l.mo52382tB() > 0) {
                    c32065l.readBytes(this.aTy.data, readUnsignedByte, this.aTz);
                    this.aTy.setPosition(0);
                    tI = this.aTy.mo52389tI();
                    this.aTx.setPosition(0);
                    this.aTw.mo42835a(this.aTx, 4);
                    i += 4;
                    this.aTw.mo42835a(c32065l, tI);
                    i += tI;
                }
                C32041m c32041m = this.aTw;
                if (this.frameType == 1) {
                    tI = 1;
                } else {
                    tI = 0;
                }
                c32041m.mo42834a(tD, tI, i, 0, null);
            }
            AppMethodBeat.m2505o(94880);
            return;
        }
        C32065l c32065l2 = new C32065l(new byte[c32065l.mo52382tB()]);
        c32065l.readBytes(c32065l2.data, 0, c32065l.mo52382tB());
        C37284a K = C37284a.m62588K(c32065l2);
        this.aTz = K.aTz;
        this.aTw.mo42836f(Format.m15273a(null, "video/avc", K.width, K.height, K.aOf, K.brq));
        this.aTf = true;
        AppMethodBeat.m2505o(94880);
    }
}
