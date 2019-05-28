package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32630sh;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall */
public final class JsApiMakeVoIPCall extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 154;
    public static final String NAME = "makeVoIPCall";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall$StartVoIPCall */
    static class StartVoIPCall extends MainProcessTask {
        public static final Creator<StartVoIPCall> CREATOR = new C332242();
        private int hwi;
        private C45608m hwz;
        private C2241c hxS;
        private C4884c hxT = new C332231();
        public int status;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall$StartVoIPCall$1 */
        class C332231 extends C4884c<C32630sh> {
            C332231() {
                AppMethodBeat.m2504i(130482);
                this.xxI = C32630sh.class.getName().hashCode();
                AppMethodBeat.m2505o(130482);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(130483);
                C32630sh c32630sh = (C32630sh) c4883b;
                if (c32630sh != null && (c32630sh instanceof C32630sh)) {
                    StartVoIPCall.this.status = c32630sh.cOB.status;
                    C4879a.xxA.mo10053d(StartVoIPCall.this.hxT);
                    StartVoIPCall.m54362b(StartVoIPCall.this);
                }
                AppMethodBeat.m2505o(130483);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall$StartVoIPCall$2 */
        static class C332242 implements Creator<StartVoIPCall> {
            C332242() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartVoIPCall[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130484);
                StartVoIPCall startVoIPCall = new StartVoIPCall(parcel);
                AppMethodBeat.m2505o(130484);
                return startVoIPCall;
            }
        }

        /* renamed from: b */
        static /* synthetic */ boolean m54362b(StartVoIPCall startVoIPCall) {
            AppMethodBeat.m2504i(130491);
            boolean aCb = startVoIPCall.aCb();
            AppMethodBeat.m2505o(130491);
            return aCb;
        }

        public StartVoIPCall(C45608m c45608m, C2241c c2241c, int i) {
            AppMethodBeat.m2504i(130485);
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
            AppMethodBeat.m2505o(130485);
        }

        public StartVoIPCall(Parcel parcel) {
            AppMethodBeat.m2504i(130486);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130486);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130487);
            C4879a.xxA.mo10052c(this.hxT);
            AppMethodBeat.m2505o(130487);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130488);
            aBW();
            C4990ab.m7417i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", Integer.valueOf(this.status));
            if (this.status == 1) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("cancel", null));
                AppMethodBeat.m2505o(130488);
            } else if (this.status == 2) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
                AppMethodBeat.m2505o(130488);
            } else if (this.status == 3) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail:network error", null));
                AppMethodBeat.m2505o(130488);
            } else if (this.status == 4) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail:param not match", null));
                AppMethodBeat.m2505o(130488);
            } else {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail:unknow", null));
                AppMethodBeat.m2505o(130488);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130489);
            this.status = parcel.readInt();
            AppMethodBeat.m2505o(130489);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130490);
            parcel.writeInt(this.status);
            AppMethodBeat.m2505o(130490);
        }

        static {
            AppMethodBeat.m2504i(130492);
            AppMethodBeat.m2505o(130492);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130493);
        C19722s c19722s = (C19722s) c2241c;
        String optString = jSONObject.optString("context");
        String optString2 = jSONObject.optString("avatarUrl");
        boolean optBoolean = jSONObject.optBoolean("showOther");
        boolean optBoolean2 = jSONObject.optBoolean("allowBackCamera");
        String optString3 = jSONObject.optString("toUserName");
        String nullAsNil = C5046bo.nullAsNil(jSONObject.optString("scene"));
        String nullAsNil2 = C5046bo.nullAsNil(jSONObject.optString("type"));
        if (C5046bo.isNullOrNil(optString3)) {
            optString3 = c19722s.getRuntime().atI().username;
        }
        if (C5046bo.isNullOrNil(c19722s.getAppId()) || C5046bo.isNullOrNil(optString3)) {
            C4990ab.m7412e("MicroMsg.JsApiMakeVoIPCall", "appId or toUserName invalid!");
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130493);
            return;
        }
        C4990ab.m7411d("MicroMsg.JsApiMakeVoIPCall", "allowBackCamera: %s, showOther: %s, avatarUrl: %s, context: %s, toUserName: %s", Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean), optString2, optString, optString3);
        MainProcessTask startVoIPCall = new StartVoIPCall(this, c19722s, i);
        startVoIPCall.aBV();
        AppBrandMainProcessService.m54349a(startVoIPCall);
        Intent intent = new Intent();
        intent.putExtra("voipCSBizId", optString3);
        intent.putExtra("voipCSAppId", c19722s.getAppId());
        intent.putExtra("voipCSAllowBackCamera", optBoolean2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        intent.putExtra("voipCSShowOther", optBoolean ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        intent.putExtra("voipCSAvatarUrl", optString2);
        intent.putExtra("voipCSContext", optString);
        intent.putExtra("voipCSScene", nullAsNil);
        intent.putExtra("voipCSType", nullAsNil2);
        intent.putExtra("launch_from_appbrand", true);
        intent.setClassName(c19722s.getContext(), c19722s.getContext().getPackageName() + ".plugin.voip_cs.ui.VoipCSMainUI");
        AppBrandProcessProxyUI.m64718n(c19722s.getContext(), intent);
        AppMethodBeat.m2505o(130493);
    }
}
