package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cy */
public final class C18455cy extends C46180a {
    private String diw = "";
    private String dix = "";
    private String diy = "";

    public final int getId() {
        return 16358;
    }

    /* renamed from: hX */
    public final C18455cy mo33728hX(String str) {
        AppMethodBeat.m2504i(70622);
        this.diw = mo74169t("WidgetAppid", str, true);
        AppMethodBeat.m2505o(70622);
        return this;
    }

    /* renamed from: hY */
    public final C18455cy mo33729hY(String str) {
        AppMethodBeat.m2504i(70623);
        this.dix = mo74169t("SrcAppid", str, true);
        AppMethodBeat.m2505o(70623);
        return this;
    }

    /* renamed from: hZ */
    public final C18455cy mo33730hZ(String str) {
        AppMethodBeat.m2504i(70624);
        this.diy = mo74169t("DrawData", str, true);
        AppMethodBeat.m2505o(70624);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(70625);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.diw);
        stringBuffer.append(str);
        stringBuffer.append(this.dix);
        stringBuffer.append(str);
        stringBuffer.append(this.diy);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(70625);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(70626);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WidgetAppid:").append(this.diw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SrcAppid:").append(this.dix);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DrawData:").append(this.diy);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(70626);
        return stringBuffer2;
    }
}
