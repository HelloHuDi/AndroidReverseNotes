package com.tencent.p177mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandEmbedUI;

/* renamed from: com.tencent.mm.plugin.appbrand.task.a */
final class C46897a extends C45695j {
    final long iEd;
    private String iEe;

    C46897a(long j) {
        super(AppBrandEmbedUI.class, null, null);
        this.iEd = j;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: DI */
    public final void mo73486DI(String str) {
        AppMethodBeat.m2504i(132778);
        if (this.iEe.equals(str)) {
            this.iFt.clear();
            this.iFu.clear();
            this.iFv = C38519g.NIL;
            AppMethodBeat.m2505o(132778);
            return;
        }
        super.mo73486DI(str);
        AppMethodBeat.m2505o(132778);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo73490a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.m2504i(132777);
        if (this.iFt.keySet().isEmpty()) {
            this.iEe = str;
        }
        super.mo73490a(str, i, appBrandRemoteTaskController);
        AppMethodBeat.m2505o(132777);
    }
}
