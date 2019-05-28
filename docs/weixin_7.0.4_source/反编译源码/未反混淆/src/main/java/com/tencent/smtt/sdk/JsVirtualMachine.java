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
    private final Context a;
    private final IX5JsVirtualMachine b;
    private final HashSet<WeakReference<a>> c;

    static class a implements IX5JsContext {
        private WebView a;

        public a(Context context) {
            AppMethodBeat.i(63961);
            this.a = new WebView(context);
            this.a.getSettings().setJavaScriptEnabled(true);
            AppMethodBeat.o(63961);
        }

        public void a() {
            AppMethodBeat.i(63962);
            if (this.a == null) {
                AppMethodBeat.o(63962);
                return;
            }
            this.a.onPause();
            AppMethodBeat.o(63962);
        }

        public void addJavascriptInterface(Object obj, String str) {
            AppMethodBeat.i(63964);
            if (this.a == null) {
                AppMethodBeat.o(63964);
                return;
            }
            this.a.addJavascriptInterface(obj, str);
            this.a.loadUrl("about:blank");
            AppMethodBeat.o(63964);
        }

        public void b() {
            AppMethodBeat.i(63963);
            if (this.a == null) {
                AppMethodBeat.o(63963);
                return;
            }
            this.a.onResume();
            AppMethodBeat.o(63963);
        }

        public void destroy() {
            AppMethodBeat.i(63965);
            if (this.a == null) {
                AppMethodBeat.o(63965);
                return;
            }
            this.a.clearHistory();
            this.a.clearCache(true);
            this.a.loadUrl("about:blank");
            this.a.freeMemory();
            this.a.pauseTimers();
            this.a.destroy();
            this.a = null;
            AppMethodBeat.o(63965);
        }

        public void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
            AppMethodBeat.i(63966);
            if (this.a == null) {
                AppMethodBeat.o(63966);
                return;
            }
            this.a.evaluateJavascript(str, valueCallback == null ? null : new e(this, valueCallback));
            AppMethodBeat.o(63966);
        }

        public IX5JsValue evaluateScript(String str, URL url) {
            AppMethodBeat.i(63967);
            if (this.a == null) {
                AppMethodBeat.o(63967);
            } else {
                this.a.evaluateJavascript(str, null);
                AppMethodBeat.o(63967);
            }
            return null;
        }

        public void evaluateScriptAsync(String str, ValueCallback<IX5JsValue> valueCallback, URL url) {
            AppMethodBeat.i(63968);
            if (this.a == null) {
                AppMethodBeat.o(63968);
                return;
            }
            this.a.evaluateJavascript(str, valueCallback == null ? null : new f(this, valueCallback));
            AppMethodBeat.o(63968);
        }

        public void removeJavascriptInterface(String str) {
            AppMethodBeat.i(63969);
            if (this.a == null) {
                AppMethodBeat.o(63969);
                return;
            }
            this.a.removeJavascriptInterface(str);
            AppMethodBeat.o(63969);
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
        AppMethodBeat.i(63970);
        this.c = new HashSet();
        this.a = context;
        this.b = X5JsCore.a(context, looper);
        AppMethodBeat.o(63970);
    }

    /* Access modifiers changed, original: protected|final */
    public final IX5JsContext a() {
        IX5JsContext aVar;
        AppMethodBeat.i(63971);
        if (this.b == null) {
            aVar = new a(this.a);
            this.c.add(new WeakReference(aVar));
        } else {
            aVar = this.b.createJsContext();
        }
        AppMethodBeat.o(63971);
        return aVar;
    }

    public final void destroy() {
        AppMethodBeat.i(63972);
        if (this.b != null) {
            this.b.destroy();
            AppMethodBeat.o(63972);
            return;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((a) weakReference.get()).destroy();
            }
        }
        AppMethodBeat.o(63972);
    }

    public final Looper getLooper() {
        AppMethodBeat.i(63973);
        Looper looper;
        if (this.b != null) {
            looper = this.b.getLooper();
            AppMethodBeat.o(63973);
            return looper;
        }
        looper = Looper.myLooper();
        AppMethodBeat.o(63973);
        return looper;
    }

    public final boolean isFallback() {
        return this.b == null;
    }

    public final void onPause() {
        AppMethodBeat.i(63974);
        if (this.b != null) {
            this.b.onPause();
            AppMethodBeat.o(63974);
            return;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((a) weakReference.get()).a();
            }
        }
        AppMethodBeat.o(63974);
    }

    public final void onResume() {
        AppMethodBeat.i(63975);
        if (this.b != null) {
            this.b.onResume();
            AppMethodBeat.o(63975);
            return;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((a) weakReference.get()).b();
            }
        }
        AppMethodBeat.o(63975);
    }
}
