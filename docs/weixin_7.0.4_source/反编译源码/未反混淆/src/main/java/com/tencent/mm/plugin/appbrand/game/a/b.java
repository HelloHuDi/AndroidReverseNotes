package com.tencent.mm.plugin.appbrand.game.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\r\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0002\u0010\r¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigAllowOpenGL3;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class b extends g<Boolean> {
    public static final b hqB = new b();

    static {
        AppMethodBeat.i(134605);
        AppMethodBeat.o(134605);
    }

    private b() {
    }

    /* Access modifiers changed, original: protected|final */
    public final String aAy() {
        return "opengl3";
    }

    /* Access modifiers changed, original: protected|final */
    public final a aAz() {
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aAA() {
        return true;
    }

    public final /* synthetic */ Object Ap(String str) {
        AppMethodBeat.i(134604);
        Boolean Ar = g.Ar(str);
        AppMethodBeat.o(134604);
        return Ar;
    }

    public final /* bridge */ /* synthetic */ Object aAB() {
        return Boolean.TRUE;
    }
}
