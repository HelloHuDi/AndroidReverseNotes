package com.tencent.mm.plugin.sport.model;

import android.app.Notification.Builder;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

public class SportForegroundService extends Service {
    private static boolean rPJ;
    private ak ilv;

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(93695);
        ab.i("MicroMsg.Sport.SportForegroundService", "onStartCommand %d", Integer.valueOf(i2));
        if (d.iW(26)) {
            Builder builder = new Builder(getApplicationContext(), "reminder_channel_id");
            builder.setContentTitle(ah.getResources().getString(R.string.erq)).setWhen(System.currentTimeMillis());
            startForeground(419430, builder.build());
            ab.i("MicroMsg.Sport.SportForegroundService", "onStartCommand startForeground");
            ((PluginSport) g.M(PluginSport.class)).getPushSportStepDetector().cwj();
            this.ilv = new ak(Looper.getMainLooper());
            this.ilv.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(93694);
                    SportForegroundService.cwA();
                    AppMethodBeat.o(93694);
                }
            }, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
        int onStartCommand = super.onStartCommand(intent, i, i2);
        AppMethodBeat.o(93695);
        return onStartCommand;
    }

    public void onDestroy() {
        AppMethodBeat.i(93696);
        ab.i("MicroMsg.Sport.SportForegroundService", "onDestroy");
        if (this.ilv != null) {
            this.ilv.removeCallbacksAndMessages(null);
        }
        stopForeground(true);
        super.onDestroy();
        AppMethodBeat.o(93696);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void cwz() {
        AppMethodBeat.i(93697);
        if (d.iW(26) && !rPJ) {
            ab.i("MicroMsg.Sport.SportForegroundService", "startSportForegroundService");
            rPJ = true;
            try {
                ah.getContext().startForegroundService(new Intent(ah.getContext(), SportForegroundService.class));
                AppMethodBeat.o(93697);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(93697);
    }

    public static void cwA() {
        AppMethodBeat.i(93698);
        if (d.iW(26) && rPJ) {
            ab.i("MicroMsg.Sport.SportForegroundService", "stopSportForegroundService");
            rPJ = false;
            try {
                ah.getContext().stopService(new Intent(ah.getContext(), SportForegroundService.class));
                AppMethodBeat.o(93698);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(93698);
    }

    public static boolean cwB() {
        return rPJ;
    }
}
