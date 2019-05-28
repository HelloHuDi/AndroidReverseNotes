package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiMakeVoIPCall extends a<s> {
    public static final int CTRL_INDEX = 154;
    public static final String NAME = "makeVoIPCall";

    static class StartVoIPCall extends MainProcessTask {
        public static final Creator<StartVoIPCall> CREATOR = new Creator<StartVoIPCall>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartVoIPCall[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130484);
                StartVoIPCall startVoIPCall = new StartVoIPCall(parcel);
                AppMethodBeat.o(130484);
                return startVoIPCall;
            }
        };
        private int hwi;
        private m hwz;
        private c hxS;
        private c hxT = new c<sh>() {
            {
                AppMethodBeat.i(130482);
                this.xxI = sh.class.getName().hashCode();
                AppMethodBeat.o(130482);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(130483);
                sh shVar = (sh) bVar;
                if (shVar != null && (shVar instanceof sh)) {
                    StartVoIPCall.this.status = shVar.cOB.status;
                    a.xxA.d(StartVoIPCall.this.hxT);
                    StartVoIPCall.b(StartVoIPCall.this);
                }
                AppMethodBeat.o(130483);
                return false;
            }
        };
        public int status;

        static /* synthetic */ boolean b(StartVoIPCall startVoIPCall) {
            AppMethodBeat.i(130491);
            boolean aCb = startVoIPCall.aCb();
            AppMethodBeat.o(130491);
            return aCb;
        }

        public StartVoIPCall(m mVar, c cVar, int i) {
            AppMethodBeat.i(130485);
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
            AppMethodBeat.o(130485);
        }

        public StartVoIPCall(Parcel parcel) {
            AppMethodBeat.i(130486);
            g(parcel);
            AppMethodBeat.o(130486);
        }

        public final void asP() {
            AppMethodBeat.i(130487);
            a.xxA.c(this.hxT);
            AppMethodBeat.o(130487);
        }

        public final void asQ() {
            AppMethodBeat.i(130488);
            aBW();
            ab.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", Integer.valueOf(this.status));
            if (this.status == 1) {
                this.hxS.M(this.hwi, this.hwz.j("cancel", null));
                AppMethodBeat.o(130488);
            } else if (this.status == 2) {
                this.hxS.M(this.hwi, this.hwz.j("ok", null));
                AppMethodBeat.o(130488);
            } else if (this.status == 3) {
                this.hxS.M(this.hwi, this.hwz.j("fail:network error", null));
                AppMethodBeat.o(130488);
            } else if (this.status == 4) {
                this.hxS.M(this.hwi, this.hwz.j("fail:param not match", null));
                AppMethodBeat.o(130488);
            } else {
                this.hxS.M(this.hwi, this.hwz.j("fail:unknow", null));
                AppMethodBeat.o(130488);
            }
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130489);
            this.status = parcel.readInt();
            AppMethodBeat.o(130489);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130490);
            parcel.writeInt(this.status);
            AppMethodBeat.o(130490);
        }

        static {
            AppMethodBeat.i(130492);
            AppMethodBeat.o(130492);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130493);
        s sVar = (s) cVar;
        String optString = jSONObject.optString("context");
        String optString2 = jSONObject.optString("avatarUrl");
        boolean optBoolean = jSONObject.optBoolean("showOther");
        boolean optBoolean2 = jSONObject.optBoolean("allowBackCamera");
        String optString3 = jSONObject.optString("toUserName");
        String nullAsNil = bo.nullAsNil(jSONObject.optString("scene"));
        String nullAsNil2 = bo.nullAsNil(jSONObject.optString("type"));
        if (bo.isNullOrNil(optString3)) {
            optString3 = sVar.getRuntime().atI().username;
        }
        if (bo.isNullOrNil(sVar.getAppId()) || bo.isNullOrNil(optString3)) {
            ab.e("MicroMsg.JsApiMakeVoIPCall", "appId or toUserName invalid!");
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(130493);
            return;
        }
        ab.d("MicroMsg.JsApiMakeVoIPCall", "allowBackCamera: %s, showOther: %s, avatarUrl: %s, context: %s, toUserName: %s", Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean), optString2, optString, optString3);
        MainProcessTask startVoIPCall = new StartVoIPCall(this, sVar, i);
        startVoIPCall.aBV();
        AppBrandMainProcessService.a(startVoIPCall);
        Intent intent = new Intent();
        intent.putExtra("voipCSBizId", optString3);
        intent.putExtra("voipCSAppId", sVar.getAppId());
        intent.putExtra("voipCSAllowBackCamera", optBoolean2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        intent.putExtra("voipCSShowOther", optBoolean ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        intent.putExtra("voipCSAvatarUrl", optString2);
        intent.putExtra("voipCSContext", optString);
        intent.putExtra("voipCSScene", nullAsNil);
        intent.putExtra("voipCSType", nullAsNil2);
        intent.putExtra("launch_from_appbrand", true);
        intent.setClassName(sVar.getContext(), sVar.getContext().getPackageName() + ".plugin.voip_cs.ui.VoipCSMainUI");
        AppBrandProcessProxyUI.n(sVar.getContext(), intent);
        AppMethodBeat.o(130493);
    }
}
