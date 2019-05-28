package com.google.android.exoplayer2.p101c.p1370g;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;

/* renamed from: com.google.android.exoplayer2.c.g.c */
final class C37246c {

    /* renamed from: com.google.android.exoplayer2.c.g.c$a */
    static final class C25531a {
        /* renamed from: id */
        public final int f5221id;
        public final long size;

        private C25531a(int i, long j) {
            this.f5221id = i;
            this.size = j;
        }

        /* renamed from: a */
        public static C25531a m40349a(C45026f c45026f, C32065l c32065l) {
            AppMethodBeat.m2504i(95190);
            c45026f.mo59479b(c32065l.data, 0, 8);
            c32065l.setPosition(0);
            C25531a c25531a = new C25531a(c32065l.readInt(), c32065l.mo52385tE());
            AppMethodBeat.m2505o(95190);
            return c25531a;
        }
    }

    /* renamed from: m */
    public static C45027b m62494m(C45026f c45026f) {
        AppMethodBeat.m2504i(95191);
        C45039a.checkNotNull(c45026f);
        C32065l c32065l = new C32065l(16);
        if (C25531a.m40349a(c45026f, c32065l).f5221id != C17675v.m27562aT("RIFF")) {
            AppMethodBeat.m2505o(95191);
            return null;
        }
        c45026f.mo59479b(c32065l.data, 0, 4);
        c32065l.setPosition(0);
        if (c32065l.readInt() != C17675v.m27562aT("WAVE")) {
            AppMethodBeat.m2505o(95191);
            return null;
        }
        C25531a a;
        while (true) {
            a = C25531a.m40349a(c45026f, c32065l);
            if (a.f5221id == C17675v.m27562aT("fmt ")) {
                break;
            }
            c45026f.mo59483dH((int) a.size);
        }
        C45039a.checkState(a.size >= 16);
        c45026f.mo59479b(c32065l.data, 0, 16);
        c32065l.setPosition(0);
        int tC = c32065l.mo52383tC();
        int tC2 = c32065l.mo52383tC();
        int tJ = c32065l.mo52390tJ();
        int tJ2 = c32065l.mo52390tJ();
        int tC3 = c32065l.mo52383tC();
        int tC4 = c32065l.mo52383tC();
        int i = (tC2 * tC4) / 8;
        if (tC3 != i) {
            C37269o c37269o = new C37269o("Expected block alignment: " + i + "; got: " + tC3);
            AppMethodBeat.m2505o(95191);
            throw c37269o;
        }
        i = C17675v.m27569eR(tC4);
        if (i == 0) {
            AppMethodBeat.m2505o(95191);
            return null;
        } else if (tC == 1 || tC == BitUtils.BIT_TURN_ZERO_1) {
            c45026f.mo59483dH(((int) a.size) - 16);
            C45027b c45027b = new C45027b(tC2, tJ, tJ2, tC3, tC4, i);
            AppMethodBeat.m2505o(95191);
            return c45027b;
        } else {
            AppMethodBeat.m2505o(95191);
            return null;
        }
    }
}
