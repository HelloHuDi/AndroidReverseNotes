package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Creator<GeobFrame> CREATOR = new C08771();
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.GeobFrame$1 */
    static class C08771 implements Creator<GeobFrame> {
        C08771() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeobFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95304);
            GeobFrame geobFrame = new GeobFrame(parcel);
            AppMethodBeat.m2505o(95304);
            return geobFrame;
        }
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.mimeType = str;
        this.filename = str2;
        this.description = str3;
        this.data = bArr;
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        AppMethodBeat.m2504i(95305);
        this.mimeType = parcel.readString();
        this.filename = parcel.readString();
        this.description = parcel.readString();
        this.data = parcel.createByteArray();
        AppMethodBeat.m2505o(95305);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95306);
        if (this == obj) {
            AppMethodBeat.m2505o(95306);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95306);
            return false;
        } else {
            GeobFrame geobFrame = (GeobFrame) obj;
            if (C17675v.m27574j(this.mimeType, geobFrame.mimeType) && C17675v.m27574j(this.filename, geobFrame.filename) && C17675v.m27574j(this.description, geobFrame.description) && Arrays.equals(this.data, geobFrame.data)) {
                AppMethodBeat.m2505o(95306);
                return true;
            }
            AppMethodBeat.m2505o(95306);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.m2504i(95307);
        if (this.mimeType != null) {
            hashCode = this.mimeType.hashCode();
        } else {
            hashCode = 0;
        }
        int i2 = (hashCode + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.filename != null) {
            hashCode = this.filename.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.description != null) {
            i = this.description.hashCode();
        }
        hashCode = ((hashCode + i) * 31) + Arrays.hashCode(this.data);
        AppMethodBeat.m2505o(95307);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95308);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.filename);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.data);
        AppMethodBeat.m2505o(95308);
    }

    static {
        AppMethodBeat.m2504i(95309);
        AppMethodBeat.m2505o(95309);
    }
}
