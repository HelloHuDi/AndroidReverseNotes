package com.tencent.p177mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37730hu;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C19680h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication */
public final class JsApiCheckIsSupportSoterAuthentication extends C10296a {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask hDf = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask */
    static class GetIsSupportSoterTask extends MainProcessTask {
        public static final Creator<GetIsSupportSoterTask> CREATOR = new C193301();
        private int bOs = -1;
        private JsApiCheckIsSupportSoterAuthentication hDg;
        private int hDh = 0;
        private C2241c hzz = null;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask$1 */
        static class C193301 implements Creator<GetIsSupportSoterTask> {
            C193301() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportSoterTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(3216);
                GetIsSupportSoterTask getIsSupportSoterTask = new GetIsSupportSoterTask(parcel);
                AppMethodBeat.m2505o(3216);
                return getIsSupportSoterTask;
            }
        }

        public final void asQ() {
            AppMethodBeat.m2504i(3217);
            super.asQ();
            C4990ab.m7411d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", Integer.valueOf(this.hDh));
            HashMap hashMap = new HashMap(2);
            hashMap.put("supportMode", C45582a.m84099oc(this.hDh));
            this.hzz.mo6107M(this.bOs, this.hDg.mo73394j("ok", hashMap));
            C19680h.m30478at(this);
            AppMethodBeat.m2505o(3217);
        }

        public final void asP() {
            AppMethodBeat.m2504i(3218);
            C37730hu c37730hu = new C37730hu();
            C4879a.xxA.mo10055m(c37730hu);
            this.hDh = c37730hu.cCM.cCN;
            C4990ab.m7417i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", Integer.valueOf(this.hDh));
            aCb();
            AppMethodBeat.m2505o(3218);
        }

        public GetIsSupportSoterTask(C2241c c2241c, int i, JsApiCheckIsSupportSoterAuthentication jsApiCheckIsSupportSoterAuthentication) {
            this.hzz = c2241c;
            this.bOs = i;
            this.hDg = jsApiCheckIsSupportSoterAuthentication;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(3219);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hDh);
            AppMethodBeat.m2505o(3219);
        }

        protected GetIsSupportSoterTask(Parcel parcel) {
            AppMethodBeat.m2504i(3220);
            mo6032g(parcel);
            AppMethodBeat.m2505o(3220);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(3221);
            super.mo6032g(parcel);
            this.hDh = parcel.readInt();
            AppMethodBeat.m2505o(3221);
        }

        static {
            AppMethodBeat.m2504i(3222);
            AppMethodBeat.m2505o(3222);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(3223);
        C4990ab.m7416i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.hDf = new GetIsSupportSoterTask(c2241c, i, this);
        C19680h.m30479bB(this.hDf);
        AppBrandMainProcessService.m54349a(this.hDf);
        AppMethodBeat.m2505o(3223);
    }
}
