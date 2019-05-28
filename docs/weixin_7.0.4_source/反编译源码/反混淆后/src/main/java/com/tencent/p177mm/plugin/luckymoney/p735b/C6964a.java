package com.tencent.p177mm.plugin.luckymoney.p735b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p217ci.C41931h;
import com.tencent.p177mm.p230g.p231a.C26262ve;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.luckymoney.model.C21204p;
import com.tencent.p177mm.plugin.luckymoney.model.C28424h;
import com.tencent.p177mm.plugin.luckymoney.model.C28426j;
import com.tencent.p177mm.plugin.luckymoney.model.C39321g;
import com.tencent.p177mm.plugin.luckymoney.model.C43257av;
import com.tencent.p177mm.plugin.luckymoney.model.C43259m;
import com.tencent.p177mm.plugin.luckymoney.model.C43261o;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22583ab;
import com.tencent.p177mm.pluginsdk.model.app.C14887t;
import com.tencent.p177mm.pluginsdk.model.app.C46493an;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.luckymoney.b.a */
public class C6964a implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C1837a kBx = new C69663();
    private C28426j nRB;
    private C21204p nRC;
    private C28424h nRD = new C28424h();
    private C43257av nRE;
    private C41931h<C43261o> nRF = new C41931h(new C69651());
    private C43259m nRG = new C43259m();
    private C4884c<C26262ve> nRH = new C69674();

    /* renamed from: com.tencent.mm.plugin.luckymoney.b.a$1 */
    class C69651 implements C32467c<C43261o> {
        C69651() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(41967);
            C43261o c43261o = new C43261o(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(41967);
            return c43261o;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.b.a$3 */
    class C69663 implements C1837a {
        C69663() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(41968);
            Map z = C5049br.m7595z(C1946aa.m4148a(c1197a.eAB.vED), "sysmsg");
            C4990ab.m7416i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
                AppMethodBeat.m2505o(41968);
                return;
            }
            if ("14".equals((String) z.get(".sysmsg.paymsg.PayMsgType"))) {
                String decode = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    C4990ab.m7412e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
                    AppMethodBeat.m2505o(41968);
                    return;
                }
                Map z2 = C5049br.m7595z(decode, "msg");
                if (z2 == null) {
                    C4990ab.m7412e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
                    AppMethodBeat.m2505o(41968);
                    return;
                }
                String str = (String) z2.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
                    AppMethodBeat.m2505o(41968);
                    return;
                }
                String str2 = (String) z.get(".sysmsg.paymsg.tousername");
                if (C5046bo.isNullOrNil(decode) || C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7412e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                    AppMethodBeat.m2505o(41968);
                    return;
                } else if (C6964a.this.bKQ().mo36579Qh(str)) {
                    C4990ab.m7416i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
                    if (!C46063x.m85797E(decode, str2, 1)) {
                        C6964a.this.bKQ().mo36580Qi(str);
                    }
                }
            }
            AppMethodBeat.m2505o(41968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.b.a$4 */
    class C69674 extends C4884c<C26262ve> {
        C69674() {
            AppMethodBeat.m2504i(41969);
            this.xxI = C26262ve.class.getName().hashCode();
            AppMethodBeat.m2505o(41969);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(41970);
            C26262ve c26262ve = (C26262ve) c4883b;
            if (!C5046bo.isNullOrNil(c26262ve.cSb.cJh)) {
                C8910b me = C8910b.m16064me(c26262ve.cSb.cJh);
                if (!C5046bo.isNullOrNil(me.fhZ)) {
                    C4990ab.m7417i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", me.fhZ);
                    C22583ab acN = C14241r.cPF().acN(me.fhZ);
                    if (acN == null) {
                        acN = new C22583ab();
                    }
                    if (C5046bo.isNullOrNil(acN.field_mNativeUrl)) {
                        acN.field_mNativeUrl = me.fhZ;
                        acN.field_receiveStatus = 0;
                    }
                    C14241r.cPF().mo38091a(acN);
                }
            }
            AppMethodBeat.m2505o(41970);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.b.a$2 */
    static class C69682 implements C1366d {
        C69682() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43261o.fnj;
        }
    }

    static {
        AppMethodBeat.m2504i(41979);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new C69682());
        AppMethodBeat.m2505o(41979);
    }

    public final C43261o bKM() {
        AppMethodBeat.m2504i(41971);
        C43261o c43261o = (C43261o) this.nRF.get();
        AppMethodBeat.m2505o(41971);
        return c43261o;
    }

    public static C6964a bKN() {
        AppMethodBeat.m2504i(41972);
        C6964a c6964a = (C6964a) C7485q.m12925Y(C6964a.class);
        AppMethodBeat.m2505o(41972);
        return c6964a;
    }

    public C6964a() {
        AppMethodBeat.m2504i(41973);
        File file = new File(C6964a.bKP());
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(C6457e.eva);
        if (!file.exists()) {
            file.mkdir();
        }
        AppMethodBeat.m2505o(41973);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(41974);
        C1202f dhQ = C46493an.dhQ();
        if (C1720g.m3531RK()) {
            C34832a.bYM().mo27202a(4, (C14887t) dhQ);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(1060, dhQ);
        }
        this.nRG.dnU();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("paymsg", this.kBx, true);
        boolean z2 = false;
        C1720g.m3537RQ();
        if (System.currentTimeMillis() - C1720g.m3536RP().mo5239Ry().mo16813Mm(352276) >= 43200000) {
            z2 = true;
        }
        C4990ab.m7416i("MicroMsg.SubCoreLuckyMoney", "isTime=" + z2 + ", isUpdate=" + z);
        if (z || z2) {
            C4990ab.m7416i("MicroMsg.SubCoreLuckyMoney", "get service applist");
            C46493an.dhQ().mo74711fM(C4996ah.getContext());
        }
        C4879a.xxA.mo10052c(this.nRD);
        C4879a.xxA.mo10052c(this.nRH);
        this.nRE = new C43257av();
        C39321g.bLs();
        AppMethodBeat.m2505o(41974);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(41975);
        C1202f dhQ = C46493an.dhQ();
        if (C1720g.m3531RK()) {
            C34832a.bYM().mo27203b(4, dhQ);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(1060, dhQ);
            dhQ.vcW = false;
            dhQ.vcX = false;
        }
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("paymsg", this.kBx, true);
        synchronized (this) {
            try {
                this.nRC = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(41975);
                }
            }
        }
        C4879a.xxA.mo10053d(this.nRD);
        C4879a.xxA.mo10053d(this.nRH);
        if (this.nRE != null) {
            C43257av c43257av = this.nRE;
            C4879a.xxA.mo10053d(c43257av.nZv);
            if (c43257av.nZs != null) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14547c(c43257av.nZs);
                c43257av.nZs = null;
            }
            if (c43257av.nZt != null) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14547c(c43257av.nZt);
                c43257av.nZt = null;
            }
        }
        C39321g.aon();
        this.nRG.dead();
        AppMethodBeat.m2505o(41975);
    }

    public static C28426j bKO() {
        AppMethodBeat.m2504i(41976);
        C1720g.m3534RN().mo5159QU();
        if (C6964a.bKN().nRB == null) {
            C6964a.bKN().nRB = new C28426j();
        }
        C28426j c28426j = C6964a.bKN().nRB;
        AppMethodBeat.m2505o(41976);
        return c28426j;
    }

    public static String bKP() {
        AppMethodBeat.m2504i(41977);
        String str;
        if (C1720g.m3531RK()) {
            str = C43217c.m76863XW() + "luckymoney";
            AppMethodBeat.m2505o(41977);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(41977);
        return str;
    }

    public final synchronized C21204p bKQ() {
        C21204p c21204p;
        AppMethodBeat.m2504i(41978);
        if (this.nRC == null) {
            this.nRC = new C21204p();
        }
        c21204p = this.nRC;
        AppMethodBeat.m2505o(41978);
        return c21204p;
    }
}
