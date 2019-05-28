package com.tencent.p177mm.p612ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.p230g.p231a.C18359oy;
import com.tencent.p177mm.p230g.p231a.C18407ua;
import com.tencent.p177mm.p230g.p231a.C42039qa;
import com.tencent.p177mm.p230g.p231a.C45355oz;
import com.tencent.p177mm.p230g.p231a.C6541qc;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30061al.C30062a;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.ak */
public final class C36121ak {
    /* renamed from: aQ */
    public static void m59475aQ(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30976);
        C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", Long.valueOf(c7620bi.field_msgId));
        if (C1855t.m3953nv(c7620bi.field_talker)) {
            C45355oz c45355oz = new C45355oz();
            c45355oz.cLo.csG = c7620bi;
            C4879a.xxA.mo10055m(c45355oz);
            AppMethodBeat.m2505o(30976);
            return;
        }
        C18359oy c18359oy = new C18359oy();
        c18359oy.cLn.csG = c7620bi;
        C4879a.xxA.mo10055m(c18359oy);
        AppMethodBeat.m2505o(30976);
    }

    /* renamed from: aR */
    public static void m59476aR(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30977);
        C42039qa c42039qa = new C42039qa();
        long oC = C1829bf.m3756oC(c7620bi.field_talker);
        C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_createTime), Long.valueOf(oC));
        if (oC == c7620bi.field_createTime) {
            oC++;
        }
        c7620bi.mo14775eJ(oC);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
        c42039qa.cMp.csG = c7620bi;
        C4879a.xxA.mo10055m(c42039qa);
        AppMethodBeat.m2505o(30977);
    }

    /* renamed from: aS */
    public static void m59477aS(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30978);
        C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", Long.valueOf(c7620bi.field_msgId));
        C18407ua c18407ua = new C18407ua();
        c18407ua.cQj.csG = c7620bi;
        C4879a.xxA.mo10055m(c18407ua);
        AppMethodBeat.m2505o(30978);
    }

    /* renamed from: aT */
    public static void m59478aT(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30979);
        C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", Long.valueOf(c7620bi.field_msgId));
        long oC = C1829bf.m3756oC(c7620bi.field_talker);
        if (oC == c7620bi.field_createTime) {
            oC++;
        }
        c7620bi.mo14775eJ(oC);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
        C30065b lZ = C14877am.aUq().mo48329lZ(c7620bi.field_msgId);
        if (lZ == null || lZ.field_msgInfoId != c7620bi.field_msgId) {
            C4990ab.m7410d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
            C14877am.dhP();
            C30062a.m47603jB(c7620bi.field_msgId);
            AppMethodBeat.m2505o(30979);
            return;
        }
        C4990ab.m7410d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
        lZ.field_status = 101;
        lZ.field_offset = 0;
        lZ.field_lastModifyTime = System.currentTimeMillis() / 1000;
        C14877am.aUq().mo48326a(lZ, new String[0]);
        C14877am.dhP().run();
        AppMethodBeat.m2505o(30979);
    }

    /* renamed from: aU */
    public static void m59479aU(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30980);
        C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", Long.valueOf(c7620bi.field_msgId));
        C36121ak.m59482aX(c7620bi);
        AppMethodBeat.m2505o(30980);
    }

    /* renamed from: aV */
    public static void m59480aV(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30981);
        C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", Long.valueOf(c7620bi.field_msgId));
        C36121ak.m59482aX(c7620bi);
        AppMethodBeat.m2505o(30981);
    }

    /* renamed from: aW */
    public static void m59481aW(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30982);
        C4990ab.m7417i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", Long.valueOf(c7620bi.field_msgId));
        C36121ak.m59482aX(c7620bi);
        AppMethodBeat.m2505o(30982);
    }

    /* renamed from: aX */
    private static void m59482aX(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30983);
        long j = c7620bi.field_msgId;
        if (j == -1) {
            C4990ab.m7412e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(30983);
        } else if (c7620bi.field_talker.equals("medianote") && (C1853r.m3822YD() & 16384) == 0) {
            AppMethodBeat.m2505o(30983);
        } else {
            C4990ab.m7411d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", Long.valueOf(j));
            if (C9638aw.m17182Rg().mo14541a(new C26451h(j), 0)) {
                j = C1829bf.m3756oC(c7620bi.field_talker);
                if (j == c7620bi.field_createTime) {
                    j++;
                }
                c7620bi.mo14775eJ(j);
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                AppMethodBeat.m2505o(30983);
                return;
            }
            C4990ab.m7412e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
            c7620bi.setStatus(5);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            C6541qc c6541qc = new C6541qc();
            c6541qc.cMs.csG = c7620bi;
            C4879a.xxA.mo10055m(c6541qc);
            AppMethodBeat.m2505o(30983);
        }
    }
}
