package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.widget.j;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.h.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class ae {
    public static String yqJ = "has_cutout";
    private static Rect yqK = new Rect(0, 0, 0, 0);
    private static boolean yqL = false;
    private static SparseArray<WindowInsets> yqM = new SparseArray(4);
    private static SparseArray<Rect> yqN = new SparseArray(4);
    private static final Object yqO = new Object();

    static {
        AppMethodBeat.i(65415);
        AppMethodBeat.o(65415);
    }

    @TargetApi(21)
    public static ViewGroup a(Window window, View view) {
        ViewGroup viewGroup = null;
        AppMethodBeat.i(65388);
        if (window == null) {
            AppMethodBeat.o(65388);
            return null;
        }
        ViewGroup e = e(window);
        if (e != null) {
            AppMethodBeat.o(65388);
            return e;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            while (parent != window.getDecorView() && parent != null) {
                ViewParent viewGroup2 = parent;
                parent = parent.getParent();
            }
            e = viewGroup2;
        } else {
            e = null;
        }
        if (e == null) {
            View childAt = ((ViewGroup) window.getDecorView()).getChildAt(0);
            if (childAt instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) childAt;
                AppMethodBeat.o(65388);
                return viewGroup2;
            } else if (VERSION.SDK_INT >= 21) {
                window.clearFlags(j.INVALID_ID);
            }
        }
        viewGroup2 = e;
        AppMethodBeat.o(65388);
        return viewGroup2;
    }

    private static ViewGroup e(Window window) {
        AppMethodBeat.i(65389);
        if (VERSION.SDK_INT >= 21) {
            c cVar = new c(window, "mContentRoot", null);
            if (cVar.Mg()) {
                try {
                    ViewGroup viewGroup = (ViewGroup) cVar.get();
                    AppMethodBeat.o(65389);
                    return viewGroup;
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
                    ab.printErrStackTrace("MicroMsg.UIUtils", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(65389);
        return null;
    }

    @TargetApi(20)
    public static boolean h(final View view, final View view2) {
        AppMethodBeat.i(65390);
        if (!d.iW(21)) {
            AppMethodBeat.o(65390);
            return true;
        } else if (view == null || !(view instanceof ViewGroup) || view2 == null || !(view.getLayoutParams() instanceof MarginLayoutParams)) {
            AppMethodBeat.o(65390);
            return false;
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    AppMethodBeat.i(65385);
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                    ae.J(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                    AppMethodBeat.o(65385);
                    return onApplyWindowInsets;
                }
            });
            AppMethodBeat.o(65390);
            return true;
        }
    }

    public static void J(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(65391);
        yqK.set(i, i2, i3, i4);
        AppMethodBeat.o(65391);
    }

    public static Rect dze() {
        return yqK;
    }

    public static int fr(Context context) {
        int i = 0;
        AppMethodBeat.i(65392);
        if (hw(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i = Resources.getSystem().getDimensionPixelSize(identifier);
            }
            AppMethodBeat.o(65392);
        } else {
            AppMethodBeat.o(65392);
        }
        return i;
    }

    @TargetApi(17)
    public static boolean hw(Context context) {
        AppMethodBeat.i(65393);
        if (hx(context) > 0) {
            AppMethodBeat.o(65393);
            return true;
        }
        AppMethodBeat.o(65393);
        return false;
    }

    private static int hx(Context context) {
        AppMethodBeat.i(65394);
        if (context == null) {
            AppMethodBeat.o(65394);
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            ab.e("MicroMsg.UIUtils", "getRealBottomHeight, get NULL windowManager");
            AppMethodBeat.o(65394);
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point hy = hy(context);
        int max = Math.max(point.y, point.x);
        int max2 = Math.max(hy.y, hy.x);
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            max = Math.max(rect.bottom - rect.top, rect.right - rect.left);
        }
        max = max2 - max;
        AppMethodBeat.o(65394);
        return max;
    }

    public static Point hy(Context context) {
        AppMethodBeat.i(65395);
        Point point = new Point();
        if (context == null) {
            AppMethodBeat.o(65395);
            return point;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            if (VERSION.SDK_INT >= 14) {
                try {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception e) {
                }
            }
            defaultDisplay.getSize(point);
        }
        AppMethodBeat.o(65395);
        return point;
    }

    public static void a(Window window) {
        AppMethodBeat.i(65396);
        if (window == null) {
            AppMethodBeat.o(65396);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.o(65396);
    }

    public static void m(Activity activity, int i) {
        AppMethodBeat.i(65397);
        if (activity == null) {
            AppMethodBeat.o(65397);
            return;
        }
        try {
            if (activity.getWindow() == null) {
                AppMethodBeat.o(65397);
                return;
            }
            if (VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(j.INVALID_ID);
                activity.getWindow().setStatusBarColor(i);
            }
            AppMethodBeat.o(65397);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.UIUtils", th, "", new Object[0]);
            AppMethodBeat.o(65397);
        }
    }

    public static void hz(Context context) {
        AppMethodBeat.i(65398);
        if (context instanceof Activity) {
            m((Activity) context, -1);
        }
        AppMethodBeat.o(65398);
    }

    public static void f(Window window) {
        AppMethodBeat.i(65399);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(65399);
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | Utility.DEFAULT_STREAM_BUFFER_SIZE);
        }
        AppMethodBeat.o(65399);
    }

    public static int Jj(int i) {
        return ((((((int) ((((float) ((i >> 24) & 255)) * 0.78f) + 56.100006f)) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * 0.78f) + 0.0f)) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * 0.78f) + 0.0f)) & 255) << 8)) | ((((int) ((((float) (i & 255)) * 0.78f) + 0.0f)) & 255) << 0);
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.i(65400);
        int hB = hB(context);
        AppMethodBeat.o(65400);
        return hB;
    }

    public static int hA(Context context) {
        AppMethodBeat.i(65401);
        int hB = hB(context);
        int height;
        if (hB > 0) {
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (rect.top > hB) {
                ab.w("MicroMsg.UIUtils", "[fixStatusBarHeight] top:%s statusHeight:%s", Integer.valueOf(rect.top), Integer.valueOf(hB));
                AppMethodBeat.o(65401);
                return 0;
            }
            AppMethodBeat.o(65401);
            return hB;
        } else if (context instanceof Activity) {
            Rect rect2 = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            height = ((Activity) context).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) context).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height - rect2.height() < 0 || iArr[1] <= 200) {
                height = rect2.top;
                AppMethodBeat.o(65401);
                return height;
            }
            height -= rect2.height();
            AppMethodBeat.o(65401);
            return height;
        } else {
            height = a.fromDPToPix(context, 20);
            AppMethodBeat.o(65401);
            return height;
        }
    }

    public static int hB(Context context) {
        int i = 0;
        AppMethodBeat.i(65402);
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(bo.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        AppMethodBeat.o(65402);
        return i;
    }

    public static boolean hD(Context context) {
        AppMethodBeat.i(65404);
        boolean A = A(context, false);
        AppMethodBeat.o(65404);
        return A;
    }

    private static boolean A(Context context, boolean z) {
        boolean z2;
        AppMethodBeat.i(65405);
        if (e.hb(context) || com.tencent.mm.sdk.h.d.ha(context) || com.tencent.mm.sdk.h.a.gZ(context) || B(context, z)) {
            z2 = true;
        } else {
            z2 = false;
        }
        ab.i("MicroMsg.UIUtils", "hasCutOut:%s", Boolean.valueOf(z2));
        AppMethodBeat.o(65405);
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized Rect d(Activity activity, int i, int i2) {
        Rect rect;
        Object obj = 1;
        synchronized (ae.class) {
            AppMethodBeat.i(65406);
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (yqN.get(rotation) != null) {
                rect = (Rect) yqN.get(rotation);
                AppMethodBeat.o(65406);
            } else if (activity.getWindow() == null) {
                AppMethodBeat.o(65406);
                rect = null;
            } else {
                if (A(activity, true)) {
                    if (VERSION.SDK_INT >= 28) {
                        WindowInsets windowInsets = (WindowInsets) yqM.get(rotation);
                        if (!(windowInsets == null || windowInsets.getDisplayCutout() == null)) {
                            rect = new Rect(windowInsets.getDisplayCutout().getSafeInsetLeft(), windowInsets.getDisplayCutout().getSafeInsetTop(), i - windowInsets.getDisplayCutout().getSafeInsetRight(), i2 - windowInsets.getDisplayCutout().getSafeInsetBottom());
                            if (obj == null) {
                                int hB = hB(activity);
                                switch (rotation) {
                                    case 0:
                                        rect = new Rect(0, hB, i, i2);
                                        break;
                                    case 1:
                                        rect = new Rect(hB, 0, i, i2);
                                        break;
                                    case 2:
                                        rect = new Rect(0, 0, i, i2 - hB);
                                        break;
                                    case 3:
                                        rect = new Rect(0, 0, i - hB, i2);
                                        break;
                                    default:
                                        rect = new Rect(0, 0, i, i2);
                                        break;
                                }
                            }
                        }
                    }
                    obj = null;
                    rect = null;
                    if (obj == null) {
                    }
                } else {
                    rect = new Rect(0, 0, i, i2);
                }
                yqN.put(rotation, rect);
                AppMethodBeat.o(65406);
            }
        }
        return rect;
    }

    @TargetApi(28)
    private static boolean B(Context context, boolean z) {
        boolean z2;
        AppMethodBeat.i(65407);
        if (context == null) {
            AppMethodBeat.o(65407);
            return false;
        }
        if (VERSION.SDK_INT >= 28) {
            yqL = as.amF(ah.doA()).getBoolean(yqJ, false);
            final View decorView = ((Activity) context).getWindow().getDecorView();
            final int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
            synchronized (yqO) {
                try {
                    WindowInsets windowInsets = (WindowInsets) yqM.get(rotation);
                    if (windowInsets == null) {
                        if (al.isMainThread() && decorView.isAttachedToWindow()) {
                            windowInsets = decorView.getRootWindowInsets();
                            yqM.put(rotation, decorView.getRootWindowInsets());
                        } else {
                            if (z) {
                                if (!al.isMainThread() && decorView.isAttachedToWindow()) {
                                    windowInsets = (WindowInsets) new bj<WindowInsets>() {
                                        public final /* synthetic */ Object run() {
                                            AppMethodBeat.i(65386);
                                            WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                                            AppMethodBeat.o(65386);
                                            return rootWindowInsets;
                                        }
                                    }.b(new ak(Looper.getMainLooper()));
                                    yqM.put(rotation, windowInsets);
                                }
                            }
                            decorView.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                    AppMethodBeat.i(65387);
                                    synchronized (ae.yqO) {
                                        try {
                                            ae.yqM.put(rotation, decorView.getRootWindowInsets());
                                            if (decorView.getRootWindowInsets() != null) {
                                                DisplayCutout displayCutout = decorView.getRootWindowInsets().getDisplayCutout();
                                                if (displayCutout != null) {
                                                    List boundingRects = displayCutout.getBoundingRects();
                                                    if (boundingRects != null && boundingRects.size() > 0) {
                                                        ae.yqL = true;
                                                        as.amF(ah.doA()).putBoolean(ae.yqJ, ae.yqL);
                                                    }
                                                }
                                            }
                                        } finally {
                                            while (true) {
                                            }
                                            AppMethodBeat.o(65387);
                                        }
                                    }
                                    decorView.setOnApplyWindowInsetsListener(null);
                                    WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                                    return onApplyWindowInsets;
                                }
                            });
                            z2 = yqL;
                        }
                    }
                    if (windowInsets != null) {
                        DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                        if (displayCutout != null) {
                            List boundingRects = displayCutout.getBoundingRects();
                            if (boundingRects != null && boundingRects.size() > 0) {
                                yqL = true;
                                as.amF(ah.doA()).putBoolean(yqJ, yqL);
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(65407);
                }
            }
        } else {
            yqL = context.getPackageManager().hasSystemFeature("android.hardware.notch_support");
        }
        z2 = yqL;
        AppMethodBeat.o(65407);
        return z2;
        return z2;
    }

    private static int[] e(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(65408);
        int[] iArr = new int[(i * i2)];
        Bitmap.createScaledBitmap(bitmap, i, i2, false).getPixels(iArr, 0, i, 0, 0, i, i2);
        AppMethodBeat.o(65408);
        return iArr;
    }

    private static List<float[]> b(float[][] fArr) {
        int i;
        List list;
        int i2 = 1;
        AppMethodBeat.i(65409);
        int[] iArr = new int[8];
        SparseArray sparseArray = new SparseArray();
        for (i = 0; i < fArr.length; i++) {
            int i3 = 1;
            while (i3 <= 7) {
                if (fArr[i][0] < 360.0f * (((float) i3) / 7.0f)) {
                    iArr[i3] = iArr[i3] + 1;
                    list = (List) sparseArray.get(i3);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fArr[i]);
                    sparseArray.put(i3, list);
                } else {
                    i3++;
                }
            }
        }
        i = -1;
        int i4 = 0;
        while (i2 <= 7) {
            if (iArr[i2] > i4) {
                i4 = iArr[i2];
                i = i2;
            }
            i2++;
        }
        list = (List) sparseArray.get(i, new ArrayList());
        AppMethodBeat.o(65409);
        return list;
    }

    private static float[] f(List<float[]> list, int i, int i2) {
        AppMethodBeat.i(65410);
        float[] fArr;
        if (list.size() > Math.max(i, i2)) {
            float[] fArr2 = null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (((float[]) list.get(i3))[2] < Float.MAX_VALUE) {
                    fArr = (float[]) list.get(i3);
                } else {
                    fArr = fArr2;
                }
                i3++;
                fArr2 = fArr;
            }
            if (((double) fArr2[2]) <= 0.15d) {
                AppMethodBeat.o(65410);
                return fArr2;
            }
            if (((double) fArr2[1]) > 0.5d) {
                fArr2[1] = fArr2[1] - 0.1f;
            }
            fArr2[2] = fArr2[2] - 0.1f;
            AppMethodBeat.o(65410);
            return fArr2;
        }
        fArr = (float[]) list.get(0);
        fArr[2] = 0.15f;
        AppMethodBeat.o(65410);
        return fArr;
    }

    private static float[][] g(int[] iArr, int i, int i2) {
        AppMethodBeat.i(65411);
        float[][] fArr = new float[(i * i2)][];
        int i3 = i * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            float[] fArr2 = new float[3];
            Color.colorToHSV(iArr[i4], fArr2);
            fArr[i4] = fArr2;
        }
        AppMethodBeat.o(65411);
        return fArr;
    }

    public static int[] ao(Bitmap bitmap) {
        AppMethodBeat.i(65412);
        int[] f = f(bitmap, 4, 4);
        AppMethodBeat.o(65412);
        return f;
    }

    public static int[] f(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(65413);
        float[] f = f(b(g(e(bitmap, i, i2), i, i2)), i, i2);
        float[] fArr = new float[3];
        if (((double) f[2]) <= 0.15d) {
            fArr[0] = f[0];
            fArr[1] = f[1];
            fArr[2] = f[2] + 0.7f;
        } else {
            fArr[0] = f[0];
            fArr[1] = f[1];
            if (((double) f[2]) + 0.5d >= 1.0d) {
                fArr[2] = f[2] - 0.5f;
            } else {
                fArr[2] = f[2] + 0.5f;
            }
        }
        if (fArr[1] > 0.5f) {
            fArr[1] = fArr[1] - 0.1f;
        }
        int[] iArr = new int[]{Color.HSVToColor(f), Color.HSVToColor(fArr)};
        AppMethodBeat.o(65413);
        return iArr;
    }

    public static boolean dzf() {
        AppMethodBeat.i(65414);
        if (dzh() == 0) {
            AppMethodBeat.o(65414);
            return false;
        } else if (dzh() == dMx()) {
            DisplayMetrics dMw = dMw();
            if (Math.round(((float) Math.min(dMw.heightPixels, dMw.widthPixels)) / dMw.density) >= 650) {
                AppMethodBeat.o(65414);
                return true;
            }
            AppMethodBeat.o(65414);
            return false;
        } else if (Math.round(((float) getDeviceWidth()) / (((float) dzh()) / 160.0f)) >= 650) {
            AppMethodBeat.o(65414);
            return true;
        } else {
            AppMethodBeat.o(65414);
            return false;
        }
    }

    public static boolean dzg() {
        AppMethodBeat.i(138425);
        if (dzh() == 0) {
            AppMethodBeat.o(138425);
            return false;
        } else if (dzh() == dMx()) {
            DisplayMetrics dMw = dMw();
            if (Math.round(((float) Math.min(dMw.heightPixels, dMw.widthPixels)) / dMw.density) >= com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX) {
                AppMethodBeat.o(138425);
                return true;
            }
            AppMethodBeat.o(138425);
            return false;
        } else if (Math.round(((float) getDeviceWidth()) / (((float) dzh()) / 160.0f)) >= com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX) {
            AppMethodBeat.o(138425);
            return true;
        } else {
            AppMethodBeat.o(138425);
            return false;
        }
    }

    public static DisplayMetrics dMw() {
        AppMethodBeat.i(139015);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        AppMethodBeat.o(139015);
        return displayMetrics;
    }

    public static int dzh() {
        Integer num;
        AppMethodBeat.i(138253);
        Integer valueOf = Integer.valueOf(0);
        try {
            Method declaredMethod = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getInitialDisplayDensity", new Class[]{Integer.TYPE});
            declaredMethod2.setAccessible(true);
            num = (Integer) declaredMethod2.invoke(invoke, new Object[]{Integer.valueOf(0)});
        } catch (Exception e) {
            ab.e("MicroMsg.UIUtils", "Exception:%s", e);
            num = valueOf;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(138253);
        return intValue;
    }

    public static int dMx() {
        AppMethodBeat.i(139016);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.densityDpi;
        AppMethodBeat.o(139016);
        return i;
    }

    public static int getDeviceWidth() {
        int i = 0;
        AppMethodBeat.i(138254);
        try {
            Method declaredMethod = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getInitialDisplaySize", new Class[]{Integer.TYPE, Point.class});
            declaredMethod2.setAccessible(true);
            Point point = new Point();
            declaredMethod2.invoke(invoke, new Object[]{Integer.valueOf(0), point});
            i = Math.min(point.x, point.y);
        } catch (Exception e) {
            ab.e("MicroMsg.UIUtils", "Exception:%s", e);
        }
        AppMethodBeat.o(138254);
        return i;
    }

    public static int hC(Context context) {
        AppMethodBeat.i(65403);
        int hB = hB(context);
        AppMethodBeat.o(65403);
        return hB;
    }
}
