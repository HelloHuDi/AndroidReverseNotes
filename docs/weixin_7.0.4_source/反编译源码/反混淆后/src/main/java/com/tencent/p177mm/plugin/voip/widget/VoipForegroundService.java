package com.tencent.p177mm.plugin.voip.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.luggage.p147g.C41711b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p546ui.VideoActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.voip.widget.VoipForegroundService */
public class VoipForegroundService extends Service {
    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(5164);
        if (C41711b.m73394iW(26) && intent != null) {
            CharSequence string;
            C4990ab.m7416i("MicroMsg.VoipForegroundService", "foreground service is on bind MicroMsg.VoipForegroundService" + intent.hasFileDescriptors());
            C4990ab.m7416i("MicroMsg.VoipForegroundService", "setNotificationBind");
            intent.setClass(C4996ah.getContext(), VideoActivity.class);
            String stringExtra = intent.getStringExtra("Voip_User");
            if (intent.getBooleanExtra("Voip_VideoCall", false)) {
                string = C4996ah.getContext().getString(C25738R.string.f7c);
            } else if (intent.getStringExtra("mTickerText") == null) {
                string = C4996ah.getContext().getString(C25738R.string.f7k);
            } else {
                string = intent.getStringExtra("mTickerText");
            }
            C4990ab.m7416i("MicroMsg.VoipForegroundService", "voip notification type is 40");
            PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 40, intent, 134217728);
            C0358c as = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(string).mo626j(System.currentTimeMillis()).mo621d(C1854s.m3866mJ(stringExtra)).mo623e(string).mo616as(C22480b.bWV());
            as.f362EI = activity;
            as.mo627k(2, true);
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41574a(40, C29488d.m46800c(as), false);
        }
        AppMethodBeat.m2505o(5164);
        return 2;
    }

    public void onCreate() {
        AppMethodBeat.m2504i(5165);
        C4990ab.m7416i("MicroMsg.VoipForegroundService", "VoipForegroundService onCreate");
        if (C41711b.m73394iW(26)) {
            C0358c as = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo626j(System.currentTimeMillis()).mo616as(C22480b.bWV());
            as.mo627k(2, true);
            startForeground(40, C29488d.m46800c(as));
        }
        AppMethodBeat.m2505o(5165);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(5166);
        C4990ab.m7416i("MicroMsg.VoipForegroundService", "VoipForegroundService onDestroy");
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
        stopForeground(true);
        AppMethodBeat.m2505o(5166);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(139158);
        C4990ab.m7416i("MicroMsg.VoipForegroundService", "onBind");
        AppMethodBeat.m2505o(139158);
        return null;
    }

    public void onTaskRemoved(Intent intent) {
        AppMethodBeat.m2504i(138296);
        C4990ab.m7417i("MicroMsg.VoipForegroundService", "onTaskRemoved: %s", intent);
        super.onTaskRemoved(intent);
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
        stopSelf();
        AppMethodBeat.m2505o(138296);
    }
}
