package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

public final class ak {
    public static void aQ(bi biVar) {
        AppMethodBeat.i(30976);
        ab.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", Long.valueOf(biVar.field_msgId));
        if (t.nv(biVar.field_talker)) {
            oz ozVar = new oz();
            ozVar.cLo.csG = biVar;
            a.xxA.m(ozVar);
            AppMethodBeat.o(30976);
            return;
        }
        oy oyVar = new oy();
        oyVar.cLn.csG = biVar;
        a.xxA.m(oyVar);
        AppMethodBeat.o(30976);
    }

    public static void aR(bi biVar) {
        AppMethodBeat.i(30977);
        qa qaVar = new qa();
        long oC = bf.oC(biVar.field_talker);
        ab.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_createTime), Long.valueOf(oC));
        if (oC == biVar.field_createTime) {
            oC++;
        }
        biVar.eJ(oC);
        aw.ZK();
        c.XO().a(biVar.field_msgId, biVar);
        qaVar.cMp.csG = biVar;
        a.xxA.m(qaVar);
        AppMethodBeat.o(30977);
    }

    public static void aS(bi biVar) {
        AppMethodBeat.i(30978);
        ab.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", Long.valueOf(biVar.field_msgId));
        ua uaVar = new ua();
        uaVar.cQj.csG = biVar;
        a.xxA.m(uaVar);
        AppMethodBeat.o(30978);
    }

    public static void aT(bi biVar) {
        AppMethodBeat.i(30979);
        ab.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", Long.valueOf(biVar.field_msgId));
        long oC = bf.oC(biVar.field_talker);
        if (oC == biVar.field_createTime) {
            oC++;
        }
        biVar.eJ(oC);
        aw.ZK();
        c.XO().a(biVar.field_msgId, biVar);
        b lZ = am.aUq().lZ(biVar.field_msgId);
        if (lZ == null || lZ.field_msgInfoId != biVar.field_msgId) {
            ab.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
            am.dhP();
            al.a.jB(biVar.field_msgId);
            AppMethodBeat.o(30979);
            return;
        }
        ab.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
        lZ.field_status = 101;
        lZ.field_offset = 0;
        lZ.field_lastModifyTime = System.currentTimeMillis() / 1000;
        am.aUq().a(lZ, new String[0]);
        am.dhP().run();
        AppMethodBeat.o(30979);
    }

    public static void aU(bi biVar) {
        AppMethodBeat.i(30980);
        ab.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", Long.valueOf(biVar.field_msgId));
        aX(biVar);
        AppMethodBeat.o(30980);
    }

    public static void aV(bi biVar) {
        AppMethodBeat.i(30981);
        ab.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", Long.valueOf(biVar.field_msgId));
        aX(biVar);
        AppMethodBeat.o(30981);
    }

    public static void aW(bi biVar) {
        AppMethodBeat.i(30982);
        ab.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", Long.valueOf(biVar.field_msgId));
        aX(biVar);
        AppMethodBeat.o(30982);
    }

    private static void aX(bi biVar) {
        AppMethodBeat.i(30983);
        long j = biVar.field_msgId;
        if (j == -1) {
            ab.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(j)));
            AppMethodBeat.o(30983);
        } else if (biVar.field_talker.equals("medianote") && (r.YD() & 16384) == 0) {
            AppMethodBeat.o(30983);
        } else {
            ab.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", Long.valueOf(j));
            if (aw.Rg().a(new h(j), 0)) {
                j = bf.oC(biVar.field_talker);
                if (j == biVar.field_createTime) {
                    j++;
                }
                biVar.eJ(j);
                aw.ZK();
                c.XO().a(biVar.field_msgId, biVar);
                AppMethodBeat.o(30983);
                return;
            }
            ab.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
            biVar.setStatus(5);
            aw.ZK();
            c.XO().a(biVar.field_msgId, biVar);
            qc qcVar = new qc();
            qcVar.cMs.csG = biVar;
            a.xxA.m(qcVar);
            AppMethodBeat.o(30983);
        }
    }
}
