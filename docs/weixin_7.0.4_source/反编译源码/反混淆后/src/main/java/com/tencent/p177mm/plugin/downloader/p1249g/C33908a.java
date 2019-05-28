package com.tencent.p177mm.plugin.downloader.p1249g;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p230g.p231a.C41999hc;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2900e;
import com.tencent.p177mm.plugin.downloader.model.C33922f;
import com.tencent.p177mm.plugin.downloader.model.C45831h;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadService;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p1250ui.FileDownloadConfirmUI;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42912b;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.downloader.p939a.C33901b;
import com.tencent.p177mm.plugin.downloader.p939a.C38842c;
import com.tencent.p177mm.plugin.downloader.p943h.C11509b;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4735m;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.plugin.downloader.g.a */
public final class C33908a extends C45831h {
    private byte[] eMl = new byte[0];
    HashMap<String, Long> kMC = new HashMap();
    HashMap<String, Long> kMD = new HashMap();
    private HashMap<String, Long> kND = new HashMap();
    HashMap<String, Long> kNE = new HashMap();
    private ConcurrentHashMap<String, Integer> kNF = new ConcurrentHashMap();
    HashSet<Long> kNG = new HashSet();
    Map<String, String> kNH = null;
    C7564ap kNI = new C7564ap(Looper.getMainLooper(), new C339094(), false);
    private ITMAssistantDownloadSDKClientListener kNJ = new C339115();
    private TMAssistantDownloadSDKClient mClient = null;
    Context mContext = C4996ah.getContext();

    /* renamed from: com.tencent.mm.plugin.downloader.g.a$4 */
    class C339094 implements C5015a {
        C339094() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(2494);
            if (!C33908a.this.biu()) {
                C33908a.this.kNI.mo16770ae(240000, 240000);
            }
            AppMethodBeat.m2505o(2494);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.g.a$5 */
    class C339115 implements ITMAssistantDownloadSDKClientListener {
        C339115() {
        }

        public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
            AppMethodBeat.m2504i(2495);
            C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
            Iterator it = C33908a.this.kNG.iterator();
            while (it.hasNext()) {
                C42911a hv = C2895c.m5147hv(((Long) it.next()).longValue());
                if (hv != null) {
                    hv.field_finishTime = System.currentTimeMillis();
                    hv.field_status = 4;
                    hv.field_errCode = C11498a.kJM;
                    C2895c.m5146e(hv);
                    C33908a.this.kMT.mo7025d(hv.field_downloadId, C11498a.kJM, false);
                    C33908a.m55489a(C33908a.this, hv.field_downloadUrl, 5, 0, false);
                }
            }
            C33908a.this.kNG.clear();
            AppMethodBeat.m2505o(2495);
        }

        public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i, int i2, String str2, boolean z, boolean z2) {
            AppMethodBeat.m2504i(2496);
            C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + i + " | ErrorCode: " + i2 + " | ErrorMsg: " + str2);
            C42911a Iq = C2895c.m5143Iq(str);
            if (Iq == null) {
                C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                AppMethodBeat.m2505o(2496);
                return;
            }
            C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", Integer.valueOf(i), Long.valueOf(Iq.field_downloadId), Iq.field_filePath, Boolean.valueOf(C5730e.m8628ct(Iq.field_filePath)), str);
            if (!(i == 1 || i == 2)) {
                FileDownloadTaskInfo hm = C33908a.this.mo23226hm(Iq.field_downloadId);
                long a = C5046bo.m7514a((Long) C33908a.this.kMD.get(Iq.field_downloadUrl), Iq.field_startTime);
                int i3 = (int) ((((float) hm.kNr) / ((float) hm.jrb)) * 100.0f);
                C11509b.m19313a(Iq.field_downloadId, ((((float) (hm.kNr - C5046bo.m7514a((Long) C33908a.this.kMC.get(Iq.field_downloadUrl), Iq.field_startSize))) * 1000.0f) / ((float) (System.currentTimeMillis() - a))) / 1048576.0f, i3);
                C33908a.this.kMC.remove(Iq.field_downloadUrl);
                C33908a.this.kMD.remove(Iq.field_downloadUrl);
            }
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
            try {
                tMAssistantDownloadTaskInfo = C33908a.this.getClient().getDownloadTaskState(Iq.field_downloadUrl);
            } catch (Exception e) {
            }
            switch (i) {
                case 1:
                    AppMethodBeat.m2505o(2496);
                    return;
                case 2:
                    Iq.field_status = 1;
                    if (tMAssistantDownloadTaskInfo != null) {
                        Iq.field_filePath = tMAssistantDownloadTaskInfo.mSavePath;
                    }
                    C2895c.m5146e(Iq);
                    AppMethodBeat.m2505o(2496);
                    return;
                case 3:
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_status = 2;
                    C2895c.m5146e(Iq);
                    C33908a.this.cancelNotification(str);
                    C33908a.this.kNG.remove(Long.valueOf(Iq.field_downloadId));
                    C33908a.this.kMT.mo7027hs(Iq.field_downloadId);
                    AppMethodBeat.m2505o(2496);
                    return;
                case 4:
                    C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
                    Iq.field_status = 6;
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_downloadedSize = Iq.field_totalSize;
                    if (tMAssistantDownloadTaskInfo != null) {
                        Iq.field_filePath = tMAssistantDownloadTaskInfo.mSavePath;
                    }
                    C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(Iq.field_downloadedSize), Long.valueOf(Iq.field_startSize));
                    C2895c.m5146e(Iq);
                    C33908a.this.kMT.mo7029hu(Iq.field_downloadId);
                    if (z2) {
                        C41999hc c41999hc = new C41999hc();
                        c41999hc.cBN.appId = Iq.field_appId;
                        c41999hc.cBN.opType = 6;
                        C4879a.xxA.mo10055m(c41999hc);
                    }
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kNn, 1);
                    intent.setClass(C33908a.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, Iq.field_downloadId);
                    intent.putExtra(FileDownloadService.kNq, z);
                    try {
                        C25985d.m41463aH(intent);
                    } catch (Exception e2) {
                        C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", e2.getMessage());
                    }
                    C33908a.this.cancelNotification(str);
                    C33908a.this.kNG.remove(Long.valueOf(Iq.field_downloadId));
                    AppMethodBeat.m2505o(2496);
                    return;
                case 5:
                    if (i2 == 601 || i2 == 602 || i2 == 603 || i2 == 605 || i2 == 606) {
                        C4990ab.m7410d("MicroMsg.FileDownloaderImplTMAssistant", "releaseTimer 4 min");
                        C33908a.this.kNI.mo16770ae(240000, 240000);
                    }
                    if (C5023at.isWifi(C4996ah.getContext()) && Iq.field_downloadInWifi) {
                        Iq.field_downloadInWifi = false;
                        Iq.field_reserveInWifi = false;
                    }
                    C33908a.m55489a(C33908a.this, str, i, 0, false);
                    C33908a.this.kNG.remove(Long.valueOf(Iq.field_downloadId));
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_errCode = i2;
                    Iq.field_status = 4;
                    C2895c.m5146e(Iq);
                    C33908a.this.kMT.mo7025d(Iq.field_downloadId, i2, z);
                    break;
            }
            AppMethodBeat.m2505o(2496);
        }

        public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
            AppMethodBeat.m2504i(2497);
            C42911a Iq = C2895c.m5143Iq(str);
            if (Iq == null) {
                C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                AppMethodBeat.m2505o(2497);
                return;
            }
            long a;
            Long valueOf = Long.valueOf(C5046bo.m7534c((Long) C33908a.this.kMC.get(Iq.field_downloadUrl)));
            if (valueOf.longValue() == 0) {
                valueOf = Long.valueOf(j);
                C33908a.this.kMC.put(Iq.field_downloadUrl, Long.valueOf(j));
            }
            long longValue = j - valueOf.longValue();
            if (j2 == 0) {
                C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "onDownloadTaskProgressChanged, totalDataLen = 0");
            } else {
                int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                if ((100 * longValue) / j2 >= 1) {
                    a = C5046bo.m7514a((Long) C33908a.this.kMD.get(Iq.field_downloadUrl), Iq.field_startTime);
                    long currentTimeMillis = System.currentTimeMillis();
                    float f = ((((float) longValue) * 1000.0f) / ((float) (currentTimeMillis - a))) / 1048576.0f;
                    C4990ab.m7411d("MicroMsg.FileDownloaderImplTMAssistant", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d", Iq.field_appId, Float.valueOf(f), Long.valueOf(currentTimeMillis - a), Long.valueOf(longValue), Long.valueOf(j2));
                    C11509b.m19313a(Iq.field_downloadId, f, i);
                    C33908a.this.kMD.put(Iq.field_downloadUrl, Long.valueOf(currentTimeMillis));
                    C33908a.this.kMC.put(Iq.field_downloadUrl, Long.valueOf(j));
                }
            }
            valueOf = (Long) C33908a.this.kNE.get(str);
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (valueOf != null) {
                a = valueOf2.longValue() - valueOf.longValue();
                if (a > 0 && a < 500) {
                    AppMethodBeat.m2505o(2497);
                    return;
                }
            }
            C33908a.this.kNE.put(str, valueOf2);
            C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
            C33908a.m55489a(C33908a.this, str, 2, (int) ((100 * j) / j2), false);
            longValue = Iq.field_downloadId;
            C42912b XS = C2895c.m5144XS();
            if (XS != null) {
                XS.mo16768hY("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + j + ",totalSize= " + j2 + " where downloadId = " + longValue);
            }
            C33908a.this.kMT.mo7028ht(Iq.field_downloadId);
            AppMethodBeat.m2505o(2497);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m55488a(C33908a c33908a, String str) {
        AppMethodBeat.m2504i(2515);
        c33908a.cancelNotification(str);
        AppMethodBeat.m2505o(2515);
    }

    public C33908a(C2886b c2886b) {
        super(c2886b);
        AppMethodBeat.m2504i(2500);
        HashMap hashMap = new HashMap();
        String property = System.getProperty("http.agent");
        C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", property);
        if (C5046bo.isNullOrNil(property)) {
            property = "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)";
        }
        property = property + " MicroMessenger";
        PackageInfo packageInfo = C33908a.getPackageInfo(this.mContext, C4996ah.getPackageName());
        if (packageInfo != null) {
            property = ((property + "/") + packageInfo.versionName) + packageInfo.versionCode;
        }
        C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", property + " NetType/" + C5023at.getNetTypeString(C4996ah.getContext()));
        hashMap.put("User-Agent", property);
        this.kNH = hashMap;
        AppMethodBeat.m2505o(2500);
    }

    /* renamed from: a */
    public final long mo23223a(final C42911a c42911a) {
        AppMethodBeat.m2504i(2501);
        C7305d.xDH.mo10140a(new Runnable() {
            /* JADX WARNING: Missing block: B:4:0x0055, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(2490);
     */
            /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                int startDownloadTask;
                Exception e;
                AppMethodBeat.m2504i(2490);
                try {
                    C38842c.m65896h(c42911a.field_appId, c42911a.field_downloadUrl, c42911a.field_secondaryUrl);
                    C34832a.bYL();
                    C4735m.aiN(c42911a.field_appId);
                    startDownloadTask = C33908a.this.getClient().startDownloadTask(c42911a.field_downloadUrl, c42911a.field_secondaryUrl, c42911a.field_fileSize, 0, "resource/tm.android.unknown", C4995ag.m7428ck(c42911a.field_downloadUrl), c42911a.field_autoDownload, C33908a.this.kNH);
                    TMAssistantDownloadTaskInfo downloadTaskState;
                    switch (startDownloadTask) {
                        case 0:
                            try {
                                downloadTaskState = C33908a.this.getClient().getDownloadTaskState(c42911a.field_downloadUrl);
                                C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s, fileLen: %d, receiveLen: %d", c42911a.field_downloadUrl, downloadTaskState.mSavePath, Long.valueOf(C5730e.asZ(downloadTaskState.mSavePath)), Long.valueOf(downloadTaskState.mReceiveDataLen));
                                c42911a.field_status = 1;
                                c42911a.field_startTime = System.currentTimeMillis();
                                c42911a.field_startSize = downloadTaskState.mReceiveDataLen;
                                c42911a.field_filePath = downloadTaskState.mSavePath;
                                c42911a.field_downloadedSize = downloadTaskState.mReceiveDataLen;
                                c42911a.field_totalSize = downloadTaskState.mTotalDataLen;
                                C2895c.m5146e(c42911a);
                                C33908a.this.kNG.add(Long.valueOf(c42911a.field_downloadId));
                                C33908a.m55489a(C33908a.this, c42911a.field_downloadUrl, downloadTaskState.mState, 0, true);
                                C33908a.this.kMT.mo7030j(c42911a.field_downloadId, downloadTaskState.mSavePath);
                                C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(c42911a.field_downloadId), c42911a.field_downloadUrl, c42911a.field_filePath);
                                AppMethodBeat.m2505o(2490);
                                return;
                            } catch (Exception e2) {
                                e = e2;
                                break;
                            }
                        case 1:
                            c42911a.field_status = 4;
                            c42911a.field_errCode = C11498a.kJX;
                            C2895c.m5146e(c42911a);
                            C33908a.this.kMT.mo7025d(c42911a.field_downloadId, C11498a.kJX, false);
                            AppMethodBeat.m2505o(2490);
                            return;
                        case 2:
                            c42911a.field_status = 4;
                            c42911a.field_errCode = C11498a.kJP;
                            C2895c.m5146e(c42911a);
                            C33908a.this.kMT.mo7025d(c42911a.field_downloadId, C11498a.kJP, false);
                            AppMethodBeat.m2505o(2490);
                            return;
                        case 3:
                            c42911a.field_status = 4;
                            c42911a.field_errCode = C11498a.DOWNLOAD_ERR_URL_INVALID;
                            C2895c.m5146e(c42911a);
                            C2895c.m5146e(c42911a);
                            C33908a.this.kMT.mo7025d(c42911a.field_downloadId, C11498a.DOWNLOAD_ERR_URL_INVALID, false);
                            AppMethodBeat.m2505o(2490);
                            return;
                        case 4:
                            C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                            downloadTaskState = C33908a.this.getClient().getDownloadTaskState(c42911a.field_downloadUrl);
                            C42911a c42911a = c42911a;
                            C42911a c42911a2 = c42911a;
                            long currentTimeMillis = System.currentTimeMillis();
                            c42911a2.field_finishTime = currentTimeMillis;
                            c42911a.field_startTime = currentTimeMillis;
                            c42911a.field_status = 6;
                            c42911a.field_filePath = downloadTaskState.mSavePath;
                            c42911a.field_startSize = downloadTaskState.mReceiveDataLen;
                            c42911a.field_downloadedSize = downloadTaskState.mReceiveDataLen;
                            c42911a.field_totalSize = downloadTaskState.mTotalDataLen;
                            C2895c.m5146e(c42911a);
                            C33908a.this.kMT.mo7029hu(c42911a.field_downloadId);
                            Intent intent = new Intent();
                            intent.putExtra(FileDownloadService.kNn, 1);
                            intent.setClass(C33908a.this.mContext, FileDownloadService.class);
                            intent.putExtra(FileDownloadService.EXTRA_ID, c42911a.field_downloadId);
                            try {
                                C25985d.m41463aH(intent);
                            } catch (Exception e3) {
                                C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", e3.getMessage());
                            }
                            C33908a.this.kNG.remove(Long.valueOf(c42911a.field_downloadId));
                            AppMethodBeat.m2505o(2490);
                            return;
                        case 5:
                            c42911a.field_startTime = System.currentTimeMillis();
                            c42911a.field_status = 1;
                            C2895c.m5146e(c42911a);
                            C33908a.this.kNG.add(Long.valueOf(c42911a.field_downloadId));
                            C33908a.m55489a(C33908a.this, c42911a.field_downloadUrl, 2, 0, true);
                            break;
                    }
                } catch (Exception e4) {
                    e3 = e4;
                    startDownloadTask = -1;
                }
                C4990ab.m7413e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", e3.getMessage());
                c42911a.field_errCode = C11498a.kJN;
                c42911a.field_status = 4;
                C2895c.m5146e(c42911a);
                C4990ab.m7413e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", Integer.valueOf(startDownloadTask), c42911a.field_downloadUrl);
                C33908a.this.kMT.mo7025d(c42911a.field_downloadId, C11498a.kJN, false);
                AppMethodBeat.m2505o(2490);
            }
        }, "MicroMsg.FileDownloaderImplTMAssistant");
        long j = c42911a.field_downloadId;
        AppMethodBeat.m2505o(2501);
        return j;
    }

    /* renamed from: a */
    public final long mo23224a(C2900e c2900e) {
        AppMethodBeat.m2504i(2502);
        if (c2900e == null || C5046bo.isNullOrNil(c2900e.gUx)) {
            C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
            AppMethodBeat.m2505o(2502);
            return -1;
        }
        long j;
        String str = c2900e.gUx;
        String str2 = c2900e.mAppId;
        C42911a Iq = C2895c.m5143Iq(str);
        if (Iq != null) {
            FileDownloadTaskInfo hm = mo23226hm(Iq.field_downloadId);
            if (hm.status == 1) {
                C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, running, return");
                j = hm.f16167id;
                AppMethodBeat.m2505o(2502);
                return j;
            } else if (hm.status == 6) {
                C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, md5 checking, return");
                j = hm.f16167id;
                AppMethodBeat.m2505o(2502);
                return j;
            } else if (hm.status == 3) {
                C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, has download finished, install");
                if (c2900e.kNc) {
                    C33913a.m55499a(hm.f16167id, false, null);
                }
                j = hm.f16167id;
                AppMethodBeat.m2505o(2502);
                return j;
            }
        }
        if (Iq == null) {
            Iq = C2895c.m5140In(str2);
        }
        C33908a.biv();
        C2895c.m5141Io(str);
        C2895c.m5142Ip(str2);
        C42911a c = C33922f.m55522c(c2900e);
        if (!c2900e.kNg || Iq == null) {
            c.field_downloadId = System.currentTimeMillis();
        } else {
            c.field_downloadId = Iq.field_downloadId;
        }
        c.field_status = 0;
        c.field_downloaderType = 2;
        if (Iq == null) {
            c.field_startState = 0;
        } else if (Iq.field_status == 2) {
            c.field_startState = C33901b.kKd;
        } else if (Iq.field_status == 4) {
            c.field_startState = C33901b.kKd;
        } else {
            c.field_startState = C33901b.kKc;
        }
        if (c2900e.kNd) {
            c.field_md5 = C33922f.m55521Iy(c.field_downloadUrl);
        }
        if (!c2900e.hyG || C5023at.isWifi(C4996ah.getContext())) {
            if (C5023at.isWifi(C4996ah.getContext())) {
                c.field_downloadInWifi = true;
            }
            C2895c.m5145d(c);
            j = mo23223a(c);
            AppMethodBeat.m2505o(2502);
            return j;
        }
        C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "downloadInWifi, not wifi");
        c.field_status = 0;
        c.field_downloadInWifi = true;
        C2895c.m5145d(c);
        j = c.field_downloadId;
        AppMethodBeat.m2505o(2502);
        return j;
    }

    /* renamed from: hl */
    public final int mo23225hl(final long j) {
        AppMethodBeat.m2504i(2503);
        C7305d.xDH.mo10140a(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2491);
                C42911a hv = C2895c.m5147hv(j);
                if (hv == null) {
                    AppMethodBeat.m2505o(2491);
                    return;
                }
                try {
                    C33908a.this.getClient().cancelDownloadTask(hv.field_downloadUrl);
                    C5730e.deleteFile(hv.field_filePath);
                    C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask, delete file, path: %s", hv.field_filePath);
                    C33908a.this.kNG.remove(Long.valueOf(hv.field_downloadId));
                    C33908a.m55488a(C33908a.this, hv.field_downloadUrl);
                    C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: status = " + hv.field_status);
                    if (hv.field_status == 5) {
                        AppMethodBeat.m2505o(2491);
                        return;
                    }
                    hv.field_status = 5;
                    hv.field_finishTime = System.currentTimeMillis();
                    C2895c.m5146e(hv);
                    long a = C5046bo.m7514a((Long) C33908a.this.kMD.get(hv.field_downloadUrl), hv.field_startTime);
                    float a2 = ((((float) (hv.field_downloadedSize - C5046bo.m7514a((Long) C33908a.this.kMC.get(hv.field_downloadUrl), hv.field_startSize))) * 1000.0f) / ((float) (System.currentTimeMillis() - a))) / 1048576.0f;
                    C11509b.m19313a(hv.field_downloadId, a2, (int) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f));
                    C33908a.this.kMT.mo7026hr(hv.field_downloadId);
                    C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: id: %d, path: %s", Long.valueOf(j), hv.field_filePath);
                    AppMethodBeat.m2505o(2491);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant remove task failed: " + e.toString());
                    AppMethodBeat.m2505o(2491);
                }
            }
        }, "MicroMsg.FileDownloaderImplTMAssistant");
        AppMethodBeat.m2505o(2503);
        return 1;
    }

    /* renamed from: hm */
    public final FileDownloadTaskInfo mo23226hm(long j) {
        AppMethodBeat.m2504i(2504);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.f16167id = j;
        C42911a hv = C2895c.m5147hv(j);
        if (hv == null || C5046bo.isNullOrNil(hv.field_downloadUrl)) {
            AppMethodBeat.m2505o(2504);
            return fileDownloadTaskInfo;
        }
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        fileDownloadTaskInfo.url = hv.field_downloadUrl;
        fileDownloadTaskInfo.status = hv.field_status;
        fileDownloadTaskInfo.path = hv.field_filePath;
        if (C5730e.m8628ct(hv.field_filePath)) {
            fileDownloadTaskInfo.kNr = hv.field_downloadedSize;
            fileDownloadTaskInfo.jrb = hv.field_totalSize;
        } else {
            fileDownloadTaskInfo.kNr = 0;
            fileDownloadTaskInfo.jrb = 0;
        }
        fileDownloadTaskInfo.cvZ = hv.field_md5;
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            final String str = fileDownloadTaskInfo.url;
            tMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo) new C5039bj<TMAssistantDownloadTaskInfo>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.m2504i(2493);
                    TMAssistantDownloadTaskInfo biw = biw();
                    AppMethodBeat.m2505o(2493);
                    return biw;
                }

                private TMAssistantDownloadTaskInfo biw() {
                    AppMethodBeat.m2504i(2492);
                    TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
                    try {
                        tMAssistantDownloadTaskInfo = C33908a.this.getClient().getDownloadTaskState(str);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadStateSync faile: " + e.toString());
                    }
                    AppMethodBeat.m2505o(2492);
                    return tMAssistantDownloadTaskInfo;
                }
            }.mo10372b(C1720g.m3539RS().doN());
        } else {
            try {
                tMAssistantDownloadTaskInfo = getClient().getDownloadTaskState(fileDownloadTaskInfo.url);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + e.toString());
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
        if ((fileDownloadTaskInfo.status == 6 || fileDownloadTaskInfo.status == 3) && !C5730e.m8628ct(fileDownloadTaskInfo.path)) {
            fileDownloadTaskInfo.status = 0;
        }
        if (C5046bo.isNullOrNil(hv.field_filePath)) {
            hv.field_filePath = fileDownloadTaskInfo.path;
            C2895c.m5146e(hv);
        }
        C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: appId: %s, status: %d, url: %s, path: %s", hv.field_appId, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path);
        AppMethodBeat.m2505o(2504);
        return fileDownloadTaskInfo;
    }

    /* Access modifiers changed, original: final */
    public final boolean biu() {
        AppMethodBeat.m2504i(2505);
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
                C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + e.toString());
            }
            C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
            AppMethodBeat.m2505o(2505);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
        AppMethodBeat.m2505o(2505);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final TMAssistantDownloadSDKClient getClient() {
        AppMethodBeat.m2504i(2506);
        if (this.mClient == null) {
            this.mClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient("WechatDownloadClient");
            this.mClient.registerDownloadTaskListener(this.kNJ);
        }
        this.kNI.mo16770ae(240000, 240000);
        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient = this.mClient;
        AppMethodBeat.m2505o(2506);
        return tMAssistantDownloadSDKClient;
    }

    /* Access modifiers changed, original: final */
    public final void cancelNotification(String str) {
        AppMethodBeat.m2504i(2507);
        synchronized (this.eMl) {
            try {
                Integer num = (Integer) this.kNF.get(str);
                if (num == null) {
                    C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
                } else {
                    ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(num.intValue());
                    C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = ".concat(String.valueOf(num)));
                    this.kNF.remove(str);
                    AppMethodBeat.m2505o(2507);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(2507);
            }
        }
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.m2504i(2508);
        if (str == null) {
            C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
            AppMethodBeat.m2505o(2508);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.m2505o(2508);
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                AppMethodBeat.m2505o(2508);
            }
        }
        return packageInfo;
    }

    private static void biv() {
        AppMethodBeat.m2504i(2509);
        if (!new C5728b(TMAssistantFile.getSavePathRootDir() + "/.tmp/").exists()) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", Boolean.valueOf(new C5728b(TMAssistantFile.getSavePathRootDir() + "/.tmp/").mkdirs()));
        }
        AppMethodBeat.m2505o(2509);
    }

    /* renamed from: hn */
    public final boolean mo23227hn(final long j) {
        AppMethodBeat.m2504i(2510);
        final C42911a hv = C2895c.m5147hv(j);
        if (hv == null || C5046bo.isNullOrNil(hv.field_downloadUrl)) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", Long.valueOf(j));
            AppMethodBeat.m2505o(2510);
            return false;
        } else if (hv.field_downloaderType != 2) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", Long.valueOf(j));
            C5730e.deleteFile(hv.field_filePath);
            C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask, delete file: %s", hv.field_filePath);
            C2895c.m5148hw(j);
            AppMethodBeat.m2505o(2510);
            return false;
        } else {
            C7305d.xDH.mo10140a(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(2498);
                    try {
                        TMAssistantDownloadTaskInfo downloadTaskState = C33908a.this.getClient().getDownloadTaskState(hv.field_downloadUrl);
                        if (downloadTaskState.mState == 1 || downloadTaskState.mState == 2) {
                            C33908a.this.getClient().pauseDownloadTask(hv.field_downloadUrl);
                            C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", Long.valueOf(j));
                            AppMethodBeat.m2505o(2498);
                            return;
                        }
                        AppMethodBeat.m2505o(2498);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", e.toString());
                        C4990ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                        AppMethodBeat.m2505o(2498);
                    }
                }
            }, "MicroMsg.FileDownloaderImplTMAssistant");
            AppMethodBeat.m2505o(2510);
            return true;
        }
    }

    /* renamed from: ho */
    public final boolean mo23228ho(long j) {
        AppMethodBeat.m2504i(2511);
        boolean n = mo54460n(j, true);
        AppMethodBeat.m2505o(2511);
        return n;
    }

    /* renamed from: hp */
    public final boolean mo54459hp(long j) {
        AppMethodBeat.m2504i(2512);
        C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(j)));
        boolean n = mo54460n(j, false);
        AppMethodBeat.m2505o(2512);
        return n;
    }

    /* renamed from: n */
    public final boolean mo54460n(long j, boolean z) {
        AppMethodBeat.m2504i(2513);
        C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: id = ".concat(String.valueOf(j)));
        final C42911a hv = C2895c.m5147hv(j);
        if (hv == null || C5046bo.isNullOrNil(hv.field_downloadUrl)) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", Long.valueOf(j));
            AppMethodBeat.m2505o(2513);
            return false;
        } else if (hv.field_downloaderType != 2) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", Long.valueOf(j));
            C5730e.deleteFile(hv.field_filePath);
            C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, delete file: " + hv.field_filePath);
            C2895c.m5148hw(j);
            AppMethodBeat.m2505o(2513);
            return false;
        } else {
            FileDownloadTaskInfo hm = mo23226hm(hv.field_downloadId);
            if (hm.status == 1) {
                C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "download runing, return");
                AppMethodBeat.m2505o(2513);
                return true;
            } else if (hm.status == 6) {
                C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "md5 checking ,return");
                AppMethodBeat.m2505o(2513);
                return true;
            } else if (hm.status == 3) {
                C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "has download finished, install");
                if (hv.field_autoInstall) {
                    C33913a.m55499a(hm.f16167id, false, null);
                }
                AppMethodBeat.m2505o(2513);
                return true;
            } else {
                if (hv.field_status == 2) {
                    hv.field_startState = C33901b.kKd;
                } else if (hv.field_status == 4) {
                    hv.field_startState = C33901b.kKe;
                } else {
                    hv.field_startState = C33901b.kKc;
                }
                hv.field_startSize = hv.field_downloadedSize;
                hv.field_errCode = 0;
                C33908a.biv();
                if ((hv.field_reserveInWifi || hv.field_downloadInWifi) && !C5023at.isWifi(C4996ah.getContext())) {
                    C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask downloadInWifi, not wifi");
                    AppMethodBeat.m2505o(2513);
                    return true;
                }
                if (C5023at.isWifi(C4996ah.getContext())) {
                    hv.field_downloadInWifi = true;
                }
                final boolean z2 = z;
                final long j2 = j;
                C7305d.xDH.mo10140a(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(2499);
                        C38842c.m65896h(hv.field_appId, hv.field_downloadUrl, hv.field_secondaryUrl);
                        C34832a.bYL();
                        C4735m.aiN(hv.field_appId);
                        TMAssistantDownloadTaskInfo downloadTaskState = C33908a.this.getClient().getDownloadTaskState(hv.field_downloadUrl);
                        if (downloadTaskState == null || !(downloadTaskState.mState == 1 || downloadTaskState.mState == 2)) {
                            try {
                                int startDownloadTask = C33908a.this.getClient().startDownloadTask(hv.field_downloadUrl, hv.field_secondaryUrl, hv.field_fileSize, 0, "resource/tm.android.unknown", C4995ag.m7428ck(hv.field_downloadUrl), hv.field_autoDownload, C33908a.this.kNH);
                                TMAssistantDownloadTaskInfo downloadTaskState2 = C33908a.this.getClient().getDownloadTaskState(hv.field_downloadUrl);
                                switch (startDownloadTask) {
                                    case 0:
                                        hv.field_status = 1;
                                        hv.field_startTime = System.currentTimeMillis();
                                        hv.field_filePath = downloadTaskState2.mSavePath;
                                        hv.field_totalSize = downloadTaskState2.mTotalDataLen;
                                        hv.field_status = 1;
                                        C2895c.m5146e(hv);
                                        C33908a.this.kNG.add(Long.valueOf(hv.field_downloadId));
                                        C33908a.m55489a(C33908a.this, hv.field_downloadUrl, 2, 0, true);
                                        if (z2) {
                                            C33908a.this.kMT.mo7031k(hv.field_downloadId, hv.field_filePath);
                                        }
                                        C4990ab.m7417i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", Long.valueOf(j2));
                                        AppMethodBeat.m2505o(2499);
                                        return;
                                    case 1:
                                        hv.field_status = 4;
                                        hv.field_errCode = C11498a.kJX;
                                        C2895c.m5146e(hv);
                                        C33908a.this.kMT.mo7025d(hv.field_downloadId, C11498a.kJX, false);
                                        AppMethodBeat.m2505o(2499);
                                        return;
                                    case 2:
                                        hv.field_status = 4;
                                        hv.field_errCode = C11498a.kJP;
                                        C2895c.m5146e(hv);
                                        C33908a.this.kMT.mo7025d(hv.field_downloadId, C11498a.kJP, false);
                                        AppMethodBeat.m2505o(2499);
                                        return;
                                    case 3:
                                        hv.field_status = 4;
                                        hv.field_errCode = C11498a.DOWNLOAD_ERR_URL_INVALID;
                                        C2895c.m5146e(hv);
                                        C33908a.this.kMT.mo7025d(hv.field_downloadId, C11498a.DOWNLOAD_ERR_URL_INVALID, false);
                                        AppMethodBeat.m2505o(2499);
                                        return;
                                    case 4:
                                        C4990ab.m7416i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                                        C42911a c42911a = hv;
                                        C42911a c42911a2 = hv;
                                        long currentTimeMillis = System.currentTimeMillis();
                                        c42911a2.field_finishTime = currentTimeMillis;
                                        c42911a.field_startTime = currentTimeMillis;
                                        hv.field_status = 6;
                                        hv.field_filePath = downloadTaskState2.mSavePath;
                                        hv.field_startSize = downloadTaskState2.mReceiveDataLen;
                                        hv.field_downloadedSize = downloadTaskState2.mReceiveDataLen;
                                        hv.field_totalSize = downloadTaskState2.mTotalDataLen;
                                        C2895c.m5146e(hv);
                                        C33908a.this.kMT.mo7029hu(hv.field_downloadId);
                                        Intent intent = new Intent();
                                        intent.putExtra(FileDownloadService.kNn, 1);
                                        intent.setClass(C33908a.this.mContext, FileDownloadService.class);
                                        intent.putExtra(FileDownloadService.EXTRA_ID, hv.field_downloadId);
                                        try {
                                            C25985d.m41463aH(intent);
                                        } catch (Exception e) {
                                            C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", e.getMessage());
                                        }
                                        C33908a.this.kNG.remove(Long.valueOf(hv.field_downloadId));
                                        AppMethodBeat.m2505o(2499);
                                        return;
                                    case 5:
                                        hv.field_startTime = System.currentTimeMillis();
                                        hv.field_status = 1;
                                        C2895c.m5146e(hv);
                                        C33908a.this.kNG.add(Long.valueOf(hv.field_downloadId));
                                        C33908a.m55489a(C33908a.this, hv.field_downloadUrl, 2, 0, true);
                                        break;
                                }
                                AppMethodBeat.m2505o(2499);
                                return;
                            } catch (Exception e2) {
                                C4990ab.m7413e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", e2.toString());
                                C4990ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e2, "", new Object[0]);
                                hv.field_status = 4;
                                hv.field_errCode = C11498a.kJO;
                                C2895c.m5146e(hv);
                                C33908a.this.kMT.mo7025d(hv.field_downloadId, C11498a.kJO, false);
                                AppMethodBeat.m2505o(2499);
                                return;
                            }
                        }
                        C4990ab.m7420w("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, is running");
                        AppMethodBeat.m2505o(2499);
                    }
                }, "MicroMsg.FileDownloaderImplTMAssistant");
                AppMethodBeat.m2505o(2513);
                return true;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m55489a(C33908a c33908a, String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(2514);
        C42911a Iq = C2895c.m5143Iq(str);
        if (Iq == null) {
            C4990ab.m7412e("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification failed: null task info");
            AppMethodBeat.m2505o(2514);
        } else if (Iq.field_showNotification) {
            C0358c bt = C45186a.m83262bt(c33908a.mContext, "reminder_channel_id");
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                c33908a.kND.put(str, Long.valueOf(currentTimeMillis));
                bt.mo626j(currentTimeMillis);
            } else {
                Long l = (Long) c33908a.kND.get(str);
                if (l != null) {
                    bt.mo626j(l.longValue());
                } else {
                    l = Long.valueOf(System.currentTimeMillis());
                    c33908a.kND.put(str, l);
                    bt.mo626j(l.longValue());
                }
            }
            C40439f bT = C46494g.m87739bT(Iq.field_appId, false);
            if (bT == null || C5046bo.isNullOrNil(bT.field_appName)) {
                bt.mo621d(Iq.field_fileName);
            } else {
                bt.mo621d(bT.field_appName);
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    bt.mo616as(17301633);
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    bt.mo618b(100, i2, i2 == 0);
                    bt.mo623e(c33908a.mContext.getString(C25738R.string.bsp));
                    if (Iq.field_reserveInWifi) {
                        bt.mo624f(c33908a.mContext.getString(C25738R.string.bsr));
                    }
                    bt.mo627k(2, true);
                    long j = Iq.field_downloadId;
                    Intent intent = new Intent(c33908a.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    bt.f362EI = PendingIntent.getActivity(c33908a.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 4:
                case 6:
                    c33908a.cancelNotification(str);
                    AppMethodBeat.m2505o(2514);
                    return;
                case 5:
                    bt.mo616as(17301634);
                    bt.mo628z(true);
                    bt.f362EI = PendingIntent.getActivity(C4996ah.getContext(), 0, new Intent(), 0);
                    bt.mo623e(c33908a.mContext.getString(C25738R.string.bsn));
                    break;
            }
            synchronized (c33908a.eMl) {
                try {
                    Integer num = (Integer) c33908a.kNF.get(str);
                    if (num == null) {
                        c33908a.kNF.put(str, Integer.valueOf(((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41577c(bt.build())));
                    } else {
                        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().notify(num.intValue(), bt.build());
                    }
                    if (i == 4) {
                        c33908a.kNF.remove(str);
                    }
                } finally {
                    AppMethodBeat.m2505o(2514);
                }
            }
        } else {
            AppMethodBeat.m2505o(2514);
        }
    }
}
