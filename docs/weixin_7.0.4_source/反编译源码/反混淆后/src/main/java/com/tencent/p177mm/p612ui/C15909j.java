package com.tencent.p177mm.p612ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.j */
public final class C15909j {
    /* renamed from: a */
    public static void m24224a(final Activity activity, final int i, final int i2, String str) {
        AppMethodBeat.m2504i(29437);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(29436);
                Activity activity = activity;
                int i = i;
                int i2 = i2;
                C4990ab.m7417i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", Integer.valueOf(i2), Integer.valueOf(i), C42252ah.anW());
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
                    C26483d.m42196b(i, str, ((activity.hashCode() / 16) * 16) + i2);
                }
                AppMethodBeat.m2505o(29436);
            }
        }, str);
        AppMethodBeat.m2505o(29437);
    }
}
