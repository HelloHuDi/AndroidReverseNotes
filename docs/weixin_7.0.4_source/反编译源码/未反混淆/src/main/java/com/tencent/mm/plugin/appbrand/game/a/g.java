package com.tencent.mm.plugin.appbrand.game.a;

import a.a.d;
import a.aa;
import a.f;
import a.f.b.j;
import a.f.b.k;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.k.u;
import a.l;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u0000 )*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\r\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\r\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0012J\r\u0010\u0014\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0012J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH$¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u000bJ\b\u0010&\u001a\u00020\u0007H\u0004J\u0015\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010(R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class g<T> {
    private static final f hqT = i.g(b.hqV);
    public static final a hqU = new a();
    private T hqS;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class c implements OnClickListener {
        public static final c hqW = new c();

        static {
            AppMethodBeat.i(134635);
            AppMethodBeat.o(134635);
        }

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(134634);
            com.tencent.mm.plugin.appbrand.game.g.a aVar = com.tencent.mm.plugin.appbrand.game.g.a.huo;
            com.tencent.mm.plugin.appbrand.game.g.a.aBI();
            com.tencent.mm.plugin.appbrand.game.g.a.aBH();
            AppMethodBeat.o(134634);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
    static final class b extends k implements a.f.a.a<List<g<?>>> {
        public static final b hqV = new b();

        static {
            AppMethodBeat.i(134630);
            AppMethodBeat.o(134630);
        }

        b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134629);
            g[] gVarArr = new g[]{d.hqL, c.hqH, b.hqB};
            j.p(gVarArr, MessengerShareContentUtility.ELEMENTS);
            List arrayList = new ArrayList(new d(gVarArr, true));
            com.tencent.mm.plugin.appbrand.game.a.e.a aVar = e.hqQ;
            Collection values = e.hqP.values();
            j.o(values, "registry.values");
            arrayList.addAll(values);
            a aVar2 = g.hqU;
            a.aG(arrayList);
            AppMethodBeat.o(134629);
            return arrayList;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0002J%\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R%\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
    public static final class a {
        static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(a.class), "mCommandProcessor", "getMCommandProcessor()Ljava/util/List;"))};

        static {
            AppMethodBeat.i(134631);
            AppMethodBeat.o(134631);
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static void a(Context context, String[] strArr) {
            AppMethodBeat.i(134632);
            j.p(context, "context");
            j.p(strArr, "args");
            int i = strArr.length >= 3 ? 1 : 0;
            Throwable assertionError;
            if (aa.AUz && i == 0) {
                assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.o(134632);
                throw assertionError;
            }
            i = (strArr[1] == null || strArr[0] == null) ? 0 : 1;
            if (aa.AUz && i == 0) {
                assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.o(134632);
                throw assertionError;
            }
            boolean I = u.I("//wagame", strArr[0], true);
            if (!aa.AUz || I) {
                Object obj;
                for (Object next : (List) g.hqT.getValue()) {
                    if (u.I(strArr[1], ((g) next).aAy(), false)) {
                        obj = next;
                        break;
                    }
                }
                obj = null;
                g gVar = (g) obj;
                if (gVar == null) {
                    Toast.makeText(ah.getContext(), "Unknown config name " + strArr[1], 0).show();
                    AppMethodBeat.o(134632);
                    return;
                }
                gVar.V(context, strArr[2]);
                AppMethodBeat.o(134632);
                return;
            }
            assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.o(134632);
            throw assertionError;
        }

        public static final /* synthetic */ void aG(List list) {
            AppMethodBeat.i(134633);
            Set linkedHashSet = new LinkedHashSet();
            for (g aAy : list) {
                String aAy2 = aAy.aAy();
                if (aAy2 != null) {
                    Object obj = !linkedHashSet.contains(aAy2) ? 1 : null;
                    if (aa.AUz && obj == null) {
                        Throwable assertionError = new AssertionError("Assertion failed");
                        AppMethodBeat.o(134633);
                        throw assertionError;
                    }
                    linkedHashSet.add(aAy2);
                }
            }
            AppMethodBeat.o(134633);
        }
    }

    public static final void a(Context context, String[] strArr) {
        a.a(context, strArr);
    }

    public abstract T Ap(String str);

    public abstract T aAB();

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.expt.a.a.a aAz() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public String aAy() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public boolean aAA() {
        return true;
    }

    public T Uw() {
        T t = this.hqS;
        if (t == null) {
            String amH;
            if (aAy() != null) {
                amH = as.amF("WAGameDynamicConfig").amH("WAGameDynamicConfig" + aAy());
                if (amH == null) {
                    t = null;
                } else {
                    t = Ap(amH);
                }
                if (t != null) {
                    ab.i("WAGameDynamicConfig", "hit localstorage");
                    this.hqS = t;
                }
            }
            if (aAz() != null) {
                amH = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(aAz(), "");
                if (amH != null) {
                    t = Ap(amH);
                    if (t != null) {
                        ab.i("WAGameDynamicConfig", "hit ABTest");
                        this.hqS = t;
                    }
                }
            }
            t = aAB();
            this.hqS = t;
        }
        return t;
    }

    public final void V(Context context, String str) {
        Object obj = 1;
        j.p(context, "context");
        Object obj2 = aAy() != null ? 1 : null;
        if (aa.AUz && obj2 == null) {
            throw new AssertionError("Assertion failed");
        }
        obj2 = Ap(str);
        if (obj2 == null) {
            obj2 = aAy() != null ? 1 : null;
            if (aa.AUz && obj2 == null) {
                throw new AssertionError("Assertion failed");
            }
            as amF = as.amF("WAGameDynamicConfig");
            amF.remove("WAGameDynamicConfig" + aAy());
            amF.commit();
            if (amF.containsKey("WAGameDynamicConfig" + aAy())) {
                obj = null;
            }
            if (aa.AUz && r1 == null) {
                throw new AssertionError("Assertion failed");
            }
            ab.i("WAGameDynamicConfig", "dl: remove localstorage config");
            if (aAA()) {
                W(context, "config[" + aAy() + "] removed");
                return;
            }
            return;
        }
        if (aAy() == null) {
            obj = null;
        }
        if (aa.AUz && obj == null) {
            throw new AssertionError("Assertion failed");
        }
        as amF2 = as.amF("WAGameDynamicConfig");
        amF2.encode("WAGameDynamicConfig" + aAy(), String.valueOf(obj2));
        amF2.commit();
        ab.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(str)));
        if (aAA()) {
            W(context, "config[" + aAy() + "] set to " + obj2);
        }
    }

    private static void W(Context context, String str) {
        new Builder(context).setTitle("").setMessage(str).setNegativeButton("cancel", null).setPositiveButton("restart", c.hqW).show();
    }

    protected static Boolean Ar(String str) {
        if (str == null) {
            return null;
        }
        if ("true".contentEquals(str)) {
            return Boolean.TRUE;
        }
        if ("false".contentEquals(str)) {
            return Boolean.FALSE;
        }
        Integer awy = a.k.t.awy(str);
        if (awy == null) {
            return null;
        }
        if (awy.intValue() > 0) {
            return Boolean.TRUE;
        }
        if (awy.intValue() == 0 || awy.intValue() == -1) {
            return Boolean.FALSE;
        }
        throw new IllegalStateException("Ambiguity name");
    }
}
