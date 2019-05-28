package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.widget.Toast;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.h.z;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class AppBrandPrepareTask {
    boolean hrs;
    PrepareParams ifS = new PrepareParams();
    public volatile transient b<AppBrandSysConfigWC> ifT;
    volatile transient WeakReference<Activity> ifU;

    static final class a implements com.tencent.mm.ipcinvoker.a<PrepareParams, PrepareResult> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(131748);
            final PrepareParams prepareParams = (PrepareParams) obj;
            if (prepareParams == null) {
                ab.w("MicroMsg.AppBrandPrepareTask", "PrepareCall invoke NULL input");
                if (cVar != null) {
                    PrepareResult prepareResult = new PrepareResult();
                    prepareResult.igp = 2;
                    prepareResult.igr = null;
                    prepareResult.igq = null;
                    prepareResult.igs = null;
                    cVar.ao(prepareResult);
                }
                AppMethodBeat.o(131748);
                return;
            }
            String c = prepareParams.igi;
            String a = prepareParams.mAppId;
            int b = prepareParams.igj;
            int d = prepareParams.gqq;
            String e = prepareParams.igh;
            final c cVar2 = cVar;
            final PrepareParams prepareParams2 = prepareParams;
            AnonymousClass1 anonymousClass1 = new b() {
                public final void aHe() {
                    AppMethodBeat.i(131737);
                    if (cVar2 != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igp = 1;
                        prepareResult.igu = bo.anU();
                        cVar2.ao(prepareResult);
                    }
                    AppMethodBeat.o(131737);
                }

                public final void onDownloadProgress(int i) {
                    AppMethodBeat.i(131738);
                    if (cVar2 != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igt = i;
                        prepareResult.igp = 4;
                        cVar2.ao(prepareResult);
                    }
                    AppMethodBeat.o(131738);
                }

                public final void atT() {
                    AppMethodBeat.i(131739);
                    if (cVar2 != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igp = 6;
                        cVar2.ao(prepareResult);
                    }
                    AppMethodBeat.o(131739);
                }

                public final void a(AppBrandSysConfigWC appBrandSysConfigWC, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle) {
                    AppMethodBeat.i(131740);
                    if (cVar2 != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igp = 2;
                        prepareResult.igr = appBrandSysConfigWC;
                        prepareResult.igq = appBrandLaunchErrorAction;
                        prepareResult.igs = appStartupPerformanceReportBundle;
                        cVar2.ao(prepareResult);
                        if (appBrandSysConfigWC != null) {
                            AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.launching.i.a() {
                                public final void b(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar) {
                                    AppMethodBeat.i(131736);
                                    ab.i("MicroMsg.AppBrandPrepareTask", "[appversion] dispatch %s, %s", prepareParams2.mAppId, aVar);
                                    PrepareResult prepareResult = new PrepareResult();
                                    prepareResult.igp = 5;
                                    prepareResult.igv = aVar;
                                    cVar2.ao(prepareResult);
                                    AppMethodBeat.o(131736);
                                }
                            };
                            if (prepareParams2.ign) {
                                anonymousClass1.b(com.tencent.mm.plugin.appbrand.jsapi.version.a.NO_UPDATE);
                            } else {
                                i iVar = new i(prepareParams2.igi, prepareParams2.gqq, anonymousClass1, prepareParams2.igo);
                                if (iVar.igX != null) {
                                    d.post(new com.tencent.mm.plugin.appbrand.launching.i.AnonymousClass1(iVar), "MicroMsg.AppBrand.Launching.ContactSilentSyncProcess");
                                    AppMethodBeat.o(131740);
                                    return;
                                }
                            }
                            AppMethodBeat.o(131740);
                            return;
                        }
                        r.zu(p.zo(prepareParams2.mAppId));
                    }
                    AppMethodBeat.o(131740);
                }

                public final void nm(int i) {
                    AppMethodBeat.i(131741);
                    PrepareResult prepareResult = new PrepareResult();
                    prepareResult.igp = 7;
                    prepareResult.igw = i;
                    cVar2.ao(prepareResult);
                    AppMethodBeat.o(131741);
                }
            };
            g Cg = g.Cg(prepareParams.igl);
            if (Cg == null) {
                Cg = new g(c, a, b, prepareParams.igg, d, e, prepareParams.igk, prepareParams.igl, prepareParams.igm, prepareParams.igo);
                final c cVar3 = cVar;
                final g gVar = Cg;
                final String str = a;
                final int i = b;
                final int i2 = d;
                g anonymousClass2 = new g() {
                    public final void BR() {
                        AppMethodBeat.i(131746);
                        com.tencent.mm.kernel.g.RQ().b(this);
                        com.tencent.mm.kernel.g.RN();
                        boolean QX = com.tencent.mm.kernel.a.QX();
                        boolean QT = com.tencent.mm.kernel.a.QT();
                        if (!QX || QT) {
                            ab.i("MicroMsg.AppBrandPrepareTask", "prepareCall, startup done, hasLogin %B, hold %B", Boolean.valueOf(QX), Boolean.valueOf(QT));
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131742);
                                    Toast.makeText(ah.getContext(), R.string.gb, 0).show();
                                    try {
                                        Intent intent = new Intent();
                                        intent.addFlags(268435456).addFlags(67108864);
                                        com.tencent.mm.bp.d.f(ah.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                                        AppMethodBeat.o(131742);
                                    } catch (Exception e) {
                                        AppMethodBeat.o(131742);
                                    }
                                }
                            });
                            if (cVar3 != null) {
                                PrepareResult prepareResult = new PrepareResult();
                                prepareResult.igp = 3;
                                cVar3.ao(prepareResult);
                                AppMethodBeat.o(131746);
                                return;
                            }
                        }
                        AnonymousClass2 anonymousClass2 = new com.tencent.mm.sdk.b.c<cc>() {
                            {
                                AppMethodBeat.i(131743);
                                this.xxI = cc.class.getName().hashCode();
                                AppMethodBeat.o(131743);
                            }

                            private boolean a(cc ccVar) {
                                AppMethodBeat.i(131744);
                                if (ccVar != null) {
                                    dead();
                                    ab.i("MicroMsg.AppBrandPrepareTask", "prepareCall account notifyAllDone, start real prepare");
                                }
                                gVar.aHd();
                                AppMethodBeat.o(131744);
                                return false;
                            }
                        };
                        if (com.tencent.mm.kernel.g.RN().eJb) {
                            anonymousClass2.a(null);
                            AppMethodBeat.o(131746);
                            return;
                        }
                        ab.i("MicroMsg.AppBrandPrepareTask", "prepareCall account not notifyAllDone yet, wait for it");
                        anonymousClass2.dnU();
                        AppMethodBeat.o(131746);
                    }

                    public final void bi(boolean z) {
                        AppMethodBeat.i(131747);
                        com.tencent.mm.kernel.g.RQ().b(this);
                        ab.i("MicroMsg.AppBrandPrepareTask", "kernel onExit(%b), kill prepare process appId[%s] type[%d] scene[%d] sessionId[%s]", Boolean.valueOf(z), str, Integer.valueOf(i), Integer.valueOf(i2), prepareParams.igl);
                        if (cVar3 != null) {
                            PrepareResult prepareResult = new PrepareResult();
                            prepareResult.igp = 3;
                            cVar3.ao(prepareResult);
                        }
                        AppMethodBeat.o(131747);
                    }
                };
                if (com.tencent.mm.kernel.g.RQ().eKi.eKC) {
                    anonymousClass2.BR();
                } else {
                    ab.i("MicroMsg.AppBrandPrepareTask", "prepareCall kernel startup not done yet, wait for it");
                    com.tencent.mm.kernel.g.RQ().a(anonymousClass2);
                }
            } else {
                h.pYm.k(369, 22, 1);
                long j = Cg.igG;
                if (j > 0 && cVar != null) {
                    PrepareResult prepareResult2 = new PrepareResult();
                    prepareResult2.igp = 1;
                    prepareResult2.igu = j;
                    cVar.ao(prepareResult2);
                }
            }
            Cg.igD = anonymousClass1;
            if (Cg.started && Cg.igF != null) {
                ab.v("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] setResultCallback already done %s %d", Cg.appId, Integer.valueOf(Cg.har));
                Cg.a(Cg.igF);
            }
            if (Cg.igE) {
                Cg.aHg();
            }
            AppMethodBeat.o(131748);
        }
    }

    static final class PrepareParams implements Parcelable {
        public static final Creator<PrepareParams> CREATOR = new Creator<PrepareParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PrepareParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131749);
                PrepareParams prepareParams = new PrepareParams(parcel);
                AppMethodBeat.o(131749);
                return prepareParams;
            }
        };
        private int gqq;
        private boolean hrs;
        private int igg;
        private String igh;
        private String igi;
        private int igj;
        private AppBrandLaunchReferrer igk;
        private String igl;
        private int igm;
        private boolean ign;
        private QualitySession igo;
        private String mAppId;

        public final String toShortString() {
            AppMethodBeat.i(131750);
            String format = String.format(Locale.US, "[%s|%d]", new Object[]{this.mAppId, Integer.valueOf(this.igj)});
            AppMethodBeat.o(131750);
            return format;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(131751);
            parcel.writeInt(this.igg);
            parcel.writeInt(this.gqq);
            parcel.writeString(this.igh);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.igi);
            parcel.writeInt(this.igj);
            parcel.writeParcelable(this.igk, i);
            parcel.writeString(this.igl);
            parcel.writeInt(this.igm);
            if (this.hrs) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.ign) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeParcelable(this.igo, i);
            AppMethodBeat.o(131751);
        }

        PrepareParams() {
        }

        PrepareParams(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(131752);
            this.igg = parcel.readInt();
            this.gqq = parcel.readInt();
            this.igh = parcel.readString();
            this.mAppId = parcel.readString();
            this.igi = parcel.readString();
            this.igj = parcel.readInt();
            this.igk = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
            this.igl = parcel.readString();
            this.igm = parcel.readInt();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.hrs = z;
            if (parcel.readInt() <= 0) {
                z2 = false;
            }
            this.ign = z2;
            this.igo = (QualitySession) parcel.readParcelable(QualitySession.class.getClassLoader());
            AppMethodBeat.o(131752);
        }

        static {
            AppMethodBeat.i(131753);
            AppMethodBeat.o(131753);
        }
    }

    public interface b<C extends AppBrandSysConfigLU> extends j {
        void a(C c, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle);

        void a(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar);

        void atT();

        void gf(long j);

        void nn(int i);
    }

    static final class PrepareResult implements Parcelable {
        public static final Creator<PrepareResult> CREATOR = new Creator<PrepareResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PrepareResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131754);
                PrepareResult prepareResult = new PrepareResult(parcel);
                AppMethodBeat.o(131754);
                return prepareResult;
            }
        };
        private int igp;
        private AppBrandLaunchErrorAction igq;
        private AppBrandSysConfigWC igr;
        private AppStartupPerformanceReportBundle igs;
        private int igt;
        private long igu;
        private com.tencent.mm.plugin.appbrand.jsapi.version.a igv;
        private int igw = 0;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131755);
            parcel.writeInt(this.igp);
            parcel.writeParcelable(this.igq, i);
            parcel.writeParcelable(this.igr, i);
            parcel.writeInt(this.igt);
            parcel.writeLong(this.igu);
            parcel.writeParcelable(this.igs, i);
            parcel.writeInt(this.igw);
            if (this.igp == 5) {
                parcel.writeString(this.igv.toString());
            }
            AppMethodBeat.o(131755);
        }

        PrepareResult() {
        }

        PrepareResult(Parcel parcel) {
            AppMethodBeat.i(131756);
            this.igp = parcel.readInt();
            this.igq = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
            this.igr = (AppBrandSysConfigWC) parcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader());
            this.igt = parcel.readInt();
            this.igu = parcel.readLong();
            this.igs = (AppStartupPerformanceReportBundle) parcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader());
            this.igw = parcel.readInt();
            if (this.igp == 5) {
                this.igv = com.tencent.mm.plugin.appbrand.jsapi.version.a.BN(parcel.readString());
            }
            AppMethodBeat.o(131756);
        }

        static {
            AppMethodBeat.i(131757);
            AppMethodBeat.o(131757);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ WxaPkgWrappingInfo ifY;

        AnonymousClass4(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            this.ifY = wxaPkgWrappingInfo;
        }

        public final void run() {
            AppMethodBeat.i(131735);
            ab.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s]", Integer.valueOf(this.ifY.gVu), bo.mx(this.ifY.gVv));
            AppMethodBeat.o(131735);
        }
    }

    public AppBrandPrepareTask(Activity activity, o oVar) {
        int i = 0;
        AppMethodBeat.i(131758);
        AppBrandStatObject appBrandStatObject = oVar.ya().bQn;
        this.ifU = new WeakReference(activity);
        this.ifS.mAppId = oVar.mAppId;
        this.ifS.igi = oVar.atI().username;
        this.ifS.igj = oVar.gNB.gVs;
        this.ifS.igg = appBrandStatObject == null ? 0 : appBrandStatObject.cOq;
        PrepareParams prepareParams = this.ifS;
        if (appBrandStatObject != null) {
            i = appBrandStatObject.scene;
        }
        prepareParams.gqq = i;
        this.ifS.igh = oVar.atI().hgC;
        this.ifS.igk = oVar.atI().hgF;
        this.ifS.igl = oVar.atI().xz();
        this.ifS.hrs = oVar.xy();
        this.ifS.ign = oVar.atI().hgO;
        this.ifS.igo = oVar.atI().hgN;
        this.hrs = oVar.xy();
        AppMethodBeat.o(131758);
    }

    public final void aHd() {
        AppMethodBeat.i(131759);
        if (al.isMainThread()) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(131732);
                    AppBrandPrepareTask.this.aHd();
                    AppMethodBeat.o(131732);
                }
            }, "AppBrandPrepareTask" + this.ifS.toShortString());
            AppMethodBeat.o(131759);
            return;
        }
        if (!WxaCommLibRuntimeReader.avO()) {
            ab.i("MicroMsg.AppBrandPrepareTask", "startPrepare(), CommLib not loaded, %s", this.ifS.toShortString());
            WxaCommLibRuntimeReader.avN();
            z.aBv();
        }
        this.ifS.igm = WxaCommLibRuntimeReader.avQ().gVu;
        XIPCInvoker.a("com.tencent.mm", this.ifS, a.class, new c<PrepareResult>() {
            public final /* synthetic */ void ao(Object obj) {
                Activity activity;
                AppMethodBeat.i(131733);
                PrepareResult prepareResult = (PrepareResult) obj;
                AppBrandPrepareTask appBrandPrepareTask = AppBrandPrepareTask.this;
                ab.i("MicroMsg.AppBrandPrepareTask", "[applaunch] runInClientProcess, event = %d, %s %d", Integer.valueOf(prepareResult.igp), appBrandPrepareTask.ifS.mAppId, Integer.valueOf(appBrandPrepareTask.ifS.igj));
                switch (prepareResult.igp) {
                    case 1:
                        if (appBrandPrepareTask.ifT != null) {
                            appBrandPrepareTask.ifT.gf(prepareResult.igu);
                            AppMethodBeat.o(131733);
                            return;
                        }
                        break;
                    case 2:
                        if (prepareResult.igr == null && prepareResult.igq == null) {
                            m.aNS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131734);
                                    int i = 369;
                                    if (AppBrandPrepareTask.this.hrs) {
                                        i = 777;
                                    }
                                    h.pYm.a((long) i, 3, 1, false);
                                    com.tencent.mm.plugin.appbrand.report.c.a(AppBrandPrepareTask.this.ifS.mAppId, 0, AppBrandPrepareTask.this.ifS.igj, i, 3);
                                    AppMethodBeat.o(131734);
                                }
                            });
                        }
                        if (appBrandPrepareTask.ifT != null) {
                            if (prepareResult.igr != null) {
                                m.aNS().aa(new AnonymousClass4(prepareResult.igr.hhd));
                            } else {
                                ab.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, config null");
                            }
                            try {
                                appBrandPrepareTask.ifT.a(prepareResult.igr, prepareResult.igq, prepareResult.igs);
                            } catch (Exception e) {
                                Throwable th = e;
                                ab.printErrStackTrace("MicroMsg.AppBrandPrepareTask", th, "runInClientProcess, prepare done exception ", new Object[0]);
                                activity = (Activity) appBrandPrepareTask.ifU.get();
                                if (activity != null) {
                                    activity.finish();
                                }
                                AppMethodBeat.o(131733);
                                throw th;
                            } catch (NullPointerException e2) {
                                al.d(new Runnable() {
                                    public final void run() {
                                        throw e2;
                                    }
                                });
                                AppMethodBeat.o(131733);
                                return;
                            }
                        }
                        ab.e("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, but callback is null");
                        e.at(appBrandPrepareTask);
                        AppMethodBeat.o(131733);
                        return;
                    case 3:
                        WeakReference weakReference = appBrandPrepareTask.ifU;
                        activity = weakReference == null ? null : (Activity) weakReference.get();
                        if (activity != null) {
                            activity.finish();
                            activity.overridePendingTransition(0, 0);
                        }
                        Process.killProcess(Process.myPid());
                        AppMethodBeat.o(131733);
                        return;
                    case 4:
                        if (appBrandPrepareTask.ifT != null) {
                            appBrandPrepareTask.ifT.nn(prepareResult.igt);
                            AppMethodBeat.o(131733);
                            return;
                        }
                        break;
                    case 5:
                        if (appBrandPrepareTask.ifT != null) {
                            appBrandPrepareTask.ifT.a(prepareResult.igv);
                            AppMethodBeat.o(131733);
                            return;
                        }
                        break;
                    case 6:
                        if (appBrandPrepareTask.ifT != null) {
                            appBrandPrepareTask.ifT.atT();
                            AppMethodBeat.o(131733);
                            return;
                        }
                        break;
                    case 7:
                        if (appBrandPrepareTask.ifT != null) {
                            appBrandPrepareTask.ifT.nm(prepareResult.igw);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(131733);
            }
        });
        ab.i("MicroMsg.AppBrandPrepareTask", "[applaunch] startPrepare in appbrand %s, %d", this.ifS.mAppId, Integer.valueOf(this.ifS.igj));
        AppMethodBeat.o(131759);
    }
}
