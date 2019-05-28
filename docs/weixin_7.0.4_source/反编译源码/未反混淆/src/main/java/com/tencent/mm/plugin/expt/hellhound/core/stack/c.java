package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    public static bf bqs() {
        AppMethodBeat.i(73359);
        bf bqt = bqt();
        if (bqt == null) {
            bqt = new bf();
            a(bqt);
        }
        AppMethodBeat.o(73359);
        return bqt;
    }

    public static void a(bf bfVar) {
        AppMethodBeat.i(73360);
        if (bfVar == null) {
            AppMethodBeat.o(73360);
            return;
        }
        byte[] bArr = null;
        try {
            bArr = bfVar.toByteArray();
        } catch (Exception e) {
            ab.printErrStackTrace("ActivityStackDao", e, "ActivityStackDao write", new Object[0]);
        }
        b.v("hell_astackd_mmkv_key", bArr);
        AppMethodBeat.o(73360);
    }

    private static bf bqt() {
        AppMethodBeat.i(73361);
        byte[] bytes = b.getBytes("hell_astackd_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(73361);
            return null;
        }
        bf bfVar = new bf();
        try {
            bfVar.parseFrom(bytes);
            AppMethodBeat.o(73361);
            return bfVar;
        } catch (Exception e) {
            ab.printErrStackTrace("ActivityStackDao", e, "ActivityStackDao read", new Object[0]);
            AppMethodBeat.o(73361);
            return null;
        }
    }
}
