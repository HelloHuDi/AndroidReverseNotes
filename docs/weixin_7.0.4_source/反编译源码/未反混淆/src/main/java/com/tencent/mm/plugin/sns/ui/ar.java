package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.pluginsdk.ui.d.a;

public final class ar implements a {
    public String cFc;
    public String czD;
    public boolean rvm = false;
    public boolean rvn = false;
    public int scene;
    public String userName;

    public ar(String str, String str2, boolean z, boolean z2, int i) {
        this.cFc = str;
        this.rvm = z;
        this.rvn = z2;
        this.scene = i;
        this.czD = str2;
    }

    public final boolean ctI() {
        int i = 2;
        AppMethodBeat.i(39186);
        if (this.scene != 1) {
            if (this.scene == 2) {
                i = 4;
            } else {
                i = -1;
            }
        }
        b Ye = ap.Ye(this.cFc);
        if (Ye == null || !Ye.foa || Ye.aAR || (i & Ye.dtW) == 0) {
            AppMethodBeat.o(39186);
            return false;
        }
        AppMethodBeat.o(39186);
        return true;
    }

    public final String getUserName() {
        return this.userName;
    }
}
