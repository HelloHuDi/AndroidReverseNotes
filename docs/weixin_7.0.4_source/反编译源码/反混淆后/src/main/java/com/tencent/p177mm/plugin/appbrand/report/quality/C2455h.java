package com.tencent.p177mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.performance.C10681e;

/* renamed from: com.tencent.mm.plugin.appbrand.report.quality.h */
public enum C2455h {
    ;
    
    C10681e ivH;

    static {
        AppMethodBeat.m2505o(132698);
    }

    private C2455h(String str) {
        AppMethodBeat.m2504i(132697);
        this.ivH = new C10681e(Process.myPid());
        this.ivH.aKs();
        AppMethodBeat.m2505o(132697);
    }
}
