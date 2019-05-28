package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class a extends com.tencent.mm.plugin.report.a {
    public long cTl = 0;
    public int cTm = 0;
    public long cTn = 0;
    private int cTo = 0;
    private String cTp = "";
    private String cTq = "";

    public final int getId() {
        return 15894;
    }

    public final a ep(String str) {
        AppMethodBeat.i(56592);
        this.cTq = t("session2", str, true);
        AppMethodBeat.o(56592);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(56593);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTl);
        stringBuffer.append(str);
        stringBuffer.append(this.cTm);
        stringBuffer.append(str);
        stringBuffer.append(this.cTn);
        stringBuffer.append(str);
        stringBuffer.append(this.cTo);
        stringBuffer.append(str);
        stringBuffer.append(this.cTp);
        stringBuffer.append(str);
        stringBuffer.append(this.cTq);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(56593);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(56594);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.cTl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("action_result:").append(this.cTm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("action_code:").append(this.cTn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("session:").append(this.cTo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("action_ext:").append(this.cTp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("session2:").append(this.cTq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(56594);
        return stringBuffer2;
    }
}
