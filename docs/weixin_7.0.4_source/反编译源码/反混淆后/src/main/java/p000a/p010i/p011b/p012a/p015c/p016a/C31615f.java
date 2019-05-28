package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44847aa;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.p774a.C24604a;
import p000a.p010i.p011b.p012a.p015c.p016a.p774a.C24604a.C24605a;
import p000a.p010i.p011b.p012a.p015c.p016a.p774a.C24607b.C8027b;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C46864j;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C25174s;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p048n.C31780a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p015c.p778f.C8175c;

/* renamed from: a.i.b.a.c.a.f */
public final class C31615f {
    /* renamed from: d */
    public static final boolean m51084d(C46867w c46867w) {
        AppMethodBeat.m2504i(119080);
        C25052j.m39376p(c46867w, "receiver$0");
        C0036h dYs = c46867w.ejw().dYs();
        if ((dYs != null ? C31615f.m51080a((C31642l) dYs) : null) == C8027b.Function) {
            AppMethodBeat.m2505o(119080);
            return true;
        }
        AppMethodBeat.m2505o(119080);
        return false;
    }

    /* renamed from: e */
    public static final boolean m51085e(C46867w c46867w) {
        AppMethodBeat.m2504i(119081);
        C25052j.m39376p(c46867w, "receiver$0");
        C0036h dYs = c46867w.ejw().dYs();
        if ((dYs != null ? C31615f.m51080a((C31642l) dYs) : null) == C8027b.SuspendFunction) {
            AppMethodBeat.m2505o(119081);
            return true;
        }
        AppMethodBeat.m2505o(119081);
        return false;
    }

    /* renamed from: f */
    public static final boolean m51086f(C46867w c46867w) {
        AppMethodBeat.m2504i(119082);
        C25052j.m39376p(c46867w, "receiver$0");
        C0036h dYs = c46867w.ejw().dYs();
        C8027b a = dYs != null ? C31615f.m51080a((C31642l) dYs) : null;
        if (a == C8027b.Function || a == C8027b.SuspendFunction) {
            AppMethodBeat.m2505o(119082);
            return true;
        }
        AppMethodBeat.m2505o(119082);
        return false;
    }

    /* renamed from: g */
    private static final boolean m51087g(C46867w c46867w) {
        AppMethodBeat.m2504i(119083);
        C0026g dYn = c46867w.dYn();
        C8174b c8174b = C31619g.Bag.BaN;
        C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        if (dYn.mo53i(c8174b) != null) {
            AppMethodBeat.m2505o(119083);
            return true;
        }
        AppMethodBeat.m2505o(119083);
        return false;
    }

    /* renamed from: a */
    private static C8027b m51080a(C31642l c31642l) {
        AppMethodBeat.m2504i(119084);
        C25052j.m39376p(c31642l, "receiver$0");
        if (!(c31642l instanceof C46865e)) {
            AppMethodBeat.m2505o(119084);
            return null;
        } else if (C31619g.m51114c(c31642l)) {
            C8027b a = C31615f.m51081a(C41434a.m72285q(c31642l));
            AppMethodBeat.m2505o(119084);
            return a;
        } else {
            AppMethodBeat.m2505o(119084);
            return null;
        }
    }

    /* renamed from: a */
    private static final C8027b m51081a(C8175c c8175c) {
        AppMethodBeat.m2504i(119085);
        if (!c8175c.ehH() || c8175c.ByV.isEmpty()) {
            AppMethodBeat.m2505o(119085);
            return null;
        }
        C24605a c24605a = C24604a.BcI;
        String str = c8175c.ehK().name;
        C25052j.m39375o(str, "shortName().asString()");
        C8174b ehG = c8175c.ehI().ehG();
        C25052j.m39375o(ehG, "toSafe().parent()");
        C8027b b = C24605a.m38271b(str, ehG);
        AppMethodBeat.m2505o(119085);
        return b;
    }

    /* renamed from: h */
    public static final C46867w m51088h(C46867w c46867w) {
        AppMethodBeat.m2504i(119086);
        C25052j.m39376p(c46867w, "receiver$0");
        boolean f = C31615f.m51086f(c46867w);
        if (C44847aa.AUz && !f) {
            Throwable assertionError = new AssertionError("Not a function type: ".concat(String.valueOf(c46867w)));
            AppMethodBeat.m2505o(119086);
            throw assertionError;
        } else if (C31615f.m51087g(c46867w)) {
            C46867w dZS = ((C41446ap) C25035t.m39337fJ(c46867w.ejt())).dZS();
            AppMethodBeat.m2505o(119086);
            return dZS;
        } else {
            AppMethodBeat.m2505o(119086);
            return null;
        }
    }

    /* renamed from: i */
    public static final C46867w m51089i(C46867w c46867w) {
        AppMethodBeat.m2504i(119087);
        C25052j.m39376p(c46867w, "receiver$0");
        boolean f = C31615f.m51086f(c46867w);
        if (!C44847aa.AUz || f) {
            C46867w dZS = ((C41446ap) C25035t.m39339fL(c46867w.ejt())).dZS();
            C25052j.m39375o(dZS, "arguments.last().type");
            AppMethodBeat.m2505o(119087);
            return dZS;
        }
        Throwable assertionError = new AssertionError("Not a function type: ".concat(String.valueOf(c46867w)));
        AppMethodBeat.m2505o(119087);
        throw assertionError;
    }

    /* renamed from: j */
    public static final List<C41446ap> m51090j(C46867w c46867w) {
        Object obj = 1;
        AppMethodBeat.m2504i(119088);
        C25052j.m39376p(c46867w, "receiver$0");
        boolean f = C31615f.m51086f(c46867w);
        Throwable assertionError;
        if (!C44847aa.AUz || f) {
            Object obj2;
            List ejt = c46867w.ejt();
            C25052j.m39376p(c46867w, "receiver$0");
            if (C31615f.m51086f(c46867w) && C31615f.m51087g(c46867w)) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            int i = obj2 != null ? 1 : 0;
            int size = ejt.size() - 1;
            if (i > size) {
                obj = null;
            }
            if (C44847aa.AUz && obj == null) {
                assertionError = new AssertionError("Not an exact function type: ".concat(String.valueOf(c46867w)));
                AppMethodBeat.m2505o(119088);
                throw assertionError;
            }
            List subList = ejt.subList(i, size);
            AppMethodBeat.m2505o(119088);
            return subList;
        }
        assertionError = new AssertionError("Not a function type: ".concat(String.valueOf(c46867w)));
        AppMethodBeat.m2505o(119088);
        throw assertionError;
    }

    /* renamed from: k */
    public static final C37022f m51091k(C46867w c46867w) {
        AppMethodBeat.m2504i(119089);
        C25052j.m39376p(c46867w, "receiver$0");
        C0026g dYn = c46867w.dYn();
        C8174b c8174b = C31619g.Bag.BaO;
        C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.parameterName");
        C44869c i = dYn.mo53i(c8174b);
        if (i == null) {
            AppMethodBeat.m2505o(119089);
            return null;
        }
        Object i2 = C25035t.m39347i((Iterable) i.eah().values());
        if (!(i2 instanceof C25174s)) {
            i2 = null;
        }
        C25174s c25174s = (C25174s) i2;
        if (c25174s != null) {
            String str = (String) c25174s.getValue();
            if (str != null) {
                if (!C37022f.avY(str)) {
                    str = null;
                }
                if (str != null) {
                    C37022f avX = C37022f.avX(str);
                    AppMethodBeat.m2505o(119089);
                    return avX;
                }
            }
        }
        AppMethodBeat.m2505o(119089);
        return null;
    }

    /* renamed from: a */
    public static /* synthetic */ C8235ad m51082a(C31619g c31619g, C0026g c0026g, C46867w c46867w, List list, C46867w c46867w2) {
        AppMethodBeat.m2504i(119091);
        C8235ad a = C31615f.m51083a(c31619g, c0026g, c46867w, list, c46867w2, false);
        AppMethodBeat.m2505o(119091);
        return a;
    }

    /* renamed from: a */
    public static final C8235ad m51083a(C31619g c31619g, C0026g c0026g, C46867w c46867w, List<? extends C46867w> list, C46867w c46867w2, boolean z) {
        Object SM;
        AppMethodBeat.m2504i(119090);
        C25052j.m39376p(c31619g, "builtIns");
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(list, "parameterTypes");
        C25052j.m39376p(c46867w2, "returnType");
        C25052j.m39376p(list, "parameterTypes");
        C25052j.m39376p(c46867w2, "returnType");
        C25052j.m39376p(c31619g, "builtIns");
        ArrayList arrayList = new ArrayList(((c46867w != null ? 1 : 0) + list.size()) + 1);
        C31780a.m51478b(arrayList, c46867w != null ? C41448a.m72315aM(c46867w) : null);
        int i = 0;
        for (Object next : list) {
            Collection collection = arrayList;
            int i2 = i + 1;
            if (i < 0) {
                C7987l.dWs();
            }
            collection.add(C41448a.m72315aM((C46867w) next));
            i = i2;
        }
        arrayList.add(C41448a.m72315aM(c46867w2));
        List list2 = arrayList;
        int size = list.size();
        if (c46867w != null) {
            size++;
        }
        if (z) {
            SM = c31619g.mo51606SM(size);
        } else {
            SM = c31619g.avB(C31619g.m51099SK(size));
        }
        C25052j.m39375o(SM, "if (suspendFunction) bui…tFunction(parameterCount)");
        if (c46867w != null) {
            C8174b c8174b = C31619g.Bag.BaN;
            C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
            if (c0026g.mo53i(c8174b) == null) {
                C0027a c0027a = C0026g.BfJ;
                Iterable iterable = c0026g;
                C8174b c8174b2 = C31619g.Bag.BaN;
                C25052j.m39375o(c8174b2, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
                c0026g = C0027a.m29fS(C25035t.m39334d(iterable, new C46864j(c31619g, c8174b2, C31586ag.emptyMap())));
            }
        }
        C8235ad a = C17326x.m26837a(c0026g, SM, list2);
        AppMethodBeat.m2505o(119090);
        return a;
    }
}
