package com.tencent.p177mm.splash;

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
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.splash.C5102a.C5101a;
import com.tencent.p177mm.splash.C5126o.C5125a;
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

/* renamed from: com.tencent.mm.splash.h */
public class C5115h {
    static C5105d ceX;
    public static final ArrayList<C5117i> xGC = new ArrayList();
    public static final ArrayList<Message> xGD = new ArrayList();
    static Application xGE;
    static String xGF;
    static C5106e xGG;
    static C5103b xGH;
    static C5107f xGI;
    static Set<SplashActivity> xGJ = new HashSet();
    private static boolean xGK = false;
    private static volatile boolean xGL = false;
    private static boolean xGM = false;
    private static C5126o xGN;
    private static boolean xGO = false;
    static C5104c xGP;
    private static Class<? extends SplashActivity> xGQ;
    private static Class<? extends Activity> xGR;
    private static C5124n xGS = new C5124n();
    private static HashSet<String> xGT = new HashSet();
    private static boolean xGU = false;
    @SuppressLint({"HandlerLeak"})
    private static Handler xGV = new Handler(Looper.getMainLooper()) {

        /* renamed from: com.tencent.mm.splash.h$3$1 */
        class C51121 implements C5101a {
            C51121() {
            }

            public final void dqV() {
                AppMethodBeat.m2504i(114830);
                C5115h.m7762BK();
                AppMethodBeat.m2505o(114830);
            }

            public final void cmC() {
                AppMethodBeat.m2504i(114831);
                C5115h.m7780g("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
                C5115h.bZk();
                AppMethodBeat.m2505o(114831);
            }

            public final void dqW() {
                AppMethodBeat.m2504i(114832);
                C5115h.m7780g("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
                C5115h.bZk();
                AppMethodBeat.m2505o(114832);
            }
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(114833);
            super.handleMessage(message);
            if (message.what == 0) {
                C5115h.m7762BK();
                AppMethodBeat.m2505o(114833);
                return;
            }
            C5102a.m7742he(C5115h.xGE);
            C5102a.m7735a(new C51121());
            AppMethodBeat.m2505o(114833);
        }
    };

    /* renamed from: com.tencent.mm.splash.h$2 */
    static class C51102 implements Runnable {
        C51102() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114829);
            if (!C5115h.xGU) {
                C5115h.m7780g("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
                C5115h.drh().mo10503m(675, 32, 1);
                C5115h.access$100();
            }
            AppMethodBeat.m2505o(114829);
        }
    }

    /* renamed from: com.tencent.mm.splash.h$4 */
    static class C51144 implements Runnable {

        /* renamed from: com.tencent.mm.splash.h$4$1 */
        class C51131 implements Runnable {
            C51131() {
            }

            public final void run() {
                AppMethodBeat.m2504i(114834);
                C5115h.xGV.sendEmptyMessage(C5102a.m7740hc(C5115h.xGE) ? 1 : 0);
                AppMethodBeat.m2505o(114834);
            }
        }

        C51144() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114835);
            C7305d.post(new C51131(), "checking-need-dexopt");
            AppMethodBeat.m2505o(114835);
        }
    }

    /* renamed from: com.tencent.mm.splash.h$5 */
    static class C51165 implements C5125a {
        C51165() {
        }

        public final void drj() {
            AppMethodBeat.m2504i(114836);
            C5115h.m7763BM();
            AppMethodBeat.m2505o(114836);
        }

        public final void done() {
            AppMethodBeat.m2504i(114837);
            C5115h.m7780g("WxSplash.Splash", "told me done.", new Object[0]);
            C5115h.aLT();
            AppMethodBeat.m2505o(114837);
        }
    }

    /* renamed from: BK */
    static /* synthetic */ void m7762BK() {
        AppMethodBeat.m2504i(114856);
        C5115h.drf();
        AppMethodBeat.m2505o(114856);
    }

    static /* synthetic */ void aLT() {
        AppMethodBeat.m2504i(114858);
        C5115h.dre();
        AppMethodBeat.m2505o(114858);
    }

    static {
        AppMethodBeat.m2504i(114859);
        AppMethodBeat.m2505o(114859);
    }

    /* renamed from: a */
    static void m7765a(SplashActivity splashActivity) {
        AppMethodBeat.m2504i(114838);
        xGJ.add(splashActivity);
        AppMethodBeat.m2505o(114838);
    }

    /* renamed from: b */
    static void m7777b(SplashActivity splashActivity) {
        AppMethodBeat.m2504i(114839);
        xGJ.remove(splashActivity);
        AppMethodBeat.m2505o(114839);
    }

    /* renamed from: an */
    public static String m7774an(Activity activity) {
        if (activity instanceof C5117i) {
            return ((C5117i) activity).xHe;
        }
        return "";
    }

    public static void aoa(String str) {
        AppMethodBeat.m2504i(114840);
        xGT.add(str);
        AppMethodBeat.m2505o(114840);
    }

    /* renamed from: a */
    public static void m7772a(C5126o c5126o) {
        xGN = c5126o;
    }

    /* renamed from: ay */
    public static void m7775ay(Class<? extends SplashActivity> cls) {
        xGQ = cls;
    }

    /* renamed from: az */
    public static void m7776az(Class<? extends Activity> cls) {
        xGR = cls;
    }

    /* renamed from: a */
    public static void m7767a(C5104c c5104c) {
        xGP = c5104c;
    }

    /* renamed from: a */
    public static void m7769a(C5106e c5106e) {
        xGG = c5106e;
    }

    /* renamed from: a */
    public static void m7768a(C5105d c5105d) {
        ceX = c5105d;
    }

    /* renamed from: a */
    public static void m7766a(C5103b c5103b) {
        xGH = c5103b;
    }

    /* renamed from: a */
    public static void m7770a(C5107f c5107f) {
        xGI = c5107f;
    }

    /* renamed from: hh */
    public static void m7781hh(Context context) {
        Object obj = 1;
        AppMethodBeat.m2504i(114841);
        try {
            ComponentName gV = C5046bo.m7561gV(context);
            if (gV == null || !gV.getPackageName().equals(context.getPackageName()) || xGF == null || !gV.getClassName().equals(xGF)) {
                if (gV != null) {
                    if (gV.getPackageName().startsWith("com.excelliance")) {
                        C5115h.m7780g("WxSplash.Splash", "it is dual open", new Object[0]);
                    }
                }
                obj = null;
            } else {
                C5115h.m7780g("WxSplash.Splash", "it is LauncherUI", new Object[0]);
            }
            if (obj == null) {
                C5115h.m7780g("WxSplash.Splash", "do nothing and return.", new Object[0]);
                AppMethodBeat.m2505o(114841);
                return;
            }
            xGS.mo10503m(675, 36, 1);
            String dqR = C5102a.dqR();
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
            AppMethodBeat.m2505o(114841);
        } catch (IOException e) {
            C5115h.m7773a(e, "request fig leaf failed.");
            AppMethodBeat.m2505o(114841);
        }
    }

    public static void aob(String str) {
        xGF = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public static synchronized boolean m7782i(Application application) {
        boolean z;
        synchronized (C5115h.class) {
            AppMethodBeat.m2504i(114842);
            if (xGM) {
                C5115h.m7780g("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
                z = true;
                AppMethodBeat.m2505o(114842);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                xGE = application;
                xGS.mo10503m(675, 4, 1);
                try {
                    Class cls = Class.forName("android.app.ActivityManagerNative");
                    Method declaredMethod = cls.getDeclaredMethod("getDefault", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(cls, new Object[0]);
                    if (invoke != null) {
                        C5115h.m7780g("WxSplash.Splash", "getDefault %s", invoke);
                        if (invoke.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin")) {
                            xGS.mo10503m(675, 33, 1);
                            C5115h.m7780g("WxSplash.Splash", "found using droidplugin", new Object[0]);
                        }
                        if (Proxy.isProxyClass(invoke.getClass())) {
                            C5115h.m7780g("WxSplash.Splash", "found ActivityManager is a Proxy class, " + invoke.getClass(), new Object[0]);
                        }
                    }
                    try {
                        Object obj;
                        Object cS = C5115h.m7778cS(application);
                        Field declaredField = cS.getClass().getDeclaredField("mInstrumentation");
                        declaredField.setAccessible(true);
                        Instrumentation instrumentation = (Instrumentation) declaredField.get(cS);
                        if (Object.class != instrumentation.getClass().getSuperclass()) {
                            String canonicalName = instrumentation.getClass().getCanonicalName();
                            if (canonicalName.startsWith("android.support.test") || canonicalName.startsWith("android.test")) {
                                C5115h.m7780g("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
                                obj = 1;
                                if (obj == null) {
                                    z = false;
                                    AppMethodBeat.m2505o(114842);
                                } else if (instrumentation == null) {
                                    NullPointerException nullPointerException = new NullPointerException("Instrumentation original should not be null.");
                                    AppMethodBeat.m2505o(114842);
                                    throw nullPointerException;
                                } else if (Object.class != instrumentation.getClass().getSuperclass()) {
                                    xGS.mo10503m(675, 7, 1);
                                    C5115h.m7780g("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", instrumentation.getClass(), instrumentation.getClass().getSuperclass());
                                    canonicalName = instrumentation.getClass().getCanonicalName();
                                    RuntimeException runtimeException = new RuntimeException("invalid environment for hack, " + instrumentation.getClass());
                                    if (canonicalName.startsWith(new String[]{"com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo"}[0])) {
                                        xGS.mo10503m(675, 30, 1);
                                        C5115h.m7780g("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
                                    }
                                    xGS.mo10503m(675, 0, 1);
                                    AppMethodBeat.m2505o(114842);
                                    throw runtimeException;
                                } else {
                                    if (instrumentation instanceof C5119k) {
                                        C5115h.m7780g("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
                                    } else {
                                        declaredField.set(cS, new C5119k(instrumentation));
                                    }
                                    C5120l.cfv = cS;
                                    Field declaredField2 = cS.getClass().getDeclaredField("mH");
                                    declaredField2.setAccessible(true);
                                    Handler handler = (Handler) declaredField2.get(cS);
                                    if (handler == null) {
                                        RuntimeException runtimeException2 = new RuntimeException("mH is null!");
                                        AppMethodBeat.m2505o(114842);
                                        throw runtimeException2;
                                    }
                                    C5120l.xHt = handler;
                                    Field declaredField3 = Handler.class.getDeclaredField("mCallback");
                                    declaredField3.setAccessible(true);
                                    Callback callback = (Callback) declaredField3.get(handler);
                                    C5120l.xHz = declaredField3;
                                    if (callback != null) {
                                        C5115h.m7780g("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", callback);
                                        xGS.mo10503m(675, 8, 1);
                                    }
                                    if (callback == null || !(callback instanceof C5118j)) {
                                        C5118j c5118j = new C5118j(application, callback);
                                        declaredField3.setAccessible(true);
                                        declaredField3.set(handler, c5118j);
                                        C5120l.xHy = c5118j;
                                    } else {
                                        C5115h.m7780g("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
                                    }
                                    handler = new Handler();
                                    C5118j.m7784av(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(114828);
                                            C5115h.xGU = true;
                                            handler.removeCallbacksAndMessages(null);
                                            C5115h.m7780g("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
                                            AppMethodBeat.m2505o(114828);
                                        }
                                    });
                                    C5120l.xHt.sendEmptyMessage(987654321);
                                    handler.postDelayed(new C51102(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                                    if (xGT.size() > 0 || !C5108g.f1294wY) {
                                        Method declaredMethod2 = cS.getClass().getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                                        declaredMethod2.setAccessible(true);
                                        C5120l.xHx = declaredMethod2;
                                        declaredField2 = cS.getClass().getDeclaredField("mBoundApplication");
                                        declaredField2.setAccessible(true);
                                        invoke = declaredField2.get(cS);
                                        C5120l.xHu = invoke;
                                        Field declaredField4 = invoke.getClass().getDeclaredField("restrictedBackupMode");
                                        declaredField4.setAccessible(true);
                                        if (!C5108g.f1294wY) {
                                            declaredField4.set(invoke, Boolean.TRUE);
                                        }
                                        declaredField4 = invoke.getClass().getDeclaredField("providers");
                                        declaredField4.setAccessible(true);
                                        C5120l.xHw = (List) declaredField4.get(invoke);
                                        Iterator it = xGT.iterator();
                                        while (it.hasNext()) {
                                            canonicalName = (String) it.next();
                                            for (Object invoke2 : C5120l.xHw) {
                                                if (invoke2.name != null && invoke2.name.equals(canonicalName)) {
                                                    break;
                                                }
                                            }
                                            invoke2 = null;
                                            C5120l.xHw.remove(invoke2);
                                        }
                                    }
                                    xGM = true;
                                    xGK = true;
                                    C5115h.m7780g("WxSplash.Splash", "splash hack success.", new Object[0]);
                                    C5115h.m7780g("WxSplash.Splash", "we need splash. time spent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    z = true;
                                    AppMethodBeat.m2505o(114842);
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                        }
                    } catch (Exception e) {
                        C5115h.m7773a(e, "splash hack error!");
                        z = false;
                        AppMethodBeat.m2505o(114842);
                    }
                } catch (Exception e2) {
                    C5115h.m7773a(e2, "validateEnvironment found some thing.");
                }
            }
        }
        return z;
    }

    public static void dqY() {
        boolean z = true;
        AppMethodBeat.m2504i(114843);
        if (xGM) {
            try {
                Callback callback = (Callback) C5120l.xHz.get(C5120l.xHt);
                String str = "WxSplash.Splash";
                String str2 = "double check, callback %s %s";
                Object[] objArr = new Object[2];
                if (callback != C5120l.xHy) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = callback;
                C5115h.m7780g(str, str2, objArr);
                if (callback == C5120l.xHy) {
                    AppMethodBeat.m2505o(114843);
                    return;
                }
                C5115h.m7780g("WxSplash.Splash", "double check found problem!", new Object[0]);
                Field field = C5120l.xHz;
                C5120l.xHy.oUK = callback;
                field.setAccessible(true);
                field.set(C5120l.xHt, C5120l.xHy);
                xGS.mo10503m(675, 31, 1);
                C5120l.xHt.sendEmptyMessage(987654321);
                AppMethodBeat.m2505o(114843);
                return;
            } catch (Exception e) {
                C5115h.m7773a(e, "double check exception.");
            }
        }
        AppMethodBeat.m2505o(114843);
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
        AppMethodBeat.m2504i(114844);
        Process.killProcess(Process.myPid());
        AppMethodBeat.m2505o(114844);
    }

    public static void drc() {
        AppMethodBeat.m2504i(114845);
        if (C5108g.f1294wY) {
            xGV.sendEmptyMessage(0);
            AppMethodBeat.m2505o(114845);
            return;
        }
        xGV.postDelayed(new C51144(), 150);
        AppMethodBeat.m2505o(114845);
    }

    /* renamed from: u */
    public static void m7783u(Message message) {
        AppMethodBeat.m2504i(114846);
        C5120l.xHt.sendMessage(message);
        AppMethodBeat.m2505o(114846);
    }

    private static void drd() {
        AppMethodBeat.m2504i(114847);
        C5115h.m7780g("WxSplash.Splash", "Gonna replay %s pending message(s).", Integer.valueOf(xGD.size()));
        Iterator it = xGD.iterator();
        while (it.hasNext()) {
            C5115h.m7783u((Message) it.next());
        }
        xGD.clear();
        AppMethodBeat.m2505o(114847);
    }

    private static void dre() {
        AppMethodBeat.m2504i(114848);
        C5115h.m7780g("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
        xGK = false;
        int size = xGJ.size();
        for (SplashActivity splashActivity : xGJ) {
            C5115h.m7780g("WxSplash.Splash", "iterate splash activity %s.", splashActivity);
            splashActivity.drl();
        }
        if (size == 0) {
            C5115h.m7780g("WxSplash.Splash", "no splash activity found, so we terminate hacked activities manually.", new Object[0]);
            Iterator it = xGC.iterator();
            while (it.hasNext()) {
                C5115h.m7771a((C5117i) it.next());
            }
        }
        C5115h.m7780g("WxSplash.Splash", "resend all %s pending message. ", Integer.valueOf(xGD.size()));
        if (!xGL) {
            C5115h.drd();
        }
        xGN = null;
        C5115h.m7780g("WxSplash.Splash", "we need splash no more.", new Object[0]);
        synchronized (C5115h.class) {
            try {
                xGO = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114848);
            }
        }
        C5124n c5124n = xGS;
        if (c5124n.mStartTimestamp > 0) {
            long currentTimeMillis = System.currentTimeMillis() - c5124n.mStartTimestamp;
            if (C5108g.f1294wY) {
                c5124n.mo10503m(676, 1, 1);
                c5124n.mo10503m(676, 3, currentTimeMillis);
                return;
            }
            c5124n.mo10503m(676, 0, 1);
            c5124n.mo10503m(676, 2, currentTimeMillis);
        }
        AppMethodBeat.m2505o(114848);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:40:0x005d, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:?, code skipped:
            xGS.mo10503m(675, 11, 1);
            com.tencent.p177mm.splash.C5115h.m7773a(r2, "install provider failed!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void drf() {
        synchronized (C5115h.class) {
            AppMethodBeat.m2504i(114849);
            C5102a.m7741hd(xGE);
            synchronized (C5115h.class) {
                try {
                    int i = xGO;
                    if (i != 0) {
                        AppMethodBeat.m2505o(i);
                    } else {
                        xGO = true;
                        if (!xGM) {
                            C5115h.m7780g("WxSplash.Splash", "not hacked, return.", new Object[0]);
                        } else if (C5108g.f1294wY) {
                            C5115h.m7780g("WxSplash.Splash", "not hack content provider, return.", new Object[0]);
                        } else if (!(C5120l.xHw == null || C5120l.xHw.size() == 0)) {
                            xGS.mo10503m(675, 10, 1);
                            Object obj = C5120l.cfv;
                            Field declaredField = obj.getClass().getDeclaredField("mInitialApplication");
                            declaredField.setAccessible(true);
                            Object obj2 = declaredField.get(obj);
                            C5120l.xHv = (Application) obj2;
                            if (obj2 == null) {
                                C5115h.m7780g("WxSplash.Splash", "mInitialApplication is null, use mine. ", new Object[0]);
                                obj2 = xGE;
                            }
                            try {
                                Class.forName("com.tencent.mm.plugin.base.stub.WXCommProvider");
                                Class.forName("com.tencent.mm.plugin.base.stub.WXCommProvider$1");
                                C5115h.m7780g("WxSplash.Splash", "WXCommProvider is ok", new Object[0]);
                            } catch (Throwable th) {
                                C5115h.m7773a(th, "before install provider, we found a weird thing.");
                            }
                            C5115h.m7780g("WxSplash.Splash", "before delay install ContentProviders. ", new Object[0]);
                            C5120l.xHx.invoke(obj, new Object[]{obj2, C5120l.xHw});
                            C5115h.m7780g("WxSplash.Splash", "delay install ContentProviders. ", new Object[0]);
                            C5120l.xHw.clear();
                        }
                        if (xGN == null) {
                            C5115h.dre();
                            AppMethodBeat.m2505o(114849);
                        } else {
                            xGN.mo10502d(new C51165());
                            AppMethodBeat.m2505o(114849);
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(114849);
                }
            }
        }
        return;
    }

    /* renamed from: cV */
    private static boolean m7779cV(String str) {
        AppMethodBeat.m2504i(114850);
        if (ceX != null) {
            boolean cV = ceX.mo10477cV(str);
            AppMethodBeat.m2505o(114850);
            return cV;
        }
        AppMethodBeat.m2505o(114850);
        return false;
    }

    /* renamed from: a */
    public static void m7771a(C5117i c5117i) {
        AppMethodBeat.m2504i(114851);
        if (C5115h.m7779cV(c5117i.xHe)) {
            c5117i.finish();
            C5115h.m7780g("WxSplash.Splash", "eat activity, %s", c5117i.xHe);
            AppMethodBeat.m2505o(114851);
            return;
        }
        c5117i.recreate();
        C5115h.m7780g("WxSplash.Splash", "do recreate for %s", c5117i.xHe);
        AppMethodBeat.m2505o(114851);
    }

    public static Class<? extends Activity> drg() {
        return xGQ;
    }

    /* renamed from: cS */
    private static Object m7778cS(Context context) {
        AppMethodBeat.m2504i(114852);
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            AppMethodBeat.m2505o(114852);
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        invoke = declaredField.get(invoke);
        AppMethodBeat.m2505o(114852);
        return invoke;
    }

    /* renamed from: g */
    public static void m7780g(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(114853);
        if (xGP != null) {
            xGP.mo4566g(str, str2, objArr);
        }
        AppMethodBeat.m2505o(114853);
    }

    /* renamed from: a */
    public static void m7773a(Throwable th, String str) {
        AppMethodBeat.m2504i(114854);
        if (xGP != null) {
            xGP.mo4565a(th, str);
        }
        AppMethodBeat.m2505o(114854);
    }

    public static C5124n drh() {
        return xGS;
    }

    static /* synthetic */ void access$100() {
        boolean z = true;
        AppMethodBeat.m2504i(114855);
        try {
            boolean z2;
            Object cS = C5115h.m7778cS(xGE);
            String str = "WxSplash.Splash";
            String str2 = "spy, activityThread %s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(cS == C5120l.cfv);
            C5115h.m7780g(str, str2, objArr);
            Field declaredField = cS.getClass().getDeclaredField("mH");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(cS);
            str = "WxSplash.Splash";
            str2 = "spy, ActivityThread_mH %s";
            objArr = new Object[1];
            if (handler == C5120l.xHt) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            C5115h.m7780g(str, str2, objArr);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            Callback callback = (Callback) declaredField2.get(handler);
            String str3 = "WxSplash.Splash";
            str = "spy, callback %s %s";
            Object[] objArr2 = new Object[2];
            if (callback != C5120l.xHy) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            objArr2[1] = callback;
            C5115h.m7780g(str3, str, objArr2);
            AppMethodBeat.m2505o(114855);
        } catch (Exception e) {
            C5115h.m7773a(e, "spy failed.");
            AppMethodBeat.m2505o(114855);
        }
    }

    /* renamed from: BM */
    static /* synthetic */ void m7763BM() {
        AppMethodBeat.m2504i(114857);
        xGL = true;
        C5115h.m7780g("WxSplash.Splash", "pending early replay %s", Boolean.valueOf(xGL));
        C5115h.drd();
        AppMethodBeat.m2505o(114857);
    }
}
