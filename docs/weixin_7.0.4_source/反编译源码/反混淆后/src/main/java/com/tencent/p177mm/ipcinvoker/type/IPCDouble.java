package com.tencent.p177mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.type.IPCDouble */
public class IPCDouble implements Parcelable {
    public static final Creator<IPCDouble> CREATOR = new C16311();
    public double value;

    /* renamed from: com.tencent.mm.ipcinvoker.type.IPCDouble$1 */
    static class C16311 implements Creator<IPCDouble> {
        C16311() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCDouble[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114140);
            IPCDouble iPCDouble = new IPCDouble();
            iPCDouble.value = parcel.readDouble();
            AppMethodBeat.m2505o(114140);
            return iPCDouble;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114141);
        parcel.writeDouble(this.value);
        AppMethodBeat.m2505o(114141);
    }

    public String toString() {
        AppMethodBeat.m2504i(114142);
        String d = Double.toString(this.value);
        AppMethodBeat.m2505o(114142);
        return d;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(114143);
        if (obj == this) {
            AppMethodBeat.m2505o(114143);
            return true;
        } else if (obj instanceof IPCDouble) {
            if (this.value == ((IPCDouble) obj).value) {
                AppMethodBeat.m2505o(114143);
                return true;
            }
            AppMethodBeat.m2505o(114143);
            return false;
        } else if (obj instanceof Double) {
            boolean equals = obj.equals(Double.valueOf(this.value));
            AppMethodBeat.m2505o(114143);
            return equals;
        } else {
            AppMethodBeat.m2505o(114143);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(114144);
        AppMethodBeat.m2505o(114144);
    }
}
