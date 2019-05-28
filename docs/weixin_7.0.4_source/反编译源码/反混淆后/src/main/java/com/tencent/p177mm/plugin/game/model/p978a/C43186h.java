package com.tencent.p177mm.plugin.game.model.p978a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.game.model.p978a.C43183a.C20983a;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.C40562qh;
import com.tencent.p177mm.protocal.protobuf.C46575qg;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.model.a.h */
public final class C43186h {

    /* renamed from: com.tencent.mm.plugin.game.model.a.h$2 */
    class C282182 implements C1224a {
        final /* synthetic */ String val$appId;

        C282182(String str) {
            this.val$appId = str;
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(111537);
            if (i == 0 && i2 == 0) {
                C40562qh c40562qh = (C40562qh) c7472b.fsH.fsP;
                if (c40562qh == null) {
                    AppMethodBeat.m2505o(111537);
                    return 0;
                }
                C4990ab.m7417i("MicroMsg.GameSilentDownloader", "op:%d", Integer.valueOf(c40562qh.f16207op));
                switch (c40562qh.f16207op) {
                    case 1:
                        ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36308Og(this.val$appId);
                        if (c40562qh.vXs != null && c40562qh.vXs.kLn != null && !C5046bo.isNullOrNil(c40562qh.vXs.kLn.egm)) {
                            C20985d Ob = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36303Ob(this.val$appId);
                            if (Ob != null) {
                                if (!c40562qh.vXs.kLn.egm.equals(C5046bo.nullAsNil(Ob.field_downloadUrl))) {
                                    C4990ab.m7417i("MicroMsg.GameSilentDownloader", "update downloadInfo. [oldDownloadUrl]:%s, [newDownloadUrl]:%s, [size]:%d, [md5]:%s, [SecondaryUrl]:%s", Ob.field_downloadUrl, c40562qh.vXs.kLn.egm, Long.valueOf(c40562qh.vXs.kLn.kKP), c40562qh.vXs.kLn.kKQ, c40562qh.vXs.kLn.kKV);
                                    if (C5046bo.isNullOrNil(Ob.field_downloadUrl)) {
                                        FileDownloadTaskInfo Is = C2896d.bij().mo7041Is(c40562qh.vXs.kLn.egm);
                                        if (!(Is == null || Is.f16167id <= 0 || Is.status == 4)) {
                                            C4990ab.m7416i("MicroMsg.GameSilentDownloader", "download task already exists");
                                            C20989f.m32246E(this.val$appId, 6, 0);
                                            ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo16760a((C4925c) Ob, new String[0]);
                                            C43186h.this.mo68678hO(false);
                                            AppMethodBeat.m2505o(111537);
                                            return 0;
                                        }
                                    }
                                    Ob.field_downloadUrl = c40562qh.vXs.kLn.egm;
                                    Ob.field_size = c40562qh.vXs.kLn.kKP;
                                    Ob.field_md5 = c40562qh.vXs.kLn.kKQ;
                                    Ob.field_SecondaryUrl = c40562qh.vXs.kLn.kKV;
                                    if (!C5046bo.isNullOrNil(c40562qh.vXs.kLn.kKO)) {
                                        Ob.field_packageName = c40562qh.vXs.kLn.kKO;
                                    }
                                    Ob.field_downloadInWidget = c40562qh.vXs.kLr;
                                    ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo10103c(Ob, new String[0]);
                                }
                                if (!C5023at.isWifi(C4996ah.getContext())) {
                                    C4990ab.m7416i("MicroMsg.GameSilentDownloader", "cgi response back, but not in wifi");
                                    break;
                                }
                                int i3 = c40562qh.vXs.kLn.kKR;
                                if (Ob != null && !C5046bo.isNullOrNil(Ob.field_downloadUrl)) {
                                    C4990ab.m7417i("MicroMsg.GameSilentDownloader", "startDownload, appId:%s, url:%s, size:%d, md5:%s, packageName:%s, expireTime:%d, isFirst:%b, nextCheckTime:%d, isRunning:%b", Ob.field_appId, Ob.field_downloadUrl, Long.valueOf(Ob.field_size), Ob.field_md5, Ob.field_packageName, Long.valueOf(Ob.field_expireTime), Boolean.valueOf(Ob.field_isFirst), Long.valueOf(Ob.field_nextCheckTime), Boolean.valueOf(Ob.field_isRunning));
                                    FileDownloadTaskInfo Is2 = C2896d.bij().mo7041Is(Ob.field_downloadUrl);
                                    long j;
                                    if (Is2 != null && Is2.f16167id > 0 && Is2.status == 2) {
                                        C4990ab.m7416i("MicroMsg.GameSilentDownloader", "resume downloadTask");
                                        j = Is2.f16167id;
                                        C2896d.bij().kMV = true;
                                        C2896d.bij().mo7050ho(j);
                                        break;
                                    }
                                    C7060h.pYm.mo8378a(858, 9, 1, false);
                                    if (Ob.field_downloadInWidget) {
                                        ((C38855d) C1720g.m3528K(C38855d.class)).mo61725Iz(Ob.field_appId);
                                    }
                                    C2901a c2901a = new C2901a();
                                    c2901a.mo7055It(Ob.field_downloadUrl);
                                    c2901a.mo7056Iu(Ob.field_SecondaryUrl);
                                    c2901a.setAppId(Ob.field_appId);
                                    c2901a.mo7066hA(Ob.field_size);
                                    c2901a.mo7062cY(Ob.field_packageName);
                                    c2901a.mo7057Iv(C46494g.m87733b(C4996ah.getContext(), C46494g.m87739bT(Ob.field_appId, true), null));
                                    c2901a.mo7058Iw(Ob.field_md5);
                                    c2901a.mo7063ga(false);
                                    c2901a.mo7064gb(false);
                                    c2901a.mo7069tN(1);
                                    c2901a.bir();
                                    c2901a.setScene(7001);
                                    C2896d.bij().kMV = true;
                                    if (i3 == 1) {
                                        j = C2896d.bij().mo7043b(c2901a.kNl);
                                    } else {
                                        j = C2896d.bij().mo7042a(c2901a.kNl);
                                    }
                                    C4990ab.m7417i("MicroMsg.GameSilentDownload.GameDownloadHelper", "add downloadTask id:%d, downloaderType:%d", Long.valueOf(j), Integer.valueOf(i3));
                                    break;
                                }
                                C4990ab.m7412e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
                                break;
                            }
                            C4990ab.m7416i("MicroMsg.GameSilentDownloader", "local SilentDownloadTask is deleted");
                            AppMethodBeat.m2505o(111537);
                            return 0;
                        }
                        C4990ab.m7412e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
                        C45405b.eBF.mo60571j(this.val$appId, 20);
                        AppMethodBeat.m2505o(111537);
                        return 0;
                        break;
                    case 2:
                        C4990ab.m7417i("MicroMsg.GameSilentDownloader", "delay, nextInterval:%d", Long.valueOf(c40562qh.vXr));
                        ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36302H(this.val$appId, C5046bo.anT() + c40562qh.vXr);
                        C43186h.this.mo68678hO(false);
                        break;
                    case 3:
                        C20989f.m32246E(this.val$appId, 5, 0);
                        C43186h.cancelDownload(this.val$appId);
                        C43186h.this.mo68678hO(false);
                        break;
                    default:
                        C45405b.eBF.mo60571j(this.val$appId, 19);
                        break;
                }
                AppMethodBeat.m2505o(111537);
                return 0;
            }
            C4990ab.m7413e("MicroMsg.GameSilentDownloader", "Check Error, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            C45405b.eBF.mo60571j(this.val$appId, 18);
            AppMethodBeat.m2505o(111537);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.a.h$a */
    public static class C43185a {
        private static C43186h mZh = new C43186h();

        static {
            AppMethodBeat.m2504i(111538);
            AppMethodBeat.m2505o(111538);
        }
    }

    /* synthetic */ C43186h(byte b) {
        this();
    }

    private C43186h() {
    }

    /* renamed from: hO */
    public final void mo68678hO(boolean z) {
        AppMethodBeat.m2504i(111539);
        while (true) {
            final C20985d bEY = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().bEY();
            if (bEY == null) {
                C4990ab.m7416i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
                AppMethodBeat.m2505o(111539);
                return;
            }
            C4990ab.m7417i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", bEY.field_appId);
            if (bEY.field_expireTime <= C5046bo.anT()) {
                C4990ab.m7417i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", bEY.field_appId);
                C20989f.m32247Oa(bEY.field_appId);
                C43186h.cancelDownload(bEY.field_appId);
                z = false;
            } else if (C5023at.isWifi(C4996ah.getContext())) {
                ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36304Oc(bEY.field_appId);
                C1720g.m3537RQ();
                if (C1720g.m3536RP().isSDCardAvailable()) {
                    ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36305Od(bEY.field_appId);
                    if (bEY.field_size <= 0 || C1445f.m3072eW(bEY.field_size)) {
                        ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36306Oe(bEY.field_appId);
                        C4990ab.m7417i("MicroMsg.GameSilentDownloader", "fromBattery：%b", Boolean.valueOf(z));
                        if (z) {
                            ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36307Of(bEY.field_appId);
                        } else {
                            C20983a bEX = C43183a.bEX();
                            C4990ab.m7417i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", Boolean.valueOf(bEX.iSd), Float.valueOf(bEX.mYY));
                            if (bEX.iSd || ((double) bEX.mYY) >= 0.2d) {
                                ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36307Of(bEY.field_appId);
                            } else {
                                C4990ab.m7416i("MicroMsg.GameSilentDownloader", "battery is low");
                                AppMethodBeat.m2505o(111539);
                                return;
                            }
                        }
                        C26006a.post(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.game.model.a.h$1$1 */
                            class C282161 implements Runnable {
                                C282161() {
                                }

                                public final void run() {
                                    AppMethodBeat.m2504i(111534);
                                    C43186h.cancelDownload(bEY.field_appId);
                                    C43186h.this.mo68678hO(false);
                                    AppMethodBeat.m2505o(111534);
                                }
                            }

                            /* renamed from: com.tencent.mm.plugin.game.model.a.h$1$2 */
                            class C282172 implements Runnable {
                                C282172() {
                                }

                                public final void run() {
                                    int i;
                                    long j = 0;
                                    AppMethodBeat.m2504i(111535);
                                    if (bEY.field_isFirst) {
                                        C20990g bDa = ((C45983c) C1720g.m3528K(C45983c.class)).bDa();
                                        if (C5046bo.isNullOrNil(bEY.field_appId)) {
                                            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
                                        } else {
                                            boolean hY = bDa.mo16768hY("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[]{"GameSilentDownload", "isFirst", "appId", bEY.field_appId}));
                                            C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", Boolean.valueOf(hY));
                                        }
                                        long j2 = bEY.field_randomTime;
                                        if (j2 > 0) {
                                            C4990ab.m7417i("MicroMsg.GameSilentDownloader", "random time interval:%d", Integer.valueOf(C5046bo.m7560gV((int) j2, 0)));
                                            j = ((long) i) + C5046bo.anT();
                                        }
                                        ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36302H(bEY.field_appId, j);
                                        if (C5046bo.anT() >= j) {
                                            i = 1;
                                        }
                                        i = 0;
                                    } else {
                                        if (C5046bo.anT() >= bEY.field_nextCheckTime) {
                                            i = 1;
                                        }
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        C43186h c43186h = C43186h.this;
                                        String str = bEY.field_appId;
                                        C4990ab.m7417i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", Integer.valueOf(1), str);
                                        C1196a c1196a = new C1196a();
                                        c1196a.fsI = 2819;
                                        c1196a.fsL = 0;
                                        c1196a.fsM = 0;
                                        c1196a.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
                                        C46575qg c46575qg = new C46575qg();
                                        c46575qg.vFH = 1;
                                        c46575qg.fKh = str;
                                        C42911a In = C2895c.m5140In(str);
                                        if (In != null) {
                                            c46575qg.vMJ = In.field_downloadUrl;
                                            c46575qg.vXq = In.field_downloadedSize;
                                        }
                                        c1196a.fsJ = c46575qg;
                                        c1196a.fsK = new C40562qh();
                                        C1226w.m2654a(c1196a.acD(), new C282182(str));
                                    }
                                    AppMethodBeat.m2505o(111535);
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(111536);
                                if (C46494g.m87726a(C4996ah.getContext(), C46494g.m87738bS(bEY.field_appId, false))) {
                                    C4990ab.m7417i("MicroMsg.GameSilentDownloader", "app is installed, appid = %s", bEY.field_appId);
                                    C20989f.m32246E(bEY.field_appId, 4, 0);
                                    C5004al.m7441d(new C282161());
                                    AppMethodBeat.m2505o(111536);
                                    return;
                                }
                                C5004al.m7441d(new C282172());
                                AppMethodBeat.m2505o(111536);
                            }
                        });
                        AppMethodBeat.m2505o(111539);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
                    AppMethodBeat.m2505o(111539);
                    return;
                }
                C4990ab.m7416i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
                AppMethodBeat.m2505o(111539);
                return;
            } else {
                C4990ab.m7416i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
                AppMethodBeat.m2505o(111539);
                return;
            }
        }
    }

    public static void pauseDownload() {
        AppMethodBeat.m2504i(111540);
        List<C20985d> bEZ = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().bEZ();
        if (C5046bo.m7548ek(bEZ)) {
            AppMethodBeat.m2505o(111540);
            return;
        }
        for (C20985d c20985d : bEZ) {
            if (c20985d != null) {
                if (c20985d.field_expireTime <= C5046bo.anT()) {
                    C4990ab.m7417i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", c20985d.field_appId);
                    C20989f.m32247Oa(c20985d.field_appId);
                    C43186h.cancelDownload(c20985d.field_appId);
                } else {
                    FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(c20985d.field_appId);
                    if (Ir != null && Ir.f16167id > 0 && Ir.status == 1) {
                        boolean hn = C43184b.m76756hn(Ir.f16167id);
                        C4990ab.m7417i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", Ir.appId, Boolean.valueOf(hn));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(111540);
    }

    static void cancelDownload(String str) {
        AppMethodBeat.m2504i(111541);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111541);
            return;
        }
        C20985d c20985d = new C20985d();
        c20985d.field_appId = str;
        C4990ab.m7417i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", str, Boolean.valueOf(((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo16760a((C4925c) c20985d, new String[0])));
        if (((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo16760a((C4925c) c20985d, new String[0])) {
            FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
            if (Ir != null && Ir.f16167id > 0) {
                C2896d.bij().mo7047hl(Ir.f16167id);
                C4990ab.m7417i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", Ir.appId);
            }
        }
        AppMethodBeat.m2505o(111541);
    }
}
