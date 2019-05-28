package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class j {
    public static void a(final Activity activity, final int i, final int i2, String str) {
        AppMethodBeat.i(29437);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29436);
                Activity activity = activity;
                int i = i;
                int i2 = i2;
                ab.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", Integer.valueOf(i2), Integer.valueOf(i), ah.anW());
                if (i2 >= 0) {
                    String str = "MainUI";
                    if (i2 == 1) {
                        str = "AddressUI";
                    }
                    if (i2 == 2) {
                        str = "FindMoreFriendUI";
                    }
                    if (i2 == 3) {
                        str = "MoreTabUI";
                    }
                    com.tencent.mm.modelstat.d.b(i, str, ((activity.hashCode() / 16) * 16) + i2);
                }
                AppMethodBeat.o(29436);
            }
        }, str);
        AppMethodBeat.o(29437);
    }
}
