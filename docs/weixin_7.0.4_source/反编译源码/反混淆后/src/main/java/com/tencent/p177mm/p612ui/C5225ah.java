package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.ah */
public final class C5225ah {
    /* renamed from: dJ */
    public static int m7960dJ(int i, int i2) {
        AppMethodBeat.m2504i(112470);
        if (i2 < 0 || i2 > 100) {
            C5227ai.m7972e("alphaColor", "alpha must be between 0 and 100", new Object[0]);
            AppMethodBeat.m2505o(112470);
            return i;
        }
        i = (16777215 & i) | (((int) ((((double) i2) * 0.01d) * 255.0d)) << 24);
        AppMethodBeat.m2505o(112470);
        return i;
    }

    /* renamed from: s */
    public static int m7964s(int i, int i2) {
        AppMethodBeat.m2504i(112471);
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int hd = C5225ah.m7963hd(alpha2, alpha);
        alpha = Color.argb(hd, C5225ah.m7959b(Color.red(i), alpha2, Color.red(i2), alpha, hd), C5225ah.m7959b(Color.green(i), alpha2, Color.green(i2), alpha, hd), C5225ah.m7959b(Color.blue(i), alpha2, Color.blue(i2), alpha, hd));
        AppMethodBeat.m2505o(112471);
        return alpha;
    }

    /* renamed from: f */
    public static Drawable m7962f(Context context, int i, int i2) {
        AppMethodBeat.m2504i(112472);
        Drawable drawable = context.getResources().getDrawable(i);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_ATOP));
        }
        AppMethodBeat.m2505o(112472);
        return drawable;
    }

    /* renamed from: e */
    public static Drawable m7961e(Drawable drawable, int i) {
        AppMethodBeat.m2504i(112473);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_ATOP));
        }
        AppMethodBeat.m2505o(112473);
        return drawable;
    }

    /* renamed from: Nw */
    public static boolean m7958Nw(int i) {
        AppMethodBeat.m2504i(112474);
        if (1.0d - ((((0.299d * ((double) Color.red(i))) + (0.587d * ((double) Color.green(i)))) + (0.114d * ((double) Color.blue(i)))) / 255.0d) >= 0.3d) {
            AppMethodBeat.m2505o(112474);
            return true;
        }
        AppMethodBeat.m2505o(112474);
        return false;
    }

    /* renamed from: hd */
    private static int m7963hd(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    /* renamed from: b */
    private static int m7959b(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }
}
