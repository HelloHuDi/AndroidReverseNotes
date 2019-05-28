package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class OpenBusinessViewUtil {

    public interface a {
        void R(int i, String str);

        void ce(String str, String str2);
    }

    public static final class NavigateBackH5Task extends MainProcessTask {
        public static final Creator<NavigateBackH5Task> CREATOR = new Creator<NavigateBackH5Task>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new NavigateBackH5Task[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131045);
                NavigateBackH5Task navigateBackH5Task = new NavigateBackH5Task();
                navigateBackH5Task.g(parcel);
                AppMethodBeat.o(131045);
                return navigateBackH5Task;
            }
        };
        public String businessType;
        public int errCode;
        public String extra;

        public NavigateBackH5Task(String str, String str2, int i) {
            this.businessType = str;
            this.extra = str2;
            this.errCode = i;
        }

        public final void asP() {
            AppMethodBeat.i(131046);
            OpenBusinessViewUtil.q(this.businessType, this.extra, this.errCode);
            AppMethodBeat.o(131046);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131047);
            parcel.writeString(this.businessType);
            parcel.writeString(this.extra);
            parcel.writeInt(this.errCode);
            AppMethodBeat.o(131047);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(131048);
            this.businessType = parcel.readString();
            this.extra = parcel.readString();
            this.errCode = parcel.readInt();
            AppMethodBeat.o(131048);
        }

        static {
            AppMethodBeat.i(131049);
            AppMethodBeat.o(131049);
        }
    }

    public static void a(int i, String str, String str2, String str3, String str4, final a aVar) {
        AppMethodBeat.i(131050);
        axo axo = new axo();
        axo.cvd = i;
        axo.wBx = str;
        axo.wBy = str3;
        axo.wBz = str4;
        axo.query = str2;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsI = 1268;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
        aVar2.fsJ = axo;
        aVar2.fsK = new axp();
        b.a(aVar2.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                AppMethodBeat.i(131044);
                if (i == 0 && i2 == 0 && bVar != null && bVar.fsH.fsP != null && (bVar.fsH.fsP instanceof axp)) {
                    axp axp = (axp) bVar.fsH.fsP;
                    ab.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", axp.csB, axp.wBA);
                    if (aVar != null) {
                        aVar.ce(axp.csB, axp.wBA);
                    }
                    AppMethodBeat.o(131044);
                    return;
                }
                ab.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
                if (aVar != null) {
                    aVar.R(i2, str);
                }
                AppMethodBeat.o(131044);
            }
        });
        AppMethodBeat.o(131050);
    }

    public static boolean l(o oVar) {
        AppMethodBeat.i(131051);
        if (oVar != null) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = oVar.atI().hgF;
            if (!(appBrandLaunchReferrer == null || appBrandLaunchReferrer.cvp != 5 || bo.isNullOrNil(appBrandLaunchReferrer.businessType))) {
                AppMethodBeat.o(131051);
                return true;
            }
        }
        AppMethodBeat.o(131051);
        return false;
    }

    public static void m(o oVar) {
        AppMethodBeat.i(131052);
        if (l(oVar)) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = oVar.atI().hgF;
            if (appBrandLaunchReferrer.hgQ == 2) {
                if (!n.xa(oVar.mAppId).gPl) {
                    ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", appBrandLaunchReferrer.businessType);
                    p(appBrandLaunchReferrer.businessType, null, -3);
                }
                AppMethodBeat.o(131052);
                return;
            } else if (appBrandLaunchReferrer.hgQ == 4) {
                if (!n.xa(oVar.mAppId).gPn) {
                    ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", appBrandLaunchReferrer.businessType);
                    if (!(oVar.atI().hgF == null || bo.isNullOrNil(oVar.atI().hgF.appId))) {
                        o(oVar.atI().hgF.appId, appBrandLaunchReferrer.businessType, -2);
                    }
                }
                AppMethodBeat.o(131052);
                return;
            } else if (appBrandLaunchReferrer.hgQ == 1 && !n.xa(oVar.mAppId).gPm) {
                ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", appBrandLaunchReferrer.businessType);
                k(appBrandLaunchReferrer.businessType, d.CANCEL.errCode, null);
            }
        }
        AppMethodBeat.o(131052);
    }

    public static void o(String str, String str2, int i) {
        AppMethodBeat.i(131053);
        ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", str, str2, Integer.valueOf(i));
        AppBrandMainProcessService.a(new NavigateBackAppTask(str, bo.bc(null, "{}"), str2, i));
        AppMethodBeat.o(131053);
    }

    public static void k(String str, int i, String str2) {
        AppMethodBeat.i(131054);
        ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", str, Integer.valueOf(i));
        l(str, i, str2);
        AppMethodBeat.o(131054);
    }

    private static void l(String str, int i, String str2) {
        AppMethodBeat.i(131055);
        kh khVar = new kh();
        khVar.cFN.errCode = i;
        khVar.cFN.businessType = str;
        khVar.cFN.cFM = str2;
        com.tencent.mm.sdk.b.a.xxA.m(khVar);
        AppMethodBeat.o(131055);
    }

    public static void p(String str, String str2, int i) {
        AppMethodBeat.i(131056);
        ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", str, Integer.valueOf(i));
        if (ah.bqo()) {
            q(str, str2, i);
            AppMethodBeat.o(131056);
            return;
        }
        AppBrandMainProcessService.a(new NavigateBackH5Task(str, str2, i));
        AppMethodBeat.o(131056);
    }

    public static void q(String str, String str2, int i) {
        AppMethodBeat.i(131057);
        kg kgVar = new kg();
        kgVar.cFL.businessType = str;
        kgVar.cFL.errCode = i;
        kgVar.cFL.cFM = str2;
        com.tencent.mm.sdk.b.a.xxA.m(kgVar);
        AppMethodBeat.o(131057);
    }
}
