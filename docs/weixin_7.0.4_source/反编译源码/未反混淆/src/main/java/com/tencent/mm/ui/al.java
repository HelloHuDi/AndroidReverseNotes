package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class al {
    public static Point hy(Context context) {
        AppMethodBeat.i(112499);
        Point point = new Point();
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
        AppMethodBeat.o(112499);
        return point;
    }

    @TargetApi(17)
    public static boolean hw(Context context) {
        AppMethodBeat.i(112500);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point hy = hy(context);
        if (Math.max(hy.y, hy.x) > Math.max(point.y, point.x)) {
            AppMethodBeat.o(112500);
            return true;
        }
        AppMethodBeat.o(112500);
        return false;
    }

    public static int la(String str) {
        int i = 0;
        AppMethodBeat.i(112501);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.decode(str).intValue();
                    AppMethodBeat.o(112501);
                    return i;
                }
            } catch (NumberFormatException e) {
                ai.printErrStackTrace("WeUIUtil", e, "", new Object[0]);
                AppMethodBeat.o(112501);
            }
        }
        AppMethodBeat.o(112501);
        return i;
    }
}
