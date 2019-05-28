package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ay extends a {
    private long cWv = 0;
    private long cWw = 0;
    private long cWz = 0;
    private String cZt = "";
    private long daA = 0;
    private long daB = 0;
    private long daC = 0;
    private long daD = 0;
    private long daE = 0;
    private long daF = 0;
    private long daG = 0;
    private long daH = 0;
    private long daI = 0;
    private long daJ = 0;
    private long daK = 0;
    private long daL = 0;
    private long daM = 0;
    private long daN = 0;
    private String daw = "";
    private String dax = "";
    private long day = 0;
    private long daz = 0;

    public final int getId() {
        return 16664;
    }

    public final ay fO(String str) {
        AppMethodBeat.i(108882);
        this.daw = t("FileUrl", str, true);
        AppMethodBeat.o(108882);
        return this;
    }

    public final String Gc() {
        return this.daw;
    }

    public final ay fP(String str) {
        AppMethodBeat.i(108883);
        this.dax = t("VideoMd5", str, true);
        AppMethodBeat.o(108883);
        return this;
    }

    public final String Gd() {
        return this.dax;
    }

    public final ay fQ(String str) {
        AppMethodBeat.i(108884);
        this.cZt = t("Tid", str, true);
        AppMethodBeat.o(108884);
        return this;
    }

    public final String Ge() {
        return this.cZt;
    }

    public final ay co(long j) {
        this.day = j;
        return this;
    }

    public final long Gf() {
        return this.day;
    }

    public final ay cp(long j) {
        this.daz = j;
        return this;
    }

    public final long Gg() {
        return this.daz;
    }

    public final ay cq(long j) {
        this.cWz = j;
        return this;
    }

    public final long Gh() {
        return this.cWz;
    }

    public final ay cr(long j) {
        this.daA = j;
        return this;
    }

    public final long Gi() {
        return this.daA;
    }

    public final ay cs(long j) {
        this.daB = j;
        return this;
    }

    public final long Gj() {
        return this.daB;
    }

    public final ay ct(long j) {
        this.daC = j;
        return this;
    }

    public final ay cu(long j) {
        this.daD = j;
        return this;
    }

    public final long Gk() {
        return this.daD;
    }

    public final ay cv(long j) {
        this.cWv = j;
        return this;
    }

    public final long Gl() {
        return this.cWv;
    }

    public final ay cw(long j) {
        this.cWw = j;
        return this;
    }

    public final long Gm() {
        return this.cWw;
    }

    public final ay cx(long j) {
        this.daE = j;
        return this;
    }

    public final long Gn() {
        return this.daE;
    }

    public final ay cy(long j) {
        this.daF = j;
        return this;
    }

    public final long Go() {
        return this.daF;
    }

    public final ay cz(long j) {
        this.daG = j;
        return this;
    }

    public final long Gp() {
        return this.daG;
    }

    public final ay cA(long j) {
        this.daH = j;
        return this;
    }

    public final ay cB(long j) {
        this.daI = j;
        return this;
    }

    public final long Gq() {
        return this.daI;
    }

    public final ay cC(long j) {
        this.daJ = j;
        return this;
    }

    public final long Gr() {
        return this.daJ;
    }

    public final ay cD(long j) {
        this.daK = j;
        return this;
    }

    public final long Gs() {
        return this.daK;
    }

    public final ay cE(long j) {
        this.daL = j;
        return this;
    }

    public final long Gt() {
        return this.daL;
    }

    public final ay cF(long j) {
        this.daM = j;
        return this;
    }

    public final long Gu() {
        return this.daM;
    }

    public final ay cG(long j) {
        this.daN = j;
        return this;
    }

    public final long Gv() {
        return this.daN;
    }

    public final String Fj() {
        AppMethodBeat.i(108885);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.daw);
        stringBuffer.append(str);
        stringBuffer.append(this.dax);
        stringBuffer.append(str);
        stringBuffer.append(this.cZt);
        stringBuffer.append(str);
        stringBuffer.append(this.day);
        stringBuffer.append(str);
        stringBuffer.append(this.daz);
        stringBuffer.append(str);
        stringBuffer.append(this.cWz);
        stringBuffer.append(str);
        stringBuffer.append(this.daA);
        stringBuffer.append(str);
        stringBuffer.append(this.daB);
        stringBuffer.append(str);
        stringBuffer.append(this.daC);
        stringBuffer.append(str);
        stringBuffer.append(this.daD);
        stringBuffer.append(str);
        stringBuffer.append(this.cWv);
        stringBuffer.append(str);
        stringBuffer.append(this.cWw);
        stringBuffer.append(str);
        stringBuffer.append(this.daE);
        stringBuffer.append(str);
        stringBuffer.append(this.daF);
        stringBuffer.append(str);
        stringBuffer.append(this.daG);
        stringBuffer.append(str);
        stringBuffer.append(this.daH);
        stringBuffer.append(str);
        stringBuffer.append(this.daI);
        stringBuffer.append(str);
        stringBuffer.append(this.daJ);
        stringBuffer.append(str);
        stringBuffer.append(this.daK);
        stringBuffer.append(str);
        stringBuffer.append(this.daL);
        stringBuffer.append(str);
        stringBuffer.append(this.daM);
        stringBuffer.append(str);
        stringBuffer.append(this.daN);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108885);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108886);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FileUrl:").append(this.daw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoMd5:").append(this.dax);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Tid:").append(this.cZt);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadStartTime:").append(this.day);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadEndTime:").append(this.daz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginSize:").append(this.cWz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginDuration:").append(this.daA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginVideoBitrate:").append(this.daB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginAudioBitrate:").append(this.daC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginFps:").append(this.daD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginWidth:").append(this.cWv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginHeight:").append(this.cWw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CPSize:").append(this.daE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CPDuration:").append(this.daF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CPVideoBitrate:").append(this.daG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CPAudioBitrate:").append(this.daH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CPFps:").append(this.daI);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CPWidth:").append(this.daJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CPHight:").append(this.daK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SendSource:").append(this.daL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OriginAudioChannel:").append(this.daM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetWorkType:").append(this.daN);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108886);
        return stringBuffer2;
    }
}
