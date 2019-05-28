package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ae;

public final class f {
    public static int[] a(Context context, View view, View view2, boolean z) {
        AppMethodBeat.i(2240);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        int height = view.getHeight();
        int i = ae.hy(context).x;
        view2.measure(0, 0);
        int measuredHeight = view2.getMeasuredHeight();
        int measuredWidth = view2.getMeasuredWidth();
        if (z) {
            iArr[0] = (i - measuredWidth) / 2;
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[0] = (i - measuredWidth) / 2;
            iArr[1] = iArr2[1] + height;
        }
        AppMethodBeat.o(2240);
        return iArr;
    }

    public static int em(View view) {
        AppMethodBeat.i(2241);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = iArr[0] + (view.getWidth() / 2);
        AppMethodBeat.o(2241);
        return width;
    }

    public static int dip2px(Context context, float f) {
        AppMethodBeat.i(2242);
        int i = (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
        AppMethodBeat.o(2242);
        return i;
    }
}
