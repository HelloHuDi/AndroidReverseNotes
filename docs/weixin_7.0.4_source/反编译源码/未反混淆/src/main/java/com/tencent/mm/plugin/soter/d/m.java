package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m {
    private static String TAG = "MicroMsg.SoterUtil";

    public static void cvR() {
        AppMethodBeat.i(59347);
        ab.i(TAG, "alvinluo dynamic config support soter: %b", Boolean.valueOf(bo.getInt(((a) g.RL().K(a.class)).Nu().getValue("SoterEntry"), 0) == 1));
        if (bo.getInt(((a) g.RL().K(a.class)).Nu().getValue("SoterEntry"), 0) == 1) {
            ab.d(TAG, "alvinluo set all soter support flag to true");
            q.eti.cOQ = true;
            q.eti.eue = 255;
            q.etg.etr = 1;
            q.etg.ets = 1;
            ab.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", Boolean.valueOf(q.eti.cOQ), Integer.valueOf(q.etg.etr), Integer.valueOf(q.etg.ets));
        }
        AppMethodBeat.o(59347);
    }

    public static String cvS() {
        String x;
        AppMethodBeat.i(59348);
        try {
            x = com.tencent.mm.a.g.x(r.YC().getBytes());
            if (x != null) {
                x = x.substring(0, 8);
                AppMethodBeat.o(59348);
                return x;
            }
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "alvinluo get md5 exception", new Object[0]);
        }
        x = "";
        AppMethodBeat.o(59348);
        return x;
    }

    public static String cvT() {
        AppMethodBeat.i(59349);
        String str = "WechatAuthKeyPay&" + r.YC();
        AppMethodBeat.o(59349);
        return str;
    }

    public static boolean cvU() {
        AppMethodBeat.i(139129);
        boolean cvV = cvV();
        AppMethodBeat.o(139129);
        return cvV;
    }

    private static boolean cvV() {
        AppMethodBeat.i(59352);
        if (q.eti.cOQ) {
            boolean dRc = com.tencent.soter.a.a.dRc();
            AppMethodBeat.o(59352);
            return dRc;
        }
        ab.i(TAG, "hy: dynamic config is not support soter");
        AppMethodBeat.o(59352);
        return false;
    }

    public static boolean eT(Context context) {
        AppMethodBeat.i(59350);
        if (cvV() && com.tencent.soter.core.a.iP(context)) {
            AppMethodBeat.o(59350);
            return true;
        }
        AppMethodBeat.o(59350);
        return false;
    }
}
