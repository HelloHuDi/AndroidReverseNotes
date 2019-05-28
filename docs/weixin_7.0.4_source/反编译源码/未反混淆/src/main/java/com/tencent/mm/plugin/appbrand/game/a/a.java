package com.tencent.mm.plugin.appbrand.game.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameCliCfg;", "", "()V", "get", "T", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "defaultValue", "log", "", "(Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;Ljava/lang/Object;Z)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
public final class a {
    public static final a hqA = new a();

    static {
        AppMethodBeat.i(134603);
        AppMethodBeat.o(134603);
    }

    private a() {
    }

    public static /* synthetic */ Object a(com.tencent.mm.plugin.expt.a.a.a aVar, Object obj) {
        AppMethodBeat.i(134602);
        j.p(aVar, "key");
        if (obj instanceof Integer) {
            Integer valueOf = Integer.valueOf(((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(aVar, ((Number) obj).intValue()));
            AppMethodBeat.o(134602);
            return valueOf;
        }
        Throwable illegalStateException = new IllegalStateException("Code should not reach");
        AppMethodBeat.o(134602);
        throw illegalStateException;
    }
}
