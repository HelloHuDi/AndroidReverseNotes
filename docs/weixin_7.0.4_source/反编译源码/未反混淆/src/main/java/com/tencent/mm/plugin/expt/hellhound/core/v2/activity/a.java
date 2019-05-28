package com.tencent.mm.plugin.expt.hellhound.core.v2.activity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    static void KO(String str) {
        AppMethodBeat.i(73388);
        ab.i("ActivityActionWrapper", "habbyge-mali, setFinishAction_resume: ".concat(String.valueOf(str)));
        b.bqC().lMN.KO(str);
        AppMethodBeat.o(73388);
    }

    static void KP(String str) {
        AppMethodBeat.i(73389);
        ab.i("ActivityActionWrapper", "habbyge-mali, setFinishAction_pause: ".concat(String.valueOf(str)));
        b.bqC().lMN.KP(str);
        AppMethodBeat.o(73389);
    }

    public static void uX(int i) {
        AppMethodBeat.i(73390);
        ab.d("ActivityActionWrapper", "habbyge-mali, setActivityMethod: ".concat(String.valueOf(i)));
        b.bqC().lMN.uX(i);
        AppMethodBeat.o(73390);
    }

    public static int bqA() {
        AppMethodBeat.i(73391);
        int bqA = b.bqC().lMN.bqA();
        AppMethodBeat.o(73391);
        return bqA;
    }
}
