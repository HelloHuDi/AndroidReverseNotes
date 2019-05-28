package com.tencent.p177mm.plugin.appbrand.game.p291a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0007J\r\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigWxbct;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "getActuallyConfig", "getConfig", "()Ljava/lang/Boolean;", "getConfigDefaultValue", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.a.f */
public final class C10230f extends C26881g<Boolean> {
    public static final C10230f hqR = new C10230f();

    static {
        AppMethodBeat.m2504i(134628);
        AppMethodBeat.m2505o(134628);
    }

    private C10230f() {
    }

    /* Access modifiers changed, original: protected|final */
    public final String aAy() {
        return "wxbct";
    }

    /* Access modifiers changed, original: protected|final */
    public final C11745a aAz() {
        return C11745a.clicfg_magicbrush_wxbct;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aAA() {
        return true;
    }

    public static final boolean aAE() {
        AppMethodBeat.m2504i(134627);
        if (((Boolean) super.mo21639Uw()).booleanValue()) {
            int intValue = ((Number) C38212a.m64661a(C11745a.clicfg_magicbrush_gcfactor, Integer.valueOf(0))).intValue();
            if (intValue == 0) {
                C4990ab.m7416i("WAGameConfigWxbct", "getActuallyConfig gcfactor == 0");
                AppMethodBeat.m2505o(134627);
                return false;
            }
            C4990ab.m7416i("WAGameConfigWxbct", "getActuallyConfig gcfactor != 0 [" + intValue + "], enable wxbct");
            AppMethodBeat.m2505o(134627);
            return true;
        }
        C4990ab.m7416i("WAGameConfigWxbct", "getActuallyConfig self == false");
        AppMethodBeat.m2505o(134627);
        return false;
    }

    /* renamed from: Ap */
    public final /* synthetic */ Object mo21635Ap(String str) {
        AppMethodBeat.m2504i(134625);
        Boolean Ar = C26881g.m42814Ar(str);
        AppMethodBeat.m2505o(134625);
        return Ar;
    }

    public final /* bridge */ /* synthetic */ Object aAB() {
        return Boolean.FALSE;
    }

    /* renamed from: Uw */
    public final /* synthetic */ Object mo21639Uw() {
        AppMethodBeat.m2504i(134626);
        Throwable illegalStateException = new IllegalStateException("Code should not reach.");
        AppMethodBeat.m2505o(134626);
        throw illegalStateException;
    }
}
