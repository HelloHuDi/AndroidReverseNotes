package com.tencent.mm.plugin.appbrand.game.a;

import a.aa;
import a.f.b.j;
import a.k.u;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0014J\r\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class e extends g<Boolean> {
    private static final HashMap<String, e> hqP = new HashMap();
    public static final a hqQ = new a();
    final String hqM;
    private final boolean hqN;
    private final boolean hqO;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0007J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        static void a(e eVar) {
            AppMethodBeat.i(134619);
            Map aAD = e.hqP;
            String str = eVar.hqM;
            if (str == null) {
                j.dWJ();
            }
            aAD.put(str, eVar);
            AppMethodBeat.o(134619);
        }
    }

    private e(String str) {
        j.p(str, "kv");
        AppMethodBeat.i(134622);
        this.hqM = str;
        this.hqN = false;
        this.hqO = true;
        boolean z = !u.ar((CharSequence) this.hqM);
        if (!aa.AUz || z) {
            AppMethodBeat.o(134622);
            return;
        }
        Throwable assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(134622);
        throw assertionError;
    }

    private /* synthetic */ e(String str, byte b) {
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
        AppMethodBeat.i(134623);
        a.a(new e("localso", (byte) 0));
        a.a(new e("showmemory", (byte) 0));
        AppMethodBeat.o(134623);
    }

    public final /* synthetic */ Object aAB() {
        AppMethodBeat.i(134620);
        Boolean valueOf = Boolean.valueOf(this.hqN);
        AppMethodBeat.o(134620);
        return valueOf;
    }

    public final /* synthetic */ Object Ap(String str) {
        AppMethodBeat.i(134621);
        Boolean Ar = g.Ar(str);
        AppMethodBeat.o(134621);
        return Ar;
    }

    public static final e Aq(String str) {
        AppMethodBeat.i(134624);
        j.p(str, "kv_name");
        Object obj = hqP.get(str);
        if (obj == null) {
            j.dWJ();
        }
        e eVar = (e) obj;
        AppMethodBeat.o(134624);
        return eVar;
    }
}
