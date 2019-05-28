package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cu */
public final class C37829cu extends C46180a {
    public long cYo = 0;
    public long dig = 0;
    public long dih = 0;
    public long dii = 0;
    public long dij = 0;
    private String dik = "";
    private String dil = "";

    public final int getId() {
        return 15452;
    }

    /* renamed from: hJ */
    public final C37829cu mo60544hJ(String str) {
        AppMethodBeat.m2504i(73311);
        this.dik = mo74169t("ExptKey", str, true);
        AppMethodBeat.m2505o(73311);
        return this;
    }

    /* renamed from: hK */
    public final C37829cu mo60545hK(String str) {
        AppMethodBeat.m2504i(73312);
        this.dil = mo74169t("ExptVal", str, false);
        AppMethodBeat.m2505o(73312);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(73313);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dig);
        stringBuffer.append(str);
        stringBuffer.append(this.dih);
        stringBuffer.append(str);
        stringBuffer.append(this.dii);
        stringBuffer.append(str);
        stringBuffer.append(this.cYo);
        stringBuffer.append(str);
        stringBuffer.append(this.dij);
        stringBuffer.append(str);
        stringBuffer.append(this.dik);
        stringBuffer.append(str);
        stringBuffer.append(this.dil);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(73313);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73314);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptId:").append(this.dig);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("GroupId:").append(this.dih);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptSeq:").append(this.dii);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartTimeStampSec:").append(this.cYo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EndTimeStampSec:").append(this.dij);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptKey:").append(this.dik);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptVal:").append(this.dil);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73314);
        return stringBuffer2;
    }
}
