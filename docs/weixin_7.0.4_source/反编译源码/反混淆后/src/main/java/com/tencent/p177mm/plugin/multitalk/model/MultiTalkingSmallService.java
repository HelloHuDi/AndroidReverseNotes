package com.tencent.p177mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.luggage.p147g.C41711b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.multitalk.model.MultiTalkingSmallService */
public class MultiTalkingSmallService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(54081);
        C4990ab.m7416i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onBind");
        Notification notification = (Notification) intent.getParcelableExtra("notification");
        if (C41711b.m73394iW(26) && notification != null) {
            startForeground(43, notification);
        }
        AppMethodBeat.m2505o(54081);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(54082);
        C4990ab.m7416i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(54082);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.m2504i(54083);
        C4990ab.m7416i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onCreate");
        AppMethodBeat.m2505o(54083);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(54084);
        C4990ab.m7416i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onDestroy");
        AppMethodBeat.m2505o(54084);
    }
}
