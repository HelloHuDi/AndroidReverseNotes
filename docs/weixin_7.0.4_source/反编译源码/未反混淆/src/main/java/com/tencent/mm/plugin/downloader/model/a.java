package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends h {
    public static final String kMy = (b.eSn + "BigFile/");
    private byte[] eMl = new byte[0];
    private HashMap<String, Long> kMA = new HashMap();
    private ConcurrentHashMap<String, Integer> kMB = new ConcurrentHashMap();
    private HashMap<String, Long> kMC = new HashMap();
    private HashMap<String, Long> kMD = new HashMap();
    private HashMap<String, Long> kMz = new HashMap();
    private com.tencent.mm.plugin.cdndownloader.d.b ktk = new com.tencent.mm.plugin.cdndownloader.d.b() {
        public final void f(String str, int i, int i2, String str2) {
            AppMethodBeat.i(2354);
            com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
            if (Iq == null) {
                h.pYm.a(710, 18, 1, false);
                ab.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
                AppMethodBeat.o(2354);
                return;
            }
            ab.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
            switch (i) {
                case 1:
                    Iq.field_status = 1;
                    c.e(Iq);
                    AppMethodBeat.o(2354);
                    return;
                case 3:
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_downloadedSize = Iq.field_totalSize;
                    Iq.field_status = 6;
                    ab.i("MicroMsg.FileCDNDownloader", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(Iq.field_downloadedSize), Long.valueOf(Iq.field_startSize));
                    c.e(Iq);
                    a.this.kMT.hu(Iq.field_downloadId);
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kNn, 1);
                    intent.setClass(a.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, Iq.field_downloadId);
                    try {
                        d.aH(intent);
                    } catch (Exception e) {
                        ab.e("MicroMsg.FileCDNDownloader", e.getMessage());
                    }
                    a.a(a.this, Iq.field_downloadUrl);
                    a.this.kMC.remove(Iq.field_downloadUrl);
                    a.this.kMD.remove(Iq.field_downloadUrl);
                    break;
                case 4:
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_errCode = Math.abs(i2);
                    Iq.field_status = 4;
                    if (at.isWifi(ah.getContext()) && Iq.field_downloadInWifi) {
                        Iq.field_downloadInWifi = false;
                        Iq.field_reserveInWifi = false;
                    }
                    c.e(Iq);
                    a.this.kMT.d(Iq.field_downloadId, Math.abs(i2), false);
                    a.a(a.this, Iq.field_downloadUrl, 4, 0, false);
                    a.this.kMC.remove(Iq.field_downloadUrl);
                    a.this.kMD.remove(Iq.field_downloadUrl);
                    AppMethodBeat.o(2354);
                    return;
            }
            AppMethodBeat.o(2354);
        }

        public final void m(String str, long j, long j2) {
            AppMethodBeat.i(2355);
            ab.d("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = %d, receiveDataLen = %d", Long.valueOf(j2), Long.valueOf(j));
            com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
            if (Iq == null) {
                ab.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
                AppMethodBeat.o(2355);
                return;
            }
            long a;
            if (Iq.field_downloadInWifi && !at.isWifi(ah.getContext())) {
                a.this.hq(Iq.field_downloadId);
            }
            Long valueOf = Long.valueOf(bo.c((Long) a.this.kMC.get(Iq.field_downloadUrl)));
            if (valueOf.longValue() == 0) {
                valueOf = Long.valueOf(j);
                a.this.kMC.put(Iq.field_downloadUrl, Long.valueOf(j));
            }
            long longValue = j - valueOf.longValue();
            if (j2 == 0) {
                ab.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = 0");
            } else {
                int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                if ((100 * longValue) / j2 >= 1) {
                    a = bo.a((Long) a.this.kMD.get(Iq.field_downloadUrl), Iq.field_startTime);
                    long currentTimeMillis = System.currentTimeMillis();
                    float f = ((((float) longValue) * 1000.0f) / ((float) (currentTimeMillis - a))) / 1048576.0f;
                    ab.d("MicroMsg.FileCDNDownloader", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d, totalPercent = %d", Iq.field_appId, Float.valueOf(f), Long.valueOf(currentTimeMillis - a), Long.valueOf(longValue), Long.valueOf(j2), Integer.valueOf(i));
                    com.tencent.mm.plugin.downloader.h.b.a(Iq.field_downloadId, f, i);
                    a.this.kMD.put(Iq.field_downloadUrl, Long.valueOf(currentTimeMillis));
                    a.this.kMC.put(Iq.field_downloadUrl, Long.valueOf(j));
                }
            }
            valueOf = Long.valueOf(bo.c((Long) a.this.kMA.get(Iq.field_downloadUrl)));
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            a = valueOf2.longValue() - valueOf.longValue();
            if (valueOf == null || a <= 0 || a >= 500) {
                a.this.kMA.put(Iq.field_downloadUrl, valueOf2);
                Iq.field_downloadedSize = j;
                Iq.field_totalSize = j2;
                c.e(Iq);
                a.this.kMT.ht(Iq.field_downloadId);
                int i2 = 0;
                if (j2 > 0) {
                    i2 = (int) ((((float) j) / ((float) j2)) * 100.0f);
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 100) {
                    i2 = 100;
                }
                a.a(a.this, Iq.field_downloadUrl, 1, i2, false);
                AppMethodBeat.o(2355);
                return;
            }
            AppMethodBeat.o(2355);
        }
    };
    private Context mContext = ah.getContext();

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(2373);
        aVar.cancelNotification(str);
        AppMethodBeat.o(2373);
    }

    static {
        AppMethodBeat.i(2375);
        AppMethodBeat.o(2375);
    }

    public a(b bVar) {
        super(bVar);
        AppMethodBeat.i(2360);
        AppMethodBeat.o(2360);
    }

    public final long a(final com.tencent.mm.plugin.downloader.f.a aVar) {
        AppMethodBeat.i(2361);
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2356);
                c.h(aVar.field_appId, aVar.field_downloadUrl, aVar.field_secondaryUrl);
                com.tencent.mm.plugin.s.a.bYL();
                m.aiN(aVar.field_appId);
                int a = com.tencent.mm.plugin.cdndownloader.d.a.beV().a(a.c(aVar));
                ab.i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", Integer.valueOf(a), Long.valueOf(aVar.field_downloadId));
                if (a == 0) {
                    aVar.field_status = 1;
                    aVar.field_startTime = System.currentTimeMillis();
                    c.d(aVar);
                    a.this.kMT.j(aVar.field_downloadId, aVar.field_filePath);
                    a.a(a.this, aVar.field_downloadUrl, 1, 0, true);
                    AppMethodBeat.o(2356);
                } else if (a == -2) {
                    aVar.field_status = 1;
                    aVar.field_startTime = System.currentTimeMillis();
                    c.d(aVar);
                    AppMethodBeat.o(2356);
                } else if (a == 1) {
                    aVar.field_status = 6;
                    com.tencent.mm.plugin.downloader.f.a aVar = aVar;
                    com.tencent.mm.plugin.downloader.f.a aVar2 = aVar;
                    com.tencent.mm.plugin.downloader.f.a aVar3 = aVar;
                    long asZ = e.asZ(aVar.field_filePath);
                    aVar3.field_totalSize = asZ;
                    aVar2.field_downloadedSize = asZ;
                    aVar.field_startSize = asZ;
                    aVar = aVar;
                    aVar2 = aVar;
                    long currentTimeMillis = System.currentTimeMillis();
                    aVar2.field_finishTime = currentTimeMillis;
                    aVar.field_startTime = currentTimeMillis;
                    c.d(aVar);
                    a.this.kMT.hu(aVar.field_downloadId);
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kNn, 1);
                    intent.setClass(a.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, aVar.field_downloadId);
                    try {
                        d.aH(intent);
                        AppMethodBeat.o(2356);
                    } catch (Exception e) {
                        ab.e("MicroMsg.FileCDNDownloader", e.getMessage());
                        AppMethodBeat.o(2356);
                    }
                } else {
                    aVar.field_status = 4;
                    aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJQ;
                    c.d(aVar);
                    a.this.kMT.d(aVar.field_downloadId, aVar.field_errCode, false);
                    AppMethodBeat.o(2356);
                }
            }
        });
        long j = aVar.field_downloadId;
        AppMethodBeat.o(2361);
        return j;
    }

    public final long a(e eVar) {
        AppMethodBeat.i(2362);
        if (eVar == null || bo.isNullOrNil(eVar.gUx)) {
            ab.e("MicroMsg.FileCDNDownloader", "Invalid Request");
            AppMethodBeat.o(2362);
            return -1;
        }
        com.tencent.mm.plugin.downloader.f.a In;
        long j;
        String str = eVar.gUx;
        com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
        if (Iq == null) {
            In = c.In(eVar.mAppId);
        } else {
            In = Iq;
        }
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        if (In != null) {
            fileDownloadTaskInfo = hm(In.field_downloadId);
            if (fileDownloadTaskInfo != null) {
                ab.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + fileDownloadTaskInfo.status);
                if (fileDownloadTaskInfo.status == 1 || fileDownloadTaskInfo.status == 6) {
                    j = fileDownloadTaskInfo.id;
                    AppMethodBeat.o(2362);
                    return j;
                } else if (fileDownloadTaskInfo.status == 3) {
                    if (In.field_autoInstall) {
                        com.tencent.mm.plugin.downloader.h.a.a(fileDownloadTaskInfo.id, false, null);
                    }
                    j = fileDownloadTaskInfo.id;
                    AppMethodBeat.o(2362);
                    return j;
                }
            }
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(kMy);
        if (!bVar.exists()) {
            if (!bVar.dMC().exists()) {
                com.tencent.mm.vfs.b dMC = bVar.dMC();
                com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(j.w(dMC.dMD()) + System.currentTimeMillis());
                if (bVar2.mkdirs()) {
                    bVar2.o(dMC);
                } else {
                    ab.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", j.w(dMC.dMD()));
                }
            }
            ab.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", Boolean.valueOf(bVar.mkdirs()));
        }
        c.Io(str);
        c.Ip(eVar.mAppId);
        if (In != null) {
            c.hw(In.field_downloadId);
        }
        com.tencent.mm.plugin.downloader.f.a c = f.c(eVar);
        if (!eVar.kNg || In == null) {
            c.field_downloadId = System.currentTimeMillis();
        } else {
            c.field_downloadId = In.field_downloadId;
        }
        c.field_downloaderType = 3;
        c.field_filePath = kMy + ag.ck(str);
        if (fileDownloadTaskInfo != null) {
            String str2 = c.field_filePath;
            str = fileDownloadTaskInfo.path;
            if (!(str2 == null || str == null || str2.equals(str))) {
                ab.i("MicroMsg.FileCDNDownloader", "removeLastFile, new File = %s, oldFile = %s", str2, str);
                if (new com.tencent.mm.vfs.b(str).exists()) {
                    ab.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", Boolean.valueOf(new com.tencent.mm.vfs.b(str).delete()));
                }
            }
            if (fileDownloadTaskInfo.status == 2) {
                c.field_startState = com.tencent.mm.plugin.downloader.a.b.kKd;
            } else if (fileDownloadTaskInfo.status == 4) {
                c.field_startState = com.tencent.mm.plugin.downloader.a.b.kKe;
            } else {
                c.field_startState = com.tencent.mm.plugin.downloader.a.b.kKc;
            }
            c.field_startSize = fileDownloadTaskInfo.kNr;
            ab.i("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + fileDownloadTaskInfo.kNr);
        } else {
            c.field_startState = com.tencent.mm.plugin.downloader.a.b.kKc;
        }
        if (!eVar.hyG || at.isWifi(ah.getContext())) {
            if (at.isWifi(ah.getContext())) {
                c.field_downloadInWifi = true;
            }
            j = a(c);
            AppMethodBeat.o(2362);
            return j;
        }
        ab.i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        c.field_status = 0;
        c.field_downloadInWifi = true;
        c.d(c);
        j = c.field_downloadId;
        AppMethodBeat.o(2362);
        return j;
    }

    private static CDNTaskInfo b(com.tencent.mm.plugin.downloader.f.a aVar) {
        AppMethodBeat.i(2363);
        CDNTaskInfo cDNTaskInfo = new CDNTaskInfo();
        cDNTaskInfo.egs = true;
        cDNTaskInfo.cHr = aVar.field_downloadUrl;
        cDNTaskInfo.downloadUrl = aVar.field_downloadUrl;
        cDNTaskInfo.filePath = aVar.field_filePath;
        cDNTaskInfo.ktq = aVar.field_secondaryUrl;
        cDNTaskInfo.kts = 15;
        cDNTaskInfo.ktt = 3600;
        cDNTaskInfo.ktu = true;
        cDNTaskInfo.ktv = aVar.field_downloadInWifi;
        JSONObject jSONObject = new JSONObject();
        try {
            if (aVar.field_fileSize > 0) {
                jSONObject.put("Content-Length", aVar.field_fileSize);
            }
            cDNTaskInfo.ktr = jSONObject.toString();
        } catch (JSONException e) {
            ab.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + e.getMessage());
        }
        AppMethodBeat.o(2363);
        return cDNTaskInfo;
    }

    public final int hl(final long j) {
        AppMethodBeat.i(2364);
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2357);
                FileDownloadTaskInfo hm = a.this.hm(j);
                if (hm == null) {
                    AppMethodBeat.o(2357);
                    return;
                }
                com.tencent.mm.plugin.cdndownloader.d.a.beV().HB(hm.url);
                a.a(a.this, hm.url);
                e.deleteFile(hm.path);
                ab.i("MicroMsg.FileCDNDownloader", "removeDownloadTask, delete file, path: %s", hm.path);
                if (hm.status != 5) {
                    com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
                    if (hv == null) {
                        AppMethodBeat.o(2357);
                        return;
                    }
                    hv.field_finishTime = System.currentTimeMillis();
                    hv.field_downloadedSize = hm.kNr;
                    hv.field_status = 5;
                    c.e(hv);
                    Long valueOf = Long.valueOf(bo.a((Long) a.this.kMD.get(hm.url), hv.field_startTime));
                    if (valueOf != null) {
                        com.tencent.mm.plugin.downloader.h.b.a(j, ((((float) (hm.kNr - Long.valueOf(bo.a((Long) a.this.kMC.get(hm.url), hv.field_startSize)).longValue())) * 1000.0f) / ((float) (System.currentTimeMillis() - valueOf.longValue()))) / 1048576.0f, (int) ((((float) hm.kNr) / ((float) hm.jrb)) * 100.0f));
                    }
                    a.this.kMC.remove(hm.url);
                    a.this.kMD.remove(hm.url);
                    a.this.kMT.hr(j);
                }
                AppMethodBeat.o(2357);
            }
        });
        AppMethodBeat.o(2364);
        return 1;
    }

    /* JADX WARNING: Missing block: B:11:0x0058, code skipped:
            r2.kNr = r3.field_downloadedSize;
            r2.jrb = r3.field_totalSize;
     */
    /* JADX WARNING: Missing block: B:13:0x0066, code skipped:
            if (r2.kNr <= r2.jrb) goto L_0x012a;
     */
    /* JADX WARNING: Missing block: B:14:0x0068, code skipped:
            r0 = r2.jrb;
     */
    /* JADX WARNING: Missing block: B:15:0x006a, code skipped:
            r2.kNr = r0;
            r3.field_downloadedSize = r2.kNr;
            r3.field_totalSize = r2.jrb;
     */
    /* JADX WARNING: Missing block: B:45:0x012a, code skipped:
            r0 = r2.kNr;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final FileDownloadTaskInfo hm(long j) {
        AppMethodBeat.i(2365);
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            CDNTaskState HC;
            FileDownloadTaskInfo fileDownloadTaskInfo2 = new FileDownloadTaskInfo();
            if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                HC = com.tencent.mm.plugin.cdndownloader.d.a.beV().HC(hv.field_downloadUrl);
            } else {
                HC = com.tencent.mm.plugin.cdndownloader.d.a.beV().HE(hv.field_downloadUrl);
            }
            if (HC != null) {
                ab.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, cdntaskstate: %d", Integer.valueOf(HC.taskState));
                switch (HC.taskState) {
                    case 100:
                        fileDownloadTaskInfo2.status = 1;
                        fileDownloadTaskInfo2.kNr = (long) HC.completeSize;
                        fileDownloadTaskInfo2.jrb = (long) HC.fileTotalSize;
                        break;
                    case 101:
                        fileDownloadTaskInfo2.status = 1;
                        break;
                    case 102:
                        fileDownloadTaskInfo2.status = 2;
                        fileDownloadTaskInfo2.kNr = (long) HC.completeSize;
                        fileDownloadTaskInfo2.jrb = (long) HC.fileTotalSize;
                        break;
                    case 104:
                        if (e.ct(hv.field_filePath)) {
                            if (hv.field_status != 6) {
                                fileDownloadTaskInfo2.status = 3;
                                break;
                            }
                            fileDownloadTaskInfo2.status = 6;
                            break;
                        }
                        fileDownloadTaskInfo2.status = 0;
                        break;
                    default:
                        if (hv.field_status != 1) {
                            fileDownloadTaskInfo2.status = hv.field_status;
                            break;
                        }
                        fileDownloadTaskInfo2.status = 0;
                        break;
                }
            }
            if (hv.field_status == 1) {
                fileDownloadTaskInfo2.status = 0;
            } else {
                fileDownloadTaskInfo2.status = hv.field_status;
            }
            if (com.tencent.mm.a.e.ct(hv.field_filePath)) {
                fileDownloadTaskInfo2.kNr = hv.field_downloadedSize;
                fileDownloadTaskInfo2.jrb = hv.field_totalSize;
            } else {
                fileDownloadTaskInfo2.kNr = 0;
                fileDownloadTaskInfo2.jrb = 0;
            }
            if ((fileDownloadTaskInfo2.status == 6 || fileDownloadTaskInfo2.status == 3) && !e.ct(hv.field_filePath)) {
                fileDownloadTaskInfo2.status = 0;
            }
            fileDownloadTaskInfo2.id = j;
            fileDownloadTaskInfo2.cBA = hv.field_downloaderType;
            fileDownloadTaskInfo2.kNs = hv.field_autoDownload;
            fileDownloadTaskInfo2.path = hv.field_filePath;
            fileDownloadTaskInfo2.url = hv.field_downloadUrl;
            fileDownloadTaskInfo2.cvZ = hv.field_md5;
            if (hv.field_status != fileDownloadTaskInfo2.status && (fileDownloadTaskInfo2.status == 1 || hv.field_status == 1)) {
                hv.field_status = fileDownloadTaskInfo2.status;
                c.e(hv);
            }
            ab.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, url: %s, status = %d, downloadedSize = %d, totalSize = %d", fileDownloadTaskInfo2.url, Integer.valueOf(fileDownloadTaskInfo2.status), Long.valueOf(fileDownloadTaskInfo2.kNr), Long.valueOf(fileDownloadTaskInfo2.jrb));
            fileDownloadTaskInfo = fileDownloadTaskInfo2;
        }
        AppMethodBeat.o(2365);
        return fileDownloadTaskInfo;
    }

    public final boolean hn(final long j) {
        AppMethodBeat.i(2366);
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2358);
                ab.i("MicroMsg.FileCDNDownloader", JsApiPauseDownloadTask.NAME);
                FileDownloadTaskInfo hm = a.this.hm(j);
                if (hm != null && hm.status == 1) {
                    com.tencent.mm.plugin.cdndownloader.d.a.beV().HA(hm.url);
                    a.a(a.this, hm.url);
                    com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
                    if (hv != null) {
                        hv.field_finishTime = System.currentTimeMillis();
                        hv.field_status = 2;
                        hv.field_downloadedSize = hm.kNr;
                        c.e(hv);
                        Long valueOf = Long.valueOf(bo.a((Long) a.this.kMD.get(hm.url), hv.field_startTime));
                        if (valueOf != null) {
                            com.tencent.mm.plugin.downloader.h.b.a(hv.field_downloadId, ((((float) (hv.field_downloadedSize - Long.valueOf(bo.a((Long) a.this.kMC.get(hm.url), hv.field_startSize)).longValue())) * 1000.0f) / ((float) (System.currentTimeMillis() - valueOf.longValue()))) / 1048576.0f, (int) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f));
                        }
                    }
                    a.this.kMC.remove(hm.url);
                    a.this.kMD.remove(hm.url);
                    a.this.kMT.hs(j);
                }
                AppMethodBeat.o(2358);
            }
        });
        AppMethodBeat.o(2366);
        return true;
    }

    public final boolean ho(long j) {
        AppMethodBeat.i(2367);
        boolean n = n(j, true);
        AppMethodBeat.o(2367);
        return n;
    }

    public final boolean n(long j, boolean z) {
        AppMethodBeat.i(2368);
        final com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            FileDownloadTaskInfo hm = hm(hv.field_downloadId);
            if (hm == null) {
                AppMethodBeat.o(2368);
                return false;
            } else if (hm.status == 1 || hm.status == 6) {
                AppMethodBeat.o(2368);
                return true;
            } else if (hm.status == 3) {
                if (hv.field_autoInstall) {
                    com.tencent.mm.plugin.downloader.h.a.a(hm.id, false, null);
                }
                AppMethodBeat.o(2368);
                return true;
            } else if ((hv.field_reserveInWifi || hv.field_downloadInWifi) && !at.isWifi(ah.getContext())) {
                ab.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask, downloadInWifi, not wifi");
                AppMethodBeat.o(2368);
                return true;
            } else {
                if (at.isWifi(ah.getContext())) {
                    hv.field_downloadInWifi = true;
                }
                final boolean z2 = z;
                final long j2 = j;
                com.tencent.mm.ce.a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(2359);
                        c.h(hv.field_appId, hv.field_downloadUrl, hv.field_secondaryUrl);
                        com.tencent.mm.plugin.s.a.bYL();
                        m.aiN(hv.field_appId);
                        int b = com.tencent.mm.plugin.cdndownloader.d.a.beV().b(a.c(hv));
                        ab.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: ".concat(String.valueOf(b)));
                        hv.field_startTime = System.currentTimeMillis();
                        hv.field_startSize = hv.field_downloadedSize;
                        hv.field_startState = com.tencent.mm.plugin.downloader.a.b.kKd;
                        if (b == 0) {
                            hv.field_status = 1;
                            hv.field_errCode = 0;
                            c.e(hv);
                            if (z2) {
                                a.this.kMT.k(j2, hv.field_filePath);
                            }
                            long j = 0;
                            if (hv.field_totalSize != 0) {
                                j = (hv.field_downloadedSize * 100) / hv.field_totalSize;
                            }
                            ab.d("MicroMsg.FileCDNDownloader", "resumeDownloadTask, progress = %d, downloadedSize = %d, totalSize = %d", Long.valueOf(j), Long.valueOf(hv.field_downloadedSize), Long.valueOf(hv.field_totalSize));
                            a.a(a.this, hv.field_downloadUrl, 1, (int) j, true);
                            AppMethodBeat.o(2359);
                        } else if (b == -2) {
                            hv.field_status = 1;
                            hv.field_errCode = 0;
                            c.e(hv);
                            AppMethodBeat.o(2359);
                        } else if (b != 1) {
                            hv.field_status = 4;
                            hv.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJR;
                            c.e(hv);
                            a.this.kMT.d(j2, hv.field_errCode, false);
                            AppMethodBeat.o(2359);
                        } else if (hv.field_status == 6 || hv.field_status == 3) {
                            AppMethodBeat.o(2359);
                        } else {
                            hv.field_status = 6;
                            com.tencent.mm.plugin.downloader.f.a aVar = hv;
                            com.tencent.mm.plugin.downloader.f.a aVar2 = hv;
                            long j2 = hv.field_totalSize;
                            aVar2.field_downloadedSize = j2;
                            aVar.field_startSize = j2;
                            aVar = hv;
                            aVar2 = hv;
                            j2 = System.currentTimeMillis();
                            aVar2.field_finishTime = j2;
                            aVar.field_startTime = j2;
                            c.e(hv);
                            a.this.kMT.hu(hv.field_downloadId);
                            Intent intent = new Intent();
                            intent.putExtra(FileDownloadService.kNn, 1);
                            intent.setClass(a.this.mContext, FileDownloadService.class);
                            intent.putExtra(FileDownloadService.EXTRA_ID, hv.field_downloadId);
                            try {
                                d.aH(intent);
                                AppMethodBeat.o(2359);
                            } catch (Exception e) {
                                ab.e("MicroMsg.FileCDNDownloader", e.getMessage());
                                AppMethodBeat.o(2359);
                            }
                        }
                    }
                });
                AppMethodBeat.o(2368);
                return true;
            }
        }
        AppMethodBeat.o(2368);
        return false;
    }

    public final boolean hp(long j) {
        AppMethodBeat.i(2369);
        ab.i("MicroMsg.FileCDNDownloader", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(j)));
        boolean n = n(j, false);
        AppMethodBeat.o(2369);
        return n;
    }

    private void cancelNotification(String str) {
        AppMethodBeat.i(2370);
        synchronized (this.eMl) {
            try {
                Integer num = (Integer) this.kMB.get(str);
                if (num == null) {
                    ab.i("MicroMsg.FileCDNDownloader", "No notification id found");
                } else {
                    ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
                    ab.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = ".concat(String.valueOf(num)));
                    this.kMB.remove(str);
                    AppMethodBeat.o(2370);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(2370);
            }
        }
    }

    public final boolean hq(long j) {
        AppMethodBeat.i(2371);
        com.tencent.mm.game.report.api.b.eBF.a(j, new com.tencent.mm.game.report.api.a(13));
        boolean hn = hn(j);
        AppMethodBeat.o(2371);
        return hn;
    }

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        AppMethodBeat.i(2372);
        ab.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
        if (Iq == null) {
            ab.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
            AppMethodBeat.o(2372);
        } else if (Iq.field_showNotification) {
            v.c bt = com.tencent.mm.bo.a.bt(aVar.mContext, "reminder_channel_id");
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.kMz.put(str, Long.valueOf(currentTimeMillis));
                bt.j(currentTimeMillis);
            } else {
                Long l = (Long) aVar.kMz.get(str);
                if (l != null) {
                    bt.j(l.longValue());
                } else {
                    l = Long.valueOf(System.currentTimeMillis());
                    aVar.kMz.put(str, l);
                    bt.j(l.longValue());
                }
            }
            f bT = com.tencent.mm.pluginsdk.model.app.g.bT(Iq.field_appId, false);
            if (bT == null || bo.isNullOrNil(bT.field_appName)) {
                bt.d(Iq.field_fileName);
            } else {
                bt.d(bT.field_appName);
            }
            switch (i) {
                case 1:
                    bt.as(17301633);
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    bt.b(100, i2, i2 == 0);
                    if (Iq.field_reserveInWifi) {
                        bt.e(aVar.mContext.getString(R.string.bsr) + "·" + aVar.mContext.getString(R.string.bsp));
                    } else {
                        bt.e(aVar.mContext.getString(R.string.bsp));
                    }
                    bt.k(2, true);
                    Intent intent = new Intent(aVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", Iq.field_downloadId);
                    bt.EI = PendingIntent.getActivity(aVar.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 4:
                    bt.as(17301634);
                    bt.z(true);
                    bt.EI = PendingIntent.getActivity(ah.getContext(), 0, new Intent(), 0);
                    bt.e(aVar.mContext.getString(R.string.bsn));
                    break;
                default:
                    aVar.cancelNotification(str);
                    AppMethodBeat.o(2372);
                    return;
            }
            synchronized (aVar.eMl) {
                try {
                    Integer num = (Integer) aVar.kMB.get(str);
                    if (num == null) {
                        aVar.kMB.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(bt.build())));
                    } else {
                        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), bt.build());
                    }
                    if (i == 4) {
                        aVar.kMB.remove(str);
                    }
                } finally {
                    AppMethodBeat.o(2372);
                }
            }
        } else {
            AppMethodBeat.o(2372);
        }
    }
}
