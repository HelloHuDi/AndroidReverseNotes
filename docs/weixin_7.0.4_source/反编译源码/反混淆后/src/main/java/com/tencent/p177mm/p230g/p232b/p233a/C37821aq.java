package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.aq */
public final class C37821aq extends C46180a {
    public long cZI = 0;
    private String cZJ = "";

    public final int getId() {
        return 16657;
    }

    /* renamed from: bE */
    public final C37821aq mo60517bE(long j) {
        this.cZI = j;
        return this;
    }

    /* renamed from: fz */
    public final C37821aq mo60518fz(String str) {
        AppMethodBeat.m2504i(108859);
        this.cZJ = mo74169t("StoryId", str, true);
        AppMethodBeat.m2505o(108859);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108860);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cZI);
        stringBuffer.append(",");
        stringBuffer.append(this.cZJ);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(108860);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108861);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PageType:").append(this.cZI);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StoryId:").append(this.cZJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(108861);
        return stringBuffer2;
    }
}
