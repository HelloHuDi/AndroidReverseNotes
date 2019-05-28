package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Creator<ApicFrame> CREATOR = new Creator<ApicFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ApicFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95274);
            ApicFrame apicFrame = new ApicFrame(parcel);
            AppMethodBeat.o(95274);
            return apicFrame;
        }
    };
    public final int bfk;
    public final byte[] bfl;
    public final String description;
    public final String mimeType;

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = str2;
        this.bfk = i;
        this.bfl = bArr;
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        AppMethodBeat.i(95275);
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.bfk = parcel.readInt();
        this.bfl = parcel.createByteArray();
        AppMethodBeat.o(95275);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95276);
        if (this == obj) {
            AppMethodBeat.o(95276);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95276);
            return false;
        } else {
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.bfk == apicFrame.bfk && v.j(this.mimeType, apicFrame.mimeType) && v.j(this.description, apicFrame.description) && Arrays.equals(this.bfl, apicFrame.bfl)) {
                AppMethodBeat.o(95276);
                return true;
            }
            AppMethodBeat.o(95276);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.i(95277);
        int i2 = (this.bfk + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.mimeType != null) {
            hashCode = this.mimeType.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.description != null) {
            i = this.description.hashCode();
        }
        hashCode = ((hashCode + i) * 31) + Arrays.hashCode(this.bfl);
        AppMethodBeat.o(95277);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95278);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.bfk);
        parcel.writeByteArray(this.bfl);
        AppMethodBeat.o(95278);
    }

    static {
        AppMethodBeat.i(95279);
        AppMethodBeat.o(95279);
    }
}
