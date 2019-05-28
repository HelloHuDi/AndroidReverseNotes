package com.tencent.p177mm.plugin.p436hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.util.C5952a;

/* renamed from: com.tencent.mm.plugin.hp.tinker.a */
public final class C43214a {
    Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.hp.tinker.a$a */
    public interface C39253a {
        void bGo();
    }

    public C43214a(Context context, final C39253a c39253a) {
        AppMethodBeat.m2504i(90626);
        Boolean ca = C43214a.m76858ca(context);
        C5952a.m9284i("Tinker.ScreenOffRetryPatch", "try post ScreenOffRetryPatch delay time: %d, screen: %b", Long.valueOf(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME), ca);
        IntentFilter intentFilter = new IntentFilter();
        final C122421 c122421 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90624);
                if (c39253a != null) {
                    C5952a.m9284i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
                    c39253a.bGo();
                }
                AppMethodBeat.m2505o(90624);
            }
        };
        if (ca == null || ca.booleanValue()) {
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
        } else {
            C5952a.m9284i("Tinker.ScreenOffRetryPatch", "screen is just off now, we can send message directly", new Object[0]);
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.handler.postDelayed(c122421, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
        context.registerReceiver(new BroadcastReceiver() {
            final /* synthetic */ long nub = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.m2504i(90625);
                if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                    C5952a.m9284i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
                    C43214a.this.handler.postDelayed(c122421, this.nub);
                    AppMethodBeat.m2505o(90625);
                    return;
                }
                C5952a.m9284i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
                C43214a.this.handler.removeCallbacks(c122421);
                context.unregisterReceiver(this);
                AppMethodBeat.m2505o(90625);
            }
        }, intentFilter);
        AppMethodBeat.m2505o(90626);
    }

    /* renamed from: ca */
    private static Boolean m76858ca(Context context) {
        AppMethodBeat.m2504i(90627);
        try {
            Boolean bool = (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
            AppMethodBeat.m2505o(90627);
            return bool;
        } catch (Exception e) {
            AppMethodBeat.m2505o(90627);
            return null;
        }
    }
}
