package com.tencent.p177mm.plugin.appbrand.game.cgipkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C18509c;
import com.tencent.p177mm.ipcinvoker.wx_extension.C45414d;
import com.tencent.p177mm.protocal.protobuf.ajh;

/* renamed from: com.tencent.mm.plugin.appbrand.game.cgipkg.GameMenuParcel */
public class GameMenuParcel implements Parcelable {
    public static final Creator<GameMenuParcel> CREATOR = new C331931();
    public String appId;
    public ajh hqz;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.cgipkg.GameMenuParcel$1 */
    static class C331931 implements Creator<GameMenuParcel> {
        C331931() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameMenuParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(130059);
            GameMenuParcel gameMenuParcel = new GameMenuParcel(parcel, (byte) 0);
            AppMethodBeat.m2505o(130059);
            return gameMenuParcel;
        }
    }

    /* synthetic */ GameMenuParcel(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(130060);
        parcel.writeString(this.appId);
        C18509c.m28814a(this.hqz, parcel);
        AppMethodBeat.m2505o(130060);
    }

    private GameMenuParcel(Parcel parcel) {
        AppMethodBeat.m2504i(130061);
        this.appId = parcel.readString();
        this.hqz = (ajh) C18509c.m28812a(C45414d.class.getName(), parcel);
        AppMethodBeat.m2505o(130061);
    }

    static {
        AppMethodBeat.m2504i(130062);
        AppMethodBeat.m2505o(130062);
    }
}
