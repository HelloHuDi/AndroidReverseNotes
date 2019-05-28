package com.tencent.p177mm.p612ui;

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
import android.support.p057v4.widget.C8415j;
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
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C16657e;
import com.tencent.p177mm.sdk.p609h.C4970a;
import com.tencent.p177mm.sdk.p609h.C4973d;
import com.tencent.p177mm.sdk.p609h.C4974e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.ae */
public final class C5222ae {
    public static String yqJ = "has_cutout";
    private static Rect yqK = new Rect(0, 0, 0, 0);
    private static boolean yqL = false;
    private static SparseArray<WindowInsets> yqM = new SparseArray(4);
    private static SparseArray<Rect> yqN = new SparseArray(4);
    private static final Object yqO = new Object();

    static {
        AppMethodBeat.m2504i(65415);
        AppMethodBeat.m2505o(65415);
    }

    @TargetApi(21)
    /* renamed from: a */
    public static ViewGroup m7934a(Window window, View view) {
        ViewGroup viewGroup = null;
        AppMethodBeat.m2504i(65388);
        if (window == null) {
            AppMethodBeat.m2505o(65388);
            return null;
        }
        ViewGroup e = C5222ae.m7939e(window);
        if (e != null) {
            AppMethodBeat.m2505o(65388);
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
                AppMethodBeat.m2505o(65388);
                return viewGroup2;
            } else if (VERSION.SDK_INT >= 21) {
                window.clearFlags(C8415j.INVALID_ID);
            }
        }
        viewGroup2 = e;
        AppMethodBeat.m2505o(65388);
        return viewGroup2;
    }

    /* renamed from: e */
    private static ViewGroup m7939e(Window window) {
        AppMethodBeat.m2504i(65389);
        if (VERSION.SDK_INT >= 21) {
            C1438c c1438c = new C1438c(window, "mContentRoot", null);
            if (c1438c.mo4891Mg()) {
                try {
                    ViewGroup viewGroup = (ViewGroup) c1438c.get();
                    AppMethodBeat.m2505o(65389);
                    return viewGroup;
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
                    C4990ab.printErrStackTrace("MicroMsg.UIUtils", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(65389);
        return null;
    }

    @TargetApi(20)
    /* renamed from: h */
    public static boolean m7946h(final View view, final View view2) {
        AppMethodBeat.m2504i(65390);
        if (!C1443d.m3068iW(21)) {
            AppMethodBeat.m2505o(65390);
            return true;
        } else if (view == null || !(view instanceof ViewGroup) || view2 == null || !(view.getLayoutParams() instanceof MarginLayoutParams)) {
            AppMethodBeat.m2505o(65390);
            return false;
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    AppMethodBeat.m2504i(65385);
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                    C5222ae.m7931J(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                    AppMethodBeat.m2505o(65385);
                    return onApplyWindowInsets;
                }
            });
            AppMethodBeat.m2505o(65390);
            return true;
        }
    }

    /* renamed from: J */
    public static void m7931J(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(65391);
        yqK.set(i, i2, i3, i4);
        AppMethodBeat.m2505o(65391);
    }

    public static Rect dze() {
        return yqK;
    }

    /* renamed from: fr */
    public static int m7944fr(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(65392);
        if (C5222ae.m7951hw(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i = Resources.getSystem().getDimensionPixelSize(identifier);
            }
            AppMethodBeat.m2505o(65392);
        } else {
            AppMethodBeat.m2505o(65392);
        }
        return i;
    }

    @TargetApi(17)
    /* renamed from: hw */
    public static boolean m7951hw(Context context) {
        AppMethodBeat.m2504i(65393);
        if (C5222ae.m7952hx(context) > 0) {
            AppMethodBeat.m2505o(65393);
            return true;
        }
        AppMethodBeat.m2505o(65393);
        return false;
    }

    /* renamed from: hx */
    private static int m7952hx(Context context) {
        AppMethodBeat.m2504i(65394);
        if (context == null) {
            AppMethodBeat.m2505o(65394);
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            C4990ab.m7412e("MicroMsg.UIUtils", "getRealBottomHeight, get NULL windowManager");
            AppMethodBeat.m2505o(65394);
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point hy = C5222ae.m7953hy(context);
        int max = Math.max(point.y, point.x);
        int max2 = Math.max(hy.y, hy.x);
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            max = Math.max(rect.bottom - rect.top, rect.right - rect.left);
        }
        max = max2 - max;
        AppMethodBeat.m2505o(65394);
        return max;
    }

    /* renamed from: hy */
    public static Point m7953hy(Context context) {
        AppMethodBeat.m2504i(65395);
        Point point = new Point();
        if (context == null) {
            AppMethodBeat.m2505o(65395);
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
        AppMethodBeat.m2505o(65395);
        return point;
    }

    /* renamed from: a */
    public static void m7935a(Window window) {
        AppMethodBeat.m2504i(65396);
        if (window == null) {
            AppMethodBeat.m2505o(65396);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.m2505o(65396);
    }

    /* renamed from: m */
    public static void m7955m(Activity activity, int i) {
        AppMethodBeat.m2504i(65397);
        if (activity == null) {
            AppMethodBeat.m2505o(65397);
            return;
        }
        try {
            if (activity.getWindow() == null) {
                AppMethodBeat.m2505o(65397);
                return;
            }
            if (VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(C8415j.INVALID_ID);
                activity.getWindow().setStatusBarColor(i);
            }
            AppMethodBeat.m2505o(65397);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.UIUtils", th, "", new Object[0]);
            AppMethodBeat.m2505o(65397);
        }
    }

    /* renamed from: hz */
    public static void m7954hz(Context context) {
        AppMethodBeat.m2504i(65398);
        if (context instanceof Activity) {
            C5222ae.m7955m((Activity) context, -1);
        }
        AppMethodBeat.m2505o(65398);
    }

    /* renamed from: f */
    public static void m7941f(Window window) {
        AppMethodBeat.m2504i(65399);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.m2505o(65399);
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | Utility.DEFAULT_STREAM_BUFFER_SIZE);
        }
        AppMethodBeat.m2505o(65399);
    }

    /* renamed from: Jj */
    public static int m7932Jj(int i) {
        return ((((((int) ((((float) ((i >> 24) & 255)) * 0.78f) + 56.100006f)) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * 0.78f) + 0.0f)) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * 0.78f) + 0.0f)) & 255) << 8)) | ((((int) ((((float) (i & 255)) * 0.78f) + 0.0f)) & 255) << 0);
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.m2504i(65400);
        int hB = C5222ae.m7948hB(context);
        AppMethodBeat.m2505o(65400);
        return hB;
    }

    /* renamed from: hA */
    public static int m7947hA(Context context) {
        AppMethodBeat.m2504i(65401);
        int hB = C5222ae.m7948hB(context);
        int height;
        if (hB > 0) {
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (rect.top > hB) {
                C4990ab.m7421w("MicroMsg.UIUtils", "[fixStatusBarHeight] top:%s statusHeight:%s", Integer.valueOf(rect.top), Integer.valueOf(hB));
                AppMethodBeat.m2505o(65401);
                return 0;
            }
            AppMethodBeat.m2505o(65401);
            return hB;
        } else if (context instanceof Activity) {
            Rect rect2 = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            height = ((Activity) context).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) context).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height - rect2.height() < 0 || iArr[1] <= 200) {
                height = rect2.top;
                AppMethodBeat.m2505o(65401);
                return height;
            }
            height -= rect2.height();
            AppMethodBeat.m2505o(65401);
            return height;
        } else {
            height = C1338a.fromDPToPix(context, 20);
            AppMethodBeat.m2505o(65401);
            return height;
        }
    }

    /* renamed from: hB */
    public static int m7948hB(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(65402);
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(C5046bo.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(65402);
        return i;
    }

    /* renamed from: hD */
    public static boolean m7950hD(Context context) {
        AppMethodBeat.m2504i(65404);
        boolean A = C5222ae.m7929A(context, false);
        AppMethodBeat.m2505o(65404);
        return A;
    }

    /* renamed from: A */
    private static boolean m7929A(Context context, boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(65405);
        if (C4974e.m7367hb(context) || C4973d.m7366ha(context) || C4970a.m7362gZ(context) || C5222ae.m7930B(context, z)) {
            z2 = true;
        } else {
            z2 = false;
        }
        C4990ab.m7417i("MicroMsg.UIUtils", "hasCutOut:%s", Boolean.valueOf(z2));
        AppMethodBeat.m2505o(65405);
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static synchronized Rect m7938d(Activity activity, int i, int i2) {
        Rect rect;
        Object obj = 1;
        synchronized (C5222ae.class) {
            AppMethodBeat.m2504i(65406);
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (yqN.get(rotation) != null) {
                rect = (Rect) yqN.get(rotation);
                AppMethodBeat.m2505o(65406);
            } else if (activity.getWindow() == null) {
                AppMethodBeat.m2505o(65406);
                rect = null;
            } else {
                if (C5222ae.m7929A(activity, true)) {
                    if (VERSION.SDK_INT >= 28) {
                        WindowInsets windowInsets = (WindowInsets) yqM.get(rotation);
                        if (!(windowInsets == null || windowInsets.getDisplayCutout() == null)) {
                            rect = new Rect(windowInsets.getDisplayCutout().getSafeInsetLeft(), windowInsets.getDisplayCutout().getSafeInsetTop(), i - windowInsets.getDisplayCutout().getSafeInsetRight(), i2 - windowInsets.getDisplayCutout().getSafeInsetBottom());
                            if (obj == null) {
                                int hB = C5222ae.m7948hB(activity);
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
                AppMethodBeat.m2505o(65406);
            }
        }
        return rect;
    }

    @TargetApi(28)
    /* renamed from: B */
    private static boolean m7930B(Context context, boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(65407);
        if (context == null) {
            AppMethodBeat.m2505o(65407);
            return false;
        }
        if (VERSION.SDK_INT >= 28) {
            yqL = C5018as.amF(C4996ah.doA()).getBoolean(yqJ, false);
            final View decorView = ((Activity) context).getWindow().getDecorView();
            final int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
            synchronized (yqO) {
                try {
                    WindowInsets windowInsets = (WindowInsets) yqM.get(rotation);
                    if (windowInsets == null) {
                        if (C5004al.isMainThread() && decorView.isAttachedToWindow()) {
                            windowInsets = decorView.getRootWindowInsets();
                            yqM.put(rotation, decorView.getRootWindowInsets());
                        } else {
                            if (z) {
                                if (!C5004al.isMainThread() && decorView.isAttachedToWindow()) {
                                    windowInsets = (WindowInsets) new C5039bj<WindowInsets>() {
                                        public final /* synthetic */ Object run() {
                                            AppMethodBeat.m2504i(65386);
                                            WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                                            AppMethodBeat.m2505o(65386);
                                            return rootWindowInsets;
                                        }
                                    }.mo10372b(new C7306ak(Looper.getMainLooper()));
                                    yqM.put(rotation, windowInsets);
                                }
                            }
                            decorView.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                    AppMethodBeat.m2504i(65387);
                                    synchronized (C5222ae.yqO) {
                                        try {
                                            C5222ae.yqM.put(rotation, decorView.getRootWindowInsets());
                                            if (decorView.getRootWindowInsets() != null) {
                                                DisplayCutout displayCutout = decorView.getRootWindowInsets().getDisplayCutout();
                                                if (displayCutout != null) {
                                                    List boundingRects = displayCutout.getBoundingRects();
                                                    if (boundingRects != null && boundingRects.size() > 0) {
                                                        C5222ae.yqL = true;
                                                        C5018as.amF(C4996ah.doA()).putBoolean(C5222ae.yqJ, C5222ae.yqL);
                                                    }
                                                }
                                            }
                                        } finally {
                                            while (true) {
                                            }
                                            AppMethodBeat.m2505o(65387);
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
                                C5018as.amF(C4996ah.doA()).putBoolean(yqJ, yqL);
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(65407);
                }
            }
        } else {
            yqL = context.getPackageManager().hasSystemFeature("android.hardware.notch_support");
        }
        z2 = yqL;
        AppMethodBeat.m2505o(65407);
        return z2;
        return z2;
    }

    /* renamed from: e */
    private static int[] m7940e(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(65408);
        int[] iArr = new int[(i * i2)];
        Bitmap.createScaledBitmap(bitmap, i, i2, false).getPixels(iArr, 0, i, 0, 0, i, i2);
        AppMethodBeat.m2505o(65408);
        return iArr;
    }

    /* renamed from: b */
    private static List<float[]> m7937b(float[][] fArr) {
        int i;
        List list;
        int i2 = 1;
        AppMethodBeat.m2504i(65409);
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
        AppMethodBeat.m2505o(65409);
        return list;
    }

    /* renamed from: f */
    private static float[] m7942f(List<float[]> list, int i, int i2) {
        AppMethodBeat.m2504i(65410);
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
                AppMethodBeat.m2505o(65410);
                return fArr2;
            }
            if (((double) fArr2[1]) > 0.5d) {
                fArr2[1] = fArr2[1] - 0.1f;
            }
            fArr2[2] = fArr2[2] - 0.1f;
            AppMethodBeat.m2505o(65410);
            return fArr2;
        }
        fArr = (float[]) list.get(0);
        fArr[2] = 0.15f;
        AppMethodBeat.m2505o(65410);
        return fArr;
    }

    /* renamed from: g */
    private static float[][] m7945g(int[] iArr, int i, int i2) {
        AppMethodBeat.m2504i(65411);
        float[][] fArr = new float[(i * i2)][];
        int i3 = i * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            float[] fArr2 = new float[3];
            Color.colorToHSV(iArr[i4], fArr2);
            fArr[i4] = fArr2;
        }
        AppMethodBeat.m2505o(65411);
        return fArr;
    }

    /* renamed from: ao */
    public static int[] m7936ao(Bitmap bitmap) {
        AppMethodBeat.m2504i(65412);
        int[] f = C5222ae.m7943f(bitmap, 4, 4);
        AppMethodBeat.m2505o(65412);
        return f;
    }

    /* renamed from: f */
    public static int[] m7943f(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(65413);
        float[] f = C5222ae.m7942f(C5222ae.m7937b(C5222ae.m7945g(C5222ae.m7940e(bitmap, i, i2), i, i2)), i, i2);
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
        AppMethodBeat.m2505o(65413);
        return iArr;
    }

    public static boolean dzf() {
        AppMethodBeat.m2504i(65414);
        if (C5222ae.dzh() == 0) {
            AppMethodBeat.m2505o(65414);
            return false;
        } else if (C5222ae.dzh() == C5222ae.dMx()) {
            DisplayMetrics dMw = C5222ae.dMw();
            if (Math.round(((float) Math.min(dMw.heightPixels, dMw.widthPixels)) / dMw.density) >= 650) {
                AppMethodBeat.m2505o(65414);
                return true;
            }
            AppMethodBeat.m2505o(65414);
            return false;
        } else if (Math.round(((float) C5222ae.getDeviceWidth()) / (((float) C5222ae.dzh()) / 160.0f)) >= 650) {
            AppMethodBeat.m2505o(65414);
            return true;
        } else {
            AppMethodBeat.m2505o(65414);
            return false;
        }
    }

    public static boolean dzg() {
        AppMethodBeat.m2504i(138425);
        if (C5222ae.dzh() == 0) {
            AppMethodBeat.m2505o(138425);
            return false;
        } else if (C5222ae.dzh() == C5222ae.dMx()) {
            DisplayMetrics dMw = C5222ae.dMw();
            if (Math.round(((float) Math.min(dMw.heightPixels, dMw.widthPixels)) / dMw.density) >= C16657e.CTRL_INDEX) {
                AppMethodBeat.m2505o(138425);
                return true;
            }
            AppMethodBeat.m2505o(138425);
            return false;
        } else if (Math.round(((float) C5222ae.getDeviceWidth()) / (((float) C5222ae.dzh()) / 160.0f)) >= C16657e.CTRL_INDEX) {
            AppMethodBeat.m2505o(138425);
            return true;
        } else {
            AppMethodBeat.m2505o(138425);
            return false;
        }
    }

    public static DisplayMetrics dMw() {
        AppMethodBeat.m2504i(139015);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        AppMethodBeat.m2505o(139015);
        return displayMetrics;
    }

    public static int dzh() {
        Integer num;
        AppMethodBeat.m2504i(138253);
        Integer valueOf = Integer.valueOf(0);
        try {
            Method declaredMethod = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getInitialDisplayDensity", new Class[]{Integer.TYPE});
            declaredMethod2.setAccessible(true);
            num = (Integer) declaredMethod2.invoke(invoke, new Object[]{Integer.valueOf(0)});
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.UIUtils", "Exception:%s", e);
            num = valueOf;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(138253);
        return intValue;
    }

    public static int dMx() {
        AppMethodBeat.m2504i(139016);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.densityDpi;
        AppMethodBeat.m2505o(139016);
        return i;
    }

    public static int getDeviceWidth() {
        int i = 0;
        AppMethodBeat.m2504i(138254);
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
            C4990ab.m7413e("MicroMsg.UIUtils", "Exception:%s", e);
        }
        AppMethodBeat.m2505o(138254);
        return i;
    }

    /* renamed from: hC */
    public static int m7949hC(Context context) {
        AppMethodBeat.m2504i(65403);
        int hB = C5222ae.m7948hB(context);
        AppMethodBeat.m2505o(65403);
        return hB;
    }
}
