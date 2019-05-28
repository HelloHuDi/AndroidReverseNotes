package com.tencent.magicbrush.handler.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.magicbrush.handler.image.b */
enum C37422b {
    ;
    
    private static int bUn;
    ExecutorService bUo;

    static {
        bUn = Runtime.getRuntime().availableProcessors() + 1;
        AppMethodBeat.m2505o(115983);
    }

    private C37422b(String str) {
        AppMethodBeat.m2504i(115982);
        this.bUo = null;
        this.bUo = Executors.newFixedThreadPool(Math.max(bUn, 5));
        AppMethodBeat.m2505o(115982);
    }
}
