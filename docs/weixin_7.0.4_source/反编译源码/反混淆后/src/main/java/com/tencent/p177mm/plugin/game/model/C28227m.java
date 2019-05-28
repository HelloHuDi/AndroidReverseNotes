package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.game.model.C44744h.C121691;
import com.tencent.p177mm.protocal.protobuf.bvb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.m */
public final class C28227m implements C1202f {
    private static boolean isRunning = false;
    private static int mWb = 20;
    private static LinkedList<C44744h> mWc = new LinkedList();
    private static C5004al mWd;
    private int offset = 0;

    /* renamed from: b */
    static /* synthetic */ void m44818b(C28227m c28227m) {
        AppMethodBeat.m2504i(111285);
        c28227m.bEk();
        AppMethodBeat.m2505o(111285);
    }

    static {
        AppMethodBeat.m2504i(111286);
        AppMethodBeat.m2505o(111286);
    }

    public static void update() {
        AppMethodBeat.m2504i(111282);
        if (!C20993e.bDY()) {
            C4990ab.m7416i("MicroMsg.GameListUpdater", "No need to update");
            AppMethodBeat.m2505o(111282);
        } else if (isRunning) {
            C4990ab.m7412e("MicroMsg.GameListUpdater", "Already running");
            AppMethodBeat.m2505o(111282);
        } else {
            mWd = new C5004al("GameListUpdate");
            mWc.clear();
            C1202f c28227m = new C28227m();
            C1720g.m3540Rg().mo14539a(1215, c28227m);
            C1720g.m3540Rg().mo14541a(new C43188au(c28227m.offset, mWb), 0);
            isRunning = true;
            AppMethodBeat.m2505o(111282);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(111283);
        if (i == 0 && i2 == 0) {
            mWd.mo10302aa(new Runnable() {
                public final void run() {
                    String str;
                    AppMethodBeat.m2504i(111281);
                    C28227m.this.offset = C28227m.this.offset + C28227m.mWb;
                    bvb bvb = (bvb) ((C43188au) c1207m).lty.fsH.fsP;
                    if (bvb == null) {
                        C4990ab.m7412e("MicroMsg.NetSceneSearchGameList", "resp == null");
                        str = null;
                    } else {
                        str = bvb.wkG;
                    }
                    C44744h c44744h = new C44744h(str);
                    c44744h.bEf();
                    C28227m.mWc.add(c44744h);
                    C4990ab.m7417i("MicroMsg.GameListUpdater", "remainingCount: %d", Integer.valueOf(c44744h.mVR.optInt("remainingCount")));
                    if (c44744h.mVR.optInt("remainingCount") > 0) {
                        C1720g.m3540Rg().mo14541a(new C43188au(C28227m.this.offset, C28227m.mWb), 0);
                        AppMethodBeat.m2505o(111281);
                        return;
                    }
                    C28227m.m44818b(C28227m.this);
                    C20993e.bDZ();
                    LinkedList aWj = C28227m.mWc;
                    if (!C5046bo.m7548ek(aWj)) {
                        C1720g.m3539RS().mo10302aa(new C121691(aWj));
                    }
                    AppMethodBeat.m2505o(111281);
                }
            });
            AppMethodBeat.m2505o(111283);
            return;
        }
        bEk();
        AppMethodBeat.m2505o(111283);
    }

    private void bEk() {
        AppMethodBeat.m2504i(111284);
        isRunning = false;
        mWd.oAl.quit();
        C1720g.m3540Rg().mo14546b(1215, (C1202f) this);
        AppMethodBeat.m2505o(111284);
    }
}
