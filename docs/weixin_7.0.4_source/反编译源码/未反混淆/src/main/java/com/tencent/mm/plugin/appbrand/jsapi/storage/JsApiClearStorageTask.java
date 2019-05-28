package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiClearStorageTask extends MainProcessTask {
    public static final Creator<JsApiClearStorageTask> CREATOR = new Creator<JsApiClearStorageTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiClearStorageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102028);
            JsApiClearStorageTask jsApiClearStorageTask = new JsApiClearStorageTask(parcel);
            AppMethodBeat.o(102028);
            return jsApiClearStorageTask;
        }
    };
    public String appId;
    public int hXg;

    public JsApiClearStorageTask(Parcel parcel) {
        AppMethodBeat.i(102029);
        g(parcel);
        AppMethodBeat.o(102029);
    }

    public final void asP() {
        b bVar;
        AppMethodBeat.i(102030);
        if (e.B(com.tencent.luggage.sdk.customize.b.class) == null) {
            bVar = null;
        } else {
            bVar = ((com.tencent.luggage.sdk.customize.b) e.B(com.tencent.luggage.sdk.customize.b.class)).xG();
        }
        if (bVar == null) {
            AppMethodBeat.o(102030);
            return;
        }
        bVar.F(this.hXg, this.appId);
        AppMethodBeat.o(102030);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(102031);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        AppMethodBeat.o(102031);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102032);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        AppMethodBeat.o(102032);
    }

    static {
        AppMethodBeat.i(102033);
        AppMethodBeat.o(102033);
    }
}
