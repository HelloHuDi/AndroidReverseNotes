package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent.C38244c;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.LaunchBroadCast;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import junit.framework.Assert;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram */
public final class JsApiLaunchMiniProgram extends C10296a<C45126b> {
    public static final int CTRL_INDEX = 166;
    public static final String NAME = "launchMiniProgram";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram$2 */
    class C425482 implements C38244c {
        final /* synthetic */ int eIl;
        final /* synthetic */ C45126b hQG;
        final /* synthetic */ String hQJ;
        final /* synthetic */ int hQK;

        C425482(String str, int i, C45126b c45126b, int i2) {
            this.hQJ = str;
            this.hQK = i;
            this.hQG = c45126b;
            this.eIl = i2;
        }

        /* renamed from: bk */
        public final void mo22088bk(Object obj) {
            AppMethodBeat.m2504i(131324);
            if (obj instanceof LaunchBroadCast) {
                LaunchBroadCast launchBroadCast = (LaunchBroadCast) obj;
                if (this.hQJ.equals(launchBroadCast.appId) && this.hQK == launchBroadCast.har) {
                    String str;
                    MMToClientEvent.m75200b(this.hQG.getAppId(), this);
                    C45126b c45126b = this.hQG;
                    int i = this.eIl;
                    JsApiLaunchMiniProgram jsApiLaunchMiniProgram = JsApiLaunchMiniProgram.this;
                    if (launchBroadCast.cQe) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    c45126b.mo6107M(i, jsApiLaunchMiniProgram.mo73394j(str, null));
                }
            }
            AppMethodBeat.m2505o(131324);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram$LaunchPreconditionTask */
    static final class LaunchPreconditionTask extends MainProcessTask {
        public static final Creator<LaunchPreconditionTask> CREATOR = new C104841();
        private String hQL;
        private int hQM;
        private int hQN = C33374a.FAIL.ordinal();

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram$LaunchPreconditionTask$1 */
        static class C104841 implements Creator<LaunchPreconditionTask> {
            C104841() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchPreconditionTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131325);
                LaunchPreconditionTask launchPreconditionTask = new LaunchPreconditionTask(parcel);
                AppMethodBeat.m2505o(131325);
                return launchPreconditionTask;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram$LaunchPreconditionTask$a */
        enum C33374a {
            FAIL("fail"),
            FAIL_MORE_THAN_ONE_TASK("fail can not launch more than 1 mini program"),
            OK("ok");
            
            public final String bzH;

            static {
                AppMethodBeat.m2505o(131329);
            }

            private C33374a(String str) {
                this.bzH = str;
            }

            /* renamed from: ou */
            public static C33374a m54564ou(int i) {
                AppMethodBeat.m2504i(131328);
                for (C33374a c33374a : C33374a.values()) {
                    if (i == c33374a.ordinal()) {
                        AppMethodBeat.m2505o(131328);
                        return c33374a;
                    }
                }
                AppMethodBeat.m2505o(131328);
                return null;
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(131330);
            this.hQL = parcel.readString();
            this.hQM = parcel.readInt();
            this.hQN = parcel.readInt();
            AppMethodBeat.m2505o(131330);
        }

        public final void asP() {
            AppMethodBeat.m2504i(131331);
            C45694h.m84416DS(this.hQL);
            this.hQN = C33374a.OK.ordinal();
            AppMethodBeat.m2505o(131331);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131332);
            parcel.writeString(this.hQL);
            parcel.writeInt(this.hQM);
            parcel.writeInt(this.hQN);
            AppMethodBeat.m2505o(131332);
        }

        LaunchPreconditionTask() {
            AppMethodBeat.m2504i(131333);
            AppMethodBeat.m2505o(131333);
        }

        LaunchPreconditionTask(Parcel parcel) {
            AppMethodBeat.m2504i(131334);
            mo6032g(parcel);
            AppMethodBeat.m2505o(131334);
        }

        static {
            AppMethodBeat.m2504i(131335);
            AppMethodBeat.m2505o(131335);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(131336);
        final C45126b c45126b = (C45126b) c2241c;
        final String optString = jSONObject.optString("appId", null);
        if (C5046bo.isNullOrNil(optString)) {
            c45126b.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131336);
        } else if (optString.equals(c45126b.getAppId())) {
            c45126b.mo6107M(i, mo73394j("fail target appId is the same as the caller appId", null));
            AppMethodBeat.m2505o(131336);
        } else {
            final String optString2 = jSONObject.optString("path", null);
            final String optString3 = jSONObject.optString("extraData", null);
            if (!(c45126b.mo34954xL().mo43489xZ().hhd.gVt == 1 && jSONObject.optBoolean("isDev", false))) {
                i2 = 0;
            }
            final int i3 = i;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(131323);
                    JsApiLaunchMiniProgram jsApiLaunchMiniProgram = JsApiLaunchMiniProgram.this;
                    C45126b c45126b = c45126b;
                    String str = optString;
                    int i = i2;
                    String str2 = optString2;
                    String str3 = optString3;
                    int i2 = i3;
                    MainProcessTask launchPreconditionTask = new LaunchPreconditionTask();
                    launchPreconditionTask.hQL = str;
                    launchPreconditionTask.hQM = i;
                    if (AppBrandMainProcessService.m54355b(launchPreconditionTask)) {
                        C33374a ou = C33374a.m54564ou(launchPreconditionTask.hQN);
                        if (ou == null) {
                            ou = C33374a.FAIL;
                        }
                        if (C33374a.OK != ou) {
                            c45126b.mo6107M(i2, jsApiLaunchMiniProgram.mo73394j(ou.bzH, null));
                            AppMethodBeat.m2505o(131323);
                            return;
                        }
                        C33183g.m54275a(c45126b.getAppId(), C33184d.LAUNCH_MINI_PROGRAM);
                        MMToClientEvent.m75199a(c45126b.getAppId(), new C425482(str, i, c45126b, i2));
                        if (!(c45126b.getContext() == null || !(c45126b.getContext() instanceof Activity) || ((Activity) c45126b.getContext()).isFinishing())) {
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_2;
                            AppBrandStatObject appBrandStatObject2 = c45126b.mo34954xL().mo43491ya().bQn;
                            if (appBrandStatObject2 != null) {
                                appBrandStatObject.cOo = appBrandStatObject2.cOo;
                            }
                            String str4 = "";
                            C37402a xV = c45126b.mo34955xV();
                            if (xV != null) {
                                str4 = xV.aBm();
                            }
                            appBrandStatObject.cst = c45126b.getAppId() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c45126b.mo34954xL().mo43491ya().mo32993xz();
                            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                            appBrandLaunchReferrer.appId = c45126b.getAppId();
                            appBrandLaunchReferrer.cFM = str3;
                            appBrandLaunchReferrer.hgQ = 1;
                            appBrandLaunchReferrer.url = str4;
                            AppBrandLaunchProxyUI.m25694a(c45126b.getContext(), null, str, str2, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
                            Assert.assertTrue(true);
                        }
                        AppMethodBeat.m2505o(131323);
                        return;
                    }
                    c45126b.mo6107M(i2, jsApiLaunchMiniProgram.mo73394j("fail precondition error", null));
                    AppMethodBeat.m2505o(131323);
                }
            });
            AppMethodBeat.m2505o(131336);
        }
    }
}
