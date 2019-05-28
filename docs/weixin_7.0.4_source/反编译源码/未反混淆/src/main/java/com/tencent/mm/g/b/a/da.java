package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class da extends a {
    private String cYv = "";
    public long diB = 0;
    private String diC = "";
    private String diD = "";
    public long diE = 0;
    public long diF = 0;
    public long diG = 0;
    public long diH = 0;

    public final int getId() {
        return 15778;
    }

    public final da ib(String str) {
        AppMethodBeat.i(91295);
        this.cYv = t("appid", str, true);
        AppMethodBeat.o(91295);
        return this;
    }

    public final da ic(String str) {
        AppMethodBeat.i(91296);
        this.diC = t("pkgMd5", str, true);
        AppMethodBeat.o(91296);
        return this;
    }

    public final da ie(String str) {
        AppMethodBeat.i(91297);
        this.diD = t("downloadUrl", str, true);
        AppMethodBeat.o(91297);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91298);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.diB);
        stringBuffer.append(str);
        stringBuffer.append(this.diC);
        stringBuffer.append(str);
        stringBuffer.append(this.diD);
        stringBuffer.append(str);
        stringBuffer.append(this.diE);
        stringBuffer.append(str);
        stringBuffer.append(this.diF);
        stringBuffer.append(str);
        stringBuffer.append(this.diG);
        stringBuffer.append(str);
        stringBuffer.append(this.diH);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(91298);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(91299);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appVersion:").append(this.diB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("pkgMd5:").append(this.diC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("downloadUrl:").append(this.diD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isSuccess:").append(this.diE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timeCostInMs:").append(this.diF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timeStampInMs:").append(this.diG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("totalLen:").append(this.diH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91299);
        return stringBuffer2;
    }
}
