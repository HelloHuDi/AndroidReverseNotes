package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cv extends a {
    public long cTl = 0;
    private String cYD = "";
    public long dim = 0;

    public final int getId() {
        return 15776;
    }

    public final cv hL(String str) {
        AppMethodBeat.i(61714);
        this.cYD = t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(61714);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(61715);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dim);
        stringBuffer.append(str);
        stringBuffer.append(this.cTl);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(61715);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(61716);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actionScene:").append(this.dim);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("action:").append(this.cTl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(61716);
        return stringBuffer2;
    }
}
