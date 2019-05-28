package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cn extends a {
    public long dha = 0;
    public long dhb = 0;
    private String dhc = "";
    public long dhd = 0;
    private String dhe = "";
    private String dhf = "";

    public final int getId() {
        return 14688;
    }

    public final cn hr(String str) {
        AppMethodBeat.i(91269);
        this.dhc = t("appId", str, true);
        AppMethodBeat.o(91269);
        return this;
    }

    public final cn hs(String str) {
        AppMethodBeat.i(91270);
        this.dhe = t("statBuffer", str, true);
        AppMethodBeat.o(91270);
        return this;
    }

    public final cn ht(String str) {
        AppMethodBeat.i(91271);
        this.dhf = t("switchId", str, true);
        AppMethodBeat.o(91271);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91272);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dha);
        stringBuffer.append(str);
        stringBuffer.append(this.dhb);
        stringBuffer.append(str);
        stringBuffer.append(this.dhc);
        stringBuffer.append(str);
        stringBuffer.append(this.dhd);
        stringBuffer.append(str);
        stringBuffer.append(this.dhe);
        stringBuffer.append(str);
        stringBuffer.append(this.dhf);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(91272);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(91273);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actionType:").append(this.dha);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("clientTimestamp:").append(this.dhb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appId:").append(this.dhc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("serviceType:").append(this.dhd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("statBuffer:").append(this.dhe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("switchId:").append(this.dhf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91273);
        return stringBuffer2;
    }
}
