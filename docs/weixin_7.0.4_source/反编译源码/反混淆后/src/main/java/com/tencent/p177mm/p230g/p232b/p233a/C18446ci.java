package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ci */
public final class C18446ci extends C46180a {
    private long ddA = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;
    public C18447a dgp;
    private long dgq = 0;

    /* renamed from: com.tencent.mm.g.b.a.ci$a */
    public enum C18447a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128850);
        }

        private C18447a(int i) {
            this.value = i;
        }

        /* renamed from: hj */
        public static C18447a m28703hj(int i) {
            switch (i) {
                case 1:
                    return release;
                case 2:
                    return debug;
                case 3:
                    return demo;
                default:
                    return null;
            }
        }
    }

    public final int getId() {
        return 15853;
    }

    /* renamed from: hf */
    public final C18446ci mo33720hf(String str) {
        AppMethodBeat.m2504i(128851);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128851);
        return this;
    }

    /* renamed from: hg */
    public final C18446ci mo33721hg(String str) {
        AppMethodBeat.m2504i(128852);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128852);
        return this;
    }

    /* renamed from: en */
    public final C18446ci mo33718en(long j) {
        AppMethodBeat.m2504i(128853);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128853);
        return this;
    }

    /* renamed from: eo */
    public final C18446ci mo33719eo(long j) {
        AppMethodBeat.m2504i(128854);
        this.dgq = j;
        super.mo74165ai("WaitingTimeMs", this.dgq);
        AppMethodBeat.m2505o(128854);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128855);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dgp != null) {
            i = this.dgp.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.ddz);
        stringBuffer.append(str);
        stringBuffer.append(this.ddA);
        stringBuffer.append(str);
        stringBuffer.append(this.dgq);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128855);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128856);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dgp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CostTimeMs:").append(this.ddA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WaitingTimeMs:").append(this.dgq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128856);
        return stringBuffer2;
    }
}
