package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    public static boolean Cj() {
        AppMethodBeat.i(15617);
        if (d.afj("translate")) {
            String value = g.Nu().getValue("TranslateMsgOff");
            if (bo.isNullOrNil(value)) {
                AppMethodBeat.o(15617);
                return true;
            } else if (bo.ank(value) != 0) {
                AppMethodBeat.o(15617);
                return false;
            } else {
                AppMethodBeat.o(15617);
                return true;
            }
        }
        AppMethodBeat.o(15617);
        return false;
    }

    public static boolean Ck() {
        AppMethodBeat.i(15618);
        if (d.afj("translate")) {
            String value = g.Nu().getValue("ReTranslateSwitch");
            if (bo.isNullOrNil(value)) {
                AppMethodBeat.o(15618);
                return true;
            } else if (bo.ank(value) != 0) {
                AppMethodBeat.o(15618);
                return false;
            } else {
                AppMethodBeat.o(15618);
                return true;
            }
        }
        AppMethodBeat.o(15618);
        return false;
    }
}
