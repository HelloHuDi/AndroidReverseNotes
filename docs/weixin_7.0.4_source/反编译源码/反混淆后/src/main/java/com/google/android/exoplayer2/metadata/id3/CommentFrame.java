package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class CommentFrame extends Id3Frame {
    public static final Creator<CommentFrame> CREATOR = new C08761();
    public final String aOt;
    public final String description;
    public final String text;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.CommentFrame$1 */
    static class C08761 implements Creator<CommentFrame> {
        C08761() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommentFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95298);
            CommentFrame commentFrame = new CommentFrame(parcel);
            AppMethodBeat.m2505o(95298);
            return commentFrame;
        }
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.aOt = str;
        this.description = str2;
        this.text = str3;
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        AppMethodBeat.m2504i(95299);
        this.aOt = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
        AppMethodBeat.m2505o(95299);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95300);
        if (this == obj) {
            AppMethodBeat.m2505o(95300);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95300);
            return false;
        } else {
            CommentFrame commentFrame = (CommentFrame) obj;
            if (C17675v.m27574j(this.description, commentFrame.description) && C17675v.m27574j(this.aOt, commentFrame.aOt) && C17675v.m27574j(this.text, commentFrame.text)) {
                AppMethodBeat.m2505o(95300);
                return true;
            }
            AppMethodBeat.m2505o(95300);
            return false;
        }
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.m2504i(95301);
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
        AppMethodBeat.m2505o(95301);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95302);
        parcel.writeString(this.f17724id);
        parcel.writeString(this.aOt);
        parcel.writeString(this.text);
        AppMethodBeat.m2505o(95302);
    }

    static {
        AppMethodBeat.m2504i(95303);
        AppMethodBeat.m2505o(95303);
    }
}
