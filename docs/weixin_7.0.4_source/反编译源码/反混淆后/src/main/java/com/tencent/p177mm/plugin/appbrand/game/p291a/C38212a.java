package com.tencent.p177mm.plugin.appbrand.game.p291a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameCliCfg;", "", "()V", "get", "T", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "defaultValue", "log", "", "(Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;Ljava/lang/Object;Z)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.a.a */
public final class C38212a {
    public static final C38212a hqA = new C38212a();

    static {
        AppMethodBeat.m2504i(134603);
        AppMethodBeat.m2505o(134603);
    }

    private C38212a() {
    }

    /* renamed from: a */
    public static /* synthetic */ Object m64661a(C11745a c11745a, Object obj) {
        AppMethodBeat.m2504i(134602);
        C25052j.m39376p(c11745a, "key");
        if (obj instanceof Integer) {
            Integer valueOf = Integer.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(c11745a, ((Number) obj).intValue()));
            AppMethodBeat.m2505o(134602);
            return valueOf;
        }
        Throwable illegalStateException = new IllegalStateException("Code should not reach");
        AppMethodBeat.m2505o(134602);
        throw illegalStateException;
    }
}
