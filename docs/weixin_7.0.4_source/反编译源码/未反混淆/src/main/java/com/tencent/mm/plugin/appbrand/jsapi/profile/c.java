package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.f.b.j;
import a.l;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c> {
    private static final int CTRL_INDEX = 508;
    private static final String NAME = "profile";
    public static final a hUM = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class b<R extends ProcessResult> implements com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b<ProfileResult> {
        final /* synthetic */ int hBE;
        final /* synthetic */ String hBP;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.c hUH;
        final /* synthetic */ String hUI;
        final /* synthetic */ int hUJ;
        final /* synthetic */ c hUN;

        b(c cVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar2, int i, String str, int i2, String str2) {
            this.hUN = cVar;
            this.hUH = cVar2;
            this.hBE = i;
            this.hUI = str;
            this.hUJ = i2;
            this.hBP = str2;
        }

        public final /* synthetic */ void c(ProcessResult processResult) {
            AppMethodBeat.i(134693);
            ProfileResult profileResult = (ProfileResult) processResult;
            ab.i("MicroMsg.JsApiProfile", "onReceiveResult resultCode:%d", Integer.valueOf(profileResult.bFZ));
            switch (profileResult.bFZ) {
                case 0:
                    this.hUH.M(this.hBE, this.hUN.AK("fail"));
                    AppMethodBeat.o(134693);
                    return;
                case 1:
                    Intent intent = new Intent();
                    if (!bo.isNullOrNil(this.hUI)) {
                        intent.putExtra("key_add_contact_report_info", this.hUI);
                    }
                    if ((profileResult.hUO & 1) != 0) {
                        intent.putExtra("Contact_Scene", this.hUJ);
                    }
                    intent.putExtra("Contact_User", this.hBP);
                    intent.putExtra("key_use_new_contact_profile", true);
                    d.b(this.hUH.getContext(), "profile", ".ui.ContactInfoUI", intent);
                    this.hUH.M(this.hBE, this.hUN.AK("ok"));
                    AppMethodBeat.o(134693);
                    return;
                case 2:
                    this.hUH.M(this.hBE, this.hUN.AK("cancel"));
                    AppMethodBeat.o(134693);
                    return;
                default:
                    this.hUH.M(this.hBE, this.hUN.AK("fail"));
                    AppMethodBeat.o(134693);
                    return;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(134694);
        j.p(cVar, "env");
        j.p(jSONObject, "data");
        String optString = jSONObject.optString("username");
        int optInt = jSONObject.optInt("scene", 122);
        String optString2 = jSONObject.optString("profileReportInfo");
        if (bo.isNullOrNil(optString)) {
            cVar.M(i, AK("fail:invalid data"));
            AppMethodBeat.o(134694);
            return;
        }
        ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.username = optString;
        profileRequest.scene = optInt;
        com.tencent.mm.plugin.appbrand.ipc.a.a(cVar.getContext(), profileRequest, new b(this, cVar, i, optString2, optInt, optString));
        AppMethodBeat.o(134694);
    }

    static {
        AppMethodBeat.i(134695);
        AppMethodBeat.o(134695);
    }
}
