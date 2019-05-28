package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.o */
public final class C1598o extends C46180a {
    private long cVR = 0;
    private String cWn = "";
    private String cWo = "";
    private String cWp = "";
    public long cWq = 0;
    private String cWr = "";
    private String cWs = "";
    public long cWt = 0;

    public final int getId() {
        return 16019;
    }

    /* renamed from: Fp */
    public final C1598o mo5038Fp() {
        this.cVR = 47;
        return this;
    }

    /* renamed from: eH */
    public final C1598o mo5039eH(String str) {
        AppMethodBeat.m2504i(91250);
        this.cWn = mo74169t("SearchId", str, true);
        AppMethodBeat.m2505o(91250);
        return this;
    }

    /* renamed from: eI */
    public final C1598o mo5040eI(String str) {
        AppMethodBeat.m2504i(91251);
        this.cWo = mo74169t("SessionId", str, true);
        AppMethodBeat.m2505o(91251);
        return this;
    }

    /* renamed from: eJ */
    public final C1598o mo5041eJ(String str) {
        AppMethodBeat.m2504i(91252);
        this.cWp = mo74169t("Query", str, true);
        AppMethodBeat.m2505o(91252);
        return this;
    }

    /* renamed from: eK */
    public final C1598o mo5042eK(String str) {
        AppMethodBeat.m2504i(91253);
        this.cWr = mo74169t("Path", str, true);
        AppMethodBeat.m2505o(91253);
        return this;
    }

    /* renamed from: eL */
    public final C1598o mo5043eL(String str) {
        AppMethodBeat.m2504i(91254);
        this.cWs = mo74169t("WeappUsrname", str, true);
        AppMethodBeat.m2505o(91254);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91255);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.cWn);
        stringBuffer.append(str);
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.cWp);
        stringBuffer.append(str);
        stringBuffer.append(this.cWq);
        stringBuffer.append(str);
        stringBuffer.append(this.cWr);
        stringBuffer.append(str);
        stringBuffer.append(this.cWs);
        stringBuffer.append(str);
        stringBuffer.append(this.cWt);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(91255);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91256);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SearchId:").append(this.cWn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Query:").append(this.cWp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("JumpType:").append(this.cWq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Path:").append(this.cWr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WeappUsrname:").append(this.cWs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ServiceType:").append(this.cWt);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91256);
        return stringBuffer2;
    }
}
