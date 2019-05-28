package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication extends a {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask hDf = null;

    static class GetIsSupportSoterTask extends MainProcessTask {
        public static final Creator<GetIsSupportSoterTask> CREATOR = new Creator<GetIsSupportSoterTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportSoterTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(3216);
                GetIsSupportSoterTask getIsSupportSoterTask = new GetIsSupportSoterTask(parcel);
                AppMethodBeat.o(3216);
                return getIsSupportSoterTask;
            }
        };
        private int bOs = -1;
        private JsApiCheckIsSupportSoterAuthentication hDg;
        private int hDh = 0;
        private c hzz = null;

        public final void asQ() {
            AppMethodBeat.i(3217);
            super.asQ();
            ab.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", Integer.valueOf(this.hDh));
            HashMap hashMap = new HashMap(2);
            hashMap.put("supportMode", a.oc(this.hDh));
            this.hzz.M(this.bOs, this.hDg.j("ok", hashMap));
            h.at(this);
            AppMethodBeat.o(3217);
        }

        public final void asP() {
            AppMethodBeat.i(3218);
            hu huVar = new hu();
            com.tencent.mm.sdk.b.a.xxA.m(huVar);
            this.hDh = huVar.cCM.cCN;
            ab.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", Integer.valueOf(this.hDh));
            aCb();
            AppMethodBeat.o(3218);
        }

        public GetIsSupportSoterTask(c cVar, int i, JsApiCheckIsSupportSoterAuthentication jsApiCheckIsSupportSoterAuthentication) {
            this.hzz = cVar;
            this.bOs = i;
            this.hDg = jsApiCheckIsSupportSoterAuthentication;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(3219);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hDh);
            AppMethodBeat.o(3219);
        }

        protected GetIsSupportSoterTask(Parcel parcel) {
            AppMethodBeat.i(3220);
            g(parcel);
            AppMethodBeat.o(3220);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(3221);
            super.g(parcel);
            this.hDh = parcel.readInt();
            AppMethodBeat.o(3221);
        }

        static {
            AppMethodBeat.i(3222);
            AppMethodBeat.o(3222);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(3223);
        ab.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.hDf = new GetIsSupportSoterTask(cVar, i, this);
        h.bB(this.hDf);
        AppBrandMainProcessService.a(this.hDf);
        AppMethodBeat.o(3223);
    }
}
