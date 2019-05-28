package p000a.p010i.p011b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C25269o;
import p000a.p010i.C31811c;
import p000a.p010i.C36663b;
import p000a.p010i.C8299p;
import p000a.p010i.p011b.p012a.C25261x;
import p000a.p010i.p011b.p012a.C31806u;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, dWq = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflect-api"})
/* renamed from: a.i.b.a */
public final class C8294a {
    /* renamed from: a */
    private static C36663b<?> m14623a(C25269o c25269o) {
        AppMethodBeat.m2504i(118654);
        C25052j.m39376p(c25269o, "receiver$0");
        C31811c dWO = c25269o.dWO();
        if (dWO != null) {
            C36663b a = C8294a.m14622a(dWO);
            if (a != null) {
                AppMethodBeat.m2505o(118654);
                return a;
            }
        }
        Throwable c25261x = new C25261x("Cannot calculate JVM erasure for type: ".concat(String.valueOf(c25269o)));
        AppMethodBeat.m2505o(118654);
        throw c25261x;
    }

    /* renamed from: a */
    public static final C36663b<?> m14622a(C31811c c31811c) {
        AppMethodBeat.m2504i(118655);
        C25052j.m39376p(c31811c, "receiver$0");
        if (c31811c instanceof C36663b) {
            C36663b c36663b = (C36663b) c31811c;
            AppMethodBeat.m2505o(118655);
            return c36663b;
        } else if (c31811c instanceof C8299p) {
            C25269o c25269o;
            Object obj;
            C36663b<?> a;
            List dWP = ((C8299p) c31811c).dWP();
            for (Object next : dWP) {
                c25269o = (C25269o) next;
                if (c25269o != null) {
                    C0036h dYs = ((C31806u) c25269o).AYl.ejw().dYs();
                    if (!(dYs instanceof C46865e)) {
                        dYs = null;
                    }
                    C46865e c46865e = (C46865e) dYs;
                    if (c46865e == null || c46865e.dYc() == C36964f.INTERFACE || c46865e.dYc() == C36964f.ANNOTATION_CLASS) {
                        obj = null;
                        continue;
                    } else {
                        obj = 1;
                        continue;
                    }
                    if (obj != null) {
                        obj = next;
                        break;
                    }
                }
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                AppMethodBeat.m2505o(118655);
                throw c44941v;
            }
            obj = null;
            c25269o = (C25269o) obj;
            if (c25269o == null) {
                c25269o = (C25269o) C25035t.m39338fK(dWP);
            }
            if (c25269o != null) {
                a = C8294a.m14623a(c25269o);
                if (a != null) {
                    AppMethodBeat.m2505o(118655);
                    return a;
                }
            }
            a = C44855v.m82055aN(Object.class);
            AppMethodBeat.m2505o(118655);
            return a;
        } else {
            Throwable c25261x = new C25261x("Cannot calculate JVM erasure for type: ".concat(String.valueOf(c31811c)));
            AppMethodBeat.m2505o(118655);
            throw c25261x;
        }
    }
}
