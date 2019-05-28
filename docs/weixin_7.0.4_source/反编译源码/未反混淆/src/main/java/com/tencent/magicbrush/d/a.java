package com.tencent.magicbrush.d;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static float bUz = -1.0f;

    public static float getDensity(Context context) {
        AppMethodBeat.i(116006);
        if (bUz < 0.0f) {
            bUz = context.getResources().getDisplayMetrics().density;
        }
        float f = bUz;
        AppMethodBeat.o(116006);
        return f;
    }

    private static int v(Context context, int i) {
        AppMethodBeat.i(116007);
        int ceil = (int) Math.ceil((double) (((float) i) / getDensity(context)));
        AppMethodBeat.o(116007);
        return ceil;
    }

    public static Point aA(Context context) {
        Point point;
        AppMethodBeat.i(116008);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point2 = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealSize(point2);
            if (!(point2.x == 0 || point2.y == 0)) {
                point = point2;
                point.x = v(context, point.x);
                point.y = v(context, point.y);
                AppMethodBeat.o(116008);
                return point;
            }
        }
        point2.x = context.getResources().getDisplayMetrics().widthPixels;
        point2.y = context.getResources().getDisplayMetrics().heightPixels;
        point = point2;
        point.x = v(context, point.x);
        point.y = v(context, point.y);
        AppMethodBeat.o(116008);
        return point;
    }
}
