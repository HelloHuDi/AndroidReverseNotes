package com.tencent.p177mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C19680h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.C40997a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment */
public final class JsApiLuggageCheckBioEnrollment extends C10296a {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";
    private static Context hDj = null;
    private GetIsEnrolledTask hDi;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment$GetIsEnrolledTask */
    static class GetIsEnrolledTask extends MainProcessTask {
        public static final Creator<GetIsEnrolledTask> CREATOR = new C193311();
        private int bOs = -1;
        private int hDd = -1;
        private int hDe = -1;
        private JsApiLuggageCheckBioEnrollment hDk;
        private C2241c hzz = null;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment$GetIsEnrolledTask$1 */
        static class C193311 implements Creator<GetIsEnrolledTask> {
            C193311() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsEnrolledTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(73776);
                GetIsEnrolledTask getIsEnrolledTask = new GetIsEnrolledTask(parcel);
                AppMethodBeat.m2505o(73776);
                return getIsEnrolledTask;
            }
        }

        public final void asQ() {
            boolean z = false;
            AppMethodBeat.m2504i(73777);
            super.asQ();
            C4990ab.m7411d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", Integer.valueOf(this.hDe));
            HashMap hashMap = new HashMap(2);
            String str = "isEnrolled";
            if (this.hDe == 1) {
                z = true;
            }
            hashMap.put(str, Boolean.valueOf(z));
            if (this.hDe == 0) {
                this.hzz.mo6107M(this.bOs, this.hDk.mo73394j("ok", hashMap));
            } else if (this.hDe == -1) {
                this.hzz.mo6107M(this.bOs, this.hDk.mo73394j("fail not support", hashMap));
            } else if (this.hDe == 1) {
                this.hzz.mo6107M(this.bOs, this.hDk.mo73394j("ok", hashMap));
            } else {
                this.hzz.mo6107M(this.bOs, this.hDk.mo73394j("fail unknown error", hashMap));
            }
            C19680h.m30478at(this);
            AppMethodBeat.m2505o(73777);
        }

        public final void asP() {
            int i;
            AppMethodBeat.m2504i(73778);
            Context access$000 = JsApiLuggageCheckBioEnrollment.hDj;
            if (this.hDd != 1) {
                i = -1;
            } else if (C40997a.m71099iR(access$000)) {
                i = 1;
            } else {
                i = 0;
            }
            this.hDe = i;
            C4990ab.m7417i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", Integer.valueOf(this.hDe));
            aCb();
            AppMethodBeat.m2505o(73778);
        }

        public GetIsEnrolledTask(C2241c c2241c, int i, int i2, JsApiLuggageCheckBioEnrollment jsApiLuggageCheckBioEnrollment) {
            this.hzz = c2241c;
            this.bOs = i;
            this.hDk = jsApiLuggageCheckBioEnrollment;
            this.hDd = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(73779);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hDe);
            parcel.writeInt(this.hDd);
            AppMethodBeat.m2505o(73779);
        }

        protected GetIsEnrolledTask(Parcel parcel) {
            AppMethodBeat.m2504i(73780);
            mo6032g(parcel);
            AppMethodBeat.m2505o(73780);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(73781);
            super.mo6032g(parcel);
            this.hDe = parcel.readInt();
            this.hDd = parcel.readInt();
            AppMethodBeat.m2505o(73781);
        }

        static {
            AppMethodBeat.m2504i(73782);
            AppMethodBeat.m2505o(73782);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(73783);
        hDj = c2241c.getContext();
        C4990ab.m7416i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
        this.hDi = new GetIsEnrolledTask(c2241c, i, C2235d.m4449AS(jSONObject.optString("checkAuthMode")), this);
        C19680h.m30479bB(this.hDi);
        AppBrandMainProcessService.m54349a(this.hDi);
        AppMethodBeat.m2505o(73783);
    }
}
