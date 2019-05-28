package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bl extends a {
    public long dck = 0;
    private String dcp = "";
    public long dcq = 0;

    public final int getId() {
        return 16016;
    }

    public final bl ge(String str) {
        AppMethodBeat.i(56604);
        this.dcp = t("TransferUserName", str, true);
        AppMethodBeat.o(56604);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(56605);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dck);
        stringBuffer.append(str);
        stringBuffer.append(this.dcp);
        stringBuffer.append(str);
        stringBuffer.append(this.dcq);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(56605);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(56606);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.dck);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TransferUserName:").append(this.dcp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TransferAmount:").append(this.dcq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(56606);
        return stringBuffer2;
    }
}
