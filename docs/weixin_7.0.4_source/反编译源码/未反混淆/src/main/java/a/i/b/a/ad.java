package a.i.b.a;

import a.f.b.j;
import a.i.b.a.c.a.h;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ai;
import a.i.b.a.c.b.aj;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.t;
import a.i.b.a.c.c;
import a.i.b.a.c.d.b.r;
import a.i.b.a.c.e;
import a.i.b.a.c.e.a.o;
import a.i.b.a.c.e.a.u;
import a.i.b.a.c.e.b.a.f;
import a.i.b.a.c.f.a;
import a.i.b.a.c.f.b;
import a.i.b.a.c.g.q;
import a.i.b.a.c.i.d;
import a.i.b.a.c.j.a.a.i;
import a.i.b.a.e.m;
import a.i.b.a.e.p;
import a.i.b.a.e.s;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, dWq = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflect-api"})
public final class ad {
    static final a AYB;
    public static final ad AYC = new ad();

    static {
        AppMethodBeat.i(118930);
        a n = a.n(new b("java.lang.Void"));
        j.o(n, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        AYB = n;
        AppMethodBeat.o(118930);
    }

    private ad() {
    }

    public static c c(t tVar) {
        AppMethodBeat.i(118925);
        j.p(tVar, "possiblySubstitutedFunction");
        a.i.b.a.c.b.b u = d.u((a.i.b.a.c.b.b) tVar);
        j.o(u, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        t dZp = ((t) u).dZp();
        j.o(dZp, "DescriptorUtils.unwrapFa…titutedFunction).original");
        c eVar;
        am dYo;
        a.i.b.a.c.d.a.d.a aVar;
        Throwable xVar;
        Object dXC;
        if (dZp instanceof a.i.b.a.c.j.a.a.b) {
            a.i.b.a.c.e.b.a.j jVar;
            q ejU = ((a.i.b.a.c.j.a.a.b) dZp).ejU();
            if (ejU instanceof o) {
                jVar = a.i.b.a.c.e.b.a.j.ByD;
                f.b a = a.i.b.a.c.e.b.a.j.a((o) ejU, ((a.i.b.a.c.j.a.a.b) dZp).ejV(), ((a.i.b.a.c.j.a.a.b) dZp).ejW());
                if (a != null) {
                    eVar = new e(a);
                    AppMethodBeat.o(118925);
                    return eVar;
                }
            }
            if (ejU instanceof a.i.b.a.c.e.a.e) {
                jVar = a.i.b.a.c.e.b.a.j.ByD;
                f.b a2 = a.i.b.a.c.e.b.a.j.a((a.i.b.a.c.e.a.e) ejU, ((a.i.b.a.c.j.a.a.b) dZp).ejV(), ((a.i.b.a.c.j.a.a.b) dZp).ejW());
                if (a2 != null) {
                    eVar = new c.d(a2);
                    AppMethodBeat.o(118925);
                    return eVar;
                }
            }
            eVar = d(dZp);
            AppMethodBeat.o(118925);
            return eVar;
        } else if (dZp instanceof a.i.b.a.c.d.a.b.e) {
            a.i.b.a.c.d.a.e.l dXC2;
            dYo = ((a.i.b.a.c.d.a.b.e) dZp).dYo();
            if (!(dYo instanceof a.i.b.a.c.d.a.d.a)) {
                dYo = null;
            }
            aVar = (a.i.b.a.c.d.a.d.a) dYo;
            if (aVar != null) {
                dXC2 = aVar.dXC();
            } else {
                dXC2 = null;
            }
            if (!(dXC2 instanceof s)) {
                dXC2 = null;
            }
            s sVar = (s) dXC2;
            if (sVar != null) {
                Method method = sVar.BOh;
                if (method != null) {
                    eVar = new c(method);
                    AppMethodBeat.o(118925);
                    return eVar;
                }
            }
            xVar = new x("Incorrect resolution sequence for Java method ".concat(String.valueOf(dZp)));
            AppMethodBeat.o(118925);
            throw xVar;
        } else if (dZp instanceof a.i.b.a.c.d.a.b.c) {
            dYo = ((a.i.b.a.c.d.a.b.c) dZp).dYo();
            if (!(dYo instanceof a.i.b.a.c.d.a.d.a)) {
                dYo = null;
            }
            aVar = (a.i.b.a.c.d.a.d.a) dYo;
            if (aVar != null) {
                dXC = aVar.dXC();
            } else {
                dXC = null;
            }
            if (dXC instanceof m) {
                eVar = new c.b(((m) dXC).BOe);
                AppMethodBeat.o(118925);
                return eVar;
            } else if ((dXC instanceof a.i.b.a.e.j) && ((a.i.b.a.e.j) dXC).AZs.isAnnotation()) {
                eVar = new c.a(((a.i.b.a.e.j) dXC).AZs);
                AppMethodBeat.o(118925);
                return eVar;
            } else {
                xVar = new x("Incorrect resolution sequence for Java constructor " + dZp + " (" + dXC + ')');
                AppMethodBeat.o(118925);
                throw xVar;
            }
        } else {
            if (dZp.dZg().equals(d.BDR) && a.i.b.a.c.i.c.g(dZp)) {
                dXC = 1;
            } else {
                dXC = null;
            }
            if (dXC == null) {
                if (dZp.dZg().equals(d.BDQ) && a.i.b.a.c.i.c.g(dZp)) {
                    dXC = 1;
                } else {
                    dXC = null;
                }
                if (dXC == null) {
                    xVar = new x("Unknown origin of " + dZp + " (" + dZp.getClass() + ')');
                    AppMethodBeat.o(118925);
                    throw xVar;
                }
            }
            eVar = d(dZp);
            AppMethodBeat.o(118925);
            return eVar;
        }
    }

    public static d c(ah ahVar) {
        d cVar;
        aj dZJ;
        e eVar;
        e eVar2 = null;
        AppMethodBeat.i(118926);
        j.p(ahVar, "possiblyOverriddenProperty");
        a.i.b.a.c.b.b u = d.u((a.i.b.a.c.b.b) ahVar);
        j.o(u, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        ah dZL = ((ah) u).dZL();
        j.o(dZL, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (dZL instanceof i) {
            u uVar = ((i) dZL).AWo;
            a.i.b.a.c.g.i.c cVar2 = uVar;
            a.i.b.a.c.g.i.f fVar = a.i.b.a.c.e.b.b.BxC;
            j.o(fVar, "JvmProtoBuf.propertySignature");
            a.i.b.a.c.e.b.b.e eVar3 = (a.i.b.a.c.e.b.b.e) a.i.b.a.c.e.a.f.a(cVar2, fVar);
            if (eVar3 != null) {
                cVar = new d.c(dZL, uVar, eVar3, ((i) dZL).AWq, ((i) dZL).AWr);
                AppMethodBeat.o(118926);
                return cVar;
            }
        } else if (dZL instanceof a.i.b.a.c.d.a.b.f) {
            Object dXC;
            am dYo = ((a.i.b.a.c.d.a.b.f) dZL).dYo();
            if (!(dYo instanceof a.i.b.a.c.d.a.d.a)) {
                dYo = null;
            }
            a.i.b.a.c.d.a.d.a aVar = (a.i.b.a.c.d.a.d.a) dYo;
            if (aVar != null) {
                dXC = aVar.dXC();
            } else {
                dXC = null;
            }
            if (dXC instanceof p) {
                cVar = new d.a(((p) dXC).BOg);
                AppMethodBeat.o(118926);
                return cVar;
            } else if (dXC instanceof s) {
                a.i.b.a.c.d.a.e.l dXC2;
                Method method;
                Method method2 = ((s) dXC).BOh;
                dZJ = dZL.dZJ();
                if (dZJ != null) {
                    dYo = dZJ.dYo();
                } else {
                    dYo = null;
                }
                if (!(dYo instanceof a.i.b.a.c.d.a.d.a)) {
                    dYo = null;
                }
                aVar = (a.i.b.a.c.d.a.d.a) dYo;
                if (aVar != null) {
                    dXC2 = aVar.dXC();
                } else {
                    dXC2 = null;
                }
                if (!(dXC2 instanceof s)) {
                    dXC2 = null;
                }
                s sVar = (s) dXC2;
                if (sVar != null) {
                    method = sVar.BOh;
                }
                cVar = new d.b(method2, method);
                AppMethodBeat.o(118926);
                return cVar;
            } else {
                Throwable xVar = new x("Incorrect resolution sequence for Java field " + dZL + " (source = " + dXC + ')');
                AppMethodBeat.o(118926);
                throw xVar;
            }
        }
        ai dZI = dZL.dZI();
        if (dZI == null) {
            j.dWJ();
        }
        e d = d(dZI);
        dZJ = dZL.dZJ();
        if (dZJ != null) {
            eVar2 = d(dZJ);
            eVar = d;
        } else {
            eVar = d;
        }
        cVar = new d.d(eVar, eVar2);
        AppMethodBeat.o(118926);
        return cVar;
    }

    private static e d(t tVar) {
        AppMethodBeat.i(118927);
        e eVar = new e(new f.b(b(tVar), r.a(tVar, false, false, 1)));
        AppMethodBeat.o(118927);
        return eVar;
    }

    private static String b(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(118928);
        String q = a.i.b.a.c.d.a.t.q(bVar);
        if (q == null) {
            if (bVar instanceof ai) {
                q = a.i.b.a.c.d.a.o.avJ(a.i.b.a.c.i.c.a.x(bVar).dZg().name);
            } else if (bVar instanceof aj) {
                q = a.i.b.a.c.d.a.o.avK(a.i.b.a.c.i.c.a.x(bVar).dZg().name);
            } else {
                q = bVar.dZg().name;
            }
            j.o(q, "when (descriptor) {\n    …name.asString()\n        }");
        }
        AppMethodBeat.o(118928);
        return q;
    }

    static h aR(Class<?> cls) {
        AppMethodBeat.i(118929);
        if (cls.isPrimitive()) {
            a.i.b.a.c.i.d.c awk = a.i.b.a.c.i.d.c.awk(cls.getSimpleName());
            j.o(awk, "JvmPrimitiveType.get(simpleName)");
            h hVar = awk.BFq;
            AppMethodBeat.o(118929);
            return hVar;
        }
        AppMethodBeat.o(118929);
        return null;
    }
}
