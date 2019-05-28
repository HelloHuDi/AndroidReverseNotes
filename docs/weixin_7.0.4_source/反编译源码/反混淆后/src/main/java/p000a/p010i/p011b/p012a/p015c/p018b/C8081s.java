package p000a.p010i.p011b.p012a.p015c.p018b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25051i;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C36663b;
import p000a.p010i.C44935d;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p050j.C16496l;
import p000a.p050j.C17348n;

/* renamed from: a.i.b.a.c.b.s */
public final class C8081s {

    /* renamed from: a.i.b.a.c.b.s$b */
    static final class C8080b extends C25053k implements C17126b<C8173a, Integer> {
        public static final C8080b BeA = new C8080b();

        static {
            AppMethodBeat.m2504i(119272);
            AppMethodBeat.m2505o(119272);
        }

        C8080b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119271);
            C25052j.m39376p((C8173a) obj, "it");
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(119271);
            return valueOf;
        }
    }

    /* renamed from: a.i.b.a.c.b.s$a */
    static final class C8082a extends C25051i implements C17126b<C8173a, C8173a> {
        public static final C8082a Bez = new C8082a();

        static {
            AppMethodBeat.m2504i(119270);
            AppMethodBeat.m2505o(119270);
        }

        C8082a() {
            super(1);
        }

        public final C44935d dWF() {
            AppMethodBeat.m2504i(119269);
            C36663b aN = C44855v.m82055aN(C8173a.class);
            AppMethodBeat.m2505o(119269);
            return aN;
        }

        public final String due() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        public final String getName() {
            return "getOuterClassId";
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119268);
            C8173a c8173a = (C8173a) obj;
            C25052j.m39376p(c8173a, "p1");
            C8173a ehC = c8173a.ehC();
            AppMethodBeat.m2505o(119268);
            return ehC;
        }
    }

    /* renamed from: a */
    public static final C46865e m14262a(C25093y c25093y, C8173a c8173a, C44870aa c44870aa) {
        AppMethodBeat.m2504i(119274);
        C25052j.m39376p(c25093y, "receiver$0");
        C25052j.m39376p(c8173a, "classId");
        C25052j.m39376p(c44870aa, "notFoundClasses");
        C46865e a = C8081s.m14261a(c25093y, c8173a);
        if (a != null) {
            AppMethodBeat.m2505o(119274);
            return a;
        }
        a = c44870aa.mo72087a(c8173a, C17348n.m26862c(C17348n.m26863d(C16496l.m25325a(c8173a, C8082a.Bez), C8080b.BeA)));
        AppMethodBeat.m2505o(119274);
        return a;
    }

    /* renamed from: a */
    public static final C46865e m14261a(C25093y c25093y, C8173a c8173a) {
        AppMethodBeat.m2504i(119273);
        C25052j.m39376p(c25093y, "receiver$0");
        C25052j.m39376p(c8173a, "classId");
        C8174b c8174b = c8173a.BcW;
        C25052j.m39375o(c8174b, "classId.packageFqName");
        C36954ad g = c25093y.mo252g(c8174b);
        List ehM = c8173a.ByN.ByQ.ehM();
        C25052j.m39375o(ehM, "classId.relativeClassName.pathSegments()");
        C31746h dXR = g.dXR();
        Object fJ = C25035t.m39337fJ(ehM);
        C25052j.m39375o(fJ, "segments.first()");
        C0036h c = dXR.mo222c((C37022f) fJ, C0039c.FROM_DESERIALIZATION);
        if (!(c instanceof C46865e)) {
            c = null;
        }
        C46865e c46865e = (C46865e) c;
        if (c46865e == null) {
            AppMethodBeat.m2505o(119273);
            return null;
        }
        Iterator it = ehM.subList(1, ehM.size()).iterator();
        while (true) {
            C46865e c46865e2 = c46865e;
            if (it.hasNext()) {
                C37022f c37022f = (C37022f) it.next();
                C31746h dZk = c46865e2.dZk();
                C25052j.m39375o(c37022f, "name");
                c = dZk.mo222c(c37022f, C0039c.FROM_DESERIALIZATION);
                if (!(c instanceof C46865e)) {
                    c = null;
                }
                c46865e = (C46865e) c;
                if (c46865e == null) {
                    AppMethodBeat.m2505o(119273);
                    return null;
                }
            } else {
                AppMethodBeat.m2505o(119273);
                return c46865e2;
            }
        }
    }
}
