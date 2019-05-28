package com.tencent.p177mm.plugin.wxpay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p217ci.C41931h;
import com.tencent.p177mm.p230g.p231a.C9412lm;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.collect.p1481a.C45815a;
import com.tencent.p177mm.plugin.fingerprint.C43094a;
import com.tencent.p177mm.plugin.fingerprint.p413b.C39089l;
import com.tencent.p177mm.plugin.fingerprint.p413b.C45943d;
import com.tencent.p177mm.plugin.honey_pay.C12223a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.C6963a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.C7508b;
import com.tencent.p177mm.plugin.luckymoney.model.C43258l;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.mall.p450a.C43288j;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.order.p1007a.C34657b;
import com.tencent.p177mm.plugin.p268aa.C45488b;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.recharge.p1655a.C46158a;
import com.tencent.p177mm.plugin.remittance.C28856a;
import com.tencent.p177mm.plugin.remittance.p1017a.C13019b;
import com.tencent.p177mm.plugin.remittance.p1017a.C28850c;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_ecard.C7189a;
import com.tencent.p177mm.plugin.wallet_index.p1051a.C14340a;
import com.tencent.p177mm.plugin.wallet_payu.p1561a.C43823d;
import com.tencent.p177mm.plugin.wxcredit.C30025a;
import com.tencent.p177mm.plugin.wxpay.p1335a.C23225a;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C40930y;
import com.tencent.soter.p663a.C30954a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wxpay.PluginWxPay */
public class PluginWxPay extends C7597f implements C18523a, C23225a {
    private C41931h<C40930y> uZH = new C41931h(new C300281());
    private C4884c<C9412lm> uZI = new C148202();

    /* renamed from: com.tencent.mm.plugin.wxpay.PluginWxPay$2 */
    class C148202 extends C4884c<C9412lm> {
        C148202() {
            AppMethodBeat.m2504i(48756);
            this.xxI = C9412lm.class.getName().hashCode();
            AppMethodBeat.m2505o(48756);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C1694a c45943d;
            AppMethodBeat.m2504i(48757);
            C4990ab.m7411d("MicroMsg.PluginWxPay", "soter initialized: %s, %s", Integer.valueOf(r8.cHn.errCode), ((C9412lm) c4883b).cHn.aIm);
            if (((C9412lm) c4883b).cHn.errCode != 0) {
                c45943d = new C45943d();
                c45943d.bxp();
            } else if (C30954a.dRc()) {
                C4990ab.m7416i("MicroMsg.PluginWxPay", "new soter impl");
                c45943d = new C39089l();
                c45943d.mo48311dP(null);
            } else {
                C4990ab.m7416i("MicroMsg.PluginWxPay", "new base impl");
                c45943d = new C45943d();
                c45943d.bxp();
            }
            C1720g.m3542a(C30052l.class, c45943d);
            AppMethodBeat.m2505o(48757);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxpay.PluginWxPay$1 */
    class C300281 implements C32467c<C40930y> {
        C300281() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(48755);
            C40930y c40930y = new C40930y(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(48755);
            return c40930y;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxpay.PluginWxPay$3 */
    class C300293 implements C1366d {
        C300293() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C40930y.fnj;
        }
    }

    public PluginWxPay() {
        AppMethodBeat.m2504i(48758);
        AppMethodBeat.m2505o(48758);
    }

    public String name() {
        return "plugin-wxpay";
    }

    public void installed() {
        AppMethodBeat.m2504i(48759);
        alias(C23225a.class);
        C1720g.m3542a(C30052l.class, new C45943d());
        this.uZI.dnU();
        AppMethodBeat.m2505o(48759);
    }

    public void uninstalled() {
        AppMethodBeat.m2504i(48760);
        super.uninstalled();
        this.uZI.dead();
        AppMethodBeat.m2505o(48760);
    }

    public void dependency() {
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(48761);
        if (c1681g.mo5181SG()) {
            pin(new C7485q(C45488b.class));
            pin(new C7485q(C45815a.class));
            pin(new C7485q(C6964a.class));
            pin(new C7485q(C43288j.class));
            pin(new C7485q(C7007k.class));
            pin(new C7485q(C34657b.class));
            pin(new C7485q(C34676a.class));
            pin(new C7485q(C46158a.class));
            pin(new C7485q(C28850c.class));
            pin(new C7485q(C46332s.class));
            pin(new C7485q(C14241r.class));
            pin(new C7485q(C14340a.class));
            pin(new C7485q(C43823d.class));
            pin(new C7485q(C30025a.class));
            pin(new C7485q(C43094a.class));
            pin(new C7485q(C7189a.class));
            pin(new C7485q(C12223a.class));
        }
        C1720g.m3543a(C6963a.class, new C6625e(new C7508b()));
        C1720g.m3543a(C12405a.class, new C6625e(new C43258l()));
        C1720g.m3543a(C28856a.class, new C6625e(new C13019b()));
        AppMethodBeat.m2505o(48761);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(48762);
        if (c1681g.mo5181SG()) {
            C9204c.aks("wallet");
            C9204c.aks("mall");
            C9204c.aks("wxcredit");
            C9204c.aks("offline");
            C9204c.aks("recharge");
            C9204c.aks("wallet_index");
            C9204c.aks("order");
            C9204c.aks("product");
            C9204c.aks("remittance");
            C9204c.aks("collect");
            C9204c.aks("wallet_payu");
            C9204c.aks("luckymoney");
            C9204c.aks(FingerprintManagerProxy.FINGERPRINT_SERVICE);
        }
        AppMethodBeat.m2505o(48762);
    }

    public C40930y getWalletCacheStg() {
        AppMethodBeat.m2504i(48763);
        if (C1720g.m3531RK()) {
            C40930y c40930y = (C40930y) this.uZH.get();
            AppMethodBeat.m2505o(48763);
            return c40930y;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(48763);
        throw c1819b;
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(48764);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("WALLET_CACHE".hashCode()), new C300293());
        AppMethodBeat.m2505o(48764);
        return hashMap;
    }
}
