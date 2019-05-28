package p000a.p010i.p011b.p012a.p014b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C31759m;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/components/RuntimeErrorReporter;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter;", "()V", "reportCannotInferVisibility", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "reportIncompleteHierarchy", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "unresolvedSuperClasses", "", "", "descriptors.runtime"})
/* renamed from: a.i.b.a.b.h */
public final class C44864h implements C31759m {
    public static final C44864h AZw = new C44864h();

    static {
        AppMethodBeat.m2504i(119048);
        AppMethodBeat.m2505o(119048);
    }

    private C44864h() {
    }

    /* renamed from: a */
    public final void mo51746a(C46865e c46865e, List<String> list) {
        AppMethodBeat.m2504i(119046);
        C25052j.m39376p(c46865e, "descriptor");
        C25052j.m39376p(list, "unresolvedSuperClasses");
        Throwable illegalStateException = new IllegalStateException("Incomplete hierarchy for class " + c46865e.dZg() + ", unresolved classes " + list);
        AppMethodBeat.m2505o(119046);
        throw illegalStateException;
    }

    /* renamed from: d */
    public final void mo51747d(C25085b c25085b) {
        AppMethodBeat.m2504i(119047);
        C25052j.m39376p(c25085b, "descriptor");
        Throwable illegalStateException = new IllegalStateException("Cannot infer visibility for ".concat(String.valueOf(c25085b)));
        AppMethodBeat.m2505o(119047);
        throw illegalStateException;
    }
}
