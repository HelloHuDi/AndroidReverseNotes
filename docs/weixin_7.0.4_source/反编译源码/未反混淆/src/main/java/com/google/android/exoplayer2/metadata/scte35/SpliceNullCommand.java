package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SpliceNullCommand extends SpliceCommand {
    public static final Creator<SpliceNullCommand> CREATOR = new Creator<SpliceNullCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SpliceNullCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95371);
            SpliceNullCommand spliceNullCommand = new SpliceNullCommand();
            AppMethodBeat.o(95371);
            return spliceNullCommand;
        }
    };

    public final void writeToParcel(Parcel parcel, int i) {
    }

    static {
        AppMethodBeat.i(95372);
        AppMethodBeat.o(95372);
    }
}
