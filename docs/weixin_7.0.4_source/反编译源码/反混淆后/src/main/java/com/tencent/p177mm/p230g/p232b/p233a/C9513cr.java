package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cr */
public final class C9513cr extends C46180a {
    public long cTl = 0;
    private String cYv = "";
    public long cYx = 0;
    public long dhm = 0;
    public long dhw = 0;

    public final int getId() {
        return 15841;
    }

    /* renamed from: hD */
    public final C9513cr mo20801hD(String str) {
        AppMethodBeat.m2504i(70619);
        this.cYv = mo74169t("appid", str, true);
        AppMethodBeat.m2505o(70619);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(70620);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTl);
        stringBuffer.append(str);
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.dhm);
        stringBuffer.append(str);
        stringBuffer.append(this.dhw);
        stringBuffer.append(str);
        stringBuffer.append(this.cYx);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(70620);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(70621);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.cTl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timecost:").append(this.dhm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("drawStrategy:").append(this.dhw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasInitData:").append(this.cYx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(70621);
        return stringBuffer2;
    }
}
