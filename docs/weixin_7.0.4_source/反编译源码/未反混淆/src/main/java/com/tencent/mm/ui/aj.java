package com.tencent.mm.ui;

import android.content.Context;
import android.util.SparseIntArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class aj {
    private static float density = -1.0f;
    private static float scale = 0.0f;
    private static SparseIntArray xup = new SparseIntArray();

    static {
        AppMethodBeat.i(112487);
        AppMethodBeat.o(112487);
    }

    public static int fromDPToPix(Context context, int i) {
        AppMethodBeat.i(112482);
        int round = Math.round(getDensity(context) * ((float) i));
        AppMethodBeat.o(112482);
        return round;
    }

    public static int am(Context context, int i) {
        int i2 = 0;
        AppMethodBeat.i(112483);
        if (context == null) {
            ai.e("WeUIResHelper", "get dimension pixel size, resId %d, but context is null".concat(String.valueOf(i)), new Object[0]);
            AppMethodBeat.o(112483);
        } else {
            i2 = xup.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                xup.put(i, i2);
            }
            AppMethodBeat.o(112483);
        }
        return i2;
    }

    public static float getDensity(Context context) {
        AppMethodBeat.i(112484);
        if (context != null && density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        float f = density;
        AppMethodBeat.o(112484);
        return f;
    }

    public static float dm(Context context) {
        AppMethodBeat.i(112485);
        if (scale == 0.0f) {
            if (context == null) {
                scale = 1.0f;
            } else {
                scale = context.getSharedPreferences("com.tencent.mm_preferences", 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        float f = scale;
        AppMethodBeat.o(112485);
        return f;
    }

    public static int hE(Context context) {
        AppMethodBeat.i(112486);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.c, typedValue, true);
        int i = typedValue.data;
        AppMethodBeat.o(112486);
        return i;
    }
}
