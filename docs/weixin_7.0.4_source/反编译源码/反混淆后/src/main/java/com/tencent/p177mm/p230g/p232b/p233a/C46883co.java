package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.co */
public final class C46883co extends C46180a {
    private long cVR = 0;
    private long cVS = 0;
    private long ddA = 0;
    private String ddc = "";
    private long ddz = 0;
    private C45383a dhg;
    private String dhh = "";

    /* renamed from: com.tencent.mm.g.b.a.co$a */
    public enum C45383a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128904);
        }

        private C45383a(int i) {
            this.value = i;
        }

        /* renamed from: ho */
        public static C45383a m83560ho(int i) {
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
        return 17147;
    }

    /* renamed from: hu */
    public final C46883co mo76075hu(String str) {
        AppMethodBeat.m2504i(128905);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128905);
        return this;
    }

    /* renamed from: a */
    public final C46883co mo76070a(C45383a c45383a) {
        this.dhg = c45383a;
        return this;
    }

    /* renamed from: ev */
    public final C46883co mo76071ev(long j) {
        this.ddz = j;
        return this;
    }

    /* renamed from: ew */
    public final C46883co mo76072ew(long j) {
        AppMethodBeat.m2504i(128906);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128906);
        return this;
    }

    /* renamed from: ex */
    public final C46883co mo76073ex(long j) {
        this.cVR = j;
        return this;
    }

    /* renamed from: ey */
    public final C46883co mo76074ey(long j) {
        this.cVS = j;
        return this;
    }

    /* renamed from: hv */
    public final C46883co mo76076hv(String str) {
        AppMethodBeat.m2504i(128907);
        this.dhh = mo74169t("ErrMsg", str, true);
        AppMethodBeat.m2505o(128907);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128908);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        if (this.dhg != null) {
            i = this.dhg.value;
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
        stringBuffer.append(this.cVS);
        stringBuffer.append(str);
        stringBuffer.append(this.dhh);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128908);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128909);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dhg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CostTimeMs:").append(this.ddA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ErrMsg:").append(this.dhh);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128909);
        return stringBuffer2;
    }
}
