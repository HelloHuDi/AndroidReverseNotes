package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Creator<PrivFrame> CREATOR = new Creator<PrivFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PrivFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95322);
            PrivFrame privFrame = new PrivFrame(parcel);
            AppMethodBeat.o(95322);
            return privFrame;
        }
    };
    public final byte[] bfA;
    public final String bfz;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.bfz = str;
        this.bfA = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        AppMethodBeat.i(95323);
        this.bfz = parcel.readString();
        this.bfA = parcel.createByteArray();
        AppMethodBeat.o(95323);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95324);
        if (this == obj) {
            AppMethodBeat.o(95324);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95324);
            return false;
        } else {
            PrivFrame privFrame = (PrivFrame) obj;
            if (v.j(this.bfz, privFrame.bfz) && Arrays.equals(this.bfA, privFrame.bfA)) {
                AppMethodBeat.o(95324);
                return true;
            }
            AppMethodBeat.o(95324);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(95325);
        int hashCode = (((this.bfz != null ? this.bfz.hashCode() : 0) + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.bfA);
        AppMethodBeat.o(95325);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95326);
        parcel.writeString(this.bfz);
        parcel.writeByteArray(this.bfA);
        AppMethodBeat.o(95326);
    }

    static {
        AppMethodBeat.i(95327);
        AppMethodBeat.o(95327);
    }
}
