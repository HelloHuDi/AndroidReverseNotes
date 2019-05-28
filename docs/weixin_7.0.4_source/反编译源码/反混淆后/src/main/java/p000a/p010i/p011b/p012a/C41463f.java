package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p1149d.C17333b;
import p000a.p010i.p011b.p012a.p1149d.C25245a;
import p000a.p010i.p011b.p012a.p1149d.C31789e;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.f */
public final class C41463f {
    private static C17333b<String, Object> AWE;

    static {
        AppMethodBeat.m2504i(118693);
        C17333b ekF = C17333b.ekF();
        C25052j.m39375o(ekF, "HashPMap.empty<String, Any>()");
        AWE = ekF;
        AppMethodBeat.m2505o(118693);
    }

    /* renamed from: aO */
    public static final <T> C16493g<T> m72345aO(Class<T> cls) {
        Object obj;
        C16493g<T> c16493g;
        C17333b K;
        Object obj2 = null;
        AppMethodBeat.m2504i(118692);
        C25052j.m39376p(cls, "jClass");
        String name = cls.getName();
        C25245a UV = AWE.mo31404UV(name.hashCode());
        while (UV != null && UV.size > 0) {
            C31789e c31789e = (C31789e) UV.first;
            if (c31789e.aCx.equals(name)) {
                obj = c31789e.value;
                break;
            }
            UV = UV.BNz;
        }
        obj = null;
        if (obj instanceof WeakReference) {
            C16493g c16493g2 = (C16493g) ((WeakReference) obj).get();
            if (c16493g2 != null) {
                obj2 = c16493g2.AVA;
            }
            if (C25052j.m39373j(obj2, cls)) {
                AppMethodBeat.m2505o(118692);
                return c16493g2;
            }
        } else if (obj != null) {
            for (WeakReference weakReference : (WeakReference[]) obj) {
                Object obj3;
                C16493g<T> c16493g3 = (C16493g) weakReference.get();
                if (c16493g3 != null) {
                    obj3 = c16493g3.AVA;
                } else {
                    obj3 = null;
                }
                if (C25052j.m39373j(obj3, cls)) {
                    AppMethodBeat.m2505o(118692);
                    return c16493g3;
                }
            }
            int length = ((Object[]) obj).length;
            WeakReference[] weakReferenceArr = new WeakReference[(length + 1)];
            System.arraycopy(obj, 0, weakReferenceArr, 0, length);
            c16493g = new C16493g(cls);
            weakReferenceArr[length] = new WeakReference(c16493g);
            K = AWE.mo31403K(name, weakReferenceArr);
            C25052j.m39375o(K, "K_CLASS_CACHE.plus(name, newArray)");
            AWE = K;
            AppMethodBeat.m2505o(118692);
            return c16493g;
        }
        c16493g = new C16493g(cls);
        K = AWE.mo31403K(name, new WeakReference(c16493g));
        C25052j.m39375o(K, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        AWE = K;
        AppMethodBeat.m2505o(118692);
        return c16493g;
    }
}
