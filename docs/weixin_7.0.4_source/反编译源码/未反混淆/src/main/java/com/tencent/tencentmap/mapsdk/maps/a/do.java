package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class do implements Runnable {
    private /* synthetic */ dn a;

    do(dn dnVar) {
        this.a = dnVar;
    }

    public final void run() {
        AppMethodBeat.i(98730);
        String b = er.b("settings_in_client", "", true);
        if (!TextUtils.isEmpty(b)) {
            try {
                this.a.a.a(b);
                dn.b(this.a);
                AppMethodBeat.o(98730);
                return;
            } catch (Throwable th) {
                er.a("settings_in_client", "", true);
            }
        }
        AppMethodBeat.o(98730);
    }
}
