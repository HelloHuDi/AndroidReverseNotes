package com.tencent.p177mm.plugin.appbrand;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.magicbrush.C37414c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p230g.p232b.p233a.C26278bw;
import com.tencent.p177mm.p230g.p232b.p233a.C26278bw.C26277a;
import com.tencent.p177mm.p230g.p232b.p233a.C37827cg;
import com.tencent.p177mm.p230g.p232b.p233a.C37827cg.C26284a;
import com.tencent.p177mm.p230g.p232b.p233a.C42097cm;
import com.tencent.p177mm.p230g.p232b.p233a.C42097cm.C42098a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C6750i.C675410;
import com.tencent.p177mm.plugin.appbrand.C6750i.C6764b;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42368m;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C33113f;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.config.C33135d;
import com.tencent.p177mm.plugin.appbrand.config.C38163a;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C33131d;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26836a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.debugger.C31286r;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.game.p1223f.C38226a;
import com.tencent.p177mm.plugin.appbrand.game.page.C10244e;
import com.tencent.p177mm.plugin.appbrand.game.preload.C38231c;
import com.tencent.p177mm.plugin.appbrand.game.preload.C38233e;
import com.tencent.p177mm.plugin.appbrand.game.preload.C45564d;
import com.tencent.p177mm.plugin.appbrand.game.preload.C45564d.C382322;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent.C38244c;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C38296al;
import com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact.C41232a;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.C19444i;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.C31304b;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C10486i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C45613h;
import com.tencent.p177mm.plugin.appbrand.jsapi.version.C42591a;
import com.tencent.p177mm.plugin.appbrand.jsapi.version.C42591a.C41236a;
import com.tencent.p177mm.plugin.appbrand.keepalive.C38410b;
import com.tencent.p177mm.plugin.appbrand.keepalive.C38410b.C384121;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandPrepareTask.C2367b;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.p177mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.p177mm.plugin.appbrand.launching.C10605x;
import com.tencent.p177mm.plugin.appbrand.launching.C38422j;
import com.tencent.p177mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.C19557a.C105761;
import com.tencent.p177mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.C19557a.C23742;
import com.tencent.p177mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.C426061;
import com.tencent.p177mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C19600a;
import com.tencent.p177mm.plugin.appbrand.media.record.C45654c;
import com.tencent.p177mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;
import com.tencent.p177mm.plugin.appbrand.networking.C10645f;
import com.tencent.p177mm.plugin.appbrand.networking.C27211e;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.plugin.appbrand.networking.C42638b;
import com.tencent.p177mm.plugin.appbrand.p281b.C38137a;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f.C19253b;
import com.tencent.p177mm.plugin.appbrand.p298j.C26910h;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a;
import com.tencent.p177mm.plugin.appbrand.p298j.C42460b.C42461a;
import com.tencent.p177mm.plugin.appbrand.p321l.C19548m;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandEmbedUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.C19789k;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27331i;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27333q;
import com.tencent.p177mm.plugin.appbrand.p336ui.C38533e;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19773a;
import com.tencent.p177mm.plugin.appbrand.page.C19640n;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;
import com.tencent.p177mm.plugin.appbrand.page.C31324aa;
import com.tencent.p177mm.plugin.appbrand.page.C31330d;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.C45665r;
import com.tencent.p177mm.plugin.appbrand.page.C45666t;
import com.tencent.p177mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.p177mm.plugin.appbrand.performance.C33486b;
import com.tencent.p177mm.plugin.appbrand.performance.C33487c;
import com.tencent.p177mm.plugin.appbrand.performance.C38483a;
import com.tencent.p177mm.plugin.appbrand.permission.C19661f;
import com.tencent.p177mm.plugin.appbrand.permission.C31331g;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.plugin.appbrand.permission.C38487d;
import com.tencent.p177mm.plugin.appbrand.permission.C42654i;
import com.tencent.p177mm.plugin.appbrand.permission.C42656l;
import com.tencent.p177mm.plugin.appbrand.permission.C44715k;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19688b.C19689a;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C19691d;
import com.tencent.p177mm.plugin.appbrand.report.C42669a;
import com.tencent.p177mm.plugin.appbrand.report.model.C38498n;
import com.tencent.p177mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C33519c;
import com.tencent.p177mm.plugin.appbrand.report.quality.C33520d;
import com.tencent.p177mm.plugin.appbrand.report.quality.C38501b;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.p177mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.p177mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.p177mm.plugin.appbrand.task.AppBrandRemoteTaskController.C27306a;
import com.tencent.p177mm.plugin.appbrand.task.C19742b;
import com.tencent.p177mm.plugin.appbrand.task.C27310e;
import com.tencent.p177mm.plugin.appbrand.task.C27310e.C27314a;
import com.tencent.p177mm.plugin.appbrand.task.C27310e.C27317b;
import com.tencent.p177mm.plugin.appbrand.task.C27318f;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.appbrand.task.C38520i;
import com.tencent.p177mm.plugin.appbrand.widget.C10979g;
import com.tencent.p177mm.plugin.appbrand.widget.C27394h;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2521f;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2521f.C25259;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2521f.C25271;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2521f.C25295;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2521f.C25308;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2521f.C25317;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2521f.C253210;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2521f.C25336;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C46499v;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
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
import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.plugin.appbrand.o */
public class C41243o extends C25697b implements C38422j {
    private volatile C33491e gPo;
    protected AppBrandRemoteTaskController gPp = new AppBrandRemoteTaskController();
    private C38498n gPq;
    public C45652m gPr = new C45652m();
    public boolean gPs;
    private int gPt = 0;
    private boolean gPu;
    private C7564ap gPv = null;
    private C10282j gPw;
    private final C27318f gPx = new C412459();

    /* renamed from: com.tencent.mm.plugin.appbrand.o$15 */
    class C1064915 implements C38244c {
        C1064915() {
        }

        /* renamed from: bk */
        public final void mo22088bk(Object obj) {
            AppMethodBeat.m2504i(129001);
            if (obj instanceof AuthStateChangedByUserEvent) {
                C38487d.m65120Dp(C41243o.this.mAppId);
            }
            AppMethodBeat.m2505o(129001);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$16 */
    class C1065016 implements C26836a {
        C1065016() {
        }

        /* renamed from: a */
        public final void mo3966a(C26839b c26839b, boolean z) {
            AppMethodBeat.m2504i(129002);
            C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "resume OnOrientationChanged orientation = [%s] success = [%b]", c26839b, Boolean.valueOf(z));
            AppMethodBeat.m2505o(129002);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$17 */
    class C1065117 implements Runnable {
        C1065117() {
        }

        public final void run() {
            AppMethodBeat.m2504i(129003);
            AppBrandSysConfigWC atH = C41243o.this.atH();
            MainProcessTask getCopyPathMenuExpireTimeTask = new GetCopyPathMenuExpireTimeTask(C41243o.this.mAppId);
            AppBrandMainProcessService.m54355b(getCopyPathMenuExpireTimeTask);
            atH.bQN = getCopyPathMenuExpireTimeTask.inh;
            AppMethodBeat.m2505o(129003);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$8 */
    class C106568 implements C5015a {
        C106568() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(128993);
            AppBrandPerformanceManager.m43294e(C41243o.this);
            AppMethodBeat.m2505o(128993);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$5 */
    class C272135 implements Runnable {
        C272135() {
        }

        public final void run() {
            AppMethodBeat.m2504i(128982);
            C45564d aBz = C45564d.aBz();
            if (aBz.htt) {
                if (!aBz.hasInit) {
                    C4990ab.m7412e("MicroMsg.WAGamePreloadManager", "hasn't init!");
                    AppMethodBeat.m2505o(128982);
                    return;
                } else if (aBz.htn != null) {
                    if (aBz.htn.getAppConfig() == null) {
                        C4990ab.m7412e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
                        AppMethodBeat.m2505o(128982);
                        return;
                    }
                    JSONArray jSONArray = aBz.htn.getAppConfig().hfc;
                    if (jSONArray != null) {
                        C38233e.aBD().mo60956cY(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, jSONArray.length());
                        int i = 0;
                        while (i < jSONArray.length()) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                if (jSONObject != null) {
                                    String optString = jSONObject.optString("url");
                                    String optString2 = jSONObject.optString("path");
                                    if (!(C37414c.isNullOrNil(optString) || C37414c.isNullOrNil(optString2))) {
                                        if (aBz.htq.mo5849yd(optString2) == C45518j.OK) {
                                            C4990ab.m7417i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", optString2);
                                        } else {
                                            aBz.hts.add(optString);
                                            C382322 c382322 = new C382322(optString, optString2);
                                            if (aBz.htp.bQy <= 0) {
                                                C4990ab.m7416i("MicroMsg.WAGamePreloadManager", "maxDownloadConcurrent <= 0 ");
                                            } else if (C45564d.m84053a(aBz.htp, optString)) {
                                                aBz.hto.mo34743a(jSONObject, 60000, new HashMap(), null, aBz.htp.hfK, c382322, C45564d.aBA(), "test");
                                            } else {
                                                C4990ab.m7413e("MicroMsg.WAGamePreloadManager", "checkDomains error,url:%s", optString);
                                            }
                                        }
                                    }
                                }
                                i++;
                            } catch (JSONException e) {
                                C4990ab.printErrStackTrace("MicroMsg.WAGamePreloadManager", e, "", new Object[0]);
                            }
                        }
                    }
                    ArrayList arrayList = aBz.htn.getAppConfig().hfd;
                    if (arrayList != null) {
                        C38233e.aBD().mo60956cY(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED, arrayList.size());
                    }
                    aBz.aBB();
                }
            }
            AppMethodBeat.m2505o(128982);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$1 */
    class C334611 implements Runnable {
        C334611() {
        }

        public final void run() {
            AppMethodBeat.m2504i(128975);
            C41243o.m71788c(C41243o.this);
            AppMethodBeat.m2505o(128975);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$2 */
    class C334622 implements Runnable {
        C334622() {
        }

        public final void run() {
            AppMethodBeat.m2504i(128976);
            AppBrandPerformanceManager.m43294e(C41243o.this);
            AppMethodBeat.m2505o(128976);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$11 */
    class C4124011 extends C6764b {
        C4124011() {
        }

        public final void prepare() {
            AppMethodBeat.m2504i(128997);
            C41243o.m71786b(this);
            AppMethodBeat.m2505o(128997);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$13 */
    class C4124113 extends C6764b {
        C4124113() {
        }

        public final void prepare() {
            AppMethodBeat.m2504i(128999);
            C41243o.m71787b(C41243o.this, this);
            AppMethodBeat.m2505o(128999);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$14 */
    class C4124414 extends C6764b {
        C4124414() {
        }

        public final void prepare() {
            AppMethodBeat.m2504i(129000);
            C41243o.m71789c(C41243o.this, this);
            AppMethodBeat.m2505o(129000);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$9 */
    class C412459 implements C27318f {
        C412459() {
        }

        public final void finish() {
            AppMethodBeat.m2504i(128994);
            C41243o.this.finish();
            AppMethodBeat.m2505o(128994);
        }

        public final void onNetworkChange() {
            AppMethodBeat.m2504i(128995);
            C42638b c42638b = (C42638b) C41243o.this.mo14978K(C42638b.class);
            if (c42638b instanceof C27211e) {
                ((C27211e) c42638b).aIQ();
            }
            AppMethodBeat.m2505o(128995);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o$12 */
    class C4124612 extends C6764b {
        C4124612() {
        }

        public final void prepare() {
            AppMethodBeat.m2504i(128998);
            C41243o.m71785a(C41243o.this, (C6764b) this);
            AppMethodBeat.m2505o(128998);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m71788c(C41243o c41243o) {
        AppMethodBeat.m2504i(129052);
        super.close();
        AppMethodBeat.m2505o(129052);
    }

    /* renamed from: xZ */
    public final /* synthetic */ AppBrandSysConfigLU mo43489xZ() {
        AppMethodBeat.m2504i(129045);
        AppBrandSysConfigWC atH = atH();
        AppMethodBeat.m2505o(129045);
        return atH;
    }

    /* renamed from: ye */
    public final /* synthetic */ C16597h mo15034ye() {
        AppMethodBeat.m2504i(129047);
        AppBrandSysConfigWC atH = atH();
        AppMethodBeat.m2505o(129047);
        return atH;
    }

    public C41243o(Activity activity, C26719ab c26719ab) {
        super(activity, c26719ab);
        AppMethodBeat.m2504i(129004);
        AppBrandRemoteTaskController appBrandRemoteTaskController = this.gPp;
        C38520i atz = c26719ab.atz();
        C27318f c27318f = this.gPx;
        appBrandRemoteTaskController.gQX = activity.getClass().getName();
        if (activity instanceof AppBrandEmbedUI) {
            appBrandRemoteTaskController.iEJ = ((AppBrandEmbedUI) activity).iFU;
        }
        appBrandRemoteTaskController.gOD = atz;
        appBrandRemoteTaskController.gPx = c27318f;
        this.gNV = C5047bp.dpL();
        AppMethodBeat.m2505o(129004);
    }

    public final Looper atd() {
        AppMethodBeat.m2504i(129007);
        Looper looper;
        if (mo65903xy()) {
            looper = new C5004al("AppRunningStateMachineForGameRuntime").oAl.getLooper();
            AppMethodBeat.m2505o(129007);
            return looper;
        }
        looper = super.atd();
        AppMethodBeat.m2505o(129007);
        return looper;
    }

    /* Access modifiers changed, original: protected|final */
    public final void atq() {
        AppMethodBeat.m2504i(129008);
        if (C27331i.m43385D(this)) {
            AppMethodBeat.m2505o(129008);
            return;
        }
        super.atq();
        AppMethodBeat.m2505o(129008);
    }

    public final void close() {
        AppMethodBeat.m2504i(129009);
        OpenBusinessViewUtil.m30041m(this);
        if (atD()) {
            finish();
            AppMethodBeat.m2505o(129009);
            return;
        }
        Object obj;
        final C334611 c334611 = new C334611();
        C2521f c2521f = new C2521f();
        C2721210 c2721210 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(128996);
                c334611.run();
                AppMethodBeat.m2505o(128996);
            }
        };
        if (atH() == null || ((MMActivity) super.getContext()) == null) {
            C4990ab.m7420w(C2521f.TAG, "invalid close state");
            obj = null;
        } else {
            AppBrandSysConfigWC atH = atH();
            if (atH.hhh) {
                C4990ab.m7417i(C2521f.TAG, "app time start:%s, close:%s, least:%s", Long.valueOf(C45445b.abw() / 1000), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(atH.hhi));
                if ((System.currentTimeMillis() / 1000) - (C45445b.abw() / 1000) < ((long) atH.hhi)) {
                    C4990ab.m7416i(C2521f.TAG, "time not enough to show evaluate dialog");
                    obj = null;
                } else {
                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
                    c2521f.userName = appBrandInitConfigWC.username;
                    if (C5046bo.isNullOrNil(c2521f.userName)) {
                        C4990ab.m7416i(C2521f.TAG, "username is null, can not show evaluate dialog");
                        obj = null;
                    } else {
                        String str;
                        MMActivity mMActivity = (MMActivity) super.getContext();
                        String str2 = appBrandInitConfigWC.cwz;
                        c2521f.dialog = new Dialog(mMActivity, C25738R.style.f10750dd);
                        c2521f.dialog.setCancelable(true);
                        c2521f.dialog.setCanceledOnTouchOutside(true);
                        Window window = c2521f.dialog.getWindow();
                        if (window != null) {
                            window.getDecorView().setPadding(0, 0, 0, 0);
                            LayoutParams attributes = window.getAttributes();
                            attributes.gravity = 81;
                            attributes.height = -2;
                            attributes.width = -1;
                            window.setAttributes(attributes);
                            window.setWindowAnimations(C25738R.style.f10749dc);
                        }
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(c2521f.dialog.getContext()).inflate(2130968680, null, false);
                        c2521f.dialog.setContentView(linearLayout);
                        Point hy = C5222ae.m7953hy(c2521f.dialog.getContext());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Math.min(hy.x, hy.y), -2);
                        layoutParams.gravity = 1;
                        linearLayout.setLayoutParams(layoutParams);
                        C4990ab.m7417i(C2521f.TAG, "createEvaluateDialog, dialog width:%d", Integer.valueOf(r2));
                        c2521f.jch = (TextView) c2521f.dialog.findViewById(2131821178);
                        c2521f.jcj = (LinearLayout) c2521f.dialog.findViewById(2131821181);
                        c2521f.jci = (FrameLayout) c2521f.dialog.findViewById(2131821179);
                        ((TextView) c2521f.dialog.findViewById(2131821180)).setOnClickListener(new C25336(mMActivity));
                        c2521f.jcg = (RatingBar) c2521f.dialog.findViewById(2131821177);
                        c2521f.jcg.setOnRatingBarChangeListener(new C25317());
                        c2521f.jcf = (TextView) c2521f.dialog.findViewById(2131821176);
                        if (C5046bo.isNullOrNil(str2)) {
                            c2521f.jcf.setVisibility(8);
                        } else {
                            c2521f.jcf.setVisibility(0);
                            c2521f.jcf.setText(mMActivity.getString(C25738R.string.f8889ic, new Object[]{str2}));
                        }
                        ((ImageView) c2521f.dialog.findViewById(2131821175)).setOnClickListener(new C25308());
                        ViewGroup viewGroup = (ViewGroup) linearLayout.getParent();
                        if (viewGroup != null) {
                            viewGroup.setOnClickListener(new C25259());
                            linearLayout.setOnClickListener(new C253210());
                        }
                        c2521f.dialog = c2521f.dialog;
                        c2521f.dialog.setOnCancelListener(new C25271());
                        c2521f.dialog.setOnDismissListener(new C25295(c2721210));
                        c2521f.jcd = false;
                        atH.hhh = false;
                        if (this == null) {
                            str = null;
                        } else {
                            str = this.mAppId;
                        }
                        c2521f.appId = str;
                        if (C5046bo.isNullOrNil(c2521f.appId)) {
                            C4990ab.m7412e(C2521f.TAG, "saveEvaluateReport, no app id");
                        } else {
                            appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
                            c2521f.cvF = "";
                            if (appBrandInitConfigWC != null) {
                                c2521f.cvF = appBrandInitConfigWC.mo32993xz();
                            }
                            c2521f.scene = 1000;
                            if (!(appBrandInitConfigWC == null || appBrandInitConfigWC.bQn == null)) {
                                c2521f.scene = appBrandInitConfigWC.bQn.scene;
                            }
                            c2521f.csu = "";
                            if (!(((C19722s) super.mo15032xT()) == null || ((C19722s) super.mo15032xT()).aun() == null)) {
                                c2521f.csu = ((C19722s) super.mo15032xT()).aun().getURL();
                            }
                        }
                        c2521f.mo6483dp(1, 1);
                        if (c2521f.dialog != null) {
                            c2521f.dialog.show();
                        }
                        obj = 1;
                    }
                }
            } else {
                C4990ab.m7416i(C2521f.TAG, "can not show evaluate dialog");
                obj = null;
            }
        }
        if (obj == null) {
            c334611.run();
        }
        AppMethodBeat.m2505o(129009);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final void mo15020d(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(138113);
        if (appBrandInitConfig == null) {
            ((AppBrandInitConfigWC) super.mo43491ya()).resetSession();
        }
        super.mo15020d(appBrandInitConfig);
        AppMethodBeat.m2505o(138113);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atE() {
        AppMethodBeat.m2504i(129014);
        mo14984a(C42637a.class, (C1694a) new C10645f());
        mo14984a(C19661f.class, (C1694a) new C42654i(this));
        mo14984a(C31331g.class, (C1694a) C44715k.ixc);
        mo14984a(C31304b.class, (C1694a) C19444i.hQA);
        this.gNK.mo5208L(C42638b.class);
        mo14984a(C42638b.class, (C1694a) new C27211e(this));
        mo14984a(C10979g.class, (C1694a) C27394h.iUe);
        AppMethodBeat.m2505o(129014);
    }

    public void onCreate() {
        int doL;
        AppMethodBeat.m2504i(129015);
        atF();
        C10048a.m17634b(this);
        boolean z = WXHardCoderJNI.hcMiniProgramLaunchEnable;
        int i = WXHardCoderJNI.hcMiniProgramLaunchDelay;
        int i2 = WXHardCoderJNI.hcMiniProgramLaunchCPU;
        int i3 = WXHardCoderJNI.hcMiniProgramLaunchIO;
        if (WXHardCoderJNI.hcMiniProgramLaunchThr) {
            doL = C1720g.m3539RS().doL();
        } else {
            doL = 0;
        }
        this.gPt = WXHardCoderJNI.startPerformance(z, i, i2, i3, doL, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
        C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "hardcoder miniprogram launch launchStartPerformance [%d]", Integer.valueOf(this.gPt));
        super.onCreate();
        atE();
        C27285a.m43324o(this);
        C2453g.m4696a(this, false);
        C38226a aBG = C38226a.aBG();
        String str = this.mAppId;
        boolean xy = mo65903xy();
        aBG.appId = str;
        C4990ab.m7417i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", str, Boolean.valueOf(xy));
        if (xy) {
            C33183g.m54274a(str, aBG.huj);
        }
        mo14983a((C6764b) new C4124011());
        mo14983a((C6764b) new C4124612());
        mo14983a((C6764b) new C4124113());
        mo14983a((C6764b) new C4124414());
        C10282j c10282j = new C10282j(this);
        this.gPw = c10282j;
        mo14983a((C6764b) c10282j);
        this.gPp.mo73483a(this.mAppId, ((AppBrandInitConfigWC) super.mo43491ya()).gVs, C38519g.m65221c((AppBrandInitConfigWC) super.mo43491ya()));
        C19600a.onCreate(this.mAppId);
        C45654c.onCreate();
        C41232a.m71771k(this);
        C33113f.m54128k(this);
        this.gPq = new C38498n(this);
        this.gPq.iCb = C5046bo.m7588yz();
        C10486i.m18200a(this.mAppId, atc(), mo43491ya().bQn);
        AppMethodBeat.m2505o(129015);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atg() {
        AppMethodBeat.m2504i(129017);
        super.atg();
        this.gPr.mo73432y(0, System.currentTimeMillis() - ((AppBrandInitConfigWC) super.mo43491ya()).startTime);
        m71799nl(1);
        C33487c.m54688a(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC) super.mo43491ya()).startTime, System.currentTimeMillis());
        MMToClientEvent.m75199a(this.mAppId, new C1064915());
        atN();
        C19689a c19689a = new C19689a(this, (byte) 0);
        this.gPr.mo73432y(8, System.currentTimeMillis() - ((AppBrandInitConfigWC) super.mo43491ya()).startTime);
        m71799nl(2);
        AppMethodBeat.m2505o(129017);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0232  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReady() {
        int i;
        QualitySessionRuntime DG;
        QualitySessionRuntime qualitySessionRuntime;
        AppMethodBeat.m2504i(129018);
        super.onReady();
        if (this.gPt != 0) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.gPt);
            this.gPt = 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - ((AppBrandInitConfigWC) super.mo43491ya()).startTime;
        C19690c.m30496a(currentTimeMillis, this.gPs, mo65903xy());
        String str = "MicroMsg.AppBrandRuntimeWC";
        String str2 = "onHideSplash: %s, cost: %dms, download : %b";
        Object[] objArr = new Object[3];
        objArr[0] = ((AppBrandInitConfigWC) super.mo43491ya()) != null ? ((AppBrandInitConfigWC) super.mo43491ya()).cwz : "";
        objArr[1] = Long.valueOf(currentTimeMillis);
        objArr[2] = Boolean.valueOf(this.gPs);
        C4990ab.m7417i(str, str2, objArr);
        currentTimeMillis = System.currentTimeMillis() - ((AppBrandInitConfigWC) super.mo43491ya()).startTime;
        this.gPr.mo73432y(5, currentTimeMillis);
        C45652m c45652m = this.gPr;
        boolean z = this.gPs;
        boolean z2 = ((AppBrandInitConfigWC) super.mo43491ya()).hgO;
        boolean z3 = ((AppStartupPerformanceReportBundle) mo14986aa(AppStartupPerformanceReportBundle.class)).igW;
        String str3 = this.mAppId;
        c45652m.f17885cD = 0;
        c45652m.mType = 0;
        if (atH() != null) {
            c45652m.f17885cD = atH().hhd.gVu;
            c45652m.mType = atH().hhd.gVt + 1;
        }
        c45652m.gOV = z ? 1 : 0;
        if (mo65903xy()) {
            i = 1;
        } else {
            i = 0;
        }
        c45652m.gPa = i;
        c45652m.gOW = mo43491ya().bQn.scene;
        c45652m.gOY = z2;
        c45652m.gOZ = z3;
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < c45652m.gOU.length; i++) {
            if (c45652m.gOU[i] < 0) {
                C4990ab.m7417i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", Integer.valueOf(i), Long.valueOf(c45652m.gOU[i]));
                break;
            }
            stringBuilder.append(c45652m.gOU[i]);
            stringBuilder.append(",");
        }
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
        if (appBrandInitConfigWC != null) {
            i = appBrandInitConfigWC.bQe;
        } else {
            i = C19691d.m30510Dy(str3);
            C4990ab.m7417i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(i));
        }
        i += 1000;
        C4990ab.m7417i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", str3, stringBuilder.toString(), Boolean.valueOf(z), Boolean.valueOf(C27310e.auw()), Integer.valueOf(i));
        c45652m.mo73431f(str3, 1, 0, i);
        c45652m.mo73431f(str3, 2, 1, i);
        c45652m.mo73431f(str3, 3, 2, i);
        c45652m.mo73431f(str3, 4, 3, i);
        c45652m.mo73431f(str3, 6, 4, i);
        c45652m.mo73431f(str3, 7, 5, i);
        c45652m.mo73431f(str3, 23, 6, i);
        c45652m.mo73431f(str3, 24, 7, i);
        c45652m.mo73431f(str3, 25, 8, i);
        c45652m.mo73431f(str3, 26, 9, i);
        c45652m.mo73431f(str3, 27, 10, i);
        c45652m.mo73431f(str3, 28, 11, i);
        c45652m.mo73431f(str3, 29, 12, i);
        c45652m.mo73431f(str3, 30, 13, i);
        c45652m.mo73431f(str3, 31, 14, i);
        AppBrandPerformanceManager.m43287a((C25697b) this, 202, currentTimeMillis);
        C33487c.m54693gs(((AppBrandInitConfigWC) super.mo43491ya()).startTime);
        C33487c.m54690a(this.mAppId, "Native", "startupDone", ((AppBrandInitConfigWC) super.mo43491ya()).startTime, System.currentTimeMillis(), String.format("{ \"appMd5\": \"%s\" }", new Object[]{atH().hhd.cvZ}));
        C27285a.m43321a(this.mAppId, this);
        if (DebuggerShell.ayT() && this.gPv == null) {
            this.gPv = new C7564ap(C45673m.aNS().oAl.getLooper(), new C106568(), true);
            this.gPv.mo16770ae(1000, 1000);
        }
        if (mo65903xy()) {
            C38233e.aBD().mo60956cY(2001, (int) (C5046bo.anU() - ((AppBrandInitConfigWC) super.mo43491ya()).startTime));
        }
        MainProcessTask mainProcessTask = this.gPp;
        if (!AppBrandRemoteTaskController.iEP) {
            mainProcessTask.iEK = C27306a.PRELOAD;
            AppBrandMainProcessService.m54349a(mainProcessTask);
            AppBrandRemoteTaskController.iEP = true;
        }
        if (((C38296al) super.asE()) != null) {
            C5730e.m8624b(((C42368m) ((C38296al) super.asE()).mo53654ae(C42368m.class)).gXQ + "/dir.lock", new byte[1], 1);
        }
        QualitySessionRuntime DG2 = C27285a.m43319DG(this.mAppId);
        if (!(DG2 == null || mo65903xy())) {
            C27285a.aLz();
            C25052j.m39376p(this, "runtime");
            C42097cm c42097cm = new C42097cm();
            DG = C27285a.m43319DG(this.mAppId);
            if (DG != null) {
                C27221aj aJz;
                C31324aa c31324aa;
                c42097cm.mo67661hp(DG.igT);
                c42097cm.mo67662hq(DG.appId);
                c42097cm.ddd = (long) DG.iDa;
                c42097cm.dgV = C42098a.m74209hn(DG.iCZ);
                c42097cm.ddz = (long) DG.apptype;
                c42097cm.cVR = (long) DG.scene;
                C45665r c45665r = (C45665r) super.asV();
                C25052j.m39375o(c45665r, "runtime.pageContainer");
                C19640n currentPage = c45665r.getCurrentPage();
                if (currentPage != null) {
                    C44709u currentPageView = currentPage.getCurrentPageView();
                    if (currentPageView != null) {
                        aJz = currentPageView.aJz();
                        if (!(aJz instanceof C31324aa)) {
                            aJz = null;
                        }
                        c31324aa = (C31324aa) aJz;
                        if (c31324aa != null) {
                            if (c31324aa.isSysKernel()) {
                                i = 4;
                            } else if (c31324aa.getIsX5Kernel()) {
                                i = 2;
                            } else if (c31324aa.isXWalkKernel()) {
                                i = 3;
                            }
                            c42097cm.dbX = (long) i;
                            qualitySessionRuntime = DG;
                        }
                        i = -1;
                        c42097cm.dbX = (long) i;
                        qualitySessionRuntime = DG;
                    }
                }
                aJz = null;
                if (aJz instanceof C31324aa) {
                }
                c31324aa = (C31324aa) aJz;
                if (c31324aa != null) {
                }
                i = -1;
                c42097cm.dbX = (long) i;
                qualitySessionRuntime = DG;
            } else {
                qualitySessionRuntime = null;
            }
            C33519c.m54745a(qualitySessionRuntime, "Null session with " + this.mAppId);
            if (!((C45665r) super.asV()).getCurrentPage().getCurrentPageView().gPH) {
                c42097cm.ddg = 0;
            } else if (DG2.iDj) {
                c42097cm.ddg = 2;
            } else {
                c42097cm.ddg = 1;
            }
            c42097cm.ajK();
        }
        if (DG2 != null) {
            C27285a.aLz();
            C25052j.m39376p(this, "runtime");
            C26278bw c26278bw = new C26278bw();
            DG = C27285a.m43319DG(this.mAppId);
            if (DG != null) {
                c26278bw.mo44025gz(DG.igT);
                c26278bw.mo44024gA(DG.appId);
                c26278bw.ddd = (long) DG.iDa;
                c26278bw.dej = C26277a.m41732gX(DG.iCZ);
                c26278bw.ddz = (long) DG.apptype;
                c26278bw.cVR = (long) DG.scene;
                C19722s c19722s = (C19722s) super.mo15032xT();
                switch (C33520d.eQZ[C42669a.m75572d(c19722s != null ? c19722s.aBx() : null).ordinal()]) {
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
                c26278bw.dbX = (long) i;
                qualitySessionRuntime = DG;
            } else {
                qualitySessionRuntime = null;
            }
            C33519c.m54745a(qualitySessionRuntime, "Null session with " + this.mAppId);
            if (!((C19722s) super.mo15032xT()).gPH) {
                c26278bw.ddg = 0;
            } else if (DG2.iDj) {
                c26278bw.ddg = 2;
            } else {
                c26278bw.ddg = 1;
            }
            c26278bw.ajK();
        }
        AppMethodBeat.m2505o(129018);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atf() {
        AppMethodBeat.m2504i(129019);
        super.atf();
        m71799nl(11);
        AppMethodBeat.m2505o(129019);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(129021);
        MainProcessTask mainProcessTask = this.gPp;
        mainProcessTask.iEK = C27306a.NOTIFY_PAUSE;
        AppBrandMainProcessService.m54349a(mainProcessTask);
        AppMethodBeat.m2505o(129021);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(129022);
        super.onDestroy();
        if (this.gPt != 0) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.gPt);
            this.gPt = 0;
        }
        if (DebuggerShell.ayT()) {
            if (this.gPv != null) {
                this.gPv.stopTimer();
            }
            C7305d.xDG.execute(new C334622());
            AppBrandPerformanceManager.m43283Dl(this.mAppId);
        }
        C19773a.release(this.mAppId);
        AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ikP;
        appBrandMusicClientService.ikO.clear();
        appBrandMusicClientService.ikQ = "";
        C19600a.m30383AO(this.mAppId);
        C38450n.remove(this.mAppId);
        C45654c.onDestroy();
        C38487d.m65120Dp(this.mAppId);
        MainProcessTask mainProcessTask = this.gPp;
        String str = this.mAppId;
        mainProcessTask.iEK = C27306a.REMOVE;
        mainProcessTask.mAppId = str;
        AppBrandMainProcessService.m54349a(mainProcessTask);
        C38296al c38296al = (C38296al) super.asE();
        if (c38296al != null) {
            C42368m c42368m = (C42368m) c38296al.mo53654ae(C42368m.class);
            if (c42368m != null) {
                C5730e.deleteFile(c42368m.gXQ + "/dir.lock");
            }
            c38296al.release();
        }
        C10048a.m17633a(this);
        if (this.gPq != null) {
            C38498n c38498n = this.gPq;
            try {
                int i;
                C38450n xa = C38450n.m65048xa(c38498n.htn.mAppId);
                c38498n.iBz = C19690c.m30503cV(C4996ah.getContext());
                c38498n.appId = c38498n.htn.mAppId;
                c38498n.axy = c38498n.htn.atH() == null ? ((AppBrandInitConfigWC) super.mo43491ya()).axy : c38498n.htn.atH().hhd.gVu;
                c38498n.css = c38498n.htn.gNB.gVs + 1;
                c38498n.scene = c38498n.htn.mo43491ya().bQn.scene;
                if (c38498n.iCc) {
                    i = 1;
                } else {
                    i = 0;
                }
                c38498n.iCd = i;
                if (xa.gPe.get()) {
                    i = 1;
                } else {
                    i = 0;
                }
                c38498n.iCe = i;
                c38498n.iCf = C5046bo.m7525az(c38498n.iCb);
                c38498n.iCg = C5046bo.anU();
                C4990ab.m7416i("MicroMsg.AppBrand.Report.kv_14576", "report|" + c38498n.toString());
                C7053e.pXa.mo8381e(14576, c38498n.iBz, c38498n.appId, Integer.valueOf(c38498n.axy), Integer.valueOf(c38498n.css), Integer.valueOf(c38498n.scene), c38498n.cvF, Integer.valueOf(c38498n.iCd), Integer.valueOf(c38498n.iCe), Long.valueOf(c38498n.iCf), Long.valueOf(c38498n.iCg));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", e);
            }
        }
        this.gPq = null;
        this.gPw = null;
        AppMethodBeat.m2505o(129022);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atm() {
        AppMethodBeat.m2504i(129023);
        this.gPp.mo73483a(this.mAppId, ((AppBrandInitConfigWC) super.mo43491ya()).gVs, C38519g.m65221c((AppBrandInitConfigWC) super.mo43491ya()));
        AppMethodBeat.m2505o(129023);
    }

    public final boolean atj() {
        AppMethodBeat.m2504i(129024);
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_splashscreen, false)) {
            C4990ab.m7421w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", Boolean.valueOf(getAppConfig().hfe));
            AppMethodBeat.m2505o(129024);
            return getAppConfig().hfe;
        }
        AppMethodBeat.m2505o(129024);
        return false;
    }

    public final C38296al atG() {
        AppMethodBeat.m2504i(139118);
        C38296al c38296al = (C38296al) super.asE();
        AppMethodBeat.m2505o(139118);
        return c38296al;
    }

    /* Access modifiers changed, original: protected|final */
    public final C19092p asZ() {
        AppMethodBeat.m2504i(129026);
        C38296al c38296al = new C38296al(this, C33135d.m54170b(atH()));
        AppMethodBeat.m2505o(129026);
        return c38296al;
    }

    public final AppBrandSysConfigWC atH() {
        AppMethodBeat.m2504i(129027);
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) mo15016c(AppBrandSysConfigWC.class, false);
        AppMethodBeat.m2505o(129027);
        return appBrandSysConfigWC;
    }

    public final AppBrandInitConfigWC atI() {
        AppMethodBeat.m2504i(139119);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
        AppMethodBeat.m2505o(139119);
        return appBrandInitConfigWC;
    }

    public final C45665r atJ() {
        AppMethodBeat.m2504i(139120);
        C45665r c45665r = (C45665r) super.asV();
        AppMethodBeat.m2505o(139120);
        return c45665r;
    }

    public final C19722s atK() {
        AppMethodBeat.m2504i(139121);
        C19722s c19722s = (C19722s) super.mo15032xT();
        AppMethodBeat.m2505o(139121);
        return c19722s;
    }

    /* renamed from: yd */
    public final boolean mo43493yd() {
        AppMethodBeat.m2504i(139122);
        boolean yd = super.mo43493yd();
        AppMethodBeat.m2505o(139122);
        return yd;
    }

    public final MMActivity atM() {
        AppMethodBeat.m2504i(139123);
        MMActivity mMActivity = (MMActivity) super.getContext();
        AppMethodBeat.m2505o(139123);
        return mMActivity;
    }

    /* renamed from: xY */
    public C33491e mo43488xY() {
        return this.gPo;
    }

    /* Access modifiers changed, original: protected */
    public C27333q ata() {
        int i = 1;
        AppMethodBeat.m2504i(129037);
        if (mo65903xy()) {
            int i2;
            C38233e aBD = C38233e.aBD();
            aBD.htG = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_predownload, false) ? 1 : 0;
            C4990ab.m7417i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", Integer.valueOf(aBD.htG));
            AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
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
            if (mo43491ya().bQn != null) {
                aBD.gOW = mo43491ya().bQn.scene;
            }
            if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_splashscreen, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            aBD.htI = i2;
            C4990ab.m7417i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", Integer.valueOf(aBD.htI));
        }
        C27333q a = C38533e.m65259a((MMActivity) super.getContext(), this);
        a.mo22399cz(((AppBrandInitConfigWC) super.mo43491ya()).iconUrl, ((AppBrandInitConfigWC) super.mo43491ya()).cwz);
        if (mo43491ya().bQn.scene != FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
            i = 0;
        }
        if (i != 0) {
            a.aHT();
        }
        AppMethodBeat.m2505o(129037);
        return a;
    }

    private void atN() {
        AppMethodBeat.m2504i(129038);
        C46499v.m87769r(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY, ((AppBrandInitConfigWC) super.mo43491ya()).appId);
        C46499v.m87769r(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, ((AppBrandInitConfigWC) super.mo43491ya()).cwz);
        C46499v.m87769r(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, Boolean.FALSE);
        AppMethodBeat.m2505o(129038);
    }

    /* renamed from: nl */
    private void m71799nl(int i) {
        AppMethodBeat.m2504i(129039);
        int i2 = 369;
        if (mo65903xy()) {
            i2 = 777;
        }
        C7060h.pYm.mo8378a((long) i2, (long) i, 1, false);
        AppMethodBeat.m2505o(129039);
    }

    /* renamed from: yc */
    public final C19789k mo43492yc() {
        AppMethodBeat.m2504i(129040);
        C33486b.m54686n(this);
        List list = ((AppStartupPerformanceReportBundle) mo14986aa(AppStartupPerformanceReportBundle.class)).igV;
        if (!C5046bo.m7548ek(list)) {
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
            AppBrandPerformanceManager.m43289a(this, j);
        }
        if (DebuggerShell.ayT()) {
            AppMethodBeat.m2505o(129040);
            return null;
        }
        C19789k yc = super.mo43492yc();
        AppMethodBeat.m2505o(129040);
        return yc;
    }

    /* renamed from: xy */
    public final boolean mo65903xy() {
        AppMethodBeat.m2504i(129005);
        boolean xy = ((AppBrandInitConfigWC) super.mo43491ya()).mo32992xy();
        AppMethodBeat.m2505o(129005);
        return xy;
    }

    public final boolean atD() {
        AppMethodBeat.m2504i(129006);
        boolean z = ((AppBrandInitConfigWC) super.mo43491ya()).hgJ;
        AppMethodBeat.m2505o(129006);
        return z;
    }

    /* Access modifiers changed, original: protected */
    public C38492q ath() {
        C38492q c42439b;
        AppMethodBeat.m2504i(129011);
        if (!super.mo43493yd()) {
            C38492q a = C27310e.m43370a(this.mAppId, C38519g.m65222eB(mo65903xy()));
            String str;
            if (a == null) {
                String str2 = "MicroMsg.AppBrandRuntimeWC";
                str = "[%s] [preload] createService got no preloaded";
                Object[] objArr = new Object[1];
                objArr[0] = mo65903xy() ? "WAGame" : "WAService";
                C4990ab.m7417i(str2, str, objArr);
                if ((C5058f.IS_FLAVOR_RED || C5058f.DEBUG || DebuggerShell.ayT()) && C19742b.aLG()) {
                    IllegalStateException illegalStateException = new IllegalStateException("[ForcePreload] enabled, but not preload");
                    AppMethodBeat.m2505o(129011);
                    throw illegalStateException;
                } else if (mo65903xy()) {
                    c42439b = new C42439b();
                } else {
                    c42439b = new C19722s();
                }
            } else {
                str = "MicroMsg.AppBrandRuntimeWC";
                String str3 = "[%s] [preload] createService preloaded";
                Object[] objArr2 = new Object[1];
                objArr2[0] = mo65903xy() ? "WAGame" : "WAService";
                C4990ab.m7417i(str, str3, objArr2);
                c42439b = a;
            }
        } else if (mo65903xy()) {
            c42439b = C27310e.m43370a(this.mAppId, C38519g.m65222eB(true));
            if (c42439b == null) {
                c42439b = new C42439b();
            }
        } else {
            c42439b = new C31286r();
        }
        AppMethodBeat.m2505o(129011);
        return c42439b;
    }

    /* Access modifiers changed, original: protected */
    public C38470q ati() {
        C45665r c10244e;
        AppMethodBeat.m2504i(129012);
        try {
            C27285a.m43319DG(this.mAppId).iDk = C5046bo.anU();
        } catch (Throwable th) {
        }
        if (mo65903xy()) {
            c10244e = new C10244e((MMActivity) super.getContext(), this);
        } else {
            c10244e = new C45665r((MMActivity) super.getContext(), this);
        }
        c10244e.setDecorWidgetFactory(new C31330d());
        AppMethodBeat.m2505o(129012);
        return c10244e;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(129013);
        C45613h.m84192a(configuration, this.mAppId);
        AppMethodBeat.m2505o(129013);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atF() {
        AppMethodBeat.m2504i(129016);
        C41243o wI = C10048a.m17635wI(this.mAppId);
        if (!(wI == null || this == wI)) {
            wI.atP();
        }
        this.gPp.mo73481DL(this.mAppId);
        AppMethodBeat.m2505o(129016);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.m2504i(129020);
        C10486i.m18200a(this.mAppId, atc(), mo43491ya().bQn);
        atN();
        MainProcessTask mainProcessTask = this.gPp;
        String str = this.mAppId;
        int i = ((AppBrandInitConfigWC) super.mo43491ya()).gVs;
        mainProcessTask.iEK = C27306a.UPDATE;
        mainProcessTask.mAppId = str;
        mainProcessTask.igj = i;
        AppBrandMainProcessService.m54349a(mainProcessTask);
        if (this.gNQ) {
            ((C45665r) super.asV()).getReporter().aIa();
        }
        C27310e.m43367DJ(this.mAppId);
        m71784a(new C1065016(), atL());
        String str2 = this.mAppId;
        int i2 = mo43491ya().bQn.scene;
        AppBrandIDKeyBatchReport.aKW().izE = 1;
        AppBrandIDKeyBatchReport.aKW().izG = str2;
        AppBrandIDKeyBatchReport.aKW().izH = i2;
        AppBrandMainProcessService.m54349a(AppBrandIDKeyBatchReport.aKW());
        C7305d.post(new C1065117(), "getCopyPathMenuExpireTime");
        AppBrandMainProcessService.m54349a(new AppBrandMainProcessPrepareTask());
        AppMethodBeat.m2505o(129020);
    }

    /* Access modifiers changed, original: protected */
    public C42458a asX() {
        byte b;
        AppMethodBeat.m2504i(129031);
        if (atH() == null || C5046bo.m7548ek(atH().hhd.gVx)) {
            b = (byte) 0;
        } else {
            b = (byte) 1;
        }
        if (b != (byte) 0) {
            C26910h c26910h = new C26910h(this);
            AppMethodBeat.m2505o(129031);
            return c26910h;
        }
        C42458a c42461a = new C42461a(this, (byte) 0);
        AppMethodBeat.m2505o(129031);
        return c42461a;
    }

    private C33131d atL() {
        AppMethodBeat.m2504i(129032);
        C45665r c45665r = (C45665r) super.asV();
        if (c45665r == null) {
            AppMethodBeat.m2505o(129032);
            return null;
        }
        C19640n currentPage = c45665r.getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.m2505o(129032);
            return null;
        }
        C33131d pageConfig = currentPage.getPageConfig();
        AppMethodBeat.m2505o(129032);
        return pageConfig;
    }

    /* renamed from: a */
    private void m71784a(C26836a c26836a, C33131d c33131d) {
        AppMethodBeat.m2504i(129033);
        if (this.mFinished) {
            C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "mFinished is true return,mAppId:%s", this.mAppId);
            AppMethodBeat.m2505o(129033);
            return;
        }
        if (mo65903xy()) {
            c33131d = null;
        }
        C26835a.m42717t((MMActivity) super.getContext()).mo44609a(C26835a.m42707a(getAppConfig(), c33131d), c26836a);
        AppMethodBeat.m2505o(129033);
    }

    /* renamed from: a */
    public final void mo14980a(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(129034);
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
                    appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
                    if (C5046bo.isNullOrNil(appBrandInitConfigWC2.hgC) && C5046bo.isNullOrNil(appBrandInitConfigWC2.bQi) && C5046bo.isNullOrNil(appBrandInitConfigWC.hgC) && C5046bo.isNullOrNil(appBrandInitConfigWC.bQi)) {
                        i = 0;
                    }
                }
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, setWillRelaunch", this.mAppId);
                this.gNQ = true;
                C4990ab.m7410d("MicroMsg.AppBrandRuntime", "setWillRelaunch");
            }
            super.mo14980a(appBrandInitConfig);
            C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], finished[%b], scene[%d]", this.mAppId, Boolean.valueOf(this.gNP), Boolean.valueOf(this.gNQ), Boolean.valueOf(this.mFinished), Integer.valueOf(mo43491ya().bQn.scene));
            if (!(this.gNP || this.mFinished)) {
                C2453g.m4696a(this, true);
                if (((C45665r) super.asV()) != null) {
                    C45665r c45665r = (C45665r) super.asV();
                    c45665r.getReporter().resetSession();
                    c45665r.isk = false;
                    c45665r.isl = false;
                }
                appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
                AppBrandSysConfigWC atH = atH();
                AppBrandStatObject appBrandStatObject2 = mo43491ya().bQn;
                C4990ab.m7417i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", appBrandInitConfigWC.appId, Integer.valueOf(appBrandInitConfigWC.gVs));
                AppBrandMainProcessService.m54349a(new UpdateTask(new LaunchCheckParams(appBrandInitConfigWC, appBrandStatObject2, atH.hhd.gVu, WxaCommLibRuntimeReader.avQ().gVu, appBrandInitConfigWC.mo32993xz(), appBrandInitConfigWC.hgN)));
            }
            AppMethodBeat.m2505o(129034);
            return;
        }
        AppMethodBeat.m2505o(129034);
    }

    public final void atO() {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(129041);
        ConcurrentLinkedDeque concurrentLinkedDeque = this.gNI;
        AppBrandSysConfigWC atH = atH();
        C16597h c16597h = new C16597h();
        c16597h.cwz = atH.cwz;
        c16597h.appId = atH.appId;
        c16597h.hgW = atH.hgW;
        c16597h.hgX = atH.hgX;
        c16597h.hhb = atH.hhb;
        c16597h.hhc = atH.hhc;
        c16597h.hhd = atH.hhd;
        c16597h.hgY = atH.hgY;
        concurrentLinkedDeque.add(c16597h);
        ConcurrentLinkedDeque concurrentLinkedDeque2 = this.gNI;
        AppBrandInitConfigLU ya = mo43491ya();
        AppBrandSysConfigLU xZ = mo43489xZ();
        C38163a appConfig = getAppConfig();
        C38414a c38414a = new C38414a();
        if (ya.bQg || ya.mo32992xy()) {
            z = true;
        } else {
            z = false;
        }
        c38414a.ioe = z;
        int i2 = (xZ.hhd.gVt == 1 || xZ.hhd.gVt == 2) ? 1 : 0;
        z = xZ.bQf ? i2 == 0 || !xZ.bQs : i2 == 0 || !xZ.bQp;
        c38414a.iof = z;
        i2 = C33135d.m54171n(xZ.bQO.hfP.hgs, appConfig.heW.cRx);
        if (i2 > 0) {
            c38414a.iog = i2;
        }
        i2 = C33135d.m54171n(xZ.bQO.hfP.hgp, appConfig.heW.hfj);
        if (i2 > 0) {
            c38414a.ioh = i2;
        }
        i2 = C33135d.m54171n(xZ.bQO.hfP.hgq, appConfig.heW.hfk);
        if (i2 > 0) {
            c38414a.ioi = i2;
        }
        i2 = C33135d.m54171n(xZ.bQO.hfP.hgr, appConfig.heW.hfl);
        if (i2 > 0) {
            c38414a.ioj = i2;
        }
        c38414a.bQw = xZ.bQw;
        c38414a.iok = xZ.bQz;
        c38414a.bQx = xZ.bQx;
        c38414a.bQy = xZ.bQy;
        c38414a.bQF = xZ.bQF;
        c38414a.bQG = xZ.bQG;
        c38414a.bQH = xZ.bQH;
        c38414a.bQI = xZ.bQI;
        c38414a.bQJ = xZ.bQJ;
        if (xZ.bQO.hfP.mode == 1) {
            if (xZ.bQO.hfP.hgn != null) {
                c38414a.iol = xZ.bQO.hfP.hgn;
            }
        } else if (xZ.bQO.hfP.mode == 2 && xZ.bQO.hfP.hgo != null) {
            c38414a.iom = xZ.bQO.hfP.hgo;
        }
        c38414a.mode = xZ.bQO.hfP.mode;
        c38414a.ion = C33135d.m54172s(this);
        if (ya.mo32992xy()) {
            i2 = xZ.bQO.hga;
        } else {
            i2 = xZ.bQO.hfK;
        }
        c38414a.hfK = i2;
        c38414a.bQB = xZ.bQB;
        c38414a.bQC = xZ.bQC;
        c38414a.ioo = C33135d.ayy();
        String str = "";
        if (!(xZ.bQO == null || xZ.bQO.hfP == null)) {
            str = xZ.bQO.hfP.hgt;
        }
        if (C5046bo.isNullOrNil(str)) {
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
        c38414a.referer = stringBuilder.toString();
        c38414a.bQf = ya.bQf;
        c38414a.iop = xZ.hhd.gVt;
        concurrentLinkedDeque2.add(c38414a);
        this.gNI.add(C33135d.m54170b(atH()));
        concurrentLinkedDeque = this.gNI;
        atH = atH();
        C27296a c27296a = new C27296a();
        c27296a.hfX = atH.bQO.hfX;
        concurrentLinkedDeque.add(c27296a);
        concurrentLinkedDeque = this.gNI;
        AppBrandSysConfigLU xZ2 = mo43489xZ();
        C38163a appConfig2 = getAppConfig();
        C38137a c38137a = new C38137a();
        if (C33097a.m54089kR(xZ2.hhd.gVt)) {
            c38137a.gWs = appConfig2.hfb.contains(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        } else {
            c38137a.gWs = xZ2.hgY;
        }
        concurrentLinkedDeque.add(c38137a);
        atH = atH();
        C38483a c38483a = new C38483a();
        if (atH.bQq && atH.hhd.gVt == 1) {
            z = true;
        } else {
            z = false;
        }
        c38483a.ivy = z;
        if (atH.hhd.gVt != 0) {
            z = true;
        } else {
            z = false;
        }
        c38483a.ivz = z;
        c38483a.ivA = atH.bQp;
        c38483a.ivy |= DebuggerShell.ayT();
        z = c38483a.ivz;
        if (C5058f.IS_FLAVOR_RED || C5047bp.dpL()) {
            i = 1;
        }
        c38483a.ivz = z | i;
        this.gNI.add(c38483a);
        AppMethodBeat.m2505o(129041);
    }

    /* renamed from: nm */
    public final void mo6247nm(int i) {
        AppMethodBeat.m2504i(129042);
        C27333q c27333q = this.gNF;
        if (c27333q instanceof C38422j) {
            ((C38422j) c27333q).mo6247nm(i);
        }
        AppMethodBeat.m2505o(129042);
    }

    public final void atP() {
        AppMethodBeat.m2504i(129043);
        this.gNT = false;
        this.gNz.mo44515j(this);
        super.finish();
        if (this.gNz instanceof C19553l) {
            ((C19553l) this.gNz).atC();
        }
        AppMethodBeat.m2505o(129043);
    }

    /* renamed from: ya */
    public final /* bridge */ /* synthetic */ AppBrandInitConfigLU mo43491ya() {
        AppMethodBeat.m2504i(129044);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
        AppMethodBeat.m2505o(129044);
        return appBrandInitConfigWC;
    }

    public final /* bridge */ /* synthetic */ C19092p asE() {
        AppMethodBeat.m2504i(129046);
        C38296al c38296al = (C38296al) super.asE();
        AppMethodBeat.m2505o(129046);
        return c38296al;
    }

    /* renamed from: yf */
    public final /* synthetic */ AppBrandInitConfig mo15035yf() {
        AppMethodBeat.m2504i(129048);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo43491ya();
        AppMethodBeat.m2505o(129048);
        return appBrandInitConfigWC;
    }

    public final /* bridge */ /* synthetic */ Activity getContext() {
        AppMethodBeat.m2504i(129049);
        MMActivity mMActivity = (MMActivity) super.getContext();
        AppMethodBeat.m2505o(129049);
        return mMActivity;
    }

    public final /* bridge */ /* synthetic */ C38470q asV() {
        AppMethodBeat.m2504i(129050);
        C45665r c45665r = (C45665r) super.asV();
        AppMethodBeat.m2505o(129050);
        return c45665r;
    }

    /* renamed from: xT */
    public final /* bridge */ /* synthetic */ C38492q mo15032xT() {
        AppMethodBeat.m2504i(129051);
        C19722s c19722s = (C19722s) super.mo15032xT();
        AppMethodBeat.m2505o(129051);
        return c19722s;
    }

    /* renamed from: b */
    static /* synthetic */ void m71786b(C6764b c6764b) {
        AppMethodBeat.m2504i(129053);
        AppBrandMainProcessService.m54349a(new AppBrandMainProcessPrepareTask());
        c6764b.mo15047wL();
        AppMethodBeat.m2505o(129053);
    }

    /* renamed from: b */
    static /* synthetic */ void m71787b(C41243o c41243o, final C6764b c6764b) {
        AppMethodBeat.m2504i(129055);
        final long currentTimeMillis = System.currentTimeMillis();
        AppBrandPrepareTask appBrandPrepareTask = new AppBrandPrepareTask((MMActivity) super.getContext(), c41243o);
        C10605x c10605x = new C10605x(new C2367b<AppBrandSysConfigWC>() {

            /* renamed from: com.tencent.mm.plugin.appbrand.o$6$2 */
            class C106532 implements Runnable {
                C106532() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(128984);
                    C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "AppBrandPrepareTask done. runOnUiThread appId = %s, finished[%B]", C41243o.this.mAppId, Boolean.valueOf(C41243o.this.mFinished));
                    if (C41243o.this.mFinished) {
                        AppMethodBeat.m2505o(128984);
                        return;
                    }
                    C10282j h = C41243o.this.gPw;
                    if (!h.gOr) {
                        h.mo15047wL();
                    }
                    C41243o.m71791d(C41243o.this, c6764b);
                    C41243o.this.gPq = null;
                    AppMethodBeat.m2505o(128984);
                }
            }

            /* renamed from: a */
            public final /* synthetic */ void mo6256a(AppBrandSysConfigLU appBrandSysConfigLU, final AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle) {
                AppMethodBeat.m2504i(128991);
                AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) appBrandSysConfigLU;
                C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "AppBrandPrepareTask.onPrepareDone appId[%s] type[%d] activityFinishing[%b], runtimeFinishing[%b %b]", C41243o.this.mAppId, Integer.valueOf(C41243o.this.gNB.gVs), Boolean.valueOf(C41243o.this.atM().isFinishing()), Boolean.valueOf(C41243o.this.f1966Pf), Boolean.valueOf(C41243o.this.mFinished));
                if (C41243o.this.atM().isFinishing() || r1 || r2) {
                    AppMethodBeat.m2505o(128991);
                    return;
                }
                C27285a.aLz();
                String str = C41243o.this.mAppId;
                if (appStartupPerformanceReportBundle == null) {
                    C4990ab.m7416i("MicroMsg.AppBrandQualitySystem", "reportAppStartupPerformanceReportBundle, but bundle == null");
                } else {
                    QualitySessionRuntime DG = C27285a.m43319DG(str);
                    if (DG != null) {
                        for (kv_14609 kv_14609 : appStartupPerformanceReportBundle.igV) {
                            kv_14609.igT = DG.igT;
                            kv_14609.mo61202IF();
                        }
                        for (C37827cg c37827cg : appStartupPerformanceReportBundle.igU) {
                            c37827cg.mo60540hc(DG.appId);
                            c37827cg.mo60539hb(DG.igT);
                            c37827cg.dfQ = C26284a.m41748hg(DG.iCZ);
                            c37827cg.ddz = (long) DG.apptype;
                            c37827cg.cVR = (long) DG.scene;
                            c37827cg.ddd = (long) DG.iDa;
                            c37827cg.ajK();
                        }
                    }
                }
                if (appBrandSysConfigWC == null) {
                    C41243o.this.atM().runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(128983);
                            C41243o.this.finish();
                            if (appBrandLaunchErrorAction != null) {
                                AppBrandLaunchErrorAction appBrandLaunchErrorAction = appBrandLaunchErrorAction;
                                Context atM = C41243o.this.atM();
                                if (atM == null || atM.isFinishing()) {
                                    atM = C4996ah.getContext();
                                }
                                appBrandLaunchErrorAction.mo22082cQ(atM);
                                OpenBusinessViewUtil.m30041m(C41243o.this);
                            }
                            AppMethodBeat.m2505o(128983);
                        }
                    });
                    C10486i.m18201b(C41243o.this.mAppId, C41243o.this.atc(), C41243o.this.mo43491ya().bQn);
                    AppMethodBeat.m2505o(128991);
                    return;
                }
                C33135d.m54169a(appBrandSysConfigWC);
                C41243o.this.gNI.add(appBrandSysConfigWC);
                C41243o.this.gNI.add(appStartupPerformanceReportBundle);
                try {
                    C27285a.m43320a(C41243o.this.mAppId, appBrandSysConfigWC, appStartupPerformanceReportBundle, C41243o.this);
                } catch (Throwable th) {
                    C4990ab.m7421w("MicroMsg.AppBrandRuntimeWC", "onPrepareDone [%s] reportResourceReady e = %s", C41243o.this.mAppId, th);
                }
                C41243o.this.gPr.mo73432y(1, System.currentTimeMillis() - currentTimeMillis);
                C33487c.m54688a(C41243o.this.mAppId, "ResourcePrepare", currentTimeMillis, System.currentTimeMillis());
                C41243o.this.mo14982a(C41243o.m71793e(C41243o.this));
                C41243o.this.gNI.add(appBrandSysConfigWC.bQt);
                C41243o.m71794f(C41243o.this);
                C41243o.this.asY();
                C41243o.this.atO();
                C41243o.m71795g(C41243o.this);
                C38410b c38410b = C38410b.ifu;
                MMActivity atM = C41243o.this.atM();
                C41243o c41243o = C41243o.this;
                C4990ab.m7417i("MicroMsg.AppBrandKeepAliveManager", "set up contextUIName:%s", atM.getClass().getName());
                c41243o.gNN.mo21486a(new C384121());
                if (c38410b.ifv != null) {
                    C4990ab.m7416i("MicroMsg.AppBrandKeepAliveManager", "already set up mAppBrandUIClassName");
                } else {
                    c38410b.ifv = atM.getClass().getName();
                }
                C41243o.this.atM().runOnUiThread(new C106532());
                AppMethodBeat.m2505o(128991);
            }

            /* renamed from: nm */
            public final void mo6247nm(int i) {
                AppMethodBeat.m2504i(128986);
                C41243o.this.mo6247nm(i);
                AppMethodBeat.m2505o(128986);
            }

            public final void atT() {
                AppMethodBeat.m2504i(128987);
                if (C41243o.this.mFinished) {
                    AppMethodBeat.m2505o(128987);
                    return;
                }
                C10282j h = C41243o.this.gPw;
                if (h != null) {
                    h.mo21729a(C27317b.SYNC_LAUNCH);
                }
                AppMethodBeat.m2505o(128987);
            }

            /* renamed from: gf */
            public final void mo6259gf(long j) {
                AppMethodBeat.m2504i(128988);
                if (C41243o.this.mFinished) {
                    AppMethodBeat.m2505o(128988);
                    return;
                }
                C41243o.this.gPs = true;
                if (C41243o.this.gPq != null) {
                    C41243o.this.gPq.iCc = true;
                }
                C41243o.m71792dv(C41243o.this.gPs);
                C10282j h = C41243o.this.gPw;
                if (h != null) {
                    h.mo21729a(C27317b.SYNC_GET_CODE);
                }
                AppMethodBeat.m2505o(128988);
            }

            /* renamed from: nn */
            public final void mo6260nn(int i) {
                AppMethodBeat.m2504i(128989);
                C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "appId[%s] onDownloadProgress %d", C41243o.this.mAppId, Integer.valueOf(i));
                C41243o c41243o = C41243o.this;
                c41243o.getContext().runOnUiThread(new C675410(i));
                AppMethodBeat.m2505o(128989);
            }

            /* renamed from: a */
            public final void mo6257a(final C42591a c42591a) {
                AppMethodBeat.m2504i(128990);
                C41243o.this.mo14976A(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(128985);
                        C42591a c42591a = c42591a;
                        C19722s atK = C41243o.this.atK();
                        C4990ab.m7417i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), service %s", c42591a.hYi, atK);
                        if (atK == null) {
                            AppMethodBeat.m2505o(128985);
                            return;
                        }
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("state", c42591a.hYi);
                        new C41236a().mo61031i(atK).mo34958t(hashMap).aCj();
                        AppMethodBeat.m2505o(128985);
                    }
                });
                AppMethodBeat.m2505o(128990);
            }
        });
        c41243o.keep(c10605x);
        appBrandPrepareTask.ifT = c10605x;
        appBrandPrepareTask.aHd();
        AppMethodBeat.m2505o(129055);
    }

    /* renamed from: c */
    static /* synthetic */ void m71789c(C41243o c41243o, final C6764b c6764b) {
        AppMethodBeat.m2504i(129056);
        C4990ab.m7417i("MicroMsg.AppBrandRuntimeWC", "startPrepareResource. Preloader shouldWait?[%b]", Boolean.valueOf(C27310e.m43374a(C38519g.m65222eB(c41243o.mo65903xy()), new C27314a() {
            public final void onReady() {
                AppMethodBeat.m2504i(128981);
                if (C41243o.this.mFinished) {
                    AppMethodBeat.m2505o(128981);
                    return;
                }
                AppBrandPreloadProfiler aLP = C27310e.aLP();
                if (aLP != null) {
                    C27285a.aLz();
                    C38501b.m65162a(C41243o.this.mAppId, aLP);
                }
                c6764b.mo15047wL();
                AppMethodBeat.m2505o(128981);
            }
        })));
        if (!C27310e.m43374a(C38519g.m65222eB(c41243o.mo65903xy()), /* anonymous class already generated */)) {
            AppBrandPreloadProfiler aLP = C27310e.aLP();
            if (aLP != null) {
                C27285a.aLz();
                C38501b.m65162a(c41243o.mAppId, aLP);
            }
            c6764b.mo15047wL();
        }
        AppMethodBeat.m2505o(129056);
    }

    /* renamed from: e */
    static /* synthetic */ C38163a m71793e(C41243o c41243o) {
        AppMethodBeat.m2504i(129057);
        String a = C33082aw.m54068a((C6750i) c41243o, "/app-config.json");
        if (C5046bo.isNullOrNil(a)) {
            Iterator it = c41243o.atH().hhd.gVx.iterator();
            while (true) {
                String str = a;
                if (!it.hasNext()) {
                    a = str;
                    break;
                }
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (modulePkgInfo.cta) {
                    a = C33082aw.m54068a((C6750i) c41243o, modulePkgInfo.name + (modulePkgInfo.name.endsWith("/") ? "" : "/") + "app-config.json");
                    if (!C5046bo.isNullOrNil(a)) {
                        break;
                    }
                } else {
                    a = str;
                }
            }
        }
        C38163a yT = C38163a.m64596yT(a);
        if (c41243o.mo65903xy()) {
            yT.heS.hfv = "custom";
        } else {
            yT.heX.hfh = ((AppBrandInitConfigWC) super.mo43491ya()).hfh;
            yT.heX.hfi = true;
        }
        AppMethodBeat.m2505o(129057);
        return yT;
    }

    /* renamed from: f */
    static /* synthetic */ void m71794f(C41243o c41243o) {
        AppMethodBeat.m2504i(129058);
        c41243o.gPo = new C42656l(c41243o);
        C4990ab.m7417i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "register runtime(%s %d), finished %b", c41243o.mAppId, Integer.valueOf(c41243o.gNB.gVs), Boolean.valueOf(c41243o.mFinished));
        if (!c41243o.mFinished) {
            C105761 c105761 = new C105761(c41243o);
            MMToClientEvent.m75199a(c41243o.mAppId, c105761);
            c41243o.gNN.mo21486a(new C23742(c41243o, c105761));
        }
        AppMethodBeat.m2505o(129058);
    }

    /* renamed from: g */
    static /* synthetic */ void m71795g(C41243o c41243o) {
        AppMethodBeat.m2504i(129059);
        if (c41243o.mo65903xy()) {
            C45564d aBz = C45564d.aBz();
            aBz.htn = c41243o;
            aBz.htp = (C38414a) c41243o.mo14986aa(C38414a.class);
            aBz.htq = (C38296al) super.asE();
            aBz.htr = new C38231c(c41243o);
            C38231c c38231c = aBz.htr;
            c38231c.htl.addAll(c41243o.gNI);
            aBz.hto = new C19548m(aBz.htr);
            aBz.hasInit = true;
            aBz.htt = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_predownload, false);
            aBz.htu = new AtomicInteger(0);
            aBz.htv = new AtomicInteger(0);
            aBz.htw = new AtomicInteger(0);
            aBz.htx = new AtomicInteger(0);
            C26006a.post(new C272135());
        }
        AppMethodBeat.m2505o(129059);
    }

    /* renamed from: d */
    static /* synthetic */ void m71791d(C41243o c41243o, final C6764b c6764b) {
        AppMethodBeat.m2504i(129060);
        if (c41243o.mo65903xy()) {
            boolean u = C42696n.m75624u((MMActivity) super.getContext());
            if (c41243o.mo65903xy() && u) {
                Toast makeText = Toast.makeText((MMActivity) super.getContext(), C25738R.string.f9281vc, 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
                ((MMActivity) super.getContext()).finish();
                AppMethodBeat.m2505o(129060);
                return;
            }
            c41243o.m71784a(new C26836a() {
                /* renamed from: a */
                public final void mo3966a(C26839b c26839b, boolean z) {
                    AppMethodBeat.m2504i(128992);
                    C4990ab.m7416i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntime.onOrientationChanged");
                    if (!z) {
                        String str;
                        String str2 = "MicroMsg.AppBrandRuntimeWC";
                        String str3 = "OnOrientationChanged failure  ret:[%s]";
                        Object[] objArr = new Object[1];
                        if (c26839b == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = c26839b.name();
                        }
                        objArr[0] = str;
                        C4990ab.m7415f(str2, str3, objArr);
                    }
                    c6764b.mo15047wL();
                    AppMethodBeat.m2505o(128992);
                }
            }, c41243o.atL());
            AppMethodBeat.m2505o(129060);
            return;
        }
        c6764b.mo15047wL();
        AppMethodBeat.m2505o(129060);
    }

    /* renamed from: dv */
    static /* synthetic */ void m71792dv(boolean z) {
        AppMethodBeat.m2504i(129061);
        C45564d.aBz();
        C45564d.m84057dQ(z);
        AppMethodBeat.m2505o(129061);
    }

    static {
        AppMethodBeat.m2504i(129062);
        C19253b.inO = new C426061();
        C45666t.m84357ev(((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_android_appbrand_page_reload_eanble, true));
        AppMethodBeat.m2505o(129062);
    }
}
