package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

/* renamed from: com.tencent.mm.g.b.a.w */
public final class C26295w extends C46180a {
    private String cWR = "";
    public long cWS = 0;
    public long cWT = 0;
    public long cWU = 0;
    public int cWc = 0;
    private String cWd = "";
    public long cYc = 0;
    private long cYd = 0;
    private boolean cYe;

    public C26295w(String str) {
        AppMethodBeat.m2504i(73296);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 9) {
                    strArr = new String[9];
                    Arrays.fill(strArr, 0, 9, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                this.cWc = C5046bo.getInt(strArr[0], 0);
                mo44065eS(strArr[1]);
                this.cYc = C5046bo.getLong(strArr[2], 0);
                mo44066eT(strArr[3]);
                this.cWS = C5046bo.getLong(strArr[4], 0);
                mo44064aQ(C5046bo.getLong(strArr[5], 0));
                this.cYd = C5046bo.getLong(strArr[6], 0);
                this.cYe = C46180a.getBoolean(strArr[7]);
                this.cWU = C5046bo.getLong(strArr[8], 0);
            }
        }
        AppMethodBeat.m2505o(73296);
    }

    public final int getId() {
        return 15885;
    }

    /* renamed from: eS */
    public final C26295w mo44065eS(String str) {
        AppMethodBeat.m2504i(73297);
        this.cWd = mo74169t("PName", str, true);
        AppMethodBeat.m2505o(73297);
        return this;
    }

    /* renamed from: eT */
    public final C26295w mo44066eT(String str) {
        AppMethodBeat.m2504i(73298);
        this.cWR = mo74169t("Name", str, true);
        AppMethodBeat.m2505o(73298);
        return this;
    }

    /* renamed from: aQ */
    public final C26295w mo44064aQ(long j) {
        AppMethodBeat.m2504i(73299);
        this.cWT = j;
        super.mo74166aj("TimeStampMs", this.cWT);
        AppMethodBeat.m2505o(73299);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(73300);
        String eU = mo44067eU(",");
        AppMethodBeat.m2505o(73300);
        return eU;
    }

    /* renamed from: eU */
    public final String mo44067eU(String str) {
        int i;
        AppMethodBeat.m2504i(73301);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWc);
        stringBuffer.append(str);
        stringBuffer.append(this.cWd);
        stringBuffer.append(str);
        stringBuffer.append(this.cYc);
        stringBuffer.append(str);
        stringBuffer.append(this.cWR);
        stringBuffer.append(str);
        stringBuffer.append(this.cWS);
        stringBuffer.append(str);
        stringBuffer.append(this.cWT);
        stringBuffer.append(str);
        stringBuffer.append(this.cYd);
        stringBuffer.append(str);
        if (this.cYe) {
            i = 1;
        } else {
            i = 0;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.cWU);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(73301);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73302);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PID:").append(this.cWc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PName:").append(this.cWd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Seq:").append(this.cYc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Name:").append(this.cWR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Type:").append(this.cWS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TimeStampMs:").append(this.cWT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("GreenManFg:").append(this.cYd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("QueueFgBool:").append(this.cYe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HashCode:").append(this.cWU);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73302);
        return stringBuffer2;
    }
}
