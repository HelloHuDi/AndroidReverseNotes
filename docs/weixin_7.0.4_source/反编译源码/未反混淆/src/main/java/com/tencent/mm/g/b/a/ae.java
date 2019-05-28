package com.tencent.mm.g.b.a;

import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ae extends a {
    private String cYA = "";
    private String cYB = "";
    private long cYC = 0;
    private String cYv = "";

    public final int getId() {
        return 15961;
    }

    public final ae fc(String str) {
        AppMethodBeat.i(91257);
        this.cYv = t("appid", str, true);
        AppMethodBeat.o(91257);
        return this;
    }

    public final ae fd(String str) {
        AppMethodBeat.i(91258);
        this.cYA = t(ProviderConstants.API_PATH, str, true);
        AppMethodBeat.o(91258);
        return this;
    }

    public final ae fe(String str) {
        AppMethodBeat.i(91259);
        this.cYB = t("arg", str, true);
        AppMethodBeat.o(91259);
        return this;
    }

    public final ae aS(long j) {
        AppMethodBeat.i(91260);
        this.cYC = j;
        super.aj("timestampMs", this.cYC);
        AppMethodBeat.o(91260);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91261);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.cYA);
        stringBuffer.append(str);
        stringBuffer.append(this.cYB);
        stringBuffer.append(str);
        stringBuffer.append(this.cYC);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(91261);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(91262);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("api:").append(this.cYA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("arg:").append(this.cYB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timestampMs:").append(this.cYC);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91262);
        return stringBuffer2;
    }
}
