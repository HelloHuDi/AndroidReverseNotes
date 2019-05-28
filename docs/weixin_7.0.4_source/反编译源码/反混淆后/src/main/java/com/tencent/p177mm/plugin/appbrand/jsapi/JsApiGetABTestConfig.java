package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.expt.p396d.C3006b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5141c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig */
public final class JsApiGetABTestConfig extends C19497u<C38492q> {
    public static final int CTRL_INDEX = 527;
    public static final String NAME = "getABTestConfig";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig$GetABTestConfigTask */
    public static class GetABTestConfigTask extends MainProcessTask {
        public static final Creator<GetABTestConfigTask> CREATOR = new C102861();
        private String hwO;
        private Map<String, String> hwP = new HashMap();

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig$GetABTestConfigTask$1 */
        static class C102861 implements Creator<GetABTestConfigTask> {
            C102861() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetABTestConfigTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130414);
                GetABTestConfigTask getABTestConfigTask = new GetABTestConfigTask(parcel);
                AppMethodBeat.m2505o(130414);
                return getABTestConfigTask;
            }
        }

        GetABTestConfigTask(String str) {
            AppMethodBeat.m2504i(138127);
            this.hwO = str;
            AppMethodBeat.m2505o(138127);
        }

        GetABTestConfigTask(Parcel parcel) {
            AppMethodBeat.m2504i(130416);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130416);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130417);
            C4990ab.m7416i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
            C5141c ll = C18624c.abi().mo17131ll(this.hwO);
            if (ll.isValid()) {
                this.hwP.putAll(ll.dru());
            }
            aCb();
            AppMethodBeat.m2505o(130417);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130418);
            AppMethodBeat.m2505o(130418);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130419);
            this.hwP.clear();
            this.hwP.putAll(parcel.readHashMap(HashMap.class.getClassLoader()));
            this.hwO = parcel.readString();
            AppMethodBeat.m2505o(130419);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130420);
            parcel.writeMap(this.hwP);
            parcel.writeString(this.hwO);
            AppMethodBeat.m2505o(130420);
        }

        static {
            AppMethodBeat.m2504i(130421);
            AppMethodBeat.m2505o(130421);
        }
    }

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(138128);
        C4990ab.m7416i("MicroMsg.JsApiGetABTestConfig", "JSONObject = ".concat(String.valueOf(jSONObject)));
        String optString = jSONObject.optString("experimentId");
        boolean equals = "Expt".equals(jSONObject.optString("experimentType"));
        if (TextUtils.isEmpty(optString)) {
            optString = mo73394j("fail:experimentId is empty", null);
            AppMethodBeat.m2505o(138128);
            return optString;
        } else if (equals) {
            HashMap hashMap = new HashMap();
            hashMap.put("testConfig", C3006b.brr().mo7215b(optString, "", true, true));
            optString = mo73394j("ok", hashMap);
            AppMethodBeat.m2505o(138128);
            return optString;
        } else {
            MainProcessTask getABTestConfigTask = new GetABTestConfigTask(optString);
            if (AppBrandMainProcessService.m54355b(getABTestConfigTask)) {
                C4990ab.m7416i("MicroMsg.JsApiGetABTestConfig", " configs = " + getABTestConfigTask.hwP);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("testConfig", getABTestConfigTask.hwP);
                optString = mo73394j("ok", hashMap2);
                AppMethodBeat.m2505o(138128);
                return optString;
            }
            optString = mo73394j("fail:fail:internal error", null);
            AppMethodBeat.m2505o(138128);
            return optString;
        }
    }
}
