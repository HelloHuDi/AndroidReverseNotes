package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ak extends a {
    private long cWY = 0;
    private long cYS = 0;
    private long cYT = 0;
    private long cYU = 0;
    private String cYV;
    private String cYW;

    public final int getId() {
        return 16688;
    }

    public final ak aT(long j) {
        this.cYS = j;
        return this;
    }

    public final long Ft() {
        return this.cYS;
    }

    public final ak aU(long j) {
        this.cYT = j;
        return this;
    }

    public final ak aV(long j) {
        this.cWY = j;
        return this;
    }

    public final long Fu() {
        return this.cWY;
    }

    public final ak aW(long j) {
        this.cYU = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108839);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYS);
        stringBuffer.append(str);
        stringBuffer.append(this.cYT);
        stringBuffer.append(str);
        stringBuffer.append(this.cWY);
        stringBuffer.append(str);
        stringBuffer.append(this.cYU);
        stringBuffer.append(str);
        stringBuffer.append(this.cYV);
        stringBuffer.append(str);
        stringBuffer.append(this.cYW);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108839);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108840);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ComposeTime:").append(this.cYS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ComposeErrorType:").append(this.cYT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadTime:").append(this.cWY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadErrorType:").append(this.cYU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ComposeErrorTypeStr:").append(this.cYV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadErrorTypeStr:").append(this.cYW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108840);
        return stringBuffer2;
    }
}
