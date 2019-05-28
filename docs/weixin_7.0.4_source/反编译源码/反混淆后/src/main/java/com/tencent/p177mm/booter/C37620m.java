package com.tencent.p177mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p202bf.C25858d;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;

/* renamed from: com.tencent.mm.booter.m */
public final class C37620m {
    private static long ecD = 86400000;

    public static void run() {
        boolean z;
        AppMethodBeat.m2504i(15862);
        C9638aw.m17190ZK();
        if (C42252ah.m74621fp(C42252ah.m74610c((Long) C18628c.m29072Ry().get(81944, null))) * 1000 > ecD) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C1202f ajP = C25858d.ajP();
            C25858d.ajQ();
            if (!ajP.fpA) {
                C1720g.m3537RQ();
                if (C1720g.m3536RP().isSDCardAvailable()) {
                    ajP.release();
                    ajP.fpA = true;
                    C1720g.m3540Rg().mo14539a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, ajP);
                    C1720g.m3540Rg().mo14541a(new C45181k(9), 0);
                }
            }
        }
        AppMethodBeat.m2505o(15862);
    }
}
