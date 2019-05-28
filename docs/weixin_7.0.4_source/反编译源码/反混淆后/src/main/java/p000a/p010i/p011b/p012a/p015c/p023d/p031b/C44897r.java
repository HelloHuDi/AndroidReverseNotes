package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0037k;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41394ai;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C31671d;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C44893t;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C31680j.C17232c;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C31680j.C31681b;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C25176c;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.b.r */
public final class C44897r {
    /* renamed from: a */
    private static String m82107a(C8083t c8083t, boolean z, boolean z2) {
        String str;
        C46867w dZS;
        AppMethodBeat.m2504i(120300);
        C25052j.m39376p(c8083t, "receiver$0");
        StringBuilder stringBuilder = new StringBuilder();
        if (z2) {
            if (c8083t instanceof C0037k) {
                str = "<init>";
            } else {
                str = c8083t.dZg().name;
                C25052j.m39375o(str, "name.asString()");
            }
            stringBuilder.append(str);
        }
        stringBuilder.append("(");
        for (C41399au c41399au : c8083t.dYV()) {
            C25052j.m39375o(c41399au, "parameter");
            dZS = c41399au.dZS();
            C25052j.m39375o(dZS, "parameter.type");
            C44897r.m82109a(stringBuilder, dZS);
        }
        stringBuilder.append(")");
        if (z) {
            Object obj;
            C8045a c8045a = c8083t;
            C25052j.m39376p(c8045a, "descriptor");
            if (c8045a instanceof C0037k) {
                obj = 1;
            } else {
                C46867w dYT = c8045a.dYT();
                if (dYT == null) {
                    C25052j.dWJ();
                }
                if (C31619g.m51097D(dYT)) {
                    dYT = c8045a.dYT();
                    if (dYT == null) {
                        C25052j.dWJ();
                    }
                    if (!(C17316av.m26813aB(dYT) || (c8045a instanceof C41394ai))) {
                        int obj2 = 1;
                    }
                }
                obj2 = null;
            }
            if (obj2 != null) {
                stringBuilder.append("V");
            } else {
                dZS = c8083t.dYT();
                if (dZS == null) {
                    C25052j.dWJ();
                }
                C25052j.m39375o(dZS, "returnType!!");
                C44897r.m82109a(stringBuilder, dZS);
            }
        }
        str = stringBuilder.toString();
        C25052j.m39375o(str, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.m2505o(120300);
        return str;
    }

    /* renamed from: a */
    public static /* synthetic */ String m82108a(C8083t c8083t, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(120301);
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        String a = C44897r.m82107a(c8083t, z, z2);
        AppMethodBeat.m2505o(120301);
        return a;
    }

    /* renamed from: b */
    public static final boolean m82110b(C8045a c8045a) {
        C25176c c25176c = null;
        AppMethodBeat.m2504i(120302);
        C25052j.m39376p(c8045a, "f");
        if (!(c8045a instanceof C8083t)) {
            AppMethodBeat.m2505o(120302);
            return false;
        } else if (((C8083t) c8045a).dYV().size() == 1 && !C44893t.m82103s((C25085b) c8045a) && (C25052j.m39373j(((C8083t) c8045a).dZg().name, "remove") ^ 1) == 0) {
            C8083t dZp = ((C8083t) c8045a).dZp();
            C25052j.m39375o(dZp, "f.original");
            List dYV = dZp.dYV();
            C25052j.m39375o(dYV, "f.original.valueParameters");
            Object fN = C25035t.m39341fN(dYV);
            C25052j.m39375o(fN, "f.original.valueParameters.single()");
            C46867w dZS = ((C41399au) fN).dZS();
            C25052j.m39375o(dZS, "f.original.valueParameters.single().type");
            C31680j V = C44897r.m82106V(dZS);
            if (!(V instanceof C17232c)) {
                V = null;
            }
            C17232c c17232c = (C17232c) V;
            if (c17232c != null) {
                c25176c = c17232c.BrE;
            }
            if (c25176c != C25176c.INT) {
                AppMethodBeat.m2505o(120302);
                return false;
            }
            C8083t e = C31671d.m51231e((C8083t) c8045a);
            if (e == null) {
                AppMethodBeat.m2505o(120302);
                return false;
            }
            dZp = e.dZp();
            C25052j.m39375o(dZp, "overridden.original");
            dYV = dZp.dYV();
            C25052j.m39375o(dYV, "overridden.original.valueParameters");
            fN = C25035t.m39341fN(dYV);
            C25052j.m39375o(fN, "overridden.original.valueParameters.single()");
            dZS = ((C41399au) fN).dZS();
            C25052j.m39375o(dZS, "overridden.original.valueParameters.single().type");
            V = C44897r.m82106V(dZS);
            C31642l dXW = e.dXW();
            C25052j.m39375o(dXW, "overridden.containingDeclaration");
            if (C25052j.m39373j(C41434a.m72285q(dXW), C31619g.Bag.Bbi.ByQ) && (V instanceof C31681b) && C25052j.m39373j(((C31681b) V).BrD, "java/lang/Object")) {
                AppMethodBeat.m2505o(120302);
                return true;
            }
            AppMethodBeat.m2505o(120302);
            return false;
        } else {
            AppMethodBeat.m2505o(120302);
            return false;
        }
    }

    /* renamed from: a */
    private static final void m82109a(StringBuilder stringBuilder, C46867w c46867w) {
        AppMethodBeat.m2504i(120304);
        stringBuilder.append(C44897r.m82106V(c46867w));
        AppMethodBeat.m2505o(120304);
    }

    /* renamed from: V */
    public static final C31680j m82106V(C46867w c46867w) {
        AppMethodBeat.m2504i(120305);
        C25052j.m39376p(c46867w, "receiver$0");
        C31680j c31680j = (C31680j) C17236y.m26625a(c46867w, C36995l.BrF, C17233w.BrW, C25130v.BrL);
        AppMethodBeat.m2505o(120305);
        return c31680j;
    }

    /* renamed from: c */
    public static final String m82111c(C8045a c8045a) {
        AppMethodBeat.m2504i(120303);
        C25052j.m39376p(c8045a, "receiver$0");
        C44898t c44898t = C44898t.BrJ;
        if (C8203d.m14485m(c8045a)) {
            AppMethodBeat.m2505o(120303);
            return null;
        }
        C31642l dXW = c8045a.dXW();
        if (!(dXW instanceof C46865e)) {
            dXW = null;
        }
        C46865e c46865e = (C46865e) dXW;
        if (c46865e == null) {
            AppMethodBeat.m2505o(120303);
            return null;
        }
        C37022f dZg = c46865e.dZg();
        C25052j.m39375o(dZg, "classDescriptor.name");
        if (dZg.ByZ) {
            AppMethodBeat.m2505o(120303);
            return null;
        }
        C8045a dYU = c8045a.dYU();
        if (!(dYU instanceof C41397al)) {
            dYU = null;
        }
        C41397al c41397al = (C41397al) dYU;
        if (c41397al == null) {
            AppMethodBeat.m2505o(120303);
            return null;
        }
        String a = C44898t.m82112a(c46865e, C44897r.m82108a(c41397al, false, false, 3));
        AppMethodBeat.m2505o(120303);
        return a;
    }
}
