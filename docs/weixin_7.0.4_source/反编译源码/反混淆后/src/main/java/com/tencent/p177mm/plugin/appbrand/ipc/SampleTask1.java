package com.tencent.p177mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.SampleTask1 */
public class SampleTask1 extends MainProcessTask {
    public static final Creator<SampleTask1> CREATOR = new C21731();
    public String hvG;
    public String hvH;

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.SampleTask1$1 */
    static class C21731 implements Creator<SampleTask1> {
        C21731() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SampleTask1[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(86954);
            SampleTask1 sampleTask1 = new SampleTask1(parcel);
            AppMethodBeat.m2505o(86954);
            return sampleTask1;
        }
    }

    public SampleTask1(Parcel parcel) {
        AppMethodBeat.m2504i(86955);
        mo6032g(parcel);
        AppMethodBeat.m2505o(86955);
    }

    public final void asP() {
        AppMethodBeat.m2504i(86956);
        C4990ab.m7412e("SampleTask", this.hvG);
        this.hvH = "String from Main Process";
        aCb();
        AppMethodBeat.m2505o(86956);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(86957);
        C4990ab.m7412e("SampleTask", this.hvH);
        AppMethodBeat.m2505o(86957);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(86958);
        this.hvG = parcel.readString();
        this.hvH = parcel.readString();
        AppMethodBeat.m2505o(86958);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(86959);
        parcel.writeString(this.hvG);
        parcel.writeString(this.hvH);
        AppMethodBeat.m2505o(86959);
    }

    static {
        AppMethodBeat.m2504i(86960);
        AppMethodBeat.m2505o(86960);
    }
}
