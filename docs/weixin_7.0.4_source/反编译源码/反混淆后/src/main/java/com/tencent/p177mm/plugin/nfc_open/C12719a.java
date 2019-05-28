package com.tencent.p177mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a.C33384d;
import com.tencent.p177mm.plugin.nfc.p472b.p1003a.C46113a;
import com.tencent.p177mm.plugin.nfc_open.p1495b.C34624a;
import com.tencent.p177mm.plugin.nfc_open.p736a.C12718b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.nfc_open.a */
public final class C12719a implements C1816at {
    private C34624a oTu;

    /* renamed from: com.tencent.mm.plugin.nfc_open.a$1 */
    class C127201 implements Runnable {
        C127201() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23053);
            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "system_config_prefs", 4);
            if (C5046bo.m7525az(sharedPreferences.getLong("NFC_REPORT_TIME", 0)) > 86400000) {
                int i;
                int eG = C46113a.bVz().mo74060eG(C4996ah.getContext());
                int i2 = eG == 0 ? 0 : 1;
                if (C33384d.aEA()) {
                    i = 1;
                } else {
                    i = 0;
                }
                C4990ab.m7417i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", Integer.valueOf(i2), Integer.valueOf(i));
                C7060h.pYm.mo8381e(12779, C1427q.m3026LK(), Integer.valueOf(i2), Integer.valueOf(i));
                Editor edit = sharedPreferences.edit();
                edit.putLong("NFC_REPORT_TIME", C5046bo.m7588yz());
                edit.commit();
                C4990ab.m7416i("MicroMsg.SubCoreCpuCard", "doNFCReport status = ".concat(String.valueOf(eG)));
            }
            AppMethodBeat.m2505o(23053);
        }
    }

    private static C12719a bVB() {
        AppMethodBeat.m2504i(23054);
        C9638aw.m17184ZE();
        C12719a c12719a = (C12719a) C45439bw.m83697oJ("plugin.nfc_open");
        if (c12719a == null) {
            C4990ab.m7420w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
            c12719a = new C12719a();
            C9638aw.m17184ZE().mo73244a("plugin.nfc_open", c12719a);
        }
        AppMethodBeat.m2505o(23054);
        return c12719a;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(23055);
        C4990ab.m7417i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", C5046bo.m7524aw(C4996ah.getContext(), Process.myPid()));
        C1720g.m3534RN().mo5159QU();
        if (C12719a.bVB().oTu == null) {
            C12719a.bVB().oTu = new C34624a();
        }
        C1202f c1202f = C12719a.bVB().oTu;
        if (c1202f.bGv()) {
            C4990ab.m7416i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
            C9638aw.m17182Rg().mo14539a(1561, c1202f);
            C9638aw.m17182Rg().mo14541a(new C12718b(c1202f.oTw.version), 0);
        }
        C9638aw.m17190ZK();
        int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            C9638aw.m17190ZK();
            if (((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
                C12719a.m20736jC(true);
            } else {
                C12719a.m20736jC(false);
            }
        } else if (intValue == 1) {
            C12719a.m20736jC(true);
        } else {
            C12719a.m20736jC(false);
        }
        C4990ab.m7416i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
        C7305d.post(new C127201(), getClass().getName());
        AppMethodBeat.m2505o(23055);
    }

    /* renamed from: jC */
    private static void m20736jC(boolean z) {
        AppMethodBeat.m2504i(23056);
        if (z) {
            C4996ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(C4996ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            AppMethodBeat.m2505o(23056);
            return;
        }
        C4996ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(C4996ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        AppMethodBeat.m2505o(23056);
    }

    public final void onAccountRelease() {
    }
}
