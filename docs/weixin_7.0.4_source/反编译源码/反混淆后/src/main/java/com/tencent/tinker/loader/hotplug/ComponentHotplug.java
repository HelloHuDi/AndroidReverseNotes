package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.handler.MHMessageHandler;
import com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.TinkerHackInstrumentation;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;

public final class ComponentHotplug {
    private static volatile boolean ABB = false;
    private static ServiceBinderInterceptor ADk;
    private static ServiceBinderInterceptor ADl;
    private static HandlerMessageInterceptor ADm;
    private static TinkerHackInstrumentation ADn;

    /* renamed from: a */
    public static synchronized void m9324a(TinkerApplication tinkerApplication, ShareSecurityCheck shareSecurityCheck) {
        synchronized (ComponentHotplug.class) {
            if (!ABB) {
                try {
                    if (IncrementComponentManager.m9331a((Context) tinkerApplication, shareSecurityCheck)) {
                        ADk = new ServiceBinderInterceptor(tinkerApplication, "activity", new AMSInterceptHandler(tinkerApplication));
                        ADl = new ServiceBinderInterceptor(tinkerApplication, "package", new PMSInterceptHandler());
                        ADk.dSn();
                        ADl.dSn();
                        if (VERSION.SDK_INT < 27) {
                            HandlerMessageInterceptor handlerMessageInterceptor = new HandlerMessageInterceptor(m9325jf(tinkerApplication), new MHMessageHandler(tinkerApplication));
                            ADm = handlerMessageInterceptor;
                            handlerMessageInterceptor.dSn();
                        } else {
                            TinkerHackInstrumentation jg = TinkerHackInstrumentation.m9342jg(tinkerApplication);
                            ADn = jg;
                            jg.dSn();
                        }
                        ABB = true;
                    }
                } catch (Throwable th) {
                    uninstall();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    public static synchronized void dSl() {
        synchronized (ComponentHotplug.class) {
            if (ABB) {
                try {
                    ADk.dSn();
                    ADl.dSn();
                    if (VERSION.SDK_INT < 27) {
                        ADm.dSn();
                    } else {
                        ADn.dSn();
                    }
                } catch (Throwable th) {
                    uninstall();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    /* renamed from: jf */
    private static Handler m9325jf(Context context) {
        Object d = ShareReflectUtil.m9399d(context, null);
        if (d == null) {
            throw new IllegalStateException("failed to fetch instance of ActivityThread.");
        }
        try {
            return (Handler) ShareReflectUtil.m9395b(d, "mH").get(d);
        } catch (Throwable th) {
            IllegalStateException illegalStateException = new IllegalStateException(th);
        }
    }

    private static synchronized void uninstall() {
        synchronized (ComponentHotplug.class) {
            if (ABB) {
                try {
                    ADk.uninstall();
                    ADl.uninstall();
                    if (VERSION.SDK_INT < 27) {
                        ADm.uninstall();
                    } else {
                        TinkerHackInstrumentation tinkerHackInstrumentation = ADn;
                        tinkerHackInstrumentation.ADK.set(tinkerHackInstrumentation.ADJ, tinkerHackInstrumentation.ADI);
                    }
                } catch (Throwable th) {
                }
                ABB = false;
            }
        }
    }

    private ComponentHotplug() {
        throw new UnsupportedOperationException();
    }
}
