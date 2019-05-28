package com.tencent.mm.plugin.appbrand.game.cgipkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.d;
import com.tencent.mm.protocal.protobuf.ajh;

public class GameMenuParcel implements Parcelable {
    public static final Creator<GameMenuParcel> CREATOR = new Creator<GameMenuParcel>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameMenuParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(130059);
            GameMenuParcel gameMenuParcel = new GameMenuParcel(parcel, (byte) 0);
            AppMethodBeat.o(130059);
            return gameMenuParcel;
        }
    };
    public String appId;
    public ajh hqz;

    /* synthetic */ GameMenuParcel(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(130060);
        parcel.writeString(this.appId);
        c.a(this.hqz, parcel);
        AppMethodBeat.o(130060);
    }

    private GameMenuParcel(Parcel parcel) {
        AppMethodBeat.i(130061);
        this.appId = parcel.readString();
        this.hqz = (ajh) c.a(d.class.getName(), parcel);
        AppMethodBeat.o(130061);
    }

    static {
        AppMethodBeat.i(130062);
        AppMethodBeat.o(130062);
    }
}
