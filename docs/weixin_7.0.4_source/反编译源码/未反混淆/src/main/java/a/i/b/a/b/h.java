package a.i.b.a.b;

import a.f.b.j;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.e;
import a.i.b.a.c.j.a.m;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/components/RuntimeErrorReporter;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter;", "()V", "reportCannotInferVisibility", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "reportIncompleteHierarchy", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "unresolvedSuperClasses", "", "", "descriptors.runtime"})
public final class h implements m {
    public static final h AZw = new h();

    static {
        AppMethodBeat.i(119048);
        AppMethodBeat.o(119048);
    }

    private h() {
    }

    public final void a(e eVar, List<String> list) {
        AppMethodBeat.i(119046);
        j.p(eVar, "descriptor");
        j.p(list, "unresolvedSuperClasses");
        Throwable illegalStateException = new IllegalStateException("Incomplete hierarchy for class " + eVar.dZg() + ", unresolved classes " + list);
        AppMethodBeat.o(119046);
        throw illegalStateException;
    }

    public final void d(b bVar) {
        AppMethodBeat.i(119047);
        j.p(bVar, "descriptor");
        Throwable illegalStateException = new IllegalStateException("Cannot infer visibility for ".concat(String.valueOf(bVar)));
        AppMethodBeat.o(119047);
        throw illegalStateException;
    }
}
