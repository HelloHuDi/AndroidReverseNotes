package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Creator<ColorInfo> CREATOR = new Creator<ColorInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ColorInfo[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95981);
            ColorInfo colorInfo = new ColorInfo(parcel);
            AppMethodBeat.o(95981);
            return colorInfo;
        }
    };
    private int aBR;
    public final int aUU;
    public final int aUV;
    public final int aUW;
    public final byte[] brS;

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.aUU = i;
        this.aUW = i2;
        this.aUV = i3;
        this.brS = bArr;
    }

    ColorInfo(Parcel parcel) {
        AppMethodBeat.i(95982);
        this.aUU = parcel.readInt();
        this.aUW = parcel.readInt();
        this.aUV = parcel.readInt();
        this.brS = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
        AppMethodBeat.o(95982);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95983);
        if (this == obj) {
            AppMethodBeat.o(95983);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95983);
            return false;
        } else {
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.aUU == colorInfo.aUU && this.aUW == colorInfo.aUW && this.aUV == colorInfo.aUV && Arrays.equals(this.brS, colorInfo.brS)) {
                AppMethodBeat.o(95983);
                return true;
            }
            AppMethodBeat.o(95983);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(95984);
        String str = "ColorInfo(" + this.aUU + ", " + this.aUW + ", " + this.aUV + ", " + (this.brS != null) + ")";
        AppMethodBeat.o(95984);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.i(95985);
        if (this.aBR == 0) {
            this.aBR = ((((((this.aUU + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.aUW) * 31) + this.aUV) * 31) + Arrays.hashCode(this.brS);
        }
        int i = this.aBR;
        AppMethodBeat.o(95985);
        return i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95986);
        parcel.writeInt(this.aUU);
        parcel.writeInt(this.aUW);
        parcel.writeInt(this.aUV);
        parcel.writeInt(this.brS != null ? 1 : 0);
        if (this.brS != null) {
            parcel.writeByteArray(this.brS);
        }
        AppMethodBeat.o(95986);
    }

    static {
        AppMethodBeat.i(95987);
        AppMethodBeat.o(95987);
    }
}
