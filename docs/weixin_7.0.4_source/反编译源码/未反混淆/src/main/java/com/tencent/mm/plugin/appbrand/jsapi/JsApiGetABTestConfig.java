package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetABTestConfig extends u<q> {
    public static final int CTRL_INDEX = 527;
    public static final String NAME = "getABTestConfig";

    public static class GetABTestConfigTask extends MainProcessTask {
        public static final Creator<GetABTestConfigTask> CREATOR = new Creator<GetABTestConfigTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetABTestConfigTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130414);
                GetABTestConfigTask getABTestConfigTask = new GetABTestConfigTask(parcel);
                AppMethodBeat.o(130414);
                return getABTestConfigTask;
            }
        };
        private String hwO;
        private Map<String, String> hwP = new HashMap();

        GetABTestConfigTask(String str) {
            AppMethodBeat.i(138127);
            this.hwO = str;
            AppMethodBeat.o(138127);
        }

        GetABTestConfigTask(Parcel parcel) {
            AppMethodBeat.i(130416);
            g(parcel);
            AppMethodBeat.o(130416);
        }

        public final void asP() {
            AppMethodBeat.i(130417);
            ab.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
            c ll = com.tencent.mm.model.c.c.abi().ll(this.hwO);
            if (ll.isValid()) {
                this.hwP.putAll(ll.dru());
            }
            aCb();
            AppMethodBeat.o(130417);
        }

        public final void asQ() {
            AppMethodBeat.i(130418);
            AppMethodBeat.o(130418);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130419);
            this.hwP.clear();
            this.hwP.putAll(parcel.readHashMap(HashMap.class.getClassLoader()));
            this.hwO = parcel.readString();
            AppMethodBeat.o(130419);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130420);
            parcel.writeMap(this.hwP);
            parcel.writeString(this.hwO);
            AppMethodBeat.o(130420);
        }

        static {
            AppMethodBeat.i(130421);
            AppMethodBeat.o(130421);
        }
    }

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(138128);
        ab.i("MicroMsg.JsApiGetABTestConfig", "JSONObject = ".concat(String.valueOf(jSONObject)));
        String optString = jSONObject.optString("experimentId");
        boolean equals = "Expt".equals(jSONObject.optString("experimentType"));
        if (TextUtils.isEmpty(optString)) {
            optString = j("fail:experimentId is empty", null);
            AppMethodBeat.o(138128);
            return optString;
        } else if (equals) {
            HashMap hashMap = new HashMap();
            hashMap.put("testConfig", b.brr().b(optString, "", true, true));
            optString = j("ok", hashMap);
            AppMethodBeat.o(138128);
            return optString;
        } else {
            MainProcessTask getABTestConfigTask = new GetABTestConfigTask(optString);
            if (AppBrandMainProcessService.b(getABTestConfigTask)) {
                ab.i("MicroMsg.JsApiGetABTestConfig", " configs = " + getABTestConfigTask.hwP);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("testConfig", getABTestConfigTask.hwP);
                optString = j("ok", hashMap2);
                AppMethodBeat.o(138128);
                return optString;
            }
            optString = j("fail:fail:internal error", null);
            AppMethodBeat.o(138128);
            return optString;
        }
    }
}
