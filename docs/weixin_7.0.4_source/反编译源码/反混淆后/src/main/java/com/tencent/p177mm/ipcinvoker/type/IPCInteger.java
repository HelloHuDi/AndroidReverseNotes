package com.tencent.p177mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.type.IPCInteger */
public class IPCInteger implements Parcelable {
    public static final Creator<IPCInteger> CREATOR = new C185221();
    public int value;

    /* renamed from: com.tencent.mm.ipcinvoker.type.IPCInteger$1 */
    static class C185221 implements Creator<IPCInteger> {
        C185221() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCInteger[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114150);
            IPCInteger iPCInteger = new IPCInteger();
            iPCInteger.value = parcel.readInt();
            AppMethodBeat.m2505o(114150);
            return iPCInteger;
        }
    }

    public IPCInteger(int i) {
        this.value = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114151);
        parcel.writeInt(this.value);
        AppMethodBeat.m2505o(114151);
    }

    public String toString() {
        AppMethodBeat.m2504i(114152);
        String num = Integer.toString(this.value);
        AppMethodBeat.m2505o(114152);
        return num;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(114153);
        if (obj == this) {
            AppMethodBeat.m2505o(114153);
            return true;
        } else if (obj instanceof IPCInteger) {
            if (this.value == ((IPCInteger) obj).value) {
                AppMethodBeat.m2505o(114153);
                return true;
            }
            AppMethodBeat.m2505o(114153);
            return false;
        } else if (obj instanceof Integer) {
            boolean equals = obj.equals(Integer.valueOf(this.value));
            AppMethodBeat.m2505o(114153);
            return equals;
        } else {
            AppMethodBeat.m2505o(114153);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(114154);
        AppMethodBeat.m2505o(114154);
    }
}
