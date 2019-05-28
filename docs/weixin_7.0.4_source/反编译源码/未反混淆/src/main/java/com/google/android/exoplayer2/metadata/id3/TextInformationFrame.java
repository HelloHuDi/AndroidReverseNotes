package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class TextInformationFrame extends Id3Frame {
    public static final Creator<TextInformationFrame> CREATOR = new Creator<TextInformationFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TextInformationFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95328);
            TextInformationFrame textInformationFrame = new TextInformationFrame(parcel);
            AppMethodBeat.o(95328);
            return textInformationFrame;
        }
    };
    public final String description;
    public final String value;

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        AppMethodBeat.i(95329);
        this.description = parcel.readString();
        this.value = parcel.readString();
        AppMethodBeat.o(95329);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95330);
        if (this == obj) {
            AppMethodBeat.o(95330);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95330);
            return false;
        } else {
            TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
            if (this.id.equals(textInformationFrame.id) && v.j(this.description, textInformationFrame.description) && v.j(this.value, textInformationFrame.value)) {
                AppMethodBeat.o(95330);
                return true;
            }
            AppMethodBeat.o(95330);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.i(95331);
        int hashCode2 = (this.id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31;
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
        AppMethodBeat.o(95331);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95332);
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
        AppMethodBeat.o(95332);
    }

    static {
        AppMethodBeat.i(95333);
        AppMethodBeat.o(95333);
    }
}
