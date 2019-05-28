package com.tencent.p177mm.plugin.subapp.p1039c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.subapp.c.e */
public final class C46291e {
    private static final C1177f<Integer, C46291e> emX = new C7598c(100);
    public String csD;
    public int fgo;
    public String fgp;
    public int ssY;
    public int ssZ;
    public String sta;
    public int stb;
    public int stc;
    public int std;
    public int ste;

    static {
        AppMethodBeat.m2504i(25282);
        AppMethodBeat.m2505o(25282);
    }

    public static C46291e abk(String str) {
        AppMethodBeat.m2504i(25281);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(25281);
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = str.hashCode();
        C46291e c46291e = (C46291e) emX.get(Integer.valueOf(hashCode));
        if (c46291e != null) {
            AppMethodBeat.m2505o(25281);
            return c46291e;
        }
        Map z = C5049br.m7595z(str, "msg");
        if (z == null) {
            C4990ab.m7412e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
            AppMethodBeat.m2505o(25281);
            return null;
        }
        try {
            C46291e c46291e2 = new C46291e();
            c46291e2.fgo = C5046bo.getInt((String) z.get(".msg.appmsg.appattach.totallen"), 0);
            c46291e2.csD = (String) z.get(".msg.appmsg.appattach.attachid");
            c46291e2.fgp = (String) z.get(".msg.appmsg.appattach.fileext");
            c46291e2.ssY = C5046bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
            c46291e2.ssZ = C5046bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
            c46291e2.sta = (String) z.get(".msg.appmsg.voicecmd.reminder.$remindattachid");
            c46291e2.stb = C5046bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
            c46291e2.stc = C5046bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
            c46291e2.std = C5046bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
            c46291e2.ste = C5046bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
            emX.mo4412k(Integer.valueOf(hashCode), c46291e2);
            AppMethodBeat.m2505o(25281);
            return c46291e2;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
            C4990ab.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(25281);
            return null;
        }
    }
}
