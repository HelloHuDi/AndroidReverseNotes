package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ab extends a {
    public long cYk = 0;
    private String cYl = "";

    public final int getId() {
        return 16868;
    }

    public final ab eW(String str) {
        AppMethodBeat.i(77604);
        this.cYl = t("emoticonMd5", str, true);
        AppMethodBeat.o(77604);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(77605);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYk);
        stringBuffer.append(",");
        stringBuffer.append(this.cYl);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(77605);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(77606);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SendScene:").append(this.cYk);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("emoticonMd5:").append(this.cYl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77606);
        return stringBuffer2;
    }
}
