package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DebuggerInfo implements Parcelable {
    public static final Creator<DebuggerInfo> CREATOR = new Creator<DebuggerInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DebuggerInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(10800);
            DebuggerInfo debuggerInfo = new DebuggerInfo();
            debuggerInfo.hmD = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            debuggerInfo.hmE = z;
            if (parcel.readInt() == 0) {
                z2 = false;
            }
            debuggerInfo.hmF = z2;
            AppMethodBeat.o(10800);
            return debuggerInfo;
        }
    };
    public boolean hmD;
    public boolean hmE;
    public boolean hmF;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(10801);
        if (this.hmD) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.hmE) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.hmF) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        AppMethodBeat.o(10801);
    }

    static {
        AppMethodBeat.i(10802);
        AppMethodBeat.o(10802);
    }
}
