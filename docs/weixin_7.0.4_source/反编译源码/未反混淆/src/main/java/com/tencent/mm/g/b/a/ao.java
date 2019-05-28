package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ao extends a {
    private long cZv = 0;
    private long cZw = 0;
    private long cZx = 0;
    private long cZy = 0;

    public final int getId() {
        return 16913;
    }

    public final ao bz(long j) {
        this.cZv = j;
        return this;
    }

    public final ao bA(long j) {
        this.cZw = j;
        return this;
    }

    public final long Fz() {
        return this.cZw;
    }

    public final ao bB(long j) {
        this.cZx = j;
        return this;
    }

    public final long FA() {
        return this.cZx;
    }

    public final ao bC(long j) {
        this.cZy = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108852);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cZv);
        stringBuffer.append(str);
        stringBuffer.append(this.cZw);
        stringBuffer.append(str);
        stringBuffer.append(this.cZx);
        stringBuffer.append(str);
        stringBuffer.append(this.cZy);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108852);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108853);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExposeViewId:").append(this.cZv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickClearCount:").append(this.cZw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickRenewCount:").append(this.cZx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IfDeleteVideo:").append(this.cZy);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108853);
        return stringBuffer2;
    }
}
