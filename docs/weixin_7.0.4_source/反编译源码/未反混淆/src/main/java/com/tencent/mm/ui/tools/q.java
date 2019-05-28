package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import junit.framework.Assert;

public final class q {
    private static q zHV = null;
    private ColorStateList[] yDX = new ColorStateList[2];
    private boolean zHW = false;

    private q(Context context) {
        AppMethodBeat.i(107808);
        this.yDX[0] = a.h(context, (int) R.color.a7z);
        this.yDX[1] = a.h(context, (int) R.color.a80);
        AppMethodBeat.o(107808);
    }

    private static q ih(Context context) {
        AppMethodBeat.i(107809);
        Assert.assertTrue(context != null);
        if (zHV == null || !zHV.zHW) {
            zHV = new q(context);
        }
        q qVar = zHV;
        AppMethodBeat.o(107809);
        return qVar;
    }

    public static ColorStateList ii(Context context) {
        AppMethodBeat.i(107810);
        ColorStateList colorStateList = ih(context).yDX[0];
        AppMethodBeat.o(107810);
        return colorStateList;
    }

    public static ColorStateList ij(Context context) {
        AppMethodBeat.i(107811);
        ColorStateList colorStateList = ih(context).yDX[1];
        AppMethodBeat.o(107811);
        return colorStateList;
    }
}
