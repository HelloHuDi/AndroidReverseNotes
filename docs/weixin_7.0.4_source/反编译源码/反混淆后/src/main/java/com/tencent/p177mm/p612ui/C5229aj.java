package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.util.SparseIntArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.ui.aj */
public final class C5229aj {
    private static float density = -1.0f;
    private static float scale = 0.0f;
    private static SparseIntArray xup = new SparseIntArray();

    static {
        AppMethodBeat.m2504i(112487);
        AppMethodBeat.m2505o(112487);
    }

    public static int fromDPToPix(Context context, int i) {
        AppMethodBeat.m2504i(112482);
        int round = Math.round(C5229aj.getDensity(context) * ((float) i));
        AppMethodBeat.m2505o(112482);
        return round;
    }

    /* renamed from: am */
    public static int m7981am(Context context, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(112483);
        if (context == null) {
            C5227ai.m7972e("WeUIResHelper", "get dimension pixel size, resId %d, but context is null".concat(String.valueOf(i)), new Object[0]);
            AppMethodBeat.m2505o(112483);
        } else {
            i2 = xup.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                xup.put(i, i2);
            }
            AppMethodBeat.m2505o(112483);
        }
        return i2;
    }

    public static float getDensity(Context context) {
        AppMethodBeat.m2504i(112484);
        if (context != null && density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        float f = density;
        AppMethodBeat.m2505o(112484);
        return f;
    }

    /* renamed from: dm */
    public static float m7982dm(Context context) {
        AppMethodBeat.m2504i(112485);
        if (scale == 0.0f) {
            if (context == null) {
                scale = 1.0f;
            } else {
                scale = context.getSharedPreferences("com.tencent.mm_preferences", 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        float f = scale;
        AppMethodBeat.m2505o(112485);
        return f;
    }

    /* renamed from: hE */
    public static int m7983hE(Context context) {
        AppMethodBeat.m2504i(112486);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C25738R.attr.f5464c, typedValue, true);
        int i = typedValue.data;
        AppMethodBeat.m2505o(112486);
        return i;
    }
}
