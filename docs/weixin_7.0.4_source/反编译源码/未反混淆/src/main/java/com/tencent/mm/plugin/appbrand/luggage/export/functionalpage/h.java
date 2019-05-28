package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.model.a;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.g;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.plugin.appbrand.report.model.p;

@SuppressLint({"ViewConstructor"})
public final class h extends r {
    public h(j jVar) {
        super(jVar.atM(), jVar);
        AppMethodBeat.i(132130);
        AppMethodBeat.o(132130);
    }

    public final g aHU() {
        AppMethodBeat.i(132131);
        AnonymousClass1 anonymousClass1 = new g() {
            private final i ikv = new d(a.d(h.this.getRuntime().atI().hgF));

            {
                AppMethodBeat.i(132124);
                AppMethodBeat.o(132124);
            }

            public final void aHW() {
            }

            public final void a(long j, aq aqVar) {
            }

            public final void a(w wVar) {
                AppMethodBeat.i(132125);
                b(wVar);
                AppMethodBeat.o(132125);
            }

            public final i aHX() {
                return this.ikv;
            }

            public final void F(Intent intent) {
            }

            public final Intent aHY() {
                return null;
            }

            public final p aHZ() {
                AppMethodBeat.i(132126);
                p aLy = p.aLy();
                AppMethodBeat.o(132126);
                return aLy;
            }

            public final void aIa() {
            }

            public final void resetSession() {
            }

            public final void a(w wVar, w wVar2, aq aqVar) {
                AppMethodBeat.i(132127);
                this.ikv.a(wVar, wVar2, aqVar);
                AppMethodBeat.o(132127);
            }

            public final void b(w wVar) {
                AppMethodBeat.i(132128);
                this.ikv.b(wVar);
                AppMethodBeat.o(132128);
            }

            public final void c(w wVar) {
                AppMethodBeat.i(132129);
                this.ikv.c(wVar);
                AppMethodBeat.o(132129);
            }
        };
        AppMethodBeat.o(132131);
        return anonymousClass1;
    }

    public final u aHV() {
        AppMethodBeat.i(132132);
        i iVar = new i();
        AppMethodBeat.o(132132);
        return iVar;
    }
}
