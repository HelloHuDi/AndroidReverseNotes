package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class g extends a {
    private String cVb = "";
    private String cVc = "";
    public int cVd = 0;

    public final int getId() {
        return 15459;
    }

    public final g es(String str) {
        AppMethodBeat.i(73278);
        this.cVb = t("ChatroomName", str, true);
        AppMethodBeat.o(73278);
        return this;
    }

    public final g et(String str) {
        AppMethodBeat.i(73279);
        this.cVc = t("ExptScore", str, true);
        AppMethodBeat.o(73279);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(73280);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVb);
        stringBuffer.append(str);
        stringBuffer.append(this.cVc);
        stringBuffer.append(str);
        stringBuffer.append(this.cVd);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(73280);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(73281);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatroomName:").append(this.cVb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptScore:").append(this.cVc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptFlag:").append(this.cVd);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(73281);
        return stringBuffer2;
    }
}
