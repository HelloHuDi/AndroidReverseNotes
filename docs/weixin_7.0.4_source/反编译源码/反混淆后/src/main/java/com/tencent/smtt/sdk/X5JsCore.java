package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public class X5JsCore {
    /* renamed from: a */
    private static C24260a f17985a = C24260a.UNINITIALIZED;
    /* renamed from: b */
    private static C24260a f17986b = C24260a.UNINITIALIZED;
    /* renamed from: c */
    private static C24260a f17987c = C24260a.UNINITIALIZED;
    /* renamed from: d */
    private final Context f17988d;
    /* renamed from: e */
    private Object f17989e = null;
    /* renamed from: f */
    private WebView f17990f = null;

    /* renamed from: com.tencent.smtt.sdk.X5JsCore$a */
    enum C24260a {
        UNINITIALIZED,
        UNAVAILABLE,
        AVAILABLE;

        static {
            AppMethodBeat.m2505o(65113);
        }
    }

    @Deprecated
    public X5JsCore(Context context) {
        AppMethodBeat.m2504i(65120);
        this.f17988d = context;
        if (canUseX5JsCore(context)) {
            Object a = m88581a("createX5JavaBridge", new Class[]{Context.class}, context);
            if (a != null) {
                this.f17989e = a;
                AppMethodBeat.m2505o(65120);
                return;
            }
        }
        this.f17990f = new WebView(context);
        this.f17990f.getSettings().setJavaScriptEnabled(true);
        AppMethodBeat.m2505o(65120);
    }

    /* renamed from: a */
    protected static IX5JsVirtualMachine m88579a(Context context, Looper looper) {
        AppMethodBeat.m2504i(65118);
        if (canUseX5JsCore(context)) {
            Object a = m88581a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, looper);
            if (a != null) {
                IX5JsVirtualMachine iX5JsVirtualMachine = (IX5JsVirtualMachine) a;
                AppMethodBeat.m2505o(65118);
                return iX5JsVirtualMachine;
            }
        }
        AppMethodBeat.m2505o(65118);
        return null;
    }

    /* renamed from: a */
    protected static Object m88580a() {
        AppMethodBeat.m2504i(65119);
        Object a = m88581a("currentContextData", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(65119);
        return a;
    }

    /* renamed from: a */
    private static Object m88581a(String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.m2504i(65114);
        try {
            C40978bv a = C40978bv.m71073a();
            if (a == null || !a.mo64921b()) {
                new StringBuilder("X5Jscore#").append(str).append(" - x5CoreEngine is null or is not x5core.");
                AppMethodBeat.m2505o(65114);
                return null;
            }
            Object invokeStaticMethod = a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            AppMethodBeat.m2505o(65114);
            return invokeStaticMethod;
        } catch (Exception e) {
        }
    }

    public static boolean canUseX5JsCore(Context context) {
        AppMethodBeat.m2504i(65116);
        if (f17985a == C24260a.UNINITIALIZED) {
            f17985a = C24260a.UNAVAILABLE;
            Object a = m88581a("canUseX5JsCore", new Class[]{Context.class}, context);
            if (a != null && (a instanceof Boolean) && ((Boolean) a).booleanValue()) {
                m88581a("setJsValueFactory", new Class[]{Object.class}, JsValue.m60048a());
                f17985a = C24260a.AVAILABLE;
                AppMethodBeat.m2505o(65116);
                return true;
            }
            AppMethodBeat.m2505o(65116);
            return false;
        } else if (f17985a == C24260a.AVAILABLE) {
            AppMethodBeat.m2505o(65116);
            return true;
        } else {
            AppMethodBeat.m2505o(65116);
            return false;
        }
    }

    public static boolean canUseX5JsCoreNewAPI(Context context) {
        AppMethodBeat.m2504i(65115);
        if (f17987c == C24260a.UNINITIALIZED) {
            f17987c = C24260a.UNAVAILABLE;
            Object a = m88581a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
            if (a != null && (a instanceof Boolean) && ((Boolean) a).booleanValue()) {
                f17987c = C24260a.AVAILABLE;
                AppMethodBeat.m2505o(65115);
                return true;
            }
            AppMethodBeat.m2505o(65115);
            return false;
        } else if (f17987c == C24260a.AVAILABLE) {
            AppMethodBeat.m2505o(65115);
            return true;
        } else {
            AppMethodBeat.m2505o(65115);
            return false;
        }
    }

    public static boolean canX5JsCoreUseNativeBuffer(Context context) {
        AppMethodBeat.m2504i(65117);
        if (f17986b == C24260a.UNINITIALIZED) {
            f17986b = C24260a.UNAVAILABLE;
            if (canUseX5JsCore(context)) {
                Object a = m88581a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context);
                if (a != null && (a instanceof Boolean) && ((Boolean) a).booleanValue()) {
                    f17986b = C24260a.AVAILABLE;
                    AppMethodBeat.m2505o(65117);
                    return true;
                }
                AppMethodBeat.m2505o(65117);
                return false;
            }
            AppMethodBeat.m2505o(65117);
            return false;
        } else if (f17986b == C24260a.AVAILABLE) {
            AppMethodBeat.m2505o(65117);
            return true;
        } else {
            AppMethodBeat.m2505o(65117);
            return false;
        }
    }

    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(65121);
        if (this.f17989e != null) {
            m88581a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, this.f17989e);
            AppMethodBeat.m2505o(65121);
            return;
        }
        if (this.f17990f != null) {
            this.f17990f.addJavascriptInterface(obj, str);
            this.f17990f.loadUrl("about:blank");
        }
        AppMethodBeat.m2505o(65121);
    }

    @Deprecated
    public void destroy() {
        AppMethodBeat.m2504i(65131);
        if (this.f17989e != null) {
            m88581a("destroyX5JsCore", new Class[]{Object.class}, this.f17989e);
            this.f17989e = null;
            AppMethodBeat.m2505o(65131);
            return;
        }
        if (this.f17990f != null) {
            this.f17990f.clearHistory();
            this.f17990f.clearCache(true);
            this.f17990f.loadUrl("about:blank");
            this.f17990f.freeMemory();
            this.f17990f.pauseTimers();
            this.f17990f.destroy();
            this.f17990f = null;
        }
        AppMethodBeat.m2505o(65131);
    }

    @Deprecated
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(65123);
        if (this.f17989e != null) {
            m88581a("evaluateJavascript", new Class[]{String.class, ValueCallback.class, Object.class}, str, valueCallback, this.f17989e);
            AppMethodBeat.m2505o(65123);
            return;
        }
        if (this.f17990f != null) {
            this.f17990f.evaluateJavascript(str, valueCallback);
        }
        AppMethodBeat.m2505o(65123);
    }

    @Deprecated
    public ByteBuffer getNativeBuffer(int i) {
        AppMethodBeat.m2504i(65130);
        if (this.f17989e != null && canX5JsCoreUseNativeBuffer(this.f17988d)) {
            Object a = m88581a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.f17989e, Integer.valueOf(i));
            if (a != null && (a instanceof ByteBuffer)) {
                ByteBuffer byteBuffer = (ByteBuffer) a;
                AppMethodBeat.m2505o(65130);
                return byteBuffer;
            }
        }
        AppMethodBeat.m2505o(65130);
        return null;
    }

    @Deprecated
    public int getNativeBufferId() {
        AppMethodBeat.m2504i(65128);
        if (this.f17989e != null && canX5JsCoreUseNativeBuffer(this.f17988d)) {
            Object a = m88581a("getNativeBufferId", new Class[]{Object.class}, this.f17989e);
            if (a != null && (a instanceof Integer)) {
                int intValue = ((Integer) a).intValue();
                AppMethodBeat.m2505o(65128);
                return intValue;
            }
        }
        AppMethodBeat.m2505o(65128);
        return -1;
    }

    @Deprecated
    public void pause() {
        AppMethodBeat.m2504i(65126);
        if (this.f17989e != null) {
            m88581a("pause", new Class[]{Object.class}, this.f17989e);
        }
        AppMethodBeat.m2505o(65126);
    }

    @Deprecated
    public void pauseTimers() {
        AppMethodBeat.m2504i(65124);
        if (this.f17989e != null) {
            m88581a("pauseTimers", new Class[]{Object.class}, this.f17989e);
        }
        AppMethodBeat.m2505o(65124);
    }

    @Deprecated
    public void removeJavascriptInterface(String str) {
        AppMethodBeat.m2504i(65122);
        if (this.f17989e != null) {
            m88581a("removeJavascriptInterface", new Class[]{String.class, Object.class}, str, this.f17989e);
            AppMethodBeat.m2505o(65122);
            return;
        }
        if (this.f17990f != null) {
            this.f17990f.removeJavascriptInterface(str);
        }
        AppMethodBeat.m2505o(65122);
    }

    @Deprecated
    public void resume() {
        AppMethodBeat.m2504i(65127);
        if (this.f17989e != null) {
            m88581a("resume", new Class[]{Object.class}, this.f17989e);
        }
        AppMethodBeat.m2505o(65127);
    }

    @Deprecated
    public void resumeTimers() {
        AppMethodBeat.m2504i(65125);
        if (this.f17989e != null) {
            m88581a("resumeTimers", new Class[]{Object.class}, this.f17989e);
        }
        AppMethodBeat.m2505o(65125);
    }

    @Deprecated
    public void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(65129);
        if (this.f17989e != null && canX5JsCoreUseNativeBuffer(this.f17988d)) {
            m88581a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.f17989e, Integer.valueOf(i), byteBuffer);
        }
        AppMethodBeat.m2505o(65129);
    }
}
