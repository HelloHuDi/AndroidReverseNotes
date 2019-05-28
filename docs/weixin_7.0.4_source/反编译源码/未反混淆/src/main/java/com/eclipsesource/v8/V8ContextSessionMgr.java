package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class V8ContextSessionMgr {
    private V8ContextWrapper currentContext;
    private final V8 v8;

    V8ContextSessionMgr(V8 v8) {
        this.v8 = v8;
    }

    public final void enterContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.i(75448);
        if (v8ContextWrapper == null) {
            AppMethodBeat.o(75448);
        } else if (v8ContextWrapper.equals(this.currentContext)) {
            AppMethodBeat.o(75448);
        } else {
            this.v8.switchV8Context(v8ContextWrapper.getPtr());
            this.currentContext = v8ContextWrapper;
            AppMethodBeat.o(75448);
        }
    }

    public final void releaseContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.i(75449);
        if (v8ContextWrapper == null) {
            AppMethodBeat.o(75449);
            return;
        }
        this.v8.releaseV8Context(v8ContextWrapper.getPtr());
        AppMethodBeat.o(75449);
    }
}
