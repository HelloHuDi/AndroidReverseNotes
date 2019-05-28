package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements e {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(95033);
            e[] eVarArr = new e[]{new c()};
            AppMethodBeat.o(95033);
            return eVarArr;
        }
    };
    private h aZR;
    private g baf;
    private boolean bag;

    static {
        AppMethodBeat.i(95038);
        AppMethodBeat.o(95038);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(95034);
        try {
            boolean j = j(fVar);
            AppMethodBeat.o(95034);
            return j;
        } catch (o e) {
            AppMethodBeat.o(95034);
            return false;
        }
    }

    public final void a(g gVar) {
        this.baf = gVar;
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(95035);
        if (this.aZR != null) {
            this.aZR.g(j, j2);
        }
        AppMethodBeat.o(95035);
    }

    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(95036);
        if (this.aZR == null) {
            if (j(fVar)) {
                fVar.qY();
            } else {
                o oVar = new o("Failed to determine bitstream type");
                AppMethodBeat.o(95036);
                throw oVar;
            }
        }
        if (!this.bag) {
            m dM = this.baf.dM(0);
            this.baf.rb();
            this.aZR.a(this.baf, dM);
            this.bag = true;
        }
        h hVar = this.aZR;
        int l;
        switch (hVar.state) {
            case 0:
                l = hVar.l(fVar);
                AppMethodBeat.o(95036);
                return l;
            case 1:
                fVar.dG((int) hVar.bay);
                hVar.state = 2;
                AppMethodBeat.o(95036);
                return 0;
            case 2:
                l = hVar.b(fVar, kVar);
                AppMethodBeat.o(95036);
                return l;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(95036);
                throw illegalStateException;
        }
    }

    private boolean j(f fVar) {
        AppMethodBeat.i(95037);
        e eVar = new e();
        if (eVar.c(fVar, true) && (eVar.type & 2) == 2) {
            int min = Math.min(eVar.bar, 8);
            l lVar = new l(min);
            fVar.b(lVar.data, 0, min);
            lVar.setPosition(0);
            if (b.r(lVar)) {
                this.aZR = new b();
            } else {
                lVar.setPosition(0);
                if (j.r(lVar)) {
                    this.aZR = new j();
                } else {
                    lVar.setPosition(0);
                    if (g.r(lVar)) {
                        this.aZR = new g();
                    } else {
                        AppMethodBeat.o(95037);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(95037);
            return true;
        }
        AppMethodBeat.o(95037);
        return false;
    }
}
