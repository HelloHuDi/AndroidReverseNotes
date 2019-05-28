package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3467a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.model.e */
public class C42194e implements C1201e {
    private static final C42193a fks = new C42193a();

    /* renamed from: com.tencent.mm.model.e$a */
    static final class C42193a extends C6454a<C3467a> implements C3467a {
        private C42193a() {
        }

        /* synthetic */ C42193a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo7926a(C1197a c1197a, C7620bi c7620bi, String str, String str2, boolean z) {
            AppMethodBeat.m2504i(59716);
            final C1197a c1197a2 = c1197a;
            final C7620bi c7620bi2 = c7620bi;
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            mo14669a(new C1387a<C3467a>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(59714);
                    ((C3467a) obj).mo7926a(c1197a2, c7620bi2, str3, str4, z2);
                    AppMethodBeat.m2505o(59714);
                }
            });
            AppMethodBeat.m2505o(59716);
        }

        /* renamed from: b */
        public final void mo7927b(C1197a c1197a, C7620bi c7620bi, String str, String str2, boolean z) {
            AppMethodBeat.m2504i(59717);
            final C1197a c1197a2 = c1197a;
            final C7620bi c7620bi2 = c7620bi;
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            mo14669a(new C1387a<C3467a>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(59715);
                    ((C3467a) obj).mo7927b(c1197a2, c7620bi2, str3, str4, z2);
                    AppMethodBeat.m2505o(59715);
                }
            });
            AppMethodBeat.m2505o(59717);
        }
    }

    static {
        AppMethodBeat.m2504i(59721);
        AppMethodBeat.m2505o(59721);
    }

    /* renamed from: a */
    public static void m74429a(C3467a c3467a) {
        AppMethodBeat.m2504i(59718);
        fks.mo14670aD(c3467a);
        AppMethodBeat.m2505o(59718);
    }

    /* renamed from: b */
    public C1198b mo4453b(C1197a c1197a) {
        C1198b c1198b = null;
        AppMethodBeat.m2504i(59719);
        C7254cm c7254cm = c1197a.eAB;
        String str = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        if (str.length() <= 0) {
            AppMethodBeat.m2505o(59719);
        } else {
            String a = C1946aa.m4148a(c7254cm.vEB);
            String a2 = C1946aa.m4148a(c7254cm.vEC);
            if (C5046bo.nullAsNil(a).length() <= 0 || C5046bo.nullAsNil(a2).length() <= 0) {
                C4990ab.m7412e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
                AppMethodBeat.m2505o(59719);
            } else {
                C7620bi a3 = mo43844a(c7254cm, a, a2, str);
                if (a3 == null) {
                    AppMethodBeat.m2505o(59719);
                } else {
                    int i;
                    C7620bi c7620bi;
                    boolean z = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().has(a) || str.equals(a);
                    if (z) {
                        a3.mo14781hO(1);
                        a3.mo14794ju(a2);
                        i = c7254cm.jBT;
                        c7620bi = a3;
                    } else {
                        a3.mo14781hO(0);
                        a3.mo14794ju(a);
                        if (c7254cm.jBT > 3) {
                            i = c7254cm.jBT;
                            c7620bi = a3;
                        } else {
                            i = 3;
                            c7620bi = a3;
                        }
                    }
                    c7620bi.setStatus(i);
                    if (c7254cm.nao == Downloads.MIN_WAIT_FOR_NETWORK) {
                        a3.setStatus(4);
                    }
                    a3.mo14791ix(c7254cm.vEG);
                    if (a3.apB(C1853r.m3846Yz())) {
                        C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(a3.field_talker);
                        if (aoZ != null) {
                            aoZ.mo16713jk(16777216);
                            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, a3.field_talker);
                        }
                    }
                    fks.mo7926a(c1197a, a3, a, a2, z);
                    if (a3.field_msgId == 0) {
                        a3.mo14783hY(2);
                        C1829bf.m3743a(a3, c1197a);
                        a3.setMsgId(C1829bf.m3752l(a3));
                        c1198b = new C1198b(a3, true);
                    } else {
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c7254cm.ptF, a3);
                        c1198b = new C1198b(a3, false);
                    }
                    fks.mo7927b(c1197a, a3, a, a2, z);
                    AppMethodBeat.m2505o(59719);
                }
            }
        }
        return c1198b;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C7620bi mo43844a(C7254cm c7254cm, String str, String str2, String str3) {
        AppMethodBeat.m2504i(59720);
        String str4 = str3.equals(str) ? str2 : str;
        C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(str4, c7254cm.ptF);
        C4990ab.m7417i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId), str, str2, str4);
        if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < C1829bf.m3764q(str4, (long) c7254cm.pcX)) {
            C4990ab.m7421w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId));
            C1829bf.m3748fm(Q.field_msgId);
            Q.setMsgId(0);
        }
        if (Q.field_msgId == 0) {
            Q = new C7620bi();
            Q.mo14774eI(c7254cm.ptF);
            Q.mo14775eJ(C1829bf.m3764q(str4, (long) c7254cm.pcX));
            Q.setType(c7254cm.nao);
            Q.setContent(C5046bo.anA(C5046bo.nullAsNil(C1946aa.m4148a(c7254cm.vED))));
        }
        AppMethodBeat.m2505o(59720);
        return Q;
    }

    /* renamed from: a */
    public void mo4452a(C1199c c1199c) {
    }
}
