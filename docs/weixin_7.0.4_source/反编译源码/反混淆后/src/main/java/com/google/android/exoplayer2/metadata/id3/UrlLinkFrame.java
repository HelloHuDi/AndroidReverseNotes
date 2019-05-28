package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class UrlLinkFrame extends Id3Frame {
    public static final Creator<UrlLinkFrame> CREATOR = new C320661();
    public final String description;
    public final String url;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.UrlLinkFrame$1 */
    static class C320661 implements Creator<UrlLinkFrame> {
        C320661() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UrlLinkFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95334);
            UrlLinkFrame urlLinkFrame = new UrlLinkFrame(parcel);
            AppMethodBeat.m2505o(95334);
            return urlLinkFrame;
        }
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.m2504i(95335);
        this.description = parcel.readString();
        this.url = parcel.readString();
        AppMethodBeat.m2505o(95335);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95336);
        if (this == obj) {
            AppMethodBeat.m2505o(95336);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95336);
            return false;
        } else {
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            if (this.f17724id.equals(urlLinkFrame.f17724id) && C17675v.m27574j(this.description, urlLinkFrame.description) && C17675v.m27574j(this.url, urlLinkFrame.url)) {
                AppMethodBeat.m2505o(95336);
                return true;
            }
            AppMethodBeat.m2505o(95336);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.m2504i(95337);
        int hashCode2 = (this.f17724id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31;
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
        AppMethodBeat.m2505o(95337);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95338);
        parcel.writeString(this.f17724id);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
        AppMethodBeat.m2505o(95338);
    }

    static {
        AppMethodBeat.m2504i(95339);
        AppMethodBeat.m2505o(95339);
    }
}
