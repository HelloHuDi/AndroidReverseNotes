package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask extends MainProcessTask {
    public static final Creator<JsApiRemoveStorageTask> CREATOR = new Creator<JsApiRemoveStorageTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiRemoveStorageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102067);
            JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
            jsApiRemoveStorageTask.g(parcel);
            AppMethodBeat.o(102067);
            return jsApiRemoveStorageTask;
        }
    };
    public String appId;
    public int hXg;
    public String key;

    public final void asP() {
        b bVar;
        AppMethodBeat.i(102068);
        if (e.B(com.tencent.luggage.sdk.customize.b.class) == null) {
            bVar = null;
        } else {
            bVar = ((com.tencent.luggage.sdk.customize.b) e.B(com.tencent.luggage.sdk.customize.b.class)).xG();
        }
        if (bVar == null) {
            AppMethodBeat.o(102068);
            return;
        }
        bVar.l(this.hXg, this.appId, this.key);
        AppMethodBeat.o(102068);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102069);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        parcel.writeString(this.key);
        AppMethodBeat.o(102069);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(102070);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        this.key = parcel.readString();
        AppMethodBeat.o(102070);
    }

    static {
        AppMethodBeat.i(102071);
        AppMethodBeat.o(102071);
    }
}
