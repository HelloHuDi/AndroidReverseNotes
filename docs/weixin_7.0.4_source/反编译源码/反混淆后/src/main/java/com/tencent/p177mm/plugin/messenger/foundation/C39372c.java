package com.tencent.p177mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1830bg;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21281u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C23454vv;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C40580vo;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.c */
public final class C39372c implements C21279r {
    /* renamed from: a */
    public final void mo36640a(C40573tb c40573tb, byte[] bArr, boolean z, C21280t c21280t) {
        boolean z2 = false;
        AppMethodBeat.m2504i(1025);
        switch (c40573tb.wat) {
            case 5:
                C7254cm c7254cm = (C7254cm) new C7254cm().parseFrom(bArr);
                if (c7254cm != null) {
                    C1197a c1197a = new C1197a(c7254cm, false, false, false);
                    C39372c.m67145a(c1197a, c21280t);
                    if (!c1197a.fsU) {
                        C1830bg.m3766a(C1946aa.m4148a(c7254cm.vEB), c7254cm.ptF, ((long) c7254cm.pcX) * 1000, c7254cm.nao);
                    }
                }
                AppMethodBeat.m2505o(1025);
                return;
            case 8:
                C40580vo c40580vo = (C40580vo) new C40580vo().parseFrom(bArr);
                String a = C1946aa.m4148a(c40580vo.wcB);
                int i = c40580vo.wcE;
                Cursor cy = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15326cy(a, i);
                if (cy.moveToFirst()) {
                    while (!cy.isAfterLast()) {
                        C7620bi c7620bi = new C7620bi();
                        c7620bi.mo8995d(cy);
                        C1829bf.m3753m(c7620bi);
                        cy.moveToNext();
                    }
                }
                cy.close();
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15325cx(a, i);
                AppMethodBeat.m2505o(1025);
                return;
            case 9:
                C23454vv c23454vv = (C23454vv) new C23454vv().parseFrom(bArr);
                LinkedList linkedList = c23454vv.wcH;
                while (true) {
                    boolean z3 = z2;
                    if (z3 >= linkedList.size()) {
                        break;
                    }
                    C1829bf.m3765r(C1946aa.m4148a(c23454vv.wcB), (long) ((Integer) linkedList.get(z3)).intValue());
                    z2 = z3 + 1;
                }
        }
        AppMethodBeat.m2505o(1025);
    }

    /* renamed from: a */
    public static C1198b m67145a(C1197a c1197a, C21280t c21280t) {
        AppMethodBeat.m2504i(1026);
        C7254cm c7254cm = c1197a.eAB;
        if (10008 == C1947ae.giz && C1947ae.giA != 0) {
            C4990ab.m7417i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(c7254cm.ptF), Integer.valueOf(C1947ae.giA));
            c7254cm.ptF = (long) C1947ae.giA;
            C1947ae.giA = 0;
        }
        if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15342jh(c7254cm.ptF)) {
            C4990ab.m7416i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
            AppMethodBeat.m2505o(1026);
            return null;
        }
        String a = C1946aa.m4148a(c7254cm.vEB);
        String a2 = C1946aa.m4148a(c7254cm.vEC);
        if (a.equals(C1853r.m3846Yz()) && a2.equals("newsapp") && c7254cm.nao != 51) {
            C4990ab.m7421w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", Long.valueOf(c7254cm.ptF), Integer.valueOf(c7254cm.nao));
            AppMethodBeat.m2505o(1026);
            return null;
        }
        C4990ab.m7417i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", a, a2, Long.valueOf(c7254cm.ptF), Integer.valueOf(c7254cm.ptD), Integer.valueOf(c7254cm.vEI), Integer.valueOf(c7254cm.jBT), Integer.valueOf(c7254cm.nao), Integer.valueOf(c7254cm.pcX), C5046bo.m7579mx((long) c7254cm.pcX), Long.valueOf(C5046bo.anT() - ((long) c7254cm.pcX)), Integer.valueOf(c7254cm.vEE), Integer.valueOf(C1946aa.m4151a(c7254cm.vEF, new byte[0]).length), Integer.valueOf(C5046bo.nullAsNil(c7254cm.vEG).length()), Integer.valueOf(C5046bo.nullAsNil(c7254cm.vEH).length()), C5046bo.anv(C1946aa.m4149a(c7254cm.vED, "")));
        C4990ab.m7417i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", c7254cm.vEG, "");
        C21281u.m32655h(c7254cm);
        if (a.equals("readerapp")) {
            c7254cm.vEB = C1946aa.m4154vy("newsapp");
            c7254cm.nao = 12399999;
        }
        if ((a.equals("blogapp") || a.equals("newsapp")) && c7254cm.nao != 10002) {
            c7254cm.nao = 12399999;
        }
        if (c7254cm.nao == 52) {
            c7254cm.nao = 1000052;
        }
        if (c7254cm.nao == 53) {
            c7254cm.nao = 1000053;
        }
        C1829bf.m3746c(c1197a);
        Object obj = null;
        C1198b c1198b = null;
        C1201e bg = C1200d.m2638bg(Integer.valueOf(c7254cm.nao));
        if (bg == null) {
            bg = C1200d.m2638bg(a);
        }
        if (bg != null) {
            c1198b = bg.mo4453b(c1197a);
            C6575cy c6575cy = c1198b == null ? null : c1198b.csG;
            if (c6575cy == null) {
                C4990ab.m7421w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", Integer.valueOf(c7254cm.nao), Long.valueOf(c7254cm.ptF), Integer.valueOf(c7254cm.vEI), Integer.valueOf(c7254cm.pcX), c1197a);
            } else if (!C39372c.m67144QE(a)) {
                C4990ab.m7410d("MicroMsg.MessageSyncExtension", " msg , id =" + c6575cy.field_msgId + "  " + c21280t);
                if (c6575cy.field_msgId > 0 && c21280t != null && c1198b.fsZ) {
                    c21280t.mo8118a(c6575cy, c7254cm);
                }
            }
            obj = 1;
        }
        C21281u.m32653b(5, c7254cm);
        if (obj == null) {
            C4990ab.m7415f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", Integer.valueOf(c7254cm.nao));
        }
        AppMethodBeat.m2505o(1026);
        return c1198b;
    }

    /* renamed from: QE */
    private static boolean m67144QE(String str) {
        AppMethodBeat.m2504i(1027);
        if (!C1855t.m3935nd(str) || C17950b.ahP()) {
            AppMethodBeat.m2505o(1027);
            return false;
        }
        AppMethodBeat.m2505o(1027);
        return true;
    }
}
