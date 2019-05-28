package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EventData implements Releasable {
    protected V8Object v8Object;

    EventData(V8Object v8Object) {
        AppMethodBeat.i(74849);
        this.v8Object = v8Object.twin();
        AppMethodBeat.o(74849);
    }

    public void release() {
        AppMethodBeat.i(74850);
        if (!this.v8Object.isReleased()) {
            this.v8Object.release();
        }
        AppMethodBeat.o(74850);
    }
}
