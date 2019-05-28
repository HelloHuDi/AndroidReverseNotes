package com.tencent.mm.plugin.appbrand.m;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.b.a;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.m.a.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d implements a, e.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!d.class.desiredAssertionStatus());
    private final q gNC;
    private final i hvJ;
    private final Map<Integer, Integer> ipS;
    private final ExecutorService mExecutorService = Executors.newCachedThreadPool();

    static {
        AppMethodBeat.i(102180);
        AppMethodBeat.o(102180);
    }

    public d(q qVar, i iVar) {
        AppMethodBeat.i(102172);
        this.gNC = qVar;
        this.hvJ = iVar;
        e.a(this, qVar);
        this.ipS = new ConcurrentHashMap();
        AppMethodBeat.o(102172);
    }

    public final void aIS() {
        AppMethodBeat.i(102173);
        ab.i("MicroMsg.NodeJavaBroker", "shutdown");
        this.mExecutorService.shutdown();
        for (Entry key : this.ipS.entrySet()) {
            unListen(((Integer) key.getKey()).intValue());
        }
        this.ipS.clear();
        AppMethodBeat.o(102173);
    }

    @JavascriptInterface
    public void req(int i, final String str, final int i2) {
        AppMethodBeat.i(102174);
        ab.v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
        com.tencent.mm.plugin.appbrand.m.a.a pp = b.pp(i);
        if (!$assertionsDisabled && pp == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(102174);
            throw assertionError;
        } else if (pp instanceof b) {
            final b bVar = (b) pp;
            this.mExecutorService.execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102171);
                    bVar.a(str, new c(d.this.gNC, i2, d.this));
                    AppMethodBeat.o(102171);
                }
            });
            AppMethodBeat.o(102174);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("req asynchronously, but target cmd not async!");
            AppMethodBeat.o(102174);
            throw illegalStateException;
        }
    }

    public final void Y(int i, String str) {
        AppMethodBeat.i(102175);
        if (i <= 0) {
            AppMethodBeat.o(102175);
            return;
        }
        this.hvJ.evaluateJavascript(String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[]{Integer.valueOf(i), str}), null);
        AppMethodBeat.o(102175);
    }

    @JavascriptInterface
    public String reqSync(int i, String str) {
        AppMethodBeat.i(102176);
        com.tencent.mm.plugin.appbrand.m.a.a pp = b.pp(i);
        if (!$assertionsDisabled && pp == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(102176);
            throw assertionError;
        } else if (pp instanceof com.tencent.mm.plugin.appbrand.m.a.d) {
            String a = ((com.tencent.mm.plugin.appbrand.m.a.d) pp).a(str, new c(this.gNC));
            AppMethodBeat.o(102176);
            return a;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("req synchronously, but target cmd not sync!");
            AppMethodBeat.o(102176);
            throw illegalStateException;
        }
    }

    @JavascriptInterface
    public void listen(int i, int i2) {
        AppMethodBeat.i(102177);
        e pq = e.pq(i);
        if (pq == null) {
            ab.e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
            AppMethodBeat.o(102177);
            return;
        }
        pq.listen(i2);
        this.ipS.put(Integer.valueOf(i2), Integer.valueOf(i));
        AppMethodBeat.o(102177);
    }

    @JavascriptInterface
    public void unListen(int i) {
        AppMethodBeat.i(102178);
        Integer num = (Integer) this.ipS.get(Integer.valueOf(i));
        if (num == null) {
            AppMethodBeat.o(102178);
            return;
        }
        ab.v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", Integer.valueOf(num.intValue()), Integer.valueOf(i));
        e pq = e.pq(r0);
        if (pq == null) {
            ab.e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
            AppMethodBeat.o(102178);
            return;
        }
        pq.unListen(i);
        this.ipS.remove(Integer.valueOf(i));
        AppMethodBeat.o(102178);
    }

    public final void d(int i, Map<String, Object> map) {
        AppMethodBeat.i(102179);
        com.tencent.luggage.g.i.d(map);
        String iVar = new com.tencent.mm.aa.i((Map) map).toString();
        this.hvJ.evaluateJavascript(String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[]{Integer.valueOf(i), iVar}), null);
        AppMethodBeat.o(102179);
    }
}
