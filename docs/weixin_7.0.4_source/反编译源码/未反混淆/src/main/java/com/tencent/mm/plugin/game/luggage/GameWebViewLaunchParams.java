package com.tencent.mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameWebViewLaunchParams implements Parcelable {
    public static final Creator<GameWebViewLaunchParams> CREATOR = new Creator<GameWebViewLaunchParams>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameWebViewLaunchParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(135802);
            GameWebViewLaunchParams gameWebViewLaunchParams = new GameWebViewLaunchParams(parcel, (byte) 0);
            AppMethodBeat.o(135802);
            return gameWebViewLaunchParams;
        }
    };
    public GameFloatLayerInfo mTF;

    /* synthetic */ GameWebViewLaunchParams(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(135803);
        parcel.writeParcelable(this.mTF, i);
        AppMethodBeat.o(135803);
    }

    private GameWebViewLaunchParams(Parcel parcel) {
        AppMethodBeat.i(135804);
        this.mTF = (GameFloatLayerInfo) parcel.readParcelable(GameFloatLayerInfo.class.getClassLoader());
        AppMethodBeat.o(135804);
    }

    static {
        AppMethodBeat.i(135805);
        AppMethodBeat.o(135805);
    }
}
