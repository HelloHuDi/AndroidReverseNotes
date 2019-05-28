package com.tencent.p177mm.plugin.appbrand.p329s;

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
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.plugin.appbrand.s.w */
public final class C10732w {
    private static float density = -1.0f;
    private static final Method iRT;

    /* renamed from: bx */
    public static int m18401bx(String str, int i) {
        AppMethodBeat.m2504i(87431);
        int z = (int) C10732w.m18407z(str, (long) i);
        AppMethodBeat.m2505o(87431);
        return z;
    }

    /* renamed from: z */
    private static long m18407z(String str, long j) {
        AppMethodBeat.m2504i(87432);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(87432);
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
            AppMethodBeat.m2505o(87432);
            return j;
        } catch (Exception e) {
            AppMethodBeat.m2505o(87432);
            return j;
        }
    }

    static {
        Method method = null;
        AppMethodBeat.m2504i(87438);
        if (VERSION.SDK_INT >= 24) {
            try {
                method = Activity.class.getMethod("isInMultiWindowMode", new Class[0]);
            } catch (Exception e) {
            }
        }
        iRT = method;
        AppMethodBeat.m2505o(87438);
    }

    /* renamed from: ct */
    public static boolean m18402ct(View view) {
        AppMethodBeat.m2504i(87433);
        if (VERSION.SDK_INT < 24) {
            AppMethodBeat.m2505o(87433);
            return false;
        } else if (view == null) {
            AppMethodBeat.m2505o(87433);
            return false;
        } else {
            Context context = view.getContext();
            if ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if ((context instanceof Activity) && C10732w.m18406u((Activity) context)) {
                AppMethodBeat.m2505o(87433);
                return true;
            }
            AppMethodBeat.m2505o(87433);
            return false;
        }
    }

    /* renamed from: u */
    private static boolean m18406u(Activity activity) {
        AppMethodBeat.m2504i(87434);
        try {
            Method method = iRT;
            if (method != null) {
                method.setAccessible(true);
                boolean booleanValue = ((Boolean) method.invoke(activity, new Object[0])).booleanValue();
                AppMethodBeat.m2505o(87434);
                return booleanValue;
            }
            C4990ab.m7410d("UIUtil", "isInMultiWindowMode method null");
            AppMethodBeat.m2505o(87434);
            return false;
        } catch (Exception e) {
            C4990ab.m7411d("UIUtil", "isInMultiWindowMode, exp %s", e);
        }
    }

    /* renamed from: db */
    public static int[] m18404db(Context context) {
        AppMethodBeat.m2504i(87435);
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        AppMethodBeat.m2505o(87435);
        return r1;
    }

    /* renamed from: d */
    public static int[] m18403d(C33327h c33327h) {
        AppMethodBeat.m2504i(87437);
        int[] iArr;
        if (c33327h.getRuntime().gNE.isLaidOut()) {
            iArr = new int[]{c33327h.getRuntime().gNE.getMeasuredWidth(), c33327h.getRuntime().gNE.getMeasuredHeight()};
            AppMethodBeat.m2505o(87437);
            return iArr;
        }
        DisplayMetrics displayMetrics = c33327h.getContext().getResources().getDisplayMetrics();
        iArr = new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        AppMethodBeat.m2505o(87437);
        return iArr;
    }

    /* renamed from: h */
    public static int[] m18405h(C38492q c38492q) {
        View view;
        AppMethodBeat.m2504i(87436);
        C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView == null) {
            view = null;
        } else {
            view = currentPageView.aBk();
        }
        int[] iArr;
        if (view != null && view.isLaidOut()) {
            C4990ab.m7416i("UIUtil", "Method: normal");
            iArr = new int[]{view.getWidth(), view.getHeight()};
            AppMethodBeat.m2505o(87436);
            return iArr;
        } else if (c38492q.getContext() instanceof Activity) {
            C4990ab.m7416i("UIUtil", "Method: DecorView");
            ((Activity) c38492q.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            iArr = new int[]{r1.right - r1.left, (r1.bottom - r1.top) - C1338a.fromDPToPix(c38492q.getContext(), 48)};
            AppMethodBeat.m2505o(87436);
            return iArr;
        } else {
            C4990ab.m7416i("UIUtil", "Method: Screen");
            iArr = new int[]{c38492q.getContext().getResources().getDisplayMetrics().widthPixels, c38492q.getContext().getResources().getDisplayMetrics().heightPixels};
            AppMethodBeat.m2505o(87436);
            return iArr;
        }
    }
}
