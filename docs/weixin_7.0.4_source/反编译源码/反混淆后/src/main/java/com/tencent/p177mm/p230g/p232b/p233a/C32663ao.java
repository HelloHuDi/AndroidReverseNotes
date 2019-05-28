package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ao */
public final class C32663ao extends C46180a {
    private long cZv = 0;
    private long cZw = 0;
    private long cZx = 0;
    private long cZy = 0;

    public final int getId() {
        return 16913;
    }

    /* renamed from: bz */
    public final C32663ao mo53172bz(long j) {
        this.cZv = j;
        return this;
    }

    /* renamed from: bA */
    public final C32663ao mo53169bA(long j) {
        this.cZw = j;
        return this;
    }

    /* renamed from: Fz */
    public final long mo53168Fz() {
        return this.cZw;
    }

    /* renamed from: bB */
    public final C32663ao mo53170bB(long j) {
        this.cZx = j;
        return this;
    }

    /* renamed from: FA */
    public final long mo53167FA() {
        return this.cZx;
    }

    /* renamed from: bC */
    public final C32663ao mo53171bC(long j) {
        this.cZy = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108852);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cZv);
        stringBuffer.append(str);
        stringBuffer.append(this.cZw);
        stringBuffer.append(str);
        stringBuffer.append(this.cZx);
        stringBuffer.append(str);
        stringBuffer.append(this.cZy);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(108852);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108853);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExposeViewId:").append(this.cZv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickClearCount:").append(this.cZw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickRenewCount:").append(this.cZx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IfDeleteVideo:").append(this.cZy);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(108853);
        return stringBuffer2;
    }
}
