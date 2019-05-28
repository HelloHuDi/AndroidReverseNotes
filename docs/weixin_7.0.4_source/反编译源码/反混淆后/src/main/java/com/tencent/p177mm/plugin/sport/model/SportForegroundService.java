package com.tencent.p177mm.plugin.sport.model;

import android.app.Notification.Builder;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.sport.PluginSport;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.sport.model.SportForegroundService */
public class SportForegroundService extends Service {
    private static boolean rPJ;
    private C7306ak ilv;

    /* renamed from: com.tencent.mm.plugin.sport.model.SportForegroundService$1 */
    class C292601 implements Runnable {
        C292601() {
        }

        public final void run() {
            AppMethodBeat.m2504i(93694);
            SportForegroundService.cwA();
            AppMethodBeat.m2505o(93694);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(93695);
        C4990ab.m7417i("MicroMsg.Sport.SportForegroundService", "onStartCommand %d", Integer.valueOf(i2));
        if (C1443d.m3068iW(26)) {
            Builder builder = new Builder(getApplicationContext(), "reminder_channel_id");
            builder.setContentTitle(C4996ah.getResources().getString(C25738R.string.erq)).setWhen(System.currentTimeMillis());
            startForeground(419430, builder.build());
            C4990ab.m7416i("MicroMsg.Sport.SportForegroundService", "onStartCommand startForeground");
            ((PluginSport) C1720g.m3530M(PluginSport.class)).getPushSportStepDetector().cwj();
            this.ilv = new C7306ak(Looper.getMainLooper());
            this.ilv.postDelayed(new C292601(), ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
        int onStartCommand = super.onStartCommand(intent, i, i2);
        AppMethodBeat.m2505o(93695);
        return onStartCommand;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(93696);
        C4990ab.m7416i("MicroMsg.Sport.SportForegroundService", "onDestroy");
        if (this.ilv != null) {
            this.ilv.removeCallbacksAndMessages(null);
        }
        stopForeground(true);
        super.onDestroy();
        AppMethodBeat.m2505o(93696);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void cwz() {
        AppMethodBeat.m2504i(93697);
        if (C1443d.m3068iW(26) && !rPJ) {
            C4990ab.m7416i("MicroMsg.Sport.SportForegroundService", "startSportForegroundService");
            rPJ = true;
            try {
                C4996ah.getContext().startForegroundService(new Intent(C4996ah.getContext(), SportForegroundService.class));
                AppMethodBeat.m2505o(93697);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(93697);
    }

    public static void cwA() {
        AppMethodBeat.m2504i(93698);
        if (C1443d.m3068iW(26) && rPJ) {
            C4990ab.m7416i("MicroMsg.Sport.SportForegroundService", "stopSportForegroundService");
            rPJ = false;
            try {
                C4996ah.getContext().stopService(new Intent(C4996ah.getContext(), SportForegroundService.class));
                AppMethodBeat.m2505o(93698);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(93698);
    }

    public static boolean cwB() {
        return rPJ;
    }
}
