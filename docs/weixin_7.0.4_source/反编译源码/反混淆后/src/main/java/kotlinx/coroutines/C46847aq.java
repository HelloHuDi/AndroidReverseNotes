package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.aq */
final class C46847aq extends C25030g {
    private final C41155ap BQi;

    public C46847aq(C41155ap c41155ap) {
        C25052j.m39376p(c41155ap, "handle");
        AppMethodBeat.m2504i(118370);
        this.BQi = c41155ap;
        AppMethodBeat.m2505o(118370);
    }

    /* renamed from: am */
    public final /* synthetic */ Object mo50am(Object obj) {
        AppMethodBeat.m2504i(118368);
        mo41930v((Throwable) obj);
        C37091y c37091y = C37091y.AUy;
        AppMethodBeat.m2505o(118368);
        return c37091y;
    }

    /* renamed from: v */
    public final void mo41930v(Throwable th) {
        AppMethodBeat.m2504i(118367);
        this.BQi.dispose();
        AppMethodBeat.m2505o(118367);
    }

    public final String toString() {
        AppMethodBeat.m2504i(118369);
        String str = "DisposeOnCancel[" + this.BQi + ']';
        AppMethodBeat.m2505o(118369);
        return str;
    }
}
