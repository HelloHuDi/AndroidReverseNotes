package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C17895o;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ba.i */
public final class C32328i implements C1202f {
    public C32328i() {
        AppMethodBeat.m2504i(78448);
        C1720g.m3535RO().eJo.mo14539a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(160, (C1202f) this);
        C1720g.m3535RO().eJo.mo14541a(new C45181k(5), 0);
        AppMethodBeat.m2505o(78448);
    }

    private void release() {
        AppMethodBeat.m2504i(78449);
        C1720g.m3535RO().eJo.mo14546b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(160, (C1202f) this);
        AppMethodBeat.m2505o(78449);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78450);
        if ((c1207m instanceof C17895o) && ((C17895o) c1207m).acR() == 5) {
            int type = c1207m.getType();
            if (type != JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (type == 160) {
                    if (i == 0 && i2 == 0) {
                        C32328i.air();
                    }
                    release();
                }
                AppMethodBeat.m2505o(78450);
                return;
            } else if (i == 0 && i2 == 0) {
                C32328i.air();
                C25854m[] lU = C41787r.aix().mo20547lU(5);
                if (lU == null || lU.length == 0) {
                    C4990ab.m7416i("MicroMsg.LangPackageUpdater", "error no pkg found.");
                    release();
                    AppMethodBeat.m2505o(78450);
                    return;
                }
                C25854m c25854m = lU[0];
                C4990ab.m7416i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + c25854m.f13661id + " version:" + c25854m.version + " status:" + c25854m.status + " type:" + c25854m.cBc);
                if (5 != c25854m.status) {
                    release();
                    AppMethodBeat.m2505o(78450);
                    return;
                }
                C1720g.m3535RO().eJo.mo14541a(new C32329j(c25854m.f13661id, 5), 0);
                AppMethodBeat.m2505o(78450);
                return;
            } else {
                release();
                AppMethodBeat.m2505o(78450);
                return;
            }
        }
        C4990ab.m7410d("MicroMsg.LangPackageUpdater", "another scene");
        AppMethodBeat.m2505o(78450);
    }

    private static void air() {
        AppMethodBeat.m2504i(78451);
        C1720g.m3536RP().mo5239Ry().set(81939, Long.valueOf(C5046bo.anU()));
        AppMethodBeat.m2505o(78451);
    }
}
