package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageInfoTask> CREATOR = new Creator<JsApiGetStorageInfoTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageInfoTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102047);
            JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
            jsApiGetStorageInfoTask.g(parcel);
            AppMethodBeat.o(102047);
            return jsApiGetStorageInfoTask;
        }
    };
    public String appId;
    public int hXg;
    public ArrayList<String> hXl;
    public Runnable hww;
    public int limit;
    public int size;

    public final void asP() {
        b bVar;
        AppMethodBeat.i(102048);
        if (e.B(com.tencent.luggage.sdk.customize.b.class) == null) {
            bVar = null;
        } else {
            bVar = ((com.tencent.luggage.sdk.customize.b) e.B(com.tencent.luggage.sdk.customize.b.class)).xG();
        }
        if (bVar == null) {
            aCb();
            AppMethodBeat.o(102048);
            return;
        }
        Object[] G = bVar.G(this.hXg, this.appId);
        this.hXl = (ArrayList) G[0];
        this.size = (int) Math.ceil(((Integer) G[1]).doubleValue() / 1000.0d);
        this.limit = (int) Math.ceil(((Integer) G[2]).doubleValue() / 1000.0d);
        aCb();
        AppMethodBeat.o(102048);
    }

    public final void asQ() {
        AppMethodBeat.i(102049);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(102049);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(102050);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        this.hXl = parcel.createStringArrayList();
        this.size = parcel.readInt();
        this.limit = parcel.readInt();
        AppMethodBeat.o(102050);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102051);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        parcel.writeStringList(this.hXl);
        parcel.writeInt(this.size);
        parcel.writeInt(this.limit);
        AppMethodBeat.o(102051);
    }

    static {
        AppMethodBeat.i(102052);
        AppMethodBeat.o(102052);
    }
}
