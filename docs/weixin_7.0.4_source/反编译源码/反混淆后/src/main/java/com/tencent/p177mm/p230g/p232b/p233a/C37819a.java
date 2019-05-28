package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.a */
public final class C37819a extends C46180a {
    public long cTl = 0;
    public int cTm = 0;
    public long cTn = 0;
    private int cTo = 0;
    private String cTp = "";
    private String cTq = "";

    public final int getId() {
        return 15894;
    }

    /* renamed from: ep */
    public final C37819a mo60512ep(String str) {
        AppMethodBeat.m2504i(56592);
        this.cTq = mo74169t("session2", str, true);
        AppMethodBeat.m2505o(56592);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(56593);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTl);
        stringBuffer.append(str);
        stringBuffer.append(this.cTm);
        stringBuffer.append(str);
        stringBuffer.append(this.cTn);
        stringBuffer.append(str);
        stringBuffer.append(this.cTo);
        stringBuffer.append(str);
        stringBuffer.append(this.cTp);
        stringBuffer.append(str);
        stringBuffer.append(this.cTq);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(56593);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(56594);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.cTl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("action_result:").append(this.cTm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("action_code:").append(this.cTn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("session:").append(this.cTo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("action_ext:").append(this.cTp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("session2:").append(this.cTq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(56594);
        return stringBuffer2;
    }
}
