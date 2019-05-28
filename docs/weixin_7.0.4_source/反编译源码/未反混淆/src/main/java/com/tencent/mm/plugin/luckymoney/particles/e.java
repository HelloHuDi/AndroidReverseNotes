package com.tencent.mm.plugin.luckymoney.particles;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    private static final Paint oau;
    private static Interpolator oav;

    static {
        AppMethodBeat.i(42458);
        Paint paint = new Paint();
        oau = paint;
        paint.setStyle(Style.FILL);
        AppMethodBeat.o(42458);
    }

    public static Interpolator bLQ() {
        AppMethodBeat.i(42457);
        if (oav == null) {
            oav = new Interpolator() {
                public final float getInterpolation(float f) {
                    return f >= 0.9f ? 1.0f - ((f - 0.9f) * 10.0f) : 1.0f;
                }
            };
        }
        Interpolator interpolator = oav;
        AppMethodBeat.o(42457);
        return interpolator;
    }
}
