package com.tencent.mm.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.util.ArrayMap;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.booter.u;
import com.tencent.mm.cj.c;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;
import org.xwalk.core.XWalkEnvironment;

public final class ToolsProfile extends e {
    private static final String TAG = ("MicroMsg." + com.tencent.mm.cj.a.dOY() + "Profile");
    public static final String ceo = ah.getProcessName();
    private static Locale locale;
    private final ap cfq = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(15408);
            ab.i(ToolsProfile.TAG, "onTimerExpired, check kill tools process");
            if (ToolsProfile.this.cfr == 0) {
                a.BK();
                ab.i(ToolsProfile.TAG, "onTimerExpired, xwebCanReboot = %b", Boolean.valueOf(WebView.getCanReboot()));
                if (WebView.getCanReboot() || !a.isLocked()) {
                    c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                    AppMethodBeat.o(15408);
                    return false;
                }
            }
            AppMethodBeat.o(15408);
            return true;
        }
    }, true);
    private int cfr = 0;

    public static final class a {
        private static final AtomicInteger cfu = new AtomicInteger(0);
        private static Object cfv;

        static {
            AppMethodBeat.i(15419);
            AppMethodBeat.o(15419);
        }

        private static boolean BJ() {
            AppMethodBeat.i(15415);
            try {
                if (cfv == null) {
                    Context context = ah.getContext();
                    Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                    method.setAccessible(true);
                    Object invoke = method.invoke(null, new Object[0]);
                    if (invoke == null) {
                        Field field = context.getClass().getField("mLoadedApk");
                        field.setAccessible(true);
                        invoke = field.get(context);
                        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
                        declaredField.setAccessible(true);
                        invoke = declaredField.get(invoke);
                    }
                    cfv = invoke;
                    ArrayMap arrayMap = (ArrayMap) org.a.a.ep(invoke).awS("mServices").object;
                    if (arrayMap.size() <= 0) {
                        AppMethodBeat.o(15415);
                        return true;
                    } else if (arrayMap.size() == 1 && (arrayMap.values().toArray()[0] instanceof BaseIPCService)) {
                        AppMethodBeat.o(15415);
                        return true;
                    } else {
                        AppMethodBeat.o(15415);
                        return false;
                    }
                }
            } catch (Throwable th) {
                ab.e("MicroMsg.ToolsProcessLocker", "skipServiceConditionIfOnlyIPCServiceAlive, hack ActivityThread_mServices e=%s", th);
            }
            AppMethodBeat.o(15415);
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean isLocked() {
            AppMethodBeat.i(15414);
            if (cfu.get() <= 0) {
                int i;
                ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
                if (activityManager != null) {
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        int[] iArr = new int[]{100};
                        int[] iArr2 = new int[]{300, 125};
                        int[] iArr3 = new int[]{1, 2};
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (((h) g.RM().Rn()).eHT.equals(runningAppProcessInfo.processName)) {
                                boolean z = com.tencent.mm.compatible.loader.a.contains(iArr, runningAppProcessInfo.importance) || ((com.tencent.mm.compatible.loader.a.contains(iArr2, runningAppProcessInfo.importance) && !BJ()) || com.tencent.mm.compatible.loader.a.contains(iArr3, runningAppProcessInfo.importanceReasonCode));
                                ab.i("MicroMsg.ToolsProcessLocker", "hasRunningServicesOrProviders:%b %d %d", Boolean.valueOf(z), Integer.valueOf(runningAppProcessInfo.importance), Integer.valueOf(runningAppProcessInfo.importanceReasonCode));
                                if (z) {
                                    i = 1;
                                    if (i == 0) {
                                        AppMethodBeat.o(15414);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
                boolean i2 = false;
                if (i2 == 0) {
                }
            }
            AppMethodBeat.o(15414);
            return true;
        }

        static /* synthetic */ void BK() {
            AppMethodBeat.i(15416);
            ab.i("MicroMsg.ToolsProcessLocker", "clearLock, beforeReset %d", Integer.valueOf(cfu.getAndSet(0)));
            AppMethodBeat.o(15416);
        }

        static /* synthetic */ void BL() {
            AppMethodBeat.i(15417);
            ab.i("MicroMsg.ToolsProcessLocker", "doLocalLock, counter %d", Integer.valueOf(cfu.incrementAndGet()));
            AppMethodBeat.o(15417);
        }

        static /* synthetic */ void BM() {
            AppMethodBeat.i(15418);
            ab.i("MicroMsg.ToolsProcessLocker", "doLocalUnlock, counter %d", Integer.valueOf(cfu.decrementAndGet()));
            AppMethodBeat.o(15418);
        }
    }

    public ToolsProfile() {
        AppMethodBeat.i(15420);
        AppMethodBeat.o(15420);
    }

    static {
        AppMethodBeat.i(15423);
        AppMethodBeat.o(15423);
    }

    public final void onCreate() {
        AppMethodBeat.i(15421);
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = ToolsProfile.class.getClassLoader();
        com.tencent.mm.f.a.bk(ah.getContext());
        l.a(new ao.c() {
            public final void b(String str, Throwable th) {
                AppMethodBeat.i(15405);
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.o(15405);
            }
        });
        l.cT(ceo);
        AppLogic.setCallBack(new AppCallBack(ah.getContext()));
        u uVar = new u(d.bo(this.app.getBaseContext()));
        uVar.jE("TOOL");
        ae.ghN = bo.a(uVar.jF(".com.tencent.mm.debug.test.display_errcode"), false);
        ae.ghO = bo.a(uVar.jF(".com.tencent.mm.debug.test.display_msgstate"), false);
        ae.ghP = bo.a(uVar.jF(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        ae.ghQ = bo.a(uVar.jF(".com.tencent.mm.debug.test.network.force_touch"), false);
        ae.ghR = bo.a(uVar.jF(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        ae.ghS = bo.a(uVar.jF(".com.tencent.mm.debug.test.crashIsExit"), false);
        ae.ghW = bo.a(uVar.jF(".com.tencent.mm.debug.test.album_show_info"), false);
        ae.ghX = bo.a(uVar.jF(".com.tencent.mm.debug.test.location_help"), false);
        ae.gia = bo.a(uVar.jF(".com.tencent.mm.debug.test.force_soso"), false);
        ae.gib = bo.a(uVar.jF(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        ae.gic = bo.a(uVar.jF(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        ae.gid = bo.a(uVar.jF(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        ae.gig = bo.a(uVar.jF(".com.tencent.mm.debug.test.filterfpnp"), false);
        ae.gih = bo.a(uVar.jF(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bo.a(uVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        ae.gie = a;
        if (a != 4 && ae.gie > 0) {
            com.tencent.mm.storage.ab.xIC = ae.gie;
            ab.e("MicroMsg.ToolDebugger", "cdn thread num " + ae.gie);
        }
        ae.gif = bo.a(uVar.jF(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(uVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.Lw(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            ab.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            String string = uVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bo.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.eSg = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.vxk = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.vxm = String.valueOf(string);
                b.amf(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eSg).append(" ").append(b.dnP());
            }
        } catch (Exception e2) {
            ab.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(uVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.vxn).append(" new: ").append(a);
            com.tencent.mm.protocal.d.vxn = (long) a;
        } catch (Exception e3) {
            ab.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            uVar.ecL.ebO = Integer.decode(uVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            ab.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bo.a(uVar.jF(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bo.a(uVar.jF(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bo.a(uVar.jF(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bo.a(uVar.jF(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            ab.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        ae.giu = bo.bc(uVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        ab.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + ae.giu);
        ae.giv = bo.bc(uVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        ab.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + ae.giv);
        ae.giw = bo.a(uVar.jF(".com.tencent.mm.debug.skiploadurlcheck"), false);
        ab.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + ae.giw);
        ae.gix = bo.a(uVar.jF(".com.tencent.mm.debug.forcex5webview"), false);
        ab.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + ae.gix);
        d.aT(((h) g.RM().Rn()).cc);
        a.cP(ceo);
        k.a("wcdb", classLoader);
        k.a("commonimgdec", classLoader);
        k.a("wechatcommon", classLoader);
        k.a(com.tencent.mm.sdk.a.xxo, classLoader);
        k.a("FFmpeg", classLoader);
        k.a("wechatpack", classLoader);
        int Lw = m.Lw();
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            ab.i(TAG, "load wechatsight_v7a, core number: %d ", Integer.valueOf(Lw >> 12));
            k.a("wechatsight_v7a", classLoader);
            if ((Lw >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.b.qwW = 3;
                com.tencent.mm.plugin.sight.base.b.qwY = 3;
                com.tencent.mm.plugin.sight.base.b.qwZ = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.b.qwW = 1;
                com.tencent.mm.plugin.sight.base.b.qwY = 1;
                com.tencent.mm.plugin.sight.base.b.qwZ = 640000;
            }
        } else {
            ab.i(TAG, "load wechatsight");
            k.a("wechatsight", classLoader);
            Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
            com.tencent.mm.plugin.sight.base.b.qwW = 1;
            com.tencent.mm.plugin.sight.base.b.qwY = 1;
            com.tencent.mm.plugin.sight.base.b.qwZ = 640000;
        }
        SightVideoJNI.registerALL();
        locale = MMActivity.initLanguage(this.app.getBaseContext());
        q.Bz();
        if (com.tencent.mm.compatible.util.d.iW(14) && b.cdV != null) {
            b.cdV.getApplication().registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                private Set<Activity> cft = new HashSet();

                {
                    AppMethodBeat.i(15409);
                    AppMethodBeat.o(15409);
                }

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    AppMethodBeat.i(15410);
                    ToolsProfile.this.cfr = ToolsProfile.this.cfr + 1;
                    this.cft.add(activity);
                    AppMethodBeat.o(15410);
                }

                public final void onActivityDestroyed(Activity activity) {
                    AppMethodBeat.i(15411);
                    ToolsProfile.this.cfr = ToolsProfile.this.cfr - 1;
                    ab.d(ToolsProfile.TAG, "onActivityDestroyed, after destroy, activityInstanceNum = %d", Integer.valueOf(ToolsProfile.this.cfr));
                    if (ToolsProfile.this.cfr == 0) {
                        a.BK();
                        ab.i(ToolsProfile.TAG, "onActivityDestroyed, xwebCanReboot = %b", Boolean.valueOf(WebView.getCanReboot()));
                        if (WebView.getCanReboot() && !a.isLocked()) {
                            Process.killProcess(Process.myPid());
                        }
                    }
                    this.cft.remove(activity);
                    AppMethodBeat.o(15411);
                }

                public final void onActivityPaused(Activity activity) {
                    AppMethodBeat.i(15412);
                    this.cft.remove(activity);
                    a.BL();
                    AppMethodBeat.o(15412);
                }

                public final void onActivityResumed(Activity activity) {
                    AppMethodBeat.i(15413);
                    if (!this.cft.contains(activity)) {
                        a.BM();
                    }
                    AppMethodBeat.o(15413);
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                }

                public final void onActivityStopped(Activity activity) {
                }
            });
        }
        ab.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mm.pluginsdk.model.v.a.fH(ah.getContext());
        com.tencent.mm.pluginsdk.ui.e.b.a.vrC = com.tencent.mm.app.plugin.e.Cl();
        c.a(MMWebView.zNq, new WebView.c() {
            public final void onCoreInitFinished() {
                AppMethodBeat.i(15406);
                ab.i(ToolsProfile.TAG, "onCoreInitFinished");
                vz vzVar = new vz();
                vzVar.cTk.success = true;
                com.tencent.mm.sdk.b.a.xxA.m(vzVar);
                AppMethodBeat.o(15406);
            }

            public final void BH() {
                AppMethodBeat.i(15407);
                ab.i(ToolsProfile.TAG, "onCoreInitFailed");
                vz vzVar = new vz();
                vzVar.cTk.success = false;
                com.tencent.mm.sdk.b.a.xxA.m(vzVar);
                AppMethodBeat.o(15407);
            }
        });
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.i.a.bfd());
        XWalkEnvironment.setIsForbidDownloadCode(com.tencent.mm.sdk.platformtools.g.dnY());
        com.tencent.mm.sdk.b.a.xxA.c(new m(22, 32));
        com.tencent.mm.pluginsdk.model.v.a.dho();
        AppMethodBeat.o(15421);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(15422);
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        ab.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + initLanguage.toString());
        if (!initLanguage.equals(locale)) {
            ab.w(TAG, "language changed, restart process");
            System.exit(-1);
        }
        AppMethodBeat.o(15422);
    }

    public final String toString() {
        return ceo;
    }
}
