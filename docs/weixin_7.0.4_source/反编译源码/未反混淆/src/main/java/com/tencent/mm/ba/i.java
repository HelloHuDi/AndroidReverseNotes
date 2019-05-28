package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i implements f {
    public i() {
        AppMethodBeat.i(78448);
        g.RO().eJo.a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        g.RO().eJo.a(160, (f) this);
        g.RO().eJo.a(new k(5), 0);
        AppMethodBeat.o(78448);
    }

    private void release() {
        AppMethodBeat.i(78449);
        g.RO().eJo.b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        g.RO().eJo.b(160, (f) this);
        AppMethodBeat.o(78449);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(78450);
        if ((mVar instanceof o) && ((o) mVar).acR() == 5) {
            int type = mVar.getType();
            if (type != JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (type == 160) {
                    if (i == 0 && i2 == 0) {
                        air();
                    }
                    release();
                }
                AppMethodBeat.o(78450);
                return;
            } else if (i == 0 && i2 == 0) {
                air();
                m[] lU = r.aix().lU(5);
                if (lU == null || lU.length == 0) {
                    ab.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
                    release();
                    AppMethodBeat.o(78450);
                    return;
                }
                m mVar2 = lU[0];
                ab.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + mVar2.id + " version:" + mVar2.version + " status:" + mVar2.status + " type:" + mVar2.cBc);
                if (5 != mVar2.status) {
                    release();
                    AppMethodBeat.o(78450);
                    return;
                }
                g.RO().eJo.a(new j(mVar2.id, 5), 0);
                AppMethodBeat.o(78450);
                return;
            } else {
                release();
                AppMethodBeat.o(78450);
                return;
            }
        }
        ab.d("MicroMsg.LangPackageUpdater", "another scene");
        AppMethodBeat.o(78450);
    }

    private static void air() {
        AppMethodBeat.i(78451);
        g.RP().Ry().set(81939, Long.valueOf(bo.anU()));
        AppMethodBeat.o(78451);
    }
}
