package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class d {
    private static String AUh;
    private static HashSet<String> AUi = new HashSet();

    public interface a {
        void awE();
    }

    public static class b {
        public b(Context context, final a aVar) {
            AppMethodBeat.i(65557);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(65556);
                    com.tencent.tinker.lib.util.a.i("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", intent == null ? "" : intent.getAction());
                    if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                        context.unregisterReceiver(this);
                        if (aVar != null) {
                            aVar.awE();
                        }
                    }
                    AppMethodBeat.o(65556);
                }
            }, intentFilter);
            AppMethodBeat.o(65557);
        }
    }

    static {
        AppMethodBeat.i(65559);
        AppMethodBeat.o(65559);
    }

    public static String dWm() {
        if (AUh == null) {
            return "";
        }
        return AUh;
    }

    public static boolean dWn() {
        AppMethodBeat.i(65558);
        if (AUh == null) {
            AppMethodBeat.o(65558);
            return false;
        }
        boolean contains = AUi.contains(AUh);
        AppMethodBeat.o(65558);
        return contains;
    }
}
