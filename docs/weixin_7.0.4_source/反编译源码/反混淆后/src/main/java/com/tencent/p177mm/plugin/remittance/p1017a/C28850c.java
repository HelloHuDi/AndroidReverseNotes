package com.tencent.p177mm.plugin.remittance.p1017a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C37741ix;
import com.tencent.p177mm.p230g.p231a.C37810vb;
import com.tencent.p177mm.p230g.p231a.C42030nm;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.remittance.model.C34808aa;
import com.tencent.p177mm.plugin.remittance.p1410b.C28857a;
import com.tencent.p177mm.plugin.remittance.p1410b.C39581b;
import com.tencent.p177mm.plugin.remittance.p1410b.C39582d;
import com.tencent.p177mm.plugin.remittance.p1410b.C46168c;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.wallet_core.C24143a;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.remittance.a.c */
public class C28850c implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C4931a foI = new C288513();
    private C1837a luy = new C288544();
    private C34808aa pLl = null;
    public C39581b pLm = null;
    private C39582d pLn = null;
    private C4884c<C42030nm> pLo = new C288555();
    private C4884c<C37810vb> pLp = new C216236();
    private C4884c<C37741ix> pLq = new C288487();

    /* renamed from: com.tencent.mm.plugin.remittance.a.c$6 */
    class C216236 extends C4884c<C37810vb> {
        C216236() {
            AppMethodBeat.m2504i(44430);
            this.xxI = C37810vb.class.getName().hashCode();
            AppMethodBeat.m2505o(44430);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C46168c VN;
            AppMethodBeat.m2504i(44431);
            C37810vb c37810vb = (C37810vb) c4883b;
            C39582d ceY = C28850c.ceY();
            String str = c37810vb.cRW.cEa;
            if (C5046bo.isNullOrNil(str) || !C39582d.gms.containsKey(str)) {
                VN = ceY.mo62548VN(str);
                if (VN != null) {
                    C39582d.gms.put(str, VN);
                } else {
                    VN = null;
                }
            } else {
                VN = (C46168c) C39582d.gms.get(str);
            }
            if (VN != null) {
                c37810vb.cRX.status = VN.field_receiveStatus;
                c37810vb.cRX.cRY = VN.field_isSend;
            } else {
                c37810vb.cRX.status = -2;
                c37810vb.cRX.cRY = false;
            }
            AppMethodBeat.m2505o(44431);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.a.c$7 */
    class C288487 extends C4884c<C37741ix> {
        C288487() {
            AppMethodBeat.m2504i(44432);
            this.xxI = C37741ix.class.getName().hashCode();
            AppMethodBeat.m2505o(44432);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44433);
            C37741ix c37741ix = (C37741ix) c4883b;
            if (!(C5046bo.isNullOrNil(c37741ix.cDZ.username) || C5046bo.isNullOrNil(c37741ix.cDZ.cEa))) {
                Context context;
                C46168c VN = C28850c.ceY().mo62548VN(c37741ix.cDZ.cEa);
                C4990ab.m7417i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, transferId: %s, username: %s", c37741ix.cDZ.cEa, c37741ix.cDZ.username);
                C4990ab.m7417i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, isContact: %s", Boolean.valueOf(C1855t.m3912mY(c37741ix.cDZ.username)));
                Context context2 = c37741ix.cDZ.context;
                if (context2 == null) {
                    context = C4996ah.getContext();
                } else {
                    context = context2;
                }
                if (!r3) {
                    C28850c.m45860ke(true);
                } else if (VN == null || VN.field_locaMsgId <= 0) {
                    C4990ab.m7416i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, cannot find local msg");
                    C28850c.m45860ke(false);
                } else {
                    C4990ab.m7417i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, localMsgId: %s", Long.valueOf(VN.field_locaMsgId));
                    if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(VN.field_locaMsgId).field_msgId <= 0) {
                        C4990ab.m7416i("MicroMsg.SubCoreRemittance", "cannot find msg in msg storage!");
                        C28850c.m45860ke(false);
                    } else {
                        C25985d.m41473f(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", c37741ix.cDZ.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", VN.field_locaMsgId).putExtra("need_hight_item", true));
                    }
                }
            }
            AppMethodBeat.m2505o(44433);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.a.c$8 */
    static class C288498 implements C5662c {
        C288498() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.a.c$3 */
    class C288513 implements C4931a {
        C288513() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(44426);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                int i;
                C5141c ll = C18624c.abi().mo17131ll("100324");
                if (ll.isValid() && "1".equals(ll.dru().get("open"))) {
                    i = 1;
                } else {
                    i = 0;
                }
                C7580z Ry = C1720g.m3536RP().mo5239Ry();
                Ry.set(C5127a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(i));
                C4990ab.m7417i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", Integer.valueOf(i), Integer.valueOf(((Integer) Ry.get(C5127a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue()));
                if (((Integer) Ry.get(C5127a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                    C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, true);
                    Ry.set(C5127a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(1));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                }
            }
            AppMethodBeat.m2505o(44426);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.a.c$1 */
    static class C288521 implements C1366d {
        C288521() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39581b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.a.c$2 */
    static class C288532 implements C1366d {
        C288532() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39582d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.a.c$4 */
    class C288544 implements C1837a {
        C288544() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(44427);
            C4990ab.m7416i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
            C7254cm c7254cm = c1197a.eAB;
            if (c7254cm == null) {
                C4990ab.m7412e("MicroMsg.SubCoreRemittance", "recieve a null msg");
                AppMethodBeat.m2505o(44427);
                return;
            }
            String a = C1946aa.m4148a(c7254cm.vED);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7412e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
                AppMethodBeat.m2505o(44427);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.SubCoreRemittance", "Resolve msg error");
                AppMethodBeat.m2505o(44427);
                return;
            }
            a = (String) z.get(".sysmsg.paymsg.PayMsgType");
            String str;
            if ("15".equals(a)) {
                String decode = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    C4990ab.m7412e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                    AppMethodBeat.m2505o(44427);
                    return;
                }
                Map z2 = C5049br.m7595z(decode, "msg");
                if (z2 == null) {
                    C4990ab.m7412e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                    AppMethodBeat.m2505o(44427);
                    return;
                }
                a = (String) z2.get(".msg.appmsg.wcpayinfo.transferid");
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7412e("MicroMsg.SubCoreRemittance", "paymsgid is null");
                    AppMethodBeat.m2505o(44427);
                } else if (C28850c.this.ceZ().mo55423VO(a)) {
                    C4990ab.m7412e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
                    AppMethodBeat.m2505o(44427);
                } else {
                    str = (String) z.get(".sysmsg.paymsg.tousername");
                    if (C5046bo.isNullOrNil(decode) || C5046bo.isNullOrNil(str)) {
                        C4990ab.m7412e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                        AppMethodBeat.m2505o(44427);
                        return;
                    }
                    C28850c.this.ceZ().mo55424Z(a, decode, str);
                    AppMethodBeat.m2505o(44427);
                }
            } else if ("22".equals(a)) {
                a = (String) z.get(".sysmsg.paymsg.tousername");
                str = (String) z.get(".sysmsg.paymsg.fromusername");
                try {
                    String decode2 = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (C5046bo.isNullOrNil(decode2)) {
                        C4990ab.m7412e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                        AppMethodBeat.m2505o(44427);
                        return;
                    }
                    Map z3 = C5049br.m7595z(decode2, "msg");
                    if (z3 == null) {
                        C4990ab.m7412e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                        AppMethodBeat.m2505o(44427);
                        return;
                    }
                    String str2 = (String) z3.get(".msg.appmsg.wcpayinfo.transferid");
                    int i = C5046bo.getInt((String) z3.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
                    C4990ab.m7417i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", str, a, str2, Integer.valueOf(i));
                    C28857a c28857a = null;
                    try {
                        C28850c.ceW();
                        c28857a = C28850c.ceX().mo62547VM(str2);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreRemittance", e, "", new Object[0]);
                    }
                    if (c28857a == null) {
                        C4990ab.m7416i("MicroMsg.SubCoreRemittance", "empty record");
                        AppMethodBeat.m2505o(44427);
                        return;
                    }
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c28857a.field_msgId);
                    if (jf.field_msgId <= 0) {
                        C4990ab.m7416i("MicroMsg.SubCoreRemittance", "has delete msg");
                        C28850c.ceW();
                        C28850c.ceX().mo16760a((C4925c) c28857a, new String[0]);
                        AppMethodBeat.m2505o(44427);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.SubCoreRemittance", "update msg: %s", Long.valueOf(jf.field_msgId));
                    jf.setContent(decode2);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
                    C46168c VN = C28850c.ceY().mo62548VN(str2);
                    if (VN != null) {
                        VN.field_receiveStatus = i;
                        C28850c.ceY().mo62549a(VN);
                        AppMethodBeat.m2505o(44427);
                        return;
                    }
                    if (!jf.field_talker.equals(C1853r.m3846Yz())) {
                        VN = new C46168c();
                        VN.field_locaMsgId = jf.field_msgId;
                        VN.field_transferId = str2;
                        VN.field_receiveStatus = i;
                        VN.field_isSend = false;
                        C28850c.ceY().mo62549a(VN);
                    }
                    AppMethodBeat.m2505o(44427);
                } catch (UnsupportedEncodingException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.SubCoreRemittance", e2, "", new Object[0]);
                    AppMethodBeat.m2505o(44427);
                }
            } else {
                if ("33".equals(a)) {
                    int i2 = C5046bo.getInt((String) z.get(".sysmsg.paymsg.opentransferbankcard"), 0);
                    C7580z Ry = C1720g.m3536RP().mo5239Ry();
                    Ry.set(C5127a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(i2));
                    C4990ab.m7417i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", Integer.valueOf(i2), Integer.valueOf(((Integer) Ry.get(C5127a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue()));
                    if (((Integer) Ry.get(C5127a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, true);
                        Ry.set(C5127a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(1));
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                }
                AppMethodBeat.m2505o(44427);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.a.c$5 */
    class C288555 extends C4884c<C42030nm> {
        C288555() {
            AppMethodBeat.m2504i(44428);
            this.xxI = C42030nm.class.getName().hashCode();
            AppMethodBeat.m2505o(44428);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44429);
            C42030nm c42030nm = (C42030nm) c4883b;
            C4990ab.m7417i("MicroMsg.SubCoreRemittance", "do insert delay transfer record: %s, %s", Long.valueOf(c42030nm.cJL.cvx), c42030nm.cJL.cEa);
            if (c42030nm.cJL.cJM != null) {
                if (c42030nm.cJL.cJM.fhv == 5) {
                    C28857a c28857a = new C28857a();
                    c28857a.field_msgId = c42030nm.cJL.cvx;
                    c28857a.field_transferId = c42030nm.cJL.cEa;
                    C28850c.ceW();
                    C28850c.ceX().mo10101b((C4925c) c28857a);
                }
                C46168c VN = C28850c.ceY().mo62548VN(c42030nm.cJL.cEa);
                if (VN != null) {
                    VN.field_receiveStatus = c42030nm.cJL.cJM.fhv;
                    C28850c.ceY().mo62549a(VN);
                } else if (!((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c42030nm.cJL.cvx).field_talker.equals(C1853r.m3846Yz())) {
                    VN = new C46168c();
                    VN.field_locaMsgId = c42030nm.cJL.cvx;
                    VN.field_transferId = c42030nm.cJL.cJM.fhy;
                    VN.field_receiveStatus = c42030nm.cJL.cJM.fhv;
                    VN.field_isSend = false;
                    C28850c.ceY().mo62549a(VN);
                }
            }
            AppMethodBeat.m2505o(44429);
            return false;
        }
    }

    public C28850c() {
        AppMethodBeat.m2504i(44434);
        AppMethodBeat.m2505o(44434);
    }

    static {
        AppMethodBeat.m2504i(44442);
        C24143a.m37115g("RemittanceProcess", C13018a.class);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new C288521());
        eaA.put(Integer.valueOf("RemittanceRecord".hashCode()), new C288532());
        AppMethodBeat.m2505o(44442);
    }

    public static C28850c ceW() {
        AppMethodBeat.m2504i(44435);
        C28850c c28850c = (C28850c) C7485q.m12925Y(C28850c.class);
        AppMethodBeat.m2505o(44435);
        return c28850c;
    }

    public static C39581b ceX() {
        AppMethodBeat.m2504i(44436);
        if (C28850c.ceW().pLm == null) {
            C28850c ceW = C28850c.ceW();
            C1720g.m3537RQ();
            ceW.pLm = new C39581b(C1720g.m3536RP().eJN);
        }
        C39581b c39581b = C28850c.ceW().pLm;
        AppMethodBeat.m2505o(44436);
        return c39581b;
    }

    public static C39582d ceY() {
        AppMethodBeat.m2504i(44437);
        if (C28850c.ceW().pLn == null) {
            C28850c ceW = C28850c.ceW();
            C1720g.m3537RQ();
            ceW.pLn = new C39582d(C1720g.m3536RP().eJN);
        }
        C39582d c39582d = C28850c.ceW().pLn;
        AppMethodBeat.m2505o(44437);
        return c39582d;
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
        AppMethodBeat.m2504i(44438);
        if (this.pLl != null) {
            C34808aa c34808aa = this.pLl;
            synchronized (c34808aa.lock) {
                try {
                    c34808aa.pQC = new HashSet();
                    c34808aa.pQD.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(44438);
                    }
                }
            }
        }
        C18624c.abi().mo10116c(this.foI);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("paymsg", this.luy, true);
        C4879a.xxA.mo10051b(this.pLo);
        C4879a.xxA.mo10051b(this.pLp);
        C4879a.xxA.mo10051b(this.pLq);
        AppMethodBeat.m2505o(44438);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(44439);
        C18624c.abi().mo10117d(this.foI);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("paymsg", this.luy, true);
        C4879a.xxA.mo10053d(this.pLo);
        C4879a.xxA.mo10053d(this.pLp);
        C4879a.xxA.mo10053d(this.pLq);
        AppMethodBeat.m2505o(44439);
    }

    public final C34808aa ceZ() {
        AppMethodBeat.m2504i(44440);
        if (this.pLl == null) {
            this.pLl = new C34808aa();
        }
        C34808aa c34808aa = this.pLl;
        AppMethodBeat.m2505o(44440);
        return c34808aa;
    }

    /* renamed from: ke */
    static /* synthetic */ void m45860ke(boolean z) {
        AppMethodBeat.m2504i(44441);
        new C5659a(C4996ah.getContext()).asL(C4996ah.getContext().getString(z ? C25738R.string.dpa : C25738R.string.dp_)).mo11510Qh(C4996ah.getContext().getResources().getColor(C25738R.color.a61)).mo11509Qg(C25738R.string.cd_).mo11522b(new C288498()).show();
        AppMethodBeat.m2505o(44441);
    }
}
