package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.task.C27310e;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI */
public final class AppBrandInToolsUI extends AppBrandUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(132964);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(132964);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(132965);
        super.onDestroy();
        try {
            KVCommCrossProcessReceiver.cgo();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandInToolsUI", e, "sendKV", new Object[0]);
        }
        C27310e.m43373a(C38519g.WASERVICE, null, true, null);
        AppMethodBeat.m2505o(132965);
    }
}
