package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.e;

public enum h {
    ;
    
    e ivH;

    static {
        AppMethodBeat.o(132698);
    }

    private h(String str) {
        AppMethodBeat.i(132697);
        this.ivH = new e(Process.myPid());
        this.ivH.aKs();
        AppMethodBeat.o(132697);
    }
}
