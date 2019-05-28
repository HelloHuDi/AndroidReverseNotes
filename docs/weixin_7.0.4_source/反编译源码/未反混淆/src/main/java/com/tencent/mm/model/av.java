package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

public final class av extends c {
    public static av fly = new av(c.eSp);
    public static final String flz = (e.eSj + "last_avatar_dir");

    static {
        AppMethodBeat.i(58094);
        AppMethodBeat.o(58094);
    }

    private av(c cVar) {
        super(cVar.Un());
        AppMethodBeat.i(58089);
        AppMethodBeat.o(58089);
    }

    public final void ak(String str, String str2) {
        AppMethodBeat.i(58090);
        ab.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", str, str2);
        this.ehZ.edit().putString(str, str2).commit();
        if (str.equals("login_weixin_username")) {
            ah.getContext().getSharedPreferences("notify_key_pref_no_account", h.Mu()).edit().putString("login_weixin_username", str2).commit();
        }
        AppMethodBeat.o(58090);
    }

    public final void c(String str, int i, String str2) {
        AppMethodBeat.i(58091);
        int i2 = 0;
        if (i != 0) {
            i2 = 1;
            ak("last_login_bind_qq", String.valueOf(i));
        }
        if (!bo.isNullOrNil(str2)) {
            i2 |= 2;
            ak("last_login_bind_email", String.valueOf(str2));
        }
        if (!bo.isNullOrNil(str)) {
            i2 |= 4;
            ak("last_login_bind_mobile", str);
        }
        ak("last_bind_info", String.valueOf(i2));
        AppMethodBeat.o(58091);
    }

    public final String ZC() {
        AppMethodBeat.i(58092);
        String T = T("last_avatar_path", "");
        AppMethodBeat.o(58092);
        return T;
    }

    public final void ou(String str) {
        AppMethodBeat.i(58093);
        ab.i("MicroMsg.LastLoginInfo", "Save last avatar: ".concat(String.valueOf(str)));
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(58093);
            return;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        if (bo.isNullOrNil(substring)) {
            AppMethodBeat.o(58093);
            return;
        }
        Object obj = flz + "/" + substring;
        com.tencent.mm.vfs.e.tf(flz);
        boolean deleteFile = com.tencent.mm.vfs.e.deleteFile(obj);
        ab.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", obj, Boolean.valueOf(deleteFile));
        com.tencent.mm.vfs.e.y(str, obj);
        ak("last_avatar_path", obj);
        if (g.RK()) {
            g.RP().Ry().set(a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, obj);
        }
        AppMethodBeat.o(58093);
    }
}
