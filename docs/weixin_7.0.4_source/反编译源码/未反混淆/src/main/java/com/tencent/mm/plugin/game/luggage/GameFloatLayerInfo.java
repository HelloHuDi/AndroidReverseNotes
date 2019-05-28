package com.tencent.mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameFloatLayerInfo implements Parcelable {
    public static final Creator<GameFloatLayerInfo> CREATOR = new Creator<GameFloatLayerInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameFloatLayerInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(135794);
            GameFloatLayerInfo gameFloatLayerInfo = new GameFloatLayerInfo(parcel, (byte) 0);
            AppMethodBeat.o(135794);
            return gameFloatLayerInfo;
        }
    };
    public boolean mTC;
    public int orientation;
    public String url;

    /* synthetic */ GameFloatLayerInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(135795);
        parcel.writeString(this.url);
        parcel.writeInt(this.mTC ? 1 : 0);
        parcel.writeInt(this.orientation);
        AppMethodBeat.o(135795);
    }

    public GameFloatLayerInfo() {
        this.mTC = false;
        this.orientation = -1;
    }

    private GameFloatLayerInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(135796);
        this.mTC = false;
        this.orientation = -1;
        this.url = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.mTC = z;
        this.orientation = parcel.readInt();
        AppMethodBeat.o(135796);
    }

    static {
        AppMethodBeat.i(135797);
        AppMethodBeat.o(135797);
    }
}
