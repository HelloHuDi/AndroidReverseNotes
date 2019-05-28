package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class d {
    private static long tVb = -1;

    public static g cTB() {
        AppMethodBeat.i(51560);
        z Ry = g.RP().Ry();
        g gVar;
        if (Ry == null) {
            gVar = new g();
            AppMethodBeat.o(51560);
            return gVar;
        }
        Object obj = Ry.get(339969, null);
        if (obj == null) {
            gVar = new g();
            AppMethodBeat.o(51560);
            return gVar;
        }
        gVar = new g().bz(e.stringToBytes((String) obj));
        AppMethodBeat.o(51560);
        return gVar;
    }

    public static void ac(long j, long j2) {
        AppMethodBeat.i(51561);
        z Ry = g.RP().Ry();
        if (Ry != null) {
            g gVar = new g();
            gVar.tVD = j;
            gVar.tVE = j2;
            Ry.set(339969, e.by(gVar.toByteArray()));
            Ry.dsb();
        }
        AppMethodBeat.o(51561);
    }

    public static void cTC() {
        AppMethodBeat.i(51562);
        z Ry = g.RP().Ry();
        if (Ry != null) {
            Ry.set(339969, null);
            Ry.dsb();
        }
        AppMethodBeat.o(51562);
    }

    public static long cTr() {
        return tVb;
    }

    public static void lK(long j) {
        tVb = j;
    }

    public static void cTq() {
        tVb = -1;
    }

    public static g cTD() {
        AppMethodBeat.i(51563);
        z Ry = g.RP().Ry();
        g gVar;
        if (Ry == null) {
            gVar = new g();
            AppMethodBeat.o(51563);
            return gVar;
        }
        Object obj = Ry.get(339971, null);
        if (obj == null) {
            gVar = new g();
            AppMethodBeat.o(51563);
            return gVar;
        }
        gVar = new g().bz(e.stringToBytes((String) obj));
        AppMethodBeat.o(51563);
        return gVar;
    }

    public static void ad(long j, long j2) {
        AppMethodBeat.i(51564);
        z Ry = g.RP().Ry();
        if (Ry != null) {
            g gVar = new g();
            gVar.tVD = j;
            gVar.tVE = j2;
            Ry.set(339971, e.by(gVar.toByteArray()));
            Ry.dsb();
        }
        AppMethodBeat.o(51564);
    }

    public static void cTE() {
        AppMethodBeat.i(51565);
        z Ry = g.RP().Ry();
        if (Ry != null) {
            Ry.set(339971, null);
            Ry.dsb();
        }
        AppMethodBeat.o(51565);
    }

    public static bil cTF() {
        AppMethodBeat.i(51566);
        z Ry = g.RP().Ry();
        if (Ry == null) {
            AppMethodBeat.o(51566);
            return null;
        }
        String str = (String) Ry.get(339989, null);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(51566);
            return null;
        }
        try {
            bil bil = (bil) new bil().parseFrom(Base64.decode(str, 2));
            AppMethodBeat.o(51566);
            return bil;
        } catch (IllegalArgumentException e) {
            ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            AppMethodBeat.o(51566);
            return null;
        } catch (IOException e2) {
            ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            AppMethodBeat.o(51566);
            return null;
        }
    }

    public static void a(bil bil) {
        AppMethodBeat.i(51567);
        z Ry = g.RP().Ry();
        if (Ry != null) {
            try {
                Ry.set(339989, Base64.encodeToString(bil.toByteArray(), 2));
                Ry.dsb();
                ab.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", Boolean.valueOf(e.cTz()));
                AppMethodBeat.o(51567);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(51567);
    }

    public static bim cTG() {
        AppMethodBeat.i(51568);
        z Ry = g.RP().Ry();
        if (Ry == null) {
            ab.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
            AppMethodBeat.o(51568);
            return null;
        }
        String str = (String) Ry.get(339990, null);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(51568);
            return null;
        }
        try {
            bim bim = (bim) new bim().parseFrom(Base64.decode(str, 2));
            AppMethodBeat.o(51568);
            return bim;
        } catch (IllegalArgumentException e) {
            ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            AppMethodBeat.o(51568);
            return null;
        } catch (IOException e2) {
            ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            AppMethodBeat.o(51568);
            return null;
        }
    }

    public static void a(bim bim) {
        AppMethodBeat.i(51569);
        if (bim != null) {
            ab.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", Integer.valueOf(bim.wLR), Integer.valueOf(bim.wLT));
        }
        z Ry = g.RP().Ry();
        if (Ry != null) {
            try {
                Ry.set(339990, Base64.encodeToString(bim.toByteArray(), 2));
                Ry.dsb();
                AppMethodBeat.o(51569);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(51569);
    }

    public static int cTH() {
        AppMethodBeat.i(51570);
        z Ry = g.RP().Ry();
        if (Ry == null) {
            AppMethodBeat.o(51570);
            return -1;
        }
        Object obj = Ry.get(339972, null);
        if (obj == null) {
            AppMethodBeat.o(51570);
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        AppMethodBeat.o(51570);
        return intValue;
    }

    public static void HD(int i) {
        AppMethodBeat.i(51571);
        z Ry = g.RP().Ry();
        if (Ry != null) {
            Ry.set(339972, Integer.valueOf(i));
            Ry.dsb();
        }
        AppMethodBeat.o(51571);
    }

    public static void cTI() {
        AppMethodBeat.i(51572);
        z Ry = g.RP().Ry();
        if (Ry != null) {
            Ry.set(339972, null);
            Ry.dsb();
        }
        AppMethodBeat.o(51572);
    }
}
