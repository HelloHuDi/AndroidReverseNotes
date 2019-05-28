package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bm */
public final class C9505bm extends C46180a {
    public long cTJ = 0;
    public long cTL = 0;
    public long cVG = 0;
    public long cVH = 0;
    public long cVO = 0;
    public long cXC = 0;
    public long cXF = 0;
    private String cXL = "";
    public long cXN = 0;
    public long cXi = 0;
    public long cXj = 0;
    public long cXl = 0;
    public long cXo = 0;
    public long cXp = 0;
    public long cXz = 0;
    private String cZJ = "";
    public long dcA = 0;
    public long dcB = 0;
    public long dcC = 0;
    public long dcD = 0;
    public long dcE = 0;
    public long dcF = 0;
    public long dcG = 0;
    public long dcH = 0;
    public long dcI = 0;
    public long dcJ = 0;
    public long dcK = 0;
    public long dcL = 0;
    public long dcM = 0;
    public long dcN = 0;
    private String dcO = "";
    public long dcP = 0;
    public long dcQ = 0;
    public long dcR = 0;
    public long dcS = 0;
    public long dcr = 0;
    public long dcs = 0;
    public long dct = 0;
    public long dcu = 0;
    public long dcv = 0;
    public long dcw = 0;
    public long dcx = 0;
    private String dcy = "";
    private String dcz = "";

    public final int getId() {
        return 17000;
    }

    /* renamed from: gf */
    public final C9505bm mo20787gf(String str) {
        AppMethodBeat.m2504i(50551);
        this.cZJ = mo74169t("StoryId", str, true);
        AppMethodBeat.m2505o(50551);
        return this;
    }

    /* renamed from: dl */
    public final C9505bm mo20776dl(long j) {
        this.dcr = j;
        return this;
    }

    /* renamed from: dm */
    public final C9505bm mo20777dm(long j) {
        this.dcs = j;
        return this;
    }

    /* renamed from: dn */
    public final C9505bm mo20778dn(long j) {
        this.dct = j;
        return this;
    }

    /* renamed from: do */
    public final C9505bm mo20779do(long j) {
        this.cVG = j;
        return this;
    }

    /* renamed from: dp */
    public final C9505bm mo20780dp(long j) {
        this.dcu = j;
        return this;
    }

    /* renamed from: dq */
    public final C9505bm mo20781dq(long j) {
        this.cXi = j;
        return this;
    }

    /* renamed from: dr */
    public final C9505bm mo20782dr(long j) {
        this.cXF = j;
        return this;
    }

    /* renamed from: ds */
    public final C9505bm mo20783ds(long j) {
        this.dcx = j;
        return this;
    }

    /* renamed from: gg */
    public final C9505bm mo20788gg(String str) {
        AppMethodBeat.m2504i(50552);
        this.dcy = mo74169t("ErrorDescription", str, true);
        AppMethodBeat.m2505o(50552);
        return this;
    }

    /* renamed from: dt */
    public final C9505bm mo20784dt(long j) {
        this.cVH = j;
        return this;
    }

    /* renamed from: gh */
    public final C9505bm mo20789gh(String str) {
        AppMethodBeat.m2504i(50553);
        this.dcz = mo74169t("VideoFormat", str, true);
        AppMethodBeat.m2505o(50553);
        return this;
    }

    /* renamed from: gi */
    public final C9505bm mo20790gi(String str) {
        AppMethodBeat.m2504i(50554);
        this.dcO = mo74169t("Iplist", str, true);
        AppMethodBeat.m2505o(50554);
        return this;
    }

    /* renamed from: gj */
    public final C9505bm mo20791gj(String str) {
        AppMethodBeat.m2504i(50555);
        this.cXL = mo74169t("XClientIp", str, true);
        AppMethodBeat.m2505o(50555);
        return this;
    }

    /* renamed from: GV */
    public final C9505bm mo20774GV() {
        this.dcQ = 1;
        return this;
    }

    /* renamed from: du */
    public final C9505bm mo20785du(long j) {
        this.cTJ = j;
        return this;
    }

    /* renamed from: dv */
    public final C9505bm mo20786dv(long j) {
        this.dcR = j;
        return this;
    }

    /* renamed from: GW */
    public final long mo20775GW() {
        return this.dcR;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(50556);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cZJ);
        stringBuffer.append(str);
        stringBuffer.append(this.dcr);
        stringBuffer.append(str);
        stringBuffer.append(this.dcs);
        stringBuffer.append(str);
        stringBuffer.append(this.dct);
        stringBuffer.append(str);
        stringBuffer.append(this.cVG);
        stringBuffer.append(str);
        stringBuffer.append(this.dcu);
        stringBuffer.append(str);
        stringBuffer.append(this.cXi);
        stringBuffer.append(str);
        stringBuffer.append(this.cXj);
        stringBuffer.append(str);
        stringBuffer.append(this.dcv);
        stringBuffer.append(str);
        stringBuffer.append(this.cXl);
        stringBuffer.append(str);
        stringBuffer.append(this.dcw);
        stringBuffer.append(str);
        stringBuffer.append(this.cXF);
        stringBuffer.append(str);
        stringBuffer.append(this.dcx);
        stringBuffer.append(str);
        stringBuffer.append(this.dcy);
        stringBuffer.append(str);
        stringBuffer.append(this.cVH);
        stringBuffer.append(str);
        stringBuffer.append(this.dcz);
        stringBuffer.append(str);
        stringBuffer.append(this.cTL);
        stringBuffer.append(str);
        stringBuffer.append(this.dcA);
        stringBuffer.append(str);
        stringBuffer.append(this.cXo);
        stringBuffer.append(str);
        stringBuffer.append(this.cXp);
        stringBuffer.append(str);
        stringBuffer.append(this.dcB);
        stringBuffer.append(str);
        stringBuffer.append(this.dcC);
        stringBuffer.append(str);
        stringBuffer.append(this.dcD);
        stringBuffer.append(str);
        stringBuffer.append(this.dcE);
        stringBuffer.append(str);
        stringBuffer.append(this.cXC);
        stringBuffer.append(str);
        stringBuffer.append(this.dcF);
        stringBuffer.append(str);
        stringBuffer.append(this.dcG);
        stringBuffer.append(str);
        stringBuffer.append(this.dcH);
        stringBuffer.append(str);
        stringBuffer.append(this.dcI);
        stringBuffer.append(str);
        stringBuffer.append(this.dcJ);
        stringBuffer.append(str);
        stringBuffer.append(this.dcK);
        stringBuffer.append(str);
        stringBuffer.append(this.dcL);
        stringBuffer.append(str);
        stringBuffer.append(this.dcM);
        stringBuffer.append(str);
        stringBuffer.append(this.dcN);
        stringBuffer.append(str);
        stringBuffer.append(this.cXz);
        stringBuffer.append(str);
        stringBuffer.append(this.dcO);
        stringBuffer.append(str);
        stringBuffer.append(this.cXL);
        stringBuffer.append(str);
        stringBuffer.append(this.dcP);
        stringBuffer.append(str);
        stringBuffer.append(this.cXN);
        stringBuffer.append(str);
        stringBuffer.append(this.dcQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cTJ);
        stringBuffer.append(str);
        stringBuffer.append(this.dcR);
        stringBuffer.append(str);
        stringBuffer.append(this.cVO);
        stringBuffer.append(str);
        stringBuffer.append(this.dcS);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(50556);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(50557);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StoryId:").append(this.cZJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PlayScene:").append(this.dcr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FirstPlayVideo:").append(this.dcs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FirstOnePlay:").append(this.dct);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoDuration:").append(this.cVG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PlayedDuration:").append(this.dcu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FirstPlayWaitTime:").append(this.cXi);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MoovWaitTime:").append(this.cXj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("BufferCount:").append(this.dcv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("RegainAvgTime:").append(this.cXl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StalledCount:").append(this.dcw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UiStayTime:").append(this.cXF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PlayErrorCode:").append(this.dcx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ErrorDescription:").append(this.dcy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoBitrate:").append(this.cVH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoFormat:").append(this.dcz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FileSize:").append(this.cTL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("RecvedBytes:").append(this.dcA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartDownloadTime:").append(this.cXo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EndDownloadTime:").append(this.cXp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ErrorCode:").append(this.dcB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnQueueTime:").append(this.dcC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MoovRequestTimes:").append(this.dcD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MoovCost:").append(this.dcE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MoovSize:").append(this.cXC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MoovCompleted:").append(this.dcF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MoovFailReason:").append(this.dcG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FirstConnectCost:").append(this.dcH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FirstRequestCost:").append(this.dcI);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FirstRequestSize:").append(this.dcJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FirstRequestDownloadSize:").append(this.dcK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FirstRequestCompleted:").append(this.dcL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AverageSpeed:").append(this.dcM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AverageConnectCost:").append(this.dcN);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetConnectTimes:").append(this.cXz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Iplist:").append(this.dcO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("XClientIp:").append(this.cXL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsCrossNet:").append(this.dcP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MoovPosition:").append(this.cXN);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PlayerMode:").append(this.dcQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetType:").append(this.cTJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnterPreviewTime:").append(this.dcR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HadPreloadSize:").append(this.cVO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ShowLoadingCount:").append(this.dcS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(50557);
        return stringBuffer2;
    }
}
