package com.tencent.p177mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.C14058r.C140624;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.voip.model.o */
public final class C40033o implements C1201e {

    /* renamed from: com.tencent.mm.plugin.voip.model.o$a */
    public static final class C22460a {
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
            AppMethodBeat.m2504i(4455);
            this.sQU = sRa;
            try {
                Map z = C5049br.m7595z(str, "voipinvitemsg");
                if (z != null) {
                    if (z.get(".voipinvitemsg.roomid") != null) {
                        this.sQS = C5046bo.getInt((String) z.get(".voipinvitemsg.roomid"), 0);
                    }
                    if (z.get(".voipinvitemsg.key") != null) {
                        this.sQT = C5046bo.getLong((String) z.get(".voipinvitemsg.key"), 0);
                    }
                    if (z.get(".voipinvitemsg.status") != null) {
                        this.status = C5046bo.getInt((String) z.get(".voipinvitemsg.status"), 0);
                    }
                    if (z.get(".voipinvitemsg.invitetype") != null) {
                        this.sQU = C5046bo.getInt((String) z.get(".voipinvitemsg.invitetype"), 0);
                    }
                    AppMethodBeat.m2505o(4455);
                    return true;
                }
                AppMethodBeat.m2505o(4455);
                return false;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.VoipExtension", "parse voip message error: %s", e.getMessage());
                AppMethodBeat.m2505o(4455);
                return false;
            }
        }
    }

    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(4456);
        C7254cm c7254cm = c1197a.eAB;
        String a = C1946aa.m4148a(c7254cm.vEB);
        String a2 = C1946aa.m4148a(c7254cm.vEC);
        String a3 = C1946aa.m4148a(c7254cm.vED);
        C4990ab.m7411d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", a, a3);
        C6977h bOr = ((C6982j) C1720g.m3528K(C6982j.class)).bOr();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        if (str.length() <= 0) {
            AppMethodBeat.m2505o(4456);
            return null;
        }
        C7620bi c7620bi;
        if (str.equals(a)) {
            str = a2;
        } else {
            str = a;
        }
        C7620bi Q = bOr.mo15241Q(str, c7254cm.ptF);
        if (Q.field_msgId == 0) {
            Q = new C7620bi();
            Q.mo14774eI(c7254cm.ptF);
            Q.mo14775eJ(C1829bf.m3764q(a, (long) c7254cm.pcX));
            c7620bi = Q;
        } else {
            c7620bi = Q;
        }
        C43727b.cIj();
        C22460a abW = C14058r.abW(a3);
        if (abW == null) {
            C4990ab.m7412e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
            try {
                Map z = C5049br.m7595z(a3, "voipwarnmsg");
                if (!(z == null || z.get(".voipwarnmsg.type") == null || C5046bo.getInt((String) z.get(".voipwarnmsg.type"), 0) != 1)) {
                    str = (String) z.get(".voipwarnmsg.warntips");
                    if (!(str == null || str.equals(""))) {
                        C4990ab.m7416i("MicroMsg.VoipExtension", "got risk tips back:".concat(String.valueOf(str)));
                        if (z.get(".voipwarnmsg.roomid") != null) {
                            if (!C37885a.m63952ME()) {
                                C4990ab.m7416i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                            } else if (C5046bo.getInt((String) z.get(".voipwarnmsg.roomid"), 0) != C43727b.cIj().sSP.sNl.sPp.nwu) {
                                C4990ab.m7416i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                                AppMethodBeat.m2505o(4456);
                                return null;
                            }
                        }
                        C43727b.cIj().sRK = str;
                        C14058r cIj = C43727b.cIj();
                        for (int i = 0; i < 2; i++) {
                            C5004al.m7442n(new C140624(str), 1000);
                        }
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.VoipExtension", "parse voip message error: %s", e.getMessage());
            }
            AppMethodBeat.m2505o(4456);
            return null;
        }
        Object obj;
        if (abW.status == C22460a.sQW) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            C4990ab.m7416i("MicroMsg.VoipExtension", "recv voip cancel message");
            C14058r cIj2 = C43727b.cIj();
            if (!(a3 == null || a3.length() == 0)) {
                C22460a c22460a = new C22460a();
                if (c22460a.parse(a3) && c22460a.status == 2) {
                    cIj2.mo26339Gv(c22460a.sQS);
                    C4286s c4286s = cIj2.sSP;
                    C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + c22460a.sQS);
                    if (c4286s.sNl.sPu != null && c22460a.sQS == c4286s.sNl.sPu.wem) {
                        c4286s.cKn();
                        c4286s.sNl.shutdown();
                    }
                }
            }
        } else {
            if (abW.status == C22460a.sQY) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(4456);
                return null;
            }
            if (abW.status == C22460a.sQV) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                C4990ab.m7416i("MicroMsg.VoipExtension", "recv voip invite delay");
                C43727b.cIj().mo26346ad(abW.sQS, abW.sQT);
                AppMethodBeat.m2505o(4456);
                return null;
            } else if (abW.cJi()) {
                C4990ab.m7416i("MicroMsg.VoipExtension", "receive invite busy message");
                c7620bi.mo14774eI(0);
            } else {
                AppMethodBeat.m2505o(4456);
                return null;
            }
        }
        if (abW.sQS == C43727b.cIj().sSV) {
            C4990ab.m7416i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
            AppMethodBeat.m2505o(4456);
            return null;
        }
        C1198b c1198b;
        c7620bi.setType(c7254cm.nao);
        c7620bi.setContent(abW.cJh() ? C7620bi.xZc : C7620bi.xZb);
        c7620bi.mo14781hO(0);
        c7620bi.mo14794ju(a);
        c7620bi.setStatus(c7254cm.jBT > 3 ? c7254cm.jBT : 3);
        if (abW.cJi()) {
            c7620bi.mo14791ix(C4996ah.getContext().getString(C25738R.string.f3x));
        } else {
            c7620bi.mo14791ix(null);
        }
        C1829bf.m3743a(c7620bi, c1197a);
        C4990ab.m7411d("MicroMsg.VoipExtension", "voipMessage==null: %b", abW);
        if (c7620bi.field_msgId == 0) {
            C22460a c22460a2;
            if (abW == null) {
                C22460a c22460a3 = new C22460a();
                c22460a3.parse(a3);
                c22460a2 = c22460a3;
            } else {
                c22460a2 = abW;
            }
            C4990ab.m7411d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", Integer.valueOf(c22460a2.sQS));
            if (C43727b.cIj().sSU.get(Integer.valueOf(c22460a2.sQS)) == null) {
                c7620bi.setMsgId(C1829bf.m3752l(c7620bi));
                C43727b.cIj().sSU.put(Integer.valueOf(c22460a2.sQS), Long.valueOf(c7620bi.field_msgId));
            } else {
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(((Long) C43727b.cIj().sSU.get(Integer.valueOf(c22460a2.sQS))).longValue(), c7620bi);
            }
            c1198b = new C1198b(c7620bi, true);
        } else {
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c7254cm.ptF, c7620bi);
            c1198b = new C1198b(c7620bi, false);
        }
        AppMethodBeat.m2505o(4456);
        return c1198b;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
