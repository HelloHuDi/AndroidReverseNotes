package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CDNTaskState implements Parcelable {
    public static final Creator<CDNTaskState> CREATOR = new Creator<CDNTaskState>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CDNTaskState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(929);
            CDNTaskState cDNTaskState = new CDNTaskState();
            cDNTaskState.taskState = parcel.readInt();
            cDNTaskState.completeSize = parcel.readInt();
            cDNTaskState.fileTotalSize = parcel.readInt();
            AppMethodBeat.o(929);
            return cDNTaskState;
        }
    };
    public int completeSize = 0;
    public int fileTotalSize = 0;
    public int taskState = -100;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(930);
        parcel.writeInt(this.taskState);
        parcel.writeInt(this.completeSize);
        parcel.writeInt(this.fileTotalSize);
        AppMethodBeat.o(930);
    }

    static {
        AppMethodBeat.i(931);
        AppMethodBeat.o(931);
    }
}
