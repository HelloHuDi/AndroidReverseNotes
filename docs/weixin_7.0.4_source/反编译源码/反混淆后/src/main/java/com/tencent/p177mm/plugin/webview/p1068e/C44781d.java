package com.tencent.p177mm.plugin.webview.p1068e;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.C44071s;
import com.tencent.p177mm.pluginsdk.C44071s.C40448a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.e.d */
public final class C44781d extends C44071s {
    private List<C40448a> kCH = new LinkedList();
    public long startTime = 0;

    /* renamed from: com.tencent.mm.plugin.webview.e.d$1 */
    public class C144501 implements ValueCallback<String> {
        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(10143);
            final String str = (String) obj;
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.m2504i(10142);
                    Looper.myQueue().removeIdleHandler(this);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        JSONObject optJSONObject = new JSONObject(str.substring(1, str.length() - 1).replace("\\\"", "\"")).optJSONObject("timing");
                        Iterator keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            C44781d.this.mo69758aI(str, optJSONObject.optLong(str));
                        }
                    } catch (Exception e) {
                        C4990ab.m7421w("MicroMsg.WebViewPerformanceHelper", "fetchDocumentTime ex: %s", e.getMessage());
                    }
                    C44781d.this.ddc();
                    C4990ab.m7419v("MicroMsg.WebViewPerformanceHelper", "onReceiveValue cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(10142);
                    return false;
                }
            });
            AppMethodBeat.m2505o(10143);
        }
    }

    public C44781d() {
        AppMethodBeat.m2504i(10144);
        AppMethodBeat.m2505o(10144);
    }

    public final void ddc() {
        AppMethodBeat.m2504i(10145);
        if (C5046bo.m7548ek(this.kCH)) {
            AppMethodBeat.m2505o(10145);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (C40448a c40448a : this.kCH) {
            stringBuilder.append("[");
            stringBuilder.append(c40448a.key);
            stringBuilder.append(": ");
            stringBuilder.append(c40448a.time);
            if (c40448a.time > this.startTime) {
                stringBuilder.append(", ").append(c40448a.time - this.startTime);
            }
            if (!C5046bo.isNullOrNil(c40448a.detail)) {
                stringBuilder.append(", ").append(c40448a.detail);
            }
            stringBuilder.append("] ");
        }
        C4990ab.m7417i("MicroMsg.WebViewPerformanceHelper", "webview Performance: %s", stringBuilder.toString());
        this.kCH.clear();
        AppMethodBeat.m2505o(10145);
    }
}
