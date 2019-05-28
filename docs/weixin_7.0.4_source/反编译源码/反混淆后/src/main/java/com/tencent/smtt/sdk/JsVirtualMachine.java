package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine {
    /* renamed from: a */
    private final Context f4480a;
    /* renamed from: b */
    private final IX5JsVirtualMachine f4481b;
    /* renamed from: c */
    private final HashSet<WeakReference<C24258a>> f4482c;

    /* renamed from: com.tencent.smtt.sdk.JsVirtualMachine$a */
    static class C24258a implements IX5JsContext {
        /* renamed from: a */
        private WebView f4483a;

        public C24258a(Context context) {
            AppMethodBeat.m2504i(63961);
            this.f4483a = new WebView(context);
            this.f4483a.getSettings().setJavaScriptEnabled(true);
            AppMethodBeat.m2505o(63961);
        }

        /* renamed from: a */
        public void mo40336a() {
            AppMethodBeat.m2504i(63962);
            if (this.f4483a == null) {
                AppMethodBeat.m2505o(63962);
                return;
            }
            this.f4483a.onPause();
            AppMethodBeat.m2505o(63962);
        }

        public void addJavascriptInterface(Object obj, String str) {
            AppMethodBeat.m2504i(63964);
            if (this.f4483a == null) {
                AppMethodBeat.m2505o(63964);
                return;
            }
            this.f4483a.addJavascriptInterface(obj, str);
            this.f4483a.loadUrl("about:blank");
            AppMethodBeat.m2505o(63964);
        }

        /* renamed from: b */
        public void mo40337b() {
            AppMethodBeat.m2504i(63963);
            if (this.f4483a == null) {
                AppMethodBeat.m2505o(63963);
                return;
            }
            this.f4483a.onResume();
            AppMethodBeat.m2505o(63963);
        }

        public void destroy() {
            AppMethodBeat.m2504i(63965);
            if (this.f4483a == null) {
                AppMethodBeat.m2505o(63965);
                return;
            }
            this.f4483a.clearHistory();
            this.f4483a.clearCache(true);
            this.f4483a.loadUrl("about:blank");
            this.f4483a.freeMemory();
            this.f4483a.pauseTimers();
            this.f4483a.destroy();
            this.f4483a = null;
            AppMethodBeat.m2505o(63965);
        }

        public void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
            AppMethodBeat.m2504i(63966);
            if (this.f4483a == null) {
                AppMethodBeat.m2505o(63966);
                return;
            }
            this.f4483a.evaluateJavascript(str, valueCallback == null ? null : new C24271e(this, valueCallback));
            AppMethodBeat.m2505o(63966);
        }

        public IX5JsValue evaluateScript(String str, URL url) {
            AppMethodBeat.m2504i(63967);
            if (this.f4483a == null) {
                AppMethodBeat.m2505o(63967);
            } else {
                this.f4483a.evaluateJavascript(str, null);
                AppMethodBeat.m2505o(63967);
            }
            return null;
        }

        public void evaluateScriptAsync(String str, ValueCallback<IX5JsValue> valueCallback, URL url) {
            AppMethodBeat.m2504i(63968);
            if (this.f4483a == null) {
                AppMethodBeat.m2505o(63968);
                return;
            }
            this.f4483a.evaluateJavascript(str, valueCallback == null ? null : new C16151f(this, valueCallback));
            AppMethodBeat.m2505o(63968);
        }

        public void removeJavascriptInterface(String str) {
            AppMethodBeat.m2504i(63969);
            if (this.f4483a == null) {
                AppMethodBeat.m2505o(63969);
                return;
            }
            this.f4483a.removeJavascriptInterface(str);
            AppMethodBeat.m2505o(63969);
        }

        public void setExceptionHandler(ValueCallback<IX5JsError> valueCallback) {
        }

        public void setName(String str) {
        }

        public void setPerContextData(Object obj) {
        }

        public void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }
    }

    public JsVirtualMachine(Context context) {
        this(context, null);
    }

    public JsVirtualMachine(Context context, Looper looper) {
        AppMethodBeat.m2504i(63970);
        this.f4482c = new HashSet();
        this.f4480a = context;
        this.f4481b = X5JsCore.m88579a(context, looper);
        AppMethodBeat.m2505o(63970);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final IX5JsContext mo40330a() {
        IX5JsContext c24258a;
        AppMethodBeat.m2504i(63971);
        if (this.f4481b == null) {
            c24258a = new C24258a(this.f4480a);
            this.f4482c.add(new WeakReference(c24258a));
        } else {
            c24258a = this.f4481b.createJsContext();
        }
        AppMethodBeat.m2505o(63971);
        return c24258a;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(63972);
        if (this.f4481b != null) {
            this.f4481b.destroy();
            AppMethodBeat.m2505o(63972);
            return;
        }
        Iterator it = this.f4482c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((C24258a) weakReference.get()).destroy();
            }
        }
        AppMethodBeat.m2505o(63972);
    }

    public final Looper getLooper() {
        AppMethodBeat.m2504i(63973);
        Looper looper;
        if (this.f4481b != null) {
            looper = this.f4481b.getLooper();
            AppMethodBeat.m2505o(63973);
            return looper;
        }
        looper = Looper.myLooper();
        AppMethodBeat.m2505o(63973);
        return looper;
    }

    public final boolean isFallback() {
        return this.f4481b == null;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(63974);
        if (this.f4481b != null) {
            this.f4481b.onPause();
            AppMethodBeat.m2505o(63974);
            return;
        }
        Iterator it = this.f4482c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((C24258a) weakReference.get()).mo40336a();
            }
        }
        AppMethodBeat.m2505o(63974);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(63975);
        if (this.f4481b != null) {
            this.f4481b.onResume();
            AppMethodBeat.m2505o(63975);
            return;
        }
        Iterator it = this.f4482c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((C24258a) weakReference.get()).mo40337b();
            }
        }
        AppMethodBeat.m2505o(63975);
    }
}
