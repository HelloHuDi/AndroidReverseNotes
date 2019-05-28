package com.tencent.p177mm.app;

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
import com.tencent.mars.p150mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.plugin.C1265e;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.booter.C41904u;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.ipcinvoker.BaseIPCService;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p218cj.C1390a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p229f.C1523a;
import com.tencent.p177mm.p230g.p231a.C45381vz;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.cdndownloader.p1544i.C44726a;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pluginsdk.model.C46499v.C30086a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C40487b.C4758a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.C15418a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5011c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C15430ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C46828c;
import com.tencent.xweb.p1634b.C44831d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;
import org.p1430a.C41166a;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.app.ToolsProfile */
public final class ToolsProfile extends C1439e {
    private static final String TAG = ("MicroMsg." + C1390a.dOY() + "Profile");
    public static final String ceo = C4996ah.getProcessName();
    private static Locale locale;
    private final C7564ap cfq = new C7564ap(new C63083(), true);
    private int cfr = 0;

    /* renamed from: com.tencent.mm.app.ToolsProfile$2 */
    class C12432 implements C46828c {
        C12432() {
        }

        public final void onCoreInitFinished() {
            AppMethodBeat.m2504i(15406);
            C4990ab.m7416i(ToolsProfile.TAG, "onCoreInitFinished");
            C45381vz c45381vz = new C45381vz();
            c45381vz.cTk.success = true;
            C4879a.xxA.mo10055m(c45381vz);
            AppMethodBeat.m2505o(15406);
        }

        /* renamed from: BH */
        public final void mo4528BH() {
            AppMethodBeat.m2504i(15407);
            C4990ab.m7416i(ToolsProfile.TAG, "onCoreInitFailed");
            C45381vz c45381vz = new C45381vz();
            c45381vz.cTk.success = false;
            C4879a.xxA.mo10055m(c45381vz);
            AppMethodBeat.m2505o(15407);
        }
    }

    /* renamed from: com.tencent.mm.app.ToolsProfile$1 */
    class C63071 implements C5011c {
        C63071() {
        }

        /* renamed from: b */
        public final void mo4564b(String str, Throwable th) {
            AppMethodBeat.m2504i(15405);
            KVCommCrossProcessReceiver.cgo();
            AppMethodBeat.m2505o(15405);
        }
    }

    /* renamed from: com.tencent.mm.app.ToolsProfile$3 */
    class C63083 implements C5015a {
        C63083() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(15408);
            C4990ab.m7416i(ToolsProfile.TAG, "onTimerExpired, check kill tools process");
            if (ToolsProfile.this.cfr == 0) {
                C6310a.m10380BK();
                C4990ab.m7417i(ToolsProfile.TAG, "onTimerExpired, xwebCanReboot = %b", Boolean.valueOf(WebView.getCanReboot()));
                if (WebView.getCanReboot() || !C6310a.isLocked()) {
                    C45287c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                    AppMethodBeat.m2505o(15408);
                    return false;
                }
            }
            AppMethodBeat.m2505o(15408);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.ToolsProfile$4 */
    class C63094 implements ActivityLifecycleCallbacks {
        private Set<Activity> cft = new HashSet();

        C63094() {
            AppMethodBeat.m2504i(15409);
            AppMethodBeat.m2505o(15409);
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.m2504i(15410);
            ToolsProfile.this.cfr = ToolsProfile.this.cfr + 1;
            this.cft.add(activity);
            AppMethodBeat.m2505o(15410);
        }

        public final void onActivityDestroyed(Activity activity) {
            AppMethodBeat.m2504i(15411);
            ToolsProfile.this.cfr = ToolsProfile.this.cfr - 1;
            C4990ab.m7411d(ToolsProfile.TAG, "onActivityDestroyed, after destroy, activityInstanceNum = %d", Integer.valueOf(ToolsProfile.this.cfr));
            if (ToolsProfile.this.cfr == 0) {
                C6310a.m10380BK();
                C4990ab.m7417i(ToolsProfile.TAG, "onActivityDestroyed, xwebCanReboot = %b", Boolean.valueOf(WebView.getCanReboot()));
                if (WebView.getCanReboot() && !C6310a.isLocked()) {
                    Process.killProcess(Process.myPid());
                }
            }
            this.cft.remove(activity);
            AppMethodBeat.m2505o(15411);
        }

        public final void onActivityPaused(Activity activity) {
            AppMethodBeat.m2504i(15412);
            this.cft.remove(activity);
            C6310a.m10381BL();
            AppMethodBeat.m2505o(15412);
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.m2504i(15413);
            if (!this.cft.contains(activity)) {
                C6310a.m10382BM();
            }
            AppMethodBeat.m2505o(15413);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: com.tencent.mm.app.ToolsProfile$a */
    public static final class C6310a {
        private static final AtomicInteger cfu = new AtomicInteger(0);
        private static Object cfv;

        static {
            AppMethodBeat.m2504i(15419);
            AppMethodBeat.m2505o(15419);
        }

        /* renamed from: BJ */
        private static boolean m10379BJ() {
            AppMethodBeat.m2504i(15415);
            try {
                if (cfv == null) {
                    Context context = C4996ah.getContext();
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
                    ArrayMap arrayMap = (ArrayMap) C41166a.m71622ep(invoke).awS("mServices").object;
                    if (arrayMap.size() <= 0) {
                        AppMethodBeat.m2505o(15415);
                        return true;
                    } else if (arrayMap.size() == 1 && (arrayMap.values().toArray()[0] instanceof BaseIPCService)) {
                        AppMethodBeat.m2505o(15415);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(15415);
                        return false;
                    }
                }
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.ToolsProcessLocker", "skipServiceConditionIfOnlyIPCServiceAlive, hack ActivityThread_mServices e=%s", th);
            }
            AppMethodBeat.m2505o(15415);
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean isLocked() {
            AppMethodBeat.m2504i(15414);
            if (cfu.get() <= 0) {
                int i;
                ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
                if (activityManager != null) {
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        int[] iArr = new int[]{100};
                        int[] iArr2 = new int[]{300, 125};
                        int[] iArr3 = new int[]{1, 2};
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (((C6624h) C1720g.m3533RM().mo5224Rn()).eHT.equals(runningAppProcessInfo.processName)) {
                                boolean z = C32473a.contains(iArr, runningAppProcessInfo.importance) || ((C32473a.contains(iArr2, runningAppProcessInfo.importance) && !C6310a.m10379BJ()) || C32473a.contains(iArr3, runningAppProcessInfo.importanceReasonCode));
                                C4990ab.m7417i("MicroMsg.ToolsProcessLocker", "hasRunningServicesOrProviders:%b %d %d", Boolean.valueOf(z), Integer.valueOf(runningAppProcessInfo.importance), Integer.valueOf(runningAppProcessInfo.importanceReasonCode));
                                if (z) {
                                    i = 1;
                                    if (i == 0) {
                                        AppMethodBeat.m2505o(15414);
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
            AppMethodBeat.m2505o(15414);
            return true;
        }

        /* renamed from: BK */
        static /* synthetic */ void m10380BK() {
            AppMethodBeat.m2504i(15416);
            C4990ab.m7417i("MicroMsg.ToolsProcessLocker", "clearLock, beforeReset %d", Integer.valueOf(cfu.getAndSet(0)));
            AppMethodBeat.m2505o(15416);
        }

        /* renamed from: BL */
        static /* synthetic */ void m10381BL() {
            AppMethodBeat.m2504i(15417);
            C4990ab.m7417i("MicroMsg.ToolsProcessLocker", "doLocalLock, counter %d", Integer.valueOf(cfu.incrementAndGet()));
            AppMethodBeat.m2505o(15417);
        }

        /* renamed from: BM */
        static /* synthetic */ void m10382BM() {
            AppMethodBeat.m2504i(15418);
            C4990ab.m7417i("MicroMsg.ToolsProcessLocker", "doLocalUnlock, counter %d", Integer.valueOf(cfu.decrementAndGet()));
            AppMethodBeat.m2505o(15418);
        }
    }

    public ToolsProfile() {
        AppMethodBeat.m2504i(15420);
        AppMethodBeat.m2505o(15420);
    }

    static {
        AppMethodBeat.m2504i(15423);
        AppMethodBeat.m2505o(15423);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(15421);
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = ToolsProfile.class.getClassLoader();
        C1523a.m3164bk(C4996ah.getContext());
        C25794l.m41013a(new C63071());
        C25794l.m41016cT(ceo);
        AppLogic.setCallBack(new AppCallBack(C4996ah.getContext()));
        C41904u c41904u = new C41904u(C1326d.m2839bo(this.app.getBaseContext()));
        c41904u.mo33553jE("TOOL");
        C1947ae.ghN = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.display_errcode"), false);
        C1947ae.ghO = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.display_msgstate"), false);
        C1947ae.ghP = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        C1947ae.ghQ = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.network.force_touch"), false);
        C1947ae.ghR = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        C1947ae.ghS = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.crashIsExit"), false);
        C1947ae.ghW = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.album_show_info"), false);
        C1947ae.ghX = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.location_help"), false);
        C1947ae.gia = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.force_soso"), false);
        C1947ae.gib = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        C1947ae.gic = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        C1947ae.gid = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        C1947ae.gig = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.filterfpnp"), false);
        C1947ae.gih = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.testForPull"), false);
        int a = C5046bo.m7512a(c41904u.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        C1947ae.gie = a;
        if (a != 4 && C1947ae.gie > 0) {
            C15430ab.xIC = C1947ae.gie;
            C4990ab.m7412e("MicroMsg.ToolDebugger", "cdn thread num " + C1947ae.gie);
        }
        C1947ae.gif = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(c41904u.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            C7243d.m12106Lw(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            C4990ab.m7416i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            String string = c41904u.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!C5046bo.isNullOrNil(string)) {
                C7243d.eSg = "android-".concat(String.valueOf(string));
                C7243d.vxk = "android-".concat(String.valueOf(string));
                C7243d.vxm = String.valueOf(string);
                C4872b.amf(string);
                new StringBuilder("set up test protocal apilevel = ").append(C7243d.eSg).append(" ").append(C4872b.dnP());
            }
        } catch (Exception e2) {
            C4990ab.m7416i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(c41904u.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(C7243d.vxn).append(" new: ").append(a);
            C7243d.vxn = (long) a;
        } catch (Exception e3) {
            C4990ab.m7416i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            c41904u.ecL.ebO = Integer.decode(c41904u.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            C4990ab.m7416i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            boolean a2 = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.report.useraction"), false);
            C3730c.m6036a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            C4990ab.m7416i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        C1947ae.giu = C5046bo.m7532bc(c41904u.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        C4990ab.m7410d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + C1947ae.giu);
        C1947ae.giv = C5046bo.m7532bc(c41904u.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        C4990ab.m7410d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + C1947ae.giv);
        C1947ae.giw = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.skiploadurlcheck"), false);
        C4990ab.m7410d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + C1947ae.giw);
        C1947ae.gix = C5046bo.m7517a(c41904u.mo33554jF(".com.tencent.mm.debug.forcex5webview"), false);
        C4990ab.m7410d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + C1947ae.gix);
        C1245d.m2683aT(((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc);
        C32258a.m52649cP(ceo);
        C1449k.m3079a("wcdb", classLoader);
        C1449k.m3079a("commonimgdec", classLoader);
        C1449k.m3079a("wechatcommon", classLoader);
        C1449k.m3079a(C15418a.xxo, classLoader);
        C1449k.m3079a("FFmpeg", classLoader);
        C1449k.m3079a("wechatpack", classLoader);
        int Lw = C45290m.m83509Lw();
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            C4990ab.m7417i(TAG, "load wechatsight_v7a, core number: %d ", Integer.valueOf(Lw >> 12));
            C1449k.m3079a("wechatsight_v7a", classLoader);
            if ((Lw >> 12) >= 4) {
                C29014b.qwW = 3;
                C29014b.qwY = 3;
                C29014b.qwZ = 544000;
            } else {
                C29014b.qwW = 1;
                C29014b.qwY = 1;
                C29014b.qwZ = 640000;
            }
        } else {
            C4990ab.m7416i(TAG, "load wechatsight");
            C1449k.m3079a("wechatsight", classLoader);
            Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
            C29014b.qwW = 1;
            C29014b.qwY = 1;
            C29014b.qwZ = 640000;
        }
        SightVideoJNI.registerALL();
        locale = MMActivity.initLanguage(this.app.getBaseContext());
        C1266q.m2719Bz();
        if (C1443d.m3068iW(14) && C1244b.cdV != null) {
            C1244b.cdV.getApplication().registerActivityLifecycleCallbacks(new C63094());
        }
        C4990ab.m7416i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        C30086a.m47650fH(C4996ah.getContext());
        C4758a.vrC = C1265e.m2715Cl();
        C45287c.m83503a(MMWebView.zNq, new C12432());
        C44831d.m82031a(C44726a.bfd());
        XWalkEnvironment.setIsForbidDownloadCode(C5059g.dnY());
        C4879a.xxA.mo10052c(new C9004m(22, 32));
        C30086a.dho();
        AppMethodBeat.m2505o(15421);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(15422);
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        C4990ab.m7410d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + initLanguage.toString());
        if (!initLanguage.equals(locale)) {
            C4990ab.m7420w(TAG, "language changed, restart process");
            System.exit(-1);
        }
        AppMethodBeat.m2505o(15422);
    }

    public final String toString() {
        return ceo;
    }
}
