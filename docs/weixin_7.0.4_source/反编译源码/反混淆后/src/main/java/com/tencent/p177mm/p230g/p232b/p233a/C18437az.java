package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.az */
public final class C18437az extends C46180a {
    public long daO = 0;
    private String daP = "";
    private String daQ = "";

    public final int getId() {
        return 15493;
    }

    /* renamed from: fR */
    public final C18437az mo33691fR(String str) {
        AppMethodBeat.m2504i(15831);
        this.daP = mo74169t("WechatLanguage", str, true);
        AppMethodBeat.m2505o(15831);
        return this;
    }

    /* renamed from: fS */
    public final C18437az mo33692fS(String str) {
        AppMethodBeat.m2504i(15832);
        this.daQ = mo74169t("InputLanguage", str, true);
        AppMethodBeat.m2505o(15832);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(15833);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.daO);
        stringBuffer.append(str);
        stringBuffer.append(this.daP);
        stringBuffer.append(str);
        stringBuffer.append(this.daQ);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(15833);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(15834);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LogType:").append(this.daO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WechatLanguage:").append(this.daP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("InputLanguage:").append(this.daQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(15834);
        return stringBuffer2;
    }
}
