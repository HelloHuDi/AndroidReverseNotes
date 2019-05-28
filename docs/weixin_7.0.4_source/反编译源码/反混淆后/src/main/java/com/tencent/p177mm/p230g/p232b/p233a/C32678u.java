package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.u */
public final class C32678u extends C46180a {
    private String cXQ = "";
    public long cXR = 0;
    public long cXS = 0;
    public long cXT = 0;

    public final int getId() {
        return 15850;
    }

    /* renamed from: eP */
    public final C32678u mo53209eP(String str) {
        AppMethodBeat.m2504i(77590);
        this.cXQ = mo74169t("sessionID", str, true);
        AppMethodBeat.m2505o(77590);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77591);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cXR);
        stringBuffer.append(str);
        stringBuffer.append(this.cXS);
        stringBuffer.append(str);
        stringBuffer.append(this.cXT);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(77591);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77592);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionID:").append(this.cXQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("actionCode:").append(this.cXR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("actionCodeResult:").append(this.cXS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("clickAddContact:").append(this.cXT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77592);
        return stringBuffer2;
    }
}
