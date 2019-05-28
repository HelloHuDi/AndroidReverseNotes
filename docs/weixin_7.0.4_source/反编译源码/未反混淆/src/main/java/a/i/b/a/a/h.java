package a.i.b.a.a;

import a.f.b.j;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.b;
import a.i.b.a.c.i.f;
import a.i.b.a.c.l.w;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, dWq = {"createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "isDefault", "", "kotlin-reflect-api"})
public final class h {
    public static /* synthetic */ d a(e eVar, b bVar) {
        AppMethodBeat.i(119015);
        d a = a(eVar, bVar, false);
        AppMethodBeat.o(119015);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Missing block: B:22:0x0076, code skipped:
            if (a.i.b.a.c.i.f.ab(r0) == true) goto L_0x0078;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <M extends Member> d<M> a(e<? extends M> eVar, b bVar, boolean z) {
        w dZS;
        Object obj;
        AppMethodBeat.i(119014);
        j.p(eVar, "receiver$0");
        j.p(bVar, "descriptor");
        List dYV = bVar.dYV();
        j.o(dYV, "descriptor.valueParameters");
        Iterable<au> iterable = dYV;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (au auVar : iterable) {
                j.o(auVar, "it");
                dZS = auVar.dZS();
                j.o(dZS, "it.type");
                if (f.ab(dZS)) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        if (obj == null) {
            dZS = bVar.dYT();
            if (dZS == null || !f.ab(dZS)) {
                if (!(eVar instanceof c)) {
                    ak dYQ = bVar.dYQ();
                    if (dYQ != null) {
                        dZS = dYQ.dZS();
                        if (dZS != null) {
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    d gVar = new g(bVar, eVar, z);
                    AppMethodBeat.o(119014);
                    return gVar;
                }
                d<M> dVar = eVar;
                AppMethodBeat.o(119014);
                return dVar;
            }
        }
        obj = 1;
        if (obj == null) {
        }
    }
}
