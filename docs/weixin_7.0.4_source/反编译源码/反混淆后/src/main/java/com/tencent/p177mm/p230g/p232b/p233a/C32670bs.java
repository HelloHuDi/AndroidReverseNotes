package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bs */
public final class C32670bs extends C46180a {
    public long cVR = 0;
    public long dbX = 0;
    private long ddA = 0;
    public long ddB = 0;
    public long ddC = 0;
    public C9506a ddN;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;

    /* renamed from: com.tencent.mm.g.b.a.bs$a */
    public enum C9506a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128678);
        }

        private C9506a(int i) {
            this.value = i;
        }

        /* renamed from: gT */
        public static C9506a m16929gT(int i) {
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
        return 16895;
    }

    /* renamed from: gr */
    public final C32670bs mo53199gr(String str) {
        AppMethodBeat.m2504i(128679);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128679);
        return this;
    }

    /* renamed from: gs */
    public final C32670bs mo53200gs(String str) {
        AppMethodBeat.m2504i(128680);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128680);
        return this;
    }

    /* renamed from: dB */
    public final C32670bs mo53196dB(long j) {
        AppMethodBeat.m2504i(128681);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128681);
        return this;
    }

    /* renamed from: dC */
    public final C32670bs mo53197dC(long j) {
        AppMethodBeat.m2504i(128682);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128682);
        return this;
    }

    /* renamed from: dD */
    public final C32670bs mo53198dD(long j) {
        AppMethodBeat.m2504i(128683);
        this.ddC = j;
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128683);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128684);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.ddN != null) {
            i = this.ddN.value;
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
        AppMethodBeat.m2505o(128684);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128685);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.ddN);
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
        AppMethodBeat.m2505o(128685);
        return stringBuffer2;
    }
}
