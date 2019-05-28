package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.n */
public final class C1597n extends C46180a {
    public int cWc = 0;
    public String cWd;
    public String cWe = "";
    public long cWf = 0;
    public long cWg = 0;
    public long cWh = 0;
    public String cWi;
    public int cWj = 0;
    public int cWk = 0;
    public int cWl = 0;
    public int cWm = 0;

    public final int getId() {
        return 16242;
    }

    /* renamed from: eF */
    public final C1597n mo5036eF(String str) {
        AppMethodBeat.m2504i(73287);
        this.cWd = mo74169t("PName", str, true);
        AppMethodBeat.m2505o(73287);
        return this;
    }

    /* renamed from: eG */
    public final C1597n mo5037eG(String str) {
        AppMethodBeat.m2504i(73288);
        this.cWe = mo74169t("sessionId", str, true);
        AppMethodBeat.m2505o(73288);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(73289);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWc);
        stringBuffer.append(str);
        stringBuffer.append(this.cWd);
        stringBuffer.append(str);
        stringBuffer.append(this.cWe);
        stringBuffer.append(str);
        stringBuffer.append(this.cWf);
        stringBuffer.append(str);
        stringBuffer.append(this.cWg);
        stringBuffer.append(str);
        stringBuffer.append(this.cWh);
        stringBuffer.append(str);
        stringBuffer.append(this.cWi);
        stringBuffer.append(str);
        stringBuffer.append(this.cWj);
        stringBuffer.append(str);
        stringBuffer.append(this.cWk);
        stringBuffer.append(str);
        stringBuffer.append(this.cWl);
        stringBuffer.append(str);
        stringBuffer.append(this.cWm);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(73289);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73290);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PID:").append(this.cWc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PName:").append(this.cWd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sessionId:").append(this.cWe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("frontTime:").append(this.cWf);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("stayTotalTime:").append(this.cWg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("scrollTotalTime:").append(this.cWh);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("reportFeedList:").append(this.cWi);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("reportFeedCount:").append(this.cWj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Seq:").append(this.cWk);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SubSeq:").append(this.cWl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SubSeqSum:").append(this.cWm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73290);
        return stringBuffer2;
    }
}
