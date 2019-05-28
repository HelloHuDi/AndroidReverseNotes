package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C38157b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice */
public final class JsApiStopPlayVoice extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice$StopPlayVoice */
    static class StopPlayVoice extends MainProcessTask {
        public static final Creator<StopPlayVoice> CREATOR = new C192962();

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice$StopPlayVoice$1 */
        class C192951 implements Runnable {
            C192951() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130804);
                ((C38157b) C1720g.m3528K(C38157b.class)).stop();
                AppMethodBeat.m2505o(130804);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice$StopPlayVoice$2 */
        static class C192962 implements Creator<StopPlayVoice> {
            C192962() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopPlayVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130805);
                StopPlayVoice stopPlayVoice = new StopPlayVoice();
                AppMethodBeat.m2505o(130805);
                return stopPlayVoice;
            }
        }

        private StopPlayVoice() {
        }

        /* synthetic */ StopPlayVoice(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.m2504i(130806);
            C5004al.m7441d(new C192951());
            AppMethodBeat.m2505o(130806);
        }

        static {
            AppMethodBeat.m2504i(130807);
            AppMethodBeat.m2505o(130807);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130809);
        C38492q c38492q = (C38492q) c2241c;
        String optString = jSONObject.optString("localId");
        C4990ab.m7417i("MicroMsg.JsApiStopPlayVoice", "doStopVoice, appId : %s, localId : %s", c38492q.getAppId(), optString);
        AppBrandMainProcessService.m54349a(new StopPlayVoice());
        c38492q.mo6107M(i, mo73394j("ok", null));
        JsApiStartPlayVoice.hBd = null;
        AppMethodBeat.m2505o(130809);
    }

    public static void aCx() {
        AppMethodBeat.m2504i(130808);
        if (C5046bo.isNullOrNil(JsApiStartPlayVoice.hBd)) {
            AppMethodBeat.m2505o(130808);
            return;
        }
        AppBrandMainProcessService.m54349a(new StopPlayVoice());
        JsApiStartPlayVoice.hBd = null;
        AppMethodBeat.m2505o(130808);
    }
}
