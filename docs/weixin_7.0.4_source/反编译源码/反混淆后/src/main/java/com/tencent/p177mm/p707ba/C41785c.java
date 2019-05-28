package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ba.c */
public final class C41785c implements C1202f {
    private static C41785c fLX;
    private int fLW = 3;
    private boolean fpA = false;

    public static C41785c aiq() {
        AppMethodBeat.m2504i(78436);
        if (fLX == null) {
            fLX = new C41785c();
        }
        C41785c c41785c = fLX;
        AppMethodBeat.m2505o(78436);
        return c41785c;
    }

    public final void update() {
        AppMethodBeat.m2504i(78437);
        C4990ab.m7416i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.fpA);
        C4990ab.m7416i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + C1720g.m3536RP().isSDCardAvailable());
        if (!this.fpA && C1720g.m3536RP().isSDCardAvailable()) {
            release();
            this.fpA = true;
            C1720g.m3535RO().eJo.mo14539a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
            C1720g.m3535RO().eJo.mo14541a(new C45181k(7), 0);
        }
        AppMethodBeat.m2505o(78437);
    }

    private void release() {
        AppMethodBeat.m2504i(78438);
        this.fpA = false;
        C1720g.m3535RO().eJo.mo14546b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(78438);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78439);
        if (c1207m.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            C4990ab.m7417i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                C1720g.m3536RP().mo5239Ry().set(81938, Long.valueOf(C5046bo.anT()));
            } else {
                int i3 = this.fLW - 1;
                this.fLW = i3;
                if (i3 < 0) {
                    C1720g.m3536RP().mo5239Ry().set(81938, Long.valueOf(((C5046bo.anU() - 86400000) + 3600000) / 1000));
                    this.fLW = 3;
                }
            }
            release();
        }
        AppMethodBeat.m2505o(78439);
    }
}
