package com.tencent.p177mm.p230g.p232b.p233a;

import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ae */
public final class C37820ae extends C46180a {
    private String cYA = "";
    private String cYB = "";
    private long cYC = 0;
    private String cYv = "";

    public final int getId() {
        return 15961;
    }

    /* renamed from: fc */
    public final C37820ae mo60514fc(String str) {
        AppMethodBeat.m2504i(91257);
        this.cYv = mo74169t("appid", str, true);
        AppMethodBeat.m2505o(91257);
        return this;
    }

    /* renamed from: fd */
    public final C37820ae mo60515fd(String str) {
        AppMethodBeat.m2504i(91258);
        this.cYA = mo74169t(ProviderConstants.API_PATH, str, true);
        AppMethodBeat.m2505o(91258);
        return this;
    }

    /* renamed from: fe */
    public final C37820ae mo60516fe(String str) {
        AppMethodBeat.m2504i(91259);
        this.cYB = mo74169t("arg", str, true);
        AppMethodBeat.m2505o(91259);
        return this;
    }

    /* renamed from: aS */
    public final C37820ae mo60513aS(long j) {
        AppMethodBeat.m2504i(91260);
        this.cYC = j;
        super.mo74166aj("timestampMs", this.cYC);
        AppMethodBeat.m2505o(91260);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91261);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(91261);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91262);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("api:").append(this.cYA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("arg:").append(this.cYB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timestampMs:").append(this.cYC);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91262);
        return stringBuffer2;
    }
}
