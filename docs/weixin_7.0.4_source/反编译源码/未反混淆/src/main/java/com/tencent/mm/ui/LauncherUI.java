package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
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
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.v;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.app.t;
import com.tencent.mm.blink.FirstScreenFrameLayout;
import com.tencent.mm.blink.b;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.x;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.l;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.account.ui.WelcomeSelectView;
import com.tencent.mm.plugin.account.ui.WelcomeView;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.pluginsdk.g.a.a.o;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.HomeUI.AnonymousClass19;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MainTabUI.TabsAdapter;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
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
    private n yjK = new n();
    public boolean yjL = false;
    boolean yjM = false;
    private boolean yjN = false;
    private WelcomeView yjO;
    private u yjP = new u("MicroMsg.LauncherUI");
    t yjQ;
    private boolean yjS = false;
    private ak yjT = new ak();
    private Runnable yjU = new Runnable() {
        long cvc = FaceGestureDetGLThread.BRIGHTNESS_DURATION;

        @TargetApi(17)
        public final void run() {
            AppMethodBeat.i(29447);
            ab.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", Long.valueOf(Thread.currentThread().getId()));
            al.af(this);
            if (aw.ZM()) {
                Object[] objArr = new Object[1];
                g.RN();
                objArr[0] = Integer.valueOf(com.tencent.mm.kernel.a.QF());
                ab.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", objArr);
                AppMethodBeat.o(29447);
            } else if (com.tencent.mm.modelstat.d.akd() || com.tencent.mm.sdk.a.b.foreground) {
                this.cvc += FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                if (this.cvc > 10000) {
                    this.cvc = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                }
                ab.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", Boolean.valueOf(com.tencent.mm.modelstat.d.akd()), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), Long.valueOf(this.cvc));
                al.n(this, this.cvc);
                AppMethodBeat.o(29447);
            } else {
                ab.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
                if (WXHardCoderJNI.isCheckEnv()) {
                    com.tencent.mm.sdk.g.d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(138620);
                            WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
                            ab.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
                            AppMethodBeat.o(138620);
                        }
                    }, "terminateApp");
                }
                ab.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
                AppMethodBeat.o(29447);
            }
        }
    };

    interface c {
        void dxq();
    }

    interface d {
    }

    interface b {
        void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup);

        boolean dxp();

        void dxr();

        void dxs();
    }

    interface a {
        boolean dxM();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LauncherUI() {
        AppMethodBeat.i(29448);
        AppMethodBeat.o(29448);
    }

    static /* synthetic */ void a(LauncherUI launcherUI) {
        AppMethodBeat.i(29483);
        launcherUI.pM(true);
        AppMethodBeat.o(29483);
    }

    static /* synthetic */ void b(LauncherUI launcherUI) {
        AppMethodBeat.i(29484);
        launcherUI.dxL();
        AppMethodBeat.o(29484);
    }

    static {
        AppMethodBeat.i(29485);
        AppMethodBeat.o(29485);
    }

    public static LauncherUI getInstance() {
        AppMethodBeat.i(29449);
        if (yjE.isEmpty()) {
            ab.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", bo.dpG());
            AppMethodBeat.o(29449);
            return null;
        }
        LauncherUI launcherUI = (LauncherUI) yjE.get(0);
        AppMethodBeat.o(29449);
        return launcherUI;
    }

    public static int dxE() {
        AppMethodBeat.i(29450);
        if (getInstance() == null || getInstance().getHomeUI() == null || getInstance().getHomeUI().getMainTabUI() == null) {
            AppMethodBeat.o(29450);
            return -1;
        }
        int i = getInstance().getHomeUI().getMainTabUI().mbt;
        AppMethodBeat.o(29450);
        return i;
    }

    private void dxF() {
        AppMethodBeat.i(29451);
        int indexOf = yjE.indexOf(this);
        if (indexOf >= 0) {
            yjE.remove(indexOf);
        }
        ab.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", Integer.valueOf(indexOf), Integer.valueOf(yjE.size()), Integer.valueOf(hashCode()));
        AppMethodBeat.o(29451);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        Object obj;
        AppMethodBeat.i(29452);
        com.tencent.mm.blink.a.eM(h.RT().eKD);
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bo.gU(this));
        this.yjQ = new t();
        super.onCreate(bundle);
        MainProcessChecker.UD(getClass().getName());
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        long currentTimeMillis2 = System.currentTimeMillis();
        int taskId = getTaskId();
        String packageName = getPackageName();
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null && w.a(intent, "absolutely_exit", false)) {
            z = true;
            ab.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
        boolean z2 = z;
        Iterator it = yjF.iterator();
        while (it.hasNext()) {
            if (((LauncherUI) ((WeakReference) it.next()).get()) != null) {
                ab.i("MicroMsg.LauncherUI", "Check launcher instance found one %s", (LauncherUI) ((WeakReference) it.next()).get());
            }
        }
        RunningTaskInfo runningTaskInfo = null;
        if (!z2) {
            Iterator it2 = yjE.iterator();
            while (it2.hasNext()) {
                LauncherUI launcherUI = (LauncherUI) it2.next();
                if (launcherUI.getTaskId() != taskId) {
                    ab.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", Integer.valueOf(launcherUI.hashCode()), Integer.valueOf(launcherUI.getTaskId()), Integer.valueOf(taskId));
                    runningTaskInfo = bo.av(this, taskId);
                    if (runningTaskInfo == null) {
                        ab.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", Integer.valueOf(taskId));
                        finish();
                        obj = null;
                        break;
                    }
                    ab.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", Integer.valueOf(runningTaskInfo.id), runningTaskInfo.topActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning));
                    if (runningTaskInfo.baseActivity.getPackageName().equals(packageName)) {
                        launcherUI.finish();
                        yjE.remove(launcherUI);
                    } else {
                        ab.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + runningTaskInfo.baseActivity.getPackageName());
                        finish();
                        if (bo.av(this, launcherUI.getTaskId()) != null) {
                            ab.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
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
                runningTaskInfo = bo.av(this, taskId);
            }
            if (runningTaskInfo != null) {
                ab.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", Integer.valueOf(runningTaskInfo.id), runningTaskInfo.baseActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning));
                packageName = getComponentName().getClassName();
                if (runningTaskInfo.numActivities > 1 && packageName.equals(r0) && packageName.equals(r3)) {
                    finish();
                    ab.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", Integer.valueOf(yjE.size()));
                    obj = null;
                    if (obj != null) {
                        ab.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
                        AppMethodBeat.o(29452);
                        return;
                    }
                    ab.i("MicroMsg.LauncherUI", "onCreate normally");
                    this.yjJ = new HomeUI();
                    this.chattingTabUI = new NewChattingTabUI(this.yjJ);
                    HomeUI homeUI = this.yjJ;
                    NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                    homeUI.yhZ = this;
                    homeUI.yiN = newChattingTabUI;
                    MainTabUI mainTabUI = homeUI.yiP;
                    mainTabUI.yhZ = this;
                    mainTabUI.ynF = homeUI;
                    w wVar = mainTabUI.ynE;
                    wVar.yhZ = this;
                    wVar.ynS = homeUI;
                    mainTabUI.iVv = homeUI;
                    homeUI.yiO = new h(this, homeUI);
                    NotifyReceiver.Im();
                    f.ah(homeUI.yhZ);
                    homeUI.mActionBar = getSupportActionBar();
                    if (homeUI.mActionBar != null) {
                        if (VERSION.SDK_INT < 11) {
                            homeUI.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dy)));
                        }
                        homeUI.mActionBar.hide();
                    }
                    setRequestedOrientation(1);
                    homeUI.yiQ = getResources().getColor(R.color.vy);
                    homeUI.yiR = Color.alpha(homeUI.yiQ);
                    String T = av.fly.T("login_user_name", "");
                    this.cEp = getIntent();
                    this.yjP.vaA = this.cEp.getBooleanExtra("splash-hack-activity-recreate", false);
                    ab.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", r1.mTag, Boolean.valueOf(r1.vaA));
                    ab.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", T, Boolean.valueOf(aw.ZM()), Boolean.valueOf(yjG));
                    if (yjG || (!aw.ZM() && T.equals(""))) {
                        yjH = currentTimeMillis;
                        ab.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.b.cdW));
                        setRequestedOrientation(1);
                        obj = (aw.ZM() || !av.fly.T("login_user_name", "").equals("")) ? null : 1;
                        if (obj == null) {
                            com.tencent.mm.sdk.platformtools.g.xye = false;
                        } else {
                            z = false;
                            if (com.tencent.mm.sdk.platformtools.g.xyf) {
                                yjI = true;
                                z = MMAppMgr.a((Activity) this, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(29443);
                                        LauncherUI.a(LauncherUI.this);
                                        LauncherUI.yjI = false;
                                        o.aVi();
                                        Activity activity = this;
                                        WelcomeView welcomeSelectView = new WelcomeSelectView(this);
                                        activity.setContentView(welcomeSelectView);
                                        LauncherUI.this.yjO = welcomeSelectView;
                                        LauncherUI.b(LauncherUI.this);
                                        AppMethodBeat.o(29443);
                                    }
                                });
                            } else {
                                MMAppMgr.hs(this);
                            }
                            if (!z) {
                                pM(true);
                                yjI = false;
                                o.aVi();
                                com.tencent.mm.plugin.report.service.g.BP(8);
                                WelcomeSelectView welcomeSelectView = new WelcomeSelectView(this);
                                setContentView(welcomeSelectView);
                                this.yjO = welcomeSelectView;
                                ab.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", Integer.valueOf(hashCode()));
                                al.af(this.yjU);
                                al.n(this.yjU, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                            }
                        }
                    } else {
                        yjH = currentTimeMillis;
                        ab.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.b.cdW));
                    }
                    if (dxI()) {
                        ab.i("MicroMsg.LauncherUI", "handleExitIntent return");
                        AppMethodBeat.o(29452);
                        return;
                    }
                    dxG();
                    ae.hD(this);
                    AppMethodBeat.o(29452);
                    return;
                }
                ab.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", Integer.valueOf(yjE.size()), Boolean.valueOf(z2));
                yjE.clear();
            } else {
                ab.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", Integer.valueOf(taskId), Integer.valueOf(yjE.size()));
                yjE.clear();
            }
        }
        yjE.add(this);
        yjF.add(new WeakReference(this));
        ab.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", Integer.valueOf(yjE.size()), Integer.valueOf(yjF.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        obj = 1;
        if (obj != null) {
        }
    }

    private void dxG() {
        AppMethodBeat.i(29453);
        ab.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
        if (yjR) {
            ab.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
            AppMethodBeat.o(29453);
        } else if (!g.RN().QY()) {
            g.RN();
            if (com.tencent.mm.kernel.a.QX()) {
                ab.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
                AppMethodBeat.o(29453);
                return;
            }
            ab.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
            AppMethodBeat.o(29453);
        } else if (dxH()) {
            if (w.a(getIntent(), "LauncherUI.enter_from_reg", false) || e.vdx == null || !e.vdx.Ch() || !aw.RK()) {
                ab.d("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew.");
            } else if (aj.amA("show_whatsnew")) {
                yjR = true;
                ab.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
                MMAppMgr.aq(this);
                com.tencent.mm.blink.a.HL();
                AppMethodBeat.o(29453);
                return;
            }
            AppMethodBeat.o(29453);
        } else {
            ab.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
            AppMethodBeat.o(29453);
        }
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(29454);
        ab.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", Integer.valueOf(hashCode()), bo.gU(this));
        this.cEp = intent;
        super.onNewIntent(intent);
        setIntent(intent);
        if (dxI()) {
            ab.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
            AppMethodBeat.o(29454);
        } else if (this.cEp == null || !w.a(this.cEp, "Intro_Need_Clear_Top ", false)) {
            if ((intent.getFlags() & 67108864) == 67108864) {
                closeChatting(false);
            }
            MainTabUI mainTabUI = this.yjJ.yiP;
            if ((intent.getFlags() & 67108864) == 67108864) {
                mainTabUI.ynG = true;
            }
            if (this.yjL) {
                ab.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
                aQ(intent);
            }
            AppMethodBeat.o(29454);
        } else {
            ab.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
            finish();
            ho(this);
            AppMethodBeat.o(29454);
        }
    }

    private void pM(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(29455);
        if (z) {
            if (this.yjK.c(this, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29444);
                    LauncherUI.a(LauncherUI.this);
                    AppMethodBeat.o(29444);
                }
            })) {
                z2 = false;
            }
            this.yjS = z2;
            AppMethodBeat.o(29455);
            return;
        }
        if (!this.yjS) {
            if (this.yjK.ao(this)) {
                z2 = false;
            }
            this.yjS = z2;
        }
        AppMethodBeat.o(29455);
    }

    public void onResume() {
        AppMethodBeat.i(29456);
        super.onResume();
        if (this.yjP.cM("onResume")) {
            ab.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
            AppMethodBeat.o(29456);
            return;
        }
        ab.i("MicroMsg.LauncherUI", "not skip this onResume");
        yjG = false;
        if (dxH()) {
            h hVar;
            long currentTimeMillis;
            long currentTimeMillis2;
            MainUI mainUI;
            LauncherUI instance;
            Object n;
            ab.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", Boolean.valueOf(this.yjL));
            if (!this.yjL) {
                this.yjL = true;
                HomeUI homeUI = this.yjJ;
                homeUI.yiT = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
                hVar = homeUI.yiO;
                com.tencent.mm.sdk.b.a.xxA.c(hVar.yif);
                com.tencent.mm.sdk.b.a.xxA.c(hVar.yig);
                if (!com.tencent.mm.ui.conversation.b.dIo()) {
                    getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
                }
                SharedPreferences sharedPreferences = homeUI.yhZ.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mu());
                if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                    sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                    XLogSetup.realSetupXlog();
                }
                homeUI.yiD = new aa(this);
                homeUI.yiv = true;
                NotifyReceiver.Io();
                aw.getNotification().il(1);
                ab.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
                currentTimeMillis = System.currentTimeMillis();
                if (aw.RK()) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    MMActivity.initLanguage(homeUI.yhZ);
                    try {
                        Set hashSet = new HashSet();
                        String[] split = homeUI.getString(R.string.b3c).split(";");
                        hashSet.add(split[0]);
                        hashSet.add(split[1]);
                        s.c(hashSet);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
                    }
                    g.RQ();
                    g.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29360);
                            com.tencent.mm.sdk.b.a.xxA.m(new bc());
                            AppMethodBeat.o(29360);
                        }
                    });
                    ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.ezi = (LayoutInflater) homeUI.yhZ.getSystemService("layout_inflater");
                    currentTimeMillis2 = System.currentTimeMillis();
                    homeUI.contentView = com.tencent.mm.kiss.a.b.SM().a(homeUI.yhZ, "R.layout.main_tab", (int) R.layout.ab9);
                    if (!(homeUI.contentView == null || VERSION.SDK_INT < 23 || com.tencent.mm.compatible.util.h.Mt())) {
                        homeUI.contentView.setBackgroundColor(homeUI.yhZ.getResources().getColor(R.color.vy));
                    }
                    com.tencent.mm.blink.b.HQ().HR();
                    ((FirstScreenFrameLayout) homeUI.contentView.findViewById(R.id.d26)).ebs = new com.tencent.mm.blink.FirstScreenFrameLayout.a() {
                        public final void Ia() {
                            AppMethodBeat.i(29355);
                            if (com.tencent.mm.blink.a.HM()) {
                                com.tencent.mm.blink.a.ig(6);
                                com.tencent.mm.blink.a.HN();
                                com.tencent.mm.blink.a.jD("First Screen");
                                com.tencent.mm.vending.g.f.dMn().ny(500).d(new com.tencent.mm.vending.c.a<Void, Void>() {
                                    public final /* synthetic */ Object call(Object obj) {
                                        AppMethodBeat.i(29354);
                                        ArrayList HO = com.tencent.mm.blink.a.HO();
                                        ArrayList arrayList = new ArrayList();
                                        Iterator it = HO.iterator();
                                        while (it.hasNext()) {
                                            long[] jArr = (long[]) it.next();
                                            ab.i("MicroMsg.LauncherUI.HomeUI", "blink-startup %s, %s, %s", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]), Long.valueOf(jArr[2]));
                                            arrayList.add(new IDKey(jArr[0], jArr[1], jArr[2]));
                                        }
                                        if (arrayList.size() > 0) {
                                            com.tencent.mm.plugin.report.service.h.pYm.b(arrayList, false);
                                        }
                                        ab.i("MicroMsg.LauncherUI.HomeUI", "blink-startup report size %s", Integer.valueOf(HO.size()));
                                        HO.clear();
                                        Iterator it2 = com.tencent.mm.blink.a.HP().iterator();
                                        while (it2.hasNext()) {
                                            Object[] objArr = (Object[]) it2.next();
                                            com.tencent.mm.plugin.report.service.h.pYm.e(((Integer) objArr[0]).intValue(), (Object[]) objArr[1]);
                                            ab.i("MicroMsg.LauncherUI.HomeUI", "blink-startup kv %s, %s", objArr[0], ((Object[]) objArr[1])[0]);
                                        }
                                        Void voidR = zXH;
                                        AppMethodBeat.o(29354);
                                        return voidR;
                                    }
                                });
                            }
                            b.HQ().HU();
                            AppMethodBeat.o(29355);
                        }
                    };
                    am.dhM();
                    ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.yhZ.setContentView(homeUI.contentView);
                    Looper.myQueue().addIdleHandler(homeUI.jQs);
                    homeUI.yiw = true;
                    ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - currentTimeMillis2));
                    ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    homeUI.initActionBar();
                    homeUI.mActionBar.show();
                    homeUI.contentView.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29369);
                            HomeUI.a(HomeUI.this);
                            aw.ZK();
                            c.Ry().setInt(327947, HomeUI.this.mActionBar.getHeight());
                            ab.i("MicroMsg.LauncherUI.HomeUI", "contentView.post then setFullScreenAfterSetContentView, padding: %s", Integer.valueOf(HomeUI.this.contentView.getPaddingTop()));
                            f.b(HomeUI.this.yhZ, HomeUI.this.contentView);
                            AppMethodBeat.o(29369);
                        }

                        public final String toString() {
                            AppMethodBeat.i(29370);
                            String str = super.toString() + "|updateTitle";
                            AppMethodBeat.o(29370);
                            return str;
                        }
                    });
                    ab.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - currentTimeMillis));
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29379);
                            ab.d("MicroMsg.LauncherUI.HomeUI", "onMainTabCreate, send refresh broadcast");
                            HomeUI.this.yhZ.sendBroadcast(new Intent(ConstantsAPI.ACTION_REFRESH_WXAPP));
                            AppMethodBeat.o(29379);
                        }

                        public final String toString() {
                            AppMethodBeat.i(29380);
                            String str = super.toString() + "|sendBroadcast";
                            AppMethodBeat.o(29380);
                            return str;
                        }
                    }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    homeUI.contentView.addOnLayoutChangeListener(homeUI.yiU);
                    f.b(homeUI.yhZ, homeUI.contentView);
                    homeUI.contentView.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29381);
                            ab.i("MicroMsg.LauncherUI.HomeUI", "contentView.post, padding: %s", Integer.valueOf(HomeUI.this.contentView.getPaddingTop()));
                            AppMethodBeat.o(29381);
                        }
                    }, 20);
                } else {
                    ab.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
                    homeUI.yhZ.finish();
                }
                MainTabUI mainTabUI = homeUI.yiP;
                mainTabUI.yeo = (CustomViewPager) mainTabUI.yhZ.findViewById(R.id.bns);
                mainTabUI.yeo.setOffscreenPageLimit(4);
                mainTabUI.yeo.setCanSlide(true);
                mainTabUI.yeo.setCanSlideBySide(false);
                mainTabUI.ynI = new TabsAdapter(mainTabUI.yhZ, mainTabUI.yeo);
                mainTabUI.Nm(0);
                w wVar = mainTabUI.ynE;
                ViewGroup viewGroup = (ViewGroup) mainTabUI.yeo.getParent();
                TabsAdapter tabsAdapter = mainTabUI.ynI;
                c cVar = wVar.ynT;
                if (wVar.ynT != null) {
                    wVar.ynT.setOnTabClickListener(null);
                    ((View) wVar.ynT).setVisibility(8);
                    if (viewGroup != null) {
                        viewGroup.removeView((View) wVar.ynT);
                    }
                }
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                LauncherUIBottomTabView launcherUIBottomTabView = new LauncherUIBottomTabView(wVar.yhZ);
                launcherUIBottomTabView.setId(R.id.bq);
                if (viewGroup != null) {
                    layoutParams.gravity = 80;
                    viewGroup.addView(launcherUIBottomTabView, layoutParams);
                }
                wVar.ynT = launcherUIBottomTabView;
                ((View) wVar.ynT).setVisibility(0);
                wVar.ynT.setOnTabClickListener(tabsAdapter);
                if (!(cVar == null || cVar == wVar.ynT)) {
                    wVar.ynT.px(cVar.getShowFriendPoint());
                    wVar.ynT.py(cVar.getSettingsPoint());
                    wVar.ynT.MM(cVar.getMainTabUnread());
                    wVar.ynT.MN(cVar.getContactTabUnread());
                    wVar.ynT.MO(cVar.getFriendTabUnread());
                    wVar.ynT.MP(cVar.getSettingsTabUnread());
                    wVar.ynT.setTo(cVar.getCurIdx());
                }
                homeUI.yiP.ynL = new com.tencent.mm.ui.MainTabUI.a() {
                    public final void MU(int i) {
                        AppMethodBeat.i(29339);
                        HomeUI.a(HomeUI.this);
                        if (i != 0) {
                            HomeUI.this.a(1.0f, HomeUI.this.yhZ.getResources().getColor(R.color.vy), HomeUI.this.yhZ.getResources().getColor(R.color.e4), HomeUI.this.yhZ.getResources().getColor(R.color.h4));
                        }
                        AppMethodBeat.o(29339);
                    }

                    public final void p(int i, float f) {
                        AppMethodBeat.i(29340);
                        HomeUI.a(HomeUI.this, i, f);
                        AppMethodBeat.o(29340);
                    }

                    public final void MV(int i) {
                        AppMethodBeat.i(29341);
                        if (HomeUI.this.yiL == 0 && i == 1) {
                            HomeUI.this.yiJ = HomeUI.this.yiP.mbt;
                        } else if (i == 2) {
                            HomeUI.this.yiK = HomeUI.this.yiP.mbt;
                        } else if (i == 0) {
                            HomeUI.this.yiJ = 0;
                            HomeUI.this.yiK = 0;
                        }
                        HomeUI.this.yiL = i;
                        ab.d("MicroMsg.LauncherUI.HomeUI", "tabSelectedStateChanged:%s begin:%s end:%s", Integer.valueOf(i), Integer.valueOf(HomeUI.this.yiJ), Integer.valueOf(HomeUI.this.yiK));
                        AppMethodBeat.o(29341);
                    }
                };
                this.chattingTabUI.iWA = this;
                aQ(getIntent());
            }
            HomeUI homeUI2 = this.yjJ;
            long anU = ah.anU();
            MainTabUI mainTabUI2 = homeUI2.yiP;
            ab.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", Integer.valueOf(mainTabUI2.mbt));
            if (mainTabUI2.ynQ.size() != 0) {
                ((m) ((MMFragment) mainTabUI2.ynQ.get(Integer.valueOf(mainTabUI2.mbt)))).dwi();
            }
            if (mainTabUI2.ynG && mainTabUI2.yhZ.getIntent().hasExtra("isScrollFirst") && mainTabUI2.yhZ.getIntent().hasExtra("isShowHeader")) {
                mainUI = (MainUI) mainTabUI2.ynQ.get(Integer.valueOf(0));
                if (mainUI != null) {
                    mainUI.i(mainTabUI2.yhZ.getIntent().getBooleanExtra("isShowHeader", false), mainTabUI2.yhZ.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), mainTabUI2.yhZ.getIntent().getBooleanExtra("isScrollFirst", true));
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
                aw.getNotification().bv(true);
            } else {
                aw.getNotification().bv(false);
            }
            m mVar = (m) mainTabUI2.Nn(mainTabUI2.mbt);
            if (mVar != null) {
                mVar.dwj();
            }
            mainTabUI2.ynG = false;
            int a = w.a(mainTabUI2.yhZ.getIntent(), "preferred_tab", 0);
            ab.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", Integer.valueOf(a));
            if (a != 0) {
                mainTabUI2.Nm(a);
                mainTabUI2.yhZ.getIntent().putExtra("preferred_tab", 0);
            }
            com.tencent.mm.sdk.b.a.xxA.c(mainTabUI2.ynM);
            com.tencent.mm.sdk.b.a.xxA.c(mainTabUI2.ynO);
            w wVar2 = mainTabUI2.ynE;
            if (wVar2.ynT != null) {
                wVar2.ynT.dwp();
            }
            aw.ZK();
            com.tencent.mm.model.c.Ry().a(wVar2.ynY);
            com.tencent.mm.x.c.PK().a(wVar2.ynX);
            aw.ZK();
            com.tencent.mm.model.c.XR().a(wVar2);
            com.tencent.mm.sdk.b.a.xxA.c(wVar2.yhr);
            com.tencent.mm.sdk.b.a.xxA.c(wVar2.ynZ);
            com.tencent.mm.sdk.b.a.xxA.c(wVar2.yhq);
            com.tencent.mm.blink.b.HQ().o(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29664);
                    w.a(w.this);
                    w.this.dyI();
                    w.b(w.this);
                    AppMethodBeat.o(29664);
                }
            });
            hVar = homeUI2.yiO;
            az azVar = new az();
            com.tencent.mm.sdk.b.a.xxA.m(azVar);
            if (azVar.cuh.cui && !ah.isNullOrNil(azVar.cuh.bzH)) {
                ab.d("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", azVar.cuh.bzH);
                com.tencent.mm.ui.base.h.b(hVar.yhZ, azVar.cuh.bzH, azVar.cuh.title, true);
            }
            if (!hVar.a(hVar.yib)) {
                aw.RS().m(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:17:0x016c  */
                    /* JADX WARNING: Removed duplicated region for block: B:19:0x017c  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        boolean z;
                        AppMethodBeat.i(29316);
                        SharedPreferences doB = com.tencent.mm.sdk.platformtools.ah.doB();
                        long j = doB.getLong("show_sdcard_full_time", 0);
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean z2 = currentTimeMillis - j > 10800000 || j > currentTimeMillis;
                        h hVar = h.this;
                        int On = a.On();
                        boolean Mo = com.tencent.mm.compatible.util.f.Mo();
                        ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space _dataRet[%d] checkSdIsFull[%b] needShowAlert[%b] testCode[%d] ", Integer.valueOf(hVar.hashCode()), Integer.valueOf(On), Boolean.valueOf(Mo), Boolean.valueOf(z2), Integer.valueOf(hVar.cur));
                        if (hVar.cur == 1) {
                            On = 1;
                            z = true;
                            hVar.cur = 4;
                        } else {
                            if (hVar.cur == 2) {
                                z = true;
                                On = 2;
                            } else if (hVar.cur == 3) {
                                On = 0;
                                Mo = true;
                                z = true;
                            } else if (hVar.cur == 4) {
                                hVar.cur = 0;
                                z2 = false;
                                if (z2) {
                                    doB.edit().putLong("show_sdcard_full_time", currentTimeMillis).commit();
                                }
                                if (!z2) {
                                    aw.ZK();
                                    if (((Boolean) c.Ry().get(ac.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                                        aw.ZK();
                                        if (ah.isNullOrNil((String) c.Ry().get(6, (Object) ""))) {
                                            aw.ZK();
                                            z = ((Boolean) c.Ry().get(ac.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.FALSE)).booleanValue();
                                            aw.ZK();
                                            final String str = (String) c.Ry().get(ac.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, h.this.getString(R.string.a72));
                                            ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", Boolean.valueOf(r2), r0, Boolean.valueOf(z), str);
                                            if (z) {
                                                com.tencent.mm.ui.base.h.a(h.this.yhZ, str, h.this.getString(R.string.tz), h.this.getString(R.string.s6), false, new OnClickListener() {
                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                        AppMethodBeat.i(29313);
                                                        Intent intent = new Intent();
                                                        intent.setClass(h.this.yhZ, BindMobileUI.class);
                                                        intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, ""));
                                                        MMWizardActivity.J(h.this.yhZ, intent);
                                                        dialogInterface.dismiss();
                                                        AppMethodBeat.o(29313);
                                                    }
                                                });
                                            } else {
                                                com.tencent.mm.ui.base.h.d(h.this.yhZ, str, h.this.getString(R.string.tz), h.this.getString(R.string.s6), h.this.getString(R.string.or), new OnClickListener() {
                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                        AppMethodBeat.i(29314);
                                                        Intent intent = new Intent();
                                                        intent.setClass(h.this.yhZ, BindMobileUI.class);
                                                        intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, ""));
                                                        MMWizardActivity.J(h.this.yhZ, intent);
                                                        dialogInterface.dismiss();
                                                        AppMethodBeat.o(29314);
                                                    }
                                                }, new OnClickListener() {
                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                        AppMethodBeat.i(29315);
                                                        dialogInterface.dismiss();
                                                        AppMethodBeat.o(29315);
                                                    }
                                                });
                                            }
                                        } else {
                                            ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", (String) c.Ry().get(6, (Object) ""));
                                        }
                                        aw.ZK();
                                        c.Ry().set(ac.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.FALSE);
                                        aw.ZK();
                                        c.Ry().set(ac.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, (Object) "");
                                        aw.ZK();
                                        c.Ry().dsb();
                                    }
                                }
                                AppMethodBeat.o(29316);
                            } else {
                                z = z2;
                            }
                            hVar.cur = 0;
                        }
                        com.tencent.mm.ui.widget.a.c.a aVar;
                        if (On == 1) {
                            if (z) {
                                z2 = true;
                                aVar = new com.tencent.mm.ui.widget.a.c.a(hVar.yhZ);
                                aVar.PV(R.string.apc);
                                aVar.asE(hVar.yhZ.getString(R.string.apb));
                                aVar.rc(false);
                                aVar.Qc(R.string.ap9).a(new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aMb().show();
                                ab.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d show no space notification isShowLackSpaceNotification[%b]", Integer.valueOf(hVar.hashCode()), Boolean.valueOf(hVar.yid));
                                if (!hVar.yid) {
                                    aw.getNotification().cancel(45);
                                    hVar.yid = true;
                                    PendingIntent activity = PendingIntent.getActivity(com.tencent.mm.sdk.platformtools.ah.getContext(), 45, new Intent(com.tencent.mm.sdk.platformtools.ah.getContext(), LauncherUI.class), 134217728);
                                    v.c z3 = com.tencent.mm.bo.a.bt(com.tencent.mm.sdk.platformtools.ah.getContext(), "reminder_channel_id").g(hVar.getString(R.string.apc)).d(hVar.getString(R.string.apc)).e(hVar.getString(R.string.apb)).z(false);
                                    z3.EI = activity;
                                    z3.k(2, true);
                                    Notification build = z3.build();
                                    build.icon = com.tencent.mm.bo.a.bWV();
                                    build.flags |= 32;
                                    aw.getNotification().a(45, build, false);
                                }
                                com.tencent.mm.plugin.report.service.h.pYm.a(282, 20, 1, false);
                            }
                            z2 = false;
                        } else if (On == 2) {
                            if (z) {
                                z2 = true;
                                aw.hold();
                                aVar = new com.tencent.mm.ui.widget.a.c.a(hVar.yhZ);
                                aVar.PV(R.string.apa);
                                aVar.asE(hVar.yhZ.getString(R.string.ap_));
                                aVar.rc(false);
                                aVar.Qc(R.string.ap8).a(new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(29310);
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(29309);
                                                g.RQ().lL("");
                                                MMAppMgr.aAd();
                                                AppMethodBeat.o(29309);
                                            }
                                        });
                                        AppMethodBeat.o(29310);
                                    }
                                });
                                aVar.aMb().show();
                                com.tencent.mm.plugin.report.service.h.pYm.a(282, 2, 1, false);
                            }
                            z2 = false;
                        } else {
                            ab.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d cancel no space notification isShowLackSpaceNotification[%b] hadCheckNotification[%b]", Integer.valueOf(hVar.hashCode()), Boolean.valueOf(hVar.yid), Boolean.valueOf(hVar.yie));
                            if (!hVar.yie || hVar.yid) {
                                aw.getNotification().cancel(45);
                                hVar.yid = false;
                            }
                            hVar.yie = true;
                            if (Mo && z) {
                                com.tencent.mm.ui.base.h.d(hVar.yhZ, hVar.getString(R.string.dz8), hVar.getString(R.string.dz9), hVar.getString(R.string.ov), hVar.getString(R.string.r6), new OnClickListener() {
                                    public final void onClick(final DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(29312);
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(29311);
                                                aw.ZK();
                                                if (c.isSDCardAvailable()) {
                                                    Intent intent = new Intent();
                                                    intent.putExtra("had_detected_no_sdcard_space", true);
                                                    d.b(h.this.yhZ, "clean", ".ui.CleanUI", intent);
                                                } else {
                                                    com.tencent.mm.ui.base.t.hO(h.this.yhZ);
                                                }
                                                dialogInterface.dismiss();
                                                com.tencent.mm.plugin.report.service.h.pYm.a(282, 1, 1, false);
                                                AppMethodBeat.o(29311);
                                            }
                                        });
                                        AppMethodBeat.o(29312);
                                    }
                                }, null);
                                com.tencent.mm.plugin.report.service.h.pYm.a(282, 0, 1, false);
                                z2 = true;
                            }
                            z2 = false;
                        }
                        ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space isShowAlert[%b]", Integer.valueOf(hVar.hashCode()), Boolean.valueOf(z2));
                        if (z2) {
                        }
                        if (z2) {
                        }
                        AppMethodBeat.o(29316);
                    }

                    public final String toString() {
                        AppMethodBeat.i(29317);
                        String str = super.toString() + "|doOnResumeCheck";
                        AppMethodBeat.o(29317);
                        return str;
                    }
                }, 500);
            }
            hVar.yib = null;
            com.tencent.mm.sdk.a.b.cE(true);
            boolean dxM = homeUI2.yiN.dxM();
            if (!dxM && aw.RK()) {
                com.tencent.mm.blink.b.HQ().o(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29382);
                        com.tencent.mm.plugin.sight.decode.a.b.WY();
                        AppMethodBeat.o(29382);
                    }
                });
                if (!(com.tencent.mm.bh.d.fUv == null || com.tencent.mm.bh.d.fUu == null || ah.isNullOrNil(com.tencent.mm.bh.d.fUu.akM()))) {
                    ab.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", com.tencent.mm.bh.d.fUv.akN());
                    ez ezVar = new ez();
                    ezVar.cys.username = com.tencent.mm.bh.d.fUv.akN();
                    com.tencent.mm.sdk.b.a.xxA.m(ezVar);
                }
            }
            if (!dxM) {
                j.a(homeUI2.yhZ, 3, homeUI2.yiP.mbt, "directReport_onResume");
                homeUI2.yiP.Nj(v2helper.VOIP_ENC_HEIGHT_LV1);
            }
            com.tencent.mm.ui.widget.h.b(homeUI2.yhZ);
            homeUI2.yhZ.onSwipe(1.0f);
            homeUI2.yiM = a.ACTIVITY_RESUME;
            if (homeUI2.yix) {
                homeUI2.yix = false;
                homeUI2.yix = false;
            }
            n.acp();
            currentTimeMillis = System.currentTimeMillis();
            ab.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
            l.m(homeUI2.yhZ, false);
            l.n(homeUI2.yhZ, false);
            currentTimeMillis2 = System.currentTimeMillis();
            if (homeUI2.yhZ.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.doA(), 0).getBoolean("settings_landscape_mode", false)) {
                homeUI2.yhZ.setRequestedOrientation(-1);
            } else {
                homeUI2.yhZ.setRequestedOrientation(1);
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (getInstance() != null) {
                com.tencent.mm.blink.b.HQ().HT();
                ((p) g.M(p.class)).getSysCmdMsgExtension().a("showprivacypolicy", homeUI2.yjk);
                homeUI2.pH(false);
                com.tencent.mm.sdk.b.a.xxA.c(homeUI2.qjs);
                ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - currentTimeMillis3));
                if (aw.RK()) {
                    homeUI2.dxu();
                }
            }
            ab.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - currentTimeMillis2));
            ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - currentTimeMillis));
            ab.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - anU));
            if (homeUI2.yix) {
                homeUI2.yix = false;
                homeUI2.yix = false;
            }
            com.tencent.mm.app.n Bw = com.tencent.mm.app.n.Bw();
            Bw.ceU = true;
            Bw.ceV.removeMessages(-1999);
            Bw.ceV.removeMessages(-2999);
            ab.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - anU));
            if (r.Zf().booleanValue()) {
                homeUI2.dxi();
            }
            a = g.RP().Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_LOGIN_SHOW_BIND_THIRD_ADD_TYPE_INT, 0);
            if (a != 0) {
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LOGIN_SHOW_BIND_THIRD_ADD_TYPE_INT, Integer.valueOf(0));
                if (!r.Za()) {
                    switch (a) {
                        case 1:
                            com.tencent.mm.ui.base.h.a(homeUI2.yhZ, homeUI2.getString(R.string.co2), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(29383);
                                    HomeUI.this.yhZ.startActivity(new Intent(HomeUI.this.yhZ, FacebookAuthUI.class));
                                    AppMethodBeat.o(29383);
                                }
                            }, null);
                            break;
                    }
                }
            }
            com.tencent.mm.blink.b.HQ().o(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29384);
                    HomeUI.dxv();
                    AppMethodBeat.o(29384);
                }
            });
            if (homeUI2.getMainTabUI().mbt != 3) {
                MoreTabUI moreTabUI = (MoreTabUI) homeUI2.getMainTabUI().Nn(3);
                if (!(moreTabUI.yoh == null || moreTabUI.yoh.isVisible)) {
                    moreTabUI.yoh.dLf();
                    moreTabUI.caE();
                }
            }
            NewChattingTabUI newChattingTabUI = this.chattingTabUI;
            newChattingTabUI.ypf = ah.anT();
            if (newChattingTabUI.cXe()) {
                newChattingTabUI.ypi = new IdleHandler() {
                    @TargetApi(17)
                    public final boolean queueIdle() {
                        boolean z = true;
                        AppMethodBeat.i(29792);
                        try {
                            if (NewChattingTabUI.this.iWA.isFinishing() || NewChattingTabUI.this.iWA.isDestroyed()) {
                                String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                                String str2 = "prepare chattingUI but activity finished isDestroyed[%b]";
                                Object[] objArr = new Object[1];
                                if (!(NewChattingTabUI.this.iWA.isDestroyed() || NewChattingTabUI.this.iWA.isFinishing())) {
                                    z = false;
                                }
                                objArr[0] = Boolean.valueOf(z);
                                ab.i(str, str2, objArr);
                                AppMethodBeat.o(29792);
                                return false;
                            }
                            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic start");
                            long currentTimeMillis = System.currentTimeMillis();
                            if (NewChattingTabUI.this.ypg == null) {
                                NewChattingTabUI.a(NewChattingTabUI.this, new Intent().putExtra("Chat_User", ""), true);
                                NewChattingTabUI.this.ypg.setVisibility(8);
                                NewChattingTabUI.this.ype.dxr();
                                y.d(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
                            }
                            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.o(29792);
                            return false;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.LauncherUI.NewChattingTabUI", e, "", new Object[0]);
                            new Handler().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(29791);
                                    RuntimeException runtimeException = new RuntimeException(e);
                                    AppMethodBeat.o(29791);
                                    throw runtimeException;
                                }
                            });
                        }
                    }
                };
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29793);
                        Looper.myQueue().addIdleHandler(NewChattingTabUI.this.ypi);
                        AppMethodBeat.o(29793);
                    }
                }, 500);
            }
            if (newChattingTabUI.dxM()) {
                newChattingTabUI.kT(3);
                if (newChattingTabUI.ypn != null && newChattingTabUI.ypn.isSupportNavigationSwipeBack()) {
                    newChattingTabUI.ypn.getSwipeBackLayout().setEnableGesture(true);
                }
            } else if (newChattingTabUI.ypq) {
                ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
                al.af(newChattingTabUI.mStartChattingRunnable);
                al.d(newChattingTabUI.mStartChattingRunnable);
                newChattingTabUI.ypq = false;
            }
            ab.i("MicroMsg.LauncherUI", "resumeNormalJump");
            com.tencent.mm.ui.MMFragmentActivity.a.dyv();
            if ("pushcontent_notification".equals(w.n(getIntent(), "nofification_type")) && !bo.isNullOrNil(w.n(getIntent(), "Main_FromUserName"))) {
                ab.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + w.n(getIntent(), "Main_FromUserName") + w.a(getIntent(), "MainUI_User_Last_Msg_Type", 0));
                com.tencent.mm.plugin.report.service.h.pYm.e(10856, Integer.valueOf(r1), r0, Integer.valueOf(0));
            }
            String n2 = w.n(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (n2 != null) {
                if (n2.equals("launch_type_voip")) {
                    ab.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
                    com.tencent.mm.plugin.report.service.h.pYm.e(11034, Integer.valueOf(2), Integer.valueOf(0));
                } else if (n2.equals("launch_type_voip_audio")) {
                    ab.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
                    com.tencent.mm.plugin.report.service.h.pYm.e(11034, Integer.valueOf(2), Integer.valueOf(1));
                }
            }
            n2 = w.n(getIntent(), "LauncherUI.switch.tab");
            if (!bo.isNullOrNil(n2)) {
                this.yjJ.getMainTabUI().aqG(n2);
                getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if (w.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false) || this.yjN) {
                this.yjN = false;
                instance = getInstance();
                if (instance != null) {
                    instance.yjJ.dxo();
                }
                getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
                getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            boolean a2 = w.a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (a2) {
                n = w.n(getIntent(), "LauncherUI.Shortcut.Username");
            } else {
                a2 = w.a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
                n = getIntent().getAction();
            }
            if (a2) {
                ab.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(n)));
                if (!bo.isNullOrNil(n)) {
                    String Fs = com.tencent.mm.plugin.base.model.b.Fs(n);
                    if (!bo.isNullOrNil(Fs)) {
                        if (com.tencent.mm.model.t.mY(Fs)) {
                            ab.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                            Intent intent;
                            if (!com.tencent.mm.aj.f.ra(Fs)) {
                                instance = getInstance();
                                if (instance != null) {
                                    instance.startChatting(Fs, null, false);
                                }
                            } else if (com.tencent.mm.aj.f.kq(Fs)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                                intent.putExtra("Contact_User", Fs);
                                intent.putExtra("biz_chat_from_scene", 9);
                                intent.addFlags(67108864);
                                startActivity(intent);
                            } else if (com.tencent.mm.aj.f.rc(Fs)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
                                intent.putExtra("enterprise_biz_name", Fs);
                                intent.putExtra("enterprise_biz_display_name", s.mJ(Fs));
                                startActivity(intent);
                            } else if (com.tencent.mm.aj.f.rd(Fs)) {
                                com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(Fs);
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
                                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                            } else {
                                instance = getInstance();
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
        com.tencent.mm.blink.a.ig(5);
        if (!yjI) {
            pM(false);
        }
        dxG();
        com.tencent.mm.blink.a.jD("LauncherUI");
        AppMethodBeat.o(29456);
    }

    private boolean dxH() {
        AppMethodBeat.i(29457);
        if (this.cEp == null || w.a(this.cEp, "Intro_Switch", false) || !aw.ZM() || aw.QT()) {
            AppMethodBeat.o(29457);
            return false;
        }
        AppMethodBeat.o(29457);
        return true;
    }

    private boolean dxI() {
        AppMethodBeat.i(29458);
        if (this.cEp != null) {
            if (w.a(this.cEp, "absolutely_exit", false) || w.a(this.cEp, "absolutely_exit_pid", 0) == Process.myPid()) {
                ab.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", Integer.valueOf(hashCode()));
                finish();
                com.tencent.mm.plugin.report.service.g.BP(8);
                MMAppMgr.pQ(w.a(this.cEp, "kill_service", true));
                System.exit(0);
                AppMethodBeat.o(29458);
                return true;
            } else if (w.a(this.cEp, "can_finish", false)) {
                ab.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
                aw.Rg().cD(true);
                if (l.bL(getApplicationContext())) {
                    com.tencent.mm.booter.b.bm(getApplicationContext());
                }
                com.tencent.mm.plugin.report.service.g.BP(8);
                sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), WXApp.WXAPP_BROADCAST_PERMISSION);
                finish();
                com.tencent.mm.ui.base.b.hM(this);
                AppMethodBeat.o(29458);
                return true;
            } else if (w.a(this.cEp, "exit_and_restart", false)) {
                com.tencent.mrs.a.onDestroy();
                BaseEvent.onSingalCrash(0);
                ab.i("MicroMsg.LauncherUI", "exit and restart myself.");
                ab.dot();
                finish();
                Intent intent = new Intent(this, LauncherUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                ab.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", Integer.valueOf(Process.myPid()));
                MMAppMgr.dys();
                Process.killProcess(Process.myPid());
                AppMethodBeat.o(29458);
                return true;
            }
        }
        AppMethodBeat.o(29458);
        return false;
    }

    private void dMv() {
        AppMethodBeat.i(139025);
        getWindow().getDecorView().setSystemUiVisibility(com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (this.yjO == null) {
            this.yjO = new WelcomeSelectView(this);
        }
        setContentView((View) this.yjO);
        AppMethodBeat.o(139025);
    }

    private void dxJ() {
        AppMethodBeat.i(138622);
        Intent intent = new Intent();
        String T = av.fly.T("login_weixin_username", "");
        intent.putParcelableArrayListExtra("key_switch_account_users", this.cEp.getParcelableArrayListExtra("key_switch_account_users"));
        intent.putExtra("key_switch_from_wx_username", T);
        T = aa.g(getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.doA(), 0));
        float dm = com.tencent.mm.bz.a.dm(this);
        intent.putExtra("key_langauage_code", T);
        intent.putExtra("key_font_scale_size", dm);
        ab.i("MicroMsg.LauncherUI", "mm pid %d", Integer.valueOf(Process.myPid()));
        intent.putExtra("key_mm_process_pid", Process.myPid());
        intent.setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI");
        startActivity(intent);
        com.tencent.mm.ui.base.b.hN(this);
        AppMethodBeat.o(138622);
    }

    private void dxK() {
        AppMethodBeat.i(29459);
        SharedPreferences sharedPreferences = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("switch_account_preferences", 0);
        String string = sharedPreferences.getString("last_switch_account_to_wx_username", "");
        ab.i("MicroMsg.LauncherUI", "switch to wxid %s", string);
        sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
        Intent intent = new Intent();
        intent.setClass(this, SettingsSwitchAccountUI.class);
        intent.addFlags(536870912);
        intent.putExtra("key_scene", 1);
        startActivity(intent);
        com.tencent.mm.ui.base.b.hN(this);
        AppMethodBeat.o(29459);
    }

    private void aQ(Intent intent) {
        AppMethodBeat.i(29460);
        ab.i("MicroMsg.LauncherUI", "handleJump");
        if (aw.RK()) {
            jd jdVar = new jd();
            jdVar.cEo.cEp = this.cEp;
            com.tencent.mm.sdk.b.a.xxA.m(jdVar);
            String n;
            Intent className;
            if ("talkroom_notification".equals(w.n(intent, "nofification_type"))) {
                n = w.n(intent, "enter_chat_usrname");
                if (!bo.isNullOrNil(n)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("enter_room_username", n);
                    intent2.setFlags(268435456);
                    com.tencent.mm.bp.d.b((Context) this, "talkroom", ".ui.TalkRoomUI", intent2);
                }
                AppMethodBeat.o(29460);
                return;
            } else if ("back_to_pcmgr_notification".equals(intent.getStringExtra("nofification_type"))) {
                if (intent.getBooleanExtra("newPCBackup", true)) {
                    ab.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
                    className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
                } else {
                    ab.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
                    className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");
                }
                className.setFlags(268435456);
                MMWizardActivity.J(this, className);
                AppMethodBeat.o(29460);
                return;
            } else if ("back_to_pcmgr_error_notification".equals(intent.getStringExtra("nofification_type"))) {
                className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
                className.setFlags(268435456);
                MMWizardActivity.J(this, className);
                AppMethodBeat.o(29460);
                return;
            } else if ("backup_move_notification".equals(intent.getStringExtra("nofification_type"))) {
                className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
                className.setFlags(268435456);
                MMWizardActivity.J(this, className);
                AppMethodBeat.o(29460);
                return;
            } else {
                int i;
                if (w.a(intent, "show_update_dialog", false)) {
                    aR(intent);
                }
                String n2 = w.n(intent, "Main_User");
                String n3 = w.n(intent, "nofification_type");
                ab.i("MicroMsg.LauncherUI", "[handleJump] user:%s", n2);
                if (n2 == null || n2.equals("")) {
                    i = 0;
                } else {
                    aw.ZK();
                    com.tencent.mm.storage.ak aoZ = com.tencent.mm.model.c.XR().aoZ(n2);
                    if (aoZ != null) {
                        i = aoZ.field_unReadCount;
                    } else {
                        i = 0;
                    }
                    ab.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", n2, aoZ, Integer.valueOf(i));
                }
                if (i == 0) {
                    i = w.a(intent, "pushcontent_unread_count", 0);
                }
                MMAppMgr.BV();
                com.tencent.mm.sdk.b.a.xxA.m(new com.tencent.mm.g.a.ac());
                boolean a = w.a(intent, "Intro_Is_Muti_Talker", true);
                ab.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", Boolean.valueOf(a), Integer.valueOf(i));
                if (!a && i > 0 && w.a(intent, "Intro_Bottle_unread_count", 0) > 0) {
                    ab.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", Integer.valueOf(w.a(intent, "Intro_Bottle_unread_count", 0)));
                    com.tencent.mm.bp.d.H(this, "bottle", ".ui.BottleConversationUI");
                }
                LauncherUI instance;
                if (a) {
                    if (w.a(intent, "From_fail_notify", false)) {
                        if (!bo.isNullOrNil(n2)) {
                            instance = getInstance();
                            if (instance != null) {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("Chat_Mode", w.a(intent, "resend_fail_messages", false));
                                if (com.tencent.mm.aj.f.kq(n2)) {
                                    intent.putExtra("Contact_User", n2);
                                    intent.addFlags(67108864);
                                    intent.putExtra("biz_chat_from_scene", 4);
                                    com.tencent.mm.bp.d.f(this, ".ui.bizchat.BizChatConversationUI", intent);
                                } else {
                                    instance.startChatting(n2, bundle, false);
                                }
                            }
                        } else if (w.a(intent, "jump_sns_from_notify", false)) {
                            className = new Intent();
                            className.addFlags(67108864);
                            className.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                            className.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                            className.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                            com.tencent.mm.bp.d.b((Context) this, "sns", ".ui.SnsTimeLineUI", className);
                        }
                    } else if (w.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                        if (getInstance() != null && com.tencent.mm.aj.f.kq(n2)) {
                            intent.putExtra("Contact_User", n2);
                            intent.addFlags(67108864);
                            com.tencent.mm.bp.d.f(this, ".ui.bizchat.BizChatConversationUI", intent);
                        }
                    } else if (!bo.isNullOrNil(n2) && "new_msg_nofification".equals(n3)) {
                        n3 = "MicroMsg.LauncherUI";
                        String str = "[handleJump] intent:%s";
                        Object[] objArr = new Object[1];
                        if (intent == null) {
                            n = BuildConfig.COMMAND;
                        } else {
                            Object obj = intent;
                        }
                        objArr[0] = n;
                        ab.w(n3, str, objArr);
                        instance = getInstance();
                        if (instance != null) {
                            instance.startChatting(n2, new Bundle(), false);
                        } else {
                            ab.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
                        }
                    }
                } else if (com.tencent.mm.model.t.np(n2)) {
                    ab.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
                    className = new Intent();
                    className.addFlags(67108864);
                    className.putExtra("type", 20);
                    com.tencent.mm.bp.d.b((Context) this, "readerapp", ".ui.ReaderAppUI", className);
                } else if (com.tencent.mm.model.t.nx(n2)) {
                    ab.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
                    className = new Intent();
                    className.addFlags(67108864);
                    className.putExtra("type", 11);
                    com.tencent.mm.bp.d.b((Context) this, "readerapp", ".ui.ReaderAppUI", className);
                } else {
                    if (intent.getIntExtra("MainUI_User_Last_Msg_Type", 34) == 34) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("Chat_Mode", i);
                    if ("new_msg_nofification".equals(w.n(intent, "nofification_type"))) {
                        bundle2.putInt("chat_from_scene", 1);
                    }
                    instance = getInstance();
                    if (instance != null) {
                        if (com.tencent.mm.aj.f.kq(n2)) {
                            intent.putExtra("Contact_User", n2);
                            intent.addFlags(67108864);
                            intent.putExtra("biz_chat_from_scene", 4);
                            com.tencent.mm.bp.d.f(this, ".ui.bizchat.BizChatConversationUI", intent);
                        } else if (com.tencent.mm.aj.f.rd(n2)) {
                            com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(n2);
                            n = qX == null ? null : qX.adT();
                            if (n == null) {
                                n = "";
                            }
                            intent.putExtra("rawUrl", n);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", n2);
                            intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent.addFlags(67108864);
                            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (ad.mg(n2)) {
                            intent.putExtra("Contact_User", n2);
                            intent.addFlags(67108864);
                            intent.putExtra("app_brand_conversation_from_scene", 3);
                            intent.putExtra("finish_direct", true);
                            intent.putExtra("key_need_send_video", false);
                            com.tencent.mm.bp.d.f(this, ".ui.conversation.AppBrandServiceConversationUI", intent);
                        } else {
                            instance.startChatting(n2, bundle2, false);
                        }
                    }
                }
                if (w.a(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                    className = new Intent();
                    className.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
                    className.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                    className.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                    MMWizardActivity.J(this, className);
                }
                AppMethodBeat.o(29460);
                return;
            }
        }
        ab.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
        startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
        finish();
        AppMethodBeat.o(29460);
    }

    private void dxL() {
        AppMethodBeat.i(29461);
        ab.i("MicroMsg.LauncherUI", "resumeLogoutJump");
        com.tencent.mm.ui.MMFragmentActivity.a.dyv();
        String T = av.fly.T("login_user_name", "");
        if (aw.ZM() || !T.equals("")) {
            com.tencent.mm.plugin.report.service.g.BP(8);
            g.RO().Rf();
            ab.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", Boolean.valueOf(this.yjL), Boolean.valueOf((this.cEp.getFlags() & 67108864) == 67108864), Boolean.valueOf(w.a(this.cEp, "Intro_Notify", false)), Boolean.valueOf(aw.QT()));
            ab.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", Boolean.valueOf(aw.ZM()));
            this.yjJ.getMainTabUI().dyy();
            if (w.a(this.cEp, "key_transit_to_switch_account", false)) {
                ab.i("MicroMsg.LauncherUI", "transit to fake switch account");
                this.cEp.removeExtra("key_transit_to_switch_account");
                SharedPreferences sharedPreferences = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("switch_account_preferences", 0);
                sharedPreferences.getString("last_switch_account_to_wx_username", "");
                sharedPreferences.edit().putBoolean("transit_to_switch_account", true).commit();
                dMv();
                dxJ();
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29446);
                        aw.hold();
                        com.tencent.mm.sdk.b.a.xxA.m(new x());
                        if (w.a(LauncherUI.this.getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                            LauncherUI.this.yjN = true;
                        }
                        g.RQ().lL("switch account ,delay logout");
                        LauncherUI.a(LauncherUI.this, LauncherUI.this);
                        aw.unhold();
                        AppMethodBeat.o(29446);
                    }
                }, 500);
                AppMethodBeat.o(29461);
                return;
            }
            aw.hold();
            com.tencent.mm.sdk.b.a.xxA.m(new x());
            if (w.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                this.yjN = true;
            }
            g.RQ().lL("[" + this.yjL + " " + r0 + " " + r3 + "]");
            hn(this);
            aw.unhold();
            AppMethodBeat.o(29461);
            return;
        }
        startActivity(new Intent(this, WelcomeActivity.class));
        com.tencent.mm.ui.base.b.hN(this);
        ab.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
        al.af(this.yjU);
        al.n(this.yjU, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(29461);
    }

    private void hn(Context context) {
        AppMethodBeat.i(29462);
        Intent intent;
        if (w.a(this.cEp, "LauncherUI.jump_switch_account", false)) {
            ab.i("MicroMsg.LauncherUI", "launcher to switch account");
            dxK();
            this.cEp.removeExtra("LauncherUI.jump_switch_account");
            AppMethodBeat.o(29462);
        } else if (w.a(this.cEp, "Intro_Switch", false) || this.yjL || com.tencent.mm.kernel.a.QI()) {
            com.tencent.mrs.a.onDestroy();
            BaseEvent.onSingalCrash(0);
            ab.i("MicroMsg.LauncherUI", "switch users count %d", Integer.valueOf(bx.fnB.aat().size()));
            ab.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
            ab.dot();
            finish();
            if (!com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false)) {
                intent = new Intent(context, LauncherUI.class);
                intent.addFlags(67108864);
                context.startActivity(intent);
            }
            ab.i("MicroMsg.LauncherUI", "try to kill mm pid %d", Integer.valueOf(Process.myPid()));
            MMAppMgr.dys();
            Process.killProcess(Process.myPid());
            AppMethodBeat.o(29462);
        } else {
            if (!w.a(this.cEp, "LauncherUI.jump_switch_account", false)) {
                ab.i("MicroMsg.LauncherUI", "jumpToLogin %s", av.fly.T("login_user_name", ""));
                if (bo.isNullOrNil(av.fly.T("login_user_name", ""))) {
                    startActivity(new Intent(this, WelcomeActivity.class));
                    com.tencent.mm.ui.base.b.hN(this);
                } else {
                    ab.i("MicroMsg.LauncherUI", "switchAccount %s", Boolean.valueOf(com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false)));
                    if (com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false)) {
                        intent = new Intent(this, SettingsSwitchAccountUI.class);
                        intent.addFlags(67108864);
                        intent.putExtra("key_scene", 2);
                        startActivity(intent);
                    } else {
                        int ank = bo.ank(av.fly.T("last_login_use_voice", ""));
                        ab.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(ank)));
                        if ((ank & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                            startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI"));
                        } else {
                            startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI"));
                        }
                    }
                    com.tencent.mm.ui.base.b.hK(this);
                }
                com.tencent.mm.plugin.report.service.g.BP(8);
                al.af(this.yjU);
                al.n(this.yjU, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            }
            AppMethodBeat.o(29462);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        Bundle bundle = null;
        AppMethodBeat.i(29463);
        super.onActivityResult(i, i2, intent);
        ab.v("MicroMsg.LauncherUI", "edw on activity result");
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if ((i == 2001 || i == 30763 || i == 30762 || i == FaceManager.FACE_ACQUIRED_HACKER) && newChattingTabUI.ypn != null) {
            newChattingTabUI.ypn.onActivityResult(i, i2, intent);
        }
        if (NewChattingTabUI.acceptRequestCode(i) && newChattingTabUI.ypn == null) {
            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
            al.af(newChattingTabUI.ypp);
            newChattingTabUI.ypp.ypy = 0;
            newChattingTabUI.ypp.requestCode = i;
            newChattingTabUI.ypp.bFZ = i2;
            newChattingTabUI.ypp.cEd = intent;
            al.d(newChattingTabUI.ypp);
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            AppMethodBeat.o(29463);
            return;
        }
        HomeUI homeUI = this.yjJ;
        if (homeUI.yiv) {
            if (i == 1) {
                aw.ZK();
                if (!ah.e((Boolean) com.tencent.mm.model.c.Ry().get(12323, null))) {
                    z.showAddrBookUploadConfirm(homeUI.yhZ, null, false, 3);
                }
                AppMethodBeat.o(29463);
                return;
            }
            String str;
            if (i == 22722) {
                str = (String) g.RP().Ry().get(274436, null);
                ab.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                    ab.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
                    g.Rg().a(new com.tencent.mm.plugin.account.model.e(2, str), 0);
                    com.tencent.mm.plugin.report.service.h.pYm.a(712, 5, 1, false);
                } else {
                    ab.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
                    com.tencent.mm.plugin.report.service.h.pYm.a(712, 4, 1, false);
                    g.Rg().a(new com.tencent.mm.plugin.account.model.e(1, str), 0);
                    if (com.tencent.mm.au.b.sO(str) && g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_NEED_BIRTHDAY_BOOLEAN_SYNC, false)) {
                        ab.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29368);
                                String string = HomeUI.this.yhZ.getString(R.string.g7l, new Object[]{aa.dor()});
                                if (g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_NEED_CONFIRM_BOOLEAN_SYNC, false)) {
                                    HomeUI.a(HomeUI.this, string, 22723, HomeUI.this.yhZ.getString(R.string.g7n, new Object[]{aa.dor()}));
                                } else {
                                    ab.i("MicroMsg.LauncherUI.HomeUI", "needconfirm false");
                                    Bundle bundle = new Bundle();
                                    bundle.putString("close_dialog_msg", HomeUI.this.yiA);
                                    bundle.putString("close_dialog_cancel", HomeUI.this.yiC);
                                    bundle.putString("close_dialog_ok", HomeUI.this.yiB);
                                    bundle.putBoolean("close_dialog_ok_close", false);
                                    HomeUI.a(HomeUI.this, string, 22723, bundle);
                                }
                                com.tencent.mm.ui.base.b.hN(HomeUI.this.yhZ);
                                AppMethodBeat.o(29368);
                            }
                        }, 100);
                    }
                }
            } else if (i == 22723) {
                str = (String) g.RP().Ry().get(274436, null);
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle != null) {
                    if (bundle.getString("go_next", "").equals("birthdayComfirmOK")) {
                        ab.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_NEED_BIRTHDAY_BOOLEAN_SYNC, Boolean.FALSE);
                    } else if (bundle.getString("go_next", "").equals("gdpr_confirm_logout")) {
                        ab.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
                        g.Rg().a(new com.tencent.mm.plugin.account.model.e(2, str), 0);
                        com.tencent.mm.plugin.report.service.h.pYm.a(712, 5, 1, false);
                    }
                }
            }
            if (i == BitUtils.BIT_TURN_ZERO_1 && i2 == -1) {
                aj.amB("welcome_page_show");
                l.m(homeUI.yhZ, true);
                MMAppMgr.BV();
                MMAppMgr.bd(homeUI.yhZ);
                homeUI.yhZ.finish();
                AppMethodBeat.o(29463);
                return;
            } else if (i == 30764 && intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                    com.tencent.mm.pluginsdk.permission.b.b(homeUI.yhZ, "android.permission.ACCESS_COARSE_LOCATION", 66);
                }
            }
        }
        AppMethodBeat.o(29463);
    }

    public void onPause() {
        AppMethodBeat.i(29464);
        ab.d("MicroMsg.LauncherUI", "onPause, chatting is show ");
        super.onPause();
        u uVar = this.yjP;
        boolean cM = uVar.cM("onPause");
        if (cM) {
            uVar.vaA = false;
        }
        if (cM) {
            ab.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
            AppMethodBeat.o(29464);
            return;
        }
        com.tencent.mm.blink.a.HL();
        ab.i("MicroMsg.LauncherUI", "not skip this onPause");
        MMFragment currentFragmet = getCurrentFragmet();
        this.yjT.removeCallbacksAndMessages(null);
        HomeUI homeUI = this.yjJ;
        MainTabUI mainTabUI = homeUI.yiP;
        ab.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", Integer.valueOf(mainTabUI.mbt), Boolean.valueOf(homeUI.yiv));
        if (homeUI.yiv) {
            mainTabUI.dyA();
        }
        w wVar = mainTabUI.ynE;
        if (aw.RK()) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().b(wVar.ynY);
            aw.ZK();
            com.tencent.mm.model.c.XR().b(wVar);
            com.tencent.mm.x.c.PK().b(wVar.ynX);
            com.tencent.mm.sdk.b.a.xxA.d(wVar.ynZ);
            com.tencent.mm.sdk.b.a.xxA.d(wVar.yhr);
            com.tencent.mm.sdk.b.a.xxA.d(wVar.yhq);
        }
        if (wVar.ynW != null) {
            wVar.ynW.ynT = null;
            wVar.ynW = null;
        }
        h hVar = homeUI.yiO;
        if (hVar.yic != null) {
            aw.Rg().b(255, hVar.yic);
            aw.Rg().b(384, hVar.yic);
            hVar.yic = null;
        }
        com.tencent.mm.sdk.a.b.cE(false);
        homeUI.yiM = a.ACTIVITY_PAUSE;
        if (!aw.ZD()) {
            aw.getNotification().bv(false);
        }
        boolean dxM = homeUI.yiN.dxM();
        ab.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(dxM)));
        if (!dxM) {
            j.a(homeUI.yhZ, 4, homeUI.yiP.mbt, "directReport_onPause");
        }
        if (!homeUI.yhZ.isFinishing()) {
            com.tencent.mm.ui.widget.h.a(homeUI.yhZ);
        }
        if (homeUI.yiv) {
            ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
            com.tencent.mm.blink.b.HQ().HS();
            if (aw.RK()) {
                com.tencent.mm.sdk.b.a.xxA.d(homeUI.qjs);
            }
        }
        if (homeUI.yiD != null && homeUI.yiD.isShowing()) {
            homeUI.yiD.dismiss();
        }
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (newChattingTabUI.dxM()) {
            newChattingTabUI.kT(4);
            if (newChattingTabUI.ypn != null && newChattingTabUI.ypn.isSupportNavigationSwipeBack()) {
                newChattingTabUI.ypn.getSwipeBackLayout().setEnableGesture(false);
            }
        }
        if (currentFragmet != null) {
            AppMethodBeat.o(29464);
            return;
        }
        this.yjM = false;
        AppMethodBeat.o(29464);
    }

    public void onStop() {
        AppMethodBeat.i(29465);
        ab.i("MicroMsg.LauncherUI", "onStop");
        com.tencent.mm.blink.a.HL();
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("showprivacypolicy", this.yjJ.yjk);
        super.onStop();
        AppMethodBeat.o(29465);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(29466);
        this.yjS = false;
        if (!this.yjK.a(this, i, strArr, iArr)) {
            HomeUI homeUI = this.yjJ;
            switch (i) {
                case 16:
                case 80:
                    int i2 = i == 80 ? R.string.dc0 : R.string.dbs;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.yhZ, homeUI.getString(i2), homeUI.getString(R.string.dc8), homeUI.getString(R.string.ckr), homeUI.getString(R.string.abx), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29371);
                                dialogInterface.dismiss();
                                HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                AppMethodBeat.o(29371);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29372);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(29372);
                            }
                        });
                        break;
                    }
                    break;
                case 24:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.yhZ, homeUI.getString("android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0), homeUI.getString(R.string.dc8), homeUI.getString(R.string.ckr), homeUI.getString(R.string.or), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29375);
                                dialogInterface.dismiss();
                                HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                AppMethodBeat.o(29375);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29376);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(29376);
                            }
                        });
                        break;
                    } else {
                        homeUI.dxm();
                        break;
                    }
                case 65:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.yhZ, homeUI.getString(R.string.dby), homeUI.getString(R.string.dc8), homeUI.getString(R.string.ckr), homeUI.getString(R.string.abx), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29373);
                                HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                AppMethodBeat.o(29373);
                            }
                        }, null);
                        break;
                    } else {
                        homeUI.dxl();
                        break;
                    }
                case 66:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.yhZ, homeUI.getString(R.string.dby), homeUI.getString(R.string.dc8), homeUI.getString(R.string.ckr), homeUI.getString(R.string.abx), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29374);
                                HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                AppMethodBeat.o(29374);
                            }
                        }, null);
                        break;
                    }
                    MMFragment dyx = homeUI.yiP.dyx();
                    if (dyx instanceof FindMoreFriendsUI) {
                        ((FindMoreFriendsUI) dyx).dwU();
                        break;
                    }
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.d.h.a.CTRL_INDEX /*78*/:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.yhZ, homeUI.getString(R.string.dby), homeUI.getString(R.string.dc8), homeUI.getString(R.string.ckr), homeUI.getString(R.string.abx), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29377);
                                HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                AppMethodBeat.o(29377);
                            }
                        }, null);
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
        AppMethodBeat.o(29466);
    }

    public void onDestroy() {
        AppMethodBeat.i(29467);
        com.tencent.mm.blink.a.HL();
        super.onDestroy();
        HomeUI homeUI = this.yjJ;
        homeUI.yiP.dyy();
        if (homeUI.yiO != null) {
            h hVar = homeUI.yiO;
            com.tencent.mm.sdk.b.a.xxA.d(hVar.yif);
            com.tencent.mm.sdk.b.a.xxA.d(hVar.yig);
        }
        if (homeUI.yiv) {
            Looper.myQueue().removeIdleHandler(homeUI.jQs);
        }
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (!(newChattingTabUI.mPrepareBitmap == null || newChattingTabUI.mPrepareBitmap.isRecycled())) {
            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", newChattingTabUI.mPrepareBitmap.toString());
            newChattingTabUI.mPrepareBitmap.recycle();
        }
        al.af(newChattingTabUI.mStartChattingRunnable);
        Looper.myQueue().removeIdleHandler(newChattingTabUI.ypi);
        dxF();
        ab.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bo.gU(this), Integer.valueOf(yjE.size()));
        AppMethodBeat.o(29467);
    }

    private void aR(Intent intent) {
        AppMethodBeat.i(29468);
        int a = w.a(intent, "update_type", -1);
        if (a == -1) {
            ab.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
            AppMethodBeat.o(29468);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(405, 28, 1, true);
        if (com.tencent.mm.plugin.p.d.bQU() != null) {
            com.tencent.mm.plugin.p.a c = com.tencent.mm.plugin.p.d.bQU().c(this, null);
            if (c == null) {
                AppMethodBeat.o(29468);
                return;
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(405, a == 2 ? 29 : 30, 1, true);
                c.update(a);
            }
        }
        AppMethodBeat.o(29468);
    }

    public void finish() {
        AppMethodBeat.i(29469);
        super.finish();
        dxF();
        ab.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", Integer.valueOf(hashCode()), Integer.valueOf(yjE.size()), bo.dpG());
        AppMethodBeat.o(29469);
    }

    public void onSwipe(float f) {
        AppMethodBeat.i(29470);
        if (this.yjL && !this.chattingTabUI.bo(f)) {
            super.onSwipe(f);
        }
        AppMethodBeat.o(29470);
    }

    public void onSettle(boolean z, int i) {
        AppMethodBeat.i(29471);
        if (this.yjL && !this.chattingTabUI.G(z, i)) {
            super.onSettle(z, i);
        }
        AppMethodBeat.o(29471);
    }

    public boolean forceRemoveNoMatchOnPath() {
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int i;
        AppMethodBeat.i(29472);
        if (this.chattingTabUI.dxM()) {
            NewChattingTabUI newChattingTabUI = this.chattingTabUI;
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                al.af(newChattingTabUI.mStartChattingRunnable);
            }
            if (newChattingTabUI.isAnimating) {
                z = true;
            } else {
                z = newChattingTabUI.ypn.onKeyDown(keyEvent.getKeyCode(), keyEvent);
            }
            if (z) {
                AppMethodBeat.o(29472);
                return true;
            }
        }
        HomeUI homeUI = this.yjJ;
        ab.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        com.tencent.mm.compatible.b.g.KO();
        com.tencent.mm.compatible.b.g.KO();
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
                    if (aw.RK() && g.RN().eJb && at.isWap(homeUI.yhZ) && MMAppMgr.c(homeUI.yhZ, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(29364);
                            HomeUI.x(HomeUI.this);
                            AppMethodBeat.o(29364);
                        }
                    })) {
                        i = 1;
                    } else {
                        int backgroundLimitType = at.getBackgroundLimitType(homeUI.yhZ);
                        if (aw.RK() && g.RN().eJb && at.isLimited(backgroundLimitType)) {
                            aw.ZK();
                            if (ah.d((Boolean) com.tencent.mm.model.c.Ry().get(16385, null)) && MMAppMgr.a(homeUI.yhZ, backgroundLimitType, new AnonymousClass19(backgroundLimitType), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(29366);
                                    HomeUI.x(HomeUI.this);
                                    AppMethodBeat.o(29366);
                                }
                            })) {
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
            AppMethodBeat.o(29472);
            return true;
        }
        try {
            z = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(29472);
            return z;
        } catch (Exception e) {
            ab.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.LauncherUI", e, "", new Object[0]);
            AppMethodBeat.o(29472);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(29473);
        super.onRestoreInstanceState(bundle);
        this.chattingTabUI.ypk = bundle.getString("last_restore_talker");
        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", r0.ypk);
        AppMethodBeat.o(29473);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(29474);
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (newChattingTabUI.ypn != null) {
            String talkerUserName = newChattingTabUI.ypn.cgL.getTalkerUserName();
            if (!ah.isNullOrNil(talkerUserName)) {
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", talkerUserName);
                bundle.putString("last_restore_talker", talkerUserName);
            }
        }
        AppMethodBeat.o(29474);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = false;
        AppMethodBeat.i(29475);
        HomeUI homeUI = this.yjJ;
        MMFragment currentFragmet = homeUI.yhZ.getCurrentFragmet();
        if ((currentFragmet == null || !currentFragmet.isShowing()) && !homeUI.yiN.dxM()) {
            if (menuItem.getItemId() == 2) {
                com.tencent.mm.plugin.report.service.h.pYm.X(10919, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                homeUI.dxj();
            } else if (menuItem.getItemId() == 1) {
                homeUI.dxl();
            } else if (menuItem.getItemId() == 5) {
                if (com.tencent.mm.sdk.a.b.dnO() || ae.gjs) {
                    j jVar = new j(homeUI.yhZ);
                    jVar.rBl = new com.tencent.mm.ui.base.n.c() {
                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            AppMethodBeat.i(29352);
                            lVar.e(1, "拍摄状态");
                            lVar.e(2, "属性配置");
                            AppMethodBeat.o(29352);
                        }
                    };
                    jVar.rBm = new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(29353);
                            switch (menuItem.getItemId()) {
                                case 1:
                                    HomeUI.l(HomeUI.this);
                                    AppMethodBeat.o(29353);
                                    return;
                                case 2:
                                    HomeUI.k(HomeUI.this);
                                    break;
                            }
                            AppMethodBeat.o(29353);
                        }
                    };
                    jVar.cuu();
                } else {
                    homeUI.dxm();
                }
            }
            z = true;
        }
        if (z) {
            AppMethodBeat.o(29475);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(29475);
        return onOptionsItemSelected;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(29476);
        if (this.chattingTabUI.dxM()) {
            AppMethodBeat.o(29476);
            return false;
        }
        HomeUI homeUI = this.yjJ;
        if (homeUI.yiN == null || homeUI.yiN.dxM()) {
            AppMethodBeat.o(29476);
            return false;
        }
        homeUI.yjf = menu;
        int height = homeUI.yhZ.getSupportActionBar().getHeight();
        int am = com.tencent.mm.bz.a.am(homeUI.yhZ, R.dimen.gd);
        if (homeUI.yiP.mbt == 3 && com.tencent.mm.plugin.story.api.n.isShowStoryCheck()) {
            homeUI.yje = menu.add(0, 5, 0, R.string.ewp);
            if (homeUI.yja == null) {
                homeUI.yja = com.tencent.mm.kiss.a.b.SM().a(homeUI.yhZ, "R.layout.actionbar_menu", (int) R.layout.ab);
                homeUI.yja.setLayoutParams(new ViewGroup.LayoutParams(am, height));
                homeUI.yja.setBackgroundResource(R.drawable.al);
                homeUI.yja.setMinimumHeight(height);
                homeUI.yja.setMinimumWidth(am);
                homeUI.yja.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(29343);
                        if (com.tencent.mm.sdk.a.b.dnO() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE) {
                            HomeUI.k(HomeUI.this);
                        }
                        AppMethodBeat.o(29343);
                        return false;
                    }
                });
                homeUI.yja.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(29344);
                        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.cAJ().cZX = System.currentTimeMillis();
                        HomeUI.l(HomeUI.this);
                        AppMethodBeat.o(29344);
                    }
                });
            }
            com.tencent.mm.plugin.story.g.h hVar;
            if (homeUI.yiT) {
                homeUI.yja.findViewById(R.id.kv).setVisibility(0);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.lo(1);
            } else {
                homeUI.yja.findViewById(R.id.kv).setVisibility(8);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.lo(0);
            }
            homeUI.yje.setActionView(homeUI.yja);
            homeUI.dxu();
            homeUI.dxk();
        } else {
            int dimensionPixelSize;
            if (height == 0) {
                DisplayMetrics displayMetrics = homeUI.yhZ.getResources().getDisplayMetrics();
                dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? homeUI.yhZ.getResources().getDimensionPixelSize(R.dimen.fc) : homeUI.yhZ.getResources().getDimensionPixelSize(R.dimen.fd);
            } else {
                dimensionPixelSize = height;
            }
            homeUI.yjb = menu.add(0, 1, 0, R.string.ewn);
            homeUI.yjb.setIcon(R.raw.actionbar_icon_dark_search);
            if (homeUI.qlP) {
                homeUI.yjb.setIcon(R.raw.actionbar_icon_light_search);
            }
            if (homeUI.yfm == null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(am, dimensionPixelSize);
                homeUI.yfm = com.tencent.mm.kiss.a.b.SM().a(homeUI.yhZ, "R.layout.actionview_with_dot_tips", (int) R.layout.ai);
                homeUI.yiZ = (ImageView) homeUI.yfm.findViewById(R.id.jb);
                homeUI.yfm.setLayoutParams(layoutParams);
                homeUI.yfm.setBackgroundResource(R.drawable.al);
                homeUI.yfm.setMinimumHeight(dimensionPixelSize);
                homeUI.yfm.setMinimumWidth(am);
                homeUI.yiZ.setImageResource(R.raw.actionbar_icon_dark_search);
                homeUI.yfm.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(29345);
                        HomeUI.m(HomeUI.this);
                        AppMethodBeat.o(29345);
                    }
                });
                homeUI.yfm.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29346);
                        HomeUI.this.yhZ.supportInvalidateOptionsMenu();
                        AppMethodBeat.o(29346);
                    }

                    public final String toString() {
                        AppMethodBeat.i(29347);
                        String str = super.toString() + "|supportInvalidateOptionsMenu";
                        AppMethodBeat.o(29347);
                        return str;
                    }
                });
            }
            android.support.v4.view.g.a(homeUI.yjb, homeUI.yfm);
            homeUI.yjc = menu.add(0, 2, 0, R.string.ewm);
            if (homeUI.yiW == null) {
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(am, dimensionPixelSize);
                homeUI.yiW = com.tencent.mm.kiss.a.b.SM().a(homeUI.yhZ, "R.layout.actionview_with_dot_tips", (int) R.layout.ai);
                homeUI.yiX = (ImageView) homeUI.yiW.findViewById(R.id.jb);
                homeUI.yiY = homeUI.yiW.findViewById(R.id.kv);
                homeUI.yiW.setLayoutParams(layoutParams2);
                homeUI.yiW.setBackgroundResource(R.drawable.al);
                homeUI.yiW.setMinimumHeight(dimensionPixelSize);
                homeUI.yiW.setMinimumWidth(am);
                homeUI.yiX.setImageResource(R.raw.icons_outlined_add2);
                homeUI.yiW.setContentDescription(homeUI.getString(R.string.ewm));
                homeUI.yiW.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(29348);
                        com.tencent.mm.plugin.report.service.h.pYm.X(10919, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        HomeUI.n(HomeUI.this);
                        if (HomeUI.yiE.booleanValue()) {
                            HomeUI homeUI = HomeUI.this;
                            Boolean bool = Boolean.TRUE;
                            HomeUI.a(homeUI, bool, bool);
                        }
                        if (HomeUI.yiF.booleanValue()) {
                            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
                        }
                        if (!bp.dnM()) {
                            long anU = ah.anU();
                            if (anU - HomeUI.this.mSj > 10000) {
                                HomeUI.this.mSj = anU;
                                HomeUI.this.clickCount = 1;
                                AppMethodBeat.o(29348);
                                return;
                            }
                            HomeUI.this.clickCount = HomeUI.this.clickCount + 1;
                            if (HomeUI.this.clickCount >= 5) {
                                ab.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
                                bp.pm(true);
                            }
                        }
                        AppMethodBeat.o(29348);
                    }
                });
                homeUI.yiW.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29349);
                        HomeUI.this.yhZ.supportInvalidateOptionsMenu();
                        AppMethodBeat.o(29349);
                    }

                    public final String toString() {
                        AppMethodBeat.i(29350);
                        String str = super.toString() + "|supportInvalidateOptionsMenu";
                        AppMethodBeat.o(29350);
                        return str;
                    }
                });
            }
            if (homeUI.qlP && homeUI.yiX != null) {
                homeUI.yiX.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            }
            com.tencent.mm.blink.b.HQ().o(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29351);
                    HomeUI.s(HomeUI.this);
                    AppMethodBeat.o(29351);
                }
            });
            homeUI.yjc.setActionView(homeUI.yiW);
            homeUI.dxk();
            homeUI.yiW.getLayoutParams().width = am;
            homeUI.yiW.getLayoutParams().height = dimensionPixelSize;
        }
        ab.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.o(29476);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(29477);
        super.onConfigurationChanged(configuration);
        HomeUI homeUI = this.yjJ;
        f.b(homeUI.yhZ, homeUI.contentView);
        AppMethodBeat.o(29477);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        ActionMode actionMode = null;
        AppMethodBeat.i(29478);
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (!(newChattingTabUI.ypn == null || newChattingTabUI.ypn.dBO() == null || !newChattingTabUI.ypn.isSupportCustomActionBar() || com.tencent.mm.compatible.util.d.iX(22))) {
            ActionMode startActionMode = newChattingTabUI.ypn.dBO().startActionMode(callback);
            if (startActionMode != null) {
                actionMode = startActionMode;
            }
        }
        if (actionMode == null) {
            actionMode = super.onWindowStartingActionMode(callback);
        }
        AppMethodBeat.o(29478);
        return actionMode;
    }

    public MMFragment getCurrentFragmet() {
        MMFragment mMFragment;
        AppMethodBeat.i(29479);
        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
        if (newChattingTabUI.mChattingClosed) {
            mMFragment = null;
        } else {
            mMFragment = newChattingTabUI.ypn;
        }
        if (mMFragment == null) {
            mMFragment = super.getCurrentFragmet();
        }
        AppMethodBeat.o(29479);
        return mMFragment;
    }

    public HomeUI getHomeUI() {
        return this.yjJ;
    }

    public static void ho(Context context) {
        AppMethodBeat.i(29480);
        Intent intent = new Intent(context, LauncherUI.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
        AppMethodBeat.o(29480);
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(29481);
        this.yjJ.dxn();
        this.chattingTabUI.startChatting(str, bundle, z);
        AppMethodBeat.o(29481);
    }

    public final void closeChatting(boolean z) {
        AppMethodBeat.i(29482);
        AnonymousClass5 anonymousClass5 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(138621);
                LauncherUI.this.yjJ.getMainTabUI().dyD();
                AppMethodBeat.o(138621);
            }
        };
        if (this.chattingTabUI.pW(z)) {
            this.yjJ.pI(this.chattingTabUI.ypn.isSupportCustomActionBar());
            this.yjJ.getMainTabUI().dyG();
        }
        AppMethodBeat.o(29482);
    }
}
