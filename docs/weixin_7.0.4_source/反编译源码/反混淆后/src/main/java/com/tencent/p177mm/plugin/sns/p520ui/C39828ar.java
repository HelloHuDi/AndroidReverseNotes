package com.tencent.p177mm.plugin.sns.p520ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.model.C13413ap;
import com.tencent.p177mm.plugin.sns.model.C13413ap.C13414b;
import com.tencent.p177mm.pluginsdk.p597ui.p1669d.C46504a;

/* renamed from: com.tencent.mm.plugin.sns.ui.ar */
public final class C39828ar implements C46504a {
    public String cFc;
    public String czD;
    public boolean rvm = false;
    public boolean rvn = false;
    public int scene;
    public String userName;

    public C39828ar(String str, String str2, boolean z, boolean z2, int i) {
        this.cFc = str;
        this.rvm = z;
        this.rvn = z2;
        this.scene = i;
        this.czD = str2;
    }

    public final boolean ctI() {
        int i = 2;
        AppMethodBeat.m2504i(39186);
        if (this.scene != 1) {
            if (this.scene == 2) {
                i = 4;
            } else {
                i = -1;
            }
        }
        C13414b Ye = C13413ap.m21540Ye(this.cFc);
        if (Ye == null || !Ye.foa || Ye.aAR || (i & Ye.dtW) == 0) {
            AppMethodBeat.m2505o(39186);
            return false;
        }
        AppMethodBeat.m2505o(39186);
        return true;
    }

    public final String getUserName() {
        return this.userName;
    }
}
