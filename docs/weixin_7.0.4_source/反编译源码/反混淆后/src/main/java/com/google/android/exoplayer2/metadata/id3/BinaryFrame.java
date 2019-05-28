package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Creator<BinaryFrame> CREATOR = new C86961();
    public final byte[] data;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.BinaryFrame$1 */
    static class C86961 implements Creator<BinaryFrame> {
        C86961() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BinaryFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95280);
            BinaryFrame binaryFrame = new BinaryFrame(parcel);
            AppMethodBeat.m2505o(95280);
            return binaryFrame;
        }
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.m2504i(95281);
        this.data = parcel.createByteArray();
        AppMethodBeat.m2505o(95281);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95282);
        if (this == obj) {
            AppMethodBeat.m2505o(95282);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95282);
            return false;
        } else {
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            if (this.f17724id.equals(binaryFrame.f17724id) && Arrays.equals(this.data, binaryFrame.data)) {
                AppMethodBeat.m2505o(95282);
                return true;
            }
            AppMethodBeat.m2505o(95282);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(95283);
        int hashCode = ((this.f17724id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.data);
        AppMethodBeat.m2505o(95283);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95284);
        parcel.writeString(this.f17724id);
        parcel.writeByteArray(this.data);
        AppMethodBeat.m2505o(95284);
    }

    static {
        AppMethodBeat.m2504i(95285);
        AppMethodBeat.m2505o(95285);
    }
}
