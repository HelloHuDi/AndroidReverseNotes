package com.tinkerboots.sdk.p1355b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.util.C5952a;
import java.util.HashSet;

/* renamed from: com.tinkerboots.sdk.b.d */
public final class C44601d {
    private static String AUh;
    private static HashSet<String> AUi = new HashSet();

    /* renamed from: com.tinkerboots.sdk.b.d$a */
    public interface C24574a {
        void awE();
    }

    /* renamed from: com.tinkerboots.sdk.b.d$b */
    public static class C24576b {
        public C24576b(Context context, final C24574a c24574a) {
            AppMethodBeat.m2504i(65557);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.m2504i(65556);
                    C5952a.m9284i("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", intent == null ? "" : intent.getAction());
                    if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                        context.unregisterReceiver(this);
                        if (c24574a != null) {
                            c24574a.awE();
                        }
                    }
                    AppMethodBeat.m2505o(65556);
                }
            }, intentFilter);
            AppMethodBeat.m2505o(65557);
        }
    }

    static {
        AppMethodBeat.m2504i(65559);
        AppMethodBeat.m2505o(65559);
    }

    public static String dWm() {
        if (AUh == null) {
            return "";
        }
        return AUh;
    }

    public static boolean dWn() {
        AppMethodBeat.m2504i(65558);
        if (AUh == null) {
            AppMethodBeat.m2505o(65558);
            return false;
        }
        boolean contains = AUi.contains(AUh);
        AppMethodBeat.m2505o(65558);
        return contains;
    }
}
