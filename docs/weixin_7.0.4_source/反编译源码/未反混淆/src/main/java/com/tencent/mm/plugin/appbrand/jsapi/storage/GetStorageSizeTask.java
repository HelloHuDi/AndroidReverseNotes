package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class GetStorageSizeTask extends MainProcessTask {
    public static final Creator<GetStorageSizeTask> CREATOR = new Creator<GetStorageSizeTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GetStorageSizeTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102015);
            GetStorageSizeTask getStorageSizeTask = new GetStorageSizeTask(parcel);
            AppMethodBeat.o(102015);
            return getStorageSizeTask;
        }
    };
    public String appId;
    public Runnable hww;
    public int size;

    public final void asP() {
        b bVar;
        AppMethodBeat.i(102016);
        if (e.B(com.tencent.luggage.sdk.customize.b.class) == null) {
            bVar = null;
        } else {
            bVar = ((com.tencent.luggage.sdk.customize.b) e.B(com.tencent.luggage.sdk.customize.b.class)).xG();
        }
        if (bVar == null) {
            aCb();
            AppMethodBeat.o(102016);
            return;
        }
        this.size = bVar.xT(this.appId);
        aCb();
        AppMethodBeat.o(102016);
    }

    public final void asQ() {
        AppMethodBeat.i(102017);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(102017);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102018);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeInt(this.size);
        AppMethodBeat.o(102018);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(102019);
        this.appId = parcel.readString();
        this.size = parcel.readInt();
        AppMethodBeat.o(102019);
    }

    protected GetStorageSizeTask(Parcel parcel) {
        AppMethodBeat.i(102020);
        g(parcel);
        AppMethodBeat.o(102020);
    }

    static {
        AppMethodBeat.i(102021);
        AppMethodBeat.o(102021);
    }
}
