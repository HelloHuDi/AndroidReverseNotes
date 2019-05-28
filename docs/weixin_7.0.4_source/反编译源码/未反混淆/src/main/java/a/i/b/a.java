package a.i.b;

import a.a.t;
import a.f.b.j;
import a.i.b;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.f;
import a.i.b.a.c.b.h;
import a.i.b.a.u;
import a.i.b.a.x;
import a.i.c;
import a.i.o;
import a.i.p;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, dWq = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflect-api"})
public final class a {
    private static b<?> a(o oVar) {
        AppMethodBeat.i(118654);
        j.p(oVar, "receiver$0");
        c dWO = oVar.dWO();
        if (dWO != null) {
            b a = a(dWO);
            if (a != null) {
                AppMethodBeat.o(118654);
                return a;
            }
        }
        Throwable xVar = new x("Cannot calculate JVM erasure for type: ".concat(String.valueOf(oVar)));
        AppMethodBeat.o(118654);
        throw xVar;
    }

    public static final b<?> a(c cVar) {
        AppMethodBeat.i(118655);
        j.p(cVar, "receiver$0");
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            AppMethodBeat.o(118655);
            return bVar;
        } else if (cVar instanceof p) {
            o oVar;
            Object obj;
            b<?> a;
            List dWP = ((p) cVar).dWP();
            for (Object next : dWP) {
                oVar = (o) next;
                if (oVar != null) {
                    h dYs = ((u) oVar).AYl.ejw().dYs();
                    if (!(dYs instanceof e)) {
                        dYs = null;
                    }
                    e eVar = (e) dYs;
                    if (eVar == null || eVar.dYc() == f.INTERFACE || eVar.dYc() == f.ANNOTATION_CLASS) {
                        obj = null;
                        continue;
                    } else {
                        obj = 1;
                        continue;
                    }
                    if (obj != null) {
                        obj = next;
                        break;
                    }
                }
                v vVar = new v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                AppMethodBeat.o(118655);
                throw vVar;
            }
            obj = null;
            oVar = (o) obj;
            if (oVar == null) {
                oVar = (o) t.fK(dWP);
            }
            if (oVar != null) {
                a = a(oVar);
                if (a != null) {
                    AppMethodBeat.o(118655);
                    return a;
                }
            }
            a = a.f.b.v.aN(Object.class);
            AppMethodBeat.o(118655);
            return a;
        } else {
            Throwable xVar = new x("Cannot calculate JVM erasure for type: ".concat(String.valueOf(cVar)));
            AppMethodBeat.o(118655);
            throw xVar;
        }
    }
}
