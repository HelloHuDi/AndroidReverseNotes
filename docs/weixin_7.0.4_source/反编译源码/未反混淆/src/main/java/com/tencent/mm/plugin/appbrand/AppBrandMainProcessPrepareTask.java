package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class AppBrandMainProcessPrepareTask extends MainProcessTask {
    public static final Creator<AppBrandMainProcessPrepareTask> CREATOR = new Creator<AppBrandMainProcessPrepareTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandMainProcessPrepareTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(128943);
            AppBrandMainProcessPrepareTask appBrandMainProcessPrepareTask = new AppBrandMainProcessPrepareTask();
            AppMethodBeat.o(128943);
            return appBrandMainProcessPrepareTask;
        }
    };
    private final Runnable gNv = null;

    AppBrandMainProcessPrepareTask() {
        AppMethodBeat.i(128944);
        aBV();
        AppMethodBeat.o(128944);
    }

    public final void asP() {
        AppMethodBeat.i(128945);
        aCb();
        AppMethodBeat.o(128945);
    }

    public final void asQ() {
        AppMethodBeat.i(128946);
        if (this.gNv != null) {
            this.gNv.run();
        }
        aBW();
        AppMethodBeat.o(128946);
    }

    static {
        AppMethodBeat.i(128947);
        AppMethodBeat.o(128947);
    }
}
