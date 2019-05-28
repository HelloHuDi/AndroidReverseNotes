package com.tencent.p177mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.api.C37859a;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.p177mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.p177mm.plugin.cdndownloader.p357d.C2789a;
import com.tencent.p177mm.plugin.cdndownloader.p357d.C45804b;
import com.tencent.p177mm.plugin.downloader.p1250ui.FileDownloadConfirmUI;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.downloader.p939a.C33901b;
import com.tencent.p177mm.plugin.downloader.p939a.C38842c;
import com.tencent.p177mm.plugin.downloader.p943h.C11509b;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4735m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader.model.a */
public final class C33917a extends C45831h {
    public static final String kMy = (C1761b.eSn + "BigFile/");
    private byte[] eMl = new byte[0];
    private HashMap<String, Long> kMA = new HashMap();
    private ConcurrentHashMap<String, Integer> kMB = new ConcurrentHashMap();
    private HashMap<String, Long> kMC = new HashMap();
    private HashMap<String, Long> kMD = new HashMap();
    private HashMap<String, Long> kMz = new HashMap();
    private C45804b ktk = new C115101();
    private Context mContext = C4996ah.getContext();

    /* renamed from: com.tencent.mm.plugin.downloader.model.a$1 */
    class C115101 implements C45804b {
        C115101() {
        }

        /* renamed from: f */
        public final void mo23221f(String str, int i, int i2, String str2) {
            AppMethodBeat.m2504i(2354);
            C42911a Iq = C2895c.m5143Iq(str);
            if (Iq == null) {
                C7060h.pYm.mo8378a(710, 18, 1, false);
                C4990ab.m7416i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
                AppMethodBeat.m2505o(2354);
                return;
            }
            C4990ab.m7417i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
            switch (i) {
                case 1:
                    Iq.field_status = 1;
                    C2895c.m5146e(Iq);
                    AppMethodBeat.m2505o(2354);
                    return;
                case 3:
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_downloadedSize = Iq.field_totalSize;
                    Iq.field_status = 6;
                    C4990ab.m7417i("MicroMsg.FileCDNDownloader", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(Iq.field_downloadedSize), Long.valueOf(Iq.field_startSize));
                    C2895c.m5146e(Iq);
                    C33917a.this.kMT.mo7029hu(Iq.field_downloadId);
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kNn, 1);
                    intent.setClass(C33917a.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, Iq.field_downloadId);
                    try {
                        C25985d.m41463aH(intent);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.FileCDNDownloader", e.getMessage());
                    }
                    C33917a.m55505a(C33917a.this, Iq.field_downloadUrl);
                    C33917a.this.kMC.remove(Iq.field_downloadUrl);
                    C33917a.this.kMD.remove(Iq.field_downloadUrl);
                    break;
                case 4:
                    Iq.field_finishTime = System.currentTimeMillis();
                    Iq.field_errCode = Math.abs(i2);
                    Iq.field_status = 4;
                    if (C5023at.isWifi(C4996ah.getContext()) && Iq.field_downloadInWifi) {
                        Iq.field_downloadInWifi = false;
                        Iq.field_reserveInWifi = false;
                    }
                    C2895c.m5146e(Iq);
                    C33917a.this.kMT.mo7025d(Iq.field_downloadId, Math.abs(i2), false);
                    C33917a.m55506a(C33917a.this, Iq.field_downloadUrl, 4, 0, false);
                    C33917a.this.kMC.remove(Iq.field_downloadUrl);
                    C33917a.this.kMD.remove(Iq.field_downloadUrl);
                    AppMethodBeat.m2505o(2354);
                    return;
            }
            AppMethodBeat.m2505o(2354);
        }

        /* renamed from: m */
        public final void mo23222m(String str, long j, long j2) {
            AppMethodBeat.m2504i(2355);
            C4990ab.m7411d("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = %d, receiveDataLen = %d", Long.valueOf(j2), Long.valueOf(j));
            C42911a Iq = C2895c.m5143Iq(str);
            if (Iq == null) {
                C4990ab.m7416i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
                AppMethodBeat.m2505o(2355);
                return;
            }
            long a;
            if (Iq.field_downloadInWifi && !C5023at.isWifi(C4996ah.getContext())) {
                C33917a.this.mo54465hq(Iq.field_downloadId);
            }
            Long valueOf = Long.valueOf(C5046bo.m7534c((Long) C33917a.this.kMC.get(Iq.field_downloadUrl)));
            if (valueOf.longValue() == 0) {
                valueOf = Long.valueOf(j);
                C33917a.this.kMC.put(Iq.field_downloadUrl, Long.valueOf(j));
            }
            long longValue = j - valueOf.longValue();
            if (j2 == 0) {
                C4990ab.m7416i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = 0");
            } else {
                int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                if ((100 * longValue) / j2 >= 1) {
                    a = C5046bo.m7514a((Long) C33917a.this.kMD.get(Iq.field_downloadUrl), Iq.field_startTime);
                    long currentTimeMillis = System.currentTimeMillis();
                    float f = ((((float) longValue) * 1000.0f) / ((float) (currentTimeMillis - a))) / 1048576.0f;
                    C4990ab.m7411d("MicroMsg.FileCDNDownloader", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d, totalPercent = %d", Iq.field_appId, Float.valueOf(f), Long.valueOf(currentTimeMillis - a), Long.valueOf(longValue), Long.valueOf(j2), Integer.valueOf(i));
                    C11509b.m19313a(Iq.field_downloadId, f, i);
                    C33917a.this.kMD.put(Iq.field_downloadUrl, Long.valueOf(currentTimeMillis));
                    C33917a.this.kMC.put(Iq.field_downloadUrl, Long.valueOf(j));
                }
            }
            valueOf = Long.valueOf(C5046bo.m7534c((Long) C33917a.this.kMA.get(Iq.field_downloadUrl)));
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            a = valueOf2.longValue() - valueOf.longValue();
            if (valueOf == null || a <= 0 || a >= 500) {
                C33917a.this.kMA.put(Iq.field_downloadUrl, valueOf2);
                Iq.field_downloadedSize = j;
                Iq.field_totalSize = j2;
                C2895c.m5146e(Iq);
                C33917a.this.kMT.mo7028ht(Iq.field_downloadId);
                int i2 = 0;
                if (j2 > 0) {
                    i2 = (int) ((((float) j) / ((float) j2)) * 100.0f);
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 100) {
                    i2 = 100;
                }
                C33917a.m55506a(C33917a.this, Iq.field_downloadUrl, 1, i2, false);
                AppMethodBeat.m2505o(2355);
                return;
            }
            AppMethodBeat.m2505o(2355);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m55505a(C33917a c33917a, String str) {
        AppMethodBeat.m2504i(2373);
        c33917a.cancelNotification(str);
        AppMethodBeat.m2505o(2373);
    }

    static {
        AppMethodBeat.m2504i(2375);
        AppMethodBeat.m2505o(2375);
    }

    public C33917a(C2886b c2886b) {
        super(c2886b);
        AppMethodBeat.m2504i(2360);
        AppMethodBeat.m2505o(2360);
    }

    /* renamed from: a */
    public final long mo23223a(final C42911a c42911a) {
        AppMethodBeat.m2504i(2361);
        C26006a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2356);
                C38842c.m65896h(c42911a.field_appId, c42911a.field_downloadUrl, c42911a.field_secondaryUrl);
                C34832a.bYL();
                C4735m.aiN(c42911a.field_appId);
                int a = C2789a.beV().mo6902a(C33917a.m55510c(c42911a));
                C4990ab.m7417i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", Integer.valueOf(a), Long.valueOf(c42911a.field_downloadId));
                if (a == 0) {
                    c42911a.field_status = 1;
                    c42911a.field_startTime = System.currentTimeMillis();
                    C2895c.m5145d(c42911a);
                    C33917a.this.kMT.mo7030j(c42911a.field_downloadId, c42911a.field_filePath);
                    C33917a.m55506a(C33917a.this, c42911a.field_downloadUrl, 1, 0, true);
                    AppMethodBeat.m2505o(2356);
                } else if (a == -2) {
                    c42911a.field_status = 1;
                    c42911a.field_startTime = System.currentTimeMillis();
                    C2895c.m5145d(c42911a);
                    AppMethodBeat.m2505o(2356);
                } else if (a == 1) {
                    c42911a.field_status = 6;
                    C42911a c42911a = c42911a;
                    C42911a c42911a2 = c42911a;
                    C42911a c42911a3 = c42911a;
                    long asZ = C5730e.asZ(c42911a.field_filePath);
                    c42911a3.field_totalSize = asZ;
                    c42911a2.field_downloadedSize = asZ;
                    c42911a.field_startSize = asZ;
                    c42911a = c42911a;
                    c42911a2 = c42911a;
                    long currentTimeMillis = System.currentTimeMillis();
                    c42911a2.field_finishTime = currentTimeMillis;
                    c42911a.field_startTime = currentTimeMillis;
                    C2895c.m5145d(c42911a);
                    C33917a.this.kMT.mo7029hu(c42911a.field_downloadId);
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kNn, 1);
                    intent.setClass(C33917a.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, c42911a.field_downloadId);
                    try {
                        C25985d.m41463aH(intent);
                        AppMethodBeat.m2505o(2356);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.FileCDNDownloader", e.getMessage());
                        AppMethodBeat.m2505o(2356);
                    }
                } else {
                    c42911a.field_status = 4;
                    c42911a.field_errCode = C11498a.kJQ;
                    C2895c.m5145d(c42911a);
                    C33917a.this.kMT.mo7025d(c42911a.field_downloadId, c42911a.field_errCode, false);
                    AppMethodBeat.m2505o(2356);
                }
            }
        });
        long j = c42911a.field_downloadId;
        AppMethodBeat.m2505o(2361);
        return j;
    }

    /* renamed from: a */
    public final long mo23224a(C2900e c2900e) {
        AppMethodBeat.m2504i(2362);
        if (c2900e == null || C5046bo.isNullOrNil(c2900e.gUx)) {
            C4990ab.m7412e("MicroMsg.FileCDNDownloader", "Invalid Request");
            AppMethodBeat.m2505o(2362);
            return -1;
        }
        C42911a In;
        long j;
        String str = c2900e.gUx;
        C42911a Iq = C2895c.m5143Iq(str);
        if (Iq == null) {
            In = C2895c.m5140In(c2900e.mAppId);
        } else {
            In = Iq;
        }
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        if (In != null) {
            fileDownloadTaskInfo = mo23226hm(In.field_downloadId);
            if (fileDownloadTaskInfo != null) {
                C4990ab.m7416i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + fileDownloadTaskInfo.status);
                if (fileDownloadTaskInfo.status == 1 || fileDownloadTaskInfo.status == 6) {
                    j = fileDownloadTaskInfo.f16167id;
                    AppMethodBeat.m2505o(2362);
                    return j;
                } else if (fileDownloadTaskInfo.status == 3) {
                    if (In.field_autoInstall) {
                        C33913a.m55499a(fileDownloadTaskInfo.f16167id, false, null);
                    }
                    j = fileDownloadTaskInfo.f16167id;
                    AppMethodBeat.m2505o(2362);
                    return j;
                }
            }
        }
        C5728b c5728b = new C5728b(kMy);
        if (!c5728b.exists()) {
            if (!c5728b.dMC().exists()) {
                C5728b dMC = c5728b.dMC();
                C5728b c5728b2 = new C5728b(C5736j.m8649w(dMC.dMD()) + System.currentTimeMillis());
                if (c5728b2.mkdirs()) {
                    c5728b2.mo11675o(dMC);
                } else {
                    C4990ab.m7413e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", C5736j.m8649w(dMC.dMD()));
                }
            }
            C4990ab.m7417i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", Boolean.valueOf(c5728b.mkdirs()));
        }
        C2895c.m5141Io(str);
        C2895c.m5142Ip(c2900e.mAppId);
        if (In != null) {
            C2895c.m5148hw(In.field_downloadId);
        }
        C42911a c = C33922f.m55522c(c2900e);
        if (!c2900e.kNg || In == null) {
            c.field_downloadId = System.currentTimeMillis();
        } else {
            c.field_downloadId = In.field_downloadId;
        }
        c.field_downloaderType = 3;
        c.field_filePath = kMy + C4995ag.m7428ck(str);
        if (fileDownloadTaskInfo != null) {
            String str2 = c.field_filePath;
            str = fileDownloadTaskInfo.path;
            if (!(str2 == null || str == null || str2.equals(str))) {
                C4990ab.m7417i("MicroMsg.FileCDNDownloader", "removeLastFile, new File = %s, oldFile = %s", str2, str);
                if (new C5728b(str).exists()) {
                    C4990ab.m7417i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", Boolean.valueOf(new C5728b(str).delete()));
                }
            }
            if (fileDownloadTaskInfo.status == 2) {
                c.field_startState = C33901b.kKd;
            } else if (fileDownloadTaskInfo.status == 4) {
                c.field_startState = C33901b.kKe;
            } else {
                c.field_startState = C33901b.kKc;
            }
            c.field_startSize = fileDownloadTaskInfo.kNr;
            C4990ab.m7416i("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + fileDownloadTaskInfo.kNr);
        } else {
            c.field_startState = C33901b.kKc;
        }
        if (!c2900e.hyG || C5023at.isWifi(C4996ah.getContext())) {
            if (C5023at.isWifi(C4996ah.getContext())) {
                c.field_downloadInWifi = true;
            }
            j = mo23223a(c);
            AppMethodBeat.m2505o(2362);
            return j;
        }
        C4990ab.m7416i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        c.field_status = 0;
        c.field_downloadInWifi = true;
        C2895c.m5145d(c);
        j = c.field_downloadId;
        AppMethodBeat.m2505o(2362);
        return j;
    }

    /* renamed from: b */
    private static CDNTaskInfo m55507b(C42911a c42911a) {
        AppMethodBeat.m2504i(2363);
        CDNTaskInfo cDNTaskInfo = new CDNTaskInfo();
        cDNTaskInfo.egs = true;
        cDNTaskInfo.cHr = c42911a.field_downloadUrl;
        cDNTaskInfo.downloadUrl = c42911a.field_downloadUrl;
        cDNTaskInfo.filePath = c42911a.field_filePath;
        cDNTaskInfo.ktq = c42911a.field_secondaryUrl;
        cDNTaskInfo.kts = 15;
        cDNTaskInfo.ktt = 3600;
        cDNTaskInfo.ktu = true;
        cDNTaskInfo.ktv = c42911a.field_downloadInWifi;
        JSONObject jSONObject = new JSONObject();
        try {
            if (c42911a.field_fileSize > 0) {
                jSONObject.put("Content-Length", c42911a.field_fileSize);
            }
            cDNTaskInfo.ktr = jSONObject.toString();
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + e.getMessage());
        }
        AppMethodBeat.m2505o(2363);
        return cDNTaskInfo;
    }

    /* renamed from: hl */
    public final int mo23225hl(final long j) {
        AppMethodBeat.m2504i(2364);
        C26006a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2357);
                FileDownloadTaskInfo hm = C33917a.this.mo23226hm(j);
                if (hm == null) {
                    AppMethodBeat.m2505o(2357);
                    return;
                }
                C2789a.beV().mo6899HB(hm.url);
                C33917a.m55505a(C33917a.this, hm.url);
                C5730e.deleteFile(hm.path);
                C4990ab.m7417i("MicroMsg.FileCDNDownloader", "removeDownloadTask, delete file, path: %s", hm.path);
                if (hm.status != 5) {
                    C42911a hv = C2895c.m5147hv(j);
                    if (hv == null) {
                        AppMethodBeat.m2505o(2357);
                        return;
                    }
                    hv.field_finishTime = System.currentTimeMillis();
                    hv.field_downloadedSize = hm.kNr;
                    hv.field_status = 5;
                    C2895c.m5146e(hv);
                    Long valueOf = Long.valueOf(C5046bo.m7514a((Long) C33917a.this.kMD.get(hm.url), hv.field_startTime));
                    if (valueOf != null) {
                        C11509b.m19313a(j, ((((float) (hm.kNr - Long.valueOf(C5046bo.m7514a((Long) C33917a.this.kMC.get(hm.url), hv.field_startSize)).longValue())) * 1000.0f) / ((float) (System.currentTimeMillis() - valueOf.longValue()))) / 1048576.0f, (int) ((((float) hm.kNr) / ((float) hm.jrb)) * 100.0f));
                    }
                    C33917a.this.kMC.remove(hm.url);
                    C33917a.this.kMD.remove(hm.url);
                    C33917a.this.kMT.mo7026hr(j);
                }
                AppMethodBeat.m2505o(2357);
            }
        });
        AppMethodBeat.m2505o(2364);
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
    /* renamed from: hm */
    public final FileDownloadTaskInfo mo23226hm(long j) {
        AppMethodBeat.m2504i(2365);
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            CDNTaskState HC;
            FileDownloadTaskInfo fileDownloadTaskInfo2 = new FileDownloadTaskInfo();
            if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                HC = C2789a.beV().mo6900HC(hv.field_downloadUrl);
            } else {
                HC = C2789a.beV().mo6901HE(hv.field_downloadUrl);
            }
            if (HC != null) {
                C4990ab.m7417i("MicroMsg.FileCDNDownloader", "queryDownloadTask, cdntaskstate: %d", Integer.valueOf(HC.taskState));
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
                        if (C5730e.m8628ct(hv.field_filePath)) {
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
            if (C1173e.m2561ct(hv.field_filePath)) {
                fileDownloadTaskInfo2.kNr = hv.field_downloadedSize;
                fileDownloadTaskInfo2.jrb = hv.field_totalSize;
            } else {
                fileDownloadTaskInfo2.kNr = 0;
                fileDownloadTaskInfo2.jrb = 0;
            }
            if ((fileDownloadTaskInfo2.status == 6 || fileDownloadTaskInfo2.status == 3) && !C5730e.m8628ct(hv.field_filePath)) {
                fileDownloadTaskInfo2.status = 0;
            }
            fileDownloadTaskInfo2.f16167id = j;
            fileDownloadTaskInfo2.cBA = hv.field_downloaderType;
            fileDownloadTaskInfo2.kNs = hv.field_autoDownload;
            fileDownloadTaskInfo2.path = hv.field_filePath;
            fileDownloadTaskInfo2.url = hv.field_downloadUrl;
            fileDownloadTaskInfo2.cvZ = hv.field_md5;
            if (hv.field_status != fileDownloadTaskInfo2.status && (fileDownloadTaskInfo2.status == 1 || hv.field_status == 1)) {
                hv.field_status = fileDownloadTaskInfo2.status;
                C2895c.m5146e(hv);
            }
            C4990ab.m7417i("MicroMsg.FileCDNDownloader", "queryDownloadTask, url: %s, status = %d, downloadedSize = %d, totalSize = %d", fileDownloadTaskInfo2.url, Integer.valueOf(fileDownloadTaskInfo2.status), Long.valueOf(fileDownloadTaskInfo2.kNr), Long.valueOf(fileDownloadTaskInfo2.jrb));
            fileDownloadTaskInfo = fileDownloadTaskInfo2;
        }
        AppMethodBeat.m2505o(2365);
        return fileDownloadTaskInfo;
    }

    /* renamed from: hn */
    public final boolean mo23227hn(final long j) {
        AppMethodBeat.m2504i(2366);
        C26006a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2358);
                C4990ab.m7416i("MicroMsg.FileCDNDownloader", JsApiPauseDownloadTask.NAME);
                FileDownloadTaskInfo hm = C33917a.this.mo23226hm(j);
                if (hm != null && hm.status == 1) {
                    C2789a.beV().mo6898HA(hm.url);
                    C33917a.m55505a(C33917a.this, hm.url);
                    C42911a hv = C2895c.m5147hv(j);
                    if (hv != null) {
                        hv.field_finishTime = System.currentTimeMillis();
                        hv.field_status = 2;
                        hv.field_downloadedSize = hm.kNr;
                        C2895c.m5146e(hv);
                        Long valueOf = Long.valueOf(C5046bo.m7514a((Long) C33917a.this.kMD.get(hm.url), hv.field_startTime));
                        if (valueOf != null) {
                            C11509b.m19313a(hv.field_downloadId, ((((float) (hv.field_downloadedSize - Long.valueOf(C5046bo.m7514a((Long) C33917a.this.kMC.get(hm.url), hv.field_startSize)).longValue())) * 1000.0f) / ((float) (System.currentTimeMillis() - valueOf.longValue()))) / 1048576.0f, (int) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f));
                        }
                    }
                    C33917a.this.kMC.remove(hm.url);
                    C33917a.this.kMD.remove(hm.url);
                    C33917a.this.kMT.mo7027hs(j);
                }
                AppMethodBeat.m2505o(2358);
            }
        });
        AppMethodBeat.m2505o(2366);
        return true;
    }

    /* renamed from: ho */
    public final boolean mo23228ho(long j) {
        AppMethodBeat.m2504i(2367);
        boolean n = mo54466n(j, true);
        AppMethodBeat.m2505o(2367);
        return n;
    }

    /* renamed from: n */
    public final boolean mo54466n(long j, boolean z) {
        AppMethodBeat.m2504i(2368);
        final C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            FileDownloadTaskInfo hm = mo23226hm(hv.field_downloadId);
            if (hm == null) {
                AppMethodBeat.m2505o(2368);
                return false;
            } else if (hm.status == 1 || hm.status == 6) {
                AppMethodBeat.m2505o(2368);
                return true;
            } else if (hm.status == 3) {
                if (hv.field_autoInstall) {
                    C33913a.m55499a(hm.f16167id, false, null);
                }
                AppMethodBeat.m2505o(2368);
                return true;
            } else if ((hv.field_reserveInWifi || hv.field_downloadInWifi) && !C5023at.isWifi(C4996ah.getContext())) {
                C4990ab.m7416i("MicroMsg.FileCDNDownloader", "resumeDownloadTask, downloadInWifi, not wifi");
                AppMethodBeat.m2505o(2368);
                return true;
            } else {
                if (C5023at.isWifi(C4996ah.getContext())) {
                    hv.field_downloadInWifi = true;
                }
                final boolean z2 = z;
                final long j2 = j;
                C26006a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(2359);
                        C38842c.m65896h(hv.field_appId, hv.field_downloadUrl, hv.field_secondaryUrl);
                        C34832a.bYL();
                        C4735m.aiN(hv.field_appId);
                        int b = C2789a.beV().mo6903b(C33917a.m55510c(hv));
                        C4990ab.m7416i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: ".concat(String.valueOf(b)));
                        hv.field_startTime = System.currentTimeMillis();
                        hv.field_startSize = hv.field_downloadedSize;
                        hv.field_startState = C33901b.kKd;
                        if (b == 0) {
                            hv.field_status = 1;
                            hv.field_errCode = 0;
                            C2895c.m5146e(hv);
                            if (z2) {
                                C33917a.this.kMT.mo7031k(j2, hv.field_filePath);
                            }
                            long j = 0;
                            if (hv.field_totalSize != 0) {
                                j = (hv.field_downloadedSize * 100) / hv.field_totalSize;
                            }
                            C4990ab.m7411d("MicroMsg.FileCDNDownloader", "resumeDownloadTask, progress = %d, downloadedSize = %d, totalSize = %d", Long.valueOf(j), Long.valueOf(hv.field_downloadedSize), Long.valueOf(hv.field_totalSize));
                            C33917a.m55506a(C33917a.this, hv.field_downloadUrl, 1, (int) j, true);
                            AppMethodBeat.m2505o(2359);
                        } else if (b == -2) {
                            hv.field_status = 1;
                            hv.field_errCode = 0;
                            C2895c.m5146e(hv);
                            AppMethodBeat.m2505o(2359);
                        } else if (b != 1) {
                            hv.field_status = 4;
                            hv.field_errCode = C11498a.kJR;
                            C2895c.m5146e(hv);
                            C33917a.this.kMT.mo7025d(j2, hv.field_errCode, false);
                            AppMethodBeat.m2505o(2359);
                        } else if (hv.field_status == 6 || hv.field_status == 3) {
                            AppMethodBeat.m2505o(2359);
                        } else {
                            hv.field_status = 6;
                            C42911a c42911a = hv;
                            C42911a c42911a2 = hv;
                            long j2 = hv.field_totalSize;
                            c42911a2.field_downloadedSize = j2;
                            c42911a.field_startSize = j2;
                            c42911a = hv;
                            c42911a2 = hv;
                            j2 = System.currentTimeMillis();
                            c42911a2.field_finishTime = j2;
                            c42911a.field_startTime = j2;
                            C2895c.m5146e(hv);
                            C33917a.this.kMT.mo7029hu(hv.field_downloadId);
                            Intent intent = new Intent();
                            intent.putExtra(FileDownloadService.kNn, 1);
                            intent.setClass(C33917a.this.mContext, FileDownloadService.class);
                            intent.putExtra(FileDownloadService.EXTRA_ID, hv.field_downloadId);
                            try {
                                C25985d.m41463aH(intent);
                                AppMethodBeat.m2505o(2359);
                            } catch (Exception e) {
                                C4990ab.m7412e("MicroMsg.FileCDNDownloader", e.getMessage());
                                AppMethodBeat.m2505o(2359);
                            }
                        }
                    }
                });
                AppMethodBeat.m2505o(2368);
                return true;
            }
        }
        AppMethodBeat.m2505o(2368);
        return false;
    }

    /* renamed from: hp */
    public final boolean mo54464hp(long j) {
        AppMethodBeat.m2504i(2369);
        C4990ab.m7416i("MicroMsg.FileCDNDownloader", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(j)));
        boolean n = mo54466n(j, false);
        AppMethodBeat.m2505o(2369);
        return n;
    }

    private void cancelNotification(String str) {
        AppMethodBeat.m2504i(2370);
        synchronized (this.eMl) {
            try {
                Integer num = (Integer) this.kMB.get(str);
                if (num == null) {
                    C4990ab.m7416i("MicroMsg.FileCDNDownloader", "No notification id found");
                } else {
                    ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(num.intValue());
                    C4990ab.m7416i("MicroMsg.FileCDNDownloader", "cancelNotification, id = ".concat(String.valueOf(num)));
                    this.kMB.remove(str);
                    AppMethodBeat.m2505o(2370);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(2370);
            }
        }
    }

    /* renamed from: hq */
    public final boolean mo54465hq(long j) {
        AppMethodBeat.m2504i(2371);
        C45405b.eBF.mo60567a(j, new C37859a(13));
        boolean hn = mo23227hn(j);
        AppMethodBeat.m2505o(2371);
        return hn;
    }

    /* renamed from: a */
    static /* synthetic */ void m55506a(C33917a c33917a, String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(2372);
        C4990ab.m7411d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        C42911a Iq = C2895c.m5143Iq(str);
        if (Iq == null) {
            C4990ab.m7412e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
            AppMethodBeat.m2505o(2372);
        } else if (Iq.field_showNotification) {
            C0358c bt = C45186a.m83262bt(c33917a.mContext, "reminder_channel_id");
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                c33917a.kMz.put(str, Long.valueOf(currentTimeMillis));
                bt.mo626j(currentTimeMillis);
            } else {
                Long l = (Long) c33917a.kMz.get(str);
                if (l != null) {
                    bt.mo626j(l.longValue());
                } else {
                    l = Long.valueOf(System.currentTimeMillis());
                    c33917a.kMz.put(str, l);
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
                    bt.mo616as(17301633);
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    bt.mo618b(100, i2, i2 == 0);
                    if (Iq.field_reserveInWifi) {
                        bt.mo623e(c33917a.mContext.getString(C25738R.string.bsr) + "·" + c33917a.mContext.getString(C25738R.string.bsp));
                    } else {
                        bt.mo623e(c33917a.mContext.getString(C25738R.string.bsp));
                    }
                    bt.mo627k(2, true);
                    Intent intent = new Intent(c33917a.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", Iq.field_downloadId);
                    bt.f362EI = PendingIntent.getActivity(c33917a.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 4:
                    bt.mo616as(17301634);
                    bt.mo628z(true);
                    bt.f362EI = PendingIntent.getActivity(C4996ah.getContext(), 0, new Intent(), 0);
                    bt.mo623e(c33917a.mContext.getString(C25738R.string.bsn));
                    break;
                default:
                    c33917a.cancelNotification(str);
                    AppMethodBeat.m2505o(2372);
                    return;
            }
            synchronized (c33917a.eMl) {
                try {
                    Integer num = (Integer) c33917a.kMB.get(str);
                    if (num == null) {
                        c33917a.kMB.put(str, Integer.valueOf(((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41577c(bt.build())));
                    } else {
                        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().notify(num.intValue(), bt.build());
                    }
                    if (i == 4) {
                        c33917a.kMB.remove(str);
                    }
                } finally {
                    AppMethodBeat.m2505o(2372);
                }
            }
        } else {
            AppMethodBeat.m2505o(2372);
        }
    }
}
