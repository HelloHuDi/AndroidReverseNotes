package com.tencent.p177mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.type.IPCLong */
public class IPCLong implements Parcelable {
    public static final Creator<IPCLong> CREATOR = new C16321();
    public long value;

    /* renamed from: com.tencent.mm.ipcinvoker.type.IPCLong$1 */
    static class C16321 implements Creator<IPCLong> {
        C16321() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCLong[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114155);
            IPCLong iPCLong = new IPCLong();
            iPCLong.value = parcel.readLong();
            AppMethodBeat.m2505o(114155);
            return iPCLong;
        }
    }

    public IPCLong(long j) {
        this.value = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114156);
        parcel.writeLong(this.value);
        AppMethodBeat.m2505o(114156);
    }

    public String toString() {
        AppMethodBeat.m2504i(114157);
        String l = Long.toString(this.value);
        AppMethodBeat.m2505o(114157);
        return l;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(114158);
        if (obj == this) {
            AppMethodBeat.m2505o(114158);
            return true;
        } else if (obj instanceof IPCLong) {
            if (this.value == ((IPCLong) obj).value) {
                AppMethodBeat.m2505o(114158);
                return true;
            }
            AppMethodBeat.m2505o(114158);
            return false;
        } else if (obj instanceof Long) {
            boolean equals = obj.equals(Long.valueOf(this.value));
            AppMethodBeat.m2505o(114158);
            return equals;
        } else {
            AppMethodBeat.m2505o(114158);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(114159);
        AppMethodBeat.m2505o(114159);
    }
}
