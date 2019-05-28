package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bo extends a {
    public long dcW = 0;
    public long dcY = 0;
    private String dcZ = "";
    public long dda = 0;
    public long ddb = 0;

    public final int getId() {
        return 15402;
    }

    public final bo gk(String str) {
        AppMethodBeat.i(128643);
        this.dcZ = t("Appid", str, true);
        AppMethodBeat.o(128643);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(128644);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dcY);
        stringBuffer.append(str);
        stringBuffer.append(this.dcZ);
        stringBuffer.append(str);
        stringBuffer.append(this.dda);
        stringBuffer.append(str);
        stringBuffer.append(this.ddb);
        stringBuffer.append(str);
        stringBuffer.append(this.dcW);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(128644);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(128645);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DeleteReason:").append(this.dcY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Appid:").append(this.dcZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DebugType:").append(this.dda);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DeleteCount:").append(this.ddb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AbtestStatus:").append(this.dcW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128645);
        return stringBuffer2;
    }
}
