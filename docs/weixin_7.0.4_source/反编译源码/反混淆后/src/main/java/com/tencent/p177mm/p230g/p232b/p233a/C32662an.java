package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.an */
public final class C32662an extends C46180a {
    private String cVC = "";
    public long cVD = 0;
    public long cVE = 0;
    public long cVF = 0;
    public long cVG = 0;
    public long cVH = 0;
    public long cVI = 0;
    public long cVJ = 0;
    public long cVK = 0;
    public long cVL = 0;
    private String cVM = "";
    public long cVN = 0;
    public long cVO = 0;
    public long cVP = 0;
    private String cZt = "";
    private String cZu = "";

    public final int getId() {
        return 16665;
    }

    /* renamed from: ft */
    public final C32662an mo53164ft(String str) {
        AppMethodBeat.m2504i(50543);
        this.cZu = mo74169t("VideoUrl", str, true);
        AppMethodBeat.m2505o(50543);
        return this;
    }

    /* renamed from: fu */
    public final C32662an mo53165fu(String str) {
        AppMethodBeat.m2504i(50544);
        this.cVC = mo74169t("NewMd5", str, true);
        AppMethodBeat.m2505o(50544);
        return this;
    }

    /* renamed from: bn */
    public final C32662an mo53152bn(long j) {
        this.cVD = j;
        return this;
    }

    /* renamed from: bo */
    public final C32662an mo53153bo(long j) {
        this.cVE = j;
        return this;
    }

    /* renamed from: bp */
    public final C32662an mo53154bp(long j) {
        this.cVF = j;
        return this;
    }

    /* renamed from: bq */
    public final C32662an mo53155bq(long j) {
        this.cVG = j;
        return this;
    }

    /* renamed from: br */
    public final C32662an mo53156br(long j) {
        this.cVH = j;
        return this;
    }

    /* renamed from: bs */
    public final C32662an mo53157bs(long j) {
        this.cVI = j;
        return this;
    }

    /* renamed from: bt */
    public final C32662an mo53158bt(long j) {
        this.cVJ = j;
        return this;
    }

    /* renamed from: bu */
    public final C32662an mo53159bu(long j) {
        this.cVK = j;
        return this;
    }

    /* renamed from: bv */
    public final C32662an mo53160bv(long j) {
        this.cVL = j;
        return this;
    }

    /* renamed from: fv */
    public final C32662an mo53166fv(String str) {
        AppMethodBeat.m2504i(50545);
        this.cVM = mo74169t("CDNIp", str, true);
        AppMethodBeat.m2505o(50545);
        return this;
    }

    /* renamed from: bw */
    public final C32662an mo53161bw(long j) {
        this.cVN = j;
        return this;
    }

    /* renamed from: bx */
    public final C32662an mo53162bx(long j) {
        this.cVO = j;
        return this;
    }

    /* renamed from: by */
    public final C32662an mo53163by(long j) {
        this.cVP = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(50546);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cZt);
        stringBuffer.append(str);
        stringBuffer.append(this.cZu);
        stringBuffer.append(str);
        stringBuffer.append(this.cVC);
        stringBuffer.append(str);
        stringBuffer.append(this.cVD);
        stringBuffer.append(str);
        stringBuffer.append(this.cVE);
        stringBuffer.append(str);
        stringBuffer.append(this.cVF);
        stringBuffer.append(str);
        stringBuffer.append(this.cVG);
        stringBuffer.append(str);
        stringBuffer.append(this.cVH);
        stringBuffer.append(str);
        stringBuffer.append(this.cVI);
        stringBuffer.append(str);
        stringBuffer.append(this.cVJ);
        stringBuffer.append(str);
        stringBuffer.append(this.cVK);
        stringBuffer.append(str);
        stringBuffer.append(this.cVL);
        stringBuffer.append(str);
        stringBuffer.append(this.cVM);
        stringBuffer.append(str);
        stringBuffer.append(this.cVN);
        stringBuffer.append(str);
        stringBuffer.append(this.cVO);
        stringBuffer.append(str);
        stringBuffer.append(this.cVP);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(50546);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(50547);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Tid:").append(this.cZt);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoUrl:").append(this.cZu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NewMd5:").append(this.cVC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownloadStartTime:").append(this.cVD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownloadEndTime:").append(this.cVE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoSize:").append(this.cVF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoDuration:").append(this.cVG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoBitrate:").append(this.cVH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AudioBitrate:").append(this.cVI);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoFps:").append(this.cVJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoWidth:").append(this.cVK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoHeight:").append(this.cVL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CDNIp:").append(this.cVM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginalAudioChannel:").append(this.cVN);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HadPreloadSize:").append(this.cVO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HadPreloadCompletion:").append(this.cVP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(50547);
        return stringBuffer2;
    }
}
