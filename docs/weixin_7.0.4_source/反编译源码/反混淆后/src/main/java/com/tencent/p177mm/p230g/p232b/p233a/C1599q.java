package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

/* renamed from: com.tencent.mm.g.b.a.q */
public final class C1599q extends C46180a {
    public String cWR = "";
    public long cWS = 0;
    public long cWT = 0;
    public long cWU = 0;

    public C1599q(String str) {
        AppMethodBeat.m2504i(73291);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 4) {
                    strArr = new String[4];
                    Arrays.fill(strArr, 0, 4, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                mo5045eN(strArr[0]);
                this.cWS = C5046bo.getLong(strArr[1], 0);
                mo5044aP(C5046bo.getLong(strArr[2], 0));
                this.cWU = C5046bo.getLong(strArr[3], 0);
            }
        }
        AppMethodBeat.m2505o(73291);
    }

    public final int getId() {
        return 0;
    }

    /* renamed from: eN */
    public final C1599q mo5045eN(String str) {
        AppMethodBeat.m2504i(73292);
        this.cWR = mo74169t("Name", str, true);
        AppMethodBeat.m2505o(73292);
        return this;
    }

    /* renamed from: aP */
    public final C1599q mo5044aP(long j) {
        AppMethodBeat.m2504i(73293);
        this.cWT = j;
        super.mo74166aj("TimeStampMs", this.cWT);
        AppMethodBeat.m2505o(73293);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(73294);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWR);
        stringBuffer.append(str);
        stringBuffer.append(this.cWS);
        stringBuffer.append(str);
        stringBuffer.append(this.cWT);
        stringBuffer.append(str);
        stringBuffer.append(this.cWU);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(73294);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73295);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Name:").append(this.cWR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Type:").append(this.cWS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TimeStampMs:").append(this.cWT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HashCode:").append(this.cWU);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73295);
        return stringBuffer2;
    }
}
