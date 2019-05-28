package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v4.app.v.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static int hzH = 2;
    private static Map<Long, Long> kMM = new HashMap();
    private static d kMU;
    private l kMN;
    private l kMO;
    private l kMP;
    private a kMQ;
    private a kMR;
    private l kMS;
    public b kMT;
    public boolean kMV = false;

    /* renamed from: com.tencent.mm.plugin.downloader.model.d$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.downloader.f.a kMF;
        final /* synthetic */ boolean kML;

        AnonymousClass2(com.tencent.mm.plugin.downloader.f.a aVar, boolean z) {
            this.kMF = aVar;
            this.kML = z;
        }

        public final void run() {
            AppMethodBeat.i(2408);
            PendingIntent pendingIntent = null;
            if (this.kMF.field_fileType == 1) {
                pendingIntent = d.a(this.kMF.field_filePath, this.kMF);
            }
            if (this.kMF.field_showNotification && bo.isNullOrNil(this.kMF.field_fileName)) {
                d.b(this.kMF.field_appId, ah.getContext().getString(R.string.bso), "", pendingIntent);
            } else if (this.kMF.field_showNotification && !bo.isNullOrNil(this.kMF.field_fileName)) {
                d.b(this.kMF.field_appId, this.kMF.field_fileName, ah.getContext().getString(R.string.bso), pendingIntent);
            }
            if (this.kMF.field_autoInstall && this.kMF.field_fileType == 1 && !this.kMF.field_reserveInWifi) {
                d.f(this.kMF);
            }
            d.this.kMT.c(this.kMF.field_downloadId, this.kMF.field_filePath, this.kML);
            AppMethodBeat.o(2408);
        }
    }

    static /* synthetic */ void b(String str, String str2, String str3, PendingIntent pendingIntent) {
        AppMethodBeat.i(2436);
        a(str, str2, str3, pendingIntent);
        AppMethodBeat.o(2436);
    }

    static {
        AppMethodBeat.i(2438);
        AppMethodBeat.o(2438);
    }

    public static d bij() {
        AppMethodBeat.i(2409);
        if (kMU == null) {
            kMU = new d();
        }
        d dVar = kMU;
        AppMethodBeat.o(2409);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(2410);
        biq();
        if (g.RN().QY()) {
            g.RN();
            if (!com.tencent.mm.kernel.a.QT()) {
                hzH = bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("FileDownloaderType"), 2);
                ab.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", Integer.valueOf(hzH));
                this.kMT = new b();
                AppMethodBeat.o(2410);
            }
        }
        ab.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
        this.kMT = new b();
        AppMethodBeat.o(2410);
    }

    public final l bik() {
        AppMethodBeat.i(2411);
        ab.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + hzH);
        l lVar;
        if (this.kMN != null) {
            lVar = this.kMN;
            AppMethodBeat.o(2411);
            return lVar;
        }
        hr hrVar = new hr();
        com.tencent.mm.sdk.b.a.xxA.m(hrVar);
        int i = hrVar.cCC.cBA;
        if (i > 0) {
            hzH = i;
        }
        if (hzH == 1) {
            this.kMN = bil();
        } else {
            this.kMN = bin();
        }
        lVar = this.kMN;
        AppMethodBeat.o(2411);
        return lVar;
    }

    private l bil() {
        AppMethodBeat.i(2412);
        if (this.kMP == null) {
            this.kMP = new g(this.kMT);
        }
        l lVar = this.kMP;
        AppMethodBeat.o(2412);
        return lVar;
    }

    private l bim() {
        AppMethodBeat.i(2413);
        if (this.kMO == null) {
            this.kMO = new i(this.kMT);
        }
        l lVar = this.kMO;
        AppMethodBeat.o(2413);
        return lVar;
    }

    public final a bin() {
        AppMethodBeat.i(2414);
        if (this.kMQ == null) {
            this.kMQ = new a(this.kMT);
        }
        a aVar = this.kMQ;
        AppMethodBeat.o(2414);
        return aVar;
    }

    public final a bio() {
        AppMethodBeat.i(2415);
        if (this.kMR == null) {
            this.kMR = new a(this.kMT);
        }
        a aVar = this.kMR;
        AppMethodBeat.o(2415);
        return aVar;
    }

    private l bip() {
        AppMethodBeat.i(2416);
        if (this.kMS == null) {
            this.kMS = new j(this.kMT);
        }
        l lVar = this.kMS;
        AppMethodBeat.o(2416);
        return lVar;
    }

    public final long a(e eVar) {
        AppMethodBeat.i(2417);
        ab.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", Integer.valueOf(eVar.kNb), eVar.mAppId);
        long a;
        if (eVar.kNb == 2) {
            a = bip().a(eVar);
            AppMethodBeat.o(2417);
            return a;
        }
        a(eVar.mAppId, eVar);
        if (g.RN().QY()) {
            g.RN();
            if (!com.tencent.mm.kernel.a.QT()) {
                a = bik().a(eVar);
                AppMethodBeat.o(2417);
                return a;
            }
        }
        a = bil().a(eVar);
        if (a >= 0) {
            kMM.put(Long.valueOf(a), Long.valueOf(0));
            ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            ab.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            AppMethodBeat.o(2417);
            return a;
        }
        ab.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        bim().a(eVar);
        AppMethodBeat.o(2417);
        return a;
    }

    public final long b(e eVar) {
        long a;
        AppMethodBeat.i(2418);
        ab.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", eVar.mAppId);
        a(eVar.mAppId, eVar);
        if (g.RN().QY()) {
            g.RN();
            if (!com.tencent.mm.kernel.a.QT()) {
                a = bio().a(eVar);
                AppMethodBeat.o(2418);
                return a;
            }
        }
        a = bil().a(eVar);
        if (a >= 0) {
            kMM.put(Long.valueOf(a), Long.valueOf(0));
            ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            ab.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            AppMethodBeat.o(2418);
            return a;
        }
        ab.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        bim().a(eVar);
        AppMethodBeat.o(2418);
        return a;
    }

    public final int hl(long j) {
        AppMethodBeat.i(2419);
        ab.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(j)));
        int hl;
        if (hx(j)) {
            hl = bil().hl(j);
            AppMethodBeat.o(2419);
            return hl;
        }
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null && (hv.field_downloadInWifi || hv.field_reserveInWifi)) {
            hv.field_downloadInWifi = false;
            hv.field_reserveInWifi = false;
            c.e(hv);
        }
        if (hv == null || hv.field_downloaderType != 3) {
            hl = bik().hl(j);
            AppMethodBeat.o(2419);
            return hl;
        }
        hl = bio().hl(j);
        AppMethodBeat.o(2419);
        return hl;
    }

    public final FileDownloadTaskInfo hm(long j) {
        AppMethodBeat.i(2420);
        FileDownloadTaskInfo hm;
        if (hx(j)) {
            hm = bil().hm(j);
            AppMethodBeat.o(2420);
            return hm;
        }
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null && hv.field_status == 3 && e.ct(hv.field_filePath)) {
            hm = new FileDownloadTaskInfo();
            hm.id = j;
            hm.url = hv.field_downloadUrl;
            hm.status = 3;
            hm.path = hv.field_filePath;
            hm.cvZ = hv.field_md5;
            hm.kNr = hv.field_downloadedSize;
            hm.jrb = hv.field_totalSize;
            hm.kNs = hv.field_autoDownload;
            hm.cBA = hv.field_downloaderType;
        } else if (hv == null || hv.field_downloaderType != 3) {
            hm = bik().hm(j);
            if (hv != null) {
                hm.kNs = hv.field_autoDownload;
                hm.cBA = hv.field_downloaderType;
            }
        } else {
            hm = bio().hm(j);
        }
        if (hm == null) {
            hm = new FileDownloadTaskInfo();
        }
        if (hm.status == 3 || hm.status == 6) {
            if (!e.ct(hm.path)) {
                hm.status = 0;
            } else if (hm.status == 6) {
                hm.status = 1;
            }
        }
        if (hv != null) {
            hm.kNt = hv.field_downloadInWifi;
            hm.appId = hv.field_appId;
            hm.kNu = hv.field_reserveInWifi;
        }
        ab.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", Long.valueOf(hm.id), hm.url, Integer.valueOf(hm.status), hm.path, hm.cvZ, Long.valueOf(hm.jrb), Boolean.valueOf(hm.kNs), Integer.valueOf(hm.cBA));
        AppMethodBeat.o(2420);
        return hm;
    }

    public final FileDownloadTaskInfo Ir(String str) {
        AppMethodBeat.i(2421);
        com.tencent.mm.plugin.downloader.f.a In = c.In(str);
        FileDownloadTaskInfo hm;
        if (In != null) {
            hm = hm(In.field_downloadId);
            AppMethodBeat.o(2421);
            return hm;
        }
        hm = new FileDownloadTaskInfo();
        AppMethodBeat.o(2421);
        return hm;
    }

    public final FileDownloadTaskInfo Is(String str) {
        AppMethodBeat.i(2422);
        com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
        FileDownloadTaskInfo hm;
        if (Iq != null) {
            hm = hm(Iq.field_downloadId);
            AppMethodBeat.o(2422);
            return hm;
        }
        hm = new FileDownloadTaskInfo();
        AppMethodBeat.o(2422);
        return hm;
    }

    public final boolean hn(long j) {
        AppMethodBeat.i(2424);
        ab.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(j)));
        hz(j);
        boolean hn;
        if (hx(j)) {
            hn = bil().hn(j);
            AppMethodBeat.o(2424);
            return hn;
        }
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null && (hv.field_downloadInWifi || hv.field_reserveInWifi)) {
            hv.field_downloadInWifi = false;
            hv.field_reserveInWifi = false;
            c.e(hv);
        }
        if (hv == null || hv.field_downloaderType != 3) {
            hn = bik().hn(j);
            AppMethodBeat.o(2424);
            return hn;
        }
        hn = bio().hn(j);
        AppMethodBeat.o(2424);
        return hn;
    }

    public final boolean ho(long j) {
        AppMethodBeat.i(2425);
        ab.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(j)));
        hz(j);
        boolean ho;
        if (hx(j)) {
            ho = bil().ho(j);
            AppMethodBeat.o(2425);
            return ho;
        }
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (!(hv == null || hv.field_reserveInWifi || !hv.field_downloadInWifi)) {
            hv.field_downloadInWifi = false;
            c.e(hv);
        }
        if (hv == null || hv.field_downloaderType != 3) {
            ho = bik().ho(j);
            AppMethodBeat.o(2425);
            return ho;
        }
        ho = bio().n(j, true);
        AppMethodBeat.o(2425);
        return ho;
    }

    private static void biq() {
        AppMethodBeat.i(2426);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("off_line_download_ids", 0);
        if (sharedPreferences == null) {
            AppMethodBeat.o(2426);
            return;
        }
        Map all = sharedPreferences.getAll();
        if (all == null || all.size() == 0) {
            AppMethodBeat.o(2426);
            return;
        }
        kMM.clear();
        for (Entry entry : all.entrySet()) {
            if (!(entry == null || bo.isNullOrNil((String) entry.getKey()))) {
                try {
                    long j = bo.getLong((String) entry.getKey(), 0);
                    long longValue = ((Long) entry.getValue()).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    if (currentTimeMillis - j > 0 && currentTimeMillis - j < 86400000) {
                        kMM.put(Long.valueOf(j), Long.valueOf(longValue));
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.FileDownloadManager", "parse download task failed: " + e.toString());
                    ab.printErrStackTrace("MicroMsg.FileDownloadManager", e, "", new Object[0]);
                }
            }
        }
        sharedPreferences.edit().clear();
        for (Entry entry2 : kMM.entrySet()) {
            sharedPreferences.edit().putLong(entry2.getKey(), ((Long) entry2.getValue()).longValue());
        }
        sharedPreferences.edit().commit();
        AppMethodBeat.o(2426);
    }

    static void a(String str, String str2, String str3, PendingIntent pendingIntent) {
        AppMethodBeat.i(2427);
        c bt = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id");
        f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, false);
        if (bT == null || bo.isNullOrNil(bT.field_appName)) {
            bt.d(str2);
        } else {
            bt.d(bT.field_appName);
        }
        bt.e(str3);
        bt.as(17301634);
        bt.z(true);
        if (pendingIntent != null) {
            bt.EI = pendingIntent;
        } else {
            bt.EI = PendingIntent.getActivity(ah.getContext(), 0, new Intent(), 0);
        }
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(bt.build());
        ab.i("MicroMsg.FileDownloadManager", "show notification");
        AppMethodBeat.o(2427);
    }

    static boolean hx(long j) {
        AppMethodBeat.i(2428);
        boolean containsKey = kMM.containsKey(Long.valueOf(j));
        AppMethodBeat.o(2428);
        return containsKey;
    }

    static void G(long j, long j2) {
        AppMethodBeat.i(2429);
        kMM.put(Long.valueOf(j), Long.valueOf(j2));
        ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(j), j2).commit();
        AppMethodBeat.o(2429);
    }

    static long hy(long j) {
        AppMethodBeat.i(2430);
        Long l = (Long) kMM.get(Long.valueOf(j));
        if (l == null) {
            AppMethodBeat.o(2430);
            return -1;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(2430);
        return longValue;
    }

    /* Access modifiers changed, original: final */
    public final void o(long j, final boolean z) {
        AppMethodBeat.i(2431);
        ab.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", Long.valueOf(j), bo.dpG());
        ah.getContext();
        if (hx(j)) {
            this.kMT.c(j, hm(j).path, z);
            AppMethodBeat.o(2431);
            return;
        }
        final com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null) {
            AppMethodBeat.o(2431);
            return;
        }
        if (bo.isNullOrNil(hv.field_packageName)) {
            String aiR = q.aiR(hv.field_filePath);
            if (!bo.isNullOrNil(aiR)) {
                hv.field_packageName = aiR;
                ab.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", hv.field_filePath, aiR);
                c.e(hv);
            }
        }
        final int aiS = q.aiS(hv.field_filePath);
        ab.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", hv.field_packageName, hv.field_filePath, Integer.valueOf(aiS));
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2407);
                if (g.RO().eJo == null || g.RO().eJo.ftA == null) {
                    AppMethodBeat.o(2407);
                    return;
                }
                new ac(hv.field_packageName, aiS).a(g.RO().eJo.ftA, new com.tencent.mm.ai.f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(2406);
                        mVar.ftk = true;
                        h hVar;
                        Object[] objArr;
                        if (i == 0 && i2 == 0) {
                            String string = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.h.Mu()).getString(hv.field_packageName, "");
                            ab.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", string);
                            if (bo.isNullOrNil(string)) {
                                h.pYm.a(322, 26, 1, false);
                                hVar = h.pYm;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf(4026);
                                objArr[1] = String.format("%s,%s", new Object[]{hv.field_packageName, hv.field_filePath});
                                hVar.e(11098, objArr);
                            } else {
                                h hVar2;
                                Object[] objArr2;
                                try {
                                    com.tencent.mm.c.c.c(new File(hv.field_filePath), string);
                                    ab.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                                    h.pYm.a(322, 25, 1, false);
                                    hVar2 = h.pYm;
                                    objArr2 = new Object[2];
                                    objArr2[0] = Integer.valueOf(4025);
                                    objArr2[1] = String.format("%s,%s,%s", new Object[]{hv.field_packageName, hv.field_filePath, string});
                                    hVar2.e(11098, objArr2);
                                } catch (Exception e) {
                                    ab.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + e.getMessage());
                                    h.pYm.a(322, 27, 1, false);
                                    hVar2 = h.pYm;
                                    objArr2 = new Object[2];
                                    objArr2[0] = Integer.valueOf(4027);
                                    objArr2[1] = String.format("%s,%s,%s", new Object[]{hv.field_packageName, hv.field_filePath, e.getMessage()});
                                    hVar2.e(11098, objArr2);
                                }
                            }
                        } else {
                            ab.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
                            h.pYm.a(322, 28, 1, false);
                            hVar = h.pYm;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(4028);
                            objArr[1] = String.format("%s,%s,%d,%d", new Object[]{hv.field_packageName, hv.field_filePath, Integer.valueOf(i), Integer.valueOf(i2)});
                            hVar.e(11098, objArr);
                            if (!bo.isNullOrNil(hv.field_appId) && com.tencent.mm.pluginsdk.model.app.g.dk(hv.field_appId)) {
                                ab.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", hv.field_appId);
                                h.pYm.a(710, 24, 1, false);
                            }
                        }
                        al.d(new AnonymousClass2(hv, z));
                        AppMethodBeat.o(2406);
                    }
                });
                AppMethodBeat.o(2407);
            }
        });
        AppMethodBeat.o(2431);
    }

    private void a(String str, e eVar) {
        AppMethodBeat.i(2432);
        if (!this.kMV) {
            com.tencent.mm.plugin.downloader.f.a In = c.In(str);
            if (In != null && In.field_autoDownload) {
                ha haVar = new ha();
                haVar.cBL.csB = str;
                com.tencent.mm.sdk.b.a.xxA.m(haVar);
                if (eVar != null) {
                    In.field_autoInstall = eVar.kNc;
                    In.field_showNotification = eVar.hzG;
                    In.field_autoDownload = eVar.kNe;
                } else {
                    In.field_autoInstall = true;
                    In.field_showNotification = true;
                    In.field_autoDownload = false;
                }
                c.e(In);
                ab.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", str);
            }
        }
        this.kMV = false;
        AppMethodBeat.o(2432);
    }

    private void hz(long j) {
        AppMethodBeat.i(2433);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null) {
            this.kMV = false;
            AppMethodBeat.o(2433);
            return;
        }
        a(hv.field_appId, null);
        AppMethodBeat.o(2433);
    }

    public final boolean hp(long j) {
        AppMethodBeat.i(2434);
        ab.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(j)));
        if (hx(j)) {
            AppMethodBeat.o(2434);
            return false;
        }
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        boolean hp;
        if (hv == null || hv.field_downloaderType != 3) {
            hp = bin().hp(j);
            AppMethodBeat.o(2434);
            return hp;
        }
        hp = bio().hp(j);
        AppMethodBeat.o(2434);
        return hp;
    }

    public static LinkedList<FileDownloadTaskInfo> M(LinkedList<String> linkedList) {
        LinkedList linkedList2 = null;
        AppMethodBeat.i(2423);
        b XS = c.XS();
        if (XS != null) {
            Cursor rawQuery = XS.rawQuery("select * from FileDownloadInfo where ".concat(String.valueOf(b.N(linkedList))), new String[0]);
            if (rawQuery != null) {
                linkedList2 = new LinkedList();
                if (rawQuery.moveToFirst()) {
                    do {
                        com.tencent.mm.plugin.downloader.f.a aVar = new com.tencent.mm.plugin.downloader.f.a();
                        aVar.d(rawQuery);
                        linkedList2.add(aVar);
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        LinkedList linkedList3 = new LinkedList();
        if (linkedList2 != null && linkedList2.size() > 0) {
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.f.a aVar2 = (com.tencent.mm.plugin.downloader.f.a) it.next();
                FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
                if (aVar2.field_status != 3 || e.ct(aVar2.field_filePath)) {
                    fileDownloadTaskInfo.status = aVar2.field_status;
                } else {
                    fileDownloadTaskInfo.status = 0;
                }
                fileDownloadTaskInfo.appId = aVar2.field_appId;
                fileDownloadTaskInfo.id = aVar2.field_downloadId;
                fileDownloadTaskInfo.url = aVar2.field_downloadUrl;
                fileDownloadTaskInfo.path = aVar2.field_filePath;
                fileDownloadTaskInfo.cvZ = aVar2.field_md5;
                fileDownloadTaskInfo.kNr = aVar2.field_downloadedSize;
                fileDownloadTaskInfo.jrb = aVar2.field_totalSize;
                fileDownloadTaskInfo.kNs = aVar2.field_autoDownload;
                fileDownloadTaskInfo.cBA = aVar2.field_downloaderType;
                fileDownloadTaskInfo.kNt = aVar2.field_downloadInWifi;
                fileDownloadTaskInfo.kNu = aVar2.field_reserveInWifi;
                linkedList3.add(fileDownloadTaskInfo);
            }
        }
        AppMethodBeat.o(2423);
        return linkedList3;
    }

    static /* synthetic */ void f(com.tencent.mm.plugin.downloader.f.a aVar) {
        AppMethodBeat.i(2437);
        if (bo.isNullOrNil(aVar.field_filePath)) {
            ab.e("MicroMsg.FileDownloadManager", "installApk, path is null");
            AppMethodBeat.o(2437);
            return;
        }
        ab.i("MicroMsg.FileDownloadManager", "APK File Path: %s", aVar.field_filePath);
        com.tencent.mm.plugin.downloader.h.a.a(aVar.field_downloadId, true, null);
        AppMethodBeat.o(2437);
    }
}
