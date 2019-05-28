package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p099a.C45019h;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.f.f */
public final class C37240f implements C0845h {
    private final String aOt;
    private Format aOv;
    private long aSk;
    private C32041m aTw;
    private int bbE;
    private final C32065l bbm = new C32065l(new byte[15]);
    private int bbo;
    private long bbq;
    private String bbx;
    private int sampleSize;
    private int state;

    public C37240f(String str) {
        AppMethodBeat.m2504i(95103);
        this.bbm.data[0] = Byte.MAX_VALUE;
        this.bbm.data[1] = (byte) -2;
        this.bbm.data[2] = Byte.MIN_VALUE;
        this.bbm.data[3] = (byte) 1;
        this.state = 0;
        this.aOt = str;
        AppMethodBeat.m2505o(95103);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        this.state = 0;
        this.bbo = 0;
        this.bbE = 0;
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95104);
        c8661d.mo19155rz();
        this.bbx = c8661d.mo19154rB();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        AppMethodBeat.m2505o(95104);
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        this.aSk = j;
    }

    /* JADX WARNING: Missing block: B:13:0x003d, code skipped:
            r0 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        AppMethodBeat.m2504i(95105);
        while (c32065l.mo52382tB() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    while (c32065l.mo52382tB() > 0) {
                        this.bbE <<= 8;
                        this.bbE |= c32065l.readUnsignedByte();
                        if (this.bbE == 2147385345) {
                            this.bbE = 0;
                            i = 1;
                            if (i == 0) {
                                break;
                            }
                            this.bbo = 4;
                            this.state = 1;
                            break;
                        }
                    }
                    break;
                case 1:
                    byte[] bArr = this.bbm.data;
                    int min = Math.min(c32065l.mo52382tB(), 15 - this.bbo);
                    c32065l.readBytes(bArr, this.bbo, min);
                    this.bbo += min;
                    if (this.bbo == 15) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        break;
                    }
                    bArr = this.bbm.data;
                    if (this.aOv == null) {
                        this.aOv = C45019h.m82474a(bArr, this.bbx, this.aOt);
                        this.aTw.mo42836f(this.aOv);
                    }
                    this.sampleSize = C45019h.m82477l(bArr);
                    this.bbq = (long) ((int) ((((long) C45019h.m82476k(bArr)) * 1000000) / ((long) this.aOv.sampleRate)));
                    this.bbm.setPosition(0);
                    this.aTw.mo42835a(this.bbm, 15);
                    this.state = 2;
                    break;
                case 2:
                    i = Math.min(c32065l.mo52382tB(), this.sampleSize - this.bbo);
                    this.aTw.mo42835a(c32065l, i);
                    this.bbo = i + this.bbo;
                    if (this.bbo != this.sampleSize) {
                        break;
                    }
                    this.aTw.mo42834a(this.aSk, 1, this.sampleSize, 0, null);
                    this.aSk += this.bbq;
                    this.state = 0;
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.m2505o(95105);
    }

    /* renamed from: ro */
    public final void mo2558ro() {
    }
}
