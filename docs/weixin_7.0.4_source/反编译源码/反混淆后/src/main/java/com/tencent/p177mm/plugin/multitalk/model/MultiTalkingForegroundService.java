package com.tencent.p177mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.luggage.p147g.C41711b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.plugin.multitalk.p459ui.MultiTalkMainUI;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService */
public class MultiTalkingForegroundService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(54077);
        C4990ab.m7416i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onBind");
        if (C41711b.m73394iW(26)) {
            C4990ab.m7416i("MicroMsg.MultiTalkingForegroundService", "foreground service is on bind MicroMsg.MultiTalkingForegroundService");
            String string = C4996ah.getContext().getString(C25738R.string.d21);
            String string2 = C4996ah.getContext().getString(C25738R.string.d33);
            Intent intent2 = new Intent();
            intent2.setClass(C4996ah.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 43, intent2, 134217728);
            int i = C25738R.drawable.bdo;
            if (C1443d.m3067fP(19)) {
                i = C25738R.drawable.bdn;
            }
            C0358c e = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(string2).mo626j(System.currentTimeMillis()).mo621d(string).mo623e(string2);
            e.f362EI = activity;
            Notification c = C29488d.m46800c(e);
            c.icon = i;
            c.flags |= 32;
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41574a(43, c, false);
            startForeground(43, c);
        }
        AppMethodBeat.m2505o(54077);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(54078);
        C4990ab.m7416i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(54078);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.m2504i(54079);
        C4990ab.m7416i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onCreate");
        AppMethodBeat.m2505o(54079);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(54080);
        C4990ab.m7416i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onDestroy");
        AppMethodBeat.m2505o(54080);
    }
}
