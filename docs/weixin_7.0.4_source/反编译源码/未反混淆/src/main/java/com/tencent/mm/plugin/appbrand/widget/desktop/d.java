package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ae;

public final class d {
    private static boolean iXe = false;

    public static int di(Context context) {
        AppMethodBeat.i(133812);
        if (context == null) {
            AppMethodBeat.o(133812);
            return 0;
        }
        ab.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d", Integer.valueOf((int) (((float) a.am(context, R.dimen.r2)) * dm(context))));
        AppMethodBeat.o(133812);
        return (int) (((float) a.am(context, R.dimen.r2)) * dm(context));
    }

    public static int dj(Context context) {
        AppMethodBeat.i(133813);
        int d = d(context, b.getShowCountPerPage());
        AppMethodBeat.o(133813);
        return d;
    }

    public static int c(int i, Context context) {
        AppMethodBeat.i(133814);
        int a = a(i, context, b.getShowCountPerPage());
        AppMethodBeat.o(133814);
        return a;
    }

    public static int getScreenWidth(Context context) {
        int i = 0;
        AppMethodBeat.i(133815);
        try {
            if (context.getResources().getConfiguration().orientation == 2 && ae.hD(context)) {
                i = ae.hy(context).x;
                AppMethodBeat.o(133815);
                return i;
            }
            i = context.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.o(133815);
            return i;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", e, "alvinluo getScreenWidth exception", new Object[i]);
            AppMethodBeat.o(133815);
        }
    }

    private static int a(int i, Context context, float f) {
        AppMethodBeat.i(133816);
        if (context == null) {
            AppMethodBeat.o(133816);
            return 0;
        }
        int ceil;
        int di = di(context);
        if (b.aPd()) {
            ceil = (int) (((double) (((float) i) - (((float) di) * f))) / Math.ceil((double) f));
        } else {
            iXe = false;
            int dk = dk(context);
            ceil = ((i - (dk * 2)) - (((int) f) * di)) / ((((int) f) - 1) * 2);
            if (ceil > dk) {
                ceil = (i - (((int) f) * di)) / (((int) f) * 2);
                iXe = true;
            } else {
                iXe = false;
            }
        }
        if (ceil < 0) {
            ceil = 0;
        }
        ab.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", Integer.valueOf(di), Integer.valueOf(ceil), Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(iXe));
        AppMethodBeat.o(133816);
        return ceil;
    }

    public static int d(Context context, float f) {
        AppMethodBeat.i(133817);
        if (context == null) {
            AppMethodBeat.o(133817);
            return 0;
        }
        int a = a(getScreenWidth(context), context, f);
        AppMethodBeat.o(133817);
        return a;
    }

    public static int dk(Context context) {
        AppMethodBeat.i(133818);
        if (iXe) {
            AppMethodBeat.o(133818);
            return 0;
        }
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.r3);
        float dm = dm(context);
        if (!(dm == 1.0f || dm == 0.875f)) {
            dimensionPixelOffset = (dm == 1.125f || dm == 1.25f || dm == 1.375f) ? context.getResources().getDimensionPixelOffset(R.dimen.l5) : context.getResources().getDimensionPixelOffset(R.dimen.m4);
        }
        ab.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", Integer.valueOf(dimensionPixelOffset));
        AppMethodBeat.o(133818);
        return dimensionPixelOffset;
    }

    public static float dl(Context context) {
        AppMethodBeat.i(133819);
        ab.i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", Float.valueOf(((float) a.am(context, R.dimen.qz)) * dm(context)));
        AppMethodBeat.o(133819);
        return ((float) a.am(context, R.dimen.qz)) * dm(context);
    }

    public static float dm(Context context) {
        AppMethodBeat.i(133820);
        float dm = a.dm(context);
        if (dm == 1.625f || dm == 1.875f || dm == 2.025f) {
            dm = 1.375f;
        }
        AppMethodBeat.o(133820);
        return dm;
    }
}
