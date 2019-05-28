package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.C33608d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.b */
public final class C2545b {
    private static int iWl = 1;
    public static float iWm = 4.5f;
    public static int iWn = 4;
    public static float iWo = 3.5f;
    public static int iWp = 3;
    public static final int iWq = AppBrandGlobalSystemConfig.ayC().hfT;
    private static float iWr = iWm;
    private static int iWs = iWn;
    private static int iWt = 0;
    private static boolean iWu = true;

    static {
        AppMethodBeat.m2504i(133712);
        AppMethodBeat.m2505o(133712);
    }

    public static boolean aPd() {
        return iWl == 2;
    }

    public static int axI() {
        AppMethodBeat.m2504i(133707);
        if (iWt == 0) {
            iWt = ((C10118af) C1720g.m3528K(C10118af.class)).awY();
        }
        int i = iWt;
        AppMethodBeat.m2505o(133707);
        return i;
    }

    public static boolean aPe() {
        AppMethodBeat.m2504i(133708);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", Boolean.valueOf(iWu), Long.valueOf(Thread.currentThread().getId()));
        boolean z = iWu;
        AppMethodBeat.m2505o(133708);
        return z;
    }

    /* renamed from: eT */
    public static void m4793eT(boolean z) {
        AppMethodBeat.m2504i(133709);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", Boolean.valueOf(z));
        if (iWu != z) {
            SharedPreferences doB = C4996ah.doB();
            if (doB != null) {
                doB.edit().putBoolean("enable_dynamic_background", z).apply();
            }
        }
        iWu = z;
        AppMethodBeat.m2505o(133709);
    }

    public static boolean aPf() {
        return true;
    }

    public static void init(Context context) {
        AppMethodBeat.m2504i(133710);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", Integer.valueOf(iWl));
        if (iWl == 1) {
            iWm = 4.0f;
            iWn = 4;
            iWo = 3.0f;
            iWp = 3;
            iWr = iWm;
            iWs = iWn;
        }
        int d = C10969d.m18705d(context, iWr);
        if (iWl == 1) {
            d = (int) (((float) d) + (((float) (context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc) * 2)) * C10969d.m18710dm(context)));
        }
        if (d <= C1338a.fromDPToPix(context, 10)) {
            iWr = iWo;
            iWs = iWp;
        } else {
            iWr = iWm;
            iWs = iWn;
        }
        C4990ab.m7417i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d", Float.valueOf(iWr), Integer.valueOf(iWs), Boolean.valueOf(iWu));
        AppMethodBeat.m2505o(133710);
    }

    public static void aPg() {
        AppMethodBeat.m2504i(133711);
        SharedPreferences doB = C4996ah.doB();
        if (doB == null) {
            AppMethodBeat.m2505o(133711);
            return;
        }
        iWu = doB.getBoolean("enable_dynamic_background", true);
        boolean aPJ = C33608d.aPJ();
        if (aPJ) {
            C4990ab.m7417i("MicroMsg.AppBrandDesktopConfig", "alvinluo localVersion %d, currentVersion: %d", Integer.valueOf(doB.getInt("dynamic_background_version", -1)), Integer.valueOf(1));
            if (doB.getInt("dynamic_background_version", -1) != 1) {
                C4990ab.m7417i("MicroMsg.AppBrandDesktopConfig", "alvinluo ignore crash because of new version", Integer.valueOf(r3), Integer.valueOf(1));
                doB.edit().putInt("dynamic_background_version", 1).apply();
                C33608d.aPK();
                C2545b.m4793eT(true);
                aPJ = false;
            } else {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopConfig", "alvinluo disable dynamicBackground because of crash");
                C2545b.m4793eT(false);
            }
        }
        C4990ab.m7417i("MicroMsg.AppBrandDesktopConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", Boolean.valueOf(iWu), Boolean.valueOf(aPJ));
        AppMethodBeat.m2505o(133711);
    }

    public static float getShowCountPerPage() {
        return iWr;
    }

    public static int getCompletelyCountPerPage() {
        return iWs;
    }
}
