package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cn */
public final class C37828cn extends C46180a {
    public long dha = 0;
    public long dhb = 0;
    private String dhc = "";
    public long dhd = 0;
    private String dhe = "";
    private String dhf = "";

    public final int getId() {
        return 14688;
    }

    /* renamed from: hr */
    public final C37828cn mo60541hr(String str) {
        AppMethodBeat.m2504i(91269);
        this.dhc = mo74169t("appId", str, true);
        AppMethodBeat.m2505o(91269);
        return this;
    }

    /* renamed from: hs */
    public final C37828cn mo60542hs(String str) {
        AppMethodBeat.m2504i(91270);
        this.dhe = mo74169t("statBuffer", str, true);
        AppMethodBeat.m2505o(91270);
        return this;
    }

    /* renamed from: ht */
    public final C37828cn mo60543ht(String str) {
        AppMethodBeat.m2504i(91271);
        this.dhf = mo74169t("switchId", str, true);
        AppMethodBeat.m2505o(91271);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91272);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dha);
        stringBuffer.append(str);
        stringBuffer.append(this.dhb);
        stringBuffer.append(str);
        stringBuffer.append(this.dhc);
        stringBuffer.append(str);
        stringBuffer.append(this.dhd);
        stringBuffer.append(str);
        stringBuffer.append(this.dhe);
        stringBuffer.append(str);
        stringBuffer.append(this.dhf);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(91272);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91273);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actionType:").append(this.dha);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("clientTimestamp:").append(this.dhb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appId:").append(this.dhc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("serviceType:").append(this.dhd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("statBuffer:").append(this.dhe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("switchId:").append(this.dhf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91273);
        return stringBuffer2;
    }
}
