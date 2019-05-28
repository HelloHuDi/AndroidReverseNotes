package com.google.android.exoplayer2.c.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Arrays;
import java.util.Collections;

public final class d implements h {
    private static final byte[] bbt = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    private final String aOt;
    long aSk;
    private boolean aTf;
    private m aTw;
    private boolean bbA;
    private m bbB;
    private long bbC;
    private int bbo;
    private long bbq;
    private final boolean bbu;
    private final k bbv;
    private final l bbw;
    private String bbx;
    private m bby;
    private int bbz;
    private int sampleSize;
    private int state;

    public d() {
        this(true, null);
    }

    public d(boolean z, String str) {
        AppMethodBeat.i(95088);
        this.bbv = new k(new byte[7]);
        this.bbw = new l(Arrays.copyOf(bbt, 10));
        rq();
        this.bbu = z;
        this.aOt = str;
        AppMethodBeat.o(95088);
    }

    public final void rn() {
        AppMethodBeat.i(139057);
        rq();
        AppMethodBeat.o(139057);
    }

    public final void a(g gVar, com.google.android.exoplayer2.c.f.v.d dVar) {
        AppMethodBeat.i(95090);
        dVar.rz();
        this.bbx = dVar.rB();
        this.aTw = gVar.dM(dVar.rA());
        if (this.bbu) {
            dVar.rz();
            this.bby = gVar.dM(dVar.rA());
            this.bby.f(Format.k(dVar.rB(), "application/id3"));
            AppMethodBeat.o(95090);
            return;
        }
        this.bby = new com.google.android.exoplayer2.c.d();
        AppMethodBeat.o(95090);
    }

    public final void d(long j, boolean z) {
        this.aSk = j;
    }

    public final void t(l lVar) {
        AppMethodBeat.i(95091);
        while (lVar.tB() > 0) {
            switch (this.state) {
                case 0:
                    v(lVar);
                    break;
                case 1:
                    if (!a(lVar, this.bbw.data, 10)) {
                        break;
                    }
                    rt();
                    break;
                case 2:
                    if (!a(lVar, this.bbv.data, this.bbA ? 7 : 5)) {
                        break;
                    }
                    ru();
                    break;
                case 3:
                    w(lVar);
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.o(95091);
    }

    public final void ro() {
    }

    private boolean a(l lVar, byte[] bArr, int i) {
        AppMethodBeat.i(95092);
        int min = Math.min(lVar.tB(), i - this.bbo);
        lVar.readBytes(bArr, this.bbo, min);
        this.bbo = min + this.bbo;
        if (this.bbo == i) {
            AppMethodBeat.o(95092);
            return true;
        }
        AppMethodBeat.o(95092);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void rq() {
        this.state = 0;
        this.bbo = 0;
        this.bbz = 256;
    }

    private void rr() {
        AppMethodBeat.i(95093);
        this.state = 1;
        this.bbo = bbt.length;
        this.sampleSize = 0;
        this.bbw.setPosition(0);
        AppMethodBeat.o(95093);
    }

    private void a(m mVar, long j, int i, int i2) {
        this.state = 3;
        this.bbo = i;
        this.bbB = mVar;
        this.bbC = j;
        this.sampleSize = i2;
    }

    private void rs() {
        this.state = 2;
        this.bbo = 0;
    }

    private void v(l lVar) {
        AppMethodBeat.i(95094);
        byte[] bArr = lVar.data;
        int i = lVar.position;
        int i2 = lVar.limit;
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
                        rr();
                        lVar.setPosition(i);
                        AppMethodBeat.o(95094);
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
            rs();
            lVar.setPosition(i);
            AppMethodBeat.o(95094);
            return;
        }
        lVar.setPosition(i3);
        AppMethodBeat.o(95094);
    }

    private void rt() {
        AppMethodBeat.i(95095);
        this.bby.a(this.bbw, 10);
        this.bbw.setPosition(6);
        a(this.bby, 0, 10, this.bbw.tH() + 10);
        AppMethodBeat.o(95095);
    }

    private void ru() {
        int i = 2;
        AppMethodBeat.i(95096);
        this.bbv.setPosition(0);
        if (this.aTf) {
            this.bbv.ee(10);
        } else {
            int ed = this.bbv.ed(2) + 1;
            if (ed != 2) {
                new StringBuilder("Detected audio object type: ").append(ed).append(", but assuming AAC LC.");
            } else {
                i = ed;
            }
            ed = this.bbv.ed(4);
            this.bbv.ee(1);
            byte[] t = c.t(i, ed, this.bbv.ed(3));
            Pair q = c.q(t);
            Format a = Format.a(this.bbx, "audio/mp4a-latm", -1, -1, ((Integer) q.second).intValue(), ((Integer) q.first).intValue(), Collections.singletonList(t), null, this.aOt);
            this.bbq = 1024000000 / ((long) a.sampleRate);
            this.aTw.f(a);
            this.aTf = true;
        }
        this.bbv.ee(4);
        int ed2 = (this.bbv.ed(13) - 2) - 5;
        if (this.bbA) {
            ed2 -= 2;
        }
        a(this.aTw, this.bbq, 0, ed2);
        AppMethodBeat.o(95096);
    }

    private void w(l lVar) {
        AppMethodBeat.i(95097);
        int min = Math.min(lVar.tB(), this.sampleSize - this.bbo);
        this.bbB.a(lVar, min);
        this.bbo = min + this.bbo;
        if (this.bbo == this.sampleSize) {
            this.bbB.a(this.aSk, 1, this.sampleSize, 0, null);
            this.aSk += this.bbC;
            rq();
        }
        AppMethodBeat.o(95097);
    }
}
