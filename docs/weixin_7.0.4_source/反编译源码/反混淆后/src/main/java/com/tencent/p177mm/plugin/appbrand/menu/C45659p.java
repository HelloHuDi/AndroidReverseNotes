package com.tencent.p177mm.plugin.appbrand.menu;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.menu.p */
public final class C45659p {
    public static final C45659p inf = new C45659p();

    static {
        AppMethodBeat.m2504i(134756);
        AppMethodBeat.m2505o(134756);
    }

    private C45659p() {
    }

    /* renamed from: a */
    public static void m84313a(StringBuilder stringBuilder, C38492q c38492q) {
        AppMethodBeat.m2504i(134755);
        C25052j.m39376p(stringBuilder, "sb");
        if (c38492q == null || !(c38492q instanceof C42439b)) {
            AppMethodBeat.m2505o(134755);
            return;
        }
        String str = "\n[renderer] ";
        MBRuntime mBRuntime = ((C42439b) c38492q).getMBRuntime();
        if (mBRuntime == null) {
            stringBuilder.append(str).append("unknown");
            AppMethodBeat.m2505o(134755);
            return;
        }
        stringBuilder.append(str).append("mbruntime");
        if (mBRuntime.getParams().use_command_buffer) {
            stringBuilder.append(" commandbuffer");
        }
        stringBuilder.append(str).append("antialias ").append(mBRuntime.getParams().allow_antialias_ ? "allowed" : "disallowed");
        AppMethodBeat.m2505o(134755);
    }
}
