package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class az extends a {
    public long daO = 0;
    private String daP = "";
    private String daQ = "";

    public final int getId() {
        return 15493;
    }

    public final az fR(String str) {
        AppMethodBeat.i(15831);
        this.daP = t("WechatLanguage", str, true);
        AppMethodBeat.o(15831);
        return this;
    }

    public final az fS(String str) {
        AppMethodBeat.i(15832);
        this.daQ = t("InputLanguage", str, true);
        AppMethodBeat.o(15832);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(15833);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.daO);
        stringBuffer.append(str);
        stringBuffer.append(this.daP);
        stringBuffer.append(str);
        stringBuffer.append(this.daQ);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(15833);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(15834);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LogType:").append(this.daO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WechatLanguage:").append(this.daP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("InputLanguage:").append(this.daQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(15834);
        return stringBuffer2;
    }
}
