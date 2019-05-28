package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

public class ActiveMainProcessTask extends MainProcessTask {
    public static final Creator<ActiveMainProcessTask> CREATOR = new Creator<ActiveMainProcessTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ActiveMainProcessTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(6243);
            ActiveMainProcessTask activeMainProcessTask = new ActiveMainProcessTask();
            AppMethodBeat.o(6243);
            return activeMainProcessTask;
        }
    };

    public final void asP() {
        AppMethodBeat.i(6244);
        ab.i("MicroMsg.ActiveMainProcessTask", "active");
        AppMethodBeat.o(6244);
    }

    private ActiveMainProcessTask(byte b) {
    }

    static {
        AppMethodBeat.i(6245);
        AppMethodBeat.o(6245);
    }
}
