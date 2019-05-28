package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BatteryManager {
    static boolean uCS;
    public static BatteryChangedReceiver uCT;

    public static class BatteryChangedReceiver extends BroadcastReceiver {
        private BatteryChangedReceiver() {
        }

        public /* synthetic */ BatteryChangedReceiver(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(8633);
            if (intent == null) {
                AppMethodBeat.o(8633);
            } else if ("android.intent.action.BATTERY_OKAY".equals(intent.getAction())) {
                BatteryManager.uCS = false;
                AppMethodBeat.o(8633);
            } else {
                if ("android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                    BatteryManager.uCS = true;
                }
                AppMethodBeat.o(8633);
            }
        }
    }
}
