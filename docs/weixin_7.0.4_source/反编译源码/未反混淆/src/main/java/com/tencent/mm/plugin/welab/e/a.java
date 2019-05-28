package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.c.cq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;

public final class a implements b {
    public final void f(Activity activity, String str) {
        AppMethodBeat.i(26582);
        cq agJ = ((d) g.K(d.class)).agJ(str);
        se seVar = new se();
        seVar.cOf.userName = agJ.field_WeAppUser;
        seVar.cOf.cOh = agJ.field_WeAppPath;
        seVar.cOf.scene = 1051;
        seVar.cOf.cOi = agJ.field_WeAppDebugMode;
        seVar.cOf.cst = String.format("%s:%s:%s:%s", new Object[]{(String) g.RP().Ry().get(2, null), agJ.field_expId, agJ.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000)});
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        AppMethodBeat.o(26582);
    }

    public final String ddq() {
        return null;
    }

    public final String ddr() {
        return null;
    }
}
