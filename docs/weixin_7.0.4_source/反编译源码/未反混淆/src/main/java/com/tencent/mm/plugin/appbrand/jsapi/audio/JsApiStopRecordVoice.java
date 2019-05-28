package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiStopRecordVoice extends a<q> {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    static class StopRecordVoice extends MainProcessTask {
        public static final Creator<StopRecordVoice> CREATOR = new Creator<StopRecordVoice>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopRecordVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130811);
                StopRecordVoice stopRecordVoice = new StopRecordVoice();
                AppMethodBeat.o(130811);
                return stopRecordVoice;
            }
        };

        private StopRecordVoice() {
        }

        /* synthetic */ StopRecordVoice(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.i(130812);
            m.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130810);
                    com.tencent.mm.plugin.appbrand.media.record.a.pg(1);
                    AppMethodBeat.o(130810);
                }
            });
            AppMethodBeat.o(130812);
        }

        static {
            AppMethodBeat.i(130813);
            AppMethodBeat.o(130813);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130815);
        q qVar = (q) cVar;
        g(qVar);
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(130815);
    }

    static void g(q qVar) {
        AppMethodBeat.i(130814);
        if (bo.isNullOrNil(JsApiStartRecordVoice.hBi)) {
            AppMethodBeat.o(130814);
            return;
        }
        com.tencent.mm.plugin.appbrand.page.a.c.a aVar = n.xa(qVar.getAppId()).gPf;
        if (aVar != null) {
            aVar.dismiss();
        }
        AppBrandMainProcessService.a(new StopRecordVoice());
        JsApiStartRecordVoice.hBi = null;
        AppMethodBeat.o(130814);
    }
}
