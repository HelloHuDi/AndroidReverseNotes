package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.bag.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class o implements InvocationHandler {
    private boolean mEnable;
    private n uzP;
    private h uzQ = new h() {
        public final void a(a aVar) {
        }

        public final void dbc() {
        }

        public final boolean Jx(int i) {
            return false;
        }

        public final void nT(boolean z) {
        }

        public final void afX(String str) {
        }

        public final void afY(String str) {
        }

        public final boolean dbd() {
            return false;
        }
    };

    public static h a(g gVar, boolean z) {
        AppMethodBeat.i(8270);
        o oVar = new o(gVar, z);
        h hVar = (h) Proxy.newProxyInstance(o.class.getClassLoader(), new Class[]{h.class}, oVar);
        AppMethodBeat.o(8270);
        return hVar;
    }

    private o() {
        AppMethodBeat.i(8271);
        AppMethodBeat.o(8271);
    }

    private o(g gVar, boolean z) {
        AppMethodBeat.i(8272);
        this.mEnable = z;
        if (z) {
            this.uzP = new n(gVar);
        }
        AppMethodBeat.o(8272);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object invoke;
        Throwable cause;
        AppMethodBeat.i(8273);
        if (this.mEnable) {
            try {
                invoke = method.invoke(this.uzP, objArr);
                AppMethodBeat.o(8273);
            } catch (InvocationTargetException e) {
                ab.i("MicroMsg.WebViewUIBagHelperProxy", "mWebViewUIBagHelper invoke e:%s", e);
                cause = e.getCause();
                AppMethodBeat.o(8273);
                throw cause;
            }
        }
        try {
            invoke = method.invoke(this.uzQ, objArr);
            AppMethodBeat.o(8273);
        } catch (InvocationTargetException e2) {
            ab.i("MicroMsg.WebViewUIBagHelperProxy", "not enable mEmptyHelper invoke e:%s", e2);
            cause = e2.getCause();
            AppMethodBeat.o(8273);
            throw cause;
        }
        return invoke;
    }
}
