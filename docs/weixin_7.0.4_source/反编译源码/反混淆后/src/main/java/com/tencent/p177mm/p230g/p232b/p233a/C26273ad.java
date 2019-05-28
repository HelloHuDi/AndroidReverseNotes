package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ad */
public final class C26273ad extends C46180a {
    private String cYr = "";
    public long cYs = 0;
    public long cYt = 0;
    public long cYu = 0;
    private String cYv = "";
    public long cYw = 0;
    public long cYx = 0;
    private String cYy = "";
    private String cYz = "";

    public final int getId() {
        return 14452;
    }

    /* renamed from: eY */
    public final C26273ad mo43950eY(String str) {
        AppMethodBeat.m2504i(70613);
        this.cYr = mo74169t("statId", str, true);
        AppMethodBeat.m2505o(70613);
        return this;
    }

    /* renamed from: eZ */
    public final C26273ad mo43951eZ(String str) {
        AppMethodBeat.m2504i(70614);
        this.cYv = mo74169t("appid", str, true);
        AppMethodBeat.m2505o(70614);
        return this;
    }

    /* renamed from: fa */
    public final C26273ad mo43952fa(String str) {
        AppMethodBeat.m2504i(70615);
        this.cYy = mo74169t(DownloadInfo.NETTYPE, str, true);
        AppMethodBeat.m2505o(70615);
        return this;
    }

    /* renamed from: fb */
    public final C26273ad mo43953fb(String str) {
        AppMethodBeat.m2504i(70616);
        this.cYz = mo74169t("jsError", str, true);
        AppMethodBeat.m2505o(70616);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(70617);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYr);
        stringBuffer.append(str);
        stringBuffer.append(this.cYs);
        stringBuffer.append(str);
        stringBuffer.append(this.cYt);
        stringBuffer.append(str);
        stringBuffer.append(this.cYu);
        stringBuffer.append(str);
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.cYw);
        stringBuffer.append(str);
        stringBuffer.append(this.cYx);
        stringBuffer.append(str);
        stringBuffer.append(this.cYy);
        stringBuffer.append(str);
        stringBuffer.append(this.cYz);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(70617);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(70618);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("statId:").append(this.cYr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("statEvent:").append(this.cYs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("statTimeStamp:").append(this.cYt);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("success:").append(this.cYu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("searchType:").append(this.cYw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasInitData:").append(this.cYx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("netType:").append(this.cYy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("jsError:").append(this.cYz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(70618);
        return stringBuffer2;
    }
}
