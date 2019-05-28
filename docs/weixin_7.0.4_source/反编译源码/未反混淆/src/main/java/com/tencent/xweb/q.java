package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.k;
import org.xwalk.core.Log;

public final class q {
    static q AML = null;
    public g AMK = null;

    public static synchronized q dUk() {
        q qVar;
        synchronized (q.class) {
            AppMethodBeat.i(3837);
            if (AML == null) {
                AML = new q();
            }
            qVar = AML;
            AppMethodBeat.o(3837);
        }
        return qVar;
    }

    private q() {
        AppMethodBeat.i(3838);
        g createWebviewStorage = k.f(WebView.getCurWebType()).createWebviewStorage();
        if (createWebviewStorage == null) {
            Log.e("WebStorage", "create WebStorage failed webStg is null, cur core kind is " + WebView.getCurWebType());
            AppMethodBeat.o(3838);
            return;
        }
        this.AMK = createWebviewStorage;
        AppMethodBeat.o(3838);
    }
}
