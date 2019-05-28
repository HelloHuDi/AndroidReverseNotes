package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SpliceNullCommand extends SpliceCommand {
    public static final Creator<SpliceNullCommand> CREATOR = new C255471();

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand$1 */
    static class C255471 implements Creator<SpliceNullCommand> {
        C255471() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SpliceNullCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95371);
            SpliceNullCommand spliceNullCommand = new SpliceNullCommand();
            AppMethodBeat.m2505o(95371);
            return spliceNullCommand;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
    }

    static {
        AppMethodBeat.m2504i(95372);
        AppMethodBeat.m2505o(95372);
    }
}
