package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static a hDK = new a().aCP();
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

    public static class a {
        public boolean aJe = a.hDN;
        public int eCL = 0;
        public boolean hDL = false;
        long hDM = 20000;
        public boolean hDP = a.hDO;
        public boolean hDR = a.hDQ;
        public String hDU = "middle";
        public int hDV = 10;
        public boolean hDW = true;

        public final a aCP() {
            AppMethodBeat.i(94216);
            a aVar = new a(this);
            AppMethodBeat.o(94216);
            return aVar;
        }
    }

    static {
        AppMethodBeat.i(94218);
        AppMethodBeat.o(94218);
    }

    public static void a(a aVar) {
        hDK = aVar;
    }

    public a(a aVar) {
        this.eCL = aVar.eCL;
        this.hDL = aVar.hDL;
        this.hDM = aVar.hDM;
        this.aJe = aVar.aJe;
        this.hDP = aVar.hDP;
        this.hDR = aVar.hDR;
        this.hDU = aVar.hDU;
        this.hDV = aVar.hDV;
        this.hDW = aVar.hDW;
    }

    public final String toString() {
        AppMethodBeat.i(94217);
        String str = "BleConfig{interval=" + this.eCL + ", allowDuplicatesKey=" + this.hDL + ", actionTimeOutTime=" + this.hDM + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + ", mode='" + this.hDU + '\'' + ", actionDelayTime=" + this.hDV + '}';
        AppMethodBeat.o(94217);
        return str;
    }
}
