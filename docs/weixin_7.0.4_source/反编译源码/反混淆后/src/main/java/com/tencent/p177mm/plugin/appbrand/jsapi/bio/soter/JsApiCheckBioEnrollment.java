package com.tencent.p177mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32570hs;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C19680h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment */
public final class JsApiCheckBioEnrollment extends C10296a {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";
    private GetIsEnrolledTask hDb = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment$GetIsEnrolledTask */
    static class GetIsEnrolledTask extends MainProcessTask {
        public static final Creator<GetIsEnrolledTask> CREATOR = new C103371();
        private int bOs = -1;
        private JsApiCheckBioEnrollment hDc;
        private int hDd = -1;
        private int hDe = -1;
        private C2241c hzz = null;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment$GetIsEnrolledTask$1 */
        static class C103371 implements Creator<GetIsEnrolledTask> {
            C103371() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsEnrolledTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(3208);
                GetIsEnrolledTask getIsEnrolledTask = new GetIsEnrolledTask(parcel);
                AppMethodBeat.m2505o(3208);
                return getIsEnrolledTask;
            }
        }

        public final void asQ() {
            boolean z = false;
            AppMethodBeat.m2504i(3209);
            super.asQ();
            C4990ab.m7411d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", Integer.valueOf(this.hDe));
            HashMap hashMap = new HashMap(2);
            String str = "isEnrolled";
            if (this.hDe == 1) {
                z = true;
            }
            hashMap.put(str, Boolean.valueOf(z));
            if (this.hDe == 0) {
                this.hzz.mo6107M(this.bOs, this.hDc.mo73394j("ok", hashMap));
            } else if (this.hDe == -1) {
                this.hzz.mo6107M(this.bOs, this.hDc.mo73394j("fail not support", hashMap));
            } else if (this.hDe == 1) {
                this.hzz.mo6107M(this.bOs, this.hDc.mo73394j("ok", hashMap));
            } else {
                this.hzz.mo6107M(this.bOs, this.hDc.mo73394j("fail unknown error", hashMap));
            }
            C19680h.m30478at(this);
            AppMethodBeat.m2505o(3209);
        }

        public final void asP() {
            AppMethodBeat.m2504i(3210);
            C32570hs c32570hs = new C32570hs();
            c32570hs.cCD.cCF = this.hDd;
            C4879a.xxA.mo10055m(c32570hs);
            this.hDe = c32570hs.cCE.cCG;
            C4990ab.m7417i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", Integer.valueOf(this.hDe));
            aCb();
            AppMethodBeat.m2505o(3210);
        }

        public GetIsEnrolledTask(C2241c c2241c, int i, int i2, JsApiCheckBioEnrollment jsApiCheckBioEnrollment) {
            this.hzz = c2241c;
            this.bOs = i;
            this.hDc = jsApiCheckBioEnrollment;
            this.hDd = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(3211);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hDe);
            parcel.writeInt(this.hDd);
            AppMethodBeat.m2505o(3211);
        }

        protected GetIsEnrolledTask(Parcel parcel) {
            AppMethodBeat.m2504i(3212);
            mo6032g(parcel);
            AppMethodBeat.m2505o(3212);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(3213);
            super.mo6032g(parcel);
            this.hDe = parcel.readInt();
            this.hDd = parcel.readInt();
            AppMethodBeat.m2505o(3213);
        }

        static {
            AppMethodBeat.m2504i(3214);
            AppMethodBeat.m2505o(3214);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(3215);
        C4990ab.m7416i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
        this.hDb = new GetIsEnrolledTask(c2241c, i, C45582a.m84097AS(jSONObject.optString("checkAuthMode")), this);
        C19680h.m30479bB(this.hDb);
        AppBrandMainProcessService.m54349a(this.hDb);
        AppMethodBeat.m2505o(3215);
    }
}
