package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public class JsApiMMTask extends MainProcessTask {
    public static final Creator<JsApiMMTask> CREATOR = new Creator<JsApiMMTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiMMTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(6256);
            JsApiMMTask jsApiMMTask = new JsApiMMTask(parcel, (byte) 0);
            AppMethodBeat.o(6256);
            return jsApiMMTask;
        }
    };
    public String aIm;
    public String hAP;
    public a ujK;
    public String ujL;
    public String ujM;

    /* synthetic */ JsApiMMTask(Parcel parcel, byte b) {
        this(parcel);
    }

    static /* synthetic */ boolean a(JsApiMMTask jsApiMMTask) {
        AppMethodBeat.i(6262);
        boolean aCb = jsApiMMTask.aCb();
        AppMethodBeat.o(6262);
        return aCb;
    }

    public final void asP() {
        AppMethodBeat.i(6257);
        try {
            ((bc) Class.forName(this.ujL).newInstance()).a(ah.getContext(), this.hAP, new bc.a() {
                public final void d(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(6255);
                    JsApiMMTask.this.aIm = str;
                    if (jSONObject != null) {
                        JsApiMMTask.this.ujM = jSONObject.toString();
                    }
                    JsApiMMTask.a(JsApiMMTask.this);
                    AppMethodBeat.o(6255);
                }
            });
            AppMethodBeat.o(6257);
        } catch (Exception e) {
            AppMethodBeat.o(6257);
        }
    }

    public final void asQ() {
        AppMethodBeat.i(6258);
        aBW();
        if (this.ujK != null) {
            try {
                this.ujK.a(this.aIm, new JSONObject(this.ujM));
                AppMethodBeat.o(6258);
                return;
            } catch (Exception e) {
                this.ujK.a(this.aIm, null);
            }
        }
        AppMethodBeat.o(6258);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(6259);
        this.hAP = parcel.readString();
        this.ujL = parcel.readString();
        this.aIm = parcel.readString();
        this.ujM = parcel.readString();
        AppMethodBeat.o(6259);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(6260);
        parcel.writeString(this.hAP);
        parcel.writeString(this.ujL);
        parcel.writeString(this.aIm);
        parcel.writeString(this.ujM);
        AppMethodBeat.o(6260);
    }

    private JsApiMMTask(Parcel parcel) {
        AppMethodBeat.i(6261);
        g(parcel);
        AppMethodBeat.o(6261);
    }

    static {
        AppMethodBeat.i(6263);
        AppMethodBeat.o(6263);
    }
}
