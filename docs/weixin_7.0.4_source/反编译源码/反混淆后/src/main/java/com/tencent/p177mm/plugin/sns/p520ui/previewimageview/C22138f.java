package com.tencent.p177mm.plugin.sns.p520ui.previewimageview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.f */
public final class C22138f {
    /* renamed from: dS */
    public static float m33758dS(View view) {
        AppMethodBeat.m2504i(40339);
        float abs = (float) Math.abs((view.getRight() - view.getLeft()) / 2);
        AppMethodBeat.m2505o(40339);
        return abs;
    }

    /* renamed from: dT */
    public static float m33759dT(View view) {
        AppMethodBeat.m2504i(40340);
        float abs = (float) Math.abs((view.getBottom() - view.getTop()) / 2);
        AppMethodBeat.m2505o(40340);
        return abs;
    }

    /* renamed from: a */
    public static int m33756a(ViewGroup viewGroup, float f, float f2) {
        AppMethodBeat.m2504i(40341);
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            if (C22138f.m33757d(viewGroup.getChildAt(childCount), f, f2)) {
                AppMethodBeat.m2505o(40341);
                return childCount;
            }
        }
        AppMethodBeat.m2505o(40341);
        return -1;
    }

    /* renamed from: d */
    public static boolean m33757d(View view, float f, float f2) {
        AppMethodBeat.m2504i(40342);
        if (f < ((float) view.getLeft()) || f > ((float) view.getRight()) || f2 < ((float) view.getTop()) || f2 > ((float) view.getBottom())) {
            AppMethodBeat.m2505o(40342);
            return false;
        }
        AppMethodBeat.m2505o(40342);
        return true;
    }
}
