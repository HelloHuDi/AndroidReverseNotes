package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cx extends a {
    public long cXP = 0;
    private String cXU = "";
    private String cYD = "";
    private String dbZ = "";
    private String din = "";
    private String diu = "";
    private String div = "";

    public final int getId() {
        return 16032;
    }

    public final cx hR(String str) {
        AppMethodBeat.i(91284);
        this.dbZ = t(b.CONTENT, str, true);
        AppMethodBeat.o(91284);
        return this;
    }

    public final cx hS(String str) {
        AppMethodBeat.i(91285);
        this.din = t("searchid", str, true);
        AppMethodBeat.o(91285);
        return this;
    }

    public final cx hT(String str) {
        AppMethodBeat.i(91286);
        this.cXU = t("sessionid", str, true);
        AppMethodBeat.o(91286);
        return this;
    }

    public final cx hU(String str) {
        AppMethodBeat.i(91287);
        this.cYD = t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(91287);
        return this;
    }

    public final cx hV(String str) {
        AppMethodBeat.i(91288);
        this.diu = t("resulttype", str, true);
        AppMethodBeat.o(91288);
        return this;
    }

    public final cx hW(String str) {
        AppMethodBeat.i(91289);
        this.div = t("resultsubtypelist", str, true);
        AppMethodBeat.o(91289);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91290);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXP);
        stringBuffer.append(str);
        stringBuffer.append(this.dbZ);
        stringBuffer.append(str);
        stringBuffer.append(this.din);
        stringBuffer.append(str);
        stringBuffer.append(this.cXU);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        stringBuffer.append(str);
        stringBuffer.append(this.diu);
        stringBuffer.append(str);
        stringBuffer.append(this.div);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(91290);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(91291);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.cXP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("content:").append(this.dbZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("searchid:").append(this.din);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sessionid:").append(this.cXU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("resulttype:").append(this.diu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("resultsubtypelist:").append(this.div);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91291);
        return stringBuffer2;
    }
}
