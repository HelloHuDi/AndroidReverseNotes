package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.config.l.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask extends MainProcessTask {
    public static final Creator<JsApiGetAppConfigTask> CREATOR = new Creator<JsApiGetAppConfigTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetAppConfigTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(130426);
            JsApiGetAppConfigTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask(parcel);
            AppMethodBeat.o(130426);
            return jsApiGetAppConfigTask;
        }
    };
    public String appId;
    public Runnable hww;
    public String key;
    public int scene;
    public int type;
    public String value;

    static /* synthetic */ boolean a(JsApiGetAppConfigTask jsApiGetAppConfigTask) {
        AppMethodBeat.i(130432);
        boolean aCb = jsApiGetAppConfigTask.aCb();
        AppMethodBeat.o(130432);
        return aCb;
    }

    public JsApiGetAppConfigTask(Parcel parcel) {
        AppMethodBeat.i(130427);
        g(parcel);
        AppMethodBeat.o(130427);
    }

    public final void asP() {
        AppMethodBeat.i(130428);
        if (g.RN().eJb) {
            Pair y = ((b) f.E(b.class)).y(this.appId, 4, this.scene);
            if (((Boolean) y.first).booleanValue()) {
                a aVar = a.gWl;
                a.z((long) ((Integer) y.second).intValue(), 166);
            }
            l.a(this.appId, this.type, 0, new c() {
                public final void xC(String str) {
                    AppMethodBeat.i(130425);
                    JsApiGetAppConfigTask.this.value = str;
                    JsApiGetAppConfigTask.a(JsApiGetAppConfigTask.this);
                    AppMethodBeat.o(130425);
                }
            }, !((Boolean) y.first).booleanValue());
            AppMethodBeat.o(130428);
            return;
        }
        AppMethodBeat.o(130428);
    }

    public final void asQ() {
        AppMethodBeat.i(130429);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(130429);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(130430);
        this.appId = parcel.readString();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readInt();
        this.scene = parcel.readInt();
        AppMethodBeat.o(130430);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(130431);
        parcel.writeString(this.appId);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeInt(this.type);
        parcel.writeInt(this.scene);
        AppMethodBeat.o(130431);
    }

    static {
        AppMethodBeat.i(130433);
        AppMethodBeat.o(130433);
    }
}
