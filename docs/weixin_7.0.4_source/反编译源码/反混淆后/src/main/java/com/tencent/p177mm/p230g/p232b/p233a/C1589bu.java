package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bu */
public final class C1589bu extends C46180a {
    public long cVR = 0;
    public long dbX = 0;
    private long ddA = 0;
    public long ddB = 0;
    public long ddC = 0;
    public C1590a ddY;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;

    /* renamed from: com.tencent.mm.g.b.a.bu$a */
    public enum C1590a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128698);
        }

        private C1590a(int i) {
            this.value = i;
        }

        /* renamed from: gV */
        public static C1590a m3215gV(int i) {
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
        return 16899;
    }

    /* renamed from: gv */
    public final C1589bu mo5020gv(String str) {
        AppMethodBeat.m2504i(128699);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128699);
        return this;
    }

    /* renamed from: gw */
    public final C1589bu mo5021gw(String str) {
        AppMethodBeat.m2504i(128700);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128700);
        return this;
    }

    /* renamed from: dH */
    public final C1589bu mo5017dH(long j) {
        AppMethodBeat.m2504i(128701);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128701);
        return this;
    }

    /* renamed from: dI */
    public final C1589bu mo5018dI(long j) {
        AppMethodBeat.m2504i(128702);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128702);
        return this;
    }

    /* renamed from: dJ */
    public final C1589bu mo5019dJ(long j) {
        AppMethodBeat.m2504i(128703);
        this.ddC = j;
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128703);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128704);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.ddY != null) {
            i = this.ddY.value;
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
        stringBuffer.append(this.dbX);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128704);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128705);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.ddY);
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
        stringBuffer.append("type:").append(this.dbX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128705);
        return stringBuffer2;
    }
}
