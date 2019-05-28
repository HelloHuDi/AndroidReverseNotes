package com.tencent.p177mm.plugin.appbrand.widget.p1236f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AutoDismissRunner;", "Ljava/lang/Runnable;", "toast", "Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "(Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.f.d */
final class C27393d implements Runnable {
    private final WeakReference<C38592c> iuM;

    public C27393d(C38592c c38592c) {
        C25052j.m39376p(c38592c, "toast");
        AppMethodBeat.m2504i(135267);
        this.iuM = new WeakReference(c38592c);
        AppMethodBeat.m2505o(135267);
    }

    public final void run() {
        AppMethodBeat.m2504i(135266);
        C38592c c38592c = (C38592c) this.iuM.get();
        if (c38592c != null) {
            c38592c.dismiss();
            AppMethodBeat.m2505o(135266);
            return;
        }
        AppMethodBeat.m2505o(135266);
    }
}
