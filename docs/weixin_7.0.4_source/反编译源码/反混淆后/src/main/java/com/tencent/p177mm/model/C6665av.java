package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1762c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.model.av */
public final class C6665av extends C1762c {
    public static C6665av fly = new C6665av(C1762c.eSp);
    public static final String flz = (C6457e.eSj + "last_avatar_dir");

    static {
        AppMethodBeat.m2504i(58094);
        AppMethodBeat.m2505o(58094);
    }

    private C6665av(C1762c c1762c) {
        super(c1762c.mo5293Un());
        AppMethodBeat.m2504i(58089);
        AppMethodBeat.m2505o(58089);
    }

    /* renamed from: ak */
    public final void mo14897ak(String str, String str2) {
        AppMethodBeat.m2504i(58090);
        C4990ab.m7417i("MicroMsg.LastLoginInfo", "save key : %s value : %s", str, str2);
        this.ehZ.edit().putString(str, str2).commit();
        if (str.equals("login_weixin_username")) {
            C4996ah.getContext().getSharedPreferences("notify_key_pref_no_account", C1448h.m3078Mu()).edit().putString("login_weixin_username", str2).commit();
        }
        AppMethodBeat.m2505o(58090);
    }

    /* renamed from: c */
    public final void mo14898c(String str, int i, String str2) {
        AppMethodBeat.m2504i(58091);
        int i2 = 0;
        if (i != 0) {
            i2 = 1;
            mo14897ak("last_login_bind_qq", String.valueOf(i));
        }
        if (!C5046bo.isNullOrNil(str2)) {
            i2 |= 2;
            mo14897ak("last_login_bind_email", String.valueOf(str2));
        }
        if (!C5046bo.isNullOrNil(str)) {
            i2 |= 4;
            mo14897ak("last_login_bind_mobile", str);
        }
        mo14897ak("last_bind_info", String.valueOf(i2));
        AppMethodBeat.m2505o(58091);
    }

    /* renamed from: ZC */
    public final String mo14896ZC() {
        AppMethodBeat.m2504i(58092);
        String T = mo5292T("last_avatar_path", "");
        AppMethodBeat.m2505o(58092);
        return T;
    }

    /* renamed from: ou */
    public final void mo14899ou(String str) {
        AppMethodBeat.m2504i(58093);
        C4990ab.m7416i("MicroMsg.LastLoginInfo", "Save last avatar: ".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(58093);
            return;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        if (C5046bo.isNullOrNil(substring)) {
            AppMethodBeat.m2505o(58093);
            return;
        }
        Object obj = flz + "/" + substring;
        C5730e.m8643tf(flz);
        boolean deleteFile = C5730e.deleteFile(obj);
        C4990ab.m7417i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", obj, Boolean.valueOf(deleteFile));
        C5730e.m8644y(str, obj);
        mo14897ak("last_avatar_path", obj);
        if (C1720g.m3531RK()) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, obj);
        }
        AppMethodBeat.m2505o(58093);
    }
}
