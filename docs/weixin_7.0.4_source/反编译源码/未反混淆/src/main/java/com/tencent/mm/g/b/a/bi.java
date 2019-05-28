package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bi extends a {
    public long dck = 0;
    public long dcl = 0;

    public final int getId() {
        return 15522;
    }

    public final String Fj() {
        AppMethodBeat.i(56602);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dck);
        stringBuffer.append(",");
        stringBuffer.append(this.dcl);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(56602);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(56603);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.dck);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ResetScece:").append(this.dcl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(56603);
        return stringBuffer2;
    }
}
