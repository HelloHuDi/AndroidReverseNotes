package com.tencent.mm.loader.e.b;

import a.f.b.j;
import a.l;
import a.v;
import android.os.Looper;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.al;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0004H$¢\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00042\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H&J$\u0010\u0013\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00042\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H&R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "R", "", "weakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getWeakHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setWeakHolder", "onResourceReady", "", "resource", "(Ljava/lang/Object;)V", "onResourceReadyUI", "viewWeakHolder", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "updateBackgroundUI", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "libimageloader_release"})
public abstract class c<R> {
    public f<?> eQw;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "R", "run"})
    static final class a implements Runnable {
        final /* synthetic */ c eQx;
        final /* synthetic */ Object eQy;

        a(c cVar, Object obj) {
            this.eQx = cVar;
            this.eQy = obj;
        }

        public final void run() {
            this.eQx.a(this.eQy, this.eQx.eQw);
            com.tencent.mm.loader.e.b.d.a aVar = d.eQA;
            d TN = com.tencent.mm.loader.e.b.d.a.TN();
            c cVar = this.eQx;
            if (cVar == null) {
                throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
            }
            TN.a(cVar);
        }
    }

    public abstract void a(f<?> fVar, f<?, ?> fVar2);

    public abstract void a(R r, f<?> fVar);

    public c(f<?> fVar) {
        j.p(fVar, "weakHolder");
        this.eQw = fVar;
    }

    public final void aP(R r) {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        j.o(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread()) {
            a((Object) r, this.eQw);
            com.tencent.mm.loader.e.b.d.a aVar = d.eQA;
            d TN = com.tencent.mm.loader.e.b.d.a.TN();
            if (this == null) {
                throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
            }
            TN.a(this);
            return;
        }
        al.d(new a(this, r));
    }
}
