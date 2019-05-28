package com.tencent.p177mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo */
public class DebuggerInfo implements Parcelable {
    public static final Creator<DebuggerInfo> CREATOR = new C382011();
    public boolean hmD;
    public boolean hmE;
    public boolean hmF;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo$1 */
    static class C382011 implements Creator<DebuggerInfo> {
        C382011() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DebuggerInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(10800);
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
            AppMethodBeat.m2505o(10800);
            return debuggerInfo;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(10801);
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
        AppMethodBeat.m2505o(10801);
    }

    static {
        AppMethodBeat.m2504i(10802);
        AppMethodBeat.m2505o(10802);
    }
}
