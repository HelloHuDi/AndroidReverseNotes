package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class TextInformationFrame extends Id3Frame {
    public static final Creator<TextInformationFrame> CREATOR = new C86981();
    public final String description;
    public final String value;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.TextInformationFrame$1 */
    static class C86981 implements Creator<TextInformationFrame> {
        C86981() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TextInformationFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95328);
            TextInformationFrame textInformationFrame = new TextInformationFrame(parcel);
            AppMethodBeat.m2505o(95328);
            return textInformationFrame;
        }
    }

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.m2504i(95329);
        this.description = parcel.readString();
        this.value = parcel.readString();
        AppMethodBeat.m2505o(95329);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95330);
        if (this == obj) {
            AppMethodBeat.m2505o(95330);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95330);
            return false;
        } else {
            TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
            if (this.f17724id.equals(textInformationFrame.f17724id) && C17675v.m27574j(this.description, textInformationFrame.description) && C17675v.m27574j(this.value, textInformationFrame.value)) {
                AppMethodBeat.m2505o(95330);
                return true;
            }
            AppMethodBeat.m2505o(95330);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.m2504i(95331);
        int hashCode2 = (this.f17724id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.description != null) {
            hashCode = this.description.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.value != null) {
            i = this.value.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(95331);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95332);
        parcel.writeString(this.f17724id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
        AppMethodBeat.m2505o(95332);
    }

    static {
        AppMethodBeat.m2504i(95333);
        AppMethodBeat.m2505o(95333);
    }
}
