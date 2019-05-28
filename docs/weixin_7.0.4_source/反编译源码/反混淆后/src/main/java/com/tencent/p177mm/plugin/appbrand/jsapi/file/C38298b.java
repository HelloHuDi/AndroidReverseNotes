package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.b */
abstract class C38298b<T extends C38299d> extends C10296a {
    static final ThreadPoolExecutor hJE = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private final T hJD;

    public C38298b(T t) {
        this.hJD = t;
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        hJE.submit(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102758);
                if (c2241c.isRunning()) {
                    C10396a c = C38298b.this.hJD.mo61002c(c2241c, jSONObject);
                    c2241c.mo6107M(i, C38298b.this.mo73393a(c2241c, c.aIm, c.values));
                    AppMethodBeat.m2505o(102758);
                    return;
                }
                AppMethodBeat.m2505o(102758);
            }
        });
    }
}
