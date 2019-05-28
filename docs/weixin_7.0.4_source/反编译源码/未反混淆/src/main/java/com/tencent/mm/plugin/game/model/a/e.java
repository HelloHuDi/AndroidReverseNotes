package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class e {
    private static int kNC = -1;
    private static b mYZ;
    private static a mZa;
    private static c mZb;
    private static c mZc = new c<hb>() {
        {
            AppMethodBeat.i(111508);
            this.xxI = hb.class.getName().hashCode();
            AppMethodBeat.o(111508);
        }

        private static boolean a(hb hbVar) {
            AppMethodBeat.i(111509);
            switch (hbVar.cBM.cuy) {
                case 2:
                    if (bo.fp(bo.c((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_GAME_SILENT_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 300) {
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_GAME_SILENT_DOWNLOAD_TIME_LONG, Long.valueOf(bo.anT()));
                        com.tencent.mm.plugin.game.model.a.h.a.mZh.hO(false);
                        break;
                    }
                    break;
                case 3:
                    String str = hbVar.cBM.csB;
                    if (!bo.isNullOrNil(str)) {
                        d dVar = new d();
                        dVar.field_appId = str;
                        ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bDa().a((com.tencent.mm.sdk.e.c) dVar, new String[0]);
                        ab.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", str);
                        break;
                    }
                    boolean hY = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bDa().hY("GameSilentDownload", String.format("delete from %s", new Object[]{"GameSilentDownload"}));
                    ab.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", Boolean.valueOf(hY));
                    break;
                case 4:
                    String str2 = hbVar.cBM.csB;
                    if (!bo.isNullOrNil(str2)) {
                        com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(str2);
                        if (In != null) {
                            d.bij().hl(In.field_downloadId);
                            com.tencent.mm.plugin.downloader.model.c.hw(In.field_downloadId);
                            ab.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", str2);
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(111509);
            return false;
        }
    };
    private static c mZd = new c<ha>() {
        {
            AppMethodBeat.i(111511);
            this.xxI = ha.class.getName().hashCode();
            AppMethodBeat.o(111511);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(111512);
            String str = ((ha) bVar).cBL.csB;
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.GameSilentDownloadListener", "GameSilentDownloadEvent, appid is null!");
                AppMethodBeat.o(111512);
            } else {
                f.X(str, 7, 0);
                d dVar = new d();
                dVar.field_appId = str;
                boolean a = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bDa().a((com.tencent.mm.sdk.e.c) dVar, new String[0]);
                ab.i("MicroMsg.GameSilentDownloadListener", "cancel silentDownloadTask, appid:%s, ret:%b", str, Boolean.valueOf(a));
                AppMethodBeat.o(111512);
            }
            return false;
        }
    };

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(111513);
            if (!g.RK() || com.tencent.mm.kernel.a.QT()) {
                ab.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
                AppMethodBeat.o(111513);
            } else if (intent == null) {
                AppMethodBeat.o(111513);
            } else if ("android.intent.action.BATTERY_OKAY".equals(intent.getAction())) {
                ab.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
                com.tencent.mm.plugin.game.model.a.h.a.mZh.hO(true);
                AppMethodBeat.o(111513);
            } else {
                if ("android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                    ab.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
                    com.tencent.mm.plugin.game.model.a.h.a.mZh;
                    h.pauseDownload();
                }
                AppMethodBeat.o(111513);
            }
        }
    }

    static class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(111514);
            if (!g.RK() || com.tencent.mm.kernel.a.QT()) {
                ab.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
                AppMethodBeat.o(111514);
                return;
            }
            int netType = at.getNetType(ah.getContext());
            if (netType == e.kNC) {
                AppMethodBeat.o(111514);
                return;
            }
            e.kNC = netType;
            if (netType == 0) {
                ab.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, checkDownload", Integer.valueOf(netType));
                com.tencent.mm.plugin.game.model.a.h.a.mZh.hO(false);
                AppMethodBeat.o(111514);
                return;
            }
            ab.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, pauseDownload", Integer.valueOf(netType));
            com.tencent.mm.plugin.game.model.a.h.a.mZh;
            h.pauseDownload();
            AppMethodBeat.o(111514);
        }
    }

    static {
        AppMethodBeat.i(111517);
        AppMethodBeat.o(111517);
    }

    public static void bie() {
        IntentFilter intentFilter;
        AppMethodBeat.i(111515);
        try {
            if (mYZ == null) {
                mYZ = new b();
            }
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            ah.getContext().registerReceiver(mYZ, intentFilter);
        } catch (Exception e) {
            ab.i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", e.getMessage());
        }
        try {
            if (mZa == null) {
                mZa = new a();
            }
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_OKAY");
            intentFilter.addAction("android.intent.action.BATTERY_LOW");
            ah.getContext().registerReceiver(mZa, intentFilter);
        } catch (Exception e2) {
            ab.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", e2.getMessage());
        }
        com.tencent.mm.sdk.b.a.xxA.c(mZc);
        com.tencent.mm.sdk.b.a.xxA.c(mZd);
        if (mZb == null) {
            mZb = new c();
        }
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.a(mZb);
        AppMethodBeat.o(111515);
    }

    public static void bgr() {
        AppMethodBeat.i(111516);
        if (mYZ != null) {
            try {
                ah.getContext().unregisterReceiver(mYZ);
            } catch (Exception e) {
                ab.i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", e.getMessage());
            }
            mYZ = null;
        }
        if (mZa != null) {
            try {
                ah.getContext().unregisterReceiver(mZa);
            } catch (Exception e2) {
                ab.i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", e2.getMessage());
            }
            mZa = null;
        }
        com.tencent.mm.sdk.b.a.xxA.d(mZc);
        com.tencent.mm.sdk.b.a.xxA.d(mZd);
        if (mZb != null) {
            d.bij();
            com.tencent.mm.plugin.downloader.model.b.b(mZb);
            mZb = null;
        }
        AppMethodBeat.o(111516);
    }
}
