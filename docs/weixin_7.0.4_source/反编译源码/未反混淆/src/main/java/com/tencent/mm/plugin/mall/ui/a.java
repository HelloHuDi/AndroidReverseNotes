package com.tencent.mm.plugin.mall.ui;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;

public final class a {
    public static final int olm = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 8);
    public static final int oln = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 140);
    public static final int olo = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 85);
    private static int olp = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 39);
    private static int olq = 40;
    private static int olr = 95;
    private static int ols = 0;
    private static int olt = 0;
    private static int olu = 70;
    private static int olv = 38;

    static {
        AppMethodBeat.i(43134);
        AppMethodBeat.o(43134);
    }

    public static void a(MMActivity mMActivity, boolean z, boolean z2) {
        AppMethodBeat.i(43133);
        int i;
        int i2;
        int fr;
        int height;
        if (z2) {
            Point hy = ae.hy(mMActivity);
            i = hy.x;
            i2 = hy.y;
            if (ae.hw(mMActivity)) {
                fr = i2 - ae.fr(mMActivity);
            } else {
                fr = i2;
            }
            if (mMActivity.getSupportActionBar() != null) {
                height = mMActivity.getSupportActionBar().getHeight();
                if (height <= 0) {
                    height = mMActivity.getResources().getDimensionPixelSize(R.dimen.fd);
                }
            } else {
                height = 0;
            }
            fr = (fr - height) - ae.getStatusBarHeight(mMActivity);
            if (((double) (i2 / i)) * 1.0d > 2.0d) {
                fr = (fr - (olm * 3)) / 20;
            } else {
                fr = (fr - (olm * 3)) / 17;
            }
            olt = Math.max(fr * 4, oln);
            olp = (int) (((double) fr) * 1.5d);
            ols = Math.max(fr * 3, olo);
            ab.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", Integer.valueOf(fr), Integer.valueOf(olt));
            AppMethodBeat.o(43133);
            return;
        }
        height = olp;
        i = com.tencent.mm.bz.a.fromDPToPix(mMActivity, olq);
        fr = ae.hy(mMActivity).y;
        if (ae.hw(mMActivity)) {
            fr -= ae.fr(mMActivity);
        }
        if (mMActivity.getSupportActionBar() != null) {
            i2 = mMActivity.getSupportActionBar().getHeight();
        } else {
            i2 = 0;
        }
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(mMActivity, olr);
        ols = Math.round(((float) (((fr - (height * 2)) - i) - i2)) / 5.0f);
        ab.i("MicroMsg.FunctionGridSizeCalculator", "calc GRID_HEIGHT_SIZE_PX: %s, minHeight: %s", Integer.valueOf(ols), Integer.valueOf(fromDPToPix));
        if (ols < fromDPToPix) {
            ols = fromDPToPix;
        }
        olt = Math.round(((float) (ols * 4)) / 3.0f) + com.tencent.mm.bz.a.fromDPToPix(mMActivity, olu);
        if (z) {
            olt += com.tencent.mm.bz.a.fromDPToPix(mMActivity, olv);
        }
        ab.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", Integer.valueOf(ols), Integer.valueOf(olt));
        AppMethodBeat.o(43133);
    }

    public static int bMW() {
        return ols;
    }

    public static int bMX() {
        return olt;
    }

    public static int bMY() {
        return olp;
    }
}
