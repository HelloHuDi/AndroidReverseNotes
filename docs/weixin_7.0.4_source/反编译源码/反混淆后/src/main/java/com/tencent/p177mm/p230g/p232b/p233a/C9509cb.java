package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cb */
public final class C9509cb extends C46180a {
    private long cVR = 0;
    private String cYP = "";
    private long ddA = 0;
    private long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    private long ddd = 0;
    private String ddx = "";
    private long ddz = 0;
    private C9508a deQ;
    private long deR = 0;
    private String dex = "";

    /* renamed from: com.tencent.mm.g.b.a.cb$a */
    public enum C9508a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128772);
        }

        private C9508a(int i) {
            this.value = i;
        }

        /* renamed from: hc */
        public static C9508a m16931hc(int i) {
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
        return 16367;
    }

    /* renamed from: gQ */
    public final C9509cb mo20797gQ(String str) {
        AppMethodBeat.m2504i(128773);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128773);
        return this;
    }

    /* renamed from: gR */
    public final C9509cb mo20798gR(String str) {
        AppMethodBeat.m2504i(128774);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128774);
        return this;
    }

    /* renamed from: dU */
    public final C9509cb mo20793dU(long j) {
        this.ddd = j;
        return this;
    }

    /* renamed from: a */
    public final C9509cb mo20792a(C9508a c9508a) {
        this.deQ = c9508a;
        return this;
    }

    /* renamed from: dV */
    public final C9509cb mo20794dV(long j) {
        this.ddz = j;
        return this;
    }

    /* renamed from: dW */
    public final C9509cb mo20795dW(long j) {
        this.cVR = j;
        return this;
    }

    /* renamed from: gS */
    public final C9509cb mo20799gS(String str) {
        AppMethodBeat.m2504i(128775);
        this.dex = mo74169t("networkTypeStr", str, true);
        AppMethodBeat.m2505o(128775);
        return this;
    }

    /* renamed from: dX */
    public final C9509cb mo20796dX(long j) {
        this.deR = j;
        return this;
    }

    /* renamed from: gT */
    public final C9509cb mo20800gT(String str) {
        AppMethodBeat.m2504i(128776);
        this.cYP = mo74169t("UserName", str, true);
        AppMethodBeat.m2505o(128776);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128777);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.deQ != null) {
            i = this.deQ.value;
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
        stringBuffer.append(this.dex);
        stringBuffer.append(str);
        stringBuffer.append(this.deR);
        stringBuffer.append(str);
        stringBuffer.append(this.cYP);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128777);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128778);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.deQ);
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
        stringBuffer.append("networkTypeStr:").append(this.dex);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isLaunch:").append(this.deR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UserName:").append(this.cYP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128778);
        return stringBuffer2;
    }
}
