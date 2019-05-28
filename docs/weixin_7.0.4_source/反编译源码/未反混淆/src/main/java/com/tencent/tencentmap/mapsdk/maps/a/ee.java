package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ee implements Runnable {
    private /* synthetic */ ed a;

    ee(ed edVar) {
        this.a = edVar;
    }

    public final void run() {
        AppMethodBeat.i(98783);
        String string = bt.a().getSharedPreferences(ed.a(this.a), 0).getString("halley_cloud_param_content", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.a.a.a(string);
                AppMethodBeat.o(98783);
                return;
            } catch (Throwable th) {
                ed.a(this.a, "");
            }
        }
        AppMethodBeat.o(98783);
    }
}
