package com.tencent.mm.plugin.game.luggage;

import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.luggage.a.a;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager.BatteryChangedReceiver;
import com.tencent.mm.sdk.platformtools.ah;

public class PluginLuggageGame extends f implements c, a {
    public void execute(g gVar) {
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(135829);
        if (BatteryManager.uCT == null) {
            BatteryManager.uCT = new BatteryChangedReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        ah.getContext().registerReceiver(BatteryManager.uCT, intentFilter);
        AppMethodBeat.o(135829);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(135830);
        if (BatteryManager.uCT != null) {
            ah.getContext().unregisterReceiver(BatteryManager.uCT);
        }
        BatteryManager.uCT = null;
        AppMethodBeat.o(135830);
    }
}
