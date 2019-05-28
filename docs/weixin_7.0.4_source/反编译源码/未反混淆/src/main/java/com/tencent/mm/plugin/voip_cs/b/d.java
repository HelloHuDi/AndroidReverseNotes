package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class d {
    public static int MOBILE_NETWORK_DISCONNECT = 2;
    public static int tcM = 0;
    public static int tcN = 1;
    public int channelStrategy;
    public int cpuFlag0;
    public int dataType;
    public String deviceModel;
    public int networkType;
    public long nwv;
    public long nxM;
    public String nxV;
    public String nxW;
    public int sTX;
    public int sUl;
    public int sUq;
    public int sUr;
    public int sUs;
    public int sVG;
    public int tcO;
    public int tcP;
    public int tcQ;
    public int tcR;
    public int tcS;
    public int tcT;
    public int tcU;
    public int tcV;
    public int tcW;
    public int tcX;
    public int tcY;
    public int tcZ;
    public int tdA;
    public int tdB;
    public int tdC;
    public int tdD;
    public int tdE;
    public long tda;
    public String tdb;
    public int tdc;
    public int tdd;
    public int tde;
    public int tdf;
    public int tdg;
    public int tdh;
    public int tdi;
    public int tdj;
    public int tdk;
    public int tdl;
    public int tdm;
    public long tdn;
    public int tdo;
    public long tdp;
    public long tdq;
    public long tdr;
    public int tds;
    public int tdt;
    public int tdu;
    public int tdv;
    public String tdw;
    public String tdx;
    public String tdy;
    public int tdz;
    public int videoFps;

    public d() {
        AppMethodBeat.i(135297);
        this.dataType = 0;
        this.tcO = 0;
        this.tcP = 0;
        this.tcQ = 0;
        this.videoFps = 0;
        this.tcR = 0;
        this.tcS = 0;
        this.tcT = 0;
        this.tcU = 0;
        this.tcV = 0;
        this.tcW = 0;
        this.networkType = 0;
        this.tcX = 0;
        this.tcZ = 0;
        this.sUl = 0;
        this.tda = 0;
        this.nwv = 0;
        this.tdb = "";
        this.sTX = 0;
        this.tdd = 0;
        this.tde = 0;
        this.tdf = 0;
        this.tdg = 0;
        this.sUr = 0;
        this.sUq = 0;
        this.tdh = 0;
        this.tdi = 1;
        this.tdj = 0;
        this.tdk = 0;
        this.tdl = 0;
        this.tdm = 0;
        this.tdn = 0;
        this.tdp = 0;
        this.tdq = 0;
        this.tdr = 0;
        this.nxM = 0;
        this.channelStrategy = 1;
        this.sVG = 0;
        this.sUs = 0;
        this.tdu = -1;
        this.tdv = 0;
        this.tdw = "";
        this.deviceModel = "";
        this.tdx = "";
        this.tdy = "";
        this.tdz = 0;
        this.tdA = 0;
        this.tdB = 0;
        this.tdC = 0;
        this.tdD = 0;
        this.tdE = 0;
        this.cpuFlag0 = m.Lw();
        this.nxW = "";
        this.nxV = "";
        this.tdw = Build.MANUFACTURER;
        if (this.tdw.contains(",")) {
            this.tdw = this.tdw.replace(',', ' ');
        }
        this.deviceModel = Build.MODEL;
        if (this.deviceModel.contains(",")) {
            this.deviceModel = this.deviceModel.replace(',', ' ');
        }
        this.tdx = VERSION.SDK;
        if (this.tdx.contains(",")) {
            this.tdx = this.tdx.replace(',', ' ');
        }
        this.tdy = VERSION.RELEASE;
        if (this.tdy.contains(",")) {
            this.tdy = this.tdy.replace(',', ' ');
        }
        AppMethodBeat.o(135297);
    }

    public final void GW(int i) {
        AppMethodBeat.i(135298);
        this.sUq = Math.abs(i);
        AppMethodBeat.o(135298);
    }

    public final void cMh() {
        AppMethodBeat.i(135299);
        ab.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
        if (this.tdD == 0 && this.tdC != 0) {
            this.tdD = (int) (System.currentTimeMillis() / 1000);
            this.nxM = (long) (this.tdD - this.tdC);
        }
        AppMethodBeat.o(135299);
    }

    public final void cMi() {
        AppMethodBeat.i(135300);
        ab.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
        if (this.tdp == 0) {
            this.tdB = (int) (System.currentTimeMillis() / 1000);
            this.tdp = (long) (this.tdB - this.tdz);
        }
        AppMethodBeat.o(135300);
    }

    public final coy cMj() {
        AppMethodBeat.i(135301);
        coy coy = new coy();
        coy.jCt = 2;
        coy.xmI = this.nxV;
        ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", coy.xmI);
        String[] split = this.nxV.split(",");
        if (split != null && split.length > 0) {
            try {
                this.videoFps = bo.getInt(split[8], 0);
                this.tcR = bo.getInt(split[10], 0);
            } catch (Exception e) {
                ab.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
            }
        }
        AppMethodBeat.o(135301);
        return coy;
    }

    public static int cMk() {
        int i;
        AppMethodBeat.i(135302);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ah.getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null) {
                    i = tcM;
                    AppMethodBeat.o(135302);
                    return i;
                } else if (networkInfo.getState() == State.CONNECTED) {
                    i = tcN;
                    AppMethodBeat.o(135302);
                    return i;
                } else {
                    i = MOBILE_NETWORK_DISCONNECT;
                    AppMethodBeat.o(135302);
                    return i;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
        }
        i = tcM;
        AppMethodBeat.o(135302);
        return i;
    }

    public static int getNetType(Context context) {
        AppMethodBeat.i(135303);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(135303);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(135303);
                return 1;
            } else if (activeNetworkInfo.getType() != 0) {
                AppMethodBeat.o(135303);
                return 0;
            } else if (activeNetworkInfo.getSubtype() == 1) {
                AppMethodBeat.o(135303);
                return 2;
            } else if (activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.o(135303);
                return 2;
            } else if (activeNetworkInfo.getSubtype() == 13) {
                AppMethodBeat.o(135303);
                return 4;
            } else if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                AppMethodBeat.o(135303);
                return 2;
            } else {
                AppMethodBeat.o(135303);
                return 3;
            }
        } catch (NullPointerException e) {
            ab.printErrStackTrace("MicroMsg.VoipCSReportHelper", e, "", new Object[0]);
            AppMethodBeat.o(135303);
            return 0;
        }
    }
}
