package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.aj */
public final class C1583aj extends C46180a {
    private String cYP = "";
    public long cYQ = 0;
    public long cYR = 0;

    public final int getId() {
        return 16656;
    }

    /* renamed from: fl */
    public final C1583aj mo4984fl(String str) {
        AppMethodBeat.m2504i(108836);
        this.cYP = mo74169t("UserName", str, true);
        AppMethodBeat.m2505o(108836);
        return this;
    }

    public final String getUserName() {
        return this.cYP;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108837);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYP);
        stringBuffer.append(str);
        stringBuffer.append(this.cYQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cYR);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(108837);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108838);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserName:").append(this.cYP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreviewEnterScene:").append(this.cYQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasUnreadStoryTips:").append(this.cYR);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(108838);
        return stringBuffer2;
    }
}
