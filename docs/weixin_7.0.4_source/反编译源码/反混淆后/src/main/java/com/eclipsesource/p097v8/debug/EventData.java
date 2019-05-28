package com.eclipsesource.p097v8.debug;

import com.eclipsesource.p097v8.Releasable;
import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.EventData */
public class EventData implements Releasable {
    protected V8Object v8Object;

    EventData(V8Object v8Object) {
        AppMethodBeat.m2504i(74849);
        this.v8Object = v8Object.twin();
        AppMethodBeat.m2505o(74849);
    }

    public void release() {
        AppMethodBeat.m2504i(74850);
        if (!this.v8Object.isReleased()) {
            this.v8Object.release();
        }
        AppMethodBeat.m2505o(74850);
    }
}
