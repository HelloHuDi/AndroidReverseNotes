package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class l extends a {
    public long cVT = 0;

    public final int getId() {
        return 16722;
    }

    public final String Fk() {
        AppMethodBeat.i(77583);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickScene:").append(this.cVT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77583);
        return stringBuffer2;
    }

    public final String Fj() {
        AppMethodBeat.i(77582);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVT);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(77582);
        return stringBuffer2;
    }
}
