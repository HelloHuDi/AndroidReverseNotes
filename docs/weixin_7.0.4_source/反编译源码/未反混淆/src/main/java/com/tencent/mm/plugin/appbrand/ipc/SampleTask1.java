package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class SampleTask1 extends MainProcessTask {
    public static final Creator<SampleTask1> CREATOR = new Creator<SampleTask1>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SampleTask1[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(86954);
            SampleTask1 sampleTask1 = new SampleTask1(parcel);
            AppMethodBeat.o(86954);
            return sampleTask1;
        }
    };
    public String hvG;
    public String hvH;

    public SampleTask1(Parcel parcel) {
        AppMethodBeat.i(86955);
        g(parcel);
        AppMethodBeat.o(86955);
    }

    public final void asP() {
        AppMethodBeat.i(86956);
        ab.e("SampleTask", this.hvG);
        this.hvH = "String from Main Process";
        aCb();
        AppMethodBeat.o(86956);
    }

    public final void asQ() {
        AppMethodBeat.i(86957);
        ab.e("SampleTask", this.hvH);
        AppMethodBeat.o(86957);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(86958);
        this.hvG = parcel.readString();
        this.hvH = parcel.readString();
        AppMethodBeat.o(86958);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(86959);
        parcel.writeString(this.hvG);
        parcel.writeString(this.hvH);
        AppMethodBeat.o(86959);
    }

    static {
        AppMethodBeat.i(86960);
        AppMethodBeat.o(86960);
    }
}
