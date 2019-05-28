package a.i.b.a;

import a.a.i;
import a.a.m;
import a.a.p;
import a.f.b.k;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.t;
import a.i.b.a.c.l.w;
import a.i.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J%\u00105\u001a\u00028\u00002\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010807\"\u0004\u0018\u000108H\u0016¢\u0006\u0002\u00109J#\u0010:\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0002¢\u0006\u0002\u0010<J#\u0010=\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0016¢\u0006\u0002\u0010<J3\u0010>\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;2\f\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010@H\u0000¢\u0006\u0004\bA\u0010BJ\u0012\u0010C\u001a\u0004\u0018\u0001082\u0006\u0010D\u001a\u00020EH\u0002J\n\u0010F\u001a\u0004\u0018\u00010EH\u0002R(\u0010\u0004\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \b*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r0\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \b*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00060\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010#R\u0014\u0010$\u001a\u00020\"8DX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010#R\u0012\u0010%\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u0014\u0010*\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0012R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006G"}, dWq = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflect_api", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflect-api"})
public abstract class e<R> implements a.i.a<R> {
    private final a.i.b.a.z.a<List<Annotation>> AWu;
    private final a.i.b.a.z.a<ArrayList<j>> AWv;
    private final a.i.b.a.z.a<u> AWw;
    private final a.i.b.a.z.a<List<w>> AWx;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"})
    static final class c extends k implements a.f.a.a<u> {
        final /* synthetic */ e AWy;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/lang/reflect/Type;", "R", "invoke"})
        /* renamed from: a.i.b.a.e$c$1 */
        static final class AnonymousClass1 extends k implements a.f.a.a<Type> {
            final /* synthetic */ c AWD;

            AnonymousClass1(c cVar) {
                this.AWD = cVar;
                super(0);
            }

            /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ Object invoke() {
                Object fM;
                AppMethodBeat.i(118689);
                e eVar = this.AWD.AWy;
                a.i.b.a.c.b.b dWT = eVar.dWT();
                if (!(dWT instanceof t)) {
                    dWT = null;
                }
                t tVar = (t) dWT;
                if (tVar != null && tVar.dZv()) {
                    fM = a.a.t.fM(eVar.dWU().dXy());
                    if (!(fM instanceof ParameterizedType)) {
                        fM = null;
                    }
                    ParameterizedType parameterizedType = (ParameterizedType) fM;
                    if (a.f.b.j.j(parameterizedType != null ? parameterizedType.getRawType() : null, a.c.c.class)) {
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        a.f.b.j.o(actualTypeArguments, "continuationType.actualTypeArguments");
                        fM = i.O(actualTypeArguments);
                        if (!(fM instanceof WildcardType)) {
                            fM = null;
                        }
                        WildcardType wildcardType = (WildcardType) fM;
                        if (wildcardType != null) {
                            actualTypeArguments = wildcardType.getLowerBounds();
                            if (actualTypeArguments != null) {
                                fM = (Type) i.L((Object[]) actualTypeArguments);
                                if (fM == null) {
                                    fM = this.AWD.AWy.dWU().dXx();
                                }
                                AppMethodBeat.o(118689);
                                return fM;
                            }
                        }
                    }
                }
                fM = null;
                if (fM == null) {
                }
                AppMethodBeat.o(118689);
                return fM;
            }
        }

        c(e eVar) {
            this.AWy = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118690);
            w dYT = this.AWy.dWT().dYT();
            if (dYT == null) {
                a.f.b.j.dWJ();
            }
            a.f.b.j.o(dYT, "descriptor.returnType!!");
            u uVar = new u(dYT, new AnonymousClass1(this));
            AppMethodBeat.o(118690);
            return uVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"})
    static final class b extends k implements a.f.a.a<ArrayList<j>> {
        final /* synthetic */ e AWy;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        public static final class a<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                AppMethodBeat.i(118686);
                int a = a.b.b.a(((j) t).getName(), ((j) t2).getName());
                AppMethodBeat.o(118686);
                return a;
            }
        }

        b(e eVar) {
            this.AWy = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            int i2;
            int i3 = 0;
            AppMethodBeat.i(118688);
            final a.i.b.a.c.b.b dWT = this.AWy.dWT();
            ArrayList arrayList = new ArrayList();
            if (this.AWy.isBound()) {
                i = 0;
            } else {
                final ak a = af.a((a.i.b.a.c.b.a) dWT);
                if (a != null) {
                    arrayList.add(new o(this.AWy, 0, a.i.j.a.INSTANCE, new a.f.a.a<ak>() {
                        public final /* bridge */ /* synthetic */ Object invoke() {
                            return a;
                        }
                    }));
                    i = 1;
                } else {
                    i = 0;
                }
                final ak dYQ = dWT.dYQ();
                if (dYQ != null) {
                    i2 = i + 1;
                    arrayList.add(new o(this.AWy, i, a.i.j.a.EXTENSION_RECEIVER, new a.f.a.a<ak>() {
                        public final /* bridge */ /* synthetic */ Object invoke() {
                            return dYQ;
                        }
                    }));
                    i = i2;
                }
            }
            List dYV = dWT.dYV();
            a.f.b.j.o(dYV, "descriptor.valueParameters");
            int size = dYV.size();
            while (i3 < size) {
                i2 = i + 1;
                arrayList.add(new o(this.AWy, i, a.i.j.a.VALUE, new a.f.a.a<au>() {
                    public final /* synthetic */ Object invoke() {
                        AppMethodBeat.i(118687);
                        Object obj = dWT.dYV().get(i3);
                        a.f.b.j.o(obj, "descriptor.valueParameters[i]");
                        au auVar = (au) obj;
                        AppMethodBeat.o(118687);
                        return auVar;
                    }
                }));
                i3++;
                i = i2;
            }
            if (this.AWy.dWW() && (dWT instanceof a.i.b.a.c.d.a.b.b)) {
                dYV = arrayList;
                if (dYV.size() > 1) {
                    p.a(dYV, new a());
                }
            }
            arrayList.trimToSize();
            AppMethodBeat.o(118688);
            return arrayList;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "R", "invoke"})
    static final class d extends k implements a.f.a.a<List<? extends w>> {
        final /* synthetic */ e AWy;

        d(e eVar) {
            this.AWy = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118691);
            List dYS = this.AWy.dWT().dYS();
            a.f.b.j.o(dYS, "descriptor.typeParameters");
            Iterable<ar> iterable = dYS;
            Collection arrayList = new ArrayList(m.d(iterable));
            for (ar wVar : iterable) {
                arrayList.add(new w(wVar));
            }
            List list = (List) arrayList;
            AppMethodBeat.o(118691);
            return list;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "", "R", "invoke"})
    static final class a extends k implements a.f.a.a<List<? extends Annotation>> {
        final /* synthetic */ e AWy;

        a(e eVar) {
            this.AWy = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118685);
            List a = af.a((a.i.b.a.c.b.a.a) this.AWy.dWT());
            AppMethodBeat.o(118685);
            return a;
        }
    }

    public abstract a.i.b.a.c.b.b dWT();

    public abstract a.i.b.a.a.d<?> dWU();

    public abstract i dWV();

    public abstract boolean isBound();

    public e() {
        a.i.b.a.z.a a = z.a(null, new a(this));
        a.f.b.j.o(a, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.AWu = a;
        a = z.a(null, new b(this));
        a.f.b.j.o(a, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.AWv = a;
        a = z.a(null, new c(this));
        a.f.b.j.o(a, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.AWw = a;
        a = z.a(null, new d(this));
        a.f.b.j.o(a, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
        this.AWx = a;
    }

    public final List<j> getParameters() {
        Object invoke = this.AWv.invoke();
        a.f.b.j.o(invoke, "_parameters()");
        return (List) invoke;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dWW() {
        return a.f.b.j.j(getName(), "<init>") && dWV().dWH().isAnnotation();
    }

    public final R W(Object... objArr) {
        a.f.b.j.p(objArr, "args");
        try {
            return dWU().W(objArr);
        } catch (IllegalAccessException e) {
            throw new a.i.a.a(e);
        }
    }
}
