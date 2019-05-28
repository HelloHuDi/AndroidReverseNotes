package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class i {
    public static void b(Context context, View view) {
        AppMethodBeat.i(133577);
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.t5);
            if (layoutParams != null) {
                layoutParams.rightMargin = dimensionPixelOffset;
                layoutParams.leftMargin = dimensionPixelOffset;
                layoutParams.topMargin = dimensionPixelOffset;
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.invalidate();
                linearLayout.requestLayout();
            }
        }
        AppMethodBeat.o(133577);
    }
}
