package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p {
    @TargetApi(11)
    public static void ci(View view) {
        AppMethodBeat.i(52001);
        if (view.getLayerType() == 1) {
            AppMethodBeat.o(52001);
            return;
        }
        view.setLayerType(1, null);
        AppMethodBeat.o(52001);
    }

    @TargetApi(11)
    public static void w(View view, int i, int i2) {
        int i3;
        AppMethodBeat.i(52002);
        if (i >= 2048 || i2 >= 2048) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (view.getLayerType() != i3) {
            view.setLayerType(i3, null);
        }
        AppMethodBeat.o(52002);
    }
}
