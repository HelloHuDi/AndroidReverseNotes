package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class CommentFrame extends Id3Frame {
    public static final Creator<CommentFrame> CREATOR = new Creator<CommentFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommentFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95298);
            CommentFrame commentFrame = new CommentFrame(parcel);
            AppMethodBeat.o(95298);
            return commentFrame;
        }
    };
    public final String aOt;
    public final String description;
    public final String text;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.aOt = str;
        this.description = str2;
        this.text = str3;
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        AppMethodBeat.i(95299);
        this.aOt = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
        AppMethodBeat.o(95299);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95300);
        if (this == obj) {
            AppMethodBeat.o(95300);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95300);
            return false;
        } else {
            CommentFrame commentFrame = (CommentFrame) obj;
            if (v.j(this.description, commentFrame.description) && v.j(this.aOt, commentFrame.aOt) && v.j(this.text, commentFrame.text)) {
                AppMethodBeat.o(95300);
                return true;
            }
            AppMethodBeat.o(95300);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.i(95301);
        if (this.aOt != null) {
            hashCode = this.aOt.hashCode();
        } else {
            hashCode = 0;
        }
        int i2 = (hashCode + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (this.description != null) {
            hashCode = this.description.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.text != null) {
            i = this.text.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(95301);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95302);
        parcel.writeString(this.id);
        parcel.writeString(this.aOt);
        parcel.writeString(this.text);
        AppMethodBeat.o(95302);
    }

    static {
        AppMethodBeat.i(95303);
        AppMethodBeat.o(95303);
    }
}
