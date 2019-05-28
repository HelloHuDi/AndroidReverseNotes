package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ag extends a {
    private String cWo = "";
    public long cYH = 0;
    private long cYI = 0;

    public final int getId() {
        return 15987;
    }

    public final ag fj(String str) {
        AppMethodBeat.i(35560);
        this.cWo = t("SessionId", str, true);
        AppMethodBeat.o(35560);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(35562);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYH);
        stringBuffer.append(str);
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.cYI);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(35562);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(35563);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Entrance:").append(this.cYH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickTimeStampMs:").append(this.cYI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(35563);
        return stringBuffer2;
    }

    public final ag Fr() {
        AppMethodBeat.i(35561);
        this.cYI = bo.anU();
        super.aj("ClickTimeStampMs", this.cYI);
        AppMethodBeat.o(35561);
        return this;
    }
}
