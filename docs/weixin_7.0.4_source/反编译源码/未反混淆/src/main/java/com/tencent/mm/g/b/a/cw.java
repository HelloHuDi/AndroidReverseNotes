package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cw extends a {
    public long cXP = 0;
    private String cXU = "";
    private String cYD = "";
    private String din = "";
    public long dio = 0;
    private String dip = "";
    public long diq = 0;
    private String dis = "";
    public long dit = 0;

    public final int getId() {
        return 16033;
    }

    public final cw hM(String str) {
        AppMethodBeat.i(91277);
        this.din = t("searchid", str, true);
        AppMethodBeat.o(91277);
        return this;
    }

    public final cw hN(String str) {
        AppMethodBeat.i(91278);
        this.dip = t("docid", str, true);
        AppMethodBeat.o(91278);
        return this;
    }

    public final cw hO(String str) {
        AppMethodBeat.i(91279);
        this.dis = t("expand2", str, true);
        AppMethodBeat.o(91279);
        return this;
    }

    public final cw hP(String str) {
        AppMethodBeat.i(91280);
        this.cYD = t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(91280);
        return this;
    }

    public final cw hQ(String str) {
        AppMethodBeat.i(91281);
        this.cXU = t("sessionid", str, true);
        AppMethodBeat.o(91281);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91282);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXP);
        stringBuffer.append(str);
        stringBuffer.append(this.din);
        stringBuffer.append(str);
        stringBuffer.append(this.dio);
        stringBuffer.append(str);
        stringBuffer.append(this.dip);
        stringBuffer.append(str);
        stringBuffer.append(this.diq);
        stringBuffer.append(str);
        stringBuffer.append(this.dis);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        stringBuffer.append(str);
        stringBuffer.append(this.cXU);
        stringBuffer.append(str);
        stringBuffer.append(this.dit);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(91282);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(91283);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.cXP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("searchid:").append(this.din);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("businesstype:").append(this.dio);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("docid:").append(this.dip);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timestampInMs:").append(this.diq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("expand2:").append(this.dis);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sessionid:").append(this.cXU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("resultsubtype:").append(this.dit);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91283);
        return stringBuffer2;
    }
}
