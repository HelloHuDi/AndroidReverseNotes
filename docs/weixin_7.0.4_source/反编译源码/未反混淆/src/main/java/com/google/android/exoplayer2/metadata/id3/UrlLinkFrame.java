package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class UrlLinkFrame extends Id3Frame {
    public static final Creator<UrlLinkFrame> CREATOR = new Creator<UrlLinkFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UrlLinkFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95334);
            UrlLinkFrame urlLinkFrame = new UrlLinkFrame(parcel);
            AppMethodBeat.o(95334);
            return urlLinkFrame;
        }
    };
    public final String description;
    public final String url;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.i(95335);
        this.description = parcel.readString();
        this.url = parcel.readString();
        AppMethodBeat.o(95335);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95336);
        if (this == obj) {
            AppMethodBeat.o(95336);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95336);
            return false;
        } else {
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            if (this.id.equals(urlLinkFrame.id) && v.j(this.description, urlLinkFrame.description) && v.j(this.url, urlLinkFrame.url)) {
                AppMethodBeat.o(95336);
                return true;
            }
            AppMethodBeat.o(95336);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.i(95337);
        int hashCode2 = (this.id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.description != null) {
            hashCode = this.description.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.url != null) {
            i = this.url.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(95337);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95338);
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
        AppMethodBeat.o(95338);
    }

    static {
        AppMethodBeat.i(95339);
        AppMethodBeat.o(95339);
    }
}
