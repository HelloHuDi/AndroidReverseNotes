package com.tencent.p177mm.plugin.report.service;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.BaseInfo;
import com.tencent.mars.smc.SmcLogic.ICallBack;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.p499b.C7050h;
import com.tencent.p177mm.protocal.p1084a.p1085a.C23366k;
import com.tencent.p177mm.protocal.protobuf.auf;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.report.service.i */
public final class C34831i implements ICallBack {
    public static IKVReportNotify pYC = null;

    public final void onReportDataReady(byte[] bArr, byte[] bArr2, int i) {
        AppMethodBeat.m2504i(72794);
        try {
            if (!(pYC == null || bArr2 == null || bArr2.length <= 0)) {
                pYC.onReportKVDataReady(bArr, bArr2, i);
            }
            AppMethodBeat.m2505o(72794);
        } catch (Exception e) {
            C4990ab.m7412e("KVReportJni", e.getMessage());
            AppMethodBeat.m2505o(72794);
        }
    }

    public final boolean onRequestGetStrategy(byte[] bArr, int i) {
        AppMethodBeat.m2504i(72795);
        try {
            if (C5059g.xyf && C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getBoolean("gprs_alert", true)) {
                C4990ab.m7416i("MicroMsg.SmcCallBack", "onRequestGetStrategy gprs alert return false");
                AppMethodBeat.m2505o(72795);
                return false;
            }
            synchronized (this) {
                if (C7050h.isRunning()) {
                    C4990ab.m7416i("KVReportJni", "already running");
                    AppMethodBeat.m2505o(72795);
                    return false;
                }
                C1720g.m3535RO().eJo.mo14541a(new C7050h(), 0);
                AppMethodBeat.m2505o(72795);
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7412e("KVReportJni", "onRequestGetStrategy error: " + e.getMessage());
            AppMethodBeat.m2505o(72795);
            return false;
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(72795);
            }
        }
    }

    public final boolean OnSelfMonitorOpLogReady(byte[] bArr) {
        AppMethodBeat.m2504i(72796);
        C1720g.m3534RN();
        if (C1668a.m3395QX()) {
            try {
                C23366k c23366k = new C23366k();
                c23366k.parseFrom(bArr);
                auf toMMSelfMonitor = SmcProtoBufUtil.toMMSelfMonitor(c23366k);
                if (toMMSelfMonitor.wye <= 0) {
                    C4990ab.m7412e("KVReportJni", "error selfmonitor count");
                    AppMethodBeat.m2505o(72796);
                    return true;
                }
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(202, toMMSelfMonitor));
                AppMethodBeat.m2505o(72796);
                return true;
            } catch (Exception e) {
                C4990ab.m7412e("KVReportJni", e.getMessage());
                AppMethodBeat.m2505o(72796);
                return false;
            }
        }
        C4990ab.m7412e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
        AppMethodBeat.m2505o(72796);
        return false;
    }

    public final int getSingleReportBufSizeB() {
        return 20480;
    }

    public final BaseInfo getKVCommReqBaseInfo() {
        AppMethodBeat.m2504i(72797);
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.deviceModel = Build.MODEL + Build.CPU_ABI;
        baseInfo.deviceBrand = Build.BRAND;
        baseInfo.osName = "android-" + Build.MANUFACTURER;
        baseInfo.osVersion = VERSION.SDK_INT;
        baseInfo.languageVer = C4988aa.dor();
        AppMethodBeat.m2505o(72797);
        return baseInfo;
    }

    public final String getKVCommPath() {
        AppMethodBeat.m2504i(72798);
        String str = AppLogic.getAppFilePath() + "/kvcomm/";
        C4990ab.m7416i("MicroMsg.SmcCallBack", "[TEST-PATH (Smc)]path:" + AppLogic.getAppFilePath());
        AppMethodBeat.m2505o(72798);
        return str;
    }

    /* renamed from: Wa */
    public static void m57200Wa(String str) {
        AppMethodBeat.m2504i(72799);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.SmcCallBack", "msg content is null");
            AppMethodBeat.m2505o(72799);
            return;
        }
        C4990ab.m7416i("MicroMsg.SmcCallBack", "receive msg: ".concat(String.valueOf(str)));
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null || z.size() == 0) {
            C4990ab.m7412e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(72799);
            return;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        if (C5046bo.isNullOrNil(str2) || !str2.equalsIgnoreCase("getkvidkeystg")) {
            C4990ab.m7412e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(72799);
            return;
        }
        long j = C5046bo.getLong((String) z.get(".sysmsg.getkvidkeystg.generalversion"), -1);
        long j2 = C5046bo.getLong((String) z.get(".sysmsg.getkvidkeystg.specialversion"), -1);
        long j3 = C5046bo.getLong((String) z.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1);
        long j4 = C5046bo.getLong((String) z.get(".sysmsg.getkvidkeystg.timeinterval"), -1);
        long j5 = C5046bo.getLong((String) z.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1);
        long j6 = C5046bo.getLong((String) z.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1);
        long j7 = C5046bo.getLong((String) z.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1);
        if (j == -1 || j2 == -1 || j3 == -1 || j4 == -1 || -1 == j5 || -1 == j6 || -1 == j7) {
            C4990ab.m7412e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(72799);
            return;
        }
        C4990ab.m7416i("MicroMsg.SmcCallBack", "plugin msg version:" + j + ", " + j2 + ", " + j3);
        SmcLogic.OnPluginMsg(j5, j6, j7, j, j2, j4);
        AppMethodBeat.m2505o(72799);
    }
}
