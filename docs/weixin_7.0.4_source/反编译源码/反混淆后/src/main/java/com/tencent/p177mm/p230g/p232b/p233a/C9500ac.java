package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

/* renamed from: com.tencent.mm.g.b.a.ac */
public final class C9500ac extends C46180a {
    public long cYn = 0;
    public long cYo = 0;
    public String cYp = "";
    public boolean cYq;

    public C9500ac(String str) {
        AppMethodBeat.m2504i(73303);
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
                this.cYn = C5046bo.getLong(strArr[0], 0);
                m16854aR(C5046bo.getLong(strArr[1], 0));
                mo20730eX(strArr[2]);
                this.cYq = C46180a.getBoolean(strArr[3]);
            }
        }
        AppMethodBeat.m2505o(73303);
    }

    public final int getId() {
        return 0;
    }

    /* renamed from: aR */
    private C9500ac m16854aR(long j) {
        AppMethodBeat.m2504i(73304);
        this.cYo = j;
        super.mo74168ak("StartTimeStampSec", this.cYo);
        AppMethodBeat.m2505o(73304);
        return this;
    }

    /* renamed from: eX */
    public final C9500ac mo20730eX(String str) {
        AppMethodBeat.m2504i(73306);
        this.cYp = mo74169t("Roomname", str, true);
        AppMethodBeat.m2505o(73306);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(73307);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYn);
        stringBuffer.append(str);
        stringBuffer.append(this.cYo);
        stringBuffer.append(str);
        stringBuffer.append(this.cYp);
        stringBuffer.append(str);
        if (this.cYq) {
            i = 1;
        } else {
            i = 0;
        }
        stringBuffer.append(i);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(73307);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73308);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptFlag:").append(this.cYn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartTimeStampSec:").append(this.cYo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Roomname:").append(this.cYp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hardcodeExptBool:").append(this.cYq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73308);
        return stringBuffer2;
    }

    /* renamed from: Fq */
    public final C9500ac mo20729Fq() {
        AppMethodBeat.m2504i(73305);
        C9500ac aR = m16854aR(C5046bo.anT());
        AppMethodBeat.m2505o(73305);
        return aR;
    }
}
