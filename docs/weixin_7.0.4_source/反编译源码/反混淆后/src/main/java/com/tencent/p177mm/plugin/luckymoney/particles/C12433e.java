package com.tencent.p177mm.plugin.luckymoney.particles;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.luckymoney.particles.e */
public final class C12433e {
    private static final Paint oau;
    private static Interpolator oav;

    /* renamed from: com.tencent.mm.plugin.luckymoney.particles.e$1 */
    static class C33881 implements Interpolator {
        C33881() {
        }

        public final float getInterpolation(float f) {
            return f >= 0.9f ? 1.0f - ((f - 0.9f) * 10.0f) : 1.0f;
        }
    }

    static {
        AppMethodBeat.m2504i(42458);
        Paint paint = new Paint();
        oau = paint;
        paint.setStyle(Style.FILL);
        AppMethodBeat.m2505o(42458);
    }

    public static Interpolator bLQ() {
        AppMethodBeat.m2504i(42457);
        if (oav == null) {
            oav = new C33881();
        }
        Interpolator interpolator = oav;
        AppMethodBeat.m2505o(42457);
        return interpolator;
    }
}
