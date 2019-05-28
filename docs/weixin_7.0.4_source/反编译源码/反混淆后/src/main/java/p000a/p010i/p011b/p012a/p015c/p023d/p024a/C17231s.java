package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C44847aa;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p047m.p1360a.C31775a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p051k.C31820v;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.d.a.s */
public final class C17231s {
    /* renamed from: a */
    private static C37022f m26621a(C37022f c37022f, boolean z) {
        AppMethodBeat.m2504i(119723);
        C25052j.m39376p(c37022f, "methodName");
        C37022f a = C17231s.m26620a(c37022f, "set", false, z ? "is" : null, 4);
        AppMethodBeat.m2505o(119723);
        return a;
    }

    /* renamed from: a */
    private static /* synthetic */ C37022f m26620a(C37022f c37022f, String str, boolean z, String str2, int i) {
        AppMethodBeat.m2504i(119725);
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        C37022f a = C17231s.m26619a(c37022f, str, z, str2);
        AppMethodBeat.m2505o(119725);
        return a;
    }

    /* renamed from: a */
    private static final C37022f m26619a(C37022f c37022f, String str, boolean z, String str2) {
        AppMethodBeat.m2504i(119724);
        if (c37022f.ByZ) {
            AppMethodBeat.m2505o(119724);
            return null;
        }
        String ehN = c37022f.ehN();
        C25052j.m39375o(ehN, "methodName.identifier");
        if (!C6163u.m9839jb(ehN, str)) {
            AppMethodBeat.m2505o(119724);
            return null;
        } else if (ehN.length() == str.length()) {
            AppMethodBeat.m2505o(119724);
            return null;
        } else {
            char charAt = ehN.charAt(str.length());
            if ('a' <= charAt && 'z' >= charAt) {
                AppMethodBeat.m2505o(119724);
                return null;
            } else if (str2 != null) {
                if (!C44847aa.AUz || z) {
                    c37022f = C37022f.avX(str2 + C31820v.m51535b(ehN, (CharSequence) str));
                    AppMethodBeat.m2505o(119724);
                    return c37022f;
                }
                Throwable assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.m2505o(119724);
                throw assertionError;
            } else if (z) {
                ehN = C31775a.awr(C31820v.m51535b(ehN, (CharSequence) str));
                if (C37022f.avY(ehN)) {
                    c37022f = C37022f.avX(ehN);
                    AppMethodBeat.m2505o(119724);
                    return c37022f;
                }
                AppMethodBeat.m2505o(119724);
                return null;
            } else {
                AppMethodBeat.m2505o(119724);
                return c37022f;
            }
        }
    }

    /* renamed from: j */
    public static final List<C37022f> m26622j(C37022f c37022f) {
        AppMethodBeat.m2504i(119726);
        C25052j.m39376p(c37022f, "name");
        String str = c37022f.name;
        C25052j.m39375o(str, "name.asString()");
        List<C37022f> k;
        if (C25121o.avH(str)) {
            C25052j.m39376p(c37022f, "methodName");
            Object a = C17231s.m26620a(c37022f, "get", false, null, 12);
            if (a == null) {
                a = C17231s.m26620a(c37022f, "is", false, null, 8);
            }
            List dm = C7987l.m14171dm(a);
            AppMethodBeat.m2505o(119726);
            return dm;
        } else if (C25121o.avI(str)) {
            C25052j.m39376p(c37022f, "methodName");
            k = C25035t.m39350k(C7987l.listOf(C17231s.m26621a(c37022f, false), C17231s.m26621a(c37022f, true)));
            AppMethodBeat.m2505o(119726);
            return k;
        } else {
            C31675e c31675e = C31675e.BkZ;
            k = C31675e.m51236i(c37022f);
            AppMethodBeat.m2505o(119726);
            return k;
        }
    }
}
