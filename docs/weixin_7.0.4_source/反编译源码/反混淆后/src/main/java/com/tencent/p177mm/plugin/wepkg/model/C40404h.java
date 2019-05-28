package com.tencent.p177mm.plugin.wepkg.model;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.p177mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.p177mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.protocal.protobuf.bkj;
import com.tencent.p177mm.protocal.protobuf.cvm;
import com.tencent.p177mm.protocal.protobuf.cvo;
import com.tencent.p177mm.protocal.protobuf.cvp;
import com.tencent.p177mm.protocal.protobuf.cvq;
import com.tencent.p177mm.protocal.protobuf.cvr;
import com.tencent.p177mm.protocal.protobuf.cvs;
import com.tencent.p177mm.protocal.protobuf.cvt;
import com.tencent.p177mm.protocal.protobuf.cvu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wepkg.model.h */
public final class C40404h {

    /* renamed from: com.tencent.mm.plugin.wepkg.model.h$12 */
    static class C3001512 implements Runnable {
        final /* synthetic */ C14805a uXt;
        final /* synthetic */ WepkgCrossProcessTask uXy;

        C3001512(C14805a c14805a, WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.uXt = c14805a;
            this.uXy = wepkgCrossProcessTask;
        }

        public final void run() {
            AppMethodBeat.m2504i(63578);
            if (this.uXt != null) {
                this.uXt.mo9822a(this.uXy);
            }
            this.uXy.aBW();
            AppMethodBeat.m2505o(63578);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.h$11 */
    static class C4040111 implements Runnable {
        final /* synthetic */ C14805a uXt;
        final /* synthetic */ WepkgCrossProcessTask uXy;

        C4040111(WepkgCrossProcessTask wepkgCrossProcessTask, C14805a c14805a) {
            this.uXy = wepkgCrossProcessTask;
            this.uXt = c14805a;
        }

        public final void run() {
            AppMethodBeat.m2504i(63577);
            this.uXy.asP();
            if (this.uXt != null) {
                this.uXt.mo9822a(this.uXy);
            }
            AppMethodBeat.m2505o(63577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.h$6 */
    public static class C404026 implements Runnable {
        final /* synthetic */ C14805a uXt = null;
        final /* synthetic */ WepkgCrossProcessTask uXy;

        public C404026(WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.uXy = wepkgCrossProcessTask;
        }

        public final void run() {
            AppMethodBeat.m2504i(63572);
            this.uXy.asP();
            if (this.uXt != null) {
                this.uXt.mo9822a(this.uXy);
            }
            AppMethodBeat.m2505o(63572);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.h$7 */
    public static class C404067 implements Runnable {
        final /* synthetic */ C14805a uXt = null;
        final /* synthetic */ WepkgCrossProcessTask uXy;

        public C404067(WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.uXy = wepkgCrossProcessTask;
        }

        public final void run() {
            AppMethodBeat.m2504i(63573);
            if (this.uXt != null) {
                this.uXt.mo9822a(this.uXy);
            }
            this.uXy.aBW();
            AppMethodBeat.m2505o(63573);
        }
    }

    public static WepkgVersion ahW(String str) {
        AppMethodBeat.m2504i(63579);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = 3001;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (C4996ah.bqo()) {
            wepkgCrossProcessTask.asP();
        } else {
            WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.uWY == null) {
            AppMethodBeat.m2505o(63579);
            return null;
        }
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.uWY;
        AppMethodBeat.m2505o(63579);
        return wepkgVersion;
    }

    public static WepkgVersion ahX(String str) {
        AppMethodBeat.m2504i(63580);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = 3002;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (C4996ah.bqo()) {
            wepkgCrossProcessTask.asP();
        } else {
            WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.uWY == null) {
            AppMethodBeat.m2505o(63580);
            return null;
        }
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.uWY;
        AppMethodBeat.m2505o(63580);
        return wepkgVersion;
    }

    /* renamed from: a */
    public static void m69308a(String str, final C14805a c14805a) {
        AppMethodBeat.m2504i(63581);
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = 3002;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (C4996ah.bqo()) {
            wepkgCrossProcessTask.asP();
            AppMethodBeat.m2505o(63581);
            return;
        }
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(63574);
                if (c14805a != null) {
                    c14805a.mo9822a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.m2505o(63574);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.m87655a(wepkgCrossProcessTask);
        AppMethodBeat.m2505o(63581);
    }

    /* renamed from: a */
    public static void m69310a(String str, String str2, boolean z, final C14805a c14805a) {
        AppMethodBeat.m2504i(63582);
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = 3005;
        wepkgCrossProcessTask.uWY.eBS = str;
        wepkgCrossProcessTask.uWY.gSP = str2;
        wepkgCrossProcessTask.uWY.uXM = z;
        if (C4996ah.bqo()) {
            C30022d.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(63575);
                    wepkgCrossProcessTask.asP();
                    if (c14805a != null) {
                        c14805a.mo9822a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.m2505o(63575);
                }
            });
            AppMethodBeat.m2505o(63582);
            return;
        }
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(63576);
                if (c14805a != null) {
                    c14805a.mo9822a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.m2505o(63576);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.m87655a(wepkgCrossProcessTask);
        AppMethodBeat.m2505o(63582);
    }

    /* renamed from: a */
    public static void m69306a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, C14805a c14805a) {
        AppMethodBeat.m2504i(63583);
        final WepkgMainProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask();
        wepkgDownloadProcessTask.fileType = i;
        wepkgDownloadProcessTask.cSY = str;
        wepkgDownloadProcessTask.downloadUrl = str3;
        wepkgDownloadProcessTask.uXf = j;
        wepkgDownloadProcessTask.version = str4;
        wepkgDownloadProcessTask.cvZ = str5;
        wepkgDownloadProcessTask.uWQ = i2;
        if (C4996ah.bqo()) {
            final C14805a c14805a2 = c14805a;
            final int i3 = i;
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final long j2 = j;
            final String str9 = str4;
            final String str10 = str5;
            final int i4 = i2;
            C30022d.aNS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.wepkg.model.h$1$1 */
                class C148081 implements IWepkgUpdateCallback {
                    C148081() {
                    }

                    /* renamed from: a */
                    public final void mo9816a(String str, String str2, RetCode retCode) {
                        AppMethodBeat.m2504i(63566);
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", retCode);
                        wepkgDownloadProcessTask.cSY = str;
                        wepkgDownloadProcessTask.gSP = str2;
                        wepkgDownloadProcessTask.uXg = retCode;
                        if (c14805a2 != null) {
                            c14805a2.mo9822a(wepkgDownloadProcessTask);
                        }
                        AppMethodBeat.m2505o(63566);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(63567);
                    C148081 c148081 = new C148081();
                    if (i3 == 1) {
                        WePkgDownloader.dgx().mo56537a(str6, c148081);
                        AppMethodBeat.m2505o(63567);
                        return;
                    }
                    WePkgDownloader.dgx().mo56536a(i3, C5046bo.nullAsNil(str6), "", C5046bo.nullAsNil(str7), C5046bo.nullAsNil(str8), j2, C5046bo.nullAsNil(str9), "", C5046bo.nullAsNil(str10), i4, c148081);
                    AppMethodBeat.m2505o(63567);
                }
            });
            AppMethodBeat.m2505o(63583);
            return;
        }
        final C14805a c14805a3 = c14805a;
        wepkgDownloadProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(63568);
                if (c14805a3 != null) {
                    c14805a3.mo9822a(wepkgDownloadProcessTask);
                }
                wepkgDownloadProcessTask.aBW();
                AppMethodBeat.m2505o(63568);
            }
        };
        wepkgDownloadProcessTask.aBV();
        WepkgMainProcessService.m87655a(wepkgDownloadProcessTask);
        AppMethodBeat.m2505o(63583);
    }

    /* renamed from: a */
    public static void m69307a(bkj bkj, int i) {
        AppMethodBeat.m2504i(63584);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = 2002;
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.uWY;
        if (bkj != null) {
            wepkgVersion.eBS = bkj.mZV;
            cvr cvr = bkj.wNv;
            cvu cvu = bkj.wNw;
            if (cvr != null) {
                wepkgVersion.appId = cvr.fKh;
                cvo cvo = cvr.xrH;
                if (cvo != null) {
                    wepkgVersion.version = cvo.xrA;
                    wepkgVersion.uXG = cvo.xrB;
                    wepkgVersion.uXH = (long) cvo.xrC;
                    wepkgVersion.uXI = (long) cvo.xrD;
                }
            }
            if (cvu != null) {
                wepkgVersion.cSx = cvu.xrK;
                wepkgVersion.charset = cvu.xql;
                cvm cvm = cvu.xrL;
                if (cvm == null || cvm.xrx == null || C5046bo.isNullOrNil(cvm.xrx.vMJ)) {
                    wepkgVersion.uXM = true;
                } else {
                    wepkgVersion.cvZ = cvm.xrx.Md5;
                    wepkgVersion.downloadUrl = cvm.xrx.vMJ;
                    wepkgVersion.uXK = cvm.xrx.xrF;
                    wepkgVersion.uWQ = cvm.xrx.xrE;
                    wepkgVersion.uXM = false;
                }
                cvt cvt = cvu.xrM;
                if (cvt != null) {
                    wepkgVersion.uXO = cvt.xrJ;
                }
                if (cvt == null || C5046bo.m7548ek(cvt.xrI) || !cvt.xrJ) {
                    wepkgVersion.uXN = true;
                } else {
                    wepkgVersion.uXN = false;
                }
                wepkgVersion.uXP = 0;
            }
            wepkgVersion.cTb = i;
        }
        WePkgDiffInfo wePkgDiffInfo = wepkgCrossProcessTask.uXa;
        if (!(bkj == null || bkj.wNw == null || bkj.wNw.xrL == null || bkj.wNw.xrL.xrx == null || bkj.wNw.xrL.xrx.xrG == null || C5046bo.isNullOrNil(bkj.wNw.xrL.xrx.xrG.vMJ))) {
            cvs cvs = bkj.wNw.xrL.xrx.xrG;
            wePkgDiffInfo.version = bkj.wNv.xrH.xrA;
            wePkgDiffInfo.eBS = bkj.mZV;
            wePkgDiffInfo.downloadUrl = cvs.vMJ;
            wePkgDiffInfo.cvZ = cvs.Md5;
            wePkgDiffInfo.fileSize = cvs.xrF;
            wePkgDiffInfo.uWQ = cvs.xrE;
        }
        cvt cvt2 = bkj.wNw.xrM;
        if (!(cvt2 == null || C5046bo.m7548ek(cvt2.xrI))) {
            ArrayList arrayList = new ArrayList();
            Iterator it = cvt2.xrI.iterator();
            while (it.hasNext()) {
                cvq cvq = (cvq) it.next();
                WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                String str = bkj.mZV;
                String str2 = bkj.wNv.xrH.xrA;
                if (cvq != null) {
                    wepkgPreloadFile.key = C30022d.m47519hA(str, cvq.wjQ);
                    wepkgPreloadFile.eBS = str;
                    wepkgPreloadFile.version = str2;
                    wepkgPreloadFile.uXe = cvq.wjQ;
                    wepkgPreloadFile.mimeType = cvq.wjS;
                    cvp cvp = cvq.xrx;
                    if (cvp != null) {
                        wepkgPreloadFile.cvZ = cvp.Md5;
                        wepkgPreloadFile.downloadUrl = cvp.vMJ;
                        wepkgPreloadFile.size = cvp.xrF;
                        wepkgPreloadFile.uWQ = cvp.xrE;
                    }
                    wepkgPreloadFile.uXr = false;
                }
                arrayList.add(wepkgPreloadFile);
            }
            wepkgCrossProcessTask.uXc = arrayList;
        }
        if (C4996ah.bqo()) {
            wepkgCrossProcessTask.asP();
            AppMethodBeat.m2505o(63584);
            return;
        }
        WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
        AppMethodBeat.m2505o(63584);
    }

    public static List<WepkgPreloadFile> ahY(String str) {
        AppMethodBeat.m2504i(63585);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = WearableStatusCodes.DUPLICATE_LISTENER;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (C4996ah.bqo()) {
            wepkgCrossProcessTask.asP();
        } else {
            WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
        }
        List list = wepkgCrossProcessTask.uXc;
        AppMethodBeat.m2505o(63585);
        return list;
    }

    /* renamed from: a */
    public static void m69309a(String str, String str2, String str3, final C14805a c14805a) {
        AppMethodBeat.m2504i(63586);
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = WearableStatusCodes.UNKNOWN_LISTENER;
        wepkgCrossProcessTask.uXb.eBS = str;
        wepkgCrossProcessTask.uXb.uXe = str2;
        wepkgCrossProcessTask.uXb.filePath = str3;
        wepkgCrossProcessTask.uXb.uXr = false;
        if (C4996ah.bqo()) {
            C30022d.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(63569);
                    wepkgCrossProcessTask.asP();
                    if (c14805a != null) {
                        c14805a.mo9822a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.m2505o(63569);
                }
            });
            AppMethodBeat.m2505o(63586);
            return;
        }
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(63570);
                if (c14805a != null) {
                    c14805a.mo9822a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.m2505o(63570);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.m87655a(wepkgCrossProcessTask);
        AppMethodBeat.m2505o(63586);
    }

    public static void ahZ(String str) {
        AppMethodBeat.m2504i(63587);
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = 3003;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (C4996ah.bqo()) {
            C30022d.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(63571);
                    wepkgCrossProcessTask.asP();
                    AppMethodBeat.m2505o(63571);
                }
            });
            AppMethodBeat.m2505o(63587);
            return;
        }
        WepkgMainProcessService.m87655a(wepkgCrossProcessTask);
        AppMethodBeat.m2505o(63587);
    }

    public static List<WepkgPreloadFile> aia(String str) {
        AppMethodBeat.m2504i(63588);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = WearableStatusCodes.DATA_ITEM_TOO_LARGE;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (C4996ah.bqo()) {
            wepkgCrossProcessTask.asP();
        } else {
            WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
        }
        List list = wepkgCrossProcessTask.uXc;
        AppMethodBeat.m2505o(63588);
        return list;
    }

    public static void aib(String str) {
        AppMethodBeat.m2504i(63589);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = TXLiveConstants.PLAY_EVT_PLAY_END;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (C4996ah.bqo()) {
            wepkgCrossProcessTask.asP();
            AppMethodBeat.m2505o(63589);
            return;
        }
        WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
        AppMethodBeat.m2505o(63589);
    }
}
