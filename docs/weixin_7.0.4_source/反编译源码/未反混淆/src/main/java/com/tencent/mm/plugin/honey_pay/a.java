package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.ci.c;
import com.tencent.mm.ci.h;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a implements at {
    private static HashMap<Integer, d> eaA;
    private h<b> nqt = new h(new c<b>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(41707);
            g.RQ();
            b bVar = new b(g.RP().eJN);
            AppMethodBeat.o(41707);
            return bVar;
        }
    });
    private com.tencent.mm.sdk.b.c<nj> nqu = new com.tencent.mm.sdk.b.c<nj>() {
        {
            AppMethodBeat.i(41708);
            this.xxI = nj.class.getName().hashCode();
            AppMethodBeat.o(41708);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(41709);
            nj njVar = (nj) bVar;
            ab.i("MicroMsg.SubCoreHoneyPay", "receive honey pay msg: %s, %s", njVar.cJG.cJH, Long.valueOf(njVar.cJG.cJD));
            if (!bo.isNullOrNil(njVar.cJG.cJH) && njVar.cJG.cJD > -1) {
                if (!bo.isNullOrNil(njVar.cJG.username)) {
                    ab.d("MicroMsg.SubCoreHoneyPay", "need replace username: %s", njVar.cJG.username);
                    String z = com.tencent.mm.plugin.honey_pay.model.c.z(njVar.cJG.cJh, njVar.cJG.username, 6);
                    if (z.equals(njVar.cJG.cJh)) {
                        njVar.cJG.cJh = null;
                    } else {
                        njVar.cJG.cJh = z;
                    }
                }
                com.tencent.mm.plugin.honey_pay.model.a aVar = new com.tencent.mm.plugin.honey_pay.model.a();
                aVar.field_msgId = njVar.cJG.cJD;
                aVar.field_payMsgId = njVar.cJG.cJH;
                a.this.bFW().b((com.tencent.mm.sdk.e.c) aVar);
            }
            AppMethodBeat.o(41709);
            return false;
        }
    };
    private o nqv = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(41710);
            if (bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0) == 35) {
                ab.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
                String str2 = (String) map.get(".sysmsg.paymsg.appmsgcontent");
                String str3 = (String) map.get(".sysmsg.paymsg.fromusername");
                String str4 = (String) map.get(".sysmsg.paymsg.tousername");
                String str5 = (String) map.get(".sysmsg.paymsg.paymsgid");
                String str6 = (String) map.get(".sysmsg.paymsg.systip");
                if (!bo.isNullOrNil(str2)) {
                    ab.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", URLDecoder.decode(str2));
                    com.tencent.mm.plugin.honey_pay.model.c.o(str5, str2, str4, str3);
                }
                if (!bo.isNullOrNil(str6)) {
                    ab.d("MicroMsg.SubCoreHoneyPay", "systip: %s", URLDecoder.decode(str6));
                    com.tencent.mm.plugin.honey_pay.model.c.V(str4, str2, str3);
                }
            }
            AppMethodBeat.o(41710);
        }
    };

    static {
        AppMethodBeat.i(41716);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        AppMethodBeat.o(41716);
    }

    public static a bFV() {
        AppMethodBeat.i(41711);
        a aVar = (a) q.Y(a.class);
        AppMethodBeat.o(41711);
        return aVar;
    }

    public a() {
        AppMethodBeat.i(41712);
        AppMethodBeat.o(41712);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(41713);
        this.nqu.dnU();
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.nqv);
        AppMethodBeat.o(41713);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(41714);
        this.nqu.dead();
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.nqv);
        AppMethodBeat.o(41714);
    }

    public final b bFW() {
        AppMethodBeat.i(41715);
        b bVar = (b) this.nqt.get();
        AppMethodBeat.o(41715);
        return bVar;
    }
}
