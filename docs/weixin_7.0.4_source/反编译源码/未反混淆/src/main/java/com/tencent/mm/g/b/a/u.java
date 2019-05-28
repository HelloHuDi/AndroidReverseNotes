package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class u extends a {
    private String cXQ = "";
    public long cXR = 0;
    public long cXS = 0;
    public long cXT = 0;

    public final int getId() {
        return 15850;
    }

    public final u eP(String str) {
        AppMethodBeat.i(77590);
        this.cXQ = t("sessionID", str, true);
        AppMethodBeat.o(77590);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(77591);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cXR);
        stringBuffer.append(str);
        stringBuffer.append(this.cXS);
        stringBuffer.append(str);
        stringBuffer.append(this.cXT);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(77591);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(77592);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionID:").append(this.cXQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("actionCode:").append(this.cXR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("actionCodeResult:").append(this.cXS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("clickAddContact:").append(this.cXT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77592);
        return stringBuffer2;
    }
}
