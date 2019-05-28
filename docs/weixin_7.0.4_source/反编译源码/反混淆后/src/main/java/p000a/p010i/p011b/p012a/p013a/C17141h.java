package p000a.p010i.p011b.p012a.p013a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p037i.C8211f;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, dWq = {"createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "isDefault", "", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.a.h */
public final class C17141h {
    /* renamed from: a */
    public static /* synthetic */ C36943d m26513a(C25058e c25058e, C25085b c25085b) {
        AppMethodBeat.m2504i(119015);
        C36943d a = C17141h.m26514a(c25058e, c25085b, false);
        AppMethodBeat.m2505o(119015);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Missing block: B:22:0x0076, code skipped:
            if (p000a.p010i.p011b.p012a.p015c.p037i.C8211f.m14513ab(r0) == true) goto L_0x0078;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final <M extends Member> C36943d<M> m26514a(C25058e<? extends M> c25058e, C25085b c25085b, boolean z) {
        C46867w dZS;
        Object obj;
        AppMethodBeat.m2504i(119014);
        C25052j.m39376p(c25058e, "receiver$0");
        C25052j.m39376p(c25085b, "descriptor");
        List dYV = c25085b.dYV();
        C25052j.m39375o(dYV, "descriptor.valueParameters");
        Iterable<C41399au> iterable = dYV;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (C41399au c41399au : iterable) {
                C25052j.m39375o(c41399au, "it");
                dZS = c41399au.dZS();
                C25052j.m39375o(dZS, "it.type");
                if (C8211f.m14513ab(dZS)) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        if (obj == null) {
            dZS = c25085b.dYT();
            if (dZS == null || !C8211f.m14513ab(dZS)) {
                if (!(c25058e instanceof C44860c)) {
                    C41396ak dYQ = c25085b.dYQ();
                    if (dYQ != null) {
                        dZS = dYQ.dZS();
                        if (dZS != null) {
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    C36943d c17139g = new C17139g(c25085b, c25058e, z);
                    AppMethodBeat.m2505o(119014);
                    return c17139g;
                }
                C36943d<M> c36943d = c25058e;
                AppMethodBeat.m2505o(119014);
                return c36943d;
            }
        }
        obj = 1;
        if (obj == null) {
        }
    }
}
