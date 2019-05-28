package com.tencent.p177mm.plugin.topstory.p541ui.widget;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5222ae;

/* renamed from: com.tencent.mm.plugin.topstory.ui.widget.f */
public final class C4251f {
    /* renamed from: a */
    public static int[] m6602a(Context context, View view, View view2, boolean z) {
        AppMethodBeat.m2504i(2240);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        int height = view.getHeight();
        int i = C5222ae.m7953hy(context).x;
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
        AppMethodBeat.m2505o(2240);
        return iArr;
    }

    /* renamed from: em */
    public static int m6603em(View view) {
        AppMethodBeat.m2504i(2241);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = iArr[0] + (view.getWidth() / 2);
        AppMethodBeat.m2505o(2241);
        return width;
    }

    public static int dip2px(Context context, float f) {
        AppMethodBeat.m2504i(2242);
        int i = (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
        AppMethodBeat.m2505o(2242);
        return i;
    }
}
