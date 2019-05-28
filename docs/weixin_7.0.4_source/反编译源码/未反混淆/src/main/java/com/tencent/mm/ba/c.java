package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c implements f {
    private static c fLX;
    private int fLW = 3;
    private boolean fpA = false;

    public static c aiq() {
        AppMethodBeat.i(78436);
        if (fLX == null) {
            fLX = new c();
        }
        c cVar = fLX;
        AppMethodBeat.o(78436);
        return cVar;
    }

    public final void update() {
        AppMethodBeat.i(78437);
        ab.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.fpA);
        ab.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.RP().isSDCardAvailable());
        if (!this.fpA && g.RP().isSDCardAvailable()) {
            release();
            this.fpA = true;
            g.RO().eJo.a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
            g.RO().eJo.a(new k(7), 0);
        }
        AppMethodBeat.o(78437);
    }

    private void release() {
        AppMethodBeat.i(78438);
        this.fpA = false;
        g.RO().eJo.b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        AppMethodBeat.o(78438);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(78439);
        if (mVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            ab.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                g.RP().Ry().set(81938, Long.valueOf(bo.anT()));
            } else {
                int i3 = this.fLW - 1;
                this.fLW = i3;
                if (i3 < 0) {
                    g.RP().Ry().set(81938, Long.valueOf(((bo.anU() - 86400000) + 3600000) / 1000));
                    this.fLW = 3;
                }
            }
            release();
        }
        AppMethodBeat.o(78439);
    }
}
