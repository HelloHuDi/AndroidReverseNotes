package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareInfo implements Parcelable {
    public static final Creator<ShareInfo> CREATOR = new Creator<ShareInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ShareInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(131479);
            ShareInfo shareInfo = new ShareInfo(parcel, (byte) 0);
            AppMethodBeat.o(131479);
            return shareInfo;
        }
    };
    public String bQh;
    public String bQi;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(131480);
        parcel.writeString(this.bQi);
        parcel.writeString(this.bQh);
        AppMethodBeat.o(131480);
    }

    public ShareInfo(String str, String str2) {
        this.bQi = str;
        this.bQh = str2;
    }

    private ShareInfo(Parcel parcel) {
        AppMethodBeat.i(131481);
        this.bQi = parcel.readString();
        this.bQh = parcel.readString();
        AppMethodBeat.o(131481);
    }

    static {
        AppMethodBeat.i(131482);
        AppMethodBeat.o(131482);
    }
}
