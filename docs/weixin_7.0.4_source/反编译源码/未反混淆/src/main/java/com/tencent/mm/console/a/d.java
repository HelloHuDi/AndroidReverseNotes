package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

public final class d implements a {
    static {
        AppMethodBeat.i(16131);
        b.a(new d(), "//hotpatch");
        AppMethodBeat.o(16131);
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16130);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(16130);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(16130);
            return true;
        } else {
            String str2 = strArr[1];
            int i = -1;
            switch (str2.hashCode()) {
                case 3237038:
                    if (str2.equals("info")) {
                        i = 1;
                        break;
                    }
                    break;
                case 93029230:
                    if (str2.equals("apply")) {
                        i = 0;
                        break;
                    }
                    break;
                case 94627080:
                    if (str2.equals("check")) {
                        i = 3;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        i = 2;
                        break;
                    }
                    break;
            }
            String str3;
            switch (i) {
                case 0:
                    if (strArr.length < 3) {
                        str3 = "/data/local/tmp/test.apk";
                    } else {
                        str3 = strArr[2];
                    }
                    ab.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", str3);
                    if (!com.tencent.tinker.lib.e.a.iX(context).ABK) {
                        com.tencent.tinker.lib.e.a.iX(context).bGr();
                    }
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(System.currentTimeMillis() - 300000));
                    ip ipVar = new ip();
                    ipVar.cDI.cDN = str3;
                    com.tencent.mm.sdk.b.a.xxA.m(ipVar);
                    AppMethodBeat.o(16130);
                    return true;
                case 1:
                    ab.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", getClass().getClassLoader());
                    AppMethodBeat.o(16130);
                    return true;
                case 2:
                    ab.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
                    ip ipVar2 = new ip();
                    ipVar2.cDI.cuy = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(ipVar2);
                    AppMethodBeat.o(16130);
                    return true;
                case 3:
                    if (strArr.length < 3) {
                        AppMethodBeat.o(16130);
                        return true;
                    }
                    str3 = strArr[2];
                    if (!str3.startsWith("/")) {
                        str3 = "/data/data/com.tencent.mm/app_dex/".concat(String.valueOf(str3));
                    }
                    ab.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", str3);
                    ab.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    ab.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    ab.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", Boolean.valueOf(SharePatchFileUtil.aus(str3)));
                    ab.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    AppMethodBeat.o(16130);
                    return true;
                default:
                    AppMethodBeat.o(16130);
                    return true;
            }
        }
    }
}
