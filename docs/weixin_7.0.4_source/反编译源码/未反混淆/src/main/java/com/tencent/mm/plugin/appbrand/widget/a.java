package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a {
    public static int de(Context context) {
        AppMethodBeat.i(87439);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.fb);
        AppMethodBeat.o(87439);
        return dimensionPixelSize;
    }
}
