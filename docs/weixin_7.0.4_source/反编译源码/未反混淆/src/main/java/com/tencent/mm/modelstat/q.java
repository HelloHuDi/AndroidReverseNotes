package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.ci.c;
import com.tencent.mm.ci.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.at;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.network.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.HashMap;

public class q implements at {
    private static HashMap<Integer, d> eaA;
    private l fUk = new l();
    private h<m> fUl = new h(new c<m>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(78787);
            m mVar = new m(g.RP().eJN);
            AppMethodBeat.o(78787);
            return mVar;
        }
    });
    private x fUm = new x();
    private h<g> fUn = new h(new c<g>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(78788);
            g gVar = new g(ac.eSj);
            AppMethodBeat.o(78788);
            return gVar;
        }
    });
    private n fyJ = new a() {
        public final void gl(int i) {
            AppMethodBeat.i(78791);
            if (i == 4 || i == 6) {
                g.RS().m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(78789);
                        if (g.RN().QY()) {
                            q.akq().aki();
                            AppMethodBeat.o(78789);
                            return;
                        }
                        AppMethodBeat.o(78789);
                    }

                    public final String toString() {
                        AppMethodBeat.i(78790);
                        String str = super.toString() + "|onNetworkChange";
                        AppMethodBeat.o(78790);
                        return str;
                    }
                }, 3000);
                ab.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", Integer.valueOf(i));
                o.mg(2);
                AppMethodBeat.o(78791);
                return;
            }
            AppMethodBeat.o(78791);
        }
    };

    public q() {
        AppMethodBeat.i(78793);
        AppMethodBeat.o(78793);
    }

    public static g akq() {
        AppMethodBeat.i(78794);
        g.RN().QU();
        g gVar = (g) akr().fUn.get();
        AppMethodBeat.o(78794);
        return gVar;
    }

    private static q akr() {
        AppMethodBeat.i(78795);
        q qVar = (q) com.tencent.mm.model.q.Y(q.class);
        AppMethodBeat.o(78795);
        return qVar;
    }

    public static m aks() {
        AppMethodBeat.i(78796);
        g.RN().QU();
        m mVar = (m) akr().fUl.get();
        AppMethodBeat.o(78796);
        return mVar;
    }

    public static void e(e eVar) {
        boolean z;
        AppMethodBeat.i(78797);
        String str = "MicroMsg.SubCoreStat";
        String str2 = "dknetstat setNetworkMoniter  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        if (eVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = bo.dpG();
        ab.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(akr().fUk);
        }
        AppMethodBeat.o(78797);
    }

    public static void f(e eVar) {
        AppMethodBeat.i(78798);
        String str = "MicroMsg.SubCoreStat";
        String str2 = "setKVReportMonitor  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(eVar == null);
        objArr[1] = bo.dpG();
        ab.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(akr().fUm);
        }
        AppMethodBeat.o(78798);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(78799);
        g.RO().b(this.fyJ);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(9998), this.fUk);
        this.fUk = new l();
        ao.a.flv = null;
        AppMethodBeat.o(78799);
    }

    static {
        AppMethodBeat.i(78801);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return m.fnj;
            }
        });
        AppMethodBeat.o(78801);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(78800);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(9998), this.fUk);
        g.RO().a(this.fyJ);
        ao.a.flv = new ao.e() {
            public final void cm(int i, int i2) {
                AppMethodBeat.i(78792);
                ab.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), bo.dpG());
                n.cm(i, i2);
                AppMethodBeat.o(78792);
            }
        };
        AppMethodBeat.o(78800);
    }

    public final void bA(boolean z) {
    }
}
