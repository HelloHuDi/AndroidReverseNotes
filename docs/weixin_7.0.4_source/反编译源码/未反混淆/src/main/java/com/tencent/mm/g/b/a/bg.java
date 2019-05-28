package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bg extends a {
    public long dcc = 0;
    public long dcd = 0;
    private String dce = "";
    private String dcf = "";
    private String dcg = "";
    private String dch = "";
    private String dci = "";

    public final int getId() {
        return 16310;
    }

    public final bg fY(String str) {
        AppMethodBeat.i(56595);
        this.dce = t("SourceH5Url", str, true);
        AppMethodBeat.o(56595);
        return this;
    }

    public final bg fZ(String str) {
        AppMethodBeat.i(56596);
        this.dcf = t("SourceAppUsername", str, true);
        AppMethodBeat.o(56596);
        return this;
    }

    public final bg ga(String str) {
        AppMethodBeat.i(56597);
        this.dcg = t("SourceAppPath", str, true);
        AppMethodBeat.o(56597);
        return this;
    }

    public final bg gb(String str) {
        AppMethodBeat.i(56598);
        this.dch = t("TargetAppUsername", str, true);
        AppMethodBeat.o(56598);
        return this;
    }

    public final bg gc(String str) {
        AppMethodBeat.i(56599);
        this.dci = t("TargetAppPath", str, true);
        AppMethodBeat.o(56599);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(56600);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dcc);
        stringBuffer.append(str);
        stringBuffer.append(this.dcd);
        stringBuffer.append(str);
        stringBuffer.append(this.dce);
        stringBuffer.append(str);
        stringBuffer.append(this.dcf);
        stringBuffer.append(str);
        stringBuffer.append(this.dcg);
        stringBuffer.append(str);
        stringBuffer.append(this.dch);
        stringBuffer.append(str);
        stringBuffer.append(this.dci);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(56600);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(56601);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PayType:").append(this.dcc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CallbackType:").append(this.dcd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceH5Url:").append(this.dce);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceAppUsername:").append(this.dcf);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceAppPath:").append(this.dcg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TargetAppUsername:").append(this.dch);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TargetAppPath:").append(this.dci);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(56601);
        return stringBuffer2;
    }
}
