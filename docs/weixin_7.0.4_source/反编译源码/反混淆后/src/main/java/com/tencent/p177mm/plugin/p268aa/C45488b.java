package com.tencent.p177mm.plugin.p268aa;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18421uz;
import com.tencent.p177mm.p230g.p231a.C18421uz.C1580b;
import com.tencent.p177mm.p230g.p231a.C26093br;
import com.tencent.p177mm.p230g.p231a.C26206ni;
import com.tencent.p177mm.p230g.p231a.C37770nh;
import com.tencent.p177mm.p230g.p231a.C9304bs;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.p268aa.p269a.C1954a;
import com.tencent.p177mm.plugin.p268aa.p269a.C24677j;
import com.tencent.p177mm.plugin.p268aa.p269a.C24677j.C18778a;
import com.tencent.p177mm.plugin.p268aa.p269a.C9797h;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C18769d;
import com.tencent.p177mm.plugin.p268aa.p269a.p879b.C18771b;
import com.tencent.p177mm.plugin.p268aa.p269a.p879b.C26535c;
import com.tencent.p177mm.plugin.p268aa.p269a.p879b.C9795d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C44106c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.aa.b */
public class C45488b implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C4884c<C26206ni> gkG = new C328971();
    private C4884c<C37770nh> gkH = new C380082();
    private C4884c<C26093br> gkI = new C454873();
    private C4884c<C9304bs> gkJ = new C380094();
    private C3473o gkK = new C265385();
    C4884c<C18421uz> gkL = new C97996();
    private C9795d gkM;
    private C18771b gkN;

    /* renamed from: com.tencent.mm.plugin.aa.b$6 */
    class C97996 extends C4884c<C18421uz> {
        C97996() {
            AppMethodBeat.m2504i(40585);
            this.xxI = C18421uz.class.getName().hashCode();
            AppMethodBeat.m2505o(40585);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i;
            AppMethodBeat.m2504i(40586);
            C18421uz c18421uz = (C18421uz) c4883b;
            String str = c18421uz.cRN.cRP;
            C1580b c1580b = c18421uz.cRO;
            C9795d aod = C45488b.aod();
            if (C9795d.gms.containsKey(str)) {
                i = ((C26535c) C9795d.gms.get(str)).field_status;
            } else {
                C26535c vH = aod.mo21152vH(str);
                if (vH != null) {
                    C9795d.gms.put(str, vH);
                    i = vH.field_status;
                } else {
                    i = -1;
                }
            }
            c1580b.status = i;
            AppMethodBeat.m2505o(40586);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.b$7 */
    static class C187797 implements C1366d {
        C187797() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C9795d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.b$5 */
    class C265385 implements C3473o {
        C265385() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(40584);
            C4990ab.m7411d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", Integer.valueOf(C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Integer.valueOf(C7243d.vxo));
            if (C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0) == 32) {
                int i = C5046bo.getInt((String) map.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
                int i2 = C5046bo.getInt((String) map.get(".sysmsg.paymsg.grouppayreddot"), -1);
                int i3 = C5046bo.getInt((String) map.get(".sysmsg.paymsg.facingreceivereddot"), -1);
                int i4 = C5046bo.getInt((String) map.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
                int i5 = C5046bo.getInt((String) map.get(".sysmsg.paymsg.rewardcodereddot"), -1);
                int i6 = C5046bo.getInt((String) map.get(".sysmsg.paymsg.android_minclientversion"), -1);
                Object bc = C5046bo.m7532bc((String) map.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, bc);
                C4990ab.m7417i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                if (C7243d.vxo >= i6) {
                    bc = null;
                    if (i == 1) {
                        C4990ab.m7416i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
                        C16112c.m24429PK().mo28557y(262159, true);
                    } else if (i == 0) {
                        C16112c.m24429PK().mo28557y(262159, false);
                    }
                    if (i2 == 1) {
                        C4990ab.m7416i("MicroMsg.SubCoreAA", "mark group pay red dot");
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, true);
                        bc = 1;
                    } else if (i2 == 0) {
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, false);
                    }
                    if (i3 == 1) {
                        C4990ab.m7416i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, true);
                        bc = 1;
                    } else if (i3 == 0) {
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, false);
                    }
                    if (i4 == 1) {
                        C4990ab.m7416i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, true);
                        bc = 1;
                    } else if (i4 == 0) {
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, false);
                    }
                    if (i5 == 1) {
                        C4990ab.m7416i("MicroMsg.SubCoreAA", "mark qr reward red dot");
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, true);
                        bc = 1;
                    } else if (i5 == 0) {
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, false);
                    }
                    if (bc != null) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                }
                C7060h.pYm.mo8381e(14396, Integer.valueOf(1));
            }
            AppMethodBeat.m2505o(40584);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.b$8 */
    static class C265398 implements C1366d {
        C265398() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C18771b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.b$1 */
    class C328971 extends C4884c<C26206ni> {
        C328971() {
            super(0);
            AppMethodBeat.m2504i(40573);
            this.xxI = C26206ni.class.getName().hashCode();
            AppMethodBeat.m2505o(40573);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(40574);
            C26206ni c26206ni = (C26206ni) c4883b;
            String str = "MicroMsg.SubCoreAA";
            String str2 = "receiveAANewXmlEventListener, content==null: %s, type: %s, fromUser: %s, toUser: %s, paymsgid: %s";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(c26206ni.cJE.content == null);
            objArr[1] = Integer.valueOf(c26206ni.cJE.type);
            objArr[2] = c26206ni.cJE.cEV;
            objArr[3] = c26206ni.cJE.toUser;
            objArr[4] = c26206ni.cJE.cJF;
            C4990ab.m7417i(str, str2, objArr);
            if (c26206ni.cJE.type == C1954a.glq) {
                C9797h.m17456bg(c26206ni.cJE.content, c26206ni.cJE.toUser);
            } else if (c26206ni.cJE.type == C1954a.glr) {
                C9797h.m17465x(c26206ni.cJE.content, c26206ni.cJE.toUser, c26206ni.cJE.cJF);
            } else if (c26206ni.cJE.type == C1954a.gls) {
                String str3 = c26206ni.cJE.content;
                str = c26206ni.cJE.toUser;
                C4990ab.m7417i("MicroMsg.AAUtil", "insertUrgePaySysMsg, toUser: %s", str);
                if (!C5046bo.isNullOrNil(str3) && C1855t.m3896kH(str)) {
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo14781hO(0);
                    c7620bi.mo14794ju(str);
                    c7620bi.setStatus(3);
                    c7620bi.setContent(str3);
                    c7620bi.mo14775eJ(C1829bf.m3764q(str3, System.currentTimeMillis() / 1000));
                    c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                    c7620bi.mo14783hY(c7620bi.field_flag | 8);
                    c7620bi.setMsgId(C1829bf.m3752l(c7620bi));
                }
            }
            AppMethodBeat.m2505o(40574);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.b$2 */
    class C380082 extends C4884c<C37770nh> {
        C380082() {
            AppMethodBeat.m2504i(40575);
            this.xxI = C37770nh.class.getName().hashCode();
            AppMethodBeat.m2505o(40575);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(40576);
            C37770nh c37770nh = (C37770nh) c4883b;
            C4990ab.m7417i("MicroMsg.SubCoreAA", "ReceiveAAMsgEvent, localMsgId: %s, msgContent: %s", Long.valueOf(c37770nh.cJC.cJD), C5046bo.anv(c37770nh.cJC.cJh));
            C9797h.m17459g(r0, r2);
            AppMethodBeat.m2505o(40576);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.b$4 */
    class C380094 extends C4884c<C9304bs> {
        C380094() {
            AppMethodBeat.m2504i(40582);
            this.xxI = C9304bs.class.getName().hashCode();
            AppMethodBeat.m2505o(40582);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(40583);
            final C9304bs c9304bs = (C9304bs) c4883b;
            if (C5046bo.isNullOrNil(c9304bs.cuR.cuO) || C5046bo.isNullOrNil(c9304bs.cuR.cuP)) {
                AppMethodBeat.m2505o(40583);
            } else {
                new C18769d(c9304bs.cuR.cuO, c9304bs.cuR.cuP).acy().mo60492h(new C5681a<Void, C37441a<C44106c>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(40581);
                        C37441a c37441a = (C37441a) obj;
                        C4990ab.m7417i("MicroMsg.SubCoreAA", "close aa urge notify cgiback, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
                        if (c37441a.errType == 0 && c37441a.errCode == 0) {
                            C4990ab.m7416i("MicroMsg.SubCoreAA", "close aa urge notify success");
                            if (((C44106c) c37441a.fsy).kCl > 0 && !C5046bo.isNullOrNil(((C44106c) c37441a.fsy).kCm)) {
                                Toast.makeText(C4996ah.getContext(), ((C44106c) c37441a.fsy).kCm, 0).show();
                                C7060h.pYm.mo8378a(407, 29, 1, false);
                            } else if (((C44106c) c37441a.fsy).kCl == 0) {
                                Toast.makeText(C4996ah.getContext(), C25738R.string.ar4, 0).show();
                                C7060h.pYm.mo8378a(407, 27, 1, false);
                                if (!C5046bo.isNullOrNil(((C44106c) c37441a.fsy).vzN)) {
                                    C9797h.m17460h(c9304bs.cuR.cuQ, ((C44106c) c37441a.fsy).vzN);
                                }
                            } else {
                                C4990ab.m7416i("MicroMsg.SubCoreAA", "illegal resp");
                                C7060h.pYm.mo8378a(407, 29, 1, false);
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.SubCoreAA", "close aa urge notify failed");
                            Toast.makeText(C4996ah.getContext(), C25738R.string.ar3, 1).show();
                            C7060h.pYm.mo8378a(407, 28, 1, false);
                        }
                        Void voidR = zXH;
                        AppMethodBeat.m2505o(40581);
                        return voidR;
                    }
                });
                AppMethodBeat.m2505o(40583);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.b$3 */
    class C454873 extends C4884c<C26093br> {
        C454873() {
            AppMethodBeat.m2504i(40579);
            this.xxI = C26093br.class.getName().hashCode();
            AppMethodBeat.m2505o(40579);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(40580);
            C26093br c26093br = (C26093br) c4883b;
            C4990ab.m7417i("MicroMsg.SubCoreAA", "closeAAEvent callback, billNo: %s, chatroom: %s", c26093br.cuN.cuO, c26093br.cuN.cuP);
            if (C5046bo.isNullOrNil(c26093br.cuN.cuO) || C5046bo.isNullOrNil(c26093br.cuN.cuP)) {
                AppMethodBeat.m2505o(40580);
            } else {
                final C24677j c24677j = new C24677j();
                c24677j.aoo().init();
                C18778a c18778a = c24677j.glN;
                String str = c26093br.cuN.cuO;
                int i = C1954a.glp;
                C5698f.m8558b(str, Integer.valueOf(i), c26093br.cuN.cuP, Long.valueOf(c26093br.cuN.cuQ)).mo15892c(c18778a).mo15893d(new C5681a<Void, Boolean>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(40578);
                        C4990ab.m7417i("MicroMsg.SubCoreAA", "close aa success: %s", (Boolean) obj);
                        c24677j.aoo().aon();
                        Toast.makeText(C4996ah.getContext(), C25738R.string.ar4, 0).show();
                        Void voidR = zXH;
                        AppMethodBeat.m2505o(40578);
                        return voidR;
                    }
                }).mo11586a((C5690a) new C5690a() {
                    /* renamed from: bi */
                    public final void mo9345bi(Object obj) {
                        AppMethodBeat.m2504i(40577);
                        if (obj instanceof String) {
                            Toast.makeText(C4996ah.getContext(), obj.toString(), 0).show();
                        } else {
                            C4990ab.m7413e("MicroMsg.SubCoreAA", "close aa failed: %s", obj);
                            Toast.makeText(C4996ah.getContext(), C25738R.string.ar6, 1).show();
                        }
                        c24677j.aoo().aon();
                        AppMethodBeat.m2505o(40577);
                    }
                });
                AppMethodBeat.m2505o(40580);
            }
            return false;
        }
    }

    public C45488b() {
        AppMethodBeat.m2504i(40587);
        AppMethodBeat.m2505o(40587);
    }

    private static C45488b aoc() {
        AppMethodBeat.m2504i(40588);
        C45488b c45488b = (C45488b) C7485q.m12925Y(C45488b.class);
        AppMethodBeat.m2505o(40588);
        return c45488b;
    }

    static {
        AppMethodBeat.m2504i(40593);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("AARecord".hashCode()), new C187797());
        eaA.put(Integer.valueOf("AAPayRecord".hashCode()), new C265398());
        AppMethodBeat.m2505o(40593);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    public static C9795d aod() {
        AppMethodBeat.m2504i(40589);
        if (C45488b.aoc().gkM == null) {
            C45488b aoc = C45488b.aoc();
            C1720g.m3537RQ();
            aoc.gkM = new C9795d(C1720g.m3536RP().eJN);
        }
        C9795d c9795d = C45488b.aoc().gkM;
        AppMethodBeat.m2505o(40589);
        return c9795d;
    }

    public static C18771b aoe() {
        AppMethodBeat.m2504i(40590);
        if (C45488b.aoc().gkN == null) {
            C45488b aoc = C45488b.aoc();
            C1720g.m3537RQ();
            aoc.gkN = new C18771b(C1720g.m3536RP().eJN);
        }
        C18771b c18771b = C45488b.aoc().gkN;
        AppMethodBeat.m2505o(40590);
        return c18771b;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(40591);
        C4879a.xxA.mo10052c(this.gkG);
        C4879a.xxA.mo10052c(this.gkH);
        C4879a.xxA.mo10052c(this.gkI);
        C4879a.xxA.mo10052c(this.gkJ);
        C4879a.xxA.mo10052c(this.gkL);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("paymsg", this.gkK);
        AppMethodBeat.m2505o(40591);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(40592);
        C4879a.xxA.mo10053d(this.gkG);
        C4879a.xxA.mo10053d(this.gkH);
        C4879a.xxA.mo10053d(this.gkI);
        C4879a.xxA.mo10053d(this.gkJ);
        C4879a.xxA.mo10053d(this.gkL);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("paymsg", this.gkK);
        AppMethodBeat.m2505o(40592);
    }
}
