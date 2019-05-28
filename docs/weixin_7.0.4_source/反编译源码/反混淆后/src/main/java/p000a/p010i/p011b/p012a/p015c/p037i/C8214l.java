package p000a.p010i.p011b.p012a.p015c.p037i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;

/* renamed from: a.i.b.a.c.i.l */
public final class C8214l {
    /* renamed from: n */
    public static final C25085b m14516n(Collection<? extends C25085b> collection) {
        AppMethodBeat.m2504i(122041);
        C25052j.m39376p(collection, "descriptors");
        Object obj = !collection.isEmpty() ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.m2505o(122041);
            throw assertionError;
        }
        C25085b c25085b;
        C25085b c25085b2 = null;
        Iterator it = collection.iterator();
        while (true) {
            c25085b = c25085b2;
            if (!it.hasNext()) {
                break;
            }
            c25085b2 = (C25085b) it.next();
            if (c25085b != null) {
                Integer b = C8051ay.m14225b(c25085b.dYf(), c25085b2.dYf());
                if (b == null || b.intValue() >= 0) {
                    c25085b2 = c25085b;
                }
            }
        }
        if (c25085b == null) {
            C25052j.dWJ();
        }
        AppMethodBeat.m2505o(122041);
        return c25085b;
    }
}
