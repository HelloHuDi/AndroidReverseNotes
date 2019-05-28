package p000a.p010i.p011b.p012a.p015c.p016a.p774a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C38339e;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44847aa;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C41364y;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31615f;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C36961p;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C36961p.C24612a;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C41177ad;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C8069ai;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p047m.C37066j;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.a.a.f */
public final class C44867f extends C41177ad {
    public static final C17144a BcZ = new C17144a();

    /* renamed from: a.i.b.a.c.a.a.f$a */
    public static final class C17144a {
        private C17144a() {
        }

        public /* synthetic */ C17144a(byte b) {
            this();
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private static C41399au m26518a(C44867f c44867f, int i, C36955ar c36955ar) {
            String str;
            AppMethodBeat.m2504i(119159);
            String str2 = c36955ar.dZg().name;
            C25052j.m39375o(str2, "typeParameter.name.asString()");
            switch (str2.hashCode()) {
                case 69:
                    if (str2.equals(QLog.TAG_REPORTLEVEL_USER)) {
                        str = "receiver";
                        break;
                    }
                case C38339e.CTRL_INDEX /*84*/:
                    if (str2.equals("T")) {
                        str = "instance";
                        break;
                    }
                default:
                    if (str2 != null) {
                        str2 = str2.toLowerCase();
                        C25052j.m39375o(str2, "(this as java.lang.String).toLowerCase()");
                        str = str2;
                        break;
                    }
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.m2505o(119159);
                    throw c44941v;
            }
            C8045a c8045a = c44867f;
            C0027a c0027a = C0026g.BfJ;
            C0026g eai = C0027a.eai();
            C37022f avX = C37022f.avX(str);
            C25052j.m39375o(avX, "Name.identifier(name)");
            C8235ad dZf = c36955ar.dZf();
            C25052j.m39375o(dZf, "typeParameter.defaultType");
            C46867w c46867w = dZf;
            C41398am c41398am = C41398am.BeR;
            C25052j.m39375o(c41398am, "SourceElement.NO_SOURCE");
            C41399au c8069ai = new C8069ai(c8045a, null, i, eai, avX, c46867w, false, false, false, null, c41398am);
            AppMethodBeat.m2505o(119159);
            return c8069ai;
        }

        /* renamed from: a */
        public static C44867f m26517a(C24607b c24607b, boolean z) {
            AppMethodBeat.m2504i(119158);
            C25052j.m39376p(c24607b, "functionClass");
            List list = c24607b.parameters;
            C44867f c44867f = new C44867f(c24607b, C8063a.DECLARATION, z);
            C41396ak dZl = c24607b.dZl();
            List list2 = C17115v.AUP;
            Iterable iterable = list;
            ArrayList arrayList = new ArrayList();
            for (Object next : iterable) {
                boolean z2;
                if (((C36955ar) next).dZh() == C0163ba.IN_VARIANCE) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    break;
                }
                arrayList.add(next);
            }
            Iterable<C41364y> p = C25035t.m39355p(arrayList);
            Collection arrayList2 = new ArrayList(C25034m.m39318d(p));
            for (C41364y c41364y : p) {
                C17144a c17144a = C44867f.BcZ;
                arrayList2.add(C17144a.m26518a(c44867f, c41364y.index, (C36955ar) c41364y.value));
            }
            c44867f.mo65810b(null, dZl, list2, (List) arrayList2, ((C36955ar) C25035t.m39339fL(list)).dZf(), C44879w.ABSTRACT, C8051ay.Bfa);
            c44867f.mo97rI(true);
            AppMethodBeat.m2505o(119158);
            return c44867f;
        }
    }

    static {
        AppMethodBeat.m2504i(119164);
        AppMethodBeat.m2505o(119164);
    }

    private C44867f(C31642l c31642l, C44867f c44867f, C8063a c8063a, boolean z) {
        C41397al c41397al = c44867f;
        C0027a c0027a = C0026g.BfJ;
        super(c31642l, c41397al, C0027a.eai(), C37066j.BLT, c8063a, C41398am.BeR);
        AppMethodBeat.m2504i(119163);
        this.BhR = true;
        this.BhZ = z;
        mo96rH(false);
        AppMethodBeat.m2505o(119163);
    }

    public /* synthetic */ C44867f(C31642l c31642l, C8063a c8063a, boolean z) {
        this(c31642l, null, c8063a, z);
    }

    /* renamed from: a */
    public final C8083t mo58964a(C24612a c24612a) {
        AppMethodBeat.m2504i(119160);
        C25052j.m39376p(c24612a, "configuration");
        C44867f c44867f = (C44867f) super.mo58964a(c24612a);
        if (c44867f == null) {
            AppMethodBeat.m2505o(119160);
            return null;
        }
        C46867w dZS;
        Object obj;
        List list = c44867f.BhM;
        C25052j.m39375o(list, "substituted.valueParameters");
        Iterable<C41399au> iterable = list;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (C41399au c41399au : iterable) {
                C25052j.m39375o(c41399au, "it");
                dZS = c41399au.dZS();
                C25052j.m39375o(dZS, "it.type");
                if (C31615f.m51091k(dZS) != null) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    obj = null;
                    break;
                }
            }
        }
        int i = 1;
        C8083t c8083t;
        if (obj != null) {
            c8083t = c44867f;
            AppMethodBeat.m2505o(119160);
            return c8083t;
        }
        list = c44867f.BhM;
        C25052j.m39375o(list, "substituted.valueParameters");
        iterable = list;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C41399au c41399au2 : iterable) {
            C25052j.m39375o(c41399au2, "it");
            dZS = c41399au2.dZS();
            C25052j.m39375o(dZS, "it.type");
            arrayList.add(C31615f.m51091k(dZS));
        }
        c8083t = c44867f.m82063fQ((List) arrayList);
        AppMethodBeat.m2505o(119160);
        return c8083t;
    }

    /* renamed from: a */
    public final C36961p mo91a(C31642l c31642l, C8083t c8083t, C8063a c8063a, C37022f c37022f, C0026g c0026g, C41398am c41398am) {
        AppMethodBeat.m2504i(119161);
        C25052j.m39376p(c31642l, "newOwner");
        C25052j.m39376p(c8063a, "kind");
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(c41398am, "source");
        C36961p c44867f = new C44867f(c31642l, (C44867f) c8083t, c8063a, dZv());
        AppMethodBeat.m2505o(119161);
        return c44867f;
    }

    public final boolean dYm() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYx() {
        return false;
    }

    /* renamed from: fQ */
    private final C8083t m82063fQ(List<C37022f> list) {
        boolean z = true;
        AppMethodBeat.m2504i(119162);
        int size = this.BhM.size() - list.size();
        boolean z2 = size == 0 || size == 1;
        if (!C44847aa.AUz || z2) {
            C37022f c37022f;
            List list2 = this.BhM;
            C25052j.m39375o(list2, "valueParameters");
            Iterable<C41399au> iterable = list2;
            Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (C41399au c41399au : iterable) {
                C25052j.m39375o(c41399au, "it");
                C37022f dZg = c41399au.dZg();
                C25052j.m39375o(dZg, "it.name");
                int index = c41399au.getIndex();
                int i = index - size;
                if (i >= 0) {
                    c37022f = (C37022f) list.get(i);
                    if (c37022f != null) {
                        dZg = c37022f;
                    }
                }
                arrayList.add(c41399au.mo17871a(this, dZg, index));
            }
            List list3 = (List) arrayList;
            C24612a h = mo58966h(C25227au.BJW);
            Iterable<C37022f> iterable2 = list;
            if (!((Collection) iterable2).isEmpty()) {
                for (C37022f c37022f2 : iterable2) {
                    if (c37022f2 == null) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
            }
            z = false;
            h.Bix = Boolean.valueOf(z);
            C24612a h2 = h.mo41455fT(list3).mo41456h(eaK());
            C25052j.m39375o(h2, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
            C8083t a = super.mo58964a(h2);
            if (a == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(119162);
            return a;
        }
        Throwable assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.m2505o(119162);
        throw assertionError;
    }
}
