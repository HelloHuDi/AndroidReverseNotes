package com.tencent.mm.loader.e.b;

import a.f.b.j;
import a.l;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.loader.f;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0014¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fH\u0016J$\u0010\r\u001a\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fH\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/loader/impr/target/EmptyTarget;", "R", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "()V", "onResourceReadyUI", "", "resource", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "updateBackgroundUI", "request", "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"})
public final class a<R> extends c<R> {
    private static final String TAG = TAG;
    public static final a eQv = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/loader/impr/target/EmptyTarget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public a() {
        super(new f(null));
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(R r, f<?> fVar) {
        j.p(fVar, "viewWeakHolder");
    }

    public final void a(f<?> fVar, f<?, ?> fVar2) {
        j.p(fVar, "viewWeakHolder");
        j.p(fVar2, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
    }
}
