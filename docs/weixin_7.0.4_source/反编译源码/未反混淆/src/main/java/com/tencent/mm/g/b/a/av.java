package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class av extends a {
    private String cWo = "";
    private String dal = "";
    public long dam = 0;
    private String dan = "";
    public long dao = 0;

    public final int getId() {
        return 16843;
    }

    public final av fH(String str) {
        AppMethodBeat.i(35568);
        this.dal = t("EnterObjectId", str, true);
        AppMethodBeat.o(35568);
        return this;
    }

    public final av fI(String str) {
        AppMethodBeat.i(35569);
        this.cWo = t("SessionId", str, true);
        AppMethodBeat.o(35569);
        return this;
    }

    public final av fJ(String str) {
        AppMethodBeat.i(35570);
        this.dan = t("ExposeUinList", str, true);
        AppMethodBeat.o(35570);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(35571);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dal);
        stringBuffer.append(str);
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.dam);
        stringBuffer.append(str);
        stringBuffer.append(this.dan);
        stringBuffer.append(str);
        stringBuffer.append(this.dao);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(35571);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(35572);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterObjectId:").append(this.dal);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeUinCount:").append(this.dam);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeUinList:").append(this.dan);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeNewVideoCount:").append(this.dao);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(35572);
        return stringBuffer2;
    }
}
