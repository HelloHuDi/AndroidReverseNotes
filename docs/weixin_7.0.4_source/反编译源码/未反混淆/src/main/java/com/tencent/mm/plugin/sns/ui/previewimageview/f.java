package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static float dS(View view) {
        AppMethodBeat.i(40339);
        float abs = (float) Math.abs((view.getRight() - view.getLeft()) / 2);
        AppMethodBeat.o(40339);
        return abs;
    }

    public static float dT(View view) {
        AppMethodBeat.i(40340);
        float abs = (float) Math.abs((view.getBottom() - view.getTop()) / 2);
        AppMethodBeat.o(40340);
        return abs;
    }

    public static int a(ViewGroup viewGroup, float f, float f2) {
        AppMethodBeat.i(40341);
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(viewGroup.getChildAt(childCount), f, f2)) {
                AppMethodBeat.o(40341);
                return childCount;
            }
        }
        AppMethodBeat.o(40341);
        return -1;
    }

    public static boolean d(View view, float f, float f2) {
        AppMethodBeat.i(40342);
        if (f < ((float) view.getLeft()) || f > ((float) view.getRight()) || f2 < ((float) view.getTop()) || f2 > ((float) view.getBottom())) {
            AppMethodBeat.o(40342);
            return false;
        }
        AppMethodBeat.o(40342);
        return true;
    }
}
