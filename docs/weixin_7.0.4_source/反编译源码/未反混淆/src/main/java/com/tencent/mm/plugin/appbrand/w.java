package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.t;
import com.tencent.mm.d.a.t.AnonymousClass3;
import com.tencent.mm.d.a.t.a;
import com.tencent.mm.d.a.u;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.h.k;
import com.tencent.mm.plugin.appbrand.r.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class w {
    u ciG = new u() {
        public final int CC() {
            AppMethodBeat.i(86779);
            if (w.this.gQi != null) {
                int nativeBufferId = w.this.gQi.getNativeBufferId();
                AppMethodBeat.o(86779);
                return nativeBufferId;
            }
            AppMethodBeat.o(86779);
            return 0;
        }

        public final ByteBuffer gq(int i) {
            AppMethodBeat.i(86780);
            if (w.this.gQi != null) {
                ByteBuffer nativeBuffer = w.this.gQi.getNativeBuffer(i);
                AppMethodBeat.o(86780);
                return nativeBuffer;
            }
            AppMethodBeat.o(86780);
            return null;
        }

        public final void a(int i, ByteBuffer byteBuffer) {
            AppMethodBeat.i(86781);
            if (w.this.gQi != null) {
                w.this.gQi.setNativeBuffer(i, byteBuffer);
            }
            AppMethodBeat.o(86781);
        }

        public final void h(int i, String str) {
            AppMethodBeat.i(86782);
            w.this.gNC.aBx().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[]{Integer.valueOf(i), str}), null);
            AppMethodBeat.o(86782);
        }
    };
    q gNC;
    k gQi;
    public t gQj;
    private ArrayList<a> gQk;

    public w(q qVar) {
        AppMethodBeat.i(86783);
        this.gNC = qVar;
        this.gQi = (k) qVar.aBx().af(k.class);
        this.gQj = auv();
        this.gQk = new ArrayList();
        this.gQk.add(new a(this.gNC.auf() + "wxa_library/bootstrap_j2v8_worker.js", d.Eb("wxa_library/bootstrap_j2v8_worker.js")));
        qVar.aBx().addJavascriptInterface(this, "WeixinWorker");
        AppMethodBeat.o(86783);
    }

    /* Access modifiers changed, original: protected */
    public t auv() {
        AppMethodBeat.i(86784);
        t tVar = new t(this.ciG);
        AppMethodBeat.o(86784);
        return tVar;
    }

    @JavascriptInterface
    public int create(String str) {
        AppMethodBeat.i(86785);
        ArrayList arrayList = new ArrayList(this.gQk);
        b(arrayList, str);
        arrayList.add(xi(str));
        int e = this.gQj.e(arrayList);
        AppMethodBeat.o(86785);
        return e;
    }

    /* Access modifiers changed, original: protected */
    public a xi(String str) {
        AppMethodBeat.i(86786);
        a aVar = new a(this.gNC.aug() + str, aw.a(this.gNC.getRuntime(), str) + this.gNC.xc(str));
        AppMethodBeat.o(86786);
        return aVar;
    }

    /* Access modifiers changed, original: protected */
    public void b(ArrayList<a> arrayList, String str) {
        AppMethodBeat.i(86787);
        arrayList.add(new a(this.gNC.auf() + "config", String.format("var __wxConfig = %s;", new Object[]{this.gNC.xW().toString()})));
        AppMethodBeat.o(86787);
    }

    @JavascriptInterface
    public void terminate(int i) {
        AppMethodBeat.i(86788);
        l lVar = (l) this.gQj.ciF.remove(Integer.valueOf(i));
        if (lVar != null) {
            lVar.destroy();
        }
        AppMethodBeat.o(86788);
    }

    @JavascriptInterface
    public void postMsgToWorker(int i, String str) {
        AppMethodBeat.i(86789);
        t tVar = this.gQj;
        l lVar = (l) tVar.ciF.get(Integer.valueOf(i));
        if (lVar != null) {
            lVar.chO.k(new AnonymousClass3(lVar, str));
        }
        AppMethodBeat.o(86789);
    }
}
