package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class f extends b {
    private static f gCM = null;
    public String account = null;
    public String gCK = null;
    public int gCL = 0;
    public String guf = null;
    public byte[] gug = null;
    public String guh = null;
    public String gui = null;

    public final void apw() {
        AppMethodBeat.i(125006);
        if (bo.isNullOrNil(this.gCK)) {
            g.Rg().a(new q(this.account, this.guf, this.yrX.getSecCodeType(), "", "", "", 0, "", false, false), 0);
            AppMethodBeat.o(125006);
            return;
        }
        g.Rg().a(new q(this.account, this.gCK, this.yrX.getSecCodeType(), "", "", "", 0, "", false, true), 0);
        AppMethodBeat.o(125006);
    }

    public static void a(f fVar) {
        gCM = fVar;
    }

    public static String ara() {
        if (gCM != null) {
            return gCM.account;
        }
        return null;
    }

    public static String arb() {
        if (gCM != null) {
            return gCM.guf;
        }
        return null;
    }
}
