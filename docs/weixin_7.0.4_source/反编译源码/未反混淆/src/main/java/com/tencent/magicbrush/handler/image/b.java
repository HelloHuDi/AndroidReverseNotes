package com.tencent.magicbrush.handler.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

enum b {
    ;
    
    private static int bUn;
    ExecutorService bUo;

    static {
        bUn = Runtime.getRuntime().availableProcessors() + 1;
        AppMethodBeat.o(115983);
    }

    private b(String str) {
        AppMethodBeat.i(115982);
        this.bUo = null;
        this.bUo = Executors.newFixedThreadPool(Math.max(bUn, 5));
        AppMethodBeat.o(115982);
    }
}
