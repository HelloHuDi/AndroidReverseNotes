package com.tencent.p177mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.sdk.platformtools.x */
public class C40619x {
    public static int xyu = -1;
    public static int xyv = -1;
    private static boolean xyw = false;
    private static int xyx = -1;
    private static int xyy = -1;

    public static void dod() {
        xyw = false;
    }

    /* renamed from: gp */
    public static final int m70070gp(Context context) {
        AppMethodBeat.m2504i(115192);
        int as;
        if (xyw) {
            as = C40619x.m70066as(context, 0);
            AppMethodBeat.m2505o(115192);
            return as;
        } else if (C40619x.m70074gt(context)) {
            as = C4996ah.doB().getInt("com.tencent.mm.compatible.util.keybord.height", C1338a.fromDPToPix(context, 230));
            xyu = as;
            AppMethodBeat.m2505o(115192);
            return as;
        } else {
            as = C4996ah.doB().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
            AppMethodBeat.m2505o(115192);
            return as;
        }
    }

    /* renamed from: gq */
    public static final int m70071gq(Context context) {
        AppMethodBeat.m2504i(115193);
        int as;
        if (xyw) {
            as = C40619x.m70066as(context, 0);
            AppMethodBeat.m2505o(115193);
            return as;
        } else if (xyu > 0) {
            as = xyu;
            AppMethodBeat.m2505o(115193);
            return as;
        } else {
            as = C40619x.m70070gp(context);
            AppMethodBeat.m2505o(115193);
            return as;
        }
    }

    /* renamed from: gr */
    public static final int m70072gr(Context context) {
        AppMethodBeat.m2504i(115194);
        int as;
        if (xyw) {
            as = C40619x.m70066as(context, 0);
            AppMethodBeat.m2505o(115194);
            return as;
        } else if (xyx > 0) {
            as = xyx;
            AppMethodBeat.m2505o(115194);
            return as;
        } else if (C40619x.m70074gt(context)) {
            as = C1338a.fromDPToPix(context, 380);
            xyx = as;
            AppMethodBeat.m2505o(115194);
            return as;
        } else {
            AppMethodBeat.m2505o(115194);
            return 1140;
        }
    }

    /* renamed from: as */
    public static final int m70066as(Context context, int i) {
        AppMethodBeat.m2504i(115195);
        int i2;
        if (i > 0) {
            i2 = i + 230;
            if (C40619x.m70074gt(context)) {
                i2 = C1338a.fromDPToPix(context, i2);
                xyy = i2;
                AppMethodBeat.m2505o(115195);
                return i2;
            }
            i2 *= 3;
            AppMethodBeat.m2505o(115195);
            return i2;
        } else if (xyy > 0) {
            i2 = xyy;
            AppMethodBeat.m2505o(115195);
            return i2;
        } else if (C40619x.m70074gt(context)) {
            i2 = C1338a.fromDPToPix(context, 230);
            xyy = i2;
            AppMethodBeat.m2505o(115195);
            return i2;
        } else {
            AppMethodBeat.m2505o(115195);
            return 690;
        }
    }

    /* renamed from: at */
    public static final int m70067at(Context context, int i) {
        AppMethodBeat.m2504i(115196);
        int e = C40619x.m70069e(context, i, 0);
        AppMethodBeat.m2505o(115196);
        return e;
    }

    /* renamed from: e */
    public static final int m70069e(Context context, int i, int i2) {
        AppMethodBeat.m2504i(115197);
        int as = C40619x.m70066as(context, i2);
        C4990ab.m7413e("MicroMsg.KeyBordUtil", "getValidPanelHeight(): minPanelHeight= %d, isOpenIm=%b", Integer.valueOf(as), Integer.valueOf(i2));
        int gr;
        if (C40619x.m70075gu(context)) {
            if (i <= 0) {
                i = C40619x.m70071gq(context);
            }
            gr = C40619x.m70072gr(context);
            if (i > gr) {
                AppMethodBeat.m2505o(115197);
                return gr;
            } else if (i < as) {
                AppMethodBeat.m2505o(115197);
                return as;
            } else {
                AppMethodBeat.m2505o(115197);
                return i;
            }
        }
        gr = (int) (((double) as) / 1.5d);
        as = C40619x.m70068db(context)[0];
        if (gr > as / 2) {
            gr = as / 2;
        }
        AppMethodBeat.m2505o(115197);
        return gr;
    }

    /* renamed from: gt */
    public static final boolean m70074gt(Context context) {
        AppMethodBeat.m2504i(115199);
        if (context == null) {
            context = C4996ah.getContext();
        }
        if (context != null) {
            AppMethodBeat.m2505o(115199);
            return true;
        }
        AppMethodBeat.m2505o(115199);
        return false;
    }

    /* renamed from: gu */
    public static boolean m70075gu(Context context) {
        AppMethodBeat.m2504i(115200);
        if (C40619x.m70076gv(context) == 1) {
            AppMethodBeat.m2505o(115200);
            return true;
        }
        AppMethodBeat.m2505o(115200);
        return false;
    }

    /* renamed from: gv */
    private static int m70076gv(Context context) {
        int i = 1;
        AppMethodBeat.m2504i(115201);
        int[] db = C40619x.m70068db(context);
        if (db[0] >= db[1]) {
            i = 2;
        }
        AppMethodBeat.m2505o(115201);
        return i;
    }

    /* renamed from: db */
    public static int[] m70068db(Context context) {
        Context context2;
        AppMethodBeat.m2504i(115202);
        if (context == null) {
            context2 = C4996ah.getContext();
        } else {
            context2 = context;
        }
        int[] iArr = new int[2];
        if (context2 instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context2).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        AppMethodBeat.m2505o(115202);
        return iArr;
    }

    /* renamed from: al */
    public static int m70065al(Activity activity) {
        AppMethodBeat.m2504i(115203);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        AppMethodBeat.m2505o(115203);
        return i;
    }

    /* renamed from: gs */
    public static final int m70073gs(Context context) {
        AppMethodBeat.m2504i(115198);
        int e = C40619x.m70069e(context, -1, 0);
        AppMethodBeat.m2505o(115198);
        return e;
    }
}
