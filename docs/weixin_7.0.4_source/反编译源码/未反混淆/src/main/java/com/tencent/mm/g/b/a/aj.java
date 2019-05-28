package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class aj extends a {
    private String cYP = "";
    public long cYQ = 0;
    public long cYR = 0;

    public final int getId() {
        return 16656;
    }

    public final aj fl(String str) {
        AppMethodBeat.i(108836);
        this.cYP = t("UserName", str, true);
        AppMethodBeat.o(108836);
        return this;
    }

    public final String getUserName() {
        return this.cYP;
    }

    public final String Fj() {
        AppMethodBeat.i(108837);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYP);
        stringBuffer.append(str);
        stringBuffer.append(this.cYQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cYR);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108837);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108838);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserName:").append(this.cYP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreviewEnterScene:").append(this.cYQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasUnreadStoryTips:").append(this.cYR);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108838);
        return stringBuffer2;
    }
}
