package a.i.b.a;

import a.a.m;
import a.f.b.h;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.a.d;
import a.i.b.a.a.e.f;
import a.i.e;
import a.i.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0011J\u001e\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003000/2\n\u00101\u001a\u0006\u0012\u0002\b\u000300H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00101\u001a\u000204H\u0002J\u0010\u00105\u001a\u0002032\u0006\u00101\u001a\u000204H\u0002J\u0010\u00106\u001a\u0002032\u0006\u00101\u001a\u000204H\u0002J\u0013\u00107\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u00109\u001a\u00020\u0013H\u0016J\b\u0010:\u001a\u00020\tH\u0016R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00178VX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00178VX\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001f\u0010\u0019R\u001b\u0010\r\u001a\u00020\u000e8VX\u0002¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, dWq = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflect-api"})
public final class j extends e<Object> implements h<Object>, b, e<Object> {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), v.a(new t(v.aN(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), v.a(new t(v.aN(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    private final a.i.b.a.z.a AWG;
    private final a.i.b.a.z.a AXq;
    private final a.i.b.a.z.a AXr;
    final i AXs;
    private final Object AXt;
    private final String signature;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<d<? extends Member>> {
        final /* synthetic */ j AXu;

        b(j jVar) {
            this.AXu = jVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Member dXw;
            d aVar;
            a.i.b.a.a.e a;
            boolean z = false;
            AppMethodBeat.i(118757);
            ad adVar = ad.AYC;
            c c = ad.c(this.AXu.dXf());
            i iVar;
            String str;
            if (c instanceof c.e) {
                iVar = this.AXu.AXs;
                str = ((c.e) c).AWk.name;
                String str2 = ((c.e) c).AWk.desc;
                dXw = this.AXu.dWU().dXw();
                if (dXw == null) {
                    a.f.b.j.dWJ();
                }
                dXw = iVar.d(str, str2, !Modifier.isStatic(dXw.getModifiers()), af.c(this.AXu.dXf()));
            } else if (c instanceof c.d) {
                if (this.AXu.dWW()) {
                    Class dWH = this.AXu.AXs.dWH();
                    Iterable<a.i.j> parameters = this.AXu.getParameters();
                    Collection arrayList = new ArrayList(m.d(parameters));
                    for (a.i.j name : parameters) {
                        String name2 = name.getName();
                        if (name2 == null) {
                            a.f.b.j.dWJ();
                        }
                        arrayList.add(name2);
                    }
                    aVar = new a.i.b.a.a.a(dWH, (List) arrayList, a.i.b.a.a.a.a.CALL_BY_NAME, a.i.b.a.a.a.b.KOTLIN);
                    AppMethodBeat.o(118757);
                    return aVar;
                }
                iVar = this.AXu.AXs;
                str = ((c.d) c).AWk.desc;
                boolean c2 = af.c(this.AXu.dXf());
                a.f.b.j.p(str, "desc");
                ArrayList arrayList2 = new ArrayList();
                iVar.c(arrayList2, str, true);
                Class dWH2 = iVar.dWH();
                List list = arrayList2;
                if (!c2) {
                    z = true;
                }
                dXw = i.a(dWH2, list, z);
            } else if (c instanceof a.i.b.a.c.a) {
                List list2 = ((a.i.b.a.c.a) c).AWf;
                Class dWH3 = this.AXu.AXs.dWH();
                Iterable<Method> iterable = list2;
                Collection arrayList3 = new ArrayList(m.d(iterable));
                for (Method method : iterable) {
                    a.f.b.j.o(method, "it");
                    arrayList3.add(method.getName());
                }
                aVar = new a.i.b.a.a.a(dWH3, (List) arrayList3, a.i.b.a.a.a.a.CALL_BY_NAME, a.i.b.a.a.a.b.JAVA, list2);
                AppMethodBeat.o(118757);
                return aVar;
            } else {
                dXw = null;
            }
            if (dXw instanceof Constructor) {
                a = j.a(this.AXu, (Constructor) dXw);
            } else if (dXw instanceof Method) {
                f b;
                if (this.AXu.dXf().dYn().i(af.dXv()) != null) {
                    a.i.b.a.c.b.l dXW = this.AXu.dXf().dXW();
                    if (dXW == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(118757);
                        throw vVar;
                    } else if (!((a.i.b.a.c.b.e) dXW).dYg()) {
                        b = j.b(this.AXu, (Method) dXw);
                        a = b;
                    }
                }
                b = j.c(this.AXu, (Method) dXw);
                a = b;
            } else {
                a = null;
            }
            if (a != null) {
                aVar = a.i.b.a.a.h.a(a, this.AXu.dXf(), true);
                AppMethodBeat.o(118757);
                return aVar;
            }
            AppMethodBeat.o(118757);
            return null;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<a.i.b.a.c.b.t> {
        final /* synthetic */ j AXu;
        final /* synthetic */ String AXv;

        c(j jVar, String str) {
            this.AXu = jVar;
            this.AXv = str;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Collection m;
            a.i.b.a.c.b.t tVar;
            int i = 0;
            AppMethodBeat.i(118758);
            i iVar = this.AXu.AXs;
            String str = this.AXv;
            String a = this.AXu.signature;
            a.f.b.j.p(str, "name");
            a.f.b.j.p(a, "signature");
            if (a.f.b.j.j(str, "<init>")) {
                m = a.a.t.m(iVar.dWR());
            } else {
                a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(str);
                a.f.b.j.o(avX, "Name.identifier(name)");
                m = iVar.b(avX);
            }
            Collection arrayList = new ArrayList();
            for (Object next : m) {
                tVar = (a.i.b.a.c.b.t) next;
                ad adVar = ad.AYC;
                if (a.f.b.j.j(ad.c(tVar).pq(), a)) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (list.size() != 1) {
                String a2 = a.a.t.a((Iterable) m, (CharSequence) IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, (a.f.a.b) d.AXn, 30);
                StringBuilder append = new StringBuilder("Function '").append(str).append("' (JVM signature: ").append(a).append(") not resolved in ").append(iVar).append(':');
                if (a2.length() == 0) {
                    i = 1;
                }
                Throwable xVar = new x(append.append(i != 0 ? " no members found" : IOUtils.LINE_SEPARATOR_UNIX.concat(String.valueOf(a2))).toString());
                AppMethodBeat.o(118758);
                throw xVar;
            }
            tVar = (a.i.b.a.c.b.t) a.a.t.fN(list);
            AppMethodBeat.o(118758);
            return tVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.a<d<? extends Member>> {
        final /* synthetic */ j AXu;

        a(j jVar) {
            this.AXu = jVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object cu;
            a.i.b.a.a.e a;
            AppMethodBeat.i(118756);
            ad adVar = ad.AYC;
            c c = ad.c(this.AXu.dXf());
            d aVar;
            Member cu2;
            if (c instanceof c.d) {
                if (this.AXu.dWW()) {
                    Class dWH = this.AXu.AXs.dWH();
                    Iterable<a.i.j> parameters = this.AXu.getParameters();
                    Collection arrayList = new ArrayList(m.d(parameters));
                    for (a.i.j name : parameters) {
                        String name2 = name.getName();
                        if (name2 == null) {
                            a.f.b.j.dWJ();
                        }
                        arrayList.add(name2);
                    }
                    aVar = new a.i.b.a.a.a(dWH, (List) arrayList, a.i.b.a.a.a.a.POSITIONAL_CALL, a.i.b.a.a.a.b.KOTLIN);
                    AppMethodBeat.o(118756);
                    return aVar;
                }
                cu2 = this.AXu.AXs.cu(((c.d) c).AWk.desc, af.c(this.AXu.dXf()));
            } else if (c instanceof c.e) {
                cu2 = this.AXu.AXs.H(((c.e) c).AWk.name, ((c.e) c).AWk.desc, af.c(this.AXu.dXf()));
            } else if (c instanceof a.i.b.a.c.c) {
                cu2 = ((a.i.b.a.c.c) c).method;
            } else if (c instanceof a.i.b.a.c.b) {
                cu2 = ((a.i.b.a.c.b) c).AWh;
            } else if (c instanceof a.i.b.a.c.a) {
                List list = ((a.i.b.a.c.a) c).AWf;
                Class dWH2 = this.AXu.AXs.dWH();
                Iterable<Method> iterable = list;
                Collection arrayList2 = new ArrayList(m.d(iterable));
                for (Method method : iterable) {
                    a.f.b.j.o(method, "it");
                    arrayList2.add(method.getName());
                }
                aVar = new a.i.b.a.a.a(dWH2, (List) arrayList2, a.i.b.a.a.a.a.POSITIONAL_CALL, a.i.b.a.a.a.b.JAVA, list);
                AppMethodBeat.o(118756);
                return aVar;
            } else {
                a.m mVar = new a.m();
                AppMethodBeat.o(118756);
                throw mVar;
            }
            if (cu2 instanceof Constructor) {
                a = j.a(this.AXu, (Constructor) cu2);
            } else if (cu2 instanceof Method) {
                f a2;
                if (!Modifier.isStatic(((Method) cu2).getModifiers())) {
                    a2 = j.a(this.AXu, (Method) cu2);
                } else if (this.AXu.dXf().dYn().i(af.dXv()) != null) {
                    a2 = j.b(this.AXu, (Method) cu2);
                } else {
                    a2 = j.c(this.AXu, (Method) cu2);
                }
                a = a2;
            } else {
                Throwable xVar = new x("Could not compute caller for function: " + this.AXu.dXf() + " (member = " + cu2 + ')');
                AppMethodBeat.o(118756);
                throw xVar;
            }
            cu2 = a.i.b.a.a.h.a(a, this.AXu.dXf());
            AppMethodBeat.o(118756);
            return cu2;
        }
    }

    static {
        AppMethodBeat.i(118759);
        AppMethodBeat.o(118759);
    }

    private j(i iVar, String str, String str2, a.i.b.a.c.b.t tVar, Object obj) {
        AppMethodBeat.i(118769);
        this.AXs = iVar;
        this.signature = str2;
        this.AXt = obj;
        this.AWG = z.a(tVar, new c(this, str));
        this.AXq = z.a(null, new a(this));
        this.AXr = z.a(null, new b(this));
        AppMethodBeat.o(118769);
    }

    public final /* synthetic */ a.i.b.a.c.b.b dWT() {
        AppMethodBeat.i(118762);
        a.i.b.a.c.b.b dXf = dXf();
        AppMethodBeat.o(118762);
        return dXf;
    }

    public final i dWV() {
        return this.AXs;
    }

    public j(i iVar, String str, String str2, Object obj) {
        a.f.b.j.p(iVar, "container");
        a.f.b.j.p(str, "name");
        a.f.b.j.p(str2, "signature");
        this(iVar, str, str2, null, obj);
        AppMethodBeat.i(118771);
        AppMethodBeat.o(118771);
    }

    public j(i iVar, a.i.b.a.c.b.t tVar) {
        a.f.b.j.p(iVar, "container");
        a.f.b.j.p(tVar, "descriptor");
        String str = tVar.dZg().name;
        a.f.b.j.o(str, "descriptor.name.asString()");
        ad adVar = ad.AYC;
        this(iVar, str, ad.c(tVar).pq(), tVar);
        AppMethodBeat.i(118772);
        AppMethodBeat.o(118772);
    }

    public final boolean isBound() {
        AppMethodBeat.i(118760);
        int j = a.f.b.j.j(this.AXt, a.f.b.c.AVy) ^ 1;
        AppMethodBeat.o(118760);
        return j;
    }

    public final String getName() {
        AppMethodBeat.i(118763);
        String str = dXf().dZg().name;
        a.f.b.j.o(str, "descriptor.name.asString()");
        AppMethodBeat.o(118763);
        return str;
    }

    public final int dWz() {
        AppMethodBeat.i(118765);
        int a = a.i.b.a.a.f.a(dWU());
        AppMethodBeat.o(118765);
        return a;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118766);
        j dw = af.dw(obj);
        if (dw == null) {
            AppMethodBeat.o(118766);
            return false;
        } else if (a.f.b.j.j(this.AXs, dw.AXs) && a.f.b.j.j(getName(), dw.getName()) && a.f.b.j.j(this.signature, dw.signature) && a.f.b.j.j(this.AXt, dw.AXt)) {
            AppMethodBeat.o(118766);
            return true;
        } else {
            AppMethodBeat.o(118766);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(118768);
        ab abVar = ab.AYy;
        String a = ab.a(dXf());
        AppMethodBeat.o(118768);
        return a;
    }

    public final a.i.b.a.c.b.t dXf() {
        AppMethodBeat.i(118761);
        a.i.b.a.c.b.t tVar = (a.i.b.a.c.b.t) this.AWG.invoke();
        AppMethodBeat.o(118761);
        return tVar;
    }

    public final d<?> dWU() {
        AppMethodBeat.i(118764);
        d dVar = (d) this.AXq.invoke();
        AppMethodBeat.o(118764);
        return dVar;
    }

    public final int hashCode() {
        AppMethodBeat.i(118767);
        int hashCode = (((this.AXs.hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
        AppMethodBeat.o(118767);
        return hashCode;
    }

    public final Object invoke() {
        AppMethodBeat.i(118773);
        Object W = W(new Object[0]);
        AppMethodBeat.o(118773);
        return W;
    }

    public final Object am(Object obj) {
        AppMethodBeat.i(118774);
        Object W = W(obj);
        AppMethodBeat.o(118774);
        return W;
    }

    public final Object m(Object obj, Object obj2) {
        AppMethodBeat.i(118775);
        Object W = W(obj, obj2);
        AppMethodBeat.o(118775);
        return W;
    }

    public final Object g(Object obj, Object obj2, Object obj3) {
        AppMethodBeat.i(118776);
        Object W = W(obj, obj2, obj3);
        AppMethodBeat.o(118776);
        return W;
    }

    public final Object a(Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(118777);
        Object W = W(obj, obj2, obj3, obj4);
        AppMethodBeat.o(118777);
        return W;
    }

    public static final /* synthetic */ f b(j jVar, Method method) {
        AppMethodBeat.i(118780);
        f bVar;
        if (jVar.isBound()) {
            bVar = new a.i.b.a.a.e.f.b(method);
            AppMethodBeat.o(118780);
            return bVar;
        }
        bVar = new f.e(method);
        AppMethodBeat.o(118780);
        return bVar;
    }

    public static final /* synthetic */ f c(j jVar, Method method) {
        AppMethodBeat.i(118781);
        f cVar;
        if (jVar.isBound()) {
            cVar = new a.i.b.a.a.e.f.c(method, jVar.AXt);
            AppMethodBeat.o(118781);
            return cVar;
        }
        cVar = new f.f(method);
        AppMethodBeat.o(118781);
        return cVar;
    }
}
