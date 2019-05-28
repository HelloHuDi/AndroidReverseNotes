package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.ui.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager {
    protected static final SparseArray<a> ivB = new SparseArray();

    static class SetAppPerformanceModeTask extends MainProcessTask {
        public static final Creator<SetAppPerformanceModeTask> CREATOR = new Creator<SetAppPerformanceModeTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAppPerformanceModeTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(102224);
                SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
                setAppPerformanceModeTask.g(parcel);
                AppMethodBeat.o(102224);
                return setAppPerformanceModeTask;
            }
        };
        private String mAppId;
        private boolean mEnable;

        private SetAppPerformanceModeTask() {
        }

        /* synthetic */ SetAppPerformanceModeTask(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.i(102225);
            ((b) e.B(b.class)).xH().bG(this.mAppId + "_PerformancePanelEnabled", this.mEnable ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AppMethodBeat.o(102225);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(102226);
            this.mAppId = parcel.readString();
            this.mEnable = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(102226);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(102227);
            parcel.writeString(this.mAppId);
            parcel.writeByte(this.mEnable ? (byte) 1 : (byte) 0);
            AppMethodBeat.o(102227);
        }

        static {
            AppMethodBeat.i(102228);
            AppMethodBeat.o(102228);
        }
    }

    protected static class a implements Runnable {
        private volatile boolean OH = true;
        protected final com.tencent.luggage.sdk.b.b ivC;
        private volatile double ivD = 0.0d;
        private volatile int ivE = 4;
        private volatile boolean ivF = false;
        protected volatile boolean ivG = false;
        private e ivH;
        f ivI;
        com.tencent.mm.plugin.appbrand.performance.f.a ivJ = new com.tencent.mm.plugin.appbrand.performance.f.a() {
            public final void v(double d) {
                AppMethodBeat.i(102215);
                if (Math.round(a.this.ivD) != Math.round(d)) {
                    a.this.ivD = d;
                    AppBrandPerformanceManager.a(a.this.ivC, 303, Math.round(a.this.ivD) + " fps");
                    c.a(a.this.mAppId, "Hardware", "FPS", a.this.ivD);
                }
                AppMethodBeat.o(102215);
            }
        };
        private c ivK = new c() {
            public final void onDestroy() {
                AppMethodBeat.i(102216);
                super.onDestroy();
                a.this.stop();
                AppMethodBeat.o(102216);
            }

            public final void a(d dVar) {
                AppMethodBeat.i(102217);
                super.a(dVar);
                a aVar = a.this;
                aVar.mPaused = true;
                if (a.aKj() && aVar.ivI != null) {
                    aVar.ivI.stop();
                }
                AppMethodBeat.o(102217);
            }

            public final void onResume() {
                AppMethodBeat.i(102218);
                super.onResume();
                a aVar = a.this;
                aVar.mPaused = false;
                if (a.aKj() && aVar.ivI != null) {
                    aVar.ivI.start();
                }
                AppMethodBeat.o(102218);
            }
        };
        protected final String mAppId;
        volatile boolean mPaused = false;

        public a(com.tencent.luggage.sdk.b.b bVar) {
            AppMethodBeat.i(102219);
            this.ivC = bVar;
            this.mAppId = bVar.mAppId;
            this.ivH = new e(Process.myPid());
            this.ivG = false;
            if (aKj()) {
                this.ivI = new f();
                this.ivI.mInterval = 100;
                this.ivI.ivJ = this.ivJ;
            }
            AppMethodBeat.o(102219);
        }

        public final void start() {
            AppMethodBeat.i(102220);
            this.OH = true;
            m.aNS().aa(this);
            g.a(this.mAppId, this.ivK);
            if (aKj() && this.ivI != null) {
                this.ivI.start();
            }
            AppMethodBeat.o(102220);
        }

        public final void stop() {
            AppMethodBeat.i(102221);
            this.OH = false;
            g.b(this.mAppId, this.ivK);
            if (aKj() && this.ivI != null) {
                this.ivI.stop();
            }
            AppMethodBeat.o(102221);
        }

        static boolean aKj() {
            return VERSION.SDK_INT >= 16;
        }

        /* Access modifiers changed, original: protected */
        public void aKk() {
            AppMethodBeat.i(102222);
            int gX = bo.gX(ah.getContext());
            AppBrandPerformanceManager.a(this.ivC, 102, gX + "m");
            c.a(this.mAppId, "Hardware", "MEMORY", (double) gX);
            AppMethodBeat.o(102222);
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
            AppMethodBeat.i(102223);
            if (this.ivC.mFinished) {
                AppMethodBeat.o(102223);
                return;
            }
            if (this.OH && !this.mPaused) {
                double aKs = this.ivH.aKs();
                AppBrandPerformanceManager.a(this.ivC, 101, ((int) aKs) + "%");
                c.a(this.mAppId, "Hardware", "CPU", aKs);
                aKk();
                aKl();
                aKm();
                aKn();
                aKo();
                aKp();
                this.ivE++;
                if (this.ivE >= 4) {
                    this.ivE = 0;
                    AppBrandSysConfigLU xZ = this.ivC.xZ();
                    if (xZ != null) {
                        if (xZ.hhe == 1) {
                            final MainProcessTask getStorageSizeTask = new GetStorageSizeTask();
                            getStorageSizeTask.appId = this.mAppId;
                            getStorageSizeTask.hww = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(102214);
                                    AppBrandPerformanceManager.a(a.this.ivC, 401, bo.ga((long) getStorageSizeTask.size));
                                    getStorageSizeTask.aBW();
                                    AppMethodBeat.o(102214);
                                }
                            };
                            getStorageSizeTask.aBV();
                            AppBrandMainProcessService.a(getStorageSizeTask);
                        } else {
                            com.tencent.luggage.sdk.b.b bVar = this.ivC;
                            f fVar = f.gXv;
                            AppBrandPerformanceManager.a(bVar, 401, bo.ga((long) f.xT(this.mAppId)));
                        }
                    }
                }
            }
            if (this.OH) {
                m.aNS().m(this, 3000);
            }
            AppMethodBeat.o(102223);
        }
    }

    static {
        AppMethodBeat.i(102241);
        AppMethodBeat.o(102241);
    }

    public static void Dl(String str) {
        AppMethodBeat.i(102230);
        ab.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", str);
        int hashCode = str.hashCode();
        a aVar = (a) ivB.get(hashCode);
        if (aVar != null) {
            ivB.remove(hashCode);
            aVar.stop();
        }
        AppMethodBeat.o(102230);
    }

    public static void Dm(String str) {
        AppMethodBeat.i(102231);
        ab.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", str);
        MainProcessTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = true;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
        AppMethodBeat.o(102231);
    }

    public static void Dn(String str) {
        AppMethodBeat.i(102232);
        ab.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", str);
        MainProcessTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = false;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
        AppMethodBeat.o(102232);
    }

    public static boolean b(com.tencent.luggage.sdk.b.b bVar) {
        AppMethodBeat.i(102233);
        a aVar = (a) bVar.aa(a.class);
        if (aVar == null || !aVar.ivy) {
            AppMethodBeat.o(102233);
            return false;
        }
        AppMethodBeat.o(102233);
        return true;
    }

    public static void a(com.tencent.luggage.sdk.b.b bVar, int i, long j) {
        AppMethodBeat.i(102234);
        a(bVar, i, String.format("%d ms", new Object[]{Long.valueOf(j)}));
        AppMethodBeat.o(102234);
    }

    public static void a(com.tencent.luggage.sdk.b.b bVar, long j) {
        AppMethodBeat.i(102239);
        a(bVar, 201, j);
        AppMethodBeat.o(102239);
    }

    public static boolean e(com.tencent.luggage.sdk.b.b bVar) {
        AppMethodBeat.i(102240);
        if (b(bVar)) {
            boolean Do = c.Do(bVar.mAppId);
            AppMethodBeat.o(102240);
            return Do;
        }
        AppMethodBeat.o(102240);
        return false;
    }

    public static void a(com.tencent.luggage.sdk.b.b bVar) {
        AppMethodBeat.i(102229);
        String str = bVar.mAppId;
        ab.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", str);
        a aVar = (a) ivB.get(str.hashCode());
        if (aVar == null) {
            aVar = new a(bVar);
            ivB.put(str.hashCode(), aVar);
        }
        aVar.start();
        AppMethodBeat.o(102229);
    }

    public static void a(com.tencent.luggage.sdk.b.b bVar, int i, String str) {
        AppMethodBeat.i(102235);
        String str2 = bVar.mAppId;
        k kVar = bVar.bRn;
        if (kVar == null) {
            v.Zp().y(str2.hashCode() + "performance_data", true).j(String.valueOf(i), str);
            AppMethodBeat.o(102235);
            return;
        }
        kVar.ae(i, str);
        AppMethodBeat.o(102235);
    }

    public static void a(com.tencent.luggage.sdk.b.b bVar, String str, String str2) {
        AppMethodBeat.i(102236);
        String str3 = bVar.mAppId;
        k kVar = bVar.bRn;
        if (kVar == null) {
            v.Zp().y(str3.hashCode() + "performance_custom_data", true).j(str, str2);
            AppMethodBeat.o(102236);
            return;
        }
        kVar.cP(str, str2);
        AppMethodBeat.o(102236);
    }

    public static void c(com.tencent.luggage.sdk.b.b bVar) {
        AppMethodBeat.i(102237);
        String str = bVar.mAppId;
        k kVar = bVar.bRn;
        v.b nV = v.Zp().nV(str.hashCode() + "performance_data");
        if (kVar == null) {
            ab.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
        } else if (nV == null) {
            ab.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
        } else {
            for (String str2 : nV.getKeySet()) {
                String str3 = (String) nV.get(str2);
                if (str3 != null) {
                    kVar.ae(Integer.valueOf(str2).intValue(), str3);
                }
            }
        }
        d(bVar);
        AppMethodBeat.o(102237);
    }

    private static void d(com.tencent.luggage.sdk.b.b bVar) {
        AppMethodBeat.i(102238);
        String str = bVar.mAppId;
        k kVar = bVar.bRn;
        v.b nV = v.Zp().nV(str.hashCode() + "performance_custom_data");
        if (kVar == null) {
            ab.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
            AppMethodBeat.o(102238);
        } else if (nV == null) {
            ab.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
            AppMethodBeat.o(102238);
        } else {
            for (String str2 : nV.getKeySet()) {
                String str3 = (String) nV.get(str2);
                if (str3 != null) {
                    kVar.cP(str2, str3);
                }
            }
            AppMethodBeat.o(102238);
        }
    }
}
