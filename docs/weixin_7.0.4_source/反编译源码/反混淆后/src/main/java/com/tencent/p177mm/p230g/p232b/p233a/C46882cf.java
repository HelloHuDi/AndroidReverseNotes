package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cf */
public final class C46882cf extends C46180a {
    private long cVR = 0;
    public long cXm = 0;
    private long ddA = 0;
    private long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    private long ddd = 0;
    private String ddx = "";
    private long ddz = 0;
    private C26282a dfD;
    public C26283c dfE;
    public C9510b dfF;

    /* renamed from: com.tencent.mm.g.b.a.cf$b */
    public enum C9510b {
        sync(0),
        async(1);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128807);
        }

        private C9510b(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.cf$a */
    public enum C26282a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128804);
        }

        private C26282a(int i) {
            this.value = i;
        }

        /* renamed from: hf */
        public static C26282a m41747hf(int i) {
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

    /* renamed from: com.tencent.mm.g.b.a.cf$c */
    public enum C26283c {
        ok(0),
        common_fail(1);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128810);
        }

        private C26283c(int i) {
            this.value = i;
        }
    }

    public final int getId() {
        return 15764;
    }

    /* renamed from: gZ */
    public final C46882cf mo76068gZ(String str) {
        AppMethodBeat.m2504i(128811);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128811);
        return this;
    }

    /* renamed from: ha */
    public final C46882cf mo76069ha(String str) {
        AppMethodBeat.m2504i(128812);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128812);
        return this;
    }

    /* renamed from: dY */
    public final C46882cf mo76062dY(long j) {
        this.ddd = j;
        return this;
    }

    /* renamed from: a */
    public final C46882cf mo76061a(C26282a c26282a) {
        this.dfD = c26282a;
        return this;
    }

    /* renamed from: dZ */
    public final C46882cf mo76063dZ(long j) {
        this.ddz = j;
        return this;
    }

    /* renamed from: ea */
    public final C46882cf mo76064ea(long j) {
        AppMethodBeat.m2504i(128813);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128813);
        return this;
    }

    /* renamed from: eb */
    public final C46882cf mo76065eb(long j) {
        this.cVR = j;
        return this;
    }

    /* renamed from: ec */
    public final C46882cf mo76066ec(long j) {
        AppMethodBeat.m2504i(128814);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128814);
        return this;
    }

    /* renamed from: ed */
    public final C46882cf mo76067ed(long j) {
        AppMethodBeat.m2504i(128815);
        this.ddC = j;
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128815);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.m2504i(128816);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfD != null) {
            i = this.dfD.value;
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
        if (this.dfE != null) {
            i = this.dfE.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.dfF != null) {
            i2 = this.dfF.value;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.cXm);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128816);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128817);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfD);
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
        stringBuffer.append("Ret:").append(this.dfE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsSync:").append(this.dfF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetworkType:").append(this.cXm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128817);
        return stringBuffer2;
    }
}
