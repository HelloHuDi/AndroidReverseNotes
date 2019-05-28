package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.le;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;

public final class ao implements a {
    private static n mgA = null;
    private static ao mgB = null;
    public int cAO;
    public int duration;
    public String path;

    public static ao bvo() {
        AppMethodBeat.i(102749);
        if (mgB == null) {
            mgB = new ao();
        }
        ao aoVar = mgB;
        AppMethodBeat.o(102749);
        return aoVar;
    }

    public static n bvq() {
        return mgA;
    }

    public final void bI(String str, int i) {
        AppMethodBeat.i(102751);
        ab.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 1);
        if (bo.bc(str, "").equals(this.path)) {
            bundle.putBoolean("result", false);
        } else {
            bundle.putBoolean("result", true);
        }
        bundle.putInt("position", i);
        le leVar = new le();
        leVar.cHe.cGZ = bundle;
        leVar.cHe.type = 4;
        com.tencent.mm.sdk.b.a.xxA.m(leVar);
        AppMethodBeat.o(102751);
    }

    public final void onFinish() {
        AppMethodBeat.i(102752);
        mgA.stopPlay();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 2);
        le leVar = new le();
        leVar.cHe.cGZ = bundle;
        leVar.cHe.type = 4;
        com.tencent.mm.sdk.b.a.xxA.m(leVar);
        AppMethodBeat.o(102752);
    }

    public final void onPause() {
        AppMethodBeat.i(102753);
        mgA.buJ();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 3);
        le leVar = new le();
        leVar.cHe.cGZ = bundle;
        leVar.cHe.type = 4;
        com.tencent.mm.sdk.b.a.xxA.m(leVar);
        AppMethodBeat.o(102753);
    }

    public final void bvp() {
        AppMethodBeat.i(102750);
        if (mgA == null) {
            mgA = new n();
        }
        mgA.a(this);
        mgA.mfU = true;
        n nVar = mgA;
        if (n.mfW == null) {
            n.mfW = new SensorController(ah.getContext());
        }
        if (nVar.mfS == null) {
            nVar.mfS = new bf(ah.getContext());
        }
        AppMethodBeat.o(102750);
    }
}
