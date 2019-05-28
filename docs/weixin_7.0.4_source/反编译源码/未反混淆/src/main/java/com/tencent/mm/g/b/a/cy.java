package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cy extends a {
    private String diw = "";
    private String dix = "";
    private String diy = "";

    public final int getId() {
        return 16358;
    }

    public final cy hX(String str) {
        AppMethodBeat.i(70622);
        this.diw = t("WidgetAppid", str, true);
        AppMethodBeat.o(70622);
        return this;
    }

    public final cy hY(String str) {
        AppMethodBeat.i(70623);
        this.dix = t("SrcAppid", str, true);
        AppMethodBeat.o(70623);
        return this;
    }

    public final cy hZ(String str) {
        AppMethodBeat.i(70624);
        this.diy = t("DrawData", str, true);
        AppMethodBeat.o(70624);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(70625);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.diw);
        stringBuffer.append(str);
        stringBuffer.append(this.dix);
        stringBuffer.append(str);
        stringBuffer.append(this.diy);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(70625);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(70626);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WidgetAppid:").append(this.diw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SrcAppid:").append(this.dix);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DrawData:").append(this.diy);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(70626);
        return stringBuffer2;
    }
}
