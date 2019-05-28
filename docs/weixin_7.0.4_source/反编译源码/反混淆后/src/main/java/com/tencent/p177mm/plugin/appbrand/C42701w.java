package com.tencent.p177mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C26065u;
import com.tencent.p177mm.p224d.p225a.C32488l;
import com.tencent.p177mm.p224d.p225a.C37673t;
import com.tencent.p177mm.p224d.p225a.C37673t.C1492a;
import com.tencent.p177mm.p224d.p225a.C37673t.C376753;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.p297h.C26901k;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.w */
public class C42701w {
    C26065u ciG = new C25081();
    C38492q gNC;
    C26901k gQi;
    public C37673t gQj;
    private ArrayList<C1492a> gQk;

    /* renamed from: com.tencent.mm.plugin.appbrand.w$1 */
    class C25081 extends C26065u {
        C25081() {
        }

        /* renamed from: CC */
        public final int mo6449CC() {
            AppMethodBeat.m2504i(86779);
            if (C42701w.this.gQi != null) {
                int nativeBufferId = C42701w.this.gQi.getNativeBufferId();
                AppMethodBeat.m2505o(86779);
                return nativeBufferId;
            }
            AppMethodBeat.m2505o(86779);
            return 0;
        }

        /* renamed from: gq */
        public final ByteBuffer mo6451gq(int i) {
            AppMethodBeat.m2504i(86780);
            if (C42701w.this.gQi != null) {
                ByteBuffer nativeBuffer = C42701w.this.gQi.getNativeBuffer(i);
                AppMethodBeat.m2505o(86780);
                return nativeBuffer;
            }
            AppMethodBeat.m2505o(86780);
            return null;
        }

        /* renamed from: a */
        public final void mo6450a(int i, ByteBuffer byteBuffer) {
            AppMethodBeat.m2504i(86781);
            if (C42701w.this.gQi != null) {
                C42701w.this.gQi.setNativeBuffer(i, byteBuffer);
            }
            AppMethodBeat.m2505o(86781);
        }

        /* renamed from: h */
        public final void mo6452h(int i, String str) {
            AppMethodBeat.m2504i(86782);
            C42701w.this.gNC.aBx().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[]{Integer.valueOf(i), str}), null);
            AppMethodBeat.m2505o(86782);
        }
    }

    public C42701w(C38492q c38492q) {
        AppMethodBeat.m2504i(86783);
        this.gNC = c38492q;
        this.gQi = (C26901k) c38492q.aBx().mo14970af(C26901k.class);
        this.gQj = auv();
        this.gQk = new ArrayList();
        this.gQk.add(new C1492a(this.gNC.auf() + "wxa_library/bootstrap_j2v8_worker.js", C45672d.m84370Eb("wxa_library/bootstrap_j2v8_worker.js")));
        c38492q.aBx().addJavascriptInterface(this, "WeixinWorker");
        AppMethodBeat.m2505o(86783);
    }

    /* Access modifiers changed, original: protected */
    public C37673t auv() {
        AppMethodBeat.m2504i(86784);
        C37673t c37673t = new C37673t(this.ciG);
        AppMethodBeat.m2505o(86784);
        return c37673t;
    }

    @JavascriptInterface
    public int create(String str) {
        AppMethodBeat.m2504i(86785);
        ArrayList arrayList = new ArrayList(this.gQk);
        mo68097b(arrayList, str);
        arrayList.add(mo68101xi(str));
        int e = this.gQj.mo60499e(arrayList);
        AppMethodBeat.m2505o(86785);
        return e;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xi */
    public C1492a mo68101xi(String str) {
        AppMethodBeat.m2504i(86786);
        C1492a c1492a = new C1492a(this.gNC.aug() + str, C33082aw.m54068a(this.gNC.getRuntime(), str) + this.gNC.mo61201xc(str));
        AppMethodBeat.m2505o(86786);
        return c1492a;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo68097b(ArrayList<C1492a> arrayList, String str) {
        AppMethodBeat.m2504i(86787);
        arrayList.add(new C1492a(this.gNC.auf() + "config", String.format("var __wxConfig = %s;", new Object[]{this.gNC.mo21959xW().toString()})));
        AppMethodBeat.m2505o(86787);
    }

    @JavascriptInterface
    public void terminate(int i) {
        AppMethodBeat.m2504i(86788);
        C32488l c32488l = (C32488l) this.gQj.ciF.remove(Integer.valueOf(i));
        if (c32488l != null) {
            c32488l.destroy();
        }
        AppMethodBeat.m2505o(86788);
    }

    @JavascriptInterface
    public void postMsgToWorker(int i, String str) {
        AppMethodBeat.m2504i(86789);
        C37673t c37673t = this.gQj;
        C32488l c32488l = (C32488l) c37673t.ciF.get(Integer.valueOf(i));
        if (c32488l != null) {
            c32488l.chO.mo73187k(new C376753(c32488l, str));
        }
        AppMethodBeat.m2505o(86789);
    }
}
