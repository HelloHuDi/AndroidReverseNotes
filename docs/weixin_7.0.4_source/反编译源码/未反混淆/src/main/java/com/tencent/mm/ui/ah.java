package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah {
    public static int dJ(int i, int i2) {
        AppMethodBeat.i(112470);
        if (i2 < 0 || i2 > 100) {
            ai.e("alphaColor", "alpha must be between 0 and 100", new Object[0]);
            AppMethodBeat.o(112470);
            return i;
        }
        i = (16777215 & i) | (((int) ((((double) i2) * 0.01d) * 255.0d)) << 24);
        AppMethodBeat.o(112470);
        return i;
    }

    public static int s(int i, int i2) {
        AppMethodBeat.i(112471);
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int hd = hd(alpha2, alpha);
        alpha = Color.argb(hd, b(Color.red(i), alpha2, Color.red(i2), alpha, hd), b(Color.green(i), alpha2, Color.green(i2), alpha, hd), b(Color.blue(i), alpha2, Color.blue(i2), alpha, hd));
        AppMethodBeat.o(112471);
        return alpha;
    }

    public static Drawable f(Context context, int i, int i2) {
        AppMethodBeat.i(112472);
        Drawable drawable = context.getResources().getDrawable(i);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_ATOP));
        }
        AppMethodBeat.o(112472);
        return drawable;
    }

    public static Drawable e(Drawable drawable, int i) {
        AppMethodBeat.i(112473);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_ATOP));
        }
        AppMethodBeat.o(112473);
        return drawable;
    }

    public static boolean Nw(int i) {
        AppMethodBeat.i(112474);
        if (1.0d - ((((0.299d * ((double) Color.red(i))) + (0.587d * ((double) Color.green(i)))) + (0.114d * ((double) Color.blue(i)))) / 255.0d) >= 0.3d) {
            AppMethodBeat.o(112474);
            return true;
        }
        AppMethodBeat.o(112474);
        return false;
    }

    private static int hd(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int b(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }
}
