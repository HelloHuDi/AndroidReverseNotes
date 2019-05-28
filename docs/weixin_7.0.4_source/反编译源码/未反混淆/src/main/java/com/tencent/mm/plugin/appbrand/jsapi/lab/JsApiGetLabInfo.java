package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiGetLabInfo extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 557;
    public static final String NAME = "getLabInfo";

    static final class GetLabInfoResult implements Parcelable {
        public static final Creator<GetLabInfoResult> CREATOR = new Creator<GetLabInfoResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetLabInfoResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131095);
                GetLabInfoResult getLabInfoResult = new GetLabInfoResult(parcel);
                AppMethodBeat.o(131095);
                return getLabInfoResult;
            }
        };
        private boolean cPt = false;
        private boolean enabled = false;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(131096);
            if (this.cPt) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.enabled) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            AppMethodBeat.o(131096);
        }

        protected GetLabInfoResult(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(131097);
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.cPt = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.enabled = z2;
            AppMethodBeat.o(131097);
        }

        static {
            AppMethodBeat.i(131098);
            AppMethodBeat.o(131098);
        }
    }

    static final class a implements com.tencent.mm.ipcinvoker.a<IPCString, GetLabInfoResult> {
        a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(131099);
            IPCString iPCString = (IPCString) obj;
            com.tencent.mm.plugin.welab.a.a.a aVar = (com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class);
            if (iPCString == null || bo.isNullOrNil(iPCString.value) || aVar == null) {
                cVar.ao(null);
                AppMethodBeat.o(131099);
                return;
            }
            GetLabInfoResult getLabInfoResult = new GetLabInfoResult();
            getLabInfoResult.cPt = aVar.agM(iPCString.value);
            getLabInfoResult.enabled = aVar.xj(iPCString.value);
            cVar.ao(getLabInfoResult);
            AppMethodBeat.o(131099);
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131100);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetLabInfo", "fail:data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131100);
            return;
        }
        String optString = jSONObject.optString("labId");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiGetLabInfo", "fail:labId is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131100);
            return;
        }
        XIPCInvoker.a("com.tencent.mm", new IPCString(optString), a.class, new c<GetLabInfoResult>() {
            public final /* synthetic */ void ao(Object obj) {
                AppMethodBeat.i(131094);
                GetLabInfoResult getLabInfoResult = (GetLabInfoResult) obj;
                if (getLabInfoResult != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("exist", Boolean.valueOf(getLabInfoResult.cPt));
                    hashMap.put("enabled", Boolean.valueOf(getLabInfoResult.enabled));
                    cVar.M(i, JsApiGetLabInfo.this.j("ok", hashMap));
                    AppMethodBeat.o(131094);
                    return;
                }
                cVar.M(i, JsApiGetLabInfo.this.j("fail", null));
                AppMethodBeat.o(131094);
            }
        });
        AppMethodBeat.o(131100);
    }
}
