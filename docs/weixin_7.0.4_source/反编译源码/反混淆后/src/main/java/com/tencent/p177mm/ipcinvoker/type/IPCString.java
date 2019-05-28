package com.tencent.p177mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.type.IPCString */
public class IPCString implements Parcelable {
    public static final Creator<IPCString> CREATOR = new C378721();
    public String value;

    /* renamed from: com.tencent.mm.ipcinvoker.type.IPCString$1 */
    static class C378721 implements Creator<IPCString> {
        C378721() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCString[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114160);
            IPCString iPCString = new IPCString();
            iPCString.value = parcel.readString();
            AppMethodBeat.m2505o(114160);
            return iPCString;
        }
    }

    public IPCString(String str) {
        this.value = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114161);
        parcel.writeString(this.value);
        AppMethodBeat.m2505o(114161);
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(114162);
        if (obj == this) {
            AppMethodBeat.m2505o(114162);
            return true;
        } else if (obj instanceof IPCString) {
            IPCString iPCString = (IPCString) obj;
            if (this.value == iPCString.value || (this.value != null && this.value.equals(iPCString.value))) {
                AppMethodBeat.m2505o(114162);
                return true;
            }
            AppMethodBeat.m2505o(114162);
            return false;
        } else if (obj instanceof String) {
            boolean equals = obj.equals(this.value);
            AppMethodBeat.m2505o(114162);
            return equals;
        } else {
            AppMethodBeat.m2505o(114162);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(114163);
        AppMethodBeat.m2505o(114163);
    }
}
