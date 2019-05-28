package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bk extends a {
    public long cVR = 0;
    public long dco = 0;

    public final int getId() {
        return 15509;
    }

    public final String Fj() {
        AppMethodBeat.i(80736);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(",");
        stringBuffer.append(this.dco);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(80736);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(80737);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CostTime:").append(this.dco);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(80737);
        return stringBuffer2;
    }
}
