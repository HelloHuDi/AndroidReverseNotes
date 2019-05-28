package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.z */
public final class C9516z extends C46180a {
    public long cYk = 0;
    private String cYl = "";
    public long cYm = 0;

    public final int getId() {
        return 16872;
    }

    /* renamed from: eV */
    public final C9516z mo20805eV(String str) {
        AppMethodBeat.m2504i(77599);
        this.cYl = mo74169t("emoticonMd5", str, true);
        AppMethodBeat.m2505o(77599);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77600);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYk);
        stringBuffer.append(str);
        stringBuffer.append(this.cYl);
        stringBuffer.append(str);
        stringBuffer.append(this.cYm);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(77600);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77601);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SendScene:").append(this.cYk);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("emoticonMd5:").append(this.cYl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasTxt:").append(this.cYm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77601);
        return stringBuffer2;
    }
}
