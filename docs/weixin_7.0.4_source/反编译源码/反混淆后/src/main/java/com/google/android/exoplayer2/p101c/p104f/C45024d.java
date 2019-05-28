package com.google.android.exoplayer2.p101c.p104f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C36683d;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32062c;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Arrays;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.c.f.d */
public final class C45024d implements C0845h {
    private static final byte[] bbt = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    private final String aOt;
    long aSk;
    private boolean aTf;
    private C32041m aTw;
    private boolean bbA;
    private C32041m bbB;
    private long bbC;
    private int bbo;
    private long bbq;
    private final boolean bbu;
    private final C32064k bbv;
    private final C32065l bbw;
    private String bbx;
    private C32041m bby;
    private int bbz;
    private int sampleSize;
    private int state;

    public C45024d() {
        this(true, null);
    }

    public C45024d(boolean z, String str) {
        AppMethodBeat.m2504i(95088);
        this.bbv = new C32064k(new byte[7]);
        this.bbw = new C32065l(Arrays.copyOf(bbt, 10));
        mo72543rq();
        this.bbu = z;
        this.aOt = str;
        AppMethodBeat.m2505o(95088);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        AppMethodBeat.m2504i(139057);
        mo72543rq();
        AppMethodBeat.m2505o(139057);
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95090);
        c8661d.mo19155rz();
        this.bbx = c8661d.mo19154rB();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        if (this.bbu) {
            c8661d.mo19155rz();
            this.bby = c8662g.mo19157dM(c8661d.mo19153rA());
            this.bby.mo42836f(Format.m15288k(c8661d.mo19154rB(), "application/id3"));
            AppMethodBeat.m2505o(95090);
            return;
        }
        this.bby = new C36683d();
        AppMethodBeat.m2505o(95090);
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        this.aSk = j;
    }

    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        AppMethodBeat.m2504i(95091);
        while (c32065l.mo52382tB() > 0) {
            switch (this.state) {
                case 0:
                    m82499v(c32065l);
                    break;
                case 1:
                    if (!m82494a(c32065l, this.bbw.data, 10)) {
                        break;
                    }
                    m82497rt();
                    break;
                case 2:
                    if (!m82494a(c32065l, this.bbv.data, this.bbA ? 7 : 5)) {
                        break;
                    }
                    m82498ru();
                    break;
                case 3:
                    m82500w(c32065l);
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.m2505o(95091);
    }

    /* renamed from: ro */
    public final void mo2558ro() {
    }

    /* renamed from: a */
    private boolean m82494a(C32065l c32065l, byte[] bArr, int i) {
        AppMethodBeat.m2504i(95092);
        int min = Math.min(c32065l.mo52382tB(), i - this.bbo);
        c32065l.readBytes(bArr, this.bbo, min);
        this.bbo = min + this.bbo;
        if (this.bbo == i) {
            AppMethodBeat.m2505o(95092);
            return true;
        }
        AppMethodBeat.m2505o(95092);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: rq */
    public final void mo72543rq() {
        this.state = 0;
        this.bbo = 0;
        this.bbz = 256;
    }

    /* renamed from: rr */
    private void m82495rr() {
        AppMethodBeat.m2504i(95093);
        this.state = 1;
        this.bbo = bbt.length;
        this.sampleSize = 0;
        this.bbw.setPosition(0);
        AppMethodBeat.m2505o(95093);
    }

    /* renamed from: a */
    private void m82493a(C32041m c32041m, long j, int i, int i2) {
        this.state = 3;
        this.bbo = i;
        this.bbB = c32041m;
        this.bbC = j;
        this.sampleSize = i2;
    }

    /* renamed from: rs */
    private void m82496rs() {
        this.state = 2;
        this.bbo = 0;
    }

    /* renamed from: v */
    private void m82499v(C32065l c32065l) {
        AppMethodBeat.m2504i(95094);
        byte[] bArr = c32065l.data;
        int i = c32065l.position;
        int i2 = c32065l.limit;
        int i3 = i;
        while (i3 < i2) {
            i = i3 + 1;
            i3 = bArr[i3] & 255;
            if (this.bbz != 512 || i3 < 240 || i3 == 255) {
                switch (i3 | this.bbz) {
                    case ErrorCode.ERROR_GETSTRINGARRAY_JARFILE /*329*/:
                        this.bbz = 768;
                        i3 = i;
                        break;
                    case ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED /*511*/:
                        this.bbz = 512;
                        i3 = i;
                        break;
                    case 836:
                        this.bbz = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i3 = i;
                        break;
                    case FilterEnum4Shaka.MIC_WEISHI_LIUJIN /*1075*/:
                        m82495rr();
                        c32065l.setPosition(i);
                        AppMethodBeat.m2505o(95094);
                        return;
                    default:
                        if (this.bbz == 256) {
                            i3 = i;
                            break;
                        }
                        this.bbz = 256;
                        i3 = i - 1;
                        break;
                }
            }
            this.bbA = (i3 & 1) == 0;
            m82496rs();
            c32065l.setPosition(i);
            AppMethodBeat.m2505o(95094);
            return;
        }
        c32065l.setPosition(i3);
        AppMethodBeat.m2505o(95094);
    }

    /* renamed from: rt */
    private void m82497rt() {
        AppMethodBeat.m2504i(95095);
        this.bby.mo42835a(this.bbw, 10);
        this.bbw.setPosition(6);
        m82493a(this.bby, 0, 10, this.bbw.mo52388tH() + 10);
        AppMethodBeat.m2505o(95095);
    }

    /* renamed from: ru */
    private void m82498ru() {
        int i = 2;
        AppMethodBeat.m2504i(95096);
        this.bbv.setPosition(0);
        if (this.aTf) {
            this.bbv.mo52355ee(10);
        } else {
            int ed = this.bbv.mo52354ed(2) + 1;
            if (ed != 2) {
                new StringBuilder("Detected audio object type: ").append(ed).append(", but assuming AAC LC.");
            } else {
                i = ed;
            }
            ed = this.bbv.mo52354ed(4);
            this.bbv.mo52355ee(1);
            byte[] t = C32062c.m52122t(i, ed, this.bbv.mo52354ed(3));
            Pair q = C32062c.m52121q(t);
            Format a = Format.m15271a(this.bbx, "audio/mp4a-latm", -1, -1, ((Integer) q.second).intValue(), ((Integer) q.first).intValue(), Collections.singletonList(t), null, this.aOt);
            this.bbq = 1024000000 / ((long) a.sampleRate);
            this.aTw.mo42836f(a);
            this.aTf = true;
        }
        this.bbv.mo52355ee(4);
        int ed2 = (this.bbv.mo52354ed(13) - 2) - 5;
        if (this.bbA) {
            ed2 -= 2;
        }
        m82493a(this.aTw, this.bbq, 0, ed2);
        AppMethodBeat.m2505o(95096);
    }

    /* renamed from: w */
    private void m82500w(C32065l c32065l) {
        AppMethodBeat.m2504i(95097);
        int min = Math.min(c32065l.mo52382tB(), this.sampleSize - this.bbo);
        this.bbB.mo42835a(c32065l, min);
        this.bbo = min + this.bbo;
        if (this.bbo == this.sampleSize) {
            this.bbB.mo42834a(this.aSk, 1, this.sampleSize, 0, null);
            this.aSk += this.bbC;
            mo72543rq();
        }
        AppMethodBeat.m2505o(95097);
    }
}
