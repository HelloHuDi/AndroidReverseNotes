package com.tencent.p177mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.FavorPayInfo */
public class FavorPayInfo implements Parcelable {
    public static final Creator<FavorPayInfo> CREATOR = new C225751();
    public String tzb;
    public int tzc;
    public String tzd;
    public String tze;
    public String tzf;
    public List<String> tzg = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.FavorPayInfo$1 */
    static class C225751 implements Creator<FavorPayInfo> {
        C225751() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavorPayInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46758);
            FavorPayInfo favorPayInfo = new FavorPayInfo(parcel);
            AppMethodBeat.m2505o(46758);
            return favorPayInfo;
        }
    }

    public FavorPayInfo() {
        AppMethodBeat.m2504i(46759);
        AppMethodBeat.m2505o(46759);
    }

    public FavorPayInfo(Parcel parcel) {
        AppMethodBeat.m2504i(46760);
        this.tzb = parcel.readString();
        this.tzc = parcel.readInt();
        this.tzd = parcel.readString();
        this.tze = parcel.readString();
        this.tzf = parcel.readString();
        this.tzg = parcel.createStringArrayList();
        AppMethodBeat.m2505o(46760);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46761);
        parcel.writeString(this.tzb);
        parcel.writeInt(this.tzc);
        parcel.writeString(this.tzd);
        parcel.writeString(this.tze);
        parcel.writeString(this.tzf);
        parcel.writeStringList(this.tzg);
        AppMethodBeat.m2505o(46761);
    }

    public String toString() {
        AppMethodBeat.m2504i(46762);
        StringBuffer stringBuffer = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[]{this.tzb, Integer.valueOf(this.tzc), this.tzd, this.tze, this.tzf}));
        if (this.tzg != null) {
            stringBuffer.append("bind_serial_list :");
            for (String str : this.tzg) {
                stringBuffer.append(str + ",");
            }
        }
        String str2 = stringBuffer.toString();
        AppMethodBeat.m2505o(46762);
        return str2;
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(46763);
        AppMethodBeat.m2505o(46763);
    }
}
