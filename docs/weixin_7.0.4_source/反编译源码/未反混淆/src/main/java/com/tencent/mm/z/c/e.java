package com.tencent.mm.z.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.c;
import com.tencent.mm.z.b.d;
import java.util.Iterator;

public final class e {
    private volatile boolean apg;
    public String eIq;
    public c eIr;
    public f eIs;
    public d eIt;
    private volatile boolean eIu;
    public a eIv;

    public interface a {
        void I(String str, int i);
    }

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        int i = 0;
        AppMethodBeat.i(115308);
        String str4 = "MicroMsg.MiniJsBridge";
        String str5 = "publishHandler, event: %s, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        ab.d(str4, str5, objArr);
        AppMethodBeat.o(115308);
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        AppMethodBeat.i(115309);
        String c;
        if (this.apg) {
            c = this.eIr.c(str, str2, i);
            AppMethodBeat.o(115309);
            return c;
        }
        c = this.eIr.eIk.Q(str, "fail:JsApi core not started");
        AppMethodBeat.o(115309);
        return c;
    }

    public final boolean R(String str, String str2) {
        AppMethodBeat.i(115310);
        f fVar = this.eIs;
        com.tencent.mm.z.b.e lq = fVar.eIw.lq(str);
        if (lq == null) {
            ab.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", str);
            AppMethodBeat.o(115310);
            return false;
        } else if (fVar.eIi.jB(lq.getIndex())) {
            if (bo.isNullOrNil(str2)) {
                str2 = "{}";
            }
            ab.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(0));
            fVar.eIt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{str, str2, "undefined", f.QB()}), null);
            AppMethodBeat.o(115310);
            return true;
        } else {
            ab.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", str);
            AppMethodBeat.o(115310);
            return false;
        }
    }

    public final boolean a(c cVar, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(115311);
        f fVar = this.eIs;
        com.tencent.mm.z.b.e lq = fVar.eIw.lq(cVar.name);
        if (lq == null) {
            ab.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", cVar);
            AppMethodBeat.o(115311);
            return false;
        } else if (fVar.eIi.jB(lq.getIndex())) {
            String jSONObject = cVar.toJSONObject().toString();
            ab.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", cVar.name, Integer.valueOf(jSONObject.length()), Integer.valueOf(0));
            fVar.eIt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{cVar.name, jSONObject, "undefined", f.QB()}), valueCallback);
            AppMethodBeat.o(115311);
            return true;
        } else {
            ab.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", cVar);
            AppMethodBeat.o(115311);
            return false;
        }
    }

    public final void onStop() {
        AppMethodBeat.i(115312);
        ab.v("MicroMsg.MiniJsBridge", "onStop(%s)", this.eIq);
        this.apg = false;
        this.eIt.cleanup();
        c cVar = this.eIr;
        cVar.eIk.quit();
        cVar.eIh.eIo.recycle();
        if (this.eIv != null) {
            this.eIv.I(this.eIq, 4);
            this.eIv = null;
        }
        AppMethodBeat.o(115312);
    }

    public final void Qz() {
        AppMethodBeat.i(115313);
        if (this.eIu) {
            AppMethodBeat.o(115313);
            return;
        }
        ab.v("MicroMsg.MiniJsBridge", "onPause(%s)", this.eIq);
        this.eIu = true;
        this.eIt.pause();
        if (this.eIv != null) {
            this.eIv.I(this.eIq, 3);
        }
        AppMethodBeat.o(115313);
    }

    public final void QA() {
        AppMethodBeat.i(115314);
        if (this.eIu) {
            ab.v("MicroMsg.MiniJsBridge", "onResume(%s)", this.eIq);
            this.eIt.resume();
            this.eIu = false;
            if (this.eIv != null) {
                this.eIv.I(this.eIq, 2);
            }
            AppMethodBeat.o(115314);
            return;
        }
        AppMethodBeat.o(115314);
    }

    public final void onStart() {
        AppMethodBeat.i(115315);
        if (this.apg) {
            AppMethodBeat.o(115315);
            return;
        }
        ab.v("MicroMsg.MiniJsBridge", "onStart(%s)", this.eIq);
        this.apg = true;
        if (this.eIv != null) {
            this.eIv.I(this.eIq, 1);
        }
        Iterator it = this.eIr.eIj.eIp.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(115315);
    }

    public final b Qy() {
        return this.eIr.eIh.eIo;
    }

    public final void a(d dVar) {
        AppMethodBeat.i(115316);
        if (this.eIt != null) {
            ab.e("MicroMsg.MiniJsBridge", "can not initialize again.");
            AppMethodBeat.o(115316);
            return;
        }
        this.eIt = dVar;
        AppMethodBeat.o(115316);
    }
}
