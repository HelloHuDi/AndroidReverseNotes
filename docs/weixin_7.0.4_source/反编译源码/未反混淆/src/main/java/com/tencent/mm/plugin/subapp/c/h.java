package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.bi;
import java.io.File;

public final class h {
    public static String by(String str, boolean z) {
        AppMethodBeat.i(25285);
        aw.ZK();
        String b = j.b(c.XZ(), "recbiz_", str, ".rec", 2);
        if (bo.isNullOrNil(b)) {
            AppMethodBeat.o(25285);
            return null;
        } else if (z) {
            AppMethodBeat.o(25285);
            return b;
        } else if (new File(b).exists()) {
            AppMethodBeat.o(25285);
            return b;
        } else {
            AppMethodBeat.o(25285);
            return b;
        }
    }

    public static boolean uS(String str) {
        AppMethodBeat.i(25286);
        if (str == null) {
            AppMethodBeat.o(25286);
            return false;
        }
        g abp = d.cDE().abp(str);
        if (abp == null) {
            ab.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(str)));
            AppMethodBeat.o(25286);
            return true;
        }
        ab.d("MicroMsg.VoiceRemindLogic", "cancel record : " + str + " LocalId:" + abp.field_msglocalid);
        if (abp.field_msglocalid != 0) {
            aw.ZK();
            c.XO().jg((long) abp.field_msglocalid);
        }
        boolean abl = abl(str);
        AppMethodBeat.o(25286);
        return abl;
    }

    private static boolean abl(String str) {
        AppMethodBeat.i(25287);
        if (str == null) {
            AppMethodBeat.o(25287);
            return false;
        }
        d.cDE().pI(str);
        uO(str);
        boolean delete = new File(by(str, false)).delete();
        AppMethodBeat.o(25287);
        return delete;
    }

    static void uO(String str) {
        AppMethodBeat.i(25288);
        d.cDE().uO(by(str, false));
        AppMethodBeat.o(25288);
    }

    public static boolean um(String str) {
        boolean z = false;
        AppMethodBeat.i(25289);
        if (str == null) {
            AppMethodBeat.o(25289);
        } else {
            g abp = d.cDE().abp(str);
            if (abp == null) {
                ab.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(str)));
                AppMethodBeat.o(25289);
            } else {
                abp.field_status = 98;
                abp.field_lastmodifytime = System.currentTimeMillis() / 1000;
                abp.bJt = 320;
                z = a(abp);
                ab.d("MicroMsg.VoiceRemindLogic", "setError file:" + str + " msgid:" + abp.field_msglocalid + " old stat:" + abp.field_status);
                if (abp.field_msglocalid == 0 || bo.isNullOrNil(abp.field_user)) {
                    ab.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + abp.field_msglocalid + " user:" + abp.field_user);
                    AppMethodBeat.o(25289);
                } else {
                    aw.ZK();
                    bi jf = c.XO().jf((long) abp.field_msglocalid);
                    jf.setMsgId((long) abp.field_msglocalid);
                    jf.setStatus(5);
                    jf.ju(abp.field_user);
                    jf.setContent(f.d(abp.field_human, -1, true));
                    aw.ZK();
                    c.XO().a(jf.field_msgId, jf);
                    AppMethodBeat.o(25289);
                }
            }
        }
        return z;
    }

    static boolean a(g gVar) {
        AppMethodBeat.i(25290);
        if (gVar == null) {
            AppMethodBeat.o(25290);
            return false;
        } else if (gVar.bJt == -1) {
            AppMethodBeat.o(25290);
            return false;
        } else {
            boolean a = d.cDE().a(gVar.field_filename, gVar);
            AppMethodBeat.o(25290);
            return a;
        }
    }

    public static c abm(String str) {
        AppMethodBeat.i(25291);
        c abo = d.cDE().abo(by(str, false));
        AppMethodBeat.o(25291);
        return abo;
    }
}
