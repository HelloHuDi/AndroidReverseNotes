package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import junit.framework.Assert;
import org.json.JSONObject;

public final class JsApiLaunchMiniProgram extends a<b> {
    public static final int CTRL_INDEX = 166;
    public static final String NAME = "launchMiniProgram";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram$2 */
    class AnonymousClass2 implements c {
        final /* synthetic */ int eIl;
        final /* synthetic */ b hQG;
        final /* synthetic */ String hQJ;
        final /* synthetic */ int hQK;

        AnonymousClass2(String str, int i, b bVar, int i2) {
            this.hQJ = str;
            this.hQK = i;
            this.hQG = bVar;
            this.eIl = i2;
        }

        public final void bk(Object obj) {
            AppMethodBeat.i(131324);
            if (obj instanceof LaunchBroadCast) {
                LaunchBroadCast launchBroadCast = (LaunchBroadCast) obj;
                if (this.hQJ.equals(launchBroadCast.appId) && this.hQK == launchBroadCast.har) {
                    String str;
                    MMToClientEvent.b(this.hQG.getAppId(), this);
                    b bVar = this.hQG;
                    int i = this.eIl;
                    JsApiLaunchMiniProgram jsApiLaunchMiniProgram = JsApiLaunchMiniProgram.this;
                    if (launchBroadCast.cQe) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    bVar.M(i, jsApiLaunchMiniProgram.j(str, null));
                }
            }
            AppMethodBeat.o(131324);
        }
    }

    static final class LaunchPreconditionTask extends MainProcessTask {
        public static final Creator<LaunchPreconditionTask> CREATOR = new Creator<LaunchPreconditionTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchPreconditionTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131325);
                LaunchPreconditionTask launchPreconditionTask = new LaunchPreconditionTask(parcel);
                AppMethodBeat.o(131325);
                return launchPreconditionTask;
            }
        };
        private String hQL;
        private int hQM;
        private int hQN = a.FAIL.ordinal();

        enum a {
            FAIL("fail"),
            FAIL_MORE_THAN_ONE_TASK("fail can not launch more than 1 mini program"),
            OK("ok");
            
            public final String bzH;

            static {
                AppMethodBeat.o(131329);
            }

            private a(String str) {
                this.bzH = str;
            }

            public static a ou(int i) {
                AppMethodBeat.i(131328);
                for (a aVar : values()) {
                    if (i == aVar.ordinal()) {
                        AppMethodBeat.o(131328);
                        return aVar;
                    }
                }
                AppMethodBeat.o(131328);
                return null;
            }
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(131330);
            this.hQL = parcel.readString();
            this.hQM = parcel.readInt();
            this.hQN = parcel.readInt();
            AppMethodBeat.o(131330);
        }

        public final void asP() {
            AppMethodBeat.i(131331);
            h.DS(this.hQL);
            this.hQN = a.OK.ordinal();
            AppMethodBeat.o(131331);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131332);
            parcel.writeString(this.hQL);
            parcel.writeInt(this.hQM);
            parcel.writeInt(this.hQN);
            AppMethodBeat.o(131332);
        }

        LaunchPreconditionTask() {
            AppMethodBeat.i(131333);
            AppMethodBeat.o(131333);
        }

        LaunchPreconditionTask(Parcel parcel) {
            AppMethodBeat.i(131334);
            g(parcel);
            AppMethodBeat.o(131334);
        }

        static {
            AppMethodBeat.i(131335);
            AppMethodBeat.o(131335);
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        int i2 = 1;
        AppMethodBeat.i(131336);
        final b bVar = (b) cVar;
        final String optString = jSONObject.optString("appId", null);
        if (bo.isNullOrNil(optString)) {
            bVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131336);
        } else if (optString.equals(bVar.getAppId())) {
            bVar.M(i, j("fail target appId is the same as the caller appId", null));
            AppMethodBeat.o(131336);
        } else {
            final String optString2 = jSONObject.optString("path", null);
            final String optString3 = jSONObject.optString("extraData", null);
            if (!(bVar.xL().xZ().hhd.gVt == 1 && jSONObject.optBoolean("isDev", false))) {
                i2 = 0;
            }
            final int i3 = i;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(131323);
                    JsApiLaunchMiniProgram jsApiLaunchMiniProgram = JsApiLaunchMiniProgram.this;
                    b bVar = bVar;
                    String str = optString;
                    int i = i2;
                    String str2 = optString2;
                    String str3 = optString3;
                    int i2 = i3;
                    MainProcessTask launchPreconditionTask = new LaunchPreconditionTask();
                    launchPreconditionTask.hQL = str;
                    launchPreconditionTask.hQM = i;
                    if (AppBrandMainProcessService.b(launchPreconditionTask)) {
                        a ou = a.ou(launchPreconditionTask.hQN);
                        if (ou == null) {
                            ou = a.FAIL;
                        }
                        if (a.OK != ou) {
                            bVar.M(i2, jsApiLaunchMiniProgram.j(ou.bzH, null));
                            AppMethodBeat.o(131323);
                            return;
                        }
                        g.a(bVar.getAppId(), d.LAUNCH_MINI_PROGRAM);
                        MMToClientEvent.a(bVar.getAppId(), new AnonymousClass2(str, i, bVar, i2));
                        if (!(bVar.getContext() == null || !(bVar.getContext() instanceof Activity) || ((Activity) bVar.getContext()).isFinishing())) {
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_2;
                            AppBrandStatObject appBrandStatObject2 = bVar.xL().ya().bQn;
                            if (appBrandStatObject2 != null) {
                                appBrandStatObject.cOo = appBrandStatObject2.cOo;
                            }
                            String str4 = "";
                            com.tencent.luggage.sdk.a.a.a xV = bVar.xV();
                            if (xV != null) {
                                str4 = xV.aBm();
                            }
                            appBrandStatObject.cst = bVar.getAppId() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bVar.xL().ya().xz();
                            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                            appBrandLaunchReferrer.appId = bVar.getAppId();
                            appBrandLaunchReferrer.cFM = str3;
                            appBrandLaunchReferrer.hgQ = 1;
                            appBrandLaunchReferrer.url = str4;
                            AppBrandLaunchProxyUI.a(bVar.getContext(), null, str, str2, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
                            Assert.assertTrue(true);
                        }
                        AppMethodBeat.o(131323);
                        return;
                    }
                    bVar.M(i2, jsApiLaunchMiniProgram.j("fail precondition error", null));
                    AppMethodBeat.o(131323);
                }
            });
            AppMethodBeat.o(131336);
        }
    }
}
