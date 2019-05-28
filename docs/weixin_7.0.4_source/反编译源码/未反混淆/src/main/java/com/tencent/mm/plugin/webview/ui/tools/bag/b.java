package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.ak;

public final class b {
    public static int uyg = fr(ah.getContext());
    public static final int uyh = ak.getStatusBarHeight(ah.getContext());
    public static final int uyi = ah.getContext().getResources().getDimensionPixelSize(R.dimen.fd);
    public static final int uyj = ah.getContext().getResources().getDimensionPixelSize(R.dimen.ab2);
    public static final int uyk = ah.getContext().getResources().getDimensionPixelSize(R.dimen.ab1);
    public static final int uyl = ah.getContext().getResources().getDimensionPixelSize(R.dimen.aaz);
    public static final int uym;
    public static final float uyn;
    public static final int uyo = ah.getContext().getResources().getDimensionPixelSize(R.dimen.aav);
    public static final int uyp;
    public static final float uyq;

    static {
        AppMethodBeat.i(8149);
        int dimensionPixelSize = ah.getContext().getResources().getDimensionPixelSize(R.dimen.aay);
        uym = dimensionPixelSize;
        uyn = ((float) dimensionPixelSize) / ((float) uyl);
        dimensionPixelSize = ah.getContext().getResources().getDimensionPixelSize(R.dimen.aau);
        uyp = dimensionPixelSize;
        uyq = ((float) dimensionPixelSize) / ((float) uyo);
        AppMethodBeat.o(8149);
    }

    private static int fr(Context context) {
        AppMethodBeat.i(8147);
        ab.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", Integer.valueOf(ak.fr(context)));
        AppMethodBeat.o(8147);
        return ak.fr(context);
    }

    public static void fs(Context context) {
        AppMethodBeat.i(8148);
        uyg = fr(context);
        AppMethodBeat.o(8148);
    }
}
