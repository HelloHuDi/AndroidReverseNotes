package com.tencent.p177mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams */
public class GameWebViewLaunchParams implements Parcelable {
    public static final Creator<GameWebViewLaunchParams> CREATOR = new C209681();
    public GameFloatLayerInfo mTF;

    /* renamed from: com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams$1 */
    static class C209681 implements Creator<GameWebViewLaunchParams> {
        C209681() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameWebViewLaunchParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(135802);
            GameWebViewLaunchParams gameWebViewLaunchParams = new GameWebViewLaunchParams(parcel, (byte) 0);
            AppMethodBeat.m2505o(135802);
            return gameWebViewLaunchParams;
        }
    }

    /* synthetic */ GameWebViewLaunchParams(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(135803);
        parcel.writeParcelable(this.mTF, i);
        AppMethodBeat.m2505o(135803);
    }

    private GameWebViewLaunchParams(Parcel parcel) {
        AppMethodBeat.m2504i(135804);
        this.mTF = (GameFloatLayerInfo) parcel.readParcelable(GameFloatLayerInfo.class.getClassLoader());
        AppMethodBeat.m2505o(135804);
    }

    static {
        AppMethodBeat.m2504i(135805);
        AppMethodBeat.m2505o(135805);
    }
}
