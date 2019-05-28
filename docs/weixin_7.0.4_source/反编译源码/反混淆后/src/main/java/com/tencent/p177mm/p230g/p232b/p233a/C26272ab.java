package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ab */
public final class C26272ab extends C46180a {
    public long cYk = 0;
    private String cYl = "";

    public final int getId() {
        return 16868;
    }

    /* renamed from: eW */
    public final C26272ab mo43949eW(String str) {
        AppMethodBeat.m2504i(77604);
        this.cYl = mo74169t("emoticonMd5", str, true);
        AppMethodBeat.m2505o(77604);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77605);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYk);
        stringBuffer.append(",");
        stringBuffer.append(this.cYl);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(77605);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77606);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SendScene:").append(this.cYk);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("emoticonMd5:").append(this.cYl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77606);
        return stringBuffer2;
    }
}
