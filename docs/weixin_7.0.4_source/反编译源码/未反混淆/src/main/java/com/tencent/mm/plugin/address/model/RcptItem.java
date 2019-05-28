package com.tencent.mm.plugin.address.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RcptItem implements Parcelable {
    public static final Creator<RcptItem> CREATOR = new Creator<RcptItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RcptItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(16756);
            RcptItem rcptItem = new RcptItem(parcel);
            AppMethodBeat.o(16756);
            return rcptItem;
        }
    };
    public String code = "";
    public String gIO = "";
    public boolean gIP = false;
    public String name = "";

    public RcptItem(String str, String str2, String str3) {
        this.name = str;
        this.code = str2;
        this.gIO = str3;
    }

    public int describeContents() {
        return 0;
    }

    public RcptItem(Parcel parcel) {
        AppMethodBeat.i(16757);
        this.name = parcel.readString();
        this.code = parcel.readString();
        this.gIO = parcel.readString();
        AppMethodBeat.o(16757);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(16758);
        parcel.writeString(this.name);
        parcel.writeString(this.code);
        parcel.writeString(this.gIO);
        AppMethodBeat.o(16758);
    }

    static {
        AppMethodBeat.i(16759);
        AppMethodBeat.o(16759);
    }
}
