package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    a() {
    }

    public static void gR(boolean z) {
        AppMethodBeat.i(73446);
        acp bqE = bqE();
        if (bqE == null) {
            bqE = new acp();
        }
        bqE.wkq = z;
        ab.d("FrontBackDao", "habbyge-mali, logout8EventFromAdd: " + bqE.wkq);
        a(bqE);
        AppMethodBeat.o(73446);
    }

    public static void uY(int i) {
        AppMethodBeat.i(73447);
        acp bqE = bqE();
        if (bqE == null) {
            bqE = new acp();
        }
        bqE.wkl = i;
        ab.d("FrontBackDao", "habbyge-mali, setFrontBackEvent_LastTime: ".concat(String.valueOf(i)));
        a(bqE);
        AppMethodBeat.o(73447);
    }

    static void a(acp acp) {
        AppMethodBeat.i(73448);
        try {
            b.v("hell_fntbck_pter_mmkv_key", acp.toByteArray());
            AppMethodBeat.o(73448);
        } catch (Exception e) {
            ab.printErrStackTrace("FrontBackDao", e, "habbyge-mali, writeBackFrontBack", new Object[0]);
            AppMethodBeat.o(73448);
        }
    }

    static acp bqE() {
        AppMethodBeat.i(73449);
        byte[] bytes = b.getBytes("hell_fntbck_pter_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(73449);
            return null;
        }
        acp acp = new acp();
        try {
            acp.parseFrom(bytes);
        } catch (Exception e) {
            ab.printErrStackTrace("FrontBackDao", e, "habbyge-mali, _doReadFrontBack parse", new Object[0]);
            acp = null;
        }
        AppMethodBeat.o(73449);
        return acp;
    }
}
