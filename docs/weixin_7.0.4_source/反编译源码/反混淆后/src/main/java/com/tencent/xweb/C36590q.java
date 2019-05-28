package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C44578g;
import com.tencent.xweb.p1115c.C44581k;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.q */
public final class C36590q {
    static C36590q AML = null;
    public C44578g AMK = null;

    public static synchronized C36590q dUk() {
        C36590q c36590q;
        synchronized (C36590q.class) {
            AppMethodBeat.m2504i(3837);
            if (AML == null) {
                AML = new C36590q();
            }
            c36590q = AML;
            AppMethodBeat.m2505o(3837);
        }
        return c36590q;
    }

    private C36590q() {
        AppMethodBeat.m2504i(3838);
        C44578g createWebviewStorage = C44581k.m80968f(WebView.getCurWebType()).createWebviewStorage();
        if (createWebviewStorage == null) {
            Log.m81046e("WebStorage", "create WebStorage failed webStg is null, cur core kind is " + WebView.getCurWebType());
            AppMethodBeat.m2505o(3838);
            return;
        }
        this.AMK = createWebviewStorage;
        AppMethodBeat.m2505o(3838);
    }
}
