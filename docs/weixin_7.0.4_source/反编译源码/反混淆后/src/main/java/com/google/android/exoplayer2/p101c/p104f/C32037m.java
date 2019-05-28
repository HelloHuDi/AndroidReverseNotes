package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C0852j;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.f.m */
public final class C32037m implements C0845h {
    private final String aOt;
    private int aPy;
    private long aSk;
    private boolean aTf;
    private C32041m aTw;
    private long bbL;
    private String bbx;
    private final C32065l bcP;
    private final C0852j bcQ;
    private int bcR;
    private boolean bcS;
    private int state;

    public C32037m() {
        this(null);
    }

    public C32037m(String str) {
        AppMethodBeat.m2504i(95137);
        this.state = 0;
        this.bcP = new C32065l(4);
        this.bcP.data[0] = (byte) -1;
        this.bcQ = new C0852j();
        this.aOt = str;
        AppMethodBeat.m2505o(95137);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        this.state = 0;
        this.bcR = 0;
        this.bcS = false;
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95138);
        c8661d.mo19155rz();
        this.bbx = c8661d.mo19154rB();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        AppMethodBeat.m2505o(95138);
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        this.aSk = j;
    }

    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        AppMethodBeat.m2504i(95139);
        while (c32065l.mo52382tB() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    byte[] bArr = c32065l.data;
                    i = c32065l.position;
                    int i2 = c32065l.limit;
                    int i3 = i;
                    while (i3 < i2) {
                        int i4;
                        boolean z = (bArr[i3] & 255) == 255;
                        if (this.bcS && (bArr[i3] & 224) == 224) {
                            i4 = 1;
                        } else {
                            boolean i42 = false;
                        }
                        this.bcS = z;
                        if (i42 != 0) {
                            c32065l.setPosition(i3 + 1);
                            this.bcS = false;
                            this.bcP.data[1] = bArr[i3];
                            this.bcR = 2;
                            this.state = 1;
                            break;
                        }
                        i3++;
                    }
                    c32065l.setPosition(i2);
                    break;
                case 1:
                    i = Math.min(c32065l.mo52382tB(), 4 - this.bcR);
                    c32065l.readBytes(this.bcP.data, this.bcR, i);
                    this.bcR = i + this.bcR;
                    if (this.bcR < 4) {
                        break;
                    }
                    this.bcP.setPosition(0);
                    if (!C0852j.m1952a(this.bcP.readInt(), this.bcQ)) {
                        this.bcR = 0;
                        this.state = 1;
                        break;
                    }
                    this.aPy = this.bcQ.aPy;
                    if (!this.aTf) {
                        this.bbL = (1000000 * ((long) this.bcQ.aTa)) / ((long) this.bcQ.sampleRate);
                        this.aTw.mo42836f(Format.m15271a(this.bbx, this.bcQ.mimeType, -1, 4096, this.bcQ.channels, this.bcQ.sampleRate, null, null, this.aOt));
                        this.aTf = true;
                    }
                    this.bcP.setPosition(0);
                    this.aTw.mo42835a(this.bcP, 4);
                    this.state = 2;
                    break;
                case 2:
                    i = Math.min(c32065l.mo52382tB(), this.aPy - this.bcR);
                    this.aTw.mo42835a(c32065l, i);
                    this.bcR = i + this.bcR;
                    if (this.bcR < this.aPy) {
                        break;
                    }
                    this.aTw.mo42834a(this.aSk, 1, this.aPy, 0, null);
                    this.aSk += this.bbL;
                    this.bcR = 0;
                    this.state = 0;
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.m2505o(95139);
    }

    /* renamed from: ro */
    public final void mo2558ro() {
    }
}
