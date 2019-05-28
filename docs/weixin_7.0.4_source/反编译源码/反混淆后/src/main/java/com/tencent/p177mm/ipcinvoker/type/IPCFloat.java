package com.tencent.p177mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.type.IPCFloat */
public class IPCFloat implements Parcelable {
    public static final Creator<IPCFloat> CREATOR = new C185211();
    public float value;

    /* renamed from: com.tencent.mm.ipcinvoker.type.IPCFloat$1 */
    static class C185211 implements Creator<IPCFloat> {
        C185211() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCFloat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114145);
            IPCFloat iPCFloat = new IPCFloat();
            iPCFloat.value = parcel.readFloat();
            AppMethodBeat.m2505o(114145);
            return iPCFloat;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114146);
        parcel.writeFloat(this.value);
        AppMethodBeat.m2505o(114146);
    }

    public String toString() {
        AppMethodBeat.m2504i(114147);
        String f = Float.toString(this.value);
        AppMethodBeat.m2505o(114147);
        return f;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(114148);
        if (obj == this) {
            AppMethodBeat.m2505o(114148);
            return true;
        } else if (obj instanceof IPCFloat) {
            if (this.value == ((IPCFloat) obj).value) {
                AppMethodBeat.m2505o(114148);
                return true;
            }
            AppMethodBeat.m2505o(114148);
            return false;
        } else if (obj instanceof Float) {
            boolean equals = obj.equals(Float.valueOf(this.value));
            AppMethodBeat.m2505o(114148);
            return equals;
        } else {
            AppMethodBeat.m2505o(114148);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(114149);
        AppMethodBeat.m2505o(114149);
    }
}
