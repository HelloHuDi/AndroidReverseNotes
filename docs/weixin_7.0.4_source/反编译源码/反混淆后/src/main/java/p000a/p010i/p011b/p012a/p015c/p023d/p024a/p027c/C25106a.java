package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import p000a.C0219k;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C44876g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C0045a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C0045a.C0046a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C0045a.C0048b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C31652b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C31673x;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f.C41415h;
import p000a.p010i.p011b.p012a.p015c.p048n.C44928g;

/* renamed from: a.i.b.a.c.d.a.c.a */
public final class C25106a {

    /* renamed from: a.i.b.a.c.d.a.c.a$b */
    static final class C17177b extends C25053k implements C31214a<C36980d> {
        final /* synthetic */ C0057h BmP;
        final /* synthetic */ C0026g BmQ;

        C17177b(C0057h c0057h, C0026g c0026g) {
            this.BmP = c0057h;
            this.BmQ = c0026g;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119817);
            C36980d a = C25106a.m39482a(this.BmP, this.BmQ);
            AppMethodBeat.m2505o(119817);
            return a;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.a$a */
    static final class C25107a extends C25053k implements C31214a<C36980d> {
        final /* synthetic */ C0057h BmN;
        final /* synthetic */ C44876g BmO;

        C25107a(C0057h c0057h, C44876g c44876g) {
            this.BmN = c0057h;
            this.BmO = c44876g;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119816);
            C36980d a = C25106a.m39482a(this.BmN, this.BmO.dYn());
            AppMethodBeat.m2505o(119816);
            return a;
        }
    }

    /* renamed from: b */
    public static final C0057h m39486b(C0057h c0057h, C0026g c0026g) {
        AppMethodBeat.m2504i(119822);
        C25052j.m39376p(c0057h, "receiver$0");
        C25052j.m39376p(c0026g, "additionalAnnotations");
        if (c0026g.isEmpty()) {
            AppMethodBeat.m2505o(119822);
            return c0057h;
        }
        C0057h c0057h2 = new C0057h(c0057h.Bnv, c0057h.Bnw, C17344i.m26853a(C0219k.NONE, new C17177b(c0057h, c0026g)));
        AppMethodBeat.m2505o(119822);
        return c0057h2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final C36980d m39482a(C0057h c0057h, C0026g c0026g) {
        AppMethodBeat.m2504i(119818);
        C25052j.m39376p(c0057h, "receiver$0");
        C25052j.m39376p(c0026g, "additionalAnnotations");
        C36980d ebm;
        if (c0057h.Bnv.Bne.Bke) {
            ebm = c0057h.ebm();
            AppMethodBeat.m2505o(119818);
            return ebm;
        }
        Object obj;
        Collection arrayList = new ArrayList();
        for (C44869c c44869c : c0026g) {
            C31668k c31668k;
            C0045a c0045a = c0057h.Bnv.Bne;
            C25052j.m39376p(c44869c, "annotationDescriptor");
            if (c0045a.Bkf.ekx()) {
                obj = null;
            } else {
                c31668k = (C31668k) C31652b.Bkr.get(c44869c.dZF());
                if (c31668k != null) {
                    C41415h c41415h = c31668k.BnC;
                    Collection collection = c31668k.BnD;
                    C44928g f = c0045a.mo85f(c44869c);
                    C44928g c44928g = (f != C44928g.IGNORE ? 1 : null) != null ? f : null;
                    obj = c44928g == null ? null : new C31668k(C41415h.m72232a(c41415h, c44928g.eky()), collection);
                } else {
                    obj = null;
                }
            }
            if (obj == null) {
                C0048b e = c0045a.mo84e(c44869c);
                if (e == null) {
                    obj = null;
                } else {
                    C44869c c44869c2 = e.Bkl;
                    List eaP = e.eaP();
                    C44928g g = c0045a.mo86g(c44869c);
                    if (g == null) {
                        g = c0045a.mo85f(c44869c2);
                    }
                    if (g.ekz()) {
                        obj = null;
                    } else {
                        C41415h i = c0057h.Bnv.Bnf.mo31285i(c44869c2);
                        if (i != null) {
                            i = C41415h.m72232a(i, g.eky());
                            if (i != null) {
                                c31668k = new C31668k(i, eaP);
                            }
                        }
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        List<C31668k> list = (List) arrayList;
        if (list.isEmpty()) {
            ebm = c0057h.ebm();
            AppMethodBeat.m2505o(119818);
            return ebm;
        }
        EnumMap enumMap;
        C36980d ebm2 = c0057h.ebm();
        if (ebm2 != null) {
            EnumMap enumMap2 = ebm2.Bnl;
            if (enumMap2 != null) {
                enumMap = new EnumMap(enumMap2);
                obj = null;
                for (C31668k c31668k2 : list) {
                    C41415h c41415h2 = c31668k2.BnC;
                    Object obj2 = obj;
                    for (C0046a put : c31668k2.BnD) {
                        enumMap.put(put, c41415h2);
                        int obj22 = 1;
                    }
                    obj = obj22;
                }
                if (obj != null) {
                    ebm = c0057h.ebm();
                    AppMethodBeat.m2505o(119818);
                    return ebm;
                }
                ebm = new C36980d(enumMap);
                AppMethodBeat.m2505o(119818);
                return ebm;
            }
        }
        enumMap = new EnumMap(C0046a.class);
        obj = null;
        for (C31668k c31668k22 : list) {
        }
        if (obj != null) {
        }
    }

    /* renamed from: a */
    private static final C0057h m39485a(C0057h c0057h, C31642l c31642l, C31673x c31673x, int i, C44856f<C36980d> c44856f) {
        C31669m c17185i;
        AppMethodBeat.m2504i(119819);
        C36979b c36979b = c0057h.Bnv;
        if (c31673x != null) {
            c17185i = new C17185i(c0057h, c31642l, c31673x, i);
        } else {
            c17185i = c0057h.Bnw;
        }
        C0057h c0057h2 = new C0057h(c36979b, c17185i, c44856f);
        AppMethodBeat.m2505o(119819);
        return c0057h2;
    }

    /* renamed from: a */
    public static final C0057h m39484a(C0057h c0057h, C31642l c31642l, C31673x c31673x, int i) {
        AppMethodBeat.m2504i(119820);
        C25052j.m39376p(c0057h, "receiver$0");
        C25052j.m39376p(c31642l, "containingDeclaration");
        C25052j.m39376p(c31673x, "typeParameterOwner");
        C0057h a = C25106a.m39485a(c0057h, c31642l, c31673x, i, c0057h.Bnx);
        AppMethodBeat.m2505o(119820);
        return a;
    }
}
