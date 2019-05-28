package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.splash.a.a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class h {
    static d ceX;
    public static final ArrayList<i> xGC = new ArrayList();
    public static final ArrayList<Message> xGD = new ArrayList();
    static Application xGE;
    static String xGF;
    static e xGG;
    static b xGH;
    static f xGI;
    static Set<SplashActivity> xGJ = new HashSet();
    private static boolean xGK = false;
    private static volatile boolean xGL = false;
    private static boolean xGM = false;
    private static o xGN;
    private static boolean xGO = false;
    static c xGP;
    private static Class<? extends SplashActivity> xGQ;
    private static Class<? extends Activity> xGR;
    private static n xGS = new n();
    private static HashSet<String> xGT = new HashSet();
    private static boolean xGU = false;
    @SuppressLint({"HandlerLeak"})
    private static Handler xGV = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(114833);
            super.handleMessage(message);
            if (message.what == 0) {
                h.BK();
                AppMethodBeat.o(114833);
                return;
            }
            a.he(h.xGE);
            a.a(new a() {
                public final void dqV() {
                    AppMethodBeat.i(114830);
                    h.BK();
                    AppMethodBeat.o(114830);
                }

                public final void cmC() {
                    AppMethodBeat.i(114831);
                    h.g("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
                    h.bZk();
                    AppMethodBeat.o(114831);
                }

                public final void dqW() {
                    AppMethodBeat.i(114832);
                    h.g("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
                    h.bZk();
                    AppMethodBeat.o(114832);
                }
            });
            AppMethodBeat.o(114833);
        }
    };

    static /* synthetic */ void BK() {
        AppMethodBeat.i(114856);
        drf();
        AppMethodBeat.o(114856);
    }

    static /* synthetic */ void aLT() {
        AppMethodBeat.i(114858);
        dre();
        AppMethodBeat.o(114858);
    }

    static {
        AppMethodBeat.i(114859);
        AppMethodBeat.o(114859);
    }

    static void a(SplashActivity splashActivity) {
        AppMethodBeat.i(114838);
        xGJ.add(splashActivity);
        AppMethodBeat.o(114838);
    }

    static void b(SplashActivity splashActivity) {
        AppMethodBeat.i(114839);
        xGJ.remove(splashActivity);
        AppMethodBeat.o(114839);
    }

    public static String an(Activity activity) {
        if (activity instanceof i) {
            return ((i) activity).xHe;
        }
        return "";
    }

    public static void aoa(String str) {
        AppMethodBeat.i(114840);
        xGT.add(str);
        AppMethodBeat.o(114840);
    }

    public static void a(o oVar) {
        xGN = oVar;
    }

    public static void ay(Class<? extends SplashActivity> cls) {
        xGQ = cls;
    }

    public static void az(Class<? extends Activity> cls) {
        xGR = cls;
    }

    public static void a(c cVar) {
        xGP = cVar;
    }

    public static void a(e eVar) {
        xGG = eVar;
    }

    public static void a(d dVar) {
        ceX = dVar;
    }

    public static void a(b bVar) {
        xGH = bVar;
    }

    public static void a(f fVar) {
        xGI = fVar;
    }

    public static void hh(Context context) {
        Object obj = 1;
        AppMethodBeat.i(114841);
        try {
            ComponentName gV = bo.gV(context);
            if (gV == null || !gV.getPackageName().equals(context.getPackageName()) || xGF == null || !gV.getClassName().equals(xGF)) {
                if (gV != null) {
                    if (gV.getPackageName().startsWith("com.excelliance")) {
                        g("WxSplash.Splash", "it is dual open", new Object[0]);
                    }
                }
                obj = null;
            } else {
                g("WxSplash.Splash", "it is LauncherUI", new Object[0]);
            }
            if (obj == null) {
                g("WxSplash.Splash", "do nothing and return.", new Object[0]);
                AppMethodBeat.o(114841);
                return;
            }
            xGS.m(675, 36, 1);
            String dqR = a.dqR();
            File file = new File(dqR);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(dqR + "/main-process-blocking");
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                Intent intent = new Intent(context, xGR);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
            AppMethodBeat.o(114841);
        } catch (IOException e) {
            a(e, "request fig leaf failed.");
            AppMethodBeat.o(114841);
        }
    }

    public static void aob(String str) {
        xGF = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean i(Application application) {
        boolean z;
        synchronized (h.class) {
            AppMethodBeat.i(114842);
            if (xGM) {
                g("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
                z = true;
                AppMethodBeat.o(114842);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                xGE = application;
                xGS.m(675, 4, 1);
                try {
                    Class cls = Class.forName("android.app.ActivityManagerNative");
                    Method declaredMethod = cls.getDeclaredMethod("getDefault", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(cls, new Object[0]);
                    if (invoke != null) {
                        g("WxSplash.Splash", "getDefault %s", invoke);
                        if (invoke.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin")) {
                            xGS.m(675, 33, 1);
                            g("WxSplash.Splash", "found using droidplugin", new Object[0]);
                        }
                        if (Proxy.isProxyClass(invoke.getClass())) {
                            g("WxSplash.Splash", "found ActivityManager is a Proxy class, " + invoke.getClass(), new Object[0]);
                        }
                    }
                    try {
                        Object obj;
                        Object cS = cS(application);
                        Field declaredField = cS.getClass().getDeclaredField("mInstrumentation");
                        declaredField.setAccessible(true);
                        Instrumentation instrumentation = (Instrumentation) declaredField.get(cS);
                        if (Object.class != instrumentation.getClass().getSuperclass()) {
                            String canonicalName = instrumentation.getClass().getCanonicalName();
                            if (canonicalName.startsWith("android.support.test") || canonicalName.startsWith("android.test")) {
                                g("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
                                obj = 1;
                                if (obj == null) {
                                    z = false;
                                    AppMethodBeat.o(114842);
                                } else if (instrumentation == null) {
                                    NullPointerException nullPointerException = new NullPointerException("Instrumentation original should not be null.");
                                    AppMethodBeat.o(114842);
                                    throw nullPointerException;
                                } else if (Object.class != instrumentation.getClass().getSuperclass()) {
                                    xGS.m(675, 7, 1);
                                    g("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", instrumentation.getClass(), instrumentation.getClass().getSuperclass());
                                    canonicalName = instrumentation.getClass().getCanonicalName();
                                    RuntimeException runtimeException = new RuntimeException("invalid environment for hack, " + instrumentation.getClass());
                                    if (canonicalName.startsWith(new String[]{"com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo"}[0])) {
                                        xGS.m(675, 30, 1);
                                        g("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
                                    }
                                    xGS.m(675, 0, 1);
                                    AppMethodBeat.o(114842);
                                    throw runtimeException;
                                } else {
                                    if (instrumentation instanceof k) {
                                        g("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
                                    } else {
                                        declaredField.set(cS, new k(instrumentation));
                                    }
                                    l.cfv = cS;
                                    Field declaredField2 = cS.getClass().getDeclaredField("mH");
                                    declaredField2.setAccessible(true);
                                    Handler handler = (Handler) declaredField2.get(cS);
                                    if (handler == null) {
                                        RuntimeException runtimeException2 = new RuntimeException("mH is null!");
                                        AppMethodBeat.o(114842);
                                        throw runtimeException2;
                                    }
                                    l.xHt = handler;
                                    Field declaredField3 = Handler.class.getDeclaredField("mCallback");
                                    declaredField3.setAccessible(true);
                                    Callback callback = (Callback) declaredField3.get(handler);
                                    l.xHz = declaredField3;
                                    if (callback != null) {
                                        g("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", callback);
                                        xGS.m(675, 8, 1);
                                    }
                                    if (callback == null || !(callback instanceof j)) {
                                        j jVar = new j(application, callback);
                                        declaredField3.setAccessible(true);
                                        declaredField3.set(handler, jVar);
                                        l.xHy = jVar;
                                    } else {
                                        g("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
                                    }
                                    handler = new Handler();
                                    j.av(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(114828);
                                            h.xGU = true;
                                            handler.removeCallbacksAndMessages(null);
                                            h.g("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
                                            AppMethodBeat.o(114828);
                                        }
                                    });
                                    l.xHt.sendEmptyMessage(987654321);
                                    handler.postDelayed(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(114829);
                                            if (!h.xGU) {
                                                h.g("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
                                                h.drh().m(675, 32, 1);
                                                h.access$100();
                                            }
                                            AppMethodBeat.o(114829);
                                        }
                                    }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                                    if (xGT.size() > 0 || !g.wY) {
                                        Method declaredMethod2 = cS.getClass().getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                                        declaredMethod2.setAccessible(true);
                                        l.xHx = declaredMethod2;
                                        declaredField2 = cS.getClass().getDeclaredField("mBoundApplication");
                                        declaredField2.setAccessible(true);
                                        invoke = declaredField2.get(cS);
                                        l.xHu = invoke;
                                        Field declaredField4 = invoke.getClass().getDeclaredField("restrictedBackupMode");
                                        declaredField4.setAccessible(true);
                                        if (!g.wY) {
                                            declaredField4.set(invoke, Boolean.TRUE);
                                        }
                                        declaredField4 = invoke.getClass().getDeclaredField("providers");
                                        declaredField4.setAccessible(true);
                                        l.xHw = (List) declaredField4.get(invoke);
                                        Iterator it = xGT.iterator();
                                        while (it.hasNext()) {
                                            canonicalName = (String) it.next();
                                            for (Object invoke2 : l.xHw) {
                                                if (invoke2.name != null && invoke2.name.equals(canonicalName)) {
                                                    break;
                                                }
                                            }
                                            invoke2 = null;
                                            l.xHw.remove(invoke2);
                                        }
                                    }
                                    xGM = true;
                                    xGK = true;
                                    g("WxSplash.Splash", "splash hack success.", new Object[0]);
                                    g("WxSplash.Splash", "we need splash. time spent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    z = true;
                                    AppMethodBeat.o(114842);
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                        }
                    } catch (Exception e) {
                        a(e, "splash hack error!");
                        z = false;
                        AppMethodBeat.o(114842);
                    }
                } catch (Exception e2) {
                    a(e2, "validateEnvironment found some thing.");
                }
            }
        }
        return z;
    }

    public static void dqY() {
        boolean z = true;
        AppMethodBeat.i(114843);
        if (xGM) {
            try {
                Callback callback = (Callback) l.xHz.get(l.xHt);
                String str = "WxSplash.Splash";
                String str2 = "double check, callback %s %s";
                Object[] objArr = new Object[2];
                if (callback != l.xHy) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = callback;
                g(str, str2, objArr);
                if (callback == l.xHy) {
                    AppMethodBeat.o(114843);
                    return;
                }
                g("WxSplash.Splash", "double check found problem!", new Object[0]);
                Field field = l.xHz;
                l.xHy.oUK = callback;
                field.setAccessible(true);
                field.set(l.xHt, l.xHy);
                xGS.m(675, 31, 1);
                l.xHt.sendEmptyMessage(987654321);
                AppMethodBeat.o(114843);
                return;
            } catch (Exception e) {
                a(e, "double check exception.");
            }
        }
        AppMethodBeat.o(114843);
    }

    public static boolean dqZ() {
        return true;
    }

    public static boolean dra() {
        if (xGK) {
            return true;
        }
        return false;
    }

    public static boolean drb() {
        return xGL;
    }

    public static void bZk() {
        AppMethodBeat.i(114844);
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(114844);
    }

    public static void drc() {
        AppMethodBeat.i(114845);
        if (g.wY) {
            xGV.sendEmptyMessage(0);
            AppMethodBeat.o(114845);
            return;
        }
        xGV.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114835);
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(114834);
                        h.xGV.sendEmptyMessage(a.hc(h.xGE) ? 1 : 0);
                        AppMethodBeat.o(114834);
                    }
                }, "checking-need-dexopt");
                AppMethodBeat.o(114835);
            }
        }, 150);
        AppMethodBeat.o(114845);
    }

    public static void u(Message message) {
        AppMethodBeat.i(114846);
        l.xHt.sendMessage(message);
        AppMethodBeat.o(114846);
    }

    private static void drd() {
        AppMethodBeat.i(114847);
        g("WxSplash.Splash", "Gonna replay %s pending message(s).", Integer.valueOf(xGD.size()));
        Iterator it = xGD.iterator();
        while (it.hasNext()) {
            u((Message) it.next());
        }
        xGD.clear();
        AppMethodBeat.o(114847);
    }

    private static void dre() {
        AppMethodBeat.i(114848);
        g("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
        xGK = false;
        int size = xGJ.size();
        for (SplashActivity splashActivity : xGJ) {
            g("WxSplash.Splash", "iterate splash activity %s.", splashActivity);
            splashActivity.drl();
        }
        if (size == 0) {
            g("WxSplash.Splash", "no splash activity found, so we terminate hacked activities manually.", new Object[0]);
            Iterator it = xGC.iterator();
            while (it.hasNext()) {
                a((i) it.next());
            }
        }
        g("WxSplash.Splash", "resend all %s pending message. ", Integer.valueOf(xGD.size()));
        if (!xGL) {
            drd();
        }
        xGN = null;
        g("WxSplash.Splash", "we need splash no more.", new Object[0]);
        synchronized (h.class) {
            try {
                xGO = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(114848);
            }
        }
        n nVar = xGS;
        if (nVar.mStartTimestamp > 0) {
            long currentTimeMillis = System.currentTimeMillis() - nVar.mStartTimestamp;
            if (g.wY) {
                nVar.m(676, 1, 1);
                nVar.m(676, 3, currentTimeMillis);
                return;
            }
            nVar.m(676, 0, 1);
            nVar.m(676, 2, currentTimeMillis);
        }
        AppMethodBeat.o(114848);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:40:0x005d, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:?, code skipped:
            xGS.m(675, 11, 1);
            a(r2, "install provider failed!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void drf() {
        synchronized (h.class) {
            AppMethodBeat.i(114849);
            a.hd(xGE);
            synchronized (h.class) {
                try {
                    int i = xGO;
                    if (i != 0) {
                        AppMethodBeat.o(i);
                    } else {
                        xGO = true;
                        if (!xGM) {
                            g("WxSplash.Splash", "not hacked, return.", new Object[0]);
                        } else if (g.wY) {
                            g("WxSplash.Splash", "not hack content provider, return.", new Object[0]);
                        } else if (!(l.xHw == null || l.xHw.size() == 0)) {
                            xGS.m(675, 10, 1);
                            Object obj = l.cfv;
                            Field declaredField = obj.getClass().getDeclaredField("mInitialApplication");
                            declaredField.setAccessible(true);
                            Object obj2 = declaredField.get(obj);
                            l.xHv = (Application) obj2;
                            if (obj2 == null) {
                                g("WxSplash.Splash", "mInitialApplication is null, use mine. ", new Object[0]);
                                obj2 = xGE;
                            }
                            try {
                                Class.forName("com.tencent.mm.plugin.base.stub.WXCommProvider");
                                Class.forName("com.tencent.mm.plugin.base.stub.WXCommProvider$1");
                                g("WxSplash.Splash", "WXCommProvider is ok", new Object[0]);
                            } catch (Throwable th) {
                                a(th, "before install provider, we found a weird thing.");
                            }
                            g("WxSplash.Splash", "before delay install ContentProviders. ", new Object[0]);
                            l.xHx.invoke(obj, new Object[]{obj2, l.xHw});
                            g("WxSplash.Splash", "delay install ContentProviders. ", new Object[0]);
                            l.xHw.clear();
                        }
                        if (xGN == null) {
                            dre();
                            AppMethodBeat.o(114849);
                        } else {
                            xGN.d(new o.a() {
                                public final void drj() {
                                    AppMethodBeat.i(114836);
                                    h.BM();
                                    AppMethodBeat.o(114836);
                                }

                                public final void done() {
                                    AppMethodBeat.i(114837);
                                    h.g("WxSplash.Splash", "told me done.", new Object[0]);
                                    h.aLT();
                                    AppMethodBeat.o(114837);
                                }
                            });
                            AppMethodBeat.o(114849);
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(114849);
                }
            }
        }
        return;
    }

    private static boolean cV(String str) {
        AppMethodBeat.i(114850);
        if (ceX != null) {
            boolean cV = ceX.cV(str);
            AppMethodBeat.o(114850);
            return cV;
        }
        AppMethodBeat.o(114850);
        return false;
    }

    public static void a(i iVar) {
        AppMethodBeat.i(114851);
        if (cV(iVar.xHe)) {
            iVar.finish();
            g("WxSplash.Splash", "eat activity, %s", iVar.xHe);
            AppMethodBeat.o(114851);
            return;
        }
        iVar.recreate();
        g("WxSplash.Splash", "do recreate for %s", iVar.xHe);
        AppMethodBeat.o(114851);
    }

    public static Class<? extends Activity> drg() {
        return xGQ;
    }

    private static Object cS(Context context) {
        AppMethodBeat.i(114852);
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            AppMethodBeat.o(114852);
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        invoke = declaredField.get(invoke);
        AppMethodBeat.o(114852);
        return invoke;
    }

    public static void g(String str, String str2, Object... objArr) {
        AppMethodBeat.i(114853);
        if (xGP != null) {
            xGP.g(str, str2, objArr);
        }
        AppMethodBeat.o(114853);
    }

    public static void a(Throwable th, String str) {
        AppMethodBeat.i(114854);
        if (xGP != null) {
            xGP.a(th, str);
        }
        AppMethodBeat.o(114854);
    }

    public static n drh() {
        return xGS;
    }

    static /* synthetic */ void access$100() {
        boolean z = true;
        AppMethodBeat.i(114855);
        try {
            boolean z2;
            Object cS = cS(xGE);
            String str = "WxSplash.Splash";
            String str2 = "spy, activityThread %s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(cS == l.cfv);
            g(str, str2, objArr);
            Field declaredField = cS.getClass().getDeclaredField("mH");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(cS);
            str = "WxSplash.Splash";
            str2 = "spy, ActivityThread_mH %s";
            objArr = new Object[1];
            if (handler == l.xHt) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            g(str, str2, objArr);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            Callback callback = (Callback) declaredField2.get(handler);
            String str3 = "WxSplash.Splash";
            str = "spy, callback %s %s";
            Object[] objArr2 = new Object[2];
            if (callback != l.xHy) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            objArr2[1] = callback;
            g(str3, str, objArr2);
            AppMethodBeat.o(114855);
        } catch (Exception e) {
            a(e, "spy failed.");
            AppMethodBeat.o(114855);
        }
    }

    static /* synthetic */ void BM() {
        AppMethodBeat.i(114857);
        xGL = true;
        g("WxSplash.Splash", "pending early replay %s", Boolean.valueOf(xGL));
        drd();
        AppMethodBeat.o(114857);
    }
}
