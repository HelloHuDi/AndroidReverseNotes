package com.tencent.p177mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.widget.Toast;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.p230g.p231a.C6464cc;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.jsapi.version.C42591a;
import com.tencent.p177mm.plugin.appbrand.launching.C27165g.C27169b;
import com.tencent.p177mm.plugin.appbrand.launching.C45639i.C27172a;
import com.tencent.p177mm.plugin.appbrand.launching.C45639i.C456381;
import com.tencent.p177mm.plugin.appbrand.p297h.C38238z;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask */
public final class AppBrandPrepareTask {
    boolean hrs;
    PrepareParams ifS = new PrepareParams();
    public volatile transient C2367b<AppBrandSysConfigWC> ifT;
    volatile transient WeakReference<Activity> ifU;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$a */
    static final class C2359a implements C37866a<PrepareParams, PrepareResult> {
        private C2359a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(131748);
            final PrepareParams prepareParams = (PrepareParams) obj;
            if (prepareParams == null) {
                C4990ab.m7420w("MicroMsg.AppBrandPrepareTask", "PrepareCall invoke NULL input");
                if (c18507c != null) {
                    PrepareResult prepareResult = new PrepareResult();
                    prepareResult.igp = 2;
                    prepareResult.igr = null;
                    prepareResult.igq = null;
                    prepareResult.igs = null;
                    c18507c.mo5960ao(prepareResult);
                }
                AppMethodBeat.m2505o(131748);
                return;
            }
            String c = prepareParams.igi;
            String a = prepareParams.mAppId;
            int b = prepareParams.igj;
            int d = prepareParams.gqq;
            String e = prepareParams.igh;
            final C18507c c18507c2 = c18507c;
            final PrepareParams prepareParams2 = prepareParams;
            C23631 c23631 = new C27169b() {

                /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$a$1$1 */
                class C23641 implements C27172a {
                    C23641() {
                    }

                    /* renamed from: b */
                    public final void mo6249b(C42591a c42591a) {
                        AppMethodBeat.m2504i(131736);
                        C4990ab.m7417i("MicroMsg.AppBrandPrepareTask", "[appversion] dispatch %s, %s", prepareParams2.mAppId, c42591a);
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igp = 5;
                        prepareResult.igv = c42591a;
                        c18507c2.mo5960ao(prepareResult);
                        AppMethodBeat.m2505o(131736);
                    }
                }

                public final void aHe() {
                    AppMethodBeat.m2504i(131737);
                    if (c18507c2 != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igp = 1;
                        prepareResult.igu = C5046bo.anU();
                        c18507c2.mo5960ao(prepareResult);
                    }
                    AppMethodBeat.m2505o(131737);
                }

                public final void onDownloadProgress(int i) {
                    AppMethodBeat.m2504i(131738);
                    if (c18507c2 != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igt = i;
                        prepareResult.igp = 4;
                        c18507c2.mo5960ao(prepareResult);
                    }
                    AppMethodBeat.m2505o(131738);
                }

                public final void atT() {
                    AppMethodBeat.m2504i(131739);
                    if (c18507c2 != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igp = 6;
                        c18507c2.mo5960ao(prepareResult);
                    }
                    AppMethodBeat.m2505o(131739);
                }

                /* renamed from: a */
                public final void mo6244a(AppBrandSysConfigWC appBrandSysConfigWC, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle) {
                    AppMethodBeat.m2504i(131740);
                    if (c18507c2 != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.igp = 2;
                        prepareResult.igr = appBrandSysConfigWC;
                        prepareResult.igq = appBrandLaunchErrorAction;
                        prepareResult.igs = appStartupPerformanceReportBundle;
                        c18507c2.mo5960ao(prepareResult);
                        if (appBrandSysConfigWC != null) {
                            C23641 c23641 = new C23641();
                            if (prepareParams2.ign) {
                                c23641.mo6249b(C42591a.NO_UPDATE);
                            } else {
                                C45639i c45639i = new C45639i(prepareParams2.igi, prepareParams2.gqq, c23641, prepareParams2.igo);
                                if (c45639i.igX != null) {
                                    C7305d.post(new C456381(c45639i), "MicroMsg.AppBrand.Launching.ContactSilentSyncProcess");
                                    AppMethodBeat.m2505o(131740);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(131740);
                            return;
                        }
                        C42406r.m75080zu(C26842p.m42742zo(prepareParams2.mAppId));
                    }
                    AppMethodBeat.m2505o(131740);
                }

                /* renamed from: nm */
                public final void mo6247nm(int i) {
                    AppMethodBeat.m2504i(131741);
                    PrepareResult prepareResult = new PrepareResult();
                    prepareResult.igp = 7;
                    prepareResult.igw = i;
                    c18507c2.mo5960ao(prepareResult);
                    AppMethodBeat.m2505o(131741);
                }
            };
            C27165g Cg = C27165g.m43174Cg(prepareParams.igl);
            if (Cg == null) {
                Cg = new C27165g(c, a, b, prepareParams.igg, d, e, prepareParams.igk, prepareParams.igl, prepareParams.igm, prepareParams.igo);
                final C18507c c18507c3 = c18507c;
                final C27165g c27165g = Cg;
                final String str = a;
                final int i = b;
                final int i2 = d;
                C1675g c23602 = new C1675g() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$a$2$1 */
                    class C23611 implements Runnable {
                        C23611() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(131742);
                            Toast.makeText(C4996ah.getContext(), C25738R.string.f8834gb, 0).show();
                            try {
                                Intent intent = new Intent();
                                intent.addFlags(268435456).addFlags(67108864);
                                C25985d.m41473f(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                                AppMethodBeat.m2505o(131742);
                            } catch (Exception e) {
                                AppMethodBeat.m2505o(131742);
                            }
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$a$2$2 */
                    class C23622 extends C4884c<C6464cc> {
                        C23622() {
                            AppMethodBeat.m2504i(131743);
                            this.xxI = C6464cc.class.getName().hashCode();
                            AppMethodBeat.m2505o(131743);
                        }

                        /* renamed from: a */
                        private boolean m4588a(C6464cc c6464cc) {
                            AppMethodBeat.m2504i(131744);
                            if (c6464cc != null) {
                                dead();
                                C4990ab.m7416i("MicroMsg.AppBrandPrepareTask", "prepareCall account notifyAllDone, start real prepare");
                            }
                            c27165g.aHd();
                            AppMethodBeat.m2505o(131744);
                            return false;
                        }
                    }

                    /* renamed from: BR */
                    public final void mo5176BR() {
                        AppMethodBeat.m2504i(131746);
                        C1720g.m3537RQ().mo5255b(this);
                        C1720g.m3534RN();
                        boolean QX = C1668a.m3395QX();
                        boolean QT = C1668a.m3393QT();
                        if (!QX || QT) {
                            C4990ab.m7417i("MicroMsg.AppBrandPrepareTask", "prepareCall, startup done, hasLogin %B, hold %B", Boolean.valueOf(QX), Boolean.valueOf(QT));
                            C5004al.m7441d(new C23611());
                            if (c18507c3 != null) {
                                PrepareResult prepareResult = new PrepareResult();
                                prepareResult.igp = 3;
                                c18507c3.mo5960ao(prepareResult);
                                AppMethodBeat.m2505o(131746);
                                return;
                            }
                        }
                        C23622 c23622 = new C23622();
                        if (C1720g.m3534RN().eJb) {
                            c23622.mo4653a(null);
                            AppMethodBeat.m2505o(131746);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.AppBrandPrepareTask", "prepareCall account not notifyAllDone yet, wait for it");
                        c23622.dnU();
                        AppMethodBeat.m2505o(131746);
                    }

                    /* renamed from: bi */
                    public final void mo5177bi(boolean z) {
                        AppMethodBeat.m2504i(131747);
                        C1720g.m3537RQ().mo5255b(this);
                        C4990ab.m7417i("MicroMsg.AppBrandPrepareTask", "kernel onExit(%b), kill prepare process appId[%s] type[%d] scene[%d] sessionId[%s]", Boolean.valueOf(z), str, Integer.valueOf(i), Integer.valueOf(i2), prepareParams.igl);
                        if (c18507c3 != null) {
                            PrepareResult prepareResult = new PrepareResult();
                            prepareResult.igp = 3;
                            c18507c3.mo5960ao(prepareResult);
                        }
                        AppMethodBeat.m2505o(131747);
                    }
                };
                if (C1720g.m3537RQ().eKi.eKC) {
                    c23602.mo5176BR();
                } else {
                    C4990ab.m7416i("MicroMsg.AppBrandPrepareTask", "prepareCall kernel startup not done yet, wait for it");
                    C1720g.m3537RQ().mo5252a(c23602);
                }
            } else {
                C7060h.pYm.mo15419k(369, 22, 1);
                long j = Cg.igG;
                if (j > 0 && c18507c != null) {
                    PrepareResult prepareResult2 = new PrepareResult();
                    prepareResult2.igp = 1;
                    prepareResult2.igu = j;
                    c18507c.mo5960ao(prepareResult2);
                }
            }
            Cg.igD = c23631;
            if (Cg.started && Cg.igF != null) {
                C4990ab.m7419v("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] setResultCallback already done %s %d", Cg.appId, Integer.valueOf(Cg.har));
                Cg.mo44841a(Cg.igF);
            }
            if (Cg.igE) {
                Cg.aHg();
            }
            AppMethodBeat.m2505o(131748);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$1 */
    class C23651 implements Runnable {
        C23651() {
        }

        public final void run() {
            AppMethodBeat.m2504i(131732);
            AppBrandPrepareTask.this.aHd();
            AppMethodBeat.m2505o(131732);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$PrepareParams */
    static final class PrepareParams implements Parcelable {
        public static final Creator<PrepareParams> CREATOR = new C23661();
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

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$PrepareParams$1 */
        static class C23661 implements Creator<PrepareParams> {
            C23661() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PrepareParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131749);
                PrepareParams prepareParams = new PrepareParams(parcel);
                AppMethodBeat.m2505o(131749);
                return prepareParams;
            }
        }

        public final String toShortString() {
            AppMethodBeat.m2504i(131750);
            String format = String.format(Locale.US, "[%s|%d]", new Object[]{this.mAppId, Integer.valueOf(this.igj)});
            AppMethodBeat.m2505o(131750);
            return format;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(131751);
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
            AppMethodBeat.m2505o(131751);
        }

        PrepareParams() {
        }

        PrepareParams(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(131752);
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
            AppMethodBeat.m2505o(131752);
        }

        static {
            AppMethodBeat.m2504i(131753);
            AppMethodBeat.m2505o(131753);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$b */
    public interface C2367b<C extends AppBrandSysConfigLU> extends C38422j {
        /* renamed from: a */
        void mo6256a(C c, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle);

        /* renamed from: a */
        void mo6257a(C42591a c42591a);

        void atT();

        /* renamed from: gf */
        void mo6259gf(long j);

        /* renamed from: nn */
        void mo6260nn(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$PrepareResult */
    static final class PrepareResult implements Parcelable {
        public static final Creator<PrepareResult> CREATOR = new C23681();
        private int igp;
        private AppBrandLaunchErrorAction igq;
        private AppBrandSysConfigWC igr;
        private AppStartupPerformanceReportBundle igs;
        private int igt;
        private long igu;
        private C42591a igv;
        private int igw = 0;

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$PrepareResult$1 */
        static class C23681 implements Creator<PrepareResult> {
            C23681() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PrepareResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131754);
                PrepareResult prepareResult = new PrepareResult(parcel);
                AppMethodBeat.m2505o(131754);
                return prepareResult;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131755);
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
            AppMethodBeat.m2505o(131755);
        }

        PrepareResult() {
        }

        PrepareResult(Parcel parcel) {
            AppMethodBeat.m2504i(131756);
            this.igp = parcel.readInt();
            this.igq = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
            this.igr = (AppBrandSysConfigWC) parcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader());
            this.igt = parcel.readInt();
            this.igu = parcel.readLong();
            this.igs = (AppStartupPerformanceReportBundle) parcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader());
            this.igw = parcel.readInt();
            if (this.igp == 5) {
                this.igv = C42591a.m75401BN(parcel.readString());
            }
            AppMethodBeat.m2505o(131756);
        }

        static {
            AppMethodBeat.m2504i(131757);
            AppMethodBeat.m2505o(131757);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$3 */
    class C23693 implements Runnable {
        C23693() {
        }

        public final void run() {
            AppMethodBeat.m2504i(131734);
            int i = 369;
            if (AppBrandPrepareTask.this.hrs) {
                i = 777;
            }
            C7060h.pYm.mo8378a((long) i, 3, 1, false);
            C19690c.m30497a(AppBrandPrepareTask.this.ifS.mAppId, 0, AppBrandPrepareTask.this.ifS.igj, i, 3);
            AppMethodBeat.m2505o(131734);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$4 */
    class C23704 implements Runnable {
        final /* synthetic */ WxaPkgWrappingInfo ifY;

        C23704(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            this.ifY = wxaPkgWrappingInfo;
        }

        public final void run() {
            AppMethodBeat.m2504i(131735);
            C4990ab.m7417i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s]", Integer.valueOf(this.ifY.gVu), C5046bo.m7579mx(this.ifY.gVv));
            AppMethodBeat.m2505o(131735);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$2 */
    class C23712 implements C18507c<PrepareResult> {
        C23712() {
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            Activity activity;
            AppMethodBeat.m2504i(131733);
            PrepareResult prepareResult = (PrepareResult) obj;
            AppBrandPrepareTask appBrandPrepareTask = AppBrandPrepareTask.this;
            C4990ab.m7417i("MicroMsg.AppBrandPrepareTask", "[applaunch] runInClientProcess, event = %d, %s %d", Integer.valueOf(prepareResult.igp), appBrandPrepareTask.ifS.mAppId, Integer.valueOf(appBrandPrepareTask.ifS.igj));
            switch (prepareResult.igp) {
                case 1:
                    if (appBrandPrepareTask.ifT != null) {
                        appBrandPrepareTask.ifT.mo6259gf(prepareResult.igu);
                        AppMethodBeat.m2505o(131733);
                        return;
                    }
                    break;
                case 2:
                    if (prepareResult.igr == null && prepareResult.igq == null) {
                        C45673m.aNS().mo10302aa(new C23693());
                    }
                    if (appBrandPrepareTask.ifT != null) {
                        if (prepareResult.igr != null) {
                            C45673m.aNS().mo10302aa(new C23704(prepareResult.igr.hhd));
                        } else {
                            C4990ab.m7416i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, config null");
                        }
                        try {
                            appBrandPrepareTask.ifT.mo6256a(prepareResult.igr, prepareResult.igq, prepareResult.igs);
                        } catch (Exception e) {
                            Throwable th = e;
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandPrepareTask", th, "runInClientProcess, prepare done exception ", new Object[0]);
                            activity = (Activity) appBrandPrepareTask.ifU.get();
                            if (activity != null) {
                                activity.finish();
                            }
                            AppMethodBeat.m2505o(131733);
                            throw th;
                        } catch (NullPointerException e2) {
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    throw e2;
                                }
                            });
                            AppMethodBeat.m2505o(131733);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, but callback is null");
                    C42677e.m75579at(appBrandPrepareTask);
                    AppMethodBeat.m2505o(131733);
                    return;
                case 3:
                    WeakReference weakReference = appBrandPrepareTask.ifU;
                    activity = weakReference == null ? null : (Activity) weakReference.get();
                    if (activity != null) {
                        activity.finish();
                        activity.overridePendingTransition(0, 0);
                    }
                    Process.killProcess(Process.myPid());
                    AppMethodBeat.m2505o(131733);
                    return;
                case 4:
                    if (appBrandPrepareTask.ifT != null) {
                        appBrandPrepareTask.ifT.mo6260nn(prepareResult.igt);
                        AppMethodBeat.m2505o(131733);
                        return;
                    }
                    break;
                case 5:
                    if (appBrandPrepareTask.ifT != null) {
                        appBrandPrepareTask.ifT.mo6257a(prepareResult.igv);
                        AppMethodBeat.m2505o(131733);
                        return;
                    }
                    break;
                case 6:
                    if (appBrandPrepareTask.ifT != null) {
                        appBrandPrepareTask.ifT.atT();
                        AppMethodBeat.m2505o(131733);
                        return;
                    }
                    break;
                case 7:
                    if (appBrandPrepareTask.ifT != null) {
                        appBrandPrepareTask.ifT.mo6247nm(prepareResult.igw);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(131733);
        }
    }

    public AppBrandPrepareTask(Activity activity, C41243o c41243o) {
        int i = 0;
        AppMethodBeat.m2504i(131758);
        AppBrandStatObject appBrandStatObject = c41243o.mo43491ya().bQn;
        this.ifU = new WeakReference(activity);
        this.ifS.mAppId = c41243o.mAppId;
        this.ifS.igi = c41243o.atI().username;
        this.ifS.igj = c41243o.gNB.gVs;
        this.ifS.igg = appBrandStatObject == null ? 0 : appBrandStatObject.cOq;
        PrepareParams prepareParams = this.ifS;
        if (appBrandStatObject != null) {
            i = appBrandStatObject.scene;
        }
        prepareParams.gqq = i;
        this.ifS.igh = c41243o.atI().hgC;
        this.ifS.igk = c41243o.atI().hgF;
        this.ifS.igl = c41243o.atI().mo32993xz();
        this.ifS.hrs = c41243o.mo65903xy();
        this.ifS.ign = c41243o.atI().hgO;
        this.ifS.igo = c41243o.atI().hgN;
        this.hrs = c41243o.mo65903xy();
        AppMethodBeat.m2505o(131758);
    }

    public final void aHd() {
        AppMethodBeat.m2504i(131759);
        if (C5004al.isMainThread()) {
            C7305d.post(new C23651(), "AppBrandPrepareTask" + this.ifS.toShortString());
            AppMethodBeat.m2505o(131759);
            return;
        }
        if (!WxaCommLibRuntimeReader.avO()) {
            C4990ab.m7417i("MicroMsg.AppBrandPrepareTask", "startPrepare(), CommLib not loaded, %s", this.ifS.toShortString());
            WxaCommLibRuntimeReader.avN();
            C38238z.aBv();
        }
        this.ifS.igm = WxaCommLibRuntimeReader.avQ().gVu;
        XIPCInvoker.m83629a("com.tencent.mm", this.ifS, C2359a.class, new C23712());
        C4990ab.m7417i("MicroMsg.AppBrandPrepareTask", "[applaunch] startPrepare in appbrand %s, %d", this.ifS.mAppId, Integer.valueOf(this.ifS.igj));
        AppMethodBeat.m2505o(131759);
    }
}
