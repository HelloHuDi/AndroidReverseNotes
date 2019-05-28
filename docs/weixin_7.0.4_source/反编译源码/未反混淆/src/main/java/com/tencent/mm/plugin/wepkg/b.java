package com.tencent.mm.plugin.wepkg;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class b {
    private static boolean enable = true;
    private static Map<String, f> uVs = new HashMap();
    private static int uVt = 0;

    static {
        AppMethodBeat.i(63363);
        AppMethodBeat.o(63363);
    }

    public static void biO() {
        AppMethodBeat.i(63351);
        dgd();
        a.biO();
        AppMethodBeat.o(63351);
    }

    public static void dgd() {
        AppMethodBeat.i(63352);
        if (!WepkgMainProcessService.isLive()) {
            d.b("", new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                }
            });
        }
        AppMethodBeat.o(63352);
    }

    private static boolean ahv(String str) {
        AppMethodBeat.i(63353);
        if (WepkgMainProcessService.isLive()) {
            AppMethodBeat.o(63353);
            return true;
        }
        d.b("", new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
            }
        });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, d.aid(str), null, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.Kl(10));
        AppMethodBeat.o(63353);
        return false;
    }

    public static void dge() {
        AppMethodBeat.i(63354);
        if (uVt == 0) {
            a.sg();
        }
        uVt++;
        AppMethodBeat.o(63354);
    }

    public static int dgf() {
        return uVt;
    }

    public static void dgg() {
        AppMethodBeat.i(63355);
        int i = uVt - 1;
        uVt = i;
        if (i == 0) {
            uVs.clear();
            a.sg();
        }
        AppMethodBeat.o(63355);
    }

    public static void Dp(String str) {
        AppMethodBeat.i(63356);
        uVs.remove(str);
        AppMethodBeat.o(63356);
    }

    public static boolean ahw(String str) {
        AppMethodBeat.i(63357);
        boolean containsKey = uVs.containsKey(str);
        AppMethodBeat.o(63357);
        return containsKey;
    }

    public static f bN(String str, boolean z) {
        AppMethodBeat.i(63358);
        ab.d("MicroMsg.WePkgLoader", "load, url: %s", str);
        if (!ahv(str)) {
            ab.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
            h.pYm.k(859, 36, 1);
            AppMethodBeat.o(63358);
            return null;
        } else if (enable()) {
            final String aid = d.aid(str);
            if (z) {
                ab.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", Long.valueOf(System.currentTimeMillis()));
                d.aNS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(63350);
                        String str = aid;
                        HashSet hashSet = new HashSet();
                        if (!bo.isNullOrNil(str)) {
                            hashSet.add(str);
                        }
                        if (!bo.isNullOrNil(a.dga())) {
                            hashSet.add(a.dga());
                        }
                        WepkgVersionUpdater.a(hashSet, 0, false);
                        AppMethodBeat.o(63350);
                    }
                });
            }
            if (bo.isNullOrNil(aid)) {
                AppMethodBeat.o(63358);
                return null;
            }
            f ahx = ahx(str);
            AppMethodBeat.o(63358);
            return ahx;
        } else {
            ab.e("MicroMsg.WePkgLoader", "load enable false");
            AppMethodBeat.o(63358);
            return null;
        }
    }

    public static f ahx(String str) {
        f fVar;
        AppMethodBeat.i(63359);
        String aid = d.aid(str);
        if (uVs.containsKey(aid)) {
            fVar = (f) uVs.get(aid);
            String aie = d.aie(str);
            if (!(fVar == null || fVar.uWY == null || !aie.equalsIgnoreCase(fVar.uWY.cSx))) {
                ab.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", fVar.uWY.eBS, fVar.uWY.version);
                AppMethodBeat.o(63359);
                return fVar;
            }
        }
        fVar = g.ahU(str);
        if (fVar != null) {
            uVs.put(aid, fVar);
        }
        AppMethodBeat.o(63359);
        return fVar;
    }

    public static boolean enable() {
        AppMethodBeat.i(63360);
        if (!enable) {
            AppMethodBeat.o(63360);
            return false;
        } else if (com.tencent.mm.plugin.game.commlib.a.bDh()) {
            ab.i("MicroMsg.WePkgLoader", "config wepkg disable");
            enable = false;
            AppMethodBeat.o(63360);
            return false;
        } else {
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("we_pkg_sp", 4);
            if (sharedPreferences == null || !sharedPreferences.getBoolean("disable_we_pkg", false)) {
                AppMethodBeat.o(63360);
                return true;
            }
            ab.i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
            enable = false;
            AppMethodBeat.o(63360);
            return false;
        }
    }

    public static String ahy(String str) {
        AppMethodBeat.i(63361);
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("wepkg_rid");
            AppMethodBeat.o(63361);
            return queryParameter;
        } catch (Exception e) {
            ab.i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", str, e.getMessage());
            AppMethodBeat.o(63361);
            return null;
        }
    }

    public static String ahz(String str) {
        AppMethodBeat.i(63362);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(63362);
            return str2;
        } else if (str.equals(bo.nullAsNil(a.dga()))) {
            str2 = a.dgb();
            AppMethodBeat.o(63362);
            return str2;
        } else {
            f fVar = (f) uVs.get(str);
            if (fVar == null || fVar.uWY == null) {
                str2 = "";
                AppMethodBeat.o(63362);
                return str2;
            }
            str2 = fVar.uWY.version;
            AppMethodBeat.o(63362);
            return str2;
        }
    }

    public static void dgh() {
        enable = false;
    }
}
