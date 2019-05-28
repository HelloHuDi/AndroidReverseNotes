package com.tencent.p177mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.p */
public final class C46617p {
    @TargetApi(11)
    /* renamed from: ci */
    public static void m88172ci(View view) {
        AppMethodBeat.m2504i(52001);
        if (view.getLayerType() == 1) {
            AppMethodBeat.m2505o(52001);
            return;
        }
        view.setLayerType(1, null);
        AppMethodBeat.m2505o(52001);
    }

    @TargetApi(11)
    /* renamed from: w */
    public static void m88173w(View view, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(52002);
        if (i >= 2048 || i2 >= 2048) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (view.getLayerType() != i3) {
            view.setLayerType(i3, null);
        }
        AppMethodBeat.m2505o(52002);
    }
}
