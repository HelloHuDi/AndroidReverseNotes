package com.tencent.mm.modelvoice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class r implements e {
    private static Set<c> gan = new HashSet();

    static {
        AppMethodBeat.i(116657);
        AppMethodBeat.o(116657);
    }

    public static void c(c cVar) {
        AppMethodBeat.i(116653);
        if (!gan.contains(cVar)) {
            gan.add(cVar);
        }
        AppMethodBeat.o(116653);
    }

    public static void b(c cVar) {
        AppMethodBeat.i(116654);
        gan.remove(cVar);
        AppMethodBeat.o(116654);
    }

    public final b b(a aVar) {
        AppMethodBeat.i(116655);
        cm cmVar = aVar.eAB;
        if (cmVar == null) {
            ab.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            AppMethodBeat.o(116655);
            return null;
        }
        String a;
        p fZ;
        ab.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + cmVar.ptF);
        String a2 = aa.a(cmVar.vEB);
        if (a2.equals(com.tencent.mm.model.r.Yz())) {
            a = aa.a(cmVar.vEC);
        } else {
            a = a2;
        }
        bi Q = ((j) g.K(j.class)).bOr().Q(a, cmVar.ptF);
        if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < bf.q(a, (long) cmVar.pcX)) {
            ab.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", Long.valueOf(cmVar.ptF));
            bf.r(a, cmVar.ptF);
            fZ = m.ama().fZ(cmVar.ptF);
            if (!(fZ == null || bo.isNullOrNil(fZ.fileName))) {
                q.uT(fZ.fileName);
            }
        }
        fZ = new p();
        fZ.cIS = a;
        fZ.createTime = (long) cmVar.pcX;
        fZ.cKK = cmVar.ptF;
        fZ.dqJ = cmVar.vEG;
        ab.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", cmVar.vEG);
        String a3 = aa.a(cmVar.vED);
        if (t.kH(a2)) {
            a2 = bf.oz(a3);
            ab.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(a2)));
        } else {
            a2 = a3;
        }
        Map z = br.z(a2, "msg");
        if (z == null) {
            h.pYm.a(111, 227, 1, false);
            AppMethodBeat.o(116655);
            return null;
        }
        try {
            fZ.fVG = Integer.valueOf((String) z.get(".msg.voicemsg.$length")).intValue();
            fZ.clientId = (String) z.get(".msg.voicemsg.$clientmsgid");
            int intValue = Integer.valueOf((String) z.get(".msg.voicemsg.$endflag")).intValue();
            int intValue2 = Integer.valueOf((String) z.get(".msg.voicemsg.$cancelflag")).intValue();
            fZ.gaf = Integer.valueOf((String) z.get(".msg.voicemsg.$voicelength")).intValue();
            fZ.fWW = (String) z.get(".msg.voicemsg.$fromusername");
            String str = (String) z.get(".msg.commenturl");
            fZ.fZe = Integer.valueOf(bo.bc((String) z.get(".msg.voicemsg.$forwardflag"), AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
            fZ.fYX = (String) z.get(".msg.voicemsg.$voiceformat");
            fZ.gah = bo.getLong((String) z.get(".msg.voicemsg.$bufid"), 0);
            if (intValue2 == 1) {
                ab.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + cmVar.ptF);
                fZ = m.ama().fZ(fZ.cKK);
                if (fZ != null) {
                    q.uR(fZ.fileName);
                }
                AppMethodBeat.o(116655);
                return null;
            }
            cy Q2;
            if (intValue == 1) {
                ab.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + cmVar.ptF);
                fZ.frO = fZ.fVG;
            }
            fZ.bJt = 284334;
            byte[] a4 = aa.a(cmVar.vEF);
            if (a4 != null) {
                ab.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + a4.length + " srvId:" + cmVar.ptF);
            }
            if (q.a(fZ, a4, cmVar.jBT, str, cmVar.vEG, aVar) > 0) {
                ab.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", Integer.valueOf(q.a(fZ, a4, cmVar.jBT, str, cmVar.vEG, aVar)), Long.valueOf(cmVar.ptF), Integer.valueOf(cmVar.vEI));
                h.pYm.a(111, 228, 1, false);
                Q2 = ((j) g.K(j.class)).bOr().Q(fZ.cIS, fZ.cKK);
                Q2.Mr(0);
                for (final c cVar : gan) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(116652);
                            cVar.J(((j) g.K(j.class)).bOr().Q(fZ.cIS, fZ.cKK));
                            AppMethodBeat.o(116652);
                        }
                    });
                }
            } else {
                ab.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", Integer.valueOf(q.a(fZ, a4, cmVar.jBT, str, cmVar.vEG, aVar)), Long.valueOf(cmVar.ptF), Integer.valueOf(cmVar.vEI), bo.dpG());
                Q2 = null;
            }
            if (Q2 != null) {
                ak aoZ = ((j) g.K(j.class)).XR().aoZ(a);
                if (aoZ != null) {
                    aoZ.jk(16777216);
                    ((j) g.K(j.class)).XR().a(aoZ, a);
                }
            }
            boolean z2 = Q2 != null && Q2.field_msgId > 0;
            b bVar = new b(Q2, z2);
            AppMethodBeat.o(116655);
            return bVar;
        } catch (Exception e) {
            h.pYm.a(111, 227, 1, false);
            ab.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
            ab.e("MicroMsg.VoiceMsgExtension", "exception:%s", bo.l(e));
            AppMethodBeat.o(116655);
            return null;
        }
    }

    public final void a(c cVar) {
        AppMethodBeat.i(116656);
        bi biVar = cVar.cKd;
        ab.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + biVar.field_imgPath + " " + biVar.field_talker);
        if (!t.nv(biVar.field_talker)) {
            q.uT(biVar.field_imgPath);
        }
        AppMethodBeat.o(116656);
    }
}
