package com.tencent.p177mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C18508a;
import com.tencent.p177mm.ipcinvoker.extension.C18509c;

/* renamed from: com.tencent.mm.ipcinvoker.extension.event.WrapperParcelable */
class WrapperParcelable implements Parcelable {
    public static final Creator<WrapperParcelable> CREATOR = new C185111();
    Object eGy;

    /* renamed from: com.tencent.mm.ipcinvoker.extension.event.WrapperParcelable$1 */
    static class C185111 implements Creator<WrapperParcelable> {
        C185111() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WrapperParcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114106);
            WrapperParcelable wrapperParcelable = new WrapperParcelable();
            if (parcel.readInt() == 1) {
                wrapperParcelable.eGy = C18509c.m28812a(parcel.readString(), parcel);
            }
            AppMethodBeat.m2505o(114106);
            return wrapperParcelable;
        }
    }

    /* synthetic */ WrapperParcelable(byte b) {
        this();
    }

    private WrapperParcelable() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114107);
        if (this.eGy != null) {
            C18508a ar = C18509c.m28815ar(this.eGy);
            if (ar != null) {
                parcel.writeInt(1);
                parcel.writeString(ar.getClass().getName());
                ar.mo20823a(this.eGy, parcel);
                AppMethodBeat.m2505o(114107);
                return;
            }
        }
        parcel.writeInt(1);
        AppMethodBeat.m2505o(114107);
    }

    static {
        AppMethodBeat.m2504i(114108);
        AppMethodBeat.m2505o(114108);
    }
}
