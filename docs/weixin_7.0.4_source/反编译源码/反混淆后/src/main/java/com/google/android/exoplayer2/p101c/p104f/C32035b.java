package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p099a.C32018a;
import com.google.android.exoplayer2.p099a.C32018a.C8638a;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

/* renamed from: com.google.android.exoplayer2.c.f.b */
public final class C32035b implements C0845h {
    private final String aOt;
    private Format aOv;
    long aSk;
    private C32041m aTw;
    private final C32064k bbl;
    private final C32065l bbm;
    private String bbn;
    private int bbo;
    private boolean bbp;
    private long bbq;
    private int sampleSize;
    private int state;

    public C32035b() {
        this(null);
    }

    public C32035b(String str) {
        AppMethodBeat.m2504i(95075);
        this.bbl = new C32064k(new byte[8]);
        this.bbm = new C32065l(this.bbl.data);
        this.state = 0;
        this.aOt = str;
        AppMethodBeat.m2505o(95075);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        this.state = 0;
        this.bbo = 0;
        this.bbp = false;
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95076);
        c8661d.mo19155rz();
        this.bbn = c8661d.mo19154rB();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        AppMethodBeat.m2505o(95076);
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        this.aSk = j;
    }

    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        AppMethodBeat.m2504i(95077);
        while (c32065l.mo52382tB() > 0) {
            switch (this.state) {
                case 0:
                    if (!m52053u(c32065l)) {
                        break;
                    }
                    this.state = 1;
                    this.bbm.data[0] = (byte) 11;
                    this.bbm.data[1] = (byte) 119;
                    this.bbo = 2;
                    break;
                case 1:
                    if (!m52051a(c32065l, this.bbm.data)) {
                        break;
                    }
                    m52052rp();
                    this.bbm.setPosition(0);
                    this.aTw.mo42835a(this.bbm, 8);
                    this.state = 2;
                    break;
                case 2:
                    int min = Math.min(c32065l.mo52382tB(), this.sampleSize - this.bbo);
                    this.aTw.mo42835a(c32065l, min);
                    this.bbo = min + this.bbo;
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
        AppMethodBeat.m2505o(95077);
    }

    /* renamed from: ro */
    public final void mo2558ro() {
    }

    /* renamed from: a */
    private boolean m52051a(C32065l c32065l, byte[] bArr) {
        AppMethodBeat.m2504i(95078);
        int min = Math.min(c32065l.mo52382tB(), 8 - this.bbo);
        c32065l.readBytes(bArr, this.bbo, min);
        this.bbo = min + this.bbo;
        if (this.bbo == 8) {
            AppMethodBeat.m2505o(95078);
            return true;
        }
        AppMethodBeat.m2505o(95078);
        return false;
    }

    /* renamed from: u */
    private boolean m52053u(C32065l c32065l) {
        AppMethodBeat.m2504i(95079);
        while (c32065l.mo52382tB() > 0) {
            if (this.bbp) {
                int readUnsignedByte = c32065l.readUnsignedByte();
                if (readUnsignedByte == C31128d.MIC_AVROUND_BLUR) {
                    this.bbp = false;
                    AppMethodBeat.m2505o(95079);
                    return true;
                }
                this.bbp = readUnsignedByte == 11;
            } else {
                this.bbp = c32065l.readUnsignedByte() == 11;
            }
        }
        AppMethodBeat.m2505o(95079);
        return false;
    }

    /* renamed from: rp */
    private void m52052rp() {
        AppMethodBeat.m2504i(95080);
        this.bbl.setPosition(0);
        C8638a a = C32018a.m51990a(this.bbl);
        if (!(this.aOv != null && a.aOn == this.aOv.aOn && a.sampleRate == this.aOv.sampleRate && a.mimeType == this.aOv.aOd)) {
            this.aOv = Format.m15271a(this.bbn, a.mimeType, -1, -1, a.aOn, a.sampleRate, null, null, this.aOt);
            this.aTw.mo42836f(this.aOv);
        }
        this.sampleSize = a.aPy;
        this.bbq = (1000000 * ((long) a.sampleCount)) / ((long) this.aOv.sampleRate);
        AppMethodBeat.m2505o(95080);
    }
}
