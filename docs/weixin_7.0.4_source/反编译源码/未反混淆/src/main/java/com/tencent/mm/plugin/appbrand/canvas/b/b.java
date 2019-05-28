package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class b implements a {
    public final String getMethod() {
        return "arc";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(103664);
        if (jSONArray.length() < 5) {
            AppMethodBeat.o(103664);
            return false;
        }
        boolean a = a(path, g.d(jSONArray, 0), g.d(jSONArray, 1), g.d(jSONArray, 2), (float) jSONArray.optDouble(3), (float) jSONArray.optDouble(4), jSONArray.optBoolean(5));
        AppMethodBeat.o(103664);
        return a;
    }

    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(103665);
        if (basePathActionArg == null || !(basePathActionArg instanceof PathArcActionArg)) {
            AppMethodBeat.o(103665);
            return false;
        }
        PathArcActionArg pathArcActionArg = (PathArcActionArg) basePathActionArg;
        boolean a = a(path, pathArcActionArg.x, pathArcActionArg.y, pathArcActionArg.radius, pathArcActionArg.hcR, pathArcActionArg.hdt, pathArcActionArg.hdu);
        AppMethodBeat.o(103665);
        return a;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.i(103666);
        PathArcActionArg pathArcActionArg = new PathArcActionArg();
        AppMethodBeat.o(103666);
        return pathArcActionArg;
    }

    private static boolean a(Path path, float f, float f2, float f3, float f4, float f5, boolean z) {
        float f6;
        AppMethodBeat.i(103667);
        float f7 = f - f3;
        float f8 = f2 - f3;
        float f9 = f + f3;
        float f10 = f2 + f3;
        float toDegrees = (float) Math.toDegrees((double) f4);
        float toDegrees2 = (float) Math.toDegrees((double) f5);
        float f11 = (float) (360.0d / (6.283185307179586d * ((double) f3)));
        if (z) {
            if (toDegrees - toDegrees2 >= 360.0f) {
                toDegrees2 = -360.0f;
            } else {
                f6 = toDegrees % 360.0f;
                toDegrees2 %= 360.0f;
                if (f6 < 0.0f) {
                    f6 += 360.0f;
                }
                if (toDegrees2 < 0.0f) {
                    toDegrees2 += 360.0f;
                }
                if (toDegrees2 >= f6) {
                    toDegrees2 = (toDegrees2 - f6) - 360.0f;
                } else {
                    toDegrees2 -= f6;
                }
            }
        } else if (toDegrees2 - toDegrees >= 360.0f) {
            toDegrees2 = 360.0f;
        } else {
            f6 = toDegrees % 360.0f;
            toDegrees2 %= 360.0f;
            if (f6 < 0.0f) {
                f6 += 360.0f;
            }
            if (toDegrees2 < 0.0f) {
                toDegrees2 += 360.0f;
            }
            if (toDegrees2 >= f6) {
                toDegrees2 -= f6;
            } else {
                toDegrees2 = (toDegrees2 + 360.0f) - f6;
            }
        }
        f6 = toDegrees2 % 360.0f;
        if (f6 > f11 || f6 < (-f11)) {
            path.arcTo(new RectF(f7, f8, f9, f10), toDegrees, toDegrees2, false);
        } else {
            path.arcTo(new RectF(f7, f8, f9, f10), toDegrees, toDegrees2, false);
            path.addArc(new RectF(f7, f8, f9, f10), toDegrees, toDegrees2);
        }
        AppMethodBeat.o(103667);
        return true;
    }
}
