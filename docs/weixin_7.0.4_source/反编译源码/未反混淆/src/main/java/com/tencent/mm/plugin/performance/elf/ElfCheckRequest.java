package com.tencent.mm.plugin.performance.elf;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ElfCheckRequest implements Parcelable {
    public static final Creator<ElfCheckRequest> CREATOR = new Creator<ElfCheckRequest>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ElfCheckRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(111047);
            ElfCheckRequest elfCheckRequest = new ElfCheckRequest(parcel);
            AppMethodBeat.o(111047);
            return elfCheckRequest;
        }
    };
    public long oJs = 0;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(111048);
        parcel.writeLong(this.oJs);
        AppMethodBeat.o(111048);
    }

    protected ElfCheckRequest(Parcel parcel) {
        AppMethodBeat.i(111049);
        this.oJs = parcel.readLong();
        AppMethodBeat.o(111049);
    }

    static {
        AppMethodBeat.i(111050);
        AppMethodBeat.o(111050);
    }
}
