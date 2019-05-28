package com.tencent.p177mm.plugin.sns.p516g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;

/* renamed from: com.tencent.mm.plugin.sns.g.g */
public final class C43543g implements C1202f {
    C39736h qQa;

    public final boolean coA() {
        AppMethodBeat.m2504i(36810);
        if (this.qQa == null || this.qQa.qPP.size() == 0) {
            AppMethodBeat.m2505o(36810);
            return false;
        }
        AppMethodBeat.m2505o(36810);
        return true;
    }

    public final C39736h coB() {
        AppMethodBeat.m2504i(36811);
        if (this.qQa == null || this.qQa.qPP.size() == 0) {
            AppMethodBeat.m2505o(36811);
            return null;
        }
        C39736h c39736h = this.qQa;
        AppMethodBeat.m2505o(36811);
        return c39736h;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
    }
}
