package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {
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
        AppMethodBeat.i(133712);
        AppMethodBeat.o(133712);
    }

    public static boolean aPd() {
        return iWl == 2;
    }

    public static int axI() {
        AppMethodBeat.i(133707);
        if (iWt == 0) {
            iWt = ((af) g.K(af.class)).awY();
        }
        int i = iWt;
        AppMethodBeat.o(133707);
        return i;
    }

    public static boolean aPe() {
        AppMethodBeat.i(133708);
        ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", Boolean.valueOf(iWu), Long.valueOf(Thread.currentThread().getId()));
        boolean z = iWu;
        AppMethodBeat.o(133708);
        return z;
    }

    public static void eT(boolean z) {
        AppMethodBeat.i(133709);
        ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", Boolean.valueOf(z));
        if (iWu != z) {
            SharedPreferences doB = ah.doB();
            if (doB != null) {
                doB.edit().putBoolean("enable_dynamic_background", z).apply();
            }
        }
        iWu = z;
        AppMethodBeat.o(133709);
    }

    public static boolean aPf() {
        return true;
    }

    public static void init(Context context) {
        AppMethodBeat.i(133710);
        ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", Integer.valueOf(iWl));
        if (iWl == 1) {
            iWm = 4.0f;
            iWn = 4;
            iWo = 3.0f;
            iWp = 3;
            iWr = iWm;
            iWs = iWn;
        }
        int d = d.d(context, iWr);
        if (iWl == 1) {
            d = (int) (((float) d) + (((float) (context.getResources().getDimensionPixelSize(R.dimen.nc) * 2)) * d.dm(context)));
        }
        if (d <= a.fromDPToPix(context, 10)) {
            iWr = iWo;
            iWs = iWp;
        } else {
            iWr = iWm;
            iWs = iWn;
        }
        ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d", Float.valueOf(iWr), Integer.valueOf(iWs), Boolean.valueOf(iWu));
        AppMethodBeat.o(133710);
    }

    public static void aPg() {
        AppMethodBeat.i(133711);
        SharedPreferences doB = ah.doB();
        if (doB == null) {
            AppMethodBeat.o(133711);
            return;
        }
        iWu = doB.getBoolean("enable_dynamic_background", true);
        boolean aPJ = d.aPJ();
        if (aPJ) {
            ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo localVersion %d, currentVersion: %d", Integer.valueOf(doB.getInt("dynamic_background_version", -1)), Integer.valueOf(1));
            if (doB.getInt("dynamic_background_version", -1) != 1) {
                ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo ignore crash because of new version", Integer.valueOf(r3), Integer.valueOf(1));
                doB.edit().putInt("dynamic_background_version", 1).apply();
                d.aPK();
                eT(true);
                aPJ = false;
            } else {
                ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo disable dynamicBackground because of crash");
                eT(false);
            }
        }
        ab.i("MicroMsg.AppBrandDesktopConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", Boolean.valueOf(iWu), Boolean.valueOf(aPJ));
        AppMethodBeat.o(133711);
    }

    public static float getShowCountPerPage() {
        return iWr;
    }

    public static int getCompletelyCountPerPage() {
        return iWs;
    }
}
