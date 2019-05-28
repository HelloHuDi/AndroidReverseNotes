package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p000a.p001a.C17115v;
import p000a.p001a.C44628q;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25051i;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C36663b;
import p000a.p010i.C44935d;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C17276b;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C17281i;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41432f;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41439d;
import p000a.p010i.p011b.p012a.p015c.p048n.C44928g;
import p000a.p010i.p011b.p012a.p015c.p048n.C8261e;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.a */
public final class C0045a {
    private final C41439d<C46865e, C44869c> Bkd;
    public final boolean Bke = this.Bkf.ekx();
    public final C8261e Bkf;

    /* renamed from: a.i.b.a.c.d.a.a$a */
    public enum C0046a {
        METHOD_RETURN_TYPE,
        VALUE_PARAMETER,
        FIELD,
        TYPE_USE;

        static {
            AppMethodBeat.m2505o(119641);
        }
    }

    /* renamed from: a.i.b.a.c.d.a.a$c */
    static final class C0047c extends C25051i implements C17126b<C46865e, C44869c> {
        C0047c(C0045a c0045a) {
            super((Object) c0045a);
        }

        public final C44935d dWF() {
            AppMethodBeat.m2504i(119648);
            C36663b aN = C44855v.m82055aN(C0045a.class);
            AppMethodBeat.m2505o(119648);
            return aN;
        }

        public final String due() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119647);
            C46865e c46865e = (C46865e) obj;
            C25052j.m39376p(c46865e, "p1");
            C44869c a = C0045a.m41a((C0045a) this.AVx, c46865e);
            AppMethodBeat.m2505o(119647);
            return a;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.a$b */
    public static final class C0048b {
        public final C44869c Bkl;
        private final int Bkm;

        public C0048b(C44869c c44869c, int i) {
            C25052j.m39376p(c44869c, "typeQualifier");
            AppMethodBeat.m2504i(119646);
            this.Bkl = c44869c;
            this.Bkm = i;
            AppMethodBeat.m2505o(119646);
        }

        public final List<C0046a> eaP() {
            AppMethodBeat.m2504i(119644);
            C0046a[] values = C0046a.values();
            Collection arrayList = new ArrayList();
            for (C0046a c0046a : values) {
                Object obj;
                C0048b c0048b = this;
                if (c0048b.m49a(C0046a.TYPE_USE) || c0048b.m49a(c0046a)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add(c0046a);
                }
            }
            List list = (List) arrayList;
            AppMethodBeat.m2505o(119644);
            return list;
        }

        /* renamed from: a */
        private final boolean m49a(C0046a c0046a) {
            AppMethodBeat.m2504i(119645);
            if ((this.Bkm & (1 << c0046a.ordinal())) != 0) {
                AppMethodBeat.m2505o(119645);
                return true;
            }
            AppMethodBeat.m2505o(119645);
            return false;
        }
    }

    public C0045a(C25212i c25212i, C8261e c8261e) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c8261e, "jsr305State");
        AppMethodBeat.m2504i(119655);
        this.Bkf = c8261e;
        this.Bkd = c25212i.mo31372g(new C0047c(this));
        AppMethodBeat.m2505o(119655);
    }

    /* renamed from: d */
    public final C44869c mo83d(C44869c c44869c) {
        AppMethodBeat.m2504i(119649);
        C25052j.m39376p(c44869c, "annotationDescriptor");
        if (this.Bkf.ekx()) {
            AppMethodBeat.m2505o(119649);
            return null;
        }
        C46865e l = C41434a.m72282l(c44869c);
        if (l == null) {
            AppMethodBeat.m2505o(119649);
            return null;
        } else if (C31652b.m51198r(l)) {
            AppMethodBeat.m2505o(119649);
            return c44869c;
        } else if (l.dYc() != C36964f.ANNOTATION_CLASS) {
            AppMethodBeat.m2505o(119649);
            return null;
        } else {
            C44869c c44869c2 = (C44869c) this.Bkd.mo50am(l);
            AppMethodBeat.m2505o(119649);
            return c44869c2;
        }
    }

    /* renamed from: e */
    public final C0048b mo84e(C44869c c44869c) {
        AppMethodBeat.m2504i(119650);
        C25052j.m39376p(c44869c, "annotationDescriptor");
        if (this.Bkf.ekx()) {
            AppMethodBeat.m2505o(119650);
            return null;
        }
        C46865e l = C41434a.m72282l(c44869c);
        if (l != null) {
            C46865e c46865e;
            if (l.dYn().mo55j(C31652b.Bkp)) {
                c46865e = l;
            } else {
                c46865e = null;
            }
            if (c46865e != null) {
                Object obj;
                l = C41434a.m72282l(c44869c);
                if (l == null) {
                    C25052j.dWJ();
                }
                C44869c i = l.dYn().mo53i(C31652b.Bkp);
                if (i == null) {
                    C25052j.dWJ();
                }
                Map eah = i.eah();
                Collection arrayList = new ArrayList();
                for (Entry entry : eah.entrySet()) {
                    List a;
                    C37022f c37022f = (C37022f) entry.getKey();
                    C41432f c41432f = (C41432f) entry.getValue();
                    if (C25052j.m39373j(c37022f, C17230p.Bln)) {
                        a = m42a(c41432f);
                    } else {
                        a = C17115v.AUP;
                    }
                    C44628q.m81054a(arrayList, (Iterable) a);
                }
                int i2 = 0;
                for (C0046a ordinal : (List) arrayList) {
                    i2 = (1 << ordinal.ordinal()) | i2;
                }
                for (Object next : c46865e.dYn()) {
                    int i3;
                    if (mo83d((C44869c) next) != null) {
                        i3 = 1;
                        continue;
                    } else {
                        i3 = 0;
                        continue;
                    }
                    if (i3 != 0) {
                        obj = next;
                        break;
                    }
                }
                C0048b obj2 = null;
                i = (C44869c) obj2;
                if (i == null) {
                    AppMethodBeat.m2505o(119650);
                    return null;
                }
                C0048b c0048b = new C0048b(i, i2);
                AppMethodBeat.m2505o(119650);
                return c0048b;
            }
        }
        AppMethodBeat.m2505o(119650);
        return null;
    }

    /* renamed from: f */
    public final C44928g mo85f(C44869c c44869c) {
        AppMethodBeat.m2504i(119651);
        C25052j.m39376p(c44869c, "annotationDescriptor");
        C44928g g = mo86g(c44869c);
        if (g != null) {
            AppMethodBeat.m2505o(119651);
            return g;
        }
        g = this.Bkf.BMZ;
        AppMethodBeat.m2505o(119651);
        return g;
    }

    /* renamed from: g */
    public final C44928g mo86g(C44869c c44869c) {
        Object obj;
        AppMethodBeat.m2504i(119652);
        C25052j.m39376p(c44869c, "annotationDescriptor");
        Map map = this.Bkf.BNb;
        C8174b dZF = c44869c.dZF();
        if (dZF != null) {
            obj = dZF.ByQ.ByV;
        } else {
            obj = null;
        }
        C44928g c44928g = (C44928g) map.get(obj);
        if (c44928g != null) {
            AppMethodBeat.m2505o(119652);
            return c44928g;
        }
        C46865e l = C41434a.m72282l(c44869c);
        if (l != null) {
            c44928g = m43q(l);
            AppMethodBeat.m2505o(119652);
            return c44928g;
        }
        AppMethodBeat.m2505o(119652);
        return null;
    }

    /* renamed from: q */
    private final C44928g m43q(C46865e c46865e) {
        AppMethodBeat.m2504i(119653);
        C44869c i = c46865e.dYn().mo53i(C31652b.Bkq);
        C41432f m = i != null ? C41434a.m72283m(i) : null;
        if (!(m instanceof C17281i)) {
            m = null;
        }
        C17281i c17281i = (C17281i) m;
        if (c17281i == null) {
            AppMethodBeat.m2505o(119653);
            return null;
        }
        C44928g c44928g = this.Bkf.BNa;
        if (c44928g != null) {
            AppMethodBeat.m2505o(119653);
            return c44928g;
        }
        String str = c17281i.BES.name;
        C44928g c44928g2;
        switch (str.hashCode()) {
            case -2137067054:
                if (str.equals("IGNORE")) {
                    c44928g2 = C44928g.IGNORE;
                    AppMethodBeat.m2505o(119653);
                    return c44928g2;
                }
                break;
            case -1838656823:
                if (str.equals("STRICT")) {
                    c44928g2 = C44928g.STRICT;
                    AppMethodBeat.m2505o(119653);
                    return c44928g2;
                }
                break;
            case 2656902:
                if (str.equals("WARN")) {
                    c44928g2 = C44928g.WARN;
                    AppMethodBeat.m2505o(119653);
                    return c44928g2;
                }
                break;
        }
        AppMethodBeat.m2505o(119653);
        return null;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final List<C0046a> m42a(C41432f<?> c41432f) {
        AppMethodBeat.m2504i(119654);
        if (c41432f instanceof C17276b) {
            Collection arrayList = new ArrayList();
            for (C41432f a : (Iterable) ((C17276b) c41432f).getValue()) {
                C44628q.m81054a(arrayList, (Iterable) m42a(a));
            }
            List list = (List) arrayList;
            AppMethodBeat.m2505o(119654);
            return list;
        } else if (c41432f instanceof C17281i) {
            Object obj;
            String ehN = ((C17281i) c41432f).BES.ehN();
            switch (ehN.hashCode()) {
                case -2024225567:
                    if (ehN.equals("METHOD")) {
                        obj = C0046a.METHOD_RETURN_TYPE;
                        break;
                    }
                case 66889946:
                    if (ehN.equals("FIELD")) {
                        obj = C0046a.FIELD;
                        break;
                    }
                case 107598562:
                    if (ehN.equals("TYPE_USE")) {
                        obj = C0046a.TYPE_USE;
                        break;
                    }
                case 446088073:
                    if (ehN.equals("PARAMETER")) {
                        obj = C0046a.VALUE_PARAMETER;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            List<C0046a> dm = C7987l.m14171dm(obj);
            AppMethodBeat.m2505o(119654);
            return dm;
        } else {
            List<C0046a> list2 = C17115v.AUP;
            AppMethodBeat.m2505o(119654);
            return list2;
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ C44869c m41a(C0045a c0045a, C46865e c46865e) {
        AppMethodBeat.m2504i(119656);
        if (c46865e.dYn().mo55j(C31652b.Bkn)) {
            for (C44869c d : c46865e.dYn()) {
                C44869c d2 = c0045a.mo83d(d2);
                if (d2 != null) {
                    AppMethodBeat.m2505o(119656);
                    return d2;
                }
            }
        }
        AppMethodBeat.m2505o(119656);
        return null;
    }
}
