package com.tencent.p177mm.plugin.appbrand.game.p291a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.game.p291a.C10229e.C10228a;
import com.tencent.p177mm.plugin.appbrand.game.p895g.C38229a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44847aa;
import p000a.C44856f;
import p000a.p001a.C0008d;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p051k.C0218t;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u0000 )*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\r\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\r\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0012J\r\u0010\u0014\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0012J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH$¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u000bJ\b\u0010&\u001a\u00020\u0007H\u0004J\u0015\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010(R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.a.g */
public abstract class C26881g<T> {
    private static final C44856f hqT = C17344i.m26854g(C26882b.hqV);
    public static final C26883a hqU = new C26883a();
    private T hqS;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.game.a.g$c */
    static final class C2155c implements OnClickListener {
        public static final C2155c hqW = new C2155c();

        static {
            AppMethodBeat.m2504i(134635);
            AppMethodBeat.m2505o(134635);
        }

        C2155c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(134634);
            C38229a c38229a = C38229a.huo;
            C38229a.aBI();
            C38229a.aBH();
            AppMethodBeat.m2505o(134634);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.game.a.g$b */
    static final class C26882b extends C25053k implements C31214a<List<C26881g<?>>> {
        public static final C26882b hqV = new C26882b();

        static {
            AppMethodBeat.m2504i(134630);
            AppMethodBeat.m2505o(134630);
        }

        C26882b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134629);
            C26881g[] c26881gArr = new C26881g[]{C31292d.hqL, C38213c.hqH, C45554b.hqB};
            C25052j.m39376p(c26881gArr, MessengerShareContentUtility.ELEMENTS);
            List arrayList = new ArrayList(new C0008d(c26881gArr, true));
            C10228a c10228a = C10229e.hqQ;
            Collection values = C10229e.hqP.values();
            C25052j.m39375o(values, "registry.values");
            arrayList.addAll(values);
            C26883a c26883a = C26881g.hqU;
            C26883a.m42821aG(arrayList);
            AppMethodBeat.m2505o(134629);
            return arrayList;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0002J%\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R%\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.game.a.g$a */
    public static final class C26883a {
        static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C26883a.class), "mCommandProcessor", "getMCommandProcessor()Ljava/util/List;"))};

        static {
            AppMethodBeat.m2504i(134631);
            AppMethodBeat.m2505o(134631);
        }

        private C26883a() {
        }

        public /* synthetic */ C26883a(byte b) {
            this();
        }

        /* renamed from: a */
        public static void m42820a(Context context, String[] strArr) {
            AppMethodBeat.m2504i(134632);
            C25052j.m39376p(context, "context");
            C25052j.m39376p(strArr, "args");
            int i = strArr.length >= 3 ? 1 : 0;
            Throwable assertionError;
            if (C44847aa.AUz && i == 0) {
                assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.m2505o(134632);
                throw assertionError;
            }
            i = (strArr[1] == null || strArr[0] == null) ? 0 : 1;
            if (C44847aa.AUz && i == 0) {
                assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.m2505o(134632);
                throw assertionError;
            }
            boolean I = C6163u.m9833I("//wagame", strArr[0], true);
            if (!C44847aa.AUz || I) {
                Object obj;
                for (Object next : (List) C26881g.hqT.getValue()) {
                    if (C6163u.m9833I(strArr[1], ((C26881g) next).aAy(), false)) {
                        obj = next;
                        break;
                    }
                }
                obj = null;
                C26881g c26881g = (C26881g) obj;
                if (c26881g == null) {
                    Toast.makeText(C4996ah.getContext(), "Unknown config name " + strArr[1], 0).show();
                    AppMethodBeat.m2505o(134632);
                    return;
                }
                c26881g.mo44641V(context, strArr[2]);
                AppMethodBeat.m2505o(134632);
                return;
            }
            assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.m2505o(134632);
            throw assertionError;
        }

        /* renamed from: aG */
        public static final /* synthetic */ void m42821aG(List list) {
            AppMethodBeat.m2504i(134633);
            Set linkedHashSet = new LinkedHashSet();
            for (C26881g aAy : list) {
                String aAy2 = aAy.aAy();
                if (aAy2 != null) {
                    Object obj = !linkedHashSet.contains(aAy2) ? 1 : null;
                    if (C44847aa.AUz && obj == null) {
                        Throwable assertionError = new AssertionError("Assertion failed");
                        AppMethodBeat.m2505o(134633);
                        throw assertionError;
                    }
                    linkedHashSet.add(aAy2);
                }
            }
            AppMethodBeat.m2505o(134633);
        }
    }

    /* renamed from: a */
    public static final void m42816a(Context context, String[] strArr) {
        C26883a.m42820a(context, strArr);
    }

    /* renamed from: Ap */
    public abstract T mo21635Ap(String str);

    public abstract T aAB();

    /* Access modifiers changed, original: protected */
    public C11745a aAz() {
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

    /* renamed from: Uw */
    public T mo21639Uw() {
        T t = this.hqS;
        if (t == null) {
            String amH;
            if (aAy() != null) {
                amH = C5018as.amF("WAGameDynamicConfig").amH("WAGameDynamicConfig" + aAy());
                if (amH == null) {
                    t = null;
                } else {
                    t = mo21635Ap(amH);
                }
                if (t != null) {
                    C4990ab.m7416i("WAGameDynamicConfig", "hit localstorage");
                    this.hqS = t;
                }
            }
            if (aAz() != null) {
                amH = ((C34069a) C1720g.m3528K(C34069a.class)).mo54613a(aAz(), "");
                if (amH != null) {
                    t = mo21635Ap(amH);
                    if (t != null) {
                        C4990ab.m7416i("WAGameDynamicConfig", "hit ABTest");
                        this.hqS = t;
                    }
                }
            }
            t = aAB();
            this.hqS = t;
        }
        return t;
    }

    /* renamed from: V */
    public final void mo44641V(Context context, String str) {
        Object obj = 1;
        C25052j.m39376p(context, "context");
        Object obj2 = aAy() != null ? 1 : null;
        if (C44847aa.AUz && obj2 == null) {
            throw new AssertionError("Assertion failed");
        }
        obj2 = mo21635Ap(str);
        if (obj2 == null) {
            obj2 = aAy() != null ? 1 : null;
            if (C44847aa.AUz && obj2 == null) {
                throw new AssertionError("Assertion failed");
            }
            C5018as amF = C5018as.amF("WAGameDynamicConfig");
            amF.remove("WAGameDynamicConfig" + aAy());
            amF.commit();
            if (amF.containsKey("WAGameDynamicConfig" + aAy())) {
                obj = null;
            }
            if (C44847aa.AUz && r1 == null) {
                throw new AssertionError("Assertion failed");
            }
            C4990ab.m7416i("WAGameDynamicConfig", "dl: remove localstorage config");
            if (aAA()) {
                C26881g.m42815W(context, "config[" + aAy() + "] removed");
                return;
            }
            return;
        }
        if (aAy() == null) {
            obj = null;
        }
        if (C44847aa.AUz && obj == null) {
            throw new AssertionError("Assertion failed");
        }
        C5018as amF2 = C5018as.amF("WAGameDynamicConfig");
        amF2.encode("WAGameDynamicConfig" + aAy(), String.valueOf(obj2));
        amF2.commit();
        C4990ab.m7416i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(str)));
        if (aAA()) {
            C26881g.m42815W(context, "config[" + aAy() + "] set to " + obj2);
        }
    }

    /* renamed from: W */
    private static void m42815W(Context context, String str) {
        new Builder(context).setTitle("").setMessage(str).setNegativeButton("cancel", null).setPositiveButton("restart", C2155c.hqW).show();
    }

    /* renamed from: Ar */
    protected static Boolean m42814Ar(String str) {
        if (str == null) {
            return null;
        }
        if ("true".contentEquals(str)) {
            return Boolean.TRUE;
        }
        if ("false".contentEquals(str)) {
            return Boolean.FALSE;
        }
        Integer awy = C0218t.awy(str);
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
