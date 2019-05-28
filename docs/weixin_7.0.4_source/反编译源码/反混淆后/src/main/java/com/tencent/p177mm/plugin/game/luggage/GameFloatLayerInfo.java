package com.tencent.p177mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo */
public class GameFloatLayerInfo implements Parcelable {
    public static final Creator<GameFloatLayerInfo> CREATOR = new C121261();
    public boolean mTC;
    public int orientation;
    public String url;

    /* renamed from: com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo$1 */
    static class C121261 implements Creator<GameFloatLayerInfo> {
        C121261() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameFloatLayerInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(135794);
            GameFloatLayerInfo gameFloatLayerInfo = new GameFloatLayerInfo(parcel, (byte) 0);
            AppMethodBeat.m2505o(135794);
            return gameFloatLayerInfo;
        }
    }

    /* synthetic */ GameFloatLayerInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(135795);
        parcel.writeString(this.url);
        parcel.writeInt(this.mTC ? 1 : 0);
        parcel.writeInt(this.orientation);
        AppMethodBeat.m2505o(135795);
    }

    public GameFloatLayerInfo() {
        this.mTC = false;
        this.orientation = -1;
    }

    private GameFloatLayerInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.m2504i(135796);
        this.mTC = false;
        this.orientation = -1;
        this.url = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.mTC = z;
        this.orientation = parcel.readInt();
        AppMethodBeat.m2505o(135796);
    }

    static {
        AppMethodBeat.m2504i(135797);
        AppMethodBeat.m2505o(135797);
    }
}
