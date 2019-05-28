package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class z extends a {
    public long cYk = 0;
    private String cYl = "";
    public long cYm = 0;

    public final int getId() {
        return 16872;
    }

    public final z eV(String str) {
        AppMethodBeat.i(77599);
        this.cYl = t("emoticonMd5", str, true);
        AppMethodBeat.o(77599);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(77600);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYk);
        stringBuffer.append(str);
        stringBuffer.append(this.cYl);
        stringBuffer.append(str);
        stringBuffer.append(this.cYm);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(77600);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(77601);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SendScene:").append(this.cYk);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("emoticonMd5:").append(this.cYl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasTxt:").append(this.cYm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77601);
        return stringBuffer2;
    }
}
