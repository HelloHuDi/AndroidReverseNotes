package com.tencent.mm.model.c;

import android.annotation.SuppressLint;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.b;
import java.util.HashMap;
import java.util.Map;

public class c implements at {
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, d> eaA;
    private com.tencent.mm.storage.d foE;
    private b foF;
    private a foG = new a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(118175);
            String a = aa.a(aVar.eAB.vED);
            ab.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s".concat(String.valueOf(a)));
            a.a pb = a.pb(a);
            if (pb == null) {
                AppMethodBeat.o(118175);
                return;
            }
            c.abi().s(pb.items, 1);
            c.abj().s(pb.foD, 2);
            AppMethodBeat.o(118175);
        }
    };
    private com.tencent.mm.sdk.b.c foH = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d>() {
        {
            AppMethodBeat.i(118176);
            this.xxI = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(118176);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(118177);
            if (((com.tencent.mm.g.a.d) bVar).crQ.crR) {
                b.abc();
            }
            AppMethodBeat.o(118177);
            return true;
        }
    };
    private k.a foI = new k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(118178);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                com.tencent.mm.storage.c ll = c.abi().ll("100205");
                if (ll.isValid()) {
                    Map dru = ll.dru();
                    int i = bo.getInt((String) dru.get("main_thread_watch_enable"), CdnLogic.kBizGeneric);
                    int i2 = bo.getInt((String) dru.get("main_thread_watch_timeout"), 5000);
                    int i3 = bo.getInt((String) dru.get("main_thread_watch_log_loop"), 0);
                    ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", i2).putInt("main_thread_watch_log_loop", i3).putInt("main_thread_watch_report", bo.getInt((String) dru.get("main_thread_watch_report"), 0)).commit();
                    ab.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(r0));
                }
                c.abk();
            }
            AppMethodBeat.o(118178);
        }
    };
    private com.tencent.mm.vending.b.b foJ = null;
    private final com.tencent.mm.plugin.auth.a.a foK = new com.tencent.mm.plugin.auth.a.a() {
        public final void a(f fVar, g gVar, boolean z) {
            AppMethodBeat.i(118179);
            if (z) {
                if (fVar != null && (fVar instanceof j.a) && fVar.vyf == 12) {
                    b.abd();
                    AppMethodBeat.o(118179);
                    return;
                }
            } else if (fVar != null && fVar.vyf == 16) {
                b.abd();
            }
            AppMethodBeat.o(118179);
        }

        public final void a(v.b bVar, String str, int i, String str2, String str3, int i2) {
        }
    };

    public c() {
        AppMethodBeat.i(118180);
        AppMethodBeat.o(118180);
    }

    private static synchronized c abh() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(118181);
            cVar = (c) q.Y(c.class);
            AppMethodBeat.o(118181);
        }
        return cVar;
    }

    public static com.tencent.mm.storage.d abi() {
        AppMethodBeat.i(118182);
        com.tencent.mm.kernel.g.RN().QU();
        if (abh().foE == null) {
            abh().foE = new com.tencent.mm.storage.d(com.tencent.mm.kernel.g.RP().eJN);
        }
        com.tencent.mm.storage.d dVar = abh().foE;
        AppMethodBeat.o(118182);
        return dVar;
    }

    public static b abj() {
        AppMethodBeat.i(118183);
        com.tencent.mm.kernel.g.RN().QU();
        if (abh().foF == null) {
            abh().foF = new b(com.tencent.mm.kernel.g.RP().eJN);
        }
        b bVar = abh().foF;
        AppMethodBeat.o(118183);
        return bVar;
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(118184);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("newabtest", this.foG, true);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("newabtestinfo", this.foG, true);
        com.tencent.mm.sdk.b.a.xxA.c(this.foH);
        abi().c(this.foI);
        this.foJ = ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.foK);
        AppMethodBeat.o(118184);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(118185);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("newabtest", this.foG, true);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("newabtestinfo", this.foG, true);
        com.tencent.mm.sdk.b.a.xxA.d(this.foH);
        abi().d(this.foI);
        if (this.foJ != null) {
            this.foJ.dead();
            this.foJ = null;
        }
        AppMethodBeat.o(118185);
    }

    static {
        AppMethodBeat.i(118187);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.d.fnj;
            }
        });
        eaA.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        AppMethodBeat.o(118187);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    static /* synthetic */ void abk() {
        AppMethodBeat.i(118186);
        com.tencent.mm.storage.c ll = abi().ll("100229");
        if (ll.isValid()) {
            Map dru = ll.dru();
            int i = bo.getInt((String) dru.get("UseSvrTime"), 0);
            ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).edit().putInt("client_server_diff_time_enable", i).putInt("client_server_diff_time_interval", bo.getInt((String) dru.get("MinDiffTime"), 0)).commit();
            ab.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time enable[%d] diffTime[%d]", Integer.valueOf(i), Integer.valueOf(r0));
            AppMethodBeat.o(118186);
            return;
        }
        ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).edit().remove("client_server_diff_time_enable").remove("client_server_diff_time_interval").commit();
        ab.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time abtest is not valid, then delete data");
        AppMethodBeat.o(118186);
    }
}
