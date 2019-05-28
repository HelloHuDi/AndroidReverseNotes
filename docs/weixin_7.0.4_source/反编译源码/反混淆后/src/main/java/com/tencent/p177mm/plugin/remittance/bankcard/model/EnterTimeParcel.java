package com.tencent.p177mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C44196yq;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel */
public class EnterTimeParcel implements Parcelable {
    public static final Creator<EnterTimeParcel> CREATOR = new C434391();
    public String color;
    public int pLQ;
    public String pLR;
    public String pLS;
    public int pLT;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel$1 */
    static class C434391 implements Creator<EnterTimeParcel> {
        C434391() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EnterTimeParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(44496);
            EnterTimeParcel enterTimeParcel = new EnterTimeParcel(parcel);
            AppMethodBeat.m2505o(44496);
            return enterTimeParcel;
        }
    }

    public EnterTimeParcel(C44196yq c44196yq) {
        this.pLQ = c44196yq.pLQ;
        this.pLR = c44196yq.pLR;
        this.pLS = c44196yq.pLS;
        this.pLT = c44196yq.pLT;
        this.color = c44196yq.color;
    }

    public EnterTimeParcel(Parcel parcel) {
        AppMethodBeat.m2504i(44497);
        this.pLQ = parcel.readInt();
        this.pLR = parcel.readString();
        this.pLS = parcel.readString();
        this.pLT = parcel.readInt();
        this.color = parcel.readString();
        AppMethodBeat.m2505o(44497);
    }

    static {
        AppMethodBeat.m2504i(44499);
        AppMethodBeat.m2505o(44499);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(44498);
        parcel.writeInt(this.pLQ);
        parcel.writeString(this.pLR);
        parcel.writeString(this.pLS);
        parcel.writeInt(this.pLT);
        parcel.writeString(this.color);
        AppMethodBeat.m2505o(44498);
    }
}
