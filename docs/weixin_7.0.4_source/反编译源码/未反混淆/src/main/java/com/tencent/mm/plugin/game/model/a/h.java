package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class h {

    /* renamed from: com.tencent.mm.plugin.game.model.a.h$2 */
    class AnonymousClass2 implements com.tencent.mm.ai.w.a {
        final /* synthetic */ String val$appId;

        AnonymousClass2(String str) {
            this.val$appId = str;
        }

        public final int a(int i, int i2, String str, b bVar, m mVar) {
            AppMethodBeat.i(111537);
            if (i == 0 && i2 == 0) {
                qh qhVar = (qh) bVar.fsH.fsP;
                if (qhVar == null) {
                    AppMethodBeat.o(111537);
                    return 0;
                }
                ab.i("MicroMsg.GameSilentDownloader", "op:%d", Integer.valueOf(qhVar.op));
                switch (qhVar.op) {
                    case 1:
                        ((c) g.K(c.class)).bDa().Og(this.val$appId);
                        if (qhVar.vXs != null && qhVar.vXs.kLn != null && !bo.isNullOrNil(qhVar.vXs.kLn.egm)) {
                            d Ob = ((c) g.K(c.class)).bDa().Ob(this.val$appId);
                            if (Ob != null) {
                                if (!qhVar.vXs.kLn.egm.equals(bo.nullAsNil(Ob.field_downloadUrl))) {
                                    ab.i("MicroMsg.GameSilentDownloader", "update downloadInfo. [oldDownloadUrl]:%s, [newDownloadUrl]:%s, [size]:%d, [md5]:%s, [SecondaryUrl]:%s", Ob.field_downloadUrl, qhVar.vXs.kLn.egm, Long.valueOf(qhVar.vXs.kLn.kKP), qhVar.vXs.kLn.kKQ, qhVar.vXs.kLn.kKV);
                                    if (bo.isNullOrNil(Ob.field_downloadUrl)) {
                                        FileDownloadTaskInfo Is = d.bij().Is(qhVar.vXs.kLn.egm);
                                        if (!(Is == null || Is.id <= 0 || Is.status == 4)) {
                                            ab.i("MicroMsg.GameSilentDownloader", "download task already exists");
                                            f.E(this.val$appId, 6, 0);
                                            ((c) g.K(c.class)).bDa().a((com.tencent.mm.sdk.e.c) Ob, new String[0]);
                                            h.this.hO(false);
                                            AppMethodBeat.o(111537);
                                            return 0;
                                        }
                                    }
                                    Ob.field_downloadUrl = qhVar.vXs.kLn.egm;
                                    Ob.field_size = qhVar.vXs.kLn.kKP;
                                    Ob.field_md5 = qhVar.vXs.kLn.kKQ;
                                    Ob.field_SecondaryUrl = qhVar.vXs.kLn.kKV;
                                    if (!bo.isNullOrNil(qhVar.vXs.kLn.kKO)) {
                                        Ob.field_packageName = qhVar.vXs.kLn.kKO;
                                    }
                                    Ob.field_downloadInWidget = qhVar.vXs.kLr;
                                    ((c) g.K(c.class)).bDa().c(Ob, new String[0]);
                                }
                                if (!at.isWifi(ah.getContext())) {
                                    ab.i("MicroMsg.GameSilentDownloader", "cgi response back, but not in wifi");
                                    break;
                                }
                                int i3 = qhVar.vXs.kLn.kKR;
                                if (Ob != null && !bo.isNullOrNil(Ob.field_downloadUrl)) {
                                    ab.i("MicroMsg.GameSilentDownloader", "startDownload, appId:%s, url:%s, size:%d, md5:%s, packageName:%s, expireTime:%d, isFirst:%b, nextCheckTime:%d, isRunning:%b", Ob.field_appId, Ob.field_downloadUrl, Long.valueOf(Ob.field_size), Ob.field_md5, Ob.field_packageName, Long.valueOf(Ob.field_expireTime), Boolean.valueOf(Ob.field_isFirst), Long.valueOf(Ob.field_nextCheckTime), Boolean.valueOf(Ob.field_isRunning));
                                    FileDownloadTaskInfo Is2 = d.bij().Is(Ob.field_downloadUrl);
                                    long j;
                                    if (Is2 != null && Is2.id > 0 && Is2.status == 2) {
                                        ab.i("MicroMsg.GameSilentDownloader", "resume downloadTask");
                                        j = Is2.id;
                                        d.bij().kMV = true;
                                        d.bij().ho(j);
                                        break;
                                    }
                                    com.tencent.mm.plugin.report.service.h.pYm.a(858, 9, 1, false);
                                    if (Ob.field_downloadInWidget) {
                                        ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).Iz(Ob.field_appId);
                                    }
                                    com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                                    aVar.It(Ob.field_downloadUrl);
                                    aVar.Iu(Ob.field_SecondaryUrl);
                                    aVar.setAppId(Ob.field_appId);
                                    aVar.hA(Ob.field_size);
                                    aVar.cY(Ob.field_packageName);
                                    aVar.Iv(com.tencent.mm.pluginsdk.model.app.g.b(ah.getContext(), com.tencent.mm.pluginsdk.model.app.g.bT(Ob.field_appId, true), null));
                                    aVar.Iw(Ob.field_md5);
                                    aVar.ga(false);
                                    aVar.gb(false);
                                    aVar.tN(1);
                                    aVar.bir();
                                    aVar.setScene(7001);
                                    d.bij().kMV = true;
                                    if (i3 == 1) {
                                        j = d.bij().b(aVar.kNl);
                                    } else {
                                        j = d.bij().a(aVar.kNl);
                                    }
                                    ab.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "add downloadTask id:%d, downloaderType:%d", Long.valueOf(j), Integer.valueOf(i3));
                                    break;
                                }
                                ab.e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
                                break;
                            }
                            ab.i("MicroMsg.GameSilentDownloader", "local SilentDownloadTask is deleted");
                            AppMethodBeat.o(111537);
                            return 0;
                        }
                        ab.e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
                        com.tencent.mm.game.report.api.b.eBF.j(this.val$appId, 20);
                        AppMethodBeat.o(111537);
                        return 0;
                        break;
                    case 2:
                        ab.i("MicroMsg.GameSilentDownloader", "delay, nextInterval:%d", Long.valueOf(qhVar.vXr));
                        ((c) g.K(c.class)).bDa().H(this.val$appId, bo.anT() + qhVar.vXr);
                        h.this.hO(false);
                        break;
                    case 3:
                        f.E(this.val$appId, 5, 0);
                        h.cancelDownload(this.val$appId);
                        h.this.hO(false);
                        break;
                    default:
                        com.tencent.mm.game.report.api.b.eBF.j(this.val$appId, 19);
                        break;
                }
                AppMethodBeat.o(111537);
                return 0;
            }
            ab.e("MicroMsg.GameSilentDownloader", "Check Error, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            com.tencent.mm.game.report.api.b.eBF.j(this.val$appId, 18);
            AppMethodBeat.o(111537);
            return 0;
        }
    }

    public static class a {
        private static h mZh = new h();

        static {
            AppMethodBeat.i(111538);
            AppMethodBeat.o(111538);
        }
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
    }

    public final void hO(boolean z) {
        AppMethodBeat.i(111539);
        while (true) {
            final d bEY = ((c) g.K(c.class)).bDa().bEY();
            if (bEY == null) {
                ab.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
                AppMethodBeat.o(111539);
                return;
            }
            ab.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", bEY.field_appId);
            if (bEY.field_expireTime <= bo.anT()) {
                ab.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", bEY.field_appId);
                f.Oa(bEY.field_appId);
                cancelDownload(bEY.field_appId);
                z = false;
            } else if (at.isWifi(ah.getContext())) {
                ((c) g.K(c.class)).bDa().Oc(bEY.field_appId);
                g.RQ();
                if (g.RP().isSDCardAvailable()) {
                    ((c) g.K(c.class)).bDa().Od(bEY.field_appId);
                    if (bEY.field_size <= 0 || f.eW(bEY.field_size)) {
                        ((c) g.K(c.class)).bDa().Oe(bEY.field_appId);
                        ab.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", Boolean.valueOf(z));
                        if (z) {
                            ((c) g.K(c.class)).bDa().Of(bEY.field_appId);
                        } else {
                            com.tencent.mm.plugin.game.model.a.a.a bEX = a.bEX();
                            ab.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", Boolean.valueOf(bEX.iSd), Float.valueOf(bEX.mYY));
                            if (bEX.iSd || ((double) bEX.mYY) >= 0.2d) {
                                ((c) g.K(c.class)).bDa().Of(bEY.field_appId);
                            } else {
                                ab.i("MicroMsg.GameSilentDownloader", "battery is low");
                                AppMethodBeat.o(111539);
                                return;
                            }
                        }
                        com.tencent.mm.ce.a.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111536);
                                if (com.tencent.mm.pluginsdk.model.app.g.a(ah.getContext(), com.tencent.mm.pluginsdk.model.app.g.bS(bEY.field_appId, false))) {
                                    ab.i("MicroMsg.GameSilentDownloader", "app is installed, appid = %s", bEY.field_appId);
                                    f.E(bEY.field_appId, 4, 0);
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(111534);
                                            h.cancelDownload(bEY.field_appId);
                                            h.this.hO(false);
                                            AppMethodBeat.o(111534);
                                        }
                                    });
                                    AppMethodBeat.o(111536);
                                    return;
                                }
                                al.d(new Runnable() {
                                    public final void run() {
                                        int i;
                                        long j = 0;
                                        AppMethodBeat.i(111535);
                                        if (bEY.field_isFirst) {
                                            g bDa = ((c) g.K(c.class)).bDa();
                                            if (bo.isNullOrNil(bEY.field_appId)) {
                                                ab.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
                                            } else {
                                                boolean hY = bDa.hY("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[]{"GameSilentDownload", "isFirst", "appId", bEY.field_appId}));
                                                ab.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", Boolean.valueOf(hY));
                                            }
                                            long j2 = bEY.field_randomTime;
                                            if (j2 > 0) {
                                                ab.i("MicroMsg.GameSilentDownloader", "random time interval:%d", Integer.valueOf(bo.gV((int) j2, 0)));
                                                j = ((long) i) + bo.anT();
                                            }
                                            ((c) g.K(c.class)).bDa().H(bEY.field_appId, j);
                                            if (bo.anT() >= j) {
                                                i = 1;
                                            }
                                            i = 0;
                                        } else {
                                            if (bo.anT() >= bEY.field_nextCheckTime) {
                                                i = 1;
                                            }
                                            i = 0;
                                        }
                                        if (i != 0) {
                                            h hVar = h.this;
                                            String str = bEY.field_appId;
                                            ab.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", Integer.valueOf(1), str);
                                            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                                            aVar.fsI = 2819;
                                            aVar.fsL = 0;
                                            aVar.fsM = 0;
                                            aVar.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
                                            qg qgVar = new qg();
                                            qgVar.vFH = 1;
                                            qgVar.fKh = str;
                                            com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(str);
                                            if (In != null) {
                                                qgVar.vMJ = In.field_downloadUrl;
                                                qgVar.vXq = In.field_downloadedSize;
                                            }
                                            aVar.fsJ = qgVar;
                                            aVar.fsK = new qh();
                                            w.a(aVar.acD(), new AnonymousClass2(str));
                                        }
                                        AppMethodBeat.o(111535);
                                    }
                                });
                                AppMethodBeat.o(111536);
                            }
                        });
                        AppMethodBeat.o(111539);
                        return;
                    }
                    ab.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
                    AppMethodBeat.o(111539);
                    return;
                }
                ab.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
                AppMethodBeat.o(111539);
                return;
            } else {
                ab.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
                AppMethodBeat.o(111539);
                return;
            }
        }
    }

    public static void pauseDownload() {
        AppMethodBeat.i(111540);
        List<d> bEZ = ((c) g.K(c.class)).bDa().bEZ();
        if (bo.ek(bEZ)) {
            AppMethodBeat.o(111540);
            return;
        }
        for (d dVar : bEZ) {
            if (dVar != null) {
                if (dVar.field_expireTime <= bo.anT()) {
                    ab.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", dVar.field_appId);
                    f.Oa(dVar.field_appId);
                    cancelDownload(dVar.field_appId);
                } else {
                    FileDownloadTaskInfo Ir = d.bij().Ir(dVar.field_appId);
                    if (Ir != null && Ir.id > 0 && Ir.status == 1) {
                        boolean hn = b.hn(Ir.id);
                        ab.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", Ir.appId, Boolean.valueOf(hn));
                    }
                }
            }
        }
        AppMethodBeat.o(111540);
    }

    static void cancelDownload(String str) {
        AppMethodBeat.i(111541);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111541);
            return;
        }
        d dVar = new d();
        dVar.field_appId = str;
        ab.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", str, Boolean.valueOf(((c) g.K(c.class)).bDa().a((com.tencent.mm.sdk.e.c) dVar, new String[0])));
        if (((c) g.K(c.class)).bDa().a((com.tencent.mm.sdk.e.c) dVar, new String[0])) {
            FileDownloadTaskInfo Ir = d.bij().Ir(str);
            if (Ir != null && Ir.id > 0) {
                d.bij().hl(Ir.id);
                ab.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", Ir.appId);
            }
        }
        AppMethodBeat.o(111541);
    }
}
