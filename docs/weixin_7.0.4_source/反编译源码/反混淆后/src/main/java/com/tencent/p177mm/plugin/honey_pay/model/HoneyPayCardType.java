package com.tencent.p177mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.asj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType */
public class HoneyPayCardType implements Parcelable {
    public static final Creator<HoneyPayCardType> CREATOR = new C122251();
    /* renamed from: wR */
    public byte[] f2910wR;

    /* renamed from: com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType$1 */
    static class C122251 implements Creator<HoneyPayCardType> {
        C122251() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new HoneyPayCardType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(41745);
            HoneyPayCardType honeyPayCardType = new HoneyPayCardType(parcel);
            AppMethodBeat.m2505o(41745);
            return honeyPayCardType;
        }
    }

    public HoneyPayCardType(asj asj) {
        AppMethodBeat.m2504i(41746);
        try {
            this.f2910wR = asj.toByteArray();
            AppMethodBeat.m2505o(41746);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.HoneyPayCardType", e, "", new Object[0]);
            AppMethodBeat.m2505o(41746);
        }
    }

    protected HoneyPayCardType(Parcel parcel) {
        AppMethodBeat.m2504i(41747);
        this.f2910wR = new byte[parcel.readInt()];
        parcel.readByteArray(this.f2910wR);
        AppMethodBeat.m2505o(41747);
    }

    static {
        AppMethodBeat.m2504i(41749);
        AppMethodBeat.m2505o(41749);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(41748);
        parcel.writeInt(this.f2910wR.length);
        parcel.writeByteArray(this.f2910wR);
        AppMethodBeat.m2505o(41748);
    }
}
