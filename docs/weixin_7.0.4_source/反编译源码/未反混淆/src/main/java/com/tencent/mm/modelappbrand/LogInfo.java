package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogInfo implements Parcelable {
    public static final Creator<LogInfo> CREATOR = new Creator<LogInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LogInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70627);
            LogInfo logInfo = new LogInfo();
            logInfo.ts = parcel.readLong();
            logInfo.level = parcel.readInt();
            logInfo.message = parcel.readString();
            AppMethodBeat.o(70627);
            return logInfo;
        }
    };
    public int level;
    public String message;
    public long ts;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(70628);
        parcel.writeLong(this.ts);
        parcel.writeInt(this.level);
        parcel.writeString(this.message);
        AppMethodBeat.o(70628);
    }

    static {
        AppMethodBeat.i(70629);
        AppMethodBeat.o(70629);
    }
}
