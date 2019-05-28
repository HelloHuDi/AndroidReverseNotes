package com.tencent.p177mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.SampleTask2 */
public class SampleTask2 extends MainProcessTask {
    public static final Creator<SampleTask2> CREATOR = new C102721();

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.SampleTask2$1 */
    static class C102721 implements Creator<SampleTask2> {
        C102721() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SampleTask2[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(86961);
            SampleTask2 sampleTask2 = new SampleTask2();
            AppMethodBeat.m2505o(86961);
            return sampleTask2;
        }
    }

    public final void asP() {
        AppMethodBeat.m2504i(86962);
        C4990ab.m7412e("SampleTask2", "Run in Main Process");
        AppMethodBeat.m2505o(86962);
    }

    static {
        AppMethodBeat.m2504i(86963);
        AppMethodBeat.m2505o(86963);
    }
}
