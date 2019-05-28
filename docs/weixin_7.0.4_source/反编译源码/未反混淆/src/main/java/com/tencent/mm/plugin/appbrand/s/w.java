package com.tencent.mm.plugin.appbrand.s;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Method;

public final class w {
    private static float density = -1.0f;
    private static final Method iRT;

    public static int bx(String str, int i) {
        AppMethodBeat.i(87431);
        int z = (int) z(str, (long) i);
        AppMethodBeat.o(87431);
        return z;
    }

    private static long z(String str, long j) {
        AppMethodBeat.i(87432);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(87432);
            return j;
        }
        if (str.startsWith("#") && str.length() == 4) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.insert(2, str.charAt(1));
            stringBuilder.insert(4, str.charAt(2));
            stringBuilder.insert(6, str.charAt(3));
            str = stringBuilder.toString();
        }
        try {
            j = 4294967295L & ((long) Color.parseColor(str));
            AppMethodBeat.o(87432);
            return j;
        } catch (Exception e) {
            AppMethodBeat.o(87432);
            return j;
        }
    }

    static {
        Method method = null;
        AppMethodBeat.i(87438);
        if (VERSION.SDK_INT >= 24) {
            try {
                method = Activity.class.getMethod("isInMultiWindowMode", new Class[0]);
            } catch (Exception e) {
            }
        }
        iRT = method;
        AppMethodBeat.o(87438);
    }

    public static boolean ct(View view) {
        AppMethodBeat.i(87433);
        if (VERSION.SDK_INT < 24) {
            AppMethodBeat.o(87433);
            return false;
        } else if (view == null) {
            AppMethodBeat.o(87433);
            return false;
        } else {
            Context context = view.getContext();
            if ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if ((context instanceof Activity) && u((Activity) context)) {
                AppMethodBeat.o(87433);
                return true;
            }
            AppMethodBeat.o(87433);
            return false;
        }
    }

    private static boolean u(Activity activity) {
        AppMethodBeat.i(87434);
        try {
            Method method = iRT;
            if (method != null) {
                method.setAccessible(true);
                boolean booleanValue = ((Boolean) method.invoke(activity, new Object[0])).booleanValue();
                AppMethodBeat.o(87434);
                return booleanValue;
            }
            ab.d("UIUtil", "isInMultiWindowMode method null");
            AppMethodBeat.o(87434);
            return false;
        } catch (Exception e) {
            ab.d("UIUtil", "isInMultiWindowMode, exp %s", e);
        }
    }

    public static int[] db(Context context) {
        AppMethodBeat.i(87435);
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        AppMethodBeat.o(87435);
        return r1;
    }

    public static int[] d(h hVar) {
        AppMethodBeat.i(87437);
        int[] iArr;
        if (hVar.getRuntime().gNE.isLaidOut()) {
            iArr = new int[]{hVar.getRuntime().gNE.getMeasuredWidth(), hVar.getRuntime().gNE.getMeasuredHeight()};
            AppMethodBeat.o(87437);
            return iArr;
        }
        DisplayMetrics displayMetrics = hVar.getContext().getResources().getDisplayMetrics();
        iArr = new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        AppMethodBeat.o(87437);
        return iArr;
    }

    public static int[] h(q qVar) {
        View view;
        AppMethodBeat.i(87436);
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView == null) {
            view = null;
        } else {
            view = currentPageView.aBk();
        }
        int[] iArr;
        if (view != null && view.isLaidOut()) {
            ab.i("UIUtil", "Method: normal");
            iArr = new int[]{view.getWidth(), view.getHeight()};
            AppMethodBeat.o(87436);
            return iArr;
        } else if (qVar.getContext() instanceof Activity) {
            ab.i("UIUtil", "Method: DecorView");
            ((Activity) qVar.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            iArr = new int[]{r1.right - r1.left, (r1.bottom - r1.top) - a.fromDPToPix(qVar.getContext(), 48)};
            AppMethodBeat.o(87436);
            return iArr;
        } else {
            ab.i("UIUtil", "Method: Screen");
            iArr = new int[]{qVar.getContext().getResources().getDisplayMetrics().widthPixels, qVar.getContext().getResources().getDisplayMetrics().heightPixels};
            AppMethodBeat.o(87436);
            return iArr;
        }
    }
}
