package com.tencent.p177mm.console.p845a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C42010ip;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

/* renamed from: com.tencent.mm.console.a.d */
public final class C45298d implements C44041a {
    static {
        AppMethodBeat.m2504i(16131);
        C44042b.m79163a(new C45298d(), "//hotpatch");
        AppMethodBeat.m2505o(16131);
    }

    public static void init() {
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16130);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(16130);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(16130);
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
                    C4990ab.m7411d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", str3);
                    if (!C31097a.m50180iX(context).ABK) {
                        C31097a.m50180iX(context).bGr();
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(System.currentTimeMillis() - 300000));
                    C42010ip c42010ip = new C42010ip();
                    c42010ip.cDI.cDN = str3;
                    C4879a.xxA.mo10055m(c42010ip);
                    AppMethodBeat.m2505o(16130);
                    return true;
                case 1:
                    C4990ab.m7411d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", getClass().getClassLoader());
                    AppMethodBeat.m2505o(16130);
                    return true;
                case 2:
                    C4990ab.m7410d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
                    C42010ip c42010ip2 = new C42010ip();
                    c42010ip2.cDI.cuy = 1;
                    C4879a.xxA.mo10055m(c42010ip2);
                    AppMethodBeat.m2505o(16130);
                    return true;
                case 3:
                    if (strArr.length < 3) {
                        AppMethodBeat.m2505o(16130);
                        return true;
                    }
                    str3 = strArr[2];
                    if (!str3.startsWith("/")) {
                        str3 = "/data/data/com.tencent.mm/app_dex/".concat(String.valueOf(str3));
                    }
                    C4990ab.m7417i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", str3);
                    C4990ab.m7416i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    C4990ab.m7416i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    C4990ab.m7417i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", Boolean.valueOf(SharePatchFileUtil.aus(str3)));
                    C4990ab.m7416i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    AppMethodBeat.m2505o(16130);
                    return true;
                default:
                    AppMethodBeat.m2505o(16130);
                    return true;
            }
        }
    }
}
