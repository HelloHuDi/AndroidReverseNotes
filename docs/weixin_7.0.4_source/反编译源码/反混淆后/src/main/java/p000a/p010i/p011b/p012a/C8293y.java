package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p000a.C0220l;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p014b.C25073c;
import p000a.p010i.p011b.p012a.p014b.C36946i;
import p000a.p010i.p011b.p012a.p014b.C36946i.C31604a;
import p000a.p010i.p011b.p012a.p014b.C41176k;
import p000a.p010i.p011b.p012a.p014b.C44864h;
import p000a.p010i.p011b.p012a.p014b.C44865j;
import p000a.p010i.p011b.p012a.p014b.C8021f;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p016a.C31625i;
import p000a.p010i.p011b.p012a.p015c.p016a.p017b.C17146e;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap.C17158a;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C44870aa;
import p000a.p010i.p011b.p012a.p015c.p018b.C44871ac;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31637v;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8086b;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8086b.C8087a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C0045a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C44891k.C36987a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C8127j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C25094j.C25095a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C31645f.C31646a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C36968g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C8091k;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C36654l;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C36979b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C44884c.C31666b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C8112g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f.C17216l;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C0073e;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C0076f;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C25129m;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C41180c;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C44895d;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C44907a;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C31759m;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C37042j;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C37042j.C37043a;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C8222h;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C8222h.C8223a;
import p000a.p010i.p011b.p012a.p015c.p044k.C17299b;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p048n.C8261e;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p049e.C37076b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.y */
public final class C8293y {
    private static final ConcurrentMap<C25072ah, WeakReference<C36946i>> AYu = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(118896);
        AppMethodBeat.m2505o(118896);
    }

    /* renamed from: aQ */
    public static final C36946i m14621aQ(Class<?> cls) {
        C36946i c36946i;
        AppMethodBeat.m2504i(118895);
        C25052j.m39376p(cls, "receiver$0");
        ClassLoader aX = C37076b.m62032aX(cls);
        C25072ah c25072ah = new C25072ah(aX);
        WeakReference weakReference = (WeakReference) AYu.get(c25072ah);
        if (weakReference != null) {
            c36946i = (C36946i) weakReference.get();
            if (c36946i != null) {
                C25052j.m39375o(c36946i, "it");
                AppMethodBeat.m2505o(118895);
                return c36946i;
            }
            AYu.remove(c25072ah, weakReference);
        }
        C31604a c31604a = C36946i.AZz;
        C25052j.m39376p(aX, "classLoader");
        C17299b c17299b = new C17299b();
        C31619g c17146e = new C17146e(c17299b, (byte) 0);
        C37022f avZ = C37022f.avZ("<runtime module for " + aX + '>');
        C25052j.m39375o(avZ, "Name.special(\"<runtime module for $classLoader>\")");
        C31637v c31637v = new C31637v(avZ, c17299b, c17146e, null, 56);
        C8021f c8021f = new C8021f(aX);
        C0073e c0073e = new C0073e();
        C36654l c36654l = new C36654l();
        C44865j c44865j = new C44865j(aX);
        C36968g c36968g = C36968g.Bmn;
        C44870aa c44870aa = new C44870aa(c17299b, c31637v);
        C0045a c0045a = new C0045a(c17299b, C8261e.BNe);
        C25212i c25212i = c17299b;
        C8127j c25073c = new C25073c(aX);
        C25129m c25129m = c8021f;
        C8091k c8091k = C8091k.Bmr;
        C25052j.m39375o(c8091k, "SignaturePropagator.DO_NOTHING");
        C31759m c31759m = C44864h.AZw;
        C25052j.m39375o(c36968g, "javaResolverCache");
        C8112g c8112g = new C8112g(new C36979b(c25212i, c25073c, c25129m, c0073e, c8091k, c31759m, c36968g, C31646a.Bmm, C25095a.Bmq, C41176k.AZE, c36654l, c44865j, C17158a.BeT, C8087a.BjE, c31637v, new C31625i(c31637v, c44870aa), c0045a, new C17216l(c0045a, C8261e.BNe), C36987a.Ble, C31666b.Bnk));
        C25093y c25093y = c31637v;
        C25052j.m39376p(c25093y, "moduleDescriptor");
        Object obj = c17146e.BdE == null ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("JvmBuiltins repeated initialization");
            AppMethodBeat.m2505o(118895);
            throw assertionError;
        }
        c17146e.BdE = c25093y;
        c17146e.BdF = true;
        C44907a c44907a = new C44907a(c8112g, c36968g);
        C0076f c0076f = new C0076f(c8021f, c0073e);
        C41180c c41180c = new C41180c(c31637v, c44870aa, c17299b, c8021f);
        C25212i c25212i2 = c17299b;
        C25093y c25093y2 = c31637v;
        C37042j c37042j = C37043a.BHa;
        C31759m c31759m2 = C44864h.AZw;
        C8086b c8086b = C8087a.BjE;
        C8223a c8223a = C8222h.BGL;
        C44895d c44895d = new C44895d(c25212i2, c25093y2, c37042j, c0076f, c41180c, c8112g, c44870aa, c31759m2, c8086b, C8223a.ejQ());
        C25052j.m39376p(c44907a, "<set-?>");
        c36654l.BnE = c44907a;
        C25052j.m39376p(c44895d, "components");
        c0073e.Brl = c44895d.Brl;
        C31637v[] c31637vArr = new C31637v[2];
        c31637vArr[0] = c31637v;
        C31637v c31637v2 = c17146e.Bab;
        C25052j.m39375o(c31637v2, "builtIns.builtInsModule");
        c31637vArr[1] = c31637v2;
        c31637v.mo51629a(c31637vArr);
        c31637v.mo51628a((C44871ac) c44907a.BFd);
        C36946i c36946i2 = new C36946i(c44895d.Brl, c44865j, (byte) 0);
        while (true) {
            try {
                weakReference = (WeakReference) AYu.putIfAbsent(c25072ah, new WeakReference(c36946i2));
                if (weakReference == null) {
                    c25072ah.AYG = null;
                    AppMethodBeat.m2505o(118895);
                    return c36946i2;
                }
                c36946i = (C36946i) weakReference.get();
                if (c36946i != null) {
                    break;
                }
                AYu.remove(c25072ah, weakReference);
            } finally {
                c25072ah.AYG = null;
                c36946i = 118895;
                AppMethodBeat.m2505o(118895);
            }
        }
        return c36946i;
    }
}
