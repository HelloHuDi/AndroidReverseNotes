package com.tencent.mm.plugin.luckymoney.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.ci.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.luckymoney.model.av;
import com.tencent.mm.plugin.luckymoney.model.h;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.m;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a implements at {
    private static HashMap<Integer, d> eaA;
    private com.tencent.mm.model.bz.a kBx = new com.tencent.mm.model.bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(41968);
            Map z = br.z(aa.a(aVar.eAB.vED), "sysmsg");
            ab.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
            if (z == null) {
                ab.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
                AppMethodBeat.o(41968);
                return;
            }
            if ("14".equals((String) z.get(".sysmsg.paymsg.PayMsgType"))) {
                String decode = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    ab.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
                    AppMethodBeat.o(41968);
                    return;
                }
                Map z2 = br.z(decode, "msg");
                if (z2 == null) {
                    ab.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
                    AppMethodBeat.o(41968);
                    return;
                }
                String str = (String) z2.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
                    AppMethodBeat.o(41968);
                    return;
                }
                String str2 = (String) z.get(".sysmsg.paymsg.tousername");
                if (bo.isNullOrNil(decode) || bo.isNullOrNil(str2)) {
                    ab.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                    AppMethodBeat.o(41968);
                    return;
                } else if (a.this.bKQ().Qh(str)) {
                    ab.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
                    if (!x.E(decode, str2, 1)) {
                        a.this.bKQ().Qi(str);
                    }
                }
            }
            AppMethodBeat.o(41968);
        }
    };
    private j nRB;
    private p nRC;
    private h nRD = new h();
    private av nRE;
    private com.tencent.mm.ci.h<o> nRF = new com.tencent.mm.ci.h(new c<o>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(41967);
            o oVar = new o(g.RP().eJN);
            AppMethodBeat.o(41967);
            return oVar;
        }
    });
    private m nRG = new m();
    private com.tencent.mm.sdk.b.c<ve> nRH = new com.tencent.mm.sdk.b.c<ve>() {
        {
            AppMethodBeat.i(41969);
            this.xxI = ve.class.getName().hashCode();
            AppMethodBeat.o(41969);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(41970);
            ve veVar = (ve) bVar;
            if (!bo.isNullOrNil(veVar.cSb.cJh)) {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(veVar.cSb.cJh);
                if (!bo.isNullOrNil(me.fhZ)) {
                    ab.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", me.fhZ);
                    com.tencent.mm.plugin.wallet_core.model.ab acN = r.cPF().acN(me.fhZ);
                    if (acN == null) {
                        acN = new com.tencent.mm.plugin.wallet_core.model.ab();
                    }
                    if (bo.isNullOrNil(acN.field_mNativeUrl)) {
                        acN.field_mNativeUrl = me.fhZ;
                        acN.field_receiveStatus = 0;
                    }
                    r.cPF().a(acN);
                }
            }
            AppMethodBeat.o(41970);
            return false;
        }
    };

    static {
        AppMethodBeat.i(41979);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new d() {
            public final String[] Af() {
                return o.fnj;
            }
        });
        AppMethodBeat.o(41979);
    }

    public final o bKM() {
        AppMethodBeat.i(41971);
        o oVar = (o) this.nRF.get();
        AppMethodBeat.o(41971);
        return oVar;
    }

    public static a bKN() {
        AppMethodBeat.i(41972);
        a aVar = (a) q.Y(a.class);
        AppMethodBeat.o(41972);
        return aVar;
    }

    public a() {
        AppMethodBeat.i(41973);
        File file = new File(bKP());
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(e.eva);
        if (!file.exists()) {
            file.mkdir();
        }
        AppMethodBeat.o(41973);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(41974);
        f dhQ = an.dhQ();
        if (g.RK()) {
            com.tencent.mm.plugin.s.a.bYM().a(4, (t) dhQ);
            g.RQ();
            g.RO().eJo.a(1060, dhQ);
        }
        this.nRG.dnU();
        ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.kBx, true);
        boolean z2 = false;
        g.RQ();
        if (System.currentTimeMillis() - g.RP().Ry().Mm(352276) >= 43200000) {
            z2 = true;
        }
        ab.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + z2 + ", isUpdate=" + z);
        if (z || z2) {
            ab.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
            an.dhQ().fM(ah.getContext());
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.nRD);
        com.tencent.mm.sdk.b.a.xxA.c(this.nRH);
        this.nRE = new av();
        com.tencent.mm.plugin.luckymoney.model.g.bLs();
        AppMethodBeat.o(41974);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(41975);
        f dhQ = an.dhQ();
        if (g.RK()) {
            com.tencent.mm.plugin.s.a.bYM().b(4, dhQ);
            g.RQ();
            g.RO().eJo.b(1060, dhQ);
            dhQ.vcW = false;
            dhQ.vcX = false;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.kBx, true);
        synchronized (this) {
            try {
                this.nRC = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(41975);
                }
            }
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.nRD);
        com.tencent.mm.sdk.b.a.xxA.d(this.nRH);
        if (this.nRE != null) {
            av avVar = this.nRE;
            com.tencent.mm.sdk.b.a.xxA.d(avVar.nZv);
            if (avVar.nZs != null) {
                g.RQ();
                g.RO().eJo.c(avVar.nZs);
                avVar.nZs = null;
            }
            if (avVar.nZt != null) {
                g.RQ();
                g.RO().eJo.c(avVar.nZt);
                avVar.nZt = null;
            }
        }
        com.tencent.mm.plugin.luckymoney.model.g.aon();
        this.nRG.dead();
        AppMethodBeat.o(41975);
    }

    public static j bKO() {
        AppMethodBeat.i(41976);
        g.RN().QU();
        if (bKN().nRB == null) {
            bKN().nRB = new j();
        }
        j jVar = bKN().nRB;
        AppMethodBeat.o(41976);
        return jVar;
    }

    public static String bKP() {
        AppMethodBeat.i(41977);
        String str;
        if (g.RK()) {
            str = com.tencent.mm.plugin.i.c.XW() + "luckymoney";
            AppMethodBeat.o(41977);
            return str;
        }
        str = "";
        AppMethodBeat.o(41977);
        return str;
    }

    public final synchronized p bKQ() {
        p pVar;
        AppMethodBeat.i(41978);
        if (this.nRC == null) {
            this.nRC = new p();
        }
        pVar = this.nRC;
        AppMethodBeat.o(41978);
        return pVar;
    }
}
