package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.media.record.C27199a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice */
public final class JsApiStopRecordVoice extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice$StopRecordVoice */
    static class StopRecordVoice extends MainProcessTask {
        public static final Creator<StopRecordVoice> CREATOR = new C269222();

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice$StopRecordVoice$1 */
        class C103031 implements Runnable {
            C103031() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130810);
                C27199a.m43218pg(1);
                AppMethodBeat.m2505o(130810);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice$StopRecordVoice$2 */
        static class C269222 implements Creator<StopRecordVoice> {
            C269222() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopRecordVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130811);
                StopRecordVoice stopRecordVoice = new StopRecordVoice();
                AppMethodBeat.m2505o(130811);
                return stopRecordVoice;
            }
        }

        private StopRecordVoice() {
        }

        /* synthetic */ StopRecordVoice(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.m2504i(130812);
            C45673m.aNS().mo10302aa(new C103031());
            AppMethodBeat.m2505o(130812);
        }

        static {
            AppMethodBeat.m2504i(130813);
            AppMethodBeat.m2505o(130813);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130815);
        C38492q c38492q = (C38492q) c2241c;
        JsApiStopRecordVoice.m54383g(c38492q);
        c38492q.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(130815);
    }

    /* renamed from: g */
    static void m54383g(C38492q c38492q) {
        AppMethodBeat.m2504i(130814);
        if (C5046bo.isNullOrNil(JsApiStartRecordVoice.hBi)) {
            AppMethodBeat.m2505o(130814);
            return;
        }
        C2405a c2405a = C38450n.m65048xa(c38492q.getAppId()).gPf;
        if (c2405a != null) {
            c2405a.dismiss();
        }
        AppBrandMainProcessService.m54349a(new StopRecordVoice());
        JsApiStartRecordVoice.hBi = null;
        AppMethodBeat.m2505o(130814);
    }
}
