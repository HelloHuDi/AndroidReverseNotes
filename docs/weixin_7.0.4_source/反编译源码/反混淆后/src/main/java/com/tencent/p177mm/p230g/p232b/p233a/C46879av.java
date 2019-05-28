package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.av */
public final class C46879av extends C46180a {
    private String cWo = "";
    private String dal = "";
    public long dam = 0;
    private String dan = "";
    public long dao = 0;

    public final int getId() {
        return 16843;
    }

    /* renamed from: fH */
    public final C46879av mo76057fH(String str) {
        AppMethodBeat.m2504i(35568);
        this.dal = mo74169t("EnterObjectId", str, true);
        AppMethodBeat.m2505o(35568);
        return this;
    }

    /* renamed from: fI */
    public final C46879av mo76058fI(String str) {
        AppMethodBeat.m2504i(35569);
        this.cWo = mo74169t("SessionId", str, true);
        AppMethodBeat.m2505o(35569);
        return this;
    }

    /* renamed from: fJ */
    public final C46879av mo76059fJ(String str) {
        AppMethodBeat.m2504i(35570);
        this.dan = mo74169t("ExposeUinList", str, true);
        AppMethodBeat.m2505o(35570);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(35571);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dal);
        stringBuffer.append(str);
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.dam);
        stringBuffer.append(str);
        stringBuffer.append(this.dan);
        stringBuffer.append(str);
        stringBuffer.append(this.dao);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(35571);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(35572);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterObjectId:").append(this.dal);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeUinCount:").append(this.dam);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeUinList:").append(this.dan);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeNewVideoCount:").append(this.dao);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(35572);
        return stringBuffer2;
    }
}
