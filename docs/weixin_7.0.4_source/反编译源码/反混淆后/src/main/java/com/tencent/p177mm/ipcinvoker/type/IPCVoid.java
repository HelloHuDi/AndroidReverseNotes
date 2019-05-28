package com.tencent.p177mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.type.IPCVoid */
public class IPCVoid implements Parcelable {
    public static final Creator<IPCVoid> CREATOR = new C263431();
    public static final IPCVoid eGH = new IPCVoid();

    /* renamed from: com.tencent.mm.ipcinvoker.type.IPCVoid$1 */
    static class C263431 implements Creator<IPCVoid> {
        C263431() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCVoid[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114164);
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.m2505o(114164);
            return iPCVoid;
        }
    }

    static {
        AppMethodBeat.m2504i(114165);
        AppMethodBeat.m2505o(114165);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
