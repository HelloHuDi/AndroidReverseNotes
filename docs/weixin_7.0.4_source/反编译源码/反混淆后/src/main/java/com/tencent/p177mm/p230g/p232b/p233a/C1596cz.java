package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cz */
public final class C1596cz extends C46180a {
    private String diA = "";
    public long diz = 0;

    public final int getId() {
        return 15779;
    }

    /* renamed from: ia */
    public final C1596cz mo5035ia(String str) {
        AppMethodBeat.m2504i(91292);
        this.diA = mo74169t("existPkgInfo", str, true);
        AppMethodBeat.m2505o(91292);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91293);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.diz);
        stringBuffer.append(",");
        stringBuffer.append(this.diA);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(91293);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91294);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("canPreload:").append(this.diz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("existPkgInfo:").append(this.diA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91294);
        return stringBuffer2;
    }
}
