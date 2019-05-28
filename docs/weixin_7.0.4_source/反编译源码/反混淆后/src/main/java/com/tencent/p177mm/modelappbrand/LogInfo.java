package com.tencent.p177mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.modelappbrand.LogInfo */
public class LogInfo implements Parcelable {
    public static final Creator<LogInfo> CREATOR = new C379231();
    public int level;
    public String message;
    /* renamed from: ts */
    public long f16124ts;

    /* renamed from: com.tencent.mm.modelappbrand.LogInfo$1 */
    static class C379231 implements Creator<LogInfo> {
        C379231() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LogInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(70627);
            LogInfo logInfo = new LogInfo();
            logInfo.f16124ts = parcel.readLong();
            logInfo.level = parcel.readInt();
            logInfo.message = parcel.readString();
            AppMethodBeat.m2505o(70627);
            return logInfo;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(70628);
        parcel.writeLong(this.f16124ts);
        parcel.writeInt(this.level);
        parcel.writeString(this.message);
        AppMethodBeat.m2505o(70628);
    }

    static {
        AppMethodBeat.m2504i(70629);
        AppMethodBeat.m2505o(70629);
    }
}
