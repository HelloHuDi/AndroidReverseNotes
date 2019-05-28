package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bj extends a {
    public long cVT = 0;
    public long dcm = 0;
    public long dcn = 0;

    public final int getId() {
        return 15661;
    }

    public final String Fj() {
        AppMethodBeat.i(77616);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVT);
        stringBuffer.append(str);
        stringBuffer.append(this.dcm);
        stringBuffer.append(str);
        stringBuffer.append(this.dcn);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(77616);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(77617);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickScene:").append(this.cVT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ReportValue:").append(this.dcm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EntryScene:").append(this.dcn);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77617);
        return stringBuffer2;
    }
}
