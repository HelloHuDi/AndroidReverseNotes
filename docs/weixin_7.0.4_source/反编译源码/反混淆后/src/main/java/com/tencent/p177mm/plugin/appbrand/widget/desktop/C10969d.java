package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.d */
public final class C10969d {
    private static boolean iXe = false;

    /* renamed from: di */
    public static int m18706di(Context context) {
        AppMethodBeat.m2504i(133812);
        if (context == null) {
            AppMethodBeat.m2505o(133812);
            return 0;
        }
        C4990ab.m7417i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d", Integer.valueOf((int) (((float) C1338a.m2857am(context, C25738R.dimen.f10132r2)) * C10969d.m18710dm(context))));
        AppMethodBeat.m2505o(133812);
        return (int) (((float) C1338a.m2857am(context, C25738R.dimen.f10132r2)) * C10969d.m18710dm(context));
    }

    /* renamed from: dj */
    public static int m18707dj(Context context) {
        AppMethodBeat.m2504i(133813);
        int d = C10969d.m18705d(context, C2545b.getShowCountPerPage());
        AppMethodBeat.m2505o(133813);
        return d;
    }

    /* renamed from: c */
    public static int m18704c(int i, Context context) {
        AppMethodBeat.m2504i(133814);
        int a = C10969d.m18703a(i, context, C2545b.getShowCountPerPage());
        AppMethodBeat.m2505o(133814);
        return a;
    }

    public static int getScreenWidth(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(133815);
        try {
            if (context.getResources().getConfiguration().orientation == 2 && C5222ae.m7950hD(context)) {
                i = C5222ae.m7953hy(context).x;
                AppMethodBeat.m2505o(133815);
                return i;
            }
            i = context.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.m2505o(133815);
            return i;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", e, "alvinluo getScreenWidth exception", new Object[i]);
            AppMethodBeat.m2505o(133815);
        }
    }

    /* renamed from: a */
    private static int m18703a(int i, Context context, float f) {
        AppMethodBeat.m2504i(133816);
        if (context == null) {
            AppMethodBeat.m2505o(133816);
            return 0;
        }
        int ceil;
        int di = C10969d.m18706di(context);
        if (C2545b.aPd()) {
            ceil = (int) (((double) (((float) i) - (((float) di) * f))) / Math.ceil((double) f));
        } else {
            iXe = false;
            int dk = C10969d.m18708dk(context);
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
        C4990ab.m7417i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", Integer.valueOf(di), Integer.valueOf(ceil), Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(iXe));
        AppMethodBeat.m2505o(133816);
        return ceil;
    }

    /* renamed from: d */
    public static int m18705d(Context context, float f) {
        AppMethodBeat.m2504i(133817);
        if (context == null) {
            AppMethodBeat.m2505o(133817);
            return 0;
        }
        int a = C10969d.m18703a(C10969d.getScreenWidth(context), context, f);
        AppMethodBeat.m2505o(133817);
        return a;
    }

    /* renamed from: dk */
    public static int m18708dk(Context context) {
        AppMethodBeat.m2504i(133818);
        if (iXe) {
            AppMethodBeat.m2505o(133818);
            return 0;
        }
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(C25738R.dimen.f10133r3);
        float dm = C10969d.m18710dm(context);
        if (!(dm == 1.0f || dm == 0.875f)) {
            dimensionPixelOffset = (dm == 1.125f || dm == 1.25f || dm == 1.375f) ? context.getResources().getDimensionPixelOffset(C25738R.dimen.f9948l5) : context.getResources().getDimensionPixelOffset(C25738R.dimen.f9979m4);
        }
        C4990ab.m7411d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", Integer.valueOf(dimensionPixelOffset));
        AppMethodBeat.m2505o(133818);
        return dimensionPixelOffset;
    }

    /* renamed from: dl */
    public static float m18709dl(Context context) {
        AppMethodBeat.m2504i(133819);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", Float.valueOf(((float) C1338a.m2857am(context, C25738R.dimen.f10129qz)) * C10969d.m18710dm(context)));
        AppMethodBeat.m2505o(133819);
        return ((float) C1338a.m2857am(context, C25738R.dimen.f10129qz)) * C10969d.m18710dm(context);
    }

    /* renamed from: dm */
    public static float m18710dm(Context context) {
        AppMethodBeat.m2504i(133820);
        float dm = C1338a.m2860dm(context);
        if (dm == 1.625f || dm == 1.875f || dm == 2.025f) {
            dm = 1.375f;
        }
        AppMethodBeat.m2505o(133820);
        return dm;
    }
}
