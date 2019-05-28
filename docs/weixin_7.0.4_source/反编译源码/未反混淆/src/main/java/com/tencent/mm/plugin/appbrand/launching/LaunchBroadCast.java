package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class LaunchBroadCast implements Parcelable {
    public static final Creator<LaunchBroadCast> CREATOR = new Creator<LaunchBroadCast>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchBroadCast[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102105);
            LaunchBroadCast launchBroadCast = new LaunchBroadCast(parcel, (byte) 0);
            AppMethodBeat.o(102105);
            return launchBroadCast;
        }
    };
    public String appId;
    public int cDB;
    public boolean cQe;
    public int har;
    public String username;

    /* synthetic */ LaunchBroadCast(Parcel parcel, byte b) {
        this(parcel);
    }

    static void a(String str, int i, int i2, boolean z) {
        AppMethodBeat.i(102106);
        LaunchBroadCast launchBroadCast = new LaunchBroadCast();
        launchBroadCast.username = null;
        launchBroadCast.appId = str;
        launchBroadCast.har = i;
        launchBroadCast.cDB = i2;
        launchBroadCast.cQe = z;
        d.a(str, launchBroadCast);
        AppMethodBeat.o(102106);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102107);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.har);
        parcel.writeInt(this.cDB);
        parcel.writeByte(this.cQe ? (byte) 1 : (byte) 0);
        AppMethodBeat.o(102107);
    }

    private LaunchBroadCast() {
    }

    private LaunchBroadCast(Parcel parcel) {
        AppMethodBeat.i(102108);
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.har = parcel.readInt();
        this.cDB = parcel.readInt();
        this.cQe = parcel.readByte() != (byte) 0;
        AppMethodBeat.o(102108);
    }

    static {
        AppMethodBeat.i(102109);
        AppMethodBeat.o(102109);
    }
}
