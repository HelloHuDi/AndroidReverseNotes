package com.tencent.mm.ca;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a {
    public static String xus = "screenResolution_density_dpi";
    public static String xut = "screenResolution_density_report_new";
    static float xuu = 1.0f;
    static a xuv;
    public static String yai = "screenResolution_density_dpi_new";
    public static String yaj = "screenResolution_density_report_pad";
    DisplayMetrics aDu;
    DisplayMetrics xuq;
    private boolean xur = true;

    public interface a {
        void Bj();
    }

    public static void a(a aVar) {
        xuv = aVar;
    }

    public a(DisplayMetrics displayMetrics) {
        AppMethodBeat.i(105870);
        this.xuq = displayMetrics;
        boolean z;
        if (ah.bqo()) {
            this.xur = dmL();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            ah.getContext().registerReceiver(new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(139067);
                    if (intent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF") && a.dmP() && a.cXN()) {
                        ab.i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                        a.aqe("densityChange");
                    }
                    AppMethodBeat.o(139067);
                }
            }, intentFilter);
        } else if (ah.isAppBrandProcess()) {
            z = dmL() && dmM();
            this.xur = z;
        } else if (ah.doF() || ah.doG()) {
            z = dmL() && dmN();
            this.xur = z;
        }
        ab.i("MicroMsg.MMDensityManager", "MMDensityManager switch mm:%s, tools:%s, appbrand:%s, all:%s", Boolean.valueOf(dmL()), Boolean.valueOf(dmN()), Boolean.valueOf(dmM()), Boolean.valueOf(dmR()));
        if (dmR()) {
            this.aDu = d(displayMetrics);
            displayMetrics.setTo(this.aDu);
            if (VERSION.SDK_INT >= 21) {
                ah.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.aDu);
            }
            ab.i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", this.aDu);
        }
        AppMethodBeat.o(105870);
    }

    public static DisplayMetrics d(DisplayMetrics displayMetrics) {
        AppMethodBeat.i(105871);
        float f = 400.0f;
        if (ae.dzf()) {
            f = 750.0f;
        } else if (ae.dzg()) {
            f = 600.0f;
        }
        float min = ((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / f;
        ab.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Float.valueOf(f));
        if (ae.dzh() == 0 || ae.getDeviceWidth() == 0) {
            f = min;
        } else {
            int min2 = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (min2 != 0) {
                f = ((float) ae.getDeviceWidth()) / ((float) min2);
            } else {
                f = 1.0f;
            }
            if (ae.dMx() != ae.dzh()) {
                f *= ((float) ae.dMx()) / ((float) ae.dzh());
            } else {
                f = 1.0f;
            }
            if (f < 0.95f) {
                f = 0.95f;
            }
            if (ae.dzf() || ae.dzg()) {
                if (f > 1.5f) {
                    f = 1.5f;
                }
            } else if (f > 1.2f) {
                f = 1.2f;
            }
            xuu = f;
            ab.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", Float.valueOf(min * f), Integer.valueOf(ae.dzh()), Integer.valueOf(ae.dMx()), Integer.valueOf(ae.getDeviceWidth()), Integer.valueOf(min2), Float.valueOf(f));
            f = r1;
        }
        float f2 = (displayMetrics.scaledDensity / displayMetrics.density) * f;
        int i = (int) (160.0f * f);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        displayMetrics2.scaledDensity = f2;
        displayMetrics2.densityDpi = i;
        displayMetrics2.density = f;
        AppMethodBeat.o(105871);
        return displayMetrics2;
    }

    public static float dmK() {
        return xuu;
    }

    public static boolean cXN() {
        AppMethodBeat.i(139068);
        try {
            if (bo.getInt(b.brr().b("clicfg_android_density_check_kill_enable", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 1) > 0) {
                AppMethodBeat.o(139068);
                return true;
            }
            AppMethodBeat.o(139068);
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "isOpenKillSelf", new Object[0]);
            AppMethodBeat.o(139068);
            return false;
        }
    }

    public static boolean dmL() {
        AppMethodBeat.i(105872);
        try {
            if (bo.getInt(b.brr().b("clicfg_screen_adaptive", "1", false, true), 1) > 0) {
                AppMethodBeat.o(105872);
                return true;
            }
            AppMethodBeat.o(105872);
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "isOpenScreenAdaptiveForMM", new Object[0]);
            AppMethodBeat.o(105872);
            return false;
        }
    }

    public static boolean dmM() {
        AppMethodBeat.i(105873);
        try {
            boolean z;
            com.tencent.mm.k.a KF = com.tencent.mm.k.a.a.KF();
            boolean Bi;
            if (KF != null) {
                Bi = KF.Bi();
            } else {
                Bi = false;
            }
            if (bo.getInt(b.brr().b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && Bi) {
                AppMethodBeat.o(105873);
                return true;
            }
            AppMethodBeat.o(105873);
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "isOpenScreenAdaptiveForAppBrand", new Object[0]);
            AppMethodBeat.o(105873);
            return false;
        }
    }

    private static boolean dmN() {
        AppMethodBeat.i(105874);
        try {
            if (bo.getInt(b.brr().b("clicfg_screen_adaptive_tool", "1", false, true), 1) > 0) {
                AppMethodBeat.o(105874);
                return true;
            }
            AppMethodBeat.o(105874);
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "isOpenScreenAdaptiveForTool", new Object[0]);
            AppMethodBeat.o(105874);
            return false;
        }
    }

    public final DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.i(105875);
        DisplayMetrics displayMetrics;
        if (dmR()) {
            displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(this.aDu);
            AppMethodBeat.o(105875);
            return displayMetrics;
        }
        displayMetrics = this.xuq;
        AppMethodBeat.o(105875);
        return displayMetrics;
    }

    public static float dmO() {
        AppMethodBeat.i(105876);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        AppMethodBeat.o(105876);
        return f;
    }

    public final Configuration b(Configuration configuration) {
        AppMethodBeat.i(105878);
        if (dmR()) {
            Configuration configuration2 = new Configuration(configuration);
            configuration2.densityDpi = getDisplayMetrics().densityDpi;
            dmQ();
            AppMethodBeat.o(105878);
            return configuration2;
        }
        AppMethodBeat.o(105878);
        return configuration;
    }

    /* Access modifiers changed, original: final */
    public final void dmQ() {
        AppMethodBeat.i(105879);
        try {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            Method declaredMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[]{Integer.valueOf(displayMetrics.densityDpi)});
            Field declaredField = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
            a(declaredField);
            declaredField.setInt(null, displayMetrics.densityDpi);
            AppMethodBeat.o(105879);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "", new Object[0]);
            AppMethodBeat.o(105879);
        }
    }

    static String e(DisplayMetrics displayMetrics) {
        AppMethodBeat.i(105881);
        String format = String.format("scaledDensity:%s densityDpi:%s density:%s", new Object[]{Float.valueOf(displayMetrics.scaledDensity), Integer.valueOf(displayMetrics.densityDpi), Float.valueOf(displayMetrics.density)});
        AppMethodBeat.o(105881);
        return format;
    }

    private static void a(Field field) {
        AppMethodBeat.i(105882);
        field.setAccessible(true);
        Field declaredField = Field.class.getDeclaredField("accessFlags");
        declaredField.setAccessible(true);
        declaredField.setInt(field, field.getModifiers() & -17);
        AppMethodBeat.o(105882);
    }

    /* Access modifiers changed, original: final */
    public final boolean dmR() {
        AppMethodBeat.i(105883);
        if (!this.xur || dmS()) {
            AppMethodBeat.o(105883);
            return false;
        }
        AppMethodBeat.o(105883);
        return true;
    }

    private boolean dmS() {
        AppMethodBeat.i(105884);
        String str = Build.BRAND;
        if (!bo.isNullOrNil(str)) {
            str = str.toLowerCase();
            if ((str.contains("huawei") || str.contains("honor")) && VERSION.SDK_INT == 24) {
                AppMethodBeat.o(105884);
                return true;
            } else if ((str.contains("huawei") || str.contains("honor")) && this.xuq != null && Math.min(this.xuq.widthPixels, this.xuq.heightPixels) == 720 && (VERSION.SDK_INT == 26 || VERSION.SDK_INT == 27)) {
                AppMethodBeat.o(105884);
                return true;
            } else if (str.contains("samsung") && VERSION.SDK_INT == 23) {
                AppMethodBeat.o(105884);
                return true;
            }
        }
        AppMethodBeat.o(105884);
        return false;
    }

    static /* synthetic */ boolean dmP() {
        AppMethodBeat.i(139069);
        int i = as.amF(ah.doA()).getInt(yai, 0);
        ae.dMw();
        int i2 = ae.dMw().densityDpi;
        if (i == 0) {
            as.amF(ah.doA()).putInt(yai, i2);
        }
        ab.i("MicroMsg.MMDensityManager", "dancy densityChangeNew, mDensityDpi:%s,  mCurrentDensityDpi:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i == i2) {
            AppMethodBeat.o(139069);
            return false;
        }
        as.amF(ah.doA()).putInt(yai, i2);
        AppMethodBeat.o(139069);
        return true;
    }

    static /* synthetic */ void aqe(String str) {
        AppMethodBeat.i(139070);
        ah.getContext().sendBroadcast(new Intent("com.tencent.mm.MMDensityManager"));
        RuntimeException runtimeException = new RuntimeException("MicroMsg.MMDensityManager ".concat(String.valueOf(str)));
        AppMethodBeat.o(139070);
        throw runtimeException;
    }
}
