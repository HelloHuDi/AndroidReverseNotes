package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Creator<ApicFrame> CREATOR = new C08751();
    public final int bfk;
    public final byte[] bfl;
    public final String description;
    public final String mimeType;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.ApicFrame$1 */
    static class C08751 implements Creator<ApicFrame> {
        C08751() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ApicFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95274);
            ApicFrame apicFrame = new ApicFrame(parcel);
            AppMethodBeat.m2505o(95274);
            return apicFrame;
        }
    }

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = str2;
        this.bfk = i;
        this.bfl = bArr;
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        AppMethodBeat.m2504i(95275);
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.bfk = parcel.readInt();
        this.bfl = parcel.createByteArray();
        AppMethodBeat.m2505o(95275);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95276);
        if (this == obj) {
            AppMethodBeat.m2505o(95276);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95276);
            return false;
        } else {
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.bfk == apicFrame.bfk && C17675v.m27574j(this.mimeType, apicFrame.mimeType) && C17675v.m27574j(this.description, apicFrame.description) && Arrays.equals(this.bfl, apicFrame.bfl)) {
                AppMethodBeat.m2505o(95276);
                return true;
            }
            AppMethodBeat.m2505o(95276);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.m2504i(95277);
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
        AppMethodBeat.m2505o(95277);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95278);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.bfk);
        parcel.writeByteArray(this.bfl);
        AppMethodBeat.m2505o(95278);
    }

    static {
        AppMethodBeat.m2504i(95279);
        AppMethodBeat.m2505o(95279);
    }
}
