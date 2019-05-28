package p000a.p005f.p007b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lkotlin/jvm/internal/PackageReference;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"})
/* renamed from: a.f.b.o */
public final class C44854o implements C41377d {
    private final Class<?> AVA;
    private final String gTy;

    public C44854o(Class<?> cls, String str) {
        C25052j.m39376p(cls, "jClass");
        C25052j.m39376p(str, "moduleName");
        AppMethodBeat.m2504i(56239);
        this.AVA = cls;
        this.gTy = str;
        AppMethodBeat.m2505o(56239);
    }

    public final Class<?> dWH() {
        return this.AVA;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(56236);
        if ((obj instanceof C44854o) && C25052j.m39373j(this.AVA, ((C44854o) obj).AVA)) {
            AppMethodBeat.m2505o(56236);
            return true;
        }
        AppMethodBeat.m2505o(56236);
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(56238);
        String str = this.AVA.toString() + " (Kotlin reflection is not available)";
        AppMethodBeat.m2505o(56238);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(56237);
        int hashCode = this.AVA.hashCode();
        AppMethodBeat.m2505o(56237);
        return hashCode;
    }
}
