package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.util.Map;
import junit.framework.Assert;

public final class f implements e {

    public static final class a {
        String content;
        String eoz;

        /* synthetic */ a(byte b) {
            this();
        }

        private a() {
            this.eoz = "";
            this.content = "";
        }
    }

    public final b b(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(24085);
        cm cmVar = aVar.eAB;
        if (cmVar == null) {
            ab.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(24085);
            return null;
        } else if (cmVar.nao == 36 || cmVar.nao == 39) {
            bi biVar;
            int i;
            b bVar;
            String a = aa.a(cmVar.vED);
            String a2 = aa.a(cmVar.vEB);
            String a3 = aa.a(cmVar.vEC);
            ab.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(a)));
            aw.ZK();
            String str = (String) c.Ry().get(2, null);
            String str2 = str.equals(a2) ? a3 : a2;
            aw.ZK();
            bi Q = c.XO().Q(str2, cmVar.ptF);
            ab.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId));
            if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < bf.q(a2, (long) cmVar.pcX)) {
                ab.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId));
                bf.fm(Q.field_msgId);
                Q.setMsgId(0);
            }
            if (Q.field_msgId == 0) {
                Q = new bi();
                Q.eI(cmVar.ptF);
                Q.eJ(bf.q(a2, (long) cmVar.pcX));
                biVar = Q;
            } else {
                biVar = Q;
            }
            biVar.setType(cmVar.nao);
            biVar.ju(str2);
            d Vb = g.cca().Vb(str2);
            if (Vb == null || bo.nullAsNil(Vb.getUsername()).length() <= 0) {
                Vb = new d();
                Vb.username = str2;
                Vb.psK = 1;
                Vb.bJt = 9;
                if (!g.cca().a(Vb)) {
                    ab.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + Vb.getUsername());
                }
            }
            long j = -1;
            if (cmVar.vEE == 2 && biVar.field_msgId == 0) {
                byte[] a4 = aa.a(cmVar.vEF);
                PString pString = new PString();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                j = o.ahl().a(a4, cmVar.ptF, false, "", pString, pInt, pInt2);
                if (j > 0) {
                    biVar.jv(pString.value);
                    biVar.hZ(pInt.value);
                    biVar.ia(pInt2.value);
                }
            }
            long j2 = j;
            if (cmVar.nao == 36) {
                boolean z;
                ad adVar;
                Assert.assertTrue(true);
                if (bo.nullAsNil(a).length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                Assert.assertTrue(bo.nullAsNil(biVar.field_talker).length() > 0);
                Object obj = null;
                aw.ZK();
                ad aoO = c.XM().aoO(biVar.field_talker);
                if (aoO == null || bo.nullAsNil(aoO.field_username).length() <= 0) {
                    obj = 1;
                    adVar = new ad(biVar.field_talker);
                } else {
                    adVar = aoO;
                }
                a aVar2 = new a();
                Map z2 = br.z(a, "msg");
                if (z2 != null) {
                    aVar2.eoz = (String) z2.get(".msg.from.displayname");
                    aVar2.content = (String) z2.get(".msg.content.t");
                }
                if (aVar2.eoz == null) {
                    str2 = "";
                } else {
                    str2 = aVar2.eoz;
                }
                adVar.iz(str2);
                if (aVar2.content == null) {
                    str2 = "";
                } else {
                    str2 = aVar2.content;
                }
                biVar.setContent(str2);
                if (obj != null) {
                    aw.ZK();
                    c.XM().Z(adVar);
                } else {
                    aw.ZK();
                    c.XM().b(adVar.field_username, adVar);
                }
            }
            aw.ZK();
            Object obj2 = (c.XU().has(a2) || str.equals(a2)) ? 1 : null;
            if (obj2 != null) {
                biVar.hO(1);
                i = cmVar.jBT;
                Q = biVar;
            } else {
                biVar.hO(0);
                if (cmVar.jBT > 3) {
                    i = cmVar.jBT;
                    Q = biVar;
                } else {
                    i = 3;
                    Q = biVar;
                }
            }
            Q.setStatus(i);
            biVar.ix(cmVar.vEG);
            bf.a(biVar, aVar);
            if (biVar.field_msgId == 0) {
                biVar.setMsgId(bf.l(biVar));
                if (cmVar.vEE == 2) {
                    com.tencent.mm.at.e b = o.ahl().b(Long.valueOf(j2));
                    b.fG((long) ((int) biVar.field_msgId));
                    o.ahl().a(Long.valueOf(j2), b);
                }
                bVar = new b(biVar, true);
            } else {
                aw.ZK();
                c.XO().b(cmVar.ptF, biVar);
                bVar = new b(biVar, false);
            }
            AppMethodBeat.o(24085);
            return bVar;
        } else {
            ab.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", Integer.valueOf(cmVar.nao));
            AppMethodBeat.o(24085);
            return null;
        }
    }

    public final void a(e.c cVar) {
        AppMethodBeat.i(24086);
        o.ahl().x(cVar.cKd);
        AppMethodBeat.o(24086);
    }
}
