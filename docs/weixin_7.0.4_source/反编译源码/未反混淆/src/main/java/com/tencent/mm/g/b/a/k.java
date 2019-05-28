package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class k extends a {
    public long cVR = 0;
    public long cVS = 0;

    public final int getId() {
        return 17055;
    }

    public final String Fj() {
        AppMethodBeat.i(138603);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(",");
        stringBuffer.append(this.cVS);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(138603);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(138604);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(138604);
        return stringBuffer2;
    }
}
