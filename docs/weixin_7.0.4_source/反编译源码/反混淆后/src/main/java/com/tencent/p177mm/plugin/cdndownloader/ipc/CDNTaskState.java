package com.tencent.p177mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState */
public class CDNTaskState implements Parcelable {
    public static final Creator<CDNTaskState> CREATOR = new C276351();
    public int completeSize = 0;
    public int fileTotalSize = 0;
    public int taskState = -100;

    /* renamed from: com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState$1 */
    static class C276351 implements Creator<CDNTaskState> {
        C276351() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CDNTaskState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(929);
            CDNTaskState cDNTaskState = new CDNTaskState();
            cDNTaskState.taskState = parcel.readInt();
            cDNTaskState.completeSize = parcel.readInt();
            cDNTaskState.fileTotalSize = parcel.readInt();
            AppMethodBeat.m2505o(929);
            return cDNTaskState;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(930);
        parcel.writeInt(this.taskState);
        parcel.writeInt(this.completeSize);
        parcel.writeInt(this.fileTotalSize);
        AppMethodBeat.m2505o(930);
    }

    static {
        AppMethodBeat.m2504i(931);
        AppMethodBeat.m2505o(931);
    }
}
