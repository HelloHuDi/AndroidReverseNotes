package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

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

public final class JsApiLuggageCheckIsSupportSoterAuthentication extends a {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask hDl;

    static class GetIsSupportSoterTask extends MainProcessTask {
        public static final Creator<GetIsSupportSoterTask> CREATOR = new Creator<GetIsSupportSoterTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportSoterTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(73784);
                GetIsSupportSoterTask getIsSupportSoterTask = new GetIsSupportSoterTask(parcel);
                AppMethodBeat.o(73784);
                return getIsSupportSoterTask;
            }
        };
        private int bOs = -1;
        private JsApiLuggageCheckIsSupportSoterAuthentication hDm;
        private String hDn = "";
        private c hzz = null;

        public final void asQ() {
            AppMethodBeat.i(73785);
            super.asQ();
            ab.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", this.hDn);
            HashMap hashMap = new HashMap(2);
            hashMap.put("verifyRemote", this.hDn);
            hashMap.put("nativeSupport", Boolean.valueOf(com.tencent.soter.core.a.dQN()));
            ab.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + com.tencent.soter.core.a.dQN());
            this.hzz.M(this.bOs, this.hDm.j("ok", hashMap));
            h.at(this);
            AppMethodBeat.o(73785);
        }

        public GetIsSupportSoterTask(c cVar, int i, JsApiLuggageCheckIsSupportSoterAuthentication jsApiLuggageCheckIsSupportSoterAuthentication) {
            this.hzz = cVar;
            this.bOs = i;
            this.hDm = jsApiLuggageCheckIsSupportSoterAuthentication;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(73787);
            super.writeToParcel(parcel, i);
            parcel.writeString(this.hDn);
            AppMethodBeat.o(73787);
        }

        protected GetIsSupportSoterTask(Parcel parcel) {
            AppMethodBeat.i(73788);
            g(parcel);
            AppMethodBeat.o(73788);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(73789);
            super.g(parcel);
            this.hDn = parcel.readString();
            AppMethodBeat.o(73789);
        }

        static {
            AppMethodBeat.i(73790);
            AppMethodBeat.o(73790);
        }

        public final void asP() {
            AppMethodBeat.i(73786);
            this.hDn = com.tencent.soter.core.a.dQT();
            ab.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", this.hDn);
            aCb();
            AppMethodBeat.o(73786);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(73791);
        ab.i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.hDl = new GetIsSupportSoterTask(cVar, i, this);
        h.bB(this.hDl);
        AppBrandMainProcessService.a(this.hDl);
        AppMethodBeat.o(73791);
    }
}
