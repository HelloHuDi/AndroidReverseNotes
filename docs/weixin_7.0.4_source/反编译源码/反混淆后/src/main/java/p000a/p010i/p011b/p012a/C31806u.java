package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0219k;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C31824m;
import p000a.C31825n;
import p000a.C44856f;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C36913i;
import p000a.p001a.C7987l;
import p000a.p005f.C25047a;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C17085r;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C25269o;
import p000a.p010i.C31811c;
import p000a.p010i.C31815k;
import p000a.p010i.C31816r;
import p000a.p010i.C44936q;
import p000a.p010i.C44936q.C8300a;
import p000a.p010i.p011b.C8294a;
import p000a.p010i.p011b.p012a.C25262z.C25266a;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17159aq;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p049e.C37076b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u00068@X\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006(²\u0006\u0010\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0002"}, dWq = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflect_api", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflect-api", "parameterizedTypeArguments"})
/* renamed from: a.i.b.a.u */
public final class C31806u implements C25269o {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C31806u.class), "javaType", "getJavaType$kotlin_reflect_api()Ljava/lang/reflect/Type;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31806u.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31806u.class), "arguments", "getArguments()Ljava/util/List;")), C44855v.m82051a(new C17085r(C44855v.m82055aN(C31806u.class), "parameterizedTypeArguments", "<v#0>"))};
    private final C25266a AYi;
    private final C25266a AYj = C25262z.m39833a(null, new C31805b(this));
    private final C25266a AYk = C25262z.m39833a(null, new C31554a(this));
    public final C46867w AYl;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"})
    /* renamed from: a.i.b.a.u$a */
    static final class C31554a extends C25053k implements C31214a<List<? extends C44936q>> {
        final /* synthetic */ C31806u AYm;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"})
        /* renamed from: a.i.b.a.u$a$b */
        static final class C31555b extends C25053k implements C31214a<List<? extends Type>> {
            final /* synthetic */ C31554a AYn;

            C31555b(C31554a c31554a) {
                this.AYn = c31554a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118874);
                List a = C37076b.m62031a(this.AYn.AYm.dXu());
                AppMethodBeat.m2505o(118874);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"})
        /* renamed from: a.i.b.a.u$a$a */
        static final class C31556a extends C25053k implements C31214a<Type> {
            final /* synthetic */ int AWC;
            final /* synthetic */ C31554a AYn;
            final /* synthetic */ C44856f AYo;
            final /* synthetic */ C31815k AYp;

            C31556a(int i, C31554a c31554a, C44856f c44856f, C31815k c31815k) {
                this.AWC = i;
                this.AYn = c31554a;
                this.AYo = c44856f;
                this.AYp = c31815k;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118873);
                Type dXu = this.AYn.AYm.dXu();
                Object componentType;
                Type type;
                Throwable c25261x;
                if (dXu instanceof Class) {
                    componentType = ((Class) dXu).isArray() ? ((Class) dXu).getComponentType() : Object.class;
                    C25052j.m39375o(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
                    type = (Type) componentType;
                    AppMethodBeat.m2505o(118873);
                    return type;
                } else if (dXu instanceof GenericArrayType) {
                    if (this.AWC != 0) {
                        c25261x = new C25261x("Array type has been queried for a non-0th argument: " + this.AYn.AYm);
                        AppMethodBeat.m2505o(118873);
                        throw c25261x;
                    }
                    componentType = ((GenericArrayType) dXu).getGenericComponentType();
                    C25052j.m39375o(componentType, "javaType.genericComponentType");
                    AppMethodBeat.m2505o(118873);
                    return componentType;
                } else if (dXu instanceof ParameterizedType) {
                    componentType = (Type) ((List) this.AYo.getValue()).get(this.AWC);
                    if (componentType instanceof WildcardType) {
                        Type[] lowerBounds = ((WildcardType) componentType).getLowerBounds();
                        C25052j.m39375o(lowerBounds, "argument.lowerBounds");
                        dXu = (Type) C36913i.m61680M(lowerBounds);
                        if (dXu == null) {
                            Type[] upperBounds = ((WildcardType) componentType).getUpperBounds();
                            C25052j.m39375o(upperBounds, "argument.upperBounds");
                            type = (Type) C36913i.m61678L((Object[]) upperBounds);
                        } else {
                            type = dXu;
                        }
                    }
                    C25052j.m39375o(componentType, "if (argument !is Wildcar…ument.upperBounds.first()");
                    AppMethodBeat.m2505o(118873);
                    return componentType;
                } else {
                    c25261x = new C25261x("Non-generic type has been queried for arguments: " + this.AYn.AYm);
                    AppMethodBeat.m2505o(118873);
                    throw c25261x;
                }
            }
        }

        C31554a(C31806u c31806u) {
            this.AYm = c31806u;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118875);
            List ejt = this.AYm.AYl.ejt();
            if (ejt.isEmpty()) {
                List list = C17115v.AUP;
                AppMethodBeat.m2505o(118875);
                return list;
            }
            C44856f a = C17344i.m26853a(C0219k.PUBLICATION, new C31555b(this));
            C31815k c31815k = C31806u.eQB[3];
            Iterable iterable = ejt;
            Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
            int i = 0;
            for (Object next : iterable) {
                Object next2;
                int i2 = i + 1;
                if (i < 0) {
                    C7987l.dWs();
                }
                C41446ap c41446ap = (C41446ap) next2;
                C8300a c8300a;
                if (c41446ap.ekp()) {
                    c8300a = C44936q.AVY;
                    next2 = C44936q.AVX;
                } else {
                    C46867w dZS = c41446ap.dZS();
                    C25052j.m39375o(dZS, "typeProjection.type");
                    C31806u c31806u = new C31806u(dZS, new C31556a(i, this, a, c31815k));
                    C25269o c25269o;
                    switch (C31807v.eQZ[c41446ap.ekq().ordinal()]) {
                        case 1:
                            c8300a = C44936q.AVY;
                            C25269o c25269o2 = c31806u;
                            C25052j.m39376p(c25269o2, "type");
                            C44936q c44936q = new C44936q(C31816r.INVARIANT, c25269o2);
                            break;
                        case 2:
                            c8300a = C44936q.AVY;
                            c25269o = c31806u;
                            C25052j.m39376p(c25269o, "type");
                            next2 = new C44936q(C31816r.IN, c25269o);
                            break;
                        case 3:
                            c8300a = C44936q.AVY;
                            c25269o = c31806u;
                            C25052j.m39376p(c25269o, "type");
                            next2 = new C44936q(C31816r.OUT, c25269o);
                            break;
                        default:
                            C31824m c31824m = new C31824m();
                            AppMethodBeat.m2505o(118875);
                            throw c31824m;
                    }
                }
                arrayList.add(next2);
                i = i2;
            }
            ejt = (List) arrayList;
            AppMethodBeat.m2505o(118875);
            return ejt;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"})
    /* renamed from: a.i.b.a.u$b */
    static final class C31805b extends C25053k implements C31214a<C31811c> {
        final /* synthetic */ C31806u AYm;

        C31805b(C31806u c31806u) {
            this.AYm = c31806u;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118876);
            C31811c a = C31806u.m51509a(this.AYm, this.AYm.AYl);
            AppMethodBeat.m2505o(118876);
            return a;
        }
    }

    static {
        AppMethodBeat.m2504i(118877);
        AppMethodBeat.m2505o(118877);
    }

    public C31806u(C46867w c46867w, C31214a<? extends Type> c31214a) {
        C25052j.m39376p(c46867w, "type");
        C25052j.m39376p(c31214a, "computeJavaType");
        AppMethodBeat.m2504i(118884);
        this.AYl = c46867w;
        this.AYi = C25262z.m39833a(null, c31214a);
        AppMethodBeat.m2505o(118884);
    }

    /* renamed from: a */
    public static final /* synthetic */ C31811c m51509a(C31806u c31806u, C46867w c46867w) {
        AppMethodBeat.m2504i(118885);
        C31811c a = c31806u.m51508a(c46867w);
        AppMethodBeat.m2505o(118885);
        return a;
    }

    /* renamed from: a */
    private final C31811c m51508a(C46867w c46867w) {
        AppMethodBeat.m2504i(118880);
        C0036h dYs = c46867w.ejw().dYs();
        Throwable c25261x;
        C31811c c16493g;
        if (dYs instanceof C46865e) {
            Class a = C8017af.m14194a((C46865e) dYs);
            if (a == null) {
                AppMethodBeat.m2505o(118880);
                return null;
            } else if (a.isArray()) {
                C41446ap c41446ap = (C41446ap) C25035t.m39342fO(c46867w.ejt());
                if (c41446ap != null) {
                    C46867w dZS = c41446ap.dZS();
                    if (dZS != null) {
                        C25052j.m39375o(dZS, "type.arguments.singleOrN…return KClassImpl(jClass)");
                        C31811c a2 = m51508a(dZS);
                        if (a2 == null) {
                            c25261x = new C25261x("Cannot determine classifier for array element type: ".concat(String.valueOf(this)));
                            AppMethodBeat.m2505o(118880);
                            throw c25261x;
                        }
                        c16493g = new C16493g(C37076b.m62038bd(C25047a.m39368a(C8294a.m14622a(a2))));
                        AppMethodBeat.m2505o(118880);
                        return c16493g;
                    }
                }
                c16493g = new C16493g(a);
                AppMethodBeat.m2505o(118880);
                return c16493g;
            } else if (C17316av.m26813aB(c46867w)) {
                c16493g = new C16493g(a);
                AppMethodBeat.m2505o(118880);
                return c16493g;
            } else {
                Class aZ = C37076b.m62034aZ(a);
                if (aZ != null) {
                    a = aZ;
                }
                c16493g = new C16493g(a);
                AppMethodBeat.m2505o(118880);
                return c16493g;
            }
        } else if (dYs instanceof C36955ar) {
            c16493g = new C31808w((C36955ar) dYs);
            AppMethodBeat.m2505o(118880);
            return c16493g;
        } else if (dYs instanceof C17159aq) {
            c25261x = new C31825n("An operation is not implemented: ".concat(String.valueOf("Type alias classifiers are not yet supported")));
            AppMethodBeat.m2505o(118880);
            throw c25261x;
        } else {
            AppMethodBeat.m2505o(118880);
            return null;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(118881);
        if ((obj instanceof C31806u) && C25052j.m39373j(this.AYl, ((C31806u) obj).AYl)) {
            AppMethodBeat.m2505o(118881);
            return true;
        }
        AppMethodBeat.m2505o(118881);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(118882);
        int hashCode = this.AYl.hashCode();
        AppMethodBeat.m2505o(118882);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(118883);
        C41382ab c41382ab = C41382ab.AYy;
        String b = C41382ab.m72165b(this.AYl);
        AppMethodBeat.m2505o(118883);
        return b;
    }

    public final Type dXu() {
        AppMethodBeat.m2504i(118878);
        Type type = (Type) this.AYi.invoke();
        AppMethodBeat.m2505o(118878);
        return type;
    }

    public final C31811c dWO() {
        AppMethodBeat.m2504i(118879);
        C31811c c31811c = (C31811c) this.AYj.invoke();
        AppMethodBeat.m2505o(118879);
        return c31811c;
    }
}
