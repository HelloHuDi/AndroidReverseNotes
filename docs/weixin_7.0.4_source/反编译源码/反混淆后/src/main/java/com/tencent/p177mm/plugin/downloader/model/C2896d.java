package com.tencent.p177mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C32823ac;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p209c.C45275c;
import com.tencent.p177mm.p230g.p231a.C37729hr;
import com.tencent.p177mm.p230g.p231a.C45331ha;
import com.tencent.p177mm.plugin.downloader.p1249g.C33908a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42912b;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.downloader.model.d */
public final class C2896d {
    private static int hzH = 2;
    private static Map<Long, Long> kMM = new HashMap();
    private static C2896d kMU;
    private C11512l kMN;
    private C11512l kMO;
    private C11512l kMP;
    private C33908a kMQ;
    private C33917a kMR;
    private C11512l kMS;
    public C2886b kMT;
    public boolean kMV = false;

    /* renamed from: com.tencent.mm.plugin.downloader.model.d$2 */
    class C28972 implements Runnable {
        final /* synthetic */ C42911a kMF;
        final /* synthetic */ boolean kML;

        C28972(C42911a c42911a, boolean z) {
            this.kMF = c42911a;
            this.kML = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(2408);
            PendingIntent pendingIntent = null;
            if (this.kMF.field_fileType == 1) {
                pendingIntent = C2896d.m5151a(this.kMF.field_filePath, this.kMF);
            }
            if (this.kMF.field_showNotification && C5046bo.isNullOrNil(this.kMF.field_fileName)) {
                C2896d.m5155b(this.kMF.field_appId, C4996ah.getContext().getString(C25738R.string.bso), "", pendingIntent);
            } else if (this.kMF.field_showNotification && !C5046bo.isNullOrNil(this.kMF.field_fileName)) {
                C2896d.m5155b(this.kMF.field_appId, this.kMF.field_fileName, C4996ah.getContext().getString(C25738R.string.bso), pendingIntent);
            }
            if (this.kMF.field_autoInstall && this.kMF.field_fileType == 1 && !this.kMF.field_reserveInWifi) {
                C2896d.m5156f(this.kMF);
            }
            C2896d.this.kMT.mo7024c(this.kMF.field_downloadId, this.kMF.field_filePath, this.kML);
            AppMethodBeat.m2505o(2408);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m5155b(String str, String str2, String str3, PendingIntent pendingIntent) {
        AppMethodBeat.m2504i(2436);
        C2896d.m5154a(str, str2, str3, pendingIntent);
        AppMethodBeat.m2505o(2436);
    }

    static {
        AppMethodBeat.m2504i(2438);
        AppMethodBeat.m2505o(2438);
    }

    public static C2896d bij() {
        AppMethodBeat.m2504i(2409);
        if (kMU == null) {
            kMU = new C2896d();
        }
        C2896d c2896d = kMU;
        AppMethodBeat.m2505o(2409);
        return c2896d;
    }

    private C2896d() {
        AppMethodBeat.m2504i(2410);
        C2896d.biq();
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                hzH = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("FileDownloaderType"), 2);
                C4990ab.m7417i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", Integer.valueOf(hzH));
                this.kMT = new C2886b();
                AppMethodBeat.m2505o(2410);
            }
        }
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
        this.kMT = new C2886b();
        AppMethodBeat.m2505o(2410);
    }

    public final C11512l bik() {
        AppMethodBeat.m2504i(2411);
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "mDownloaderType = " + hzH);
        C11512l c11512l;
        if (this.kMN != null) {
            c11512l = this.kMN;
            AppMethodBeat.m2505o(2411);
            return c11512l;
        }
        C37729hr c37729hr = new C37729hr();
        C4879a.xxA.mo10055m(c37729hr);
        int i = c37729hr.cCC.cBA;
        if (i > 0) {
            hzH = i;
        }
        if (hzH == 1) {
            this.kMN = bil();
        } else {
            this.kMN = bin();
        }
        c11512l = this.kMN;
        AppMethodBeat.m2505o(2411);
        return c11512l;
    }

    private C11512l bil() {
        AppMethodBeat.m2504i(2412);
        if (this.kMP == null) {
            this.kMP = new C38849g(this.kMT);
        }
        C11512l c11512l = this.kMP;
        AppMethodBeat.m2505o(2412);
        return c11512l;
    }

    private C11512l bim() {
        AppMethodBeat.m2504i(2413);
        if (this.kMO == null) {
            this.kMO = new C38852i(this.kMT);
        }
        C11512l c11512l = this.kMO;
        AppMethodBeat.m2505o(2413);
        return c11512l;
    }

    public final C33908a bin() {
        AppMethodBeat.m2504i(2414);
        if (this.kMQ == null) {
            this.kMQ = new C33908a(this.kMT);
        }
        C33908a c33908a = this.kMQ;
        AppMethodBeat.m2505o(2414);
        return c33908a;
    }

    public final C33917a bio() {
        AppMethodBeat.m2504i(2415);
        if (this.kMR == null) {
            this.kMR = new C33917a(this.kMT);
        }
        C33917a c33917a = this.kMR;
        AppMethodBeat.m2505o(2415);
        return c33917a;
    }

    private C11512l bip() {
        AppMethodBeat.m2504i(2416);
        if (this.kMS == null) {
            this.kMS = new C33926j(this.kMT);
        }
        C11512l c11512l = this.kMS;
        AppMethodBeat.m2505o(2416);
        return c11512l;
    }

    /* renamed from: a */
    public final long mo7042a(C2900e c2900e) {
        AppMethodBeat.m2504i(2417);
        C4990ab.m7417i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", Integer.valueOf(c2900e.kNb), c2900e.mAppId);
        long a;
        if (c2900e.kNb == 2) {
            a = bip().mo23224a(c2900e);
            AppMethodBeat.m2505o(2417);
            return a;
        }
        m5153a(c2900e.mAppId, c2900e);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                a = bik().mo23224a(c2900e);
                AppMethodBeat.m2505o(2417);
                return a;
            }
        }
        a = bil().mo23224a(c2900e);
        if (a >= 0) {
            kMM.put(Long.valueOf(a), Long.valueOf(0));
            C4996ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            C4990ab.m7417i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            AppMethodBeat.m2505o(2417);
            return a;
        }
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        bim().mo23224a(c2900e);
        AppMethodBeat.m2505o(2417);
        return a;
    }

    /* renamed from: b */
    public final long mo7043b(C2900e c2900e) {
        long a;
        AppMethodBeat.m2504i(2418);
        C4990ab.m7417i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", c2900e.mAppId);
        m5153a(c2900e.mAppId, c2900e);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                a = bio().mo23224a(c2900e);
                AppMethodBeat.m2505o(2418);
                return a;
            }
        }
        a = bil().mo23224a(c2900e);
        if (a >= 0) {
            kMM.put(Long.valueOf(a), Long.valueOf(0));
            C4996ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            C4990ab.m7417i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            AppMethodBeat.m2505o(2418);
            return a;
        }
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        bim().mo23224a(c2900e);
        AppMethodBeat.m2505o(2418);
        return a;
    }

    /* renamed from: hl */
    public final int mo7047hl(long j) {
        AppMethodBeat.m2504i(2419);
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(j)));
        int hl;
        if (C2896d.m5157hx(j)) {
            hl = bil().mo23225hl(j);
            AppMethodBeat.m2505o(2419);
            return hl;
        }
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null && (hv.field_downloadInWifi || hv.field_reserveInWifi)) {
            hv.field_downloadInWifi = false;
            hv.field_reserveInWifi = false;
            C2895c.m5146e(hv);
        }
        if (hv == null || hv.field_downloaderType != 3) {
            hl = bik().mo23225hl(j);
            AppMethodBeat.m2505o(2419);
            return hl;
        }
        hl = bio().mo23225hl(j);
        AppMethodBeat.m2505o(2419);
        return hl;
    }

    /* renamed from: hm */
    public final FileDownloadTaskInfo mo7048hm(long j) {
        AppMethodBeat.m2504i(2420);
        FileDownloadTaskInfo hm;
        if (C2896d.m5157hx(j)) {
            hm = bil().mo23226hm(j);
            AppMethodBeat.m2505o(2420);
            return hm;
        }
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null && hv.field_status == 3 && C5730e.m8628ct(hv.field_filePath)) {
            hm = new FileDownloadTaskInfo();
            hm.f16167id = j;
            hm.url = hv.field_downloadUrl;
            hm.status = 3;
            hm.path = hv.field_filePath;
            hm.cvZ = hv.field_md5;
            hm.kNr = hv.field_downloadedSize;
            hm.jrb = hv.field_totalSize;
            hm.kNs = hv.field_autoDownload;
            hm.cBA = hv.field_downloaderType;
        } else if (hv == null || hv.field_downloaderType != 3) {
            hm = bik().mo23226hm(j);
            if (hv != null) {
                hm.kNs = hv.field_autoDownload;
                hm.cBA = hv.field_downloaderType;
            }
        } else {
            hm = bio().mo23226hm(j);
        }
        if (hm == null) {
            hm = new FileDownloadTaskInfo();
        }
        if (hm.status == 3 || hm.status == 6) {
            if (!C5730e.m8628ct(hm.path)) {
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
        C4990ab.m7417i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", Long.valueOf(hm.f16167id), hm.url, Integer.valueOf(hm.status), hm.path, hm.cvZ, Long.valueOf(hm.jrb), Boolean.valueOf(hm.kNs), Integer.valueOf(hm.cBA));
        AppMethodBeat.m2505o(2420);
        return hm;
    }

    /* renamed from: Ir */
    public final FileDownloadTaskInfo mo7040Ir(String str) {
        AppMethodBeat.m2504i(2421);
        C42911a In = C2895c.m5140In(str);
        FileDownloadTaskInfo hm;
        if (In != null) {
            hm = mo7048hm(In.field_downloadId);
            AppMethodBeat.m2505o(2421);
            return hm;
        }
        hm = new FileDownloadTaskInfo();
        AppMethodBeat.m2505o(2421);
        return hm;
    }

    /* renamed from: Is */
    public final FileDownloadTaskInfo mo7041Is(String str) {
        AppMethodBeat.m2504i(2422);
        C42911a Iq = C2895c.m5143Iq(str);
        FileDownloadTaskInfo hm;
        if (Iq != null) {
            hm = mo7048hm(Iq.field_downloadId);
            AppMethodBeat.m2505o(2422);
            return hm;
        }
        hm = new FileDownloadTaskInfo();
        AppMethodBeat.m2505o(2422);
        return hm;
    }

    /* renamed from: hn */
    public final boolean mo7049hn(long j) {
        AppMethodBeat.m2504i(2424);
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(j)));
        m5159hz(j);
        boolean hn;
        if (C2896d.m5157hx(j)) {
            hn = bil().mo23227hn(j);
            AppMethodBeat.m2505o(2424);
            return hn;
        }
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null && (hv.field_downloadInWifi || hv.field_reserveInWifi)) {
            hv.field_downloadInWifi = false;
            hv.field_reserveInWifi = false;
            C2895c.m5146e(hv);
        }
        if (hv == null || hv.field_downloaderType != 3) {
            hn = bik().mo23227hn(j);
            AppMethodBeat.m2505o(2424);
            return hn;
        }
        hn = bio().mo23227hn(j);
        AppMethodBeat.m2505o(2424);
        return hn;
    }

    /* renamed from: ho */
    public final boolean mo7050ho(long j) {
        AppMethodBeat.m2504i(2425);
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(j)));
        m5159hz(j);
        boolean ho;
        if (C2896d.m5157hx(j)) {
            ho = bil().mo23228ho(j);
            AppMethodBeat.m2505o(2425);
            return ho;
        }
        C42911a hv = C2895c.m5147hv(j);
        if (!(hv == null || hv.field_reserveInWifi || !hv.field_downloadInWifi)) {
            hv.field_downloadInWifi = false;
            C2895c.m5146e(hv);
        }
        if (hv == null || hv.field_downloaderType != 3) {
            ho = bik().mo23228ho(j);
            AppMethodBeat.m2505o(2425);
            return ho;
        }
        ho = bio().mo54466n(j, true);
        AppMethodBeat.m2505o(2425);
        return ho;
    }

    private static void biq() {
        AppMethodBeat.m2504i(2426);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("off_line_download_ids", 0);
        if (sharedPreferences == null) {
            AppMethodBeat.m2505o(2426);
            return;
        }
        Map all = sharedPreferences.getAll();
        if (all == null || all.size() == 0) {
            AppMethodBeat.m2505o(2426);
            return;
        }
        kMM.clear();
        for (Entry entry : all.entrySet()) {
            if (!(entry == null || C5046bo.isNullOrNil((String) entry.getKey()))) {
                try {
                    long j = C5046bo.getLong((String) entry.getKey(), 0);
                    long longValue = ((Long) entry.getValue()).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    if (currentTimeMillis - j > 0 && currentTimeMillis - j < 86400000) {
                        kMM.put(Long.valueOf(j), Long.valueOf(longValue));
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.FileDownloadManager", "parse download task failed: " + e.toString());
                    C4990ab.printErrStackTrace("MicroMsg.FileDownloadManager", e, "", new Object[0]);
                }
            }
        }
        sharedPreferences.edit().clear();
        for (Entry entry2 : kMM.entrySet()) {
            sharedPreferences.edit().putLong(entry2.getKey(), ((Long) entry2.getValue()).longValue());
        }
        sharedPreferences.edit().commit();
        AppMethodBeat.m2505o(2426);
    }

    /* renamed from: a */
    static void m5154a(String str, String str2, String str3, PendingIntent pendingIntent) {
        AppMethodBeat.m2504i(2427);
        C0358c bt = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id");
        C40439f bT = C46494g.m87739bT(str, false);
        if (bT == null || C5046bo.isNullOrNil(bT.field_appName)) {
            bt.mo621d(str2);
        } else {
            bt.mo621d(bT.field_appName);
        }
        bt.mo623e(str3);
        bt.mo616as(17301634);
        bt.mo628z(true);
        if (pendingIntent != null) {
            bt.f362EI = pendingIntent;
        } else {
            bt.f362EI = PendingIntent.getActivity(C4996ah.getContext(), 0, new Intent(), 0);
        }
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41577c(bt.build());
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "show notification");
        AppMethodBeat.m2505o(2427);
    }

    /* renamed from: hx */
    static boolean m5157hx(long j) {
        AppMethodBeat.m2504i(2428);
        boolean containsKey = kMM.containsKey(Long.valueOf(j));
        AppMethodBeat.m2505o(2428);
        return containsKey;
    }

    /* renamed from: G */
    static void m5149G(long j, long j2) {
        AppMethodBeat.m2504i(2429);
        kMM.put(Long.valueOf(j), Long.valueOf(j2));
        C4996ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(j), j2).commit();
        AppMethodBeat.m2505o(2429);
    }

    /* renamed from: hy */
    static long m5158hy(long j) {
        AppMethodBeat.m2504i(2430);
        Long l = (Long) kMM.get(Long.valueOf(j));
        if (l == null) {
            AppMethodBeat.m2505o(2430);
            return -1;
        }
        long longValue = l.longValue();
        AppMethodBeat.m2505o(2430);
        return longValue;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final void mo7052o(long j, final boolean z) {
        AppMethodBeat.m2504i(2431);
        C4990ab.m7411d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", Long.valueOf(j), C5046bo.dpG());
        C4996ah.getContext();
        if (C2896d.m5157hx(j)) {
            this.kMT.mo7024c(j, mo7048hm(j).path, z);
            AppMethodBeat.m2505o(2431);
            return;
        }
        final C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            AppMethodBeat.m2505o(2431);
            return;
        }
        if (C5046bo.isNullOrNil(hv.field_packageName)) {
            String aiR = C35800q.aiR(hv.field_filePath);
            if (!C5046bo.isNullOrNil(aiR)) {
                hv.field_packageName = aiR;
                C4990ab.m7417i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", hv.field_filePath, aiR);
                C2895c.m5146e(hv);
            }
        }
        final int aiS = C35800q.aiS(hv.field_filePath);
        C4990ab.m7411d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", hv.field_packageName, hv.field_filePath, Integer.valueOf(aiS));
        C1720g.m3539RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.downloader.model.d$1$1 */
            class C28991 implements C1202f {
                C28991() {
                }

                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(2406);
                    c1207m.ftk = true;
                    C7060h c7060h;
                    Object[] objArr;
                    if (i == 0 && i2 == 0) {
                        String string = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "yyb_pkg_sig_prefs", C1448h.m3078Mu()).getString(hv.field_packageName, "");
                        C4990ab.m7417i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", string);
                        if (C5046bo.isNullOrNil(string)) {
                            C7060h.pYm.mo8378a(322, 26, 1, false);
                            c7060h = C7060h.pYm;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(4026);
                            objArr[1] = String.format("%s,%s", new Object[]{hv.field_packageName, hv.field_filePath});
                            c7060h.mo8381e(11098, objArr);
                        } else {
                            C7060h c7060h2;
                            Object[] objArr2;
                            try {
                                C45275c.m83482c(new File(hv.field_filePath), string);
                                C4990ab.m7416i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                                C7060h.pYm.mo8378a(322, 25, 1, false);
                                c7060h2 = C7060h.pYm;
                                objArr2 = new Object[2];
                                objArr2[0] = Integer.valueOf(4025);
                                objArr2[1] = String.format("%s,%s,%s", new Object[]{hv.field_packageName, hv.field_filePath, string});
                                c7060h2.mo8381e(11098, objArr2);
                            } catch (Exception e) {
                                C4990ab.m7420w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + e.getMessage());
                                C7060h.pYm.mo8378a(322, 27, 1, false);
                                c7060h2 = C7060h.pYm;
                                objArr2 = new Object[2];
                                objArr2[0] = Integer.valueOf(4027);
                                objArr2[1] = String.format("%s,%s,%s", new Object[]{hv.field_packageName, hv.field_filePath, e.getMessage()});
                                c7060h2.mo8381e(11098, objArr2);
                            }
                        }
                    } else {
                        C4990ab.m7420w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
                        C7060h.pYm.mo8378a(322, 28, 1, false);
                        c7060h = C7060h.pYm;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(4028);
                        objArr[1] = String.format("%s,%s,%d,%d", new Object[]{hv.field_packageName, hv.field_filePath, Integer.valueOf(i), Integer.valueOf(i2)});
                        c7060h.mo8381e(11098, objArr);
                        if (!C5046bo.isNullOrNil(hv.field_appId) && C46494g.m87744dk(hv.field_appId)) {
                            C4990ab.m7417i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", hv.field_appId);
                            C7060h.pYm.mo8378a(710, 24, 1, false);
                        }
                    }
                    C5004al.m7441d(new C28972(hv, z));
                    AppMethodBeat.m2505o(2406);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(2407);
                if (C1720g.m3535RO().eJo == null || C1720g.m3535RO().eJo.ftA == null) {
                    AppMethodBeat.m2505o(2407);
                    return;
                }
                new C32823ac(hv.field_packageName, aiS).mo4456a(C1720g.m3535RO().eJo.ftA, new C28991());
                AppMethodBeat.m2505o(2407);
            }
        });
        AppMethodBeat.m2505o(2431);
    }

    /* renamed from: a */
    private void m5153a(String str, C2900e c2900e) {
        AppMethodBeat.m2504i(2432);
        if (!this.kMV) {
            C42911a In = C2895c.m5140In(str);
            if (In != null && In.field_autoDownload) {
                C45331ha c45331ha = new C45331ha();
                c45331ha.cBL.csB = str;
                C4879a.xxA.mo10055m(c45331ha);
                if (c2900e != null) {
                    In.field_autoInstall = c2900e.kNc;
                    In.field_showNotification = c2900e.hzG;
                    In.field_autoDownload = c2900e.kNe;
                } else {
                    In.field_autoInstall = true;
                    In.field_showNotification = true;
                    In.field_autoDownload = false;
                }
                C2895c.m5146e(In);
                C4990ab.m7417i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", str);
            }
        }
        this.kMV = false;
        AppMethodBeat.m2505o(2432);
    }

    /* renamed from: hz */
    private void m5159hz(long j) {
        AppMethodBeat.m2504i(2433);
        C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            this.kMV = false;
            AppMethodBeat.m2505o(2433);
            return;
        }
        m5153a(hv.field_appId, null);
        AppMethodBeat.m2505o(2433);
    }

    /* renamed from: hp */
    public final boolean mo7051hp(long j) {
        AppMethodBeat.m2504i(2434);
        C4990ab.m7416i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(j)));
        if (C2896d.m5157hx(j)) {
            AppMethodBeat.m2505o(2434);
            return false;
        }
        C42911a hv = C2895c.m5147hv(j);
        boolean hp;
        if (hv == null || hv.field_downloaderType != 3) {
            hp = bin().mo54459hp(j);
            AppMethodBeat.m2505o(2434);
            return hp;
        }
        hp = bio().mo54464hp(j);
        AppMethodBeat.m2505o(2434);
        return hp;
    }

    /* renamed from: M */
    public static LinkedList<FileDownloadTaskInfo> m5150M(LinkedList<String> linkedList) {
        LinkedList linkedList2 = null;
        AppMethodBeat.m2504i(2423);
        C42912b XS = C2895c.m5144XS();
        if (XS != null) {
            Cursor rawQuery = XS.rawQuery("select * from FileDownloadInfo where ".concat(String.valueOf(C42912b.m76187N(linkedList))), new String[0]);
            if (rawQuery != null) {
                linkedList2 = new LinkedList();
                if (rawQuery.moveToFirst()) {
                    do {
                        C42911a c42911a = new C42911a();
                        c42911a.mo8995d(rawQuery);
                        linkedList2.add(c42911a);
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
                C42911a c42911a2 = (C42911a) it.next();
                FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
                if (c42911a2.field_status != 3 || C5730e.m8628ct(c42911a2.field_filePath)) {
                    fileDownloadTaskInfo.status = c42911a2.field_status;
                } else {
                    fileDownloadTaskInfo.status = 0;
                }
                fileDownloadTaskInfo.appId = c42911a2.field_appId;
                fileDownloadTaskInfo.f16167id = c42911a2.field_downloadId;
                fileDownloadTaskInfo.url = c42911a2.field_downloadUrl;
                fileDownloadTaskInfo.path = c42911a2.field_filePath;
                fileDownloadTaskInfo.cvZ = c42911a2.field_md5;
                fileDownloadTaskInfo.kNr = c42911a2.field_downloadedSize;
                fileDownloadTaskInfo.jrb = c42911a2.field_totalSize;
                fileDownloadTaskInfo.kNs = c42911a2.field_autoDownload;
                fileDownloadTaskInfo.cBA = c42911a2.field_downloaderType;
                fileDownloadTaskInfo.kNt = c42911a2.field_downloadInWifi;
                fileDownloadTaskInfo.kNu = c42911a2.field_reserveInWifi;
                linkedList3.add(fileDownloadTaskInfo);
            }
        }
        AppMethodBeat.m2505o(2423);
        return linkedList3;
    }

    /* renamed from: f */
    static /* synthetic */ void m5156f(C42911a c42911a) {
        AppMethodBeat.m2504i(2437);
        if (C5046bo.isNullOrNil(c42911a.field_filePath)) {
            C4990ab.m7412e("MicroMsg.FileDownloadManager", "installApk, path is null");
            AppMethodBeat.m2505o(2437);
            return;
        }
        C4990ab.m7417i("MicroMsg.FileDownloadManager", "APK File Path: %s", c42911a.field_filePath);
        C33913a.m55499a(c42911a.field_downloadId, true, null);
        AppMethodBeat.m2505o(2437);
    }
}
