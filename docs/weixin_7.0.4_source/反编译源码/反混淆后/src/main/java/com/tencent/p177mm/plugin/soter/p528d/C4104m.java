package com.tencent.p177mm.plugin.soter.p528d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.p663a.C30954a;

/* renamed from: com.tencent.mm.plugin.soter.d.m */
public final class C4104m {
    private static String TAG = "MicroMsg.SoterUtil";

    public static void cvR() {
        AppMethodBeat.m2504i(59347);
        C4990ab.m7417i(TAG, "alvinluo dynamic config support soter: %b", Boolean.valueOf(C5046bo.getInt(((C7234a) C1720g.m3532RL().mo5214K(C7234a.class)).mo15608Nu().getValue("SoterEntry"), 0) == 1));
        if (C5046bo.getInt(((C7234a) C1720g.m3532RL().mo5214K(C7234a.class)).mo15608Nu().getValue("SoterEntry"), 0) == 1) {
            C4990ab.m7410d(TAG, "alvinluo set all soter support flag to true");
            C1427q.eti.cOQ = true;
            C1427q.eti.eue = 255;
            C1427q.etg.etr = 1;
            C1427q.etg.ets = 1;
            C4990ab.m7411d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", Boolean.valueOf(C1427q.eti.cOQ), Integer.valueOf(C1427q.etg.etr), Integer.valueOf(C1427q.etg.ets));
        }
        AppMethodBeat.m2505o(59347);
    }

    public static String cvS() {
        String x;
        AppMethodBeat.m2504i(59348);
        try {
            x = C1178g.m2591x(C1853r.m3821YC().getBytes());
            if (x != null) {
                x = x.substring(0, 8);
                AppMethodBeat.m2505o(59348);
                return x;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "alvinluo get md5 exception", new Object[0]);
        }
        x = "";
        AppMethodBeat.m2505o(59348);
        return x;
    }

    public static String cvT() {
        AppMethodBeat.m2504i(59349);
        String str = "WechatAuthKeyPay&" + C1853r.m3821YC();
        AppMethodBeat.m2505o(59349);
        return str;
    }

    public static boolean cvU() {
        AppMethodBeat.m2504i(139129);
        boolean cvV = C4104m.cvV();
        AppMethodBeat.m2505o(139129);
        return cvV;
    }

    private static boolean cvV() {
        AppMethodBeat.m2504i(59352);
        if (C1427q.eti.cOQ) {
            boolean dRc = C30954a.dRc();
            AppMethodBeat.m2505o(59352);
            return dRc;
        }
        C4990ab.m7416i(TAG, "hy: dynamic config is not support soter");
        AppMethodBeat.m2505o(59352);
        return false;
    }

    /* renamed from: eT */
    public static boolean m6423eT(Context context) {
        AppMethodBeat.m2504i(59350);
        if (C4104m.cvV() && C40997a.m71097iP(context)) {
            AppMethodBeat.m2505o(59350);
            return true;
        }
        AppMethodBeat.m2505o(59350);
        return false;
    }
}
