package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import p000a.C8312u;
import p000a.p001a.C25034m;
import p000a.p001a.C31586ag;
import p000a.p001a.C44628q;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0030m;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C8043n;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C36983b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8116m;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C17276b;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C17281i;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41432f;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.d.a.a.d */
public final class C8088d {
    private static final Map<String, EnumSet<C8043n>> Bmg = C31586ag.m51049a(C8312u.m14628I("PACKAGE", EnumSet.noneOf(C8043n.class)), C8312u.m14628I("TYPE", EnumSet.of(C8043n.CLASS, C8043n.FILE)), C8312u.m14628I("ANNOTATION_TYPE", EnumSet.of(C8043n.ANNOTATION_CLASS)), C8312u.m14628I("TYPE_PARAMETER", EnumSet.of(C8043n.TYPE_PARAMETER)), C8312u.m14628I("FIELD", EnumSet.of(C8043n.FIELD)), C8312u.m14628I("LOCAL_VARIABLE", EnumSet.of(C8043n.LOCAL_VARIABLE)), C8312u.m14628I("PARAMETER", EnumSet.of(C8043n.VALUE_PARAMETER)), C8312u.m14628I("CONSTRUCTOR", EnumSet.of(C8043n.CONSTRUCTOR)), C8312u.m14628I("METHOD", EnumSet.of(C8043n.FUNCTION, C8043n.PROPERTY_GETTER, C8043n.PROPERTY_SETTER)), C8312u.m14628I("TYPE_USE", EnumSet.of(C8043n.TYPE)));
    private static final Map<String, C0030m> Bmh = C31586ag.m51049a(C8312u.m14628I("RUNTIME", C0030m.RUNTIME), C8312u.m14628I("CLASS", C0030m.BINARY), C8312u.m14628I("SOURCE", C0030m.SOURCE));
    public static final C8088d Bmi = new C8088d();

    /* renamed from: a.i.b.a.c.d.a.a.d$a */
    static final class C8089a extends C25053k implements C17126b<C25093y, C46867w> {
        public static final C8089a Bmj = new C8089a();

        static {
            AppMethodBeat.m2504i(119760);
            AppMethodBeat.m2505o(119760);
        }

        C8089a() {
            super(1);
        }

        /* JADX WARNING: Missing block: B:3:0x002a, code skipped:
            if (r0 == null) goto L_0x002c;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            Object dZS;
            AppMethodBeat.m2504i(119759);
            C25093y c25093y = (C25093y) obj;
            C25052j.m39376p(c25093y, "module");
            C0042c c0042c = C0042c.Bmf;
            C41399au b = C31644a.m51184b(C0042c.ebj(), c25093y.dZD().mo51611c(C31619g.Bag.BaQ));
            if (b != null) {
                dZS = b.dZS();
            }
            C8235ad awn = C25235p.awn("Error: AnnotationTarget[]");
            C25052j.m39375o(awn, "ErrorUtils.createErrorTy…ror: AnnotationTarget[]\")");
            dZS = awn;
            AppMethodBeat.m2505o(119759);
            return dZS;
        }
    }

    static {
        AppMethodBeat.m2504i(119763);
        AppMethodBeat.m2505o(119763);
    }

    private C8088d() {
    }

    /* renamed from: fW */
    public static C41432f<?> m14278fW(List<? extends C36983b> list) {
        AppMethodBeat.m2504i(119761);
        C25052j.m39376p(list, "arguments");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof C8116m) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (C8116m ebR : (List) arrayList) {
            Object obj;
            C37022f ebR2 = ebR.ebR();
            if (ebR2 != null) {
                obj = ebR2.name;
            } else {
                obj = null;
            }
            C44629x c44629x = (EnumSet) Bmg.get(obj);
            if (c44629x == null) {
                c44629x = C44629x.AUR;
            }
            C44628q.m81054a(arrayList2, (Iterable) c44629x);
        }
        Iterable<C8043n> iterable = (List) arrayList2;
        arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C8043n c8043n : iterable) {
            C8173a n = C8173a.m14427n(C31619g.Bag.BaR);
            C25052j.m39375o(n, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
            C37022f avX = C37022f.avX(c8043n.name());
            C25052j.m39375o(avX, "Name.identifier(kotlinTarget.name)");
            arrayList.add(new C17281i(n, avX));
        }
        C41432f c17276b = new C17276b((List) arrayList, C8089a.Bmj);
        AppMethodBeat.m2505o(119761);
        return c17276b;
    }

    /* renamed from: a */
    public static C41432f<?> m14277a(C36983b c36983b) {
        C17281i c17281i;
        AppMethodBeat.m2504i(119762);
        C8116m c8116m = (C8116m) (!(c36983b instanceof C8116m) ? null : c36983b);
        if (c8116m != null) {
            Object obj;
            Map map = Bmh;
            C37022f ebR = c8116m.ebR();
            if (ebR != null) {
                obj = ebR.name;
            } else {
                obj = null;
            }
            C0030m c0030m = (C0030m) map.get(obj);
            if (c0030m != null) {
                C8173a n = C8173a.m14427n(C31619g.Bag.BaS);
                C25052j.m39375o(n, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
                ebR = C37022f.avX(c0030m.name());
                C25052j.m39375o(ebR, "Name.identifier(retention.name)");
                c17281i = new C17281i(n, ebR);
            } else {
                c17281i = null;
            }
        } else {
            c17281i = null;
        }
        C41432f c41432f = c17281i;
        AppMethodBeat.m2505o(119762);
        return c41432f;
    }
}
