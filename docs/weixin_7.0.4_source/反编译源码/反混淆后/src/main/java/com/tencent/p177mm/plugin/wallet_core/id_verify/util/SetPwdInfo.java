package com.tencent.p177mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo */
public class SetPwdInfo implements Parcelable {
    public static final Creator<SetPwdInfo> CREATOR = new C225721();
    public String nZa;
    public String nZb = "";
    public String nZc = "";
    public int twa;

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo$1 */
    static class C225721 implements Creator<SetPwdInfo> {
        C225721() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetPwdInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46690);
            SetPwdInfo setPwdInfo = new SetPwdInfo(parcel);
            AppMethodBeat.m2505o(46690);
            return setPwdInfo;
        }
    }

    protected SetPwdInfo(Parcel parcel) {
        AppMethodBeat.m2504i(46691);
        this.twa = parcel.readInt();
        this.nZa = parcel.readString();
        this.nZb = parcel.readString();
        this.nZc = parcel.readString();
        AppMethodBeat.m2505o(46691);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46692);
        parcel.writeInt(this.twa);
        parcel.writeString(this.nZa);
        parcel.writeString(this.nZb);
        parcel.writeString(this.nZc);
        AppMethodBeat.m2505o(46692);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(46693);
        AppMethodBeat.m2505o(46693);
    }
}
