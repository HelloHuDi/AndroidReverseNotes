package com.tencent.mm.plugin.appbrand.menu;

import a.f.b.j;
import a.l;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.b;
import com.tencent.mm.plugin.appbrand.q;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
public final class p {
    public static final p inf = new p();

    static {
        AppMethodBeat.i(134756);
        AppMethodBeat.o(134756);
    }

    private p() {
    }

    public static void a(StringBuilder stringBuilder, q qVar) {
        AppMethodBeat.i(134755);
        j.p(stringBuilder, "sb");
        if (qVar == null || !(qVar instanceof b)) {
            AppMethodBeat.o(134755);
            return;
        }
        String str = "\n[renderer] ";
        MBRuntime mBRuntime = ((b) qVar).getMBRuntime();
        if (mBRuntime == null) {
            stringBuilder.append(str).append("unknown");
            AppMethodBeat.o(134755);
            return;
        }
        stringBuilder.append(str).append("mbruntime");
        if (mBRuntime.getParams().use_command_buffer) {
            stringBuilder.append(" commandbuffer");
        }
        stringBuilder.append(str).append("antialias ").append(mBRuntime.getParams().allow_antialias_ ? "allowed" : "disallowed");
        AppMethodBeat.o(134755);
    }
}
