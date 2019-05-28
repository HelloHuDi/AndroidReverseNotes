package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cl */
public final class C42096cl extends C46180a {
    private String bUh = "";
    public long cVR = 0;
    private long ddA = 0;
    private long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    public long ddg = 0;
    private String ddx = "";
    public long ddz = 0;
    public long deD = 0;
    private String dex = "";
    public C32672a dgQ;

    /* renamed from: com.tencent.mm.g.b.a.cl$a */
    public enum C32672a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128885);
        }

        private C32672a(int i) {
            this.value = i;
        }

        /* renamed from: hm */
        public static C32672a m53304hm(int i) {
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
        return 16011;
    }

    /* renamed from: hl */
    public final C42096cl mo67657hl(String str) {
        AppMethodBeat.m2504i(128886);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128886);
        return this;
    }

    /* renamed from: hm */
    public final C42096cl mo67658hm(String str) {
        AppMethodBeat.m2504i(128887);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128887);
        return this;
    }

    /* renamed from: et */
    public final C42096cl mo67655et(long j) {
        AppMethodBeat.m2504i(128888);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128888);
        return this;
    }

    /* renamed from: eu */
    public final C42096cl mo67656eu(long j) {
        AppMethodBeat.m2504i(128889);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128889);
        return this;
    }

    /* renamed from: hn */
    public final C42096cl mo67659hn(String str) {
        AppMethodBeat.m2504i(128891);
        this.bUh = mo74169t("path", str, true);
        AppMethodBeat.m2505o(128891);
        return this;
    }

    /* renamed from: ho */
    public final C42096cl mo67660ho(String str) {
        AppMethodBeat.m2504i(128892);
        this.dex = mo74169t("networkTypeStr", str, true);
        AppMethodBeat.m2505o(128892);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128893);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dgQ != null) {
            i = this.dgQ.value;
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
        stringBuffer.append(this.bUh);
        stringBuffer.append(str);
        stringBuffer.append(this.ddg);
        stringBuffer.append(str);
        stringBuffer.append(this.deD);
        stringBuffer.append(str);
        stringBuffer.append(this.dex);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128893);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128894);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dgQ);
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
        stringBuffer.append("path:").append(this.bUh);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isPreload:").append(this.ddg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isPreloadPageFrame:").append(this.deD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("networkTypeStr:").append(this.dex);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128894);
        return stringBuffer2;
    }

    /* renamed from: Hi */
    public final C42096cl mo67654Hi() {
        AppMethodBeat.m2504i(128890);
        this.ddC = C5046bo.anU();
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128890);
        return this;
    }
}
