package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiSetLabInfo extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 558;
    public static final String NAME = "setLabInfo";

    static final class IPCSetLabInfoRequest implements Parcelable {
        public static final Creator<IPCSetLabInfoRequest> CREATOR = new Creator<IPCSetLabInfoRequest>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IPCSetLabInfoRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131103);
                IPCSetLabInfoRequest iPCSetLabInfoRequest = new IPCSetLabInfoRequest(parcel);
                AppMethodBeat.o(131103);
                return iPCSetLabInfoRequest;
            }
        };
        private String csB;
        private boolean enabled;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131104);
            parcel.writeString(this.csB);
            parcel.writeByte(this.enabled ? (byte) 1 : (byte) 0);
            AppMethodBeat.o(131104);
        }

        public IPCSetLabInfoRequest(String str, boolean z) {
            this.csB = str;
            this.enabled = z;
        }

        protected IPCSetLabInfoRequest(Parcel parcel) {
            AppMethodBeat.i(131105);
            this.csB = parcel.readString();
            this.enabled = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(131105);
        }

        static {
            AppMethodBeat.i(131106);
            AppMethodBeat.o(131106);
        }
    }

    static final class a implements com.tencent.mm.ipcinvoker.a<IPCSetLabInfoRequest, IPCBoolean> {
        a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(131102);
            IPCSetLabInfoRequest iPCSetLabInfoRequest = (IPCSetLabInfoRequest) obj;
            com.tencent.mm.plugin.welab.a.a.a aVar = (com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class);
            if (iPCSetLabInfoRequest == null || bo.isNullOrNil(iPCSetLabInfoRequest.csB) || aVar == null) {
                cVar.ao(null);
                AppMethodBeat.o(131102);
            } else if (aVar.agM(iPCSetLabInfoRequest.csB)) {
                aVar.bK(iPCSetLabInfoRequest.csB, iPCSetLabInfoRequest.enabled);
                cVar.ao(new IPCBoolean(true));
                AppMethodBeat.o(131102);
            } else {
                cVar.ao(new IPCBoolean(false));
                AppMethodBeat.o(131102);
            }
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131107);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiSetLabInfo", "fail:data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131107);
            return;
        }
        String optString = jSONObject.optString("labId");
        if (bo.isNullOrNil(optString) || !jSONObject.has("enabled")) {
            ab.e("MicroMsg.JsApiSetLabInfo", "fail:labId is null or no enabled");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131107);
            return;
        }
        XIPCInvoker.a("com.tencent.mm", new IPCSetLabInfoRequest(optString, jSONObject.optBoolean("enabled")), a.class, new c<IPCBoolean>() {
            public final /* synthetic */ void ao(Object obj) {
                AppMethodBeat.i(131101);
                IPCBoolean iPCBoolean = (IPCBoolean) obj;
                if (iPCBoolean == null || !iPCBoolean.value) {
                    cVar.M(i, JsApiSetLabInfo.this.j("fail", null));
                    AppMethodBeat.o(131101);
                    return;
                }
                cVar.M(i, JsApiSetLabInfo.this.j("ok", null));
                AppMethodBeat.o(131101);
            }
        });
        AppMethodBeat.o(131107);
    }
}
