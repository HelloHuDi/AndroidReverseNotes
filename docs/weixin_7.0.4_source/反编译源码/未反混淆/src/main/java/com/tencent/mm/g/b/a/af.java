package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class af extends a {
    private String cWe = "";
    private String cYD = "";
    public long cYE = 0;
    private String cYF = "";
    private String cYG = "";

    public final int getId() {
        return 15960;
    }

    public final af ff(String str) {
        AppMethodBeat.i(91263);
        this.cYD = t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(91263);
        return this;
    }

    public final af fg(String str) {
        AppMethodBeat.i(91264);
        this.cWe = t("sessionId", str, true);
        AppMethodBeat.o(91264);
        return this;
    }

    public final af fh(String str) {
        AppMethodBeat.i(91265);
        this.cYF = t("appidBefore", str, true);
        AppMethodBeat.o(91265);
        return this;
    }

    public final af fi(String str) {
        AppMethodBeat.i(91266);
        this.cYG = t("appidAfter", str, true);
        AppMethodBeat.o(91266);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91267);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYD);
        stringBuffer.append(str);
        stringBuffer.append(this.cWe);
        stringBuffer.append(str);
        stringBuffer.append(this.cYE);
        stringBuffer.append(str);
        stringBuffer.append(this.cYF);
        stringBuffer.append(str);
        stringBuffer.append(this.cYG);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(91267);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(91268);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("query:").append(this.cYD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sessionId:").append(this.cWe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isChange:").append(this.cYE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appidBefore:").append(this.cYF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appidAfter:").append(this.cYG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91268);
        return stringBuffer2;
    }
}
