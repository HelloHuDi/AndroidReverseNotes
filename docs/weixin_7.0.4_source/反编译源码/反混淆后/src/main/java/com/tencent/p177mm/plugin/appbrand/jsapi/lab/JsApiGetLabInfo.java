package com.tencent.p177mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo */
public final class JsApiGetLabInfo extends C10296a {
    public static final int CTRL_INDEX = 557;
    public static final String NAME = "getLabInfo";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo$GetLabInfoResult */
    static final class GetLabInfoResult implements Parcelable {
        public static final Creator<GetLabInfoResult> CREATOR = new C194141();
        private boolean cPt = false;
        private boolean enabled = false;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo$GetLabInfoResult$1 */
        static class C194141 implements Creator<GetLabInfoResult> {
            C194141() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetLabInfoResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131095);
                GetLabInfoResult getLabInfoResult = new GetLabInfoResult(parcel);
                AppMethodBeat.m2505o(131095);
                return getLabInfoResult;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(131096);
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
            AppMethodBeat.m2505o(131096);
        }

        protected GetLabInfoResult(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(131097);
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
            AppMethodBeat.m2505o(131097);
        }

        static {
            AppMethodBeat.m2504i(131098);
            AppMethodBeat.m2505o(131098);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo$a */
    static final class C19415a implements C37866a<IPCString, GetLabInfoResult> {
        C19415a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(131099);
            IPCString iPCString = (IPCString) obj;
            C23167a c23167a = (C23167a) C1720g.m3528K(C23167a.class);
            if (iPCString == null || C5046bo.isNullOrNil(iPCString.value) || c23167a == null) {
                c18507c.mo5960ao(null);
                AppMethodBeat.m2505o(131099);
                return;
            }
            GetLabInfoResult getLabInfoResult = new GetLabInfoResult();
            getLabInfoResult.cPt = c23167a.agM(iPCString.value);
            getLabInfoResult.enabled = c23167a.mo38786xj(iPCString.value);
            c18507c.mo5960ao(getLabInfoResult);
            AppMethodBeat.m2505o(131099);
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131100);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetLabInfo", "fail:data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131100);
            return;
        }
        String optString = jSONObject.optString("labId");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiGetLabInfo", "fail:labId is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131100);
            return;
        }
        XIPCInvoker.m83629a("com.tencent.mm", new IPCString(optString), C19415a.class, new C18507c<GetLabInfoResult>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(131094);
                GetLabInfoResult getLabInfoResult = (GetLabInfoResult) obj;
                if (getLabInfoResult != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("exist", Boolean.valueOf(getLabInfoResult.cPt));
                    hashMap.put("enabled", Boolean.valueOf(getLabInfoResult.enabled));
                    c2241c.mo6107M(i, JsApiGetLabInfo.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(131094);
                    return;
                }
                c2241c.mo6107M(i, JsApiGetLabInfo.this.mo73394j("fail", null));
                AppMethodBeat.m2505o(131094);
            }
        });
        AppMethodBeat.m2505o(131100);
    }
}
