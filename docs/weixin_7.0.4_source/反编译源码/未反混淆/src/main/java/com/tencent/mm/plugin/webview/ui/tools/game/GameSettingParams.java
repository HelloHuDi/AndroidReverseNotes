package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameSettingParams implements Parcelable {
    public static final Creator<GameSettingParams> CREATOR = new Creator<GameSettingParams>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameSettingParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8690);
            GameSettingParams gameSettingParams = new GameSettingParams(parcel, (byte) 0);
            AppMethodBeat.o(8690);
            return gameSettingParams;
        }
    };
    public String uDr;
    public String uDs;

    /* synthetic */ GameSettingParams(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(8691);
        parcel.writeString(this.uDr);
        parcel.writeString(this.uDs);
        AppMethodBeat.o(8691);
    }

    private GameSettingParams(Parcel parcel) {
        AppMethodBeat.i(8692);
        this.uDr = parcel.readString();
        this.uDs = parcel.readString();
        AppMethodBeat.o(8692);
    }

    static {
        AppMethodBeat.i(8693);
        AppMethodBeat.o(8693);
    }
}
