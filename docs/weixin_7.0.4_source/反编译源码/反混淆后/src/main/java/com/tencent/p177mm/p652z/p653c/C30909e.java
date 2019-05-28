package com.tencent.p177mm.p652z.p653c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p652z.p1101b.C30908e;
import com.tencent.p177mm.p652z.p1101b.C40954d;
import com.tencent.p177mm.p652z.p1101b.C46727c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.z.c.e */
public final class C30909e {
    private volatile boolean apg;
    public String eIq;
    public C5756c eIr;
    public C16117f eIs;
    public C40954d eIt;
    private volatile boolean eIu;
    public C30910a eIv;

    /* renamed from: com.tencent.mm.z.c.e$a */
    public interface C30910a {
        /* renamed from: I */
        void mo5961I(String str, int i);
    }

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        int i = 0;
        AppMethodBeat.m2504i(115308);
        String str4 = "MicroMsg.MiniJsBridge";
        String str5 = "publishHandler, event: %s, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7411d(str4, str5, objArr);
        AppMethodBeat.m2505o(115308);
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        AppMethodBeat.m2504i(115309);
        String c;
        if (this.apg) {
            c = this.eIr.mo11731c(str, str2, i);
            AppMethodBeat.m2505o(115309);
            return c;
        }
        c = this.eIr.eIk.mo34412Q(str, "fail:JsApi core not started");
        AppMethodBeat.m2505o(115309);
        return c;
    }

    /* renamed from: R */
    public final boolean mo49448R(String str, String str2) {
        AppMethodBeat.m2504i(115310);
        C16117f c16117f = this.eIs;
        C30908e lq = c16117f.eIw.mo75146lq(str);
        if (lq == null) {
            C4990ab.m7417i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", str);
            AppMethodBeat.m2505o(115310);
            return false;
        } else if (c16117f.eIi.mo11735jB(lq.getIndex())) {
            if (C5046bo.isNullOrNil(str2)) {
                str2 = "{}";
            }
            C4990ab.m7411d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(0));
            c16117f.eIt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{str, str2, "undefined", C16117f.m24441QB()}), null);
            AppMethodBeat.m2505o(115310);
            return true;
        } else {
            C4990ab.m7417i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", str);
            AppMethodBeat.m2505o(115310);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo49450a(C46727c c46727c, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(115311);
        C16117f c16117f = this.eIs;
        C30908e lq = c16117f.eIw.mo75146lq(c46727c.name);
        if (lq == null) {
            C4990ab.m7417i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", c46727c);
            AppMethodBeat.m2505o(115311);
            return false;
        } else if (c16117f.eIi.mo11735jB(lq.getIndex())) {
            String jSONObject = c46727c.toJSONObject().toString();
            C4990ab.m7411d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", c46727c.name, Integer.valueOf(jSONObject.length()), Integer.valueOf(0));
            c16117f.eIt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{c46727c.name, jSONObject, "undefined", C16117f.m24441QB()}), valueCallback);
            AppMethodBeat.m2505o(115311);
            return true;
        } else {
            C4990ab.m7417i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", c46727c);
            AppMethodBeat.m2505o(115311);
            return false;
        }
    }

    public final void onStop() {
        AppMethodBeat.m2504i(115312);
        C4990ab.m7419v("MicroMsg.MiniJsBridge", "onStop(%s)", this.eIq);
        this.apg = false;
        this.eIt.cleanup();
        C5756c c5756c = this.eIr;
        c5756c.eIk.quit();
        c5756c.eIh.eIo.recycle();
        if (this.eIv != null) {
            this.eIv.mo5961I(this.eIq, 4);
            this.eIv = null;
        }
        AppMethodBeat.m2505o(115312);
    }

    /* renamed from: Qz */
    public final void mo49447Qz() {
        AppMethodBeat.m2504i(115313);
        if (this.eIu) {
            AppMethodBeat.m2505o(115313);
            return;
        }
        C4990ab.m7419v("MicroMsg.MiniJsBridge", "onPause(%s)", this.eIq);
        this.eIu = true;
        this.eIt.pause();
        if (this.eIv != null) {
            this.eIv.mo5961I(this.eIq, 3);
        }
        AppMethodBeat.m2505o(115313);
    }

    /* renamed from: QA */
    public final void mo49445QA() {
        AppMethodBeat.m2504i(115314);
        if (this.eIu) {
            C4990ab.m7419v("MicroMsg.MiniJsBridge", "onResume(%s)", this.eIq);
            this.eIt.resume();
            this.eIu = false;
            if (this.eIv != null) {
                this.eIv.mo5961I(this.eIq, 2);
            }
            AppMethodBeat.m2505o(115314);
            return;
        }
        AppMethodBeat.m2505o(115314);
    }

    public final void onStart() {
        AppMethodBeat.m2504i(115315);
        if (this.apg) {
            AppMethodBeat.m2505o(115315);
            return;
        }
        C4990ab.m7419v("MicroMsg.MiniJsBridge", "onStart(%s)", this.eIq);
        this.apg = true;
        if (this.eIv != null) {
            this.eIv.mo5961I(this.eIq, 1);
        }
        Iterator it = this.eIr.eIj.eIp.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(115315);
    }

    /* renamed from: Qy */
    public final C32800b mo49446Qy() {
        return this.eIr.eIh.eIo;
    }

    /* renamed from: a */
    public final void mo49449a(C40954d c40954d) {
        AppMethodBeat.m2504i(115316);
        if (this.eIt != null) {
            C4990ab.m7412e("MicroMsg.MiniJsBridge", "can not initialize again.");
            AppMethodBeat.m2505o(115316);
            return;
        }
        this.eIt = c40954d;
        AppMethodBeat.m2505o(115316);
    }
}
