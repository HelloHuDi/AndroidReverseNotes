package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0219k;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p001a.C25033k;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C44870aa;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.a.i */
public final class C31625i {
    public static final C31623b Bcn = new C31623b();
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C31625i.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31625i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31625i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31625i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31625i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31625i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31625i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31625i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    private final C44856f Bce;
    private final C31626a Bcf = new C31626a(1);
    private final C31626a Bcg = new C31626a(1);
    private final C31626a Bch = new C31626a(2);
    private final C31626a Bci = new C31626a(3);
    private final C31626a Bcj = new C31626a(1);
    private final C31626a Bck = new C31626a(2);
    private final C31626a Bcl = new C31626a(3);
    private final C44870aa Bcm;

    /* renamed from: a.i.b.a.c.a.i$b */
    public static final class C31623b {
        private C31623b() {
        }

        public /* synthetic */ C31623b(byte b) {
            this();
        }
    }

    /* renamed from: a.i.b.a.c.a.i$c */
    static final class C31624c extends C25053k implements C31214a<C31746h> {
        final /* synthetic */ C25093y Bcp;

        C31624c(C25093y c25093y) {
            this.Bcp = c25093y;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119107);
            C31746h dXR = this.Bcp.mo252g(C8036j.dXT()).dXR();
            AppMethodBeat.m2505o(119107);
            return dXR;
        }
    }

    /* renamed from: a.i.b.a.c.a.i$a */
    static final class C31626a {
        final int Bco;

        public C31626a(int i) {
            this.Bco = i;
        }
    }

    static {
        AppMethodBeat.m2504i(119108);
        AppMethodBeat.m2505o(119108);
    }

    public C31625i(C25093y c25093y, C44870aa c44870aa) {
        C25052j.m39376p(c25093y, "module");
        C25052j.m39376p(c44870aa, "notFoundClasses");
        AppMethodBeat.m2504i(119110);
        this.Bcm = c44870aa;
        this.Bce = C17344i.m26853a(C0219k.PUBLICATION, new C31624c(c25093y));
        AppMethodBeat.m2505o(119110);
    }

    public final C46865e dXS() {
        AppMethodBeat.m2504i(119109);
        C31626a c31626a = this.Bcf;
        Object obj = eQB[1];
        C25052j.m39376p(this, "types");
        C25052j.m39376p(obj, "property");
        String capitalize = C6163u.capitalize(obj.getName());
        int i = c31626a.Bco;
        C37022f avX = C37022f.avX(capitalize);
        C25052j.m39375o(avX, "Name.identifier(className)");
        C0036h c = ((C31746h) this.Bce.getValue()).mo222c(avX, C0039c.FROM_REFLECTION);
        if (!(c instanceof C46865e)) {
            c = null;
        }
        C46865e c46865e = (C46865e) c;
        if (c46865e == null) {
            c46865e = this.Bcm.mo72087a(new C8173a(C8036j.dXT(), avX), C25033k.listOf(Integer.valueOf(i)));
        }
        AppMethodBeat.m2505o(119109);
        return c46865e;
    }
}
