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
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice */
public final class JsApiPausePlayVoice extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";
    private PausePlayVoice hAV;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice$PausePlayVoice */
    static class PausePlayVoice extends MainProcessTask {
        public static final Creator<PausePlayVoice> CREATOR = new C332392();

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice$PausePlayVoice$1 */
        class C332381 implements Runnable {
            C332381() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130756);
                ((C38157b) C1720g.m3528K(C38157b.class)).pause();
                AppMethodBeat.m2505o(130756);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice$PausePlayVoice$2 */
        static class C332392 implements Creator<PausePlayVoice> {
            C332392() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PausePlayVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130757);
                PausePlayVoice pausePlayVoice = new PausePlayVoice();
                pausePlayVoice.mo6032g(parcel);
                AppMethodBeat.m2505o(130757);
                return pausePlayVoice;
            }
        }

        private PausePlayVoice() {
        }

        /* synthetic */ PausePlayVoice(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.m2504i(130758);
            C5004al.m7441d(new C332381());
            AppMethodBeat.m2505o(130758);
        }

        static {
            AppMethodBeat.m2504i(130759);
            AppMethodBeat.m2505o(130759);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130760);
        C38492q c38492q = (C38492q) c2241c;
        this.hAV = new PausePlayVoice();
        AppBrandMainProcessService.m54349a(this.hAV);
        JsApiStartPlayVoice.hBd = null;
        c38492q.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(130760);
    }
}
