package com.tencent.mm.plugin.wxpay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.c;
import com.tencent.mm.ci.h;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.plugin.fingerprint.b.l;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.y;
import java.util.HashMap;

public class PluginWxPay extends f implements a, com.tencent.mm.plugin.wxpay.a.a {
    private h<y> uZH = new h(new c<y>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(48755);
            y yVar = new y(g.RP().eJN);
            AppMethodBeat.o(48755);
            return yVar;
        }
    });
    private com.tencent.mm.sdk.b.c<lm> uZI = new com.tencent.mm.sdk.b.c<lm>() {
        {
            AppMethodBeat.i(48756);
            this.xxI = lm.class.getName().hashCode();
            AppMethodBeat.o(48756);
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.kernel.c.a dVar;
            AppMethodBeat.i(48757);
            ab.d("MicroMsg.PluginWxPay", "soter initialized: %s, %s", Integer.valueOf(r8.cHn.errCode), ((lm) bVar).cHn.aIm);
            if (((lm) bVar).cHn.errCode != 0) {
                dVar = new d();
                dVar.bxp();
            } else if (com.tencent.soter.a.a.dRc()) {
                ab.i("MicroMsg.PluginWxPay", "new soter impl");
                dVar = new l();
                dVar.dP(null);
            } else {
                ab.i("MicroMsg.PluginWxPay", "new base impl");
                dVar = new d();
                dVar.bxp();
            }
            g.a(com.tencent.mm.pluginsdk.l.class, dVar);
            AppMethodBeat.o(48757);
            return false;
        }
    };

    public PluginWxPay() {
        AppMethodBeat.i(48758);
        AppMethodBeat.o(48758);
    }

    public String name() {
        return "plugin-wxpay";
    }

    public void installed() {
        AppMethodBeat.i(48759);
        alias(com.tencent.mm.plugin.wxpay.a.a.class);
        g.a(com.tencent.mm.pluginsdk.l.class, new d());
        this.uZI.dnU();
        AppMethodBeat.o(48759);
    }

    public void uninstalled() {
        AppMethodBeat.i(48760);
        super.uninstalled();
        this.uZI.dead();
        AppMethodBeat.o(48760);
    }

    public void dependency() {
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(48761);
        if (gVar.SG()) {
            pin(new q(com.tencent.mm.plugin.aa.b.class));
            pin(new q(com.tencent.mm.plugin.collect.a.a.class));
            pin(new q(com.tencent.mm.plugin.luckymoney.b.a.class));
            pin(new q(j.class));
            pin(new q(k.class));
            pin(new q(com.tencent.mm.plugin.order.a.b.class));
            pin(new q(com.tencent.mm.plugin.product.a.a.class));
            pin(new q(com.tencent.mm.plugin.recharge.a.a.class));
            pin(new q(com.tencent.mm.plugin.remittance.a.c.class));
            pin(new q(s.class));
            pin(new q(r.class));
            pin(new q(com.tencent.mm.plugin.wallet_index.a.a.class));
            pin(new q(com.tencent.mm.plugin.wallet_payu.a.d.class));
            pin(new q(com.tencent.mm.plugin.wxcredit.a.class));
            pin(new q(com.tencent.mm.plugin.fingerprint.a.class));
            pin(new q(com.tencent.mm.plugin.wallet_ecard.a.class));
            pin(new q(com.tencent.mm.plugin.honey_pay.a.class));
        }
        g.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
        g.a(com.tencent.mm.plugin.luckymoney.a.a.class, new e(new com.tencent.mm.plugin.luckymoney.model.l()));
        g.a(com.tencent.mm.plugin.remittance.a.class, new e(new com.tencent.mm.plugin.remittance.a.b()));
        AppMethodBeat.o(48761);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(48762);
        if (gVar.SG()) {
            com.tencent.mm.bp.c.aks("wallet");
            com.tencent.mm.bp.c.aks("mall");
            com.tencent.mm.bp.c.aks("wxcredit");
            com.tencent.mm.bp.c.aks("offline");
            com.tencent.mm.bp.c.aks("recharge");
            com.tencent.mm.bp.c.aks("wallet_index");
            com.tencent.mm.bp.c.aks("order");
            com.tencent.mm.bp.c.aks("product");
            com.tencent.mm.bp.c.aks("remittance");
            com.tencent.mm.bp.c.aks("collect");
            com.tencent.mm.bp.c.aks("wallet_payu");
            com.tencent.mm.bp.c.aks("luckymoney");
            com.tencent.mm.bp.c.aks(FingerprintManagerProxy.FINGERPRINT_SERVICE);
        }
        AppMethodBeat.o(48762);
    }

    public y getWalletCacheStg() {
        AppMethodBeat.i(48763);
        if (g.RK()) {
            y yVar = (y) this.uZH.get();
            AppMethodBeat.o(48763);
            return yVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(48763);
        throw bVar;
    }

    public HashMap<Integer, com.tencent.mm.cd.h.d> collectDatabaseFactory() {
        AppMethodBeat.i(48764);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("WALLET_CACHE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return y.fnj;
            }
        });
        AppMethodBeat.o(48764);
        return hashMap;
    }
}
