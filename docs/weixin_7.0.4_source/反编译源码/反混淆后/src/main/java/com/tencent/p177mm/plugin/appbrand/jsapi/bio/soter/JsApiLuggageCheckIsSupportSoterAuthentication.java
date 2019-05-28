package com.tencent.p177mm.plugin.appbrand.jsapi.bio.soter;

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

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication */
public final class JsApiLuggageCheckIsSupportSoterAuthentication extends C10296a {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask hDl;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication$GetIsSupportSoterTask */
    static class GetIsSupportSoterTask extends MainProcessTask {
        public static final Creator<GetIsSupportSoterTask> CREATOR = new C103381();
        private int bOs = -1;
        private JsApiLuggageCheckIsSupportSoterAuthentication hDm;
        private String hDn = "";
        private C2241c hzz = null;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication$GetIsSupportSoterTask$1 */
        static class C103381 implements Creator<GetIsSupportSoterTask> {
            C103381() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportSoterTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(73784);
                GetIsSupportSoterTask getIsSupportSoterTask = new GetIsSupportSoterTask(parcel);
                AppMethodBeat.m2505o(73784);
                return getIsSupportSoterTask;
            }
        }

        public final void asQ() {
            AppMethodBeat.m2504i(73785);
            super.asQ();
            C4990ab.m7411d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", this.hDn);
            HashMap hashMap = new HashMap(2);
            hashMap.put("verifyRemote", this.hDn);
            hashMap.put("nativeSupport", Boolean.valueOf(C40997a.dQN()));
            C4990ab.m7416i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + C40997a.dQN());
            this.hzz.mo6107M(this.bOs, this.hDm.mo73394j("ok", hashMap));
            C19680h.m30478at(this);
            AppMethodBeat.m2505o(73785);
        }

        public GetIsSupportSoterTask(C2241c c2241c, int i, JsApiLuggageCheckIsSupportSoterAuthentication jsApiLuggageCheckIsSupportSoterAuthentication) {
            this.hzz = c2241c;
            this.bOs = i;
            this.hDm = jsApiLuggageCheckIsSupportSoterAuthentication;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(73787);
            super.writeToParcel(parcel, i);
            parcel.writeString(this.hDn);
            AppMethodBeat.m2505o(73787);
        }

        protected GetIsSupportSoterTask(Parcel parcel) {
            AppMethodBeat.m2504i(73788);
            mo6032g(parcel);
            AppMethodBeat.m2505o(73788);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(73789);
            super.mo6032g(parcel);
            this.hDn = parcel.readString();
            AppMethodBeat.m2505o(73789);
        }

        static {
            AppMethodBeat.m2504i(73790);
            AppMethodBeat.m2505o(73790);
        }

        public final void asP() {
            AppMethodBeat.m2504i(73786);
            this.hDn = C40997a.dQT();
            C4990ab.m7417i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", this.hDn);
            aCb();
            AppMethodBeat.m2505o(73786);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(73791);
        C4990ab.m7416i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.hDl = new GetIsSupportSoterTask(c2241c, i, this);
        C19680h.m30479bB(this.hDl);
        AppBrandMainProcessService.m54349a(this.hDl);
        AppMethodBeat.m2505o(73791);
    }
}
