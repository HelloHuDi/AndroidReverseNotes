package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.voip.model.r.AnonymousClass4;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class o implements e {

    public static final class a {
        public static int sQV = 1;
        public static int sQW = 2;
        public static int sQX = 3;
        public static int sQY = 4;
        public static int sQZ = 5;
        public static int sRa = 0;
        public static int sRb = 1;
        public int sQS;
        public long sQT;
        public int sQU;
        public int status;

        public final boolean cJh() {
            return this.sQU == sRa;
        }

        public final boolean cJi() {
            return this.status == sQZ;
        }

        public final boolean parse(String str) {
            AppMethodBeat.i(4455);
            this.sQU = sRa;
            try {
                Map z = br.z(str, "voipinvitemsg");
                if (z != null) {
                    if (z.get(".voipinvitemsg.roomid") != null) {
                        this.sQS = bo.getInt((String) z.get(".voipinvitemsg.roomid"), 0);
                    }
                    if (z.get(".voipinvitemsg.key") != null) {
                        this.sQT = bo.getLong((String) z.get(".voipinvitemsg.key"), 0);
                    }
                    if (z.get(".voipinvitemsg.status") != null) {
                        this.status = bo.getInt((String) z.get(".voipinvitemsg.status"), 0);
                    }
                    if (z.get(".voipinvitemsg.invitetype") != null) {
                        this.sQU = bo.getInt((String) z.get(".voipinvitemsg.invitetype"), 0);
                    }
                    AppMethodBeat.o(4455);
                    return true;
                }
                AppMethodBeat.o(4455);
                return false;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
                ab.e("MicroMsg.VoipExtension", "parse voip message error: %s", e.getMessage());
                AppMethodBeat.o(4455);
                return false;
            }
        }
    }

    public final b b(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(4456);
        cm cmVar = aVar.eAB;
        String a = aa.a(cmVar.vEB);
        String a2 = aa.a(cmVar.vEC);
        String a3 = aa.a(cmVar.vED);
        ab.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", a, a3);
        h bOr = ((j) g.K(j.class)).bOr();
        String str = (String) g.RP().Ry().get(2, (Object) "");
        if (str.length() <= 0) {
            AppMethodBeat.o(4456);
            return null;
        }
        bi biVar;
        if (str.equals(a)) {
            str = a2;
        } else {
            str = a;
        }
        bi Q = bOr.Q(str, cmVar.ptF);
        if (Q.field_msgId == 0) {
            Q = new bi();
            Q.eI(cmVar.ptF);
            Q.eJ(bf.q(a, (long) cmVar.pcX));
            biVar = Q;
        } else {
            biVar = Q;
        }
        com.tencent.mm.plugin.voip.b.cIj();
        a abW = r.abW(a3);
        if (abW == null) {
            ab.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
            try {
                Map z = br.z(a3, "voipwarnmsg");
                if (!(z == null || z.get(".voipwarnmsg.type") == null || bo.getInt((String) z.get(".voipwarnmsg.type"), 0) != 1)) {
                    str = (String) z.get(".voipwarnmsg.warntips");
                    if (!(str == null || str.equals(""))) {
                        ab.i("MicroMsg.VoipExtension", "got risk tips back:".concat(String.valueOf(str)));
                        if (z.get(".voipwarnmsg.roomid") != null) {
                            if (!com.tencent.mm.m.a.ME()) {
                                ab.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                            } else if (bo.getInt((String) z.get(".voipwarnmsg.roomid"), 0) != com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu) {
                                ab.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                                AppMethodBeat.o(4456);
                                return null;
                            }
                        }
                        com.tencent.mm.plugin.voip.b.cIj().sRK = str;
                        r cIj = com.tencent.mm.plugin.voip.b.cIj();
                        for (int i = 0; i < 2; i++) {
                            al.n(new AnonymousClass4(str), 1000);
                        }
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
                ab.e("MicroMsg.VoipExtension", "parse voip message error: %s", e.getMessage());
            }
            AppMethodBeat.o(4456);
            return null;
        }
        Object obj;
        if (abW.status == a.sQW) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            ab.i("MicroMsg.VoipExtension", "recv voip cancel message");
            r cIj2 = com.tencent.mm.plugin.voip.b.cIj();
            if (!(a3 == null || a3.length() == 0)) {
                a aVar2 = new a();
                if (aVar2.parse(a3) && aVar2.status == 2) {
                    cIj2.Gv(aVar2.sQS);
                    s sVar = cIj2.sSP;
                    ab.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + aVar2.sQS);
                    if (sVar.sNl.sPu != null && aVar2.sQS == sVar.sNl.sPu.wem) {
                        sVar.cKn();
                        sVar.sNl.shutdown();
                    }
                }
            }
        } else {
            if (abW.status == a.sQY) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.o(4456);
                return null;
            }
            if (abW.status == a.sQV) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ab.i("MicroMsg.VoipExtension", "recv voip invite delay");
                com.tencent.mm.plugin.voip.b.cIj().ad(abW.sQS, abW.sQT);
                AppMethodBeat.o(4456);
                return null;
            } else if (abW.cJi()) {
                ab.i("MicroMsg.VoipExtension", "receive invite busy message");
                biVar.eI(0);
            } else {
                AppMethodBeat.o(4456);
                return null;
            }
        }
        if (abW.sQS == com.tencent.mm.plugin.voip.b.cIj().sSV) {
            ab.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
            AppMethodBeat.o(4456);
            return null;
        }
        b bVar;
        biVar.setType(cmVar.nao);
        biVar.setContent(abW.cJh() ? bi.xZc : bi.xZb);
        biVar.hO(0);
        biVar.ju(a);
        biVar.setStatus(cmVar.jBT > 3 ? cmVar.jBT : 3);
        if (abW.cJi()) {
            biVar.ix(ah.getContext().getString(R.string.f3x));
        } else {
            biVar.ix(null);
        }
        bf.a(biVar, aVar);
        ab.d("MicroMsg.VoipExtension", "voipMessage==null: %b", abW);
        if (biVar.field_msgId == 0) {
            a aVar3;
            if (abW == null) {
                a aVar4 = new a();
                aVar4.parse(a3);
                aVar3 = aVar4;
            } else {
                aVar3 = abW;
            }
            ab.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", Integer.valueOf(aVar3.sQS));
            if (com.tencent.mm.plugin.voip.b.cIj().sSU.get(Integer.valueOf(aVar3.sQS)) == null) {
                biVar.setMsgId(bf.l(biVar));
                com.tencent.mm.plugin.voip.b.cIj().sSU.put(Integer.valueOf(aVar3.sQS), Long.valueOf(biVar.field_msgId));
            } else {
                ((j) g.K(j.class)).bOr().a(((Long) com.tencent.mm.plugin.voip.b.cIj().sSU.get(Integer.valueOf(aVar3.sQS))).longValue(), biVar);
            }
            bVar = new b(biVar, true);
        } else {
            ((j) g.K(j.class)).bOr().b(cmVar.ptF, biVar);
            bVar = new b(biVar, false);
        }
        AppMethodBeat.o(4456);
        return bVar;
    }

    public final void a(c cVar) {
    }
}
