package com.tencent.p177mm.p210ca;

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
import com.tencent.p177mm.p237k.C1640a;
import com.tencent.p177mm.p237k.C1640a.C1641a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.expt.p396d.C3006b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.ca.a */
public final class C32432a {
    public static String xus = "screenResolution_density_dpi";
    public static String xut = "screenResolution_density_report_new";
    static float xuu = 1.0f;
    static C32433a xuv;
    public static String yai = "screenResolution_density_dpi_new";
    public static String yaj = "screenResolution_density_report_pad";
    DisplayMetrics aDu;
    DisplayMetrics xuq;
    private boolean xur = true;

    /* renamed from: com.tencent.mm.ca.a$1 */
    class C181201 extends BroadcastReceiver {
        C181201() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(139067);
            if (intent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF") && C32432a.dmP() && C32432a.cXN()) {
                C4990ab.m7416i("MicroMsg.MMDensityManager", "killSelfAndCallUp ");
                C32432a.aqe("densityChange");
            }
            AppMethodBeat.m2505o(139067);
        }
    }

    /* renamed from: com.tencent.mm.ca.a$a */
    public interface C32433a {
        /* renamed from: Bj */
        void mo20433Bj();
    }

    /* renamed from: a */
    public static void m53092a(C32433a c32433a) {
        xuv = c32433a;
    }

    public C32432a(DisplayMetrics displayMetrics) {
        AppMethodBeat.m2504i(105870);
        this.xuq = displayMetrics;
        boolean z;
        if (C4996ah.bqo()) {
            this.xur = C32432a.dmL();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            C4996ah.getContext().registerReceiver(new C181201(), intentFilter);
        } else if (C4996ah.isAppBrandProcess()) {
            z = C32432a.dmL() && C32432a.dmM();
            this.xur = z;
        } else if (C4996ah.doF() || C4996ah.doG()) {
            z = C32432a.dmL() && C32432a.dmN();
            this.xur = z;
        }
        C4990ab.m7417i("MicroMsg.MMDensityManager", "MMDensityManager switch mm:%s, tools:%s, appbrand:%s, all:%s", Boolean.valueOf(C32432a.dmL()), Boolean.valueOf(C32432a.dmN()), Boolean.valueOf(C32432a.dmM()), Boolean.valueOf(dmR()));
        if (dmR()) {
            this.aDu = C32432a.m53094d(displayMetrics);
            displayMetrics.setTo(this.aDu);
            if (VERSION.SDK_INT >= 21) {
                C4996ah.getContext().getTheme().getResources().getDisplayMetrics().setTo(this.aDu);
            }
            C4990ab.m7417i("MicroMsg.MMDensityManager", " Target DisplayMetrics[%s]", this.aDu);
        }
        AppMethodBeat.m2505o(105870);
    }

    /* renamed from: d */
    public static DisplayMetrics m53094d(DisplayMetrics displayMetrics) {
        AppMethodBeat.m2504i(105871);
        float f = 400.0f;
        if (C5222ae.dzf()) {
            f = 750.0f;
        } else if (C5222ae.dzg()) {
            f = 600.0f;
        }
        float min = ((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / f;
        C4990ab.m7417i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Float.valueOf(f));
        if (C5222ae.dzh() == 0 || C5222ae.getDeviceWidth() == 0) {
            f = min;
        } else {
            int min2 = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (min2 != 0) {
                f = ((float) C5222ae.getDeviceWidth()) / ((float) min2);
            } else {
                f = 1.0f;
            }
            if (C5222ae.dMx() != C5222ae.dzh()) {
                f *= ((float) C5222ae.dMx()) / ((float) C5222ae.dzh());
            } else {
                f = 1.0f;
            }
            if (f < 0.95f) {
                f = 0.95f;
            }
            if (C5222ae.dzf() || C5222ae.dzg()) {
                if (f > 1.5f) {
                    f = 1.5f;
                }
            } else if (f > 1.2f) {
                f = 1.2f;
            }
            xuu = f;
            C4990ab.m7417i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", Float.valueOf(min * f), Integer.valueOf(C5222ae.dzh()), Integer.valueOf(C5222ae.dMx()), Integer.valueOf(C5222ae.getDeviceWidth()), Integer.valueOf(min2), Float.valueOf(f));
            f = r1;
        }
        float f2 = (displayMetrics.scaledDensity / displayMetrics.density) * f;
        int i = (int) (160.0f * f);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        displayMetrics2.scaledDensity = f2;
        displayMetrics2.densityDpi = i;
        displayMetrics2.density = f;
        AppMethodBeat.m2505o(105871);
        return displayMetrics2;
    }

    public static float dmK() {
        return xuu;
    }

    public static boolean cXN() {
        AppMethodBeat.m2504i(139068);
        try {
            if (C5046bo.getInt(C3006b.brr().mo7215b("clicfg_android_density_check_kill_enable", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 1) > 0) {
                AppMethodBeat.m2505o(139068);
                return true;
            }
            AppMethodBeat.m2505o(139068);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "isOpenKillSelf", new Object[0]);
            AppMethodBeat.m2505o(139068);
            return false;
        }
    }

    public static boolean dmL() {
        AppMethodBeat.m2504i(105872);
        try {
            if (C5046bo.getInt(C3006b.brr().mo7215b("clicfg_screen_adaptive", "1", false, true), 1) > 0) {
                AppMethodBeat.m2505o(105872);
                return true;
            }
            AppMethodBeat.m2505o(105872);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "isOpenScreenAdaptiveForMM", new Object[0]);
            AppMethodBeat.m2505o(105872);
            return false;
        }
    }

    public static boolean dmM() {
        AppMethodBeat.m2504i(105873);
        try {
            boolean z;
            C1640a KF = C1641a.m3314KF();
            boolean Bi;
            if (KF != null) {
                Bi = KF.mo5101Bi();
            } else {
                Bi = false;
            }
            if (C5046bo.getInt(C3006b.brr().mo7215b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && Bi) {
                AppMethodBeat.m2505o(105873);
                return true;
            }
            AppMethodBeat.m2505o(105873);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "isOpenScreenAdaptiveForAppBrand", new Object[0]);
            AppMethodBeat.m2505o(105873);
            return false;
        }
    }

    private static boolean dmN() {
        AppMethodBeat.m2504i(105874);
        try {
            if (C5046bo.getInt(C3006b.brr().mo7215b("clicfg_screen_adaptive_tool", "1", false, true), 1) > 0) {
                AppMethodBeat.m2505o(105874);
                return true;
            }
            AppMethodBeat.m2505o(105874);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "isOpenScreenAdaptiveForTool", new Object[0]);
            AppMethodBeat.m2505o(105874);
            return false;
        }
    }

    public final DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.m2504i(105875);
        DisplayMetrics displayMetrics;
        if (dmR()) {
            displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(this.aDu);
            AppMethodBeat.m2505o(105875);
            return displayMetrics;
        }
        displayMetrics = this.xuq;
        AppMethodBeat.m2505o(105875);
        return displayMetrics;
    }

    public static float dmO() {
        AppMethodBeat.m2504i(105876);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        AppMethodBeat.m2505o(105876);
        return f;
    }

    /* renamed from: b */
    public final Configuration mo53072b(Configuration configuration) {
        AppMethodBeat.m2504i(105878);
        if (dmR()) {
            Configuration configuration2 = new Configuration(configuration);
            configuration2.densityDpi = getDisplayMetrics().densityDpi;
            dmQ();
            AppMethodBeat.m2505o(105878);
            return configuration2;
        }
        AppMethodBeat.m2505o(105878);
        return configuration;
    }

    /* Access modifiers changed, original: final */
    public final void dmQ() {
        AppMethodBeat.m2504i(105879);
        try {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            Method declaredMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[]{Integer.valueOf(displayMetrics.densityDpi)});
            Field declaredField = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
            C32432a.m53093a(declaredField);
            declaredField.setInt(null, displayMetrics.densityDpi);
            AppMethodBeat.m2505o(105879);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "", new Object[0]);
            AppMethodBeat.m2505o(105879);
        }
    }

    /* renamed from: e */
    static String m53095e(DisplayMetrics displayMetrics) {
        AppMethodBeat.m2504i(105881);
        String format = String.format("scaledDensity:%s densityDpi:%s density:%s", new Object[]{Float.valueOf(displayMetrics.scaledDensity), Integer.valueOf(displayMetrics.densityDpi), Float.valueOf(displayMetrics.density)});
        AppMethodBeat.m2505o(105881);
        return format;
    }

    /* renamed from: a */
    private static void m53093a(Field field) {
        AppMethodBeat.m2504i(105882);
        field.setAccessible(true);
        Field declaredField = Field.class.getDeclaredField("accessFlags");
        declaredField.setAccessible(true);
        declaredField.setInt(field, field.getModifiers() & -17);
        AppMethodBeat.m2505o(105882);
    }

    /* Access modifiers changed, original: final */
    public final boolean dmR() {
        AppMethodBeat.m2504i(105883);
        if (!this.xur || dmS()) {
            AppMethodBeat.m2505o(105883);
            return false;
        }
        AppMethodBeat.m2505o(105883);
        return true;
    }

    private boolean dmS() {
        AppMethodBeat.m2504i(105884);
        String str = Build.BRAND;
        if (!C5046bo.isNullOrNil(str)) {
            str = str.toLowerCase();
            if ((str.contains("huawei") || str.contains("honor")) && VERSION.SDK_INT == 24) {
                AppMethodBeat.m2505o(105884);
                return true;
            } else if ((str.contains("huawei") || str.contains("honor")) && this.xuq != null && Math.min(this.xuq.widthPixels, this.xuq.heightPixels) == 720 && (VERSION.SDK_INT == 26 || VERSION.SDK_INT == 27)) {
                AppMethodBeat.m2505o(105884);
                return true;
            } else if (str.contains("samsung") && VERSION.SDK_INT == 23) {
                AppMethodBeat.m2505o(105884);
                return true;
            }
        }
        AppMethodBeat.m2505o(105884);
        return false;
    }

    static /* synthetic */ boolean dmP() {
        AppMethodBeat.m2504i(139069);
        int i = C5018as.amF(C4996ah.doA()).getInt(yai, 0);
        C5222ae.dMw();
        int i2 = C5222ae.dMw().densityDpi;
        if (i == 0) {
            C5018as.amF(C4996ah.doA()).putInt(yai, i2);
        }
        C4990ab.m7417i("MicroMsg.MMDensityManager", "dancy densityChangeNew, mDensityDpi:%s,  mCurrentDensityDpi:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i == i2) {
            AppMethodBeat.m2505o(139069);
            return false;
        }
        C5018as.amF(C4996ah.doA()).putInt(yai, i2);
        AppMethodBeat.m2505o(139069);
        return true;
    }

    static /* synthetic */ void aqe(String str) {
        AppMethodBeat.m2504i(139070);
        C4996ah.getContext().sendBroadcast(new Intent("com.tencent.mm.MMDensityManager"));
        RuntimeException runtimeException = new RuntimeException("MicroMsg.MMDensityManager ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(139070);
        throw runtimeException;
    }
}
