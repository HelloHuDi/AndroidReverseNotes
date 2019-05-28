package com.tencent.p177mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.luggage.p147g.C41711b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip.widget.VoipSmallService */
public class VoipSmallService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(5167);
        C4990ab.m7416i("MicroMsg.VoipSmallService", "VoipSmallService onBind");
        Notification notification = (Notification) intent.getParcelableExtra("notification");
        if (C41711b.m73394iW(26) && notification != null) {
            startForeground(40, notification);
        }
        AppMethodBeat.m2505o(5167);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(5168);
        C4990ab.m7416i("MicroMsg.VoipSmallService", "VoipSmallService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(5168);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.m2504i(5169);
        C4990ab.m7416i("MicroMsg.VoipSmallService", "VoipSmallService onCreate");
        AppMethodBeat.m2505o(5169);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(5170);
        C4990ab.m7416i("MicroMsg.VoipSmallService", "VoipSmallService onDestroy");
        AppMethodBeat.m2505o(5170);
    }
}
