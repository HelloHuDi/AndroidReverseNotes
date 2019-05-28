package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class a implements at {
    private com.tencent.mm.plugin.nfc_open.b.a oTu;

    private static a bVB() {
        AppMethodBeat.i(23054);
        aw.ZE();
        a aVar = (a) bw.oJ("plugin.nfc_open");
        if (aVar == null) {
            ab.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
            aVar = new a();
            aw.ZE().a("plugin.nfc_open", aVar);
        }
        AppMethodBeat.o(23054);
        return aVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(23055);
        ab.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", bo.aw(ah.getContext(), Process.myPid()));
        g.RN().QU();
        if (bVB().oTu == null) {
            bVB().oTu = new com.tencent.mm.plugin.nfc_open.b.a();
        }
        f fVar = bVB().oTu;
        if (fVar.bGv()) {
            ab.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
            aw.Rg().a(1561, fVar);
            aw.Rg().a(new b(fVar.oTw.version), 0);
        }
        aw.ZK();
        int intValue = ((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            aw.ZK();
            if (((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
                jC(true);
            } else {
                jC(false);
            }
        } else if (intValue == 1) {
            jC(true);
        } else {
            jC(false);
        }
        ab.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23053);
                SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "system_config_prefs", 4);
                if (bo.az(sharedPreferences.getLong("NFC_REPORT_TIME", 0)) > 86400000) {
                    int i;
                    int eG = com.tencent.mm.plugin.nfc.b.a.a.bVz().eG(ah.getContext());
                    int i2 = eG == 0 ? 0 : 1;
                    if (com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.aEA()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    ab.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", Integer.valueOf(i2), Integer.valueOf(i));
                    h.pYm.e(12779, q.LK(), Integer.valueOf(i2), Integer.valueOf(i));
                    Editor edit = sharedPreferences.edit();
                    edit.putLong("NFC_REPORT_TIME", bo.yz());
                    edit.commit();
                    ab.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = ".concat(String.valueOf(eG)));
                }
                AppMethodBeat.o(23053);
            }
        }, getClass().getName());
        AppMethodBeat.o(23055);
    }

    private static void jC(boolean z) {
        AppMethodBeat.i(23056);
        if (z) {
            ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            AppMethodBeat.o(23056);
            return;
        }
        ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        AppMethodBeat.o(23056);
    }

    public final void onAccountRelease() {
    }
}
