package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.e.c */
public final class C17639c implements C32034e {
    public static final C32039h aTh = new C176381();
    private C32031h aZR;
    private C8662g baf;
    private boolean bag;

    /* renamed from: com.google.android.exoplayer2.c.e.c$1 */
    static class C176381 implements C32039h {
        C176381() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(95033);
            C32034e[] c32034eArr = new C32034e[]{new C17639c()};
            AppMethodBeat.m2505o(95033);
            return c32034eArr;
        }
    }

    static {
        AppMethodBeat.m2504i(95038);
        AppMethodBeat.m2505o(95038);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(95034);
        try {
            boolean j = m27470j(c45026f);
            AppMethodBeat.m2505o(95034);
            return j;
        } catch (C37269o e) {
            AppMethodBeat.m2505o(95034);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        this.baf = c8662g;
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(95035);
        if (this.aZR != null) {
            this.aZR.mo52330g(j, j2);
        }
        AppMethodBeat.m2505o(95035);
    }

    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        AppMethodBeat.m2504i(95036);
        if (this.aZR == null) {
            if (m27470j(c45026f)) {
                c45026f.mo59486qY();
            } else {
                C37269o c37269o = new C37269o("Failed to determine bitstream type");
                AppMethodBeat.m2505o(95036);
                throw c37269o;
            }
        }
        if (!this.bag) {
            C32041m dM = this.baf.mo19157dM(0);
            this.baf.mo19158rb();
            this.aZR.mo52328a(this.baf, dM);
            this.bag = true;
        }
        C32031h c32031h = this.aZR;
        int l;
        switch (c32031h.state) {
            case 0:
                l = c32031h.mo52331l(c45026f);
                AppMethodBeat.m2505o(95036);
                return l;
            case 1:
                c45026f.mo59482dG((int) c32031h.bay);
                c32031h.state = 2;
                AppMethodBeat.m2505o(95036);
                return 0;
            case 2:
                l = c32031h.mo52329b(c45026f, c32040k);
                AppMethodBeat.m2505o(95036);
                return l;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(95036);
                throw illegalStateException;
        }
    }

    /* renamed from: j */
    private boolean m27470j(C45026f c45026f) {
        AppMethodBeat.m2504i(95037);
        C32030e c32030e = new C32030e();
        if (c32030e.mo52324c(c45026f, true) && (c32030e.type & 2) == 2) {
            int min = Math.min(c32030e.bar, 8);
            C32065l c32065l = new C32065l(min);
            c45026f.mo59479b(c32065l.data, 0, min);
            c32065l.setPosition(0);
            if (C25520b.m40325r(c32065l)) {
                this.aZR = new C25520b();
            } else {
                c32065l.setPosition(0);
                if (C17640j.m27475r(c32065l)) {
                    this.aZR = new C17640j();
                } else {
                    c32065l.setPosition(0);
                    if (C36684g.m60844r(c32065l)) {
                        this.aZR = new C36684g();
                    } else {
                        AppMethodBeat.m2505o(95037);
                        return false;
                    }
                }
            }
            AppMethodBeat.m2505o(95037);
            return true;
        }
        AppMethodBeat.m2505o(95037);
        return false;
    }
}
