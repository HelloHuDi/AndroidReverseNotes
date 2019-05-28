package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    Handler handler = new Handler(Looper.getMainLooper());

    public interface a {
        void bGo();
    }

    public a(Context context, final a aVar) {
        AppMethodBeat.i(90626);
        Boolean ca = ca(context);
        com.tencent.tinker.lib.util.a.i("Tinker.ScreenOffRetryPatch", "try post ScreenOffRetryPatch delay time: %d, screen: %b", Long.valueOf(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME), ca);
        IntentFilter intentFilter = new IntentFilter();
        final AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(90624);
                if (aVar != null) {
                    com.tencent.tinker.lib.util.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
                    aVar.bGo();
                }
                AppMethodBeat.o(90624);
            }
        };
        if (ca == null || ca.booleanValue()) {
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
        } else {
            com.tencent.tinker.lib.util.a.i("Tinker.ScreenOffRetryPatch", "screen is just off now, we can send message directly", new Object[0]);
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.handler.postDelayed(anonymousClass1, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
        context.registerReceiver(new BroadcastReceiver() {
            final /* synthetic */ long nub = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(90625);
                if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                    com.tencent.tinker.lib.util.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
                    a.this.handler.postDelayed(anonymousClass1, this.nub);
                    AppMethodBeat.o(90625);
                    return;
                }
                com.tencent.tinker.lib.util.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
                a.this.handler.removeCallbacks(anonymousClass1);
                context.unregisterReceiver(this);
                AppMethodBeat.o(90625);
            }
        }, intentFilter);
        AppMethodBeat.o(90626);
    }

    private static Boolean ca(Context context) {
        AppMethodBeat.i(90627);
        try {
            Boolean bool = (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
            AppMethodBeat.o(90627);
            return bool;
        } catch (Exception e) {
            AppMethodBeat.o(90627);
            return null;
        }
    }
}
