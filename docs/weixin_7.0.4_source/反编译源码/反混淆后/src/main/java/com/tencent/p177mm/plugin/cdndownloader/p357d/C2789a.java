package com.tencent.p177mm.plugin.cdndownloader.p357d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.ipcinvoker.wx_extension.p856b.C32719a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.p177mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.p177mm.plugin.cdndownloader.p1478e.C33808a;
import com.tencent.p177mm.plugin.cdndownloader.p1478e.C33809b;
import com.tencent.p177mm.plugin.cdndownloader.p933a.C42873a;
import com.tencent.p177mm.plugin.cdndownloader.p933a.C42873a.C42874a;
import com.tencent.p177mm.plugin.cdndownloader.p933a.C45803b;
import com.tencent.p177mm.plugin.cdndownloader.p933a.C45803b.C42875a;
import com.tencent.p177mm.plugin.cdndownloader.p935f.C11368c;
import com.tencent.p177mm.plugin.cdndownloader.p935f.C38783a;
import com.tencent.p177mm.plugin.cdndownloader.p935f.C45805b;
import com.tencent.p177mm.plugin.cdndownloader.service.CDNDownloadService;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.cdndownloader.d.a */
public final class C2789a implements C32719a {
    private static C2789a kte;
    private static final Object kth = new Object();
    private long ktf = 0;
    private long ktg = 0;
    C42873a kti;
    private Set<CDNTaskInfo> ktj = new C33808a(new C27911());
    public C45804b ktk;
    private ServiceConnection ktl = new C27902();
    private C7564ap ktm = new C7564ap(C26006a.dvQ().getLooper(), new C27923(), true);
    private C45803b ktn = new C27944();
    private C1924a kto = new C27955();
    private Context mContext = C4996ah.getContext();

    /* renamed from: com.tencent.mm.plugin.cdndownloader.d.a$2 */
    class C27902 implements ServiceConnection {
        C27902() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(892);
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "onServiceConnected");
            C2789a.this.kti = C42874a.m76126s(iBinder);
            C2789a.m5042f(C2789a.this);
            C2789a.m5043g(C2789a.this);
            try {
                synchronized (C2789a.kth) {
                    C2789a.kth.notifyAll();
                }
                AppMethodBeat.m2505o(892);
            } catch (Exception e) {
                AppMethodBeat.m2505o(892);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(892);
                }
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(893);
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
            if (C2789a.this.ktj.size() != 0) {
                for (CDNTaskInfo cDNTaskInfo : C2789a.this.ktj) {
                    cDNTaskInfo.ktw = true;
                }
            }
            AppMethodBeat.m2505o(893);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cdndownloader.d.a$1 */
    class C27911 implements C33809b {
        C27911() {
        }

        public final void beX() {
            AppMethodBeat.m2504i(889);
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "notify add");
            C2789a.m5033a(C2789a.this);
            C2789a.m5035b(C2789a.this);
            AppMethodBeat.m2505o(889);
        }

        public final void remove() {
            AppMethodBeat.m2504i(890);
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "notify remove");
            if (C2789a.this.ktj.size() == 0) {
                C2789a.m5038d(C2789a.this);
                C2789a.m5041e(C2789a.this);
            }
            AppMethodBeat.m2505o(890);
        }

        public final void clear() {
            AppMethodBeat.m2504i(891);
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "notify clear");
            C2789a.m5038d(C2789a.this);
            C2789a.m5041e(C2789a.this);
            AppMethodBeat.m2505o(891);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cdndownloader.d.a$3 */
    class C27923 implements C5015a {
        C27923() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(894);
            C4990ab.m7410d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
            if (C2789a.this.ktj.size() == 0) {
                AppMethodBeat.m2505o(894);
                return false;
            }
            if (C2789a.this.kti != null) {
                try {
                    C4990ab.m7410d("MicroMsg.CDNDownloadClient", "checkActive");
                    C2789a.this.kti.beT();
                } catch (RemoteException e) {
                    C4990ab.m7412e("MicroMsg.CDNDownloadClient", "check process active false");
                    C7060h.pYm.mo8378a(710, 3, 1, false);
                    if (C2789a.m5045i(C2789a.this)) {
                        C2789a.this.ktg = System.currentTimeMillis();
                        for (CDNTaskInfo cDNTaskInfo : C2789a.this.ktj) {
                            cDNTaskInfo.ktw = true;
                        }
                        C2789a.m5046j(C2789a.this);
                        AppMethodBeat.m2505o(894);
                        return true;
                    }
                    C4990ab.m7416i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
                    C7060h.pYm.mo8378a(710, 4, 1, false);
                    for (CDNTaskInfo cDNTaskInfo2 : C2789a.this.ktj) {
                        C2789a.this.ktk.mo23221f(cDNTaskInfo2.downloadUrl, 4, C11498a.kJS, null);
                    }
                    C2789a.m5048l(C2789a.this);
                    AppMethodBeat.m2505o(894);
                    return false;
                }
            }
            AppMethodBeat.m2505o(894);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.cdndownloader.d.a$6 */
    class C27936 implements Runnable {
        C27936() {
        }

        public final void run() {
            AppMethodBeat.m2504i(898);
            synchronized (C2789a.kth) {
                try {
                    C4990ab.m7416i("MicroMsg.CDNDownloadClient", "queryDownloadTaskSync, notify after 10000ms");
                    C2789a.kth.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(898);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.cdndownloader.d.a$4 */
    class C27944 extends C42875a {
        C27944() {
        }

        /* renamed from: e */
        public final void mo6910e(String str, int i, int i2, String str2) {
            AppMethodBeat.m2504i(895);
            C4990ab.m7417i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
            if (i != 1) {
                C2789a.m5034a(C2789a.this, new CDNTaskInfo(str));
            }
            if (C2789a.this.ktk != null) {
                C2789a.this.ktk.mo23221f(str, i, i2, str2);
            }
            AppMethodBeat.m2505o(895);
        }

        /* renamed from: l */
        public final void mo6911l(String str, long j, long j2) {
            AppMethodBeat.m2504i(896);
            C4990ab.m7411d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", str, Long.valueOf(j), Long.valueOf(j2));
            if (C2789a.this.ktk != null) {
                C2789a.this.ktk.mo23222m(str, j, j2);
            }
            AppMethodBeat.m2505o(896);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cdndownloader.d.a$5 */
    class C27955 extends C1924a {
        C27955() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(897);
            C2789a c2789a = C2789a.this;
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: ".concat(String.valueOf(i)));
            if (c2789a.kti != null) {
                try {
                    c2789a.kti.mo23090tr(i);
                    AppMethodBeat.m2505o(897);
                    return;
                } catch (RemoteException e) {
                }
            }
            AppMethodBeat.m2505o(897);
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m5046j(C2789a c2789a) {
        AppMethodBeat.m2504i(919);
        c2789a.beW();
        AppMethodBeat.m2505o(919);
    }

    public static synchronized C2789a beV() {
        C2789a c2789a;
        synchronized (C2789a.class) {
            AppMethodBeat.m2504i(899);
            if (kte == null) {
                kte = new C2789a();
            }
            c2789a = kte;
            AppMethodBeat.m2505o(899);
        }
        return c2789a;
    }

    static {
        AppMethodBeat.m2504i(922);
        AppMethodBeat.m2505o(922);
    }

    public C2789a() {
        AppMethodBeat.m2504i(TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
        C1720g.m3537RQ();
        C1720g.m3535RO().mo5187a(this.kto);
        beW();
        AppMethodBeat.m2505o(TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
    }

    private synchronized void beW() {
        AppMethodBeat.m2504i(901);
        try {
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "bindService: ".concat(String.valueOf(this.mContext.bindService(new Intent(this.mContext, CDNDownloadService.class), this.ktl, 1))));
            AppMethodBeat.m2505o(901);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.CDNDownloadClient", "bindService: " + e.getMessage());
            AppMethodBeat.m2505o(901);
        }
        return;
    }

    /* renamed from: a */
    public final synchronized int mo6902a(CDNTaskInfo cDNTaskInfo) {
        int i = -2;
        synchronized (this) {
            AppMethodBeat.m2504i(902);
            if (cDNTaskInfo == null || C5046bo.isNullOrNil(cDNTaskInfo.downloadUrl)) {
                C4990ab.m7420w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
                i = -1;
                AppMethodBeat.m2505o(902);
            } else {
                C4990ab.m7417i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", cDNTaskInfo.filePath, cDNTaskInfo.downloadUrl);
                if (this.ktj.contains(cDNTaskInfo)) {
                    C4990ab.m7416i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
                    AppMethodBeat.m2505o(902);
                } else {
                    CDNTaskState HC = mo6900HC(cDNTaskInfo.downloadUrl);
                    if (HC != null && HC.taskState == 104 && C1173e.m2561ct(cDNTaskInfo.filePath)) {
                        C4990ab.m7416i("MicroMsg.CDNDownloadClient", "addDownloadTask, has download success");
                        AppMethodBeat.m2505o(902);
                        i = 1;
                    } else {
                        if (this.kti != null) {
                            try {
                                int a = this.kti.mo23082a(cDNTaskInfo);
                                this.ktn.mo6910e(cDNTaskInfo.cHr, 1, 0, "");
                                if (a == 0 || a == -2) {
                                    m5037c(cDNTaskInfo);
                                }
                                AppMethodBeat.m2505o(902);
                                i = a;
                            } catch (RemoteException e) {
                                C4990ab.m7412e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + e.getMessage());
                            }
                        }
                        m5037c(cDNTaskInfo);
                        beW();
                        AppMethodBeat.m2505o(902);
                        i = 0;
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: HA */
    public final synchronized boolean mo6898HA(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(C1625i.SCENE_BIZ_SCROLL);
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: ".concat(String.valueOf(str)));
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
                AppMethodBeat.m2505o(C1625i.SCENE_BIZ_SCROLL);
            } else {
                m5039d(new CDNTaskInfo(str));
                if (this.kti != null) {
                    try {
                        z = this.kti.mo23079HA(str);
                        AppMethodBeat.m2505o(C1625i.SCENE_BIZ_SCROLL);
                    } catch (RemoteException e) {
                        C4990ab.m7412e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + e.getMessage());
                    }
                }
                C4990ab.m7416i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
                AppMethodBeat.m2505o(C1625i.SCENE_BIZ_SCROLL);
            }
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized int mo6903b(CDNTaskInfo cDNTaskInfo) {
        int i = -2;
        synchronized (this) {
            AppMethodBeat.m2504i(904);
            if (cDNTaskInfo == null || C5046bo.isNullOrNil(cDNTaskInfo.downloadUrl)) {
                C4990ab.m7420w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
                i = -1;
                AppMethodBeat.m2505o(904);
            } else {
                C4990ab.m7416i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + cDNTaskInfo.downloadUrl);
                if (this.ktj.contains(cDNTaskInfo)) {
                    C4990ab.m7416i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, already in running");
                    AppMethodBeat.m2505o(904);
                } else {
                    CDNTaskState HC = mo6900HC(cDNTaskInfo.downloadUrl);
                    if (HC != null && HC.taskState == 104 && C1173e.m2561ct(cDNTaskInfo.filePath)) {
                        C4990ab.m7416i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, has download success");
                        AppMethodBeat.m2505o(904);
                        i = 1;
                    } else {
                        cDNTaskInfo.ktw = true;
                        if (this.kti != null) {
                            try {
                                int b = this.kti.mo23085b(cDNTaskInfo);
                                this.ktn.mo6910e(cDNTaskInfo.cHr, 1, 0, "");
                                if (b == 0 || b == -2) {
                                    m5037c(cDNTaskInfo);
                                }
                                AppMethodBeat.m2505o(904);
                                i = b;
                            } catch (RemoteException e) {
                                C4990ab.m7412e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + e.getMessage());
                            }
                        }
                        m5037c(cDNTaskInfo);
                        beW();
                        AppMethodBeat.m2505o(904);
                        i = 0;
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: HB */
    public final synchronized boolean mo6899HB(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(905);
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "removeDownloadTask: ".concat(String.valueOf(str)));
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
                AppMethodBeat.m2505o(905);
            } else {
                m5039d(new CDNTaskInfo(str));
                if (this.kti != null) {
                    try {
                        z = this.kti.mo23080HB(str);
                        AppMethodBeat.m2505o(905);
                    } catch (RemoteException e) {
                        C4990ab.m7412e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + e.getMessage());
                    }
                }
                C4990ab.m7416i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
                AppMethodBeat.m2505o(905);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db A:{Catch:{ RemoteException -> 0x009a }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0112 A:{Catch:{ RemoteException -> 0x009a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: HC */
    public final synchronized CDNTaskState mo6900HC(String str) {
        CDNTaskState cDNTaskState = null;
        synchronized (this) {
            AppMethodBeat.m2504i(906);
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "queryDownloadTask: ".concat(String.valueOf(str)));
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
                AppMethodBeat.m2505o(906);
            } else {
                if (this.kti != null) {
                    C4990ab.m7410d("MicroMsg.CDNDownloadClient", "queryDownloadTask service has connected");
                    try {
                        CDNTaskState HC = this.kti.mo23081HC(str);
                        if (HC.taskState == 100 || HC.taskState == 101) {
                            if (!this.ktj.contains(new CDNTaskInfo(str))) {
                                C38783a c38783a;
                                Object cDNTaskInfo;
                                C11368c beQ = C45805b.beQ();
                                if (beQ != null) {
                                    Cursor rawQuery = beQ.rawQuery(String.format("select * from %s where %s=%s", new Object[]{"CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(str.hashCode())}), new String[0]);
                                    if (rawQuery != null) {
                                        C38783a c38783a2 = null;
                                        while (rawQuery.moveToNext()) {
                                            c38783a2 = new C38783a();
                                            c38783a2.mo8995d(rawQuery);
                                        }
                                        rawQuery.close();
                                        c38783a = c38783a2;
                                        if (c38783a == null) {
                                            cDNTaskInfo = new CDNTaskInfo(str);
                                            cDNTaskInfo.ktq = c38783a.field_httpsUrl;
                                            cDNTaskInfo.cHr = c38783a.field_mediaId;
                                            cDNTaskInfo.filePath = c38783a.field_filePath;
                                            cDNTaskInfo.ktr = c38783a.field_verifyHeaders;
                                            cDNTaskInfo.ktu = c38783a.field_allowMobileNetDownload.booleanValue();
                                            cDNTaskInfo.ktv = c38783a.field_wifiAutoDownload.booleanValue();
                                            cDNTaskInfo.egs = c38783a.field_game_package_download.booleanValue();
                                            cDNTaskInfo.kts = 15;
                                            cDNTaskInfo.ktt = 3600;
                                        } else {
                                            cDNTaskInfo = null;
                                        }
                                        if (cDNTaskInfo != null) {
                                            this.ktj.add(cDNTaskInfo);
                                        }
                                    }
                                }
                                c38783a = null;
                                if (c38783a == null) {
                                }
                                if (cDNTaskInfo != null) {
                                }
                            }
                        } else if (this.ktj.contains(new CDNTaskInfo(str))) {
                            HC.taskState = 101;
                        }
                        AppMethodBeat.m2505o(906);
                        cDNTaskState = HC;
                    } catch (RemoteException e) {
                        C4990ab.m7412e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + e.getMessage());
                    }
                }
                if (this.ktj.contains(new CDNTaskInfo(str))) {
                    cDNTaskState = new CDNTaskState();
                    cDNTaskState.taskState = 101;
                    AppMethodBeat.m2505o(906);
                } else {
                    AppMethodBeat.m2505o(906);
                }
            }
        }
        return cDNTaskState;
    }

    /* renamed from: HE */
    public final synchronized CDNTaskState mo6901HE(String str) {
        CDNTaskState HC;
        try {
            AppMethodBeat.m2504i(907);
            if (this.kti != null) {
                HC = mo6900HC(str);
                AppMethodBeat.m2505o(907);
            } else if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                HC = null;
                AppMethodBeat.m2505o(907);
            } else {
                beW();
                try {
                    synchronized (kth) {
                        if (this.kti == null) {
                            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "queryDownloadTaskSync, wait for bindService, now: " + System.currentTimeMillis());
                            C26006a.m41507r(new C27936(), 10000);
                            kth.wait();
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7417i("MicroMsg.CDNDownloadClient", "queryDownloadTaskSync，now: %d, exp: %s", Long.valueOf(System.currentTimeMillis()), e.getMessage());
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(907);
                        throw th;
                    }
                }
                HC = mo6900HC(str);
                AppMethodBeat.m2505o(907);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return HC;
    }

    private void beR() {
        AppMethodBeat.m2504i(908);
        if (this.kti != null) {
            try {
                this.kti.beR();
                AppMethodBeat.m2505o(908);
                return;
            } catch (RemoteException e) {
                C4990ab.m7412e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: ".concat(String.valueOf(e)));
            }
        }
        AppMethodBeat.m2505o(908);
    }

    /* renamed from: c */
    private void m5037c(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.m2504i(909);
        this.ktj.add(cDNTaskInfo);
        C45805b.m84722a(C2789a.m5040e(cDNTaskInfo));
        AppMethodBeat.m2505o(909);
    }

    /* renamed from: d */
    private void m5039d(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.m2504i(910);
        this.ktj.remove(cDNTaskInfo);
        C45805b.m84721HF(cDNTaskInfo.downloadUrl);
        AppMethodBeat.m2505o(910);
    }

    /* renamed from: e */
    private static C38783a m5040e(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.m2504i(911);
        C38783a c38783a = new C38783a();
        c38783a.field_mediaId = cDNTaskInfo.cHr;
        c38783a.field_downloadUrlHashCode = cDNTaskInfo.downloadUrl.hashCode();
        c38783a.field_downloadUrl = cDNTaskInfo.downloadUrl;
        c38783a.field_httpsUrl = cDNTaskInfo.ktq;
        c38783a.field_filePath = cDNTaskInfo.filePath;
        c38783a.field_verifyHeaders = cDNTaskInfo.ktr;
        c38783a.field_allowMobileNetDownload = Boolean.valueOf(cDNTaskInfo.ktu);
        c38783a.field_wifiAutoDownload = Boolean.valueOf(cDNTaskInfo.ktv);
        c38783a.field_game_package_download = Boolean.valueOf(cDNTaskInfo.egs);
        AppMethodBeat.m2505o(911);
        return c38783a;
    }

    /* renamed from: f */
    static /* synthetic */ void m5042f(C2789a c2789a) {
        AppMethodBeat.m2504i(916);
        try {
            C4990ab.m7416i("MicroMsg.CDNDownloadClient", "registerCallback");
            c2789a.kti.mo23083a(c2789a.ktn);
            AppMethodBeat.m2505o(916);
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.CDNDownloadClient", "registerCallback: " + e.getMessage());
            AppMethodBeat.m2505o(916);
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m5043g(C2789a c2789a) {
        AppMethodBeat.m2504i(917);
        C4990ab.m7416i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected");
        if (c2789a.ktj.size() > 0) {
            c2789a.beR();
        }
        for (CDNTaskInfo cDNTaskInfo : c2789a.ktj) {
            C4990ab.m7417i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected, url: %s, resume: %b", cDNTaskInfo.downloadUrl, Boolean.valueOf(cDNTaskInfo.ktw));
            try {
                if (cDNTaskInfo.ktw) {
                    c2789a.kti.mo23085b(cDNTaskInfo);
                } else {
                    c2789a.kti.mo23082a(cDNTaskInfo);
                }
                c2789a.ktn.mo6910e(cDNTaskInfo.cHr, 1, 0, "");
            } catch (RemoteException e) {
                C4990ab.m7412e("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected: ".concat(String.valueOf(e)));
                C7060h.pYm.mo8378a(710, 0, 1, false);
            }
        }
        AppMethodBeat.m2505o(917);
    }

    /* renamed from: i */
    static /* synthetic */ boolean m5045i(C2789a c2789a) {
        AppMethodBeat.m2504i(918);
        if (System.currentTimeMillis() - c2789a.ktg > 120000) {
            AppMethodBeat.m2505o(918);
            return true;
        }
        AppMethodBeat.m2505o(918);
        return false;
    }

    /* renamed from: l */
    static /* synthetic */ void m5048l(C2789a c2789a) {
        AppMethodBeat.m2504i(920);
        c2789a.ktj.clear();
        C11368c beQ = C45805b.beQ();
        if (beQ != null) {
            beQ.mo16768hY("CdnDownloadInfo", String.format("delete from %s", new Object[]{"CdnDownloadInfo"}));
        }
        AppMethodBeat.m2505o(920);
    }
}
