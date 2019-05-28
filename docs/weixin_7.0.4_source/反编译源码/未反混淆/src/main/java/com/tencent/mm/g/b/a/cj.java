package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cj extends com.tencent.mm.plugin.report.a {
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
    public a dgv;
    public long dgw = 0;
    public c dgx;
    public b dgy;
    public long dgz = 0;

    public enum b {
        sync(0),
        unsync(1);
        
        final int value;

        static {
            AppMethodBeat.o(128862);
        }

        private b(int i) {
            this.value = i;
        }
    }

    public enum c {
        sync(0),
        unsync(1);
        
        final int value;

        static {
            AppMethodBeat.o(128865);
        }

        private c(int i) {
            this.value = i;
        }
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128859);
        }

        private a(int i) {
            this.value = i;
        }

        public static a hk(int i) {
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

    public final cj hh(String str) {
        AppMethodBeat.i(128866);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128866);
        return this;
    }

    public final cj hi(String str) {
        AppMethodBeat.i(128867);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128867);
        return this;
    }

    public final cj ep(long j) {
        AppMethodBeat.i(128868);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128868);
        return this;
    }

    public final cj eq(long j) {
        AppMethodBeat.i(128869);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128869);
        return this;
    }

    public final String Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.i(128871);
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
        VX(stringBuffer2);
        AppMethodBeat.o(128871);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128872);
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
        AppMethodBeat.o(128872);
        return stringBuffer2;
    }

    public final cj Hg() {
        AppMethodBeat.i(128870);
        this.ddC = bo.anU();
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128870);
        return this;
    }
}
