package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cj */
public final class C18448cj extends C46180a {
    public long cVR = 0;
    public long cXm = 0;
    private long ddA = 0;
    private long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;
    private long dgA = 0;
    public C18450a dgv;
    public long dgw = 0;
    public C18449c dgx;
    public C9512b dgy;
    public long dgz = 0;

    /* renamed from: com.tencent.mm.g.b.a.cj$b */
    public enum C9512b {
        sync(0),
        unsync(1);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128862);
        }

        private C9512b(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.cj$c */
    public enum C18449c {
        sync(0),
        unsync(1);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128865);
        }

        private C18449c(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.cj$a */
    public enum C18450a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128859);
        }

        private C18450a(int i) {
            this.value = i;
        }

        /* renamed from: hk */
        public static C18450a m28711hk(int i) {
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
        return 15766;
    }

    /* renamed from: hh */
    public final C18448cj mo33725hh(String str) {
        AppMethodBeat.m2504i(128866);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128866);
        return this;
    }

    /* renamed from: hi */
    public final C18448cj mo33726hi(String str) {
        AppMethodBeat.m2504i(128867);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128867);
        return this;
    }

    /* renamed from: ep */
    public final C18448cj mo33723ep(long j) {
        AppMethodBeat.m2504i(128868);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128868);
        return this;
    }

    /* renamed from: eq */
    public final C18448cj mo33724eq(long j) {
        AppMethodBeat.m2504i(128869);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128869);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.m2504i(128871);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dgv != null) {
            i = this.dgv.value;
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
        stringBuffer.append(this.dgw);
        stringBuffer.append(str);
        if (this.dgx != null) {
            i = this.dgx.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.dgy != null) {
            i2 = this.dgy.value;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.cXm);
        stringBuffer.append(str);
        stringBuffer.append(this.dgz);
        stringBuffer.append(str);
        stringBuffer.append(this.dgA);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128871);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128872);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dgv);
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
        stringBuffer.append("PkgSize:").append(this.dgw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsLaunchSync:").append(this.dgx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsContactSync:").append(this.dgy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetworkType:").append(this.cXm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasDownloadCode:").append(this.dgz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsFirstDownload:").append(this.dgA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128872);
        return stringBuffer2;
    }

    /* renamed from: Hg */
    public final C18448cj mo33722Hg() {
        AppMethodBeat.m2504i(128870);
        this.ddC = C5046bo.anU();
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128870);
        return this;
    }
}
