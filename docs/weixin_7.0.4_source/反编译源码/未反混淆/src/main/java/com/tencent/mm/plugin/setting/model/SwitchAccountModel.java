package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwitchAccountModel implements Parcelable {
    public static final Creator<SwitchAccountModel> CREATOR = new Creator<SwitchAccountModel>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SwitchAccountModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(126862);
            SwitchAccountModel switchAccountModel = new SwitchAccountModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
            AppMethodBeat.o(126862);
            return switchAccountModel;
        }
    };
    public final String mnu;
    public final String qjK;
    public final String qjL;
    public final int qjM;
    public final String username;

    static {
        AppMethodBeat.i(126864);
        AppMethodBeat.o(126864);
    }

    public SwitchAccountModel(String str, String str2, String str3, String str4, int i) {
        this.qjK = str;
        this.username = str2;
        this.mnu = str3;
        this.qjL = str4;
        this.qjM = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(126863);
        parcel.writeString(this.qjK);
        parcel.writeString(this.username);
        parcel.writeString(this.mnu);
        parcel.writeString(this.qjL);
        parcel.writeInt(this.qjM);
        AppMethodBeat.o(126863);
    }
}
