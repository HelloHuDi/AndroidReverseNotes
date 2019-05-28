package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams */
public class GameSettingParams implements Parcelable {
    public static final Creator<GameSettingParams> CREATOR = new C146061();
    public String uDr;
    public String uDs;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams$1 */
    static class C146061 implements Creator<GameSettingParams> {
        C146061() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameSettingParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(8690);
            GameSettingParams gameSettingParams = new GameSettingParams(parcel, (byte) 0);
            AppMethodBeat.m2505o(8690);
            return gameSettingParams;
        }
    }

    /* synthetic */ GameSettingParams(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(8691);
        parcel.writeString(this.uDr);
        parcel.writeString(this.uDs);
        AppMethodBeat.m2505o(8691);
    }

    private GameSettingParams(Parcel parcel) {
        AppMethodBeat.m2504i(8692);
        this.uDr = parcel.readString();
        this.uDs = parcel.readString();
        AppMethodBeat.m2505o(8692);
    }

    static {
        AppMethodBeat.m2504i(8693);
        AppMethodBeat.m2505o(8693);
    }
}
