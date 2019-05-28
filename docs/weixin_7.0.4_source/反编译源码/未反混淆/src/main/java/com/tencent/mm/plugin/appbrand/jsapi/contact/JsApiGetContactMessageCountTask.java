package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ak;

class JsApiGetContactMessageCountTask extends MainProcessTask {
    public static final Creator<JsApiGetContactMessageCountTask> CREATOR = new Creator<JsApiGetContactMessageCountTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetContactMessageCountTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(131012);
            JsApiGetContactMessageCountTask jsApiGetContactMessageCountTask = new JsApiGetContactMessageCountTask(parcel);
            AppMethodBeat.o(131012);
            return jsApiGetContactMessageCountTask;
        }
    };
    public int csm;
    public Runnable hww;
    public String username;

    public JsApiGetContactMessageCountTask(Parcel parcel) {
        AppMethodBeat.i(131013);
        g(parcel);
        AppMethodBeat.o(131013);
    }

    public final void asP() {
        AppMethodBeat.i(131014);
        ak aoZ = ((j) g.K(j.class)).XR().aoZ(this.username);
        if (aoZ == null) {
            this.csm = -1;
            aCb();
            AppMethodBeat.o(131014);
            return;
        }
        this.csm = aoZ.field_unReadCount;
        aCb();
        AppMethodBeat.o(131014);
    }

    public final void asQ() {
        AppMethodBeat.i(131015);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(131015);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(131016);
        this.username = parcel.readString();
        this.csm = parcel.readInt();
        AppMethodBeat.o(131016);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(131017);
        parcel.writeString(this.username);
        parcel.writeInt(this.csm);
        AppMethodBeat.o(131017);
    }

    static {
        AppMethodBeat.i(131018);
        AppMethodBeat.o(131018);
    }
}
