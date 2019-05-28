package com.tencent.p177mm.plugin.appbrand.p322m;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19596a;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19597c;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C27190b;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C27190b.C27191a;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42626d;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e.C38438a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.mm.plugin.appbrand.m.d */
public class C45651d implements C27191a, C38438a {
    static final /* synthetic */ boolean $assertionsDisabled = (!C45651d.class.desiredAssertionStatus());
    private final C38492q gNC;
    private final C6747i hvJ;
    private final Map<Integer, Integer> ipS;
    private final ExecutorService mExecutorService = Executors.newCachedThreadPool();

    static {
        AppMethodBeat.m2504i(102180);
        AppMethodBeat.m2505o(102180);
    }

    public C45651d(C38492q c38492q, C6747i c6747i) {
        AppMethodBeat.m2504i(102172);
        this.gNC = c38492q;
        this.hvJ = c6747i;
        C38442e.m65037a(this, c38492q);
        this.ipS = new ConcurrentHashMap();
        AppMethodBeat.m2505o(102172);
    }

    public final void aIS() {
        AppMethodBeat.m2504i(102173);
        C4990ab.m7416i("MicroMsg.NodeJavaBroker", "shutdown");
        this.mExecutorService.shutdown();
        for (Entry key : this.ipS.entrySet()) {
            unListen(((Integer) key.getKey()).intValue());
        }
        this.ipS.clear();
        AppMethodBeat.m2505o(102173);
    }

    @JavascriptInterface
    public void req(int i, final String str, final int i2) {
        AppMethodBeat.m2504i(102174);
        C4990ab.m7419v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
        C19596a pp = C2385b.m4646pp(i);
        if (!$assertionsDisabled && pp == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(102174);
            throw assertionError;
        } else if (pp instanceof C27190b) {
            final C27190b c27190b = (C27190b) pp;
            this.mExecutorService.execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(102171);
                    c27190b.mo44859a(str, new C19597c(C45651d.this.gNC, i2, C45651d.this));
                    AppMethodBeat.m2505o(102171);
                }
            });
            AppMethodBeat.m2505o(102174);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("req asynchronously, but target cmd not async!");
            AppMethodBeat.m2505o(102174);
            throw illegalStateException;
        }
    }

    /* renamed from: Y */
    public final void mo44860Y(int i, String str) {
        AppMethodBeat.m2504i(102175);
        if (i <= 0) {
            AppMethodBeat.m2505o(102175);
            return;
        }
        this.hvJ.evaluateJavascript(String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[]{Integer.valueOf(i), str}), null);
        AppMethodBeat.m2505o(102175);
    }

    @JavascriptInterface
    public String reqSync(int i, String str) {
        AppMethodBeat.m2504i(102176);
        C19596a pp = C2385b.m4646pp(i);
        if (!$assertionsDisabled && pp == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(102176);
            throw assertionError;
        } else if (pp instanceof C42626d) {
            String a = ((C42626d) pp).mo68066a(str, new C19597c(this.gNC));
            AppMethodBeat.m2505o(102176);
            return a;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("req synchronously, but target cmd not sync!");
            AppMethodBeat.m2505o(102176);
            throw illegalStateException;
        }
    }

    @JavascriptInterface
    public void listen(int i, int i2) {
        AppMethodBeat.m2504i(102177);
        C42627e pq = C38442e.m65039pq(i);
        if (pq == null) {
            C4990ab.m7412e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
            AppMethodBeat.m2505o(102177);
            return;
        }
        pq.listen(i2);
        this.ipS.put(Integer.valueOf(i2), Integer.valueOf(i));
        AppMethodBeat.m2505o(102177);
    }

    @JavascriptInterface
    public void unListen(int i) {
        AppMethodBeat.m2504i(102178);
        Integer num = (Integer) this.ipS.get(Integer.valueOf(i));
        if (num == null) {
            AppMethodBeat.m2505o(102178);
            return;
        }
        C4990ab.m7419v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", Integer.valueOf(num.intValue()), Integer.valueOf(i));
        C42627e pq = C38442e.m65039pq(r0);
        if (pq == null) {
            C4990ab.m7412e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
            AppMethodBeat.m2505o(102178);
            return;
        }
        pq.unListen(i);
        this.ipS.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(102178);
    }

    /* renamed from: d */
    public final void mo61135d(int i, Map<String, Object> map) {
        AppMethodBeat.m2504i(102179);
        C32192i.m52509d(map);
        String c41726i = new C41726i((Map) map).toString();
        this.hvJ.evaluateJavascript(String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[]{Integer.valueOf(i), c41726i}), null);
        AppMethodBeat.m2505o(102179);
    }
}
