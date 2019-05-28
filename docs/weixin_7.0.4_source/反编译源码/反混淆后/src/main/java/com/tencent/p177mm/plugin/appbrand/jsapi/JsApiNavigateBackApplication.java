package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.p177mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication */
public final class JsApiNavigateBackApplication extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 288;
    public static final String NAME = "navigateBackApplication";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication$NavigateBackAppTask */
    public static final class NavigateBackAppTask extends MainProcessTask {
        public static final Creator<NavigateBackAppTask> CREATOR = new C102871();
        public String appId;
        public String businessType;
        public String data;
        public int errCode;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication$NavigateBackAppTask$1 */
        static class C102871 implements Creator<NavigateBackAppTask> {
            C102871() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new NavigateBackAppTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130495);
                NavigateBackAppTask navigateBackAppTask = new NavigateBackAppTask();
                navigateBackAppTask.mo6032g(parcel);
                AppMethodBeat.m2505o(130495);
                return navigateBackAppTask;
            }
        }

        public NavigateBackAppTask(String str, String str2, String str3, int i) {
            this.appId = str;
            this.data = str2;
            this.businessType = str3;
            this.errCode = i;
        }

        public final void asP() {
            AppMethodBeat.m2504i(130496);
            C40439f bT = C46494g.m87739bT(this.appId, true);
            C4990ab.m7417i("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appid %s", this.appId);
            if (bT == null) {
                C4990ab.m7420w("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appinfo is null");
                AppMethodBeat.m2505o(130496);
                return;
            }
            Bundle bundle = new Bundle();
            if (C5046bo.isNullOrNil(this.businessType)) {
                Resp resp = new Resp(bundle);
                resp.extMsg = this.data;
                resp.openId = bT.field_openId;
                NavigateBackAppTask.m25551a(bundle, resp, bT);
                AppMethodBeat.m2505o(130496);
                return;
            }
            WXOpenBusinessView.Resp resp2 = new WXOpenBusinessView.Resp(bundle);
            resp2.extMsg = this.data;
            resp2.openId = bT.field_openId;
            resp2.errCode = this.errCode;
            resp2.businessType = this.businessType;
            NavigateBackAppTask.m25551a(bundle, resp2, bT);
            AppMethodBeat.m2505o(130496);
        }

        /* renamed from: a */
        private static void m25551a(Bundle bundle, BaseResp baseResp, C40439f c40439f) {
            AppMethodBeat.m2504i(130497);
            baseResp.toBundle(bundle);
            Args args = new Args();
            args.targetPkgName = c40439f.field_packageName;
            args.bundle = bundle;
            C35799p.m58687at(bundle);
            C35799p.m58688au(bundle);
            MMessageActV2.send(C4996ah.getContext(), args);
            AppMethodBeat.m2505o(130497);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130498);
            parcel.writeString(this.appId);
            parcel.writeString(this.data);
            parcel.writeString(this.businessType);
            parcel.writeInt(this.errCode);
            AppMethodBeat.m2505o(130498);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130499);
            this.appId = parcel.readString();
            this.data = parcel.readString();
            this.businessType = parcel.readString();
            this.errCode = parcel.readInt();
            AppMethodBeat.m2505o(130499);
        }

        static {
            AppMethodBeat.m2504i(130500);
            AppMethodBeat.m2505o(130500);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        String str;
        AppMethodBeat.m2504i(130501);
        final C38492q c38492q = (C38492q) c2241c;
        AppBrandLaunchReferrer appBrandLaunchReferrer = c38492q.getRuntime().mo15035yf().hgF;
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("extraData");
        if (appBrandLaunchReferrer != null) {
            str = appBrandLaunchReferrer.businessType;
        } else {
            str = null;
        }
        if (c38492q.getRuntime() instanceof C41243o) {
            C41243o c41243o = (C41243o) c38492q.getRuntime();
            if (appBrandLaunchReferrer != null && appBrandLaunchReferrer.hgQ == 4 && OpenBusinessViewUtil.m30040l(c41243o)) {
                C4990ab.m7417i("MicroMsg.JsApiNavigateBackApplication", "navigate back Application, businessType:%s", appBrandLaunchReferrer.businessType);
                C38450n.m65049xb(c38492q.getAppId()).gPn = true;
            }
        }
        if (!C5046bo.isNullOrNil(optString)) {
            AppBrandMainProcessService.m54349a(new NavigateBackAppTask(optString, C5046bo.m7532bc(optString2, "{}"), str, 0));
        } else if (C5046bo.isNullOrNil(appBrandLaunchReferrer.appId) || !(appBrandLaunchReferrer.hgQ == 4 || appBrandLaunchReferrer.hgQ == 7)) {
            C4990ab.m7421w("MicroMsg.JsApiNavigateBackApplication", "navigateBackApplication appid %s,launchScene %d", appBrandLaunchReferrer.appId, Integer.valueOf(appBrandLaunchReferrer.hgQ));
            c38492q.mo6107M(i, mo73394j("fail:not from opensdk", null));
            AppMethodBeat.m2505o(130501);
            return;
        } else {
            AppBrandMainProcessService.m54349a(new NavigateBackAppTask(appBrandLaunchReferrer.appId, C5046bo.m7532bc(optString2, "{}"), str, 0));
        }
        c38492q.mo6107M(i, mo73394j("ok", null));
        if (!C5046bo.isNullOrNil(str)) {
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(130494);
                    c38492q.getRuntime().finish();
                    AppMethodBeat.m2505o(130494);
                }
            }, 1000);
        }
        AppMethodBeat.m2505o(130501);
    }
}
