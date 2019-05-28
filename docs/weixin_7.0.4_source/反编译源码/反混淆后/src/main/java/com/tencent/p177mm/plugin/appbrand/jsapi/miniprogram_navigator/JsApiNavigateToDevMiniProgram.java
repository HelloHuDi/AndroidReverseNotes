package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2323c;
import com.tencent.p177mm.plugin.appbrand.launching.C42611l;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram */
public final class JsApiNavigateToDevMiniProgram extends C16672a {
    private static final int CTRL_INDEX = 351;
    private static final String NAME = "navigateToDevMiniProgram";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram$DevPkgInfo */
    static final class DevPkgInfo implements Parcelable {
        public static final Creator<DevPkgInfo> CREATOR = new C104851();
        String appId;
        String cOj;
        String cOk;
        String hQT;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram$DevPkgInfo$1 */
        static class C104851 implements Creator<DevPkgInfo> {
            C104851() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DevPkgInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131338);
                DevPkgInfo devPkgInfo = new DevPkgInfo(parcel);
                AppMethodBeat.m2505o(131338);
                return devPkgInfo;
            }
        }

        DevPkgInfo() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131339);
            parcel.writeString(this.appId);
            parcel.writeString(this.cOj);
            parcel.writeString(this.cOk);
            parcel.writeString(this.hQT);
            AppMethodBeat.m2505o(131339);
        }

        DevPkgInfo(Parcel parcel) {
            AppMethodBeat.m2504i(131340);
            this.appId = parcel.readString();
            this.cOj = parcel.readString();
            this.cOk = parcel.readString();
            this.hQT = parcel.readString();
            AppMethodBeat.m2505o(131340);
        }

        static {
            AppMethodBeat.m2504i(131341);
            AppMethodBeat.m2505o(131341);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram$a */
    static final class C33375a implements C45413i<DevPkgInfo, IPCVoid> {
        private C33375a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(131342);
            DevPkgInfo devPkgInfo = (DevPkgInfo) obj;
            ((C42611l) ((C0997b) C37384e.m62985B(C0997b.class)).mo3973E(C42611l.class)).mo68053n(devPkgInfo.appId, 1, devPkgInfo.hQT);
            if (((C0997b) C37384e.m62985B(C0997b.class)).mo3974xF().mo60848a(devPkgInfo.appId, 1, devPkgInfo.cOj, devPkgInfo.cOk, 0, C5046bo.anT() + 7200)) {
                C45694h.m84422bt(devPkgInfo.appId, 1);
            }
            IPCVoid iPCVoid = IPCVoid.eGH;
            AppMethodBeat.m2505o(131342);
            return iPCVoid;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131343);
        final C2119d c2119d = (C2119d) c2241c;
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("downloadURL");
        String optString3 = jSONObject.optString("checkSumMd5");
        C2319b a = C2319b.m4539a(jSONObject.optString("envVersion"), C2319b.DEVELOP);
        String optString4 = jSONObject.optString("relativeURL");
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        String optString5 = jSONObject.optString("extoptions");
        if (C5046bo.isNullOrNil(optString)) {
            c2119d.mo6107M(i, mo73394j("fail:appID is empty", null));
            AppMethodBeat.m2505o(131343);
        } else if (C2319b.DEVELOP == a && (C5046bo.isNullOrNil(optString2) || C5046bo.isNullOrNil(optString3))) {
            c2119d.mo6107M(i, mo73394j("fail invalid downloadURL & checkSumMd5", null));
            AppMethodBeat.m2505o(131343);
        } else {
            if (C2319b.DEVELOP == a) {
                DevPkgInfo devPkgInfo = new DevPkgInfo();
                devPkgInfo.appId = optString;
                devPkgInfo.cOj = optString2;
                devPkgInfo.cOk = optString3;
                devPkgInfo.hQT = optString5;
                C9549f.m17010a(C4996ah.getPackageName(), devPkgInfo, C33375a.class);
            }
            C27039k.hRd.mo6194a(c2119d, optString, a.har, optString4, null, optJSONObject, null, new C2323c() {
                /* renamed from: dY */
                public final void mo6193dY(boolean z) {
                    String str;
                    AppMethodBeat.m2504i(131337);
                    C2119d c2119d = c2119d;
                    int i = i;
                    JsApiNavigateToDevMiniProgram jsApiNavigateToDevMiniProgram = JsApiNavigateToDevMiniProgram.this;
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    c2119d.mo6107M(i, jsApiNavigateToDevMiniProgram.mo73394j(str, null));
                    AppMethodBeat.m2505o(131337);
                }
            });
            AppMethodBeat.m2505o(131343);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final C2320c aDv() {
        return C27039k.hRd;
    }
}
