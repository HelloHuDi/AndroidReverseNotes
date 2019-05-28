package com.tencent.mm.plugin.downloader.g;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.h.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends h {
    private byte[] eMl = new byte[0];
    HashMap<String, Long> kMC = new HashMap();
    HashMap<String, Long> kMD = new HashMap();
    private HashMap<String, Long> kND = new HashMap();
    HashMap<String, Long> kNE = new HashMap();
    private ConcurrentHashMap<String, Integer> kNF = new ConcurrentHashMap();
    HashSet<Long> kNG = new HashSet();
    Map<String, String> kNH = null;
    ap kNI = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(2494);
            if (!a.this.biu()) {
                a.this.kNI.ae(240000, 240000);
            }
            AppMethodBeat.o(2494);
            return true;
        }
    }, false);
    private ITMAssistantDownloadSDKClientListener kNJ = new ITMAssistantDownloadSDKClientListener() {
        public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
            AppMethodBeat.i(2495);
            ab.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
            Iterator it = a.this.kNG.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.f.a hv = c.hv(((Long) it.next()).longValue());
                if (hv != null) {
                    hv.field_finishTime = System.currentTimeMillis();
                    hv.field_status = 4;
                    hv.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJM;
                    c.e(hv);
                    a.this.kMT.d(hv.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kJM, false);
                    a.a(a.this, hv.field_downloadUrl, 5, 0, false);
                }
            }
            a.this.kNG.clear();
            AppMethodBeat.o(2495);
        }

        public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i, int i2, String str2, boolean z, boolean z2) {
            AppMethodBeat.i(2496);
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + i + " | ErrorCode: " + i2 + " | ErrorMsg: " + str2);
            com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
            if (Iq == null) {
                ab.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                AppMethodBeat.o(2496);
                return;
            }
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", Integer.valueOf(i), Long.valueOf(Iq.field_downloadId), Iq.field_filePath, Boolean.valueOf(e.ct(Iq.field_filePath)), str);
            if (!(i == 1 || i == 2)) {
                FileDownloadTaskInfo hm = a.this.hm(Iq.field_downloadId);
                long a = bo.a((Long) a.this.kMD.get(Iq.field_downloadUrl), Iq.field_startTime);
                int i3 = (int) ((((float) hm.kNr) / ((float) hm.jrb)) * 100.0f);
                b.a(Iq.field_downloadId, ((((float) (hm.kNr - bo.a((Long) a.this.kMC.get(Iq.field_downloadUrl), Iq.field_startSize))) * 1000.0f) / ((float) (System.currentTimeMillis() - a))) / 1048576.0f, i3);
                a.this.kMC.remove(Iq.field_downloadUrl);
                a.this.kMD.remove(Iq.field_downloadUrl);
            }
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
            try {
                tMAssistantDownloadTaskInfo = a.this.getClient().getDownloadTaskState(Iq.field_downloadUrl);
            } catch (Exception e) {
            }
            switch (i) {
                case 1:
                    AppMethodBeat.o(2496);
                    return;
                case 2:
                    Iq.field_status = 1;
                    if (tMAssistantDownloadTaskInfo != null) {
                        Iq.field_filePath = tMAssistantDownloadTaskInfo.mSavePath;
                    }
                    c.e(Iq);
                    AppMethodBeat.o(2496);
                    return;
                case 3:
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_status = 2;
                    c.e(Iq);
                    a.this.cancelNotification(str);
                    a.this.kNG.remove(Long.valueOf(Iq.field_downloadId));
                    a.this.kMT.hs(Iq.field_downloadId);
                    AppMethodBeat.o(2496);
                    return;
                case 4:
                    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
                    Iq.field_status = 6;
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_downloadedSize = Iq.field_totalSize;
                    if (tMAssistantDownloadTaskInfo != null) {
                        Iq.field_filePath = tMAssistantDownloadTaskInfo.mSavePath;
                    }
                    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(Iq.field_downloadedSize), Long.valueOf(Iq.field_startSize));
                    c.e(Iq);
                    a.this.kMT.hu(Iq.field_downloadId);
                    if (z2) {
                        hc hcVar = new hc();
                        hcVar.cBN.appId = Iq.field_appId;
                        hcVar.cBN.opType = 6;
                        com.tencent.mm.sdk.b.a.xxA.m(hcVar);
                    }
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kNn, 1);
                    intent.setClass(a.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, Iq.field_downloadId);
                    intent.putExtra(FileDownloadService.kNq, z);
                    try {
                        d.aH(intent);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.FileDownloaderImplTMAssistant", e2.getMessage());
                    }
                    a.this.cancelNotification(str);
                    a.this.kNG.remove(Long.valueOf(Iq.field_downloadId));
                    AppMethodBeat.o(2496);
                    return;
                case 5:
                    if (i2 == 601 || i2 == 602 || i2 == 603 || i2 == 605 || i2 == 606) {
                        ab.d("MicroMsg.FileDownloaderImplTMAssistant", "releaseTimer 4 min");
                        a.this.kNI.ae(240000, 240000);
                    }
                    if (at.isWifi(ah.getContext()) && Iq.field_downloadInWifi) {
                        Iq.field_downloadInWifi = false;
                        Iq.field_reserveInWifi = false;
                    }
                    a.a(a.this, str, i, 0, false);
                    a.this.kNG.remove(Long.valueOf(Iq.field_downloadId));
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_errCode = i2;
                    Iq.field_status = 4;
                    c.e(Iq);
                    a.this.kMT.d(Iq.field_downloadId, i2, z);
                    break;
            }
            AppMethodBeat.o(2496);
        }

        public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
            AppMethodBeat.i(2497);
            com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
            if (Iq == null) {
                ab.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                AppMethodBeat.o(2497);
                return;
            }
            long a;
            Long valueOf = Long.valueOf(bo.c((Long) a.this.kMC.get(Iq.field_downloadUrl)));
            if (valueOf.longValue() == 0) {
                valueOf = Long.valueOf(j);
                a.this.kMC.put(Iq.field_downloadUrl, Long.valueOf(j));
            }
            long longValue = j - valueOf.longValue();
            if (j2 == 0) {
                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "onDownloadTaskProgressChanged, totalDataLen = 0");
            } else {
                int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                if ((100 * longValue) / j2 >= 1) {
                    a = bo.a((Long) a.this.kMD.get(Iq.field_downloadUrl), Iq.field_startTime);
                    long currentTimeMillis = System.currentTimeMillis();
                    float f = ((((float) longValue) * 1000.0f) / ((float) (currentTimeMillis - a))) / 1048576.0f;
                    ab.d("MicroMsg.FileDownloaderImplTMAssistant", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d", Iq.field_appId, Float.valueOf(f), Long.valueOf(currentTimeMillis - a), Long.valueOf(longValue), Long.valueOf(j2));
                    b.a(Iq.field_downloadId, f, i);
                    a.this.kMD.put(Iq.field_downloadUrl, Long.valueOf(currentTimeMillis));
                    a.this.kMC.put(Iq.field_downloadUrl, Long.valueOf(j));
                }
            }
            valueOf = (Long) a.this.kNE.get(str);
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (valueOf != null) {
                a = valueOf2.longValue() - valueOf.longValue();
                if (a > 0 && a < 500) {
                    AppMethodBeat.o(2497);
                    return;
                }
            }
            a.this.kNE.put(str, valueOf2);
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
            a.a(a.this, str, 2, (int) ((100 * j) / j2), false);
            longValue = Iq.field_downloadId;
            com.tencent.mm.plugin.downloader.f.b XS = c.XS();
            if (XS != null) {
                XS.hY("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + j + ",totalSize= " + j2 + " where downloadId = " + longValue);
            }
            a.this.kMT.ht(Iq.field_downloadId);
            AppMethodBeat.o(2497);
        }
    };
    private TMAssistantDownloadSDKClient mClient = null;
    Context mContext = ah.getContext();

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(2515);
        aVar.cancelNotification(str);
        AppMethodBeat.o(2515);
    }

    public a(com.tencent.mm.plugin.downloader.model.b bVar) {
        super(bVar);
        AppMethodBeat.i(2500);
        HashMap hashMap = new HashMap();
        String property = System.getProperty("http.agent");
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", property);
        if (bo.isNullOrNil(property)) {
            property = "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)";
        }
        property = property + " MicroMessenger";
        PackageInfo packageInfo = getPackageInfo(this.mContext, ah.getPackageName());
        if (packageInfo != null) {
            property = ((property + "/") + packageInfo.versionName) + packageInfo.versionCode;
        }
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", property + " NetType/" + at.getNetTypeString(ah.getContext()));
        hashMap.put("User-Agent", property);
        this.kNH = hashMap;
        AppMethodBeat.o(2500);
    }

    public final long a(final com.tencent.mm.plugin.downloader.f.a aVar) {
        AppMethodBeat.i(2501);
        com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
            /* JADX WARNING: Missing block: B:4:0x0055, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(2490);
     */
            /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                int startDownloadTask;
                Exception e;
                AppMethodBeat.i(2490);
                try {
                    com.tencent.mm.plugin.downloader.a.c.h(aVar.field_appId, aVar.field_downloadUrl, aVar.field_secondaryUrl);
                    com.tencent.mm.plugin.s.a.bYL();
                    m.aiN(aVar.field_appId);
                    startDownloadTask = a.this.getClient().startDownloadTask(aVar.field_downloadUrl, aVar.field_secondaryUrl, aVar.field_fileSize, 0, "resource/tm.android.unknown", ag.ck(aVar.field_downloadUrl), aVar.field_autoDownload, a.this.kNH);
                    TMAssistantDownloadTaskInfo downloadTaskState;
                    switch (startDownloadTask) {
                        case 0:
                            try {
                                downloadTaskState = a.this.getClient().getDownloadTaskState(aVar.field_downloadUrl);
                                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s, fileLen: %d, receiveLen: %d", aVar.field_downloadUrl, downloadTaskState.mSavePath, Long.valueOf(e.asZ(downloadTaskState.mSavePath)), Long.valueOf(downloadTaskState.mReceiveDataLen));
                                aVar.field_status = 1;
                                aVar.field_startTime = System.currentTimeMillis();
                                aVar.field_startSize = downloadTaskState.mReceiveDataLen;
                                aVar.field_filePath = downloadTaskState.mSavePath;
                                aVar.field_downloadedSize = downloadTaskState.mReceiveDataLen;
                                aVar.field_totalSize = downloadTaskState.mTotalDataLen;
                                c.e(aVar);
                                a.this.kNG.add(Long.valueOf(aVar.field_downloadId));
                                a.a(a.this, aVar.field_downloadUrl, downloadTaskState.mState, 0, true);
                                a.this.kMT.j(aVar.field_downloadId, downloadTaskState.mSavePath);
                                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(aVar.field_downloadId), aVar.field_downloadUrl, aVar.field_filePath);
                                AppMethodBeat.o(2490);
                                return;
                            } catch (Exception e2) {
                                e = e2;
                                break;
                            }
                        case 1:
                            aVar.field_status = 4;
                            aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJX;
                            c.e(aVar);
                            a.this.kMT.d(aVar.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kJX, false);
                            AppMethodBeat.o(2490);
                            return;
                        case 2:
                            aVar.field_status = 4;
                            aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJP;
                            c.e(aVar);
                            a.this.kMT.d(aVar.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kJP, false);
                            AppMethodBeat.o(2490);
                            return;
                        case 3:
                            aVar.field_status = 4;
                            aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID;
                            c.e(aVar);
                            c.e(aVar);
                            a.this.kMT.d(aVar.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
                            AppMethodBeat.o(2490);
                            return;
                        case 4:
                            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                            downloadTaskState = a.this.getClient().getDownloadTaskState(aVar.field_downloadUrl);
                            com.tencent.mm.plugin.downloader.f.a aVar = aVar;
                            com.tencent.mm.plugin.downloader.f.a aVar2 = aVar;
                            long currentTimeMillis = System.currentTimeMillis();
                            aVar2.field_finishTime = currentTimeMillis;
                            aVar.field_startTime = currentTimeMillis;
                            aVar.field_status = 6;
                            aVar.field_filePath = downloadTaskState.mSavePath;
                            aVar.field_startSize = downloadTaskState.mReceiveDataLen;
                            aVar.field_downloadedSize = downloadTaskState.mReceiveDataLen;
                            aVar.field_totalSize = downloadTaskState.mTotalDataLen;
                            c.e(aVar);
                            a.this.kMT.hu(aVar.field_downloadId);
                            Intent intent = new Intent();
                            intent.putExtra(FileDownloadService.kNn, 1);
                            intent.setClass(a.this.mContext, FileDownloadService.class);
                            intent.putExtra(FileDownloadService.EXTRA_ID, aVar.field_downloadId);
                            try {
                                d.aH(intent);
                            } catch (Exception e3) {
                                ab.e("MicroMsg.FileDownloaderImplTMAssistant", e3.getMessage());
                            }
                            a.this.kNG.remove(Long.valueOf(aVar.field_downloadId));
                            AppMethodBeat.o(2490);
                            return;
                        case 5:
                            aVar.field_startTime = System.currentTimeMillis();
                            aVar.field_status = 1;
                            c.e(aVar);
                            a.this.kNG.add(Long.valueOf(aVar.field_downloadId));
                            a.a(a.this, aVar.field_downloadUrl, 2, 0, true);
                            break;
                    }
                } catch (Exception e4) {
                    e3 = e4;
                    startDownloadTask = -1;
                }
                ab.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", e3.getMessage());
                aVar.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJN;
                aVar.field_status = 4;
                c.e(aVar);
                ab.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", Integer.valueOf(startDownloadTask), aVar.field_downloadUrl);
                a.this.kMT.d(aVar.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kJN, false);
                AppMethodBeat.o(2490);
            }
        }, "MicroMsg.FileDownloaderImplTMAssistant");
        long j = aVar.field_downloadId;
        AppMethodBeat.o(2501);
        return j;
    }

    public final long a(com.tencent.mm.plugin.downloader.model.e eVar) {
        AppMethodBeat.i(2502);
        if (eVar == null || bo.isNullOrNil(eVar.gUx)) {
            ab.e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
            AppMethodBeat.o(2502);
            return -1;
        }
        long j;
        String str = eVar.gUx;
        String str2 = eVar.mAppId;
        com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
        if (Iq != null) {
            FileDownloadTaskInfo hm = hm(Iq.field_downloadId);
            if (hm.status == 1) {
                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, running, return");
                j = hm.id;
                AppMethodBeat.o(2502);
                return j;
            } else if (hm.status == 6) {
                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, md5 checking, return");
                j = hm.id;
                AppMethodBeat.o(2502);
                return j;
            } else if (hm.status == 3) {
                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, has download finished, install");
                if (eVar.kNc) {
                    com.tencent.mm.plugin.downloader.h.a.a(hm.id, false, null);
                }
                j = hm.id;
                AppMethodBeat.o(2502);
                return j;
            }
        }
        if (Iq == null) {
            Iq = c.In(str2);
        }
        biv();
        c.Io(str);
        c.Ip(str2);
        com.tencent.mm.plugin.downloader.f.a c = f.c(eVar);
        if (!eVar.kNg || Iq == null) {
            c.field_downloadId = System.currentTimeMillis();
        } else {
            c.field_downloadId = Iq.field_downloadId;
        }
        c.field_status = 0;
        c.field_downloaderType = 2;
        if (Iq == null) {
            c.field_startState = 0;
        } else if (Iq.field_status == 2) {
            c.field_startState = com.tencent.mm.plugin.downloader.a.b.kKd;
        } else if (Iq.field_status == 4) {
            c.field_startState = com.tencent.mm.plugin.downloader.a.b.kKd;
        } else {
            c.field_startState = com.tencent.mm.plugin.downloader.a.b.kKc;
        }
        if (eVar.kNd) {
            c.field_md5 = f.Iy(c.field_downloadUrl);
        }
        if (!eVar.hyG || at.isWifi(ah.getContext())) {
            if (at.isWifi(ah.getContext())) {
                c.field_downloadInWifi = true;
            }
            c.d(c);
            j = a(c);
            AppMethodBeat.o(2502);
            return j;
        }
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "downloadInWifi, not wifi");
        c.field_status = 0;
        c.field_downloadInWifi = true;
        c.d(c);
        j = c.field_downloadId;
        AppMethodBeat.o(2502);
        return j;
    }

    public final int hl(final long j) {
        AppMethodBeat.i(2503);
        com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2491);
                com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
                if (hv == null) {
                    AppMethodBeat.o(2491);
                    return;
                }
                try {
                    a.this.getClient().cancelDownloadTask(hv.field_downloadUrl);
                    e.deleteFile(hv.field_filePath);
                    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask, delete file, path: %s", hv.field_filePath);
                    a.this.kNG.remove(Long.valueOf(hv.field_downloadId));
                    a.a(a.this, hv.field_downloadUrl);
                    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: status = " + hv.field_status);
                    if (hv.field_status == 5) {
                        AppMethodBeat.o(2491);
                        return;
                    }
                    hv.field_status = 5;
                    hv.field_finishTime = System.currentTimeMillis();
                    c.e(hv);
                    long a = bo.a((Long) a.this.kMD.get(hv.field_downloadUrl), hv.field_startTime);
                    float a2 = ((((float) (hv.field_downloadedSize - bo.a((Long) a.this.kMC.get(hv.field_downloadUrl), hv.field_startSize))) * 1000.0f) / ((float) (System.currentTimeMillis() - a))) / 1048576.0f;
                    b.a(hv.field_downloadId, a2, (int) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f));
                    a.this.kMT.hr(hv.field_downloadId);
                    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: id: %d, path: %s", Long.valueOf(j), hv.field_filePath);
                    AppMethodBeat.o(2491);
                } catch (Exception e) {
                    ab.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant remove task failed: " + e.toString());
                    AppMethodBeat.o(2491);
                }
            }
        }, "MicroMsg.FileDownloaderImplTMAssistant");
        AppMethodBeat.o(2503);
        return 1;
    }

    public final FileDownloadTaskInfo hm(long j) {
        AppMethodBeat.i(2504);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null || bo.isNullOrNil(hv.field_downloadUrl)) {
            AppMethodBeat.o(2504);
            return fileDownloadTaskInfo;
        }
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        fileDownloadTaskInfo.url = hv.field_downloadUrl;
        fileDownloadTaskInfo.status = hv.field_status;
        fileDownloadTaskInfo.path = hv.field_filePath;
        if (e.ct(hv.field_filePath)) {
            fileDownloadTaskInfo.kNr = hv.field_downloadedSize;
            fileDownloadTaskInfo.jrb = hv.field_totalSize;
        } else {
            fileDownloadTaskInfo.kNr = 0;
            fileDownloadTaskInfo.jrb = 0;
        }
        fileDownloadTaskInfo.cvZ = hv.field_md5;
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            final String str = fileDownloadTaskInfo.url;
            tMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo) new bj<TMAssistantDownloadTaskInfo>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(2493);
                    TMAssistantDownloadTaskInfo biw = biw();
                    AppMethodBeat.o(2493);
                    return biw;
                }

                private TMAssistantDownloadTaskInfo biw() {
                    AppMethodBeat.i(2492);
                    TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
                    try {
                        tMAssistantDownloadTaskInfo = a.this.getClient().getDownloadTaskState(str);
                    } catch (Exception e) {
                        ab.e("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadStateSync faile: " + e.toString());
                    }
                    AppMethodBeat.o(2492);
                    return tMAssistantDownloadTaskInfo;
                }
            }.b(g.RS().doN());
        } else {
            try {
                tMAssistantDownloadTaskInfo = getClient().getDownloadTaskState(fileDownloadTaskInfo.url);
            } catch (Exception e) {
                ab.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + e.toString());
                tMAssistantDownloadTaskInfo = null;
            }
        }
        if (tMAssistantDownloadTaskInfo != null) {
            switch (tMAssistantDownloadTaskInfo.mState) {
                case 1:
                case 2:
                    fileDownloadTaskInfo.status = 1;
                    break;
                case 3:
                    fileDownloadTaskInfo.status = 2;
                    break;
                case 4:
                    if (fileDownloadTaskInfo.status != 6) {
                        fileDownloadTaskInfo.status = 3;
                        break;
                    }
                    fileDownloadTaskInfo.status = 6;
                    break;
                default:
                    if (fileDownloadTaskInfo.status == 1) {
                        fileDownloadTaskInfo.status = 0;
                        break;
                    }
                    break;
            }
            fileDownloadTaskInfo.path = tMAssistantDownloadTaskInfo.mSavePath;
            fileDownloadTaskInfo.kNr = tMAssistantDownloadTaskInfo.mReceiveDataLen;
            fileDownloadTaskInfo.jrb = tMAssistantDownloadTaskInfo.mTotalDataLen;
        } else if (fileDownloadTaskInfo.status == 1) {
            fileDownloadTaskInfo.status = 0;
        }
        if ((fileDownloadTaskInfo.status == 6 || fileDownloadTaskInfo.status == 3) && !e.ct(fileDownloadTaskInfo.path)) {
            fileDownloadTaskInfo.status = 0;
        }
        if (bo.isNullOrNil(hv.field_filePath)) {
            hv.field_filePath = fileDownloadTaskInfo.path;
            c.e(hv);
        }
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: appId: %s, status: %d, url: %s, path: %s", hv.field_appId, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path);
        AppMethodBeat.o(2504);
        return fileDownloadTaskInfo;
    }

    /* Access modifiers changed, original: final */
    public final boolean biu() {
        AppMethodBeat.i(2505);
        if (this.kNG == null || this.kNG.size() == 0) {
            TMAssistantDownloadSDKManager.getInstance(this.mContext).releaseDownloadSDKClient("WechatDownloadClient");
            if (this.mClient != null) {
                this.mClient.unRegisterDownloadTaskListener(this.kNJ);
            }
            this.mClient = null;
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
            try {
                this.mContext.stopService(new Intent(this.mContext, TMAssistantDownloadSDKService.class));
            } catch (Exception e) {
                ab.e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + e.toString());
            }
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
            AppMethodBeat.o(2505);
            return true;
        }
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
        AppMethodBeat.o(2505);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final TMAssistantDownloadSDKClient getClient() {
        AppMethodBeat.i(2506);
        if (this.mClient == null) {
            this.mClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient("WechatDownloadClient");
            this.mClient.registerDownloadTaskListener(this.kNJ);
        }
        this.kNI.ae(240000, 240000);
        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient = this.mClient;
        AppMethodBeat.o(2506);
        return tMAssistantDownloadSDKClient;
    }

    /* Access modifiers changed, original: final */
    public final void cancelNotification(String str) {
        AppMethodBeat.i(2507);
        synchronized (this.eMl) {
            try {
                Integer num = (Integer) this.kNF.get(str);
                if (num == null) {
                    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
                } else {
                    ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
                    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = ".concat(String.valueOf(num)));
                    this.kNF.remove(str);
                    AppMethodBeat.o(2507);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(2507);
            }
        }
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(2508);
        if (str == null) {
            ab.e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
            AppMethodBeat.o(2508);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.o(2508);
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                AppMethodBeat.o(2508);
            }
        }
        return packageInfo;
    }

    private static void biv() {
        AppMethodBeat.i(2509);
        if (!new com.tencent.mm.vfs.b(TMAssistantFile.getSavePathRootDir() + "/.tmp/").exists()) {
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", Boolean.valueOf(new com.tencent.mm.vfs.b(TMAssistantFile.getSavePathRootDir() + "/.tmp/").mkdirs()));
        }
        AppMethodBeat.o(2509);
    }

    public final boolean hn(final long j) {
        AppMethodBeat.i(2510);
        final com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null || bo.isNullOrNil(hv.field_downloadUrl)) {
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", Long.valueOf(j));
            AppMethodBeat.o(2510);
            return false;
        } else if (hv.field_downloaderType != 2) {
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", Long.valueOf(j));
            e.deleteFile(hv.field_filePath);
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask, delete file: %s", hv.field_filePath);
            c.hw(j);
            AppMethodBeat.o(2510);
            return false;
        } else {
            com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(2498);
                    try {
                        TMAssistantDownloadTaskInfo downloadTaskState = a.this.getClient().getDownloadTaskState(hv.field_downloadUrl);
                        if (downloadTaskState.mState == 1 || downloadTaskState.mState == 2) {
                            a.this.getClient().pauseDownloadTask(hv.field_downloadUrl);
                            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", Long.valueOf(j));
                            AppMethodBeat.o(2498);
                            return;
                        }
                        AppMethodBeat.o(2498);
                    } catch (Exception e) {
                        ab.e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", e.toString());
                        ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                        AppMethodBeat.o(2498);
                    }
                }
            }, "MicroMsg.FileDownloaderImplTMAssistant");
            AppMethodBeat.o(2510);
            return true;
        }
    }

    public final boolean ho(long j) {
        AppMethodBeat.i(2511);
        boolean n = n(j, true);
        AppMethodBeat.o(2511);
        return n;
    }

    public final boolean hp(long j) {
        AppMethodBeat.i(2512);
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(j)));
        boolean n = n(j, false);
        AppMethodBeat.o(2512);
        return n;
    }

    public final boolean n(long j, boolean z) {
        AppMethodBeat.i(2513);
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: id = ".concat(String.valueOf(j)));
        final com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null || bo.isNullOrNil(hv.field_downloadUrl)) {
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", Long.valueOf(j));
            AppMethodBeat.o(2513);
            return false;
        } else if (hv.field_downloaderType != 2) {
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", Long.valueOf(j));
            e.deleteFile(hv.field_filePath);
            ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, delete file: " + hv.field_filePath);
            c.hw(j);
            AppMethodBeat.o(2513);
            return false;
        } else {
            FileDownloadTaskInfo hm = hm(hv.field_downloadId);
            if (hm.status == 1) {
                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "download runing, return");
                AppMethodBeat.o(2513);
                return true;
            } else if (hm.status == 6) {
                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "md5 checking ,return");
                AppMethodBeat.o(2513);
                return true;
            } else if (hm.status == 3) {
                ab.i("MicroMsg.FileDownloaderImplTMAssistant", "has download finished, install");
                if (hv.field_autoInstall) {
                    com.tencent.mm.plugin.downloader.h.a.a(hm.id, false, null);
                }
                AppMethodBeat.o(2513);
                return true;
            } else {
                if (hv.field_status == 2) {
                    hv.field_startState = com.tencent.mm.plugin.downloader.a.b.kKd;
                } else if (hv.field_status == 4) {
                    hv.field_startState = com.tencent.mm.plugin.downloader.a.b.kKe;
                } else {
                    hv.field_startState = com.tencent.mm.plugin.downloader.a.b.kKc;
                }
                hv.field_startSize = hv.field_downloadedSize;
                hv.field_errCode = 0;
                biv();
                if ((hv.field_reserveInWifi || hv.field_downloadInWifi) && !at.isWifi(ah.getContext())) {
                    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask downloadInWifi, not wifi");
                    AppMethodBeat.o(2513);
                    return true;
                }
                if (at.isWifi(ah.getContext())) {
                    hv.field_downloadInWifi = true;
                }
                final boolean z2 = z;
                final long j2 = j;
                com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(2499);
                        com.tencent.mm.plugin.downloader.a.c.h(hv.field_appId, hv.field_downloadUrl, hv.field_secondaryUrl);
                        com.tencent.mm.plugin.s.a.bYL();
                        m.aiN(hv.field_appId);
                        TMAssistantDownloadTaskInfo downloadTaskState = a.this.getClient().getDownloadTaskState(hv.field_downloadUrl);
                        if (downloadTaskState == null || !(downloadTaskState.mState == 1 || downloadTaskState.mState == 2)) {
                            try {
                                int startDownloadTask = a.this.getClient().startDownloadTask(hv.field_downloadUrl, hv.field_secondaryUrl, hv.field_fileSize, 0, "resource/tm.android.unknown", ag.ck(hv.field_downloadUrl), hv.field_autoDownload, a.this.kNH);
                                TMAssistantDownloadTaskInfo downloadTaskState2 = a.this.getClient().getDownloadTaskState(hv.field_downloadUrl);
                                switch (startDownloadTask) {
                                    case 0:
                                        hv.field_status = 1;
                                        hv.field_startTime = System.currentTimeMillis();
                                        hv.field_filePath = downloadTaskState2.mSavePath;
                                        hv.field_totalSize = downloadTaskState2.mTotalDataLen;
                                        hv.field_status = 1;
                                        c.e(hv);
                                        a.this.kNG.add(Long.valueOf(hv.field_downloadId));
                                        a.a(a.this, hv.field_downloadUrl, 2, 0, true);
                                        if (z2) {
                                            a.this.kMT.k(hv.field_downloadId, hv.field_filePath);
                                        }
                                        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", Long.valueOf(j2));
                                        AppMethodBeat.o(2499);
                                        return;
                                    case 1:
                                        hv.field_status = 4;
                                        hv.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJX;
                                        c.e(hv);
                                        a.this.kMT.d(hv.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kJX, false);
                                        AppMethodBeat.o(2499);
                                        return;
                                    case 2:
                                        hv.field_status = 4;
                                        hv.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJP;
                                        c.e(hv);
                                        a.this.kMT.d(hv.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kJP, false);
                                        AppMethodBeat.o(2499);
                                        return;
                                    case 3:
                                        hv.field_status = 4;
                                        hv.field_errCode = com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID;
                                        c.e(hv);
                                        a.this.kMT.d(hv.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
                                        AppMethodBeat.o(2499);
                                        return;
                                    case 4:
                                        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                                        com.tencent.mm.plugin.downloader.f.a aVar = hv;
                                        com.tencent.mm.plugin.downloader.f.a aVar2 = hv;
                                        long currentTimeMillis = System.currentTimeMillis();
                                        aVar2.field_finishTime = currentTimeMillis;
                                        aVar.field_startTime = currentTimeMillis;
                                        hv.field_status = 6;
                                        hv.field_filePath = downloadTaskState2.mSavePath;
                                        hv.field_startSize = downloadTaskState2.mReceiveDataLen;
                                        hv.field_downloadedSize = downloadTaskState2.mReceiveDataLen;
                                        hv.field_totalSize = downloadTaskState2.mTotalDataLen;
                                        c.e(hv);
                                        a.this.kMT.hu(hv.field_downloadId);
                                        Intent intent = new Intent();
                                        intent.putExtra(FileDownloadService.kNn, 1);
                                        intent.setClass(a.this.mContext, FileDownloadService.class);
                                        intent.putExtra(FileDownloadService.EXTRA_ID, hv.field_downloadId);
                                        try {
                                            d.aH(intent);
                                        } catch (Exception e) {
                                            ab.e("MicroMsg.FileDownloaderImplTMAssistant", e.getMessage());
                                        }
                                        a.this.kNG.remove(Long.valueOf(hv.field_downloadId));
                                        AppMethodBeat.o(2499);
                                        return;
                                    case 5:
                                        hv.field_startTime = System.currentTimeMillis();
                                        hv.field_status = 1;
                                        c.e(hv);
                                        a.this.kNG.add(Long.valueOf(hv.field_downloadId));
                                        a.a(a.this, hv.field_downloadUrl, 2, 0, true);
                                        break;
                                }
                                AppMethodBeat.o(2499);
                                return;
                            } catch (Exception e2) {
                                ab.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", e2.toString());
                                ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e2, "", new Object[0]);
                                hv.field_status = 4;
                                hv.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJO;
                                c.e(hv);
                                a.this.kMT.d(hv.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kJO, false);
                                AppMethodBeat.o(2499);
                                return;
                            }
                        }
                        ab.w("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, is running");
                        AppMethodBeat.o(2499);
                    }
                }, "MicroMsg.FileDownloaderImplTMAssistant");
                AppMethodBeat.o(2513);
                return true;
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        AppMethodBeat.i(2514);
        com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
        if (Iq == null) {
            ab.e("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification failed: null task info");
            AppMethodBeat.o(2514);
        } else if (Iq.field_showNotification) {
            v.c bt = com.tencent.mm.bo.a.bt(aVar.mContext, "reminder_channel_id");
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.kND.put(str, Long.valueOf(currentTimeMillis));
                bt.j(currentTimeMillis);
            } else {
                Long l = (Long) aVar.kND.get(str);
                if (l != null) {
                    bt.j(l.longValue());
                } else {
                    l = Long.valueOf(System.currentTimeMillis());
                    aVar.kND.put(str, l);
                    bt.j(l.longValue());
                }
            }
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(Iq.field_appId, false);
            if (bT == null || bo.isNullOrNil(bT.field_appName)) {
                bt.d(Iq.field_fileName);
            } else {
                bt.d(bT.field_appName);
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    bt.as(17301633);
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    bt.b(100, i2, i2 == 0);
                    bt.e(aVar.mContext.getString(R.string.bsp));
                    if (Iq.field_reserveInWifi) {
                        bt.f(aVar.mContext.getString(R.string.bsr));
                    }
                    bt.k(2, true);
                    long j = Iq.field_downloadId;
                    Intent intent = new Intent(aVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    bt.EI = PendingIntent.getActivity(aVar.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 4:
                case 6:
                    aVar.cancelNotification(str);
                    AppMethodBeat.o(2514);
                    return;
                case 5:
                    bt.as(17301634);
                    bt.z(true);
                    bt.EI = PendingIntent.getActivity(ah.getContext(), 0, new Intent(), 0);
                    bt.e(aVar.mContext.getString(R.string.bsn));
                    break;
            }
            synchronized (aVar.eMl) {
                try {
                    Integer num = (Integer) aVar.kNF.get(str);
                    if (num == null) {
                        aVar.kNF.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(bt.build())));
                    } else {
                        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), bt.build());
                    }
                    if (i == 4) {
                        aVar.kNF.remove(str);
                    }
                } finally {
                    AppMethodBeat.o(2514);
                }
            }
        } else {
            AppMethodBeat.o(2514);
        }
    }
}
