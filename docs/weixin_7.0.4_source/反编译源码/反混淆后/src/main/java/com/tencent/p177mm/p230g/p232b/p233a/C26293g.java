package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.g */
public final class C26293g extends C46180a {
    private String cVb = "";
    private String cVc = "";
    public int cVd = 0;

    public final int getId() {
        return 15459;
    }

    /* renamed from: es */
    public final C26293g mo44054es(String str) {
        AppMethodBeat.m2504i(73278);
        this.cVb = mo74169t("ChatroomName", str, true);
        AppMethodBeat.m2505o(73278);
        return this;
    }

    /* renamed from: et */
    public final C26293g mo44055et(String str) {
        AppMethodBeat.m2504i(73279);
        this.cVc = mo74169t("ExptScore", str, true);
        AppMethodBeat.m2505o(73279);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(73280);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVb);
        stringBuffer.append(str);
        stringBuffer.append(this.cVc);
        stringBuffer.append(str);
        stringBuffer.append(this.cVd);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(73280);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73281);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatroomName:").append(this.cVb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptScore:").append(this.cVc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptFlag:").append(this.cVd);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73281);
        return stringBuffer2;
    }
}
