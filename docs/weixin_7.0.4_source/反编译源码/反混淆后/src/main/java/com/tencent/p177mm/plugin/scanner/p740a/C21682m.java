package com.tencent.p177mm.plugin.scanner.p740a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarCodeDetectInfo;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.scanner.a.m */
public final class C21682m {
    public static int pZH = 0;
    public static int pZI = 1;
    public static int pZJ = 2;
    public static C21682m pZK = new C21682m();
    public float decodeScale;
    public int detectTime;
    private int pPD = -1;
    private long pZL = 0;
    public boolean pZM = false;
    public int pZN = 0;
    private long pZO = 0;
    private Point pZP = null;
    private String pZQ;
    private String pZR;
    private String pZS;
    private int pZT;
    private String pZU;
    private int pZV = 0;
    private int pZW;
    public int pZX = 0;
    private int pZY;
    private boolean pZZ = false;
    private int pyramidLv;
    public boolean qaa;
    public List<QBarCodeDetectInfo> qab;
    private int qac = 0;
    private int qad = 0;
    private Object qae = new Object();
    private int retryCount = 0;
    public String scaleList;
    public int srTime;

    public C21682m() {
        AppMethodBeat.m2504i(80861);
        AppMethodBeat.m2505o(80861);
    }

    static {
        AppMethodBeat.m2504i(80872);
        AppMethodBeat.m2505o(80872);
    }

    /* renamed from: jH */
    public final void mo37160jH(long j) {
        AppMethodBeat.m2504i(80862);
        C4990ab.m7417i("MicroMsg.QBarEngineReporter", "addScanTime: %s", Long.valueOf(j));
        this.pZL += j;
        AppMethodBeat.m2505o(80862);
    }

    public final void cgH() {
        AppMethodBeat.m2504i(80863);
        C4990ab.m7416i("MicroMsg.QBarEngineReporter", "markScanSuccess");
        this.pZM = true;
        AppMethodBeat.m2505o(80863);
    }

    public final void cgI() {
        AppMethodBeat.m2504i(80864);
        C4990ab.m7417i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", Integer.valueOf(this.pZN));
        this.pZN++;
        AppMethodBeat.m2505o(80864);
    }

    /* renamed from: BU */
    public final void mo37152BU(int i) {
        AppMethodBeat.m2504i(80865);
        C4990ab.m7417i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", Integer.valueOf(i));
        this.pPD = i;
        AppMethodBeat.m2505o(80865);
    }

    /* renamed from: fc */
    public final void mo37159fc(int i, int i2) {
        AppMethodBeat.m2504i(80866);
        C4990ab.m7417i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.pZP = new Point(i, i2);
        AppMethodBeat.m2505o(80866);
    }

    public final void cgJ() {
        AppMethodBeat.m2504i(80867);
        C4990ab.m7417i("MicroMsg.QBarEngineReporter", "addRetryTime, current retry count: %s", Integer.valueOf(this.retryCount));
        this.retryCount++;
        AppMethodBeat.m2505o(80867);
    }

    /* renamed from: jI */
    public final void mo37161jI(long j) {
        AppMethodBeat.m2504i(80868);
        C4990ab.m7417i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", Long.valueOf(j));
        this.pZO = j;
        AppMethodBeat.m2505o(80868);
    }

    /* renamed from: a */
    public final void mo37154a(String str, String str2, String str3, QBarReportMsg qBarReportMsg, int i, List<QBarReportMsg> list) {
        AppMethodBeat.m2504i(80869);
        this.pZQ = str;
        this.pZR = str2;
        this.pZS = str3;
        this.pZV = i;
        this.pZW = 0;
        if (qBarReportMsg != null) {
            this.pZT = qBarReportMsg.qrcodeVersion;
            this.pyramidLv = qBarReportMsg.pyramidLv;
            this.pZU = qBarReportMsg.binaryMethod;
            this.scaleList = qBarReportMsg.scaleList;
            this.decodeScale = qBarReportMsg.decodeScale;
            this.detectTime = qBarReportMsg.detectTime;
            this.srTime = qBarReportMsg.srTime;
        }
        this.qac = 0;
        this.qad = 0;
        for (QBarReportMsg qBarReportMsg2 : list) {
            if (qBarReportMsg2.inWhiteList) {
                this.qac++;
            } else if (qBarReportMsg2.inBlackList) {
                this.qad++;
            }
        }
        C4990ab.m7417i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", str, str2, str3, Integer.valueOf(this.pZT), Integer.valueOf(this.pyramidLv), this.pZU, Integer.valueOf(i), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.qac), Integer.valueOf(this.qad));
        AppMethodBeat.m2505o(80869);
    }

    /* renamed from: BV */
    public final void mo37153BV(int i) {
        if (this.pZY != 2) {
            this.pZY = i;
        }
    }

    public final void bHT() {
        AppMethodBeat.m2504i(80870);
        synchronized (this.qae) {
            try {
                if (this.pZZ) {
                    C4990ab.m7416i("MicroMsg.QBarEngineReporter", "doReport, already report");
                } else {
                    int i;
                    Object obj;
                    int i2;
                    String str = "MicroMsg.QBarEngineReporter";
                    String str2 = "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d";
                    Object[] objArr = new Object[16];
                    objArr[0] = Integer.valueOf(this.pZN);
                    objArr[1] = Long.valueOf(this.pZL);
                    objArr[2] = Long.valueOf(this.pZO);
                    objArr[3] = Integer.valueOf(this.pPD);
                    objArr[4] = this.pZP;
                    objArr[5] = Integer.valueOf(this.retryCount);
                    objArr[6] = Boolean.valueOf(this.pZM);
                    objArr[7] = this.pZQ;
                    objArr[8] = this.pZR;
                    objArr[9] = this.pZS;
                    objArr[10] = Integer.valueOf(this.pZT);
                    objArr[11] = Integer.valueOf(this.pyramidLv);
                    objArr[12] = this.pZU;
                    if (C5046bo.isNullOrNil(this.pZR)) {
                        i = 0;
                    } else {
                        i = this.pZR.length();
                    }
                    objArr[13] = Integer.valueOf(i);
                    objArr[14] = this.pZX;
                    objArr[15] = Integer.valueOf(this.pZY);
                    C4990ab.m7417i(str, str2, objArr);
                    String str3 = "";
                    if (this.pZP != null) {
                        obj = this.pZP.x + VideoMaterialUtil.CRAZYFACE_X + this.pZP.y;
                    } else {
                        String obj2 = str3;
                    }
                    str3 = "";
                    if (this.pZM || this.qab == null) {
                        str = str3;
                        i2 = 0;
                    } else {
                        i2 = this.qab.size();
                        C4990ab.m7417i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", Integer.valueOf(i2));
                        int i3 = 0;
                        str = str3;
                        for (QBarCodeDetectInfo qBarCodeDetectInfo : this.qab) {
                            if (i3 < this.qab.size() - 1) {
                                str3 = str + qBarCodeDetectInfo.prob + "|";
                            } else {
                                str3 = str + qBarCodeDetectInfo.prob;
                            }
                            i3++;
                            str = str3;
                        }
                    }
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr2 = new Object[29];
                    objArr2[0] = Integer.valueOf(this.pZN);
                    objArr2[1] = Long.valueOf(this.pZL);
                    objArr2[2] = Long.valueOf(this.pZO);
                    objArr2[3] = Integer.valueOf(this.pPD);
                    objArr2[4] = obj2;
                    objArr2[5] = Integer.valueOf(this.retryCount);
                    if (this.pZM) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    objArr2[6] = Integer.valueOf(i);
                    objArr2[7] = this.pZQ;
                    objArr2[8] = "";
                    objArr2[9] = this.pZS;
                    objArr2[10] = Integer.valueOf(this.pZT);
                    objArr2[11] = Integer.valueOf(this.pyramidLv);
                    objArr2[12] = this.pZU;
                    if (C5046bo.isNullOrNil(this.pZR)) {
                        i = 0;
                    } else {
                        i = this.pZR.length();
                    }
                    objArr2[13] = Integer.valueOf(i);
                    objArr2[14] = this.pZX;
                    objArr2[15] = Integer.valueOf(this.pZY);
                    objArr2[16] = Integer.valueOf(this.qaa ? 1 : 0);
                    objArr2[17] = Integer.valueOf(0);
                    objArr2[18] = QbarNative.getVersion();
                    objArr2[19] = Integer.valueOf(this.pZV);
                    objArr2[20] = Integer.valueOf(this.pZW);
                    objArr2[21] = Integer.valueOf(i2);
                    objArr2[22] = str;
                    objArr2[23] = this.scaleList;
                    objArr2[24] = Integer.valueOf((int) (this.decodeScale * 10.0f));
                    objArr2[25] = Integer.valueOf(this.detectTime);
                    objArr2[26] = Integer.valueOf(this.srTime);
                    objArr2[27] = Integer.valueOf(this.qac);
                    objArr2[28] = Integer.valueOf(this.qad);
                    c7060h.mo8381e(13233, objArr2);
                    this.pZZ = true;
                    AppMethodBeat.m2505o(80870);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(80870);
            }
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(80871);
        synchronized (this.qae) {
            try {
                this.pZL = 0;
                this.pZM = false;
                this.pZN = 0;
                this.pPD = -1;
                this.pZP = null;
                this.retryCount = 0;
                this.pZQ = "";
                this.pZR = "";
                this.pZS = "";
                this.pZT = 0;
                this.pyramidLv = 0;
                this.pZU = "";
                this.pZO = 0;
                this.pZZ = false;
                this.pZX = 0;
                this.pZY = 0;
                this.qaa = false;
                this.pZV = 0;
                this.pZW = 0;
                this.qab = null;
                this.scaleList = "";
                this.decodeScale = 0.0f;
                this.detectTime = 0;
                this.srTime = 0;
                this.qac = 0;
                this.qad = 0;
                C4990ab.m7416i("MicroMsg.QBarEngineReporter", "reset");
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(80871);
            }
        }
    }
}
