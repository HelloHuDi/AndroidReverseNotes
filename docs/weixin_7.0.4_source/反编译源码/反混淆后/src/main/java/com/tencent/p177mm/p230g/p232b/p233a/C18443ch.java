package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ch */
public final class C18443ch extends C46180a {
    private long cVR = 0;
    public long cXm = 0;
    private long ddA = 0;
    public long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    private long ddd = 0;
    private String ddx = "";
    private long ddz = 0;
    private C1595a dfZ;
    public C18445c dga;
    public C18444b dgb;
    public long dgc = 0;

    /* renamed from: com.tencent.mm.g.b.a.ch$a */
    public enum C1595a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128834);
        }

        private C1595a(int i) {
            this.value = i;
        }

        /* renamed from: hi */
        public static C1595a m3235hi(int i) {
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

    /* renamed from: com.tencent.mm.g.b.a.ch$b */
    public enum C18444b {
        sync(0),
        async(1);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128837);
        }

        private C18444b(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.ch$c */
    public enum C18445c {
        ok(0),
        common_fail(1),
        bundle_null(2),
        jsapi_control_bytes_null(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128840);
        }

        private C18445c(int i) {
            this.value = i;
        }
    }

    public final int getId() {
        return 15765;
    }

    /* renamed from: hd */
    public final C18443ch mo33716hd(String str) {
        AppMethodBeat.m2504i(128841);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128841);
        return this;
    }

    /* renamed from: he */
    public final C18443ch mo33717he(String str) {
        AppMethodBeat.m2504i(128842);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128842);
        return this;
    }

    /* renamed from: eh */
    public final C18443ch mo33710eh(long j) {
        this.ddd = j;
        return this;
    }

    /* renamed from: a */
    public final C18443ch mo33709a(C1595a c1595a) {
        this.dfZ = c1595a;
        return this;
    }

    /* renamed from: ei */
    public final C18443ch mo33711ei(long j) {
        this.ddz = j;
        return this;
    }

    /* renamed from: ej */
    public final C18443ch mo33712ej(long j) {
        AppMethodBeat.m2504i(128843);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128843);
        return this;
    }

    /* renamed from: ek */
    public final C18443ch mo33713ek(long j) {
        this.cVR = j;
        return this;
    }

    /* renamed from: el */
    public final C18443ch mo33714el(long j) {
        AppMethodBeat.m2504i(128844);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128844);
        return this;
    }

    /* renamed from: em */
    public final C18443ch mo33715em(long j) {
        AppMethodBeat.m2504i(128845);
        this.ddC = j;
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128845);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.m2504i(128846);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfZ != null) {
            i = this.dfZ.value;
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
        if (this.dga != null) {
            i = this.dga.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.dgb != null) {
            i2 = this.dgb.value;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.cXm);
        stringBuffer.append(str);
        stringBuffer.append(this.dgc);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128846);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128847);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfZ);
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
        stringBuffer.append("Ret:").append(this.dga);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsSync:").append(this.dgb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetworkType:").append(this.cXm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsNormalOpen:").append(this.dgc);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128847);
        return stringBuffer2;
    }
}
