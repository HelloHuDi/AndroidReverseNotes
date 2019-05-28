package com.tencent.p177mm.p612ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p069v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.ui.ak */
public final class C5230ak {
    /* renamed from: de */
    public static int m7987de(Context context) {
        int height;
        AppMethodBeat.m2504i(112488);
        if (context == null) {
            C5227ai.m7975w("WeUIToolHelper", "[getActionBarHeight] context is null!", new Object[0]);
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
        if (context instanceof AppCompatActivity) {
            if (((AppCompatActivity) context).getSupportActionBar() != null) {
                height = ((AppCompatActivity) context).getSupportActionBar().getHeight();
            }
            height = 0;
        } else {
            if ((context instanceof Activity) && ((Activity) context).getActionBar() != null) {
                height = ((Activity) context).getActionBar().getHeight();
            }
            height = 0;
        }
        if (height <= 0) {
            height = dimensionPixelSize;
        }
        C5227ai.m7973i("WeUIToolHelper", "[getActionBarHeight] real:%s defaultVal:%s", Integer.valueOf(height), Integer.valueOf(dimensionPixelSize));
        AppMethodBeat.m2505o(112488);
        return height;
    }

    /* renamed from: hF */
    public static int m7989hF(Context context) {
        AppMethodBeat.m2504i(112489);
        int ax = C5230ak.m7985ax(context, C5229aj.fromDPToPix(context, 25));
        AppMethodBeat.m2505o(112489);
        return ax;
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.m2504i(112490);
        int J = C5230ak.m7984J(context, C5229aj.fromDPToPix(context, 25));
        AppMethodBeat.m2505o(112490);
        return J;
    }

    /* renamed from: J */
    public static int m7984J(Context context, int i) {
        AppMethodBeat.m2504i(112491);
        int ax = C5230ak.m7985ax(context, i);
        if (ax > 0) {
            i = C5230ak.m7986ay(context, ax);
            AppMethodBeat.m2505o(112491);
            return i;
        }
        if (ax <= 0) {
            C5227ai.m7973i("WeUIToolHelper", "[getStatusBarHeight] return default!!!", new Object[0]);
        } else {
            i = ax;
        }
        AppMethodBeat.m2505o(112491);
        return i;
    }

    /* renamed from: ax */
    private static int m7985ax(Context context, int i) {
        AppMethodBeat.m2504i(112492);
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(C5231al.m7996la(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            C5227ai.printErrStackTrace("WeUIToolHelper", e, "getStatusBarHeightFromSysR", new Object[0]);
        }
        C5227ai.m7973i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", Integer.valueOf(i));
        AppMethodBeat.m2505o(112492);
        return i;
    }

    /* renamed from: ay */
    private static int m7986ay(Context context, int i) {
        AppMethodBeat.m2504i(112493);
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = ((Activity) context).getResources().getDisplayMetrics();
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (displayMetrics != null && rect.height() > 0) {
                int height = displayMetrics.heightPixels - rect.height();
                C5227ai.m7973i("WeUIToolHelper", "[fixStatusBarHeight] new statusBar:%s ", Integer.valueOf(height));
                if (height > i && height - i < 100) {
                    C5227ai.m7973i("WeUIToolHelper", "[fixStatusBarHeight] return new statusBar:%s ", Integer.valueOf(height));
                    AppMethodBeat.m2505o(112493);
                    return height;
                }
            }
        }
        AppMethodBeat.m2505o(112493);
        return i;
    }

    /* renamed from: hy */
    public static Point m7993hy(Context context) {
        AppMethodBeat.m2504i(112494);
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (VERSION.SDK_INT >= 14) {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (NoSuchMethodException e) {
                C5227ai.printErrStackTrace("WeUIToolHelper", e, "getDisplayRealSize NoSuchMethodException", new Object[0]);
            } catch (IllegalAccessException e2) {
                C5227ai.printErrStackTrace("WeUIToolHelper", e2, "getDisplayRealSize IllegalAccessException", new Object[0]);
            } catch (InvocationTargetException e3) {
                C5227ai.printErrStackTrace("WeUIToolHelper", e3, "getDisplayRealSize InvocationTargetException", new Object[0]);
            }
        } else {
            defaultDisplay.getSize(point);
        }
        AppMethodBeat.m2505o(112494);
        return point;
    }

    @TargetApi(17)
    /* renamed from: hw */
    public static boolean m7991hw(Context context) {
        AppMethodBeat.m2504i(112495);
        if (C5230ak.m7992hx(context) > 0) {
            AppMethodBeat.m2505o(112495);
            return true;
        }
        AppMethodBeat.m2505o(112495);
        return false;
    }

    /* renamed from: hx */
    public static int m7992hx(Context context) {
        AppMethodBeat.m2504i(112496);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point hy = C5230ak.m7993hy(context);
        int max = Math.max(point.y, point.x);
        int max2 = Math.max(hy.y, hy.x);
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            max = Math.max(rect.bottom, rect.right);
        }
        max = max2 - max;
        AppMethodBeat.m2505o(112496);
        return max;
    }

    /* renamed from: hG */
    public static boolean m7990hG(Context context) {
        AppMethodBeat.m2504i(112497);
        if (!(context instanceof Activity)) {
            AppMethodBeat.m2505o(112497);
            return true;
        } else if ((((Activity) context).getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            AppMethodBeat.m2505o(112497);
            return true;
        } else {
            AppMethodBeat.m2505o(112497);
            return false;
        }
    }

    /* renamed from: fr */
    public static int m7988fr(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(112498);
        if (C5230ak.m7991hw(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i = Resources.getSystem().getDimensionPixelSize(identifier);
            }
            identifier = C5230ak.m7992hx(context);
            if (identifier != 0 && identifier < r0) {
                i = identifier;
            }
            AppMethodBeat.m2505o(112498);
        } else {
            AppMethodBeat.m2505o(112498);
        }
        return i;
    }
}
