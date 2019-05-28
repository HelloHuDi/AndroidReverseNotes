package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Creator<PrivFrame> CREATOR = new C176821();
    public final byte[] bfA;
    public final String bfz;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.PrivFrame$1 */
    static class C176821 implements Creator<PrivFrame> {
        C176821() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PrivFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95322);
            PrivFrame privFrame = new PrivFrame(parcel);
            AppMethodBeat.m2505o(95322);
            return privFrame;
        }
    }

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.bfz = str;
        this.bfA = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        AppMethodBeat.m2504i(95323);
        this.bfz = parcel.readString();
        this.bfA = parcel.createByteArray();
        AppMethodBeat.m2505o(95323);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95324);
        if (this == obj) {
            AppMethodBeat.m2505o(95324);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95324);
            return false;
        } else {
            PrivFrame privFrame = (PrivFrame) obj;
            if (C17675v.m27574j(this.bfz, privFrame.bfz) && Arrays.equals(this.bfA, privFrame.bfA)) {
                AppMethodBeat.m2505o(95324);
                return true;
            }
            AppMethodBeat.m2505o(95324);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(95325);
        int hashCode = (((this.bfz != null ? this.bfz.hashCode() : 0) + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.bfA);
        AppMethodBeat.m2505o(95325);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95326);
        parcel.writeString(this.bfz);
        parcel.writeByteArray(this.bfA);
        AppMethodBeat.m2505o(95326);
    }

    static {
        AppMethodBeat.m2504i(95327);
        AppMethodBeat.m2505o(95327);
    }
}
