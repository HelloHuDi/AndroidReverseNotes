package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class b<T extends d> extends a {
    static final ThreadPoolExecutor hJE = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private final T hJD;

    public b(T t) {
        this.hJD = t;
    }

    public final void a(final c cVar, final JSONObject jSONObject, final int i) {
        hJE.submit(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102758);
                if (cVar.isRunning()) {
                    f.a c = b.this.hJD.c(cVar, jSONObject);
                    cVar.M(i, b.this.a(cVar, c.aIm, c.values));
                    AppMethodBeat.o(102758);
                    return;
                }
                AppMethodBeat.o(102758);
            }
        });
    }
}
