package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class MMMusicPlayerService extends Service {
    a oMS;
    Runnable oMT = new Runnable() {
        public final void run() {
            AppMethodBeat.i(104991);
            ab.i("MicroMsg.Music.MMMusicPlayerService", "quit");
            al.af(MMMusicPlayerService.this.oMT);
            MMMusicPlayerService.this.stopSelf();
            AppMethodBeat.o(104991);
        }
    };

    public class a extends Binder {
    }

    public MMMusicPlayerService() {
        AppMethodBeat.i(104992);
        AppMethodBeat.o(104992);
    }

    public void onCreate() {
        AppMethodBeat.i(104993);
        super.onCreate();
        ab.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
        ab.i("MicroMsg.Music.MMMusicPlayerService", "init");
        this.oMS = new a();
        a aVar = this.oMS;
        ab.i("MicroMsg.Music.MMMusicNotification", "init");
        aVar.oMK = this;
        aVar.oML = (NotificationManager) getSystemService("notification");
        aVar.oMN = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(104972);
                if (intent == null || bo.isNullOrNil(intent.getAction())) {
                    AppMethodBeat.o(104972);
                    return;
                }
                String stringExtra = intent.getStringExtra("mm_music_notification_action_key");
                if (bo.isNullOrNil(stringExtra)) {
                    ab.e("MicroMsg.Music.MMMusicNotification", "action is null, err, return");
                    AppMethodBeat.o(104972);
                    return;
                }
                ab.i("MicroMsg.Music.MMMusicNotification", "action:%s", stringExtra);
                d bTS = k.bUf().bTS();
                if (bTS == null) {
                    ab.e("MicroMsg.Music.MMMusicNotification", "musicPlayer is null, return");
                    AppMethodBeat.o(104972);
                    return;
                }
                com.tencent.mm.plugin.music.model.e.a bTU = ((e) b.ar(e.class)).bTU();
                if (bTU == null) {
                    ab.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
                    AppMethodBeat.o(104972);
                } else if (stringExtra.equals("mm_music_notification_action_play")) {
                    bTS.resume();
                    com.tencent.mm.plugin.music.model.d.d.a(2, bTU);
                    AppMethodBeat.o(104972);
                } else if (stringExtra.equals("mm_music_notification_action_pause")) {
                    bTS.bSN();
                    k.bUh().bSK();
                    com.tencent.mm.plugin.music.model.d.d.a(3, bTU);
                    AppMethodBeat.o(104972);
                } else if (stringExtra.equals("mm_music_notification_action_pre")) {
                    if (bTU.field_musicType == 11) {
                        k.bUf().ju(true);
                    } else if (((e) b.ar(e.class)).getMode() == 2) {
                        ((e) b.ar(e.class)).bTZ();
                    } else {
                        bTS.lP(0);
                        bTS.resume();
                    }
                    a.a(bTU, 13, bTS.bSO());
                    com.tencent.mm.plugin.music.model.d.d.a(1, bTU);
                    AppMethodBeat.o(104972);
                } else if (stringExtra.equals("mm_music_notification_action_next")) {
                    if (bTU.field_musicType == 11) {
                        k.bUf().ju(true);
                    } else if (((e) b.ar(e.class)).getMode() == 2) {
                        ((e) b.ar(e.class)).bTY();
                    } else {
                        bTS.lP(0);
                        bTS.resume();
                    }
                    a.a(bTU, 14, bTS.bSO());
                    com.tencent.mm.plugin.music.model.d.d.a(4, bTU);
                    AppMethodBeat.o(104972);
                } else {
                    if (stringExtra.equals("mm_music_notification_action_close")) {
                        al.d(a.this.oMM);
                        bTS.stopPlay();
                        com.tencent.mm.plugin.music.model.d.d.a(5, bTU);
                    }
                    AppMethodBeat.o(104972);
                }
            }
        };
        registerReceiver(aVar.oMN, new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK"));
        aVar.bZi = true;
        refresh();
        AppMethodBeat.o(104993);
    }

    /* Access modifiers changed, original: final */
    public final void refresh() {
        AppMethodBeat.i(104994);
        ab.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
        com.tencent.mm.plugin.music.model.e.a bTU = ((e) b.ar(e.class)).bTU();
        if (bTU == null) {
            ab.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
            AppMethodBeat.o(104994);
        } else if (bo.isNullOrNil(bTU.field_protocol)) {
            d bTS = k.bUf().bTS();
            if (bTS == null) {
                ab.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
                AppMethodBeat.o(104994);
            } else if (bTS.aie()) {
                c(bTU);
                AppMethodBeat.o(104994);
            } else if (bTS.aif()) {
                d(bTU);
                AppMethodBeat.o(104994);
            } else {
                AppMethodBeat.o(104994);
            }
        } else {
            ab.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
            AppMethodBeat.o(104994);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public final void c(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(104995);
        ab.i("MicroMsg.Music.MMMusicPlayerService", "play");
        if (aVar == null) {
            ab.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            AppMethodBeat.o(104995);
            return;
        }
        al.af(this.oMT);
        this.oMS.c(aVar);
        AppMethodBeat.o(104995);
    }

    public final void d(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(104996);
        ab.i("MicroMsg.Music.MMMusicPlayerService", "pause");
        if (aVar == null) {
            ab.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            AppMethodBeat.o(104996);
            return;
        }
        al.af(this.oMT);
        this.oMS.d(aVar);
        AppMethodBeat.o(104996);
    }

    public final void stop() {
        AppMethodBeat.i(104997);
        ab.i("MicroMsg.Music.MMMusicPlayerService", "stop");
        this.oMS.close();
        al.af(this.oMT);
        al.n(this.oMT, 60000);
        AppMethodBeat.o(104997);
    }

    public void onDestroy() {
        AppMethodBeat.i(104998);
        super.onDestroy();
        ab.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
        a aVar = this.oMS;
        ab.i("MicroMsg.Music.MMMusicNotification", "uninit");
        aVar.oMK.unregisterReceiver(aVar.oMN);
        aVar.oMN = null;
        aVar.oMK = null;
        aVar.oML = null;
        aVar.bZi = false;
        AppMethodBeat.o(104998);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(104999);
        a aVar = new a();
        AppMethodBeat.o(104999);
        return aVar;
    }
}
