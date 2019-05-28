package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

/* renamed from: com.tencent.mm.g.b.a.cg */
public final class C37827cg extends C46180a {
    public long cVR = 0;
    public long cXm = 0;
    private long ddA = 0;
    private long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;
    public C26284a dfQ;
    public C9511b dfR;

    /* renamed from: com.tencent.mm.g.b.a.cg$b */
    public enum C9511b {
        ok(0),
        common_fail(1);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128823);
        }

        private C9511b(int i) {
            this.value = i;
        }

        /* renamed from: hh */
        public static C9511b m16943hh(int i) {
            switch (i) {
                case 0:
                    return ok;
                case 1:
                    return common_fail;
                default:
                    return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.cg$a */
    public enum C26284a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128820);
        }

        private C26284a(int i) {
            this.value = i;
        }

        /* renamed from: hg */
        public static C26284a m41748hg(int i) {
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

    public C37827cg(String str) {
        AppMethodBeat.m2504i(128824);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 11) {
                    strArr = new String[11];
                    Arrays.fill(strArr, 0, 11, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                mo60539hb(strArr[0]);
                mo60540hc(strArr[1]);
                this.ddd = C5046bo.getLong(strArr[2], 0);
                this.dfQ = C26284a.m41748hg(C5046bo.getInt(strArr[3], 0));
                this.ddz = C5046bo.getLong(strArr[4], 0);
                mo60536ee(C5046bo.getLong(strArr[5], 0));
                this.cVR = C5046bo.getLong(strArr[6], 0);
                mo60537ef(C5046bo.getLong(strArr[7], 0));
                mo60538eg(C5046bo.getLong(strArr[8], 0));
                this.dfR = C9511b.m16943hh(C5046bo.getInt(strArr[9], 0));
                this.cXm = C5046bo.getLong(strArr[10], 0);
            }
        }
        AppMethodBeat.m2505o(128824);
    }

    public final int getId() {
        return 15798;
    }

    /* renamed from: hb */
    public final C37827cg mo60539hb(String str) {
        AppMethodBeat.m2504i(128825);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128825);
        return this;
    }

    /* renamed from: hc */
    public final C37827cg mo60540hc(String str) {
        AppMethodBeat.m2504i(128826);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128826);
        return this;
    }

    /* renamed from: ee */
    public final C37827cg mo60536ee(long j) {
        AppMethodBeat.m2504i(128827);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128827);
        return this;
    }

    /* renamed from: ef */
    public final C37827cg mo60537ef(long j) {
        AppMethodBeat.m2504i(128828);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128828);
        return this;
    }

    /* renamed from: eg */
    public final C37827cg mo60538eg(long j) {
        AppMethodBeat.m2504i(128829);
        this.ddC = j;
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128829);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.m2504i(128830);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfQ != null) {
            i = this.dfQ.value;
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
        if (this.dfR != null) {
            i2 = this.dfR.value;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.cXm);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128830);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128831);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfQ);
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
        stringBuffer.append("Ret:").append(this.dfR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetworkType:").append(this.cXm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128831);
        return stringBuffer2;
    }
}
