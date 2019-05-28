package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bh extends a {
    public long cVR = 0;
    public long cVS = 0;
    private String dcj = "";

    public final int getId() {
        return 17072;
    }

    public final bh gd(String str) {
        AppMethodBeat.i(138575);
        this.dcj = t("OrderId", str, true);
        AppMethodBeat.o(138575);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(77614);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.cVS);
        stringBuffer.append(str);
        stringBuffer.append(this.dcj);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(77614);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(77615);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OrderId:").append(this.dcj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77615);
        return stringBuffer2;
    }
}
