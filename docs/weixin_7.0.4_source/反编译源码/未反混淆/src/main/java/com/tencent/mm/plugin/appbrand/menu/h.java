package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.base.l;

public final class h extends a {
    public h() {
        super(o.OpenGamePreload.ordinal());
        AppMethodBeat.i(132214);
        AppMethodBeat.o(132214);
    }

    public final void a(Context context, u uVar, l lVar, String str) {
        AppMethodBeat.i(132215);
        if (uVar.getRuntime() instanceof o) {
            o oVar = (o) uVar.getRuntime();
            if (oVar.xy() && oVar.yd()) {
                if (t.azr()) {
                    lVar.e(this.inj, "Disable Preload");
                    AppMethodBeat.o(132215);
                    return;
                }
                lVar.e(this.inj, "Enable Preload");
            }
        }
        AppMethodBeat.o(132215);
    }

    public final void a(Context context, u uVar, String str, n nVar) {
        AppMethodBeat.i(132216);
        if (t.azr()) {
            t.dL(false);
            Toast.makeText(context, "Disable success, please restart WeChat to take effect.", 1).show();
            AppMethodBeat.o(132216);
            return;
        }
        t.dL(true);
        Toast.makeText(context, "Enable success, please restart WeChat to take effect.", 1).show();
        AppMethodBeat.o(132216);
    }
}
