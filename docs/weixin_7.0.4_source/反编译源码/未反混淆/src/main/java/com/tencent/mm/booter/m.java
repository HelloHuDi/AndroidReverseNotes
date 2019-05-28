package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ba.k;
import com.tencent.mm.bf.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;

public final class m {
    private static long ecD = 86400000;

    public static void run() {
        boolean z;
        AppMethodBeat.i(15862);
        aw.ZK();
        if (ah.fp(ah.c((Long) c.Ry().get(81944, null))) * 1000 > ecD) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f ajP = d.ajP();
            d.ajQ();
            if (!ajP.fpA) {
                g.RQ();
                if (g.RP().isSDCardAvailable()) {
                    ajP.release();
                    ajP.fpA = true;
                    g.Rg().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, ajP);
                    g.Rg().a(new k(9), 0);
                }
            }
        }
        AppMethodBeat.o(15862);
    }
}
