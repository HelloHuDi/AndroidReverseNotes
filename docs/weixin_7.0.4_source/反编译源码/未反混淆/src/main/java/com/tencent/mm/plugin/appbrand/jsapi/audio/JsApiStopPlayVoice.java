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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiStopPlayVoice extends a<q> {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    static class StopPlayVoice extends MainProcessTask {
        public static final Creator<StopPlayVoice> CREATOR = new Creator<StopPlayVoice>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopPlayVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130805);
                StopPlayVoice stopPlayVoice = new StopPlayVoice();
                AppMethodBeat.o(130805);
                return stopPlayVoice;
            }
        };

        private StopPlayVoice() {
        }

        /* synthetic */ StopPlayVoice(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.i(130806);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130804);
                    ((b) g.K(b.class)).stop();
                    AppMethodBeat.o(130804);
                }
            });
            AppMethodBeat.o(130806);
        }

        static {
            AppMethodBeat.i(130807);
            AppMethodBeat.o(130807);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130809);
        q qVar = (q) cVar;
        String optString = jSONObject.optString("localId");
        ab.i("MicroMsg.JsApiStopPlayVoice", "doStopVoice, appId : %s, localId : %s", qVar.getAppId(), optString);
        AppBrandMainProcessService.a(new StopPlayVoice());
        qVar.M(i, j("ok", null));
        JsApiStartPlayVoice.hBd = null;
        AppMethodBeat.o(130809);
    }

    public static void aCx() {
        AppMethodBeat.i(130808);
        if (bo.isNullOrNil(JsApiStartPlayVoice.hBd)) {
            AppMethodBeat.o(130808);
            return;
        }
        AppBrandMainProcessService.a(new StopPlayVoice());
        JsApiStartPlayVoice.hBd = null;
        AppMethodBeat.o(130808);
    }
}
