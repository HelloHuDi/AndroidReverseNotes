package com.google.android.exoplayer2.p101c.p104f;

import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C37247l.C17646a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.f.c */
public final class C37238c implements C32034e {
    public static final C32039h aTh = new C86581();
    private static final int bbg = C17675v.m27562aT("ID3");
    private final long bbh;
    private boolean bbk;
    private final C45024d bbr;
    private final C32065l bbs;

    /* renamed from: com.google.android.exoplayer2.c.f.c$1 */
    static class C86581 implements C32039h {
        C86581() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(95081);
            C32034e[] c32034eArr = new C32034e[]{new C37238c()};
            AppMethodBeat.m2505o(95081);
            return c32034eArr;
        }
    }

    static {
        AppMethodBeat.m2504i(95087);
        AppMethodBeat.m2505o(95087);
    }

    public C37238c() {
        this(0);
    }

    public C37238c(long j) {
        AppMethodBeat.m2504i(95082);
        this.bbh = j;
        this.bbr = new C45024d();
        this.bbs = new C32065l(200);
        AppMethodBeat.m2505o(95082);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        int tH;
        AppMethodBeat.m2504i(95083);
        C32065l c32065l = new C32065l(10);
        C32064k c32064k = new C32064k(c32065l.data);
        int i = 0;
        while (true) {
            c45026f.mo59479b(c32065l.data, 0, 10);
            c32065l.setPosition(0);
            if (c32065l.mo52384tD() != bbg) {
                break;
            }
            c32065l.mo52369eM(3);
            tH = c32065l.mo52388tH();
            i += tH + 10;
            c45026f.mo59483dH(tH);
        }
        c45026f.mo59486qY();
        c45026f.mo59483dH(i);
        tH = 0;
        int i2 = 0;
        int i3 = i;
        while (true) {
            c45026f.mo59479b(c32065l.data, 0, 2);
            c32065l.setPosition(0);
            if ((c32065l.readUnsignedShort() & 65526) != 65520) {
                c45026f.mo59486qY();
                i3++;
                if (i3 - i >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    AppMethodBeat.m2505o(95083);
                    return false;
                }
                c45026f.mo59483dH(i3);
                tH = 0;
                i2 = 0;
            } else {
                tH++;
                if (tH < 4 || i2 <= 188) {
                    c45026f.mo59479b(c32065l.data, 0, 4);
                    c32064k.setPosition(14);
                    int ed = c32064k.mo52354ed(13);
                    if (ed <= 6) {
                        AppMethodBeat.m2505o(95083);
                        return false;
                    }
                    c45026f.mo59483dH(ed - 6);
                    i2 += ed;
                } else {
                    AppMethodBeat.m2505o(95083);
                    return true;
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        AppMethodBeat.m2504i(95084);
        this.bbr.mo2555a(c8662g, new C8661d(0, 1));
        c8662g.mo19158rb();
        c8662g.mo19156a(new C17646a(-9223372036854775807L));
        AppMethodBeat.m2505o(95084);
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(95085);
        this.bbk = false;
        this.bbr.mo72543rq();
        AppMethodBeat.m2505o(95085);
    }

    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        AppMethodBeat.m2504i(95086);
        int read = c45026f.read(this.bbs.data, 0, 200);
        if (read == -1) {
            AppMethodBeat.m2505o(95086);
            return -1;
        }
        this.bbs.setPosition(0);
        this.bbs.mo52368eL(read);
        if (!this.bbk) {
            this.bbr.aSk = this.bbh;
            this.bbk = true;
        }
        this.bbr.mo2559t(this.bbs);
        AppMethodBeat.m2505o(95086);
        return 0;
    }
}
