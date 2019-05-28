package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import p000a.p005f.p006a.C17126b;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h.C17286a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.j */
public interface C25177j {

    /* renamed from: a.i.b.a.c.i.e.j$a */
    public static final class C8205a {
        /* renamed from: a */
        public static /* synthetic */ Collection m14503a(C25177j c25177j, C0136d c0136d, C17126b c17126b, int i) {
            AppMethodBeat.m2504i(122199);
            if ((i & 1) != 0) {
                c0136d = C0136d.BFL;
            }
            if ((i & 2) != 0) {
                C17286a c17286a = C31746h.BGd;
                c17126b = C17286a.ejN();
            }
            Collection a = c25177j.mo220a(c0136d, c17126b);
            AppMethodBeat.m2505o(122199);
            return a;
        }
    }

    /* renamed from: a */
    Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b);

    /* renamed from: b */
    Collection<C8083t> mo221b(C37022f c37022f, C8085a c8085a);

    /* renamed from: c */
    C0036h mo222c(C37022f c37022f, C8085a c8085a);
}
