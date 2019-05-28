package com.eclipsesource.p097v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.V8ContextSessionMgr */
final class V8ContextSessionMgr {
    private V8ContextWrapper currentContext;
    /* renamed from: v8 */
    private final C45010V8 f4045v8;

    V8ContextSessionMgr(C45010V8 c45010v8) {
        this.f4045v8 = c45010v8;
    }

    public final void enterContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.m2504i(75448);
        if (v8ContextWrapper == null) {
            AppMethodBeat.m2505o(75448);
        } else if (v8ContextWrapper.equals(this.currentContext)) {
            AppMethodBeat.m2505o(75448);
        } else {
            this.f4045v8.switchV8Context(v8ContextWrapper.getPtr());
            this.currentContext = v8ContextWrapper;
            AppMethodBeat.m2505o(75448);
        }
    }

    public final void releaseContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.m2504i(75449);
        if (v8ContextWrapper == null) {
            AppMethodBeat.m2505o(75449);
            return;
        }
        this.f4045v8.releaseV8Context(v8ContextWrapper.getPtr());
        AppMethodBeat.m2505o(75449);
    }
}
