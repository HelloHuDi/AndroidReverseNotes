package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bv */
public final class C18441bv extends C46180a {
    public long cVR = 0;
    public long dbX = 0;
    private long ddA = 0;
    private long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    public long ddg = 0;
    private String ddx = "";
    public long ddz = 0;
    public C18442a ded;
    public long dee = 0;

    /* renamed from: com.tencent.mm.g.b.a.bv$a */
    public enum C18442a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128708);
        }

        private C18442a(int i) {
            this.value = i;
        }

        /* renamed from: gW */
        public static C18442a m28685gW(int i) {
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
        return 15814;
    }

    /* renamed from: gx */
    public final C18441bv mo33707gx(String str) {
        AppMethodBeat.m2504i(128709);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128709);
        return this;
    }

    /* renamed from: gy */
    public final C18441bv mo33708gy(String str) {
        AppMethodBeat.m2504i(128710);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128710);
        return this;
    }

    /* renamed from: dK */
    public final C18441bv mo33705dK(long j) {
        AppMethodBeat.m2504i(128711);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128711);
        return this;
    }

    /* renamed from: dL */
    public final C18441bv mo33706dL(long j) {
        AppMethodBeat.m2504i(128712);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128712);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128714);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.ded != null) {
            i = this.ded.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.ddz);
        stringBuffer.append(str);
        stringBuffer.append(this.ddA);
        stringBuffer.append(str);
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.ddB);
        stringBuffer.append(str);
        stringBuffer.append(this.ddC);
        stringBuffer.append(str);
        stringBuffer.append(this.ddg);
        stringBuffer.append(str);
        stringBuffer.append(this.dbX);
        stringBuffer.append(str);
        stringBuffer.append(this.dee);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128714);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128715);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.ded);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CostTimeMs:").append(this.ddA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartTimeStampMs:").append(this.ddB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EndTimeStampMs:").append(this.ddC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isPreload:").append(this.ddg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("type:").append(this.dbX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isGame:").append(this.dee);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128715);
        return stringBuffer2;
    }

    /* renamed from: GY */
    public final C18441bv mo33704GY() {
        AppMethodBeat.m2504i(128713);
        this.ddC = C5046bo.anU();
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128713);
        return this;
    }
}
