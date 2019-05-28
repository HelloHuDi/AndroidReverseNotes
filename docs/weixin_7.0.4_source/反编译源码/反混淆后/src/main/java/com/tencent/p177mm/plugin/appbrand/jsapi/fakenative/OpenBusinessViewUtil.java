package com.tencent.p177mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C9395kg;
import com.tencent.p177mm.p230g.p231a.C9398kh;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;
import com.tencent.p177mm.protocal.protobuf.axo;
import com.tencent.p177mm.protocal.protobuf.axp;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil */
public final class OpenBusinessViewUtil {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil$a */
    public interface C19360a {
        /* renamed from: R */
        void mo6277R(int i, String str);

        /* renamed from: ce */
        void mo6278ce(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil$NavigateBackH5Task */
    public static final class NavigateBackH5Task extends MainProcessTask {
        public static final Creator<NavigateBackH5Task> CREATOR = new C193611();
        public String businessType;
        public int errCode;
        public String extra;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil$NavigateBackH5Task$1 */
        static class C193611 implements Creator<NavigateBackH5Task> {
            C193611() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new NavigateBackH5Task[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131045);
                NavigateBackH5Task navigateBackH5Task = new NavigateBackH5Task();
                navigateBackH5Task.mo6032g(parcel);
                AppMethodBeat.m2505o(131045);
                return navigateBackH5Task;
            }
        }

        public NavigateBackH5Task(String str, String str2, int i) {
            this.businessType = str;
            this.extra = str2;
            this.errCode = i;
        }

        public final void asP() {
            AppMethodBeat.m2504i(131046);
            OpenBusinessViewUtil.m30044q(this.businessType, this.extra, this.errCode);
            AppMethodBeat.m2505o(131046);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131047);
            parcel.writeString(this.businessType);
            parcel.writeString(this.extra);
            parcel.writeInt(this.errCode);
            AppMethodBeat.m2505o(131047);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(131048);
            this.businessType = parcel.readString();
            this.extra = parcel.readString();
            this.errCode = parcel.readInt();
            AppMethodBeat.m2505o(131048);
        }

        static {
            AppMethodBeat.m2504i(131049);
            AppMethodBeat.m2505o(131049);
        }
    }

    /* renamed from: a */
    public static void m30037a(int i, String str, String str2, String str3, String str4, final C19360a c19360a) {
        AppMethodBeat.m2504i(131050);
        axo axo = new axo();
        axo.cvd = i;
        axo.wBx = str;
        axo.wBy = str3;
        axo.wBz = str4;
        axo.query = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1268;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
        c1196a.fsJ = axo;
        c1196a.fsK = new axp();
        C42146b.m74301a(c1196a.acD(), new C9557a() {
            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(131044);
                if (i == 0 && i2 == 0 && c7472b != null && c7472b.fsH.fsP != null && (c7472b.fsH.fsP instanceof axp)) {
                    axp axp = (axp) c7472b.fsH.fsP;
                    C4990ab.m7417i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", axp.csB, axp.wBA);
                    if (c19360a != null) {
                        c19360a.mo6278ce(axp.csB, axp.wBA);
                    }
                    AppMethodBeat.m2505o(131044);
                    return;
                }
                C4990ab.m7412e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
                if (c19360a != null) {
                    c19360a.mo6277R(i2, str);
                }
                AppMethodBeat.m2505o(131044);
            }
        });
        AppMethodBeat.m2505o(131050);
    }

    /* renamed from: l */
    public static boolean m30040l(C41243o c41243o) {
        AppMethodBeat.m2504i(131051);
        if (c41243o != null) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = c41243o.atI().hgF;
            if (!(appBrandLaunchReferrer == null || appBrandLaunchReferrer.cvp != 5 || C5046bo.isNullOrNil(appBrandLaunchReferrer.businessType))) {
                AppMethodBeat.m2505o(131051);
                return true;
            }
        }
        AppMethodBeat.m2505o(131051);
        return false;
    }

    /* renamed from: m */
    public static void m30041m(C41243o c41243o) {
        AppMethodBeat.m2504i(131052);
        if (OpenBusinessViewUtil.m30040l(c41243o)) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = c41243o.atI().hgF;
            if (appBrandLaunchReferrer.hgQ == 2) {
                if (!C38450n.m65048xa(c41243o.mAppId).gPl) {
                    C4990ab.m7417i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", appBrandLaunchReferrer.businessType);
                    OpenBusinessViewUtil.m30043p(appBrandLaunchReferrer.businessType, null, -3);
                }
                AppMethodBeat.m2505o(131052);
                return;
            } else if (appBrandLaunchReferrer.hgQ == 4) {
                if (!C38450n.m65048xa(c41243o.mAppId).gPn) {
                    C4990ab.m7417i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", appBrandLaunchReferrer.businessType);
                    if (!(c41243o.atI().hgF == null || C5046bo.isNullOrNil(c41243o.atI().hgF.appId))) {
                        OpenBusinessViewUtil.m30042o(c41243o.atI().hgF.appId, appBrandLaunchReferrer.businessType, -2);
                    }
                }
                AppMethodBeat.m2505o(131052);
                return;
            } else if (appBrandLaunchReferrer.hgQ == 1 && !C38450n.m65048xa(c41243o.mAppId).gPm) {
                C4990ab.m7417i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", appBrandLaunchReferrer.businessType);
                OpenBusinessViewUtil.m30038k(appBrandLaunchReferrer.businessType, C26968d.CANCEL.errCode, null);
            }
        }
        AppMethodBeat.m2505o(131052);
    }

    /* renamed from: o */
    public static void m30042o(String str, String str2, int i) {
        AppMethodBeat.m2504i(131053);
        C4990ab.m7417i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", str, str2, Integer.valueOf(i));
        AppBrandMainProcessService.m54349a(new NavigateBackAppTask(str, C5046bo.m7532bc(null, "{}"), str2, i));
        AppMethodBeat.m2505o(131053);
    }

    /* renamed from: k */
    public static void m30038k(String str, int i, String str2) {
        AppMethodBeat.m2504i(131054);
        C4990ab.m7417i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", str, Integer.valueOf(i));
        OpenBusinessViewUtil.m30039l(str, i, str2);
        AppMethodBeat.m2505o(131054);
    }

    /* renamed from: l */
    private static void m30039l(String str, int i, String str2) {
        AppMethodBeat.m2504i(131055);
        C9398kh c9398kh = new C9398kh();
        c9398kh.cFN.errCode = i;
        c9398kh.cFN.businessType = str;
        c9398kh.cFN.cFM = str2;
        C4879a.xxA.mo10055m(c9398kh);
        AppMethodBeat.m2505o(131055);
    }

    /* renamed from: p */
    public static void m30043p(String str, String str2, int i) {
        AppMethodBeat.m2504i(131056);
        C4990ab.m7417i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", str, Integer.valueOf(i));
        if (C4996ah.bqo()) {
            OpenBusinessViewUtil.m30044q(str, str2, i);
            AppMethodBeat.m2505o(131056);
            return;
        }
        AppBrandMainProcessService.m54349a(new NavigateBackH5Task(str, str2, i));
        AppMethodBeat.m2505o(131056);
    }

    /* renamed from: q */
    public static void m30044q(String str, String str2, int i) {
        AppMethodBeat.m2504i(131057);
        C9395kg c9395kg = new C9395kg();
        c9395kg.cFL.businessType = str;
        c9395kg.cFL.errCode = i;
        c9395kg.cFL.cFM = str2;
        C4879a.xxA.mo10055m(c9395kg);
        AppMethodBeat.m2505o(131057);
    }
}
