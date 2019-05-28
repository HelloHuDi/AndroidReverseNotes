package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ab;

public final class AppBrandInToolsUI extends AppBrandUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(132964);
        super.onCreate(bundle);
        AppMethodBeat.o(132964);
    }

    public final void onDestroy() {
        AppMethodBeat.i(132965);
        super.onDestroy();
        try {
            KVCommCrossProcessReceiver.cgo();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandInToolsUI", e, "sendKV", new Object[0]);
        }
        e.a(g.WASERVICE, null, true, null);
        AppMethodBeat.o(132965);
    }
}
