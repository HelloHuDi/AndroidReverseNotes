package com.tencent.p177mm.plugin.wepkg.model;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.p177mm.plugin.wepkg.event.C35760c;
import com.tencent.p177mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.utils.C35765a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wepkg.model.i */
public class C30020i {
    private static volatile C30020i uXB = null;

    /* renamed from: a */
    static /* synthetic */ void m47506a(C30020i c30020i, String str, List list, boolean z) {
        AppMethodBeat.m2504i(63600);
        c30020i.m47508a(str, list, z);
        AppMethodBeat.m2505o(63600);
    }

    /* renamed from: w */
    static /* synthetic */ void m47511w(boolean z, String str) {
        AppMethodBeat.m2504i(63599);
        C30020i.m47510v(z, str);
        AppMethodBeat.m2505o(63599);
    }

    public static C30020i dgD() {
        AppMethodBeat.m2504i(63593);
        if (uXB == null) {
            synchronized (C30020i.class) {
                try {
                    if (uXB == null) {
                        uXB = new C30020i();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(63593);
                    }
                }
            }
        }
        C30020i c30020i = uXB;
        AppMethodBeat.m2505o(63593);
        return c30020i;
    }

    /* renamed from: bQ */
    public final void mo48257bQ(final String str, final boolean z) {
        AppMethodBeat.m2504i(63594);
        if (C5046bo.isNullOrNil(str)) {
            C30020i.m47510v(z, str);
            AppMethodBeat.m2505o(63594);
            return;
        }
        final C232061 c232061 = new C14805a() {
            /* renamed from: a */
            public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
                AppMethodBeat.m2504i(63590);
                if (this.object instanceof String) {
                    C30020i.m47509bR((String) this.object, baseWepkgProcessTask.csN);
                    C30020i.m47507a(C30020i.this, (String) this.object, z);
                    AppMethodBeat.m2505o(63590);
                    return;
                }
                C30020i.m47511w(z, str);
                AppMethodBeat.m2505o(63590);
            }
        };
        c232061.object = str;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        if (C5046bo.isNullOrNil(str)) {
            C30020i.m47510v(z, str);
            AppMethodBeat.m2505o(63594);
            return;
        }
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        WepkgVersion ahW = C40404h.ahW(str);
        if (ahW == null) {
            C30020i.m47510v(z, str);
            AppMethodBeat.m2505o(63594);
        } else if (ahW.uXM) {
            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
            wepkgCrossProcessTask.csN = true;
            c232061.mo9822a(wepkgCrossProcessTask);
            AppMethodBeat.m2505o(63594);
        } else {
            C40404h.m69306a(1, ahW.eBS, "", ahW.downloadUrl, (long) ahW.uXK, ahW.version, ahW.cvZ, ahW.uWQ, new C14805a() {
                /* renamed from: a */
                public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    AppMethodBeat.m2504i(63591);
                    if (baseWepkgProcessTask instanceof WepkgDownloadProcessTask) {
                        WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                        if (wepkgDownloadProcessTask.uXg != RetCode.OK || C5046bo.isNullOrNil(wepkgDownloadProcessTask.cSY) || C5046bo.isNullOrNil(wepkgDownloadProcessTask.gSP)) {
                            if (c232061 != null) {
                                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                wepkgCrossProcessTask.csN = false;
                                c232061.mo9822a(wepkgCrossProcessTask);
                            }
                            C30020i.m47511w(z, str);
                            AppMethodBeat.m2505o(63591);
                            return;
                        }
                        C40404h.m69310a(wepkgDownloadProcessTask.cSY, wepkgDownloadProcessTask.gSP, true, c232061);
                        AppMethodBeat.m2505o(63591);
                        return;
                    }
                    C30020i.m47511w(z, str);
                    AppMethodBeat.m2505o(63591);
                }
            });
            AppMethodBeat.m2505o(63594);
        }
    }

    /* renamed from: a */
    private void m47508a(final String str, List<WepkgPreloadFile> list, boolean z) {
        AppMethodBeat.m2504i(63595);
        try {
            if (C5046bo.m7548ek(list)) {
                C4990ab.m7416i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
                if (C5046bo.isNullOrNil(str)) {
                    C30020i.m47510v(z, str);
                    AppMethodBeat.m2505o(63595);
                    return;
                }
                if (C5046bo.m7548ek(C40404h.ahY(str))) {
                    WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.f2968Cn = AuthApiStatusCodes.AUTH_APP_CERT_ERROR;
                    wepkgCrossProcessTask.uWY.eBS = str;
                    wepkgCrossProcessTask.uWY.uXN = true;
                    if (C4996ah.bqo()) {
                        wepkgCrossProcessTask.asP();
                    } else {
                        WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
                    }
                    WepkgVersion ahW = C40404h.ahW(str);
                    if (!(ahW == null || ahW.createTime == 0)) {
                        C35765a.m58633b("downloadCompleteTime", "", ahW.eBS, ahW.version, -1, System.currentTimeMillis() - (ahW.createTime * 1000), null);
                        wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.f2968Cn = 3007;
                        wepkgCrossProcessTask.uWY.eBS = str;
                        if (C4996ah.bqo()) {
                            wepkgCrossProcessTask.asP();
                        } else {
                            WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
                        }
                    }
                    C30020i.m47510v(z, str);
                    C4990ab.m7416i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
                    AppMethodBeat.m2505o(63595);
                    return;
                }
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", Integer.valueOf(C40404h.ahY(str).size()));
                C30020i.m47510v(z, str);
                AppMethodBeat.m2505o(63595);
                return;
            }
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) list.remove(0);
            if (wepkgPreloadFile != null) {
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", wepkgPreloadFile.eBS, wepkgPreloadFile.version, wepkgPreloadFile.uXe);
                final List<WepkgPreloadFile> list2 = list;
                final boolean z2 = z;
                C300193 c300193 = new C14805a() {
                    /* renamed from: a */
                    public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
                        AppMethodBeat.m2504i(63592);
                        if ((this.object instanceof WepkgPreloadFile) && (baseWepkgProcessTask instanceof WepkgDownloadProcessTask)) {
                            WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.object;
                            if (wepkgDownloadProcessTask.uXg != RetCode.OK || C5046bo.isNullOrNil(wepkgDownloadProcessTask.gSP)) {
                                C4990ab.m7417i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", wepkgDownloadProcessTask.uXg);
                                C30020i.m47506a(C30020i.this, str, list2, z2);
                                AppMethodBeat.m2505o(63592);
                                return;
                            }
                            String str = wepkgPreloadFile.eBS;
                            String str2 = wepkgPreloadFile.uXe;
                            String str3 = wepkgDownloadProcessTask.gSP;
                            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                            wepkgCrossProcessTask.f2968Cn = WearableStatusCodes.UNKNOWN_LISTENER;
                            wepkgCrossProcessTask.uXb.eBS = str;
                            wepkgCrossProcessTask.uXb.uXe = str2;
                            wepkgCrossProcessTask.uXb.filePath = str3;
                            wepkgCrossProcessTask.uXb.uXr = true;
                            if (C4996ah.bqo()) {
                                wepkgCrossProcessTask.asP();
                            } else {
                                WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
                            }
                            C30020i.m47506a(C30020i.this, str, list2, z2);
                            AppMethodBeat.m2505o(63592);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
                        C30020i.m47506a(C30020i.this, str, list2, z2);
                        AppMethodBeat.m2505o(63592);
                    }
                };
                c300193.object = wepkgPreloadFile;
                C40404h.m69306a(2, wepkgPreloadFile.eBS, wepkgPreloadFile.uXe, wepkgPreloadFile.downloadUrl, (long) wepkgPreloadFile.size, wepkgPreloadFile.version, wepkgPreloadFile.cvZ, wepkgPreloadFile.uWQ, c300193);
                AppMethodBeat.m2505o(63595);
                return;
            }
            C4990ab.m7416i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
            m47508a(str, (List) list, z);
            AppMethodBeat.m2505o(63595);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", e.getMessage());
            AppMethodBeat.m2505o(63595);
        }
    }

    /* renamed from: v */
    private static void m47510v(boolean z, String str) {
        AppMethodBeat.m2504i(63596);
        if (z) {
            C9497vv c9497vv = new C9497vv();
            c9497vv.cSX.cuy = 0;
            C4879a.xxA.mo10055m(c9497vv);
        }
        C40404h.aib(str);
        C30011b.dgz().mo48248dP(str, 3);
        AppMethodBeat.m2505o(63596);
    }

    /* renamed from: bR */
    static /* synthetic */ void m47509bR(String str, boolean z) {
        AppMethodBeat.m2504i(63597);
        C4990ab.m7416i("MicroMsg.Wepkg.WepkgUpdater", "notifyBigPkgDownloadComplete: ".concat(String.valueOf(str)));
        C35760c.m58625a(new DownloadBigPkgCompleteNotify(str, z), null);
        AppMethodBeat.m2505o(63597);
    }
}
