package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.i.b.g */
public final class C17277g {
    public static final C17277g BEO = new C17277g();

    /* renamed from: a.i.b.a.c.i.b.g$a */
    static final class C17278a extends C25053k implements C17126b<C25093y, C46867w> {
        final /* synthetic */ C46867w BEP;

        C17278a(C46867w c46867w) {
            this.BEP = c46867w;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122078);
            C25052j.m39376p((C25093y) obj, "it");
            C46867w c46867w = this.BEP;
            AppMethodBeat.m2505o(122078);
            return c46867w;
        }
    }

    /* renamed from: a.i.b.a.c.i.b.g$b */
    static final class C17279b extends C25053k implements C17126b<C25093y, C8235ad> {
        final /* synthetic */ C31622h BEQ;

        C17279b(C31622h c31622h) {
            this.BEQ = c31622h;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122079);
            C25093y c25093y = (C25093y) obj;
            C25052j.m39376p(c25093y, "module");
            C8235ad b = c25093y.dZD().mo51610b(this.BEQ);
            C25052j.m39375o(b, "module.builtIns.getPrimi…KotlinType(componentType)");
            AppMethodBeat.m2505o(122079);
            return b;
        }
    }

    static {
        AppMethodBeat.m2504i(122083);
        AppMethodBeat.m2505o(122083);
    }

    private C17277g() {
    }

    /* renamed from: a */
    public static C17276b m26758a(List<? extends C41432f<?>> list, C46867w c46867w) {
        AppMethodBeat.m2504i(122080);
        C25052j.m39376p(list, "value");
        C25052j.m39376p(c46867w, "type");
        C17276b c17276b = new C17276b(list, new C17278a(c46867w));
        AppMethodBeat.m2505o(122080);
        return c17276b;
    }

    /* renamed from: dQ */
    public final C41432f<?> mo31363dQ(Object obj) {
        AppMethodBeat.m2504i(122081);
        C41432f<?> c17282r;
        if (obj instanceof Byte) {
            C41432f c44834d = new C44834d(((Number) obj).byteValue());
            AppMethodBeat.m2505o(122081);
            return c44834d;
        } else if (obj instanceof Short) {
            c17282r = new C17282r(((Number) obj).shortValue());
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof Integer) {
            c17282r = new C44905l(((Number) obj).intValue());
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof Long) {
            c17282r = new C8200p(((Number) obj).longValue());
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof Character) {
            c17282r = new C44835e(((Character) obj).charValue());
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof Float) {
            c17282r = new C37034k(((Number) obj).floatValue());
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof Double) {
            c17282r = new C17280h(((Number) obj).doubleValue());
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof Boolean) {
            c17282r = new C44637c(((Boolean) obj).booleanValue());
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof String) {
            c17282r = new C25174s((String) obj);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof byte[]) {
            c17282r = m26757a(C36913i.m61697cu((byte[]) obj), C31622h.BYTE);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof short[]) {
            c17282r = m26757a(C36913i.m61694b((short[]) obj), C31622h.SHORT);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof int[]) {
            c17282r = m26757a(C36913i.m61677K((int[]) obj), C31622h.INT);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof long[]) {
            c17282r = m26757a(C36913i.m61699g((long[]) obj), C31622h.LONG);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof char[]) {
            c17282r = m26757a(C36913i.m61695c((char[]) obj), C31622h.CHAR);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof float[]) {
            c17282r = m26757a(C36913i.m61702k((float[]) obj), C31622h.FLOAT);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof double[]) {
            c17282r = m26757a(C36913i.m61698e((double[]) obj), C31622h.DOUBLE);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj instanceof boolean[]) {
            c17282r = m26757a(C36913i.m61696c((boolean[]) obj), C31622h.BOOLEAN);
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else if (obj == null) {
            c17282r = new C25173q();
            AppMethodBeat.m2505o(122081);
            return c17282r;
        } else {
            AppMethodBeat.m2505o(122081);
            return null;
        }
    }

    /* renamed from: a */
    private final C17276b m26757a(List<?> list, C31622h c31622h) {
        AppMethodBeat.m2504i(122082);
        Collection arrayList = new ArrayList();
        for (Object dQ : C25035t.m39352m(list)) {
            C41432f dQ2 = mo31363dQ(dQ);
            if (dQ2 != null) {
                arrayList.add(dQ2);
            }
        }
        C17276b c17276b = new C17276b((List) arrayList, new C17279b(c31622h));
        AppMethodBeat.m2505o(122082);
        return c17276b;
    }
}
