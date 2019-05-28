package com.tencent.magicbrush.p821d;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.d.a */
public final class C8881a {
    private static float bUz = -1.0f;

    public static float getDensity(Context context) {
        AppMethodBeat.m2504i(116006);
        if (bUz < 0.0f) {
            bUz = context.getResources().getDisplayMetrics().density;
        }
        float f = bUz;
        AppMethodBeat.m2505o(116006);
        return f;
    }

    /* renamed from: v */
    private static int m15857v(Context context, int i) {
        AppMethodBeat.m2504i(116007);
        int ceil = (int) Math.ceil((double) (((float) i) / C8881a.getDensity(context)));
        AppMethodBeat.m2505o(116007);
        return ceil;
    }

    /* renamed from: aA */
    public static Point m15856aA(Context context) {
        Point point;
        AppMethodBeat.m2504i(116008);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point2 = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealSize(point2);
            if (!(point2.x == 0 || point2.y == 0)) {
                point = point2;
                point.x = C8881a.m15857v(context, point.x);
                point.y = C8881a.m15857v(context, point.y);
                AppMethodBeat.m2505o(116008);
                return point;
            }
        }
        point2.x = context.getResources().getDisplayMetrics().widthPixels;
        point2.y = context.getResources().getDisplayMetrics().heightPixels;
        point = point2;
        point.x = C8881a.m15857v(context, point.x);
        point.y = C8881a.m15857v(context, point.y);
        AppMethodBeat.m2505o(116008);
        return point;
    }
}
