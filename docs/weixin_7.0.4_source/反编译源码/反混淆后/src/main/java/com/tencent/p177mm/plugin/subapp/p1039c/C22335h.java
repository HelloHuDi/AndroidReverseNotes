package com.tencent.p177mm.plugin.subapp.p1039c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.subapp.c.h */
public final class C22335h {
    /* renamed from: by */
    public static String m34031by(String str, boolean z) {
        AppMethodBeat.m2504i(25285);
        C9638aw.m17190ZK();
        String b = C15428j.m23709b(C18628c.m29091XZ(), "recbiz_", str, ".rec", 2);
        if (C5046bo.isNullOrNil(b)) {
            AppMethodBeat.m2505o(25285);
            return null;
        } else if (z) {
            AppMethodBeat.m2505o(25285);
            return b;
        } else if (new File(b).exists()) {
            AppMethodBeat.m2505o(25285);
            return b;
        } else {
            AppMethodBeat.m2505o(25285);
            return b;
        }
    }

    /* renamed from: uS */
    public static boolean m34033uS(String str) {
        AppMethodBeat.m2504i(25286);
        if (str == null) {
            AppMethodBeat.m2505o(25286);
            return false;
        }
        C29385g abp = C41315d.cDE().abp(str);
        if (abp == null) {
            C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(25286);
            return true;
        }
        C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "cancel record : " + str + " LocalId:" + abp.field_msglocalid);
        if (abp.field_msglocalid != 0) {
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15341jg((long) abp.field_msglocalid);
        }
        boolean abl = C22335h.abl(str);
        AppMethodBeat.m2505o(25286);
        return abl;
    }

    private static boolean abl(String str) {
        AppMethodBeat.m2504i(25287);
        if (str == null) {
            AppMethodBeat.m2505o(25287);
            return false;
        }
        C41315d.cDE().mo69308pI(str);
        C22335h.m34032uO(str);
        boolean delete = new File(C22335h.m34031by(str, false)).delete();
        AppMethodBeat.m2505o(25287);
        return delete;
    }

    /* renamed from: uO */
    static void m34032uO(String str) {
        AppMethodBeat.m2504i(25288);
        C41315d.cDE().mo69309uO(C22335h.m34031by(str, false));
        AppMethodBeat.m2505o(25288);
    }

    /* renamed from: um */
    public static boolean m34034um(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(25289);
        if (str == null) {
            AppMethodBeat.m2505o(25289);
        } else {
            C29385g abp = C41315d.cDE().abp(str);
            if (abp == null) {
                C4990ab.m7412e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(25289);
            } else {
                abp.field_status = 98;
                abp.field_lastmodifytime = System.currentTimeMillis() / 1000;
                abp.bJt = 320;
                z = C22335h.m34030a(abp);
                C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "setError file:" + str + " msgid:" + abp.field_msglocalid + " old stat:" + abp.field_status);
                if (abp.field_msglocalid == 0 || C5046bo.isNullOrNil(abp.field_user)) {
                    C4990ab.m7412e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + abp.field_msglocalid + " user:" + abp.field_user);
                    AppMethodBeat.m2505o(25289);
                } else {
                    C9638aw.m17190ZK();
                    C7620bi jf = C18628c.m29080XO().mo15340jf((long) abp.field_msglocalid);
                    jf.setMsgId((long) abp.field_msglocalid);
                    jf.setStatus(5);
                    jf.mo14794ju(abp.field_user);
                    jf.setContent(C39938f.m68400d(abp.field_human, -1, true));
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                    AppMethodBeat.m2505o(25289);
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    static boolean m34030a(C29385g c29385g) {
        AppMethodBeat.m2504i(25290);
        if (c29385g == null) {
            AppMethodBeat.m2505o(25290);
            return false;
        } else if (c29385g.bJt == -1) {
            AppMethodBeat.m2505o(25290);
            return false;
        } else {
            boolean a = C41315d.cDE().mo69305a(c29385g.field_filename, c29385g);
            AppMethodBeat.m2505o(25290);
            return a;
        }
    }

    public static C35265c abm(String str) {
        AppMethodBeat.m2504i(25291);
        C35265c abo = C41315d.cDE().abo(C22335h.m34031by(str, false));
        AppMethodBeat.m2505o(25291);
        return abo;
    }
}
