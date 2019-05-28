package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.v;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.service.MMService;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@k
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class UpdaterService extends MMService {
    private static UpdaterService xxh = null;
    static final long xxj = 1800000;
    private boolean caA = false;
    Map<Integer, a> xxi = new HashMap();
    private ap xxk = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(28984);
            if (UpdaterService.a(UpdaterService.this)) {
                AppMethodBeat.o(28984);
                return false;
            }
            AppMethodBeat.o(28984);
            return true;
        }
    }, true);
    private a xxl = null;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    static final class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(28986);
            if (UpdaterService.dnH() != null) {
                UpdaterService dnH = UpdaterService.dnH();
                boolean isWifi = at.isWifi(context);
                if (dnH.xxi.size() > 0) {
                    for (a pc : dnH.xxi.values()) {
                        pc.pc(isWifi);
                    }
                }
            }
            AppMethodBeat.o(28986);
        }
    }

    public UpdaterService() {
        AppMethodBeat.i(28987);
        AppMethodBeat.o(28987);
    }

    static /* synthetic */ boolean a(UpdaterService updaterService) {
        AppMethodBeat.i(28995);
        boolean dnI = updaterService.dnI();
        AppMethodBeat.o(28995);
        return dnI;
    }

    public static void ev() {
        AppMethodBeat.i(28988);
        ab.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
        if (xxh != null) {
            xxh.dnI();
        }
        AppMethodBeat.o(28988);
    }

    public static UpdaterService dnH() {
        return xxh;
    }

    public final String getTag() {
        return "MicroMsg.UpdaterService";
    }

    public final void onCreate() {
        AppMethodBeat.i(28989);
        super.onCreate();
        ab.i("MicroMsg.UpdaterService", "onCreate");
        c.l(hashCode(), this);
        xxh = this;
        this.xxi.put(Integer.valueOf(0), a.xxg);
        this.xxi.put(Integer.valueOf(1), d.dnn());
        this.xxi.put(Integer.valueOf(2), d.dnn());
        this.xxi.put(Integer.valueOf(4), com.tencent.mm.sandbox.updater.k.a.xxn);
        this.xxi.put(Integer.valueOf(5), com.tencent.mm.sandbox.updater.k.a.xxn);
        MMActivity.initLanguage(ah.getContext());
        ap apVar = this.xxk;
        long j = xxj;
        apVar.ae(j, j);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.xxl = new a();
        this.xFe.registerReceiver(this.xxl, intentFilter);
        AppMethodBeat.o(28989);
    }

    public final void onStart(Intent intent, int i) {
        AppMethodBeat.i(28990);
        ab.i("MicroMsg.UpdaterService", "onStart intent = %s", intent);
        o(intent);
        AppMethodBeat.o(28990);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(28991);
        ab.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", intent);
        if (intent != null) {
            if (intent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
                ab.i("MicroMsg.UpdaterService", "runServiceInForground");
                PendingIntent service = PendingIntent.getService(ah.getContext(), 0, new Intent(), 0);
                v.c e = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").g("updater service running forground").j(System.currentTimeMillis()).d("Updater Service").e("updater service running forground");
                e.EI = service;
                startForeground(0, e.build());
                this.caA = true;
            } else if (VERSION.SDK_INT < 18 && !this.caA) {
                startForeground(-1314, new Notification());
                this.caA = true;
            }
        }
        o(intent);
        AppMethodBeat.o(28991);
        return 2;
    }

    public final void onDestroy() {
        AppMethodBeat.i(28992);
        ab.i("MicroMsg.UpdaterService", "onDestroy");
        this.xxk.stopTimer();
        if (this.xxl != null) {
            try {
                this.xFe.unregisterReceiver(this.xxl);
            } catch (Exception e) {
                ab.e("MicroMsg.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", e.getMessage());
            }
        }
        if (this.caA) {
            dqz();
        }
        for (a onDestroy : this.xxi.values()) {
            onDestroy.onDestroy();
        }
        this.xxi.clear();
        xxh = null;
        c.m(hashCode(), this);
        super.onDestroy();
        AppMethodBeat.o(28992);
    }

    public final IBinder Iu() {
        return null;
    }

    private void o(Intent intent) {
        AppMethodBeat.i(28993);
        if (intent == null) {
            AppMethodBeat.o(28993);
            return;
        }
        ab.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 0)));
        a aVar = (a) this.xxi.get(Integer.valueOf(r0));
        if (aVar != null) {
            ab.i("MicroMsg.UpdaterService", "handleCommand ret = %b", Boolean.valueOf(aVar.aJ(intent)));
            if (!aVar.aJ(intent)) {
                dnI();
            }
        }
        AppMethodBeat.o(28993);
    }

    private boolean dnI() {
        AppMethodBeat.i(28994);
        if (this.xxi.size() > 0) {
            for (a isBusy : this.xxi.values()) {
                if (isBusy.isBusy()) {
                    ab.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
                    AppMethodBeat.o(28994);
                    return false;
                }
            }
        }
        ab.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28985);
                if (UpdaterService.this.xxi.size() > 0) {
                    for (a isBusy : UpdaterService.this.xxi.values()) {
                        if (isBusy.isBusy()) {
                            ab.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
                            AppMethodBeat.o(28985);
                            return;
                        }
                    }
                }
                if (com.tencent.mm.pluginsdk.model.v.a.dhp()) {
                    ab.i("TBSDownloadMgr", "is still busy");
                    AppMethodBeat.o(28985);
                    return;
                }
                UpdaterService.this.stopSelf();
                AppMethodBeat.o(28985);
            }
        }, 10000);
        AppMethodBeat.o(28994);
        return true;
    }
}
