package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class n extends be<bg> implements m {
    public final o BPA;

    public final /* synthetic */ Object am(Object obj) {
        AppMethodBeat.i(118509);
        v((Throwable) obj);
        y yVar = y.AUy;
        AppMethodBeat.o(118509);
        return yVar;
    }

    public n(bg bgVar, o oVar) {
        j.p(bgVar, "parent");
        j.p(oVar, "childJob");
        super(bgVar);
        AppMethodBeat.i(118512);
        this.BPA = oVar;
        AppMethodBeat.o(118512);
    }

    public final void v(Throwable th) {
        AppMethodBeat.i(118508);
        this.BPA.a((bn) this.BQz);
        AppMethodBeat.o(118508);
    }

    public final boolean x(Throwable th) {
        AppMethodBeat.i(118510);
        j.p(th, "cause");
        bg bgVar = (bg) this.BQz;
        j.p(th, "cause");
        if (bgVar.ei(th)) {
            AppMethodBeat.o(118510);
            return true;
        }
        AppMethodBeat.o(118510);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(118511);
        String str = "ChildHandle[" + this.BPA + ']';
        AppMethodBeat.o(118511);
        return str;
    }
}
