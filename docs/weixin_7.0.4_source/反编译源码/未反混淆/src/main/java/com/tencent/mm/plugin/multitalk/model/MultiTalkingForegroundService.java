package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.v.c;
import com.tencent.luggage.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bo.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class MultiTalkingForegroundService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(54077);
        ab.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onBind");
        if (b.iW(26)) {
            ab.i("MicroMsg.MultiTalkingForegroundService", "foreground service is on bind MicroMsg.MultiTalkingForegroundService");
            String string = ah.getContext().getString(R.string.d21);
            String string2 = ah.getContext().getString(R.string.d33);
            Intent intent2 = new Intent();
            intent2.setClass(ah.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 43, intent2, 134217728);
            int i = R.drawable.bdo;
            if (d.fP(19)) {
                i = R.drawable.bdn;
            }
            c e = a.bt(ah.getContext(), "reminder_channel_id").g(string2).j(System.currentTimeMillis()).d(string).e(string2);
            e.EI = activity;
            Notification c = com.tencent.mm.plugin.voip.a.d.c(e);
            c.icon = i;
            c.flags |= 32;
            ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, c, false);
            startForeground(43, c);
        }
        AppMethodBeat.o(54077);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(54078);
        ab.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(54078);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(54079);
        ab.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onCreate");
        AppMethodBeat.o(54079);
    }

    public void onDestroy() {
        AppMethodBeat.i(54080);
        ab.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onDestroy");
        AppMethodBeat.o(54080);
    }
}
