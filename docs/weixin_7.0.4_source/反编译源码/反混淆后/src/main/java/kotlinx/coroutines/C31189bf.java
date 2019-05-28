package kotlinx.coroutines;

import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b \u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u0006\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, dWq = {"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bf */
public abstract class C31189bf<J extends C41157bc> extends C46851t implements C41155ap, C44612ay {
    public final J BQz;

    public C31189bf(J j) {
        C25052j.m39376p(j, "job");
        this.BQz = j;
    }

    public final boolean isActive() {
        return true;
    }

    public final C36628bk ell() {
        return null;
    }

    public final void dispose() {
        C41157bc c41157bc = this.BQz;
        if (c41157bc == null) {
            throw new C44941v("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        C16456bg c16456bg = (C16456bg) c41157bc;
        C25052j.m39376p(this, "node");
        C31189bf elt;
        do {
            elt = c16456bg.elt();
            if (elt instanceof C31189bf) {
                if (elt != this) {
                    return;
                }
            } else if ((elt instanceof C44612ay) && elt.ell() != null) {
                aQp();
                return;
            } else {
                return;
            }
        } while (!C16456bg.BPt.compareAndSet(c16456bg, elt, C16460bh.BQN));
    }
}
