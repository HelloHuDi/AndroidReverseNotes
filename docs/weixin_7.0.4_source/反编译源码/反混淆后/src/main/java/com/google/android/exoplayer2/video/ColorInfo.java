package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Creator<ColorInfo> CREATOR = new C87181();
    private int aBR;
    public final int aUU;
    public final int aUV;
    public final int aUW;
    public final byte[] brS;

    /* renamed from: com.google.android.exoplayer2.video.ColorInfo$1 */
    static class C87181 implements Creator<ColorInfo> {
        C87181() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ColorInfo[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95981);
            ColorInfo colorInfo = new ColorInfo(parcel);
            AppMethodBeat.m2505o(95981);
            return colorInfo;
        }
    }

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.aUU = i;
        this.aUW = i2;
        this.aUV = i3;
        this.brS = bArr;
    }

    ColorInfo(Parcel parcel) {
        AppMethodBeat.m2504i(95982);
        this.aUU = parcel.readInt();
        this.aUW = parcel.readInt();
        this.aUV = parcel.readInt();
        this.brS = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
        AppMethodBeat.m2505o(95982);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95983);
        if (this == obj) {
            AppMethodBeat.m2505o(95983);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95983);
            return false;
        } else {
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.aUU == colorInfo.aUU && this.aUW == colorInfo.aUW && this.aUV == colorInfo.aUV && Arrays.equals(this.brS, colorInfo.brS)) {
                AppMethodBeat.m2505o(95983);
                return true;
            }
            AppMethodBeat.m2505o(95983);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(95984);
        String str = "ColorInfo(" + this.aUU + ", " + this.aUW + ", " + this.aUV + ", " + (this.brS != null) + ")";
        AppMethodBeat.m2505o(95984);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(95985);
        if (this.aBR == 0) {
            this.aBR = ((((((this.aUU + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.aUW) * 31) + this.aUV) * 31) + Arrays.hashCode(this.brS);
        }
        int i = this.aBR;
        AppMethodBeat.m2505o(95985);
        return i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95986);
        parcel.writeInt(this.aUU);
        parcel.writeInt(this.aUW);
        parcel.writeInt(this.aUV);
        parcel.writeInt(this.brS != null ? 1 : 0);
        if (this.brS != null) {
            parcel.writeByteArray(this.brS);
        }
        AppMethodBeat.m2505o(95986);
    }

    static {
        AppMethodBeat.m2504i(95987);
        AppMethodBeat.m2505o(95987);
    }
}
