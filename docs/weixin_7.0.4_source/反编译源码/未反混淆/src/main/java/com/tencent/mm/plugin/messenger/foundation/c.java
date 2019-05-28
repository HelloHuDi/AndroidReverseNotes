package com.tencent.mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class c implements r {
    public final void a(tb tbVar, byte[] bArr, boolean z, t tVar) {
        boolean z2 = false;
        AppMethodBeat.i(1025);
        switch (tbVar.wat) {
            case 5:
                cm cmVar = (cm) new cm().parseFrom(bArr);
                if (cmVar != null) {
                    a aVar = new a(cmVar, false, false, false);
                    a(aVar, tVar);
                    if (!aVar.fsU) {
                        bg.a(aa.a(cmVar.vEB), cmVar.ptF, ((long) cmVar.pcX) * 1000, cmVar.nao);
                    }
                }
                AppMethodBeat.o(1025);
                return;
            case 8:
                vo voVar = (vo) new vo().parseFrom(bArr);
                String a = aa.a(voVar.wcB);
                int i = voVar.wcE;
                Cursor cy = ((j) g.K(j.class)).bOr().cy(a, i);
                if (cy.moveToFirst()) {
                    while (!cy.isAfterLast()) {
                        bi biVar = new bi();
                        biVar.d(cy);
                        bf.m(biVar);
                        cy.moveToNext();
                    }
                }
                cy.close();
                ((j) g.K(j.class)).bOr().cx(a, i);
                AppMethodBeat.o(1025);
                return;
            case 9:
                vv vvVar = (vv) new vv().parseFrom(bArr);
                LinkedList linkedList = vvVar.wcH;
                while (true) {
                    boolean z3 = z2;
                    if (z3 >= linkedList.size()) {
                        break;
                    }
                    bf.r(aa.a(vvVar.wcB), (long) ((Integer) linkedList.get(z3)).intValue());
                    z2 = z3 + 1;
                }
        }
        AppMethodBeat.o(1025);
    }

    public static b a(a aVar, t tVar) {
        AppMethodBeat.i(1026);
        cm cmVar = aVar.eAB;
        if (10008 == ae.giz && ae.giA != 0) {
            ab.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(cmVar.ptF), Integer.valueOf(ae.giA));
            cmVar.ptF = (long) ae.giA;
            ae.giA = 0;
        }
        if (((j) g.K(j.class)).bOr().jh(cmVar.ptF)) {
            ab.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
            AppMethodBeat.o(1026);
            return null;
        }
        String a = aa.a(cmVar.vEB);
        String a2 = aa.a(cmVar.vEC);
        if (a.equals(com.tencent.mm.model.r.Yz()) && a2.equals("newsapp") && cmVar.nao != 51) {
            ab.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", Long.valueOf(cmVar.ptF), Integer.valueOf(cmVar.nao));
            AppMethodBeat.o(1026);
            return null;
        }
        ab.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", a, a2, Long.valueOf(cmVar.ptF), Integer.valueOf(cmVar.ptD), Integer.valueOf(cmVar.vEI), Integer.valueOf(cmVar.jBT), Integer.valueOf(cmVar.nao), Integer.valueOf(cmVar.pcX), bo.mx((long) cmVar.pcX), Long.valueOf(bo.anT() - ((long) cmVar.pcX)), Integer.valueOf(cmVar.vEE), Integer.valueOf(aa.a(cmVar.vEF, new byte[0]).length), Integer.valueOf(bo.nullAsNil(cmVar.vEG).length()), Integer.valueOf(bo.nullAsNil(cmVar.vEH).length()), bo.anv(aa.a(cmVar.vED, "")));
        ab.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", cmVar.vEG, "");
        u.h(cmVar);
        if (a.equals("readerapp")) {
            cmVar.vEB = aa.vy("newsapp");
            cmVar.nao = 12399999;
        }
        if ((a.equals("blogapp") || a.equals("newsapp")) && cmVar.nao != 10002) {
            cmVar.nao = 12399999;
        }
        if (cmVar.nao == 52) {
            cmVar.nao = 1000052;
        }
        if (cmVar.nao == 53) {
            cmVar.nao = 1000053;
        }
        bf.c(aVar);
        Object obj = null;
        b bVar = null;
        e bg = d.bg(Integer.valueOf(cmVar.nao));
        if (bg == null) {
            bg = d.bg(a);
        }
        if (bg != null) {
            bVar = bg.b(aVar);
            cy cyVar = bVar == null ? null : bVar.csG;
            if (cyVar == null) {
                ab.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", Integer.valueOf(cmVar.nao), Long.valueOf(cmVar.ptF), Integer.valueOf(cmVar.vEI), Integer.valueOf(cmVar.pcX), aVar);
            } else if (!QE(a)) {
                ab.d("MicroMsg.MessageSyncExtension", " msg , id =" + cyVar.field_msgId + "  " + tVar);
                if (cyVar.field_msgId > 0 && tVar != null && bVar.fsZ) {
                    tVar.a(cyVar, cmVar);
                }
            }
            obj = 1;
        }
        u.b(5, cmVar);
        if (obj == null) {
            ab.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", Integer.valueOf(cmVar.nao));
        }
        AppMethodBeat.o(1026);
        return bVar;
    }

    private static boolean QE(String str) {
        AppMethodBeat.i(1027);
        if (!com.tencent.mm.model.t.nd(str) || com.tencent.mm.au.b.ahP()) {
            AppMethodBeat.o(1027);
            return false;
        }
        AppMethodBeat.o(1027);
        return true;
    }
}
