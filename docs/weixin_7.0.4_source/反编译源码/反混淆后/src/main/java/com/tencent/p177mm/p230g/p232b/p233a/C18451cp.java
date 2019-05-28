package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cp */
public final class C18451cp extends C46180a {
    private String cYD = "";
    private String cYv = "";
    public long cYx = 0;
    public long dhm = 0;

    public final int getId() {
        return 15831;
    }

    /* renamed from: hw */
    public final C18451cp mo33727hw(String str) {
        AppMethodBeat.m2504i(91274);
        this.cYv = mo74169t("appid", str, true);
        AppMethodBeat.m2505o(91274);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91275);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        stringBuffer.append(str);
        stringBuffer.append(this.dhm);
        stringBuffer.append(str);
        stringBuffer.append(this.cYx);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(91275);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91276);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timecost:").append(this.dhm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasInitData:").append(this.cYx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91276);
        return stringBuffer2;
    }
}
