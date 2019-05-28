package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.luggage.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class VoipSmallService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(5167);
        ab.i("MicroMsg.VoipSmallService", "VoipSmallService onBind");
        Notification notification = (Notification) intent.getParcelableExtra("notification");
        if (b.iW(26) && notification != null) {
            startForeground(40, notification);
        }
        AppMethodBeat.o(5167);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(5168);
        ab.i("MicroMsg.VoipSmallService", "VoipSmallService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(5168);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(5169);
        ab.i("MicroMsg.VoipSmallService", "VoipSmallService onCreate");
        AppMethodBeat.o(5169);
    }

    public void onDestroy() {
        AppMethodBeat.i(5170);
        ab.i("MicroMsg.VoipSmallService", "VoipSmallService onDestroy");
        AppMethodBeat.o(5170);
    }
}
