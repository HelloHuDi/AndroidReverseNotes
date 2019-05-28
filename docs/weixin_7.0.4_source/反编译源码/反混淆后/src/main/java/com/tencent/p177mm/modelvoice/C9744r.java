package com.tencent.p177mm.modelvoice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.modelvoice.r */
public final class C9744r implements C1201e {
    private static Set<C18717c> gan = new HashSet();

    static {
        AppMethodBeat.m2504i(116657);
        AppMethodBeat.m2505o(116657);
    }

    /* renamed from: c */
    public static void m17383c(C18717c c18717c) {
        AppMethodBeat.m2504i(116653);
        if (!gan.contains(c18717c)) {
            gan.add(c18717c);
        }
        AppMethodBeat.m2505o(116653);
    }

    /* renamed from: b */
    public static void m17382b(C18717c c18717c) {
        AppMethodBeat.m2504i(116654);
        gan.remove(c18717c);
        AppMethodBeat.m2505o(116654);
    }

    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(116655);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null) {
            C4990ab.m7412e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            AppMethodBeat.m2505o(116655);
            return null;
        }
        String a;
        C32849p fZ;
        C4990ab.m7416i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + c7254cm.ptF);
        String a2 = C1946aa.m4148a(c7254cm.vEB);
        if (a2.equals(C1853r.m3846Yz())) {
            a = C1946aa.m4148a(c7254cm.vEC);
        } else {
            a = a2;
        }
        C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(a, c7254cm.ptF);
        if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < C1829bf.m3764q(a, (long) c7254cm.pcX)) {
            C4990ab.m7421w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", Long.valueOf(c7254cm.ptF));
            C1829bf.m3765r(a, c7254cm.ptF);
            fZ = C26500m.ama().mo33984fZ(c7254cm.ptF);
            if (!(fZ == null || C5046bo.isNullOrNil(fZ.fileName))) {
                C32850q.m53733uT(fZ.fileName);
            }
        }
        fZ = new C32849p();
        fZ.cIS = a;
        fZ.createTime = (long) c7254cm.pcX;
        fZ.cKK = c7254cm.ptF;
        fZ.dqJ = c7254cm.vEG;
        C4990ab.m7411d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", c7254cm.vEG);
        String a3 = C1946aa.m4148a(c7254cm.vED);
        if (C1855t.m3896kH(a2)) {
            a2 = C1829bf.m3763oz(a3);
            C4990ab.m7416i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(a2)));
        } else {
            a2 = a3;
        }
        Map z = C5049br.m7595z(a2, "msg");
        if (z == null) {
            C7060h.pYm.mo8378a(111, 227, 1, false);
            AppMethodBeat.m2505o(116655);
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
            fZ.fZe = Integer.valueOf(C5046bo.m7532bc((String) z.get(".msg.voicemsg.$forwardflag"), AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
            fZ.fYX = (String) z.get(".msg.voicemsg.$voiceformat");
            fZ.gah = C5046bo.getLong((String) z.get(".msg.voicemsg.$bufid"), 0);
            if (intValue2 == 1) {
                C4990ab.m7418v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + c7254cm.ptF);
                fZ = C26500m.ama().mo33984fZ(fZ.cKK);
                if (fZ != null) {
                    C32850q.m53731uR(fZ.fileName);
                }
                AppMethodBeat.m2505o(116655);
                return null;
            }
            C6575cy Q2;
            if (intValue == 1) {
                C4990ab.m7418v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + c7254cm.ptF);
                fZ.frO = fZ.fVG;
            }
            fZ.bJt = 284334;
            byte[] a4 = C1946aa.m4150a(c7254cm.vEF);
            if (a4 != null) {
                C4990ab.m7410d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + a4.length + " srvId:" + c7254cm.ptF);
            }
            if (C32850q.m53709a(fZ, a4, c7254cm.jBT, str, c7254cm.vEG, c1197a) > 0) {
                C4990ab.m7417i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", Integer.valueOf(C32850q.m53709a(fZ, a4, c7254cm.jBT, str, c7254cm.vEG, c1197a)), Long.valueOf(c7254cm.ptF), Integer.valueOf(c7254cm.vEI));
                C7060h.pYm.mo8378a(111, 228, 1, false);
                Q2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(fZ.cIS, fZ.cKK);
                Q2.mo17082Mr(0);
                for (final C18717c c18717c : gan) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(116652);
                            c18717c.mo33980J(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(fZ.cIS, fZ.cKK));
                            AppMethodBeat.m2505o(116652);
                        }
                    });
                }
            } else {
                C4990ab.m7417i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", Integer.valueOf(C32850q.m53709a(fZ, a4, c7254cm.jBT, str, c7254cm.vEG, c1197a)), Long.valueOf(c7254cm.ptF), Integer.valueOf(c7254cm.vEI), C5046bo.dpG());
                Q2 = null;
            }
            if (Q2 != null) {
                C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(a);
                if (aoZ != null) {
                    aoZ.mo16713jk(16777216);
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, a);
                }
            }
            boolean z2 = Q2 != null && Q2.field_msgId > 0;
            C1198b c1198b = new C1198b(Q2, z2);
            AppMethodBeat.m2505o(116655);
            return c1198b;
        } catch (Exception e) {
            C7060h.pYm.mo8378a(111, 227, 1, false);
            C4990ab.m7412e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
            C4990ab.m7413e("MicroMsg.VoiceMsgExtension", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(116655);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
        AppMethodBeat.m2504i(116656);
        C7620bi c7620bi = c1199c.cKd;
        C4990ab.m7410d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + c7620bi.field_imgPath + " " + c7620bi.field_talker);
        if (!C1855t.m3953nv(c7620bi.field_talker)) {
            C32850q.m53733uT(c7620bi.field_imgPath);
        }
        AppMethodBeat.m2505o(116656);
    }
}
