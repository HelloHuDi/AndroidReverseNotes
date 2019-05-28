package a.i.b.a;

import a.f.b.j;
import a.i.b.a.d.a;
import a.i.b.a.d.b;
import a.i.b.a.d.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"})
public final class f {
    private static b<String, Object> AWE;

    static {
        AppMethodBeat.i(118693);
        b ekF = b.ekF();
        j.o(ekF, "HashPMap.empty<String, Any>()");
        AWE = ekF;
        AppMethodBeat.o(118693);
    }

    public static final <T> g<T> aO(Class<T> cls) {
        Object obj;
        g<T> gVar;
        b K;
        Object obj2 = null;
        AppMethodBeat.i(118692);
        j.p(cls, "jClass");
        String name = cls.getName();
        a UV = AWE.UV(name.hashCode());
        while (UV != null && UV.size > 0) {
            e eVar = (e) UV.first;
            if (eVar.aCx.equals(name)) {
                obj = eVar.value;
                break;
            }
            UV = UV.BNz;
        }
        obj = null;
        if (obj instanceof WeakReference) {
            g gVar2 = (g) ((WeakReference) obj).get();
            if (gVar2 != null) {
                obj2 = gVar2.AVA;
            }
            if (j.j(obj2, cls)) {
                AppMethodBeat.o(118692);
                return gVar2;
            }
        } else if (obj != null) {
            for (WeakReference weakReference : (WeakReference[]) obj) {
                Object obj3;
                g<T> gVar3 = (g) weakReference.get();
                if (gVar3 != null) {
                    obj3 = gVar3.AVA;
                } else {
                    obj3 = null;
                }
                if (j.j(obj3, cls)) {
                    AppMethodBeat.o(118692);
                    return gVar3;
                }
            }
            int length = ((Object[]) obj).length;
            WeakReference[] weakReferenceArr = new WeakReference[(length + 1)];
            System.arraycopy(obj, 0, weakReferenceArr, 0, length);
            gVar = new g(cls);
            weakReferenceArr[length] = new WeakReference(gVar);
            K = AWE.K(name, weakReferenceArr);
            j.o(K, "K_CLASS_CACHE.plus(name, newArray)");
            AWE = K;
            AppMethodBeat.o(118692);
            return gVar;
        }
        gVar = new g(cls);
        K = AWE.K(name, new WeakReference(gVar));
        j.o(K, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        AWE = K;
        AppMethodBeat.o(118692);
        return gVar;
    }
}
