package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bx */
public final class C1591bx extends C46180a {
    public long cVR = 0;
    private long ddA = 0;
    private long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;
    public C1592a deo;
    public long dep = 0;
    private String deq = "";

    /* renamed from: com.tencent.mm.g.b.a.bx$a */
    public enum C1592a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128725);
        }

        private C1592a(int i) {
            this.value = i;
        }

        /* renamed from: gY */
        public static C1592a m3224gY(int i) {
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
        return 16007;
    }

    /* renamed from: gB */
    public final C1591bx mo5025gB(String str) {
        AppMethodBeat.m2504i(128726);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128726);
        return this;
    }

    /* renamed from: gC */
    public final C1591bx mo5026gC(String str) {
        AppMethodBeat.m2504i(128727);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128727);
        return this;
    }

    /* renamed from: dM */
    public final C1591bx mo5023dM(long j) {
        AppMethodBeat.m2504i(128728);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128728);
        return this;
    }

    /* renamed from: dN */
    public final C1591bx mo5024dN(long j) {
        AppMethodBeat.m2504i(128729);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128729);
        return this;
    }

    /* renamed from: gD */
    public final C1591bx mo5027gD(String str) {
        AppMethodBeat.m2504i(128731);
        this.deq = mo74169t("filePath", str, true);
        AppMethodBeat.m2505o(128731);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128732);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.deo != null) {
            i = this.deo.value;
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
        stringBuffer.append(this.dep);
        stringBuffer.append(str);
        stringBuffer.append(this.deq);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128732);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128733);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.deo);
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
        stringBuffer.append("fileSize:").append(this.dep);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("filePath:").append(this.deq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128733);
        return stringBuffer2;
    }

    /* renamed from: GZ */
    public final C1591bx mo5022GZ() {
        AppMethodBeat.m2504i(128730);
        this.ddC = C5046bo.anU();
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128730);
        return this;
    }
}
