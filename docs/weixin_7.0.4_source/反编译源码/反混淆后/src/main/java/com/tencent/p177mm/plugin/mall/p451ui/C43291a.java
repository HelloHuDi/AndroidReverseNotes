package com.tencent.p177mm.plugin.mall.p451ui;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.mall.ui.a */
public final class C43291a {
    public static final int olm = C1338a.fromDPToPix(C4996ah.getContext(), 8);
    public static final int oln = C1338a.fromDPToPix(C4996ah.getContext(), 140);
    public static final int olo = C1338a.fromDPToPix(C4996ah.getContext(), 85);
    private static int olp = C1338a.fromDPToPix(C4996ah.getContext(), 39);
    private static int olq = 40;
    private static int olr = 95;
    private static int ols = 0;
    private static int olt = 0;
    private static int olu = 70;
    private static int olv = 38;

    static {
        AppMethodBeat.m2504i(43134);
        AppMethodBeat.m2505o(43134);
    }

    /* renamed from: a */
    public static void m77161a(MMActivity mMActivity, boolean z, boolean z2) {
        AppMethodBeat.m2504i(43133);
        int i;
        int i2;
        int fr;
        int height;
        if (z2) {
            Point hy = C5222ae.m7953hy(mMActivity);
            i = hy.x;
            i2 = hy.y;
            if (C5222ae.m7951hw(mMActivity)) {
                fr = i2 - C5222ae.m7944fr(mMActivity);
            } else {
                fr = i2;
            }
            if (mMActivity.getSupportActionBar() != null) {
                height = mMActivity.getSupportActionBar().getHeight();
                if (height <= 0) {
                    height = mMActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
                }
            } else {
                height = 0;
            }
            fr = (fr - height) - C5222ae.getStatusBarHeight(mMActivity);
            if (((double) (i2 / i)) * 1.0d > 2.0d) {
                fr = (fr - (olm * 3)) / 20;
            } else {
                fr = (fr - (olm * 3)) / 17;
            }
            olt = Math.max(fr * 4, oln);
            olp = (int) (((double) fr) * 1.5d);
            ols = Math.max(fr * 3, olo);
            C4990ab.m7417i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", Integer.valueOf(fr), Integer.valueOf(olt));
            AppMethodBeat.m2505o(43133);
            return;
        }
        height = olp;
        i = C1338a.fromDPToPix(mMActivity, olq);
        fr = C5222ae.m7953hy(mMActivity).y;
        if (C5222ae.m7951hw(mMActivity)) {
            fr -= C5222ae.m7944fr(mMActivity);
        }
        if (mMActivity.getSupportActionBar() != null) {
            i2 = mMActivity.getSupportActionBar().getHeight();
        } else {
            i2 = 0;
        }
        int fromDPToPix = C1338a.fromDPToPix(mMActivity, olr);
        ols = Math.round(((float) (((fr - (height * 2)) - i) - i2)) / 5.0f);
        C4990ab.m7417i("MicroMsg.FunctionGridSizeCalculator", "calc GRID_HEIGHT_SIZE_PX: %s, minHeight: %s", Integer.valueOf(ols), Integer.valueOf(fromDPToPix));
        if (ols < fromDPToPix) {
            ols = fromDPToPix;
        }
        olt = Math.round(((float) (ols * 4)) / 3.0f) + C1338a.fromDPToPix(mMActivity, olu);
        if (z) {
            olt += C1338a.fromDPToPix(mMActivity, olv);
        }
        C4990ab.m7417i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", Integer.valueOf(ols), Integer.valueOf(olt));
        AppMethodBeat.m2505o(43133);
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
