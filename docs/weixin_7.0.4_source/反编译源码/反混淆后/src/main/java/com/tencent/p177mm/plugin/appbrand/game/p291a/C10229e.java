package com.tencent.p177mm.plugin.appbrand.game.p291a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import p000a.C0220l;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0014J\r\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.a.e */
public final class C10229e extends C26881g<Boolean> {
    private static final HashMap<String, C10229e> hqP = new HashMap();
    public static final C10228a hqQ = new C10228a();
    final String hqM;
    private final boolean hqN;
    private final boolean hqO;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0007J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.game.a.e$a */
    public static final class C10228a {
        private C10228a() {
        }

        public /* synthetic */ C10228a(byte b) {
            this();
        }

        /* renamed from: a */
        static void m17878a(C10229e c10229e) {
            AppMethodBeat.m2504i(134619);
            Map aAD = C10229e.hqP;
            String str = c10229e.hqM;
            if (str == null) {
                C25052j.dWJ();
            }
            aAD.put(str, c10229e);
            AppMethodBeat.m2505o(134619);
        }
    }

    private C10229e(String str) {
        C25052j.m39376p(str, "kv");
        AppMethodBeat.m2504i(134622);
        this.hqM = str;
        this.hqN = false;
        this.hqO = true;
        boolean z = !C6163u.m9837ar((CharSequence) this.hqM);
        if (!C44847aa.AUz || z) {
            AppMethodBeat.m2505o(134622);
            return;
        }
        Throwable assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.m2505o(134622);
        throw assertionError;
    }

    private /* synthetic */ C10229e(String str, byte b) {
        this(str);
    }

    /* Access modifiers changed, original: protected|final */
    public final String aAy() {
        return this.hqM;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aAA() {
        return this.hqO;
    }

    static {
        AppMethodBeat.m2504i(134623);
        C10228a.m17878a(new C10229e("localso", (byte) 0));
        C10228a.m17878a(new C10229e("showmemory", (byte) 0));
        AppMethodBeat.m2505o(134623);
    }

    public final /* synthetic */ Object aAB() {
        AppMethodBeat.m2504i(134620);
        Boolean valueOf = Boolean.valueOf(this.hqN);
        AppMethodBeat.m2505o(134620);
        return valueOf;
    }

    /* renamed from: Ap */
    public final /* synthetic */ Object mo21635Ap(String str) {
        AppMethodBeat.m2504i(134621);
        Boolean Ar = C26881g.m42814Ar(str);
        AppMethodBeat.m2505o(134621);
        return Ar;
    }

    /* renamed from: Aq */
    public static final C10229e m17879Aq(String str) {
        AppMethodBeat.m2504i(134624);
        C25052j.m39376p(str, "kv_name");
        Object obj = hqP.get(str);
        if (obj == null) {
            C25052j.dWJ();
        }
        C10229e c10229e = (C10229e) obj;
        AppMethodBeat.m2505o(134624);
        return c10229e;
    }
}
