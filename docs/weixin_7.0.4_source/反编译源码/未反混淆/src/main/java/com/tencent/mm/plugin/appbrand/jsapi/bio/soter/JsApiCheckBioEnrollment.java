package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment extends a {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";
    private GetIsEnrolledTask hDb = null;

    static class GetIsEnrolledTask extends MainProcessTask {
        public static final Creator<GetIsEnrolledTask> CREATOR = new Creator<GetIsEnrolledTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsEnrolledTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(3208);
                GetIsEnrolledTask getIsEnrolledTask = new GetIsEnrolledTask(parcel);
                AppMethodBeat.o(3208);
                return getIsEnrolledTask;
            }
        };
        private int bOs = -1;
        private JsApiCheckBioEnrollment hDc;
        private int hDd = -1;
        private int hDe = -1;
        private c hzz = null;

        public final void asQ() {
            boolean z = false;
            AppMethodBeat.i(3209);
            super.asQ();
            ab.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", Integer.valueOf(this.hDe));
            HashMap hashMap = new HashMap(2);
            String str = "isEnrolled";
            if (this.hDe == 1) {
                z = true;
            }
            hashMap.put(str, Boolean.valueOf(z));
            if (this.hDe == 0) {
                this.hzz.M(this.bOs, this.hDc.j("ok", hashMap));
            } else if (this.hDe == -1) {
                this.hzz.M(this.bOs, this.hDc.j("fail not support", hashMap));
            } else if (this.hDe == 1) {
                this.hzz.M(this.bOs, this.hDc.j("ok", hashMap));
            } else {
                this.hzz.M(this.bOs, this.hDc.j("fail unknown error", hashMap));
            }
            h.at(this);
            AppMethodBeat.o(3209);
        }

        public final void asP() {
            AppMethodBeat.i(3210);
            hs hsVar = new hs();
            hsVar.cCD.cCF = this.hDd;
            com.tencent.mm.sdk.b.a.xxA.m(hsVar);
            this.hDe = hsVar.cCE.cCG;
            ab.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", Integer.valueOf(this.hDe));
            aCb();
            AppMethodBeat.o(3210);
        }

        public GetIsEnrolledTask(c cVar, int i, int i2, JsApiCheckBioEnrollment jsApiCheckBioEnrollment) {
            this.hzz = cVar;
            this.bOs = i;
            this.hDc = jsApiCheckBioEnrollment;
            this.hDd = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(3211);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hDe);
            parcel.writeInt(this.hDd);
            AppMethodBeat.o(3211);
        }

        protected GetIsEnrolledTask(Parcel parcel) {
            AppMethodBeat.i(3212);
            g(parcel);
            AppMethodBeat.o(3212);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(3213);
            super.g(parcel);
            this.hDe = parcel.readInt();
            this.hDd = parcel.readInt();
            AppMethodBeat.o(3213);
        }

        static {
            AppMethodBeat.i(3214);
            AppMethodBeat.o(3214);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(3215);
        ab.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
        this.hDb = new GetIsEnrolledTask(cVar, i, a.AS(jSONObject.optString("checkAuthMode")), this);
        h.bB(this.hDb);
        AppBrandMainProcessService.a(this.hDb);
        AppMethodBeat.o(3215);
    }
}
