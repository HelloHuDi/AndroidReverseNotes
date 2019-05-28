package com.tencent.p177mm.plugin.wepkg;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.C14805a;
import com.tencent.p177mm.plugin.wepkg.model.C40398f;
import com.tencent.p177mm.plugin.wepkg.model.C46476g;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.plugin.wepkg.utils.C35765a;
import com.tencent.p177mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wepkg.b */
public final class C40393b {
    private static boolean enable = true;
    private static Map<String, C40398f> uVs = new HashMap();
    private static int uVt = 0;

    /* renamed from: com.tencent.mm.plugin.wepkg.b$1 */
    static class C231961 extends C14805a {
        C231961() {
        }

        /* renamed from: a */
        public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.b$2 */
    static class C231972 extends C14805a {
        C231972() {
        }

        /* renamed from: a */
        public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
        }
    }

    static {
        AppMethodBeat.m2504i(63363);
        AppMethodBeat.m2505o(63363);
    }

    public static void biO() {
        AppMethodBeat.m2504i(63351);
        C40393b.dgd();
        C46469a.biO();
        AppMethodBeat.m2505o(63351);
    }

    public static void dgd() {
        AppMethodBeat.m2504i(63352);
        if (!WepkgMainProcessService.isLive()) {
            C30022d.m47516b("", new C231961());
        }
        AppMethodBeat.m2505o(63352);
    }

    private static boolean ahv(String str) {
        AppMethodBeat.m2504i(63353);
        if (WepkgMainProcessService.isLive()) {
            AppMethodBeat.m2505o(63353);
            return true;
        }
        C30022d.m47516b("", new C231972());
        C35765a.m58633b("EnterWeb", str, C30022d.aid(str), null, 0, 0, C35765a.m58632Kl(10));
        AppMethodBeat.m2505o(63353);
        return false;
    }

    public static void dge() {
        AppMethodBeat.m2504i(63354);
        if (uVt == 0) {
            C46469a.m87646sg();
        }
        uVt++;
        AppMethodBeat.m2505o(63354);
    }

    public static int dgf() {
        return uVt;
    }

    public static void dgg() {
        AppMethodBeat.m2504i(63355);
        int i = uVt - 1;
        uVt = i;
        if (i == 0) {
            uVs.clear();
            C46469a.m87646sg();
        }
        AppMethodBeat.m2505o(63355);
    }

    /* renamed from: Dp */
    public static void m69299Dp(String str) {
        AppMethodBeat.m2504i(63356);
        uVs.remove(str);
        AppMethodBeat.m2505o(63356);
    }

    public static boolean ahw(String str) {
        AppMethodBeat.m2504i(63357);
        boolean containsKey = uVs.containsKey(str);
        AppMethodBeat.m2505o(63357);
        return containsKey;
    }

    /* renamed from: bN */
    public static C40398f m69300bN(String str, boolean z) {
        AppMethodBeat.m2504i(63358);
        C4990ab.m7411d("MicroMsg.WePkgLoader", "load, url: %s", str);
        if (!C40393b.ahv(str)) {
            C4990ab.m7412e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
            C7060h.pYm.mo15419k(859, 36, 1);
            AppMethodBeat.m2505o(63358);
            return null;
        } else if (C40393b.enable()) {
            final String aid = C30022d.aid(str);
            if (z) {
                C4990ab.m7411d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", Long.valueOf(System.currentTimeMillis()));
                C30022d.aNS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(63350);
                        String str = aid;
                        HashSet hashSet = new HashSet();
                        if (!C5046bo.isNullOrNil(str)) {
                            hashSet.add(str);
                        }
                        if (!C5046bo.isNullOrNil(C46469a.dga())) {
                            hashSet.add(C46469a.dga());
                        }
                        WepkgVersionUpdater.m23052a(hashSet, 0, false);
                        AppMethodBeat.m2505o(63350);
                    }
                });
            }
            if (C5046bo.isNullOrNil(aid)) {
                AppMethodBeat.m2505o(63358);
                return null;
            }
            C40398f ahx = C40393b.ahx(str);
            AppMethodBeat.m2505o(63358);
            return ahx;
        } else {
            C4990ab.m7412e("MicroMsg.WePkgLoader", "load enable false");
            AppMethodBeat.m2505o(63358);
            return null;
        }
    }

    public static C40398f ahx(String str) {
        C40398f c40398f;
        AppMethodBeat.m2504i(63359);
        String aid = C30022d.aid(str);
        if (uVs.containsKey(aid)) {
            c40398f = (C40398f) uVs.get(aid);
            String aie = C30022d.aie(str);
            if (!(c40398f == null || c40398f.uWY == null || !aie.equalsIgnoreCase(c40398f.uWY.cSx))) {
                C4990ab.m7417i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", c40398f.uWY.eBS, c40398f.uWY.version);
                AppMethodBeat.m2505o(63359);
                return c40398f;
            }
        }
        c40398f = C46476g.ahU(str);
        if (c40398f != null) {
            uVs.put(aid, c40398f);
        }
        AppMethodBeat.m2505o(63359);
        return c40398f;
    }

    public static boolean enable() {
        AppMethodBeat.m2504i(63360);
        if (!enable) {
            AppMethodBeat.m2505o(63360);
            return false;
        } else if (C45985a.bDh()) {
            C4990ab.m7416i("MicroMsg.WePkgLoader", "config wepkg disable");
            enable = false;
            AppMethodBeat.m2505o(63360);
            return false;
        } else {
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("we_pkg_sp", 4);
            if (sharedPreferences == null || !sharedPreferences.getBoolean("disable_we_pkg", false)) {
                AppMethodBeat.m2505o(63360);
                return true;
            }
            C4990ab.m7416i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
            enable = false;
            AppMethodBeat.m2505o(63360);
            return false;
        }
    }

    public static String ahy(String str) {
        AppMethodBeat.m2504i(63361);
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("wepkg_rid");
            AppMethodBeat.m2505o(63361);
            return queryParameter;
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", str, e.getMessage());
            AppMethodBeat.m2505o(63361);
            return null;
        }
    }

    public static String ahz(String str) {
        AppMethodBeat.m2504i(63362);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(63362);
            return str2;
        } else if (str.equals(C5046bo.nullAsNil(C46469a.dga()))) {
            str2 = C46469a.dgb();
            AppMethodBeat.m2505o(63362);
            return str2;
        } else {
            C40398f c40398f = (C40398f) uVs.get(str);
            if (c40398f == null || c40398f.uWY == null) {
                str2 = "";
                AppMethodBeat.m2505o(63362);
                return str2;
            }
            str2 = c40398f.uWY.version;
            AppMethodBeat.m2505o(63362);
            return str2;
        }
    }

    public static void dgh() {
        enable = false;
    }
}
