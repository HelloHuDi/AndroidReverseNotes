package p000a.p010i.p011b.p012a.p015c.p016a.p774a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p000a.C37091y;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31585ab;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p009h.C31599d;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p016a.C8033c;
import p000a.p010i.p011b.p012a.p015c.p016a.C8036j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap.C17158a;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36963d;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C17161a;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31634ah;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h.C17288b;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C44836ar;
import p000a.p010i.p011b.p012a.p015c.p045l.C44923b;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.a.a.b */
public final class C24607b extends C17161a {
    final int AVt;
    private final C25212i Baf;
    private final C8025a BcK = new C8025a();
    private final C44866d BcL = new C44866d(this.Baf, this);
    private final C36953ab BcM;
    final C8027b BcN;
    final List<C36955ar> parameters;

    /* renamed from: a.i.b.a.c.a.a.b$a */
    final class C8025a extends C44923b {

        /* renamed from: a.i.b.a.c.a.a.b$a$a */
        static final class C8026a extends C25053k implements C31591m<C36953ab, C37022f, C37091y> {
            final /* synthetic */ ArrayList BcP;
            final /* synthetic */ C8025a BcQ;

            C8026a(C8025a c8025a, ArrayList arrayList) {
                this.BcQ = c8025a;
                this.BcP = arrayList;
                super(2);
            }

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                AppMethodBeat.m2504i(119138);
                mo17827a((C36953ab) obj, (C37022f) obj2);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(119138);
                return c37091y;
            }

            /* renamed from: a */
            public final void mo17827a(C36953ab c36953ab, C37022f c37022f) {
                AppMethodBeat.m2504i(119139);
                C25052j.m39376p(c36953ab, "packageFragment");
                C25052j.m39376p(c37022f, "name");
                C0036h c = c36953ab.dXR().mo222c(c37022f, C0039c.FROM_BUILTINS);
                if (!(c instanceof C46865e)) {
                    c = null;
                }
                C46865e c46865e = (C46865e) c;
                if (c46865e == null) {
                    Throwable illegalStateException = new IllegalStateException(("Class " + c37022f + " not found in " + c36953ab).toString());
                    AppMethodBeat.m2505o(119139);
                    throw illegalStateException;
                }
                C17313an dXY = c46865e.dXY();
                C25052j.m39375o(dXY, "descriptor.typeConstructor");
                Iterable<C36955ar> y = C25035t.m39362y(this.BcQ.getParameters(), dXY.getParameters().size());
                Collection arrayList = new ArrayList(C25034m.m39318d(y));
                for (C36955ar dZf : y) {
                    arrayList.add(new C44836ar(dZf.dZf()));
                }
                List list = (List) arrayList;
                ArrayList arrayList2 = this.BcP;
                C0027a c0027a = C0026g.BfJ;
                arrayList2.add(C17326x.m26837a(C0027a.eai(), c46865e, list));
                AppMethodBeat.m2505o(119139);
            }
        }

        public C8025a() {
            super(C24607b.this.Baf);
            AppMethodBeat.m2504i(119144);
            AppMethodBeat.m2505o(119144);
        }

        public final Collection<C46867w> dYr() {
            C8174b c8174b;
            AppMethodBeat.m2504i(119140);
            ArrayList arrayList = new ArrayList(2);
            C8026a c8026a = new C8026a(this, arrayList);
            C36953ab e;
            C37022f avX;
            switch (C41387c.eQZ[C24607b.this.BcN.ordinal()]) {
                case 1:
                    c8174b = C31619g.AZV;
                    C25052j.m39375o(c8174b, "BUILT_INS_PACKAGE_FQ_NAME");
                    e = m14207e(c8174b);
                    avX = C37022f.avX("Function");
                    C25052j.m39375o(avX, "Name.identifier(\"Function\")");
                    c8026a.mo17827a(e, avX);
                    break;
                case 2:
                    e = C24607b.this.BcM;
                    avX = C37022f.avX("KFunction");
                    C25052j.m39375o(avX, "Name.identifier(\"KFunction\")");
                    c8026a.mo17827a(e, avX);
                    break;
                default:
                    e = C24607b.this.BcM;
                    avX = C37022f.avX(C24607b.this.BcN.BcX);
                    C25052j.m39375o(avX, "Name.identifier(functionKind.classNamePrefix)");
                    c8026a.mo17827a(e, avX);
                    break;
            }
            switch (C41387c.pCY[C24607b.this.BcN.ordinal()]) {
                case 1:
                    c8174b = C31619g.AZV;
                    C25052j.m39375o(c8174b, "BUILT_INS_PACKAGE_FQ_NAME");
                    c8026a.mo17827a(m14207e(c8174b), C8027b.Function.mo17828SN(C24607b.this.AVt));
                    break;
                case 2:
                    c8174b = C8203d.BDS;
                    C25052j.m39375o(c8174b, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
                    c8026a.mo17827a(m14207e(c8174b), C8027b.SuspendFunction.mo17828SN(C24607b.this.AVt));
                    break;
            }
            Collection m = C25035t.m39352m(arrayList);
            AppMethodBeat.m2505o(119140);
            return m;
        }

        /* renamed from: e */
        private final C8033c m14207e(C8174b c8174b) {
            AppMethodBeat.m2504i(119141);
            Collection arrayList = new ArrayList();
            for (Object next : C24607b.this.BcM.dZE().mo252g(c8174b).getFragments()) {
                if (next instanceof C8033c) {
                    arrayList.add(next);
                }
            }
            C8033c c8033c = (C8033c) C25035t.m39337fJ((List) arrayList);
            AppMethodBeat.m2505o(119141);
            return c8033c;
        }

        public final List<C36955ar> getParameters() {
            AppMethodBeat.m2504i(119142);
            List b = C24607b.this.parameters;
            AppMethodBeat.m2505o(119142);
            return b;
        }

        public final boolean dYu() {
            return true;
        }

        public final C17157ap dYv() {
            return C17158a.BeT;
        }

        public final /* bridge */ /* synthetic */ C0036h dYs() {
            return C24607b.this;
        }

        public final /* bridge */ /* synthetic */ C46865e dYt() {
            return C24607b.this;
        }

        public final String toString() {
            AppMethodBeat.m2504i(119143);
            String c24607b = C24607b.this.toString();
            AppMethodBeat.m2505o(119143);
            return c24607b;
        }
    }

    /* renamed from: a.i.b.a.c.a.a.b$b */
    public enum C8027b {
        Function(r3, "Function"),
        SuspendFunction(r3, "SuspendFunction"),
        KFunction(C8036j.dXT(), "KFunction"),
        KSuspendFunction(C8036j.dXT(), "KSuspendFunction");
        
        public static final C8028a BcY = null;
        public final C8174b BcW;
        public final String BcX;

        /* renamed from: a.i.b.a.c.a.a.b$b$a */
        public static final class C8028a {
            private C8028a() {
            }

            public /* synthetic */ C8028a(byte b) {
                this();
            }
        }

        private C8027b(C8174b c8174b, String str) {
            C25052j.m39376p(c8174b, "packageFqName");
            C25052j.m39376p(str, "classNamePrefix");
            AppMethodBeat.m2504i(119147);
            this.BcW = c8174b;
            this.BcX = str;
            AppMethodBeat.m2505o(119147);
        }

        static {
            BcY = new C8028a();
            AppMethodBeat.m2505o(119145);
        }

        /* renamed from: SN */
        public final C37022f mo17828SN(int i) {
            AppMethodBeat.m2504i(119146);
            C37022f avX = C37022f.avX(this.BcX + i);
            C25052j.m39375o(avX, "Name.identifier(\"$classNamePrefix$arity\")");
            AppMethodBeat.m2505o(119146);
            return avX;
        }
    }

    public final /* bridge */ /* synthetic */ C46865e dYa() {
        return null;
    }

    public final /* bridge */ /* synthetic */ C36963d dYe() {
        return null;
    }

    public C24607b(C25212i c25212i, C36953ab c36953ab, C8027b c8027b, int i) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c36953ab, "containingDeclaration");
        C25052j.m39376p(c8027b, "functionKind");
        super(c25212i, c8027b.mo17828SN(i));
        AppMethodBeat.m2504i(119154);
        this.Baf = c25212i;
        this.BcM = c36953ab;
        this.BcN = c8027b;
        this.AVt = i;
        final ArrayList arrayList = new ArrayList();
        C246081 c246081 = new C31591m<C0163ba, String, C37091y>(this) {
            final /* synthetic */ C24607b BcO;

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                AppMethodBeat.m2504i(119135);
                mo41449a((C0163ba) obj, (String) obj2);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(119135);
                return c37091y;
            }

            /* renamed from: a */
            public final void mo41449a(C0163ba c0163ba, String str) {
                AppMethodBeat.m2504i(119136);
                C25052j.m39376p(c0163ba, "variance");
                C25052j.m39376p(str, "name");
                ArrayList arrayList = arrayList;
                C31642l c31642l = this.BcO;
                C0027a c0027a = C0026g.BfJ;
                arrayList.add(C31634ah.m51154a(c31642l, C0027a.eai(), c0163ba, C37022f.avX(str), arrayList.size()));
                AppMethodBeat.m2505o(119136);
            }
        };
        Iterable c31599d = new C31599d(1, this.AVt);
        Collection arrayList2 = new ArrayList(C25034m.m39318d(c31599d));
        Iterator it = c31599d.iterator();
        while (it.hasNext()) {
            c246081.mo41449a(C0163ba.IN_VARIANCE, "P".concat(String.valueOf(((C31585ab) it).nextInt())));
            arrayList2.add(C37091y.AUy);
        }
        c246081.mo41449a(C0163ba.OUT_VARIANCE, "R");
        this.parameters = C25035t.m39352m(arrayList);
        AppMethodBeat.m2505o(119154);
    }

    public final C17313an dXY() {
        return this.BcK;
    }

    public final C36964f dYc() {
        return C36964f.INTERFACE;
    }

    public final C44879w dYd() {
        return C44879w.ABSTRACT;
    }

    public final C25082az dYf() {
        AppMethodBeat.m2504i(119150);
        C25082az c25082az = C8051ay.Bfa;
        C25052j.m39375o(c25082az, "Visibilities.PUBLIC");
        AppMethodBeat.m2505o(119150);
        return c25082az;
    }

    public final boolean dYg() {
        return false;
    }

    public final boolean dYh() {
        return false;
    }

    public final boolean dYi() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYk() {
        return false;
    }

    public final boolean dYl() {
        return false;
    }

    public final boolean dYm() {
        return false;
    }

    public final C0026g dYn() {
        AppMethodBeat.m2504i(119151);
        C0027a c0027a = C0026g.BfJ;
        C0026g eai = C0027a.eai();
        AppMethodBeat.m2505o(119151);
        return eai;
    }

    public final C41398am dYo() {
        AppMethodBeat.m2504i(119152);
        C41398am c41398am = C41398am.BeR;
        C25052j.m39375o(c41398am, "SourceElement.NO_SOURCE");
        AppMethodBeat.m2505o(119152);
        return c41398am;
    }

    public final List<C36955ar> dYq() {
        return this.parameters;
    }

    public final /* bridge */ /* synthetic */ C31642l dXW() {
        return this.BcM;
    }

    public final /* bridge */ /* synthetic */ C31746h dXX() {
        return C17288b.BGh;
    }

    public final /* bridge */ /* synthetic */ C31746h dXZ() {
        return this.BcL;
    }

    public final /* bridge */ /* synthetic */ Collection dYb() {
        return C17115v.AUP;
    }

    public final /* bridge */ /* synthetic */ Collection dYp() {
        return C17115v.AUP;
    }

    public final String toString() {
        AppMethodBeat.m2504i(119153);
        String str = this.BgZ.name;
        C25052j.m39375o(str, "name.asString()");
        AppMethodBeat.m2505o(119153);
        return str;
    }
}
