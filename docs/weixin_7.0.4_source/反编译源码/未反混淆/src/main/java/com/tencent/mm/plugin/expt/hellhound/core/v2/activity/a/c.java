package com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ab;

final class c extends a {
    c() {
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        AppMethodBeat.i(73429);
        ab.i("ActivityDao_MMKV", "habbyge-mali, ActivityDao_MMKV reset");
        b.v("hell_aty_action_mmkv_key", new byte[0]);
        AppMethodBeat.o(73429);
    }

    /* Access modifiers changed, original: final */
    public final void KQ(String str) {
        AppMethodBeat.i(73430);
        bb bqD = bqD();
        if (bqD == null) {
            bqD = new bb();
        }
        bqD.vCS = true;
        if (str == null) {
            str = "";
        }
        bqD.vCW = str;
        a(bqD);
        AppMethodBeat.o(73430);
    }

    /* Access modifiers changed, original: final */
    public final boolean KR(String str) {
        AppMethodBeat.i(73431);
        bb bqD = bqD();
        if (bqD == null) {
            AppMethodBeat.o(73431);
            return false;
        }
        boolean z = bqD.vCS;
        String str2 = bqD.vCW;
        if (z) {
            if (!(TextUtils.isEmpty(str2) || str2.equals(str))) {
                z = false;
            }
            bqD.vCS = false;
            bqD.vCW = "";
            a(bqD);
        }
        AppMethodBeat.o(73431);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void KO(String str) {
        AppMethodBeat.i(73432);
        bb bqD = bqD();
        if (bqD == null) {
            bqD = new bb();
        }
        bqD.vCT = true;
        if (str == null) {
            str = "";
        }
        bqD.vCX = str;
        a(bqD);
        AppMethodBeat.o(73432);
    }

    /* Access modifiers changed, original: final */
    public final boolean bqB() {
        AppMethodBeat.i(73433);
        bb bqD = bqD();
        if (bqD == null) {
            AppMethodBeat.o(73433);
            return false;
        }
        boolean z = bqD.vCT;
        if (z) {
            bqD.vCT = false;
            bqD.vCX = "";
            a(bqD);
        }
        AppMethodBeat.o(73433);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void KS(String str) {
        AppMethodBeat.i(73434);
        ab.i("ActivityDao_MMKV", "habbyge-mali, ActivityDao, setStartActivityAction_pause: ".concat(String.valueOf(str)));
        bb bqD = bqD();
        if (bqD == null) {
            bqD = new bb();
        }
        bqD.vCU = true;
        if (str == null) {
            str = "";
        }
        bqD.vCY = str;
        a(bqD);
        AppMethodBeat.o(73434);
    }

    /* Access modifiers changed, original: final */
    public final boolean KT(String str) {
        AppMethodBeat.i(73435);
        ab.i("ActivityDao_MMKV", "habbyge-mali, isStartActivityAction_pause: ".concat(String.valueOf(str)));
        bb bqD = bqD();
        if (bqD == null) {
            AppMethodBeat.o(73435);
            return false;
        }
        boolean z = bqD.vCU;
        if (z) {
            bqD.vCU = false;
            bqD.vCY = "";
            a(bqD);
        }
        AppMethodBeat.o(73435);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void KP(String str) {
        AppMethodBeat.i(73436);
        bb bqD = bqD();
        if (bqD == null) {
            bqD = new bb();
        }
        bqD.vCV = true;
        if (str == null) {
            str = "";
        }
        bqD.vCZ = str;
        a(bqD);
        AppMethodBeat.o(73436);
    }

    /* Access modifiers changed, original: final */
    public final boolean KU(String str) {
        AppMethodBeat.i(73437);
        bb bqD = bqD();
        if (bqD == null) {
            AppMethodBeat.o(73437);
            return false;
        }
        boolean z = bqD.vCV;
        String str2 = bqD.vCZ;
        if (z) {
            if (!(TextUtils.isEmpty(str2) || str2.equals(str))) {
                z = false;
            }
            bqD.vCV = false;
            bqD.vCZ = "";
            a(bqD);
        }
        AppMethodBeat.o(73437);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void uX(int i) {
        AppMethodBeat.i(73438);
        bb bqD = bqD();
        if (bqD == null) {
            bqD = new bb();
        }
        bqD.vDa = i;
        a(bqD);
        AppMethodBeat.o(73438);
    }

    /* Access modifiers changed, original: final */
    public final int bqA() {
        AppMethodBeat.i(73439);
        bb bqD = bqD();
        if (bqD == null) {
            AppMethodBeat.o(73439);
            return -1;
        }
        int i = bqD.vDa;
        AppMethodBeat.o(73439);
        return i;
    }

    private static void a(bb bbVar) {
        AppMethodBeat.i(73440);
        try {
            b.v("hell_aty_action_mmkv_key", bbVar.toByteArray());
            AppMethodBeat.o(73440);
        } catch (Exception e) {
            ab.printErrStackTrace("ActivityDao_MMKV", e, "habbyge-mali, HellhoundDao writeBack", new Object[0]);
            AppMethodBeat.o(73440);
        }
    }

    private static bb bqD() {
        AppMethodBeat.i(73441);
        byte[] bytes = b.getBytes("hell_aty_action_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(73441);
            return null;
        }
        bb bbVar = new bb();
        try {
            bbVar.parseFrom(bytes);
        } catch (Exception e) {
            ab.printErrStackTrace("ActivityDao_MMKV", e, "habbyge-mali, HellhoundDao _doRead parse", new Object[0]);
            bbVar = null;
        }
        AppMethodBeat.o(73441);
        return bbVar;
    }
}
