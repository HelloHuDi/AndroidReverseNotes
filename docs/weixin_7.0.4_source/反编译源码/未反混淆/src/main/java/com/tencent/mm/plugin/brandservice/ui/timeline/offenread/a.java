package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    private static float iWr = 4.5f;
    private static int iWs = 4;

    public static void init(Context context) {
        AppMethodBeat.i(14334);
        if (d(context, 4.5f) <= com.tencent.mm.bz.a.fromDPToPix(context, 10)) {
            iWr = 3.5f;
            iWs = 3;
            AppMethodBeat.o(14334);
            return;
        }
        iWr = 4.5f;
        iWs = 4;
        AppMethodBeat.o(14334);
    }

    public static float getShowCountPerPage() {
        return iWr;
    }

    public static int getCompletelyCountPerPage() {
        return iWs;
    }

    public static int di(Context context) {
        AppMethodBeat.i(14335);
        if (context == null) {
            AppMethodBeat.o(14335);
            return 0;
        }
        ab.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", Integer.valueOf((int) (((float) com.tencent.mm.bz.a.am(context, R.dimen.uk)) * dm(context))));
        AppMethodBeat.o(14335);
        return (int) (((float) com.tencent.mm.bz.a.am(context, R.dimen.uk)) * dm(context));
    }

    private static int dw(Context context) {
        int i = 0;
        AppMethodBeat.i(14337);
        try {
            i = context.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.o(14337);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", e, "alvinluo getViewWidth exception", new Object[i]);
            AppMethodBeat.o(14337);
        }
        return i;
    }

    private static int d(Context context, float f) {
        AppMethodBeat.i(14338);
        if (context == null) {
            AppMethodBeat.o(14338);
            return 0;
        }
        int di = di(context);
        int dw = (int) (((double) (((float) dw(context)) - (((float) di) * f))) / Math.ceil((double) f));
        if (dw < 0) {
            dw = 0;
        }
        ab.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d", Integer.valueOf(di), Integer.valueOf(dw), Integer.valueOf(r3));
        AppMethodBeat.o(14338);
        return dw;
    }

    public static int dx(Context context) {
        AppMethodBeat.i(14339);
        int am = (int) (((float) com.tencent.mm.bz.a.am(context, R.dimen.uj)) * dm(context));
        AppMethodBeat.o(14339);
        return am;
    }

    private static float dm(Context context) {
        AppMethodBeat.i(14340);
        float dm = com.tencent.mm.bz.a.dm(context);
        if (dm == 1.625f || dm == 1.875f || dm == 2.025f) {
            dm = 1.375f;
        }
        AppMethodBeat.o(14340);
        return dm;
    }

    public static int dj(Context context) {
        AppMethodBeat.i(14336);
        int d = d(context, iWr);
        AppMethodBeat.o(14336);
        return d;
    }
}
