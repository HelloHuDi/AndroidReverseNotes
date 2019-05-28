package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class aq extends a {
    public long cZI = 0;
    private String cZJ = "";

    public final int getId() {
        return 16657;
    }

    public final aq bE(long j) {
        this.cZI = j;
        return this;
    }

    public final aq fz(String str) {
        AppMethodBeat.i(108859);
        this.cZJ = t("StoryId", str, true);
        AppMethodBeat.o(108859);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108860);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cZI);
        stringBuffer.append(",");
        stringBuffer.append(this.cZJ);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(108860);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(108861);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PageType:").append(this.cZI);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StoryId:").append(this.cZJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108861);
        return stringBuffer2;
    }
}
