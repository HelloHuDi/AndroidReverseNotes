package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22935h.C22936a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.o */
public class C40291o implements InvocationHandler {
    private boolean mEnable;
    private C43949n uzP;
    private C22935h uzQ = new C356491();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.o$1 */
    class C356491 implements C22935h {
        C356491() {
        }

        /* renamed from: a */
        public final void mo38527a(C22936a c22936a) {
        }

        public final void dbc() {
        }

        /* renamed from: Jx */
        public final boolean mo38526Jx(int i) {
            return false;
        }

        /* renamed from: nT */
        public final void mo38532nT(boolean z) {
        }

        public final void afX(String str) {
        }

        public final void afY(String str) {
        }

        public final boolean dbd() {
            return false;
        }
    }

    /* renamed from: a */
    public static C22935h m69086a(C43945g c43945g, boolean z) {
        AppMethodBeat.m2504i(8270);
        C40291o c40291o = new C40291o(c43945g, z);
        C22935h c22935h = (C22935h) Proxy.newProxyInstance(C40291o.class.getClassLoader(), new Class[]{C22935h.class}, c40291o);
        AppMethodBeat.m2505o(8270);
        return c22935h;
    }

    private C40291o() {
        AppMethodBeat.m2504i(8271);
        AppMethodBeat.m2505o(8271);
    }

    private C40291o(C43945g c43945g, boolean z) {
        AppMethodBeat.m2504i(8272);
        this.mEnable = z;
        if (z) {
            this.uzP = new C43949n(c43945g);
        }
        AppMethodBeat.m2505o(8272);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object invoke;
        Throwable cause;
        AppMethodBeat.m2504i(8273);
        if (this.mEnable) {
            try {
                invoke = method.invoke(this.uzP, objArr);
                AppMethodBeat.m2505o(8273);
            } catch (InvocationTargetException e) {
                C4990ab.m7417i("MicroMsg.WebViewUIBagHelperProxy", "mWebViewUIBagHelper invoke e:%s", e);
                cause = e.getCause();
                AppMethodBeat.m2505o(8273);
                throw cause;
            }
        }
        try {
            invoke = method.invoke(this.uzQ, objArr);
            AppMethodBeat.m2505o(8273);
        } catch (InvocationTargetException e2) {
            C4990ab.m7417i("MicroMsg.WebViewUIBagHelperProxy", "not enable mEmptyHelper invoke e:%s", e2);
            cause = e2.getCause();
            AppMethodBeat.m2505o(8273);
            throw cause;
        }
        return invoke;
    }
}
