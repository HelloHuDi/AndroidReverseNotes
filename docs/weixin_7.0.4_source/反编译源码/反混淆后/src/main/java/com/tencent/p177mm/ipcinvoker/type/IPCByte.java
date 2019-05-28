package com.tencent.p177mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.type.IPCByte */
public class IPCByte implements Parcelable {
    public static final Creator<IPCByte> CREATOR = new C327161();
    public byte value;

    /* renamed from: com.tencent.mm.ipcinvoker.type.IPCByte$1 */
    static class C327161 implements Creator<IPCByte> {
        C327161() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCByte[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114135);
            IPCByte iPCByte = new IPCByte();
            iPCByte.value = parcel.readByte();
            AppMethodBeat.m2505o(114135);
            return iPCByte;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114136);
        parcel.writeByte(this.value);
        AppMethodBeat.m2505o(114136);
    }

    public String toString() {
        AppMethodBeat.m2504i(114137);
        String num = Integer.toString(this.value);
        AppMethodBeat.m2505o(114137);
        return num;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(114138);
        if (obj == this) {
            AppMethodBeat.m2505o(114138);
            return true;
        } else if (obj instanceof IPCByte) {
            if (this.value == ((IPCByte) obj).value) {
                AppMethodBeat.m2505o(114138);
                return true;
            }
            AppMethodBeat.m2505o(114138);
            return false;
        } else if (obj instanceof Byte) {
            boolean equals = obj.equals(Byte.valueOf(this.value));
            AppMethodBeat.m2505o(114138);
            return equals;
        } else {
            AppMethodBeat.m2505o(114138);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(114139);
        AppMethodBeat.m2505o(114139);
    }
}
