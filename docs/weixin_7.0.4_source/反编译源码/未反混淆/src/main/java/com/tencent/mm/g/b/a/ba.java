package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ba extends a {
    public long cVS = 0;
    public long daR = 0;

    public final int getId() {
        return 16996;
    }

    public final String Fj() {
        AppMethodBeat.i(73676);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.daR);
        stringBuffer.append(",");
        stringBuffer.append(this.cVS);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(73676);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(73677);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ThirdAppType:").append(this.daR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(73677);
        return stringBuffer2;
    }
}
