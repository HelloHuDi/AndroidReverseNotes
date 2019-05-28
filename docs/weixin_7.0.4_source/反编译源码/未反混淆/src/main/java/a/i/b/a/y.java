package a.i.b.a;

import a.f.b.j;
import a.i.b.a.b.c;
import a.i.b.a.b.h;
import a.i.b.a.b.i;
import a.i.b.a.b.i.a;
import a.i.b.a.c.a.b.e;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.aa;
import a.i.b.a.c.b.ac;
import a.i.b.a.c.b.ap;
import a.i.b.a.c.b.c.v;
import a.i.b.a.c.d.a.a.k;
import a.i.b.a.c.d.b.d;
import a.i.b.a.c.d.b.m;
import a.i.b.a.c.f.f;
import a.i.b.a.e.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflect-api"})
public final class y {
    private static final ConcurrentMap<ah, WeakReference<i>> AYu = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(118896);
        AppMethodBeat.o(118896);
    }

    public static final i aQ(Class<?> cls) {
        i iVar;
        AppMethodBeat.i(118895);
        j.p(cls, "receiver$0");
        ClassLoader aX = b.aX(cls);
        ah ahVar = new ah(aX);
        WeakReference weakReference = (WeakReference) AYu.get(ahVar);
        if (weakReference != null) {
            iVar = (i) weakReference.get();
            if (iVar != null) {
                j.o(iVar, "it");
                AppMethodBeat.o(118895);
                return iVar;
            }
            AYu.remove(ahVar, weakReference);
        }
        a aVar = i.AZz;
        j.p(aX, "classLoader");
        a.i.b.a.c.k.b bVar = new a.i.b.a.c.k.b();
        g eVar = new e(bVar, (byte) 0);
        f avZ = f.avZ("<runtime module for " + aX + '>');
        j.o(avZ, "Name.special(\"<runtime module for $classLoader>\")");
        v vVar = new v(avZ, bVar, eVar, null, 56);
        a.i.b.a.b.f fVar = new a.i.b.a.b.f(aX);
        a.i.b.a.c.d.b.e eVar2 = new a.i.b.a.c.d.b.e();
        a.i.b.a.c.d.a.c.l lVar = new a.i.b.a.c.d.a.c.l();
        a.i.b.a.b.j jVar = new a.i.b.a.b.j(aX);
        a.i.b.a.c.d.a.a.g gVar = a.i.b.a.c.d.a.a.g.Bmn;
        aa aaVar = new aa(bVar, vVar);
        a.i.b.a.c.d.a.a aVar2 = new a.i.b.a.c.d.a.a(bVar, a.i.b.a.c.n.e.BNe);
        a.i.b.a.c.k.i iVar2 = bVar;
        a.i.b.a.c.d.a.j cVar = new c(aX);
        m mVar = fVar;
        k kVar = k.Bmr;
        j.o(kVar, "SignaturePropagator.DO_NOTHING");
        a.i.b.a.c.j.a.m mVar2 = h.AZw;
        j.o(gVar, "javaResolverCache");
        a.i.b.a.c.d.a.c.g gVar2 = new a.i.b.a.c.d.a.c.g(new a.i.b.a.c.d.a.c.b(iVar2, cVar, mVar, eVar2, kVar, mVar2, gVar, a.i.b.a.c.d.a.a.f.a.Bmm, a.i.b.a.c.d.a.a.j.a.Bmq, a.i.b.a.b.k.AZE, lVar, jVar, ap.a.BeT, a.i.b.a.c.c.a.b.a.BjE, vVar, new a.i.b.a.c.a.i(vVar, aaVar), aVar2, new a.i.b.a.c.d.a.f.l(aVar2, a.i.b.a.c.n.e.BNe), a.i.b.a.c.d.a.k.a.Ble, a.i.b.a.c.d.a.c.c.b.Bnk));
        a.i.b.a.c.b.y yVar = vVar;
        j.p(yVar, "moduleDescriptor");
        Object obj = eVar.BdE == null ? 1 : null;
        if (a.aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("JvmBuiltins repeated initialization");
            AppMethodBeat.o(118895);
            throw assertionError;
        }
        eVar.BdE = yVar;
        eVar.BdF = true;
        a.i.b.a.c.i.d.a aVar3 = new a.i.b.a.c.i.d.a(gVar2, gVar);
        a.i.b.a.c.d.b.f fVar2 = new a.i.b.a.c.d.b.f(fVar, eVar2);
        a.i.b.a.c.d.b.c cVar2 = new a.i.b.a.c.d.b.c(vVar, aaVar, bVar, fVar);
        a.i.b.a.c.k.i iVar3 = bVar;
        a.i.b.a.c.b.y yVar2 = vVar;
        a.i.b.a.c.j.a.j jVar2 = a.i.b.a.c.j.a.j.a.BHa;
        a.i.b.a.c.j.a.m mVar3 = h.AZw;
        a.i.b.a.c.c.a.b bVar2 = a.i.b.a.c.c.a.b.a.BjE;
        a.i.b.a.c.j.a.h.a aVar4 = a.i.b.a.c.j.a.h.BGL;
        d dVar = new d(iVar3, yVar2, jVar2, fVar2, cVar2, gVar2, aaVar, mVar3, bVar2, a.i.b.a.c.j.a.h.a.ejQ());
        j.p(aVar3, "<set-?>");
        lVar.BnE = aVar3;
        j.p(dVar, "components");
        eVar2.Brl = dVar.Brl;
        v[] vVarArr = new v[2];
        vVarArr[0] = vVar;
        v vVar2 = eVar.Bab;
        j.o(vVar2, "builtIns.builtInsModule");
        vVarArr[1] = vVar2;
        vVar.a(vVarArr);
        vVar.a((ac) aVar3.BFd);
        i iVar4 = new i(dVar.Brl, jVar, (byte) 0);
        while (true) {
            try {
                weakReference = (WeakReference) AYu.putIfAbsent(ahVar, new WeakReference(iVar4));
                if (weakReference == null) {
                    ahVar.AYG = null;
                    AppMethodBeat.o(118895);
                    return iVar4;
                }
                iVar = (i) weakReference.get();
                if (iVar != null) {
                    break;
                }
                AYu.remove(ahVar, weakReference);
            } finally {
                ahVar.AYG = null;
                iVar = 118895;
                AppMethodBeat.o(118895);
            }
        }
        return iVar;
    }
}
