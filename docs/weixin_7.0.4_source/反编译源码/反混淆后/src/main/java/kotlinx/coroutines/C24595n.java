package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.n */
public final class C24595n extends C16455be<C16456bg> implements C44622m {
    public final C31194o BPA;

    /* renamed from: am */
    public final /* synthetic */ Object mo50am(Object obj) {
        AppMethodBeat.m2504i(118509);
        mo30347v((Throwable) obj);
        C37091y c37091y = C37091y.AUy;
        AppMethodBeat.m2505o(118509);
        return c37091y;
    }

    public C24595n(C16456bg c16456bg, C31194o c31194o) {
        C25052j.m39376p(c16456bg, "parent");
        C25052j.m39376p(c31194o, "childJob");
        super(c16456bg);
        AppMethodBeat.m2504i(118512);
        this.BPA = c31194o;
        AppMethodBeat.m2505o(118512);
    }

    /* renamed from: v */
    public final void mo30347v(Throwable th) {
        AppMethodBeat.m2504i(118508);
        this.BPA.mo30331a((C6101bn) this.BQz);
        AppMethodBeat.m2505o(118508);
    }

    /* renamed from: x */
    public final boolean mo41384x(Throwable th) {
        AppMethodBeat.m2504i(118510);
        C25052j.m39376p(th, "cause");
        C16456bg c16456bg = (C16456bg) this.BQz;
        C25052j.m39376p(th, "cause");
        if (c16456bg.mo30333ei(th)) {
            AppMethodBeat.m2505o(118510);
            return true;
        }
        AppMethodBeat.m2505o(118510);
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(118511);
        String str = "ChildHandle[" + this.BPA + ']';
        AppMethodBeat.m2505o(118511);
        return str;
    }
}
