package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.da */
public final class C37831da extends C46180a {
    private String cYv = "";
    public long diB = 0;
    private String diC = "";
    private String diD = "";
    public long diE = 0;
    public long diF = 0;
    public long diG = 0;
    public long diH = 0;

    public final int getId() {
        return 15778;
    }

    /* renamed from: ib */
    public final C37831da mo60551ib(String str) {
        AppMethodBeat.m2504i(91295);
        this.cYv = mo74169t("appid", str, true);
        AppMethodBeat.m2505o(91295);
        return this;
    }

    /* renamed from: ic */
    public final C37831da mo60552ic(String str) {
        AppMethodBeat.m2504i(91296);
        this.diC = mo74169t("pkgMd5", str, true);
        AppMethodBeat.m2505o(91296);
        return this;
    }

    /* renamed from: ie */
    public final C37831da mo60553ie(String str) {
        AppMethodBeat.m2504i(91297);
        this.diD = mo74169t("downloadUrl", str, true);
        AppMethodBeat.m2505o(91297);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91298);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.diB);
        stringBuffer.append(str);
        stringBuffer.append(this.diC);
        stringBuffer.append(str);
        stringBuffer.append(this.diD);
        stringBuffer.append(str);
        stringBuffer.append(this.diE);
        stringBuffer.append(str);
        stringBuffer.append(this.diF);
        stringBuffer.append(str);
        stringBuffer.append(this.diG);
        stringBuffer.append(str);
        stringBuffer.append(this.diH);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(91298);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91299);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appVersion:").append(this.diB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("pkgMd5:").append(this.diC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("downloadUrl:").append(this.diD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isSuccess:").append(this.diE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timeCostInMs:").append(this.diF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timeStampInMs:").append(this.diG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("totalLen:").append(this.diH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91299);
        return stringBuffer2;
    }
}
