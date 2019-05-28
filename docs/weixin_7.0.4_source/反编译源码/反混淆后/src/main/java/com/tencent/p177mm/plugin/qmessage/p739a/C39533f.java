package com.tencent.p177mm.plugin.qmessage.p739a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.qmessage.a.f */
public final class C39533f implements C1201e {

    /* renamed from: com.tencent.mm.plugin.qmessage.a.f$a */
    public static final class C28724a {
        String content;
        String eoz;

        /* synthetic */ C28724a(byte b) {
            this();
        }

        private C28724a() {
            this.eoz = "";
            this.content = "";
        }
    }

    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(24085);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null) {
            C4990ab.m7412e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.m2505o(24085);
            return null;
        } else if (c7254cm.nao == 36 || c7254cm.nao == 39) {
            C7620bi c7620bi;
            int i;
            C1198b c1198b;
            String a = C1946aa.m4148a(c7254cm.vED);
            String a2 = C1946aa.m4148a(c7254cm.vEB);
            String a3 = C1946aa.m4148a(c7254cm.vEC);
            C4990ab.m7410d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(a)));
            C9638aw.m17190ZK();
            String str = (String) C18628c.m29072Ry().get(2, null);
            String str2 = str.equals(a2) ? a3 : a2;
            C9638aw.m17190ZK();
            C7620bi Q = C18628c.m29080XO().mo15241Q(str2, c7254cm.ptF);
            C4990ab.m7411d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId));
            if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < C1829bf.m3764q(a2, (long) c7254cm.pcX)) {
                C4990ab.m7421w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId));
                C1829bf.m3748fm(Q.field_msgId);
                Q.setMsgId(0);
            }
            if (Q.field_msgId == 0) {
                Q = new C7620bi();
                Q.mo14774eI(c7254cm.ptF);
                Q.mo14775eJ(C1829bf.m3764q(a2, (long) c7254cm.pcX));
                c7620bi = Q;
            } else {
                c7620bi = Q;
            }
            c7620bi.setType(c7254cm.nao);
            c7620bi.mo14794ju(str2);
            C12873d Vb = C46142g.cca().mo55344Vb(str2);
            if (Vb == null || C5046bo.nullAsNil(Vb.getUsername()).length() <= 0) {
                Vb = new C12873d();
                Vb.username = str2;
                Vb.psK = 1;
                Vb.bJt = 9;
                if (!C46142g.cca().mo55345a(Vb)) {
                    C4990ab.m7412e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + Vb.getUsername());
                }
            }
            long j = -1;
            if (c7254cm.vEE == 2 && c7620bi.field_msgId == 0) {
                byte[] a4 = C1946aa.m4150a(c7254cm.vEF);
                PString pString = new PString();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                j = C32291o.ahl().mo73082a(a4, c7254cm.ptF, false, "", pString, pInt, pInt2);
                if (j > 0) {
                    c7620bi.mo14795jv(pString.value);
                    c7620bi.mo14784hZ(pInt.value);
                    c7620bi.mo14786ia(pInt2.value);
                }
            }
            long j2 = j;
            if (c7254cm.nao == 36) {
                boolean z;
                C7616ad c7616ad;
                Assert.assertTrue(true);
                if (C5046bo.nullAsNil(a).length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                Assert.assertTrue(C5046bo.nullAsNil(c7620bi.field_talker).length() > 0);
                Object obj = null;
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(c7620bi.field_talker);
                if (aoO == null || C5046bo.nullAsNil(aoO.field_username).length() <= 0) {
                    obj = 1;
                    c7616ad = new C7616ad(c7620bi.field_talker);
                } else {
                    c7616ad = aoO;
                }
                C28724a c28724a = new C28724a();
                Map z2 = C5049br.m7595z(a, "msg");
                if (z2 != null) {
                    c28724a.eoz = (String) z2.get(".msg.from.displayname");
                    c28724a.content = (String) z2.get(".msg.content.t");
                }
                if (c28724a.eoz == null) {
                    str2 = "";
                } else {
                    str2 = c28724a.eoz;
                }
                c7616ad.mo14729iz(str2);
                if (c28724a.content == null) {
                    str2 = "";
                } else {
                    str2 = c28724a.content;
                }
                c7620bi.setContent(str2);
                if (obj != null) {
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15702Z(c7616ad);
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15724b(c7616ad.field_username, c7616ad);
                }
            }
            C9638aw.m17190ZK();
            Object obj2 = (C18628c.m29086XU().has(a2) || str.equals(a2)) ? 1 : null;
            if (obj2 != null) {
                c7620bi.mo14781hO(1);
                i = c7254cm.jBT;
                Q = c7620bi;
            } else {
                c7620bi.mo14781hO(0);
                if (c7254cm.jBT > 3) {
                    i = c7254cm.jBT;
                    Q = c7620bi;
                } else {
                    i = 3;
                    Q = c7620bi;
                }
            }
            Q.setStatus(i);
            c7620bi.mo14791ix(c7254cm.vEG);
            C1829bf.m3743a(c7620bi, c1197a);
            if (c7620bi.field_msgId == 0) {
                c7620bi.setMsgId(C1829bf.m3752l(c7620bi));
                if (c7254cm.vEE == 2) {
                    C25822e b = C32291o.ahl().mo73105b(Long.valueOf(j2));
                    b.mo43793fG((long) ((int) c7620bi.field_msgId));
                    C32291o.ahl().mo73077a(Long.valueOf(j2), b);
                }
                c1198b = new C1198b(c7620bi, true);
            } else {
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15302b(c7254cm.ptF, c7620bi);
                c1198b = new C1198b(c7620bi, false);
            }
            AppMethodBeat.m2505o(24085);
            return c1198b;
        } else {
            C4990ab.m7413e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", Integer.valueOf(c7254cm.nao));
            AppMethodBeat.m2505o(24085);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
        AppMethodBeat.m2504i(24086);
        C32291o.ahl().mo73125x(c1199c.cKd);
        AppMethodBeat.m2505o(24086);
    }
}
