package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiNavigateBackApplication extends a<q> {
    private static final int CTRL_INDEX = 288;
    public static final String NAME = "navigateBackApplication";

    public static final class NavigateBackAppTask extends MainProcessTask {
        public static final Creator<NavigateBackAppTask> CREATOR = new Creator<NavigateBackAppTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new NavigateBackAppTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130495);
                NavigateBackAppTask navigateBackAppTask = new NavigateBackAppTask();
                navigateBackAppTask.g(parcel);
                AppMethodBeat.o(130495);
                return navigateBackAppTask;
            }
        };
        public String appId;
        public String businessType;
        public String data;
        public int errCode;

        public NavigateBackAppTask(String str, String str2, String str3, int i) {
            this.appId = str;
            this.data = str2;
            this.businessType = str3;
            this.errCode = i;
        }

        public final void asP() {
            AppMethodBeat.i(130496);
            f bT = g.bT(this.appId, true);
            ab.i("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appid %s", this.appId);
            if (bT == null) {
                ab.w("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appinfo is null");
                AppMethodBeat.o(130496);
                return;
            }
            Bundle bundle = new Bundle();
            if (bo.isNullOrNil(this.businessType)) {
                Resp resp = new Resp(bundle);
                resp.extMsg = this.data;
                resp.openId = bT.field_openId;
                a(bundle, resp, bT);
                AppMethodBeat.o(130496);
                return;
            }
            WXOpenBusinessView.Resp resp2 = new WXOpenBusinessView.Resp(bundle);
            resp2.extMsg = this.data;
            resp2.openId = bT.field_openId;
            resp2.errCode = this.errCode;
            resp2.businessType = this.businessType;
            a(bundle, resp2, bT);
            AppMethodBeat.o(130496);
        }

        private static void a(Bundle bundle, BaseResp baseResp, f fVar) {
            AppMethodBeat.i(130497);
            baseResp.toBundle(bundle);
            Args args = new Args();
            args.targetPkgName = fVar.field_packageName;
            args.bundle = bundle;
            p.at(bundle);
            p.au(bundle);
            MMessageActV2.send(ah.getContext(), args);
            AppMethodBeat.o(130497);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130498);
            parcel.writeString(this.appId);
            parcel.writeString(this.data);
            parcel.writeString(this.businessType);
            parcel.writeInt(this.errCode);
            AppMethodBeat.o(130498);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130499);
            this.appId = parcel.readString();
            this.data = parcel.readString();
            this.businessType = parcel.readString();
            this.errCode = parcel.readInt();
            AppMethodBeat.o(130499);
        }

        static {
            AppMethodBeat.i(130500);
            AppMethodBeat.o(130500);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        String str;
        AppMethodBeat.i(130501);
        final q qVar = (q) cVar;
        AppBrandLaunchReferrer appBrandLaunchReferrer = qVar.getRuntime().yf().hgF;
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("extraData");
        if (appBrandLaunchReferrer != null) {
            str = appBrandLaunchReferrer.businessType;
        } else {
            str = null;
        }
        if (qVar.getRuntime() instanceof o) {
            o oVar = (o) qVar.getRuntime();
            if (appBrandLaunchReferrer != null && appBrandLaunchReferrer.hgQ == 4 && OpenBusinessViewUtil.l(oVar)) {
                ab.i("MicroMsg.JsApiNavigateBackApplication", "navigate back Application, businessType:%s", appBrandLaunchReferrer.businessType);
                n.xb(qVar.getAppId()).gPn = true;
            }
        }
        if (!bo.isNullOrNil(optString)) {
            AppBrandMainProcessService.a(new NavigateBackAppTask(optString, bo.bc(optString2, "{}"), str, 0));
        } else if (bo.isNullOrNil(appBrandLaunchReferrer.appId) || !(appBrandLaunchReferrer.hgQ == 4 || appBrandLaunchReferrer.hgQ == 7)) {
            ab.w("MicroMsg.JsApiNavigateBackApplication", "navigateBackApplication appid %s,launchScene %d", appBrandLaunchReferrer.appId, Integer.valueOf(appBrandLaunchReferrer.hgQ));
            qVar.M(i, j("fail:not from opensdk", null));
            AppMethodBeat.o(130501);
            return;
        } else {
            AppBrandMainProcessService.a(new NavigateBackAppTask(appBrandLaunchReferrer.appId, bo.bc(optString2, "{}"), str, 0));
        }
        qVar.M(i, j("ok", null));
        if (!bo.isNullOrNil(str)) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130494);
                    qVar.getRuntime().finish();
                    AppMethodBeat.o(130494);
                }
            }, 1000);
        }
        AppMethodBeat.o(130501);
    }
}
