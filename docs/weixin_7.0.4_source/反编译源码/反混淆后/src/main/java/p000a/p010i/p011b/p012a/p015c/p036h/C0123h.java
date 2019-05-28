package p000a.p010i.p011b.p012a.p015c.p036h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import p000a.p001a.C25035t;
import p000a.p001a.C36913i;

/* renamed from: a.i.b.a.c.h.h */
public enum C0123h {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true);
    
    public static final Set<C0123h> BCu = null;
    public static final Set<C0123h> BCv = null;
    public static final C0124a BCw = null;
    private final boolean BCt;

    /* renamed from: a.i.b.a.c.h.h$a */
    public static final class C0124a {
        private C0124a() {
        }

        public /* synthetic */ C0124a(byte b) {
            this();
        }
    }

    private C0123h(boolean z) {
        this.BCt = z;
    }

    static {
        BCw = new C0124a();
        C0123h[] values = C0123h.values();
        Collection arrayList = new ArrayList();
        int length = values.length;
        int i;
        while (i < length) {
            C0123h c0123h = values[i];
            if (c0123h.BCt) {
                arrayList.add(c0123h);
            }
            i++;
        }
        BCu = C25035t.m39354o((List) arrayList);
        BCv = C36913i.m61685R(C0123h.values());
        AppMethodBeat.m2505o(121848);
    }
}
