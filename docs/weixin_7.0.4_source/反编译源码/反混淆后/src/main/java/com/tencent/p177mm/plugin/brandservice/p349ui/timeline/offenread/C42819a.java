package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a */
public final class C42819a {
    private static float iWr = 4.5f;
    private static int iWs = 4;

    public static void init(Context context) {
        AppMethodBeat.m2504i(14334);
        if (C42819a.m75962d(context, 4.5f) <= C1338a.fromDPToPix(context, 10)) {
            iWr = 3.5f;
            iWs = 3;
            AppMethodBeat.m2505o(14334);
            return;
        }
        iWr = 4.5f;
        iWs = 4;
        AppMethodBeat.m2505o(14334);
    }

    public static float getShowCountPerPage() {
        return iWr;
    }

    public static int getCompletelyCountPerPage() {
        return iWs;
    }

    /* renamed from: di */
    public static int m75963di(Context context) {
        AppMethodBeat.m2504i(14335);
        if (context == null) {
            AppMethodBeat.m2505o(14335);
            return 0;
        }
        C4990ab.m7411d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", Integer.valueOf((int) (((float) C1338a.m2857am(context, C25738R.dimen.f10209uk)) * C42819a.m75965dm(context))));
        AppMethodBeat.m2505o(14335);
        return (int) (((float) C1338a.m2857am(context, C25738R.dimen.f10209uk)) * C42819a.m75965dm(context));
    }

    /* renamed from: dw */
    private static int m75966dw(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(14337);
        try {
            i = context.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.m2505o(14337);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", e, "alvinluo getViewWidth exception", new Object[i]);
            AppMethodBeat.m2505o(14337);
        }
        return i;
    }

    /* renamed from: d */
    private static int m75962d(Context context, float f) {
        AppMethodBeat.m2504i(14338);
        if (context == null) {
            AppMethodBeat.m2505o(14338);
            return 0;
        }
        int di = C42819a.m75963di(context);
        int dw = (int) (((double) (((float) C42819a.m75966dw(context)) - (((float) di) * f))) / Math.ceil((double) f));
        if (dw < 0) {
            dw = 0;
        }
        C4990ab.m7411d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d", Integer.valueOf(di), Integer.valueOf(dw), Integer.valueOf(r3));
        AppMethodBeat.m2505o(14338);
        return dw;
    }

    /* renamed from: dx */
    public static int m75967dx(Context context) {
        AppMethodBeat.m2504i(14339);
        int am = (int) (((float) C1338a.m2857am(context, C25738R.dimen.f10208uj)) * C42819a.m75965dm(context));
        AppMethodBeat.m2505o(14339);
        return am;
    }

    /* renamed from: dm */
    private static float m75965dm(Context context) {
        AppMethodBeat.m2504i(14340);
        float dm = C1338a.m2860dm(context);
        if (dm == 1.625f || dm == 1.875f || dm == 2.025f) {
            dm = 1.375f;
        }
        AppMethodBeat.m2505o(14340);
        return dm;
    }

    /* renamed from: dj */
    public static int m75964dj(Context context) {
        AppMethodBeat.m2504i(14336);
        int d = C42819a.m75962d(context, iWr);
        AppMethodBeat.m2505o(14336);
        return d;
    }
}
