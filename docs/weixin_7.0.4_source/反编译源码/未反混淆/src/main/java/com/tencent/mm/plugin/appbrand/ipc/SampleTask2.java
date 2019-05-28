package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class SampleTask2 extends MainProcessTask {
    public static final Creator<SampleTask2> CREATOR = new Creator<SampleTask2>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SampleTask2[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(86961);
            SampleTask2 sampleTask2 = new SampleTask2();
            AppMethodBeat.o(86961);
            return sampleTask2;
        }
    };

    public final void asP() {
        AppMethodBeat.i(86962);
        ab.e("SampleTask2", "Run in Main Process");
        AppMethodBeat.o(86962);
    }

    static {
        AppMethodBeat.i(86963);
        AppMethodBeat.o(86963);
    }
}
