package com.tencent.p177mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;

/* renamed from: com.tencent.mm.plugin.appbrand.AppBrandMainProcessPrepareTask */
public class AppBrandMainProcessPrepareTask extends MainProcessTask {
    public static final Creator<AppBrandMainProcessPrepareTask> CREATOR = new C189921();
    private final Runnable gNv = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.AppBrandMainProcessPrepareTask$1 */
    static class C189921 implements Creator<AppBrandMainProcessPrepareTask> {
        C189921() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandMainProcessPrepareTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(128943);
            AppBrandMainProcessPrepareTask appBrandMainProcessPrepareTask = new AppBrandMainProcessPrepareTask();
            AppMethodBeat.m2505o(128943);
            return appBrandMainProcessPrepareTask;
        }
    }

    AppBrandMainProcessPrepareTask() {
        AppMethodBeat.m2504i(128944);
        aBV();
        AppMethodBeat.m2505o(128944);
    }

    public final void asP() {
        AppMethodBeat.m2504i(128945);
        aCb();
        AppMethodBeat.m2505o(128945);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(128946);
        if (this.gNv != null) {
            this.gNv.run();
        }
        aBW();
        AppMethodBeat.m2505o(128946);
    }

    static {
        AppMethodBeat.m2504i(128947);
        AppMethodBeat.m2505o(128947);
    }
}
