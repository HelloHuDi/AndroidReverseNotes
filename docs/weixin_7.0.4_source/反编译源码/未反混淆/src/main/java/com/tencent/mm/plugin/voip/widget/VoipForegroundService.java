package com.tencent.mm.plugin.voip.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.v.c;
import com.tencent.luggage.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bo.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class VoipForegroundService extends Service {
    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(5164);
        if (b.iW(26) && intent != null) {
            CharSequence string;
            ab.i("MicroMsg.VoipForegroundService", "foreground service is on bind MicroMsg.VoipForegroundService" + intent.hasFileDescriptors());
            ab.i("MicroMsg.VoipForegroundService", "setNotificationBind");
            intent.setClass(ah.getContext(), VideoActivity.class);
            String stringExtra = intent.getStringExtra("Voip_User");
            if (intent.getBooleanExtra("Voip_VideoCall", false)) {
                string = ah.getContext().getString(R.string.f7c);
            } else if (intent.getStringExtra("mTickerText") == null) {
                string = ah.getContext().getString(R.string.f7k);
            } else {
                string = intent.getStringExtra("mTickerText");
            }
            ab.i("MicroMsg.VoipForegroundService", "voip notification type is 40");
            PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 40, intent, 134217728);
            c as = a.bt(ah.getContext(), "reminder_channel_id").g(string).j(System.currentTimeMillis()).d(s.mJ(stringExtra)).e(string).as(b.bWV());
            as.EI = activity;
            as.k(2, true);
            ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, d.c(as), false);
        }
        AppMethodBeat.o(5164);
        return 2;
    }

    public void onCreate() {
        AppMethodBeat.i(5165);
        ab.i("MicroMsg.VoipForegroundService", "VoipForegroundService onCreate");
        if (b.iW(26)) {
            c as = a.bt(ah.getContext(), "reminder_channel_id").j(System.currentTimeMillis()).as(b.bWV());
            as.k(2, true);
            startForeground(40, d.c(as));
        }
        AppMethodBeat.o(5165);
    }

    public void onDestroy() {
        AppMethodBeat.i(5166);
        ab.i("MicroMsg.VoipForegroundService", "VoipForegroundService onDestroy");
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        stopForeground(true);
        AppMethodBeat.o(5166);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(139158);
        ab.i("MicroMsg.VoipForegroundService", "onBind");
        AppMethodBeat.o(139158);
        return null;
    }

    public void onTaskRemoved(Intent intent) {
        AppMethodBeat.i(138296);
        ab.i("MicroMsg.VoipForegroundService", "onTaskRemoved: %s", intent);
        super.onTaskRemoved(intent);
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        stopSelf();
        AppMethodBeat.o(138296);
    }
}
