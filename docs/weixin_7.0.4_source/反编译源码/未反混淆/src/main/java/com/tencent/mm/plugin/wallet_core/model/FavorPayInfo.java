package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public class FavorPayInfo implements Parcelable {
    public static final Creator<FavorPayInfo> CREATOR = new Creator<FavorPayInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavorPayInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46758);
            FavorPayInfo favorPayInfo = new FavorPayInfo(parcel);
            AppMethodBeat.o(46758);
            return favorPayInfo;
        }
    };
    public String tzb;
    public int tzc;
    public String tzd;
    public String tze;
    public String tzf;
    public List<String> tzg = new LinkedList();

    public FavorPayInfo() {
        AppMethodBeat.i(46759);
        AppMethodBeat.o(46759);
    }

    public FavorPayInfo(Parcel parcel) {
        AppMethodBeat.i(46760);
        this.tzb = parcel.readString();
        this.tzc = parcel.readInt();
        this.tzd = parcel.readString();
        this.tze = parcel.readString();
        this.tzf = parcel.readString();
        this.tzg = parcel.createStringArrayList();
        AppMethodBeat.o(46760);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46761);
        parcel.writeString(this.tzb);
        parcel.writeInt(this.tzc);
        parcel.writeString(this.tzd);
        parcel.writeString(this.tze);
        parcel.writeString(this.tzf);
        parcel.writeStringList(this.tzg);
        AppMethodBeat.o(46761);
    }

    public String toString() {
        AppMethodBeat.i(46762);
        StringBuffer stringBuffer = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[]{this.tzb, Integer.valueOf(this.tzc), this.tzd, this.tze, this.tzf}));
        if (this.tzg != null) {
            stringBuffer.append("bind_serial_list :");
            for (String str : this.tzg) {
                stringBuffer.append(str + ",");
            }
        }
        String str2 = stringBuffer.toString();
        AppMethodBeat.o(46762);
        return str2;
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(46763);
        AppMethodBeat.o(46763);
    }
}
