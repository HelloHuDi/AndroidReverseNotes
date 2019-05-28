package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bg */
public final class C26276bg extends C46180a {
    public long dcc = 0;
    public long dcd = 0;
    private String dce = "";
    private String dcf = "";
    private String dcg = "";
    private String dch = "";
    private String dci = "";

    public final int getId() {
        return 16310;
    }

    /* renamed from: fY */
    public final C26276bg mo44019fY(String str) {
        AppMethodBeat.m2504i(56595);
        this.dce = mo74169t("SourceH5Url", str, true);
        AppMethodBeat.m2505o(56595);
        return this;
    }

    /* renamed from: fZ */
    public final C26276bg mo44020fZ(String str) {
        AppMethodBeat.m2504i(56596);
        this.dcf = mo74169t("SourceAppUsername", str, true);
        AppMethodBeat.m2505o(56596);
        return this;
    }

    /* renamed from: ga */
    public final C26276bg mo44021ga(String str) {
        AppMethodBeat.m2504i(56597);
        this.dcg = mo74169t("SourceAppPath", str, true);
        AppMethodBeat.m2505o(56597);
        return this;
    }

    /* renamed from: gb */
    public final C26276bg mo44022gb(String str) {
        AppMethodBeat.m2504i(56598);
        this.dch = mo74169t("TargetAppUsername", str, true);
        AppMethodBeat.m2505o(56598);
        return this;
    }

    /* renamed from: gc */
    public final C26276bg mo44023gc(String str) {
        AppMethodBeat.m2504i(56599);
        this.dci = mo74169t("TargetAppPath", str, true);
        AppMethodBeat.m2505o(56599);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(56600);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dcc);
        stringBuffer.append(str);
        stringBuffer.append(this.dcd);
        stringBuffer.append(str);
        stringBuffer.append(this.dce);
        stringBuffer.append(str);
        stringBuffer.append(this.dcf);
        stringBuffer.append(str);
        stringBuffer.append(this.dcg);
        stringBuffer.append(str);
        stringBuffer.append(this.dch);
        stringBuffer.append(str);
        stringBuffer.append(this.dci);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(56600);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(56601);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PayType:").append(this.dcc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CallbackType:").append(this.dcd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceH5Url:").append(this.dce);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceAppUsername:").append(this.dcf);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceAppPath:").append(this.dcg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TargetAppUsername:").append(this.dch);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TargetAppPath:").append(this.dci);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(56601);
        return stringBuffer2;
    }
}
