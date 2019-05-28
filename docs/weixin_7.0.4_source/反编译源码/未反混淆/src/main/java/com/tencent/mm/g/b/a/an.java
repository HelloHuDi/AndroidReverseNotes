package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class an extends a {
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

    public final an ft(String str) {
        AppMethodBeat.i(50543);
        this.cZu = t("VideoUrl", str, true);
        AppMethodBeat.o(50543);
        return this;
    }

    public final an fu(String str) {
        AppMethodBeat.i(50544);
        this.cVC = t("NewMd5", str, true);
        AppMethodBeat.o(50544);
        return this;
    }

    public final an bn(long j) {
        this.cVD = j;
        return this;
    }

    public final an bo(long j) {
        this.cVE = j;
        return this;
    }

    public final an bp(long j) {
        this.cVF = j;
        return this;
    }

    public final an bq(long j) {
        this.cVG = j;
        return this;
    }

    public final an br(long j) {
        this.cVH = j;
        return this;
    }

    public final an bs(long j) {
        this.cVI = j;
        return this;
    }

    public final an bt(long j) {
        this.cVJ = j;
        return this;
    }

    public final an bu(long j) {
        this.cVK = j;
        return this;
    }

    public final an bv(long j) {
        this.cVL = j;
        return this;
    }

    public final an fv(String str) {
        AppMethodBeat.i(50545);
        this.cVM = t("CDNIp", str, true);
        AppMethodBeat.o(50545);
        return this;
    }

    public final an bw(long j) {
        this.cVN = j;
        return this;
    }

    public final an bx(long j) {
        this.cVO = j;
        return this;
    }

    public final an by(long j) {
        this.cVP = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(50546);
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
        VX(str);
        AppMethodBeat.o(50546);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(50547);
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
        AppMethodBeat.o(50547);
        return stringBuffer2;
    }
}
