package com.tencent.mm.plugin.cdndownloader.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.cdndownloader.e.b;
import com.tencent.mm.plugin.cdndownloader.f.c;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import java.util.Set;

public final class a implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
    private static a kte;
    private static final Object kth = new Object();
    private long ktf = 0;
    private long ktg = 0;
    com.tencent.mm.plugin.cdndownloader.a.a kti;
    private Set<CDNTaskInfo> ktj = new com.tencent.mm.plugin.cdndownloader.e.a(new b() {
        public final void beX() {
            AppMethodBeat.i(889);
            ab.i("MicroMsg.CDNDownloadClient", "notify add");
            a.a(a.this);
            a.b(a.this);
            AppMethodBeat.o(889);
        }

        public final void remove() {
            AppMethodBeat.i(890);
            ab.i("MicroMsg.CDNDownloadClient", "notify remove");
            if (a.this.ktj.size() == 0) {
                a.d(a.this);
                a.e(a.this);
            }
            AppMethodBeat.o(890);
        }

        public final void clear() {
            AppMethodBeat.i(891);
            ab.i("MicroMsg.CDNDownloadClient", "notify clear");
            a.d(a.this);
            a.e(a.this);
            AppMethodBeat.o(891);
        }
    });
    public b ktk;
    private ServiceConnection ktl = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(892);
            ab.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
            a.this.kti = com.tencent.mm.plugin.cdndownloader.a.a.a.s(iBinder);
            a.f(a.this);
            a.g(a.this);
            try {
                synchronized (a.kth) {
                    a.kth.notifyAll();
                }
                AppMethodBeat.o(892);
            } catch (Exception e) {
                AppMethodBeat.o(892);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(892);
                }
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(893);
            ab.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
            if (a.this.ktj.size() != 0) {
                for (CDNTaskInfo cDNTaskInfo : a.this.ktj) {
                    cDNTaskInfo.ktw = true;
                }
            }
            AppMethodBeat.o(893);
        }
    };
    private ap ktm = new ap(com.tencent.mm.ce.a.dvQ().getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(894);
            ab.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
            if (a.this.ktj.size() == 0) {
                AppMethodBeat.o(894);
                return false;
            }
            if (a.this.kti != null) {
                try {
                    ab.d("MicroMsg.CDNDownloadClient", "checkActive");
                    a.this.kti.beT();
                } catch (RemoteException e) {
                    ab.e("MicroMsg.CDNDownloadClient", "check process active false");
                    h.pYm.a(710, 3, 1, false);
                    if (a.i(a.this)) {
                        a.this.ktg = System.currentTimeMillis();
                        for (CDNTaskInfo cDNTaskInfo : a.this.ktj) {
                            cDNTaskInfo.ktw = true;
                        }
                        a.j(a.this);
                        AppMethodBeat.o(894);
                        return true;
                    }
                    ab.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
                    h.pYm.a(710, 4, 1, false);
                    for (CDNTaskInfo cDNTaskInfo2 : a.this.ktj) {
                        a.this.ktk.f(cDNTaskInfo2.downloadUrl, 4, com.tencent.mm.plugin.downloader.a.a.kJS, null);
                    }
                    a.l(a.this);
                    AppMethodBeat.o(894);
                    return false;
                }
            }
            AppMethodBeat.o(894);
            return true;
        }
    }, true);
    private com.tencent.mm.plugin.cdndownloader.a.b ktn = new com.tencent.mm.plugin.cdndownloader.a.b.a() {
        public final void e(String str, int i, int i2, String str2) {
            AppMethodBeat.i(895);
            ab.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
            if (i != 1) {
                a.a(a.this, new CDNTaskInfo(str));
            }
            if (a.this.ktk != null) {
                a.this.ktk.f(str, i, i2, str2);
            }
            AppMethodBeat.o(895);
        }

        public final void l(String str, long j, long j2) {
            AppMethodBeat.i(896);
            ab.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", str, Long.valueOf(j), Long.valueOf(j2));
            if (a.this.ktk != null) {
                a.this.ktk.m(str, j, j2);
            }
            AppMethodBeat.o(896);
        }
    };
    private com.tencent.mm.network.n.a kto = new com.tencent.mm.network.n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(897);
            a aVar = a.this;
            ab.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: ".concat(String.valueOf(i)));
            if (aVar.kti != null) {
                try {
                    aVar.kti.tr(i);
                    AppMethodBeat.o(897);
                    return;
                } catch (RemoteException e) {
                }
            }
            AppMethodBeat.o(897);
        }
    };
    private Context mContext = ah.getContext();

    static /* synthetic */ void j(a aVar) {
        AppMethodBeat.i(919);
        aVar.beW();
        AppMethodBeat.o(919);
    }

    public static synchronized a beV() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(899);
            if (kte == null) {
                kte = new a();
            }
            aVar = kte;
            AppMethodBeat.o(899);
        }
        return aVar;
    }

    static {
        AppMethodBeat.i(922);
        AppMethodBeat.o(922);
    }

    public a() {
        AppMethodBeat.i(TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
        g.RQ();
        g.RO().a(this.kto);
        beW();
        AppMethodBeat.o(TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
    }

    private synchronized void beW() {
        AppMethodBeat.i(901);
        try {
            ab.i("MicroMsg.CDNDownloadClient", "bindService: ".concat(String.valueOf(this.mContext.bindService(new Intent(this.mContext, CDNDownloadService.class), this.ktl, 1))));
            AppMethodBeat.o(901);
        } catch (Exception e) {
            ab.e("MicroMsg.CDNDownloadClient", "bindService: " + e.getMessage());
            AppMethodBeat.o(901);
        }
        return;
    }

    public final synchronized int a(CDNTaskInfo cDNTaskInfo) {
        int i = -2;
        synchronized (this) {
            AppMethodBeat.i(902);
            if (cDNTaskInfo == null || bo.isNullOrNil(cDNTaskInfo.downloadUrl)) {
                ab.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
                i = -1;
                AppMethodBeat.o(902);
            } else {
                ab.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", cDNTaskInfo.filePath, cDNTaskInfo.downloadUrl);
                if (this.ktj.contains(cDNTaskInfo)) {
                    ab.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
                    AppMethodBeat.o(902);
                } else {
                    CDNTaskState HC = HC(cDNTaskInfo.downloadUrl);
                    if (HC != null && HC.taskState == 104 && e.ct(cDNTaskInfo.filePath)) {
                        ab.i("MicroMsg.CDNDownloadClient", "addDownloadTask, has download success");
                        AppMethodBeat.o(902);
                        i = 1;
                    } else {
                        if (this.kti != null) {
                            try {
                                int a = this.kti.a(cDNTaskInfo);
                                this.ktn.e(cDNTaskInfo.cHr, 1, 0, "");
                                if (a == 0 || a == -2) {
                                    c(cDNTaskInfo);
                                }
                                AppMethodBeat.o(902);
                                i = a;
                            } catch (RemoteException e) {
                                ab.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + e.getMessage());
                            }
                        }
                        c(cDNTaskInfo);
                        beW();
                        AppMethodBeat.o(902);
                        i = 0;
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean HA(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(i.SCENE_BIZ_SCROLL);
            ab.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: ".concat(String.valueOf(str)));
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
                AppMethodBeat.o(i.SCENE_BIZ_SCROLL);
            } else {
                d(new CDNTaskInfo(str));
                if (this.kti != null) {
                    try {
                        z = this.kti.HA(str);
                        AppMethodBeat.o(i.SCENE_BIZ_SCROLL);
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + e.getMessage());
                    }
                }
                ab.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
                AppMethodBeat.o(i.SCENE_BIZ_SCROLL);
            }
        }
        return z;
    }

    public final synchronized int b(CDNTaskInfo cDNTaskInfo) {
        int i = -2;
        synchronized (this) {
            AppMethodBeat.i(904);
            if (cDNTaskInfo == null || bo.isNullOrNil(cDNTaskInfo.downloadUrl)) {
                ab.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
                i = -1;
                AppMethodBeat.o(904);
            } else {
                ab.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + cDNTaskInfo.downloadUrl);
                if (this.ktj.contains(cDNTaskInfo)) {
                    ab.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, already in running");
                    AppMethodBeat.o(904);
                } else {
                    CDNTaskState HC = HC(cDNTaskInfo.downloadUrl);
                    if (HC != null && HC.taskState == 104 && e.ct(cDNTaskInfo.filePath)) {
                        ab.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, has download success");
                        AppMethodBeat.o(904);
                        i = 1;
                    } else {
                        cDNTaskInfo.ktw = true;
                        if (this.kti != null) {
                            try {
                                int b = this.kti.b(cDNTaskInfo);
                                this.ktn.e(cDNTaskInfo.cHr, 1, 0, "");
                                if (b == 0 || b == -2) {
                                    c(cDNTaskInfo);
                                }
                                AppMethodBeat.o(904);
                                i = b;
                            } catch (RemoteException e) {
                                ab.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + e.getMessage());
                            }
                        }
                        c(cDNTaskInfo);
                        beW();
                        AppMethodBeat.o(904);
                        i = 0;
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean HB(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(905);
            ab.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: ".concat(String.valueOf(str)));
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
                AppMethodBeat.o(905);
            } else {
                d(new CDNTaskInfo(str));
                if (this.kti != null) {
                    try {
                        z = this.kti.HB(str);
                        AppMethodBeat.o(905);
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + e.getMessage());
                    }
                }
                ab.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
                AppMethodBeat.o(905);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db A:{Catch:{ RemoteException -> 0x009a }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0112 A:{Catch:{ RemoteException -> 0x009a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized CDNTaskState HC(String str) {
        CDNTaskState cDNTaskState = null;
        synchronized (this) {
            AppMethodBeat.i(906);
            ab.i("MicroMsg.CDNDownloadClient", "queryDownloadTask: ".concat(String.valueOf(str)));
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
                AppMethodBeat.o(906);
            } else {
                if (this.kti != null) {
                    ab.d("MicroMsg.CDNDownloadClient", "queryDownloadTask service has connected");
                    try {
                        CDNTaskState HC = this.kti.HC(str);
                        if (HC.taskState == 100 || HC.taskState == 101) {
                            if (!this.ktj.contains(new CDNTaskInfo(str))) {
                                com.tencent.mm.plugin.cdndownloader.f.a aVar;
                                Object cDNTaskInfo;
                                c beQ = com.tencent.mm.plugin.cdndownloader.f.b.beQ();
                                if (beQ != null) {
                                    Cursor rawQuery = beQ.rawQuery(String.format("select * from %s where %s=%s", new Object[]{"CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(str.hashCode())}), new String[0]);
                                    if (rawQuery != null) {
                                        com.tencent.mm.plugin.cdndownloader.f.a aVar2 = null;
                                        while (rawQuery.moveToNext()) {
                                            aVar2 = new com.tencent.mm.plugin.cdndownloader.f.a();
                                            aVar2.d(rawQuery);
                                        }
                                        rawQuery.close();
                                        aVar = aVar2;
                                        if (aVar == null) {
                                            cDNTaskInfo = new CDNTaskInfo(str);
                                            cDNTaskInfo.ktq = aVar.field_httpsUrl;
                                            cDNTaskInfo.cHr = aVar.field_mediaId;
                                            cDNTaskInfo.filePath = aVar.field_filePath;
                                            cDNTaskInfo.ktr = aVar.field_verifyHeaders;
                                            cDNTaskInfo.ktu = aVar.field_allowMobileNetDownload.booleanValue();
                                            cDNTaskInfo.ktv = aVar.field_wifiAutoDownload.booleanValue();
                                            cDNTaskInfo.egs = aVar.field_game_package_download.booleanValue();
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
                                aVar = null;
                                if (aVar == null) {
                                }
                                if (cDNTaskInfo != null) {
                                }
                            }
                        } else if (this.ktj.contains(new CDNTaskInfo(str))) {
                            HC.taskState = 101;
                        }
                        AppMethodBeat.o(906);
                        cDNTaskState = HC;
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + e.getMessage());
                    }
                }
                if (this.ktj.contains(new CDNTaskInfo(str))) {
                    cDNTaskState = new CDNTaskState();
                    cDNTaskState.taskState = 101;
                    AppMethodBeat.o(906);
                } else {
                    AppMethodBeat.o(906);
                }
            }
        }
        return cDNTaskState;
    }

    public final synchronized CDNTaskState HE(String str) {
        CDNTaskState HC;
        try {
            AppMethodBeat.i(907);
            if (this.kti != null) {
                HC = HC(str);
                AppMethodBeat.o(907);
            } else if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                HC = null;
                AppMethodBeat.o(907);
            } else {
                beW();
                try {
                    synchronized (kth) {
                        if (this.kti == null) {
                            ab.i("MicroMsg.CDNDownloadClient", "queryDownloadTaskSync, wait for bindService, now: " + System.currentTimeMillis());
                            com.tencent.mm.ce.a.r(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(898);
                                    synchronized (a.kth) {
                                        try {
                                            ab.i("MicroMsg.CDNDownloadClient", "queryDownloadTaskSync, notify after 10000ms");
                                            a.kth.notifyAll();
                                        } finally {
                                            while (true) {
                                            }
                                            AppMethodBeat.o(898);
                                        }
                                    }
                                }
                            }, 10000);
                            kth.wait();
                        }
                    }
                } catch (Exception e) {
                    ab.i("MicroMsg.CDNDownloadClient", "queryDownloadTaskSync，now: %d, exp: %s", Long.valueOf(System.currentTimeMillis()), e.getMessage());
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(907);
                        throw th;
                    }
                }
                HC = HC(str);
                AppMethodBeat.o(907);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return HC;
    }

    private void beR() {
        AppMethodBeat.i(908);
        if (this.kti != null) {
            try {
                this.kti.beR();
                AppMethodBeat.o(908);
                return;
            } catch (RemoteException e) {
                ab.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: ".concat(String.valueOf(e)));
            }
        }
        AppMethodBeat.o(908);
    }

    private void c(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.i(909);
        this.ktj.add(cDNTaskInfo);
        com.tencent.mm.plugin.cdndownloader.f.b.a(e(cDNTaskInfo));
        AppMethodBeat.o(909);
    }

    private void d(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.i(910);
        this.ktj.remove(cDNTaskInfo);
        com.tencent.mm.plugin.cdndownloader.f.b.HF(cDNTaskInfo.downloadUrl);
        AppMethodBeat.o(910);
    }

    private static com.tencent.mm.plugin.cdndownloader.f.a e(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.i(911);
        com.tencent.mm.plugin.cdndownloader.f.a aVar = new com.tencent.mm.plugin.cdndownloader.f.a();
        aVar.field_mediaId = cDNTaskInfo.cHr;
        aVar.field_downloadUrlHashCode = cDNTaskInfo.downloadUrl.hashCode();
        aVar.field_downloadUrl = cDNTaskInfo.downloadUrl;
        aVar.field_httpsUrl = cDNTaskInfo.ktq;
        aVar.field_filePath = cDNTaskInfo.filePath;
        aVar.field_verifyHeaders = cDNTaskInfo.ktr;
        aVar.field_allowMobileNetDownload = Boolean.valueOf(cDNTaskInfo.ktu);
        aVar.field_wifiAutoDownload = Boolean.valueOf(cDNTaskInfo.ktv);
        aVar.field_game_package_download = Boolean.valueOf(cDNTaskInfo.egs);
        AppMethodBeat.o(911);
        return aVar;
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(916);
        try {
            ab.i("MicroMsg.CDNDownloadClient", "registerCallback");
            aVar.kti.a(aVar.ktn);
            AppMethodBeat.o(916);
        } catch (RemoteException e) {
            ab.e("MicroMsg.CDNDownloadClient", "registerCallback: " + e.getMessage());
            AppMethodBeat.o(916);
        }
    }

    static /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(917);
        ab.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected");
        if (aVar.ktj.size() > 0) {
            aVar.beR();
        }
        for (CDNTaskInfo cDNTaskInfo : aVar.ktj) {
            ab.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected, url: %s, resume: %b", cDNTaskInfo.downloadUrl, Boolean.valueOf(cDNTaskInfo.ktw));
            try {
                if (cDNTaskInfo.ktw) {
                    aVar.kti.b(cDNTaskInfo);
                } else {
                    aVar.kti.a(cDNTaskInfo);
                }
                aVar.ktn.e(cDNTaskInfo.cHr, 1, 0, "");
            } catch (RemoteException e) {
                ab.e("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected: ".concat(String.valueOf(e)));
                h.pYm.a(710, 0, 1, false);
            }
        }
        AppMethodBeat.o(917);
    }

    static /* synthetic */ boolean i(a aVar) {
        AppMethodBeat.i(918);
        if (System.currentTimeMillis() - aVar.ktg > 120000) {
            AppMethodBeat.o(918);
            return true;
        }
        AppMethodBeat.o(918);
        return false;
    }

    static /* synthetic */ void l(a aVar) {
        AppMethodBeat.i(920);
        aVar.ktj.clear();
        c beQ = com.tencent.mm.plugin.cdndownloader.f.b.beQ();
        if (beQ != null) {
            beQ.hY("CdnDownloadInfo", String.format("delete from %s", new Object[]{"CdnDownloadInfo"}));
        }
        AppMethodBeat.o(920);
    }
}
