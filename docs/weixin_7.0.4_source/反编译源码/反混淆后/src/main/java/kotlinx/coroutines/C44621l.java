package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/AbstractContinuation;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/AbstractContinuation;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.l */
public final class C44621l extends C16455be<C41157bc> {
    public final C46947a<?> BPz;

    /* renamed from: am */
    public final /* synthetic */ Object mo50am(Object obj) {
        AppMethodBeat.m2504i(118540);
        mo30347v((Throwable) obj);
        C37091y c37091y = C37091y.AUy;
        AppMethodBeat.m2505o(118540);
        return c37091y;
    }

    public C44621l(C41157bc c41157bc, C46947a<?> c46947a) {
        C25052j.m39376p(c41157bc, "parent");
        C25052j.m39376p(c46947a, "child");
        super(c41157bc);
        AppMethodBeat.m2504i(118542);
        this.BPz = c46947a;
        AppMethodBeat.m2505o(118542);
    }

    /* renamed from: v */
    public final void mo30347v(Throwable th) {
        AppMethodBeat.m2504i(118539);
        C46947a c46947a = this.BPz;
        Throwable a = C46947a.m89802a(this.BQz);
        Object obj;
        do {
            obj = c46947a.BPs;
            if (!(obj instanceof C36629bm)) {
                break;
            }
        } while (!c46947a.mo76257a((C36629bm) obj, new C44620k(c46947a, a), 0));
        AppMethodBeat.m2505o(118539);
    }

    public final String toString() {
        AppMethodBeat.m2504i(118541);
        String str = "ChildContinuation[" + this.BPz + ']';
        AppMethodBeat.m2505o(118541);
        return str;
    }
}
