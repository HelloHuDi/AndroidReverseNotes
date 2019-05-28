package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bl */
public final class C41361bl implements C41155ap, C44622m {
    public static final C41361bl BQP = new C41361bl();

    static {
        AppMethodBeat.m2504i(118506);
        AppMethodBeat.m2505o(118506);
    }

    private C41361bl() {
    }

    public final void dispose() {
    }

    /* renamed from: x */
    public final boolean mo41384x(Throwable th) {
        AppMethodBeat.m2504i(118505);
        C25052j.m39376p(th, "cause");
        AppMethodBeat.m2505o(118505);
        return false;
    }

    public final String toString() {
        return "NonDisposableHandle";
    }
}
