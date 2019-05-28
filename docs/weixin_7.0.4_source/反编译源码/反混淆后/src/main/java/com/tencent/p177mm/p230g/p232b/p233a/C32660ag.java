package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ag */
public final class C32660ag extends C46180a {
    private String cWo = "";
    public long cYH = 0;
    private long cYI = 0;

    public final int getId() {
        return 15987;
    }

    /* renamed from: fj */
    public final C32660ag mo53149fj(String str) {
        AppMethodBeat.m2504i(35560);
        this.cWo = mo74169t("SessionId", str, true);
        AppMethodBeat.m2505o(35560);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(35562);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYH);
        stringBuffer.append(str);
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.cYI);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(35562);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(35563);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Entrance:").append(this.cYH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickTimeStampMs:").append(this.cYI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(35563);
        return stringBuffer2;
    }

    /* renamed from: Fr */
    public final C32660ag mo53148Fr() {
        AppMethodBeat.m2504i(35561);
        this.cYI = C5046bo.anU();
        super.mo74166aj("ClickTimeStampMs", this.cYI);
        AppMethodBeat.m2505o(35561);
        return this;
    }
}
