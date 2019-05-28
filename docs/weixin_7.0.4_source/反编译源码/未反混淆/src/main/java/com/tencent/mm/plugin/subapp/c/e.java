package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class e {
    private static final f<Integer, e> emX = new c(100);
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
        AppMethodBeat.i(25282);
        AppMethodBeat.o(25282);
    }

    public static e abk(String str) {
        AppMethodBeat.i(25281);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(25281);
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = str.hashCode();
        e eVar = (e) emX.get(Integer.valueOf(hashCode));
        if (eVar != null) {
            AppMethodBeat.o(25281);
            return eVar;
        }
        Map z = br.z(str, "msg");
        if (z == null) {
            ab.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
            AppMethodBeat.o(25281);
            return null;
        }
        try {
            e eVar2 = new e();
            eVar2.fgo = bo.getInt((String) z.get(".msg.appmsg.appattach.totallen"), 0);
            eVar2.csD = (String) z.get(".msg.appmsg.appattach.attachid");
            eVar2.fgp = (String) z.get(".msg.appmsg.appattach.fileext");
            eVar2.ssY = bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
            eVar2.ssZ = bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
            eVar2.sta = (String) z.get(".msg.appmsg.voicecmd.reminder.$remindattachid");
            eVar2.stb = bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
            eVar2.stc = bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
            eVar2.std = bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
            eVar2.ste = bo.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
            emX.k(Integer.valueOf(hashCode), eVar2);
            AppMethodBeat.o(25281);
            return eVar2;
        } catch (Exception e) {
            ab.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
            ab.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", e, "", new Object[0]);
            AppMethodBeat.o(25281);
            return null;
        }
    }
}
