package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a */
public final class C38281a {
    public static C38281a hDK = new C26939a().aCP();
    public static boolean hDN = false;
    public static boolean hDO = true;
    public static boolean hDQ = true;
    public static boolean hDS = false;
    public static int hDT = 5;
    public static boolean hDX = true;
    public boolean aJe;
    public int eCL;
    public boolean hDL;
    public long hDM;
    public boolean hDP;
    public boolean hDR;
    public String hDU;
    public int hDV;
    public boolean hDW;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a$a */
    public static class C26939a {
        public boolean aJe = C38281a.hDN;
        public int eCL = 0;
        public boolean hDL = false;
        long hDM = 20000;
        public boolean hDP = C38281a.hDO;
        public boolean hDR = C38281a.hDQ;
        public String hDU = "middle";
        public int hDV = 10;
        public boolean hDW = true;

        public final C38281a aCP() {
            AppMethodBeat.m2504i(94216);
            C38281a c38281a = new C38281a(this);
            AppMethodBeat.m2505o(94216);
            return c38281a;
        }
    }

    static {
        AppMethodBeat.m2504i(94218);
        AppMethodBeat.m2505o(94218);
    }

    /* renamed from: a */
    public static void m64772a(C38281a c38281a) {
        hDK = c38281a;
    }

    public C38281a(C26939a c26939a) {
        this.eCL = c26939a.eCL;
        this.hDL = c26939a.hDL;
        this.hDM = c26939a.hDM;
        this.aJe = c26939a.aJe;
        this.hDP = c26939a.hDP;
        this.hDR = c26939a.hDR;
        this.hDU = c26939a.hDU;
        this.hDV = c26939a.hDV;
        this.hDW = c26939a.hDW;
    }

    public final String toString() {
        AppMethodBeat.m2504i(94217);
        String str = "BleConfig{interval=" + this.eCL + ", allowDuplicatesKey=" + this.hDL + ", actionTimeOutTime=" + this.hDM + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + ", mode='" + this.hDU + '\'' + ", actionDelayTime=" + this.hDV + '}';
        AppMethodBeat.m2505o(94217);
        return str;
    }
}
