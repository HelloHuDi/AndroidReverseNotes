package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C36913i;
import p000a.p001a.C41363p;
import p000a.p002c.C36927c;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.C31813j;
import p000a.p010i.C31813j.C31812a;
import p000a.p010i.C44858a;
import p000a.p010i.p011b.p012a.C25262z.C25266a;
import p000a.p010i.p011b.p012a.p013a.C36943d;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44868a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p026b.C17174b;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p1145a.C17134a;
import p000a.p772b.C7992b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J%\u00105\u001a\u00028\u00002\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010807\"\u0004\u0018\u000108H\u0016¢\u0006\u0002\u00109J#\u0010:\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0002¢\u0006\u0002\u0010<J#\u0010=\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0016¢\u0006\u0002\u0010<J3\u0010>\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;2\f\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010@H\u0000¢\u0006\u0004\bA\u0010BJ\u0012\u0010C\u001a\u0004\u0018\u0001082\u0006\u0010D\u001a\u00020EH\u0002J\n\u0010F\u001a\u0004\u0018\u00010EH\u0002R(\u0010\u0004\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \b*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r0\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \b*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00060\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010#R\u0014\u0010$\u001a\u00020\"8DX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010#R\u0012\u0010%\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u0014\u0010*\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0012R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006G"}, dWq = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflect_api", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.e */
public abstract class C46869e<R> implements C44858a<R> {
    private final C25266a<List<Annotation>> AWu;
    private final C25266a<ArrayList<C31813j>> AWv;
    private final C25266a<C31806u> AWw;
    private final C25266a<List<C31808w>> AWx;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"})
    /* renamed from: a.i.b.a.e$c */
    static final class C8265c extends C25053k implements C31214a<C31806u> {
        final /* synthetic */ C46869e AWy;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/lang/reflect/Type;", "R", "invoke"})
        /* renamed from: a.i.b.a.e$c$1 */
        static final class C82661 extends C25053k implements C31214a<Type> {
            final /* synthetic */ C8265c AWD;

            C82661(C8265c c8265c) {
                this.AWD = c8265c;
                super(0);
            }

            /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ Object invoke() {
                Object fM;
                AppMethodBeat.m2504i(118689);
                C46869e c46869e = this.AWD.AWy;
                C25085b dWT = c46869e.dWT();
                if (!(dWT instanceof C8083t)) {
                    dWT = null;
                }
                C8083t c8083t = (C8083t) dWT;
                if (c8083t != null && c8083t.dZv()) {
                    fM = C25035t.m39340fM(c46869e.dWU().dXy());
                    if (!(fM instanceof ParameterizedType)) {
                        fM = null;
                    }
                    ParameterizedType parameterizedType = (ParameterizedType) fM;
                    if (C25052j.m39373j(parameterizedType != null ? parameterizedType.getRawType() : null, C36927c.class)) {
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        C25052j.m39375o(actualTypeArguments, "continuationType.actualTypeArguments");
                        fM = C36913i.m61682O(actualTypeArguments);
                        if (!(fM instanceof WildcardType)) {
                            fM = null;
                        }
                        WildcardType wildcardType = (WildcardType) fM;
                        if (wildcardType != null) {
                            actualTypeArguments = wildcardType.getLowerBounds();
                            if (actualTypeArguments != null) {
                                fM = (Type) C36913i.m61678L((Object[]) actualTypeArguments);
                                if (fM == null) {
                                    fM = this.AWD.AWy.dWU().dXx();
                                }
                                AppMethodBeat.m2505o(118689);
                                return fM;
                            }
                        }
                    }
                }
                fM = null;
                if (fM == null) {
                }
                AppMethodBeat.m2505o(118689);
                return fM;
            }
        }

        C8265c(C46869e c46869e) {
            this.AWy = c46869e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118690);
            C46867w dYT = this.AWy.dWT().dYT();
            if (dYT == null) {
                C25052j.dWJ();
            }
            C25052j.m39375o(dYT, "descriptor.returnType!!");
            C31806u c31806u = new C31806u(dYT, new C82661(this));
            AppMethodBeat.m2505o(118690);
            return c31806u;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"})
    /* renamed from: a.i.b.a.e$b */
    static final class C31548b extends C25053k implements C31214a<ArrayList<C31813j>> {
        final /* synthetic */ C46869e AWy;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        /* renamed from: a.i.b.a.e$b$a */
        public static final class C31549a<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                AppMethodBeat.m2504i(118686);
                int a = C7992b.m14176a(((C31813j) t).getName(), ((C31813j) t2).getName());
                AppMethodBeat.m2505o(118686);
                return a;
            }
        }

        C31548b(C46869e c46869e) {
            this.AWy = c46869e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            int i2;
            int i3 = 0;
            AppMethodBeat.m2504i(118688);
            final C25085b dWT = this.AWy.dWT();
            ArrayList arrayList = new ArrayList();
            if (this.AWy.isBound()) {
                i = 0;
            } else {
                final C41396ak a = C8017af.m14193a((C8045a) dWT);
                if (a != null) {
                    arrayList.add(new C0201o(this.AWy, 0, C31812a.INSTANCE, new C31214a<C41396ak>() {
                        public final /* bridge */ /* synthetic */ Object invoke() {
                            return a;
                        }
                    }));
                    i = 1;
                } else {
                    i = 0;
                }
                final C41396ak dYQ = dWT.dYQ();
                if (dYQ != null) {
                    i2 = i + 1;
                    arrayList.add(new C0201o(this.AWy, i, C31812a.EXTENSION_RECEIVER, new C31214a<C41396ak>() {
                        public final /* bridge */ /* synthetic */ Object invoke() {
                            return dYQ;
                        }
                    }));
                    i = i2;
                }
            }
            List dYV = dWT.dYV();
            C25052j.m39375o(dYV, "descriptor.valueParameters");
            int size = dYV.size();
            while (i3 < size) {
                i2 = i + 1;
                arrayList.add(new C0201o(this.AWy, i, C31812a.VALUE, new C31214a<C41399au>() {
                    public final /* synthetic */ Object invoke() {
                        AppMethodBeat.m2504i(118687);
                        Object obj = dWT.dYV().get(i3);
                        C25052j.m39375o(obj, "descriptor.valueParameters[i]");
                        C41399au c41399au = (C41399au) obj;
                        AppMethodBeat.m2505o(118687);
                        return c41399au;
                    }
                }));
                i3++;
                i = i2;
            }
            if (this.AWy.dWW() && (dWT instanceof C17174b)) {
                dYV = arrayList;
                if (dYV.size() > 1) {
                    C41363p.m72150a(dYV, new C31549a());
                }
            }
            arrayList.trimToSize();
            AppMethodBeat.m2505o(118688);
            return arrayList;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "R", "invoke"})
    /* renamed from: a.i.b.a.e$d */
    static final class C31550d extends C25053k implements C31214a<List<? extends C31808w>> {
        final /* synthetic */ C46869e AWy;

        C31550d(C46869e c46869e) {
            this.AWy = c46869e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118691);
            List dYS = this.AWy.dWT().dYS();
            C25052j.m39375o(dYS, "descriptor.typeParameters");
            Iterable<C36955ar> iterable = dYS;
            Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (C36955ar c31808w : iterable) {
                arrayList.add(new C31808w(c31808w));
            }
            List list = (List) arrayList;
            AppMethodBeat.m2505o(118691);
            return list;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "", "R", "invoke"})
    /* renamed from: a.i.b.a.e$a */
    static final class C31790a extends C25053k implements C31214a<List<? extends Annotation>> {
        final /* synthetic */ C46869e AWy;

        C31790a(C46869e c46869e) {
            this.AWy = c46869e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118685);
            List a = C8017af.m14199a((C44868a) this.AWy.dWT());
            AppMethodBeat.m2505o(118685);
            return a;
        }
    }

    public abstract C25085b dWT();

    public abstract C36943d<?> dWU();

    public abstract C8275i dWV();

    public abstract boolean isBound();

    public C46869e() {
        C25266a a = C25262z.m39833a(null, new C31790a(this));
        C25052j.m39375o(a, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.AWu = a;
        a = C25262z.m39833a(null, new C31548b(this));
        C25052j.m39375o(a, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.AWv = a;
        a = C25262z.m39833a(null, new C8265c(this));
        C25052j.m39375o(a, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.AWw = a;
        a = C25262z.m39833a(null, new C31550d(this));
        C25052j.m39375o(a, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
        this.AWx = a;
    }

    public final List<C31813j> getParameters() {
        Object invoke = this.AWv.invoke();
        C25052j.m39375o(invoke, "_parameters()");
        return (List) invoke;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dWW() {
        return C25052j.m39373j(getName(), "<init>") && dWV().dWH().isAnnotation();
    }

    /* renamed from: W */
    public final R mo66046W(Object... objArr) {
        C25052j.m39376p(objArr, "args");
        try {
            return dWU().mo17818W(objArr);
        } catch (IllegalAccessException e) {
            throw new C17134a(e);
        }
    }
}
