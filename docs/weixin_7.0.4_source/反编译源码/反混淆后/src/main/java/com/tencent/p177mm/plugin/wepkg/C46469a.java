package com.tencent.p177mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.C14805a;
import com.tencent.p177mm.plugin.wepkg.model.C40398f;
import com.tencent.p177mm.plugin.wepkg.model.C40404h;
import com.tencent.p177mm.plugin.wepkg.model.C46475e;
import com.tencent.p177mm.plugin.wepkg.model.C46476g;
import com.tencent.p177mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C31147o;

/* renamed from: com.tencent.mm.plugin.wepkg.a */
public final class C46469a {
    private static C40398f uVn;
    private static boolean uVo = false;

    /* renamed from: com.tencent.mm.plugin.wepkg.a$1 */
    static class C464681 extends C14805a {
        C464681() {
        }

        /* renamed from: a */
        public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
            AppMethodBeat.m2504i(63338);
            WepkgVersion wepkgVersion = ((WepkgCrossProcessTask) baseWepkgProcessTask).uWY;
            if (wepkgVersion == null) {
                C4990ab.m7412e("MicroMsg.CommJsLoader", "wepkgVersion is null");
                C46469a.uVn = null;
                AppMethodBeat.m2505o(63338);
            } else if (wepkgVersion.version == null) {
                C4990ab.m7412e("MicroMsg.CommJsLoader", "version is null");
                C46469a.uVn = null;
                AppMethodBeat.m2505o(63338);
            } else if (C46469a.uVn != null && wepkgVersion.version.equals(C46469a.uVn.uWY.version)) {
                AppMethodBeat.m2505o(63338);
            } else if (wepkgVersion.uXM) {
                C46475e a = C46476g.m87670a(C46469a.dga(), wepkgVersion.version, wepkgVersion.gSP, wepkgVersion.cvZ, wepkgVersion.uXK);
                if (a == null || C5046bo.isNullOrNil(wepkgVersion.gSP) || !C1173e.m2561ct(wepkgVersion.gSP)) {
                    C4990ab.m7412e("MicroMsg.CommJsLoader", "path not exist");
                    AppMethodBeat.m2505o(63338);
                    return;
                }
                C46469a.uVn = new C40398f(wepkgVersion, a, null);
                AppMethodBeat.m2505o(63338);
            } else {
                C4990ab.m7412e("MicroMsg.CommJsLoader", "bigPackage is not ready");
                AppMethodBeat.m2505o(63338);
            }
        }
    }

    public static String dga() {
        AppMethodBeat.m2504i(63339);
        String bDi = C45985a.bDi();
        if (C5046bo.isNullOrNil(bDi)) {
            bDi = "commlib";
            AppMethodBeat.m2505o(63339);
            return bDi;
        }
        AppMethodBeat.m2505o(63339);
        return bDi;
    }

    public static void biO() {
        AppMethodBeat.m2504i(63340);
        C46469a.m87646sg();
        AppMethodBeat.m2505o(63340);
    }

    public static void aht(String str) {
        AppMethodBeat.m2504i(63341);
        if (C46469a.dga().equals(str)) {
            uVo = true;
        }
        AppMethodBeat.m2505o(63341);
    }

    /* renamed from: bM */
    public static void m87645bM(String str, boolean z) {
        AppMethodBeat.m2504i(63342);
        if (C46469a.dga().equals(str) && (uVo || C40393b.dgf() == 0)) {
            uVo = false;
            if (z) {
                C46469a.m87646sg();
            }
        }
        AppMethodBeat.m2505o(63342);
    }

    /* renamed from: sg */
    public static void m87646sg() {
        AppMethodBeat.m2504i(63343);
        C4990ab.m7416i("MicroMsg.CommJsLoader", "load");
        C40404h.m69308a(C46469a.dga(), new C464681());
        AppMethodBeat.m2505o(63343);
    }

    public static C31147o ahu(String str) {
        AppMethodBeat.m2504i(63344);
        if (!C40393b.enable() || uVn == null) {
            C4990ab.m7412e("MicroMsg.CommJsLoader", "nativeJsCache is null");
            AppMethodBeat.m2505o(63344);
            return null;
        }
        C31147o ahS = uVn.ahS(str);
        if (ahS != null) {
            AppMethodBeat.m2505o(63344);
            return ahS;
        }
        AppMethodBeat.m2505o(63344);
        return null;
    }

    public static String dgb() {
        if (uVn == null || uVn.uWY == null) {
            return "";
        }
        return uVn.uWY.version;
    }
}
