package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.c */
public final class C42090c extends C46180a {
    private String cTx = "";
    public long cTy = 0;
    public C42089a cTz;

    /* renamed from: com.tencent.mm.g.b.a.c$a */
    public enum C42089a {
        NoDownLoad(0),
        DownLoading(1),
        DownLoaded(2),
        DownLoadFail(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128635);
        }

        private C42089a(int i) {
            this.value = i;
        }
    }

    public final int getId() {
        return 15586;
    }

    /* renamed from: eq */
    public final C42090c mo67645eq(String str) {
        AppMethodBeat.m2504i(128636);
        this.cTx = mo74169t("Url", str, true);
        AppMethodBeat.m2505o(128636);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128637);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTx);
        stringBuffer.append(str);
        stringBuffer.append(this.cTy);
        stringBuffer.append(str);
        if (this.cTz != null) {
            i = this.cTz.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(128637);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128638);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Url:").append(this.cTx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownLoadCostStampMs:").append(this.cTy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreLoadStatus:").append(this.cTz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128638);
        return stringBuffer2;
    }
}
