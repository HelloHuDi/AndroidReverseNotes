package com.tencent.mm.plugin.appbrand.game.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0007J\r\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigWxbct;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "getActuallyConfig", "getConfig", "()Ljava/lang/Boolean;", "getConfigDefaultValue", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class f extends g<Boolean> {
    public static final f hqR = new f();

    static {
        AppMethodBeat.i(134628);
        AppMethodBeat.o(134628);
    }

    private f() {
    }

    /* Access modifiers changed, original: protected|final */
    public final String aAy() {
        return "wxbct";
    }

    /* Access modifiers changed, original: protected|final */
    public final a aAz() {
        return a.clicfg_magicbrush_wxbct;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aAA() {
        return true;
    }

    public static final boolean aAE() {
        AppMethodBeat.i(134627);
        if (((Boolean) super.Uw()).booleanValue()) {
            int intValue = ((Number) a.a(a.clicfg_magicbrush_gcfactor, Integer.valueOf(0))).intValue();
            if (intValue == 0) {
                ab.i("WAGameConfigWxbct", "getActuallyConfig gcfactor == 0");
                AppMethodBeat.o(134627);
                return false;
            }
            ab.i("WAGameConfigWxbct", "getActuallyConfig gcfactor != 0 [" + intValue + "], enable wxbct");
            AppMethodBeat.o(134627);
            return true;
        }
        ab.i("WAGameConfigWxbct", "getActuallyConfig self == false");
        AppMethodBeat.o(134627);
        return false;
    }

    public final /* synthetic */ Object Ap(String str) {
        AppMethodBeat.i(134625);
        Boolean Ar = g.Ar(str);
        AppMethodBeat.o(134625);
        return Ar;
    }

    public final /* bridge */ /* synthetic */ Object aAB() {
        return Boolean.FALSE;
    }

    public final /* synthetic */ Object Uw() {
        AppMethodBeat.i(134626);
        Throwable illegalStateException = new IllegalStateException("Code should not reach.");
        AppMethodBeat.o(134626);
        throw illegalStateException;
    }
}
