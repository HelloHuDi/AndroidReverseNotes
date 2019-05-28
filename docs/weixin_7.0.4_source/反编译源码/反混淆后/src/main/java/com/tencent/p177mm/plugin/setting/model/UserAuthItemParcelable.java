package com.tencent.p177mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.setting.model.UserAuthItemParcelable */
public class UserAuthItemParcelable implements Parcelable {
    public static final Creator<UserAuthItemParcelable> CREATOR = new C131881();
    public String qkh;
    public int qki;
    public String scope;
    public int state;

    /* renamed from: com.tencent.mm.plugin.setting.model.UserAuthItemParcelable$1 */
    static class C131881 implements Creator<UserAuthItemParcelable> {
        C131881() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UserAuthItemParcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(126880);
            UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
            userAuthItemParcelable.scope = parcel.readString();
            userAuthItemParcelable.qkh = parcel.readString();
            userAuthItemParcelable.state = parcel.readInt();
            userAuthItemParcelable.qki = parcel.readInt();
            AppMethodBeat.m2505o(126880);
            return userAuthItemParcelable;
        }
    }

    static {
        AppMethodBeat.m2504i(126882);
        AppMethodBeat.m2505o(126882);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(126881);
        parcel.writeString(this.scope);
        parcel.writeString(this.qkh);
        parcel.writeInt(this.state);
        parcel.writeInt(this.qki);
        AppMethodBeat.m2505o(126881);
    }
}
