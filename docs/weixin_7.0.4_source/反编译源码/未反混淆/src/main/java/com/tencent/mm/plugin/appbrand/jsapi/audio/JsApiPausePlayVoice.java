package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class JsApiPausePlayVoice extends a<q> {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";
    private PausePlayVoice hAV;

    static class PausePlayVoice extends MainProcessTask {
        public static final Creator<PausePlayVoice> CREATOR = new Creator<PausePlayVoice>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PausePlayVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130757);
                PausePlayVoice pausePlayVoice = new PausePlayVoice();
                pausePlayVoice.g(parcel);
                AppMethodBeat.o(130757);
                return pausePlayVoice;
            }
        };

        private PausePlayVoice() {
        }

        /* synthetic */ PausePlayVoice(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.i(130758);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130756);
                    ((b) g.K(b.class)).pause();
                    AppMethodBeat.o(130756);
                }
            });
            AppMethodBeat.o(130758);
        }

        static {
            AppMethodBeat.i(130759);
            AppMethodBeat.o(130759);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130760);
        q qVar = (q) cVar;
        this.hAV = new PausePlayVoice();
        AppBrandMainProcessService.a(this.hAV);
        JsApiStartPlayVoice.hBd = null;
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(130760);
    }
}
