package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.Profession */
public class Profession implements Parcelable {
    public static final Creator<Profession> CREATOR = new C463631();
    public String tvN;
    public int tvO;

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.Profession$1 */
    static class C463631 implements Creator<Profession> {
        C463631() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Profession[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46654);
            Profession profession = new Profession(parcel);
            AppMethodBeat.m2505o(46654);
            return profession;
        }
    }

    public Profession(String str, int i) {
        this.tvN = str;
        this.tvO = i;
    }

    protected Profession(Parcel parcel) {
        AppMethodBeat.m2504i(46655);
        this.tvN = parcel.readString();
        this.tvO = parcel.readInt();
        AppMethodBeat.m2505o(46655);
    }

    static {
        AppMethodBeat.m2504i(46657);
        AppMethodBeat.m2505o(46657);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46656);
        parcel.writeString(this.tvN);
        parcel.writeInt(this.tvO);
        AppMethodBeat.m2505o(46656);
    }
}
