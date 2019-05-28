package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

final class cn extends TimerTask {
    private /* synthetic */ Runnable a;

    cn(cm cmVar, Runnable runnable) {
        this.a = runnable;
    }

    public final void run() {
        AppMethodBeat.i(98654);
        this.a.run();
        AppMethodBeat.o(98654);
    }
}
