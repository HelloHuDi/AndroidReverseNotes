package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bb extends a {
    public long cVR = 0;
    public long cVS = 0;
    public long daS = 0;

    public final int getId() {
        return 16440;
    }

    public final String Fj() {
        AppMethodBeat.i(77607);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.cVS);
        stringBuffer.append(str);
        stringBuffer.append(this.daS);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(77607);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(77608);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Status:").append(this.daS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77608);
        return stringBuffer2;
    }
}
