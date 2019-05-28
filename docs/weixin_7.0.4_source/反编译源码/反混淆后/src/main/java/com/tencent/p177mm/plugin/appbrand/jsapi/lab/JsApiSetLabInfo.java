package com.tencent.p177mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo */
public final class JsApiSetLabInfo extends C10296a {
    public static final int CTRL_INDEX = 558;
    public static final String NAME = "setLabInfo";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo$IPCSetLabInfoRequest */
    static final class IPCSetLabInfoRequest implements Parcelable {
        public static final Creator<IPCSetLabInfoRequest> CREATOR = new C104491();
        private String csB;
        private boolean enabled;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo$IPCSetLabInfoRequest$1 */
        static class C104491 implements Creator<IPCSetLabInfoRequest> {
            C104491() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IPCSetLabInfoRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131103);
                IPCSetLabInfoRequest iPCSetLabInfoRequest = new IPCSetLabInfoRequest(parcel);
                AppMethodBeat.m2505o(131103);
                return iPCSetLabInfoRequest;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131104);
            parcel.writeString(this.csB);
            parcel.writeByte(this.enabled ? (byte) 1 : (byte) 0);
            AppMethodBeat.m2505o(131104);
        }

        public IPCSetLabInfoRequest(String str, boolean z) {
            this.csB = str;
            this.enabled = z;
        }

        protected IPCSetLabInfoRequest(Parcel parcel) {
            AppMethodBeat.m2504i(131105);
            this.csB = parcel.readString();
            this.enabled = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(131105);
        }

        static {
            AppMethodBeat.m2504i(131106);
            AppMethodBeat.m2505o(131106);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo$a */
    static final class C33346a implements C37866a<IPCSetLabInfoRequest, IPCBoolean> {
        C33346a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(131102);
            IPCSetLabInfoRequest iPCSetLabInfoRequest = (IPCSetLabInfoRequest) obj;
            C23167a c23167a = (C23167a) C1720g.m3528K(C23167a.class);
            if (iPCSetLabInfoRequest == null || C5046bo.isNullOrNil(iPCSetLabInfoRequest.csB) || c23167a == null) {
                c18507c.mo5960ao(null);
                AppMethodBeat.m2505o(131102);
            } else if (c23167a.agM(iPCSetLabInfoRequest.csB)) {
                c23167a.mo38784bK(iPCSetLabInfoRequest.csB, iPCSetLabInfoRequest.enabled);
                c18507c.mo5960ao(new IPCBoolean(true));
                AppMethodBeat.m2505o(131102);
            } else {
                c18507c.mo5960ao(new IPCBoolean(false));
                AppMethodBeat.m2505o(131102);
            }
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131107);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetLabInfo", "fail:data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131107);
            return;
        }
        String optString = jSONObject.optString("labId");
        if (C5046bo.isNullOrNil(optString) || !jSONObject.has("enabled")) {
            C4990ab.m7412e("MicroMsg.JsApiSetLabInfo", "fail:labId is null or no enabled");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131107);
            return;
        }
        XIPCInvoker.m83629a("com.tencent.mm", new IPCSetLabInfoRequest(optString, jSONObject.optBoolean("enabled")), C33346a.class, new C18507c<IPCBoolean>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(131101);
                IPCBoolean iPCBoolean = (IPCBoolean) obj;
                if (iPCBoolean == null || !iPCBoolean.value) {
                    c2241c.mo6107M(i, JsApiSetLabInfo.this.mo73394j("fail", null));
                    AppMethodBeat.m2505o(131101);
                    return;
                }
                c2241c.mo6107M(i, JsApiSetLabInfo.this.mo73394j("ok", null));
                AppMethodBeat.m2505o(131101);
            }
        });
        AppMethodBeat.m2505o(131107);
    }
}
