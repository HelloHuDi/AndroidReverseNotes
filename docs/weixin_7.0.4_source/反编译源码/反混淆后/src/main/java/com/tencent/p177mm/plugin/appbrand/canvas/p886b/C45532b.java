package com.tencent.p177mm.plugin.appbrand.canvas.p886b;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.b */
public final class C45532b implements C42399a {
    public final String getMethod() {
        return "arc";
    }

    /* renamed from: a */
    public final boolean mo21528a(Path path, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103664);
        if (jSONArray.length() < 5) {
            AppMethodBeat.m2505o(103664);
            return false;
        }
        boolean a = C45532b.m83962a(path, C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), (float) jSONArray.optDouble(3), (float) jSONArray.optDouble(4), jSONArray.optBoolean(5));
        AppMethodBeat.m2505o(103664);
        return a;
    }

    /* renamed from: a */
    public final boolean mo21527a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.m2504i(103665);
        if (basePathActionArg == null || !(basePathActionArg instanceof PathArcActionArg)) {
            AppMethodBeat.m2505o(103665);
            return false;
        }
        PathArcActionArg pathArcActionArg = (PathArcActionArg) basePathActionArg;
        boolean a = C45532b.m83962a(path, pathArcActionArg.f16140x, pathArcActionArg.f16141y, pathArcActionArg.radius, pathArcActionArg.hcR, pathArcActionArg.hdt, pathArcActionArg.hdu);
        AppMethodBeat.m2505o(103665);
        return a;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.m2504i(103666);
        PathArcActionArg pathArcActionArg = new PathArcActionArg();
        AppMethodBeat.m2505o(103666);
        return pathArcActionArg;
    }

    /* renamed from: a */
    private static boolean m83962a(Path path, float f, float f2, float f3, float f4, float f5, boolean z) {
        float f6;
        AppMethodBeat.m2504i(103667);
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
        AppMethodBeat.m2505o(103667);
        return true;
    }
}
