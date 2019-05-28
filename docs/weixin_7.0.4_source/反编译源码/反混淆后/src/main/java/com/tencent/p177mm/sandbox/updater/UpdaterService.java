package com.tencent.p177mm.sandbox.updater;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.p057v4.app.C0363v.C0358c;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C26347k;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.pluginsdk.model.C46499v.C30086a;
import com.tencent.p177mm.sandbox.C15411c;
import com.tencent.p177mm.sandbox.updater.C44215j.C23491a;
import com.tencent.p177mm.sandbox.updater.C46612k.C40610a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.service.MMService;
import java.util.HashMap;
import java.util.Map;

@C26347k
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
/* renamed from: com.tencent.mm.sandbox.updater.UpdaterService */
public class UpdaterService extends MMService {
    private static UpdaterService xxh = null;
    static final long xxj = 1800000;
    private boolean caA = false;
    Map<Integer, C40606a> xxi = new HashMap();
    private C7564ap xxk = new C7564ap(new C302761(), true);
    private C15415a xxl = null;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    /* renamed from: com.tencent.mm.sandbox.updater.UpdaterService$a */
    static final class C15415a extends BroadcastReceiver {
        C15415a() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(28986);
            if (UpdaterService.dnH() != null) {
                UpdaterService dnH = UpdaterService.dnH();
                boolean isWifi = C5023at.isWifi(context);
                if (dnH.xxi.size() > 0) {
                    for (C40606a pc : dnH.xxi.values()) {
                        pc.mo48469pc(isWifi);
                    }
                }
            }
            AppMethodBeat.m2505o(28986);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.UpdaterService$1 */
    class C302761 implements C5015a {
        C302761() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(28984);
            if (UpdaterService.m48154a(UpdaterService.this)) {
                AppMethodBeat.m2505o(28984);
                return false;
            }
            AppMethodBeat.m2505o(28984);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.UpdaterService$2 */
    class C302772 implements Runnable {
        C302772() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28985);
            if (UpdaterService.this.xxi.size() > 0) {
                for (C40606a isBusy : UpdaterService.this.xxi.values()) {
                    if (isBusy.isBusy()) {
                        C4990ab.m7416i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
                        AppMethodBeat.m2505o(28985);
                        return;
                    }
                }
            }
            if (C30086a.dhp()) {
                C4990ab.m7416i("TBSDownloadMgr", "is still busy");
                AppMethodBeat.m2505o(28985);
                return;
            }
            UpdaterService.this.stopSelf();
            AppMethodBeat.m2505o(28985);
        }
    }

    public UpdaterService() {
        AppMethodBeat.m2504i(28987);
        AppMethodBeat.m2505o(28987);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m48154a(UpdaterService updaterService) {
        AppMethodBeat.m2504i(28995);
        boolean dnI = updaterService.dnI();
        AppMethodBeat.m2505o(28995);
        return dnI;
    }

    /* renamed from: ev */
    public static void m48156ev() {
        AppMethodBeat.m2504i(28988);
        C4990ab.m7416i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
        if (xxh != null) {
            xxh.dnI();
        }
        AppMethodBeat.m2505o(28988);
    }

    public static UpdaterService dnH() {
        return xxh;
    }

    public final String getTag() {
        return "MicroMsg.UpdaterService";
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(28989);
        super.onCreate();
        C4990ab.m7416i("MicroMsg.UpdaterService", "onCreate");
        C15411c.m23691l(hashCode(), this);
        xxh = this;
        this.xxi.put(Integer.valueOf(0), C23491a.xxg);
        this.xxi.put(Integer.valueOf(1), C30279d.dnn());
        this.xxi.put(Integer.valueOf(2), C30279d.dnn());
        this.xxi.put(Integer.valueOf(4), C40610a.xxn);
        this.xxi.put(Integer.valueOf(5), C40610a.xxn);
        MMActivity.initLanguage(C4996ah.getContext());
        C7564ap c7564ap = this.xxk;
        long j = xxj;
        c7564ap.mo16770ae(j, j);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.xxl = new C15415a();
        this.xFe.registerReceiver(this.xxl, intentFilter);
        AppMethodBeat.m2505o(28989);
    }

    public final void onStart(Intent intent, int i) {
        AppMethodBeat.m2504i(28990);
        C4990ab.m7417i("MicroMsg.UpdaterService", "onStart intent = %s", intent);
        m48157o(intent);
        AppMethodBeat.m2505o(28990);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(28991);
        C4990ab.m7417i("MicroMsg.UpdaterService", "onStartCommand intent = %s", intent);
        if (intent != null) {
            if (intent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
                C4990ab.m7416i("MicroMsg.UpdaterService", "runServiceInForground");
                PendingIntent service = PendingIntent.getService(C4996ah.getContext(), 0, new Intent(), 0);
                C0358c e = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g("updater service running forground").mo626j(System.currentTimeMillis()).mo621d("Updater Service").mo623e("updater service running forground");
                e.f362EI = service;
                startForeground(0, e.build());
                this.caA = true;
            } else if (VERSION.SDK_INT < 18 && !this.caA) {
                startForeground(-1314, new Notification());
                this.caA = true;
            }
        }
        m48157o(intent);
        AppMethodBeat.m2505o(28991);
        return 2;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(28992);
        C4990ab.m7416i("MicroMsg.UpdaterService", "onDestroy");
        this.xxk.stopTimer();
        if (this.xxl != null) {
            try {
                this.xFe.unregisterReceiver(this.xxl);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", e.getMessage());
            }
        }
        if (this.caA) {
            dqz();
        }
        for (C40606a onDestroy : this.xxi.values()) {
            onDestroy.onDestroy();
        }
        this.xxi.clear();
        xxh = null;
        C15411c.m23692m(hashCode(), this);
        super.onDestroy();
        AppMethodBeat.m2505o(28992);
    }

    /* renamed from: Iu */
    public final IBinder mo10421Iu() {
        return null;
    }

    /* renamed from: o */
    private void m48157o(Intent intent) {
        AppMethodBeat.m2504i(28993);
        if (intent == null) {
            AppMethodBeat.m2505o(28993);
            return;
        }
        C4990ab.m7417i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 0)));
        C40606a c40606a = (C40606a) this.xxi.get(Integer.valueOf(r0));
        if (c40606a != null) {
            C4990ab.m7417i("MicroMsg.UpdaterService", "handleCommand ret = %b", Boolean.valueOf(c40606a.mo48466aJ(intent)));
            if (!c40606a.mo48466aJ(intent)) {
                dnI();
            }
        }
        AppMethodBeat.m2505o(28993);
    }

    private boolean dnI() {
        AppMethodBeat.m2504i(28994);
        if (this.xxi.size() > 0) {
            for (C40606a isBusy : this.xxi.values()) {
                if (isBusy.isBusy()) {
                    C4990ab.m7416i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
                    AppMethodBeat.m2505o(28994);
                    return false;
                }
            }
        }
        C4990ab.m7416i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
        C5004al.m7442n(new C302772(), 10000);
        AppMethodBeat.m2505o(28994);
        return true;
    }
}
