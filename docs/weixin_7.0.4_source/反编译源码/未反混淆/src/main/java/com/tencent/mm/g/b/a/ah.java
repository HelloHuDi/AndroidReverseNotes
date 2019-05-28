package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ah extends a {
    private String cWo = "";
    private long cYI = 0;

    public final int getId() {
        return 15988;
    }

    public final ah fk(String str) {
        AppMethodBeat.i(35564);
        this.cWo = t("SessionId", str, true);
        AppMethodBeat.o(35564);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(35566);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWo);
        stringBuffer.append(",");
        stringBuffer.append(this.cYI);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(35566);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(35567);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickTimeStampMs:").append(this.cYI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(35567);
        return stringBuffer2;
    }

    public final ah Fs() {
        AppMethodBeat.i(35565);
        this.cYI = bo.anU();
        super.aj("ClickTimeStampMs", this.cYI);
        AppMethodBeat.o(35565);
        return this;
    }
}
