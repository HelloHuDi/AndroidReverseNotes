package com.tencent.p177mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask */
public class ActiveMainProcessTask extends MainProcessTask {
    public static final Creator<ActiveMainProcessTask> CREATOR = new C297921();

    /* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask$1 */
    static class C297921 implements Creator<ActiveMainProcessTask> {
        C297921() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ActiveMainProcessTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(6243);
            ActiveMainProcessTask activeMainProcessTask = new ActiveMainProcessTask();
            AppMethodBeat.m2505o(6243);
            return activeMainProcessTask;
        }
    }

    public final void asP() {
        AppMethodBeat.m2504i(6244);
        C4990ab.m7416i("MicroMsg.ActiveMainProcessTask", "active");
        AppMethodBeat.m2505o(6244);
    }

    private ActiveMainProcessTask(byte b) {
    }

    static {
        AppMethodBeat.m2504i(6245);
        AppMethodBeat.m2505o(6245);
    }
}
