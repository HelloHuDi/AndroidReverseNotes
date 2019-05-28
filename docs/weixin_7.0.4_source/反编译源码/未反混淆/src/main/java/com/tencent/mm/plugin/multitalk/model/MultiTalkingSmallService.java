package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.luggage.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MultiTalkingSmallService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(54081);
        ab.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onBind");
        Notification notification = (Notification) intent.getParcelableExtra("notification");
        if (b.iW(26) && notification != null) {
            startForeground(43, notification);
        }
        AppMethodBeat.o(54081);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(54082);
        ab.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(54082);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(54083);
        ab.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onCreate");
        AppMethodBeat.o(54083);
    }

    public void onDestroy() {
        AppMethodBeat.i(54084);
        ab.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onDestroy");
        AppMethodBeat.o(54084);
    }
}
