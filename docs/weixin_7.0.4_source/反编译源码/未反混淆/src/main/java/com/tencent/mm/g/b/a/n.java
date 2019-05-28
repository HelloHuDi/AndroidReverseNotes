package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class n extends a {
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

    public final n eF(String str) {
        AppMethodBeat.i(73287);
        this.cWd = t("PName", str, true);
        AppMethodBeat.o(73287);
        return this;
    }

    public final n eG(String str) {
        AppMethodBeat.i(73288);
        this.cWe = t("sessionId", str, true);
        AppMethodBeat.o(73288);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(73289);
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
        VX(str);
        AppMethodBeat.o(73289);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(73290);
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
        AppMethodBeat.o(73290);
        return stringBuffer2;
    }
}
