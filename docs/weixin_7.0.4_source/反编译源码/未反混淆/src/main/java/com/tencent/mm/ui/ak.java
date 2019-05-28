package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ak {
    public static int de(Context context) {
        int height;
        AppMethodBeat.i(112488);
        if (context == null) {
            ai.w("WeUIToolHelper", "[getActionBarHeight] context is null!", new Object[0]);
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.fc);
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
        ai.i("WeUIToolHelper", "[getActionBarHeight] real:%s defaultVal:%s", Integer.valueOf(height), Integer.valueOf(dimensionPixelSize));
        AppMethodBeat.o(112488);
        return height;
    }

    public static int hF(Context context) {
        AppMethodBeat.i(112489);
        int ax = ax(context, aj.fromDPToPix(context, 25));
        AppMethodBeat.o(112489);
        return ax;
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.i(112490);
        int J = J(context, aj.fromDPToPix(context, 25));
        AppMethodBeat.o(112490);
        return J;
    }

    public static int J(Context context, int i) {
        AppMethodBeat.i(112491);
        int ax = ax(context, i);
        if (ax > 0) {
            i = ay(context, ax);
            AppMethodBeat.o(112491);
            return i;
        }
        if (ax <= 0) {
            ai.i("WeUIToolHelper", "[getStatusBarHeight] return default!!!", new Object[0]);
        } else {
            i = ax;
        }
        AppMethodBeat.o(112491);
        return i;
    }

    private static int ax(Context context, int i) {
        AppMethodBeat.i(112492);
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(al.la(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            ai.printErrStackTrace("WeUIToolHelper", e, "getStatusBarHeightFromSysR", new Object[0]);
        }
        ai.i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", Integer.valueOf(i));
        AppMethodBeat.o(112492);
        return i;
    }

    private static int ay(Context context, int i) {
        AppMethodBeat.i(112493);
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = ((Activity) context).getResources().getDisplayMetrics();
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (displayMetrics != null && rect.height() > 0) {
                int height = displayMetrics.heightPixels - rect.height();
                ai.i("WeUIToolHelper", "[fixStatusBarHeight] new statusBar:%s ", Integer.valueOf(height));
                if (height > i && height - i < 100) {
                    ai.i("WeUIToolHelper", "[fixStatusBarHeight] return new statusBar:%s ", Integer.valueOf(height));
                    AppMethodBeat.o(112493);
                    return height;
                }
            }
        }
        AppMethodBeat.o(112493);
        return i;
    }

    public static Point hy(Context context) {
        AppMethodBeat.i(112494);
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
                ai.printErrStackTrace("WeUIToolHelper", e, "getDisplayRealSize NoSuchMethodException", new Object[0]);
            } catch (IllegalAccessException e2) {
                ai.printErrStackTrace("WeUIToolHelper", e2, "getDisplayRealSize IllegalAccessException", new Object[0]);
            } catch (InvocationTargetException e3) {
                ai.printErrStackTrace("WeUIToolHelper", e3, "getDisplayRealSize InvocationTargetException", new Object[0]);
            }
        } else {
            defaultDisplay.getSize(point);
        }
        AppMethodBeat.o(112494);
        return point;
    }

    @TargetApi(17)
    public static boolean hw(Context context) {
        AppMethodBeat.i(112495);
        if (hx(context) > 0) {
            AppMethodBeat.o(112495);
            return true;
        }
        AppMethodBeat.o(112495);
        return false;
    }

    public static int hx(Context context) {
        AppMethodBeat.i(112496);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point hy = hy(context);
        int max = Math.max(point.y, point.x);
        int max2 = Math.max(hy.y, hy.x);
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            max = Math.max(rect.bottom, rect.right);
        }
        max = max2 - max;
        AppMethodBeat.o(112496);
        return max;
    }

    public static boolean hG(Context context) {
        AppMethodBeat.i(112497);
        if (!(context instanceof Activity)) {
            AppMethodBeat.o(112497);
            return true;
        } else if ((((Activity) context).getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            AppMethodBeat.o(112497);
            return true;
        } else {
            AppMethodBeat.o(112497);
            return false;
        }
    }

    public static int fr(Context context) {
        int i = 0;
        AppMethodBeat.i(112498);
        if (hw(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i = Resources.getSystem().getDimensionPixelSize(identifier);
            }
            identifier = hx(context);
            if (identifier != 0 && identifier < r0) {
                i = identifier;
            }
            AppMethodBeat.o(112498);
        } else {
            AppMethodBeat.o(112498);
        }
        return i;
    }
}
