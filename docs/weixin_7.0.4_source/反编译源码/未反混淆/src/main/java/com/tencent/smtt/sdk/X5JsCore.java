package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public class X5JsCore {
    private static a a = a.UNINITIALIZED;
    private static a b = a.UNINITIALIZED;
    private static a c = a.UNINITIALIZED;
    private final Context d;
    private Object e = null;
    private WebView f = null;

    enum a {
        UNINITIALIZED,
        UNAVAILABLE,
        AVAILABLE;

        static {
            AppMethodBeat.o(65113);
        }
    }

    @Deprecated
    public X5JsCore(Context context) {
        AppMethodBeat.i(65120);
        this.d = context;
        if (canUseX5JsCore(context)) {
            Object a = a("createX5JavaBridge", new Class[]{Context.class}, context);
            if (a != null) {
                this.e = a;
                AppMethodBeat.o(65120);
                return;
            }
        }
        this.f = new WebView(context);
        this.f.getSettings().setJavaScriptEnabled(true);
        AppMethodBeat.o(65120);
    }

    protected static IX5JsVirtualMachine a(Context context, Looper looper) {
        AppMethodBeat.i(65118);
        if (canUseX5JsCore(context)) {
            Object a = a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, looper);
            if (a != null) {
                IX5JsVirtualMachine iX5JsVirtualMachine = (IX5JsVirtualMachine) a;
                AppMethodBeat.o(65118);
                return iX5JsVirtualMachine;
            }
        }
        AppMethodBeat.o(65118);
        return null;
    }

    protected static Object a() {
        AppMethodBeat.i(65119);
        Object a = a("currentContextData", new Class[0], new Object[0]);
        AppMethodBeat.o(65119);
        return a;
    }

    private static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(65114);
        try {
            bv a = bv.a();
            if (a == null || !a.b()) {
                new StringBuilder("X5Jscore#").append(str).append(" - x5CoreEngine is null or is not x5core.");
                AppMethodBeat.o(65114);
                return null;
            }
            Object invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            AppMethodBeat.o(65114);
            return invokeStaticMethod;
        } catch (Exception e) {
        }
    }

    public static boolean canUseX5JsCore(Context context) {
        AppMethodBeat.i(65116);
        if (a == a.UNINITIALIZED) {
            a = a.UNAVAILABLE;
            Object a = a("canUseX5JsCore", new Class[]{Context.class}, context);
            if (a != null && (a instanceof Boolean) && ((Boolean) a).booleanValue()) {
                a("setJsValueFactory", new Class[]{Object.class}, JsValue.a());
                a = a.AVAILABLE;
                AppMethodBeat.o(65116);
                return true;
            }
            AppMethodBeat.o(65116);
            return false;
        } else if (a == a.AVAILABLE) {
            AppMethodBeat.o(65116);
            return true;
        } else {
            AppMethodBeat.o(65116);
            return false;
        }
    }

    public static boolean canUseX5JsCoreNewAPI(Context context) {
        AppMethodBeat.i(65115);
        if (c == a.UNINITIALIZED) {
            c = a.UNAVAILABLE;
            Object a = a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
            if (a != null && (a instanceof Boolean) && ((Boolean) a).booleanValue()) {
                c = a.AVAILABLE;
                AppMethodBeat.o(65115);
                return true;
            }
            AppMethodBeat.o(65115);
            return false;
        } else if (c == a.AVAILABLE) {
            AppMethodBeat.o(65115);
            return true;
        } else {
            AppMethodBeat.o(65115);
            return false;
        }
    }

    public static boolean canX5JsCoreUseNativeBuffer(Context context) {
        AppMethodBeat.i(65117);
        if (b == a.UNINITIALIZED) {
            b = a.UNAVAILABLE;
            if (canUseX5JsCore(context)) {
                Object a = a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context);
                if (a != null && (a instanceof Boolean) && ((Boolean) a).booleanValue()) {
                    b = a.AVAILABLE;
                    AppMethodBeat.o(65117);
                    return true;
                }
                AppMethodBeat.o(65117);
                return false;
            }
            AppMethodBeat.o(65117);
            return false;
        } else if (b == a.AVAILABLE) {
            AppMethodBeat.o(65117);
            return true;
        } else {
            AppMethodBeat.o(65117);
            return false;
        }
    }

    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(65121);
        if (this.e != null) {
            a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, this.e);
            AppMethodBeat.o(65121);
            return;
        }
        if (this.f != null) {
            this.f.addJavascriptInterface(obj, str);
            this.f.loadUrl("about:blank");
        }
        AppMethodBeat.o(65121);
    }

    @Deprecated
    public void destroy() {
        AppMethodBeat.i(65131);
        if (this.e != null) {
            a("destroyX5JsCore", new Class[]{Object.class}, this.e);
            this.e = null;
            AppMethodBeat.o(65131);
            return;
        }
        if (this.f != null) {
            this.f.clearHistory();
            this.f.clearCache(true);
            this.f.loadUrl("about:blank");
            this.f.freeMemory();
            this.f.pauseTimers();
            this.f.destroy();
            this.f = null;
        }
        AppMethodBeat.o(65131);
    }

    @Deprecated
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(65123);
        if (this.e != null) {
            a("evaluateJavascript", new Class[]{String.class, ValueCallback.class, Object.class}, str, valueCallback, this.e);
            AppMethodBeat.o(65123);
            return;
        }
        if (this.f != null) {
            this.f.evaluateJavascript(str, valueCallback);
        }
        AppMethodBeat.o(65123);
    }

    @Deprecated
    public ByteBuffer getNativeBuffer(int i) {
        AppMethodBeat.i(65130);
        if (this.e != null && canX5JsCoreUseNativeBuffer(this.d)) {
            Object a = a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.e, Integer.valueOf(i));
            if (a != null && (a instanceof ByteBuffer)) {
                ByteBuffer byteBuffer = (ByteBuffer) a;
                AppMethodBeat.o(65130);
                return byteBuffer;
            }
        }
        AppMethodBeat.o(65130);
        return null;
    }

    @Deprecated
    public int getNativeBufferId() {
        AppMethodBeat.i(65128);
        if (this.e != null && canX5JsCoreUseNativeBuffer(this.d)) {
            Object a = a("getNativeBufferId", new Class[]{Object.class}, this.e);
            if (a != null && (a instanceof Integer)) {
                int intValue = ((Integer) a).intValue();
                AppMethodBeat.o(65128);
                return intValue;
            }
        }
        AppMethodBeat.o(65128);
        return -1;
    }

    @Deprecated
    public void pause() {
        AppMethodBeat.i(65126);
        if (this.e != null) {
            a("pause", new Class[]{Object.class}, this.e);
        }
        AppMethodBeat.o(65126);
    }

    @Deprecated
    public void pauseTimers() {
        AppMethodBeat.i(65124);
        if (this.e != null) {
            a("pauseTimers", new Class[]{Object.class}, this.e);
        }
        AppMethodBeat.o(65124);
    }

    @Deprecated
    public void removeJavascriptInterface(String str) {
        AppMethodBeat.i(65122);
        if (this.e != null) {
            a("removeJavascriptInterface", new Class[]{String.class, Object.class}, str, this.e);
            AppMethodBeat.o(65122);
            return;
        }
        if (this.f != null) {
            this.f.removeJavascriptInterface(str);
        }
        AppMethodBeat.o(65122);
    }

    @Deprecated
    public void resume() {
        AppMethodBeat.i(65127);
        if (this.e != null) {
            a("resume", new Class[]{Object.class}, this.e);
        }
        AppMethodBeat.o(65127);
    }

    @Deprecated
    public void resumeTimers() {
        AppMethodBeat.i(65125);
        if (this.e != null) {
            a("resumeTimers", new Class[]{Object.class}, this.e);
        }
        AppMethodBeat.o(65125);
    }

    @Deprecated
    public void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        AppMethodBeat.i(65129);
        if (this.e != null && canX5JsCoreUseNativeBuffer(this.d)) {
            a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.e, Integer.valueOf(i), byteBuffer);
        }
        AppMethodBeat.o(65129);
    }
}
