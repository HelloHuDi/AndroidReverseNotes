package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.i */
public final class C45707i {
    /* renamed from: b */
    public static void m84462b(Context context, View view) {
        AppMethodBeat.m2504i(133577);
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(C25738R.dimen.f10174t5);
            if (layoutParams != null) {
                layoutParams.rightMargin = dimensionPixelOffset;
                layoutParams.leftMargin = dimensionPixelOffset;
                layoutParams.topMargin = dimensionPixelOffset;
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.invalidate();
                linearLayout.requestLayout();
            }
        }
        AppMethodBeat.m2505o(133577);
    }
}
