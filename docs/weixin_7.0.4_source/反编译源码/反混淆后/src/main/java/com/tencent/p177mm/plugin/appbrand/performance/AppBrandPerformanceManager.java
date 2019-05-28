package com.tencent.p177mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p336ui.C19789k;
import com.tencent.p177mm.plugin.appbrand.performance.C27258f.C27259a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager */
public class AppBrandPerformanceManager {
    protected static final SparseArray<C27255a> ivB = new SparseArray();

    /* renamed from: com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager$SetAppPerformanceModeTask */
    static class SetAppPerformanceModeTask extends MainProcessTask {
        public static final Creator<SetAppPerformanceModeTask> CREATOR = new C272531();
        private String mAppId;
        private boolean mEnable;

        /* renamed from: com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager$SetAppPerformanceModeTask$1 */
        static class C272531 implements Creator<SetAppPerformanceModeTask> {
            C272531() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAppPerformanceModeTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(102224);
                SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
                setAppPerformanceModeTask.mo6032g(parcel);
                AppMethodBeat.m2505o(102224);
                return setAppPerformanceModeTask;
            }
        }

        private SetAppPerformanceModeTask() {
        }

        /* synthetic */ SetAppPerformanceModeTask(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.m2504i(102225);
            ((C0997b) C37384e.m62985B(C0997b.class)).mo3976xH().mo53682bG(this.mAppId + "_PerformancePanelEnabled", this.mEnable ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AppMethodBeat.m2505o(102225);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(102226);
            this.mAppId = parcel.readString();
            this.mEnable = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(102226);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(102227);
            parcel.writeString(this.mAppId);
            parcel.writeByte(this.mEnable ? (byte) 1 : (byte) 0);
            AppMethodBeat.m2505o(102227);
        }

        static {
            AppMethodBeat.m2504i(102228);
            AppMethodBeat.m2505o(102228);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager$a */
    protected static class C27255a implements Runnable {
        /* renamed from: OH */
        private volatile boolean f13678OH = true;
        protected final C25697b ivC;
        private volatile double ivD = 0.0d;
        private volatile int ivE = 4;
        private volatile boolean ivF = false;
        protected volatile boolean ivG = false;
        private C10681e ivH;
        C27258f ivI;
        C27259a ivJ = new C272542();
        private C33186c ivK = new C24273();
        protected final String mAppId;
        volatile boolean mPaused = false;

        /* renamed from: com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager$a$3 */
        class C24273 extends C33186c {
            C24273() {
            }

            public final void onDestroy() {
                AppMethodBeat.m2504i(102216);
                super.onDestroy();
                C27255a.this.stop();
                AppMethodBeat.m2505o(102216);
            }

            /* renamed from: a */
            public final void mo6074a(C33184d c33184d) {
                AppMethodBeat.m2504i(102217);
                super.mo6074a(c33184d);
                C27255a c27255a = C27255a.this;
                c27255a.mPaused = true;
                if (C27255a.aKj() && c27255a.ivI != null) {
                    c27255a.ivI.stop();
                }
                AppMethodBeat.m2505o(102217);
            }

            public final void onResume() {
                AppMethodBeat.m2504i(102218);
                super.onResume();
                C27255a c27255a = C27255a.this;
                c27255a.mPaused = false;
                if (C27255a.aKj() && c27255a.ivI != null) {
                    c27255a.ivI.start();
                }
                AppMethodBeat.m2505o(102218);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager$a$2 */
        class C272542 implements C27259a {
            C272542() {
            }

            /* renamed from: v */
            public final void mo44934v(double d) {
                AppMethodBeat.m2504i(102215);
                if (Math.round(C27255a.this.ivD) != Math.round(d)) {
                    C27255a.this.ivD = d;
                    AppBrandPerformanceManager.m43288a(C27255a.this.ivC, 303, Math.round(C27255a.this.ivD) + " fps");
                    C33487c.m54689a(C27255a.this.mAppId, "Hardware", "FPS", C27255a.this.ivD);
                }
                AppMethodBeat.m2505o(102215);
            }
        }

        public C27255a(C25697b c25697b) {
            AppMethodBeat.m2504i(102219);
            this.ivC = c25697b;
            this.mAppId = c25697b.mAppId;
            this.ivH = new C10681e(Process.myPid());
            this.ivG = false;
            if (C27255a.aKj()) {
                this.ivI = new C27258f();
                this.ivI.mInterval = 100;
                this.ivI.ivJ = this.ivJ;
            }
            AppMethodBeat.m2505o(102219);
        }

        public final void start() {
            AppMethodBeat.m2504i(102220);
            this.f13678OH = true;
            C45673m.aNS().mo10302aa(this);
            C33183g.m54274a(this.mAppId, this.ivK);
            if (C27255a.aKj() && this.ivI != null) {
                this.ivI.start();
            }
            AppMethodBeat.m2505o(102220);
        }

        public final void stop() {
            AppMethodBeat.m2504i(102221);
            this.f13678OH = false;
            C33183g.m54276b(this.mAppId, this.ivK);
            if (C27255a.aKj() && this.ivI != null) {
                this.ivI.stop();
            }
            AppMethodBeat.m2505o(102221);
        }

        static boolean aKj() {
            return VERSION.SDK_INT >= 16;
        }

        /* Access modifiers changed, original: protected */
        public void aKk() {
            AppMethodBeat.m2504i(102222);
            int gX = C5046bo.m7564gX(C4996ah.getContext());
            AppBrandPerformanceManager.m43288a(this.ivC, 102, gX + "m");
            C33487c.m54689a(this.mAppId, "Hardware", "MEMORY", (double) gX);
            AppMethodBeat.m2505o(102222);
        }

        /* Access modifiers changed, original: protected */
        public void aKl() {
            if (!this.ivG) {
            }
        }

        /* Access modifiers changed, original: protected */
        public void aKm() {
            if (!this.ivG) {
            }
        }

        /* Access modifiers changed, original: protected */
        public void aKn() {
        }

        /* Access modifiers changed, original: protected */
        public void aKo() {
        }

        /* Access modifiers changed, original: protected */
        public void aKp() {
        }

        public void run() {
            AppMethodBeat.m2504i(102223);
            if (this.ivC.mFinished) {
                AppMethodBeat.m2505o(102223);
                return;
            }
            if (this.f13678OH && !this.mPaused) {
                double aKs = this.ivH.aKs();
                AppBrandPerformanceManager.m43288a(this.ivC, 101, ((int) aKs) + "%");
                C33487c.m54689a(this.mAppId, "Hardware", "CPU", aKs);
                aKk();
                aKl();
                aKm();
                aKn();
                aKo();
                aKp();
                this.ivE++;
                if (this.ivE >= 4) {
                    this.ivE = 0;
                    AppBrandSysConfigLU xZ = this.ivC.mo43489xZ();
                    if (xZ != null) {
                        if (xZ.hhe == 1) {
                            final MainProcessTask getStorageSizeTask = new GetStorageSizeTask();
                            getStorageSizeTask.appId = this.mAppId;
                            getStorageSizeTask.hww = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(102214);
                                    AppBrandPerformanceManager.m43288a(C27255a.this.ivC, 401, C5046bo.m7565ga((long) getStorageSizeTask.size));
                                    getStorageSizeTask.aBW();
                                    AppMethodBeat.m2505o(102214);
                                }
                            };
                            getStorageSizeTask.aBV();
                            AppBrandMainProcessService.m54349a(getStorageSizeTask);
                        } else {
                            C25697b c25697b = this.ivC;
                            C19085f c19085f = C19085f.gXv;
                            AppBrandPerformanceManager.m43288a(c25697b, 401, C5046bo.m7565ga((long) C19085f.m29671xT(this.mAppId)));
                        }
                    }
                }
            }
            if (this.f13678OH) {
                C45673m.aNS().mo10310m(this, 3000);
            }
            AppMethodBeat.m2505o(102223);
        }
    }

    static {
        AppMethodBeat.m2504i(102241);
        AppMethodBeat.m2505o(102241);
    }

    /* renamed from: Dl */
    public static void m43283Dl(String str) {
        AppMethodBeat.m2504i(102230);
        C4990ab.m7411d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", str);
        int hashCode = str.hashCode();
        C27255a c27255a = (C27255a) ivB.get(hashCode);
        if (c27255a != null) {
            ivB.remove(hashCode);
            c27255a.stop();
        }
        AppMethodBeat.m2505o(102230);
    }

    /* renamed from: Dm */
    public static void m43284Dm(String str) {
        AppMethodBeat.m2504i(102231);
        C4990ab.m7411d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", str);
        MainProcessTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = true;
        AppBrandMainProcessService.m54349a(setAppPerformanceModeTask);
        AppMethodBeat.m2505o(102231);
    }

    /* renamed from: Dn */
    public static void m43285Dn(String str) {
        AppMethodBeat.m2504i(102232);
        C4990ab.m7411d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", str);
        MainProcessTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = false;
        AppBrandMainProcessService.m54349a(setAppPerformanceModeTask);
        AppMethodBeat.m2505o(102232);
    }

    /* renamed from: b */
    public static boolean m43291b(C25697b c25697b) {
        AppMethodBeat.m2504i(102233);
        C38483a c38483a = (C38483a) c25697b.mo14986aa(C38483a.class);
        if (c38483a == null || !c38483a.ivy) {
            AppMethodBeat.m2505o(102233);
            return false;
        }
        AppMethodBeat.m2505o(102233);
        return true;
    }

    /* renamed from: a */
    public static void m43287a(C25697b c25697b, int i, long j) {
        AppMethodBeat.m2504i(102234);
        AppBrandPerformanceManager.m43288a(c25697b, i, String.format("%d ms", new Object[]{Long.valueOf(j)}));
        AppMethodBeat.m2505o(102234);
    }

    /* renamed from: a */
    public static void m43289a(C25697b c25697b, long j) {
        AppMethodBeat.m2504i(102239);
        AppBrandPerformanceManager.m43287a(c25697b, 201, j);
        AppMethodBeat.m2505o(102239);
    }

    /* renamed from: e */
    public static boolean m43294e(C25697b c25697b) {
        AppMethodBeat.m2504i(102240);
        if (AppBrandPerformanceManager.m43291b(c25697b)) {
            boolean Do = C33487c.m54687Do(c25697b.mAppId);
            AppMethodBeat.m2505o(102240);
            return Do;
        }
        AppMethodBeat.m2505o(102240);
        return false;
    }

    /* renamed from: a */
    public static void m43286a(C25697b c25697b) {
        AppMethodBeat.m2504i(102229);
        String str = c25697b.mAppId;
        C4990ab.m7411d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", str);
        C27255a c27255a = (C27255a) ivB.get(str.hashCode());
        if (c27255a == null) {
            c27255a = new C27255a(c25697b);
            ivB.put(str.hashCode(), c27255a);
        }
        c27255a.start();
        AppMethodBeat.m2505o(102229);
    }

    /* renamed from: a */
    public static void m43288a(C25697b c25697b, int i, String str) {
        AppMethodBeat.m2504i(102235);
        String str2 = c25697b.mAppId;
        C19789k c19789k = c25697b.bRn;
        if (c19789k == null) {
            C37922v.m64076Zp().mo60676y(str2.hashCode() + "performance_data", true).mo53356j(String.valueOf(i), str);
            AppMethodBeat.m2505o(102235);
            return;
        }
        c19789k.mo35017ae(i, str);
        AppMethodBeat.m2505o(102235);
    }

    /* renamed from: a */
    public static void m43290a(C25697b c25697b, String str, String str2) {
        AppMethodBeat.m2504i(102236);
        String str3 = c25697b.mAppId;
        C19789k c19789k = c25697b.bRn;
        if (c19789k == null) {
            C37922v.m64076Zp().mo60676y(str3.hashCode() + "performance_custom_data", true).mo53356j(str, str2);
            AppMethodBeat.m2505o(102236);
            return;
        }
        c19789k.mo35018cP(str, str2);
        AppMethodBeat.m2505o(102236);
    }

    /* renamed from: c */
    public static void m43292c(C25697b c25697b) {
        AppMethodBeat.m2504i(102237);
        String str = c25697b.mAppId;
        C19789k c19789k = c25697b.bRn;
        C32800b nV = C37922v.m64076Zp().mo60674nV(str.hashCode() + "performance_data");
        if (c19789k == null) {
            C4990ab.m7412e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
        } else if (nV == null) {
            C4990ab.m7410d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
        } else {
            for (String str2 : nV.getKeySet()) {
                String str3 = (String) nV.get(str2);
                if (str3 != null) {
                    c19789k.mo35017ae(Integer.valueOf(str2).intValue(), str3);
                }
            }
        }
        AppBrandPerformanceManager.m43293d(c25697b);
        AppMethodBeat.m2505o(102237);
    }

    /* renamed from: d */
    private static void m43293d(C25697b c25697b) {
        AppMethodBeat.m2504i(102238);
        String str = c25697b.mAppId;
        C19789k c19789k = c25697b.bRn;
        C32800b nV = C37922v.m64076Zp().mo60674nV(str.hashCode() + "performance_custom_data");
        if (c19789k == null) {
            C4990ab.m7412e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
            AppMethodBeat.m2505o(102238);
        } else if (nV == null) {
            C4990ab.m7410d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
            AppMethodBeat.m2505o(102238);
        } else {
            for (String str2 : nV.getKeySet()) {
                String str3 = (String) nV.get(str2);
                if (str3 != null) {
                    c19789k.mo35018cP(str2, str3);
                }
            }
            AppMethodBeat.m2505o(102238);
        }
    }
}
