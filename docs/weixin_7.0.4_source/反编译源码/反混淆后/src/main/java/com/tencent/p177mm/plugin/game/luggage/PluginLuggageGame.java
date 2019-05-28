package com.tencent.p177mm.plugin.game.luggage;

import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.game.luggage.p1270a.C20969a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.BatteryManager;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.BatteryManager.BatteryChangedReceiver;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.game.luggage.PluginLuggageGame */
public class PluginLuggageGame extends C7597f implements C9562c, C20969a {
    public void execute(C1681g c1681g) {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(135829);
        if (BatteryManager.uCT == null) {
            BatteryManager.uCT = new BatteryChangedReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        C4996ah.getContext().registerReceiver(BatteryManager.uCT, intentFilter);
        AppMethodBeat.m2505o(135829);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(135830);
        if (BatteryManager.uCT != null) {
            C4996ah.getContext().unregisterReceiver(BatteryManager.uCT);
        }
        BatteryManager.uCT = null;
        AppMethodBeat.m2505o(135830);
    }
}
