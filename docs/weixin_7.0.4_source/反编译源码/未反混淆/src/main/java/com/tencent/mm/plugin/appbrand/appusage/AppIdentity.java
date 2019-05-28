package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppIdentity implements Parcelable {
    public static final Creator<AppIdentity> CREATOR = new Creator<AppIdentity>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppIdentity[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(129695);
            AppIdentity appIdentity = new AppIdentity(parcel);
            AppMethodBeat.o(129695);
            return appIdentity;
        }
    };
    public final int har;
    public final String username;

    public AppIdentity(String str, int i) {
        this.username = str;
        this.har = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(129696);
        parcel.writeString(this.username);
        parcel.writeInt(this.har);
        AppMethodBeat.o(129696);
    }

    protected AppIdentity(Parcel parcel) {
        AppMethodBeat.i(129697);
        this.username = parcel.readString();
        this.har = parcel.readInt();
        AppMethodBeat.o(129697);
    }

    static {
        AppMethodBeat.i(129698);
        AppMethodBeat.o(129698);
    }
}
