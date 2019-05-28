package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cp extends a {
    private String cYD = "";
    private String cYv = "";
    public long cYx = 0;
    public long dhm = 0;

    public final int getId() {
        return 15831;
    }

    public final cp hw(String str) {
        AppMethodBeat.i(91274);
        this.cYv = t("appid", str, true);
        AppMethodBeat.o(91274);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91275);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        stringBuffer.append(str);
        stringBuffer.append(this.dhm);
        stringBuffer.append(str);
        stringBuffer.append(this.cYx);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(91275);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(91276);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timecost:").append(this.dhm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasInitData:").append(this.cYx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91276);
        return stringBuffer2;
    }
}
