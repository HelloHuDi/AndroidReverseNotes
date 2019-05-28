package com.tencent.p177mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.setting.model.SwitchAccountModel */
public class SwitchAccountModel implements Parcelable {
    public static final Creator<SwitchAccountModel> CREATOR = new C217371();
    public final String mnu;
    public final String qjK;
    public final String qjL;
    public final int qjM;
    public final String username;

    /* renamed from: com.tencent.mm.plugin.setting.model.SwitchAccountModel$1 */
    static class C217371 implements Creator<SwitchAccountModel> {
        C217371() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SwitchAccountModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(126862);
            SwitchAccountModel switchAccountModel = new SwitchAccountModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
            AppMethodBeat.m2505o(126862);
            return switchAccountModel;
        }
    }

    static {
        AppMethodBeat.m2504i(126864);
        AppMethodBeat.m2505o(126864);
    }

    public SwitchAccountModel(String str, String str2, String str3, String str4, int i) {
        this.qjK = str;
        this.username = str2;
        this.mnu = str3;
        this.qjL = str4;
        this.qjM = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(126863);
        parcel.writeString(this.qjK);
        parcel.writeString(this.username);
        parcel.writeString(this.mnu);
        parcel.writeString(this.qjL);
        parcel.writeInt(this.qjM);
        AppMethodBeat.m2505o(126863);
    }
}
