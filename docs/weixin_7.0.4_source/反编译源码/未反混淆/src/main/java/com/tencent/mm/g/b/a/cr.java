package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cr extends a {
    public long cTl = 0;
    private String cYv = "";
    public long cYx = 0;
    public long dhm = 0;
    public long dhw = 0;

    public final int getId() {
        return 15841;
    }

    public final cr hD(String str) {
        AppMethodBeat.i(70619);
        this.cYv = t("appid", str, true);
        AppMethodBeat.o(70619);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(70620);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTl);
        stringBuffer.append(str);
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.dhm);
        stringBuffer.append(str);
        stringBuffer.append(this.dhw);
        stringBuffer.append(str);
        stringBuffer.append(this.cYx);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(70620);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(70621);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.cTl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timecost:").append(this.dhm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("drawStrategy:").append(this.dhw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasInitData:").append(this.cYx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(70621);
        return stringBuffer2;
    }
}
