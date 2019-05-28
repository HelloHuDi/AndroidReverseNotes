package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.luggage.sdk.b.b;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bw;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.j;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.record.c;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;
import com.tencent.mm.plugin.appbrand.networking.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.permission.l;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.q;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o extends b implements j {
    private volatile e gPo;
    protected AppBrandRemoteTaskController gPp = new AppBrandRemoteTaskController();
    private n gPq;
    public m gPr = new m();
    public boolean gPs;
    private int gPt = 0;
    private boolean gPu;
    private ap gPv = null;
    private j gPw;
    private final f gPx = new f() {
        public final void finish() {
            AppMethodBeat.i(128994);
            o.this.finish();
            AppMethodBeat.o(128994);
        }

        public final void onNetworkChange() {
            AppMethodBeat.i(128995);
            com.tencent.mm.plugin.appbrand.networking.b bVar = (com.tencent.mm.plugin.appbrand.networking.b) o.this.K(com.tencent.mm.plugin.appbrand.networking.b.class);
            if (bVar instanceof com.tencent.mm.plugin.appbrand.networking.e) {
                ((com.tencent.mm.plugin.appbrand.networking.e) bVar).aIQ();
            }
            AppMethodBeat.o(128995);
        }
    };

    static /* synthetic */ void c(o oVar) {
        AppMethodBeat.i(129052);
        super.close();
        AppMethodBeat.o(129052);
    }

    public final /* synthetic */ AppBrandSysConfigLU xZ() {
        AppMethodBeat.i(129045);
        AppBrandSysConfigWC atH = atH();
        AppMethodBeat.o(129045);
        return atH;
    }

    public final /* synthetic */ h ye() {
        AppMethodBeat.i(129047);
        AppBrandSysConfigWC atH = atH();
        AppMethodBeat.o(129047);
        return atH;
    }

    public o(Activity activity, ab abVar) {
        super(activity, abVar);
        AppMethodBeat.i(129004);
        AppBrandRemoteTaskController appBrandRemoteTaskController = this.gPp;
        i atz = abVar.atz();
        f fVar = this.gPx;
        appBrandRemoteTaskController.gQX = activity.getClass().getName();
        if (activity instanceof AppBrandEmbedUI) {
            appBrandRemoteTaskController.iEJ = ((AppBrandEmbedUI) activity).iFU;
        }
        appBrandRemoteTaskController.gOD = atz;
        appBrandRemoteTaskController.gPx = fVar;
        this.gNV = bp.dpL();
        AppMethodBeat.o(129004);
    }

    public final Looper atd() {
        AppMethodBeat.i(129007);
        Looper looper;
        if (xy()) {
            looper = new al("AppRunningStateMachineForGameRuntime").oAl.getLooper();
            AppMethodBeat.o(129007);
            return looper;
        }
        looper = super.atd();
        AppMethodBeat.o(129007);
        return looper;
    }

    /* Access modifiers changed, original: protected|final */
    public final void atq() {
        AppMethodBeat.i(129008);
        if (com.tencent.mm.plugin.appbrand.ui.i.D(this)) {
            AppMethodBeat.o(129008);
            return;
        }
        super.atq();
        AppMethodBeat.o(129008);
    }

    public final void close() {
        AppMethodBeat.i(129009);
        OpenBusinessViewUtil.m(this);
        if (atD()) {
            finish();
            AppMethodBeat.o(129009);
            return;
        }
        Object obj;
        final AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(128975);
                o.c(o.this);
                AppMethodBeat.o(128975);
            }
        };
        com.tencent.mm.plugin.appbrand.widget.b.f fVar = new com.tencent.mm.plugin.appbrand.widget.b.f();
        AnonymousClass10 anonymousClass10 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(128996);
                anonymousClass1.run();
                AppMethodBeat.o(128996);
            }
        };
        if (atH() == null || ((MMActivity) super.getContext()) == null) {
            ab.w(com.tencent.mm.plugin.appbrand.widget.b.f.TAG, "invalid close state");
            obj = null;
        } else {
            AppBrandSysConfigWC atH = atH();
            if (atH.hhh) {
                ab.i(com.tencent.mm.plugin.appbrand.widget.b.f.TAG, "app time start:%s, close:%s, least:%s", Long.valueOf(com.tencent.mm.modelappbrand.b.abw() / 1000), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(atH.hhi));
                if ((System.currentTimeMillis() / 1000) - (com.tencent.mm.modelappbrand.b.abw() / 1000) < ((long) atH.hhi)) {
                    ab.i(com.tencent.mm.plugin.appbrand.widget.b.f.TAG, "time not enough to show evaluate dialog");
                    obj = null;
                } else {
                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
                    fVar.userName = appBrandInitConfigWC.username;
                    if (bo.isNullOrNil(fVar.userName)) {
                        ab.i(com.tencent.mm.plugin.appbrand.widget.b.f.TAG, "username is null, can not show evaluate dialog");
                        obj = null;
                    } else {
                        String str;
                        MMActivity mMActivity = (MMActivity) super.getContext();
                        String str2 = appBrandInitConfigWC.cwz;
                        fVar.dialog = new Dialog(mMActivity, R.style.dd);
                        fVar.dialog.setCancelable(true);
                        fVar.dialog.setCanceledOnTouchOutside(true);
                        Window window = fVar.dialog.getWindow();
                        if (window != null) {
                            window.getDecorView().setPadding(0, 0, 0, 0);
                            LayoutParams attributes = window.getAttributes();
                            attributes.gravity = 81;
                            attributes.height = -2;
                            attributes.width = -1;
                            window.setAttributes(attributes);
                            window.setWindowAnimations(R.style.dc);
                        }
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(fVar.dialog.getContext()).inflate(R.layout.c4, null, false);
                        fVar.dialog.setContentView(linearLayout);
                        Point hy = ae.hy(fVar.dialog.getContext());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Math.min(hy.x, hy.y), -2);
                        layoutParams.gravity = 1;
                        linearLayout.setLayoutParams(layoutParams);
                        ab.i(com.tencent.mm.plugin.appbrand.widget.b.f.TAG, "createEvaluateDialog, dialog width:%d", Integer.valueOf(r2));
                        fVar.jch = (TextView) fVar.dialog.findViewById(R.id.qf);
                        fVar.jcj = (LinearLayout) fVar.dialog.findViewById(R.id.qi);
                        fVar.jci = (FrameLayout) fVar.dialog.findViewById(R.id.qg);
                        ((TextView) fVar.dialog.findViewById(R.id.qh)).setOnClickListener(new com.tencent.mm.plugin.appbrand.widget.b.f.AnonymousClass6(mMActivity));
                        fVar.jcg = (RatingBar) fVar.dialog.findViewById(R.id.qe);
                        fVar.jcg.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
                            public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                                AppMethodBeat.i(134259);
                                f.a(f.this, f);
                                AppMethodBeat.o(134259);
                            }
                        });
                        fVar.jcf = (TextView) fVar.dialog.findViewById(R.id.qd);
                        if (bo.isNullOrNil(str2)) {
                            fVar.jcf.setVisibility(8);
                        } else {
                            fVar.jcf.setVisibility(0);
                            fVar.jcf.setText(mMActivity.getString(R.string.ic, new Object[]{str2}));
                        }
                        ((ImageView) fVar.dialog.findViewById(R.id.qc)).setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(134260);
                                ab.i(f.TAG, "user clicked dialog close button");
                                f.this.jcd = false;
                                f.this.dismiss();
                                AppMethodBeat.o(134260);
                            }
                        });
                        ViewGroup viewGroup = (ViewGroup) linearLayout.getParent();
                        if (viewGroup != null) {
                            viewGroup.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(134261);
                                    ab.i(f.TAG, "user clicked dialog outside");
                                    f.this.jcd = false;
                                    f.this.dismiss();
                                    AppMethodBeat.o(134261);
                                }
                            });
                            linearLayout.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(134262);
                                    ab.i(f.TAG, "user clicked dialog inside");
                                    AppMethodBeat.o(134262);
                                }
                            });
                        }
                        fVar.dialog = fVar.dialog;
                        fVar.dialog.setOnCancelListener(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(134253);
                                ab.i(f.TAG, "user cancel evaluate dialog");
                                f.this.jcd = false;
                                AppMethodBeat.o(134253);
                            }
                        });
                        fVar.dialog.setOnDismissListener(new com.tencent.mm.plugin.appbrand.widget.b.f.AnonymousClass5(anonymousClass10));
                        fVar.jcd = false;
                        atH.hhh = false;
                        if (this == null) {
                            str = null;
                        } else {
                            str = this.mAppId;
                        }
                        fVar.appId = str;
                        if (bo.isNullOrNil(fVar.appId)) {
                            ab.e(com.tencent.mm.plugin.appbrand.widget.b.f.TAG, "saveEvaluateReport, no app id");
                        } else {
                            appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
                            fVar.cvF = "";
                            if (appBrandInitConfigWC != null) {
                                fVar.cvF = appBrandInitConfigWC.xz();
                            }
                            fVar.scene = 1000;
                            if (!(appBrandInitConfigWC == null || appBrandInitConfigWC.bQn == null)) {
                                fVar.scene = appBrandInitConfigWC.bQn.scene;
                            }
                            fVar.csu = "";
                            if (!(((s) super.xT()) == null || ((s) super.xT()).aun() == null)) {
                                fVar.csu = ((s) super.xT()).aun().getURL();
                            }
                        }
                        fVar.dp(1, 1);
                        if (fVar.dialog != null) {
                            fVar.dialog.show();
                        }
                        obj = 1;
                    }
                }
            } else {
                ab.i(com.tencent.mm.plugin.appbrand.widget.b.f.TAG, "can not show evaluate dialog");
                obj = null;
            }
        }
        if (obj == null) {
            anonymousClass1.run();
        }
        AppMethodBeat.o(129009);
    }

    /* Access modifiers changed, original: protected|final */
    public final void d(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(138113);
        if (appBrandInitConfig == null) {
            ((AppBrandInitConfigWC) super.ya()).resetSession();
        }
        super.d(appBrandInitConfig);
        AppMethodBeat.o(138113);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atE() {
        AppMethodBeat.i(129014);
        a(a.class, (com.tencent.mm.kernel.c.a) new com.tencent.mm.plugin.appbrand.networking.f());
        a(com.tencent.mm.plugin.appbrand.permission.f.class, (com.tencent.mm.kernel.c.a) new com.tencent.mm.plugin.appbrand.permission.i(this));
        a(g.class, (com.tencent.mm.kernel.c.a) k.ixc);
        a(com.tencent.mm.plugin.appbrand.jsapi.media.b.class, (com.tencent.mm.kernel.c.a) com.tencent.mm.plugin.appbrand.jsapi.media.i.hQA);
        this.gNK.L(com.tencent.mm.plugin.appbrand.networking.b.class);
        a(com.tencent.mm.plugin.appbrand.networking.b.class, (com.tencent.mm.kernel.c.a) new com.tencent.mm.plugin.appbrand.networking.e(this));
        a(com.tencent.mm.plugin.appbrand.widget.g.class, (com.tencent.mm.kernel.c.a) com.tencent.mm.plugin.appbrand.widget.h.iUe);
        AppMethodBeat.o(129014);
    }

    public void onCreate() {
        int doL;
        AppMethodBeat.i(129015);
        atF();
        a.b(this);
        boolean z = WXHardCoderJNI.hcMiniProgramLaunchEnable;
        int i = WXHardCoderJNI.hcMiniProgramLaunchDelay;
        int i2 = WXHardCoderJNI.hcMiniProgramLaunchCPU;
        int i3 = WXHardCoderJNI.hcMiniProgramLaunchIO;
        if (WXHardCoderJNI.hcMiniProgramLaunchThr) {
            doL = com.tencent.mm.kernel.g.RS().doL();
        } else {
            doL = 0;
        }
        this.gPt = WXHardCoderJNI.startPerformance(z, i, i2, i3, doL, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
        ab.i("MicroMsg.AppBrandRuntimeWC", "hardcoder miniprogram launch launchStartPerformance [%d]", Integer.valueOf(this.gPt));
        super.onCreate();
        atE();
        com.tencent.mm.plugin.appbrand.report.quality.a.o(this);
        com.tencent.mm.plugin.appbrand.report.quality.g.a(this, false);
        com.tencent.mm.plugin.appbrand.game.f.a aBG = com.tencent.mm.plugin.appbrand.game.f.a.aBG();
        String str = this.mAppId;
        boolean xy = xy();
        aBG.appId = str;
        ab.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", str, Boolean.valueOf(xy));
        if (xy) {
            g.a(str, aBG.huj);
        }
        a((i.b) new i.b() {
            public final void prepare() {
                AppMethodBeat.i(128997);
                o.b(this);
                AppMethodBeat.o(128997);
            }
        });
        a((i.b) new i.b() {
            public final void prepare() {
                AppMethodBeat.i(128998);
                o.a(o.this, (i.b) this);
                AppMethodBeat.o(128998);
            }
        });
        a((i.b) new i.b() {
            public final void prepare() {
                AppMethodBeat.i(128999);
                o.b(o.this, this);
                AppMethodBeat.o(128999);
            }
        });
        a((i.b) new i.b() {
            public final void prepare() {
                AppMethodBeat.i(129000);
                o.c(o.this, this);
                AppMethodBeat.o(129000);
            }
        });
        j jVar = new j(this);
        this.gPw = jVar;
        a((i.b) jVar);
        this.gPp.a(this.mAppId, ((AppBrandInitConfigWC) super.ya()).gVs, com.tencent.mm.plugin.appbrand.task.g.c((AppBrandInitConfigWC) super.ya()));
        com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
        c.onCreate();
        com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.k(this);
        com.tencent.mm.plugin.appbrand.backgroundfetch.f.k(this);
        this.gPq = new n(this);
        this.gPq.iCb = bo.yz();
        com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i.a(this.mAppId, atc(), ya().bQn);
        AppMethodBeat.o(129015);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atg() {
        AppMethodBeat.i(129017);
        super.atg();
        this.gPr.y(0, System.currentTimeMillis() - ((AppBrandInitConfigWC) super.ya()).startTime);
        nl(1);
        com.tencent.mm.plugin.appbrand.performance.c.a(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC) super.ya()).startTime, System.currentTimeMillis());
        MMToClientEvent.a(this.mAppId, new MMToClientEvent.c() {
            public final void bk(Object obj) {
                AppMethodBeat.i(129001);
                if (obj instanceof AuthStateChangedByUserEvent) {
                    d.Dp(o.this.mAppId);
                }
                AppMethodBeat.o(129001);
            }
        });
        atN();
        com.tencent.mm.plugin.appbrand.report.b.a aVar = new com.tencent.mm.plugin.appbrand.report.b.a(this, (byte) 0);
        this.gPr.y(8, System.currentTimeMillis() - ((AppBrandInitConfigWC) super.ya()).startTime);
        nl(2);
        AppMethodBeat.o(129017);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0232  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReady() {
        int i;
        QualitySessionRuntime DG;
        QualitySessionRuntime qualitySessionRuntime;
        AppMethodBeat.i(129018);
        super.onReady();
        if (this.gPt != 0) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.gPt);
            this.gPt = 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - ((AppBrandInitConfigWC) super.ya()).startTime;
        com.tencent.mm.plugin.appbrand.report.c.a(currentTimeMillis, this.gPs, xy());
        String str = "MicroMsg.AppBrandRuntimeWC";
        String str2 = "onHideSplash: %s, cost: %dms, download : %b";
        Object[] objArr = new Object[3];
        objArr[0] = ((AppBrandInitConfigWC) super.ya()) != null ? ((AppBrandInitConfigWC) super.ya()).cwz : "";
        objArr[1] = Long.valueOf(currentTimeMillis);
        objArr[2] = Boolean.valueOf(this.gPs);
        ab.i(str, str2, objArr);
        currentTimeMillis = System.currentTimeMillis() - ((AppBrandInitConfigWC) super.ya()).startTime;
        this.gPr.y(5, currentTimeMillis);
        m mVar = this.gPr;
        boolean z = this.gPs;
        boolean z2 = ((AppBrandInitConfigWC) super.ya()).hgO;
        boolean z3 = ((AppStartupPerformanceReportBundle) aa(AppStartupPerformanceReportBundle.class)).igW;
        String str3 = this.mAppId;
        mVar.cD = 0;
        mVar.mType = 0;
        if (atH() != null) {
            mVar.cD = atH().hhd.gVu;
            mVar.mType = atH().hhd.gVt + 1;
        }
        mVar.gOV = z ? 1 : 0;
        if (xy()) {
            i = 1;
        } else {
            i = 0;
        }
        mVar.gPa = i;
        mVar.gOW = ya().bQn.scene;
        mVar.gOY = z2;
        mVar.gOZ = z3;
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < mVar.gOU.length; i++) {
            if (mVar.gOU[i] < 0) {
                ab.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", Integer.valueOf(i), Long.valueOf(mVar.gOU[i]));
                break;
            }
            stringBuilder.append(mVar.gOU[i]);
            stringBuilder.append(",");
        }
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
        if (appBrandInitConfigWC != null) {
            i = appBrandInitConfigWC.bQe;
        } else {
            i = com.tencent.mm.plugin.appbrand.report.d.Dy(str3);
            ab.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(i));
        }
        i += 1000;
        ab.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", str3, stringBuilder.toString(), Boolean.valueOf(z), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.e.auw()), Integer.valueOf(i));
        mVar.f(str3, 1, 0, i);
        mVar.f(str3, 2, 1, i);
        mVar.f(str3, 3, 2, i);
        mVar.f(str3, 4, 3, i);
        mVar.f(str3, 6, 4, i);
        mVar.f(str3, 7, 5, i);
        mVar.f(str3, 23, 6, i);
        mVar.f(str3, 24, 7, i);
        mVar.f(str3, 25, 8, i);
        mVar.f(str3, 26, 9, i);
        mVar.f(str3, 27, 10, i);
        mVar.f(str3, 28, 11, i);
        mVar.f(str3, 29, 12, i);
        mVar.f(str3, 30, 13, i);
        mVar.f(str3, 31, 14, i);
        AppBrandPerformanceManager.a((b) this, 202, currentTimeMillis);
        com.tencent.mm.plugin.appbrand.performance.c.gs(((AppBrandInitConfigWC) super.ya()).startTime);
        com.tencent.mm.plugin.appbrand.performance.c.a(this.mAppId, "Native", "startupDone", ((AppBrandInitConfigWC) super.ya()).startTime, System.currentTimeMillis(), String.format("{ \"appMd5\": \"%s\" }", new Object[]{atH().hhd.cvZ}));
        com.tencent.mm.plugin.appbrand.report.quality.a.a(this.mAppId, this);
        if (DebuggerShell.ayT() && this.gPv == null) {
            this.gPv = new ap(m.aNS().oAl.getLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(128993);
                    AppBrandPerformanceManager.e(o.this);
                    AppMethodBeat.o(128993);
                    return true;
                }
            }, true);
            this.gPv.ae(1000, 1000);
        }
        if (xy()) {
            com.tencent.mm.plugin.appbrand.game.preload.e.aBD().cY(2001, (int) (bo.anU() - ((AppBrandInitConfigWC) super.ya()).startTime));
        }
        MainProcessTask mainProcessTask = this.gPp;
        if (!AppBrandRemoteTaskController.iEP) {
            mainProcessTask.iEK = AppBrandRemoteTaskController.a.PRELOAD;
            AppBrandMainProcessService.a(mainProcessTask);
            AppBrandRemoteTaskController.iEP = true;
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.file.al) super.asE()) != null) {
            com.tencent.mm.vfs.e.b(((com.tencent.mm.plugin.appbrand.appstorage.m) ((com.tencent.mm.plugin.appbrand.jsapi.file.al) super.asE()).ae(com.tencent.mm.plugin.appbrand.appstorage.m.class)).gXQ + "/dir.lock", new byte[1], 1);
        }
        QualitySessionRuntime DG2 = com.tencent.mm.plugin.appbrand.report.quality.a.DG(this.mAppId);
        if (!(DG2 == null || xy())) {
            com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
            a.f.b.j.p(this, "runtime");
            cm cmVar = new cm();
            DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(this.mAppId);
            if (DG != null) {
                aj aJz;
                aa aaVar;
                cmVar.hp(DG.igT);
                cmVar.hq(DG.appId);
                cmVar.ddd = (long) DG.iDa;
                cmVar.dgV = cm.a.hn(DG.iCZ);
                cmVar.ddz = (long) DG.apptype;
                cmVar.cVR = (long) DG.scene;
                r rVar = (r) super.asV();
                a.f.b.j.o(rVar, "runtime.pageContainer");
                com.tencent.mm.plugin.appbrand.page.n currentPage = rVar.getCurrentPage();
                if (currentPage != null) {
                    u currentPageView = currentPage.getCurrentPageView();
                    if (currentPageView != null) {
                        aJz = currentPageView.aJz();
                        if (!(aJz instanceof aa)) {
                            aJz = null;
                        }
                        aaVar = (aa) aJz;
                        if (aaVar != null) {
                            if (aaVar.isSysKernel()) {
                                i = 4;
                            } else if (aaVar.getIsX5Kernel()) {
                                i = 2;
                            } else if (aaVar.isXWalkKernel()) {
                                i = 3;
                            }
                            cmVar.dbX = (long) i;
                            qualitySessionRuntime = DG;
                        }
                        i = -1;
                        cmVar.dbX = (long) i;
                        qualitySessionRuntime = DG;
                    }
                }
                aJz = null;
                if (aJz instanceof aa) {
                }
                aaVar = (aa) aJz;
                if (aaVar != null) {
                }
                i = -1;
                cmVar.dbX = (long) i;
                qualitySessionRuntime = DG;
            } else {
                qualitySessionRuntime = null;
            }
            com.tencent.mm.plugin.appbrand.report.quality.c.a(qualitySessionRuntime, "Null session with " + this.mAppId);
            if (!((r) super.asV()).getCurrentPage().getCurrentPageView().gPH) {
                cmVar.ddg = 0;
            } else if (DG2.iDj) {
                cmVar.ddg = 2;
            } else {
                cmVar.ddg = 1;
            }
            cmVar.ajK();
        }
        if (DG2 != null) {
            com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
            a.f.b.j.p(this, "runtime");
            bw bwVar = new bw();
            DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(this.mAppId);
            if (DG != null) {
                bwVar.gz(DG.igT);
                bwVar.gA(DG.appId);
                bwVar.ddd = (long) DG.iDa;
                bwVar.dej = bw.a.gX(DG.iCZ);
                bwVar.ddz = (long) DG.apptype;
                bwVar.cVR = (long) DG.scene;
                s sVar = (s) super.xT();
                switch (com.tencent.mm.plugin.appbrand.report.quality.d.eQZ[com.tencent.mm.plugin.appbrand.report.a.d(sVar != null ? sVar.aBx() : null).ordinal()]) {
                    case 1:
                        i = 1;
                        break;
                    case 2:
                        i = 2;
                        break;
                    case 3:
                        i = 3;
                        break;
                    case 4:
                        i = 4;
                        break;
                    case 5:
                        i = 5;
                        break;
                    case 6:
                        i = 6;
                        break;
                    default:
                        i = -1;
                        break;
                }
                bwVar.dbX = (long) i;
                qualitySessionRuntime = DG;
            } else {
                qualitySessionRuntime = null;
            }
            com.tencent.mm.plugin.appbrand.report.quality.c.a(qualitySessionRuntime, "Null session with " + this.mAppId);
            if (!((s) super.xT()).gPH) {
                bwVar.ddg = 0;
            } else if (DG2.iDj) {
                bwVar.ddg = 2;
            } else {
                bwVar.ddg = 1;
            }
            bwVar.ajK();
        }
        AppMethodBeat.o(129018);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atf() {
        AppMethodBeat.i(129019);
        super.atf();
        nl(11);
        AppMethodBeat.o(129019);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(129021);
        MainProcessTask mainProcessTask = this.gPp;
        mainProcessTask.iEK = AppBrandRemoteTaskController.a.NOTIFY_PAUSE;
        AppBrandMainProcessService.a(mainProcessTask);
        AppMethodBeat.o(129021);
    }

    public final void onDestroy() {
        AppMethodBeat.i(129022);
        super.onDestroy();
        if (this.gPt != 0) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.gPt);
            this.gPt = 0;
        }
        if (DebuggerShell.ayT()) {
            if (this.gPv != null) {
                this.gPv.stopTimer();
            }
            com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(128976);
                    AppBrandPerformanceManager.e(o.this);
                    AppMethodBeat.o(128976);
                }
            });
            AppBrandPerformanceManager.Dl(this.mAppId);
        }
        AppBrandStickyBannerLogic.a.release(this.mAppId);
        AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ikP;
        appBrandMusicClientService.ikO.clear();
        appBrandMusicClientService.ikQ = "";
        com.tencent.mm.plugin.appbrand.media.a.a.AO(this.mAppId);
        n.remove(this.mAppId);
        c.onDestroy();
        d.Dp(this.mAppId);
        MainProcessTask mainProcessTask = this.gPp;
        String str = this.mAppId;
        mainProcessTask.iEK = AppBrandRemoteTaskController.a.REMOVE;
        mainProcessTask.mAppId = str;
        AppBrandMainProcessService.a(mainProcessTask);
        com.tencent.mm.plugin.appbrand.jsapi.file.al alVar = (com.tencent.mm.plugin.appbrand.jsapi.file.al) super.asE();
        if (alVar != null) {
            com.tencent.mm.plugin.appbrand.appstorage.m mVar = (com.tencent.mm.plugin.appbrand.appstorage.m) alVar.ae(com.tencent.mm.plugin.appbrand.appstorage.m.class);
            if (mVar != null) {
                com.tencent.mm.vfs.e.deleteFile(mVar.gXQ + "/dir.lock");
            }
            alVar.release();
        }
        a.a(this);
        if (this.gPq != null) {
            n nVar = this.gPq;
            try {
                int i;
                n xa = n.xa(nVar.htn.mAppId);
                nVar.iBz = com.tencent.mm.plugin.appbrand.report.c.cV(ah.getContext());
                nVar.appId = nVar.htn.mAppId;
                nVar.axy = nVar.htn.atH() == null ? ((AppBrandInitConfigWC) super.ya()).axy : nVar.htn.atH().hhd.gVu;
                nVar.css = nVar.htn.gNB.gVs + 1;
                nVar.scene = nVar.htn.ya().bQn.scene;
                if (nVar.iCc) {
                    i = 1;
                } else {
                    i = 0;
                }
                nVar.iCd = i;
                if (xa.gPe.get()) {
                    i = 1;
                } else {
                    i = 0;
                }
                nVar.iCe = i;
                nVar.iCf = bo.az(nVar.iCb);
                nVar.iCg = bo.anU();
                ab.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + nVar.toString());
                com.tencent.mm.plugin.report.e.pXa.e(14576, nVar.iBz, nVar.appId, Integer.valueOf(nVar.axy), Integer.valueOf(nVar.css), Integer.valueOf(nVar.scene), nVar.cvF, Integer.valueOf(nVar.iCd), Integer.valueOf(nVar.iCe), Long.valueOf(nVar.iCf), Long.valueOf(nVar.iCg));
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", e);
            }
        }
        this.gPq = null;
        this.gPw = null;
        AppMethodBeat.o(129022);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atm() {
        AppMethodBeat.i(129023);
        this.gPp.a(this.mAppId, ((AppBrandInitConfigWC) super.ya()).gVs, com.tencent.mm.plugin.appbrand.task.g.c((AppBrandInitConfigWC) super.ya()));
        AppMethodBeat.o(129023);
    }

    public final boolean atj() {
        AppMethodBeat.i(129024);
        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_game_splashscreen, false)) {
            ab.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", Boolean.valueOf(getAppConfig().hfe));
            AppMethodBeat.o(129024);
            return getAppConfig().hfe;
        }
        AppMethodBeat.o(129024);
        return false;
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.file.al atG() {
        AppMethodBeat.i(139118);
        com.tencent.mm.plugin.appbrand.jsapi.file.al alVar = (com.tencent.mm.plugin.appbrand.jsapi.file.al) super.asE();
        AppMethodBeat.o(139118);
        return alVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final p asZ() {
        AppMethodBeat.i(129026);
        com.tencent.mm.plugin.appbrand.jsapi.file.al alVar = new com.tencent.mm.plugin.appbrand.jsapi.file.al(this, com.tencent.mm.plugin.appbrand.config.d.b(atH()));
        AppMethodBeat.o(129026);
        return alVar;
    }

    public final AppBrandSysConfigWC atH() {
        AppMethodBeat.i(129027);
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) c(AppBrandSysConfigWC.class, false);
        AppMethodBeat.o(129027);
        return appBrandSysConfigWC;
    }

    public final AppBrandInitConfigWC atI() {
        AppMethodBeat.i(139119);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
        AppMethodBeat.o(139119);
        return appBrandInitConfigWC;
    }

    public final r atJ() {
        AppMethodBeat.i(139120);
        r rVar = (r) super.asV();
        AppMethodBeat.o(139120);
        return rVar;
    }

    public final s atK() {
        AppMethodBeat.i(139121);
        s sVar = (s) super.xT();
        AppMethodBeat.o(139121);
        return sVar;
    }

    public final boolean yd() {
        AppMethodBeat.i(139122);
        boolean yd = super.yd();
        AppMethodBeat.o(139122);
        return yd;
    }

    public final MMActivity atM() {
        AppMethodBeat.i(139123);
        MMActivity mMActivity = (MMActivity) super.getContext();
        AppMethodBeat.o(139123);
        return mMActivity;
    }

    public e xY() {
        return this.gPo;
    }

    /* Access modifiers changed, original: protected */
    public q ata() {
        int i = 1;
        AppMethodBeat.i(129037);
        if (xy()) {
            int i2;
            com.tencent.mm.plugin.appbrand.game.preload.e aBD = com.tencent.mm.plugin.appbrand.game.preload.e.aBD();
            aBD.htG = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_game_predownload, false) ? 1 : 0;
            ab.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", Integer.valueOf(aBD.htG));
            AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
            aBD.htB = appBrandInitConfigWC.appId;
            aBD.htC = appBrandInitConfigWC.axy;
            aBD.htD = appBrandInitConfigWC.gVs;
            aBD.htE = appBrandInitConfigWC.bQe + 1000;
            aBD.htF = appBrandInitConfigWC.hgN.igT;
            switch (aBD.htD) {
                case 0:
                    aBD.htD = 1;
                    break;
                case 1:
                    aBD.htD = 2;
                    break;
                case 2:
                    aBD.htD = 3;
                    break;
            }
            if (ya().bQn != null) {
                aBD.gOW = ya().bQn.scene;
            }
            if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_game_splashscreen, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            aBD.htI = i2;
            ab.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", Integer.valueOf(aBD.htI));
        }
        q a = com.tencent.mm.plugin.appbrand.ui.e.a((MMActivity) super.getContext(), this);
        a.cz(((AppBrandInitConfigWC) super.ya()).iconUrl, ((AppBrandInitConfigWC) super.ya()).cwz);
        if (ya().bQn.scene != FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
            i = 0;
        }
        if (i != 0) {
            a.aHT();
        }
        AppMethodBeat.o(129037);
        return a;
    }

    private void atN() {
        AppMethodBeat.i(129038);
        v.r(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY, ((AppBrandInitConfigWC) super.ya()).appId);
        v.r(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, ((AppBrandInitConfigWC) super.ya()).cwz);
        v.r(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, Boolean.FALSE);
        AppMethodBeat.o(129038);
    }

    private void nl(int i) {
        AppMethodBeat.i(129039);
        int i2 = 369;
        if (xy()) {
            i2 = 777;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a((long) i2, (long) i, 1, false);
        AppMethodBeat.o(129039);
    }

    public final com.tencent.mm.plugin.appbrand.ui.k yc() {
        AppMethodBeat.i(129040);
        com.tencent.mm.plugin.appbrand.performance.b.n(this);
        List list = ((AppStartupPerformanceReportBundle) aa(AppStartupPerformanceReportBundle.class)).igV;
        if (!bo.ek(list)) {
            long j;
            long j2 = 0;
            Iterator it = list.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                j2 = Math.max(j, ((kv_14609) it.next()).iCh);
            }
            AppBrandPerformanceManager.a(this, j);
        }
        if (DebuggerShell.ayT()) {
            AppMethodBeat.o(129040);
            return null;
        }
        com.tencent.mm.plugin.appbrand.ui.k yc = super.yc();
        AppMethodBeat.o(129040);
        return yc;
    }

    public final boolean xy() {
        AppMethodBeat.i(129005);
        boolean xy = ((AppBrandInitConfigWC) super.ya()).xy();
        AppMethodBeat.o(129005);
        return xy;
    }

    public final boolean atD() {
        AppMethodBeat.i(129006);
        boolean z = ((AppBrandInitConfigWC) super.ya()).hgJ;
        AppMethodBeat.o(129006);
        return z;
    }

    /* Access modifiers changed, original: protected */
    public q ath() {
        q bVar;
        AppMethodBeat.i(129011);
        if (!super.yd()) {
            q a = com.tencent.mm.plugin.appbrand.task.e.a(this.mAppId, com.tencent.mm.plugin.appbrand.task.g.eB(xy()));
            String str;
            if (a == null) {
                String str2 = "MicroMsg.AppBrandRuntimeWC";
                str = "[%s] [preload] createService got no preloaded";
                Object[] objArr = new Object[1];
                objArr[0] = xy() ? "WAGame" : "WAService";
                ab.i(str2, str, objArr);
                if ((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.DEBUG || DebuggerShell.ayT()) && com.tencent.mm.plugin.appbrand.task.b.aLG()) {
                    IllegalStateException illegalStateException = new IllegalStateException("[ForcePreload] enabled, but not preload");
                    AppMethodBeat.o(129011);
                    throw illegalStateException;
                } else if (xy()) {
                    bVar = new com.tencent.mm.plugin.appbrand.game.b();
                } else {
                    bVar = new s();
                }
            } else {
                str = "MicroMsg.AppBrandRuntimeWC";
                String str3 = "[%s] [preload] createService preloaded";
                Object[] objArr2 = new Object[1];
                objArr2[0] = xy() ? "WAGame" : "WAService";
                ab.i(str, str3, objArr2);
                bVar = a;
            }
        } else if (xy()) {
            bVar = com.tencent.mm.plugin.appbrand.task.e.a(this.mAppId, com.tencent.mm.plugin.appbrand.task.g.eB(true));
            if (bVar == null) {
                bVar = new com.tencent.mm.plugin.appbrand.game.b();
            }
        } else {
            bVar = new com.tencent.mm.plugin.appbrand.debugger.r();
        }
        AppMethodBeat.o(129011);
        return bVar;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.appbrand.page.q ati() {
        r eVar;
        AppMethodBeat.i(129012);
        try {
            com.tencent.mm.plugin.appbrand.report.quality.a.DG(this.mAppId).iDk = bo.anU();
        } catch (Throwable th) {
        }
        if (xy()) {
            eVar = new com.tencent.mm.plugin.appbrand.game.page.e((MMActivity) super.getContext(), this);
        } else {
            eVar = new r((MMActivity) super.getContext(), this);
        }
        eVar.setDecorWidgetFactory(new com.tencent.mm.plugin.appbrand.page.d());
        AppMethodBeat.o(129012);
        return eVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(129013);
        com.tencent.mm.plugin.appbrand.jsapi.p.h.a(configuration, this.mAppId);
        AppMethodBeat.o(129013);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atF() {
        AppMethodBeat.i(129016);
        o wI = a.wI(this.mAppId);
        if (!(wI == null || this == wI)) {
            wI.atP();
        }
        this.gPp.DL(this.mAppId);
        AppMethodBeat.o(129016);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.i(129020);
        com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i.a(this.mAppId, atc(), ya().bQn);
        atN();
        MainProcessTask mainProcessTask = this.gPp;
        String str = this.mAppId;
        int i = ((AppBrandInitConfigWC) super.ya()).gVs;
        mainProcessTask.iEK = AppBrandRemoteTaskController.a.UPDATE;
        mainProcessTask.mAppId = str;
        mainProcessTask.igj = i;
        AppBrandMainProcessService.a(mainProcessTask);
        if (this.gNQ) {
            ((r) super.asV()).getReporter().aIa();
        }
        com.tencent.mm.plugin.appbrand.task.e.DJ(this.mAppId);
        a(new com.tencent.mm.plugin.appbrand.config.a.a.a() {
            public final void a(com.tencent.mm.plugin.appbrand.config.a.a.b bVar, boolean z) {
                AppMethodBeat.i(129002);
                ab.i("MicroMsg.AppBrandRuntimeWC", "resume OnOrientationChanged orientation = [%s] success = [%b]", bVar, Boolean.valueOf(z));
                AppMethodBeat.o(129002);
            }
        }, atL());
        String str2 = this.mAppId;
        int i2 = ya().bQn.scene;
        AppBrandIDKeyBatchReport.aKW().izE = 1;
        AppBrandIDKeyBatchReport.aKW().izG = str2;
        AppBrandIDKeyBatchReport.aKW().izH = i2;
        AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.aKW());
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129003);
                AppBrandSysConfigWC atH = o.this.atH();
                MainProcessTask getCopyPathMenuExpireTimeTask = new GetCopyPathMenuExpireTimeTask(o.this.mAppId);
                AppBrandMainProcessService.b(getCopyPathMenuExpireTimeTask);
                atH.bQN = getCopyPathMenuExpireTimeTask.inh;
                AppMethodBeat.o(129003);
            }
        }, "getCopyPathMenuExpireTime");
        AppBrandMainProcessService.a(new AppBrandMainProcessPrepareTask());
        AppMethodBeat.o(129020);
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.appbrand.j.a asX() {
        byte b;
        AppMethodBeat.i(129031);
        if (atH() == null || bo.ek(atH().hhd.gVx)) {
            b = (byte) 0;
        } else {
            b = (byte) 1;
        }
        if (b != (byte) 0) {
            com.tencent.mm.plugin.appbrand.j.h hVar = new com.tencent.mm.plugin.appbrand.j.h(this);
            AppMethodBeat.o(129031);
            return hVar;
        }
        com.tencent.mm.plugin.appbrand.j.a aVar = new com.tencent.mm.plugin.appbrand.j.b.a(this, (byte) 0);
        AppMethodBeat.o(129031);
        return aVar;
    }

    private com.tencent.mm.plugin.appbrand.config.a.d atL() {
        AppMethodBeat.i(129032);
        r rVar = (r) super.asV();
        if (rVar == null) {
            AppMethodBeat.o(129032);
            return null;
        }
        com.tencent.mm.plugin.appbrand.page.n currentPage = rVar.getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.o(129032);
            return null;
        }
        com.tencent.mm.plugin.appbrand.config.a.d pageConfig = currentPage.getPageConfig();
        AppMethodBeat.o(129032);
        return pageConfig;
    }

    private void a(com.tencent.mm.plugin.appbrand.config.a.a.a aVar, com.tencent.mm.plugin.appbrand.config.a.d dVar) {
        AppMethodBeat.i(129033);
        if (this.mFinished) {
            ab.i("MicroMsg.AppBrandRuntimeWC", "mFinished is true return,mAppId:%s", this.mAppId);
            AppMethodBeat.o(129033);
            return;
        }
        if (xy()) {
            dVar = null;
        }
        com.tencent.mm.plugin.appbrand.config.a.a.t((MMActivity) super.getContext()).a(com.tencent.mm.plugin.appbrand.config.a.a.a(getAppConfig(), dVar), aVar);
        AppMethodBeat.o(129033);
    }

    public final void a(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(129034);
        if (this.eMP) {
            int i;
            AppBrandInitConfigWC appBrandInitConfigWC;
            AppBrandInitConfigWC appBrandInitConfigWC2 = (AppBrandInitConfigWC) appBrandInitConfig;
            if (this.eMP) {
                AppBrandStatObject appBrandStatObject = appBrandInitConfigWC2.bQn;
                if (this.gPu || appBrandStatObject.scene == FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN) {
                    boolean z;
                    if (appBrandStatObject.scene == FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.gPu = z;
                } else if (appBrandStatObject.scene == 1022 || appBrandStatObject.scene == 1001 || appBrandStatObject.scene == FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU || appBrandStatObject.scene == FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI || appBrandStatObject.scene == 1038) {
                    i = 0;
                } else {
                    appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
                    if (bo.isNullOrNil(appBrandInitConfigWC2.hgC) && bo.isNullOrNil(appBrandInitConfigWC2.bQi) && bo.isNullOrNil(appBrandInitConfigWC.hgC) && bo.isNullOrNil(appBrandInitConfigWC.bQi)) {
                        i = 0;
                    }
                }
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                ab.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, setWillRelaunch", this.mAppId);
                this.gNQ = true;
                ab.d("MicroMsg.AppBrandRuntime", "setWillRelaunch");
            }
            super.a(appBrandInitConfig);
            ab.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], finished[%b], scene[%d]", this.mAppId, Boolean.valueOf(this.gNP), Boolean.valueOf(this.gNQ), Boolean.valueOf(this.mFinished), Integer.valueOf(ya().bQn.scene));
            if (!(this.gNP || this.mFinished)) {
                com.tencent.mm.plugin.appbrand.report.quality.g.a(this, true);
                if (((r) super.asV()) != null) {
                    r rVar = (r) super.asV();
                    rVar.getReporter().resetSession();
                    rVar.isk = false;
                    rVar.isl = false;
                }
                appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
                AppBrandSysConfigWC atH = atH();
                AppBrandStatObject appBrandStatObject2 = ya().bQn;
                ab.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", appBrandInitConfigWC.appId, Integer.valueOf(appBrandInitConfigWC.gVs));
                AppBrandMainProcessService.a(new UpdateTask(new LaunchCheckParams(appBrandInitConfigWC, appBrandStatObject2, atH.hhd.gVu, WxaCommLibRuntimeReader.avQ().gVu, appBrandInitConfigWC.xz(), appBrandInitConfigWC.hgN)));
            }
            AppMethodBeat.o(129034);
            return;
        }
        AppMethodBeat.o(129034);
    }

    public final void atO() {
        boolean z;
        int i = 0;
        AppMethodBeat.i(129041);
        ConcurrentLinkedDeque concurrentLinkedDeque = this.gNI;
        AppBrandSysConfigWC atH = atH();
        h hVar = new h();
        hVar.cwz = atH.cwz;
        hVar.appId = atH.appId;
        hVar.hgW = atH.hgW;
        hVar.hgX = atH.hgX;
        hVar.hhb = atH.hhb;
        hVar.hhc = atH.hhc;
        hVar.hhd = atH.hhd;
        hVar.hgY = atH.hgY;
        concurrentLinkedDeque.add(hVar);
        ConcurrentLinkedDeque concurrentLinkedDeque2 = this.gNI;
        AppBrandInitConfigLU ya = ya();
        AppBrandSysConfigLU xZ = xZ();
        com.tencent.mm.plugin.appbrand.config.a appConfig = getAppConfig();
        com.tencent.mm.plugin.appbrand.l.a aVar = new com.tencent.mm.plugin.appbrand.l.a();
        if (ya.bQg || ya.xy()) {
            z = true;
        } else {
            z = false;
        }
        aVar.ioe = z;
        int i2 = (xZ.hhd.gVt == 1 || xZ.hhd.gVt == 2) ? 1 : 0;
        z = xZ.bQf ? i2 == 0 || !xZ.bQs : i2 == 0 || !xZ.bQp;
        aVar.iof = z;
        i2 = com.tencent.mm.plugin.appbrand.config.d.n(xZ.bQO.hfP.hgs, appConfig.heW.cRx);
        if (i2 > 0) {
            aVar.iog = i2;
        }
        i2 = com.tencent.mm.plugin.appbrand.config.d.n(xZ.bQO.hfP.hgp, appConfig.heW.hfj);
        if (i2 > 0) {
            aVar.ioh = i2;
        }
        i2 = com.tencent.mm.plugin.appbrand.config.d.n(xZ.bQO.hfP.hgq, appConfig.heW.hfk);
        if (i2 > 0) {
            aVar.ioi = i2;
        }
        i2 = com.tencent.mm.plugin.appbrand.config.d.n(xZ.bQO.hfP.hgr, appConfig.heW.hfl);
        if (i2 > 0) {
            aVar.ioj = i2;
        }
        aVar.bQw = xZ.bQw;
        aVar.iok = xZ.bQz;
        aVar.bQx = xZ.bQx;
        aVar.bQy = xZ.bQy;
        aVar.bQF = xZ.bQF;
        aVar.bQG = xZ.bQG;
        aVar.bQH = xZ.bQH;
        aVar.bQI = xZ.bQI;
        aVar.bQJ = xZ.bQJ;
        if (xZ.bQO.hfP.mode == 1) {
            if (xZ.bQO.hfP.hgn != null) {
                aVar.iol = xZ.bQO.hfP.hgn;
            }
        } else if (xZ.bQO.hfP.mode == 2 && xZ.bQO.hfP.hgo != null) {
            aVar.iom = xZ.bQO.hfP.hgo;
        }
        aVar.mode = xZ.bQO.hfP.mode;
        aVar.ion = com.tencent.mm.plugin.appbrand.config.d.s(this);
        if (ya.xy()) {
            i2 = xZ.bQO.hga;
        } else {
            i2 = xZ.bQO.hfK;
        }
        aVar.hfK = i2;
        aVar.bQB = xZ.bQB;
        aVar.bQC = xZ.bQC;
        aVar.ioo = com.tencent.mm.plugin.appbrand.config.d.ayy();
        String str = "";
        if (!(xZ.bQO == null || xZ.bQO.hfP == null)) {
            str = xZ.bQO.hfP.hgt;
        }
        if (bo.isNullOrNil(str)) {
            str = "servicewechat.com";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(xZ.appId);
        stringBuilder.append("/");
        stringBuilder.append(xZ.hhd.gVu);
        stringBuilder.append("/page-frame.html");
        aVar.referer = stringBuilder.toString();
        aVar.bQf = ya.bQf;
        aVar.iop = xZ.hhd.gVt;
        concurrentLinkedDeque2.add(aVar);
        this.gNI.add(com.tencent.mm.plugin.appbrand.config.d.b(atH()));
        concurrentLinkedDeque = this.gNI;
        atH = atH();
        com.tencent.mm.plugin.appbrand.s.q.a aVar2 = new com.tencent.mm.plugin.appbrand.s.q.a();
        aVar2.hfX = atH.bQO.hfX;
        concurrentLinkedDeque.add(aVar2);
        concurrentLinkedDeque = this.gNI;
        AppBrandSysConfigLU xZ2 = xZ();
        com.tencent.mm.plugin.appbrand.config.a appConfig2 = getAppConfig();
        com.tencent.mm.plugin.appbrand.b.a aVar3 = new com.tencent.mm.plugin.appbrand.b.a();
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.kR(xZ2.hhd.gVt)) {
            aVar3.gWs = appConfig2.hfb.contains(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        } else {
            aVar3.gWs = xZ2.hgY;
        }
        concurrentLinkedDeque.add(aVar3);
        atH = atH();
        com.tencent.mm.plugin.appbrand.performance.a aVar4 = new com.tencent.mm.plugin.appbrand.performance.a();
        if (atH.bQq && atH.hhd.gVt == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar4.ivy = z;
        if (atH.hhd.gVt != 0) {
            z = true;
        } else {
            z = false;
        }
        aVar4.ivz = z;
        aVar4.ivA = atH.bQp;
        aVar4.ivy |= DebuggerShell.ayT();
        z = aVar4.ivz;
        if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || bp.dpL()) {
            i = 1;
        }
        aVar4.ivz = z | i;
        this.gNI.add(aVar4);
        AppMethodBeat.o(129041);
    }

    public final void nm(int i) {
        AppMethodBeat.i(129042);
        q qVar = this.gNF;
        if (qVar instanceof j) {
            ((j) qVar).nm(i);
        }
        AppMethodBeat.o(129042);
    }

    public final void atP() {
        AppMethodBeat.i(129043);
        this.gNT = false;
        this.gNz.j(this);
        super.finish();
        if (this.gNz instanceof l) {
            ((l) this.gNz).atC();
        }
        AppMethodBeat.o(129043);
    }

    public final /* bridge */ /* synthetic */ AppBrandInitConfigLU ya() {
        AppMethodBeat.i(129044);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
        AppMethodBeat.o(129044);
        return appBrandInitConfigWC;
    }

    public final /* bridge */ /* synthetic */ p asE() {
        AppMethodBeat.i(129046);
        com.tencent.mm.plugin.appbrand.jsapi.file.al alVar = (com.tencent.mm.plugin.appbrand.jsapi.file.al) super.asE();
        AppMethodBeat.o(129046);
        return alVar;
    }

    public final /* synthetic */ AppBrandInitConfig yf() {
        AppMethodBeat.i(129048);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ya();
        AppMethodBeat.o(129048);
        return appBrandInitConfigWC;
    }

    public final /* bridge */ /* synthetic */ Activity getContext() {
        AppMethodBeat.i(129049);
        MMActivity mMActivity = (MMActivity) super.getContext();
        AppMethodBeat.o(129049);
        return mMActivity;
    }

    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.appbrand.page.q asV() {
        AppMethodBeat.i(129050);
        r rVar = (r) super.asV();
        AppMethodBeat.o(129050);
        return rVar;
    }

    public final /* bridge */ /* synthetic */ q xT() {
        AppMethodBeat.i(129051);
        s sVar = (s) super.xT();
        AppMethodBeat.o(129051);
        return sVar;
    }

    static /* synthetic */ void b(i.b bVar) {
        AppMethodBeat.i(129053);
        AppBrandMainProcessService.a(new AppBrandMainProcessPrepareTask());
        bVar.wL();
        AppMethodBeat.o(129053);
    }

    static /* synthetic */ void b(o oVar, final i.b bVar) {
        AppMethodBeat.i(129055);
        final long currentTimeMillis = System.currentTimeMillis();
        AppBrandPrepareTask appBrandPrepareTask = new AppBrandPrepareTask((MMActivity) super.getContext(), oVar);
        x xVar = new x(new AppBrandPrepareTask.b<AppBrandSysConfigWC>() {
            public final /* synthetic */ void a(AppBrandSysConfigLU appBrandSysConfigLU, final AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle) {
                AppMethodBeat.i(128991);
                AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) appBrandSysConfigLU;
                ab.i("MicroMsg.AppBrandRuntimeWC", "AppBrandPrepareTask.onPrepareDone appId[%s] type[%d] activityFinishing[%b], runtimeFinishing[%b %b]", o.this.mAppId, Integer.valueOf(o.this.gNB.gVs), Boolean.valueOf(o.this.atM().isFinishing()), Boolean.valueOf(o.this.Pf), Boolean.valueOf(o.this.mFinished));
                if (o.this.atM().isFinishing() || r1 || r2) {
                    AppMethodBeat.o(128991);
                    return;
                }
                com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                String str = o.this.mAppId;
                if (appStartupPerformanceReportBundle == null) {
                    ab.i("MicroMsg.AppBrandQualitySystem", "reportAppStartupPerformanceReportBundle, but bundle == null");
                } else {
                    QualitySessionRuntime DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(str);
                    if (DG != null) {
                        for (kv_14609 kv_14609 : appStartupPerformanceReportBundle.igV) {
                            kv_14609.igT = DG.igT;
                            kv_14609.IF();
                        }
                        for (cg cgVar : appStartupPerformanceReportBundle.igU) {
                            cgVar.hc(DG.appId);
                            cgVar.hb(DG.igT);
                            cgVar.dfQ = cg.a.hg(DG.iCZ);
                            cgVar.ddz = (long) DG.apptype;
                            cgVar.cVR = (long) DG.scene;
                            cgVar.ddd = (long) DG.iDa;
                            cgVar.ajK();
                        }
                    }
                }
                if (appBrandSysConfigWC == null) {
                    o.this.atM().runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(128983);
                            o.this.finish();
                            if (appBrandLaunchErrorAction != null) {
                                AppBrandLaunchErrorAction appBrandLaunchErrorAction = appBrandLaunchErrorAction;
                                Context atM = o.this.atM();
                                if (atM == null || atM.isFinishing()) {
                                    atM = ah.getContext();
                                }
                                appBrandLaunchErrorAction.cQ(atM);
                                OpenBusinessViewUtil.m(o.this);
                            }
                            AppMethodBeat.o(128983);
                        }
                    });
                    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i.b(o.this.mAppId, o.this.atc(), o.this.ya().bQn);
                    AppMethodBeat.o(128991);
                    return;
                }
                com.tencent.mm.plugin.appbrand.config.d.a(appBrandSysConfigWC);
                o.this.gNI.add(appBrandSysConfigWC);
                o.this.gNI.add(appStartupPerformanceReportBundle);
                try {
                    com.tencent.mm.plugin.appbrand.report.quality.a.a(o.this.mAppId, appBrandSysConfigWC, appStartupPerformanceReportBundle, o.this);
                } catch (Throwable th) {
                    ab.w("MicroMsg.AppBrandRuntimeWC", "onPrepareDone [%s] reportResourceReady e = %s", o.this.mAppId, th);
                }
                o.this.gPr.y(1, System.currentTimeMillis() - currentTimeMillis);
                com.tencent.mm.plugin.appbrand.performance.c.a(o.this.mAppId, "ResourcePrepare", currentTimeMillis, System.currentTimeMillis());
                o.this.a(o.e(o.this));
                o.this.gNI.add(appBrandSysConfigWC.bQt);
                o.f(o.this);
                o.this.asY();
                o.this.atO();
                o.g(o.this);
                com.tencent.mm.plugin.appbrand.keepalive.b bVar = com.tencent.mm.plugin.appbrand.keepalive.b.ifu;
                MMActivity atM = o.this.atM();
                o oVar = o.this;
                ab.i("MicroMsg.AppBrandKeepAliveManager", "set up contextUIName:%s", atM.getClass().getName());
                oVar.gNN.a(new com.tencent.mm.plugin.appbrand.b.c.a() {
                    public final void a(String str, com.tencent.mm.plugin.appbrand.b.b bVar) {
                        AppMethodBeat.i(131684);
                        switch (bVar) {
                            case BACKGROUND:
                                b.a(b.this, str);
                                AppMethodBeat.o(131684);
                                return;
                            case SUSPEND:
                            case FOREGROUND:
                            case DESTROYED:
                                b.a(b.this);
                                break;
                        }
                        AppMethodBeat.o(131684);
                    }
                });
                if (bVar.ifv != null) {
                    ab.i("MicroMsg.AppBrandKeepAliveManager", "already set up mAppBrandUIClassName");
                } else {
                    bVar.ifv = atM.getClass().getName();
                }
                o.this.atM().runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(128984);
                        ab.i("MicroMsg.AppBrandRuntimeWC", "AppBrandPrepareTask done. runOnUiThread appId = %s, finished[%B]", o.this.mAppId, Boolean.valueOf(o.this.mFinished));
                        if (o.this.mFinished) {
                            AppMethodBeat.o(128984);
                            return;
                        }
                        j h = o.this.gPw;
                        if (!h.gOr) {
                            h.wL();
                        }
                        o.d(o.this, bVar);
                        o.this.gPq = null;
                        AppMethodBeat.o(128984);
                    }
                });
                AppMethodBeat.o(128991);
            }

            public final void nm(int i) {
                AppMethodBeat.i(128986);
                o.this.nm(i);
                AppMethodBeat.o(128986);
            }

            public final void atT() {
                AppMethodBeat.i(128987);
                if (o.this.mFinished) {
                    AppMethodBeat.o(128987);
                    return;
                }
                j h = o.this.gPw;
                if (h != null) {
                    h.a(com.tencent.mm.plugin.appbrand.task.e.b.SYNC_LAUNCH);
                }
                AppMethodBeat.o(128987);
            }

            public final void gf(long j) {
                AppMethodBeat.i(128988);
                if (o.this.mFinished) {
                    AppMethodBeat.o(128988);
                    return;
                }
                o.this.gPs = true;
                if (o.this.gPq != null) {
                    o.this.gPq.iCc = true;
                }
                o.dv(o.this.gPs);
                j h = o.this.gPw;
                if (h != null) {
                    h.a(com.tencent.mm.plugin.appbrand.task.e.b.SYNC_GET_CODE);
                }
                AppMethodBeat.o(128988);
            }

            public final void nn(int i) {
                AppMethodBeat.i(128989);
                ab.i("MicroMsg.AppBrandRuntimeWC", "appId[%s] onDownloadProgress %d", o.this.mAppId, Integer.valueOf(i));
                o oVar = o.this;
                oVar.getContext().runOnUiThread(new com.tencent.mm.plugin.appbrand.i.AnonymousClass10(i));
                AppMethodBeat.o(128989);
            }

            public final void a(final com.tencent.mm.plugin.appbrand.jsapi.version.a aVar) {
                AppMethodBeat.i(128990);
                o.this.A(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(128985);
                        com.tencent.mm.plugin.appbrand.jsapi.version.a aVar = aVar;
                        s atK = o.this.atK();
                        ab.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), service %s", aVar.hYi, atK);
                        if (atK == null) {
                            AppMethodBeat.o(128985);
                            return;
                        }
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("state", aVar.hYi);
                        new com.tencent.mm.plugin.appbrand.jsapi.version.a.a().i(atK).t(hashMap).aCj();
                        AppMethodBeat.o(128985);
                    }
                });
                AppMethodBeat.o(128990);
            }
        });
        oVar.keep(xVar);
        appBrandPrepareTask.ifT = xVar;
        appBrandPrepareTask.aHd();
        AppMethodBeat.o(129055);
    }

    static /* synthetic */ void c(o oVar, final i.b bVar) {
        AppMethodBeat.i(129056);
        ab.i("MicroMsg.AppBrandRuntimeWC", "startPrepareResource. Preloader shouldWait?[%b]", Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.e.a(com.tencent.mm.plugin.appbrand.task.g.eB(oVar.xy()), new com.tencent.mm.plugin.appbrand.task.e.a() {
            public final void onReady() {
                AppMethodBeat.i(128981);
                if (o.this.mFinished) {
                    AppMethodBeat.o(128981);
                    return;
                }
                AppBrandPreloadProfiler aLP = com.tencent.mm.plugin.appbrand.task.e.aLP();
                if (aLP != null) {
                    com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                    com.tencent.mm.plugin.appbrand.report.quality.b.a(o.this.mAppId, aLP);
                }
                bVar.wL();
                AppMethodBeat.o(128981);
            }
        })));
        if (!com.tencent.mm.plugin.appbrand.task.e.a(com.tencent.mm.plugin.appbrand.task.g.eB(oVar.xy()), /* anonymous class already generated */)) {
            AppBrandPreloadProfiler aLP = com.tencent.mm.plugin.appbrand.task.e.aLP();
            if (aLP != null) {
                com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                com.tencent.mm.plugin.appbrand.report.quality.b.a(oVar.mAppId, aLP);
            }
            bVar.wL();
        }
        AppMethodBeat.o(129056);
    }

    static /* synthetic */ com.tencent.mm.plugin.appbrand.config.a e(o oVar) {
        AppMethodBeat.i(129057);
        String a = aw.a((i) oVar, "/app-config.json");
        if (bo.isNullOrNil(a)) {
            Iterator it = oVar.atH().hhd.gVx.iterator();
            while (true) {
                String str = a;
                if (!it.hasNext()) {
                    a = str;
                    break;
                }
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (modulePkgInfo.cta) {
                    a = aw.a((i) oVar, modulePkgInfo.name + (modulePkgInfo.name.endsWith("/") ? "" : "/") + "app-config.json");
                    if (!bo.isNullOrNil(a)) {
                        break;
                    }
                } else {
                    a = str;
                }
            }
        }
        com.tencent.mm.plugin.appbrand.config.a yT = com.tencent.mm.plugin.appbrand.config.a.yT(a);
        if (oVar.xy()) {
            yT.heS.hfv = "custom";
        } else {
            yT.heX.hfh = ((AppBrandInitConfigWC) super.ya()).hfh;
            yT.heX.hfi = true;
        }
        AppMethodBeat.o(129057);
        return yT;
    }

    static /* synthetic */ void f(o oVar) {
        AppMethodBeat.i(129058);
        oVar.gPo = new l(oVar);
        ab.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "register runtime(%s %d), finished %b", oVar.mAppId, Integer.valueOf(oVar.gNB.gVs), Boolean.valueOf(oVar.mFinished));
        if (!oVar.mFinished) {
            com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.AnonymousClass1(oVar);
            MMToClientEvent.a(oVar.mAppId, anonymousClass1);
            oVar.gNN.a(new com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.AnonymousClass2(oVar, anonymousClass1));
        }
        AppMethodBeat.o(129058);
    }

    static /* synthetic */ void g(o oVar) {
        AppMethodBeat.i(129059);
        if (oVar.xy()) {
            com.tencent.mm.plugin.appbrand.game.preload.d aBz = com.tencent.mm.plugin.appbrand.game.preload.d.aBz();
            aBz.htn = oVar;
            aBz.htp = (com.tencent.mm.plugin.appbrand.l.a) oVar.aa(com.tencent.mm.plugin.appbrand.l.a.class);
            aBz.htq = (com.tencent.mm.plugin.appbrand.jsapi.file.al) super.asE();
            aBz.htr = new com.tencent.mm.plugin.appbrand.game.preload.c(oVar);
            com.tencent.mm.plugin.appbrand.game.preload.c cVar = aBz.htr;
            cVar.htl.addAll(oVar.gNI);
            aBz.hto = new com.tencent.mm.plugin.appbrand.l.m(aBz.htr);
            aBz.hasInit = true;
            aBz.htt = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_game_predownload, false);
            aBz.htu = new AtomicInteger(0);
            aBz.htv = new AtomicInteger(0);
            aBz.htw = new AtomicInteger(0);
            aBz.htx = new AtomicInteger(0);
            com.tencent.mm.ce.a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(128982);
                    com.tencent.mm.plugin.appbrand.game.preload.d aBz = com.tencent.mm.plugin.appbrand.game.preload.d.aBz();
                    if (aBz.htt) {
                        if (!aBz.hasInit) {
                            ab.e("MicroMsg.WAGamePreloadManager", "hasn't init!");
                            AppMethodBeat.o(128982);
                            return;
                        } else if (aBz.htn != null) {
                            if (aBz.htn.getAppConfig() == null) {
                                ab.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
                                AppMethodBeat.o(128982);
                                return;
                            }
                            JSONArray jSONArray = aBz.htn.getAppConfig().hfc;
                            if (jSONArray != null) {
                                com.tencent.mm.plugin.appbrand.game.preload.e.aBD().cY(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, jSONArray.length());
                                int i = 0;
                                while (i < jSONArray.length()) {
                                    try {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                                        if (jSONObject != null) {
                                            String optString = jSONObject.optString("url");
                                            String optString2 = jSONObject.optString("path");
                                            if (!(com.tencent.magicbrush.c.isNullOrNil(optString) || com.tencent.magicbrush.c.isNullOrNil(optString2))) {
                                                if (aBz.htq.yd(optString2) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                                                    ab.i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", optString2);
                                                } else {
                                                    aBz.hts.add(optString);
                                                    com.tencent.mm.plugin.appbrand.game.preload.d.AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.appbrand.game.preload.d.AnonymousClass2(optString, optString2);
                                                    if (aBz.htp.bQy <= 0) {
                                                        ab.i("MicroMsg.WAGamePreloadManager", "maxDownloadConcurrent <= 0 ");
                                                    } else if (com.tencent.mm.plugin.appbrand.game.preload.d.a(aBz.htp, optString)) {
                                                        aBz.hto.a(jSONObject, 60000, new HashMap(), null, aBz.htp.hfK, anonymousClass2, com.tencent.mm.plugin.appbrand.game.preload.d.aBA(), "test");
                                                    } else {
                                                        ab.e("MicroMsg.WAGamePreloadManager", "checkDomains error,url:%s", optString);
                                                    }
                                                }
                                            }
                                        }
                                        i++;
                                    } catch (JSONException e) {
                                        ab.printErrStackTrace("MicroMsg.WAGamePreloadManager", e, "", new Object[0]);
                                    }
                                }
                            }
                            ArrayList arrayList = aBz.htn.getAppConfig().hfd;
                            if (arrayList != null) {
                                com.tencent.mm.plugin.appbrand.game.preload.e.aBD().cY(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED, arrayList.size());
                            }
                            aBz.aBB();
                        }
                    }
                    AppMethodBeat.o(128982);
                }
            });
        }
        AppMethodBeat.o(129059);
    }

    static /* synthetic */ void d(o oVar, final i.b bVar) {
        AppMethodBeat.i(129060);
        if (oVar.xy()) {
            boolean u = com.tencent.mm.plugin.appbrand.ui.n.u((MMActivity) super.getContext());
            if (oVar.xy() && u) {
                Toast makeText = Toast.makeText((MMActivity) super.getContext(), R.string.vc, 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
                ((MMActivity) super.getContext()).finish();
                AppMethodBeat.o(129060);
                return;
            }
            oVar.a(new com.tencent.mm.plugin.appbrand.config.a.a.a() {
                public final void a(com.tencent.mm.plugin.appbrand.config.a.a.b bVar, boolean z) {
                    AppMethodBeat.i(128992);
                    ab.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntime.onOrientationChanged");
                    if (!z) {
                        String str;
                        String str2 = "MicroMsg.AppBrandRuntimeWC";
                        String str3 = "OnOrientationChanged failure  ret:[%s]";
                        Object[] objArr = new Object[1];
                        if (bVar == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = bVar.name();
                        }
                        objArr[0] = str;
                        ab.f(str2, str3, objArr);
                    }
                    bVar.wL();
                    AppMethodBeat.o(128992);
                }
            }, oVar.atL());
            AppMethodBeat.o(129060);
            return;
        }
        bVar.wL();
        AppMethodBeat.o(129060);
    }

    static /* synthetic */ void dv(boolean z) {
        AppMethodBeat.i(129061);
        com.tencent.mm.plugin.appbrand.game.preload.d.aBz();
        com.tencent.mm.plugin.appbrand.game.preload.d.dQ(z);
        AppMethodBeat.o(129061);
    }

    static {
        AppMethodBeat.i(129062);
        com.tencent.mm.plugin.appbrand.j.f.b.inO = new com.tencent.mm.plugin.appbrand.j.f.b() {
            public final com.tencent.mm.plugin.appbrand.j.f i(com.tencent.mm.plugin.appbrand.i iVar, String str) {
                AppMethodBeat.i(131925);
                ModularizingPkgRetrieverWC modularizingPkgRetrieverWC = new ModularizingPkgRetrieverWC(iVar.mAppId, iVar.ye().hhd.gVt, iVar.ye().hhd.gVu, str, (byte) 0);
                try {
                    if (iVar instanceof com.tencent.mm.vending.e.b) {
                        iVar.keep(modularizingPkgRetrieverWC);
                    }
                } catch (ClassCastException e) {
                    if (bp.dpL() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
                        AppMethodBeat.o(131925);
                        throw e;
                    }
                }
                AppMethodBeat.o(131925);
                return modularizingPkgRetrieverWC;
            }
        };
        t.ev(((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_android_appbrand_page_reload_eanble, true));
        AppMethodBeat.o(129062);
    }
}
