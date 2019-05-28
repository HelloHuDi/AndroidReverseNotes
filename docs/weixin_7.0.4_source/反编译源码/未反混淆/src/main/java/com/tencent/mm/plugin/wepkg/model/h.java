package com.tencent.mm.plugin.wepkg.model;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.cvs;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h {

    /* renamed from: com.tencent.mm.plugin.wepkg.model.h$12 */
    static class AnonymousClass12 implements Runnable {
        final /* synthetic */ a uXt;
        final /* synthetic */ WepkgCrossProcessTask uXy;

        AnonymousClass12(a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.uXt = aVar;
            this.uXy = wepkgCrossProcessTask;
        }

        public final void run() {
            AppMethodBeat.i(63578);
            if (this.uXt != null) {
                this.uXt.a(this.uXy);
            }
            this.uXy.aBW();
            AppMethodBeat.o(63578);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.h$11 */
    static class AnonymousClass11 implements Runnable {
        final /* synthetic */ a uXt;
        final /* synthetic */ WepkgCrossProcessTask uXy;

        AnonymousClass11(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
            this.uXy = wepkgCrossProcessTask;
            this.uXt = aVar;
        }

        public final void run() {
            AppMethodBeat.i(63577);
            this.uXy.asP();
            if (this.uXt != null) {
                this.uXt.a(this.uXy);
            }
            AppMethodBeat.o(63577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.h$6 */
    public static class AnonymousClass6 implements Runnable {
        final /* synthetic */ a uXt = null;
        final /* synthetic */ WepkgCrossProcessTask uXy;

        public AnonymousClass6(WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.uXy = wepkgCrossProcessTask;
        }

        public final void run() {
            AppMethodBeat.i(63572);
            this.uXy.asP();
            if (this.uXt != null) {
                this.uXt.a(this.uXy);
            }
            AppMethodBeat.o(63572);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.h$7 */
    public static class AnonymousClass7 implements Runnable {
        final /* synthetic */ a uXt = null;
        final /* synthetic */ WepkgCrossProcessTask uXy;

        public AnonymousClass7(WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.uXy = wepkgCrossProcessTask;
        }

        public final void run() {
            AppMethodBeat.i(63573);
            if (this.uXt != null) {
                this.uXt.a(this.uXy);
            }
            this.uXy.aBW();
            AppMethodBeat.o(63573);
        }
    }

    public static WepkgVersion ahW(String str) {
        AppMethodBeat.i(63579);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = 3001;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (ah.bqo()) {
            wepkgCrossProcessTask.asP();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.uWY == null) {
            AppMethodBeat.o(63579);
            return null;
        }
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.uWY;
        AppMethodBeat.o(63579);
        return wepkgVersion;
    }

    public static WepkgVersion ahX(String str) {
        AppMethodBeat.i(63580);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = 3002;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (ah.bqo()) {
            wepkgCrossProcessTask.asP();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.uWY == null) {
            AppMethodBeat.o(63580);
            return null;
        }
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.uWY;
        AppMethodBeat.o(63580);
        return wepkgVersion;
    }

    public static void a(String str, final a aVar) {
        AppMethodBeat.i(63581);
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = 3002;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (ah.bqo()) {
            wepkgCrossProcessTask.asP();
            AppMethodBeat.o(63581);
            return;
        }
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(63574);
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.o(63574);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(63581);
    }

    public static void a(String str, String str2, boolean z, final a aVar) {
        AppMethodBeat.i(63582);
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = 3005;
        wepkgCrossProcessTask.uWY.eBS = str;
        wepkgCrossProcessTask.uWY.gSP = str2;
        wepkgCrossProcessTask.uWY.uXM = z;
        if (ah.bqo()) {
            d.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(63575);
                    wepkgCrossProcessTask.asP();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.o(63575);
                }
            });
            AppMethodBeat.o(63582);
            return;
        }
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(63576);
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.o(63576);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(63582);
    }

    public static void a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, a aVar) {
        AppMethodBeat.i(63583);
        final WepkgMainProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask();
        wepkgDownloadProcessTask.fileType = i;
        wepkgDownloadProcessTask.cSY = str;
        wepkgDownloadProcessTask.downloadUrl = str3;
        wepkgDownloadProcessTask.uXf = j;
        wepkgDownloadProcessTask.version = str4;
        wepkgDownloadProcessTask.cvZ = str5;
        wepkgDownloadProcessTask.uWQ = i2;
        if (ah.bqo()) {
            final a aVar2 = aVar;
            final int i3 = i;
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final long j2 = j;
            final String str9 = str4;
            final String str10 = str5;
            final int i4 = i2;
            d.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(63567);
                    AnonymousClass1 anonymousClass1 = new IWepkgUpdateCallback() {
                        public final void a(String str, String str2, RetCode retCode) {
                            AppMethodBeat.i(63566);
                            ab.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", retCode);
                            wepkgDownloadProcessTask.cSY = str;
                            wepkgDownloadProcessTask.gSP = str2;
                            wepkgDownloadProcessTask.uXg = retCode;
                            if (aVar2 != null) {
                                aVar2.a(wepkgDownloadProcessTask);
                            }
                            AppMethodBeat.o(63566);
                        }
                    };
                    if (i3 == 1) {
                        WePkgDownloader.dgx().a(str6, anonymousClass1);
                        AppMethodBeat.o(63567);
                        return;
                    }
                    WePkgDownloader.dgx().a(i3, bo.nullAsNil(str6), "", bo.nullAsNil(str7), bo.nullAsNil(str8), j2, bo.nullAsNil(str9), "", bo.nullAsNil(str10), i4, anonymousClass1);
                    AppMethodBeat.o(63567);
                }
            });
            AppMethodBeat.o(63583);
            return;
        }
        final a aVar3 = aVar;
        wepkgDownloadProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(63568);
                if (aVar3 != null) {
                    aVar3.a(wepkgDownloadProcessTask);
                }
                wepkgDownloadProcessTask.aBW();
                AppMethodBeat.o(63568);
            }
        };
        wepkgDownloadProcessTask.aBV();
        WepkgMainProcessService.a(wepkgDownloadProcessTask);
        AppMethodBeat.o(63583);
    }

    public static void a(bkj bkj, int i) {
        AppMethodBeat.i(63584);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = 2002;
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
                if (cvm == null || cvm.xrx == null || bo.isNullOrNil(cvm.xrx.vMJ)) {
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
                if (cvt == null || bo.ek(cvt.xrI) || !cvt.xrJ) {
                    wepkgVersion.uXN = true;
                } else {
                    wepkgVersion.uXN = false;
                }
                wepkgVersion.uXP = 0;
            }
            wepkgVersion.cTb = i;
        }
        WePkgDiffInfo wePkgDiffInfo = wepkgCrossProcessTask.uXa;
        if (!(bkj == null || bkj.wNw == null || bkj.wNw.xrL == null || bkj.wNw.xrL.xrx == null || bkj.wNw.xrL.xrx.xrG == null || bo.isNullOrNil(bkj.wNw.xrL.xrx.xrG.vMJ))) {
            cvs cvs = bkj.wNw.xrL.xrx.xrG;
            wePkgDiffInfo.version = bkj.wNv.xrH.xrA;
            wePkgDiffInfo.eBS = bkj.mZV;
            wePkgDiffInfo.downloadUrl = cvs.vMJ;
            wePkgDiffInfo.cvZ = cvs.Md5;
            wePkgDiffInfo.fileSize = cvs.xrF;
            wePkgDiffInfo.uWQ = cvs.xrE;
        }
        cvt cvt2 = bkj.wNw.xrM;
        if (!(cvt2 == null || bo.ek(cvt2.xrI))) {
            ArrayList arrayList = new ArrayList();
            Iterator it = cvt2.xrI.iterator();
            while (it.hasNext()) {
                cvq cvq = (cvq) it.next();
                WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                String str = bkj.mZV;
                String str2 = bkj.wNv.xrH.xrA;
                if (cvq != null) {
                    wepkgPreloadFile.key = d.hA(str, cvq.wjQ);
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
        if (ah.bqo()) {
            wepkgCrossProcessTask.asP();
            AppMethodBeat.o(63584);
            return;
        }
        WepkgMainProcessService.b(wepkgCrossProcessTask);
        AppMethodBeat.o(63584);
    }

    public static List<WepkgPreloadFile> ahY(String str) {
        AppMethodBeat.i(63585);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = WearableStatusCodes.DUPLICATE_LISTENER;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (ah.bqo()) {
            wepkgCrossProcessTask.asP();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        List list = wepkgCrossProcessTask.uXc;
        AppMethodBeat.o(63585);
        return list;
    }

    public static void a(String str, String str2, String str3, final a aVar) {
        AppMethodBeat.i(63586);
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = WearableStatusCodes.UNKNOWN_LISTENER;
        wepkgCrossProcessTask.uXb.eBS = str;
        wepkgCrossProcessTask.uXb.uXe = str2;
        wepkgCrossProcessTask.uXb.filePath = str3;
        wepkgCrossProcessTask.uXb.uXr = false;
        if (ah.bqo()) {
            d.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(63569);
                    wepkgCrossProcessTask.asP();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.o(63569);
                }
            });
            AppMethodBeat.o(63586);
            return;
        }
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(63570);
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.o(63570);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(63586);
    }

    public static void ahZ(String str) {
        AppMethodBeat.i(63587);
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = 3003;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (ah.bqo()) {
            d.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(63571);
                    wepkgCrossProcessTask.asP();
                    AppMethodBeat.o(63571);
                }
            });
            AppMethodBeat.o(63587);
            return;
        }
        WepkgMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(63587);
    }

    public static List<WepkgPreloadFile> aia(String str) {
        AppMethodBeat.i(63588);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = WearableStatusCodes.DATA_ITEM_TOO_LARGE;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (ah.bqo()) {
            wepkgCrossProcessTask.asP();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        List list = wepkgCrossProcessTask.uXc;
        AppMethodBeat.o(63588);
        return list;
    }

    public static void aib(String str) {
        AppMethodBeat.i(63589);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = TXLiveConstants.PLAY_EVT_PLAY_END;
        wepkgCrossProcessTask.uWY.eBS = str;
        if (ah.bqo()) {
            wepkgCrossProcessTask.asP();
            AppMethodBeat.o(63589);
            return;
        }
        WepkgMainProcessService.b(wepkgCrossProcessTask);
        AppMethodBeat.o(63589);
    }
}
