package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.v */
public final class C32679v extends C46180a {
    private String cXU = "";
    private String cXV = "";
    public long cXW = 0;
    public long cXX = 0;
    public long cXY = 0;
    public long cXZ = 0;
    public long cYa = 0;
    public long cYb = 0;

    public final int getId() {
        return 15855;
    }

    /* renamed from: eQ */
    public final C32679v mo53210eQ(String str) {
        AppMethodBeat.m2504i(77593);
        this.cXU = mo74169t("sessionid", str, true);
        AppMethodBeat.m2505o(77593);
        return this;
    }

    /* renamed from: eR */
    public final C32679v mo53211eR(String str) {
        AppMethodBeat.m2504i(77594);
        this.cXV = mo74169t("userName", str, true);
        AppMethodBeat.m2505o(77594);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77595);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXU);
        stringBuffer.append(str);
        stringBuffer.append(this.cXV);
        stringBuffer.append(str);
        stringBuffer.append(this.cXW);
        stringBuffer.append(str);
        stringBuffer.append(this.cXX);
        stringBuffer.append(str);
        stringBuffer.append(this.cXY);
        stringBuffer.append(str);
        stringBuffer.append(this.cXZ);
        stringBuffer.append(str);
        stringBuffer.append(this.cYa);
        stringBuffer.append(str);
        stringBuffer.append(this.cYb);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(77595);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77596);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.cXU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("userName:").append(this.cXV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("succeedStatus:").append(this.cXW);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("userStatus:").append(this.cXX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("showSucceedMethod:").append(this.cXY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("clickSucceedAction:").append(this.cXZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("watchMessageRecord:").append(this.cYa);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sendMessageStatus:").append(this.cYb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77596);
        return stringBuffer2;
    }
}
