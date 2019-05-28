package com.tencent.mm.plugin.report.service;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.BaseInfo;
import com.tencent.mars.smc.SmcLogic.ICallBack;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.b.h;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.g;
import java.util.Map;

public final class i implements ICallBack {
    public static IKVReportNotify pYC = null;

    public final void onReportDataReady(byte[] bArr, byte[] bArr2, int i) {
        AppMethodBeat.i(72794);
        try {
            if (!(pYC == null || bArr2 == null || bArr2.length <= 0)) {
                pYC.onReportKVDataReady(bArr, bArr2, i);
            }
            AppMethodBeat.o(72794);
        } catch (Exception e) {
            ab.e("KVReportJni", e.getMessage());
            AppMethodBeat.o(72794);
        }
    }

    public final boolean onRequestGetStrategy(byte[] bArr, int i) {
        AppMethodBeat.i(72795);
        try {
            if (g.xyf && ah.getContext().getSharedPreferences(ah.doA(), 0).getBoolean("gprs_alert", true)) {
                ab.i("MicroMsg.SmcCallBack", "onRequestGetStrategy gprs alert return false");
                AppMethodBeat.o(72795);
                return false;
            }
            synchronized (this) {
                if (h.isRunning()) {
                    ab.i("KVReportJni", "already running");
                    AppMethodBeat.o(72795);
                    return false;
                }
                com.tencent.mm.kernel.g.RO().eJo.a(new h(), 0);
                AppMethodBeat.o(72795);
                return true;
            }
        } catch (Exception e) {
            ab.e("KVReportJni", "onRequestGetStrategy error: " + e.getMessage());
            AppMethodBeat.o(72795);
            return false;
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(72795);
            }
        }
    }

    public final boolean OnSelfMonitorOpLogReady(byte[] bArr) {
        AppMethodBeat.i(72796);
        com.tencent.mm.kernel.g.RN();
        if (a.QX()) {
            try {
                k kVar = new k();
                kVar.parseFrom(bArr);
                auf toMMSelfMonitor = SmcProtoBufUtil.toMMSelfMonitor(kVar);
                if (toMMSelfMonitor.wye <= 0) {
                    ab.e("KVReportJni", "error selfmonitor count");
                    AppMethodBeat.o(72796);
                    return true;
                }
                ((j) com.tencent.mm.kernel.g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(202, toMMSelfMonitor));
                AppMethodBeat.o(72796);
                return true;
            } catch (Exception e) {
                ab.e("KVReportJni", e.getMessage());
                AppMethodBeat.o(72796);
                return false;
            }
        }
        ab.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
        AppMethodBeat.o(72796);
        return false;
    }

    public final int getSingleReportBufSizeB() {
        return 20480;
    }

    public final BaseInfo getKVCommReqBaseInfo() {
        AppMethodBeat.i(72797);
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.deviceModel = Build.MODEL + Build.CPU_ABI;
        baseInfo.deviceBrand = Build.BRAND;
        baseInfo.osName = "android-" + Build.MANUFACTURER;
        baseInfo.osVersion = VERSION.SDK_INT;
        baseInfo.languageVer = aa.dor();
        AppMethodBeat.o(72797);
        return baseInfo;
    }

    public final String getKVCommPath() {
        AppMethodBeat.i(72798);
        String str = AppLogic.getAppFilePath() + "/kvcomm/";
        ab.i("MicroMsg.SmcCallBack", "[TEST-PATH (Smc)]path:" + AppLogic.getAppFilePath());
        AppMethodBeat.o(72798);
        return str;
    }

    public static void Wa(String str) {
        AppMethodBeat.i(72799);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.SmcCallBack", "msg content is null");
            AppMethodBeat.o(72799);
            return;
        }
        ab.i("MicroMsg.SmcCallBack", "receive msg: ".concat(String.valueOf(str)));
        Map z = br.z(str, "sysmsg");
        if (z == null || z.size() == 0) {
            ab.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.o(72799);
            return;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        if (bo.isNullOrNil(str2) || !str2.equalsIgnoreCase("getkvidkeystg")) {
            ab.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.o(72799);
            return;
        }
        long j = bo.getLong((String) z.get(".sysmsg.getkvidkeystg.generalversion"), -1);
        long j2 = bo.getLong((String) z.get(".sysmsg.getkvidkeystg.specialversion"), -1);
        long j3 = bo.getLong((String) z.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1);
        long j4 = bo.getLong((String) z.get(".sysmsg.getkvidkeystg.timeinterval"), -1);
        long j5 = bo.getLong((String) z.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1);
        long j6 = bo.getLong((String) z.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1);
        long j7 = bo.getLong((String) z.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1);
        if (j == -1 || j2 == -1 || j3 == -1 || j4 == -1 || -1 == j5 || -1 == j6 || -1 == j7) {
            ab.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.o(72799);
            return;
        }
        ab.i("MicroMsg.SmcCallBack", "plugin msg version:" + j + ", " + j2 + ", " + j3);
        SmcLogic.OnPluginMsg(j5, j6, j7, j, j2, j4);
        AppMethodBeat.o(72799);
    }
}
