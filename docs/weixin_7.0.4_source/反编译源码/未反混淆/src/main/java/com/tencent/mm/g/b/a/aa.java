package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aa extends a {
    public long cVT = 0;

    public final int getId() {
        return 16867;
    }

    public final String Fk() {
        AppMethodBeat.i(77603);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickScene:").append(this.cVT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77603);
        return stringBuffer2;
    }

    public final String Fj() {
        AppMethodBeat.i(77602);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVT);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(77602);
        return stringBuffer2;
    }
}
