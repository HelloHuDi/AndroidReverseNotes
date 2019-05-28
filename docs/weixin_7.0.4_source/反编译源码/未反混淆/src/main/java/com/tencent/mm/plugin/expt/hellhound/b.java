package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.c.e;
import com.tencent.mm.plugin.expt.hellhound.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.c.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements com.tencent.mm.plugin.expt.a.b {
    public static void d(g gVar) {
        AppMethodBeat.i(73338);
        if (gVar == null) {
            AppMethodBeat.o(73338);
        } else if (a.bqj()) {
            ab.i("HellhoundService", "habbyge-mali, IHellhoundService Start !!!");
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.expt.a.b.class, new b());
            com.tencent.mm.plugin.expt.a.b bVar = (com.tencent.mm.plugin.expt.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.b.class);
            bVar.a(new a() {
                public final void KM(String str) {
                    AppMethodBeat.i(73326);
                    ab.d("HellhoundService", "habbyge-mali, callback, startActivity: ".concat(String.valueOf(str)));
                    AppMethodBeat.o(73326);
                }

                public final void ea(String str, String str2) {
                    AppMethodBeat.i(73327);
                    com.tencent.mm.plugin.expt.hellhound.a.a.b.s(103, str, str2);
                    AppMethodBeat.o(73327);
                }

                public final void eb(String str, String str2) {
                    AppMethodBeat.i(73328);
                    com.tencent.mm.plugin.expt.hellhound.a.a.b.s(103, str, str2);
                    AppMethodBeat.o(73328);
                }

                public final void B(Activity activity) {
                    AppMethodBeat.i(73329);
                    String canonicalName = activity.getClass().getCanonicalName();
                    com.tencent.mm.plugin.expt.hellhound.a.a.b.s(100, canonicalName, String.valueOf(activity.hashCode()));
                    d.a(0, canonicalName, activity);
                    AppMethodBeat.o(73329);
                }

                public final void C(Activity activity) {
                    AppMethodBeat.i(73330);
                    if (activity == null) {
                        AppMethodBeat.o(73330);
                        return;
                    }
                    String canonicalName = activity.getClass().getCanonicalName();
                    com.tencent.mm.plugin.expt.hellhound.a.a.b.s(101, canonicalName, String.valueOf(activity.hashCode()));
                    d.a(1, canonicalName, activity);
                    AppMethodBeat.o(73330);
                }

                public final void D(Activity activity) {
                    AppMethodBeat.i(73331);
                    if (activity == null) {
                        AppMethodBeat.o(73331);
                        return;
                    }
                    com.tencent.mm.plugin.expt.hellhound.a.a.b.s(102, activity.getClass().getCanonicalName(), String.valueOf(activity.hashCode()));
                    AppMethodBeat.o(73331);
                }

                public final void E(Activity activity) {
                    AppMethodBeat.i(73332);
                    if (activity == null) {
                        AppMethodBeat.o(73332);
                        return;
                    }
                    d.a(2, activity.getClass().getCanonicalName(), activity);
                    AppMethodBeat.o(73332);
                }
            });
            bVar.a(new com.tencent.mm.plugin.expt.a.b.b() {
                public final void ec(String str, String str2) {
                    AppMethodBeat.i(73333);
                    c.a(str, Integer.valueOf(str2).intValue(), com.tencent.mm.plugin.expt.a.c.a.MMActivity_Back2Front);
                    AppMethodBeat.o(73333);
                }

                public final void ed(String str, String str2) {
                    AppMethodBeat.i(73334);
                    c.a(str, Integer.valueOf(str2).intValue(), com.tencent.mm.plugin.expt.a.c.a.MMActivity_Front2Back);
                    AppMethodBeat.o(73334);
                }

                public final void a(String str, String str2, int i, long j, int i2) {
                    AppMethodBeat.i(73335);
                    ab.i("HellhoundService", "habbyge-mali, frontToBackMMProcessEnd: " + str + "/" + i);
                    int intValue = Integer.valueOf(str2).intValue();
                    com.tencent.mm.plugin.expt.a.c.a aVar = com.tencent.mm.plugin.expt.a.c.a.MMActivity_Front2Back;
                    w wVar = new w();
                    wVar.cWc = i;
                    w eT = wVar.eS(((h) com.tencent.mm.kernel.g.RM().Rn()).eHT).eT(str);
                    eT.cYc = (long) i2;
                    eT.cWS = (long) aVar.value;
                    eT = eT.aQ(j);
                    eT.cWU = (long) intValue;
                    e.brf().a(eT);
                    ab.i("HellFrontBackReport", "habbyge-mali, [进程尾部补偿8] frontback-pure-report [%s]", eT.Fk());
                    AppMethodBeat.o(73335);
                }
            });
            com.tencent.mm.plugin.expt.hellhound.core.a.bqm();
            com.tencent.mm.plugin.expt.hellhound.core.a.a(new f() {
                public final void a(be beVar) {
                    AppMethodBeat.i(73336);
                    if (beVar != null) {
                        d.a(3, beVar.vDg.activityName, null);
                    }
                    AppMethodBeat.o(73336);
                }

                public final void b(be beVar) {
                    AppMethodBeat.i(73337);
                    if (beVar != null) {
                        d.a(3, beVar.vDg.activityName, null);
                    }
                    AppMethodBeat.o(73337);
                }
            });
            bVar.f(gVar.cc);
            com.tencent.mm.plugin.expt.hellhound.a.a.b.s(104, "", "");
            AppMethodBeat.o(73338);
        } else {
            ab.w("HellhoundService", "habbyge-mali, IHellhoundService Close !!!");
            AppMethodBeat.o(73338);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(73339);
        com.tencent.mm.plugin.expt.hellhound.core.a bqm = com.tencent.mm.plugin.expt.hellhound.core.a.bqm();
        if (com.tencent.mm.plugin.expt.hellhound.core.a.bqn()) {
            bqm.lMk.a(aVar);
        }
        AppMethodBeat.o(73339);
    }

    public final void a(com.tencent.mm.plugin.expt.a.b.b bVar) {
        AppMethodBeat.i(73340);
        com.tencent.mm.plugin.expt.hellhound.a.a.b.bqF().lMP = bVar;
        AppMethodBeat.o(73340);
    }

    public final void f(Application application) {
        AppMethodBeat.i(73341);
        com.tencent.mm.plugin.expt.hellhound.core.a bqm = com.tencent.mm.plugin.expt.hellhound.core.a.bqm();
        ab.i("Hellhound", "habbyge-Hellhound.startMonitor()");
        if (com.tencent.mm.plugin.expt.hellhound.core.a.bqn()) {
            bqm.lMk.g(application);
        }
        AppMethodBeat.o(73341);
    }
}
