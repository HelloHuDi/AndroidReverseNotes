package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;

public class x {
    public static int xyu = -1;
    public static int xyv = -1;
    private static boolean xyw = false;
    private static int xyx = -1;
    private static int xyy = -1;

    public static void dod() {
        xyw = false;
    }

    public static final int gp(Context context) {
        AppMethodBeat.i(115192);
        int as;
        if (xyw) {
            as = as(context, 0);
            AppMethodBeat.o(115192);
            return as;
        } else if (gt(context)) {
            as = ah.doB().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(context, 230));
            xyu = as;
            AppMethodBeat.o(115192);
            return as;
        } else {
            as = ah.doB().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
            AppMethodBeat.o(115192);
            return as;
        }
    }

    public static final int gq(Context context) {
        AppMethodBeat.i(115193);
        int as;
        if (xyw) {
            as = as(context, 0);
            AppMethodBeat.o(115193);
            return as;
        } else if (xyu > 0) {
            as = xyu;
            AppMethodBeat.o(115193);
            return as;
        } else {
            as = gp(context);
            AppMethodBeat.o(115193);
            return as;
        }
    }

    public static final int gr(Context context) {
        AppMethodBeat.i(115194);
        int as;
        if (xyw) {
            as = as(context, 0);
            AppMethodBeat.o(115194);
            return as;
        } else if (xyx > 0) {
            as = xyx;
            AppMethodBeat.o(115194);
            return as;
        } else if (gt(context)) {
            as = a.fromDPToPix(context, 380);
            xyx = as;
            AppMethodBeat.o(115194);
            return as;
        } else {
            AppMethodBeat.o(115194);
            return 1140;
        }
    }

    public static final int as(Context context, int i) {
        AppMethodBeat.i(115195);
        int i2;
        if (i > 0) {
            i2 = i + 230;
            if (gt(context)) {
                i2 = a.fromDPToPix(context, i2);
                xyy = i2;
                AppMethodBeat.o(115195);
                return i2;
            }
            i2 *= 3;
            AppMethodBeat.o(115195);
            return i2;
        } else if (xyy > 0) {
            i2 = xyy;
            AppMethodBeat.o(115195);
            return i2;
        } else if (gt(context)) {
            i2 = a.fromDPToPix(context, 230);
            xyy = i2;
            AppMethodBeat.o(115195);
            return i2;
        } else {
            AppMethodBeat.o(115195);
            return 690;
        }
    }

    public static final int at(Context context, int i) {
        AppMethodBeat.i(115196);
        int e = e(context, i, 0);
        AppMethodBeat.o(115196);
        return e;
    }

    public static final int e(Context context, int i, int i2) {
        AppMethodBeat.i(115197);
        int as = as(context, i2);
        ab.e("MicroMsg.KeyBordUtil", "getValidPanelHeight(): minPanelHeight= %d, isOpenIm=%b", Integer.valueOf(as), Integer.valueOf(i2));
        int gr;
        if (gu(context)) {
            if (i <= 0) {
                i = gq(context);
            }
            gr = gr(context);
            if (i > gr) {
                AppMethodBeat.o(115197);
                return gr;
            } else if (i < as) {
                AppMethodBeat.o(115197);
                return as;
            } else {
                AppMethodBeat.o(115197);
                return i;
            }
        }
        gr = (int) (((double) as) / 1.5d);
        as = db(context)[0];
        if (gr > as / 2) {
            gr = as / 2;
        }
        AppMethodBeat.o(115197);
        return gr;
    }

    public static final boolean gt(Context context) {
        AppMethodBeat.i(115199);
        if (context == null) {
            context = ah.getContext();
        }
        if (context != null) {
            AppMethodBeat.o(115199);
            return true;
        }
        AppMethodBeat.o(115199);
        return false;
    }

    public static boolean gu(Context context) {
        AppMethodBeat.i(115200);
        if (gv(context) == 1) {
            AppMethodBeat.o(115200);
            return true;
        }
        AppMethodBeat.o(115200);
        return false;
    }

    private static int gv(Context context) {
        int i = 1;
        AppMethodBeat.i(115201);
        int[] db = db(context);
        if (db[0] >= db[1]) {
            i = 2;
        }
        AppMethodBeat.o(115201);
        return i;
    }

    public static int[] db(Context context) {
        Context context2;
        AppMethodBeat.i(115202);
        if (context == null) {
            context2 = ah.getContext();
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
        AppMethodBeat.o(115202);
        return iArr;
    }

    public static int al(Activity activity) {
        AppMethodBeat.i(115203);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        AppMethodBeat.o(115203);
        return i;
    }

    public static final int gs(Context context) {
        AppMethodBeat.i(115198);
        int e = e(context, -1, 0);
        AppMethodBeat.o(115198);
        return e;
    }
}
