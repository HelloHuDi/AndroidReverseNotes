package com.tencent.p177mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.type.IPCBoolean */
public class IPCBoolean implements Parcelable {
    public static final Creator<IPCBoolean> CREATOR = new C263421();
    public boolean value;

    /* renamed from: com.tencent.mm.ipcinvoker.type.IPCBoolean$1 */
    static class C263421 implements Creator<IPCBoolean> {
        C263421() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCBoolean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(114130);
            IPCBoolean iPCBoolean = new IPCBoolean();
            if (parcel.readInt() != 1) {
                z = false;
            }
            iPCBoolean.value = z;
            AppMethodBeat.m2505o(114130);
            return iPCBoolean;
        }
    }

    public IPCBoolean(boolean z) {
        this.value = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114131);
        parcel.writeInt(this.value ? 1 : 0);
        AppMethodBeat.m2505o(114131);
    }

    public String toString() {
        AppMethodBeat.m2504i(114132);
        String bool = Boolean.toString(this.value);
        AppMethodBeat.m2505o(114132);
        return bool;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(114133);
        if (obj == this) {
            AppMethodBeat.m2505o(114133);
            return true;
        } else if (obj instanceof IPCBoolean) {
            if (this.value == ((IPCBoolean) obj).value) {
                AppMethodBeat.m2505o(114133);
                return true;
            }
            AppMethodBeat.m2505o(114133);
            return false;
        } else if (obj instanceof Boolean) {
            boolean equals = obj.equals(Boolean.valueOf(this.value));
            AppMethodBeat.m2505o(114133);
            return equals;
        } else {
            AppMethodBeat.m2505o(114133);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(114134);
        AppMethodBeat.m2505o(114134);
    }
}
