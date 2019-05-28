package com.tencent.p177mm.plugin.game.model.p978a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C41997hb;
import com.tencent.p177mm.p230g.p231a.C45331ha;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.game.model.p978a.C43186h.C43185a;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.game.model.a.e */
public final class C20986e {
    private static int kNC = -1;
    private static C12155b mYZ;
    private static C12154a mZa;
    private static C20984c mZb;
    private static C4884c mZc = new C209871();
    private static C4884c mZd = new C209882();

    /* renamed from: com.tencent.mm.plugin.game.model.a.e$a */
    static class C12154a extends BroadcastReceiver {
        private C12154a() {
        }

        /* synthetic */ C12154a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(111513);
            if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                C4990ab.m7412e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
                AppMethodBeat.m2505o(111513);
            } else if (intent == null) {
                AppMethodBeat.m2505o(111513);
            } else if ("android.intent.action.BATTERY_OKAY".equals(intent.getAction())) {
                C4990ab.m7416i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
                C43185a.mZh.mo68678hO(true);
                AppMethodBeat.m2505o(111513);
            } else {
                if ("android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                    C4990ab.m7416i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
                    C43185a.mZh;
                    C43186h.pauseDownload();
                }
                AppMethodBeat.m2505o(111513);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.a.e$b */
    static class C12155b extends BroadcastReceiver {
        private C12155b() {
        }

        /* synthetic */ C12155b(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(111514);
            if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                C4990ab.m7412e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
                AppMethodBeat.m2505o(111514);
                return;
            }
            int netType = C5023at.getNetType(C4996ah.getContext());
            if (netType == C20986e.kNC) {
                AppMethodBeat.m2505o(111514);
                return;
            }
            C20986e.kNC = netType;
            if (netType == 0) {
                C4990ab.m7417i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, checkDownload", Integer.valueOf(netType));
                C43185a.mZh.mo68678hO(false);
                AppMethodBeat.m2505o(111514);
                return;
            }
            C4990ab.m7417i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, pauseDownload", Integer.valueOf(netType));
            C43185a.mZh;
            C43186h.pauseDownload();
            AppMethodBeat.m2505o(111514);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.a.e$1 */
    static class C209871 extends C4884c<C41997hb> {
        C209871() {
            AppMethodBeat.m2504i(111508);
            this.xxI = C41997hb.class.getName().hashCode();
            AppMethodBeat.m2505o(111508);
        }

        /* renamed from: a */
        private static boolean m32243a(C41997hb c41997hb) {
            AppMethodBeat.m2504i(111509);
            switch (c41997hb.cBM.cuy) {
                case 2:
                    if (C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GAME_SILENT_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 300) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GAME_SILENT_DOWNLOAD_TIME_LONG, Long.valueOf(C5046bo.anT()));
                        C43185a.mZh.mo68678hO(false);
                        break;
                    }
                    break;
                case 3:
                    String str = c41997hb.cBM.csB;
                    if (!C5046bo.isNullOrNil(str)) {
                        C20985d c20985d = new C20985d();
                        c20985d.field_appId = str;
                        ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo16760a((C4925c) c20985d, new String[0]);
                        C4990ab.m7417i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", str);
                        break;
                    }
                    boolean hY = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo16768hY("GameSilentDownload", String.format("delete from %s", new Object[]{"GameSilentDownload"}));
                    C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", Boolean.valueOf(hY));
                    break;
                case 4:
                    String str2 = c41997hb.cBM.csB;
                    if (!C5046bo.isNullOrNil(str2)) {
                        C42911a In = C2895c.m5140In(str2);
                        if (In != null) {
                            C2896d.bij().mo7047hl(In.field_downloadId);
                            C2895c.m5148hw(In.field_downloadId);
                            C4990ab.m7417i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", str2);
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(111509);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.a.e$2 */
    static class C209882 extends C4884c<C45331ha> {
        C209882() {
            AppMethodBeat.m2504i(111511);
            this.xxI = C45331ha.class.getName().hashCode();
            AppMethodBeat.m2505o(111511);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111512);
            String str = ((C45331ha) c4883b).cBL.csB;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.GameSilentDownloadListener", "GameSilentDownloadEvent, appid is null!");
                AppMethodBeat.m2505o(111512);
            } else {
                C20989f.m32248X(str, 7, 0);
                C20985d c20985d = new C20985d();
                c20985d.field_appId = str;
                boolean a = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo16760a((C4925c) c20985d, new String[0]);
                C4990ab.m7417i("MicroMsg.GameSilentDownloadListener", "cancel silentDownloadTask, appid:%s, ret:%b", str, Boolean.valueOf(a));
                AppMethodBeat.m2505o(111512);
            }
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(111517);
        AppMethodBeat.m2505o(111517);
    }

    public static void bie() {
        IntentFilter intentFilter;
        AppMethodBeat.m2504i(111515);
        try {
            if (mYZ == null) {
                mYZ = new C12155b();
            }
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            C4996ah.getContext().registerReceiver(mYZ, intentFilter);
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", e.getMessage());
        }
        try {
            if (mZa == null) {
                mZa = new C12154a();
            }
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_OKAY");
            intentFilter.addAction("android.intent.action.BATTERY_LOW");
            C4996ah.getContext().registerReceiver(mZa, intentFilter);
        } catch (Exception e2) {
            C4990ab.m7417i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", e2.getMessage());
        }
        C4879a.xxA.mo10052c(mZc);
        C4879a.xxA.mo10052c(mZd);
        if (mZb == null) {
            mZb = new C20984c();
        }
        C2896d.bij();
        C2886b.m5129a(mZb);
        AppMethodBeat.m2505o(111515);
    }

    public static void bgr() {
        AppMethodBeat.m2504i(111516);
        if (mYZ != null) {
            try {
                C4996ah.getContext().unregisterReceiver(mYZ);
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", e.getMessage());
            }
            mYZ = null;
        }
        if (mZa != null) {
            try {
                C4996ah.getContext().unregisterReceiver(mZa);
            } catch (Exception e2) {
                C4990ab.m7417i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", e2.getMessage());
            }
            mZa = null;
        }
        C4879a.xxA.mo10053d(mZc);
        C4879a.xxA.mo10053d(mZd);
        if (mZb != null) {
            C2896d.bij();
            C2886b.m5130b(mZb);
            mZb = null;
        }
        AppMethodBeat.m2505o(111516);
    }
}
