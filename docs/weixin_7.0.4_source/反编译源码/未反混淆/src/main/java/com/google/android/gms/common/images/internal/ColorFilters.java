package com.google.android.gms.common.images.internal;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ColorFilters {
    public static final ColorFilter COLOR_FILTER_BW = new ColorMatrixColorFilter(zzpv);
    private static final ColorMatrix zzpv;

    static {
        AppMethodBeat.i(61258);
        ColorMatrix colorMatrix = new ColorMatrix();
        zzpv = colorMatrix;
        colorMatrix.setSaturation(0.0f);
        AppMethodBeat.o(61258);
    }

    private ColorFilters() {
    }
}
