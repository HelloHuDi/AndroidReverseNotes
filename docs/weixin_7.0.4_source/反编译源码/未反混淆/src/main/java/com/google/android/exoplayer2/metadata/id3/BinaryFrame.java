package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Creator<BinaryFrame> CREATOR = new Creator<BinaryFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BinaryFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95280);
            BinaryFrame binaryFrame = new BinaryFrame(parcel);
            AppMethodBeat.o(95280);
            return binaryFrame;
        }
    };
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.i(95281);
        this.data = parcel.createByteArray();
        AppMethodBeat.o(95281);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95282);
        if (this == obj) {
            AppMethodBeat.o(95282);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95282);
            return false;
        } else {
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            if (this.id.equals(binaryFrame.id) && Arrays.equals(this.data, binaryFrame.data)) {
                AppMethodBeat.o(95282);
                return true;
            }
            AppMethodBeat.o(95282);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(95283);
        int hashCode = ((this.id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.data);
        AppMethodBeat.o(95283);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95284);
        parcel.writeString(this.id);
        parcel.writeByteArray(this.data);
        AppMethodBeat.o(95284);
    }

    static {
        AppMethodBeat.i(95285);
        AppMethodBeat.o(95285);
    }
}
