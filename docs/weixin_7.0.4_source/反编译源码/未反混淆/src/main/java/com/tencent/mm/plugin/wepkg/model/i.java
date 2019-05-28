package com.tencent.mm.plugin.wepkg.model;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.c;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class i {
    private static volatile i uXB = null;

    static /* synthetic */ void a(i iVar, String str, List list, boolean z) {
        AppMethodBeat.i(63600);
        iVar.a(str, list, z);
        AppMethodBeat.o(63600);
    }

    static /* synthetic */ void w(boolean z, String str) {
        AppMethodBeat.i(63599);
        v(z, str);
        AppMethodBeat.o(63599);
    }

    public static i dgD() {
        AppMethodBeat.i(63593);
        if (uXB == null) {
            synchronized (i.class) {
                try {
                    if (uXB == null) {
                        uXB = new i();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(63593);
                    }
                }
            }
        }
        i iVar = uXB;
        AppMethodBeat.o(63593);
        return iVar;
    }

    public final void bQ(final String str, final boolean z) {
        AppMethodBeat.i(63594);
        if (bo.isNullOrNil(str)) {
            v(z, str);
            AppMethodBeat.o(63594);
            return;
        }
        final AnonymousClass1 anonymousClass1 = new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                AppMethodBeat.i(63590);
                if (this.object instanceof String) {
                    i.bR((String) this.object, baseWepkgProcessTask.csN);
                    i.a(i.this, (String) this.object, z);
                    AppMethodBeat.o(63590);
                    return;
                }
                i.w(z, str);
                AppMethodBeat.o(63590);
            }
        };
        anonymousClass1.object = str;
        ab.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        if (bo.isNullOrNil(str)) {
            v(z, str);
            AppMethodBeat.o(63594);
            return;
        }
        ab.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        WepkgVersion ahW = h.ahW(str);
        if (ahW == null) {
            v(z, str);
            AppMethodBeat.o(63594);
        } else if (ahW.uXM) {
            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
            wepkgCrossProcessTask.csN = true;
            anonymousClass1.a(wepkgCrossProcessTask);
            AppMethodBeat.o(63594);
        } else {
            h.a(1, ahW.eBS, "", ahW.downloadUrl, (long) ahW.uXK, ahW.version, ahW.cvZ, ahW.uWQ, new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    AppMethodBeat.i(63591);
                    if (baseWepkgProcessTask instanceof WepkgDownloadProcessTask) {
                        WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                        if (wepkgDownloadProcessTask.uXg != RetCode.OK || bo.isNullOrNil(wepkgDownloadProcessTask.cSY) || bo.isNullOrNil(wepkgDownloadProcessTask.gSP)) {
                            if (anonymousClass1 != null) {
                                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                wepkgCrossProcessTask.csN = false;
                                anonymousClass1.a(wepkgCrossProcessTask);
                            }
                            i.w(z, str);
                            AppMethodBeat.o(63591);
                            return;
                        }
                        h.a(wepkgDownloadProcessTask.cSY, wepkgDownloadProcessTask.gSP, true, anonymousClass1);
                        AppMethodBeat.o(63591);
                        return;
                    }
                    i.w(z, str);
                    AppMethodBeat.o(63591);
                }
            });
            AppMethodBeat.o(63594);
        }
    }

    private void a(final String str, List<WepkgPreloadFile> list, boolean z) {
        AppMethodBeat.i(63595);
        try {
            if (bo.ek(list)) {
                ab.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
                if (bo.isNullOrNil(str)) {
                    v(z, str);
                    AppMethodBeat.o(63595);
                    return;
                }
                if (bo.ek(h.ahY(str))) {
                    WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.Cn = AuthApiStatusCodes.AUTH_APP_CERT_ERROR;
                    wepkgCrossProcessTask.uWY.eBS = str;
                    wepkgCrossProcessTask.uWY.uXN = true;
                    if (ah.bqo()) {
                        wepkgCrossProcessTask.asP();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask);
                    }
                    WepkgVersion ahW = h.ahW(str);
                    if (!(ahW == null || ahW.createTime == 0)) {
                        a.b("downloadCompleteTime", "", ahW.eBS, ahW.version, -1, System.currentTimeMillis() - (ahW.createTime * 1000), null);
                        wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.Cn = 3007;
                        wepkgCrossProcessTask.uWY.eBS = str;
                        if (ah.bqo()) {
                            wepkgCrossProcessTask.asP();
                        } else {
                            WepkgMainProcessService.b(wepkgCrossProcessTask);
                        }
                    }
                    v(z, str);
                    ab.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
                    AppMethodBeat.o(63595);
                    return;
                }
                ab.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", Integer.valueOf(h.ahY(str).size()));
                v(z, str);
                AppMethodBeat.o(63595);
                return;
            }
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) list.remove(0);
            if (wepkgPreloadFile != null) {
                ab.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", wepkgPreloadFile.eBS, wepkgPreloadFile.version, wepkgPreloadFile.uXe);
                final List<WepkgPreloadFile> list2 = list;
                final boolean z2 = z;
                AnonymousClass3 anonymousClass3 = new a() {
                    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                        AppMethodBeat.i(63592);
                        if ((this.object instanceof WepkgPreloadFile) && (baseWepkgProcessTask instanceof WepkgDownloadProcessTask)) {
                            WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.object;
                            if (wepkgDownloadProcessTask.uXg != RetCode.OK || bo.isNullOrNil(wepkgDownloadProcessTask.gSP)) {
                                ab.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", wepkgDownloadProcessTask.uXg);
                                i.a(i.this, str, list2, z2);
                                AppMethodBeat.o(63592);
                                return;
                            }
                            String str = wepkgPreloadFile.eBS;
                            String str2 = wepkgPreloadFile.uXe;
                            String str3 = wepkgDownloadProcessTask.gSP;
                            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                            wepkgCrossProcessTask.Cn = WearableStatusCodes.UNKNOWN_LISTENER;
                            wepkgCrossProcessTask.uXb.eBS = str;
                            wepkgCrossProcessTask.uXb.uXe = str2;
                            wepkgCrossProcessTask.uXb.filePath = str3;
                            wepkgCrossProcessTask.uXb.uXr = true;
                            if (ah.bqo()) {
                                wepkgCrossProcessTask.asP();
                            } else {
                                WepkgMainProcessService.b(wepkgCrossProcessTask);
                            }
                            i.a(i.this, str, list2, z2);
                            AppMethodBeat.o(63592);
                            return;
                        }
                        ab.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
                        i.a(i.this, str, list2, z2);
                        AppMethodBeat.o(63592);
                    }
                };
                anonymousClass3.object = wepkgPreloadFile;
                h.a(2, wepkgPreloadFile.eBS, wepkgPreloadFile.uXe, wepkgPreloadFile.downloadUrl, (long) wepkgPreloadFile.size, wepkgPreloadFile.version, wepkgPreloadFile.cvZ, wepkgPreloadFile.uWQ, anonymousClass3);
                AppMethodBeat.o(63595);
                return;
            }
            ab.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
            a(str, (List) list, z);
            AppMethodBeat.o(63595);
        } catch (Exception e) {
            ab.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", e.getMessage());
            AppMethodBeat.o(63595);
        }
    }

    private static void v(boolean z, String str) {
        AppMethodBeat.i(63596);
        if (z) {
            vv vvVar = new vv();
            vvVar.cSX.cuy = 0;
            com.tencent.mm.sdk.b.a.xxA.m(vvVar);
        }
        h.aib(str);
        b.dgz().dP(str, 3);
        AppMethodBeat.o(63596);
    }

    static /* synthetic */ void bR(String str, boolean z) {
        AppMethodBeat.i(63597);
        ab.i("MicroMsg.Wepkg.WepkgUpdater", "notifyBigPkgDownloadComplete: ".concat(String.valueOf(str)));
        c.a(new DownloadBigPkgCompleteNotify(str, z), null);
        AppMethodBeat.o(63597);
    }
}
