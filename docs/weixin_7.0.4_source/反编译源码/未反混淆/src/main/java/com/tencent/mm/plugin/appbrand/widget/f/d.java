package com.tencent.mm.plugin.appbrand.widget.f;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AutoDismissRunner;", "Ljava/lang/Runnable;", "toast", "Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "(Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "", "plugin-appbrand-integration_release"})
final class d implements Runnable {
    private final WeakReference<c> iuM;

    public d(c cVar) {
        j.p(cVar, "toast");
        AppMethodBeat.i(135267);
        this.iuM = new WeakReference(cVar);
        AppMethodBeat.o(135267);
    }

    public final void run() {
        AppMethodBeat.i(135266);
        c cVar = (c) this.iuM.get();
        if (cVar != null) {
            cVar.dismiss();
            AppMethodBeat.o(135266);
            return;
        }
        AppMethodBeat.o(135266);
    }
}
