package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiLuggageCheckBioEnrollment extends a {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";
    private static Context hDj = null;
    private GetIsEnrolledTask hDi;

    static class GetIsEnrolledTask extends MainProcessTask {
        public static final Creator<GetIsEnrolledTask> CREATOR = new Creator<GetIsEnrolledTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsEnrolledTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(73776);
                GetIsEnrolledTask getIsEnrolledTask = new GetIsEnrolledTask(parcel);
                AppMethodBeat.o(73776);
                return getIsEnrolledTask;
            }
        };
        private int bOs = -1;
        private int hDd = -1;
        private int hDe = -1;
        private JsApiLuggageCheckBioEnrollment hDk;
        private c hzz = null;

        public final void asQ() {
            boolean z = false;
            AppMethodBeat.i(73777);
            super.asQ();
            ab.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", Integer.valueOf(this.hDe));
            HashMap hashMap = new HashMap(2);
            String str = "isEnrolled";
            if (this.hDe == 1) {
                z = true;
            }
            hashMap.put(str, Boolean.valueOf(z));
            if (this.hDe == 0) {
                this.hzz.M(this.bOs, this.hDk.j("ok", hashMap));
            } else if (this.hDe == -1) {
                this.hzz.M(this.bOs, this.hDk.j("fail not support", hashMap));
            } else if (this.hDe == 1) {
                this.hzz.M(this.bOs, this.hDk.j("ok", hashMap));
            } else {
                this.hzz.M(this.bOs, this.hDk.j("fail unknown error", hashMap));
            }
            h.at(this);
            AppMethodBeat.o(73777);
        }

        public final void asP() {
            int i;
            AppMethodBeat.i(73778);
            Context access$000 = JsApiLuggageCheckBioEnrollment.hDj;
            if (this.hDd != 1) {
                i = -1;
            } else if (com.tencent.soter.core.a.iR(access$000)) {
                i = 1;
            } else {
                i = 0;
            }
            this.hDe = i;
            ab.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", Integer.valueOf(this.hDe));
            aCb();
            AppMethodBeat.o(73778);
        }

        public GetIsEnrolledTask(c cVar, int i, int i2, JsApiLuggageCheckBioEnrollment jsApiLuggageCheckBioEnrollment) {
            this.hzz = cVar;
            this.bOs = i;
            this.hDk = jsApiLuggageCheckBioEnrollment;
            this.hDd = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(73779);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hDe);
            parcel.writeInt(this.hDd);
            AppMethodBeat.o(73779);
        }

        protected GetIsEnrolledTask(Parcel parcel) {
            AppMethodBeat.i(73780);
            g(parcel);
            AppMethodBeat.o(73780);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(73781);
            super.g(parcel);
            this.hDe = parcel.readInt();
            this.hDd = parcel.readInt();
            AppMethodBeat.o(73781);
        }

        static {
            AppMethodBeat.i(73782);
            AppMethodBeat.o(73782);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(73783);
        hDj = cVar.getContext();
        ab.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
        this.hDi = new GetIsEnrolledTask(cVar, i, d.AS(jSONObject.optString("checkAuthMode")), this);
        h.bB(this.hDi);
        AppBrandMainProcessService.a(this.hDi);
        AppMethodBeat.o(73783);
    }
}
