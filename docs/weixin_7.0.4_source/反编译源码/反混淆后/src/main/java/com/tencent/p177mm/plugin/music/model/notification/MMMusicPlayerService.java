package com.tencent.p177mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.model.notification.C39447a.C345982;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.p462e.C28559e;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService */
public class MMMusicPlayerService extends Service {
    C39447a oMS;
    Runnable oMT = new C213521();

    /* renamed from: com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService$a */
    public class C21351a extends Binder {
    }

    /* renamed from: com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService$1 */
    class C213521 implements Runnable {
        C213521() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104991);
            C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "quit");
            C5004al.m7439af(MMMusicPlayerService.this.oMT);
            MMMusicPlayerService.this.stopSelf();
            AppMethodBeat.m2505o(104991);
        }
    }

    public MMMusicPlayerService() {
        AppMethodBeat.m2504i(104992);
        AppMethodBeat.m2505o(104992);
    }

    public void onCreate() {
        AppMethodBeat.m2504i(104993);
        super.onCreate();
        C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
        C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "init");
        this.oMS = new C39447a();
        C39447a c39447a = this.oMS;
        C4990ab.m7416i("MicroMsg.Music.MMMusicNotification", "init");
        c39447a.oMK = this;
        c39447a.oML = (NotificationManager) getSystemService("notification");
        c39447a.oMN = new C345982();
        registerReceiver(c39447a.oMN, new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK"));
        c39447a.bZi = true;
        refresh();
        AppMethodBeat.m2505o(104993);
    }

    /* Access modifiers changed, original: final */
    public final void refresh() {
        AppMethodBeat.m2504i(104994);
        C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
        C28575a bTU = ((C28559e) C43329b.m77295ar(C28559e.class)).bTU();
        if (bTU == null) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
            AppMethodBeat.m2505o(104994);
        } else if (C5046bo.isNullOrNil(bTU.field_protocol)) {
            C34578d bTS = C39435k.bUf().bTS();
            if (bTS == null) {
                C4990ab.m7412e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
                AppMethodBeat.m2505o(104994);
            } else if (bTS.aie()) {
                mo36804c(bTU);
                AppMethodBeat.m2505o(104994);
            } else if (bTS.aif()) {
                mo36805d(bTU);
                AppMethodBeat.m2505o(104994);
            } else {
                AppMethodBeat.m2505o(104994);
            }
        } else {
            C4990ab.m7412e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
            AppMethodBeat.m2505o(104994);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    /* renamed from: c */
    public final void mo36804c(C28575a c28575a) {
        AppMethodBeat.m2504i(104995);
        C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "play");
        if (c28575a == null) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            AppMethodBeat.m2505o(104995);
            return;
        }
        C5004al.m7439af(this.oMT);
        this.oMS.mo62390c(c28575a);
        AppMethodBeat.m2505o(104995);
    }

    /* renamed from: d */
    public final void mo36805d(C28575a c28575a) {
        AppMethodBeat.m2504i(104996);
        C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "pause");
        if (c28575a == null) {
            C4990ab.m7412e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            AppMethodBeat.m2505o(104996);
            return;
        }
        C5004al.m7439af(this.oMT);
        this.oMS.mo62392d(c28575a);
        AppMethodBeat.m2505o(104996);
    }

    public final void stop() {
        AppMethodBeat.m2504i(104997);
        C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "stop");
        this.oMS.close();
        C5004al.m7439af(this.oMT);
        C5004al.m7442n(this.oMT, 60000);
        AppMethodBeat.m2505o(104997);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104998);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
        C39447a c39447a = this.oMS;
        C4990ab.m7416i("MicroMsg.Music.MMMusicNotification", "uninit");
        c39447a.oMK.unregisterReceiver(c39447a.oMN);
        c39447a.oMN = null;
        c39447a.oMK = null;
        c39447a.oML = null;
        c39447a.bZi = false;
        AppMethodBeat.m2505o(104998);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(104999);
        C21351a c21351a = new C21351a();
        AppMethodBeat.m2505o(104999);
        return c21351a;
    }
}
