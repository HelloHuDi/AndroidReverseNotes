package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cz extends a {
    private String diA = "";
    public long diz = 0;

    public final int getId() {
        return 15779;
    }

    public final cz ia(String str) {
        AppMethodBeat.i(91292);
        this.diA = t("existPkgInfo", str, true);
        AppMethodBeat.o(91292);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91293);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.diz);
        stringBuffer.append(",");
        stringBuffer.append(this.diA);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(91293);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(91294);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("canPreload:").append(this.diz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("existPkgInfo:").append(this.diA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91294);
        return stringBuffer2;
    }
}
