package com.tencent.p177mm.loader.p246e.p247b;

import android.os.Looper;
import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.p246e.p247b.C1754d.C1755a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0004H$¢\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00042\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H&J$\u0010\u0013\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00042\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H&R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "R", "", "weakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getWeakHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setWeakHolder", "onResourceReady", "", "resource", "(Ljava/lang/Object;)V", "onResourceReadyUI", "viewWeakHolder", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "updateBackgroundUI", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.e.b.c */
public abstract class C1752c<R> {
    public C32731f<?> eQw;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "R", "run"})
    /* renamed from: com.tencent.mm.loader.e.b.c$a */
    static final class C1753a implements Runnable {
        final /* synthetic */ C1752c eQx;
        final /* synthetic */ Object eQy;

        C1753a(C1752c c1752c, Object obj) {
            this.eQx = c1752c;
            this.eQy = obj;
        }

        public final void run() {
            this.eQx.mo5286a(this.eQy, this.eQx.eQw);
            C1755a c1755a = C1754d.eQA;
            C1754d TN = C1755a.m3619TN();
            C1752c c1752c = this.eQx;
            if (c1752c == null) {
                throw new C44941v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
            }
            TN.mo5289a(c1752c);
        }
    }

    /* renamed from: a */
    public abstract void mo5285a(C32731f<?> c32731f, C45421f<?, ?> c45421f);

    /* renamed from: a */
    public abstract void mo5286a(R r, C32731f<?> c32731f);

    public C1752c(C32731f<?> c32731f) {
        C25052j.m39376p(c32731f, "weakHolder");
        this.eQw = c32731f;
    }

    /* renamed from: aP */
    public final void mo5287aP(R r) {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        C25052j.m39375o(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread()) {
            mo5286a((Object) r, this.eQw);
            C1755a c1755a = C1754d.eQA;
            C1754d TN = C1755a.m3619TN();
            if (this == null) {
                throw new C44941v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
            }
            TN.mo5289a(this);
            return;
        }
        C5004al.m7441d(new C1753a(this, r));
    }
}
