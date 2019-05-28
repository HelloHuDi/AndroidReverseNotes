package com.tencent.p177mm.p612ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.p057v4.view.C0464g;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mrs.C5769a;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.C1244b;
import com.tencent.p177mm.app.C25798n;
import com.tencent.p177mm.app.C37470t;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.blink.FirstScreenFrameLayout;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.booter.C1324b;
import com.tencent.p177mm.booter.NotifyReceiver;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1728h;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p182ah.C45140n;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26087az;
import com.tencent.p177mm.p230g.p231a.C26270x;
import com.tencent.p177mm.p230g.p231a.C37688ac;
import com.tencent.p177mm.p230g.p231a.C45322ez;
import com.tencent.p177mm.p230g.p231a.C6496jd;
import com.tencent.p177mm.p612ui.C36298h.C363026;
import com.tencent.p177mm.p612ui.C44395w.C443936;
import com.tencent.p177mm.p612ui.HomeUI.C1546214;
import com.tencent.p177mm.p612ui.HomeUI.C154665;
import com.tencent.p177mm.p612ui.HomeUI.C154677;
import com.tencent.p177mm.p612ui.HomeUI.C2353522;
import com.tencent.p177mm.p612ui.HomeUI.C2353629;
import com.tencent.p177mm.p612ui.HomeUI.C2353736;
import com.tencent.p177mm.p612ui.HomeUI.C3033320;
import com.tencent.p177mm.p612ui.HomeUI.C3033428;
import com.tencent.p177mm.p612ui.HomeUI.C3033533;
import com.tencent.p177mm.p612ui.HomeUI.C3602418;
import com.tencent.p177mm.p612ui.HomeUI.C3602635;
import com.tencent.p177mm.p612ui.HomeUI.C360279;
import com.tencent.p177mm.p612ui.HomeUI.C4064612;
import com.tencent.p177mm.p612ui.HomeUI.C4064719;
import com.tencent.p177mm.p612ui.HomeUI.C406481;
import com.tencent.p177mm.p612ui.HomeUI.C4064932;
import com.tencent.p177mm.p612ui.HomeUI.C406503;
import com.tencent.p177mm.p612ui.HomeUI.C4423410;
import com.tencent.p177mm.p612ui.HomeUI.C4423523;
import com.tencent.p177mm.p612ui.HomeUI.C4423624;
import com.tencent.p177mm.p612ui.HomeUI.C4423725;
import com.tencent.p177mm.p612ui.HomeUI.C4423826;
import com.tencent.p177mm.p612ui.HomeUI.C4423927;
import com.tencent.p177mm.p612ui.HomeUI.C4424011;
import com.tencent.p177mm.p612ui.HomeUI.C4424330;
import com.tencent.p177mm.p612ui.HomeUI.C4424437;
import com.tencent.p177mm.p612ui.HomeUI.C442454;
import com.tencent.p177mm.p612ui.HomeUI.C51806;
import com.tencent.p177mm.p612ui.HomeUI.C51818;
import com.tencent.p177mm.p612ui.HomeUI.C5182a;
import com.tencent.p177mm.p612ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.MainTabUI.TabsAdapter;
import com.tencent.p177mm.p612ui.NewChattingTabUI.C235571;
import com.tencent.p177mm.p612ui.NewChattingTabUI.C235582;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.CustomViewPager;
import com.tencent.p177mm.p612ui.conversation.C5481b;
import com.tencent.p177mm.p612ui.conversation.MainUI;
import com.tencent.p177mm.p612ui.p614b.C15500c;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.C5666h;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.model.C42286e;
import com.tencent.p177mm.plugin.account.p275ui.WelcomeActivity;
import com.tencent.p177mm.plugin.account.p275ui.WelcomeSelectView;
import com.tencent.p177mm.plugin.account.p275ui.WelcomeView;
import com.tencent.p177mm.plugin.appbrand.jsapi.p303d.C33289h.C33294a;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.p1283p.C21426a;
import com.tencent.p177mm.plugin.p1283p.C21429d;
import com.tencent.p177mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.p505ui.setting.SettingsSwitchAccountUI;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.C4736u;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.p1079f.C40423e;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C44797o;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.xlog.app.XLogSetup;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.view.C31128d;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@C5271a(3)
@TargetApi(11)
/* renamed from: com.tencent.mm.ui.LauncherUI */
public class LauncherUI extends MMFragmentActivity {
    private static ArrayList<LauncherUI> yjE = new ArrayList();
    private static ArrayList<WeakReference<LauncherUI>> yjF = new ArrayList();
    private static boolean yjG = true;
    public static long yjH;
    private static boolean yjI = false;
    private static boolean yjR = false;
    private Intent cEp = null;
    private NewChattingTabUI chattingTabUI = new NewChattingTabUI(this.yjJ);
    public HomeUI yjJ = new HomeUI();
    private C44376n yjK = new C44376n();
    public boolean yjL = false;
    boolean yjM = false;
    private boolean yjN = false;
    private WelcomeView yjO;
    private C4736u yjP = new C4736u("MicroMsg.LauncherUI");
    C37470t yjQ;
    private boolean yjS = false;
    private C7306ak yjT = new C7306ak();
    private Runnable yjU = new C360294();

    /* renamed from: com.tencent.mm.ui.LauncherUI$2 */
    class C154682 implements Runnable {
        C154682() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29444);
            LauncherUI.m59296a(LauncherUI.this);
            AppMethodBeat.m2505o(29444);
        }
    }

    /* renamed from: com.tencent.mm.ui.LauncherUI$c */
    interface C23538c {
        void dxq();
    }

    /* renamed from: com.tencent.mm.ui.LauncherUI$d */
    interface C23539d {
    }

    /* renamed from: com.tencent.mm.ui.LauncherUI$4 */
    class C360294 implements Runnable {
        long cvc = FaceGestureDetGLThread.BRIGHTNESS_DURATION;

        /* renamed from: com.tencent.mm.ui.LauncherUI$4$1 */
        class C360301 implements Runnable {
            C360301() {
            }

            public final void run() {
                AppMethodBeat.m2504i(138620);
                WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
                C4990ab.m7416i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
                AppMethodBeat.m2505o(138620);
            }
        }

        C360294() {
        }

        @TargetApi(17)
        public final void run() {
            AppMethodBeat.m2504i(29447);
            C4990ab.m7417i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", Long.valueOf(Thread.currentThread().getId()));
            C5004al.m7439af(this);
            if (C9638aw.m17192ZM()) {
                Object[] objArr = new Object[1];
                C1720g.m3534RN();
                objArr[0] = Integer.valueOf(C1668a.m3383QF());
                C4990ab.m7417i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", objArr);
                AppMethodBeat.m2505o(29447);
            } else if (C26483d.akd() || C4872b.foreground) {
                this.cvc += FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                if (this.cvc > 10000) {
                    this.cvc = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                }
                C4990ab.m7417i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", Boolean.valueOf(C26483d.akd()), Boolean.valueOf(C4872b.foreground), Long.valueOf(this.cvc));
                C5004al.m7442n(this, this.cvc);
                AppMethodBeat.m2505o(29447);
            } else {
                C4990ab.m7416i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
                if (WXHardCoderJNI.isCheckEnv()) {
                    C7305d.post(new C360301(), "terminateApp");
                }
                C4990ab.m7416i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
                AppMethodBeat.m2505o(29447);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.LauncherUI$5 */
    class C360315 implements Runnable {
        C360315() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138621);
            LauncherUI.this.yjJ.getMainTabUI().dyD();
            AppMethodBeat.m2505o(138621);
        }
    }

    /* renamed from: com.tencent.mm.ui.LauncherUI$b */
    interface C36032b {
        /* renamed from: a */
        void mo56794a(FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup);

        boolean dxp();

        void dxr();

        void dxs();
    }

    /* renamed from: com.tencent.mm.ui.LauncherUI$3 */
    class C360333 implements Runnable {
        C360333() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29446);
            C9638aw.hold();
            C4879a.xxA.mo10055m(new C26270x());
            if (C5068w.m7683a(LauncherUI.this.getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                LauncherUI.this.yjN = true;
            }
            C1720g.m3537RQ().mo5257lL("switch account ,delay logout");
            LauncherUI.m59297a(LauncherUI.this, LauncherUI.this);
            C9638aw.unhold();
            AppMethodBeat.m2505o(29446);
        }
    }

    /* renamed from: com.tencent.mm.ui.LauncherUI$a */
    interface C36034a {
        boolean dxM();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LauncherUI() {
        AppMethodBeat.m2504i(29448);
        AppMethodBeat.m2505o(29448);
    }

    /* renamed from: a */
    static /* synthetic */ void m59296a(LauncherUI launcherUI) {
        AppMethodBeat.m2504i(29483);
        launcherUI.m59304pM(true);
        AppMethodBeat.m2505o(29483);
    }

    /* renamed from: b */
    static /* synthetic */ void m59300b(LauncherUI launcherUI) {
        AppMethodBeat.m2504i(29484);
        launcherUI.dxL();
        AppMethodBeat.m2505o(29484);
    }

    static {
        AppMethodBeat.m2504i(29485);
        AppMethodBeat.m2505o(29485);
    }

    public static LauncherUI getInstance() {
        AppMethodBeat.m2504i(29449);
        if (yjE.isEmpty()) {
            C4990ab.m7413e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", C5046bo.dpG());
            AppMethodBeat.m2505o(29449);
            return null;
        }
        LauncherUI launcherUI = (LauncherUI) yjE.get(0);
        AppMethodBeat.m2505o(29449);
        return launcherUI;
    }

    public static int dxE() {
        AppMethodBeat.m2504i(29450);
        if (LauncherUI.getInstance() == null || LauncherUI.getInstance().getHomeUI() == null || LauncherUI.getInstance().getHomeUI().getMainTabUI() == null) {
            AppMethodBeat.m2505o(29450);
            return -1;
        }
        int i = LauncherUI.getInstance().getHomeUI().getMainTabUI().mbt;
        AppMethodBeat.m2505o(29450);
        return i;
    }

    private void dxF() {
        AppMethodBeat.m2504i(29451);
        int indexOf = yjE.indexOf(this);
        if (indexOf >= 0) {
            yjE.remove(indexOf);
        }
        C4990ab.m7417i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", Integer.valueOf(indexOf), Integer.valueOf(yjE.size()), Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(29451);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        Object obj;
        AppMethodBeat.m2504i(29452);
        C1311a.m2802eM(C1728h.m3566RT().eKD);
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), C5046bo.m7559gU(this));
        this.yjQ = new C37470t();
        super.onCreate(bundle);
        MainProcessChecker.m67458UD(getClass().getName());
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        long currentTimeMillis2 = System.currentTimeMillis();
        int taskId = getTaskId();
        String packageName = getPackageName();
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null && C5068w.m7683a(intent, "absolutely_exit", false)) {
            z = true;
            C4990ab.m7416i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
        boolean z2 = z;
        Iterator it = yjF.iterator();
        while (it.hasNext()) {
            if (((LauncherUI) ((WeakReference) it.next()).get()) != null) {
                C4990ab.m7417i("MicroMsg.LauncherUI", "Check launcher instance found one %s", (LauncherUI) ((WeakReference) it.next()).get());
            }
        }
        RunningTaskInfo runningTaskInfo = null;
        if (!z2) {
            Iterator it2 = yjE.iterator();
            while (it2.hasNext()) {
                LauncherUI launcherUI = (LauncherUI) it2.next();
                if (launcherUI.getTaskId() != taskId) {
                    C4990ab.m7417i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", Integer.valueOf(launcherUI.hashCode()), Integer.valueOf(launcherUI.getTaskId()), Integer.valueOf(taskId));
                    runningTaskInfo = C5046bo.m7523av(this, taskId);
                    if (runningTaskInfo == null) {
                        C4990ab.m7413e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", Integer.valueOf(taskId));
                        finish();
                        obj = null;
                        break;
                    }
                    C4990ab.m7417i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", Integer.valueOf(runningTaskInfo.id), runningTaskInfo.topActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning));
                    if (runningTaskInfo.baseActivity.getPackageName().equals(packageName)) {
                        launcherUI.finish();
                        yjE.remove(launcherUI);
                    } else {
                        C4990ab.m7412e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + runningTaskInfo.baseActivity.getPackageName());
                        finish();
                        if (C5046bo.m7523av(this, launcherUI.getTaskId()) != null) {
                            C4990ab.m7416i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
                            Intent intent2 = new Intent(this, LauncherUI.class);
                            intent2.addFlags(268435456);
                            startActivity(intent2);
                        }
                        obj = null;
                    }
                }
                runningTaskInfo = runningTaskInfo;
            }
        }
        if (!yjE.isEmpty()) {
            if (runningTaskInfo == null) {
                runningTaskInfo = C5046bo.m7523av(this, taskId);
            }
            if (runningTaskInfo != null) {
                C4990ab.m7417i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", Integer.valueOf(runningTaskInfo.id), runningTaskInfo.baseActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning));
                packageName = getComponentName().getClassName();
                if (runningTaskInfo.numActivities > 1 && packageName.equals(r0) && packageName.equals(r3)) {
                    finish();
                    C4990ab.m7421w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", Integer.valueOf(yjE.size()));
                    obj = null;
                    if (obj != null) {
                        C4990ab.m7416i("MicroMsg.LauncherUI", "onCreate checkInstance false");
                        AppMethodBeat.m2505o(29452);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.LauncherUI", "onCreate normally");
                    this.yjJ = new HomeUI();
                    this.chattingTabUI = new NewChattingTabUI(this.yjJ);
                    HomeUI homeUI = this.yjJ;
                    NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                    homeUI.yhZ = this;
                    homeUI.yiN = newChattingTabUI;
                    MainTabUI mainTabUI = homeUI.yiP;
                    mainTabUI.yhZ = this;
                    mainTabUI.ynF = homeUI;
                    C44395w c44395w = mainTabUI.ynE;
                    c44395w.yhZ = this;
                    c44395w.ynS = homeUI;
                    mainTabUI.iVv = homeUI;
                    homeUI.yiO = new C36298h(this, homeUI);
                    NotifyReceiver.m41394Im();
                    C30036f.m47540ah(homeUI.yhZ);
                    homeUI.mActionBar = getSupportActionBar();
                    if (homeUI.mActionBar != null) {
                        if (VERSION.SDK_INT < 11) {
                            homeUI.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.f11700dy)));
                        }
                        homeUI.mActionBar.hide();
                    }
                    setRequestedOrientation(1);
                    homeUI.yiQ = getResources().getColor(C25738R.color.f12206vy);
                    homeUI.yiR = Color.alpha(homeUI.yiQ);
                    String T = C6665av.fly.mo5292T("login_user_name", "");
                    this.cEp = getIntent();
                    this.yjP.vaA = this.cEp.getBooleanExtra("splash-hack-activity-recreate", false);
                    C4990ab.m7417i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", r1.mTag, Boolean.valueOf(r1.vaA));
                    C4990ab.m7417i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", T, Boolean.valueOf(C9638aw.m17192ZM()), Boolean.valueOf(yjG));
                    if (yjG || (!C9638aw.m17192ZM() && T.equals(""))) {
                        yjH = currentTimeMillis;
                        C4990ab.m7416i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - C1244b.cdW));
                        setRequestedOrientation(1);
                        obj = (C9638aw.m17192ZM() || !C6665av.fly.mo5292T("login_user_name", "").equals("")) ? null : 1;
                        if (obj == null) {
                            C5059g.xye = false;
                        } else {
                            z = false;
                            if (C5059g.xyf) {
                                yjI = true;
                                z = MMAppMgr.m7896a((Activity) this, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.m2504i(29443);
                                        LauncherUI.m59296a(LauncherUI.this);
                                        LauncherUI.yjI = false;
                                        C44797o.aVi();
                                        Activity activity = this;
                                        WelcomeView welcomeSelectView = new WelcomeSelectView(this);
                                        activity.setContentView(welcomeSelectView);
                                        LauncherUI.this.yjO = welcomeSelectView;
                                        LauncherUI.m59300b(LauncherUI.this);
                                        AppMethodBeat.m2505o(29443);
                                    }
                                });
                            } else {
                                MMAppMgr.m7912hs(this);
                            }
                            if (!z) {
                                m59304pM(true);
                                yjI = false;
                                C44797o.aVi();
                                C34830g.m57196BP(8);
                                WelcomeSelectView welcomeSelectView = new WelcomeSelectView(this);
                                setContentView(welcomeSelectView);
                                this.yjO = welcomeSelectView;
                                C4990ab.m7417i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", Integer.valueOf(hashCode()));
                                C5004al.m7439af(this.yjU);
                                C5004al.m7442n(this.yjU, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                            }
                        }
                    } else {
                        yjH = currentTimeMillis;
                        C4990ab.m7416i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - C1244b.cdW));
                    }
                    if (dxI()) {
                        C4990ab.m7416i("MicroMsg.LauncherUI", "handleExitIntent return");
                        AppMethodBeat.m2505o(29452);
                        return;
                    }
                    dxG();
                    C5222ae.m7950hD(this);
                    AppMethodBeat.m2505o(29452);
                    return;
                }
                C4990ab.m7421w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", Integer.valueOf(yjE.size()), Boolean.valueOf(z2));
                yjE.clear();
            } else {
                C4990ab.m7421w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", Integer.valueOf(taskId), Integer.valueOf(yjE.size()));
                yjE.clear();
            }
        }
        yjE.add(this);
        yjF.add(new WeakReference(this));
        C4990ab.m7417i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", Integer.valueOf(yjE.size()), Integer.valueOf(yjF.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        obj = 1;
        if (obj != null) {
        }
    }

    private void dxG() {
        AppMethodBeat.m2504i(29453);
        C4990ab.m7410d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
        if (yjR) {
            C4990ab.m7416i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
            AppMethodBeat.m2505o(29453);
        } else if (!C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (C1668a.m3395QX()) {
                C4990ab.m7416i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
                AppMethodBeat.m2505o(29453);
                return;
            }
            C4990ab.m7416i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
            AppMethodBeat.m2505o(29453);
        } else if (dxH()) {
            if (C5068w.m7683a(getIntent(), "LauncherUI.enter_from_reg", false) || C40423e.vdx == null || !C40423e.vdx.mo20425Ch() || !C9638aw.m17179RK()) {
                C4990ab.m7410d("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew.");
            } else if (C4997aj.amA("show_whatsnew")) {
                yjR = true;
                C4990ab.m7416i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
                MMAppMgr.m7901aq(this);
                C1311a.m2794HL();
                AppMethodBeat.m2505o(29453);
                return;
            }
            AppMethodBeat.m2505o(29453);
        } else {
            C4990ab.m7416i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
            AppMethodBeat.m2505o(29453);
        }
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(29454);
        C4990ab.m7417i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", Integer.valueOf(hashCode()), C5046bo.m7559gU(this));
        this.cEp = intent;
        super.onNewIntent(intent);
        setIntent(intent);
        if (dxI()) {
            C4990ab.m7416i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
            AppMethodBeat.m2505o(29454);
        } else if (this.cEp == null || !C5068w.m7683a(this.cEp, "Intro_Need_Clear_Top ", false)) {
            if ((intent.getFlags() & 67108864) == 67108864) {
                closeChatting(false);
            }
            MainTabUI mainTabUI = this.yjJ.yiP;
            if ((intent.getFlags() & 67108864) == 67108864) {
                mainTabUI.ynG = true;
            }
            if (this.yjL) {
                C4990ab.m7418v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
                m59298aQ(intent);
            }
            AppMethodBeat.m2505o(29454);
        } else {
            C4990ab.m7410d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
            finish();
            LauncherUI.m59303ho(this);
            AppMethodBeat.m2505o(29454);
        }
    }

    /* renamed from: pM */
    private void m59304pM(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(29455);
        if (z) {
            if (this.yjK.mo70241c(this, new C154682())) {
                z2 = false;
            }
            this.yjS = z2;
            AppMethodBeat.m2505o(29455);
            return;
        }
        if (!this.yjS) {
            if (this.yjK.mo70240ao(this)) {
                z2 = false;
            }
            this.yjS = z2;
        }
        AppMethodBeat.m2505o(29455);
    }

    public void onResume() {
        AppMethodBeat.m2504i(29456);
        super.onResume();
        if (this.yjP.mo9879cM("onResume")) {
            C4990ab.m7416i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
            AppMethodBeat.m2505o(29456);
            return;
        }
        C4990ab.m7416i("MicroMsg.LauncherUI", "not skip this onResume");
        yjG = false;
        if (dxH()) {
            C36298h c36298h;
            long currentTimeMillis;
            long currentTimeMillis2;
            MainUI mainUI;
            LauncherUI instance;
            Object n;
            C4990ab.m7417i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", Boolean.valueOf(this.yjL));
            if (!this.yjL) {
                this.yjL = true;
                HomeUI homeUI = this.yjJ;
                homeUI.yiT = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
                c36298h = homeUI.yiO;
                C4879a.xxA.mo10052c(c36298h.yif);
                C4879a.xxA.mo10052c(c36298h.yig);
                if (!C5481b.dIo()) {
                    getWindow().setCallback(new C15500c(getWindow().getCallback(), this));
                }
                SharedPreferences sharedPreferences = homeUI.yhZ.getSharedPreferences("system_config_prefs", C1448h.m3078Mu());
                if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                    sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                    XLogSetup.realSetupXlog();
                }
                homeUI.yiD = new C46630aa(this);
                homeUI.yiv = true;
                NotifyReceiver.m41396Io();
                C9638aw.getNotification().mo41581il(1);
                C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
                currentTimeMillis = System.currentTimeMillis();
                if (C9638aw.m17179RK()) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    MMActivity.initLanguage(homeUI.yhZ);
                    try {
                        Set hashSet = new HashSet();
                        String[] split = homeUI.getString(C25738R.string.b3c).split(";");
                        hashSet.add(split[0]);
                        hashSet.add(split[1]);
                        C1854s.m3863c(hashSet);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
                    }
                    C1720g.m3537RQ();
                    C1720g.m3539RS().mo10302aa(new C1546214());
                    C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.ezi = (LayoutInflater) homeUI.yhZ.getSystemService("layout_inflater");
                    currentTimeMillis2 = System.currentTimeMillis();
                    homeUI.contentView = C1742b.m3596SM().mo5274a(homeUI.yhZ, "R.layout.main_tab", 2130970021);
                    if (!(homeUI.contentView == null || VERSION.SDK_INT < 23 || C1448h.m3077Mt())) {
                        homeUI.contentView.setBackgroundColor(homeUI.yhZ.getResources().getColor(C25738R.color.f12206vy));
                    }
                    C1314b.m2812HQ().mo4637HR();
                    ((FirstScreenFrameLayout) homeUI.contentView.findViewById(2131825729)).ebs = new C4064612();
                    C14877am.dhM();
                    C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.yhZ.setContentView(homeUI.contentView);
                    Looper.myQueue().addIdleHandler(homeUI.jQs);
                    homeUI.yiw = true;
                    C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - currentTimeMillis2));
                    C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    homeUI.initActionBar();
                    homeUI.mActionBar.show();
                    homeUI.contentView.post(new C4423523());
                    C4990ab.m7418v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - currentTimeMillis));
                    C5004al.m7442n(new C4064932(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    homeUI.contentView.addOnLayoutChangeListener(homeUI.yiU);
                    C30036f.m47541b(homeUI.yhZ, homeUI.contentView);
                    homeUI.contentView.postDelayed(new C3033533(), 20);
                } else {
                    C4990ab.m7412e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
                    homeUI.yhZ.finish();
                }
                MainTabUI mainTabUI = homeUI.yiP;
                mainTabUI.yeo = (CustomViewPager) mainTabUI.yhZ.findViewById(2131823829);
                mainTabUI.yeo.setOffscreenPageLimit(4);
                mainTabUI.yeo.setCanSlide(true);
                mainTabUI.yeo.setCanSlideBySide(false);
                mainTabUI.ynI = new TabsAdapter(mainTabUI.yhZ, mainTabUI.yeo);
                mainTabUI.mo48631Nm(0);
                C44395w c44395w = mainTabUI.ynE;
                ViewGroup viewGroup = (ViewGroup) mainTabUI.yeo.getParent();
                TabsAdapter tabsAdapter = mainTabUI.ynI;
                C5301c c5301c = c44395w.ynT;
                if (c44395w.ynT != null) {
                    c44395w.ynT.setOnTabClickListener(null);
                    ((View) c44395w.ynT).setVisibility(8);
                    if (viewGroup != null) {
                        viewGroup.removeView((View) c44395w.ynT);
                    }
                }
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                LauncherUIBottomTabView launcherUIBottomTabView = new LauncherUIBottomTabView(c44395w.yhZ);
                launcherUIBottomTabView.setId(2131820634);
                if (viewGroup != null) {
                    layoutParams.gravity = 80;
                    viewGroup.addView(launcherUIBottomTabView, layoutParams);
                }
                c44395w.ynT = launcherUIBottomTabView;
                ((View) c44395w.ynT).setVisibility(0);
                c44395w.ynT.setOnTabClickListener(tabsAdapter);
                if (!(c5301c == null || c5301c == c44395w.ynT)) {
                    c44395w.ynT.mo10915px(c5301c.getShowFriendPoint());
                    c44395w.ynT.mo10916py(c5301c.getSettingsPoint());
                    c44395w.ynT.mo10902MM(c5301c.getMainTabUnread());
                    c44395w.ynT.mo10903MN(c5301c.getContactTabUnread());
                    c44395w.ynT.mo10904MO(c5301c.getFriendTabUnread());
                    c44395w.ynT.mo10905MP(c5301c.getSettingsTabUnread());
                    c44395w.ynT.setTo(c5301c.getCurIdx());
                }
                homeUI.yiP.ynL = new C406481();
                this.chattingTabUI.iWA = this;
                m59298aQ(getIntent());
            }
            HomeUI homeUI2 = this.yjJ;
            long anU = C42252ah.anU();
            MainTabUI mainTabUI2 = homeUI2.yiP;
            C4990ab.m7417i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", Integer.valueOf(mainTabUI2.mbt));
            if (mainTabUI2.ynQ.size() != 0) {
                ((C15912m) ((MMFragment) mainTabUI2.ynQ.get(Integer.valueOf(mainTabUI2.mbt)))).dwi();
            }
            if (mainTabUI2.ynG && mainTabUI2.yhZ.getIntent().hasExtra("isScrollFirst") && mainTabUI2.yhZ.getIntent().hasExtra("isShowHeader")) {
                mainUI = (MainUI) mainTabUI2.ynQ.get(Integer.valueOf(0));
                if (mainUI != null) {
                    mainUI.mo39759i(mainTabUI2.yhZ.getIntent().getBooleanExtra("isShowHeader", false), mainTabUI2.yhZ.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), mainTabUI2.yhZ.getIntent().getBooleanExtra("isScrollFirst", true));
                }
            }
            if (mainTabUI2.ynG) {
                mainTabUI2.ynG = false;
                mainTabUI2.aqG("tab_main");
            }
            mainUI = (MainUI) mainTabUI2.ynQ.get(Integer.valueOf(0));
            if (mainUI != null) {
                mainUI.dHz();
                mainUI.dIT();
            }
            if (mainTabUI2.mbt == 0) {
                C9638aw.getNotification().mo41575bv(true);
            } else {
                C9638aw.getNotification().mo41575bv(false);
            }
            C15912m c15912m = (C15912m) mainTabUI2.mo48632Nn(mainTabUI2.mbt);
            if (c15912m != null) {
                c15912m.dwj();
            }
            mainTabUI2.ynG = false;
            int a = C5068w.m7682a(mainTabUI2.yhZ.getIntent(), "preferred_tab", 0);
            C4990ab.m7411d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", Integer.valueOf(a));
            if (a != 0) {
                mainTabUI2.mo48631Nm(a);
                mainTabUI2.yhZ.getIntent().putExtra("preferred_tab", 0);
            }
            C4879a.xxA.mo10052c(mainTabUI2.ynM);
            C4879a.xxA.mo10052c(mainTabUI2.ynO);
            C44395w c44395w2 = mainTabUI2.ynE;
            if (c44395w2.ynT != null) {
                c44395w2.ynT.dwp();
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().mo10118a(c44395w2.ynY);
            C16112c.m24429PK().mo28543a(c44395w2.ynX);
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10118a(c44395w2);
            C4879a.xxA.mo10052c(c44395w2.yhr);
            C4879a.xxA.mo10052c(c44395w2.ynZ);
            C4879a.xxA.mo10052c(c44395w2.yhq);
            C1314b.m2812HQ().mo4642o(new C443936());
            c36298h = homeUI2.yiO;
            C26087az c26087az = new C26087az();
            C4879a.xxA.mo10055m(c26087az);
            if (c26087az.cuh.cui && !C42252ah.isNullOrNil(c26087az.cuh.bzH)) {
                C4990ab.m7411d("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", c26087az.cuh.bzH);
                C30379h.m48461b(c36298h.yhZ, c26087az.cuh.bzH, c26087az.cuh.title, true);
            }
            if (!c36298h.mo57163a(c36298h.yib)) {
                C9638aw.m17180RS().mo10310m(new C363026(), 500);
            }
            c36298h.yib = null;
            C4872b.m7236cE(true);
            boolean dxM = homeUI2.yiN.dxM();
            if (!dxM && C9638aw.m17179RK()) {
                C1314b.m2812HQ().mo4642o(new C3602635());
                if (!(C25859d.fUv == null || C25859d.fUu == null || C42252ah.isNullOrNil(C25859d.fUu.akM()))) {
                    C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", C25859d.fUv.akN());
                    C45322ez c45322ez = new C45322ez();
                    c45322ez.cys.username = C25859d.fUv.akN();
                    C4879a.xxA.mo10055m(c45322ez);
                }
            }
            if (!dxM) {
                C15909j.m24224a(homeUI2.yhZ, 3, homeUI2.yiP.mbt, "directReport_onResume");
                homeUI2.yiP.mo48629Nj(v2helper.VOIP_ENC_HEIGHT_LV1);
            }
            C5666h.m8513b(homeUI2.yhZ);
            homeUI2.yhZ.onSwipe(1.0f);
            homeUI2.yiM = C5182a.ACTIVITY_RESUME;
            if (homeUI2.yix) {
                homeUI2.yix = false;
                homeUI2.yix = false;
            }
            C45140n.acp();
            currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7420w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
            C1737l.m3593m(homeUI2.yhZ, false);
            C1737l.m3594n(homeUI2.yhZ, false);
            currentTimeMillis2 = System.currentTimeMillis();
            if (homeUI2.yhZ.getSharedPreferences(C4996ah.doA(), 0).getBoolean("settings_landscape_mode", false)) {
                homeUI2.yhZ.setRequestedOrientation(-1);
            } else {
                homeUI2.yhZ.setRequestedOrientation(1);
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (LauncherUI.getInstance() != null) {
                C1314b.m2812HQ().mo4639HT();
                ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("showprivacypolicy", homeUI2.yjk);
                homeUI2.mo69894pH(false);
                C4879a.xxA.mo10052c(homeUI2.qjs);
                C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - currentTimeMillis3));
                if (C9638aw.m17179RK()) {
                    homeUI2.dxu();
                }
            }
            C4990ab.m7418v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - currentTimeMillis2));
            C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - currentTimeMillis));
            C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - anU));
            if (homeUI2.yix) {
                homeUI2.yix = false;
                homeUI2.yix = false;
            }
            C25798n Bw = C25798n.m41027Bw();
            Bw.ceU = true;
            Bw.ceV.removeMessages(-1999);
            Bw.ceV.removeMessages(-2999);
            C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - anU));
            if (C1853r.m3852Zf().booleanValue()) {
                homeUI2.dxi();
            }
            a = C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_LOGIN_SHOW_BIND_THIRD_ADD_TYPE_INT, 0);
            if (a != 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LOGIN_SHOW_BIND_THIRD_ADD_TYPE_INT, Integer.valueOf(0));
                if (!C1853r.m3847Za()) {
                    switch (a) {
                        case 1:
                            C30379h.m48440a(homeUI2.yhZ, homeUI2.getString(C25738R.string.co2), "", new C2353736(), null);
                            break;
                    }
                }
            }
            C1314b.m2812HQ().mo4642o(new C4424437());
            if (homeUI2.getMainTabUI().mbt != 3) {
                MoreTabUI moreTabUI = (MoreTabUI) homeUI2.getMainTabUI().mo48632Nn(3);
                if (!(moreTabUI.yoh == null || moreTabUI.yoh.isVisible)) {
                    moreTabUI.yoh.dLf();
                    moreTabUI.caE();
                }
            }
            NewChattingTabUI newChattingTabUI = this.chattingTabUI;
            newChattingTabUI.ypf = C42252ah.anT();
            if (newChattingTabUI.cXe()) {
                newChattingTabUI.ypi = new C235571();
                C5004al.m7442n(new C235582(), 500);
            }
            if (newChattingTabUI.dxM()) {
                newChattingTabUI.mo76179kT(3);
                if (newChattingTabUI.ypn != null && newChattingTabUI.ypn.isSupportNavigationSwipeBack()) {
                    newChattingTabUI.ypn.getSwipeBackLayout().setEnableGesture(true);
                }
            } else if (newChattingTabUI.ypq) {
                C4990ab.m7420w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
                C5004al.m7439af(newChattingTabUI.mStartChattingRunnable);
                C5004al.m7441d(newChattingTabUI.mStartChattingRunnable);
                newChattingTabUI.ypq = false;
            }
            C4990ab.m7416i("MicroMsg.LauncherUI", "resumeNormalJump");
            C5206a.dyv();
            if ("pushcontent_notification".equals(C5068w.m7689n(getIntent(), "nofification_type")) && !C5046bo.isNullOrNil(C5068w.m7689n(getIntent(), "Main_FromUserName"))) {
                C4990ab.m7412e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + C5068w.m7689n(getIntent(), "Main_FromUserName") + C5068w.m7682a(getIntent(), "MainUI_User_Last_Msg_Type", 0));
                C7060h.pYm.mo8381e(10856, Integer.valueOf(r1), r0, Integer.valueOf(0));
            }
            String n2 = C5068w.m7689n(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (n2 != null) {
                if (n2.equals("launch_type_voip")) {
                    C4990ab.m7410d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
                    C7060h.pYm.mo8381e(11034, Integer.valueOf(2), Integer.valueOf(0));
                } else if (n2.equals("launch_type_voip_audio")) {
                    C4990ab.m7410d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
                    C7060h.pYm.mo8381e(11034, Integer.valueOf(2), Integer.valueOf(1));
                }
            }
            n2 = C5068w.m7689n(getIntent(), "LauncherUI.switch.tab");
            if (!C5046bo.isNullOrNil(n2)) {
                this.yjJ.getMainTabUI().aqG(n2);
                getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if (C5068w.m7683a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false) || this.yjN) {
                this.yjN = false;
                instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.dxo();
                }
                getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
                getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            boolean a2 = C5068w.m7683a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (a2) {
                n = C5068w.m7689n(getIntent(), "LauncherUI.Shortcut.Username");
            } else {
                a2 = C5068w.m7683a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
                n = getIntent().getAction();
            }
            if (a2) {
                C4990ab.m7410d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(n)));
                if (!C5046bo.isNullOrNil(n)) {
                    String Fs = C42781b.m75855Fs(n);
                    if (!C5046bo.isNullOrNil(Fs)) {
                        if (C1855t.m3912mY(Fs)) {
                            C4990ab.m7410d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                            Intent intent;
                            if (!C17903f.m28107ra(Fs)) {
                                instance = LauncherUI.getInstance();
                                if (instance != null) {
                                    instance.startChatting(Fs, null, false);
                                }
                            } else if (C17903f.m28103kq(Fs)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                                intent.putExtra("Contact_User", Fs);
                                intent.putExtra("biz_chat_from_scene", 9);
                                intent.addFlags(67108864);
                                startActivity(intent);
                            } else if (C17903f.m28109rc(Fs)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
                                intent.putExtra("enterprise_biz_name", Fs);
                                intent.putExtra("enterprise_biz_display_name", C1854s.m3866mJ(Fs));
                                startActivity(intent);
                            } else if (C17903f.m28110rd(Fs)) {
                                C16527d qX = C17903f.m28104qX(Fs);
                                n2 = qX == null ? null : qX.adT();
                                if (n2 == null) {
                                    n2 = "";
                                }
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", n2);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("srcUsername", Fs);
                                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                intent2.addFlags(67108864);
                                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                            } else {
                                instance = LauncherUI.getInstance();
                                Bundle bundle = new Bundle();
                                bundle.putInt("chat_from_scene", 3);
                                instance.startChatting(Fs, bundle, false);
                            }
                        }
                        getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                        getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                    }
                }
            }
            this.yjM = true;
        } else if (!yjI) {
            dxL();
        }
        C1311a.m2806ig(5);
        if (!yjI) {
            m59304pM(false);
        }
        dxG();
        C1311a.m2807jD("LauncherUI");
        AppMethodBeat.m2505o(29456);
    }

    private boolean dxH() {
        AppMethodBeat.m2504i(29457);
        if (this.cEp == null || C5068w.m7683a(this.cEp, "Intro_Switch", false) || !C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            AppMethodBeat.m2505o(29457);
            return false;
        }
        AppMethodBeat.m2505o(29457);
        return true;
    }

    private boolean dxI() {
        AppMethodBeat.m2504i(29458);
        if (this.cEp != null) {
            if (C5068w.m7683a(this.cEp, "absolutely_exit", false) || C5068w.m7682a(this.cEp, "absolutely_exit_pid", 0) == Process.myPid()) {
                C4990ab.m7421w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", Integer.valueOf(hashCode()));
                finish();
                C34830g.m57196BP(8);
                MMAppMgr.m7914pQ(C5068w.m7683a(this.cEp, "kill_service", true));
                System.exit(0);
                AppMethodBeat.m2505o(29458);
                return true;
            } else if (C5068w.m7683a(this.cEp, "can_finish", false)) {
                C4990ab.m7416i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
                C9638aw.m17182Rg().mo14548cD(true);
                if (C1737l.m3591bL(getApplicationContext())) {
                    C1324b.m2836bm(getApplicationContext());
                }
                C34830g.m57196BP(8);
                sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), WXApp.WXAPP_BROADCAST_PERMISSION);
                finish();
                C5274b.m8054hM(this);
                AppMethodBeat.m2505o(29458);
                return true;
            } else if (C5068w.m7683a(this.cEp, "exit_and_restart", false)) {
                C5769a.onDestroy();
                BaseEvent.onSingalCrash(0);
                C4990ab.m7416i("MicroMsg.LauncherUI", "exit and restart myself.");
                C4990ab.dot();
                finish();
                Intent intent = new Intent(this, LauncherUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                C4990ab.m7417i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", Integer.valueOf(Process.myPid()));
                MMAppMgr.dys();
                Process.killProcess(Process.myPid());
                AppMethodBeat.m2505o(29458);
                return true;
            }
        }
        AppMethodBeat.m2505o(29458);
        return false;
    }

    private void dMv() {
        AppMethodBeat.m2504i(139025);
        getWindow().getDecorView().setSystemUiVisibility(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (this.yjO == null) {
            this.yjO = new WelcomeSelectView(this);
        }
        setContentView((View) this.yjO);
        AppMethodBeat.m2505o(139025);
    }

    private void dxJ() {
        AppMethodBeat.m2504i(138622);
        Intent intent = new Intent();
        String T = C6665av.fly.mo5292T("login_weixin_username", "");
        intent.putParcelableArrayListExtra("key_switch_account_users", this.cEp.getParcelableArrayListExtra("key_switch_account_users"));
        intent.putExtra("key_switch_from_wx_username", T);
        T = C4988aa.m7402g(getSharedPreferences(C4996ah.doA(), 0));
        float dm = C1338a.m2860dm(this);
        intent.putExtra("key_langauage_code", T);
        intent.putExtra("key_font_scale_size", dm);
        C4990ab.m7417i("MicroMsg.LauncherUI", "mm pid %d", Integer.valueOf(Process.myPid()));
        intent.putExtra("key_mm_process_pid", Process.myPid());
        intent.setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI");
        startActivity(intent);
        C5274b.m8055hN(this);
        AppMethodBeat.m2505o(138622);
    }

    private void dxK() {
        AppMethodBeat.m2504i(29459);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0);
        String string = sharedPreferences.getString("last_switch_account_to_wx_username", "");
        C4990ab.m7417i("MicroMsg.LauncherUI", "switch to wxid %s", string);
        sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
        Intent intent = new Intent();
        intent.setClass(this, SettingsSwitchAccountUI.class);
        intent.addFlags(536870912);
        intent.putExtra("key_scene", 1);
        startActivity(intent);
        C5274b.m8055hN(this);
        AppMethodBeat.m2505o(29459);
    }

    /* renamed from: aQ */
    private void m59298aQ(Intent intent) {
        AppMethodBeat.m2504i(29460);
        C4990ab.m7416i("MicroMsg.LauncherUI", "handleJump");
        if (C9638aw.m17179RK()) {
            C6496jd c6496jd = new C6496jd();
            c6496jd.cEo.cEp = this.cEp;
            C4879a.xxA.mo10055m(c6496jd);
            String n;
            Intent className;
            if ("talkroom_notification".equals(C5068w.m7689n(intent, "nofification_type"))) {
                n = C5068w.m7689n(intent, "enter_chat_usrname");
                if (!C5046bo.isNullOrNil(n)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("enter_room_username", n);
                    intent2.setFlags(268435456);
                    C25985d.m41467b((Context) this, "talkroom", ".ui.TalkRoomUI", intent2);
                }
                AppMethodBeat.m2505o(29460);
                return;
            } else if ("back_to_pcmgr_notification".equals(intent.getStringExtra("nofification_type"))) {
                if (intent.getBooleanExtra("newPCBackup", true)) {
                    C4990ab.m7416i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
                    className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
                } else {
                    C4990ab.m7416i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
                    className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");
                }
                className.setFlags(268435456);
                MMWizardActivity.m23791J(this, className);
                AppMethodBeat.m2505o(29460);
                return;
            } else if ("back_to_pcmgr_error_notification".equals(intent.getStringExtra("nofification_type"))) {
                className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
                className.setFlags(268435456);
                MMWizardActivity.m23791J(this, className);
                AppMethodBeat.m2505o(29460);
                return;
            } else if ("backup_move_notification".equals(intent.getStringExtra("nofification_type"))) {
                className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
                className.setFlags(268435456);
                MMWizardActivity.m23791J(this, className);
                AppMethodBeat.m2505o(29460);
                return;
            } else {
                int i;
                if (C5068w.m7683a(intent, "show_update_dialog", false)) {
                    m59299aR(intent);
                }
                String n2 = C5068w.m7689n(intent, "Main_User");
                String n3 = C5068w.m7689n(intent, "nofification_type");
                C4990ab.m7417i("MicroMsg.LauncherUI", "[handleJump] user:%s", n2);
                if (n2 == null || n2.equals("")) {
                    i = 0;
                } else {
                    C9638aw.m17190ZK();
                    C7617ak aoZ = C18628c.m29083XR().aoZ(n2);
                    if (aoZ != null) {
                        i = aoZ.field_unReadCount;
                    } else {
                        i = 0;
                    }
                    C4990ab.m7417i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", n2, aoZ, Integer.valueOf(i));
                }
                if (i == 0) {
                    i = C5068w.m7682a(intent, "pushcontent_unread_count", 0);
                }
                MMAppMgr.m7891BV();
                C4879a.xxA.mo10055m(new C37688ac());
                boolean a = C5068w.m7683a(intent, "Intro_Is_Muti_Talker", true);
                C4990ab.m7417i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", Boolean.valueOf(a), Integer.valueOf(i));
                if (!a && i > 0 && C5068w.m7682a(intent, "Intro_Bottle_unread_count", 0) > 0) {
                    C4990ab.m7417i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", Integer.valueOf(C5068w.m7682a(intent, "Intro_Bottle_unread_count", 0)));
                    C25985d.m41448H(this, "bottle", ".ui.BottleConversationUI");
                }
                LauncherUI instance;
                if (a) {
                    if (C5068w.m7683a(intent, "From_fail_notify", false)) {
                        if (!C5046bo.isNullOrNil(n2)) {
                            instance = LauncherUI.getInstance();
                            if (instance != null) {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("Chat_Mode", C5068w.m7683a(intent, "resend_fail_messages", false));
                                if (C17903f.m28103kq(n2)) {
                                    intent.putExtra("Contact_User", n2);
                                    intent.addFlags(67108864);
                                    intent.putExtra("biz_chat_from_scene", 4);
                                    C25985d.m41473f(this, ".ui.bizchat.BizChatConversationUI", intent);
                                } else {
                                    instance.startChatting(n2, bundle, false);
                                }
                            }
                        } else if (C5068w.m7683a(intent, "jump_sns_from_notify", false)) {
                            className = new Intent();
                            className.addFlags(67108864);
                            className.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                            className.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                            className.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                            C25985d.m41467b((Context) this, "sns", ".ui.SnsTimeLineUI", className);
                        }
                    } else if (C5068w.m7683a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                        if (LauncherUI.getInstance() != null && C17903f.m28103kq(n2)) {
                            intent.putExtra("Contact_User", n2);
                            intent.addFlags(67108864);
                            C25985d.m41473f(this, ".ui.bizchat.BizChatConversationUI", intent);
                        }
                    } else if (!C5046bo.isNullOrNil(n2) && "new_msg_nofification".equals(n3)) {
                        n3 = "MicroMsg.LauncherUI";
                        String str = "[handleJump] intent:%s";
                        Object[] objArr = new Object[1];
                        if (intent == null) {
                            n = BuildConfig.COMMAND;
                        } else {
                            Object obj = intent;
                        }
                        objArr[0] = n;
                        C4990ab.m7421w(n3, str, objArr);
                        instance = LauncherUI.getInstance();
                        if (instance != null) {
                            instance.startChatting(n2, new Bundle(), false);
                        } else {
                            C4990ab.m7420w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
                        }
                    }
                } else if (C1855t.m3947np(n2)) {
                    C4990ab.m7416i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
                    className = new Intent();
                    className.addFlags(67108864);
                    className.putExtra("type", 20);
                    C25985d.m41467b((Context) this, "readerapp", ".ui.ReaderAppUI", className);
                } else if (C1855t.m3955nx(n2)) {
                    C4990ab.m7416i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
                    className = new Intent();
                    className.addFlags(67108864);
                    className.putExtra("type", 11);
                    C25985d.m41467b((Context) this, "readerapp", ".ui.ReaderAppUI", className);
                } else {
                    if (intent.getIntExtra("MainUI_User_Last_Msg_Type", 34) == 34) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("Chat_Mode", i);
                    if ("new_msg_nofification".equals(C5068w.m7689n(intent, "nofification_type"))) {
                        bundle2.putInt("chat_from_scene", 1);
                    }
                    instance = LauncherUI.getInstance();
                    if (instance != null) {
                        if (C17903f.m28103kq(n2)) {
                            intent.putExtra("Contact_User", n2);
                            intent.addFlags(67108864);
                            intent.putExtra("biz_chat_from_scene", 4);
                            C25985d.m41473f(this, ".ui.bizchat.BizChatConversationUI", intent);
                        } else if (C17903f.m28110rd(n2)) {
                            C16527d qX = C17903f.m28104qX(n2);
                            n = qX == null ? null : qX.adT();
                            if (n == null) {
                                n = "";
                            }
                            intent.putExtra("rawUrl", n);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", n2);
                            intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent.addFlags(67108864);
                            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (C7616ad.m13549mg(n2)) {
                            intent.putExtra("Contact_User", n2);
                            intent.addFlags(67108864);
                            intent.putExtra("app_brand_conversation_from_scene", 3);
                            intent.putExtra("finish_direct", true);
                            intent.putExtra("key_need_send_video", false);
                            C25985d.m41473f(this, ".ui.conversation.AppBrandServiceConversationUI", intent);
                        } else {
                            instance.startChatting(n2, bundle2, false);
                        }
                    }
                }
                if (C5068w.m7682a(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                    className = new Intent();
                    className.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
                    className.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                    className.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                    MMWizardActivity.m23791J(this, className);
                }
                AppMethodBeat.m2505o(29460);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
        startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
        finish();
        AppMethodBeat.m2505o(29460);
    }

    private void dxL() {
        AppMethodBeat.m2504i(29461);
        C4990ab.m7416i("MicroMsg.LauncherUI", "resumeLogoutJump");
        C5206a.dyv();
        String T = C6665av.fly.mo5292T("login_user_name", "");
        if (C9638aw.m17192ZM() || !T.equals("")) {
            C34830g.m57196BP(8);
            C1720g.m3535RO().mo5185Rf();
            C4990ab.m7417i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", Boolean.valueOf(this.yjL), Boolean.valueOf((this.cEp.getFlags() & 67108864) == 67108864), Boolean.valueOf(C5068w.m7683a(this.cEp, "Intro_Notify", false)), Boolean.valueOf(C9638aw.m17178QT()));
            C4990ab.m7417i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", Boolean.valueOf(C9638aw.m17192ZM()));
            this.yjJ.getMainTabUI().dyy();
            if (C5068w.m7683a(this.cEp, "key_transit_to_switch_account", false)) {
                C4990ab.m7416i("MicroMsg.LauncherUI", "transit to fake switch account");
                this.cEp.removeExtra("key_transit_to_switch_account");
                SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0);
                sharedPreferences.getString("last_switch_account_to_wx_username", "");
                sharedPreferences.edit().putBoolean("transit_to_switch_account", true).commit();
                dMv();
                dxJ();
                C5004al.m7442n(new C360333(), 500);
                AppMethodBeat.m2505o(29461);
                return;
            }
            C9638aw.hold();
            C4879a.xxA.mo10055m(new C26270x());
            if (C5068w.m7683a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                this.yjN = true;
            }
            C1720g.m3537RQ().mo5257lL("[" + this.yjL + " " + r0 + " " + r3 + "]");
            m59302hn(this);
            C9638aw.unhold();
            AppMethodBeat.m2505o(29461);
            return;
        }
        startActivity(new Intent(this, WelcomeActivity.class));
        C5274b.m8055hN(this);
        C4990ab.m7416i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
        C5004al.m7439af(this.yjU);
        C5004al.m7442n(this.yjU, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(29461);
    }

    /* renamed from: hn */
    private void m59302hn(Context context) {
        AppMethodBeat.m2504i(29462);
        Intent intent;
        if (C5068w.m7683a(this.cEp, "LauncherUI.jump_switch_account", false)) {
            C4990ab.m7416i("MicroMsg.LauncherUI", "launcher to switch account");
            dxK();
            this.cEp.removeExtra("LauncherUI.jump_switch_account");
            AppMethodBeat.m2505o(29462);
        } else if (C5068w.m7683a(this.cEp, "Intro_Switch", false) || this.yjL || C1668a.m3386QI()) {
            C5769a.onDestroy();
            BaseEvent.onSingalCrash(0);
            C4990ab.m7417i("MicroMsg.LauncherUI", "switch users count %d", Integer.valueOf(C37914bx.fnB.aat().size()));
            C4990ab.m7416i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
            C4990ab.dot();
            finish();
            if (!C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false)) {
                intent = new Intent(context, LauncherUI.class);
                intent.addFlags(67108864);
                context.startActivity(intent);
            }
            C4990ab.m7417i("MicroMsg.LauncherUI", "try to kill mm pid %d", Integer.valueOf(Process.myPid()));
            MMAppMgr.dys();
            Process.killProcess(Process.myPid());
            AppMethodBeat.m2505o(29462);
        } else {
            if (!C5068w.m7683a(this.cEp, "LauncherUI.jump_switch_account", false)) {
                C4990ab.m7417i("MicroMsg.LauncherUI", "jumpToLogin %s", C6665av.fly.mo5292T("login_user_name", ""));
                if (C5046bo.isNullOrNil(C6665av.fly.mo5292T("login_user_name", ""))) {
                    startActivity(new Intent(this, WelcomeActivity.class));
                    C5274b.m8055hN(this);
                } else {
                    C4990ab.m7417i("MicroMsg.LauncherUI", "switchAccount %s", Boolean.valueOf(C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false)));
                    if (C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false)) {
                        intent = new Intent(this, SettingsSwitchAccountUI.class);
                        intent.addFlags(67108864);
                        intent.putExtra("key_scene", 2);
                        startActivity(intent);
                    } else {
                        int ank = C5046bo.ank(C6665av.fly.mo5292T("last_login_use_voice", ""));
                        C4990ab.m7416i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(ank)));
                        if ((ank & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                            startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI"));
                        } else {
                            startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI"));
                        }
                    }
                    C5274b.m8052hK(this);
                }
                C34830g.m57196BP(8);
                C5004al.m7439af(this.yjU);
                C5004al.m7442n(this.yjU, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            }
            AppMethodBeat.m2505o(29462);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        Bundle bundle = null;
        AppMethodBeat.m2504i(29463);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7418v("MicroMsg.LauncherUI", "edw on activity result");
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if ((i == 2001 || i == 30763 || i == 30762 || i == FaceManager.FACE_ACQUIRED_HACKER) && newChattingTabUI.ypn != null) {
            newChattingTabUI.ypn.onActivityResult(i, i2, intent);
        }
        if (NewChattingTabUI.acceptRequestCode(i) && newChattingTabUI.ypn == null) {
            C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
            C5004al.m7439af(newChattingTabUI.ypp);
            newChattingTabUI.ypp.ypy = 0;
            newChattingTabUI.ypp.requestCode = i;
            newChattingTabUI.ypp.bFZ = i2;
            newChattingTabUI.ypp.cEd = intent;
            C5004al.m7441d(newChattingTabUI.ypp);
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            AppMethodBeat.m2505o(29463);
            return;
        }
        HomeUI homeUI = this.yjJ;
        if (homeUI.yiv) {
            if (i == 1) {
                C9638aw.m17190ZK();
                if (!C42252ah.m74619e((Boolean) C18628c.m29072Ry().get(12323, null))) {
                    C42257z.showAddrBookUploadConfirm(homeUI.yhZ, null, false, 3);
                }
                AppMethodBeat.m2505o(29463);
                return;
            }
            String str;
            if (i == 22722) {
                str = (String) C1720g.m3536RP().mo5239Ry().get(274436, null);
                C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                    C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
                    C1720g.m3540Rg().mo14541a(new C42286e(2, str), 0);
                    C7060h.pYm.mo8378a(712, 5, 1, false);
                } else {
                    C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
                    C7060h.pYm.mo8378a(712, 4, 1, false);
                    C1720g.m3540Rg().mo14541a(new C42286e(1, str), 0);
                    if (C17950b.m28216sO(str) && C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_NEED_BIRTHDAY_BOOLEAN_SYNC, false)) {
                        C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
                        C5004al.m7442n(new C2353522(), 100);
                    }
                }
            } else if (i == 22723) {
                str = (String) C1720g.m3536RP().mo5239Ry().get(274436, null);
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle != null) {
                    if (bundle.getString("go_next", "").equals("birthdayComfirmOK")) {
                        C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEED_BIRTHDAY_BOOLEAN_SYNC, Boolean.FALSE);
                    } else if (bundle.getString("go_next", "").equals("gdpr_confirm_logout")) {
                        C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
                        C1720g.m3540Rg().mo14541a(new C42286e(2, str), 0);
                        C7060h.pYm.mo8378a(712, 5, 1, false);
                    }
                }
            }
            if (i == BitUtils.BIT_TURN_ZERO_1 && i2 == -1) {
                C4997aj.amB("welcome_page_show");
                C1737l.m3593m(homeUI.yhZ, true);
                MMAppMgr.m7891BV();
                MMAppMgr.m7905bd(homeUI.yhZ);
                homeUI.yhZ.finish();
                AppMethodBeat.m2505o(29463);
                return;
            } else if (i == 30764 && intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                    C35805b.m58709b(homeUI.yhZ, "android.permission.ACCESS_COARSE_LOCATION", 66);
                }
            }
        }
        AppMethodBeat.m2505o(29463);
    }

    public void onPause() {
        AppMethodBeat.m2504i(29464);
        C4990ab.m7410d("MicroMsg.LauncherUI", "onPause, chatting is show ");
        super.onPause();
        C4736u c4736u = this.yjP;
        boolean cM = c4736u.mo9879cM("onPause");
        if (cM) {
            c4736u.vaA = false;
        }
        if (cM) {
            C4990ab.m7416i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
            AppMethodBeat.m2505o(29464);
            return;
        }
        C1311a.m2794HL();
        C4990ab.m7416i("MicroMsg.LauncherUI", "not skip this onPause");
        MMFragment currentFragmet = getCurrentFragmet();
        this.yjT.removeCallbacksAndMessages(null);
        HomeUI homeUI = this.yjJ;
        MainTabUI mainTabUI = homeUI.yiP;
        C4990ab.m7419v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", Integer.valueOf(mainTabUI.mbt), Boolean.valueOf(homeUI.yiv));
        if (homeUI.yiv) {
            mainTabUI.dyA();
        }
        C44395w c44395w = mainTabUI.ynE;
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().mo10121b(c44395w.ynY);
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10121b(c44395w);
            C16112c.m24429PK().mo28549b(c44395w.ynX);
            C4879a.xxA.mo10053d(c44395w.ynZ);
            C4879a.xxA.mo10053d(c44395w.yhr);
            C4879a.xxA.mo10053d(c44395w.yhq);
        }
        if (c44395w.ynW != null) {
            c44395w.ynW.ynT = null;
            c44395w.ynW = null;
        }
        C36298h c36298h = homeUI.yiO;
        if (c36298h.yic != null) {
            C9638aw.m17182Rg().mo14546b(255, c36298h.yic);
            C9638aw.m17182Rg().mo14546b(384, c36298h.yic);
            c36298h.yic = null;
        }
        C4872b.m7236cE(false);
        homeUI.yiM = C5182a.ACTIVITY_PAUSE;
        if (!C9638aw.m17183ZD()) {
            C9638aw.getNotification().mo41575bv(false);
        }
        boolean dxM = homeUI.yiN.dxM();
        C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(dxM)));
        if (!dxM) {
            C15909j.m24224a(homeUI.yhZ, 4, homeUI.yiP.mbt, "directReport_onPause");
        }
        if (!homeUI.yhZ.isFinishing()) {
            C5666h.m8512a(homeUI.yhZ);
        }
        if (homeUI.yiv) {
            C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
            C1314b.m2812HQ().mo4638HS();
            if (C9638aw.m17179RK()) {
                C4879a.xxA.mo10053d(homeUI.qjs);
            }
        }
        if (homeUI.yiD != null && homeUI.yiD.isShowing()) {
            homeUI.yiD.dismiss();
        }
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (newChattingTabUI.dxM()) {
            newChattingTabUI.mo76179kT(4);
            if (newChattingTabUI.ypn != null && newChattingTabUI.ypn.isSupportNavigationSwipeBack()) {
                newChattingTabUI.ypn.getSwipeBackLayout().setEnableGesture(false);
            }
        }
        if (currentFragmet != null) {
            AppMethodBeat.m2505o(29464);
            return;
        }
        this.yjM = false;
        AppMethodBeat.m2505o(29464);
    }

    public void onStop() {
        AppMethodBeat.m2504i(29465);
        C4990ab.m7416i("MicroMsg.LauncherUI", "onStop");
        C1311a.m2794HL();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("showprivacypolicy", this.yjJ.yjk);
        super.onStop();
        AppMethodBeat.m2505o(29465);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(29466);
        this.yjS = false;
        if (!this.yjK.mo70239a(this, i, strArr, iArr)) {
            HomeUI homeUI = this.yjJ;
            switch (i) {
                case 16:
                case 80:
                    int i2 = i == 80 ? C25738R.string.dc0 : C25738R.string.dbs;
                    if (iArr[0] != 0) {
                        C30379h.m48445a(homeUI.yhZ, homeUI.getString(i2), homeUI.getString(C25738R.string.dc8), homeUI.getString(C25738R.string.ckr), homeUI.getString(C25738R.string.abx), false, new C4423624(), new C4423725());
                        break;
                    }
                    break;
                case 24:
                    if (iArr[0] != 0) {
                        C30379h.m48445a(homeUI.yhZ, homeUI.getString("android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0), homeUI.getString(C25738R.string.dc8), homeUI.getString(C25738R.string.ckr), homeUI.getString(C25738R.string.f9076or), false, new C3033428(), new C2353629());
                        break;
                    } else {
                        homeUI.dxm();
                        break;
                    }
                case 65:
                    if (iArr[0] != 0) {
                        C30379h.m48445a(homeUI.yhZ, homeUI.getString(C25738R.string.dby), homeUI.getString(C25738R.string.dc8), homeUI.getString(C25738R.string.ckr), homeUI.getString(C25738R.string.abx), false, new C4423826(), null);
                        break;
                    } else {
                        homeUI.dxl();
                        break;
                    }
                case 66:
                    if (iArr[0] != 0) {
                        C30379h.m48445a(homeUI.yhZ, homeUI.getString(C25738R.string.dby), homeUI.getString(C25738R.string.dc8), homeUI.getString(C25738R.string.ckr), homeUI.getString(C25738R.string.abx), false, new C4423927(), null);
                        break;
                    }
                    MMFragment dyx = homeUI.yiP.dyx();
                    if (dyx instanceof FindMoreFriendsUI) {
                        ((FindMoreFriendsUI) dyx).dwU();
                        break;
                    }
                    break;
                case C33294a.CTRL_INDEX /*78*/:
                    if (iArr[0] != 0) {
                        C30379h.m48445a(homeUI.yhZ, homeUI.getString(C25738R.string.dby), homeUI.getString(C25738R.string.dc8), homeUI.getString(C25738R.string.ckr), homeUI.getString(C25738R.string.abx), false, new C4424330(), null);
                        break;
                    } else {
                        homeUI.dxm();
                        break;
                    }
            }
            NewChattingTabUI newChattingTabUI = this.chattingTabUI;
            if (newChattingTabUI.ypn != null) {
                newChattingTabUI.ypn.onRequestPermissionsResult(i, strArr, iArr);
            }
        }
        AppMethodBeat.m2505o(29466);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(29467);
        C1311a.m2794HL();
        super.onDestroy();
        HomeUI homeUI = this.yjJ;
        homeUI.yiP.dyy();
        if (homeUI.yiO != null) {
            C36298h c36298h = homeUI.yiO;
            C4879a.xxA.mo10053d(c36298h.yif);
            C4879a.xxA.mo10053d(c36298h.yig);
        }
        if (homeUI.yiv) {
            Looper.myQueue().removeIdleHandler(homeUI.jQs);
        }
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (!(newChattingTabUI.mPrepareBitmap == null || newChattingTabUI.mPrepareBitmap.isRecycled())) {
            C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", newChattingTabUI.mPrepareBitmap.toString());
            newChattingTabUI.mPrepareBitmap.recycle();
        }
        C5004al.m7439af(newChattingTabUI.mStartChattingRunnable);
        Looper.myQueue().removeIdleHandler(newChattingTabUI.ypi);
        dxF();
        C4990ab.m7417i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), C5046bo.m7559gU(this), Integer.valueOf(yjE.size()));
        AppMethodBeat.m2505o(29467);
    }

    /* renamed from: aR */
    private void m59299aR(Intent intent) {
        AppMethodBeat.m2504i(29468);
        int a = C5068w.m7682a(intent, "update_type", -1);
        if (a == -1) {
            C4990ab.m7412e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
            AppMethodBeat.m2505o(29468);
            return;
        }
        C7060h.pYm.mo8378a(405, 28, 1, true);
        if (C21429d.bQU() != null) {
            C21426a c = C21429d.bQU().mo36878c(this, null);
            if (c == null) {
                AppMethodBeat.m2505o(29468);
                return;
            } else {
                C7060h.pYm.mo8378a(405, a == 2 ? 29 : 30, 1, true);
                c.update(a);
            }
        }
        AppMethodBeat.m2505o(29468);
    }

    public void finish() {
        AppMethodBeat.m2504i(29469);
        super.finish();
        dxF();
        C4990ab.m7417i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", Integer.valueOf(hashCode()), Integer.valueOf(yjE.size()), C5046bo.dpG());
        AppMethodBeat.m2505o(29469);
    }

    public void onSwipe(float f) {
        AppMethodBeat.m2504i(29470);
        if (this.yjL && !this.chattingTabUI.mo76177bo(f)) {
            super.onSwipe(f);
        }
        AppMethodBeat.m2505o(29470);
    }

    public void onSettle(boolean z, int i) {
        AppMethodBeat.m2504i(29471);
        if (this.yjL && !this.chattingTabUI.mo76176G(z, i)) {
            super.onSettle(z, i);
        }
        AppMethodBeat.m2505o(29471);
    }

    public boolean forceRemoveNoMatchOnPath() {
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int i;
        AppMethodBeat.m2504i(29472);
        if (this.chattingTabUI.dxM()) {
            NewChattingTabUI newChattingTabUI = this.chattingTabUI;
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                C5004al.m7439af(newChattingTabUI.mStartChattingRunnable);
            }
            if (newChattingTabUI.isAnimating) {
                z = true;
            } else {
                z = newChattingTabUI.ypn.onKeyDown(keyEvent.getKeyCode(), keyEvent);
            }
            if (z) {
                AppMethodBeat.m2505o(29472);
                return true;
            }
        }
        HomeUI homeUI = this.yjJ;
        C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        C1407g.m2947KO();
        C1407g.m2947KO();
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && homeUI.yiD != null && homeUI.yiD.isShowing()) {
            homeUI.yiD.dismiss();
            i = 1;
        } else if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1) {
            homeUI.dxj();
            i = 1;
        } else {
            MMFragment dyx = homeUI.yiP.dyx();
            if (dyx == null || !dyx.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
                if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                    if (C9638aw.m17179RK() && C1720g.m3534RN().eJb && C5023at.isWap(homeUI.yhZ) && MMAppMgr.m7909c(homeUI.yhZ, new C3602418())) {
                        i = 1;
                    } else {
                        int backgroundLimitType = C5023at.getBackgroundLimitType(homeUI.yhZ);
                        if (C9638aw.m17179RK() && C1720g.m3534RN().eJb && C5023at.isLimited(backgroundLimitType)) {
                            C9638aw.m17190ZK();
                            if (C42252ah.m74618d((Boolean) C18628c.m29072Ry().get(16385, null)) && MMAppMgr.m7897a(homeUI.yhZ, backgroundLimitType, new C4064719(backgroundLimitType), new C3033320())) {
                                i = 1;
                            }
                        }
                        homeUI.dwf();
                    }
                }
                i = 0;
            } else {
                i = 1;
            }
        }
        if (i != 0) {
            AppMethodBeat.m2505o(29472);
            return true;
        }
        try {
            z = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.m2505o(29472);
            return z;
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.LauncherUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(29472);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(29473);
        super.onRestoreInstanceState(bundle);
        this.chattingTabUI.ypk = bundle.getString("last_restore_talker");
        C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", r0.ypk);
        AppMethodBeat.m2505o(29473);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(29474);
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (newChattingTabUI.ypn != null) {
            String talkerUserName = newChattingTabUI.ypn.cgL.getTalkerUserName();
            if (!C42252ah.isNullOrNil(talkerUserName)) {
                C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", talkerUserName);
                bundle.putString("last_restore_talker", talkerUserName);
            }
        }
        AppMethodBeat.m2505o(29474);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = false;
        AppMethodBeat.m2504i(29475);
        HomeUI homeUI = this.yjJ;
        MMFragment currentFragmet = homeUI.yhZ.getCurrentFragmet();
        if ((currentFragmet == null || !currentFragmet.isShowing()) && !homeUI.yiN.dxM()) {
            if (menuItem.getItemId() == 2) {
                C7060h.pYm.mo8374X(10919, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                homeUI.dxj();
            } else if (menuItem.getItemId() == 1) {
                homeUI.dxl();
            } else if (menuItem.getItemId() == 5) {
                if (C4872b.dnO() || C1947ae.gjs) {
                    C46696j c46696j = new C46696j(homeUI.yhZ);
                    c46696j.rBl = new C4423410();
                    c46696j.rBm = new C4424011();
                    c46696j.cuu();
                } else {
                    homeUI.dxm();
                }
            }
            z = true;
        }
        if (z) {
            AppMethodBeat.m2505o(29475);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.m2505o(29475);
        return onOptionsItemSelected;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(29476);
        if (this.chattingTabUI.dxM()) {
            AppMethodBeat.m2505o(29476);
            return false;
        }
        HomeUI homeUI = this.yjJ;
        if (homeUI.yiN == null || homeUI.yiN.dxM()) {
            AppMethodBeat.m2505o(29476);
            return false;
        }
        homeUI.yjf = menu;
        int height = homeUI.yhZ.getSupportActionBar().getHeight();
        int am = C1338a.m2857am(homeUI.yhZ, C25738R.dimen.f9810gd);
        if (homeUI.yiP.mbt == 3 && C46270n.isShowStoryCheck()) {
            homeUI.yje = menu.add(0, 5, 0, C25738R.string.ewp);
            if (homeUI.yja == null) {
                homeUI.yja = C1742b.m3596SM().mo5274a(homeUI.yhZ, "R.layout.actionbar_menu", 2130968614);
                homeUI.yja.setLayoutParams(new ViewGroup.LayoutParams(am, height));
                homeUI.yja.setBackgroundResource(C25738R.drawable.f6332al);
                homeUI.yja.setMinimumHeight(height);
                homeUI.yja.setMinimumWidth(am);
                homeUI.yja.setOnLongClickListener(new C406503());
                homeUI.yja.setOnClickListener(new C442454());
            }
            C22212h c22212h;
            if (homeUI.yiT) {
                homeUI.yja.findViewById(2131820972).setVisibility(0);
                c22212h = C22212h.scu;
                C22212h.m33897lo(1);
            } else {
                homeUI.yja.findViewById(2131820972).setVisibility(8);
                c22212h = C22212h.scu;
                C22212h.m33897lo(0);
            }
            homeUI.yje.setActionView(homeUI.yja);
            homeUI.dxu();
            homeUI.dxk();
        } else {
            int dimensionPixelSize;
            if (height == 0) {
                DisplayMetrics displayMetrics = homeUI.yhZ.getResources().getDisplayMetrics();
                dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? homeUI.yhZ.getResources().getDimensionPixelSize(C25738R.dimen.f9777fc) : homeUI.yhZ.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
            } else {
                dimensionPixelSize = height;
            }
            homeUI.yjb = menu.add(0, 1, 0, C25738R.string.ewn);
            homeUI.yjb.setIcon(C1318a.actionbar_icon_dark_search);
            if (homeUI.qlP) {
                homeUI.yjb.setIcon(C1318a.actionbar_icon_light_search);
            }
            if (homeUI.yfm == null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(am, dimensionPixelSize);
                homeUI.yfm = C1742b.m3596SM().mo5274a(homeUI.yhZ, "R.layout.actionview_with_dot_tips", 2130968621);
                homeUI.yiZ = (ImageView) homeUI.yfm.findViewById(2131820915);
                homeUI.yfm.setLayoutParams(layoutParams);
                homeUI.yfm.setBackgroundResource(C25738R.drawable.f6332al);
                homeUI.yfm.setMinimumHeight(dimensionPixelSize);
                homeUI.yfm.setMinimumWidth(am);
                homeUI.yiZ.setImageResource(C1318a.actionbar_icon_dark_search);
                homeUI.yfm.setOnClickListener(new C154665());
                homeUI.yfm.post(new C51806());
            }
            C0464g.m803a(homeUI.yjb, homeUI.yfm);
            homeUI.yjc = menu.add(0, 2, 0, C25738R.string.ewm);
            if (homeUI.yiW == null) {
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(am, dimensionPixelSize);
                homeUI.yiW = C1742b.m3596SM().mo5274a(homeUI.yhZ, "R.layout.actionview_with_dot_tips", 2130968621);
                homeUI.yiX = (ImageView) homeUI.yiW.findViewById(2131820915);
                homeUI.yiY = homeUI.yiW.findViewById(2131820972);
                homeUI.yiW.setLayoutParams(layoutParams2);
                homeUI.yiW.setBackgroundResource(C25738R.drawable.f6332al);
                homeUI.yiW.setMinimumHeight(dimensionPixelSize);
                homeUI.yiW.setMinimumWidth(am);
                homeUI.yiX.setImageResource(C1318a.icons_outlined_add2);
                homeUI.yiW.setContentDescription(homeUI.getString(C25738R.string.ewm));
                homeUI.yiW.setOnClickListener(new C154677());
                homeUI.yiW.post(new C51818());
            }
            if (homeUI.qlP && homeUI.yiX != null) {
                homeUI.yiX.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            }
            C1314b.m2812HQ().mo4642o(new C360279());
            homeUI.yjc.setActionView(homeUI.yiW);
            homeUI.dxk();
            homeUI.yiW.getLayoutParams().width = am;
            homeUI.yiW.getLayoutParams().height = dimensionPixelSize;
        }
        C4990ab.m7418v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.m2505o(29476);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(29477);
        super.onConfigurationChanged(configuration);
        HomeUI homeUI = this.yjJ;
        C30036f.m47541b(homeUI.yhZ, homeUI.contentView);
        AppMethodBeat.m2505o(29477);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        ActionMode actionMode = null;
        AppMethodBeat.m2504i(29478);
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (!(newChattingTabUI.ypn == null || newChattingTabUI.ypn.dBO() == null || !newChattingTabUI.ypn.isSupportCustomActionBar() || C1443d.m3069iX(22))) {
            ActionMode startActionMode = newChattingTabUI.ypn.dBO().startActionMode(callback);
            if (startActionMode != null) {
                actionMode = startActionMode;
            }
        }
        if (actionMode == null) {
            actionMode = super.onWindowStartingActionMode(callback);
        }
        AppMethodBeat.m2505o(29478);
        return actionMode;
    }

    public MMFragment getCurrentFragmet() {
        MMFragment mMFragment;
        AppMethodBeat.m2504i(29479);
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (newChattingTabUI.mChattingClosed) {
            mMFragment = null;
        } else {
            mMFragment = newChattingTabUI.ypn;
        }
        if (mMFragment == null) {
            mMFragment = super.getCurrentFragmet();
        }
        AppMethodBeat.m2505o(29479);
        return mMFragment;
    }

    public HomeUI getHomeUI() {
        return this.yjJ;
    }

    /* renamed from: ho */
    public static void m59303ho(Context context) {
        AppMethodBeat.m2504i(29480);
        Intent intent = new Intent(context, LauncherUI.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
        AppMethodBeat.m2505o(29480);
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(29481);
        this.yjJ.dxn();
        this.chattingTabUI.startChatting(str, bundle, z);
        AppMethodBeat.m2505o(29481);
    }

    public final void closeChatting(boolean z) {
        AppMethodBeat.m2504i(29482);
        C360315 c360315 = new C360315();
        if (this.chattingTabUI.mo76180pW(z)) {
            this.yjJ.mo69895pI(this.chattingTabUI.ypn.isSupportCustomActionBar());
            this.yjJ.getMainTabUI().dyG();
        }
        AppMethodBeat.m2505o(29482);
    }
}
