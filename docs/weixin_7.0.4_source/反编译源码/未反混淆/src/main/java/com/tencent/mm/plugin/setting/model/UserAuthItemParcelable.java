package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserAuthItemParcelable implements Parcelable {
    public static final Creator<UserAuthItemParcelable> CREATOR = new Creator<UserAuthItemParcelable>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UserAuthItemParcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(126880);
            UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
            userAuthItemParcelable.scope = parcel.readString();
            userAuthItemParcelable.qkh = parcel.readString();
            userAuthItemParcelable.state = parcel.readInt();
            userAuthItemParcelable.qki = parcel.readInt();
            AppMethodBeat.o(126880);
            return userAuthItemParcelable;
        }
    };
    public String qkh;
    public int qki;
    public String scope;
    public int state;

    static {
        AppMethodBeat.i(126882);
        AppMethodBeat.o(126882);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(126881);
        parcel.writeString(this.scope);
        parcel.writeString(this.qkh);
        parcel.writeInt(this.state);
        parcel.writeInt(this.qki);
        AppMethodBeat.o(126881);
    }
}
