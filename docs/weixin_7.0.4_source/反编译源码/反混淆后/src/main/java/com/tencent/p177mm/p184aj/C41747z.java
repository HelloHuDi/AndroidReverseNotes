package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C42194e;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p184aj.C25764e.C25765a;
import com.tencent.p177mm.p184aj.C25764e.C25765a.C25766a;
import com.tencent.p177mm.p184aj.C25764e.C25765a.C8934b;
import com.tencent.p177mm.p184aj.C8935m.C8938a;
import com.tencent.p177mm.p184aj.p185a.C25757g;
import com.tencent.p177mm.p184aj.p185a.C25759h;
import com.tencent.p177mm.p184aj.p185a.C37446b;
import com.tencent.p177mm.p184aj.p185a.C37448d;
import com.tencent.p177mm.p184aj.p185a.C37449k;
import com.tencent.p177mm.p184aj.p185a.C8926i;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p711c.C6563at;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C23522t;
import com.tencent.p177mm.storage.C40635r;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7310be.C5132a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.aj.z */
public class C41747z implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private static long fwQ = 0;
    private C42194e flI = new C42194e();
    private C25764e fwR;
    private C8938a fwS = null;
    private C25767k fwT = null;
    private C41743i fwU;
    private C37453h fwV = null;
    private C37448d fwW = null;
    private C37446b fwX = null;
    private C37449k fwY = null;
    private C25757g fwZ = null;
    private C8926i fxa = null;
    private C25759h fxb = null;
    private C8927c fxc = null;
    private C40635r fxd = null;
    private C23522t fxe = null;
    private C32237a fxf;
    private C1837a fxg = new C322429();
    private C5132a fxh = new C4174810();
    private C25765a fxi = new C179072();

    /* renamed from: com.tencent.mm.aj.z$4 */
    static class C63054 implements C1366d {
        C63054() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C37448d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.aj.z$5 */
    static class C89405 implements C1366d {
        C89405() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C37449k.fnj;
        }
    }

    /* renamed from: com.tencent.mm.aj.z$2 */
    class C179072 implements C25765a {
        C179072() {
        }

        /* renamed from: a */
        public final void mo11091a(C8934b c8934b) {
            AppMethodBeat.m2504i(11464);
            if (c8934b.fwk == C25766a.INSTERT || c8934b.fwk == C25766a.UPDATE) {
                if (c8934b.fwl == null) {
                    AppMethodBeat.m2505o(11464);
                    return;
                }
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c8934b.fuO);
                if (aoO == null) {
                    AppMethodBeat.m2505o(11464);
                    return;
                } else if (!aoO.dsf()) {
                    C41747z.m73590j(c8934b.fwl);
                    AppMethodBeat.m2505o(11464);
                    return;
                } else if (C1855t.m3943nl(aoO.field_username)) {
                    AppMethodBeat.m2505o(11464);
                    return;
                } else {
                    C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c8934b.fuO);
                    C4990ab.m7419v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", c8934b.fuO);
                    if (!(!c8934b.fwl.adQ() || c8934b.fwl.mo30481cJ(false) == null || c8934b.fwl.mo30481cJ(false).aer() == null || C5046bo.isNullOrNil(c8934b.fwl.adX()) || !C5046bo.isNullOrNil(c8934b.fwl.field_enterpriseFather))) {
                        c8934b.fwl.field_enterpriseFather = c8934b.fwl.adX();
                        C41747z.aeR().mo43726e(c8934b.fwl);
                        C4990ab.m7417i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", c8934b.fuO, c8934b.fwl.field_enterpriseFather);
                    }
                    if (aoZ == null) {
                        AppMethodBeat.m2505o(11464);
                        return;
                    }
                    int i;
                    if (c8934b.fwl.adQ()) {
                        if (c8934b.fwl.mo30481cJ(false) == null) {
                            C4990ab.m7412e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                            AppMethodBeat.m2505o(11464);
                            return;
                        } else if (c8934b.fwl.mo30481cJ(false).aer() == null) {
                            C4990ab.m7412e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                            AppMethodBeat.m2505o(11464);
                            return;
                        } else {
                            String str = aoZ.field_parentRef;
                            if (c8934b.fwl.adR()) {
                                aoZ.mo14760jj(null);
                            } else {
                                C4990ab.m7417i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", c8934b.fwl.adX(), c8934b.fuO);
                                aoZ.mo14760jj(C5046bo.nullAsNil(c8934b.fwl.adX()));
                            }
                            if (str != null && aoZ.field_parentRef != null && !str.equals(aoZ.field_parentRef)) {
                                i = 1;
                            } else if (str == null && aoZ.field_parentRef != null) {
                                i = 1;
                            } else if (str == null || aoZ.field_parentRef != null) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            C4990ab.m7419v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", c8934b.fuO, aoZ.field_parentRef);
                        }
                    } else if (c8934b.fwl.adP()) {
                        C4990ab.m7419v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", c8934b.fuO);
                        i = 1;
                    } else if (!c8934b.fwl.adM() && !C1855t.m3921nG(aoO.field_username) && !"officialaccounts".equals(aoZ.field_parentRef)) {
                        aoZ.mo14760jj("officialaccounts");
                        i = 1;
                    } else if (!c8934b.fwl.adM() || aoZ.field_parentRef == null) {
                        i = 0;
                    } else {
                        aoZ.mo14760jj(null);
                        i = 1;
                    }
                    if (i != 0) {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, aoZ.field_username);
                        String dsR;
                        C7620bi Rb;
                        if (C5046bo.isNullOrNil(aoZ.field_parentRef)) {
                            AppMethodBeat.m2505o(11464);
                            return;
                        } else if ("officialaccounts".equals(aoZ.field_parentRef)) {
                            C6563at aoZ2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ("officialaccounts");
                            if (aoZ2 == null) {
                                C6563at c7617ak = new C7617ak("officialaccounts");
                                c7617ak.dsI();
                                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d((C7617ak) c7617ak);
                                aoZ2 = c7617ak;
                            }
                            if (C5046bo.isNullOrNil(aoZ2.field_content)) {
                                C4990ab.m7416i("MicroMsg.SubCoreBiz", "conv content is null");
                                dsR = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().dsR();
                                if (C5046bo.isNullOrNil(dsR)) {
                                    C4990ab.m7420w("MicroMsg.SubCoreBiz", "last convBiz is null");
                                    AppMethodBeat.m2505o(11464);
                                    return;
                                }
                                Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(dsR);
                                if (Rb == null || Rb.field_msgId == 0) {
                                    C4990ab.m7420w("MicroMsg.SubCoreBiz", "last biz msg is error");
                                    AppMethodBeat.m2505o(11464);
                                    return;
                                }
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(Rb.field_msgId, Rb);
                            }
                            AppMethodBeat.m2505o(11464);
                            return;
                        } else {
                            C4990ab.m7417i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", c8934b.fuO, aoZ.field_parentRef);
                            C7617ak aoZ3 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(aoZ.field_parentRef);
                            if (aoZ3 == null) {
                                AppMethodBeat.m2505o(11464);
                                return;
                            } else if (C5046bo.isNullOrNil(aoZ3.field_content)) {
                                C4990ab.m7416i("MicroMsg.SubCoreBiz", "conv content is null");
                                dsR = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apm(aoZ.field_parentRef);
                                if (C5046bo.isNullOrNil(dsR)) {
                                    C4990ab.m7420w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                                    AppMethodBeat.m2505o(11464);
                                    return;
                                }
                                Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(dsR);
                                if (Rb == null || Rb.field_msgId == 0) {
                                    C4990ab.m7420w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                                    AppMethodBeat.m2505o(11464);
                                    return;
                                }
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(Rb.field_msgId, Rb);
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(11464);
        }
    }

    /* renamed from: com.tencent.mm.aj.z$3 */
    static class C257743 implements C1366d {
        C257743() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C41743i.fnj;
        }
    }

    /* renamed from: com.tencent.mm.aj.z$7 */
    static class C322407 implements C1366d {
        C322407() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C25757g.fnj;
        }
    }

    /* renamed from: com.tencent.mm.aj.z$8 */
    static class C322418 implements C1366d {
        C322418() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C8927c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.aj.z$9 */
    class C322429 implements C1837a {
        C322429() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(11465);
            C7254cm c7254cm = c1197a.eAB;
            if (c7254cm == null) {
                C4990ab.m7412e("MicroMsg.SubCoreBiz", "AddMsg is null.");
                AppMethodBeat.m2505o(11465);
                return;
            }
            String a = C1946aa.m4148a(c7254cm.vED);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7412e("MicroMsg.SubCoreBiz", "msg content is null");
                AppMethodBeat.m2505o(11465);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z == null || z.size() <= 0) {
                C4990ab.m7412e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
                AppMethodBeat.m2505o(11465);
                return;
            }
            if ("mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
                C4990ab.m7417i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0)));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, Integer.valueOf(r0));
                C1720g.m3536RP().mo5239Ry().dsb();
                AppMethodBeat.m2505o(11465);
                return;
            }
            C4990ab.m7412e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
            AppMethodBeat.m2505o(11465);
        }
    }

    /* renamed from: com.tencent.mm.aj.z$6 */
    static class C374576 implements C1366d {
        C374576() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C37446b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.aj.z$10 */
    class C4174810 implements C5132a {
        C4174810() {
        }

        /* renamed from: a */
        public final void mo10531a(C7617ak c7617ak, C7310be c7310be) {
            AppMethodBeat.m2504i(11466);
            if (!(c7617ak == null || C5046bo.isNullOrNil(c7617ak.field_username))) {
                String str = c7617ak.field_username;
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                if (aoO == null) {
                    AppMethodBeat.m2505o(11466);
                    return;
                } else if (aoO.dsf() && !C1855t.m3943nl(str)) {
                    C16527d qP = C41747z.aeR().mo43729qP(str);
                    if (qP.xDa == -1) {
                        C4990ab.m7416i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
                        AppMethodBeat.m2505o(11466);
                        return;
                    } else if (qP.adQ()) {
                        if (qP.mo30481cJ(false) == null) {
                            c7617ak.mo14760jj(null);
                            C4990ab.m7412e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                            AppMethodBeat.m2505o(11466);
                            return;
                        } else if (qP.mo30481cJ(false).aer() == null) {
                            c7617ak.mo14760jj(null);
                            C4990ab.m7412e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                            AppMethodBeat.m2505o(11466);
                            return;
                        } else {
                            if (qP.adR()) {
                                c7617ak.mo14760jj(null);
                            } else {
                                c7617ak.mo14760jj(C5046bo.nullAsNil(qP.adX()));
                                if (C5046bo.isNullOrNil(qP.adX())) {
                                    C4990ab.m7421w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", c7617ak.field_username);
                                    AppMethodBeat.m2505o(11466);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(11466);
                            return;
                        }
                    } else if (qP.adM() || qP.adP() || C1855t.m3921nG(str)) {
                        c7617ak.mo14760jj(null);
                        AppMethodBeat.m2505o(11466);
                        return;
                    } else {
                        c7617ak.mo14760jj("officialaccounts");
                    }
                }
            }
            AppMethodBeat.m2505o(11466);
        }
    }

    /* renamed from: com.tencent.mm.aj.z$1 */
    static class C417491 implements C1366d {
        C417491() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C25764e.fnj;
        }
    }

    static {
        AppMethodBeat.m2504i(11488);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new C417491());
        eaA.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new C257743());
        eaA.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new C63054());
        eaA.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new C89405());
        eaA.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new C374576());
        eaA.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new C322407());
        eaA.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new C322418());
        AppMethodBeat.m2505o(11488);
    }

    public C41747z() {
        AppMethodBeat.m2504i(11467);
        AppMethodBeat.m2505o(11467);
    }

    private static synchronized C41747z aeP() {
        C41747z c41747z;
        synchronized (C41747z.class) {
            AppMethodBeat.m2504i(11468);
            c41747z = (C41747z) C7485q.m12925Y(C41747z.class);
            AppMethodBeat.m2505o(11468);
        }
        return c41747z;
    }

    public static C41743i aeQ() {
        AppMethodBeat.m2504i(11469);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwU == null) {
            C41747z.aeP().fwU = new C41743i(C1720g.m3536RP().eJN);
        }
        C41743i c41743i = C41747z.aeP().fwU;
        AppMethodBeat.m2505o(11469);
        return c41743i;
    }

    public static C25764e aeR() {
        AppMethodBeat.m2504i(11470);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwR == null) {
            C41747z.aeP().fwR = new C25764e(C1720g.m3536RP().eJN);
        }
        C25764e c25764e = C41747z.aeP().fwR;
        AppMethodBeat.m2505o(11470);
        return c25764e;
    }

    public static C37453h aeS() {
        AppMethodBeat.m2504i(11471);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwV == null) {
            C41747z.aeP().fwV = new C37453h();
            C1202f c1202f = C41747z.aeP().fwV;
            C1720g.m3535RO().eJo.mo14539a(675, c1202f);
            C1720g.m3535RO().eJo.mo14539a(672, c1202f);
            C1720g.m3535RO().eJo.mo14539a(674, c1202f);
            synchronized (c1202f.cli) {
                try {
                    c1202f.fwn.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(11471);
                    }
                }
            }
        }
        C37453h c37453h = C41747z.aeP().fwV;
        AppMethodBeat.m2505o(11471);
        return c37453h;
    }

    public static C37448d aeT() {
        AppMethodBeat.m2504i(11472);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwW == null) {
            C41747z.aeP().fwW = new C37448d(C1720g.m3536RP().eJN);
        }
        C37448d c37448d = C41747z.aeP().fwW;
        AppMethodBeat.m2505o(11472);
        return c37448d;
    }

    public static C37446b aeU() {
        AppMethodBeat.m2504i(11473);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwX == null) {
            C41747z.aeP().fwX = new C37446b(C1720g.m3536RP().eJN);
        }
        C37446b c37446b = C41747z.aeP().fwX;
        AppMethodBeat.m2505o(11473);
        return c37446b;
    }

    public static C37449k aeV() {
        AppMethodBeat.m2504i(11474);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwY == null) {
            C41747z.aeP().fwY = new C37449k(C1720g.m3536RP().eJN);
        }
        C37449k c37449k = C41747z.aeP().fwY;
        AppMethodBeat.m2505o(11474);
        return c37449k;
    }

    public static C25757g aeW() {
        AppMethodBeat.m2504i(11475);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwZ == null) {
            C41747z.aeP().fwZ = new C25757g(C1720g.m3536RP().eJN);
        }
        C25757g c25757g = C41747z.aeP().fwZ;
        AppMethodBeat.m2505o(11475);
        return c25757g;
    }

    public static C40635r aeX() {
        AppMethodBeat.m2504i(11476);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fxd == null) {
            C41747z.aeP().fxd = new C40635r(C1720g.m3536RP().eJN);
        }
        C40635r c40635r = C41747z.aeP().fxd;
        AppMethodBeat.m2505o(11476);
        return c40635r;
    }

    public static C23522t aeY() {
        AppMethodBeat.m2504i(11477);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fxe == null) {
            C41747z.aeP().fxe = new C23522t(C1720g.m3536RP().eJN);
        }
        C23522t c23522t = C41747z.aeP().fxe;
        AppMethodBeat.m2505o(11477);
        return c23522t;
    }

    public static C25759h aeZ() {
        AppMethodBeat.m2504i(11478);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fxb == null) {
            C41747z.aeP().fxb = new C25759h();
        }
        C25759h c25759h = C41747z.aeP().fxb;
        AppMethodBeat.m2505o(11478);
        return c25759h;
    }

    public static C8927c afa() {
        AppMethodBeat.m2504i(11479);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fxc == null) {
            C41747z.aeP().fxc = new C8927c(C1720g.m3536RP().eJN);
        }
        C8927c c8927c = C41747z.aeP().fxc;
        AppMethodBeat.m2505o(11479);
        return c8927c;
    }

    public static C8938a afb() {
        AppMethodBeat.m2504i(11480);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwS == null) {
            C41747z.aeP().fwS = new C8938a();
        }
        C8938a c8938a = C41747z.aeP().fwS;
        AppMethodBeat.m2505o(11480);
        return c8938a;
    }

    public static C25767k afc() {
        AppMethodBeat.m2504i(11481);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fwT == null) {
            C41747z.aeP().fwT = new C25767k();
        }
        C25767k c25767k = C41747z.aeP().fwT;
        AppMethodBeat.m2505o(11481);
        return c25767k;
    }

    public static C32237a afd() {
        AppMethodBeat.m2504i(11482);
        if (C41747z.aeP().fxf == null) {
            C41747z.aeP().fxf = new C32237a();
        }
        C32237a c32237a = C41747z.aeP().fxf;
        AppMethodBeat.m2505o(11482);
        return c32237a;
    }

    public static C8926i afe() {
        AppMethodBeat.m2504i(11483);
        C1720g.m3534RN().mo5159QU();
        if (C41747z.aeP().fxa == null) {
            C41747z.aeP().fxa = new C8926i();
        }
        C8926i c8926i = C41747z.aeP().fxa;
        AppMethodBeat.m2505o(11483);
        return c8926i;
    }

    public static long aff() {
        AppMethodBeat.m2504i(11484);
        if (fwQ == 0) {
            Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, null);
            if (obj != null && (obj instanceof Long)) {
                fwQ = ((Long) obj).longValue();
                C4990ab.m7417i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", Long.valueOf(fwQ));
            }
        }
        if (fwQ == 0) {
            fwQ = System.currentTimeMillis();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, Long.valueOf(fwQ));
            C4990ab.m7417i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", Long.valueOf(fwQ));
        }
        long j = fwQ;
        AppMethodBeat.m2505o(11484);
        return j;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(11485);
        C1200d.m2636a(Integer.valueOf(55), this.flI);
        C1200d.m2636a(Integer.valueOf(57), this.flI);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15805c(this.fxh);
        C41747z.aeR().mo43722a(this.fxi, null);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("mmbizattrappsvr_BizAttrSync", this.fxg, true);
        AppMethodBeat.m2505o(11485);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(11486);
        C1200d.m2637b(Integer.valueOf(55), this.flI);
        C1200d.m2637b(Integer.valueOf(57), this.flI);
        if (C41747z.aeP().fwV != null) {
            C1202f c1202f = C41747z.aeP().fwV;
            C1720g.m3535RO().eJo.mo14546b(675, c1202f);
            C1720g.m3535RO().eJo.mo14546b(672, c1202f);
            C1720g.m3535RO().eJo.mo14546b(674, c1202f);
            synchronized (c1202f.cli) {
                try {
                    c1202f.fwn.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(11486);
                    }
                }
            }
            c1202f.fwm.clear();
        }
        if (C1720g.m3534RN().mo5161QY()) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15808d(this.fxh);
            C41747z.aeR().mo43721a(this.fxi);
        }
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("mmbizattrappsvr_BizAttrSync", this.fxg, true);
        AppMethodBeat.m2505o(11486);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: j */
    static /* synthetic */ void m73590j(C16527d c16527d) {
        AppMethodBeat.m2504i(11487);
        if (!(!c16527d.adQ() || c16527d.adR() || c16527d.mo30481cJ(false) == null || c16527d.mo30481cJ(false).aer() == null || C5046bo.isNullOrNil(c16527d.adX()))) {
            if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c16527d.adX()) == null) {
                C4990ab.m7410d("MicroMsg.SubCoreBiz", "father conv is null");
            }
            if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c16527d.field_username) == null) {
                C4990ab.m7419v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", c16527d.field_username);
                C7617ak c7617ak = new C7617ak(c16527d.field_username);
                if (!c16527d.adR()) {
                    C4990ab.m7417i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", c16527d.adX(), c16527d.field_username);
                    c7617ak.mo14760jj(C5046bo.nullAsNil(c16527d.adX()));
                    c7617ak.dsI();
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(c7617ak);
                }
            }
        }
        AppMethodBeat.m2505o(11487);
    }
}
